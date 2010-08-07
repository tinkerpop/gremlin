tree grammar GremlinEvaluator;

options {
	tokenVocab=Gremlin;
	ASTLabelType=CommonTree;
}

@header {
    package com.tinkerpop.gremlin.compiler;

    import java.io.FileReader;
    
    import java.util.ArrayList;
    
    import java.util.Map;
    import java.util.HashMap;
    import java.util.Iterator;
    
    import java.util.regex.Pattern;
    import java.util.regex.Matcher;

    import java.util.Collections;

    import java.util.ServiceLoader;

    import com.tinkerpop.gremlin.GremlinScriptEngine;
    
    import com.tinkerpop.gremlin.compiler.Tokens;

    import com.tinkerpop.gremlin.compiler.context.*;

    import com.tinkerpop.gremlin.compiler.functions.Functions;
    
    // types
    import com.tinkerpop.gremlin.compiler.types.*;

    // operations
    import com.tinkerpop.gremlin.compiler.operations.Operation;
    import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;

    import com.tinkerpop.gremlin.compiler.statements.*;
    import com.tinkerpop.gremlin.compiler.operations.math.*;
    import com.tinkerpop.gremlin.compiler.operations.logic.*;
    import com.tinkerpop.gremlin.compiler.operations.util.*;

    import com.tinkerpop.gremlin.compiler.functions.Function;
    import com.tinkerpop.gremlin.compiler.functions.NativeFunction;

    // blueprints
    import com.tinkerpop.blueprints.pgm.Vertex;

    // pipes
    import com.tinkerpop.pipes.Pipe;
    import com.tinkerpop.pipes.Pipeline;

    import com.tinkerpop.pipes.SingleIterator;
    import com.tinkerpop.pipes.MultiIterator;
    
    import com.tinkerpop.pipes.pgm.PropertyPipe;
    import com.tinkerpop.pipes.filter.FilterPipe;
    import com.tinkerpop.pipes.filter.FutureFilterPipe;
    
    import com.tinkerpop.gremlin.compiler.pipes.GremlinPipesHelper;
}

@members {
    // debug mode
    public  static boolean DEBUG = false;
    public  static boolean EMBEDDED = false;

    private boolean isGPath = false;

    private Pattern rangePattern = Pattern.compile("^(\\d+)..(\\d+)");

    private GremlinScriptContext context = new GremlinScriptContext();

    public GremlinEvaluator(final TreeNodeStream input, final GremlinScriptContext context) {
        this(input, new RecognizerSharedState());
        this.context = context;
    }

    private Atom getVariable(String name) {
        return this.context.getVariableByName(name);
    }

    private Function getFunction(final String ns, final String functionName) {
        return this.context.getFunctionLibrary().getFunction(ns, functionName);
    }

    private void registerFunction(final String ns, final Function func) {
        this.context.getFunctionLibrary().registerFunction(ns, func);
    }
    
    private void formProgramResult(List<Object> resultList, Operation currentOperation) {
        Atom result  = currentOperation.compute();
        Object value = null;

        try {
            value = result.getValue();
        } catch(Exception e) {}

        if (EMBEDDED) resultList.add(value);
        
        if (value != null && DEBUG) {
            if (value instanceof Iterable) {
                for(Object o : (Iterable) value) {
                    this.context.writeOutput(Tokens.RESULT_PROMPT + o);
                }
            } else if (value instanceof Map) {
                Map map = (Map) value;
                if (map.isEmpty()) {
                    this.context.writeOutput(Tokens.RESULT_PROMPT + "{}");
                } else {
                    for (Object key : map.keySet()) {
                        this.context.writeOutput(Tokens.RESULT_PROMPT + key + "=" + map.get(key));
                    }
                }
            } else if(value instanceof Iterator) {
                Iterator itty = (Iterator) value;
                
                while(itty.hasNext()) {
                    this.context.writeOutput(Tokens.RESULT_PROMPT + itty.next());
                }
            } else {
                this.context.writeOutput(Tokens.RESULT_PROMPT + value);
            }
        }

        this.context.getVariableLibrary().setHistoryVariable(new Atom<Object>(value));
    }
}

program returns [Iterable results]
    @init {
        List<Object> resultList = new ArrayList<Object>();
    }
    : ((statement
     {
        formProgramResult(resultList, $statement.op);
     } | col=collection {
        formProgramResult(resultList, $col.op);
     } | ^(VAR VARIABLE c=collection) {
        formProgramResult(resultList, new DeclareVariable($VARIABLE.text, $c.op, this.context)); 
     }) NEWLINE*)+
     {
        $results = resultList;
     }
    ;

statement returns [Operation op]
	:	if_statement                        { $op = $if_statement.op; }
	|	foreach_statement                   { $op = $foreach_statement.op; }
    |	while_statement                     { $op = $while_statement.op; }
	|	repeat_statement                    { $op = $repeat_statement.op; }
	|	path_definition_statement           { $op = $path_definition_statement.op; }
	|	function_definition_statement       { $op = $function_definition_statement.op; }
	|	include_statement                   { $op = new UnaryOperation($include_statement.result); }
	|   script_statement                    { $op = new UnaryOperation($script_statement.result); }
	|	gpath_statement                     { $op = $gpath_statement.op; }
	|	^(VAR VARIABLE s=statement)         { $op = new DeclareVariable($VARIABLE.text, $s.op, this.context); }
    |   ^('and' a=statement b=statement)    { $op = new And($a.op, $b.op); }
    |   ^('or'  a=statement b=statement)    { $op = new Or($a.op, $b.op); }
    |   expression                          { $op = $expression.expr; }
	;

script_statement returns [Atom result]
    : ^(SCRIPT StringLiteral)
      {
            $result = new Atom<Boolean>(true);

            String filename = $StringLiteral.text;
            try {
                final GremlinScriptEngine engine = new GremlinScriptEngine();
                engine.eval(new FileReader(filename.substring(1, filename.length() - 1)), this.context);
            } catch(Exception e) {
                $result = new Atom<Boolean>(false);
            }
      }
    ;

include_statement returns [Atom result]
	:	^(INCLUDE StringLiteral)
        {
            $result = new Atom<Boolean>(true);

            String className = $StringLiteral.text;
            try {
                final Class toLoad = Class.forName(className);
                final ServiceLoader<Functions> functionsService = ServiceLoader.load(toLoad);

                for (final Functions functionsToLoad : functionsService) {
                    this.context.getFunctionLibrary().registerFunctions(functionsToLoad);
                }
            } catch(Exception e) {
                $result = new Atom<Boolean>(false);
                e.printStackTrace();
            }
        }
	;
	
path_definition_statement returns [Operation op]
    @init {
        List<Pipe> pipes = new ArrayList<Pipe>();
    }
	:	^(PATH path_name=IDENTIFIER (gpath=gpath_statement { pipes.addAll(((GPathOperation)$gpath.op).getPipes()); } | ^(PROPERTY_CALL pr=PROPERTY) { pipes.add(new PropertyPipe($pr.text.substring(1))); }))
        {
            this.context.getPathLibrary().registerPath($path_name.text, pipes);
            $op = new UnaryOperation(new Atom<Boolean>(true));
        }
	;
	

gpath_statement returns [Operation op]
    scope {
        int pipeCount;

        Atom<Object> root;
        List<Pipe> pipeList;
    }
    @init {
        isGPath = true;
        
        $gpath_statement::pipeCount = 0;
        $gpath_statement::root = null;
        $gpath_statement::pipeList = new ArrayList<Pipe>();
    }
    @after {
        isGPath = false;
    }
	:	^(GPATH (step)+) 
        {
            if ($gpath_statement::pipeList.size() > 0) {
                $op = new GPathOperation($gpath_statement::pipeList, $gpath_statement::root, this.context);
            } else {
                $op = new UnaryOperation(new Atom<Object>(null));
            }
        }
	;

step
    @init {
        List<Operation> predicates = new ArrayList<Operation>();
    }
    :	^(STEP ^(TOKEN token) ^(PREDICATES ( ^(PREDICATE statement { predicates.add($statement.op); }) )* ))
        {
            final Atom tokenAtom = $token.atom;
            final PathLibrary paths = this.context.getPathLibrary();

            if (tokenAtom != null) {
                if ($gpath_statement::pipeCount == 0) {

                    if (tokenAtom instanceof DynamicEntity) {
                        $gpath_statement::root = tokenAtom;    
                    } else if (paths.isPath(tokenAtom.toString())) {
                        $gpath_statement::pipeList.addAll(paths.getPath(tokenAtom.toString()));
                        $gpath_statement::root = this.getVariable(Tokens.ROOT_VARIABLE);
                    } else {
                        $gpath_statement::root = tokenAtom;
                    }
                
                    $gpath_statement::pipeList.addAll(GremlinPipesHelper.pipesForStep(predicates, this.context));
                } else {
                    $gpath_statement::pipeList.addAll(GremlinPipesHelper.pipesForStep(tokenAtom, predicates, this.context));
                }
            }
            
            $gpath_statement::pipeCount++;
        }
    ;

token returns [Atom atom]	
    : 	expression { $atom = $expression.expr.compute(); }
    |   gpath_statement { $atom = $gpath_statement.op.compute(); }
    |   collection { $atom = $collection.op.compute(); }
    |   '..'       {

                        List<Pipe> history = new ArrayList<Pipe>();
                        List<Pipe> newPipes = new ArrayList<Pipe>();
                        List<Pipe> pipes = $gpath_statement::pipeList;

                        if ((pipes.size() == 1 && (pipes.get(0) instanceof FutureFilterPipe)) || pipes.size() == 0) {
                            $gpath_statement::pipeList = new ArrayList();
                        } else {
                            int idx;
                            
                            for (idx = pipes.size() - 1; idx >= 0; idx--) {
                                Pipe currentPipe = pipes.get(idx);
                                history.add(currentPipe);

                                if (!(currentPipe instanceof FilterPipe)) break;
                            }

                            for (int i = 0; i < idx; i++) {
                                newPipes.add(pipes.get(i));
                            }

                            // don't like that - fix. PY
                            Collections.reverse(history);
                            newPipes.add(new FutureFilterPipe(new Pipeline(history)));
                        
                            $gpath_statement::pipeList = newPipes;
                        }
                        
                        $atom = null;
                   }
	;


if_statement returns [Operation op]
	:	^(IF ^(COND cond=statement) if_block=block ( ^(ELSE else_block=block ) )? )
        {
            $op = new If($cond.op, $if_block.operations, $else_block.operations);
        }
	;

while_statement returns [Operation op]
	:	^(WHILE ^(COND cond=statement) block)
        {
            $op = new While($cond.op, $block.operations);
        }
	;

foreach_statement returns [Operation op]
	:	^(FOREACH VARIABLE arr=statement block)
        {
            $op = new Foreach($VARIABLE.text, $arr.op, $block.operations, this.context);
        }
	;
	
repeat_statement returns [Operation op]
	:	^(REPEAT timer=statement block)
        {
            $op = new Repeat($timer.op, $block.operations);
        }
	;

block returns [List<Operation> operations]
    @init {
        List<Operation> operationList = new ArrayList<Operation>();
    }
    :	^(BLOCK ( (statement { operationList.add($statement.op); } | collection { operationList.add($collection.op); }))+) { $operations = operationList; }
	;

expression returns [Operation expr]
    :   ^('='  a=statement b=statement) { $expr = new Equality($a.op, $b.op); }
    |   ^('!=' a=statement b=statement) { $expr = new UnEquality($a.op, $b.op); }
    |   ^('<'  a=statement b=statement) { $expr = new LessThan($a.op, $b.op); }
    |   ^('>'  a=statement b=statement) { $expr = new GreaterThan($a.op, $b.op); }
    |   ^('<=' a=statement b=statement) { $expr = new LessThanOrEqual($a.op, $b.op); }
    |   ^('>=' a=statement b=statement) { $expr = new GreaterThanOrEqual($a.op, $b.op); }
    |   operation                       { $expr = $operation.op; }
	;

operation returns [Operation op]
    :   ^('+' a=operation b=operation) { $op = new Addition($a.op, $b.op); }
    |   ^('-' a=operation b=operation) { $op = new Subtraction($a.op, $b.op); }
    |   binary_operation               { $op = $binary_operation.operation; }
	;

binary_operation returns [Operation operation]
    :   ^('*' a=operation b=operation)      { $operation = new Multiplication($a.op, $b.op); }
    |   ^('div' a=operation b=operation)    { $operation = new Division($a.op, $b.op); }
    |	^('mod' a=operation b=operation)    { $operation = new Modulo($a.op, $b.op); }
    |   atom                                { $operation = new UnaryOperation($atom.value); }
	;

function_definition_statement returns [Operation op]
    @init {
        List<String> params = new ArrayList<String>();
    }
	:	^(FUNC ^(FUNC_NAME ^(NS ns=IDENTIFIER) ^(NAME fn_name=IDENTIFIER)) ^(ARGS ( ^(ARG VARIABLE { params.add($VARIABLE.text); }) )*) block)
        {
            NativeFunction fn = new NativeFunction($fn_name.text, params, $block.operations);
            this.registerFunction($ns.text, fn);

            $op = new UnaryOperation(new Atom<Boolean>(true));
        }
	;
	
function_call returns [Atom value]
    @init {
        List<Operation> params = new ArrayList<Operation>();
    }
	:	^(FUNC_CALL ^(FUNC_NAME ^(NS ns=IDENTIFIER) ^(NAME fn_name=IDENTIFIER)) ^(ARGS ( ^(ARG (st=statement { params.add($st.op); } | col=collection { params.add($col.op); }) ) )* ))
        {
            try {
                $value = new Func(this.getFunction($ns.text, $fn_name.text), params, this.context);
            } catch(Exception e) {
                System.err.println(e);
            }
        }
	;

collection returns [Operation op]
    @init {
        Atom<Object> root = null;
        List<Pipe> pipes = new ArrayList<Pipe>();
        List<Operation> predicates = new ArrayList<Operation>();
    }
    : ^(COLLECTION_CALL ^(STEP ^(TOKEN token) ^(PREDICATES ( ^(PREDICATE statement { predicates.add($statement.op); }) )+ )))
    {
        final Atom tokenAtom = $token.atom;
        final PathLibrary paths = this.context.getPathLibrary();

        if (tokenAtom != null) {
            if (tokenAtom instanceof DynamicEntity) {
                root = tokenAtom;
            } else if (paths.isPath(tokenAtom.toString())) {
                pipes.addAll(paths.getPath(tokenAtom.toString()));
                root = this.getVariable(Tokens.ROOT_VARIABLE);
            } else {
                root = tokenAtom;
            }

            pipes.addAll(GremlinPipesHelper.pipesForStep(predicates, this.context));
        }
        
        $op = new GPathOperation(pipes, root, this.context);
    }
    ;


atom returns [Atom value]
    @init {
        List<Double> array = new ArrayList<Double>();
    }
	:   ^(INT G_INT)                                                { $value = new Atom<Integer>(new Integer($G_INT.text)); }
	|   ^(LONG G_LONG)                                              {
	                                                                    String longStr = $G_LONG.text;
	                                                                    $value = new Atom<Long>(new Long(longStr.substring(0, longStr.length() - 1)));
	                                                                }
	|   ^(FLOAT G_FLOAT)                                            { $value = new Atom<Float>(new Float($G_FLOAT.text)); }
	|   ^(DOUBLE G_DOUBLE)                                          {
	                                                                    String doubleStr = $G_DOUBLE.text;
	                                                                    $value = new Atom<Double>(new Double(doubleStr.substring(0, doubleStr.length() - 1)));
	                                                                }
	|   ^(RANGE min=G_INT max=G_INT)                                { $value = new Atom(new Range($min.text, $max.text)); }
	|	^(STR StringLiteral)                                        { $value = new Atom($StringLiteral.text); }
    |   ^(BOOL b=BOOLEAN)                                           { $value = new Atom(new Boolean($b.text)); }
    |   NULL                                                        { $value = new Atom(null); }
    |   ^(ARR (NUMBER { array.add(new Double($NUMBER.text)); })+)   { $value = new Atom(array); }
	|	^(VARIABLE_CALL VARIABLE)                                   { 
                                                                      $value = this.getVariable($VARIABLE.text); 
                                                                    }
	|	^(PROPERTY_CALL PROPERTY)                                   { 
                                                                        Atom propertyAtom = new Atom($PROPERTY.text.substring(1));
                                                                        propertyAtom.setProperty(true);
                                                                        $value = propertyAtom;
                                                                    }
	|	IDENTIFIER                                                  {
	                                                                    String idText = $IDENTIFIER.text;
                                                                        
	                                                                    if (idText.equals(".") && !isGPath) {
	                                                                        Atom id  = this.getVariable(Tokens.ROOT_VARIABLE);
	                                                                        Atom dot = new Atom(id.getValue());
	                                                                        dot.setIdentifier(true);
	                                                                        $value = dot;
	                                                                    } else if (idText.matches("^[\\d]+..[\\d]+")) {
                                                                            Matcher range = rangePattern.matcher(idText);
                                                                            if (range.matches())
                                                                                $value = new Atom<Range>(new Range(range.group(1), range.group(2)));
                                                                            else
                                                                                $value = new Atom(null);
	                                                                    } else {
                                                                            Atom idAtom = new Atom<String>($IDENTIFIER.text);
                                                                            idAtom.setIdentifier(true);
                                                                            $value = idAtom;
                                                                        }
                                                                    }
	|	function_call                                               { $value = $function_call.value; }
	|	'('! statement ')'!
	;


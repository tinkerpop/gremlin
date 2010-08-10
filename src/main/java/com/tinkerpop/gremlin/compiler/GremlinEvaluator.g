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
    import java.util.LinkedHashMap;
    
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
    private int gpathScope = 0;

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
    
    private Atom compileCollectionCall(final Atom<Object> tokenAtom, final List<Operation> predicates) {
        final List<Pipe> pipes  = new ArrayList<Pipe>();
        final Atom<Object> root = makePipelineRoot(tokenAtom, pipes);

        pipes.addAll(GremlinPipesHelper.pipesForStep(predicates, this.context));

        return new GPath(root, pipes, this.context);
    }

    private Atom compileGPathCall(final Map<Atom<Object>, List<Operation>> steps) {
        Atom<Object> root = null;
        List<Pipe> pipes = new ArrayList<Pipe>();

        long count = 0;
        for (final Atom<Object> token : steps.keySet()) {
            final List<Operation> predicates = steps.get(token);
            
            if (count == 0) {
                root = makePipelineRoot(token, pipes);
                pipes.addAll(GremlinPipesHelper.pipesForStep(predicates, this.context));
            } else if (token.isIdentifier() && token.getValue().equals("..")) {
                List<Pipe> history = new ArrayList<Pipe>();
                List<Pipe> newPipes = new ArrayList<Pipe>();
                List<Pipe> currPipes = pipes;

                if ((currPipes.size() == 1 && (currPipes.get(0) instanceof FutureFilterPipe)) || currPipes.size() == 0) {
                    pipes = new ArrayList();
                } else {
                    int idx;
                            
                    for (idx = currPipes.size() - 1; idx >= 0; idx--) {
                        Pipe currentPipe = currPipes.get(idx);
                        history.add(currentPipe);

                        if (!(currentPipe instanceof FilterPipe)) break;
                    }

                    for (int i = 0; i < idx; i++) {
                        newPipes.add(currPipes.get(i));
                    }

                    Collections.reverse(history);
                    newPipes.add(new FutureFilterPipe(new Pipeline(history)));
                        
                    pipes = newPipes;
                }
                
                pipes.addAll(GremlinPipesHelper.pipesForStep(predicates, this.context));
            } else {
                pipes.addAll(GremlinPipesHelper.pipesForStep(token, predicates, this.context));
            }

            count++;
        }
        
        return (pipes.size() == 0) ? new Atom<Object>(null) : new GPath(root, pipes, this.context);
    }

    private Atom<Object> makePipelineRoot(final Atom<Object> token, final List<Pipe> pipes) {
        final PathLibrary paths = this.context.getPathLibrary();

        if (token instanceof DynamicEntity) {
            return token;
        } else if (paths.isPath(token.toString())) {
            pipes.addAll(paths.getPath(token.toString()));
            return this.getVariable(Tokens.ROOT_VARIABLE);
        } else {
            return token;
        }
    }

    private Atom<Object> singleGPathStep(final Atom<Object> token) {
        final PathLibrary paths = this.context.getPathLibrary();

        if (token instanceof DynamicEntity) {
            return token;
        } else if (token.isIdentifier() && token.getValue().equals(".")) {
            return (gpathScope > 1) ? new Id<String>(".") : this.getVariable(Tokens.ROOT_VARIABLE);
        } else if(paths.isPath(token.toString())) {
            return new GPath(this.getVariable(Tokens.ROOT_VARIABLE), paths.getPath(token.toString()), this.context);
        } else {
            return token;
        }
    }

    private void formProgramResult(List<Object> resultList, Operation currentOperation) {
        Atom result  = currentOperation.compute();
        Object value = null;

        try {
            value = result.getValue();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        if (EMBEDDED && (currentOperation.getType() != Operation.Type.CONTROL_STATEMENT)) 
            resultList.add(value);

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
    : (statement { formProgramResult(resultList, $statement.op); } NEWLINE*)+
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
	:	^(PATH path_name=IDENTIFIER (gpath=gpath_statement { pipes.addAll(((GPath) $gpath.value).getPipes()); } | ^(PROPERTY_CALL pr=PROPERTY) { pipes.add(new PropertyPipe($pr.text.substring(1))); }))
        {
            this.context.getPathLibrary().registerPath($path_name.text, pipes);
            $op = new UnaryOperation(new Atom<Boolean>(true));
        }
	;
	

gpath_statement returns [Atom value]
    scope {
        int pipeCount;
        Map<Atom<Object>, List<Operation>> steps;
    }
    @init {
        isGPath = true;
        gpathScope++;
        $gpath_statement::steps = new LinkedHashMap<Atom<Object>, List<Operation>>();
    }
    @after {
        isGPath = false;
        gpathScope--;
    }
	:	^(GPATH (step)+) 
        {
            Map<Atom<Object>, List<Operation>> stepMap = $gpath_statement::steps;

            if (stepMap.size() == 1) {
                Atom<Object> token = stepMap.keySet().iterator().next();
                List<Operation> predicates = stepMap.get(token);
                $value = (predicates.size() == 0) ? singleGPathStep(token) : compileCollectionCall(token, predicates);
            } else {
                $value = compileGPathCall(stepMap);
            }
        }
	;

step
    @init {
        List<Operation> predicates = new ArrayList<Operation>();
    }
    :	^(STEP ^(TOKEN token) ^(PREDICATES ( ^(PREDICATE statement { predicates.add($statement.op); }) )* ))
        {
            $gpath_statement::steps.put($token.atom, predicates);
        }
    ;

token returns [Atom atom]
    :   function_call               { $atom = $function_call.value; }
    |   ^(STR StringLiteral)        { $atom = new Atom<String>($StringLiteral.text); }
	|	^(VARIABLE_CALL VARIABLE)   { $atom = new Var($VARIABLE.text, this.context); }
	|	^(PROPERTY_CALL PROPERTY)   { $atom = new Prop<String>($PROPERTY.text.substring(1)); }
    |	IDENTIFIER                                                  
        {
            String idText = $IDENTIFIER.text;
                                                                        
	        if (idText.matches("^[\\d]+..[\\d]+")) {
                    Matcher range = rangePattern.matcher(idText);
                    $atom = (range.matches()) ? new Atom<Range>(new Range(range.group(1), range.group(2))) : new Atom<Object>(null);
	        } else {
                    $atom = new Id<String>($IDENTIFIER.text);
            }
        }
	|   '..' { $atom = new Id<String>(".."); }
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
    :	^(BLOCK ( statement { operationList.add($statement.op); } )+) { $operations = operationList; }
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
    :   ^('+' a=statement b=statement) { $op = new Addition($a.op, $b.op); }
    |   ^('-' a=statement b=statement) { $op = new Subtraction($a.op, $b.op); }
    |   binary_operation               { $op = $binary_operation.operation; }
	;

binary_operation returns [Operation operation]
    :   ^('*'   a=statement b=statement)  { $operation = new Multiplication($a.op, $b.op); }
    |   ^('div' a=statement b=statement)  { $operation = new Division($a.op, $b.op); }
    |	^('mod' a=statement b=statement)  { $operation = new Modulo($a.op, $b.op); }
    |   atom                              { $operation = new UnaryOperation($atom.value); }
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
	:	^(FUNC_CALL ^(FUNC_NAME ^(NS ns=IDENTIFIER) ^(NAME fn_name=IDENTIFIER)) ^(ARGS ( ^(ARG st=statement { params.add($st.op); }) )* ))
        {
            try {
                $value = new Func(this.getFunction($ns.text, $fn_name.text), params, this.context);
            } catch(Exception e) {
                this.context.writeError(e.getMessage());
            }
        }
	;

atom returns [Atom value]
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
	|   ^(RANGE min=G_INT max=G_INT)                                { $value = new Atom<Range>(new Range($min.text, $max.text)); }
    |   gpath_statement                                             { $value = $gpath_statement.value; }
    |   ^(BOOL b=BOOLEAN)                                           { $value = new Atom<Boolean>(new Boolean($b.text)); }
    |   NULL                                                        { $value = new Atom<Object>(null); }
	|	'('! statement ')'!
	;


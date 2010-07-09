tree grammar GremlinEvaluator;

options {
	tokenVocab=Gremlin;
	ASTLabelType=CommonTree;
}

@header {
    package com.tinkerpop.gremlin.compiler;

    import java.util.ArrayList;
    
    import java.util.Map;
    import java.util.HashMap;
    
    import java.util.regex.Pattern;
    import java.util.regex.Matcher;

    import java.util.Collections;
    
    import com.tinkerpop.gremlin.Gremlin;

    import com.tinkerpop.gremlin.compiler.Tokens;
    import com.tinkerpop.gremlin.compiler.Atom;
    import com.tinkerpop.gremlin.compiler.VariableLibrary;
    import com.tinkerpop.gremlin.compiler.FunctionLibrary;
    import com.tinkerpop.gremlin.compiler.PathLibrary;

    // types
    import com.tinkerpop.gremlin.compiler.types.Range;

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
    
    private static VariableLibrary variables = new VariableLibrary();
    public  static FunctionLibrary functions = new FunctionLibrary();
    public  static PathLibrary     paths     = new PathLibrary();

    public static void declareVariable(String name, Atom value) {
        variables.declare(name, value);
    }

    public static Atom getVariable(String name) {
        return variables.get(name);
    }

    public static void freeVariable(String name) {
        variables.free(name);
    }

    public static VariableLibrary getVariableLibrary() {
        return variables;
    }

    public static void setVariableLibrary(VariableLibrary lib) {
        variables = lib;
    }

    private static void formProgramResult(List<Object> resultList, Operation currentOperation) {
        Atom result = currentOperation.compute();

        if (EMBEDDED) resultList.add(result.getValue());
        
        if (!result.isNull() && DEBUG) {
            if (result.isIterable()) {
                for(Object o : (Iterable)result.getValue()) {
                    System.out.println(Tokens.RESULT_PROMPT + o);
                }
            } else if (result.isMap()) {
                Map map = (Map) result.getValue();

                for (Object key : map.keySet()) {
                    System.out.println(Tokens.RESULT_PROMPT + key + "=" + map.get(key));
                }
            } else {
                System.out.println(Tokens.RESULT_PROMPT + result);
            }
        }

        if (!(currentOperation instanceof DeclareVariable)) {
            declareVariable(Tokens.LAST_VARIABLE, result);
        }
        
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
        formProgramResult(resultList, new DeclareVariable($VARIABLE.text, $c.op)); 
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
	|	gpath_statement                     { $op = $gpath_statement.op; }
	|	^(VAR VARIABLE s=statement)         { $op = new DeclareVariable($VARIABLE.text, $s.op); }
    |   ^('and' a=statement b=statement)    { $op = new And($a.op, $b.op); }
    |   ^('or'  a=statement b=statement)    { $op = new Or($a.op, $b.op); }
    |   expression                          { $op = $expression.expr; }
	;

include_statement returns [Atom result]
	:	^(INCLUDE StringLiteral)
        {
            $result = new Atom(true);

            String filename = $StringLiteral.text;
            try {
                ANTLRFileStream file = new ANTLRFileStream(filename.substring(1, filename.length() - 1));
                Gremlin.evaluate(file);
            } catch(Exception e) {
                $result = new Atom(false);
            }
        }
	;
	
path_definition_statement returns [Operation op]
    @init {
        List<Pipe> pipes = new ArrayList<Pipe>();
    }
	:	^(PATH path_name=IDENTIFIER (gpath=gpath_statement { pipes.addAll(((GPathOperation)$gpath.op).getPipes()); } | ^(PROPERTY_CALL pr=PROPERTY) { pipes.add(new PropertyPipe($pr.text.substring(1))); }))
        {
            paths.registerPath($path_name.text, pipes);
            $op = new UnaryOperation(new Atom(null));
        }
	;
	

gpath_statement returns [Operation op]
    scope {
        int pipeCount;

        Object startPoint;
        List<Pipe> pipeList;
    }
    @init {
        isGPath = true;
        
        $gpath_statement::pipeCount = 0;
        $gpath_statement::startPoint = null;
        $gpath_statement::pipeList = new ArrayList<Pipe>();
    }
    @after {
        isGPath = false;
    }
	:	^(GPATH (step)+) 
        {
            if ($gpath_statement::pipeList.size() > 0) {
                $op = new GPathOperation($gpath_statement::pipeList, $gpath_statement::startPoint);
            } else {
                $op = new UnaryOperation(new Atom(null));
            }
        }
	;

step
    @init {
        List<Operation> predicates = new ArrayList<Operation>();
    }
    :	^(STEP ^(TOKEN token) ^(PREDICATES ( ^(PREDICATE statement { predicates.add($statement.op); }) )* ))
        {
            Atom tokenAtom = $token.atom;
            
            if (tokenAtom != null) {
                if ($gpath_statement::pipeCount == 0) {
                    if (tokenAtom.isIdentifier() && ((String)tokenAtom.getValue()).equals(".")) {
                        $gpath_statement::startPoint = GremlinEvaluator.getVariable(Tokens.ROOT_VARIABLE).getValue();
                    } else if (paths.isPath(tokenAtom.getValue().toString())) {
                        $gpath_statement::pipeList.addAll(paths.getPath((String)tokenAtom.getValue()));
                        $gpath_statement::startPoint = GremlinEvaluator.getVariable(Tokens.ROOT_VARIABLE).getValue();
                    } else {
                        $gpath_statement::startPoint = tokenAtom.getValue();
                    }
                } else {
                    $gpath_statement::pipeList.addAll(GremlinPipesHelper.pipesForStep($token.atom, predicates));
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
	:	^(IF ^(COND cond=statement) block) 
        {
            $op = new If($cond.op, $block.operations);
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
            $op = new Foreach($VARIABLE.text, $arr.op, $block.operations);
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
    :	^(BLOCK (statement { operationList.add($statement.op); })+) { $operations = operationList; }
	;

expression returns [Operation expr]
    :   ^('='  a=operation b=operation) { $expr = new Equality($a.op, $b.op); }
    |   ^('!=' a=operation b=operation) { $expr = new UnEquality($a.op, $b.op); }
    |   ^('<'  a=operation b=operation) { $expr = new LessThan($a.op, $b.op); }
    |   ^('>'  a=operation b=operation) { $expr = new GreaterThan($a.op, $b.op); }
    |   ^('<=' a=operation b=operation) { $expr = new LessThanOrEqual($a.op, $b.op); }
    |   ^('>=' a=operation b=operation) { $expr = new GreaterThanOrEqual($a.op, $b.op); }
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
    |   atom                                { $operation = new UnaryOperation($atom.value); }
	;

function_definition_statement returns [Operation op]
    @init {
        List<String> params = new ArrayList<String>();
    }
	:	^(FUNC ^(FUNC_NAME ^(NS ns=IDENTIFIER) ^(NAME fn_name=IDENTIFIER)) ^(ARGS ( ^(ARG VARIABLE { params.add($VARIABLE.text); }) )*) block)
        {
            NativeFunction fn = new NativeFunction($fn_name.text, params, $block.operations);
            functions.registerFunction($ns.text, fn);

            $op = new UnaryOperation(new Atom(null));
        }
	;
	
function_call returns [Atom value]
    @init {
        List<Operation> params = new ArrayList<Operation>();
    }
	:	^(FUNC_CALL ^(FUNC_NAME ^(NS ns=IDENTIFIER) ^(NAME fn_name=IDENTIFIER)) ^(ARGS ( ^(ARG st=statement { params.add($st.op); }) )* ))
        {
            try {
                $value = functions.runFunction($ns.text, $fn_name.text, params);
            } catch(Exception e) {
                System.err.println(e);
            }
        }
	;

collection returns [Operation op]
    @init {
        Object startPoint = null;
        List<Pipe> pipes = new ArrayList<Pipe>();
        List<Operation> predicates = new ArrayList<Operation>();
    }
    : ^(COLLECTION_CALL ^(STEP ^(TOKEN token) ^(PREDICATES ( ^(PREDICATE statement { predicates.add($statement.op); }) )+ )))
    {
        Atom tokenAtom = $token.atom;

        if (tokenAtom.isIdentifier() && ((String)tokenAtom.getValue()).equals(".")) {
            startPoint = GremlinEvaluator.getVariable(Tokens.ROOT_VARIABLE).getValue();
        } else if (paths.isPath(tokenAtom.getValue().toString())) {
            pipes.addAll(paths.getPath((String)tokenAtom.getValue()));
            startPoint = GremlinEvaluator.getVariable(Tokens.ROOT_VARIABLE).getValue();
        } else {
            startPoint = tokenAtom.getValue();
        }

        pipes.addAll(GremlinPipesHelper.pipesForStep(predicates));

        $op = new GPathOperation(pipes, startPoint);
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
                                                                      $value = getVariable($VARIABLE.text); 
                                                                    }
	|	^(PROPERTY_CALL PROPERTY)                                   { 
                                                                        Atom propertyAtom = new Atom($PROPERTY.text.substring(1));
                                                                        propertyAtom.setProperty(true);
                                                                        $value = propertyAtom;
                                                                    }
	|	IDENTIFIER                                                  {
	                                                                    String idText = $IDENTIFIER.text;
                                                                        
	                                                                    if (idText.equals(".") && !isGPath) {
	                                                                        $value = getVariable(Tokens.ROOT_VARIABLE);
	                                                                    } else if (idText.matches("^[\\d]+..[\\d]+")) {
                                                                            Matcher range = rangePattern.matcher(idText);
                                                                            if (range.matches())
                                                                                $value = new Atom(new Range(range.group(1), range.group(2)));
                                                                            else
                                                                                $value = new Atom(null);
	                                                                    } else {
                                                                            Atom idAtom = new Atom($IDENTIFIER.text);
                                                                            idAtom.setIdentifier(true);
                                                                            $value = idAtom;
                                                                        }
                                                                    }
	|	function_call                                               { $value = $function_call.value; }
	|	'('! statement ')'!
	;


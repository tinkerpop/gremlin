tree grammar GremlinEvaluator;

options {
    output=AST;
	tokenVocab=Gremlin;
	ASTLabelType=CommonTree;
}

@header {
    package com.tinkerpop.gremlin.compiler;

    import java.io.FileReader;
    import java.io.FileNotFoundException;

    import java.util.ArrayList;
    import java.util.LinkedList;

    import java.util.Set;
    import java.util.LinkedHashSet;
   
    import java.util.Map;
    import java.util.HashMap;
    import java.util.Iterator;
    import java.util.Arrays;

    import java.util.regex.Pattern;
    import java.util.regex.Matcher;

    import java.util.Collections;

    import java.util.ServiceLoader;

    import com.tinkerpop.gremlin.GremlinScriptEngine;
    
    import com.tinkerpop.gremlin.compiler.util.Tokens;

    import com.tinkerpop.gremlin.compiler.context.*;

    import com.tinkerpop.gremlin.functions.Functions;
    
    // types
    import com.tinkerpop.gremlin.compiler.types.*;

    // operations
    import com.tinkerpop.gremlin.compiler.operations.Operation;
    import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;

    import com.tinkerpop.gremlin.compiler.statements.*;
    import com.tinkerpop.gremlin.compiler.operations.math.*;
    import com.tinkerpop.gremlin.compiler.operations.logic.*;
    import com.tinkerpop.gremlin.compiler.operations.util.*;

    import com.tinkerpop.gremlin.functions.Function;
    import com.tinkerpop.gremlin.functions.NativeFunction;

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
    import com.tinkerpop.pipes.util.EndSupportPipe;

    import com.tinkerpop.gremlin.compiler.pipes.GremlinPipesHelper;

    // util
    import com.tinkerpop.gremlin.compiler.util.Pair;
    import com.tinkerpop.gremlin.compiler.util.CodeBlock;

    import javax.script.ScriptContext;

    // steps
    import com.tinkerpop.gremlin.steps.Step;
    import com.tinkerpop.gremlin.steps.NativePipe;
}

@members {
    // debug mode
    public static boolean DEBUG = false;

    // script mode - for ScriptExecutor
    public static boolean SCRIPT_MODE = false;

    private boolean isGPath = false;
    private boolean inBlock = false;

    private int gpathScope = 0;

    private Pattern rangePattern = Pattern.compile("^(\\d+)..(\\d+)");

    private GremlinScriptContext context = new GremlinScriptContext();

    public GremlinEvaluator(final TreeNodeStream input, final GremlinScriptContext context) {
        this(input, new RecognizerSharedState());
        this.context = context;
    }

    private Atom getVariable(final String name) {
        return new Atom(context.getBindings(ScriptContext.ENGINE_SCOPE).get(name));
    }

    private Object getVariableValue(final String name) {
        return context.getBindings(ScriptContext.ENGINE_SCOPE).get(name);
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

    private Atom compileGPathCall(final List<Pair<Atom<Object>, List<Operation>>> steps) {
        Atom<Object> root = null;
        List<Pipe> pipes = new ArrayList<Pipe>();

        long count = 0;
        for (final Pair<Atom<Object>, List<Operation>> pair : steps) {
            final Atom<Object> token = pair.getA();
            final List<Operation> predicates = pair.getB();
            
            if (count == 0) {
                root = makePipelineRoot(token, pipes);
                pipes.addAll(GremlinPipesHelper.pipesForStep(predicates, this.context));
            } else if (token.isIdentifier() && token.getValue().equals("..")) {
                List<Pipe> currPipes = pipes;
                List<Pipe> newPipes = new ArrayList<Pipe>();
                LinkedList<Pipe> history = new LinkedList<Pipe>();

                if ((currPipes.size() == 1 && (currPipes.get(0) instanceof FutureFilterPipe)) || currPipes.size() == 0) {
                    pipes = new ArrayList();
                } else {
                    int idx;
                            
                    for (idx = currPipes.size() - 1; idx >= 0; idx--) {
                        Pipe currentPipe = currPipes.get(idx);
                        history.addFirst(currentPipe);

                        if (!(currentPipe instanceof FilterPipe)) break;
                    }

                    for (int i = 0; i < idx; i++) {
                        newPipes.add(currPipes.get(i));
                    }

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
        final StepLibrary steps = this.context.getStepLibrary();

        if (token instanceof DynamicEntity) {
            return token;
        } else if (token.isIdentifier()) {
            Step currentStep = steps.getStep(token.toString());

            if(null != currentStep) {
            	pipes.add(currentStep.createPipe());	
            }

            return (this.getVariableValue(Tokens.IN_BLOCK) == null) ? this.getVariable(Tokens.ROOT_VARIABLE) : new Atom<Object>(this.context.getCurrentPoint());
        } else {
            return token;
        }
    }

    private Atom<Object> singleGPathStep(final Atom<Object> token) {
        final StepLibrary steps = this.context.getStepLibrary();

        if (token instanceof DynamicEntity) {
            if (gpathScope == 1 && token instanceof Func) {
                Func function = (Func) token;
                Object root = this.getVariable(Tokens.ROOT_VARIABLE).getValue();
                List<Operation> arguments = GremlinPipesHelper.updateArguments(function.getArguments(), root);
                return new Func(function.getFunction(), arguments, this.context);
            }
            return token;
        } else if (token.isProperty()) {
            return (gpathScope == 1) ? new Atom<Object>(null) : token;
        } else if (token.isIdentifier()) {
            String identifier = (String) token.getValue();
            if (identifier.equals(Tokens.IDENTITY)) {
                if (this.getVariableValue(Tokens.IN_BLOCK) == null) {
                    return (gpathScope > 1) ? new Var(Tokens.ROOT_VARIABLE, this.context) : new RootVar(this.context);
                } else {
                    return new Atom<Object>(this.context.getCurrentPoint());
                }
            } else {
            	final Step currentStep = steps.getStep(token.toString());
                if(null != currentStep) {
                	final List<Pipe> pipes = Arrays.asList(currentStep.createPipe());
                	return new GPath(this.getVariable(Tokens.ROOT_VARIABLE), pipes, this.context);
                } 
             }
             return new Atom<Object>(null);  
        }

        return token;
    }

    private Set createRange(final String min, final String max) throws RuntimeException {
        final int minimum = new Integer(min);
        final int maximum = new Integer(max);
        
        final Set<Integer> range = new LinkedHashSet<Integer>();

        for (int i = minimum; i < maximum; i++) {
            range.add(i);
        }

        return range;
    }

    private void formProgramResult(List<Object> resultList, Operation currentOperation) {
        Atom result  = currentOperation.compute();
        Object value = null;

        try {
            value = result.getValue();
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        if (currentOperation.getType() != Operation.Type.CONTROL_STATEMENT) 
            resultList.add(value);

        if (value != null && DEBUG) {
            if (value instanceof Iterable) {
                for(Object o : (Iterable) value) {
                    this.context.writeOutput(Tokens.RESULT_PROMPT + o + "\n");
                }
            } else if (value instanceof Map) {
                Map map = (Map) value;
                if (map.isEmpty()) {
                    this.context.writeOutput(Tokens.RESULT_PROMPT + "{}\n");
                } else {
                    for (Object key : map.keySet()) {
                        this.context.writeOutput(Tokens.RESULT_PROMPT + key + "=" + map.get(key) + "\n");
                    }
                }
            } else if(value instanceof Iterator) {
                Iterator itty = (Iterator) value;
                
                while(itty.hasNext()) {
                    this.context.writeOutput(Tokens.RESULT_PROMPT + itty.next() + "\n");
                }
            } else {
                this.context.writeOutput(Tokens.RESULT_PROMPT + value + "\n");
            }
        } else if (SCRIPT_MODE) {
           if (value instanceof Iterable) {
               for(Object o : (Iterable) value) {}
           } else if(value instanceof Iterator) {
                Iterator itty = (Iterator) value;
                while(itty.hasNext()) itty.next();
            } 
        }

        this.context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.LAST_VARIABLE, new Atom<Object>(value));
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
	|	native_step_definition_statement    { $op = $native_step_definition_statement.op; }
	|	function_definition_statement       { $op = $function_definition_statement.op; }
	|	include_statement                   { $op = new UnaryOperation($include_statement.result); }
	|   script_statement                    { $op = new UnaryOperation($script_statement.result); }
	|	^(VAR atom s=statement)             { $op = new DeclareVariable($atom.value, $s.op, this.context); }
    |   ^('and' a=statement b=statement)    { $op = new And($a.op, $b.op); }
    |   ^('or'  a=statement b=statement)    { $op = new Or($a.op, $b.op); }
    |   expression                          { $op = $expression.expr; }
	;

script_statement returns [Atom result]
    : ^(SCRIPT StringLiteral)
      {
            $result = new Atom<Boolean>(true);

            String filename = $StringLiteral.text;
            filename = filename.substring(1, filename.length() - 1);

            try {
                final GremlinScriptEngine engine = new GremlinScriptEngine();
                engine.eval(new FileReader(filename), this.context);
            } catch(FileNotFoundException e) {
                this.context.writeError("File '" + filename + "' does not exist");
                this.context.flushErrorStream();

                $result = new Atom<Boolean>(false);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
      }
    ;

include_statement returns [Atom result]
	:	^(INCLUDE StringLiteral)
        {
            $result = new Atom<Boolean>(true);

            String className = $StringLiteral.text;
            try {
                this.context.loadLibrary(className);
            } catch(Exception e) {
                this.context.writeError("Library '" + className + "' does not exist");
                this.context.flushErrorStream();

                $result = new Atom<Boolean>(false);
            }
        }
	;
	
native_step_definition_statement returns [Operation op]
    @init {
        List<Pipe> pipes = new ArrayList<Pipe>();
    }
	: ^(NATIVE_STEP name=IDENTIFIER block) 
      {
          Step nativeStep = new Step($name.text, NativePipe.class, new Object[]{ $block.cb });
          this.context.getStepLibrary().registerStep(nativeStep);
          $op = new UnaryOperation(new Atom<Boolean>(true));
      } 	
	;
	

gpath_statement returns [Atom value]
    scope {
        int pipeCount;
        List<Pair<Atom<Object>, List<Operation>>> steps;
    }
    @init {
        isGPath = true;
        gpathScope++;
        $gpath_statement::steps = new LinkedList<Pair<Atom<Object>, List<Operation>>>();
    }
    @after {
        isGPath = false;
        gpathScope--;
    }
	:	^(GPATH (step)+) 
        {
            if (!inBlock) {
                List<Pair<Atom<Object>, List<Operation>>> stepList = $gpath_statement::steps;

                if (stepList.size() == 1) {
                    Pair<Atom<Object>, List<Operation>> currentPair = stepList.get(0);
                
                    Atom<Object> token = currentPair.getA();
                    List<Operation> predicates = currentPair.getB();
                    $value = (predicates.size() == 0) ? singleGPathStep(token) : compileCollectionCall(token, predicates);
                } else {
                    $value = compileGPathCall(stepList);
                }
            }
        }
	;

step
    @init {
        List<Operation> predicates = new ArrayList<Operation>();
    }
    :	^(STEP ^(TOKEN token) ^(PREDICATES ( ^(PREDICATE statement { predicates.add($statement.op); }) )* ) ^(LOOPS ( inline_loop_definition )* ))
        {
            $gpath_statement::steps.add(new Pair($token.atom, predicates));
        }
    ;

inline_loop_definition returns [Pipe pipe]
    : ^(REPEAT times=statement block) { }
    | ^(WHILE ^(COND condition=statement) block) { }
    | ^(FOREACH VARIABLE iterable=statement block) { }
    ;

token returns [Atom atom]
    :   function_call               { $atom = $function_call.value; }
    |   ^(STR StringLiteral)        { $atom = new Atom<String>($StringLiteral.text); }
	|	^(VARIABLE_CALL VARIABLE)   { $atom = $VARIABLE.text.equals(Tokens.ROOT_VARIABLE) ? new RootVar(context) : new Var($VARIABLE.text, this.context); }
	|	^(PROPERTY_CALL PROPERTY)   { $atom = new Prop<String>($PROPERTY.text.substring(1)); }
    |	IDENTIFIER                                                  
        {
            String idText = $IDENTIFIER.text;
                                                                        
	        if (idText.matches("^[\\d]+..[\\d]+")) {
                    Matcher range = rangePattern.matcher(idText);
                    $atom = (range.matches()) ? new Atom<Set>(this.createRange(range.group(1), range.group(2))) : new Atom<Object>(null);
	        } else {
                    $atom = new Id<String>($IDENTIFIER.text);
            }
        }
	|   '..' { $atom = new Id<String>(".."); }
    |   ^(BOOL b=BOOLEAN) { $atom = new Atom<Boolean>(new Boolean($b.text)); }
	|	statement {
            try {
                $atom = $statement.op.compute();
            } catch (Exception e) {
                $atom = new Atom<Operation>($statement.op);
            }
        }
    ;


if_statement returns [Operation op]
	:	^(IF ^(COND cond=statement) if_block=block ( ^(ELSE else_block=block ) )? )
        {
            $op = new If($cond.op, $if_block.cb, $else_block.cb);
        }
	;

while_statement returns [Operation op]
	:	^(WHILE ^(COND cond=statement) block)
        {
            $op = new While($cond.op, $block.cb);
        }
	;

foreach_statement returns [Operation op]
	:	^(FOREACH VARIABLE arr=statement block)
        {
            $op = new Foreach($VARIABLE.text, $arr.op, $block.cb, this.context);
        }
	;
	
repeat_statement returns [Operation op]
	:	^(REPEAT timer=statement block)
        {
            $op = new Repeat($timer.op, $block.cb);
        }
	;

block returns [CodeBlock cb]
    @init {
        inBlock = true;
        List<Tree> statements = new LinkedList<Tree>();
    }
    @after {
        inBlock = false;
    }
    :	^(BLOCK ( st=statement { statements.add($st.tree); } | ^(RETURN ret=statement { statements.add($ret.tree.getParent()); }) )* ) 
        { $cb = new CodeBlock(statements, this.context); }
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
            NativeFunction fn = new NativeFunction($fn_name.text, params, $block.cb);
            this.registerFunction($ns.text, fn);

            $op = new UnaryOperation(new Atom<Boolean>(true));
        }
	;
	
function_call returns [Atom value]
    @init {
        List<Operation> arguments = new ArrayList<Operation>();
    }
	:	^(FUNC_CALL ^(FUNC_NAME ^(NS ns=IDENTIFIER) ^(NAME fn_name=IDENTIFIER)) ^(ARGS ( ^(ARG st=statement { arguments.add($st.op); }) )* ))
        {
            if (!inBlock) { 
                try {
                    $value = new Func(this.getFunction($ns.text, $fn_name.text), arguments, this.context);
                } catch(Exception e) {
                    this.context.writeError(e.getMessage());
                }
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
    |   gpath_statement                                             { $value = $gpath_statement.value; }
    |   NULL                                                        { $value = new Atom<Object>(null); }
	;


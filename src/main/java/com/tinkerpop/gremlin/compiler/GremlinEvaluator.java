// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g 2010-10-21 17:34:14

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


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class GremlinEvaluator extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "GPATH", "NATIVE_STEP", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "LOOPS", "SELF", "HISTORY", "FUNC_CALL", "RETURN", "IF", "ELSE", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "SCRIPT", "INT", "LONG", "FLOAT", "DOUBLE", "STR", "ARR", "BOOL", "NULL", "RANGE", "PROPERTY_CALL", "VARIABLE_CALL", "COLLECTION_CALL", "COMMENT", "NEWLINE", "G_INT", "G_LONG", "G_FLOAT", "G_DOUBLE", "StringLiteral", "PROPERTY", "VARIABLE", "IDENTIFIER", "BOOLEAN", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "'/'", "'['", "']'", "'..'", "'('", "')'", "'repeat'", "'=>'", "'while'", "'foreach'", "'in'", "'{'", "'}'", "':='", "'and'", "'or'", "'include'", "'script'", "'if'", "'else'", "'end'", "'step'", "'func'", "','", "'return'", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "'mod'", "':'"
    };
    public static final int WHILE=27;
    public static final int DecimalDigit=64;
    public static final int EOF=-1;
    public static final int FUNC_CALL=20;
    public static final int SingleStringCharacter=55;
    public static final int TOKEN=14;
    public static final int T__93=93;
    public static final int HISTORY=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int NAME=9;
    public static final int T__90=90;
    public static final int ARG=5;
    public static final int G_INT=45;
    public static final int SingleEscapeCharacter=61;
    public static final int INCLUDE=29;
    public static final int RETURN=21;
    public static final int DOUBLE=34;
    public static final int ARGS=6;
    public static final int VAR=4;
    public static final int GPATH=11;
    public static final int COMMENT=43;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int SCRIPT=30;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int NS=8;
    public static final int NULL=38;
    public static final int ELSE=23;
    public static final int BOOL=37;
    public static final int INT=31;
    public static final int DoubleStringCharacter=54;
    public static final int ARR=36;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int WS=56;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int PREDICATES=16;
    public static final int VARIABLE=51;
    public static final int T__70=70;
    public static final int G_DOUBLE=48;
    public static final int PROPERTY=50;
    public static final int FUNC=7;
    public static final int G_LONG=46;
    public static final int FOREACH=26;
    public static final int REPEAT=28;
    public static final int CharacterEscapeSequence=58;
    public static final int FUNC_NAME=10;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int EscapeSequence=57;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int HexEscapeSequence=59;
    public static final int STEP=13;
    public static final int FLOAT=33;
    public static final int HexDigit=65;
    public static final int PREDICATE=15;
    public static final int IF=22;
    public static final int STR=35;
    public static final int BOOLEAN=53;
    public static final int IDENTIFIER=52;
    public static final int EscapeCharacter=63;
    public static final int NATIVE_STEP=12;
    public static final int COLLECTION_CALL=42;
    public static final int G_FLOAT=47;
    public static final int LOOPS=17;
    public static final int PROPERTY_CALL=40;
    public static final int UnicodeEscapeSequence=60;
    public static final int RANGE=39;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int StringLiteral=49;
    public static final int NEWLINE=44;
    public static final int BLOCK=25;
    public static final int NonEscapeCharacter=62;
    public static final int LONG=32;
    public static final int COND=24;
    public static final int SELF=18;
    public static final int VARIABLE_CALL=41;

    // delegates
    // delegators


        public GremlinEvaluator(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public GremlinEvaluator(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return GremlinEvaluator.tokenNames; }
    public String getGrammarFileName() { return "src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g"; }


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


    public static class program_return extends TreeRuleReturnScope {
        public Iterable results;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:293:1: program returns [Iterable results] : ( statement ( NEWLINE )* )+ ;
    public final GremlinEvaluator.program_return program() throws RecognitionException {
        GremlinEvaluator.program_return retval = new GremlinEvaluator.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NEWLINE2=null;
        GremlinEvaluator.statement_return statement1 = null;


        CommonTree NEWLINE2_tree=null;


                List<Object> resultList = new ArrayList<Object>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:297:5: ( ( statement ( NEWLINE )* )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:297:7: ( statement ( NEWLINE )* )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:297:7: ( statement ( NEWLINE )* )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==VAR||LA2_0==FUNC||(LA2_0>=GPATH && LA2_0<=NATIVE_STEP)||LA2_0==IF||(LA2_0>=FOREACH && LA2_0<=DOUBLE)||LA2_0==NULL||(LA2_0>=80 && LA2_0<=81)||(LA2_0>=91 && LA2_0<=101)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:297:8: statement ( NEWLINE )*
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_program68);
            	    statement1=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement1.getTree());
            	     formProgramResult(resultList, (statement1!=null?statement1.op:null)); 
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:297:68: ( NEWLINE )*
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==NEWLINE) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:297:68: NEWLINE
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    NEWLINE2=(CommonTree)match(input,NEWLINE,FOLLOW_NEWLINE_in_program72); 
            	    	    NEWLINE2_tree = (CommonTree)adaptor.dupNode(NEWLINE2);

            	    	    adaptor.addChild(root_0, NEWLINE2_tree);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop1;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


                    retval.results = resultList;
                  

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:303:1: statement returns [Operation op] : ( if_statement | foreach_statement | while_statement | repeat_statement | native_step_definition_statement | function_definition_statement | include_statement | script_statement | ^( VAR atom s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression );
    public final GremlinEvaluator.statement_return statement() throws RecognitionException {
        GremlinEvaluator.statement_return retval = new GremlinEvaluator.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree VAR11=null;
        CommonTree string_literal13=null;
        CommonTree string_literal14=null;
        GremlinEvaluator.statement_return s = null;

        GremlinEvaluator.statement_return a = null;

        GremlinEvaluator.statement_return b = null;

        GremlinEvaluator.if_statement_return if_statement3 = null;

        GremlinEvaluator.foreach_statement_return foreach_statement4 = null;

        GremlinEvaluator.while_statement_return while_statement5 = null;

        GremlinEvaluator.repeat_statement_return repeat_statement6 = null;

        GremlinEvaluator.native_step_definition_statement_return native_step_definition_statement7 = null;

        GremlinEvaluator.function_definition_statement_return function_definition_statement8 = null;

        GremlinEvaluator.include_statement_return include_statement9 = null;

        GremlinEvaluator.script_statement_return script_statement10 = null;

        GremlinEvaluator.atom_return atom12 = null;

        GremlinEvaluator.expression_return expression15 = null;


        CommonTree VAR11_tree=null;
        CommonTree string_literal13_tree=null;
        CommonTree string_literal14_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:304:2: ( if_statement | foreach_statement | while_statement | repeat_statement | native_step_definition_statement | function_definition_statement | include_statement | script_statement | ^( VAR atom s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression )
            int alt3=12;
            switch ( input.LA(1) ) {
            case IF:
                {
                alt3=1;
                }
                break;
            case FOREACH:
                {
                alt3=2;
                }
                break;
            case WHILE:
                {
                alt3=3;
                }
                break;
            case REPEAT:
                {
                alt3=4;
                }
                break;
            case NATIVE_STEP:
                {
                alt3=5;
                }
                break;
            case FUNC:
                {
                alt3=6;
                }
                break;
            case INCLUDE:
                {
                alt3=7;
                }
                break;
            case SCRIPT:
                {
                alt3=8;
                }
                break;
            case VAR:
                {
                alt3=9;
                }
                break;
            case 80:
                {
                alt3=10;
                }
                break;
            case 81:
                {
                alt3=11;
                }
                break;
            case GPATH:
            case INT:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case NULL:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                {
                alt3=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:304:4: if_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_if_statement_in_statement101);
                    if_statement3=if_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, if_statement3.getTree());
                     retval.op = (if_statement3!=null?if_statement3.op:null); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:305:4: foreach_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_statement_in_statement131);
                    foreach_statement4=foreach_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, foreach_statement4.getTree());
                     retval.op = (foreach_statement4!=null?foreach_statement4.op:null); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:306:7: while_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_while_statement_in_statement159);
                    while_statement5=while_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, while_statement5.getTree());
                     retval.op = (while_statement5!=null?while_statement5.op:null); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:307:4: repeat_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_repeat_statement_in_statement186);
                    repeat_statement6=repeat_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, repeat_statement6.getTree());
                     retval.op = (repeat_statement6!=null?repeat_statement6.op:null); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:308:4: native_step_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_native_step_definition_statement_in_statement212);
                    native_step_definition_statement7=native_step_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, native_step_definition_statement7.getTree());
                     retval.op = (native_step_definition_statement7!=null?native_step_definition_statement7.op:null); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:309:4: function_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_definition_statement_in_statement222);
                    function_definition_statement8=function_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, function_definition_statement8.getTree());
                     retval.op = (function_definition_statement8!=null?function_definition_statement8.op:null); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:310:4: include_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_include_statement_in_statement235);
                    include_statement9=include_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, include_statement9.getTree());
                     retval.op = new UnaryOperation((include_statement9!=null?include_statement9.result:null)); 

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:311:6: script_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_script_statement_in_statement262);
                    script_statement10=script_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, script_statement10.getTree());
                     retval.op = new UnaryOperation((script_statement10!=null?script_statement10.result:null)); 

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:312:4: ^( VAR atom s= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VAR11=(CommonTree)match(input,VAR,FOLLOW_VAR_in_statement289); 
                    VAR11_tree = (CommonTree)adaptor.dupNode(VAR11);

                    root_1 = (CommonTree)adaptor.becomeRoot(VAR11_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atom_in_statement291);
                    atom12=atom();

                    state._fsp--;

                    adaptor.addChild(root_1, atom12.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement295);
                    s=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, s.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new DeclareVariable((atom12!=null?atom12.value:null), (s!=null?s.op:null), this.context); 

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:313:9: ^( 'and' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal13=(CommonTree)match(input,80,FOLLOW_80_in_statement321); 
                    string_literal13_tree = (CommonTree)adaptor.dupNode(string_literal13);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal13_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement325);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement329);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new And((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:314:9: ^( 'or' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal14=(CommonTree)match(input,81,FOLLOW_81_in_statement346); 
                    string_literal14_tree = (CommonTree)adaptor.dupNode(string_literal14);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal14_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement351);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement355);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Or((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:315:9: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement371);
                    expression15=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression15.getTree());
                     retval.op = (expression15!=null?expression15.expr:null); 

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class script_statement_return extends TreeRuleReturnScope {
        public Atom result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "script_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:318:1: script_statement returns [Atom result] : ^( SCRIPT StringLiteral ) ;
    public final GremlinEvaluator.script_statement_return script_statement() throws RecognitionException {
        GremlinEvaluator.script_statement_return retval = new GremlinEvaluator.script_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SCRIPT16=null;
        CommonTree StringLiteral17=null;

        CommonTree SCRIPT16_tree=null;
        CommonTree StringLiteral17_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:319:5: ( ^( SCRIPT StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:319:7: ^( SCRIPT StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            SCRIPT16=(CommonTree)match(input,SCRIPT,FOLLOW_SCRIPT_in_script_statement417); 
            SCRIPT16_tree = (CommonTree)adaptor.dupNode(SCRIPT16);

            root_1 = (CommonTree)adaptor.becomeRoot(SCRIPT16_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            StringLiteral17=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_script_statement419); 
            StringLiteral17_tree = (CommonTree)adaptor.dupNode(StringLiteral17);

            adaptor.addChild(root_1, StringLiteral17_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.result = new Atom<Boolean>(true);

                        String filename = (StringLiteral17!=null?StringLiteral17.getText():null);
                        filename = filename.substring(1, filename.length() - 1);

                        try {
                            final GremlinScriptEngine engine = new GremlinScriptEngine();
                            engine.eval(new FileReader(filename), this.context);
                        } catch(FileNotFoundException e) {
                            this.context.writeError("File '" + filename + "' does not exist");
                            this.context.flushErrorStream();

                            retval.result = new Atom<Boolean>(false);
                        } catch (Exception e) {
                            throw new RuntimeException(e.getMessage(), e);
                        }
                  

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "script_statement"

    public static class include_statement_return extends TreeRuleReturnScope {
        public Atom result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "include_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:340:1: include_statement returns [Atom result] : ^( INCLUDE StringLiteral ) ;
    public final GremlinEvaluator.include_statement_return include_statement() throws RecognitionException {
        GremlinEvaluator.include_statement_return retval = new GremlinEvaluator.include_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INCLUDE18=null;
        CommonTree StringLiteral19=null;

        CommonTree INCLUDE18_tree=null;
        CommonTree StringLiteral19_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:341:2: ( ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:341:4: ^( INCLUDE StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            INCLUDE18=(CommonTree)match(input,INCLUDE,FOLLOW_INCLUDE_in_include_statement447); 
            INCLUDE18_tree = (CommonTree)adaptor.dupNode(INCLUDE18);

            root_1 = (CommonTree)adaptor.becomeRoot(INCLUDE18_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            StringLiteral19=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement449); 
            StringLiteral19_tree = (CommonTree)adaptor.dupNode(StringLiteral19);

            adaptor.addChild(root_1, StringLiteral19_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.result = new Atom<Boolean>(true);

                        String className = (StringLiteral19!=null?StringLiteral19.getText():null);
                        try {
                            this.context.loadLibrary(className);
                        } catch(Exception e) {
                            this.context.writeError("Library '" + className + "' does not exist");
                            this.context.flushErrorStream();

                            retval.result = new Atom<Boolean>(false);
                        }
                    

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "include_statement"

    public static class native_step_definition_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "native_step_definition_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:357:1: native_step_definition_statement returns [Operation op] : ^( NATIVE_STEP name= IDENTIFIER block ) ;
    public final GremlinEvaluator.native_step_definition_statement_return native_step_definition_statement() throws RecognitionException {
        GremlinEvaluator.native_step_definition_statement_return retval = new GremlinEvaluator.native_step_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree name=null;
        CommonTree NATIVE_STEP20=null;
        GremlinEvaluator.block_return block21 = null;


        CommonTree name_tree=null;
        CommonTree NATIVE_STEP20_tree=null;


                List<Pipe> pipes = new ArrayList<Pipe>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:361:2: ( ^( NATIVE_STEP name= IDENTIFIER block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:361:4: ^( NATIVE_STEP name= IDENTIFIER block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NATIVE_STEP20=(CommonTree)match(input,NATIVE_STEP,FOLLOW_NATIVE_STEP_in_native_step_definition_statement486); 
            NATIVE_STEP20_tree = (CommonTree)adaptor.dupNode(NATIVE_STEP20);

            root_1 = (CommonTree)adaptor.becomeRoot(NATIVE_STEP20_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_native_step_definition_statement490); 
            name_tree = (CommonTree)adaptor.dupNode(name);

            adaptor.addChild(root_1, name_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_native_step_definition_statement492);
            block21=block();

            state._fsp--;

            adaptor.addChild(root_1, block21.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                      Step nativeStep = new Step((name!=null?name.getText():null), NativePipe.class, new Object[]{ (block21!=null?block21.cb:null) });
                      this.context.getStepLibrary().registerStep(nativeStep);
                      retval.op = new UnaryOperation(new Atom<Boolean>(true));
                  

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "native_step_definition_statement"

    protected static class gpath_statement_scope {
        int pipeCount;
        List<Pair<Atom<Object>, List<Operation>>> steps;
    }
    protected Stack gpath_statement_stack = new Stack();

    public static class gpath_statement_return extends TreeRuleReturnScope {
        public Atom value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gpath_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:370:1: gpath_statement returns [Atom value] : ^( GPATH ( step )+ ) ;
    public final GremlinEvaluator.gpath_statement_return gpath_statement() throws RecognitionException {
        gpath_statement_stack.push(new gpath_statement_scope());
        GremlinEvaluator.gpath_statement_return retval = new GremlinEvaluator.gpath_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GPATH22=null;
        GremlinEvaluator.step_return step23 = null;


        CommonTree GPATH22_tree=null;


                isGPath = true;
                gpathScope++;
                ((gpath_statement_scope)gpath_statement_stack.peek()).steps = new LinkedList<Pair<Atom<Object>, List<Operation>>>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:384:2: ( ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:384:4: ^( GPATH ( step )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            GPATH22=(CommonTree)match(input,GPATH,FOLLOW_GPATH_in_gpath_statement548); 
            GPATH22_tree = (CommonTree)adaptor.dupNode(GPATH22);

            root_1 = (CommonTree)adaptor.becomeRoot(GPATH22_tree, root_1);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:384:12: ( step )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==STEP) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:384:13: step
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_step_in_gpath_statement551);
            	    step23=step();

            	    state._fsp--;

            	    adaptor.addChild(root_1, step23.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        if (!inBlock) {
                            List<Pair<Atom<Object>, List<Operation>>> stepList = ((gpath_statement_scope)gpath_statement_stack.peek()).steps;

                            if (stepList.size() == 1) {
                                Pair<Atom<Object>, List<Operation>> currentPair = stepList.get(0);
                            
                                Atom<Object> token = currentPair.getA();
                                List<Operation> predicates = currentPair.getB();
                                retval.value = (predicates.size() == 0) ? singleGPathStep(token) : compileCollectionCall(token, predicates);
                            } else {
                                retval.value = compileGPathCall(stepList);
                            }
                        }
                    

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


                    isGPath = false;
                    gpathScope--;
                
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            gpath_statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "gpath_statement"

    public static class step_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "step"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:402:1: step : ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ^( LOOPS ( inline_loop_definition )* ) ) ;
    public final GremlinEvaluator.step_return step() throws RecognitionException {
        GremlinEvaluator.step_return retval = new GremlinEvaluator.step_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STEP24=null;
        CommonTree TOKEN25=null;
        CommonTree PREDICATES27=null;
        CommonTree PREDICATE28=null;
        CommonTree LOOPS30=null;
        GremlinEvaluator.token_return token26 = null;

        GremlinEvaluator.statement_return statement29 = null;

        GremlinEvaluator.inline_loop_definition_return inline_loop_definition31 = null;


        CommonTree STEP24_tree=null;
        CommonTree TOKEN25_tree=null;
        CommonTree PREDICATES27_tree=null;
        CommonTree PREDICATE28_tree=null;
        CommonTree LOOPS30_tree=null;


                List<Operation> predicates = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:406:5: ( ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ^( LOOPS ( inline_loop_definition )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:406:7: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ^( LOOPS ( inline_loop_definition )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            STEP24=(CommonTree)match(input,STEP,FOLLOW_STEP_in_step589); 
            STEP24_tree = (CommonTree)adaptor.dupNode(STEP24);

            root_1 = (CommonTree)adaptor.becomeRoot(STEP24_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TOKEN25=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_step592); 
            TOKEN25_tree = (CommonTree)adaptor.dupNode(TOKEN25);

            root_2 = (CommonTree)adaptor.becomeRoot(TOKEN25_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_token_in_step594);
            token26=token();

            state._fsp--;

            adaptor.addChild(root_2, token26.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PREDICATES27=(CommonTree)match(input,PREDICATES,FOLLOW_PREDICATES_in_step598); 
            PREDICATES27_tree = (CommonTree)adaptor.dupNode(PREDICATES27);

            root_2 = (CommonTree)adaptor.becomeRoot(PREDICATES27_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:406:42: ( ^( PREDICATE statement ) )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==PREDICATE) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:406:44: ^( PREDICATE statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    PREDICATE28=(CommonTree)match(input,PREDICATE,FOLLOW_PREDICATE_in_step603); 
                	    PREDICATE28_tree = (CommonTree)adaptor.dupNode(PREDICATE28);

                	    root_3 = (CommonTree)adaptor.becomeRoot(PREDICATE28_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_step605);
                	    statement29=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_3, statement29.getTree());
                	     predicates.add((statement29!=null?statement29.op:null)); 

                	    match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
                	    }


                	    }
                	    break;

                	default :
                	    break loop5;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            LOOPS30=(CommonTree)match(input,LOOPS,FOLLOW_LOOPS_in_step616); 
            LOOPS30_tree = (CommonTree)adaptor.dupNode(LOOPS30);

            root_2 = (CommonTree)adaptor.becomeRoot(LOOPS30_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:406:115: ( inline_loop_definition )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=FOREACH && LA6_0<=REPEAT)) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:406:117: inline_loop_definition
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_inline_loop_definition_in_step620);
                	    inline_loop_definition31=inline_loop_definition();

                	    state._fsp--;

                	    adaptor.addChild(root_2, inline_loop_definition31.getTree());

                	    }
                	    break;

                	default :
                	    break loop6;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        ((gpath_statement_scope)gpath_statement_stack.peek()).steps.add(new Pair((token26!=null?token26.atom:null), predicates));
                    

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "step"

    public static class inline_loop_definition_return extends TreeRuleReturnScope {
        public Pipe pipe;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inline_loop_definition"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:412:1: inline_loop_definition returns [Pipe pipe] : ( ^( REPEAT times= statement block ) | ^( WHILE ^( COND condition= statement ) block ) | ^( FOREACH VARIABLE iterable= statement block ) );
    public final GremlinEvaluator.inline_loop_definition_return inline_loop_definition() throws RecognitionException {
        GremlinEvaluator.inline_loop_definition_return retval = new GremlinEvaluator.inline_loop_definition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REPEAT32=null;
        CommonTree WHILE34=null;
        CommonTree COND35=null;
        CommonTree FOREACH37=null;
        CommonTree VARIABLE38=null;
        GremlinEvaluator.statement_return times = null;

        GremlinEvaluator.statement_return condition = null;

        GremlinEvaluator.statement_return iterable = null;

        GremlinEvaluator.block_return block33 = null;

        GremlinEvaluator.block_return block36 = null;

        GremlinEvaluator.block_return block39 = null;


        CommonTree REPEAT32_tree=null;
        CommonTree WHILE34_tree=null;
        CommonTree COND35_tree=null;
        CommonTree FOREACH37_tree=null;
        CommonTree VARIABLE38_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:413:5: ( ^( REPEAT times= statement block ) | ^( WHILE ^( COND condition= statement ) block ) | ^( FOREACH VARIABLE iterable= statement block ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case REPEAT:
                {
                alt7=1;
                }
                break;
            case WHILE:
                {
                alt7=2;
                }
                break;
            case FOREACH:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:413:7: ^( REPEAT times= statement block )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    REPEAT32=(CommonTree)match(input,REPEAT,FOLLOW_REPEAT_in_inline_loop_definition658); 
                    REPEAT32_tree = (CommonTree)adaptor.dupNode(REPEAT32);

                    root_1 = (CommonTree)adaptor.becomeRoot(REPEAT32_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_inline_loop_definition662);
                    times=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, times.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_block_in_inline_loop_definition664);
                    block33=block();

                    state._fsp--;

                    adaptor.addChild(root_1, block33.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:414:7: ^( WHILE ^( COND condition= statement ) block )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    WHILE34=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_inline_loop_definition676); 
                    WHILE34_tree = (CommonTree)adaptor.dupNode(WHILE34);

                    root_1 = (CommonTree)adaptor.becomeRoot(WHILE34_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    COND35=(CommonTree)match(input,COND,FOLLOW_COND_in_inline_loop_definition679); 
                    COND35_tree = (CommonTree)adaptor.dupNode(COND35);

                    root_2 = (CommonTree)adaptor.becomeRoot(COND35_tree, root_2);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_inline_loop_definition683);
                    condition=statement();

                    state._fsp--;

                    adaptor.addChild(root_2, condition.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
                    }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_block_in_inline_loop_definition686);
                    block36=block();

                    state._fsp--;

                    adaptor.addChild(root_1, block36.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:415:7: ^( FOREACH VARIABLE iterable= statement block )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    FOREACH37=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_inline_loop_definition698); 
                    FOREACH37_tree = (CommonTree)adaptor.dupNode(FOREACH37);

                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH37_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VARIABLE38=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_inline_loop_definition700); 
                    VARIABLE38_tree = (CommonTree)adaptor.dupNode(VARIABLE38);

                    adaptor.addChild(root_1, VARIABLE38_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_inline_loop_definition704);
                    iterable=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, iterable.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_block_in_inline_loop_definition706);
                    block39=block();

                    state._fsp--;

                    adaptor.addChild(root_1, block39.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inline_loop_definition"

    public static class token_return extends TreeRuleReturnScope {
        public Atom atom;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "token"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:418:1: token returns [Atom atom] : ( function_call | ^( STR StringLiteral ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | '..' | ^( BOOL b= BOOLEAN ) | statement );
    public final GremlinEvaluator.token_return token() throws RecognitionException {
        GremlinEvaluator.token_return retval = new GremlinEvaluator.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree b=null;
        CommonTree STR41=null;
        CommonTree StringLiteral42=null;
        CommonTree VARIABLE_CALL43=null;
        CommonTree VARIABLE44=null;
        CommonTree PROPERTY_CALL45=null;
        CommonTree PROPERTY46=null;
        CommonTree IDENTIFIER47=null;
        CommonTree string_literal48=null;
        CommonTree BOOL49=null;
        GremlinEvaluator.function_call_return function_call40 = null;

        GremlinEvaluator.statement_return statement50 = null;


        CommonTree b_tree=null;
        CommonTree STR41_tree=null;
        CommonTree StringLiteral42_tree=null;
        CommonTree VARIABLE_CALL43_tree=null;
        CommonTree VARIABLE44_tree=null;
        CommonTree PROPERTY_CALL45_tree=null;
        CommonTree PROPERTY46_tree=null;
        CommonTree IDENTIFIER47_tree=null;
        CommonTree string_literal48_tree=null;
        CommonTree BOOL49_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:419:5: ( function_call | ^( STR StringLiteral ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | '..' | ^( BOOL b= BOOLEAN ) | statement )
            int alt8=8;
            switch ( input.LA(1) ) {
            case FUNC_CALL:
                {
                alt8=1;
                }
                break;
            case STR:
                {
                alt8=2;
                }
                break;
            case VARIABLE_CALL:
                {
                alt8=3;
                }
                break;
            case PROPERTY_CALL:
                {
                alt8=4;
                }
                break;
            case IDENTIFIER:
                {
                alt8=5;
                }
                break;
            case 69:
                {
                alt8=6;
                }
                break;
            case BOOL:
                {
                alt8=7;
                }
                break;
            case VAR:
            case FUNC:
            case GPATH:
            case NATIVE_STEP:
            case IF:
            case FOREACH:
            case WHILE:
            case REPEAT:
            case INCLUDE:
            case SCRIPT:
            case INT:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case NULL:
            case 80:
            case 81:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                {
                alt8=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:419:9: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_call_in_token732);
                    function_call40=function_call();

                    state._fsp--;

                    adaptor.addChild(root_0, function_call40.getTree());
                     retval.atom = (function_call40!=null?function_call40.value:null); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:420:9: ^( STR StringLiteral )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    STR41=(CommonTree)match(input,STR,FOLLOW_STR_in_token759); 
                    STR41_tree = (CommonTree)adaptor.dupNode(STR41);

                    root_1 = (CommonTree)adaptor.becomeRoot(STR41_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    StringLiteral42=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_token761); 
                    StringLiteral42_tree = (CommonTree)adaptor.dupNode(StringLiteral42);

                    adaptor.addChild(root_1, StringLiteral42_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.atom = new Atom<String>((StringLiteral42!=null?StringLiteral42.getText():null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:421:4: ^( VARIABLE_CALL VARIABLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VARIABLE_CALL43=(CommonTree)match(input,VARIABLE_CALL,FOLLOW_VARIABLE_CALL_in_token777); 
                    VARIABLE_CALL43_tree = (CommonTree)adaptor.dupNode(VARIABLE_CALL43);

                    root_1 = (CommonTree)adaptor.becomeRoot(VARIABLE_CALL43_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VARIABLE44=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_token779); 
                    VARIABLE44_tree = (CommonTree)adaptor.dupNode(VARIABLE44);

                    adaptor.addChild(root_1, VARIABLE44_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.atom = (VARIABLE44!=null?VARIABLE44.getText():null).equals(Tokens.ROOT_VARIABLE) ? new RootVar(context) : new Var((VARIABLE44!=null?VARIABLE44.getText():null), this.context); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:422:4: ^( PROPERTY_CALL PROPERTY )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    PROPERTY_CALL45=(CommonTree)match(input,PROPERTY_CALL,FOLLOW_PROPERTY_CALL_in_token790); 
                    PROPERTY_CALL45_tree = (CommonTree)adaptor.dupNode(PROPERTY_CALL45);

                    root_1 = (CommonTree)adaptor.becomeRoot(PROPERTY_CALL45_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    PROPERTY46=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_token792); 
                    PROPERTY46_tree = (CommonTree)adaptor.dupNode(PROPERTY46);

                    adaptor.addChild(root_1, PROPERTY46_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.atom = new Prop<String>((PROPERTY46!=null?PROPERTY46.getText():null).substring(1)); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:423:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER47=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_token805); 
                    IDENTIFIER47_tree = (CommonTree)adaptor.dupNode(IDENTIFIER47);

                    adaptor.addChild(root_0, IDENTIFIER47_tree);


                                String idText = (IDENTIFIER47!=null?IDENTIFIER47.getText():null);
                                                                                            
                    	        if (idText.matches("^[\\d]+..[\\d]+")) {
                                        Matcher range = rangePattern.matcher(idText);
                                        retval.atom = (range.matches()) ? new Atom<Set>(this.createRange(range.group(1), range.group(2))) : new Atom<Object>(null);
                    	        } else {
                                        retval.atom = new Id<String>((IDENTIFIER47!=null?IDENTIFIER47.getText():null));
                                }
                            

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:434:6: '..'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal48=(CommonTree)match(input,69,FOLLOW_69_in_token872); 
                    string_literal48_tree = (CommonTree)adaptor.dupNode(string_literal48);

                    adaptor.addChild(root_0, string_literal48_tree);

                     retval.atom = new Id<String>(".."); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:435:9: ^( BOOL b= BOOLEAN )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    BOOL49=(CommonTree)match(input,BOOL,FOLLOW_BOOL_in_token885); 
                    BOOL49_tree = (CommonTree)adaptor.dupNode(BOOL49);

                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL49_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    b=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_token889); 
                    b_tree = (CommonTree)adaptor.dupNode(b);

                    adaptor.addChild(root_1, b_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.atom = new Atom<Boolean>(new Boolean((b!=null?b.getText():null))); 

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:436:4: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_token897);
                    statement50=statement();

                    state._fsp--;

                    adaptor.addChild(root_0, statement50.getTree());

                                try {
                                    retval.atom = (statement50!=null?statement50.op:null).compute();
                                } catch (Exception e) {
                                    retval.atom = new Atom<Operation>((statement50!=null?statement50.op:null));
                                }
                            

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "token"

    public static class if_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "if_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:446:1: if_statement returns [Operation op] : ^( IF ^( COND cond= statement ) if_block= block ( ^( ELSE else_block= block ) )? ) ;
    public final GremlinEvaluator.if_statement_return if_statement() throws RecognitionException {
        GremlinEvaluator.if_statement_return retval = new GremlinEvaluator.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IF51=null;
        CommonTree COND52=null;
        CommonTree ELSE53=null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return if_block = null;

        GremlinEvaluator.block_return else_block = null;


        CommonTree IF51_tree=null;
        CommonTree COND52_tree=null;
        CommonTree ELSE53_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:447:2: ( ^( IF ^( COND cond= statement ) if_block= block ( ^( ELSE else_block= block ) )? ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:447:4: ^( IF ^( COND cond= statement ) if_block= block ( ^( ELSE else_block= block ) )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            IF51=(CommonTree)match(input,IF,FOLLOW_IF_in_if_statement919); 
            IF51_tree = (CommonTree)adaptor.dupNode(IF51);

            root_1 = (CommonTree)adaptor.becomeRoot(IF51_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND52=(CommonTree)match(input,COND,FOLLOW_COND_in_if_statement922); 
            COND52_tree = (CommonTree)adaptor.dupNode(COND52);

            root_2 = (CommonTree)adaptor.becomeRoot(COND52_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_if_statement926);
            cond=statement();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_if_statement931);
            if_block=block();

            state._fsp--;

            adaptor.addChild(root_1, if_block.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:447:47: ( ^( ELSE else_block= block ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ELSE) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:447:49: ^( ELSE else_block= block )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    ELSE53=(CommonTree)match(input,ELSE,FOLLOW_ELSE_in_if_statement936); 
                    ELSE53_tree = (CommonTree)adaptor.dupNode(ELSE53);

                    root_2 = (CommonTree)adaptor.becomeRoot(ELSE53_tree, root_2);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_block_in_if_statement940);
                    else_block=block();

                    state._fsp--;

                    adaptor.addChild(root_2, else_block.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
                    }


                    }
                    break;

            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new If((cond!=null?cond.op:null), (if_block!=null?if_block.cb:null), (else_block!=null?else_block.cb:null));
                    

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "if_statement"

    public static class while_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "while_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:453:1: while_statement returns [Operation op] : ^( WHILE ^( COND cond= statement ) block ) ;
    public final GremlinEvaluator.while_statement_return while_statement() throws RecognitionException {
        GremlinEvaluator.while_statement_return retval = new GremlinEvaluator.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree WHILE54=null;
        CommonTree COND55=null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return block56 = null;


        CommonTree WHILE54_tree=null;
        CommonTree COND55_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:454:2: ( ^( WHILE ^( COND cond= statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:454:4: ^( WHILE ^( COND cond= statement ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            WHILE54=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_while_statement973); 
            WHILE54_tree = (CommonTree)adaptor.dupNode(WHILE54);

            root_1 = (CommonTree)adaptor.becomeRoot(WHILE54_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND55=(CommonTree)match(input,COND,FOLLOW_COND_in_while_statement976); 
            COND55_tree = (CommonTree)adaptor.dupNode(COND55);

            root_2 = (CommonTree)adaptor.becomeRoot(COND55_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_while_statement980);
            cond=statement();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_while_statement983);
            block56=block();

            state._fsp--;

            adaptor.addChild(root_1, block56.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new While((cond!=null?cond.op:null), (block56!=null?block56.cb:null));
                    

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "while_statement"

    public static class foreach_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "foreach_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:460:1: foreach_statement returns [Operation op] : ^( FOREACH VARIABLE arr= statement block ) ;
    public final GremlinEvaluator.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinEvaluator.foreach_statement_return retval = new GremlinEvaluator.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH57=null;
        CommonTree VARIABLE58=null;
        GremlinEvaluator.statement_return arr = null;

        GremlinEvaluator.block_return block59 = null;


        CommonTree FOREACH57_tree=null;
        CommonTree VARIABLE58_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:461:2: ( ^( FOREACH VARIABLE arr= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:461:4: ^( FOREACH VARIABLE arr= statement block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FOREACH57=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_statement1010); 
            FOREACH57_tree = (CommonTree)adaptor.dupNode(FOREACH57);

            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH57_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            VARIABLE58=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement1012); 
            VARIABLE58_tree = (CommonTree)adaptor.dupNode(VARIABLE58);

            adaptor.addChild(root_1, VARIABLE58_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_foreach_statement1016);
            arr=statement();

            state._fsp--;

            adaptor.addChild(root_1, arr.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_foreach_statement1018);
            block59=block();

            state._fsp--;

            adaptor.addChild(root_1, block59.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Foreach((VARIABLE58!=null?VARIABLE58.getText():null), (arr!=null?arr.op:null), (block59!=null?block59.cb:null), this.context);
                    

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "foreach_statement"

    public static class repeat_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "repeat_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:467:1: repeat_statement returns [Operation op] : ^( REPEAT timer= statement block ) ;
    public final GremlinEvaluator.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinEvaluator.repeat_statement_return retval = new GremlinEvaluator.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REPEAT60=null;
        GremlinEvaluator.statement_return timer = null;

        GremlinEvaluator.block_return block61 = null;


        CommonTree REPEAT60_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:468:2: ( ^( REPEAT timer= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:468:4: ^( REPEAT timer= statement block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            REPEAT60=(CommonTree)match(input,REPEAT,FOLLOW_REPEAT_in_repeat_statement1046); 
            REPEAT60_tree = (CommonTree)adaptor.dupNode(REPEAT60);

            root_1 = (CommonTree)adaptor.becomeRoot(REPEAT60_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_repeat_statement1050);
            timer=statement();

            state._fsp--;

            adaptor.addChild(root_1, timer.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_repeat_statement1052);
            block61=block();

            state._fsp--;

            adaptor.addChild(root_1, block61.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Repeat((timer!=null?timer.op:null), (block61!=null?block61.cb:null));
                    

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "repeat_statement"

    public static class block_return extends TreeRuleReturnScope {
        public CodeBlock cb;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:474:1: block returns [CodeBlock cb] : ^( BLOCK (st= statement | ^( RETURN ret= statement ) )* ) ;
    public final GremlinEvaluator.block_return block() throws RecognitionException {
        GremlinEvaluator.block_return retval = new GremlinEvaluator.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BLOCK62=null;
        CommonTree RETURN63=null;
        GremlinEvaluator.statement_return st = null;

        GremlinEvaluator.statement_return ret = null;


        CommonTree BLOCK62_tree=null;
        CommonTree RETURN63_tree=null;


                inBlock = true;
                List<Tree> statements = new LinkedList<Tree>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:482:5: ( ^( BLOCK (st= statement | ^( RETURN ret= statement ) )* ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:482:7: ^( BLOCK (st= statement | ^( RETURN ret= statement ) )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            BLOCK62=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_block1100); 
            BLOCK62_tree = (CommonTree)adaptor.dupNode(BLOCK62);

            root_1 = (CommonTree)adaptor.becomeRoot(BLOCK62_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:482:15: (st= statement | ^( RETURN ret= statement ) )*
                loop10:
                do {
                    int alt10=3;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==VAR||LA10_0==FUNC||(LA10_0>=GPATH && LA10_0<=NATIVE_STEP)||LA10_0==IF||(LA10_0>=FOREACH && LA10_0<=DOUBLE)||LA10_0==NULL||(LA10_0>=80 && LA10_0<=81)||(LA10_0>=91 && LA10_0<=101)) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==RETURN) ) {
                        alt10=2;
                    }


                    switch (alt10) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:482:17: st= statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_block1106);
                	    st=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_1, st.getTree());
                	     statements.add((st!=null?((CommonTree)st.tree):null)); 

                	    }
                	    break;
                	case 2 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:482:62: ^( RETURN ret= statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_2 = _last;
                	    CommonTree _first_2 = null;
                	    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    RETURN63=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_block1113); 
                	    RETURN63_tree = (CommonTree)adaptor.dupNode(RETURN63);

                	    root_2 = (CommonTree)adaptor.becomeRoot(RETURN63_tree, root_2);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_block1117);
                	    ret=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_2, ret.getTree());
                	     statements.add((ret!=null?((CommonTree)ret.tree):null).getParent()); 

                	    match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
                	    }


                	    }
                	    break;

                	default :
                	    break loop10;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

             retval.cb = new CodeBlock(statements, this.context); 

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


                    inBlock = false;
                
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class expression_return extends TreeRuleReturnScope {
        public Operation expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:486:1: expression returns [Operation expr] : ( ^( '=' a= statement b= statement ) | ^( '!=' a= statement b= statement ) | ^( '<' a= statement b= statement ) | ^( '>' a= statement b= statement ) | ^( '<=' a= statement b= statement ) | ^( '>=' a= statement b= statement ) | operation );
    public final GremlinEvaluator.expression_return expression() throws RecognitionException {
        GremlinEvaluator.expression_return retval = new GremlinEvaluator.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal64=null;
        CommonTree string_literal65=null;
        CommonTree char_literal66=null;
        CommonTree char_literal67=null;
        CommonTree string_literal68=null;
        CommonTree string_literal69=null;
        GremlinEvaluator.statement_return a = null;

        GremlinEvaluator.statement_return b = null;

        GremlinEvaluator.operation_return operation70 = null;


        CommonTree char_literal64_tree=null;
        CommonTree string_literal65_tree=null;
        CommonTree char_literal66_tree=null;
        CommonTree char_literal67_tree=null;
        CommonTree string_literal68_tree=null;
        CommonTree string_literal69_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:487:5: ( ^( '=' a= statement b= statement ) | ^( '!=' a= statement b= statement ) | ^( '<' a= statement b= statement ) | ^( '>' a= statement b= statement ) | ^( '<=' a= statement b= statement ) | ^( '>=' a= statement b= statement ) | operation )
            int alt11=7;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt11=1;
                }
                break;
            case 92:
                {
                alt11=2;
                }
                break;
            case 93:
                {
                alt11=3;
                }
                break;
            case 95:
                {
                alt11=4;
                }
                break;
            case 94:
                {
                alt11=5;
                }
                break;
            case 96:
                {
                alt11=6;
                }
                break;
            case GPATH:
            case INT:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case NULL:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                {
                alt11=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:487:9: ^( '=' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal64=(CommonTree)match(input,91,FOLLOW_91_in_expression1160); 
                    char_literal64_tree = (CommonTree)adaptor.dupNode(char_literal64);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal64_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1165);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1169);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new Equality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:488:9: ^( '!=' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal65=(CommonTree)match(input,92,FOLLOW_92_in_expression1183); 
                    string_literal65_tree = (CommonTree)adaptor.dupNode(string_literal65);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal65_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1187);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1191);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new UnEquality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:489:9: ^( '<' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal66=(CommonTree)match(input,93,FOLLOW_93_in_expression1205); 
                    char_literal66_tree = (CommonTree)adaptor.dupNode(char_literal66);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal66_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1210);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1214);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:490:9: ^( '>' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal67=(CommonTree)match(input,95,FOLLOW_95_in_expression1228); 
                    char_literal67_tree = (CommonTree)adaptor.dupNode(char_literal67);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal67_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1233);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1237);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:491:9: ^( '<=' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal68=(CommonTree)match(input,94,FOLLOW_94_in_expression1251); 
                    string_literal68_tree = (CommonTree)adaptor.dupNode(string_literal68);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal68_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1255);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1259);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:492:9: ^( '>=' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal69=(CommonTree)match(input,96,FOLLOW_96_in_expression1273); 
                    string_literal69_tree = (CommonTree)adaptor.dupNode(string_literal69);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal69_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1277);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1281);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:493:9: operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression1294);
                    operation70=operation();

                    state._fsp--;

                    adaptor.addChild(root_0, operation70.getTree());
                     retval.expr = (operation70!=null?operation70.op:null); 

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class operation_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operation"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:496:1: operation returns [Operation op] : ( ^( '+' a= statement b= statement ) | ^( '-' a= statement b= statement ) | binary_operation );
    public final GremlinEvaluator.operation_return operation() throws RecognitionException {
        GremlinEvaluator.operation_return retval = new GremlinEvaluator.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal71=null;
        CommonTree char_literal72=null;
        GremlinEvaluator.statement_return a = null;

        GremlinEvaluator.statement_return b = null;

        GremlinEvaluator.binary_operation_return binary_operation73 = null;


        CommonTree char_literal71_tree=null;
        CommonTree char_literal72_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:497:5: ( ^( '+' a= statement b= statement ) | ^( '-' a= statement b= statement ) | binary_operation )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 97:
                {
                alt12=1;
                }
                break;
            case 98:
                {
                alt12=2;
                }
                break;
            case GPATH:
            case INT:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case NULL:
            case 99:
            case 100:
            case 101:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:497:9: ^( '+' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal71=(CommonTree)match(input,97,FOLLOW_97_in_operation1339); 
                    char_literal71_tree = (CommonTree)adaptor.dupNode(char_literal71);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal71_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_operation1343);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_operation1347);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Addition((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:498:9: ^( '-' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal72=(CommonTree)match(input,98,FOLLOW_98_in_operation1361); 
                    char_literal72_tree = (CommonTree)adaptor.dupNode(char_literal72);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal72_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_operation1365);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_operation1369);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Subtraction((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:499:9: binary_operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_binary_operation_in_operation1382);
                    binary_operation73=binary_operation();

                    state._fsp--;

                    adaptor.addChild(root_0, binary_operation73.getTree());
                     retval.op = (binary_operation73!=null?binary_operation73.operation:null); 

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operation"

    public static class binary_operation_return extends TreeRuleReturnScope {
        public Operation operation;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "binary_operation"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:502:1: binary_operation returns [Operation operation] : ( ^( '*' a= statement b= statement ) | ^( 'div' a= statement b= statement ) | ^( 'mod' a= statement b= statement ) | atom );
    public final GremlinEvaluator.binary_operation_return binary_operation() throws RecognitionException {
        GremlinEvaluator.binary_operation_return retval = new GremlinEvaluator.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal74=null;
        CommonTree string_literal75=null;
        CommonTree string_literal76=null;
        GremlinEvaluator.statement_return a = null;

        GremlinEvaluator.statement_return b = null;

        GremlinEvaluator.atom_return atom77 = null;


        CommonTree char_literal74_tree=null;
        CommonTree string_literal75_tree=null;
        CommonTree string_literal76_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:503:5: ( ^( '*' a= statement b= statement ) | ^( 'div' a= statement b= statement ) | ^( 'mod' a= statement b= statement ) | atom )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt13=1;
                }
                break;
            case 100:
                {
                alt13=2;
                }
                break;
            case 101:
                {
                alt13=3;
                }
                break;
            case GPATH:
            case INT:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case NULL:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:503:9: ^( '*' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal74=(CommonTree)match(input,99,FOLLOW_99_in_binary_operation1419); 
                    char_literal74_tree = (CommonTree)adaptor.dupNode(char_literal74);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal74_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1425);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1429);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Multiplication((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:504:9: ^( 'div' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal75=(CommonTree)match(input,100,FOLLOW_100_in_binary_operation1444); 
                    string_literal75_tree = (CommonTree)adaptor.dupNode(string_literal75);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal75_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1448);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1452);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Division((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:505:7: ^( 'mod' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal76=(CommonTree)match(input,101,FOLLOW_101_in_binary_operation1465); 
                    string_literal76_tree = (CommonTree)adaptor.dupNode(string_literal76);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal76_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1469);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1473);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Modulo((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:506:9: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atom_in_binary_operation1487);
                    atom77=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom77.getTree());
                     retval.operation = new UnaryOperation((atom77!=null?atom77.value:null)); 

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "binary_operation"

    public static class function_definition_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_definition_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:509:1: function_definition_statement returns [Operation op] : ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) ;
    public final GremlinEvaluator.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinEvaluator.function_definition_statement_return retval = new GremlinEvaluator.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC78=null;
        CommonTree FUNC_NAME79=null;
        CommonTree NS80=null;
        CommonTree NAME81=null;
        CommonTree ARGS82=null;
        CommonTree ARG83=null;
        CommonTree VARIABLE84=null;
        GremlinEvaluator.block_return block85 = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC78_tree=null;
        CommonTree FUNC_NAME79_tree=null;
        CommonTree NS80_tree=null;
        CommonTree NAME81_tree=null;
        CommonTree ARGS82_tree=null;
        CommonTree ARG83_tree=null;
        CommonTree VARIABLE84_tree=null;


                List<String> params = new ArrayList<String>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:513:2: ( ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:513:4: ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC78=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_function_definition_statement1543); 
            FUNC78_tree = (CommonTree)adaptor.dupNode(FUNC78);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC78_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME79=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_definition_statement1546); 
            FUNC_NAME79_tree = (CommonTree)adaptor.dupNode(FUNC_NAME79);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME79_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS80=(CommonTree)match(input,NS,FOLLOW_NS_in_function_definition_statement1549); 
            NS80_tree = (CommonTree)adaptor.dupNode(NS80);

            root_3 = (CommonTree)adaptor.becomeRoot(NS80_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1553); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME81=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_definition_statement1557); 
            NAME81_tree = (CommonTree)adaptor.dupNode(NAME81);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME81_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1561); 
            fn_name_tree = (CommonTree)adaptor.dupNode(fn_name);

            adaptor.addChild(root_3, fn_name_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }


            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ARGS82=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_definition_statement1566); 
            ARGS82_tree = (CommonTree)adaptor.dupNode(ARGS82);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS82_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:513:78: ( ^( ARG VARIABLE ) )*
                loop14:
                do {
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==ARG) ) {
                        alt14=1;
                    }


                    switch (alt14) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:513:80: ^( ARG VARIABLE )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG83=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_definition_statement1571); 
                	    ARG83_tree = (CommonTree)adaptor.dupNode(ARG83);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG83_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    VARIABLE84=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_function_definition_statement1573); 
                	    VARIABLE84_tree = (CommonTree)adaptor.dupNode(VARIABLE84);

                	    adaptor.addChild(root_3, VARIABLE84_tree);

                	     params.add((VARIABLE84!=null?VARIABLE84.getText():null)); 

                	    match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
                	    }


                	    }
                	    break;

                	default :
                	    break loop14;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_function_definition_statement1582);
            block85=block();

            state._fsp--;

            adaptor.addChild(root_1, block85.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        NativeFunction fn = new NativeFunction((fn_name!=null?fn_name.getText():null), params, (block85!=null?block85.cb:null));
                        this.registerFunction((ns!=null?ns.getText():null), fn);

                        retval.op = new UnaryOperation(new Atom<Boolean>(true));
                    

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_definition_statement"

    public static class function_call_return extends TreeRuleReturnScope {
        public Atom value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_call"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:522:1: function_call returns [Atom value] : ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) ;
    public final GremlinEvaluator.function_call_return function_call() throws RecognitionException {
        GremlinEvaluator.function_call_return retval = new GremlinEvaluator.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC_CALL86=null;
        CommonTree FUNC_NAME87=null;
        CommonTree NS88=null;
        CommonTree NAME89=null;
        CommonTree ARGS90=null;
        CommonTree ARG91=null;
        GremlinEvaluator.statement_return st = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC_CALL86_tree=null;
        CommonTree FUNC_NAME87_tree=null;
        CommonTree NS88_tree=null;
        CommonTree NAME89_tree=null;
        CommonTree ARGS90_tree=null;
        CommonTree ARG91_tree=null;


                List<Operation> arguments = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:526:2: ( ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:526:4: ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_CALL86=(CommonTree)match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_function_call1619); 
            FUNC_CALL86_tree = (CommonTree)adaptor.dupNode(FUNC_CALL86);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_CALL86_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME87=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_call1622); 
            FUNC_NAME87_tree = (CommonTree)adaptor.dupNode(FUNC_NAME87);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME87_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS88=(CommonTree)match(input,NS,FOLLOW_NS_in_function_call1625); 
            NS88_tree = (CommonTree)adaptor.dupNode(NS88);

            root_3 = (CommonTree)adaptor.becomeRoot(NS88_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1629); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME89=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_call1633); 
            NAME89_tree = (CommonTree)adaptor.dupNode(NAME89);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME89_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1637); 
            fn_name_tree = (CommonTree)adaptor.dupNode(fn_name);

            adaptor.addChild(root_3, fn_name_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }


            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ARGS90=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_call1642); 
            ARGS90_tree = (CommonTree)adaptor.dupNode(ARGS90);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS90_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:526:83: ( ^( ARG st= statement ) )*
                loop15:
                do {
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==ARG) ) {
                        alt15=1;
                    }


                    switch (alt15) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:526:85: ^( ARG st= statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG91=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_call1647); 
                	    ARG91_tree = (CommonTree)adaptor.dupNode(ARG91);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG91_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_function_call1651);
                	    st=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_3, st.getTree());
                	     arguments.add((st!=null?st.op:null)); 

                	    match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
                	    }


                	    }
                	    break;

                	default :
                	    break loop15;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        if (!inBlock) { 
                            try {
                                retval.value = new Func(this.getFunction((ns!=null?ns.getText():null), (fn_name!=null?fn_name.getText():null)), arguments, this.context);
                            } catch(Exception e) {
                                this.context.writeError(e.getMessage());
                            }
                        }
                    

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_call"

    public static class atom_return extends TreeRuleReturnScope {
        public Atom value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:538:1: atom returns [Atom value] : ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | gpath_statement | NULL );
    public final GremlinEvaluator.atom_return atom() throws RecognitionException {
        GremlinEvaluator.atom_return retval = new GremlinEvaluator.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INT92=null;
        CommonTree G_INT93=null;
        CommonTree LONG94=null;
        CommonTree G_LONG95=null;
        CommonTree FLOAT96=null;
        CommonTree G_FLOAT97=null;
        CommonTree DOUBLE98=null;
        CommonTree G_DOUBLE99=null;
        CommonTree NULL101=null;
        GremlinEvaluator.gpath_statement_return gpath_statement100 = null;


        CommonTree INT92_tree=null;
        CommonTree G_INT93_tree=null;
        CommonTree LONG94_tree=null;
        CommonTree G_LONG95_tree=null;
        CommonTree FLOAT96_tree=null;
        CommonTree G_FLOAT97_tree=null;
        CommonTree DOUBLE98_tree=null;
        CommonTree G_DOUBLE99_tree=null;
        CommonTree NULL101_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:539:2: ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | gpath_statement | NULL )
            int alt16=6;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt16=1;
                }
                break;
            case LONG:
                {
                alt16=2;
                }
                break;
            case FLOAT:
                {
                alt16=3;
                }
                break;
            case DOUBLE:
                {
                alt16=4;
                }
                break;
            case GPATH:
                {
                alt16=5;
                }
                break;
            case NULL:
                {
                alt16=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:539:6: ^( INT G_INT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    INT92=(CommonTree)match(input,INT,FOLLOW_INT_in_atom1688); 
                    INT92_tree = (CommonTree)adaptor.dupNode(INT92);

                    root_1 = (CommonTree)adaptor.becomeRoot(INT92_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_INT93=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1690); 
                    G_INT93_tree = (CommonTree)adaptor.dupNode(G_INT93);

                    adaptor.addChild(root_1, G_INT93_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Integer>(new Integer((G_INT93!=null?G_INT93.getText():null))); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:540:6: ^( LONG G_LONG )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    LONG94=(CommonTree)match(input,LONG,FOLLOW_LONG_in_atom1748); 
                    LONG94_tree = (CommonTree)adaptor.dupNode(LONG94);

                    root_1 = (CommonTree)adaptor.becomeRoot(LONG94_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_LONG95=(CommonTree)match(input,G_LONG,FOLLOW_G_LONG_in_atom1750); 
                    G_LONG95_tree = (CommonTree)adaptor.dupNode(G_LONG95);

                    adaptor.addChild(root_1, G_LONG95_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String longStr = (G_LONG95!=null?G_LONG95.getText():null);
                    	                                                                    retval.value = new Atom<Long>(new Long(longStr.substring(0, longStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:544:6: ^( FLOAT G_FLOAT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    FLOAT96=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_atom1806); 
                    FLOAT96_tree = (CommonTree)adaptor.dupNode(FLOAT96);

                    root_1 = (CommonTree)adaptor.becomeRoot(FLOAT96_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_FLOAT97=(CommonTree)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_atom1808); 
                    G_FLOAT97_tree = (CommonTree)adaptor.dupNode(G_FLOAT97);

                    adaptor.addChild(root_1, G_FLOAT97_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Float>(new Float((G_FLOAT97!=null?G_FLOAT97.getText():null))); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:545:6: ^( DOUBLE G_DOUBLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    DOUBLE98=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_atom1862); 
                    DOUBLE98_tree = (CommonTree)adaptor.dupNode(DOUBLE98);

                    root_1 = (CommonTree)adaptor.becomeRoot(DOUBLE98_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_DOUBLE99=(CommonTree)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_atom1864); 
                    G_DOUBLE99_tree = (CommonTree)adaptor.dupNode(G_DOUBLE99);

                    adaptor.addChild(root_1, G_DOUBLE99_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String doubleStr = (G_DOUBLE99!=null?G_DOUBLE99.getText():null);
                    	                                                                    retval.value = new Atom<Double>(new Double(doubleStr.substring(0, doubleStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:549:9: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_atom1918);
                    gpath_statement100=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, gpath_statement100.getTree());
                     retval.value = (gpath_statement100!=null?gpath_statement100.value:null); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:550:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    NULL101=(CommonTree)match(input,NULL,FOLLOW_NULL_in_atom1974); 
                    NULL101_tree = (CommonTree)adaptor.dupNode(NULL101);

                    adaptor.addChild(root_0, NULL101_tree);

                     retval.value = new Atom<Object>(null); 

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_in_program68 = new BitSet(new long[]{0x00001047FC401892L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_NEWLINE_in_program72 = new BitSet(new long[]{0x00001047FC401892L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_if_statement_in_statement101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_step_definition_statement_in_statement212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_script_statement_in_statement262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_statement289 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_statement291 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_statement295 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_80_in_statement321 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement325 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_statement329 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_81_in_statement346 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement351 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_statement355 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_statement371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SCRIPT_in_script_statement417 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_script_statement419 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCLUDE_in_include_statement447 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement449 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NATIVE_STEP_in_native_step_definition_statement486 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_native_step_definition_statement490 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_block_in_native_step_definition_statement492 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GPATH_in_gpath_statement548 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_step_in_gpath_statement551 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_STEP_in_step589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_in_step592 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_step594 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREDICATES_in_step598 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PREDICATE_in_step603 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_step605 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOOPS_in_step616 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inline_loop_definition_in_step620 = new BitSet(new long[]{0x000000001C000008L});
    public static final BitSet FOLLOW_REPEAT_in_inline_loop_definition658 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_inline_loop_definition662 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_block_in_inline_loop_definition664 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_inline_loop_definition676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_inline_loop_definition679 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_inline_loop_definition683 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_inline_loop_definition686 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_inline_loop_definition698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_inline_loop_definition700 = new BitSet(new long[]{0x00001047FE401890L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_inline_loop_definition704 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_block_in_inline_loop_definition706 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_function_call_in_token732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_token759 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_token761 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLE_CALL_in_token777 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_token779 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_token790 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_token792 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_token805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_token872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_token885 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOLEAN_in_token889 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_statement_in_token897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_statement919 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_if_statement922 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_if_statement926 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_if_statement931 = new BitSet(new long[]{0x0000000000800008L});
    public static final BitSet FOLLOW_ELSE_in_if_statement936 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_if_statement940 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_while_statement973 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_while_statement976 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_while_statement980 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_while_statement983 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_statement1010 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement1012 = new BitSet(new long[]{0x00001047FE401890L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_foreach_statement1016 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_block_in_foreach_statement1018 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_repeat_statement1046 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_repeat_statement1050 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_block_in_repeat_statement1052 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_block1100 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block1106 = new BitSet(new long[]{0x00001047FC601898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_RETURN_in_block1113 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block1117 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_91_in_expression1160 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1165 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_expression1169 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_92_in_expression1183 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1187 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_expression1191 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_93_in_expression1205 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1210 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_expression1214 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_95_in_expression1228 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1233 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_expression1237 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_94_in_expression1251 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1255 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_expression1259 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_96_in_expression1273 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1277 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_expression1281 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_operation_in_expression1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_operation1339 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_operation1343 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_operation1347 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_98_in_operation1361 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_operation1365 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_operation1369 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binary_operation_in_operation1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_binary_operation1419 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_binary_operation1425 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_binary_operation1429 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_100_in_binary_operation1444 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_binary_operation1448 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_binary_operation1452 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_101_in_binary_operation1465 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_binary_operation1469 = new BitSet(new long[]{0x00001047FC401898L,0x0000003FF8030000L});
    public static final BitSet FOLLOW_statement_in_binary_operation1473 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_binary_operation1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_in_function_definition_statement1543 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_definition_statement1546 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_definition_statement1549 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1553 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_definition_statement1557 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1561 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_definition_statement1566 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_definition_statement1571 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_function_definition_statement1573 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_function_definition_statement1582 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_function_call1619 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_call1622 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_call1625 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1629 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_call1633 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1637 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_call1642 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_call1647 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_function_call1651 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_atom1688 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_INT_in_atom1690 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONG_in_atom1748 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_LONG_in_atom1750 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FLOAT_in_atom1806 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_FLOAT_in_atom1808 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLE_in_atom1862 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_DOUBLE_in_atom1864 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_gpath_statement_in_atom1918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_atom1974 = new BitSet(new long[]{0x0000000000000002L});

}
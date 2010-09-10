// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g 2010-09-10 21:04:25

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
    
    import com.tinkerpop.gremlin.compiler.pipes.GremlinPipesHelper;

    // util
    import com.tinkerpop.gremlin.compiler.util.Pair;
    import com.tinkerpop.gremlin.compiler.util.CodeBlock;

    import javax.script.ScriptContext;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class GremlinEvaluator extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "PATH", "GPATH", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "SELF", "HISTORY", "FUNC_CALL", "IF", "ELSE", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "SCRIPT", "INT", "LONG", "FLOAT", "DOUBLE", "STR", "ARR", "BOOL", "NULL", "RANGE", "PROPERTY_CALL", "VARIABLE_CALL", "COLLECTION_CALL", "COMMENT", "NEWLINE", "G_INT", "G_LONG", "G_FLOAT", "G_DOUBLE", "StringLiteral", "PROPERTY", "VARIABLE", "IDENTIFIER", "BOOLEAN", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "'/'", "'['", "']'", "'..'", "'('", "')'", "':='", "'and'", "'or'", "'include'", "'script'", "'if'", "'else'", "'end'", "'foreach'", "'in'", "'while'", "'repeat'", "'path'", "'func'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "'mod'", "':'"
    };
    public static final int WHILE=25;
    public static final int DecimalDigit=62;
    public static final int EOF=-1;
    public static final int FUNC_CALL=19;
    public static final int TOKEN=14;
    public static final int SingleStringCharacter=53;
    public static final int T__93=93;
    public static final int HISTORY=18;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int NAME=9;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int ARG=5;
    public static final int PATH=11;
    public static final int G_INT=43;
    public static final int INCLUDE=27;
    public static final int SingleEscapeCharacter=59;
    public static final int DOUBLE=32;
    public static final int ARGS=6;
    public static final int VAR=4;
    public static final int GPATH=12;
    public static final int COMMENT=41;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int SCRIPT=28;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int NS=8;
    public static final int NULL=36;
    public static final int ELSE=21;
    public static final int BOOL=35;
    public static final int INT=29;
    public static final int DoubleStringCharacter=52;
    public static final int ARR=34;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int T__71=71;
    public static final int WS=54;
    public static final int T__72=72;
    public static final int PREDICATES=16;
    public static final int VARIABLE=49;
    public static final int T__70=70;
    public static final int G_DOUBLE=46;
    public static final int PROPERTY=48;
    public static final int FUNC=7;
    public static final int G_LONG=44;
    public static final int FOREACH=24;
    public static final int REPEAT=26;
    public static final int FUNC_NAME=10;
    public static final int CharacterEscapeSequence=56;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int EscapeSequence=55;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int HexEscapeSequence=57;
    public static final int STEP=13;
    public static final int FLOAT=31;
    public static final int HexDigit=63;
    public static final int PREDICATE=15;
    public static final int IF=20;
    public static final int STR=33;
    public static final int BOOLEAN=51;
    public static final int IDENTIFIER=50;
    public static final int EscapeCharacter=61;
    public static final int COLLECTION_CALL=40;
    public static final int G_FLOAT=45;
    public static final int PROPERTY_CALL=38;
    public static final int UnicodeEscapeSequence=58;
    public static final int RANGE=37;
    public static final int StringLiteral=47;
    public static final int NEWLINE=42;
    public static final int BLOCK=23;
    public static final int NonEscapeCharacter=60;
    public static final int LONG=30;
    public static final int COND=22;
    public static final int SELF=17;
    public static final int VARIABLE_CALL=39;

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
        private int gpathScope = 0;

        private Pattern rangePattern = Pattern.compile("^(\\d+)..(\\d+)");

        private GremlinScriptContext context = new GremlinScriptContext();

        public GremlinEvaluator(final TreeNodeStream input, final GremlinScriptContext context) {
            this(input, new RecognizerSharedState());
            this.context = context;
        }

        private Atom getVariable(String name) {
            return new Atom(context.getBindings(ScriptContext.ENGINE_SCOPE).get(name));
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
            final PathLibrary paths = this.context.getPathLibrary();

            if (token instanceof DynamicEntity) {
                return token;
            } else if (token.isIdentifier() && paths.isPath(token.toString())) {
                pipes.addAll(paths.getPath(token.toString()));
                return this.getVariable(Tokens.ROOT_VARIABLE);
            } else {
                return token;
            }
        }

        private Atom<Object> singleGPathStep(final Atom<Object> token) {
            final PathLibrary paths = this.context.getPathLibrary();

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
                    return (gpathScope > 1) ? new Var(Tokens.ROOT_VARIABLE, this.context) : new RootVar(this.context);
                 } else if(paths.isPath(token.toString())) {
                    return new GPath(this.getVariable(Tokens.ROOT_VARIABLE), paths.getPath(token.toString()), this.context);
                } else {
                    return new Atom<Object>(null);
                }
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
                throw new RuntimeException(e);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:270:1: program returns [Iterable results] : ( statement ( NEWLINE )* )+ ;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:274:5: ( ( statement ( NEWLINE )* )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:274:7: ( statement ( NEWLINE )* )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:274:7: ( statement ( NEWLINE )* )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==VAR||LA2_0==FUNC||(LA2_0>=PATH && LA2_0<=GPATH)||LA2_0==IF||(LA2_0>=FOREACH && LA2_0<=DOUBLE)||LA2_0==NULL||(LA2_0>=71 && LA2_0<=72)||(LA2_0>=85 && LA2_0<=95)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:274:8: statement ( NEWLINE )*
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_program68);
            	    statement1=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement1.getTree());
            	     formProgramResult(resultList, (statement1!=null?statement1.op:null)); 
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:274:68: ( NEWLINE )*
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==NEWLINE) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:274:68: NEWLINE
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:280:1: statement returns [Operation op] : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | script_statement | ^( VAR atom s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression );
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

        GremlinEvaluator.path_definition_statement_return path_definition_statement7 = null;

        GremlinEvaluator.function_definition_statement_return function_definition_statement8 = null;

        GremlinEvaluator.include_statement_return include_statement9 = null;

        GremlinEvaluator.script_statement_return script_statement10 = null;

        GremlinEvaluator.atom_return atom12 = null;

        GremlinEvaluator.expression_return expression15 = null;


        CommonTree VAR11_tree=null;
        CommonTree string_literal13_tree=null;
        CommonTree string_literal14_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:281:2: ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | script_statement | ^( VAR atom s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression )
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
            case PATH:
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
            case 71:
                {
                alt3=10;
                }
                break;
            case 72:
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
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:281:4: if_statement
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:282:4: foreach_statement
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:283:7: while_statement
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:284:4: repeat_statement
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:285:4: path_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_definition_statement_in_statement212);
                    path_definition_statement7=path_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, path_definition_statement7.getTree());
                     retval.op = (path_definition_statement7!=null?path_definition_statement7.op:null); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:286:4: function_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_definition_statement_in_statement229);
                    function_definition_statement8=function_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, function_definition_statement8.getTree());
                     retval.op = (function_definition_statement8!=null?function_definition_statement8.op:null); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:287:4: include_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_include_statement_in_statement242);
                    include_statement9=include_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, include_statement9.getTree());
                     retval.op = new UnaryOperation((include_statement9!=null?include_statement9.result:null)); 

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:288:6: script_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_script_statement_in_statement269);
                    script_statement10=script_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, script_statement10.getTree());
                     retval.op = new UnaryOperation((script_statement10!=null?script_statement10.result:null)); 

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:289:4: ^( VAR atom s= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VAR11=(CommonTree)match(input,VAR,FOLLOW_VAR_in_statement296); 
                    VAR11_tree = (CommonTree)adaptor.dupNode(VAR11);

                    root_1 = (CommonTree)adaptor.becomeRoot(VAR11_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atom_in_statement298);
                    atom12=atom();

                    state._fsp--;

                    adaptor.addChild(root_1, atom12.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement302);
                    s=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, s.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new DeclareVariable((atom12!=null?atom12.value:null), (s!=null?s.op:null), this.context); 

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:290:9: ^( 'and' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal13=(CommonTree)match(input,71,FOLLOW_71_in_statement328); 
                    string_literal13_tree = (CommonTree)adaptor.dupNode(string_literal13);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal13_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement332);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement336);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new And((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:291:9: ^( 'or' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal14=(CommonTree)match(input,72,FOLLOW_72_in_statement353); 
                    string_literal14_tree = (CommonTree)adaptor.dupNode(string_literal14);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal14_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement358);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement362);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Or((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:292:9: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement378);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:295:1: script_statement returns [Atom result] : ^( SCRIPT StringLiteral ) ;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:296:5: ( ^( SCRIPT StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:296:7: ^( SCRIPT StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            SCRIPT16=(CommonTree)match(input,SCRIPT,FOLLOW_SCRIPT_in_script_statement424); 
            SCRIPT16_tree = (CommonTree)adaptor.dupNode(SCRIPT16);

            root_1 = (CommonTree)adaptor.becomeRoot(SCRIPT16_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            StringLiteral17=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_script_statement426); 
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
                            throw new RuntimeException(e.getMessage());
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:317:1: include_statement returns [Atom result] : ^( INCLUDE StringLiteral ) ;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:318:2: ( ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:318:4: ^( INCLUDE StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            INCLUDE18=(CommonTree)match(input,INCLUDE,FOLLOW_INCLUDE_in_include_statement454); 
            INCLUDE18_tree = (CommonTree)adaptor.dupNode(INCLUDE18);

            root_1 = (CommonTree)adaptor.becomeRoot(INCLUDE18_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            StringLiteral19=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement456); 
            StringLiteral19_tree = (CommonTree)adaptor.dupNode(StringLiteral19);

            adaptor.addChild(root_1, StringLiteral19_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.result = new Atom<Boolean>(true);

                        String className = (StringLiteral19!=null?StringLiteral19.getText():null);
                        try {
                            this.context.getFunctionLibrary().loadFunctions(className);
                        } catch(Exception e) {
                            this.context.writeError("Functions " + className + " do not exist");
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

    public static class path_definition_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "path_definition_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:334:1: path_definition_statement returns [Operation op] : ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) ;
    public final GremlinEvaluator.path_definition_statement_return path_definition_statement() throws RecognitionException {
        GremlinEvaluator.path_definition_statement_return retval = new GremlinEvaluator.path_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree path_name=null;
        CommonTree pr=null;
        CommonTree PATH20=null;
        CommonTree PROPERTY_CALL21=null;
        GremlinEvaluator.gpath_statement_return gpath = null;


        CommonTree path_name_tree=null;
        CommonTree pr_tree=null;
        CommonTree PATH20_tree=null;
        CommonTree PROPERTY_CALL21_tree=null;


                List<Pipe> pipes = new ArrayList<Pipe>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:338:2: ( ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:338:4: ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PATH20=(CommonTree)match(input,PATH,FOLLOW_PATH_in_path_definition_statement493); 
            PATH20_tree = (CommonTree)adaptor.dupNode(PATH20);

            root_1 = (CommonTree)adaptor.becomeRoot(PATH20_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            path_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_path_definition_statement497); 
            path_name_tree = (CommonTree)adaptor.dupNode(path_name);

            adaptor.addChild(root_1, path_name_tree);

            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:338:32: (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==GPATH) ) {
                alt4=1;
            }
            else if ( (LA4_0==PROPERTY_CALL) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:338:33: gpath= gpath_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_path_definition_statement502);
                    gpath=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_1, gpath.getTree());
                     pipes.addAll(((GPath) (gpath!=null?gpath.value:null)).getPipes()); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:338:110: ^( PROPERTY_CALL pr= PROPERTY )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    PROPERTY_CALL21=(CommonTree)match(input,PROPERTY_CALL,FOLLOW_PROPERTY_CALL_in_path_definition_statement509); 
                    PROPERTY_CALL21_tree = (CommonTree)adaptor.dupNode(PROPERTY_CALL21);

                    root_2 = (CommonTree)adaptor.becomeRoot(PROPERTY_CALL21_tree, root_2);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pr=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_path_definition_statement513); 
                    pr_tree = (CommonTree)adaptor.dupNode(pr);

                    adaptor.addChild(root_2, pr_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
                    }

                     pipes.add(new PropertyPipe((pr!=null?pr.getText():null).substring(1))); 

                    }
                    break;

            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        this.context.getPathLibrary().registerPath((path_name!=null?path_name.getText():null), pipes);
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
    // $ANTLR end "path_definition_statement"

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:346:1: gpath_statement returns [Atom value] : ^( GPATH ( step )+ ) ;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:360:2: ( ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:360:4: ^( GPATH ( step )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            GPATH22=(CommonTree)match(input,GPATH,FOLLOW_GPATH_in_gpath_statement572); 
            GPATH22_tree = (CommonTree)adaptor.dupNode(GPATH22);

            root_1 = (CommonTree)adaptor.becomeRoot(GPATH22_tree, root_1);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:360:12: ( step )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==STEP) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:360:13: step
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_step_in_gpath_statement575);
            	    step23=step();

            	    state._fsp--;

            	    adaptor.addChild(root_1, step23.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:376:1: step : ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) ;
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
        GremlinEvaluator.token_return token26 = null;

        GremlinEvaluator.statement_return statement29 = null;


        CommonTree STEP24_tree=null;
        CommonTree TOKEN25_tree=null;
        CommonTree PREDICATES27_tree=null;
        CommonTree PREDICATE28_tree=null;


                List<Operation> predicates = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:380:5: ( ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:380:7: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            STEP24=(CommonTree)match(input,STEP,FOLLOW_STEP_in_step613); 
            STEP24_tree = (CommonTree)adaptor.dupNode(STEP24);

            root_1 = (CommonTree)adaptor.becomeRoot(STEP24_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TOKEN25=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_step616); 
            TOKEN25_tree = (CommonTree)adaptor.dupNode(TOKEN25);

            root_2 = (CommonTree)adaptor.becomeRoot(TOKEN25_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_token_in_step618);
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
            PREDICATES27=(CommonTree)match(input,PREDICATES,FOLLOW_PREDICATES_in_step622); 
            PREDICATES27_tree = (CommonTree)adaptor.dupNode(PREDICATES27);

            root_2 = (CommonTree)adaptor.becomeRoot(PREDICATES27_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:380:42: ( ^( PREDICATE statement ) )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==PREDICATE) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:380:44: ^( PREDICATE statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    PREDICATE28=(CommonTree)match(input,PREDICATE,FOLLOW_PREDICATE_in_step627); 
                	    PREDICATE28_tree = (CommonTree)adaptor.dupNode(PREDICATE28);

                	    root_3 = (CommonTree)adaptor.becomeRoot(PREDICATE28_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_step629);
                	    statement29=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_3, statement29.getTree());
                	     predicates.add((statement29!=null?statement29.op:null)); 

                	    match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
                	    }


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

    public static class token_return extends TreeRuleReturnScope {
        public Atom atom;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "token"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:386:1: token returns [Atom atom] : ( function_call | ^( STR StringLiteral ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | '..' | ^( BOOL b= BOOLEAN ) | statement );
    public final GremlinEvaluator.token_return token() throws RecognitionException {
        GremlinEvaluator.token_return retval = new GremlinEvaluator.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree b=null;
        CommonTree STR31=null;
        CommonTree StringLiteral32=null;
        CommonTree VARIABLE_CALL33=null;
        CommonTree VARIABLE34=null;
        CommonTree PROPERTY_CALL35=null;
        CommonTree PROPERTY36=null;
        CommonTree IDENTIFIER37=null;
        CommonTree string_literal38=null;
        CommonTree BOOL39=null;
        GremlinEvaluator.function_call_return function_call30 = null;

        GremlinEvaluator.statement_return statement40 = null;


        CommonTree b_tree=null;
        CommonTree STR31_tree=null;
        CommonTree StringLiteral32_tree=null;
        CommonTree VARIABLE_CALL33_tree=null;
        CommonTree VARIABLE34_tree=null;
        CommonTree PROPERTY_CALL35_tree=null;
        CommonTree PROPERTY36_tree=null;
        CommonTree IDENTIFIER37_tree=null;
        CommonTree string_literal38_tree=null;
        CommonTree BOOL39_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:387:5: ( function_call | ^( STR StringLiteral ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | '..' | ^( BOOL b= BOOLEAN ) | statement )
            int alt7=8;
            switch ( input.LA(1) ) {
            case FUNC_CALL:
                {
                alt7=1;
                }
                break;
            case STR:
                {
                alt7=2;
                }
                break;
            case VARIABLE_CALL:
                {
                alt7=3;
                }
                break;
            case PROPERTY_CALL:
                {
                alt7=4;
                }
                break;
            case IDENTIFIER:
                {
                alt7=5;
                }
                break;
            case 67:
                {
                alt7=6;
                }
                break;
            case BOOL:
                {
                alt7=7;
                }
                break;
            case VAR:
            case FUNC:
            case PATH:
            case GPATH:
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
            case 71:
            case 72:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
                {
                alt7=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:387:9: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_call_in_token671);
                    function_call30=function_call();

                    state._fsp--;

                    adaptor.addChild(root_0, function_call30.getTree());
                     retval.atom = (function_call30!=null?function_call30.value:null); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:388:9: ^( STR StringLiteral )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    STR31=(CommonTree)match(input,STR,FOLLOW_STR_in_token698); 
                    STR31_tree = (CommonTree)adaptor.dupNode(STR31);

                    root_1 = (CommonTree)adaptor.becomeRoot(STR31_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    StringLiteral32=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_token700); 
                    StringLiteral32_tree = (CommonTree)adaptor.dupNode(StringLiteral32);

                    adaptor.addChild(root_1, StringLiteral32_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.atom = new Atom<String>((StringLiteral32!=null?StringLiteral32.getText():null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:389:4: ^( VARIABLE_CALL VARIABLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VARIABLE_CALL33=(CommonTree)match(input,VARIABLE_CALL,FOLLOW_VARIABLE_CALL_in_token716); 
                    VARIABLE_CALL33_tree = (CommonTree)adaptor.dupNode(VARIABLE_CALL33);

                    root_1 = (CommonTree)adaptor.becomeRoot(VARIABLE_CALL33_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VARIABLE34=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_token718); 
                    VARIABLE34_tree = (CommonTree)adaptor.dupNode(VARIABLE34);

                    adaptor.addChild(root_1, VARIABLE34_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.atom = (VARIABLE34!=null?VARIABLE34.getText():null).equals(Tokens.ROOT_VARIABLE) ? new RootVar(context) : new Var((VARIABLE34!=null?VARIABLE34.getText():null), this.context); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:390:4: ^( PROPERTY_CALL PROPERTY )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    PROPERTY_CALL35=(CommonTree)match(input,PROPERTY_CALL,FOLLOW_PROPERTY_CALL_in_token729); 
                    PROPERTY_CALL35_tree = (CommonTree)adaptor.dupNode(PROPERTY_CALL35);

                    root_1 = (CommonTree)adaptor.becomeRoot(PROPERTY_CALL35_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    PROPERTY36=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_token731); 
                    PROPERTY36_tree = (CommonTree)adaptor.dupNode(PROPERTY36);

                    adaptor.addChild(root_1, PROPERTY36_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.atom = new Prop<String>((PROPERTY36!=null?PROPERTY36.getText():null).substring(1)); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:391:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER37=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_token744); 
                    IDENTIFIER37_tree = (CommonTree)adaptor.dupNode(IDENTIFIER37);

                    adaptor.addChild(root_0, IDENTIFIER37_tree);


                                String idText = (IDENTIFIER37!=null?IDENTIFIER37.getText():null);
                                                                                            
                    	        if (idText.matches("^[\\d]+..[\\d]+")) {
                                        Matcher range = rangePattern.matcher(idText);
                                        retval.atom = (range.matches()) ? new Atom<Set>(this.createRange(range.group(1), range.group(2))) : new Atom<Object>(null);
                    	        } else {
                                        retval.atom = new Id<String>((IDENTIFIER37!=null?IDENTIFIER37.getText():null));
                                }
                            

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:402:6: '..'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal38=(CommonTree)match(input,67,FOLLOW_67_in_token811); 
                    string_literal38_tree = (CommonTree)adaptor.dupNode(string_literal38);

                    adaptor.addChild(root_0, string_literal38_tree);

                     retval.atom = new Id<String>(".."); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:403:9: ^( BOOL b= BOOLEAN )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    BOOL39=(CommonTree)match(input,BOOL,FOLLOW_BOOL_in_token824); 
                    BOOL39_tree = (CommonTree)adaptor.dupNode(BOOL39);

                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL39_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    b=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_token828); 
                    b_tree = (CommonTree)adaptor.dupNode(b);

                    adaptor.addChild(root_1, b_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.atom = new Atom<Boolean>(new Boolean((b!=null?b.getText():null))); 

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:404:4: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_token836);
                    statement40=statement();

                    state._fsp--;

                    adaptor.addChild(root_0, statement40.getTree());

                                try {
                                    retval.atom = (statement40!=null?statement40.op:null).compute();
                                } catch (Exception e) {
                                    retval.atom = new Atom<Operation>((statement40!=null?statement40.op:null));
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:414:1: if_statement returns [Operation op] : ^( IF ^( COND cond= statement ) if_block= block ( ^( ELSE else_block= block ) )? ) ;
    public final GremlinEvaluator.if_statement_return if_statement() throws RecognitionException {
        GremlinEvaluator.if_statement_return retval = new GremlinEvaluator.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IF41=null;
        CommonTree COND42=null;
        CommonTree ELSE43=null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return if_block = null;

        GremlinEvaluator.block_return else_block = null;


        CommonTree IF41_tree=null;
        CommonTree COND42_tree=null;
        CommonTree ELSE43_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:415:2: ( ^( IF ^( COND cond= statement ) if_block= block ( ^( ELSE else_block= block ) )? ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:415:4: ^( IF ^( COND cond= statement ) if_block= block ( ^( ELSE else_block= block ) )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            IF41=(CommonTree)match(input,IF,FOLLOW_IF_in_if_statement858); 
            IF41_tree = (CommonTree)adaptor.dupNode(IF41);

            root_1 = (CommonTree)adaptor.becomeRoot(IF41_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND42=(CommonTree)match(input,COND,FOLLOW_COND_in_if_statement861); 
            COND42_tree = (CommonTree)adaptor.dupNode(COND42);

            root_2 = (CommonTree)adaptor.becomeRoot(COND42_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_if_statement865);
            cond=statement();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_if_statement870);
            if_block=block();

            state._fsp--;

            adaptor.addChild(root_1, if_block.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:415:47: ( ^( ELSE else_block= block ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ELSE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:415:49: ^( ELSE else_block= block )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    ELSE43=(CommonTree)match(input,ELSE,FOLLOW_ELSE_in_if_statement875); 
                    ELSE43_tree = (CommonTree)adaptor.dupNode(ELSE43);

                    root_2 = (CommonTree)adaptor.becomeRoot(ELSE43_tree, root_2);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_block_in_if_statement879);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:421:1: while_statement returns [Operation op] : ^( WHILE ^( COND cond= statement ) block ) ;
    public final GremlinEvaluator.while_statement_return while_statement() throws RecognitionException {
        GremlinEvaluator.while_statement_return retval = new GremlinEvaluator.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree WHILE44=null;
        CommonTree COND45=null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return block46 = null;


        CommonTree WHILE44_tree=null;
        CommonTree COND45_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:422:2: ( ^( WHILE ^( COND cond= statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:422:4: ^( WHILE ^( COND cond= statement ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            WHILE44=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_while_statement912); 
            WHILE44_tree = (CommonTree)adaptor.dupNode(WHILE44);

            root_1 = (CommonTree)adaptor.becomeRoot(WHILE44_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND45=(CommonTree)match(input,COND,FOLLOW_COND_in_while_statement915); 
            COND45_tree = (CommonTree)adaptor.dupNode(COND45);

            root_2 = (CommonTree)adaptor.becomeRoot(COND45_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_while_statement919);
            cond=statement();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_while_statement922);
            block46=block();

            state._fsp--;

            adaptor.addChild(root_1, block46.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new While((cond!=null?cond.op:null), (block46!=null?block46.cb:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:428:1: foreach_statement returns [Operation op] : ^( FOREACH VARIABLE arr= statement block ) ;
    public final GremlinEvaluator.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinEvaluator.foreach_statement_return retval = new GremlinEvaluator.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH47=null;
        CommonTree VARIABLE48=null;
        GremlinEvaluator.statement_return arr = null;

        GremlinEvaluator.block_return block49 = null;


        CommonTree FOREACH47_tree=null;
        CommonTree VARIABLE48_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:429:2: ( ^( FOREACH VARIABLE arr= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:429:4: ^( FOREACH VARIABLE arr= statement block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FOREACH47=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_statement949); 
            FOREACH47_tree = (CommonTree)adaptor.dupNode(FOREACH47);

            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH47_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            VARIABLE48=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement951); 
            VARIABLE48_tree = (CommonTree)adaptor.dupNode(VARIABLE48);

            adaptor.addChild(root_1, VARIABLE48_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_foreach_statement955);
            arr=statement();

            state._fsp--;

            adaptor.addChild(root_1, arr.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_foreach_statement957);
            block49=block();

            state._fsp--;

            adaptor.addChild(root_1, block49.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Foreach((VARIABLE48!=null?VARIABLE48.getText():null), (arr!=null?arr.op:null), (block49!=null?block49.cb:null), this.context);
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:435:1: repeat_statement returns [Operation op] : ^( REPEAT timer= statement block ) ;
    public final GremlinEvaluator.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinEvaluator.repeat_statement_return retval = new GremlinEvaluator.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REPEAT50=null;
        GremlinEvaluator.statement_return timer = null;

        GremlinEvaluator.block_return block51 = null;


        CommonTree REPEAT50_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:436:2: ( ^( REPEAT timer= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:436:4: ^( REPEAT timer= statement block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            REPEAT50=(CommonTree)match(input,REPEAT,FOLLOW_REPEAT_in_repeat_statement985); 
            REPEAT50_tree = (CommonTree)adaptor.dupNode(REPEAT50);

            root_1 = (CommonTree)adaptor.becomeRoot(REPEAT50_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_repeat_statement989);
            timer=statement();

            state._fsp--;

            adaptor.addChild(root_1, timer.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_repeat_statement991);
            block51=block();

            state._fsp--;

            adaptor.addChild(root_1, block51.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Repeat((timer!=null?timer.op:null), (block51!=null?block51.cb:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:442:1: block returns [CodeBlock cb] : ^( BLOCK ( statement )+ ) ;
    public final GremlinEvaluator.block_return block() throws RecognitionException {
        GremlinEvaluator.block_return retval = new GremlinEvaluator.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BLOCK52=null;
        GremlinEvaluator.statement_return statement53 = null;


        CommonTree BLOCK52_tree=null;


                List<Tree> statements = new LinkedList<Tree>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:446:5: ( ^( BLOCK ( statement )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:446:7: ^( BLOCK ( statement )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            BLOCK52=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_block1030); 
            BLOCK52_tree = (CommonTree)adaptor.dupNode(BLOCK52);

            root_1 = (CommonTree)adaptor.becomeRoot(BLOCK52_tree, root_1);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:446:15: ( statement )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==VAR||LA9_0==FUNC||(LA9_0>=PATH && LA9_0<=GPATH)||LA9_0==IF||(LA9_0>=FOREACH && LA9_0<=DOUBLE)||LA9_0==NULL||(LA9_0>=71 && LA9_0<=72)||(LA9_0>=85 && LA9_0<=95)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:446:17: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_block1034);
            	    statement53=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_1, statement53.getTree());
            	     statements.add((statement53!=null?((CommonTree)statement53.tree):null)); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

             retval.cb = new CodeBlock(statements, this.context); 

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
    // $ANTLR end "block"

    public static class expression_return extends TreeRuleReturnScope {
        public Operation expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:449:1: expression returns [Operation expr] : ( ^( '=' a= statement b= statement ) | ^( '!=' a= statement b= statement ) | ^( '<' a= statement b= statement ) | ^( '>' a= statement b= statement ) | ^( '<=' a= statement b= statement ) | ^( '>=' a= statement b= statement ) | operation );
    public final GremlinEvaluator.expression_return expression() throws RecognitionException {
        GremlinEvaluator.expression_return retval = new GremlinEvaluator.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal54=null;
        CommonTree string_literal55=null;
        CommonTree char_literal56=null;
        CommonTree char_literal57=null;
        CommonTree string_literal58=null;
        CommonTree string_literal59=null;
        GremlinEvaluator.statement_return a = null;

        GremlinEvaluator.statement_return b = null;

        GremlinEvaluator.operation_return operation60 = null;


        CommonTree char_literal54_tree=null;
        CommonTree string_literal55_tree=null;
        CommonTree char_literal56_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree string_literal58_tree=null;
        CommonTree string_literal59_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:450:5: ( ^( '=' a= statement b= statement ) | ^( '!=' a= statement b= statement ) | ^( '<' a= statement b= statement ) | ^( '>' a= statement b= statement ) | ^( '<=' a= statement b= statement ) | ^( '>=' a= statement b= statement ) | operation )
            int alt10=7;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt10=1;
                }
                break;
            case 86:
                {
                alt10=2;
                }
                break;
            case 87:
                {
                alt10=3;
                }
                break;
            case 89:
                {
                alt10=4;
                }
                break;
            case 88:
                {
                alt10=5;
                }
                break;
            case 90:
                {
                alt10=6;
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
                {
                alt10=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:450:9: ^( '=' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,85,FOLLOW_85_in_expression1066); 
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal54_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1071);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1075);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new Equality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:451:9: ^( '!=' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal55=(CommonTree)match(input,86,FOLLOW_86_in_expression1089); 
                    string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal55_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1093);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1097);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new UnEquality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:452:9: ^( '<' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal56=(CommonTree)match(input,87,FOLLOW_87_in_expression1111); 
                    char_literal56_tree = (CommonTree)adaptor.dupNode(char_literal56);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal56_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1116);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1120);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:453:9: ^( '>' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal57=(CommonTree)match(input,89,FOLLOW_89_in_expression1134); 
                    char_literal57_tree = (CommonTree)adaptor.dupNode(char_literal57);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal57_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1139);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1143);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:454:9: ^( '<=' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal58=(CommonTree)match(input,88,FOLLOW_88_in_expression1157); 
                    string_literal58_tree = (CommonTree)adaptor.dupNode(string_literal58);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal58_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1161);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1165);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:455:9: ^( '>=' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal59=(CommonTree)match(input,90,FOLLOW_90_in_expression1179); 
                    string_literal59_tree = (CommonTree)adaptor.dupNode(string_literal59);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal59_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1183);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_expression1187);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:456:9: operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression1200);
                    operation60=operation();

                    state._fsp--;

                    adaptor.addChild(root_0, operation60.getTree());
                     retval.expr = (operation60!=null?operation60.op:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:459:1: operation returns [Operation op] : ( ^( '+' a= statement b= statement ) | ^( '-' a= statement b= statement ) | binary_operation );
    public final GremlinEvaluator.operation_return operation() throws RecognitionException {
        GremlinEvaluator.operation_return retval = new GremlinEvaluator.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal61=null;
        CommonTree char_literal62=null;
        GremlinEvaluator.statement_return a = null;

        GremlinEvaluator.statement_return b = null;

        GremlinEvaluator.binary_operation_return binary_operation63 = null;


        CommonTree char_literal61_tree=null;
        CommonTree char_literal62_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:460:5: ( ^( '+' a= statement b= statement ) | ^( '-' a= statement b= statement ) | binary_operation )
            int alt11=3;
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
            case GPATH:
            case INT:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case NULL:
            case 93:
            case 94:
            case 95:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:460:9: ^( '+' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal61=(CommonTree)match(input,91,FOLLOW_91_in_operation1245); 
                    char_literal61_tree = (CommonTree)adaptor.dupNode(char_literal61);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal61_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_operation1249);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_operation1253);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Addition((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:461:9: ^( '-' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal62=(CommonTree)match(input,92,FOLLOW_92_in_operation1267); 
                    char_literal62_tree = (CommonTree)adaptor.dupNode(char_literal62);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal62_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_operation1271);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_operation1275);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Subtraction((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:462:9: binary_operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_binary_operation_in_operation1288);
                    binary_operation63=binary_operation();

                    state._fsp--;

                    adaptor.addChild(root_0, binary_operation63.getTree());
                     retval.op = (binary_operation63!=null?binary_operation63.operation:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:465:1: binary_operation returns [Operation operation] : ( ^( '*' a= statement b= statement ) | ^( 'div' a= statement b= statement ) | ^( 'mod' a= statement b= statement ) | atom );
    public final GremlinEvaluator.binary_operation_return binary_operation() throws RecognitionException {
        GremlinEvaluator.binary_operation_return retval = new GremlinEvaluator.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal64=null;
        CommonTree string_literal65=null;
        CommonTree string_literal66=null;
        GremlinEvaluator.statement_return a = null;

        GremlinEvaluator.statement_return b = null;

        GremlinEvaluator.atom_return atom67 = null;


        CommonTree char_literal64_tree=null;
        CommonTree string_literal65_tree=null;
        CommonTree string_literal66_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:466:5: ( ^( '*' a= statement b= statement ) | ^( 'div' a= statement b= statement ) | ^( 'mod' a= statement b= statement ) | atom )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt12=1;
                }
                break;
            case 94:
                {
                alt12=2;
                }
                break;
            case 95:
                {
                alt12=3;
                }
                break;
            case GPATH:
            case INT:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case NULL:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:466:9: ^( '*' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal64=(CommonTree)match(input,93,FOLLOW_93_in_binary_operation1325); 
                    char_literal64_tree = (CommonTree)adaptor.dupNode(char_literal64);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal64_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1331);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1335);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Multiplication((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:467:9: ^( 'div' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal65=(CommonTree)match(input,94,FOLLOW_94_in_binary_operation1350); 
                    string_literal65_tree = (CommonTree)adaptor.dupNode(string_literal65);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal65_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1354);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1358);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Division((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:468:7: ^( 'mod' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal66=(CommonTree)match(input,95,FOLLOW_95_in_binary_operation1371); 
                    string_literal66_tree = (CommonTree)adaptor.dupNode(string_literal66);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal66_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1375);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_binary_operation1379);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Modulo((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:469:9: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atom_in_binary_operation1393);
                    atom67=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom67.getTree());
                     retval.operation = new UnaryOperation((atom67!=null?atom67.value:null)); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:472:1: function_definition_statement returns [Operation op] : ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) ;
    public final GremlinEvaluator.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinEvaluator.function_definition_statement_return retval = new GremlinEvaluator.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC68=null;
        CommonTree FUNC_NAME69=null;
        CommonTree NS70=null;
        CommonTree NAME71=null;
        CommonTree ARGS72=null;
        CommonTree ARG73=null;
        CommonTree VARIABLE74=null;
        GremlinEvaluator.block_return block75 = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC68_tree=null;
        CommonTree FUNC_NAME69_tree=null;
        CommonTree NS70_tree=null;
        CommonTree NAME71_tree=null;
        CommonTree ARGS72_tree=null;
        CommonTree ARG73_tree=null;
        CommonTree VARIABLE74_tree=null;


                List<String> params = new ArrayList<String>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:476:2: ( ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:476:4: ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC68=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_function_definition_statement1449); 
            FUNC68_tree = (CommonTree)adaptor.dupNode(FUNC68);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC68_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME69=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_definition_statement1452); 
            FUNC_NAME69_tree = (CommonTree)adaptor.dupNode(FUNC_NAME69);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME69_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS70=(CommonTree)match(input,NS,FOLLOW_NS_in_function_definition_statement1455); 
            NS70_tree = (CommonTree)adaptor.dupNode(NS70);

            root_3 = (CommonTree)adaptor.becomeRoot(NS70_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1459); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME71=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_definition_statement1463); 
            NAME71_tree = (CommonTree)adaptor.dupNode(NAME71);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME71_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1467); 
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
            ARGS72=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_definition_statement1472); 
            ARGS72_tree = (CommonTree)adaptor.dupNode(ARGS72);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS72_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:476:78: ( ^( ARG VARIABLE ) )*
                loop13:
                do {
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==ARG) ) {
                        alt13=1;
                    }


                    switch (alt13) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:476:80: ^( ARG VARIABLE )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG73=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_definition_statement1477); 
                	    ARG73_tree = (CommonTree)adaptor.dupNode(ARG73);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG73_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    VARIABLE74=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_function_definition_statement1479); 
                	    VARIABLE74_tree = (CommonTree)adaptor.dupNode(VARIABLE74);

                	    adaptor.addChild(root_3, VARIABLE74_tree);

                	     params.add((VARIABLE74!=null?VARIABLE74.getText():null)); 

                	    match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
                	    }


                	    }
                	    break;

                	default :
                	    break loop13;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_function_definition_statement1488);
            block75=block();

            state._fsp--;

            adaptor.addChild(root_1, block75.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        NativeFunction fn = new NativeFunction((fn_name!=null?fn_name.getText():null), params, (block75!=null?block75.cb:null));
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:485:1: function_call returns [Atom value] : ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) ;
    public final GremlinEvaluator.function_call_return function_call() throws RecognitionException {
        GremlinEvaluator.function_call_return retval = new GremlinEvaluator.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC_CALL76=null;
        CommonTree FUNC_NAME77=null;
        CommonTree NS78=null;
        CommonTree NAME79=null;
        CommonTree ARGS80=null;
        CommonTree ARG81=null;
        GremlinEvaluator.statement_return st = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC_CALL76_tree=null;
        CommonTree FUNC_NAME77_tree=null;
        CommonTree NS78_tree=null;
        CommonTree NAME79_tree=null;
        CommonTree ARGS80_tree=null;
        CommonTree ARG81_tree=null;


                List<Operation> arguments = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:489:2: ( ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:489:4: ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_CALL76=(CommonTree)match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_function_call1525); 
            FUNC_CALL76_tree = (CommonTree)adaptor.dupNode(FUNC_CALL76);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_CALL76_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME77=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_call1528); 
            FUNC_NAME77_tree = (CommonTree)adaptor.dupNode(FUNC_NAME77);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME77_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS78=(CommonTree)match(input,NS,FOLLOW_NS_in_function_call1531); 
            NS78_tree = (CommonTree)adaptor.dupNode(NS78);

            root_3 = (CommonTree)adaptor.becomeRoot(NS78_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1535); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME79=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_call1539); 
            NAME79_tree = (CommonTree)adaptor.dupNode(NAME79);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME79_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1543); 
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
            ARGS80=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_call1548); 
            ARGS80_tree = (CommonTree)adaptor.dupNode(ARGS80);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS80_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:489:83: ( ^( ARG st= statement ) )*
                loop14:
                do {
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==ARG) ) {
                        alt14=1;
                    }


                    switch (alt14) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:489:85: ^( ARG st= statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG81=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_call1553); 
                	    ARG81_tree = (CommonTree)adaptor.dupNode(ARG81);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG81_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_function_call1557);
                	    st=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_3, st.getTree());
                	     arguments.add((st!=null?st.op:null)); 

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


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        try {
                            retval.value = new Func(this.getFunction((ns!=null?ns.getText():null), (fn_name!=null?fn_name.getText():null)), arguments, this.context);
                        } catch(Exception e) {
                            this.context.writeError(e.getMessage());
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:499:1: atom returns [Atom value] : ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | gpath_statement | NULL );
    public final GremlinEvaluator.atom_return atom() throws RecognitionException {
        GremlinEvaluator.atom_return retval = new GremlinEvaluator.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INT82=null;
        CommonTree G_INT83=null;
        CommonTree LONG84=null;
        CommonTree G_LONG85=null;
        CommonTree FLOAT86=null;
        CommonTree G_FLOAT87=null;
        CommonTree DOUBLE88=null;
        CommonTree G_DOUBLE89=null;
        CommonTree NULL91=null;
        GremlinEvaluator.gpath_statement_return gpath_statement90 = null;


        CommonTree INT82_tree=null;
        CommonTree G_INT83_tree=null;
        CommonTree LONG84_tree=null;
        CommonTree G_LONG85_tree=null;
        CommonTree FLOAT86_tree=null;
        CommonTree G_FLOAT87_tree=null;
        CommonTree DOUBLE88_tree=null;
        CommonTree G_DOUBLE89_tree=null;
        CommonTree NULL91_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:500:2: ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | gpath_statement | NULL )
            int alt15=6;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt15=1;
                }
                break;
            case LONG:
                {
                alt15=2;
                }
                break;
            case FLOAT:
                {
                alt15=3;
                }
                break;
            case DOUBLE:
                {
                alt15=4;
                }
                break;
            case GPATH:
                {
                alt15=5;
                }
                break;
            case NULL:
                {
                alt15=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:500:6: ^( INT G_INT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    INT82=(CommonTree)match(input,INT,FOLLOW_INT_in_atom1594); 
                    INT82_tree = (CommonTree)adaptor.dupNode(INT82);

                    root_1 = (CommonTree)adaptor.becomeRoot(INT82_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_INT83=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1596); 
                    G_INT83_tree = (CommonTree)adaptor.dupNode(G_INT83);

                    adaptor.addChild(root_1, G_INT83_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Integer>(new Integer((G_INT83!=null?G_INT83.getText():null))); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:501:6: ^( LONG G_LONG )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    LONG84=(CommonTree)match(input,LONG,FOLLOW_LONG_in_atom1654); 
                    LONG84_tree = (CommonTree)adaptor.dupNode(LONG84);

                    root_1 = (CommonTree)adaptor.becomeRoot(LONG84_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_LONG85=(CommonTree)match(input,G_LONG,FOLLOW_G_LONG_in_atom1656); 
                    G_LONG85_tree = (CommonTree)adaptor.dupNode(G_LONG85);

                    adaptor.addChild(root_1, G_LONG85_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String longStr = (G_LONG85!=null?G_LONG85.getText():null);
                    	                                                                    retval.value = new Atom<Long>(new Long(longStr.substring(0, longStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:505:6: ^( FLOAT G_FLOAT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    FLOAT86=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_atom1712); 
                    FLOAT86_tree = (CommonTree)adaptor.dupNode(FLOAT86);

                    root_1 = (CommonTree)adaptor.becomeRoot(FLOAT86_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_FLOAT87=(CommonTree)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_atom1714); 
                    G_FLOAT87_tree = (CommonTree)adaptor.dupNode(G_FLOAT87);

                    adaptor.addChild(root_1, G_FLOAT87_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Float>(new Float((G_FLOAT87!=null?G_FLOAT87.getText():null))); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:506:6: ^( DOUBLE G_DOUBLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    DOUBLE88=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_atom1768); 
                    DOUBLE88_tree = (CommonTree)adaptor.dupNode(DOUBLE88);

                    root_1 = (CommonTree)adaptor.becomeRoot(DOUBLE88_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_DOUBLE89=(CommonTree)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_atom1770); 
                    G_DOUBLE89_tree = (CommonTree)adaptor.dupNode(G_DOUBLE89);

                    adaptor.addChild(root_1, G_DOUBLE89_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String doubleStr = (G_DOUBLE89!=null?G_DOUBLE89.getText():null);
                    	                                                                    retval.value = new Atom<Double>(new Double(doubleStr.substring(0, doubleStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:510:9: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_atom1824);
                    gpath_statement90=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, gpath_statement90.getTree());
                     retval.value = (gpath_statement90!=null?gpath_statement90.value:null); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:511:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    NULL91=(CommonTree)match(input,NULL,FOLLOW_NULL_in_atom1880); 
                    NULL91_tree = (CommonTree)adaptor.dupNode(NULL91);

                    adaptor.addChild(root_0, NULL91_tree);

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


 

    public static final BitSet FOLLOW_statement_in_program68 = new BitSet(new long[]{0x00000411FF101892L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_NEWLINE_in_program72 = new BitSet(new long[]{0x00000411FF101892L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_if_statement_in_statement101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_definition_statement_in_statement212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_script_statement_in_statement269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_statement296 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_statement298 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_statement302 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_71_in_statement328 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement332 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_statement336 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_72_in_statement353 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement358 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_statement362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_statement378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SCRIPT_in_script_statement424 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_script_statement426 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCLUDE_in_include_statement454 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement456 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PATH_in_path_definition_statement493 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_path_definition_statement497 = new BitSet(new long[]{0x0000004000001000L});
    public static final BitSet FOLLOW_gpath_statement_in_path_definition_statement502 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_path_definition_statement509 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_path_definition_statement513 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GPATH_in_gpath_statement572 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_step_in_gpath_statement575 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_STEP_in_step613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_in_step616 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_step618 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREDICATES_in_step622 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PREDICATE_in_step627 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_step629 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_function_call_in_token671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_in_token698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_token700 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VARIABLE_CALL_in_token716 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_token718 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_token729 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_token731 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_token744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_token811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_token824 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOLEAN_in_token828 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_statement_in_token836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_statement858 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_if_statement861 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_if_statement865 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_if_statement870 = new BitSet(new long[]{0x0000000000200008L});
    public static final BitSet FOLLOW_ELSE_in_if_statement875 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_if_statement879 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_while_statement912 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_while_statement915 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_while_statement919 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_while_statement922 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_statement949 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement951 = new BitSet(new long[]{0x00000411FF901890L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_foreach_statement955 = new BitSet(new long[]{0x00000411FF901890L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_block_in_foreach_statement957 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_repeat_statement985 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_repeat_statement989 = new BitSet(new long[]{0x00000411FF901890L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_block_in_repeat_statement991 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_block1030 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block1034 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_85_in_expression1066 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1071 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_expression1075 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_86_in_expression1089 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1093 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_expression1097 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_87_in_expression1111 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1116 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_expression1120 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_89_in_expression1134 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1139 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_expression1143 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_88_in_expression1157 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1161 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_expression1165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_90_in_expression1179 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_expression1183 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_expression1187 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_operation_in_expression1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_operation1245 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_operation1249 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_operation1253 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_92_in_operation1267 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_operation1271 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_operation1275 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binary_operation_in_operation1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_binary_operation1325 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_binary_operation1331 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_binary_operation1335 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_94_in_binary_operation1350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_binary_operation1354 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_binary_operation1358 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_95_in_binary_operation1371 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_binary_operation1375 = new BitSet(new long[]{0x00000411FF101898L,0x00000000FFE00180L});
    public static final BitSet FOLLOW_statement_in_binary_operation1379 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_binary_operation1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_in_function_definition_statement1449 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_definition_statement1452 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_definition_statement1455 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1459 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_definition_statement1463 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1467 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_definition_statement1472 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_definition_statement1477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_function_definition_statement1479 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_function_definition_statement1488 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_function_call1525 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_call1528 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_call1531 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1535 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_call1539 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1543 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_call1548 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_call1553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_function_call1557 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_atom1594 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_INT_in_atom1596 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONG_in_atom1654 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_LONG_in_atom1656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FLOAT_in_atom1712 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_FLOAT_in_atom1714 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLE_in_atom1768 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_DOUBLE_in_atom1770 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_gpath_statement_in_atom1824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_atom1880 = new BitSet(new long[]{0x0000000000000002L});

}
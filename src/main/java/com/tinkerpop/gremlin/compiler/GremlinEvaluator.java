// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g 2010-07-08 15:59:02

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
    //import com.tinkerpop.pipes.filter.OrFilterPipe;
    import com.tinkerpop.pipes.filter.FilterPipe;
    //import com.tinkerpop.pipes.util.HasNextPipe;
    import com.tinkerpop.pipes.filter.FutureFilterPipe;
    
    import com.tinkerpop.gremlin.compiler.pipes.GremlinPipesHelper;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class GremlinEvaluator extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "PATH", "GPATH", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "SELF", "HISTORY", "FUNC_CALL", "IF", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "INT", "LONG", "FLOAT", "DOUBLE", "STR", "ARR", "BOOL", "NULL", "RANGE", "PROPERTY_CALL", "VARIABLE_CALL", "COLLECTION_CALL", "COMMENT", "NEWLINE", "VARIABLE", "StringLiteral", "IDENTIFIER", "G_INT", "G_LONG", "G_FLOAT", "G_DOUBLE", "BOOLEAN", "PROPERTY", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "'/'", "'['", "']'", "'..'", "':='", "'and'", "'or'", "'include'", "'if'", "'end'", "'foreach'", "'in'", "'while'", "'repeat'", "'path'", "'func'", "'('", "')'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "':'", "NUMBER"
    };
    public static final int WHILE=24;
    public static final int DecimalDigit=60;
    public static final int EOF=-1;
    public static final int FUNC_CALL=19;
    public static final int TOKEN=14;
    public static final int SingleStringCharacter=51;
    public static final int HISTORY=18;
    public static final int T__91=91;
    public static final int NAME=9;
    public static final int T__90=90;
    public static final int ARG=5;
    public static final int PATH=11;
    public static final int G_INT=44;
    public static final int INCLUDE=26;
    public static final int SingleEscapeCharacter=57;
    public static final int ARGS=6;
    public static final int DOUBLE=30;
    public static final int VAR=4;
    public static final int GPATH=12;
    public static final int COMMENT=39;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int NS=8;
    public static final int NULL=34;
    public static final int NUMBER=92;
    public static final int BOOL=33;
    public static final int INT=27;
    public static final int DoubleStringCharacter=50;
    public static final int ARR=32;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int WS=52;
    public static final int T__71=71;
    public static final int PREDICATES=16;
    public static final int T__72=72;
    public static final int VARIABLE=41;
    public static final int T__70=70;
    public static final int G_DOUBLE=47;
    public static final int PROPERTY=49;
    public static final int FUNC=7;
    public static final int G_LONG=45;
    public static final int FOREACH=23;
    public static final int REPEAT=25;
    public static final int FUNC_NAME=10;
    public static final int CharacterEscapeSequence=54;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int EscapeSequence=53;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int HexEscapeSequence=55;
    public static final int STEP=13;
    public static final int FLOAT=29;
    public static final int HexDigit=61;
    public static final int PREDICATE=15;
    public static final int IF=20;
    public static final int STR=31;
    public static final int BOOLEAN=48;
    public static final int IDENTIFIER=43;
    public static final int EscapeCharacter=59;
    public static final int COLLECTION_CALL=38;
    public static final int G_FLOAT=46;
    public static final int PROPERTY_CALL=36;
    public static final int UnicodeEscapeSequence=56;
    public static final int RANGE=35;
    public static final int StringLiteral=42;
    public static final int NEWLINE=40;
    public static final int BLOCK=22;
    public static final int NonEscapeCharacter=58;
    public static final int COND=21;
    public static final int LONG=28;
    public static final int SELF=17;
    public static final int VARIABLE_CALL=37;

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
        }


    public static class program_return extends TreeRuleReturnScope {
        public Iterable results;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:116:1: program returns [Iterable results] : ( ( statement | collection ) ( NEWLINE )* )+ ;
    public final GremlinEvaluator.program_return program() throws RecognitionException {
        GremlinEvaluator.program_return retval = new GremlinEvaluator.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NEWLINE3=null;
        GremlinEvaluator.statement_return statement1 = null;

        GremlinEvaluator.collection_return collection2 = null;


        CommonTree NEWLINE3_tree=null;


                List<Object> resultList = new ArrayList<Object>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:120:5: ( ( ( statement | collection ) ( NEWLINE )* )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:120:7: ( ( statement | collection ) ( NEWLINE )* )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:120:7: ( ( statement | collection ) ( NEWLINE )* )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==VAR||LA3_0==FUNC||(LA3_0>=PATH && LA3_0<=GPATH)||(LA3_0>=FUNC_CALL && LA3_0<=IF)||(LA3_0>=FOREACH && LA3_0<=COLLECTION_CALL)||LA3_0==IDENTIFIER||(LA3_0>=67 && LA3_0<=68)||LA3_0==78||(LA3_0>=81 && LA3_0<=90)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:120:8: ( statement | collection ) ( NEWLINE )*
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:120:8: ( statement | collection )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==VAR||LA1_0==FUNC||(LA1_0>=PATH && LA1_0<=GPATH)||(LA1_0>=FUNC_CALL && LA1_0<=IF)||(LA1_0>=FOREACH && LA1_0<=VARIABLE_CALL)||LA1_0==IDENTIFIER||(LA1_0>=67 && LA1_0<=68)||LA1_0==78||(LA1_0>=81 && LA1_0<=90)) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==COLLECTION_CALL) ) {
            	        alt1=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:120:9: statement
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            pushFollow(FOLLOW_statement_in_program60);
            	            statement1=statement();

            	            state._fsp--;

            	            adaptor.addChild(root_0, statement1.getTree());

            	                    formProgramResult(resultList, (statement1!=null?statement1.op:null));
            	                 

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:10: collection
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            pushFollow(FOLLOW_collection_in_program71);
            	            collection2=collection();

            	            state._fsp--;

            	            adaptor.addChild(root_0, collection2.getTree());

            	                    formProgramResult(resultList, (collection2!=null?collection2.op:null));
            	                 

            	            }
            	            break;

            	    }

            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:125:9: ( NEWLINE )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==NEWLINE) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:125:9: NEWLINE
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    NEWLINE3=(CommonTree)match(input,NEWLINE,FOLLOW_NEWLINE_in_program76); 
            	    	    NEWLINE3_tree = (CommonTree)adaptor.dupNode(NEWLINE3);

            	    	    adaptor.addChild(root_0, NEWLINE3_tree);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:131:1: statement returns [Operation op] : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | ^( VAR VARIABLE s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression );
    public final GremlinEvaluator.statement_return statement() throws RecognitionException {
        GremlinEvaluator.statement_return retval = new GremlinEvaluator.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree VAR12=null;
        CommonTree VARIABLE13=null;
        CommonTree string_literal14=null;
        CommonTree string_literal15=null;
        GremlinEvaluator.statement_return s = null;

        GremlinEvaluator.statement_return a = null;

        GremlinEvaluator.statement_return b = null;

        GremlinEvaluator.if_statement_return if_statement4 = null;

        GremlinEvaluator.foreach_statement_return foreach_statement5 = null;

        GremlinEvaluator.while_statement_return while_statement6 = null;

        GremlinEvaluator.repeat_statement_return repeat_statement7 = null;

        GremlinEvaluator.path_definition_statement_return path_definition_statement8 = null;

        GremlinEvaluator.function_definition_statement_return function_definition_statement9 = null;

        GremlinEvaluator.include_statement_return include_statement10 = null;

        GremlinEvaluator.gpath_statement_return gpath_statement11 = null;

        GremlinEvaluator.expression_return expression16 = null;


        CommonTree VAR12_tree=null;
        CommonTree VARIABLE13_tree=null;
        CommonTree string_literal14_tree=null;
        CommonTree string_literal15_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:132:2: ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | ^( VAR VARIABLE s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression )
            int alt4=12;
            switch ( input.LA(1) ) {
            case IF:
                {
                alt4=1;
                }
                break;
            case FOREACH:
                {
                alt4=2;
                }
                break;
            case WHILE:
                {
                alt4=3;
                }
                break;
            case REPEAT:
                {
                alt4=4;
                }
                break;
            case PATH:
                {
                alt4=5;
                }
                break;
            case FUNC:
                {
                alt4=6;
                }
                break;
            case INCLUDE:
                {
                alt4=7;
                }
                break;
            case GPATH:
                {
                alt4=8;
                }
                break;
            case VAR:
                {
                alt4=9;
                }
                break;
            case 67:
                {
                alt4=10;
                }
                break;
            case 68:
                {
                alt4=11;
                }
                break;
            case FUNC_CALL:
            case INT:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case STR:
            case ARR:
            case BOOL:
            case NULL:
            case RANGE:
            case PROPERTY_CALL:
            case VARIABLE_CALL:
            case IDENTIFIER:
            case 78:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
                {
                alt4=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:132:4: if_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_if_statement_in_statement104);
                    if_statement4=if_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, if_statement4.getTree());
                     retval.op = (if_statement4!=null?if_statement4.op:null); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:133:4: foreach_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_statement_in_statement134);
                    foreach_statement5=foreach_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, foreach_statement5.getTree());
                     retval.op = (foreach_statement5!=null?foreach_statement5.op:null); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:134:7: while_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_while_statement_in_statement162);
                    while_statement6=while_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, while_statement6.getTree());
                     retval.op = (while_statement6!=null?while_statement6.op:null); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:135:4: repeat_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_repeat_statement_in_statement189);
                    repeat_statement7=repeat_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, repeat_statement7.getTree());
                     retval.op = (repeat_statement7!=null?repeat_statement7.op:null); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:136:4: path_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_definition_statement_in_statement215);
                    path_definition_statement8=path_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, path_definition_statement8.getTree());
                     retval.op = (path_definition_statement8!=null?path_definition_statement8.op:null); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:137:4: function_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_definition_statement_in_statement232);
                    function_definition_statement9=function_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, function_definition_statement9.getTree());
                     retval.op = (function_definition_statement9!=null?function_definition_statement9.op:null); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:138:4: include_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_include_statement_in_statement245);
                    include_statement10=include_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, include_statement10.getTree());
                     retval.op = new UnaryOperation((include_statement10!=null?include_statement10.result:null)); 

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:139:4: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_statement270);
                    gpath_statement11=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, gpath_statement11.getTree());
                     retval.op = (gpath_statement11!=null?gpath_statement11.op:null); 

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:140:4: ^( VAR VARIABLE s= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VAR12=(CommonTree)match(input,VAR,FOLLOW_VAR_in_statement298); 
                    VAR12_tree = (CommonTree)adaptor.dupNode(VAR12);

                    root_1 = (CommonTree)adaptor.becomeRoot(VAR12_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VARIABLE13=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_statement300); 
                    VARIABLE13_tree = (CommonTree)adaptor.dupNode(VARIABLE13);

                    adaptor.addChild(root_1, VARIABLE13_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement304);
                    s=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, s.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new DeclareVariable((VARIABLE13!=null?VARIABLE13.getText():null), (s!=null?s.op:null)); 

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:141:9: ^( 'and' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal14=(CommonTree)match(input,67,FOLLOW_67_in_statement326); 
                    string_literal14_tree = (CommonTree)adaptor.dupNode(string_literal14);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal14_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement330);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement334);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new And((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:142:9: ^( 'or' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal15=(CommonTree)match(input,68,FOLLOW_68_in_statement351); 
                    string_literal15_tree = (CommonTree)adaptor.dupNode(string_literal15);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal15_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement356);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement360);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Or((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:143:9: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement376);
                    expression16=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression16.getTree());
                     retval.op = (expression16!=null?expression16.expr:null); 

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

    public static class include_statement_return extends TreeRuleReturnScope {
        public Atom result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "include_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:146:1: include_statement returns [Atom result] : ^( INCLUDE StringLiteral ) ;
    public final GremlinEvaluator.include_statement_return include_statement() throws RecognitionException {
        GremlinEvaluator.include_statement_return retval = new GremlinEvaluator.include_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INCLUDE17=null;
        CommonTree StringLiteral18=null;

        CommonTree INCLUDE17_tree=null;
        CommonTree StringLiteral18_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:147:2: ( ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:147:4: ^( INCLUDE StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            INCLUDE17=(CommonTree)match(input,INCLUDE,FOLLOW_INCLUDE_in_include_statement419); 
            INCLUDE17_tree = (CommonTree)adaptor.dupNode(INCLUDE17);

            root_1 = (CommonTree)adaptor.becomeRoot(INCLUDE17_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            StringLiteral18=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement421); 
            StringLiteral18_tree = (CommonTree)adaptor.dupNode(StringLiteral18);

            adaptor.addChild(root_1, StringLiteral18_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.result = new Atom(true);

                        String filename = (StringLiteral18!=null?StringLiteral18.getText():null);
                        try {
                            ANTLRFileStream file = new ANTLRFileStream(filename.substring(1, filename.length() - 1));
                            Gremlin.evaluate(file);
                        } catch(Exception e) {
                            retval.result = new Atom(false);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:161:1: path_definition_statement returns [Operation op] : ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) ;
    public final GremlinEvaluator.path_definition_statement_return path_definition_statement() throws RecognitionException {
        GremlinEvaluator.path_definition_statement_return retval = new GremlinEvaluator.path_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree path_name=null;
        CommonTree pr=null;
        CommonTree PATH19=null;
        CommonTree PROPERTY_CALL20=null;
        GremlinEvaluator.gpath_statement_return gpath = null;


        CommonTree path_name_tree=null;
        CommonTree pr_tree=null;
        CommonTree PATH19_tree=null;
        CommonTree PROPERTY_CALL20_tree=null;


                List<Pipe> pipes = new ArrayList<Pipe>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:165:2: ( ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:165:4: ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PATH19=(CommonTree)match(input,PATH,FOLLOW_PATH_in_path_definition_statement458); 
            PATH19_tree = (CommonTree)adaptor.dupNode(PATH19);

            root_1 = (CommonTree)adaptor.becomeRoot(PATH19_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            path_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_path_definition_statement462); 
            path_name_tree = (CommonTree)adaptor.dupNode(path_name);

            adaptor.addChild(root_1, path_name_tree);

            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:165:32: (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==GPATH) ) {
                alt5=1;
            }
            else if ( (LA5_0==PROPERTY_CALL) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:165:33: gpath= gpath_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_path_definition_statement467);
                    gpath=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_1, gpath.getTree());
                     pipes.addAll(((GPathOperation)(gpath!=null?gpath.op:null)).getPipes()); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:165:115: ^( PROPERTY_CALL pr= PROPERTY )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    PROPERTY_CALL20=(CommonTree)match(input,PROPERTY_CALL,FOLLOW_PROPERTY_CALL_in_path_definition_statement474); 
                    PROPERTY_CALL20_tree = (CommonTree)adaptor.dupNode(PROPERTY_CALL20);

                    root_2 = (CommonTree)adaptor.becomeRoot(PROPERTY_CALL20_tree, root_2);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pr=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_path_definition_statement478); 
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


                        paths.registerPath((path_name!=null?path_name.getText():null), pipes);
                        retval.op = new UnaryOperation(new Atom(null));
                    

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
        Object startPoint;
        List<Pipe> pipeList;
    }
    protected Stack gpath_statement_stack = new Stack();

    public static class gpath_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gpath_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:173:1: gpath_statement returns [Operation op] : ^( GPATH ( step )+ ) ;
    public final GremlinEvaluator.gpath_statement_return gpath_statement() throws RecognitionException {
        gpath_statement_stack.push(new gpath_statement_scope());
        GremlinEvaluator.gpath_statement_return retval = new GremlinEvaluator.gpath_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GPATH21=null;
        GremlinEvaluator.step_return step22 = null;


        CommonTree GPATH21_tree=null;


                isGPath = true;
                
                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeCount = 0;
                ((gpath_statement_scope)gpath_statement_stack.peek()).startPoint = null;
                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList = new ArrayList<Pipe>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:190:2: ( ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:190:4: ^( GPATH ( step )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            GPATH21=(CommonTree)match(input,GPATH,FOLLOW_GPATH_in_gpath_statement537); 
            GPATH21_tree = (CommonTree)adaptor.dupNode(GPATH21);

            root_1 = (CommonTree)adaptor.becomeRoot(GPATH21_tree, root_1);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:190:12: ( step )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==STEP) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:190:13: step
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_step_in_gpath_statement540);
            	    step22=step();

            	    state._fsp--;

            	    adaptor.addChild(root_1, step22.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        if (((gpath_statement_scope)gpath_statement_stack.peek()).pipeList.size() > 0) {
                            retval.op = new GPathOperation(((gpath_statement_scope)gpath_statement_stack.peek()).pipeList, ((gpath_statement_scope)gpath_statement_stack.peek()).startPoint);
                        } else {
                            retval.op = new UnaryOperation(new Atom(null));
                        }
                    

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


                    isGPath = false;
                
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:200:1: step : ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) ;
    public final GremlinEvaluator.step_return step() throws RecognitionException {
        GremlinEvaluator.step_return retval = new GremlinEvaluator.step_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STEP23=null;
        CommonTree TOKEN24=null;
        CommonTree PREDICATES26=null;
        CommonTree PREDICATE27=null;
        GremlinEvaluator.token_return token25 = null;

        GremlinEvaluator.statement_return statement28 = null;


        CommonTree STEP23_tree=null;
        CommonTree TOKEN24_tree=null;
        CommonTree PREDICATES26_tree=null;
        CommonTree PREDICATE27_tree=null;


                List<Operation> predicates = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:204:5: ( ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:204:7: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            STEP23=(CommonTree)match(input,STEP,FOLLOW_STEP_in_step578); 
            STEP23_tree = (CommonTree)adaptor.dupNode(STEP23);

            root_1 = (CommonTree)adaptor.becomeRoot(STEP23_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TOKEN24=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_step581); 
            TOKEN24_tree = (CommonTree)adaptor.dupNode(TOKEN24);

            root_2 = (CommonTree)adaptor.becomeRoot(TOKEN24_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_token_in_step583);
            token25=token();

            state._fsp--;

            adaptor.addChild(root_2, token25.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PREDICATES26=(CommonTree)match(input,PREDICATES,FOLLOW_PREDICATES_in_step587); 
            PREDICATES26_tree = (CommonTree)adaptor.dupNode(PREDICATES26);

            root_2 = (CommonTree)adaptor.becomeRoot(PREDICATES26_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:204:42: ( ^( PREDICATE statement ) )*
                loop7:
                do {
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==PREDICATE) ) {
                        alt7=1;
                    }


                    switch (alt7) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:204:44: ^( PREDICATE statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    PREDICATE27=(CommonTree)match(input,PREDICATE,FOLLOW_PREDICATE_in_step592); 
                	    PREDICATE27_tree = (CommonTree)adaptor.dupNode(PREDICATE27);

                	    root_3 = (CommonTree)adaptor.becomeRoot(PREDICATE27_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_step594);
                	    statement28=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_3, statement28.getTree());
                	     predicates.add((statement28!=null?statement28.op:null)); 

                	    match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
                	    }


                	    }
                	    break;

                	default :
                	    break loop7;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        Atom tokenAtom = (token25!=null?token25.atom:null);
                        
                        if (tokenAtom != null) {
                            if (((gpath_statement_scope)gpath_statement_stack.peek()).pipeCount == 0) {
                                if (tokenAtom.isIdentifier() && ((String)tokenAtom.getValue()).equals(".")) {
                                    ((gpath_statement_scope)gpath_statement_stack.peek()).startPoint = GremlinEvaluator.getVariable(Tokens.ROOT_VARIABLE).getValue();
                                } else if (paths.isPath(tokenAtom.getValue().toString())) {
                                    ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList.addAll(paths.getPath((String)tokenAtom.getValue()));
                                    ((gpath_statement_scope)gpath_statement_stack.peek()).startPoint = GremlinEvaluator.getVariable(Tokens.ROOT_VARIABLE).getValue();
                                } else {
                                    ((gpath_statement_scope)gpath_statement_stack.peek()).startPoint = tokenAtom.getValue();
                                }
                            } else {
                                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList.addAll(GremlinPipesHelper.pipesForStep((token25!=null?token25.atom:null), predicates));
                            }
                        }
                        
                        ((gpath_statement_scope)gpath_statement_stack.peek()).pipeCount++;
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:227:1: token returns [Atom atom] : ( expression | '..' );
    public final GremlinEvaluator.token_return token() throws RecognitionException {
        GremlinEvaluator.token_return retval = new GremlinEvaluator.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal30=null;
        GremlinEvaluator.expression_return expression29 = null;


        CommonTree string_literal30_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:228:5: ( expression | '..' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==FUNC_CALL||(LA8_0>=INT && LA8_0<=VARIABLE_CALL)||LA8_0==IDENTIFIER||LA8_0==78||(LA8_0>=81 && LA8_0<=90)) ) {
                alt8=1;
            }
            else if ( (LA8_0==65) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:228:8: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_token636);
                    expression29=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression29.getTree());
                     retval.atom = (expression29!=null?expression29.expr:null).compute(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:229:9: '..'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal30=(CommonTree)match(input,65,FOLLOW_65_in_token648); 
                    string_literal30_tree = (CommonTree)adaptor.dupNode(string_literal30);

                    adaptor.addChild(root_0, string_literal30_tree);



                                            List<Pipe> history = new ArrayList<Pipe>();
                                            List<Pipe> newPipes = new ArrayList<Pipe>();
                                            List<Pipe> pipes = ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList;

                                            if ((pipes.size() == 1 && (pipes.get(0) instanceof FutureFilterPipe)) || pipes.size() == 0) {
                                                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList = new ArrayList();
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
                                            
                                                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList = newPipes;
                                            }
                                            
                                            retval.atom = null;
                                       

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:263:1: if_statement returns [Operation op] : ^( IF ^( COND cond= statement ) block ) ;
    public final GremlinEvaluator.if_statement_return if_statement() throws RecognitionException {
        GremlinEvaluator.if_statement_return retval = new GremlinEvaluator.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IF31=null;
        CommonTree COND32=null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return block33 = null;


        CommonTree IF31_tree=null;
        CommonTree COND32_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:264:2: ( ^( IF ^( COND cond= statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:264:4: ^( IF ^( COND cond= statement ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            IF31=(CommonTree)match(input,IF,FOLLOW_IF_in_if_statement673); 
            IF31_tree = (CommonTree)adaptor.dupNode(IF31);

            root_1 = (CommonTree)adaptor.becomeRoot(IF31_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND32=(CommonTree)match(input,COND,FOLLOW_COND_in_if_statement676); 
            COND32_tree = (CommonTree)adaptor.dupNode(COND32);

            root_2 = (CommonTree)adaptor.becomeRoot(COND32_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_if_statement680);
            cond=statement();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_if_statement683);
            block33=block();

            state._fsp--;

            adaptor.addChild(root_1, block33.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new If((cond!=null?cond.op:null), (block33!=null?block33.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:270:1: while_statement returns [Operation op] : ^( WHILE ^( COND cond= statement ) block ) ;
    public final GremlinEvaluator.while_statement_return while_statement() throws RecognitionException {
        GremlinEvaluator.while_statement_return retval = new GremlinEvaluator.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree WHILE34=null;
        CommonTree COND35=null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return block36 = null;


        CommonTree WHILE34_tree=null;
        CommonTree COND35_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:271:2: ( ^( WHILE ^( COND cond= statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:271:4: ^( WHILE ^( COND cond= statement ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            WHILE34=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_while_statement711); 
            WHILE34_tree = (CommonTree)adaptor.dupNode(WHILE34);

            root_1 = (CommonTree)adaptor.becomeRoot(WHILE34_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND35=(CommonTree)match(input,COND,FOLLOW_COND_in_while_statement714); 
            COND35_tree = (CommonTree)adaptor.dupNode(COND35);

            root_2 = (CommonTree)adaptor.becomeRoot(COND35_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_while_statement718);
            cond=statement();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_while_statement721);
            block36=block();

            state._fsp--;

            adaptor.addChild(root_1, block36.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new While((cond!=null?cond.op:null), (block36!=null?block36.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:277:1: foreach_statement returns [Operation op] : ^( FOREACH VARIABLE arr= statement block ) ;
    public final GremlinEvaluator.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinEvaluator.foreach_statement_return retval = new GremlinEvaluator.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH37=null;
        CommonTree VARIABLE38=null;
        GremlinEvaluator.statement_return arr = null;

        GremlinEvaluator.block_return block39 = null;


        CommonTree FOREACH37_tree=null;
        CommonTree VARIABLE38_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:278:2: ( ^( FOREACH VARIABLE arr= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:278:4: ^( FOREACH VARIABLE arr= statement block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FOREACH37=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_statement748); 
            FOREACH37_tree = (CommonTree)adaptor.dupNode(FOREACH37);

            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH37_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            VARIABLE38=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement750); 
            VARIABLE38_tree = (CommonTree)adaptor.dupNode(VARIABLE38);

            adaptor.addChild(root_1, VARIABLE38_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_foreach_statement754);
            arr=statement();

            state._fsp--;

            adaptor.addChild(root_1, arr.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_foreach_statement756);
            block39=block();

            state._fsp--;

            adaptor.addChild(root_1, block39.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Foreach((VARIABLE38!=null?VARIABLE38.getText():null), (arr!=null?arr.op:null), (block39!=null?block39.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:284:1: repeat_statement returns [Operation op] : ^( REPEAT timer= statement block ) ;
    public final GremlinEvaluator.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinEvaluator.repeat_statement_return retval = new GremlinEvaluator.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REPEAT40=null;
        GremlinEvaluator.statement_return timer = null;

        GremlinEvaluator.block_return block41 = null;


        CommonTree REPEAT40_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:285:2: ( ^( REPEAT timer= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:285:4: ^( REPEAT timer= statement block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            REPEAT40=(CommonTree)match(input,REPEAT,FOLLOW_REPEAT_in_repeat_statement784); 
            REPEAT40_tree = (CommonTree)adaptor.dupNode(REPEAT40);

            root_1 = (CommonTree)adaptor.becomeRoot(REPEAT40_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_repeat_statement788);
            timer=statement();

            state._fsp--;

            adaptor.addChild(root_1, timer.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_repeat_statement790);
            block41=block();

            state._fsp--;

            adaptor.addChild(root_1, block41.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Repeat((timer!=null?timer.op:null), (block41!=null?block41.operations:null));
                    

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
        public List<Operation> operations;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:291:1: block returns [List<Operation> operations] : ^( BLOCK ( statement )+ ) ;
    public final GremlinEvaluator.block_return block() throws RecognitionException {
        GremlinEvaluator.block_return retval = new GremlinEvaluator.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BLOCK42=null;
        GremlinEvaluator.statement_return statement43 = null;


        CommonTree BLOCK42_tree=null;


                List<Operation> operationList = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:295:5: ( ^( BLOCK ( statement )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:295:7: ^( BLOCK ( statement )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            BLOCK42=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_block829); 
            BLOCK42_tree = (CommonTree)adaptor.dupNode(BLOCK42);

            root_1 = (CommonTree)adaptor.becomeRoot(BLOCK42_tree, root_1);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:295:15: ( statement )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==VAR||LA9_0==FUNC||(LA9_0>=PATH && LA9_0<=GPATH)||(LA9_0>=FUNC_CALL && LA9_0<=IF)||(LA9_0>=FOREACH && LA9_0<=VARIABLE_CALL)||LA9_0==IDENTIFIER||(LA9_0>=67 && LA9_0<=68)||LA9_0==78||(LA9_0>=81 && LA9_0<=90)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:295:16: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_block832);
            	    statement43=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_1, statement43.getTree());
            	     operationList.add((statement43!=null?statement43.op:null)); 

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

             retval.operations = operationList; 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:298:1: expression returns [Operation expr] : ( ^( '=' a= operation b= operation ) | ^( '!=' a= operation b= operation ) | ^( '<' a= operation b= operation ) | ^( '>' a= operation b= operation ) | ^( '<=' a= operation b= operation ) | ^( '>=' a= operation b= operation ) | operation );
    public final GremlinEvaluator.expression_return expression() throws RecognitionException {
        GremlinEvaluator.expression_return retval = new GremlinEvaluator.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal44=null;
        CommonTree string_literal45=null;
        CommonTree char_literal46=null;
        CommonTree char_literal47=null;
        CommonTree string_literal48=null;
        CommonTree string_literal49=null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.operation_return operation50 = null;


        CommonTree char_literal44_tree=null;
        CommonTree string_literal45_tree=null;
        CommonTree char_literal46_tree=null;
        CommonTree char_literal47_tree=null;
        CommonTree string_literal48_tree=null;
        CommonTree string_literal49_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:299:5: ( ^( '=' a= operation b= operation ) | ^( '!=' a= operation b= operation ) | ^( '<' a= operation b= operation ) | ^( '>' a= operation b= operation ) | ^( '<=' a= operation b= operation ) | ^( '>=' a= operation b= operation ) | operation )
            int alt10=7;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt10=1;
                }
                break;
            case 82:
                {
                alt10=2;
                }
                break;
            case 83:
                {
                alt10=3;
                }
                break;
            case 85:
                {
                alt10=4;
                }
                break;
            case 84:
                {
                alt10=5;
                }
                break;
            case 86:
                {
                alt10=6;
                }
                break;
            case FUNC_CALL:
            case INT:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case STR:
            case ARR:
            case BOOL:
            case NULL:
            case RANGE:
            case PROPERTY_CALL:
            case VARIABLE_CALL:
            case IDENTIFIER:
            case 78:
            case 87:
            case 88:
            case 89:
            case 90:
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:299:9: ^( '=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal44=(CommonTree)match(input,81,FOLLOW_81_in_expression860); 
                    char_literal44_tree = (CommonTree)adaptor.dupNode(char_literal44);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal44_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression865);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression869);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new Equality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:300:9: ^( '!=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal45=(CommonTree)match(input,82,FOLLOW_82_in_expression883); 
                    string_literal45_tree = (CommonTree)adaptor.dupNode(string_literal45);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal45_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression887);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression891);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new UnEquality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:301:9: ^( '<' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal46=(CommonTree)match(input,83,FOLLOW_83_in_expression905); 
                    char_literal46_tree = (CommonTree)adaptor.dupNode(char_literal46);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal46_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression910);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression914);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:302:9: ^( '>' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal47=(CommonTree)match(input,85,FOLLOW_85_in_expression928); 
                    char_literal47_tree = (CommonTree)adaptor.dupNode(char_literal47);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal47_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression933);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression937);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:303:9: ^( '<=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal48=(CommonTree)match(input,84,FOLLOW_84_in_expression951); 
                    string_literal48_tree = (CommonTree)adaptor.dupNode(string_literal48);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal48_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression955);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression959);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:304:9: ^( '>=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal49=(CommonTree)match(input,86,FOLLOW_86_in_expression973); 
                    string_literal49_tree = (CommonTree)adaptor.dupNode(string_literal49);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal49_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression977);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression981);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:305:9: operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression994);
                    operation50=operation();

                    state._fsp--;

                    adaptor.addChild(root_0, operation50.getTree());
                     retval.expr = (operation50!=null?operation50.op:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:308:1: operation returns [Operation op] : ( ^( '+' a= operation b= operation ) | ^( '-' a= operation b= operation ) | binary_operation );
    public final GremlinEvaluator.operation_return operation() throws RecognitionException {
        GremlinEvaluator.operation_return retval = new GremlinEvaluator.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal51=null;
        CommonTree char_literal52=null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.binary_operation_return binary_operation53 = null;


        CommonTree char_literal51_tree=null;
        CommonTree char_literal52_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:309:5: ( ^( '+' a= operation b= operation ) | ^( '-' a= operation b= operation ) | binary_operation )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt11=1;
                }
                break;
            case 88:
                {
                alt11=2;
                }
                break;
            case FUNC_CALL:
            case INT:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case STR:
            case ARR:
            case BOOL:
            case NULL:
            case RANGE:
            case PROPERTY_CALL:
            case VARIABLE_CALL:
            case IDENTIFIER:
            case 78:
            case 89:
            case 90:
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:309:9: ^( '+' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal51=(CommonTree)match(input,87,FOLLOW_87_in_operation1039); 
                    char_literal51_tree = (CommonTree)adaptor.dupNode(char_literal51);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal51_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1043);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1047);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Addition((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:310:9: ^( '-' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal52=(CommonTree)match(input,88,FOLLOW_88_in_operation1061); 
                    char_literal52_tree = (CommonTree)adaptor.dupNode(char_literal52);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal52_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1065);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1069);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Subtraction((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:311:9: binary_operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_binary_operation_in_operation1082);
                    binary_operation53=binary_operation();

                    state._fsp--;

                    adaptor.addChild(root_0, binary_operation53.getTree());
                     retval.op = (binary_operation53!=null?binary_operation53.operation:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:314:1: binary_operation returns [Operation operation] : ( ^( '*' a= operation b= operation ) | ^( 'div' a= operation b= operation ) | atom );
    public final GremlinEvaluator.binary_operation_return binary_operation() throws RecognitionException {
        GremlinEvaluator.binary_operation_return retval = new GremlinEvaluator.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal54=null;
        CommonTree string_literal55=null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.atom_return atom56 = null;


        CommonTree char_literal54_tree=null;
        CommonTree string_literal55_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:315:5: ( ^( '*' a= operation b= operation ) | ^( 'div' a= operation b= operation ) | atom )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt12=1;
                }
                break;
            case 90:
                {
                alt12=2;
                }
                break;
            case FUNC_CALL:
            case INT:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case STR:
            case ARR:
            case BOOL:
            case NULL:
            case RANGE:
            case PROPERTY_CALL:
            case VARIABLE_CALL:
            case IDENTIFIER:
            case 78:
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:315:9: ^( '*' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,89,FOLLOW_89_in_binary_operation1119); 
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal54_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1123);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1127);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Multiplication((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:316:9: ^( 'div' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal55=(CommonTree)match(input,90,FOLLOW_90_in_binary_operation1146); 
                    string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal55_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1150);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1154);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Division((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:317:9: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atom_in_binary_operation1170);
                    atom56=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom56.getTree());
                     retval.operation = new UnaryOperation((atom56!=null?atom56.value:null)); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:320:1: function_definition_statement returns [Operation op] : ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) ;
    public final GremlinEvaluator.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinEvaluator.function_definition_statement_return retval = new GremlinEvaluator.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC57=null;
        CommonTree FUNC_NAME58=null;
        CommonTree NS59=null;
        CommonTree NAME60=null;
        CommonTree ARGS61=null;
        CommonTree ARG62=null;
        CommonTree VARIABLE63=null;
        GremlinEvaluator.block_return block64 = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC57_tree=null;
        CommonTree FUNC_NAME58_tree=null;
        CommonTree NS59_tree=null;
        CommonTree NAME60_tree=null;
        CommonTree ARGS61_tree=null;
        CommonTree ARG62_tree=null;
        CommonTree VARIABLE63_tree=null;


                List<String> params = new ArrayList<String>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:324:2: ( ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:324:4: ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC57=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_function_definition_statement1228); 
            FUNC57_tree = (CommonTree)adaptor.dupNode(FUNC57);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC57_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME58=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_definition_statement1231); 
            FUNC_NAME58_tree = (CommonTree)adaptor.dupNode(FUNC_NAME58);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME58_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS59=(CommonTree)match(input,NS,FOLLOW_NS_in_function_definition_statement1234); 
            NS59_tree = (CommonTree)adaptor.dupNode(NS59);

            root_3 = (CommonTree)adaptor.becomeRoot(NS59_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1238); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME60=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_definition_statement1242); 
            NAME60_tree = (CommonTree)adaptor.dupNode(NAME60);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME60_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1246); 
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
            ARGS61=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_definition_statement1251); 
            ARGS61_tree = (CommonTree)adaptor.dupNode(ARGS61);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS61_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:324:78: ( ^( ARG VARIABLE ) )*
                loop13:
                do {
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==ARG) ) {
                        alt13=1;
                    }


                    switch (alt13) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:324:80: ^( ARG VARIABLE )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG62=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_definition_statement1256); 
                	    ARG62_tree = (CommonTree)adaptor.dupNode(ARG62);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG62_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    VARIABLE63=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_function_definition_statement1258); 
                	    VARIABLE63_tree = (CommonTree)adaptor.dupNode(VARIABLE63);

                	    adaptor.addChild(root_3, VARIABLE63_tree);

                	     params.add((VARIABLE63!=null?VARIABLE63.getText():null)); 

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
            pushFollow(FOLLOW_block_in_function_definition_statement1267);
            block64=block();

            state._fsp--;

            adaptor.addChild(root_1, block64.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        NativeFunction fn = new NativeFunction((fn_name!=null?fn_name.getText():null), params, (block64!=null?block64.operations:null));
                        functions.registerFunction((ns!=null?ns.getText():null), fn);

                        retval.op = new UnaryOperation(new Atom(null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:333:1: function_call returns [Atom value] : ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) ;
    public final GremlinEvaluator.function_call_return function_call() throws RecognitionException {
        GremlinEvaluator.function_call_return retval = new GremlinEvaluator.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC_CALL65=null;
        CommonTree FUNC_NAME66=null;
        CommonTree NS67=null;
        CommonTree NAME68=null;
        CommonTree ARGS69=null;
        CommonTree ARG70=null;
        GremlinEvaluator.statement_return st = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC_CALL65_tree=null;
        CommonTree FUNC_NAME66_tree=null;
        CommonTree NS67_tree=null;
        CommonTree NAME68_tree=null;
        CommonTree ARGS69_tree=null;
        CommonTree ARG70_tree=null;


                List<Operation> params = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:337:2: ( ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:337:4: ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_CALL65=(CommonTree)match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_function_call1304); 
            FUNC_CALL65_tree = (CommonTree)adaptor.dupNode(FUNC_CALL65);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_CALL65_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME66=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_call1307); 
            FUNC_NAME66_tree = (CommonTree)adaptor.dupNode(FUNC_NAME66);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME66_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS67=(CommonTree)match(input,NS,FOLLOW_NS_in_function_call1310); 
            NS67_tree = (CommonTree)adaptor.dupNode(NS67);

            root_3 = (CommonTree)adaptor.becomeRoot(NS67_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1314); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME68=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_call1318); 
            NAME68_tree = (CommonTree)adaptor.dupNode(NAME68);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME68_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1322); 
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
            ARGS69=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_call1327); 
            ARGS69_tree = (CommonTree)adaptor.dupNode(ARGS69);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS69_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:337:83: ( ^( ARG st= statement ) )*
                loop14:
                do {
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==ARG) ) {
                        alt14=1;
                    }


                    switch (alt14) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:337:85: ^( ARG st= statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG70=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_call1332); 
                	    ARG70_tree = (CommonTree)adaptor.dupNode(ARG70);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG70_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_function_call1336);
                	    st=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_3, st.getTree());
                	     params.add((st!=null?st.op:null)); 

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
                            retval.value = functions.runFunction((ns!=null?ns.getText():null), (fn_name!=null?fn_name.getText():null), params);
                        } catch(Exception e) {
                            System.err.println(e);
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

    public static class collection_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "collection"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:347:1: collection returns [Operation op] : ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) ) ;
    public final GremlinEvaluator.collection_return collection() throws RecognitionException {
        GremlinEvaluator.collection_return retval = new GremlinEvaluator.collection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COLLECTION_CALL71=null;
        CommonTree STEP72=null;
        CommonTree TOKEN73=null;
        CommonTree PREDICATES75=null;
        CommonTree PREDICATE76=null;
        GremlinEvaluator.token_return token74 = null;

        GremlinEvaluator.statement_return statement77 = null;


        CommonTree COLLECTION_CALL71_tree=null;
        CommonTree STEP72_tree=null;
        CommonTree TOKEN73_tree=null;
        CommonTree PREDICATES75_tree=null;
        CommonTree PREDICATE76_tree=null;


                Object startPoint = null;
                List<Pipe> pipes = new ArrayList<Pipe>();
                List<Operation> predicates = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:353:5: ( ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:353:7: ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COLLECTION_CALL71=(CommonTree)match(input,COLLECTION_CALL,FOLLOW_COLLECTION_CALL_in_collection1383); 
            COLLECTION_CALL71_tree = (CommonTree)adaptor.dupNode(COLLECTION_CALL71);

            root_1 = (CommonTree)adaptor.becomeRoot(COLLECTION_CALL71_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            STEP72=(CommonTree)match(input,STEP,FOLLOW_STEP_in_collection1386); 
            STEP72_tree = (CommonTree)adaptor.dupNode(STEP72);

            root_2 = (CommonTree)adaptor.becomeRoot(STEP72_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TOKEN73=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_collection1389); 
            TOKEN73_tree = (CommonTree)adaptor.dupNode(TOKEN73);

            root_3 = (CommonTree)adaptor.becomeRoot(TOKEN73_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_token_in_collection1391);
            token74=token();

            state._fsp--;

            adaptor.addChild(root_3, token74.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PREDICATES75=(CommonTree)match(input,PREDICATES,FOLLOW_PREDICATES_in_collection1395); 
            PREDICATES75_tree = (CommonTree)adaptor.dupNode(PREDICATES75);

            root_3 = (CommonTree)adaptor.becomeRoot(PREDICATES75_tree, root_3);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:353:60: ( ^( PREDICATE statement ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==PREDICATE) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:353:62: ^( PREDICATE statement )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_4 = _last;
            	    CommonTree _first_4 = null;
            	    CommonTree root_4 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            	    PREDICATE76=(CommonTree)match(input,PREDICATE,FOLLOW_PREDICATE_in_collection1400); 
            	    PREDICATE76_tree = (CommonTree)adaptor.dupNode(PREDICATE76);

            	    root_4 = (CommonTree)adaptor.becomeRoot(PREDICATE76_tree, root_4);



            	    match(input, Token.DOWN, null); 
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_collection1402);
            	    statement77=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_4, statement77.getTree());
            	     predicates.add((statement77!=null?statement77.op:null)); 

            	    match(input, Token.UP, null); adaptor.addChild(root_3, root_4);_last = _save_last_4;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }


            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                    Atom tokenAtom = (token74!=null?token74.atom:null);

                    if (tokenAtom.isIdentifier() && ((String)tokenAtom.getValue()).equals(".")) {
                        startPoint = GremlinEvaluator.getVariable(Tokens.ROOT_VARIABLE).getValue();
                    } else if (paths.isPath(tokenAtom.getValue().toString())) {
                        pipes.addAll(paths.getPath((String)tokenAtom.getValue()));
                        startPoint = GremlinEvaluator.getVariable(Tokens.ROOT_VARIABLE).getValue();
                    } else {
                        startPoint = tokenAtom.getValue();
                    }

                    Atom id = new Atom(".");
                    id.setIdentifier(true);
                    
                    pipes.addAll(GremlinPipesHelper.pipesForStep(id, predicates));

                    retval.op = new GPathOperation(pipes, startPoint);
                

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
    // $ANTLR end "collection"

    public static class atom_return extends TreeRuleReturnScope {
        public Atom value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:376:1: atom returns [Atom value] : ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | ^( RANGE min= G_INT max= G_INT ) | ^( STR StringLiteral ) | ^( BOOL b= BOOLEAN ) | NULL | ^( ARR ( NUMBER )+ ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | function_call | '(' statement ')' );
    public final GremlinEvaluator.atom_return atom() throws RecognitionException {
        GremlinEvaluator.atom_return retval = new GremlinEvaluator.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree min=null;
        CommonTree max=null;
        CommonTree b=null;
        CommonTree INT78=null;
        CommonTree G_INT79=null;
        CommonTree LONG80=null;
        CommonTree G_LONG81=null;
        CommonTree FLOAT82=null;
        CommonTree G_FLOAT83=null;
        CommonTree DOUBLE84=null;
        CommonTree G_DOUBLE85=null;
        CommonTree RANGE86=null;
        CommonTree STR87=null;
        CommonTree StringLiteral88=null;
        CommonTree BOOL89=null;
        CommonTree NULL90=null;
        CommonTree ARR91=null;
        CommonTree NUMBER92=null;
        CommonTree VARIABLE_CALL93=null;
        CommonTree VARIABLE94=null;
        CommonTree PROPERTY_CALL95=null;
        CommonTree PROPERTY96=null;
        CommonTree IDENTIFIER97=null;
        CommonTree char_literal99=null;
        CommonTree char_literal101=null;
        GremlinEvaluator.function_call_return function_call98 = null;

        GremlinEvaluator.statement_return statement100 = null;


        CommonTree min_tree=null;
        CommonTree max_tree=null;
        CommonTree b_tree=null;
        CommonTree INT78_tree=null;
        CommonTree G_INT79_tree=null;
        CommonTree LONG80_tree=null;
        CommonTree G_LONG81_tree=null;
        CommonTree FLOAT82_tree=null;
        CommonTree G_FLOAT83_tree=null;
        CommonTree DOUBLE84_tree=null;
        CommonTree G_DOUBLE85_tree=null;
        CommonTree RANGE86_tree=null;
        CommonTree STR87_tree=null;
        CommonTree StringLiteral88_tree=null;
        CommonTree BOOL89_tree=null;
        CommonTree NULL90_tree=null;
        CommonTree ARR91_tree=null;
        CommonTree NUMBER92_tree=null;
        CommonTree VARIABLE_CALL93_tree=null;
        CommonTree VARIABLE94_tree=null;
        CommonTree PROPERTY_CALL95_tree=null;
        CommonTree PROPERTY96_tree=null;
        CommonTree IDENTIFIER97_tree=null;
        CommonTree char_literal99_tree=null;
        CommonTree char_literal101_tree=null;


                List<Double> array = new ArrayList<Double>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:380:2: ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | ^( RANGE min= G_INT max= G_INT ) | ^( STR StringLiteral ) | ^( BOOL b= BOOLEAN ) | NULL | ^( ARR ( NUMBER )+ ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | function_call | '(' statement ')' )
            int alt17=14;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt17=1;
                }
                break;
            case LONG:
                {
                alt17=2;
                }
                break;
            case FLOAT:
                {
                alt17=3;
                }
                break;
            case DOUBLE:
                {
                alt17=4;
                }
                break;
            case RANGE:
                {
                alt17=5;
                }
                break;
            case STR:
                {
                alt17=6;
                }
                break;
            case BOOL:
                {
                alt17=7;
                }
                break;
            case NULL:
                {
                alt17=8;
                }
                break;
            case ARR:
                {
                alt17=9;
                }
                break;
            case VARIABLE_CALL:
                {
                alt17=10;
                }
                break;
            case PROPERTY_CALL:
                {
                alt17=11;
                }
                break;
            case IDENTIFIER:
                {
                alt17=12;
                }
                break;
            case FUNC_CALL:
                {
                alt17=13;
                }
                break;
            case 78:
                {
                alt17=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:380:6: ^( INT G_INT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    INT78=(CommonTree)match(input,INT,FOLLOW_INT_in_atom1449); 
                    INT78_tree = (CommonTree)adaptor.dupNode(INT78);

                    root_1 = (CommonTree)adaptor.becomeRoot(INT78_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_INT79=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1451); 
                    G_INT79_tree = (CommonTree)adaptor.dupNode(G_INT79);

                    adaptor.addChild(root_1, G_INT79_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Integer>(new Integer((G_INT79!=null?G_INT79.getText():null))); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:381:6: ^( LONG G_LONG )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    LONG80=(CommonTree)match(input,LONG,FOLLOW_LONG_in_atom1509); 
                    LONG80_tree = (CommonTree)adaptor.dupNode(LONG80);

                    root_1 = (CommonTree)adaptor.becomeRoot(LONG80_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_LONG81=(CommonTree)match(input,G_LONG,FOLLOW_G_LONG_in_atom1511); 
                    G_LONG81_tree = (CommonTree)adaptor.dupNode(G_LONG81);

                    adaptor.addChild(root_1, G_LONG81_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String longStr = (G_LONG81!=null?G_LONG81.getText():null);
                    	                                                                    retval.value = new Atom<Long>(new Long(longStr.substring(0, longStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:385:6: ^( FLOAT G_FLOAT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    FLOAT82=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_atom1567); 
                    FLOAT82_tree = (CommonTree)adaptor.dupNode(FLOAT82);

                    root_1 = (CommonTree)adaptor.becomeRoot(FLOAT82_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_FLOAT83=(CommonTree)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_atom1569); 
                    G_FLOAT83_tree = (CommonTree)adaptor.dupNode(G_FLOAT83);

                    adaptor.addChild(root_1, G_FLOAT83_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Float>(new Float((G_FLOAT83!=null?G_FLOAT83.getText():null))); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:386:6: ^( DOUBLE G_DOUBLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    DOUBLE84=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_atom1623); 
                    DOUBLE84_tree = (CommonTree)adaptor.dupNode(DOUBLE84);

                    root_1 = (CommonTree)adaptor.becomeRoot(DOUBLE84_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_DOUBLE85=(CommonTree)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_atom1625); 
                    G_DOUBLE85_tree = (CommonTree)adaptor.dupNode(G_DOUBLE85);

                    adaptor.addChild(root_1, G_DOUBLE85_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String doubleStr = (G_DOUBLE85!=null?G_DOUBLE85.getText():null);
                    	                                                                    retval.value = new Atom<Double>(new Double(doubleStr.substring(0, doubleStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:390:6: ^( RANGE min= G_INT max= G_INT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    RANGE86=(CommonTree)match(input,RANGE,FOLLOW_RANGE_in_atom1677); 
                    RANGE86_tree = (CommonTree)adaptor.dupNode(RANGE86);

                    root_1 = (CommonTree)adaptor.becomeRoot(RANGE86_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    min=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1681); 
                    min_tree = (CommonTree)adaptor.dupNode(min);

                    adaptor.addChild(root_1, min_tree);

                    _last = (CommonTree)input.LT(1);
                    max=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1685); 
                    max_tree = (CommonTree)adaptor.dupNode(max);

                    adaptor.addChild(root_1, max_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom(new Range((min!=null?min.getText():null), (max!=null?max.getText():null))); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:391:4: ^( STR StringLiteral )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    STR87=(CommonTree)match(input,STR,FOLLOW_STR_in_atom1725); 
                    STR87_tree = (CommonTree)adaptor.dupNode(STR87);

                    root_1 = (CommonTree)adaptor.becomeRoot(STR87_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    StringLiteral88=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_atom1727); 
                    StringLiteral88_tree = (CommonTree)adaptor.dupNode(StringLiteral88);

                    adaptor.addChild(root_1, StringLiteral88_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom((StringLiteral88!=null?StringLiteral88.getText():null)); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:392:9: ^( BOOL b= BOOLEAN )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    BOOL89=(CommonTree)match(input,BOOL,FOLLOW_BOOL_in_atom1780); 
                    BOOL89_tree = (CommonTree)adaptor.dupNode(BOOL89);

                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL89_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    b=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_atom1784); 
                    b_tree = (CommonTree)adaptor.dupNode(b);

                    adaptor.addChild(root_1, b_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom(new Boolean((b!=null?b.getText():null))); 

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:393:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    NULL90=(CommonTree)match(input,NULL,FOLLOW_NULL_in_atom1839); 
                    NULL90_tree = (CommonTree)adaptor.dupNode(NULL90);

                    adaptor.addChild(root_0, NULL90_tree);

                     retval.value = new Atom(null); 

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:394:9: ^( ARR ( NUMBER )+ )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    ARR91=(CommonTree)match(input,ARR,FOLLOW_ARR_in_atom1907); 
                    ARR91_tree = (CommonTree)adaptor.dupNode(ARR91);

                    root_1 = (CommonTree)adaptor.becomeRoot(ARR91_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:394:15: ( NUMBER )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==NUMBER) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:394:16: NUMBER
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    NUMBER92=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_atom1910); 
                    	    NUMBER92_tree = (CommonTree)adaptor.dupNode(NUMBER92);

                    	    adaptor.addChild(root_1, NUMBER92_tree);

                    	     array.add(new Double((NUMBER92!=null?NUMBER92.getText():null))); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom(array); 

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:395:4: ^( VARIABLE_CALL VARIABLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VARIABLE_CALL93=(CommonTree)match(input,VARIABLE_CALL,FOLLOW_VARIABLE_CALL_in_atom1925); 
                    VARIABLE_CALL93_tree = (CommonTree)adaptor.dupNode(VARIABLE_CALL93);

                    root_1 = (CommonTree)adaptor.becomeRoot(VARIABLE_CALL93_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VARIABLE94=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_atom1927); 
                    VARIABLE94_tree = (CommonTree)adaptor.dupNode(VARIABLE94);

                    adaptor.addChild(root_1, VARIABLE94_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     
                                                                                          retval.value = getVariable((VARIABLE94!=null?VARIABLE94.getText():null)); 
                                                                                        

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:398:4: ^( PROPERTY_CALL PROPERTY )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    PROPERTY_CALL95=(CommonTree)match(input,PROPERTY_CALL,FOLLOW_PROPERTY_CALL_in_atom1970); 
                    PROPERTY_CALL95_tree = (CommonTree)adaptor.dupNode(PROPERTY_CALL95);

                    root_1 = (CommonTree)adaptor.becomeRoot(PROPERTY_CALL95_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    PROPERTY96=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_atom1972); 
                    PROPERTY96_tree = (CommonTree)adaptor.dupNode(PROPERTY96);

                    adaptor.addChild(root_1, PROPERTY96_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     
                                                                                            Atom propertyAtom = new Atom((PROPERTY96!=null?PROPERTY96.getText():null).substring(1));
                                                                                            propertyAtom.setProperty(true);
                                                                                            retval.value = propertyAtom;
                                                                                        

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:403:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER97=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atom2014); 
                    IDENTIFIER97_tree = (CommonTree)adaptor.dupNode(IDENTIFIER97);

                    adaptor.addChild(root_0, IDENTIFIER97_tree);


                    	                                                                    String idText = (IDENTIFIER97!=null?IDENTIFIER97.getText():null);
                                                                                            
                    	                                                                    if (idText.equals(".") && !isGPath) {
                    	                                                                        retval.value = getVariable(Tokens.ROOT_VARIABLE);
                    	                                                                    } else if (idText.matches("^[\\d]+..[\\d]+")) {
                                                                                                Matcher range = rangePattern.matcher(idText);
                                                                                                if (range.matches())
                                                                                                    retval.value = new Atom(new Range(range.group(1), range.group(2)));
                                                                                                else
                                                                                                    retval.value = new Atom(null);
                    	                                                                    } else {
                                                                                                Atom idAtom = new Atom((IDENTIFIER97!=null?IDENTIFIER97.getText():null));
                                                                                                idAtom.setIdentifier(true);
                                                                                                retval.value = idAtom;
                                                                                            }
                                                                                        

                    }
                    break;
                case 13 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:420:4: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_call_in_atom2070);
                    function_call98=function_call();

                    state._fsp--;

                    adaptor.addChild(root_0, function_call98.getTree());
                     retval.value = (function_call98!=null?function_call98.value:null); 

                    }
                    break;
                case 14 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:421:4: '(' statement ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal99=(CommonTree)match(input,78,FOLLOW_78_in_atom2123); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_atom2126);
                    statement100=statement();

                    state._fsp--;

                    adaptor.addChild(root_0, statement100.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal101=(CommonTree)match(input,79,FOLLOW_79_in_atom2128); 

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


 

    public static final BitSet FOLLOW_statement_in_program60 = new BitSet(new long[]{0x0000097FFF981892L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_collection_in_program71 = new BitSet(new long[]{0x0000097FFF981892L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_NEWLINE_in_program76 = new BitSet(new long[]{0x0000097FFF981892L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_if_statement_in_statement104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_definition_statement_in_statement215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_statement270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_statement298 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_statement300 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_statement_in_statement304 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_statement326 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement330 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_statement_in_statement334 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_68_in_statement351 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement356 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_statement_in_statement360 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_statement376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_include_statement419 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement421 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PATH_in_path_definition_statement458 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_path_definition_statement462 = new BitSet(new long[]{0x0000001000001000L});
    public static final BitSet FOLLOW_gpath_statement_in_path_definition_statement467 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_path_definition_statement474 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_path_definition_statement478 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GPATH_in_gpath_statement537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_step_in_gpath_statement540 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_STEP_in_step578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_in_step581 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_step583 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREDICATES_in_step587 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PREDICATE_in_step592 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_step594 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_token636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_token648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_statement673 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_if_statement676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_if_statement680 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_if_statement683 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_while_statement711 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_while_statement714 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_while_statement718 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_while_statement721 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_statement748 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement750 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_statement_in_foreach_statement754 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_block_in_foreach_statement756 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_repeat_statement784 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_repeat_statement788 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_block_in_repeat_statement790 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_block829 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block832 = new BitSet(new long[]{0x0000083FFF981898L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_81_in_expression860 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression865 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression869 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_82_in_expression883 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression887 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression891 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_83_in_expression905 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression910 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression914 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_85_in_expression928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression933 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression937 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_84_in_expression951 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression955 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression959 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_86_in_expression973 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression977 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression981 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_operation_in_expression994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_operation1039 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_operation1043 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_operation1047 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_88_in_operation1061 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_operation1065 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_operation1069 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binary_operation_in_operation1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_binary_operation1119 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_binary_operation1123 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_binary_operation1127 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_90_in_binary_operation1146 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_binary_operation1150 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_binary_operation1154 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_binary_operation1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_in_function_definition_statement1228 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_definition_statement1231 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_definition_statement1234 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1238 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_definition_statement1242 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1246 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_definition_statement1251 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_definition_statement1256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_function_definition_statement1258 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_function_definition_statement1267 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_function_call1304 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_call1307 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_call1310 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1314 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_call1318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1322 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_call1327 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_call1332 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_function_call1336 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COLLECTION_CALL_in_collection1383 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STEP_in_collection1386 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_in_collection1389 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_collection1391 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREDICATES_in_collection1395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PREDICATE_in_collection1400 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_collection1402 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_atom1449 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_INT_in_atom1451 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONG_in_atom1509 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_LONG_in_atom1511 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FLOAT_in_atom1567 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_FLOAT_in_atom1569 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLE_in_atom1623 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_DOUBLE_in_atom1625 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_atom1677 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_INT_in_atom1681 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_G_INT_in_atom1685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STR_in_atom1725 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_atom1727 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOOL_in_atom1780 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOLEAN_in_atom1784 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_atom1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARR_in_atom1907 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NUMBER_in_atom1910 = new BitSet(new long[]{0x0000000000000008L,0x0000000010000000L});
    public static final BitSet FOLLOW_VARIABLE_CALL_in_atom1925 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_atom1927 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_atom1970 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_atom1972 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_atom2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_atom2123 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_statement_in_atom2126 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_atom2128 = new BitSet(new long[]{0x0000000000000002L});

}
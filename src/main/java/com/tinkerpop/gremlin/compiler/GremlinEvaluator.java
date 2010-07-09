// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g 2010-07-09 15:37:14

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


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class GremlinEvaluator extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "PATH", "GPATH", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "SELF", "HISTORY", "FUNC_CALL", "IF", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "INT", "LONG", "FLOAT", "DOUBLE", "STR", "ARR", "BOOL", "NULL", "RANGE", "PROPERTY_CALL", "VARIABLE_CALL", "COLLECTION_CALL", "COMMENT", "VARIABLE", "NEWLINE", "StringLiteral", "IDENTIFIER", "G_INT", "G_LONG", "G_FLOAT", "G_DOUBLE", "BOOLEAN", "PROPERTY", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "':='", "'/'", "'['", "']'", "'..'", "'and'", "'or'", "'include'", "'if'", "'end'", "'foreach'", "'in'", "'while'", "'repeat'", "'path'", "'func'", "'('", "')'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "':'", "NUMBER"
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
    public static final int VARIABLE=40;
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
    public static final int NEWLINE=41;
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

            if (!(currentOperation instanceof DeclareVariable)) {
                declareVariable(Tokens.LAST_VARIABLE, result);
            }
            
        }


    public static class program_return extends TreeRuleReturnScope {
        public Iterable results;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:119:1: program returns [Iterable results] : ( ( statement | col= collection | ^( VAR VARIABLE c= collection ) ) ( NEWLINE )* )+ ;
    public final GremlinEvaluator.program_return program() throws RecognitionException {
        GremlinEvaluator.program_return retval = new GremlinEvaluator.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree VAR2=null;
        CommonTree VARIABLE3=null;
        CommonTree NEWLINE4=null;
        GremlinEvaluator.collection_return col = null;

        GremlinEvaluator.collection_return c = null;

        GremlinEvaluator.statement_return statement1 = null;


        CommonTree VAR2_tree=null;
        CommonTree VARIABLE3_tree=null;
        CommonTree NEWLINE4_tree=null;


                List<Object> resultList = new ArrayList<Object>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:5: ( ( ( statement | col= collection | ^( VAR VARIABLE c= collection ) ) ( NEWLINE )* )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:7: ( ( statement | col= collection | ^( VAR VARIABLE c= collection ) ) ( NEWLINE )* )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:7: ( ( statement | col= collection | ^( VAR VARIABLE c= collection ) ) ( NEWLINE )* )+
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:8: ( statement | col= collection | ^( VAR VARIABLE c= collection ) ) ( NEWLINE )*
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:8: ( statement | col= collection | ^( VAR VARIABLE c= collection ) )
            	    int alt1=3;
            	    switch ( input.LA(1) ) {
            	    case FUNC:
            	    case PATH:
            	    case GPATH:
            	    case FUNC_CALL:
            	    case IF:
            	    case FOREACH:
            	    case WHILE:
            	    case REPEAT:
            	    case INCLUDE:
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
            	    case 67:
            	    case 68:
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
            	        alt1=1;
            	        }
            	        break;
            	    case VAR:
            	        {
            	        int LA1_2 = input.LA(2);

            	        if ( (LA1_2==DOWN) ) {
            	            int LA1_4 = input.LA(3);

            	            if ( (LA1_4==VARIABLE) ) {
            	                int LA1_5 = input.LA(4);

            	                if ( (LA1_5==VAR||LA1_5==FUNC||(LA1_5>=PATH && LA1_5<=GPATH)||(LA1_5>=FUNC_CALL && LA1_5<=IF)||(LA1_5>=FOREACH && LA1_5<=VARIABLE_CALL)||LA1_5==IDENTIFIER||(LA1_5>=67 && LA1_5<=68)||LA1_5==78||(LA1_5>=81 && LA1_5<=90)) ) {
            	                    alt1=1;
            	                }
            	                else if ( (LA1_5==COLLECTION_CALL) ) {
            	                    alt1=3;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("", 1, 5, input);

            	                    throw nvae;
            	                }
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 1, 4, input);

            	                throw nvae;
            	            }
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 1, 2, input);

            	            throw nvae;
            	        }
            	        }
            	        break;
            	    case COLLECTION_CALL:
            	        {
            	        alt1=2;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:9: statement
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
            	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:126:10: col= collection
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            pushFollow(FOLLOW_collection_in_program73);
            	            col=collection();

            	            state._fsp--;

            	            adaptor.addChild(root_0, col.getTree());

            	                    formProgramResult(resultList, (col!=null?col.op:null));
            	                 

            	            }
            	            break;
            	        case 3 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:128:10: ^( VAR VARIABLE c= collection )
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            {
            	            CommonTree _save_last_1 = _last;
            	            CommonTree _first_1 = null;
            	            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            	            VAR2=(CommonTree)match(input,VAR,FOLLOW_VAR_in_program80); 
            	            VAR2_tree = (CommonTree)adaptor.dupNode(VAR2);

            	            root_1 = (CommonTree)adaptor.becomeRoot(VAR2_tree, root_1);



            	            match(input, Token.DOWN, null); 
            	            _last = (CommonTree)input.LT(1);
            	            VARIABLE3=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_program82); 
            	            VARIABLE3_tree = (CommonTree)adaptor.dupNode(VARIABLE3);

            	            adaptor.addChild(root_1, VARIABLE3_tree);

            	            _last = (CommonTree)input.LT(1);
            	            pushFollow(FOLLOW_collection_in_program86);
            	            c=collection();

            	            state._fsp--;

            	            adaptor.addChild(root_1, c.getTree());

            	            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            	            }


            	                    formProgramResult(resultList, new DeclareVariable((VARIABLE3!=null?VARIABLE3.getText():null), (c!=null?c.op:null))); 
            	                 

            	            }
            	            break;

            	    }

            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:130:9: ( NEWLINE )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==NEWLINE) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:130:9: NEWLINE
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    NEWLINE4=(CommonTree)match(input,NEWLINE,FOLLOW_NEWLINE_in_program92); 
            	    	    NEWLINE4_tree = (CommonTree)adaptor.dupNode(NEWLINE4);

            	    	    adaptor.addChild(root_0, NEWLINE4_tree);


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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:136:1: statement returns [Operation op] : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | ^( VAR VARIABLE s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression );
    public final GremlinEvaluator.statement_return statement() throws RecognitionException {
        GremlinEvaluator.statement_return retval = new GremlinEvaluator.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree VAR13=null;
        CommonTree VARIABLE14=null;
        CommonTree string_literal15=null;
        CommonTree string_literal16=null;
        GremlinEvaluator.statement_return s = null;

        GremlinEvaluator.statement_return a = null;

        GremlinEvaluator.statement_return b = null;

        GremlinEvaluator.if_statement_return if_statement5 = null;

        GremlinEvaluator.foreach_statement_return foreach_statement6 = null;

        GremlinEvaluator.while_statement_return while_statement7 = null;

        GremlinEvaluator.repeat_statement_return repeat_statement8 = null;

        GremlinEvaluator.path_definition_statement_return path_definition_statement9 = null;

        GremlinEvaluator.function_definition_statement_return function_definition_statement10 = null;

        GremlinEvaluator.include_statement_return include_statement11 = null;

        GremlinEvaluator.gpath_statement_return gpath_statement12 = null;

        GremlinEvaluator.expression_return expression17 = null;


        CommonTree VAR13_tree=null;
        CommonTree VARIABLE14_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree string_literal16_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:137:2: ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | ^( VAR VARIABLE s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:137:4: if_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_if_statement_in_statement120);
                    if_statement5=if_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, if_statement5.getTree());
                     retval.op = (if_statement5!=null?if_statement5.op:null); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:138:4: foreach_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_statement_in_statement150);
                    foreach_statement6=foreach_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, foreach_statement6.getTree());
                     retval.op = (foreach_statement6!=null?foreach_statement6.op:null); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:139:7: while_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_while_statement_in_statement178);
                    while_statement7=while_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, while_statement7.getTree());
                     retval.op = (while_statement7!=null?while_statement7.op:null); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:140:4: repeat_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_repeat_statement_in_statement205);
                    repeat_statement8=repeat_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, repeat_statement8.getTree());
                     retval.op = (repeat_statement8!=null?repeat_statement8.op:null); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:141:4: path_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_definition_statement_in_statement231);
                    path_definition_statement9=path_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, path_definition_statement9.getTree());
                     retval.op = (path_definition_statement9!=null?path_definition_statement9.op:null); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:142:4: function_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_definition_statement_in_statement248);
                    function_definition_statement10=function_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, function_definition_statement10.getTree());
                     retval.op = (function_definition_statement10!=null?function_definition_statement10.op:null); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:143:4: include_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_include_statement_in_statement261);
                    include_statement11=include_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, include_statement11.getTree());
                     retval.op = new UnaryOperation((include_statement11!=null?include_statement11.result:null)); 

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:144:4: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_statement286);
                    gpath_statement12=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, gpath_statement12.getTree());
                     retval.op = (gpath_statement12!=null?gpath_statement12.op:null); 

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:145:4: ^( VAR VARIABLE s= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VAR13=(CommonTree)match(input,VAR,FOLLOW_VAR_in_statement314); 
                    VAR13_tree = (CommonTree)adaptor.dupNode(VAR13);

                    root_1 = (CommonTree)adaptor.becomeRoot(VAR13_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VARIABLE14=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_statement316); 
                    VARIABLE14_tree = (CommonTree)adaptor.dupNode(VARIABLE14);

                    adaptor.addChild(root_1, VARIABLE14_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement320);
                    s=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, s.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new DeclareVariable((VARIABLE14!=null?VARIABLE14.getText():null), (s!=null?s.op:null)); 

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:146:9: ^( 'and' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal15=(CommonTree)match(input,67,FOLLOW_67_in_statement342); 
                    string_literal15_tree = (CommonTree)adaptor.dupNode(string_literal15);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal15_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement346);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement350);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new And((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:147:9: ^( 'or' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal16=(CommonTree)match(input,68,FOLLOW_68_in_statement367); 
                    string_literal16_tree = (CommonTree)adaptor.dupNode(string_literal16);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal16_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement372);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement376);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Or((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:148:9: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement392);
                    expression17=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression17.getTree());
                     retval.op = (expression17!=null?expression17.expr:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:151:1: include_statement returns [Atom result] : ^( INCLUDE StringLiteral ) ;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:152:2: ( ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:152:4: ^( INCLUDE StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            INCLUDE18=(CommonTree)match(input,INCLUDE,FOLLOW_INCLUDE_in_include_statement435); 
            INCLUDE18_tree = (CommonTree)adaptor.dupNode(INCLUDE18);

            root_1 = (CommonTree)adaptor.becomeRoot(INCLUDE18_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            StringLiteral19=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement437); 
            StringLiteral19_tree = (CommonTree)adaptor.dupNode(StringLiteral19);

            adaptor.addChild(root_1, StringLiteral19_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.result = new Atom(true);

                        String filename = (StringLiteral19!=null?StringLiteral19.getText():null);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:166:1: path_definition_statement returns [Operation op] : ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) ;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:170:2: ( ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:170:4: ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PATH20=(CommonTree)match(input,PATH,FOLLOW_PATH_in_path_definition_statement474); 
            PATH20_tree = (CommonTree)adaptor.dupNode(PATH20);

            root_1 = (CommonTree)adaptor.becomeRoot(PATH20_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            path_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_path_definition_statement478); 
            path_name_tree = (CommonTree)adaptor.dupNode(path_name);

            adaptor.addChild(root_1, path_name_tree);

            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:170:32: (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:170:33: gpath= gpath_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_path_definition_statement483);
                    gpath=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_1, gpath.getTree());
                     pipes.addAll(((GPathOperation)(gpath!=null?gpath.op:null)).getPipes()); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:170:115: ^( PROPERTY_CALL pr= PROPERTY )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    PROPERTY_CALL21=(CommonTree)match(input,PROPERTY_CALL,FOLLOW_PROPERTY_CALL_in_path_definition_statement490); 
                    PROPERTY_CALL21_tree = (CommonTree)adaptor.dupNode(PROPERTY_CALL21);

                    root_2 = (CommonTree)adaptor.becomeRoot(PROPERTY_CALL21_tree, root_2);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pr=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_path_definition_statement494); 
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:178:1: gpath_statement returns [Operation op] : ^( GPATH ( step )+ ) ;
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
                
                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeCount = 0;
                ((gpath_statement_scope)gpath_statement_stack.peek()).startPoint = null;
                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList = new ArrayList<Pipe>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:195:2: ( ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:195:4: ^( GPATH ( step )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            GPATH22=(CommonTree)match(input,GPATH,FOLLOW_GPATH_in_gpath_statement553); 
            GPATH22_tree = (CommonTree)adaptor.dupNode(GPATH22);

            root_1 = (CommonTree)adaptor.becomeRoot(GPATH22_tree, root_1);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:195:12: ( step )+
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:195:13: step
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_step_in_gpath_statement556);
            	    step23=step();

            	    state._fsp--;

            	    adaptor.addChild(root_1, step23.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:205:1: step : ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) ;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:209:5: ( ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:209:7: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            STEP24=(CommonTree)match(input,STEP,FOLLOW_STEP_in_step594); 
            STEP24_tree = (CommonTree)adaptor.dupNode(STEP24);

            root_1 = (CommonTree)adaptor.becomeRoot(STEP24_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TOKEN25=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_step597); 
            TOKEN25_tree = (CommonTree)adaptor.dupNode(TOKEN25);

            root_2 = (CommonTree)adaptor.becomeRoot(TOKEN25_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_token_in_step599);
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
            PREDICATES27=(CommonTree)match(input,PREDICATES,FOLLOW_PREDICATES_in_step603); 
            PREDICATES27_tree = (CommonTree)adaptor.dupNode(PREDICATES27);

            root_2 = (CommonTree)adaptor.becomeRoot(PREDICATES27_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:209:42: ( ^( PREDICATE statement ) )*
                loop7:
                do {
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==PREDICATE) ) {
                        alt7=1;
                    }


                    switch (alt7) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:209:44: ^( PREDICATE statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    PREDICATE28=(CommonTree)match(input,PREDICATE,FOLLOW_PREDICATE_in_step608); 
                	    PREDICATE28_tree = (CommonTree)adaptor.dupNode(PREDICATE28);

                	    root_3 = (CommonTree)adaptor.becomeRoot(PREDICATE28_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_step610);
                	    statement29=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_3, statement29.getTree());
                	     predicates.add((statement29!=null?statement29.op:null)); 

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


                        Atom tokenAtom = (token26!=null?token26.atom:null);
                        
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
                                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList.addAll(GremlinPipesHelper.pipesForStep((token26!=null?token26.atom:null), predicates));
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:232:1: token returns [Atom atom] : ( expression | gpath_statement | collection | '..' );
    public final GremlinEvaluator.token_return token() throws RecognitionException {
        GremlinEvaluator.token_return retval = new GremlinEvaluator.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal33=null;
        GremlinEvaluator.expression_return expression30 = null;

        GremlinEvaluator.gpath_statement_return gpath_statement31 = null;

        GremlinEvaluator.collection_return collection32 = null;


        CommonTree string_literal33_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:233:5: ( expression | gpath_statement | collection | '..' )
            int alt8=4;
            switch ( input.LA(1) ) {
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
                alt8=1;
                }
                break;
            case GPATH:
                {
                alt8=2;
                }
                break;
            case COLLECTION_CALL:
                {
                alt8=3;
                }
                break;
            case 66:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:233:8: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_token652);
                    expression30=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression30.getTree());
                     retval.atom = (expression30!=null?expression30.expr:null).compute(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:234:9: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_token664);
                    gpath_statement31=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, gpath_statement31.getTree());
                     retval.atom = (gpath_statement31!=null?gpath_statement31.op:null).compute(); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:235:9: collection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_collection_in_token676);
                    collection32=collection();

                    state._fsp--;

                    adaptor.addChild(root_0, collection32.getTree());
                     retval.atom = (collection32!=null?collection32.op:null).compute(); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:236:9: '..'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal33=(CommonTree)match(input,66,FOLLOW_66_in_token688); 
                    string_literal33_tree = (CommonTree)adaptor.dupNode(string_literal33);

                    adaptor.addChild(root_0, string_literal33_tree);



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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:270:1: if_statement returns [Operation op] : ^( IF ^( COND cond= statement ) block ) ;
    public final GremlinEvaluator.if_statement_return if_statement() throws RecognitionException {
        GremlinEvaluator.if_statement_return retval = new GremlinEvaluator.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IF34=null;
        CommonTree COND35=null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return block36 = null;


        CommonTree IF34_tree=null;
        CommonTree COND35_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:271:2: ( ^( IF ^( COND cond= statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:271:4: ^( IF ^( COND cond= statement ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            IF34=(CommonTree)match(input,IF,FOLLOW_IF_in_if_statement713); 
            IF34_tree = (CommonTree)adaptor.dupNode(IF34);

            root_1 = (CommonTree)adaptor.becomeRoot(IF34_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND35=(CommonTree)match(input,COND,FOLLOW_COND_in_if_statement716); 
            COND35_tree = (CommonTree)adaptor.dupNode(COND35);

            root_2 = (CommonTree)adaptor.becomeRoot(COND35_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_if_statement720);
            cond=statement();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_if_statement723);
            block36=block();

            state._fsp--;

            adaptor.addChild(root_1, block36.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new If((cond!=null?cond.op:null), (block36!=null?block36.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:277:1: while_statement returns [Operation op] : ^( WHILE ^( COND cond= statement ) block ) ;
    public final GremlinEvaluator.while_statement_return while_statement() throws RecognitionException {
        GremlinEvaluator.while_statement_return retval = new GremlinEvaluator.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree WHILE37=null;
        CommonTree COND38=null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return block39 = null;


        CommonTree WHILE37_tree=null;
        CommonTree COND38_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:278:2: ( ^( WHILE ^( COND cond= statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:278:4: ^( WHILE ^( COND cond= statement ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            WHILE37=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_while_statement751); 
            WHILE37_tree = (CommonTree)adaptor.dupNode(WHILE37);

            root_1 = (CommonTree)adaptor.becomeRoot(WHILE37_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND38=(CommonTree)match(input,COND,FOLLOW_COND_in_while_statement754); 
            COND38_tree = (CommonTree)adaptor.dupNode(COND38);

            root_2 = (CommonTree)adaptor.becomeRoot(COND38_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_while_statement758);
            cond=statement();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_while_statement761);
            block39=block();

            state._fsp--;

            adaptor.addChild(root_1, block39.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new While((cond!=null?cond.op:null), (block39!=null?block39.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:284:1: foreach_statement returns [Operation op] : ^( FOREACH VARIABLE arr= statement block ) ;
    public final GremlinEvaluator.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinEvaluator.foreach_statement_return retval = new GremlinEvaluator.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH40=null;
        CommonTree VARIABLE41=null;
        GremlinEvaluator.statement_return arr = null;

        GremlinEvaluator.block_return block42 = null;


        CommonTree FOREACH40_tree=null;
        CommonTree VARIABLE41_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:285:2: ( ^( FOREACH VARIABLE arr= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:285:4: ^( FOREACH VARIABLE arr= statement block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FOREACH40=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_statement788); 
            FOREACH40_tree = (CommonTree)adaptor.dupNode(FOREACH40);

            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH40_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            VARIABLE41=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement790); 
            VARIABLE41_tree = (CommonTree)adaptor.dupNode(VARIABLE41);

            adaptor.addChild(root_1, VARIABLE41_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_foreach_statement794);
            arr=statement();

            state._fsp--;

            adaptor.addChild(root_1, arr.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_foreach_statement796);
            block42=block();

            state._fsp--;

            adaptor.addChild(root_1, block42.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Foreach((VARIABLE41!=null?VARIABLE41.getText():null), (arr!=null?arr.op:null), (block42!=null?block42.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:291:1: repeat_statement returns [Operation op] : ^( REPEAT timer= statement block ) ;
    public final GremlinEvaluator.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinEvaluator.repeat_statement_return retval = new GremlinEvaluator.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REPEAT43=null;
        GremlinEvaluator.statement_return timer = null;

        GremlinEvaluator.block_return block44 = null;


        CommonTree REPEAT43_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:292:2: ( ^( REPEAT timer= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:292:4: ^( REPEAT timer= statement block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            REPEAT43=(CommonTree)match(input,REPEAT,FOLLOW_REPEAT_in_repeat_statement824); 
            REPEAT43_tree = (CommonTree)adaptor.dupNode(REPEAT43);

            root_1 = (CommonTree)adaptor.becomeRoot(REPEAT43_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_repeat_statement828);
            timer=statement();

            state._fsp--;

            adaptor.addChild(root_1, timer.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_repeat_statement830);
            block44=block();

            state._fsp--;

            adaptor.addChild(root_1, block44.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Repeat((timer!=null?timer.op:null), (block44!=null?block44.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:298:1: block returns [List<Operation> operations] : ^( BLOCK ( statement )+ ) ;
    public final GremlinEvaluator.block_return block() throws RecognitionException {
        GremlinEvaluator.block_return retval = new GremlinEvaluator.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BLOCK45=null;
        GremlinEvaluator.statement_return statement46 = null;


        CommonTree BLOCK45_tree=null;


                List<Operation> operationList = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:302:5: ( ^( BLOCK ( statement )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:302:7: ^( BLOCK ( statement )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            BLOCK45=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_block869); 
            BLOCK45_tree = (CommonTree)adaptor.dupNode(BLOCK45);

            root_1 = (CommonTree)adaptor.becomeRoot(BLOCK45_tree, root_1);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:302:15: ( statement )+
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:302:16: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_block872);
            	    statement46=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_1, statement46.getTree());
            	     operationList.add((statement46!=null?statement46.op:null)); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:305:1: expression returns [Operation expr] : ( ^( '=' a= operation b= operation ) | ^( '!=' a= operation b= operation ) | ^( '<' a= operation b= operation ) | ^( '>' a= operation b= operation ) | ^( '<=' a= operation b= operation ) | ^( '>=' a= operation b= operation ) | operation );
    public final GremlinEvaluator.expression_return expression() throws RecognitionException {
        GremlinEvaluator.expression_return retval = new GremlinEvaluator.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal47=null;
        CommonTree string_literal48=null;
        CommonTree char_literal49=null;
        CommonTree char_literal50=null;
        CommonTree string_literal51=null;
        CommonTree string_literal52=null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.operation_return operation53 = null;


        CommonTree char_literal47_tree=null;
        CommonTree string_literal48_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree char_literal50_tree=null;
        CommonTree string_literal51_tree=null;
        CommonTree string_literal52_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:306:5: ( ^( '=' a= operation b= operation ) | ^( '!=' a= operation b= operation ) | ^( '<' a= operation b= operation ) | ^( '>' a= operation b= operation ) | ^( '<=' a= operation b= operation ) | ^( '>=' a= operation b= operation ) | operation )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:306:9: ^( '=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal47=(CommonTree)match(input,81,FOLLOW_81_in_expression900); 
                    char_literal47_tree = (CommonTree)adaptor.dupNode(char_literal47);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal47_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression905);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression909);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new Equality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:307:9: ^( '!=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal48=(CommonTree)match(input,82,FOLLOW_82_in_expression923); 
                    string_literal48_tree = (CommonTree)adaptor.dupNode(string_literal48);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal48_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression927);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression931);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new UnEquality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:308:9: ^( '<' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal49=(CommonTree)match(input,83,FOLLOW_83_in_expression945); 
                    char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal49_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression950);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression954);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:309:9: ^( '>' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal50=(CommonTree)match(input,85,FOLLOW_85_in_expression968); 
                    char_literal50_tree = (CommonTree)adaptor.dupNode(char_literal50);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal50_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression973);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression977);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:310:9: ^( '<=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal51=(CommonTree)match(input,84,FOLLOW_84_in_expression991); 
                    string_literal51_tree = (CommonTree)adaptor.dupNode(string_literal51);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal51_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression995);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression999);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:311:9: ^( '>=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal52=(CommonTree)match(input,86,FOLLOW_86_in_expression1013); 
                    string_literal52_tree = (CommonTree)adaptor.dupNode(string_literal52);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal52_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression1017);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression1021);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:312:9: operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression1034);
                    operation53=operation();

                    state._fsp--;

                    adaptor.addChild(root_0, operation53.getTree());
                     retval.expr = (operation53!=null?operation53.op:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:315:1: operation returns [Operation op] : ( ^( '+' a= operation b= operation ) | ^( '-' a= operation b= operation ) | binary_operation );
    public final GremlinEvaluator.operation_return operation() throws RecognitionException {
        GremlinEvaluator.operation_return retval = new GremlinEvaluator.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal54=null;
        CommonTree char_literal55=null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.binary_operation_return binary_operation56 = null;


        CommonTree char_literal54_tree=null;
        CommonTree char_literal55_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:316:5: ( ^( '+' a= operation b= operation ) | ^( '-' a= operation b= operation ) | binary_operation )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:316:9: ^( '+' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,87,FOLLOW_87_in_operation1079); 
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal54_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1083);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1087);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Addition((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:317:9: ^( '-' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal55=(CommonTree)match(input,88,FOLLOW_88_in_operation1101); 
                    char_literal55_tree = (CommonTree)adaptor.dupNode(char_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal55_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1105);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1109);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Subtraction((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:318:9: binary_operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_binary_operation_in_operation1122);
                    binary_operation56=binary_operation();

                    state._fsp--;

                    adaptor.addChild(root_0, binary_operation56.getTree());
                     retval.op = (binary_operation56!=null?binary_operation56.operation:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:321:1: binary_operation returns [Operation operation] : ( ^( '*' a= operation b= operation ) | ^( 'div' a= operation b= operation ) | atom );
    public final GremlinEvaluator.binary_operation_return binary_operation() throws RecognitionException {
        GremlinEvaluator.binary_operation_return retval = new GremlinEvaluator.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal57=null;
        CommonTree string_literal58=null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.atom_return atom59 = null;


        CommonTree char_literal57_tree=null;
        CommonTree string_literal58_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:322:5: ( ^( '*' a= operation b= operation ) | ^( 'div' a= operation b= operation ) | atom )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:322:9: ^( '*' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal57=(CommonTree)match(input,89,FOLLOW_89_in_binary_operation1159); 
                    char_literal57_tree = (CommonTree)adaptor.dupNode(char_literal57);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal57_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1163);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1167);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Multiplication((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:323:9: ^( 'div' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal58=(CommonTree)match(input,90,FOLLOW_90_in_binary_operation1186); 
                    string_literal58_tree = (CommonTree)adaptor.dupNode(string_literal58);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal58_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1190);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1194);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Division((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:324:9: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atom_in_binary_operation1210);
                    atom59=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom59.getTree());
                     retval.operation = new UnaryOperation((atom59!=null?atom59.value:null)); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:327:1: function_definition_statement returns [Operation op] : ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) ;
    public final GremlinEvaluator.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinEvaluator.function_definition_statement_return retval = new GremlinEvaluator.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC60=null;
        CommonTree FUNC_NAME61=null;
        CommonTree NS62=null;
        CommonTree NAME63=null;
        CommonTree ARGS64=null;
        CommonTree ARG65=null;
        CommonTree VARIABLE66=null;
        GremlinEvaluator.block_return block67 = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC60_tree=null;
        CommonTree FUNC_NAME61_tree=null;
        CommonTree NS62_tree=null;
        CommonTree NAME63_tree=null;
        CommonTree ARGS64_tree=null;
        CommonTree ARG65_tree=null;
        CommonTree VARIABLE66_tree=null;


                List<String> params = new ArrayList<String>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:331:2: ( ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:331:4: ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC60=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_function_definition_statement1268); 
            FUNC60_tree = (CommonTree)adaptor.dupNode(FUNC60);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC60_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME61=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_definition_statement1271); 
            FUNC_NAME61_tree = (CommonTree)adaptor.dupNode(FUNC_NAME61);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME61_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS62=(CommonTree)match(input,NS,FOLLOW_NS_in_function_definition_statement1274); 
            NS62_tree = (CommonTree)adaptor.dupNode(NS62);

            root_3 = (CommonTree)adaptor.becomeRoot(NS62_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1278); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME63=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_definition_statement1282); 
            NAME63_tree = (CommonTree)adaptor.dupNode(NAME63);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME63_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1286); 
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
            ARGS64=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_definition_statement1291); 
            ARGS64_tree = (CommonTree)adaptor.dupNode(ARGS64);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS64_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:331:78: ( ^( ARG VARIABLE ) )*
                loop13:
                do {
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==ARG) ) {
                        alt13=1;
                    }


                    switch (alt13) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:331:80: ^( ARG VARIABLE )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG65=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_definition_statement1296); 
                	    ARG65_tree = (CommonTree)adaptor.dupNode(ARG65);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG65_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    VARIABLE66=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_function_definition_statement1298); 
                	    VARIABLE66_tree = (CommonTree)adaptor.dupNode(VARIABLE66);

                	    adaptor.addChild(root_3, VARIABLE66_tree);

                	     params.add((VARIABLE66!=null?VARIABLE66.getText():null)); 

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
            pushFollow(FOLLOW_block_in_function_definition_statement1307);
            block67=block();

            state._fsp--;

            adaptor.addChild(root_1, block67.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        NativeFunction fn = new NativeFunction((fn_name!=null?fn_name.getText():null), params, (block67!=null?block67.operations:null));
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:340:1: function_call returns [Atom value] : ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) ;
    public final GremlinEvaluator.function_call_return function_call() throws RecognitionException {
        GremlinEvaluator.function_call_return retval = new GremlinEvaluator.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC_CALL68=null;
        CommonTree FUNC_NAME69=null;
        CommonTree NS70=null;
        CommonTree NAME71=null;
        CommonTree ARGS72=null;
        CommonTree ARG73=null;
        GremlinEvaluator.statement_return st = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC_CALL68_tree=null;
        CommonTree FUNC_NAME69_tree=null;
        CommonTree NS70_tree=null;
        CommonTree NAME71_tree=null;
        CommonTree ARGS72_tree=null;
        CommonTree ARG73_tree=null;


                List<Operation> params = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:344:2: ( ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:344:4: ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_CALL68=(CommonTree)match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_function_call1344); 
            FUNC_CALL68_tree = (CommonTree)adaptor.dupNode(FUNC_CALL68);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_CALL68_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME69=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_call1347); 
            FUNC_NAME69_tree = (CommonTree)adaptor.dupNode(FUNC_NAME69);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME69_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS70=(CommonTree)match(input,NS,FOLLOW_NS_in_function_call1350); 
            NS70_tree = (CommonTree)adaptor.dupNode(NS70);

            root_3 = (CommonTree)adaptor.becomeRoot(NS70_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1354); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME71=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_call1358); 
            NAME71_tree = (CommonTree)adaptor.dupNode(NAME71);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME71_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1362); 
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
            ARGS72=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_call1367); 
            ARGS72_tree = (CommonTree)adaptor.dupNode(ARGS72);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS72_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:344:83: ( ^( ARG st= statement ) )*
                loop14:
                do {
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==ARG) ) {
                        alt14=1;
                    }


                    switch (alt14) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:344:85: ^( ARG st= statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG73=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_call1372); 
                	    ARG73_tree = (CommonTree)adaptor.dupNode(ARG73);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG73_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_function_call1376);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:354:1: collection returns [Operation op] : ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) ) ;
    public final GremlinEvaluator.collection_return collection() throws RecognitionException {
        GremlinEvaluator.collection_return retval = new GremlinEvaluator.collection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COLLECTION_CALL74=null;
        CommonTree STEP75=null;
        CommonTree TOKEN76=null;
        CommonTree PREDICATES78=null;
        CommonTree PREDICATE79=null;
        GremlinEvaluator.token_return token77 = null;

        GremlinEvaluator.statement_return statement80 = null;


        CommonTree COLLECTION_CALL74_tree=null;
        CommonTree STEP75_tree=null;
        CommonTree TOKEN76_tree=null;
        CommonTree PREDICATES78_tree=null;
        CommonTree PREDICATE79_tree=null;


                Object startPoint = null;
                List<Pipe> pipes = new ArrayList<Pipe>();
                List<Operation> predicates = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:360:5: ( ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:360:7: ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COLLECTION_CALL74=(CommonTree)match(input,COLLECTION_CALL,FOLLOW_COLLECTION_CALL_in_collection1423); 
            COLLECTION_CALL74_tree = (CommonTree)adaptor.dupNode(COLLECTION_CALL74);

            root_1 = (CommonTree)adaptor.becomeRoot(COLLECTION_CALL74_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            STEP75=(CommonTree)match(input,STEP,FOLLOW_STEP_in_collection1426); 
            STEP75_tree = (CommonTree)adaptor.dupNode(STEP75);

            root_2 = (CommonTree)adaptor.becomeRoot(STEP75_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TOKEN76=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_collection1429); 
            TOKEN76_tree = (CommonTree)adaptor.dupNode(TOKEN76);

            root_3 = (CommonTree)adaptor.becomeRoot(TOKEN76_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_token_in_collection1431);
            token77=token();

            state._fsp--;

            adaptor.addChild(root_3, token77.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PREDICATES78=(CommonTree)match(input,PREDICATES,FOLLOW_PREDICATES_in_collection1435); 
            PREDICATES78_tree = (CommonTree)adaptor.dupNode(PREDICATES78);

            root_3 = (CommonTree)adaptor.becomeRoot(PREDICATES78_tree, root_3);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:360:60: ( ^( PREDICATE statement ) )+
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:360:62: ^( PREDICATE statement )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_4 = _last;
            	    CommonTree _first_4 = null;
            	    CommonTree root_4 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            	    PREDICATE79=(CommonTree)match(input,PREDICATE,FOLLOW_PREDICATE_in_collection1440); 
            	    PREDICATE79_tree = (CommonTree)adaptor.dupNode(PREDICATE79);

            	    root_4 = (CommonTree)adaptor.becomeRoot(PREDICATE79_tree, root_4);



            	    match(input, Token.DOWN, null); 
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_collection1442);
            	    statement80=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_4, statement80.getTree());
            	     predicates.add((statement80!=null?statement80.op:null)); 

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


                    Atom tokenAtom = (token77!=null?token77.atom:null);

                    if (tokenAtom.isIdentifier() && ((String)tokenAtom.getValue()).equals(".")) {
                        startPoint = GremlinEvaluator.getVariable(Tokens.ROOT_VARIABLE).getValue();
                    } else if (paths.isPath(tokenAtom.getValue().toString())) {
                        pipes.addAll(paths.getPath((String)tokenAtom.getValue()));
                        startPoint = GremlinEvaluator.getVariable(Tokens.ROOT_VARIABLE).getValue();
                    } else {
                        startPoint = tokenAtom.getValue();
                    }

                    pipes.addAll(GremlinPipesHelper.pipesForStep(predicates));

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:380:1: atom returns [Atom value] : ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | ^( RANGE min= G_INT max= G_INT ) | ^( STR StringLiteral ) | ^( BOOL b= BOOLEAN ) | NULL | ^( ARR ( NUMBER )+ ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | function_call | '(' statement ')' );
    public final GremlinEvaluator.atom_return atom() throws RecognitionException {
        GremlinEvaluator.atom_return retval = new GremlinEvaluator.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree min=null;
        CommonTree max=null;
        CommonTree b=null;
        CommonTree INT81=null;
        CommonTree G_INT82=null;
        CommonTree LONG83=null;
        CommonTree G_LONG84=null;
        CommonTree FLOAT85=null;
        CommonTree G_FLOAT86=null;
        CommonTree DOUBLE87=null;
        CommonTree G_DOUBLE88=null;
        CommonTree RANGE89=null;
        CommonTree STR90=null;
        CommonTree StringLiteral91=null;
        CommonTree BOOL92=null;
        CommonTree NULL93=null;
        CommonTree ARR94=null;
        CommonTree NUMBER95=null;
        CommonTree VARIABLE_CALL96=null;
        CommonTree VARIABLE97=null;
        CommonTree PROPERTY_CALL98=null;
        CommonTree PROPERTY99=null;
        CommonTree IDENTIFIER100=null;
        CommonTree char_literal102=null;
        CommonTree char_literal104=null;
        GremlinEvaluator.function_call_return function_call101 = null;

        GremlinEvaluator.statement_return statement103 = null;


        CommonTree min_tree=null;
        CommonTree max_tree=null;
        CommonTree b_tree=null;
        CommonTree INT81_tree=null;
        CommonTree G_INT82_tree=null;
        CommonTree LONG83_tree=null;
        CommonTree G_LONG84_tree=null;
        CommonTree FLOAT85_tree=null;
        CommonTree G_FLOAT86_tree=null;
        CommonTree DOUBLE87_tree=null;
        CommonTree G_DOUBLE88_tree=null;
        CommonTree RANGE89_tree=null;
        CommonTree STR90_tree=null;
        CommonTree StringLiteral91_tree=null;
        CommonTree BOOL92_tree=null;
        CommonTree NULL93_tree=null;
        CommonTree ARR94_tree=null;
        CommonTree NUMBER95_tree=null;
        CommonTree VARIABLE_CALL96_tree=null;
        CommonTree VARIABLE97_tree=null;
        CommonTree PROPERTY_CALL98_tree=null;
        CommonTree PROPERTY99_tree=null;
        CommonTree IDENTIFIER100_tree=null;
        CommonTree char_literal102_tree=null;
        CommonTree char_literal104_tree=null;


                List<Double> array = new ArrayList<Double>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:384:2: ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | ^( RANGE min= G_INT max= G_INT ) | ^( STR StringLiteral ) | ^( BOOL b= BOOLEAN ) | NULL | ^( ARR ( NUMBER )+ ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | function_call | '(' statement ')' )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:384:6: ^( INT G_INT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    INT81=(CommonTree)match(input,INT,FOLLOW_INT_in_atom1489); 
                    INT81_tree = (CommonTree)adaptor.dupNode(INT81);

                    root_1 = (CommonTree)adaptor.becomeRoot(INT81_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_INT82=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1491); 
                    G_INT82_tree = (CommonTree)adaptor.dupNode(G_INT82);

                    adaptor.addChild(root_1, G_INT82_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Integer>(new Integer((G_INT82!=null?G_INT82.getText():null))); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:385:6: ^( LONG G_LONG )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    LONG83=(CommonTree)match(input,LONG,FOLLOW_LONG_in_atom1549); 
                    LONG83_tree = (CommonTree)adaptor.dupNode(LONG83);

                    root_1 = (CommonTree)adaptor.becomeRoot(LONG83_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_LONG84=(CommonTree)match(input,G_LONG,FOLLOW_G_LONG_in_atom1551); 
                    G_LONG84_tree = (CommonTree)adaptor.dupNode(G_LONG84);

                    adaptor.addChild(root_1, G_LONG84_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String longStr = (G_LONG84!=null?G_LONG84.getText():null);
                    	                                                                    retval.value = new Atom<Long>(new Long(longStr.substring(0, longStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:389:6: ^( FLOAT G_FLOAT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    FLOAT85=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_atom1607); 
                    FLOAT85_tree = (CommonTree)adaptor.dupNode(FLOAT85);

                    root_1 = (CommonTree)adaptor.becomeRoot(FLOAT85_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_FLOAT86=(CommonTree)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_atom1609); 
                    G_FLOAT86_tree = (CommonTree)adaptor.dupNode(G_FLOAT86);

                    adaptor.addChild(root_1, G_FLOAT86_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Float>(new Float((G_FLOAT86!=null?G_FLOAT86.getText():null))); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:390:6: ^( DOUBLE G_DOUBLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    DOUBLE87=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_atom1663); 
                    DOUBLE87_tree = (CommonTree)adaptor.dupNode(DOUBLE87);

                    root_1 = (CommonTree)adaptor.becomeRoot(DOUBLE87_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_DOUBLE88=(CommonTree)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_atom1665); 
                    G_DOUBLE88_tree = (CommonTree)adaptor.dupNode(G_DOUBLE88);

                    adaptor.addChild(root_1, G_DOUBLE88_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String doubleStr = (G_DOUBLE88!=null?G_DOUBLE88.getText():null);
                    	                                                                    retval.value = new Atom<Double>(new Double(doubleStr.substring(0, doubleStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:394:6: ^( RANGE min= G_INT max= G_INT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    RANGE89=(CommonTree)match(input,RANGE,FOLLOW_RANGE_in_atom1717); 
                    RANGE89_tree = (CommonTree)adaptor.dupNode(RANGE89);

                    root_1 = (CommonTree)adaptor.becomeRoot(RANGE89_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    min=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1721); 
                    min_tree = (CommonTree)adaptor.dupNode(min);

                    adaptor.addChild(root_1, min_tree);

                    _last = (CommonTree)input.LT(1);
                    max=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1725); 
                    max_tree = (CommonTree)adaptor.dupNode(max);

                    adaptor.addChild(root_1, max_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom(new Range((min!=null?min.getText():null), (max!=null?max.getText():null))); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:395:4: ^( STR StringLiteral )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    STR90=(CommonTree)match(input,STR,FOLLOW_STR_in_atom1765); 
                    STR90_tree = (CommonTree)adaptor.dupNode(STR90);

                    root_1 = (CommonTree)adaptor.becomeRoot(STR90_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    StringLiteral91=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_atom1767); 
                    StringLiteral91_tree = (CommonTree)adaptor.dupNode(StringLiteral91);

                    adaptor.addChild(root_1, StringLiteral91_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom((StringLiteral91!=null?StringLiteral91.getText():null)); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:396:9: ^( BOOL b= BOOLEAN )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    BOOL92=(CommonTree)match(input,BOOL,FOLLOW_BOOL_in_atom1820); 
                    BOOL92_tree = (CommonTree)adaptor.dupNode(BOOL92);

                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL92_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    b=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_atom1824); 
                    b_tree = (CommonTree)adaptor.dupNode(b);

                    adaptor.addChild(root_1, b_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom(new Boolean((b!=null?b.getText():null))); 

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:397:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    NULL93=(CommonTree)match(input,NULL,FOLLOW_NULL_in_atom1879); 
                    NULL93_tree = (CommonTree)adaptor.dupNode(NULL93);

                    adaptor.addChild(root_0, NULL93_tree);

                     retval.value = new Atom(null); 

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:398:9: ^( ARR ( NUMBER )+ )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    ARR94=(CommonTree)match(input,ARR,FOLLOW_ARR_in_atom1947); 
                    ARR94_tree = (CommonTree)adaptor.dupNode(ARR94);

                    root_1 = (CommonTree)adaptor.becomeRoot(ARR94_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:398:15: ( NUMBER )+
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
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:398:16: NUMBER
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    NUMBER95=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_atom1950); 
                    	    NUMBER95_tree = (CommonTree)adaptor.dupNode(NUMBER95);

                    	    adaptor.addChild(root_1, NUMBER95_tree);

                    	     array.add(new Double((NUMBER95!=null?NUMBER95.getText():null))); 

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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:399:4: ^( VARIABLE_CALL VARIABLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VARIABLE_CALL96=(CommonTree)match(input,VARIABLE_CALL,FOLLOW_VARIABLE_CALL_in_atom1965); 
                    VARIABLE_CALL96_tree = (CommonTree)adaptor.dupNode(VARIABLE_CALL96);

                    root_1 = (CommonTree)adaptor.becomeRoot(VARIABLE_CALL96_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VARIABLE97=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_atom1967); 
                    VARIABLE97_tree = (CommonTree)adaptor.dupNode(VARIABLE97);

                    adaptor.addChild(root_1, VARIABLE97_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     
                                                                                          retval.value = getVariable((VARIABLE97!=null?VARIABLE97.getText():null)); 
                                                                                        

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:402:4: ^( PROPERTY_CALL PROPERTY )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    PROPERTY_CALL98=(CommonTree)match(input,PROPERTY_CALL,FOLLOW_PROPERTY_CALL_in_atom2010); 
                    PROPERTY_CALL98_tree = (CommonTree)adaptor.dupNode(PROPERTY_CALL98);

                    root_1 = (CommonTree)adaptor.becomeRoot(PROPERTY_CALL98_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    PROPERTY99=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_atom2012); 
                    PROPERTY99_tree = (CommonTree)adaptor.dupNode(PROPERTY99);

                    adaptor.addChild(root_1, PROPERTY99_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     
                                                                                            Atom propertyAtom = new Atom((PROPERTY99!=null?PROPERTY99.getText():null).substring(1));
                                                                                            propertyAtom.setProperty(true);
                                                                                            retval.value = propertyAtom;
                                                                                        

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:407:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER100=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atom2054); 
                    IDENTIFIER100_tree = (CommonTree)adaptor.dupNode(IDENTIFIER100);

                    adaptor.addChild(root_0, IDENTIFIER100_tree);


                    	                                                                    String idText = (IDENTIFIER100!=null?IDENTIFIER100.getText():null);
                                                                                            
                    	                                                                    if (idText.equals(".") && !isGPath) {
                    	                                                                        retval.value = getVariable(Tokens.ROOT_VARIABLE);
                    	                                                                    } else if (idText.matches("^[\\d]+..[\\d]+")) {
                                                                                                Matcher range = rangePattern.matcher(idText);
                                                                                                if (range.matches())
                                                                                                    retval.value = new Atom(new Range(range.group(1), range.group(2)));
                                                                                                else
                                                                                                    retval.value = new Atom(null);
                    	                                                                    } else {
                                                                                                Atom idAtom = new Atom((IDENTIFIER100!=null?IDENTIFIER100.getText():null));
                                                                                                idAtom.setIdentifier(true);
                                                                                                retval.value = idAtom;
                                                                                            }
                                                                                        

                    }
                    break;
                case 13 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:424:4: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_call_in_atom2110);
                    function_call101=function_call();

                    state._fsp--;

                    adaptor.addChild(root_0, function_call101.getTree());
                     retval.value = (function_call101!=null?function_call101.value:null); 

                    }
                    break;
                case 14 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:425:4: '(' statement ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal102=(CommonTree)match(input,78,FOLLOW_78_in_atom2163); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_atom2166);
                    statement103=statement();

                    state._fsp--;

                    adaptor.addChild(root_0, statement103.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal104=(CommonTree)match(input,79,FOLLOW_79_in_atom2168); 

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


 

    public static final BitSet FOLLOW_statement_in_program60 = new BitSet(new long[]{0x00000A7FFF981892L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_collection_in_program73 = new BitSet(new long[]{0x00000A7FFF981892L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_VAR_in_program80 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_program82 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_collection_in_program86 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEWLINE_in_program92 = new BitSet(new long[]{0x00000A7FFF981892L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_if_statement_in_statement120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_definition_statement_in_statement231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_statement286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_statement314 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_statement316 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_statement_in_statement320 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_statement342 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement346 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_statement_in_statement350 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_68_in_statement367 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement372 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_statement_in_statement376 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_statement392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_include_statement435 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement437 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PATH_in_path_definition_statement474 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_path_definition_statement478 = new BitSet(new long[]{0x0000001000001000L});
    public static final BitSet FOLLOW_gpath_statement_in_path_definition_statement483 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_path_definition_statement490 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_path_definition_statement494 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GPATH_in_gpath_statement553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_step_in_gpath_statement556 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_STEP_in_step594 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_in_step597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_step599 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREDICATES_in_step603 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PREDICATE_in_step608 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_step610 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_token652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_token664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_in_token676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_token688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_statement713 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_if_statement716 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_if_statement720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_if_statement723 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_while_statement751 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_while_statement754 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_while_statement758 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_while_statement761 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_statement788 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement790 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_statement_in_foreach_statement794 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_block_in_foreach_statement796 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_repeat_statement824 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_repeat_statement828 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_block_in_repeat_statement830 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_block869 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block872 = new BitSet(new long[]{0x0000083FFF981898L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_81_in_expression900 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression905 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression909 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_82_in_expression923 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression927 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression931 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_83_in_expression945 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression950 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression954 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_85_in_expression968 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression973 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression977 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_84_in_expression991 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression995 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression999 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_86_in_expression1013 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression1017 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_expression1021 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_operation_in_expression1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_operation1079 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_operation1083 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_operation1087 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_88_in_operation1101 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_operation1105 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_operation1109 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binary_operation_in_operation1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_binary_operation1159 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_binary_operation1163 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_binary_operation1167 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_90_in_binary_operation1186 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_binary_operation1190 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_operation_in_binary_operation1194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_binary_operation1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_in_function_definition_statement1268 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_definition_statement1271 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_definition_statement1274 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1278 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_definition_statement1282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1286 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_definition_statement1291 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_definition_statement1296 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_function_definition_statement1298 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_function_definition_statement1307 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_function_call1344 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_call1347 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_call1350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1354 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_call1358 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_call1367 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_call1372 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_function_call1376 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COLLECTION_CALL_in_collection1423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STEP_in_collection1426 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_in_collection1429 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_collection1431 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREDICATES_in_collection1435 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PREDICATE_in_collection1440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_collection1442 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_atom1489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_INT_in_atom1491 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONG_in_atom1549 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_LONG_in_atom1551 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FLOAT_in_atom1607 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_FLOAT_in_atom1609 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLE_in_atom1663 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_DOUBLE_in_atom1665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_atom1717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_INT_in_atom1721 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_G_INT_in_atom1725 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STR_in_atom1765 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_atom1767 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOOL_in_atom1820 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOLEAN_in_atom1824 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_atom1879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARR_in_atom1947 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NUMBER_in_atom1950 = new BitSet(new long[]{0x0000000000000008L,0x0000000010000000L});
    public static final BitSet FOLLOW_VARIABLE_CALL_in_atom1965 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_atom1967 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_atom2010 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_atom2012 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom2054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_atom2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_atom2163 = new BitSet(new long[]{0x0000083FFF981890L,0x0000000007FE4018L});
    public static final BitSet FOLLOW_statement_in_atom2166 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_atom2168 = new BitSet(new long[]{0x0000000000000002L});

}
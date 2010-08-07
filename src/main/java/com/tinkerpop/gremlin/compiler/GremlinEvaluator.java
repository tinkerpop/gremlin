// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g 2010-08-08 00:59:42

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


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class GremlinEvaluator extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "PATH", "GPATH", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "SELF", "HISTORY", "FUNC_CALL", "IF", "ELSE", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "SCRIPT", "INT", "LONG", "FLOAT", "DOUBLE", "STR", "ARR", "BOOL", "NULL", "RANGE", "PROPERTY_CALL", "VARIABLE_CALL", "COLLECTION_CALL", "COMMENT", "VARIABLE", "NEWLINE", "StringLiteral", "IDENTIFIER", "G_INT", "G_LONG", "G_FLOAT", "G_DOUBLE", "BOOLEAN", "PROPERTY", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "':='", "'/'", "'['", "']'", "'..'", "'and'", "'or'", "'include'", "'script'", "'if'", "'else'", "'end'", "'foreach'", "'in'", "'while'", "'repeat'", "'path'", "'func'", "'('", "')'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "'mod'", "':'", "NUMBER"
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
    public static final int G_INT=46;
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
    public static final int NUMBER=97;
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
    public static final int VARIABLE=42;
    public static final int T__70=70;
    public static final int G_DOUBLE=49;
    public static final int PROPERTY=51;
    public static final int FUNC=7;
    public static final int G_LONG=47;
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
    public static final int BOOLEAN=50;
    public static final int IDENTIFIER=45;
    public static final int EscapeCharacter=61;
    public static final int COLLECTION_CALL=40;
    public static final int G_FLOAT=48;
    public static final int PROPERTY_CALL=38;
    public static final int UnicodeEscapeSequence=58;
    public static final int RANGE=37;
    public static final int StringLiteral=44;
    public static final int NEWLINE=43;
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
            } catch(Exception e) {
                throw new RuntimeException(e);
            }

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


    public static class program_return extends TreeRuleReturnScope {
        public Iterable results;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:135:1: program returns [Iterable results] : ( ( statement | col= collection | ^( VAR VARIABLE c= collection ) ) ( NEWLINE )* )+ ;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:139:5: ( ( ( statement | col= collection | ^( VAR VARIABLE c= collection ) ) ( NEWLINE )* )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:139:7: ( ( statement | col= collection | ^( VAR VARIABLE c= collection ) ) ( NEWLINE )* )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:139:7: ( ( statement | col= collection | ^( VAR VARIABLE c= collection ) ) ( NEWLINE )* )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==VAR||LA3_0==FUNC||(LA3_0>=PATH && LA3_0<=GPATH)||(LA3_0>=FUNC_CALL && LA3_0<=IF)||(LA3_0>=FOREACH && LA3_0<=COLLECTION_CALL)||LA3_0==IDENTIFIER||(LA3_0>=69 && LA3_0<=70)||LA3_0==82||(LA3_0>=85 && LA3_0<=95)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:139:8: ( statement | col= collection | ^( VAR VARIABLE c= collection ) ) ( NEWLINE )*
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:139:8: ( statement | col= collection | ^( VAR VARIABLE c= collection ) )
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
            	    case SCRIPT:
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
            	    case 69:
            	    case 70:
            	    case 82:
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

            	                if ( (LA1_5==COLLECTION_CALL) ) {
            	                    alt1=3;
            	                }
            	                else if ( (LA1_5==VAR||LA1_5==FUNC||(LA1_5>=PATH && LA1_5<=GPATH)||(LA1_5>=FUNC_CALL && LA1_5<=IF)||(LA1_5>=FOREACH && LA1_5<=VARIABLE_CALL)||LA1_5==IDENTIFIER||(LA1_5>=69 && LA1_5<=70)||LA1_5==82||(LA1_5>=85 && LA1_5<=95)) ) {
            	                    alt1=1;
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
            	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:139:9: statement
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
            	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:142:10: col= collection
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
            	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:144:10: ^( VAR VARIABLE c= collection )
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


            	                    formProgramResult(resultList, new DeclareVariable((VARIABLE3!=null?VARIABLE3.getText():null), (c!=null?c.op:null), this.context)); 
            	                 

            	            }
            	            break;

            	    }

            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:146:9: ( NEWLINE )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==NEWLINE) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:146:9: NEWLINE
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:152:1: statement returns [Operation op] : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | script_statement | gpath_statement | ^( VAR VARIABLE s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression );
    public final GremlinEvaluator.statement_return statement() throws RecognitionException {
        GremlinEvaluator.statement_return retval = new GremlinEvaluator.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree VAR14=null;
        CommonTree VARIABLE15=null;
        CommonTree string_literal16=null;
        CommonTree string_literal17=null;
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

        GremlinEvaluator.script_statement_return script_statement12 = null;

        GremlinEvaluator.gpath_statement_return gpath_statement13 = null;

        GremlinEvaluator.expression_return expression18 = null;


        CommonTree VAR14_tree=null;
        CommonTree VARIABLE15_tree=null;
        CommonTree string_literal16_tree=null;
        CommonTree string_literal17_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:153:2: ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | script_statement | gpath_statement | ^( VAR VARIABLE s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression )
            int alt4=13;
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
            case SCRIPT:
                {
                alt4=8;
                }
                break;
            case GPATH:
                {
                alt4=9;
                }
                break;
            case VAR:
                {
                alt4=10;
                }
                break;
            case 69:
                {
                alt4=11;
                }
                break;
            case 70:
                {
                alt4=12;
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
            case 82:
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
                alt4=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:153:4: if_statement
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:154:4: foreach_statement
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:155:7: while_statement
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:156:4: repeat_statement
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:157:4: path_definition_statement
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:158:4: function_definition_statement
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:159:4: include_statement
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:160:6: script_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_script_statement_in_statement288);
                    script_statement12=script_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, script_statement12.getTree());
                     retval.op = new UnaryOperation((script_statement12!=null?script_statement12.result:null)); 

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:161:4: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_statement314);
                    gpath_statement13=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, gpath_statement13.getTree());
                     retval.op = (gpath_statement13!=null?gpath_statement13.op:null); 

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:162:4: ^( VAR VARIABLE s= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VAR14=(CommonTree)match(input,VAR,FOLLOW_VAR_in_statement342); 
                    VAR14_tree = (CommonTree)adaptor.dupNode(VAR14);

                    root_1 = (CommonTree)adaptor.becomeRoot(VAR14_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VARIABLE15=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_statement344); 
                    VARIABLE15_tree = (CommonTree)adaptor.dupNode(VARIABLE15);

                    adaptor.addChild(root_1, VARIABLE15_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement348);
                    s=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, s.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new DeclareVariable((VARIABLE15!=null?VARIABLE15.getText():null), (s!=null?s.op:null), this.context); 

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:163:9: ^( 'and' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal16=(CommonTree)match(input,69,FOLLOW_69_in_statement370); 
                    string_literal16_tree = (CommonTree)adaptor.dupNode(string_literal16);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal16_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement374);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement378);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new And((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:164:9: ^( 'or' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal17=(CommonTree)match(input,70,FOLLOW_70_in_statement395); 
                    string_literal17_tree = (CommonTree)adaptor.dupNode(string_literal17);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal17_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement400);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement404);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Or((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 13 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:165:9: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement420);
                    expression18=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression18.getTree());
                     retval.op = (expression18!=null?expression18.expr:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:168:1: script_statement returns [Atom result] : ^( SCRIPT StringLiteral ) ;
    public final GremlinEvaluator.script_statement_return script_statement() throws RecognitionException {
        GremlinEvaluator.script_statement_return retval = new GremlinEvaluator.script_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SCRIPT19=null;
        CommonTree StringLiteral20=null;

        CommonTree SCRIPT19_tree=null;
        CommonTree StringLiteral20_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:169:5: ( ^( SCRIPT StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:169:7: ^( SCRIPT StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            SCRIPT19=(CommonTree)match(input,SCRIPT,FOLLOW_SCRIPT_in_script_statement466); 
            SCRIPT19_tree = (CommonTree)adaptor.dupNode(SCRIPT19);

            root_1 = (CommonTree)adaptor.becomeRoot(SCRIPT19_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            StringLiteral20=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_script_statement468); 
            StringLiteral20_tree = (CommonTree)adaptor.dupNode(StringLiteral20);

            adaptor.addChild(root_1, StringLiteral20_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.result = new Atom<Boolean>(true);

                        String filename = (StringLiteral20!=null?StringLiteral20.getText():null);
                        try {
                            final GremlinScriptEngine engine = new GremlinScriptEngine();
                            engine.eval(new FileReader(filename.substring(1, filename.length() - 1)), this.context);
                        } catch(Exception e) {
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
    // $ANTLR end "script_statement"

    public static class include_statement_return extends TreeRuleReturnScope {
        public Atom result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "include_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:183:1: include_statement returns [Atom result] : ^( INCLUDE StringLiteral ) ;
    public final GremlinEvaluator.include_statement_return include_statement() throws RecognitionException {
        GremlinEvaluator.include_statement_return retval = new GremlinEvaluator.include_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INCLUDE21=null;
        CommonTree StringLiteral22=null;

        CommonTree INCLUDE21_tree=null;
        CommonTree StringLiteral22_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:184:2: ( ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:184:4: ^( INCLUDE StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            INCLUDE21=(CommonTree)match(input,INCLUDE,FOLLOW_INCLUDE_in_include_statement496); 
            INCLUDE21_tree = (CommonTree)adaptor.dupNode(INCLUDE21);

            root_1 = (CommonTree)adaptor.becomeRoot(INCLUDE21_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            StringLiteral22=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement498); 
            StringLiteral22_tree = (CommonTree)adaptor.dupNode(StringLiteral22);

            adaptor.addChild(root_1, StringLiteral22_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.result = new Atom<Boolean>(true);

                        String className = (StringLiteral22!=null?StringLiteral22.getText():null);
                        try {
                            final Class toLoad = Class.forName(className);
                            final ServiceLoader<Functions> functionsService = ServiceLoader.load(toLoad);

                            for (final Functions functionsToLoad : functionsService) {
                                this.context.getFunctionLibrary().registerFunctions(functionsToLoad);
                            }
                        } catch(Exception e) {
                            retval.result = new Atom<Boolean>(false);
                            e.printStackTrace();
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:203:1: path_definition_statement returns [Operation op] : ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) ;
    public final GremlinEvaluator.path_definition_statement_return path_definition_statement() throws RecognitionException {
        GremlinEvaluator.path_definition_statement_return retval = new GremlinEvaluator.path_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree path_name=null;
        CommonTree pr=null;
        CommonTree PATH23=null;
        CommonTree PROPERTY_CALL24=null;
        GremlinEvaluator.gpath_statement_return gpath = null;


        CommonTree path_name_tree=null;
        CommonTree pr_tree=null;
        CommonTree PATH23_tree=null;
        CommonTree PROPERTY_CALL24_tree=null;


                List<Pipe> pipes = new ArrayList<Pipe>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:207:2: ( ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:207:4: ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PATH23=(CommonTree)match(input,PATH,FOLLOW_PATH_in_path_definition_statement535); 
            PATH23_tree = (CommonTree)adaptor.dupNode(PATH23);

            root_1 = (CommonTree)adaptor.becomeRoot(PATH23_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            path_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_path_definition_statement539); 
            path_name_tree = (CommonTree)adaptor.dupNode(path_name);

            adaptor.addChild(root_1, path_name_tree);

            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:207:32: (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:207:33: gpath= gpath_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_path_definition_statement544);
                    gpath=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_1, gpath.getTree());
                     pipes.addAll(((GPathOperation)(gpath!=null?gpath.op:null)).getPipes()); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:207:115: ^( PROPERTY_CALL pr= PROPERTY )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    PROPERTY_CALL24=(CommonTree)match(input,PROPERTY_CALL,FOLLOW_PROPERTY_CALL_in_path_definition_statement551); 
                    PROPERTY_CALL24_tree = (CommonTree)adaptor.dupNode(PROPERTY_CALL24);

                    root_2 = (CommonTree)adaptor.becomeRoot(PROPERTY_CALL24_tree, root_2);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pr=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_path_definition_statement555); 
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
        Atom<Object> root;
        List<Pipe> pipeList;
    }
    protected Stack gpath_statement_stack = new Stack();

    public static class gpath_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gpath_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:215:1: gpath_statement returns [Operation op] : ^( GPATH ( step )+ ) ;
    public final GremlinEvaluator.gpath_statement_return gpath_statement() throws RecognitionException {
        gpath_statement_stack.push(new gpath_statement_scope());
        GremlinEvaluator.gpath_statement_return retval = new GremlinEvaluator.gpath_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GPATH25=null;
        GremlinEvaluator.step_return step26 = null;


        CommonTree GPATH25_tree=null;


                isGPath = true;
                
                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeCount = 0;
                ((gpath_statement_scope)gpath_statement_stack.peek()).root = null;
                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList = new ArrayList<Pipe>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:232:2: ( ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:232:4: ^( GPATH ( step )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            GPATH25=(CommonTree)match(input,GPATH,FOLLOW_GPATH_in_gpath_statement614); 
            GPATH25_tree = (CommonTree)adaptor.dupNode(GPATH25);

            root_1 = (CommonTree)adaptor.becomeRoot(GPATH25_tree, root_1);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:232:12: ( step )+
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:232:13: step
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_step_in_gpath_statement617);
            	    step26=step();

            	    state._fsp--;

            	    adaptor.addChild(root_1, step26.getTree());

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
                            retval.op = new GPathOperation(((gpath_statement_scope)gpath_statement_stack.peek()).pipeList, ((gpath_statement_scope)gpath_statement_stack.peek()).root, this.context);
                        } else {
                            retval.op = new UnaryOperation(new Atom<Object>(null));
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:242:1: step : ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) ;
    public final GremlinEvaluator.step_return step() throws RecognitionException {
        GremlinEvaluator.step_return retval = new GremlinEvaluator.step_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STEP27=null;
        CommonTree TOKEN28=null;
        CommonTree PREDICATES30=null;
        CommonTree PREDICATE31=null;
        GremlinEvaluator.token_return token29 = null;

        GremlinEvaluator.statement_return statement32 = null;


        CommonTree STEP27_tree=null;
        CommonTree TOKEN28_tree=null;
        CommonTree PREDICATES30_tree=null;
        CommonTree PREDICATE31_tree=null;


                List<Operation> predicates = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:246:5: ( ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:246:7: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            STEP27=(CommonTree)match(input,STEP,FOLLOW_STEP_in_step655); 
            STEP27_tree = (CommonTree)adaptor.dupNode(STEP27);

            root_1 = (CommonTree)adaptor.becomeRoot(STEP27_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TOKEN28=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_step658); 
            TOKEN28_tree = (CommonTree)adaptor.dupNode(TOKEN28);

            root_2 = (CommonTree)adaptor.becomeRoot(TOKEN28_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_token_in_step660);
            token29=token();

            state._fsp--;

            adaptor.addChild(root_2, token29.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PREDICATES30=(CommonTree)match(input,PREDICATES,FOLLOW_PREDICATES_in_step664); 
            PREDICATES30_tree = (CommonTree)adaptor.dupNode(PREDICATES30);

            root_2 = (CommonTree)adaptor.becomeRoot(PREDICATES30_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:246:42: ( ^( PREDICATE statement ) )*
                loop7:
                do {
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==PREDICATE) ) {
                        alt7=1;
                    }


                    switch (alt7) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:246:44: ^( PREDICATE statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    PREDICATE31=(CommonTree)match(input,PREDICATE,FOLLOW_PREDICATE_in_step669); 
                	    PREDICATE31_tree = (CommonTree)adaptor.dupNode(PREDICATE31);

                	    root_3 = (CommonTree)adaptor.becomeRoot(PREDICATE31_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_step671);
                	    statement32=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_3, statement32.getTree());
                	     predicates.add((statement32!=null?statement32.op:null)); 

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


                        final Atom tokenAtom = (token29!=null?token29.atom:null);
                        final PathLibrary paths = this.context.getPathLibrary();

                        if (tokenAtom != null) {
                            if (((gpath_statement_scope)gpath_statement_stack.peek()).pipeCount == 0) {

                                if (tokenAtom instanceof DynamicEntity) {
                                    ((gpath_statement_scope)gpath_statement_stack.peek()).root = tokenAtom;    
                                } else if (paths.isPath(tokenAtom.toString())) {
                                    ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList.addAll(paths.getPath(tokenAtom.toString()));
                                    ((gpath_statement_scope)gpath_statement_stack.peek()).root = this.getVariable(Tokens.ROOT_VARIABLE);
                                } else {
                                    ((gpath_statement_scope)gpath_statement_stack.peek()).root = tokenAtom;
                                }
                            
                                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList.addAll(GremlinPipesHelper.pipesForStep(predicates, this.context));
                            } else {
                                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList.addAll(GremlinPipesHelper.pipesForStep(tokenAtom, predicates, this.context));
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:273:1: token returns [Atom atom] : ( expression | gpath_statement | collection | '..' );
    public final GremlinEvaluator.token_return token() throws RecognitionException {
        GremlinEvaluator.token_return retval = new GremlinEvaluator.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal36=null;
        GremlinEvaluator.expression_return expression33 = null;

        GremlinEvaluator.gpath_statement_return gpath_statement34 = null;

        GremlinEvaluator.collection_return collection35 = null;


        CommonTree string_literal36_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:274:5: ( expression | gpath_statement | collection | '..' )
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
            case 82:
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
            case 68:
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:274:8: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_token713);
                    expression33=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression33.getTree());
                     retval.atom = (expression33!=null?expression33.expr:null).compute(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:275:9: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_token725);
                    gpath_statement34=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, gpath_statement34.getTree());
                     retval.atom = (gpath_statement34!=null?gpath_statement34.op:null).compute(); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:276:9: collection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_collection_in_token737);
                    collection35=collection();

                    state._fsp--;

                    adaptor.addChild(root_0, collection35.getTree());
                     retval.atom = (collection35!=null?collection35.op:null).compute(); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:277:9: '..'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal36=(CommonTree)match(input,68,FOLLOW_68_in_token749); 
                    string_literal36_tree = (CommonTree)adaptor.dupNode(string_literal36);

                    adaptor.addChild(root_0, string_literal36_tree);



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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:311:1: if_statement returns [Operation op] : ^( IF ^( COND cond= operand ) if_block= block ( ^( ELSE else_block= block ) )? ) ;
    public final GremlinEvaluator.if_statement_return if_statement() throws RecognitionException {
        GremlinEvaluator.if_statement_return retval = new GremlinEvaluator.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IF37=null;
        CommonTree COND38=null;
        CommonTree ELSE39=null;
        GremlinEvaluator.operand_return cond = null;

        GremlinEvaluator.block_return if_block = null;

        GremlinEvaluator.block_return else_block = null;


        CommonTree IF37_tree=null;
        CommonTree COND38_tree=null;
        CommonTree ELSE39_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:312:2: ( ^( IF ^( COND cond= operand ) if_block= block ( ^( ELSE else_block= block ) )? ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:312:4: ^( IF ^( COND cond= operand ) if_block= block ( ^( ELSE else_block= block ) )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            IF37=(CommonTree)match(input,IF,FOLLOW_IF_in_if_statement774); 
            IF37_tree = (CommonTree)adaptor.dupNode(IF37);

            root_1 = (CommonTree)adaptor.becomeRoot(IF37_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND38=(CommonTree)match(input,COND,FOLLOW_COND_in_if_statement777); 
            COND38_tree = (CommonTree)adaptor.dupNode(COND38);

            root_2 = (CommonTree)adaptor.becomeRoot(COND38_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_operand_in_if_statement781);
            cond=operand();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_if_statement786);
            if_block=block();

            state._fsp--;

            adaptor.addChild(root_1, if_block.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:312:45: ( ^( ELSE else_block= block ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ELSE) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:312:47: ^( ELSE else_block= block )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    ELSE39=(CommonTree)match(input,ELSE,FOLLOW_ELSE_in_if_statement791); 
                    ELSE39_tree = (CommonTree)adaptor.dupNode(ELSE39);

                    root_2 = (CommonTree)adaptor.becomeRoot(ELSE39_tree, root_2);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_block_in_if_statement795);
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


                        retval.op = new If((cond!=null?cond.op:null), (if_block!=null?if_block.operations:null), (else_block!=null?else_block.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:318:1: while_statement returns [Operation op] : ^( WHILE ^( COND cond= operand ) block ) ;
    public final GremlinEvaluator.while_statement_return while_statement() throws RecognitionException {
        GremlinEvaluator.while_statement_return retval = new GremlinEvaluator.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree WHILE40=null;
        CommonTree COND41=null;
        GremlinEvaluator.operand_return cond = null;

        GremlinEvaluator.block_return block42 = null;


        CommonTree WHILE40_tree=null;
        CommonTree COND41_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:319:2: ( ^( WHILE ^( COND cond= operand ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:319:4: ^( WHILE ^( COND cond= operand ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            WHILE40=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_while_statement828); 
            WHILE40_tree = (CommonTree)adaptor.dupNode(WHILE40);

            root_1 = (CommonTree)adaptor.becomeRoot(WHILE40_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND41=(CommonTree)match(input,COND,FOLLOW_COND_in_while_statement831); 
            COND41_tree = (CommonTree)adaptor.dupNode(COND41);

            root_2 = (CommonTree)adaptor.becomeRoot(COND41_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_operand_in_while_statement835);
            cond=operand();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_while_statement838);
            block42=block();

            state._fsp--;

            adaptor.addChild(root_1, block42.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new While((cond!=null?cond.op:null), (block42!=null?block42.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:325:1: foreach_statement returns [Operation op] : ^( FOREACH VARIABLE arr= operand block ) ;
    public final GremlinEvaluator.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinEvaluator.foreach_statement_return retval = new GremlinEvaluator.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH43=null;
        CommonTree VARIABLE44=null;
        GremlinEvaluator.operand_return arr = null;

        GremlinEvaluator.block_return block45 = null;


        CommonTree FOREACH43_tree=null;
        CommonTree VARIABLE44_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:326:2: ( ^( FOREACH VARIABLE arr= operand block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:326:4: ^( FOREACH VARIABLE arr= operand block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FOREACH43=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_statement865); 
            FOREACH43_tree = (CommonTree)adaptor.dupNode(FOREACH43);

            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH43_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            VARIABLE44=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement867); 
            VARIABLE44_tree = (CommonTree)adaptor.dupNode(VARIABLE44);

            adaptor.addChild(root_1, VARIABLE44_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_operand_in_foreach_statement871);
            arr=operand();

            state._fsp--;

            adaptor.addChild(root_1, arr.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_foreach_statement873);
            block45=block();

            state._fsp--;

            adaptor.addChild(root_1, block45.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Foreach((VARIABLE44!=null?VARIABLE44.getText():null), (arr!=null?arr.op:null), (block45!=null?block45.operations:null), this.context);
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:332:1: repeat_statement returns [Operation op] : ^( REPEAT timer= operand block ) ;
    public final GremlinEvaluator.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinEvaluator.repeat_statement_return retval = new GremlinEvaluator.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REPEAT46=null;
        GremlinEvaluator.operand_return timer = null;

        GremlinEvaluator.block_return block47 = null;


        CommonTree REPEAT46_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:333:2: ( ^( REPEAT timer= operand block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:333:4: ^( REPEAT timer= operand block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            REPEAT46=(CommonTree)match(input,REPEAT,FOLLOW_REPEAT_in_repeat_statement901); 
            REPEAT46_tree = (CommonTree)adaptor.dupNode(REPEAT46);

            root_1 = (CommonTree)adaptor.becomeRoot(REPEAT46_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_operand_in_repeat_statement905);
            timer=operand();

            state._fsp--;

            adaptor.addChild(root_1, timer.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_repeat_statement907);
            block47=block();

            state._fsp--;

            adaptor.addChild(root_1, block47.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Repeat((timer!=null?timer.op:null), (block47!=null?block47.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:339:1: block returns [List<Operation> operations] : ^( BLOCK ( ( statement | collection ) )+ ) ;
    public final GremlinEvaluator.block_return block() throws RecognitionException {
        GremlinEvaluator.block_return retval = new GremlinEvaluator.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BLOCK48=null;
        GremlinEvaluator.statement_return statement49 = null;

        GremlinEvaluator.collection_return collection50 = null;


        CommonTree BLOCK48_tree=null;


                List<Operation> operationList = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:343:5: ( ^( BLOCK ( ( statement | collection ) )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:343:7: ^( BLOCK ( ( statement | collection ) )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            BLOCK48=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_block946); 
            BLOCK48_tree = (CommonTree)adaptor.dupNode(BLOCK48);

            root_1 = (CommonTree)adaptor.becomeRoot(BLOCK48_tree, root_1);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:343:15: ( ( statement | collection ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==VAR||LA11_0==FUNC||(LA11_0>=PATH && LA11_0<=GPATH)||(LA11_0>=FUNC_CALL && LA11_0<=IF)||(LA11_0>=FOREACH && LA11_0<=COLLECTION_CALL)||LA11_0==IDENTIFIER||(LA11_0>=69 && LA11_0<=70)||LA11_0==82||(LA11_0>=85 && LA11_0<=95)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:343:17: ( statement | collection )
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:343:17: ( statement | collection )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==VAR||LA10_0==FUNC||(LA10_0>=PATH && LA10_0<=GPATH)||(LA10_0>=FUNC_CALL && LA10_0<=IF)||(LA10_0>=FOREACH && LA10_0<=VARIABLE_CALL)||LA10_0==IDENTIFIER||(LA10_0>=69 && LA10_0<=70)||LA10_0==82||(LA10_0>=85 && LA10_0<=95)) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==COLLECTION_CALL) ) {
            	        alt10=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:343:18: statement
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            pushFollow(FOLLOW_statement_in_block951);
            	            statement49=statement();

            	            state._fsp--;

            	            adaptor.addChild(root_1, statement49.getTree());
            	             operationList.add((statement49!=null?statement49.op:null)); 

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:343:68: collection
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            pushFollow(FOLLOW_collection_in_block957);
            	            collection50=collection();

            	            state._fsp--;

            	            adaptor.addChild(root_1, collection50.getTree());
            	             operationList.add((collection50!=null?collection50.op:null)); 

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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

    public static class operand_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operand"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:347:1: operand returns [Operation op] : ( statement | collection );
    public final GremlinEvaluator.operand_return operand() throws RecognitionException {
        GremlinEvaluator.operand_return retval = new GremlinEvaluator.operand_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        GremlinEvaluator.statement_return statement51 = null;

        GremlinEvaluator.collection_return collection52 = null;



        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:348:5: ( statement | collection )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==VAR||LA12_0==FUNC||(LA12_0>=PATH && LA12_0<=GPATH)||(LA12_0>=FUNC_CALL && LA12_0<=IF)||(LA12_0>=FOREACH && LA12_0<=VARIABLE_CALL)||LA12_0==IDENTIFIER||(LA12_0>=69 && LA12_0<=70)||LA12_0==82||(LA12_0>=85 && LA12_0<=95)) ) {
                alt12=1;
            }
            else if ( (LA12_0==COLLECTION_CALL) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:348:7: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_operand988);
                    statement51=statement();

                    state._fsp--;

                    adaptor.addChild(root_0, statement51.getTree());
                     retval.op = (statement51!=null?statement51.op:null); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:349:7: collection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_collection_in_operand999);
                    collection52=collection();

                    state._fsp--;

                    adaptor.addChild(root_0, collection52.getTree());
                     retval.op = (collection52!=null?collection52.op:null); 

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
    // $ANTLR end "operand"

    public static class expression_return extends TreeRuleReturnScope {
        public Operation expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:352:1: expression returns [Operation expr] : ( ^( '=' a= operand b= operand ) | ^( '!=' a= operand b= operand ) | ^( '<' a= operand b= operand ) | ^( '>' a= operand b= operand ) | ^( '<=' a= operand b= operand ) | ^( '>=' a= operand b= operand ) | operation );
    public final GremlinEvaluator.expression_return expression() throws RecognitionException {
        GremlinEvaluator.expression_return retval = new GremlinEvaluator.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal53=null;
        CommonTree string_literal54=null;
        CommonTree char_literal55=null;
        CommonTree char_literal56=null;
        CommonTree string_literal57=null;
        CommonTree string_literal58=null;
        GremlinEvaluator.operand_return a = null;

        GremlinEvaluator.operand_return b = null;

        GremlinEvaluator.operation_return operation59 = null;


        CommonTree char_literal53_tree=null;
        CommonTree string_literal54_tree=null;
        CommonTree char_literal55_tree=null;
        CommonTree char_literal56_tree=null;
        CommonTree string_literal57_tree=null;
        CommonTree string_literal58_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:353:5: ( ^( '=' a= operand b= operand ) | ^( '!=' a= operand b= operand ) | ^( '<' a= operand b= operand ) | ^( '>' a= operand b= operand ) | ^( '<=' a= operand b= operand ) | ^( '>=' a= operand b= operand ) | operation )
            int alt13=7;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt13=1;
                }
                break;
            case 86:
                {
                alt13=2;
                }
                break;
            case 87:
                {
                alt13=3;
                }
                break;
            case 89:
                {
                alt13=4;
                }
                break;
            case 88:
                {
                alt13=5;
                }
                break;
            case 90:
                {
                alt13=6;
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
            case 82:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
                {
                alt13=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:353:9: ^( '=' a= operand b= operand )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal53=(CommonTree)match(input,85,FOLLOW_85_in_expression1025); 
                    char_literal53_tree = (CommonTree)adaptor.dupNode(char_literal53);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal53_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1030);
                    a=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1034);
                    b=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new Equality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:354:9: ^( '!=' a= operand b= operand )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal54=(CommonTree)match(input,86,FOLLOW_86_in_expression1048); 
                    string_literal54_tree = (CommonTree)adaptor.dupNode(string_literal54);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal54_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1052);
                    a=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1056);
                    b=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new UnEquality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:355:9: ^( '<' a= operand b= operand )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal55=(CommonTree)match(input,87,FOLLOW_87_in_expression1070); 
                    char_literal55_tree = (CommonTree)adaptor.dupNode(char_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal55_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1075);
                    a=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1079);
                    b=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:356:9: ^( '>' a= operand b= operand )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal56=(CommonTree)match(input,89,FOLLOW_89_in_expression1093); 
                    char_literal56_tree = (CommonTree)adaptor.dupNode(char_literal56);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal56_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1098);
                    a=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1102);
                    b=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:357:9: ^( '<=' a= operand b= operand )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal57=(CommonTree)match(input,88,FOLLOW_88_in_expression1116); 
                    string_literal57_tree = (CommonTree)adaptor.dupNode(string_literal57);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal57_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1120);
                    a=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1124);
                    b=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:358:9: ^( '>=' a= operand b= operand )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal58=(CommonTree)match(input,90,FOLLOW_90_in_expression1138); 
                    string_literal58_tree = (CommonTree)adaptor.dupNode(string_literal58);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal58_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1142);
                    a=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_expression1146);
                    b=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:359:9: operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression1159);
                    operation59=operation();

                    state._fsp--;

                    adaptor.addChild(root_0, operation59.getTree());
                     retval.expr = (operation59!=null?operation59.op:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:362:1: operation returns [Operation op] : ( ^( '+' a= operand b= operand ) | ^( '-' a= operand b= operand ) | binary_operation );
    public final GremlinEvaluator.operation_return operation() throws RecognitionException {
        GremlinEvaluator.operation_return retval = new GremlinEvaluator.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal60=null;
        CommonTree char_literal61=null;
        GremlinEvaluator.operand_return a = null;

        GremlinEvaluator.operand_return b = null;

        GremlinEvaluator.binary_operation_return binary_operation62 = null;


        CommonTree char_literal60_tree=null;
        CommonTree char_literal61_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:363:5: ( ^( '+' a= operand b= operand ) | ^( '-' a= operand b= operand ) | binary_operation )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt14=1;
                }
                break;
            case 92:
                {
                alt14=2;
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
            case 82:
            case 93:
            case 94:
            case 95:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:363:9: ^( '+' a= operand b= operand )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal60=(CommonTree)match(input,91,FOLLOW_91_in_operation1204); 
                    char_literal60_tree = (CommonTree)adaptor.dupNode(char_literal60);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal60_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_operation1208);
                    a=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_operation1212);
                    b=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Addition((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:364:9: ^( '-' a= operand b= operand )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal61=(CommonTree)match(input,92,FOLLOW_92_in_operation1226); 
                    char_literal61_tree = (CommonTree)adaptor.dupNode(char_literal61);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal61_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_operation1230);
                    a=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_operation1234);
                    b=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Subtraction((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:365:9: binary_operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_binary_operation_in_operation1247);
                    binary_operation62=binary_operation();

                    state._fsp--;

                    adaptor.addChild(root_0, binary_operation62.getTree());
                     retval.op = (binary_operation62!=null?binary_operation62.operation:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:368:1: binary_operation returns [Operation operation] : ( ^( '*' a= operand b= operand ) | ^( 'div' a= operand b= operand ) | ^( 'mod' a= operand b= operand ) | atom );
    public final GremlinEvaluator.binary_operation_return binary_operation() throws RecognitionException {
        GremlinEvaluator.binary_operation_return retval = new GremlinEvaluator.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal63=null;
        CommonTree string_literal64=null;
        CommonTree string_literal65=null;
        GremlinEvaluator.operand_return a = null;

        GremlinEvaluator.operand_return b = null;

        GremlinEvaluator.atom_return atom66 = null;


        CommonTree char_literal63_tree=null;
        CommonTree string_literal64_tree=null;
        CommonTree string_literal65_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:369:5: ( ^( '*' a= operand b= operand ) | ^( 'div' a= operand b= operand ) | ^( 'mod' a= operand b= operand ) | atom )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt15=1;
                }
                break;
            case 94:
                {
                alt15=2;
                }
                break;
            case 95:
                {
                alt15=3;
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
            case 82:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:369:9: ^( '*' a= operand b= operand )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal63=(CommonTree)match(input,93,FOLLOW_93_in_binary_operation1284); 
                    char_literal63_tree = (CommonTree)adaptor.dupNode(char_literal63);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal63_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_binary_operation1288);
                    a=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_binary_operation1292);
                    b=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Multiplication((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:370:9: ^( 'div' a= operand b= operand )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal64=(CommonTree)match(input,94,FOLLOW_94_in_binary_operation1311); 
                    string_literal64_tree = (CommonTree)adaptor.dupNode(string_literal64);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal64_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_binary_operation1315);
                    a=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_binary_operation1319);
                    b=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Division((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:371:7: ^( 'mod' a= operand b= operand )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal65=(CommonTree)match(input,95,FOLLOW_95_in_binary_operation1334); 
                    string_literal65_tree = (CommonTree)adaptor.dupNode(string_literal65);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal65_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_binary_operation1338);
                    a=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operand_in_binary_operation1342);
                    b=operand();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Modulo((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:372:9: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atom_in_binary_operation1358);
                    atom66=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom66.getTree());
                     retval.operation = new UnaryOperation((atom66!=null?atom66.value:null)); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:375:1: function_definition_statement returns [Operation op] : ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) ;
    public final GremlinEvaluator.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinEvaluator.function_definition_statement_return retval = new GremlinEvaluator.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC67=null;
        CommonTree FUNC_NAME68=null;
        CommonTree NS69=null;
        CommonTree NAME70=null;
        CommonTree ARGS71=null;
        CommonTree ARG72=null;
        CommonTree VARIABLE73=null;
        GremlinEvaluator.block_return block74 = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC67_tree=null;
        CommonTree FUNC_NAME68_tree=null;
        CommonTree NS69_tree=null;
        CommonTree NAME70_tree=null;
        CommonTree ARGS71_tree=null;
        CommonTree ARG72_tree=null;
        CommonTree VARIABLE73_tree=null;


                List<String> params = new ArrayList<String>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:379:2: ( ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:379:4: ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC67=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_function_definition_statement1412); 
            FUNC67_tree = (CommonTree)adaptor.dupNode(FUNC67);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC67_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME68=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_definition_statement1415); 
            FUNC_NAME68_tree = (CommonTree)adaptor.dupNode(FUNC_NAME68);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME68_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS69=(CommonTree)match(input,NS,FOLLOW_NS_in_function_definition_statement1418); 
            NS69_tree = (CommonTree)adaptor.dupNode(NS69);

            root_3 = (CommonTree)adaptor.becomeRoot(NS69_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1422); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME70=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_definition_statement1426); 
            NAME70_tree = (CommonTree)adaptor.dupNode(NAME70);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME70_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1430); 
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
            ARGS71=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_definition_statement1435); 
            ARGS71_tree = (CommonTree)adaptor.dupNode(ARGS71);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS71_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:379:78: ( ^( ARG VARIABLE ) )*
                loop16:
                do {
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==ARG) ) {
                        alt16=1;
                    }


                    switch (alt16) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:379:80: ^( ARG VARIABLE )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG72=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_definition_statement1440); 
                	    ARG72_tree = (CommonTree)adaptor.dupNode(ARG72);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG72_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    VARIABLE73=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_function_definition_statement1442); 
                	    VARIABLE73_tree = (CommonTree)adaptor.dupNode(VARIABLE73);

                	    adaptor.addChild(root_3, VARIABLE73_tree);

                	     params.add((VARIABLE73!=null?VARIABLE73.getText():null)); 

                	    match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
                	    }


                	    }
                	    break;

                	default :
                	    break loop16;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_function_definition_statement1451);
            block74=block();

            state._fsp--;

            adaptor.addChild(root_1, block74.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        NativeFunction fn = new NativeFunction((fn_name!=null?fn_name.getText():null), params, (block74!=null?block74.operations:null));
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:388:1: function_call returns [Atom value] : ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG (st= statement | col= collection ) ) )* ) ) ;
    public final GremlinEvaluator.function_call_return function_call() throws RecognitionException {
        GremlinEvaluator.function_call_return retval = new GremlinEvaluator.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC_CALL75=null;
        CommonTree FUNC_NAME76=null;
        CommonTree NS77=null;
        CommonTree NAME78=null;
        CommonTree ARGS79=null;
        CommonTree ARG80=null;
        GremlinEvaluator.statement_return st = null;

        GremlinEvaluator.collection_return col = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC_CALL75_tree=null;
        CommonTree FUNC_NAME76_tree=null;
        CommonTree NS77_tree=null;
        CommonTree NAME78_tree=null;
        CommonTree ARGS79_tree=null;
        CommonTree ARG80_tree=null;


                List<Operation> params = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:392:2: ( ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG (st= statement | col= collection ) ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:392:4: ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG (st= statement | col= collection ) ) )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_CALL75=(CommonTree)match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_function_call1488); 
            FUNC_CALL75_tree = (CommonTree)adaptor.dupNode(FUNC_CALL75);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_CALL75_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME76=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_call1491); 
            FUNC_NAME76_tree = (CommonTree)adaptor.dupNode(FUNC_NAME76);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME76_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS77=(CommonTree)match(input,NS,FOLLOW_NS_in_function_call1494); 
            NS77_tree = (CommonTree)adaptor.dupNode(NS77);

            root_3 = (CommonTree)adaptor.becomeRoot(NS77_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1498); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME78=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_call1502); 
            NAME78_tree = (CommonTree)adaptor.dupNode(NAME78);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME78_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1506); 
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
            ARGS79=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_call1511); 
            ARGS79_tree = (CommonTree)adaptor.dupNode(ARGS79);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS79_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:392:83: ( ^( ARG (st= statement | col= collection ) ) )*
                loop18:
                do {
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==ARG) ) {
                        alt18=1;
                    }


                    switch (alt18) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:392:85: ^( ARG (st= statement | col= collection ) )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG80=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_call1516); 
                	    ARG80_tree = (CommonTree)adaptor.dupNode(ARG80);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG80_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:392:91: (st= statement | col= collection )
                	    int alt17=2;
                	    int LA17_0 = input.LA(1);

                	    if ( (LA17_0==VAR||LA17_0==FUNC||(LA17_0>=PATH && LA17_0<=GPATH)||(LA17_0>=FUNC_CALL && LA17_0<=IF)||(LA17_0>=FOREACH && LA17_0<=VARIABLE_CALL)||LA17_0==IDENTIFIER||(LA17_0>=69 && LA17_0<=70)||LA17_0==82||(LA17_0>=85 && LA17_0<=95)) ) {
                	        alt17=1;
                	    }
                	    else if ( (LA17_0==COLLECTION_CALL) ) {
                	        alt17=2;
                	    }
                	    else {
                	        NoViableAltException nvae =
                	            new NoViableAltException("", 17, 0, input);

                	        throw nvae;
                	    }
                	    switch (alt17) {
                	        case 1 :
                	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:392:92: st= statement
                	            {
                	            _last = (CommonTree)input.LT(1);
                	            pushFollow(FOLLOW_statement_in_function_call1521);
                	            st=statement();

                	            state._fsp--;

                	            adaptor.addChild(root_3, st.getTree());
                	             params.add((st!=null?st.op:null)); 

                	            }
                	            break;
                	        case 2 :
                	            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:392:131: col= collection
                	            {
                	            _last = (CommonTree)input.LT(1);
                	            pushFollow(FOLLOW_collection_in_function_call1529);
                	            col=collection();

                	            state._fsp--;

                	            adaptor.addChild(root_3, col.getTree());
                	             params.add((col!=null?col.op:null)); 

                	            }
                	            break;

                	    }


                	    match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
                	    }


                	    }
                	    break;

                	default :
                	    break loop18;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        try {
                            retval.value = new Func(this.getFunction((ns!=null?ns.getText():null), (fn_name!=null?fn_name.getText():null)), params, this.context);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:402:1: collection returns [Operation op] : ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) ) ;
    public final GremlinEvaluator.collection_return collection() throws RecognitionException {
        GremlinEvaluator.collection_return retval = new GremlinEvaluator.collection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COLLECTION_CALL81=null;
        CommonTree STEP82=null;
        CommonTree TOKEN83=null;
        CommonTree PREDICATES85=null;
        CommonTree PREDICATE86=null;
        GremlinEvaluator.token_return token84 = null;

        GremlinEvaluator.statement_return statement87 = null;


        CommonTree COLLECTION_CALL81_tree=null;
        CommonTree STEP82_tree=null;
        CommonTree TOKEN83_tree=null;
        CommonTree PREDICATES85_tree=null;
        CommonTree PREDICATE86_tree=null;


                Atom<Object> root = null;
                List<Pipe> pipes = new ArrayList<Pipe>();
                List<Operation> predicates = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:408:5: ( ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:408:7: ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COLLECTION_CALL81=(CommonTree)match(input,COLLECTION_CALL,FOLLOW_COLLECTION_CALL_in_collection1578); 
            COLLECTION_CALL81_tree = (CommonTree)adaptor.dupNode(COLLECTION_CALL81);

            root_1 = (CommonTree)adaptor.becomeRoot(COLLECTION_CALL81_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            STEP82=(CommonTree)match(input,STEP,FOLLOW_STEP_in_collection1581); 
            STEP82_tree = (CommonTree)adaptor.dupNode(STEP82);

            root_2 = (CommonTree)adaptor.becomeRoot(STEP82_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TOKEN83=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_collection1584); 
            TOKEN83_tree = (CommonTree)adaptor.dupNode(TOKEN83);

            root_3 = (CommonTree)adaptor.becomeRoot(TOKEN83_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_token_in_collection1586);
            token84=token();

            state._fsp--;

            adaptor.addChild(root_3, token84.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PREDICATES85=(CommonTree)match(input,PREDICATES,FOLLOW_PREDICATES_in_collection1590); 
            PREDICATES85_tree = (CommonTree)adaptor.dupNode(PREDICATES85);

            root_3 = (CommonTree)adaptor.becomeRoot(PREDICATES85_tree, root_3);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:408:60: ( ^( PREDICATE statement ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==PREDICATE) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:408:62: ^( PREDICATE statement )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_4 = _last;
            	    CommonTree _first_4 = null;
            	    CommonTree root_4 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            	    PREDICATE86=(CommonTree)match(input,PREDICATE,FOLLOW_PREDICATE_in_collection1595); 
            	    PREDICATE86_tree = (CommonTree)adaptor.dupNode(PREDICATE86);

            	    root_4 = (CommonTree)adaptor.becomeRoot(PREDICATE86_tree, root_4);



            	    match(input, Token.DOWN, null); 
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_collection1597);
            	    statement87=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_4, statement87.getTree());
            	     predicates.add((statement87!=null?statement87.op:null)); 

            	    match(input, Token.UP, null); adaptor.addChild(root_3, root_4);_last = _save_last_4;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }


            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                    final Atom tokenAtom = (token84!=null?token84.atom:null);
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
                    
                    retval.op = new GPathOperation(pipes, root, this.context);
                

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:431:1: atom returns [Atom value] : ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | ^( RANGE min= G_INT max= G_INT ) | ^( STR StringLiteral ) | ^( BOOL b= BOOLEAN ) | NULL | ^( ARR ( NUMBER )+ ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | function_call | '(' statement ')' );
    public final GremlinEvaluator.atom_return atom() throws RecognitionException {
        GremlinEvaluator.atom_return retval = new GremlinEvaluator.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree min=null;
        CommonTree max=null;
        CommonTree b=null;
        CommonTree INT88=null;
        CommonTree G_INT89=null;
        CommonTree LONG90=null;
        CommonTree G_LONG91=null;
        CommonTree FLOAT92=null;
        CommonTree G_FLOAT93=null;
        CommonTree DOUBLE94=null;
        CommonTree G_DOUBLE95=null;
        CommonTree RANGE96=null;
        CommonTree STR97=null;
        CommonTree StringLiteral98=null;
        CommonTree BOOL99=null;
        CommonTree NULL100=null;
        CommonTree ARR101=null;
        CommonTree NUMBER102=null;
        CommonTree VARIABLE_CALL103=null;
        CommonTree VARIABLE104=null;
        CommonTree PROPERTY_CALL105=null;
        CommonTree PROPERTY106=null;
        CommonTree IDENTIFIER107=null;
        CommonTree char_literal109=null;
        CommonTree char_literal111=null;
        GremlinEvaluator.function_call_return function_call108 = null;

        GremlinEvaluator.statement_return statement110 = null;


        CommonTree min_tree=null;
        CommonTree max_tree=null;
        CommonTree b_tree=null;
        CommonTree INT88_tree=null;
        CommonTree G_INT89_tree=null;
        CommonTree LONG90_tree=null;
        CommonTree G_LONG91_tree=null;
        CommonTree FLOAT92_tree=null;
        CommonTree G_FLOAT93_tree=null;
        CommonTree DOUBLE94_tree=null;
        CommonTree G_DOUBLE95_tree=null;
        CommonTree RANGE96_tree=null;
        CommonTree STR97_tree=null;
        CommonTree StringLiteral98_tree=null;
        CommonTree BOOL99_tree=null;
        CommonTree NULL100_tree=null;
        CommonTree ARR101_tree=null;
        CommonTree NUMBER102_tree=null;
        CommonTree VARIABLE_CALL103_tree=null;
        CommonTree VARIABLE104_tree=null;
        CommonTree PROPERTY_CALL105_tree=null;
        CommonTree PROPERTY106_tree=null;
        CommonTree IDENTIFIER107_tree=null;
        CommonTree char_literal109_tree=null;
        CommonTree char_literal111_tree=null;


                List<Double> array = new ArrayList<Double>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:435:2: ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | ^( RANGE min= G_INT max= G_INT ) | ^( STR StringLiteral ) | ^( BOOL b= BOOLEAN ) | NULL | ^( ARR ( NUMBER )+ ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | function_call | '(' statement ')' )
            int alt21=14;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt21=1;
                }
                break;
            case LONG:
                {
                alt21=2;
                }
                break;
            case FLOAT:
                {
                alt21=3;
                }
                break;
            case DOUBLE:
                {
                alt21=4;
                }
                break;
            case RANGE:
                {
                alt21=5;
                }
                break;
            case STR:
                {
                alt21=6;
                }
                break;
            case BOOL:
                {
                alt21=7;
                }
                break;
            case NULL:
                {
                alt21=8;
                }
                break;
            case ARR:
                {
                alt21=9;
                }
                break;
            case VARIABLE_CALL:
                {
                alt21=10;
                }
                break;
            case PROPERTY_CALL:
                {
                alt21=11;
                }
                break;
            case IDENTIFIER:
                {
                alt21=12;
                }
                break;
            case FUNC_CALL:
                {
                alt21=13;
                }
                break;
            case 82:
                {
                alt21=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:435:6: ^( INT G_INT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    INT88=(CommonTree)match(input,INT,FOLLOW_INT_in_atom1644); 
                    INT88_tree = (CommonTree)adaptor.dupNode(INT88);

                    root_1 = (CommonTree)adaptor.becomeRoot(INT88_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_INT89=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1646); 
                    G_INT89_tree = (CommonTree)adaptor.dupNode(G_INT89);

                    adaptor.addChild(root_1, G_INT89_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Integer>(new Integer((G_INT89!=null?G_INT89.getText():null))); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:436:6: ^( LONG G_LONG )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    LONG90=(CommonTree)match(input,LONG,FOLLOW_LONG_in_atom1704); 
                    LONG90_tree = (CommonTree)adaptor.dupNode(LONG90);

                    root_1 = (CommonTree)adaptor.becomeRoot(LONG90_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_LONG91=(CommonTree)match(input,G_LONG,FOLLOW_G_LONG_in_atom1706); 
                    G_LONG91_tree = (CommonTree)adaptor.dupNode(G_LONG91);

                    adaptor.addChild(root_1, G_LONG91_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String longStr = (G_LONG91!=null?G_LONG91.getText():null);
                    	                                                                    retval.value = new Atom<Long>(new Long(longStr.substring(0, longStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:440:6: ^( FLOAT G_FLOAT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    FLOAT92=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_atom1762); 
                    FLOAT92_tree = (CommonTree)adaptor.dupNode(FLOAT92);

                    root_1 = (CommonTree)adaptor.becomeRoot(FLOAT92_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_FLOAT93=(CommonTree)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_atom1764); 
                    G_FLOAT93_tree = (CommonTree)adaptor.dupNode(G_FLOAT93);

                    adaptor.addChild(root_1, G_FLOAT93_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Float>(new Float((G_FLOAT93!=null?G_FLOAT93.getText():null))); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:441:6: ^( DOUBLE G_DOUBLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    DOUBLE94=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_atom1818); 
                    DOUBLE94_tree = (CommonTree)adaptor.dupNode(DOUBLE94);

                    root_1 = (CommonTree)adaptor.becomeRoot(DOUBLE94_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_DOUBLE95=(CommonTree)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_atom1820); 
                    G_DOUBLE95_tree = (CommonTree)adaptor.dupNode(G_DOUBLE95);

                    adaptor.addChild(root_1, G_DOUBLE95_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String doubleStr = (G_DOUBLE95!=null?G_DOUBLE95.getText():null);
                    	                                                                    retval.value = new Atom<Double>(new Double(doubleStr.substring(0, doubleStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:445:6: ^( RANGE min= G_INT max= G_INT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    RANGE96=(CommonTree)match(input,RANGE,FOLLOW_RANGE_in_atom1872); 
                    RANGE96_tree = (CommonTree)adaptor.dupNode(RANGE96);

                    root_1 = (CommonTree)adaptor.becomeRoot(RANGE96_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    min=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1876); 
                    min_tree = (CommonTree)adaptor.dupNode(min);

                    adaptor.addChild(root_1, min_tree);

                    _last = (CommonTree)input.LT(1);
                    max=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1880); 
                    max_tree = (CommonTree)adaptor.dupNode(max);

                    adaptor.addChild(root_1, max_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom(new Range((min!=null?min.getText():null), (max!=null?max.getText():null))); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:446:4: ^( STR StringLiteral )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    STR97=(CommonTree)match(input,STR,FOLLOW_STR_in_atom1920); 
                    STR97_tree = (CommonTree)adaptor.dupNode(STR97);

                    root_1 = (CommonTree)adaptor.becomeRoot(STR97_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    StringLiteral98=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_atom1922); 
                    StringLiteral98_tree = (CommonTree)adaptor.dupNode(StringLiteral98);

                    adaptor.addChild(root_1, StringLiteral98_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom((StringLiteral98!=null?StringLiteral98.getText():null)); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:447:9: ^( BOOL b= BOOLEAN )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    BOOL99=(CommonTree)match(input,BOOL,FOLLOW_BOOL_in_atom1975); 
                    BOOL99_tree = (CommonTree)adaptor.dupNode(BOOL99);

                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL99_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    b=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_atom1979); 
                    b_tree = (CommonTree)adaptor.dupNode(b);

                    adaptor.addChild(root_1, b_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom(new Boolean((b!=null?b.getText():null))); 

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:448:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    NULL100=(CommonTree)match(input,NULL,FOLLOW_NULL_in_atom2034); 
                    NULL100_tree = (CommonTree)adaptor.dupNode(NULL100);

                    adaptor.addChild(root_0, NULL100_tree);

                     retval.value = new Atom(null); 

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:449:9: ^( ARR ( NUMBER )+ )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    ARR101=(CommonTree)match(input,ARR,FOLLOW_ARR_in_atom2102); 
                    ARR101_tree = (CommonTree)adaptor.dupNode(ARR101);

                    root_1 = (CommonTree)adaptor.becomeRoot(ARR101_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:449:15: ( NUMBER )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==NUMBER) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:449:16: NUMBER
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    NUMBER102=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_atom2105); 
                    	    NUMBER102_tree = (CommonTree)adaptor.dupNode(NUMBER102);

                    	    adaptor.addChild(root_1, NUMBER102_tree);

                    	     array.add(new Double((NUMBER102!=null?NUMBER102.getText():null))); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom(array); 

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:450:4: ^( VARIABLE_CALL VARIABLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VARIABLE_CALL103=(CommonTree)match(input,VARIABLE_CALL,FOLLOW_VARIABLE_CALL_in_atom2120); 
                    VARIABLE_CALL103_tree = (CommonTree)adaptor.dupNode(VARIABLE_CALL103);

                    root_1 = (CommonTree)adaptor.becomeRoot(VARIABLE_CALL103_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VARIABLE104=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_atom2122); 
                    VARIABLE104_tree = (CommonTree)adaptor.dupNode(VARIABLE104);

                    adaptor.addChild(root_1, VARIABLE104_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     
                                                                                          retval.value = this.getVariable((VARIABLE104!=null?VARIABLE104.getText():null)); 
                                                                                        

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:453:4: ^( PROPERTY_CALL PROPERTY )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    PROPERTY_CALL105=(CommonTree)match(input,PROPERTY_CALL,FOLLOW_PROPERTY_CALL_in_atom2165); 
                    PROPERTY_CALL105_tree = (CommonTree)adaptor.dupNode(PROPERTY_CALL105);

                    root_1 = (CommonTree)adaptor.becomeRoot(PROPERTY_CALL105_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    PROPERTY106=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_atom2167); 
                    PROPERTY106_tree = (CommonTree)adaptor.dupNode(PROPERTY106);

                    adaptor.addChild(root_1, PROPERTY106_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     
                                                                                            Atom propertyAtom = new Atom((PROPERTY106!=null?PROPERTY106.getText():null).substring(1));
                                                                                            propertyAtom.setProperty(true);
                                                                                            retval.value = propertyAtom;
                                                                                        

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:458:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER107=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atom2209); 
                    IDENTIFIER107_tree = (CommonTree)adaptor.dupNode(IDENTIFIER107);

                    adaptor.addChild(root_0, IDENTIFIER107_tree);


                    	                                                                    String idText = (IDENTIFIER107!=null?IDENTIFIER107.getText():null);
                                                                                            
                    	                                                                    if (idText.equals(".") && !isGPath) {
                    	                                                                        Atom id  = this.getVariable(Tokens.ROOT_VARIABLE);
                    	                                                                        Atom dot = new Atom(id.getValue());
                    	                                                                        dot.setIdentifier(true);
                    	                                                                        retval.value = dot;
                    	                                                                    } else if (idText.matches("^[\\d]+..[\\d]+")) {
                                                                                                Matcher range = rangePattern.matcher(idText);
                                                                                                if (range.matches())
                                                                                                    retval.value = new Atom<Range>(new Range(range.group(1), range.group(2)));
                                                                                                else
                                                                                                    retval.value = new Atom(null);
                    	                                                                    } else {
                                                                                                Atom idAtom = new Atom<String>((IDENTIFIER107!=null?IDENTIFIER107.getText():null));
                                                                                                idAtom.setIdentifier(true);
                                                                                                retval.value = idAtom;
                                                                                            }
                                                                                        

                    }
                    break;
                case 13 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:478:4: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_call_in_atom2265);
                    function_call108=function_call();

                    state._fsp--;

                    adaptor.addChild(root_0, function_call108.getTree());
                     retval.value = (function_call108!=null?function_call108.value:null); 

                    }
                    break;
                case 14 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:479:4: '(' statement ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal109=(CommonTree)match(input,82,FOLLOW_82_in_atom2318); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_atom2321);
                    statement110=statement();

                    state._fsp--;

                    adaptor.addChild(root_0, statement110.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal111=(CommonTree)match(input,83,FOLLOW_83_in_atom2323); 

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


 

    public static final BitSet FOLLOW_statement_in_program60 = new BitSet(new long[]{0x000029FFFF181892L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_collection_in_program73 = new BitSet(new long[]{0x000029FFFF181892L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_VAR_in_program80 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_program82 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_collection_in_program86 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEWLINE_in_program92 = new BitSet(new long[]{0x000029FFFF181892L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_if_statement_in_statement120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_definition_statement_in_statement231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_script_statement_in_statement288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_statement314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_statement342 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_statement344 = new BitSet(new long[]{0x000020FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_statement_in_statement348 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_69_in_statement370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement374 = new BitSet(new long[]{0x000020FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_statement_in_statement378 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_70_in_statement395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement400 = new BitSet(new long[]{0x000020FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_statement_in_statement404 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_statement420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SCRIPT_in_script_statement466 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_script_statement468 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCLUDE_in_include_statement496 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement498 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PATH_in_path_definition_statement535 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_path_definition_statement539 = new BitSet(new long[]{0x0000004000001000L});
    public static final BitSet FOLLOW_gpath_statement_in_path_definition_statement544 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_path_definition_statement551 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_path_definition_statement555 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GPATH_in_gpath_statement614 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_step_in_gpath_statement617 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_STEP_in_step655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_in_step658 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_step660 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREDICATES_in_step664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PREDICATE_in_step669 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_step671 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_token713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_token725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_in_token737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_token749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_statement774 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_if_statement777 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_if_statement781 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_if_statement786 = new BitSet(new long[]{0x0000000000200008L});
    public static final BitSet FOLLOW_ELSE_in_if_statement791 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_if_statement795 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_while_statement828 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_while_statement831 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_while_statement835 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_while_statement838 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_statement865 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement867 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_foreach_statement871 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_block_in_foreach_statement873 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_repeat_statement901 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_repeat_statement905 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_block_in_repeat_statement907 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_block946 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block951 = new BitSet(new long[]{0x000021FFFF181898L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_collection_in_block957 = new BitSet(new long[]{0x000021FFFF181898L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_statement_in_operand988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_in_operand999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_expression1025 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_expression1030 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_expression1034 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_86_in_expression1048 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_expression1052 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_expression1056 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_87_in_expression1070 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_expression1075 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_expression1079 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_89_in_expression1093 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_expression1098 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_expression1102 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_88_in_expression1116 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_expression1120 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_expression1124 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_90_in_expression1138 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_expression1142 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_expression1146 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_operation_in_expression1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_operation1204 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_operation1208 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_operation1212 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_92_in_operation1226 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_operation1230 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_operation1234 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binary_operation_in_operation1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_binary_operation1284 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_binary_operation1288 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_binary_operation1292 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_94_in_binary_operation1311 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_binary_operation1315 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_binary_operation1319 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_95_in_binary_operation1334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_binary_operation1338 = new BitSet(new long[]{0x000021FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_operand_in_binary_operation1342 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_binary_operation1358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_in_function_definition_statement1412 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_definition_statement1415 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_definition_statement1418 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1422 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_definition_statement1426 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1430 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_definition_statement1435 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_definition_statement1440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_function_definition_statement1442 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_function_definition_statement1451 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_function_call1488 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_call1491 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_call1494 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1498 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_call1502 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1506 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_call1511 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_call1516 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_function_call1521 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_collection_in_function_call1529 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COLLECTION_CALL_in_collection1578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STEP_in_collection1581 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_in_collection1584 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_collection1586 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREDICATES_in_collection1590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PREDICATE_in_collection1595 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_collection1597 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_atom1644 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_INT_in_atom1646 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONG_in_atom1704 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_LONG_in_atom1706 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FLOAT_in_atom1762 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_FLOAT_in_atom1764 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLE_in_atom1818 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_DOUBLE_in_atom1820 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_atom1872 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_INT_in_atom1876 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_G_INT_in_atom1880 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STR_in_atom1920 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_atom1922 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOOL_in_atom1975 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOLEAN_in_atom1979 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_atom2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARR_in_atom2102 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NUMBER_in_atom2105 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_VARIABLE_CALL_in_atom2120 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_atom2122 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_atom2165 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_atom2167 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_atom2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_atom2318 = new BitSet(new long[]{0x000020FFFF181890L,0x00000000FFE40060L});
    public static final BitSet FOLLOW_statement_in_atom2321 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_atom2323 = new BitSet(new long[]{0x0000000000000002L});

}
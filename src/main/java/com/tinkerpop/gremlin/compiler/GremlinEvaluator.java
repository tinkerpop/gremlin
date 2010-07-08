// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g 2010-07-08 11:17:03

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "PATH", "GPATH", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "SELF", "HISTORY", "FUNC_CALL", "IF", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "INT", "LONG", "FLOAT", "DOUBLE", "STR", "ARR", "BOOL", "NULL", "RANGE", "PROPERTY_CALL", "VARIABLE_CALL", "COMMENT", "NEWLINE", "VARIABLE", "StringLiteral", "IDENTIFIER", "G_INT", "G_LONG", "G_FLOAT", "G_DOUBLE", "BOOLEAN", "PROPERTY", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "'/'", "'['", "']'", "'..'", "':='", "'and'", "'or'", "'include'", "'if'", "'end'", "'foreach'", "'in'", "'while'", "'repeat'", "'path'", "'func'", "'('", "')'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "':'", "NUMBER"
    };
    public static final int WHILE=24;
    public static final int DecimalDigit=59;
    public static final int EOF=-1;
    public static final int FUNC_CALL=19;
    public static final int TOKEN=14;
    public static final int SingleStringCharacter=50;
    public static final int HISTORY=18;
    public static final int NAME=9;
    public static final int T__90=90;
    public static final int ARG=5;
    public static final int PATH=11;
    public static final int G_INT=43;
    public static final int INCLUDE=26;
    public static final int SingleEscapeCharacter=56;
    public static final int ARGS=6;
    public static final int DOUBLE=30;
    public static final int VAR=4;
    public static final int GPATH=12;
    public static final int COMMENT=38;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int NS=8;
    public static final int NULL=34;
    public static final int BOOL=33;
    public static final int NUMBER=91;
    public static final int INT=27;
    public static final int DoubleStringCharacter=49;
    public static final int ARR=32;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int WS=51;
    public static final int T__71=71;
    public static final int PREDICATES=16;
    public static final int T__72=72;
    public static final int VARIABLE=40;
    public static final int G_DOUBLE=46;
    public static final int T__70=70;
    public static final int PROPERTY=48;
    public static final int FUNC=7;
    public static final int G_LONG=44;
    public static final int REPEAT=25;
    public static final int FOREACH=23;
    public static final int CharacterEscapeSequence=53;
    public static final int FUNC_NAME=10;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int EscapeSequence=52;
    public static final int T__73=73;
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
    public static final int HexEscapeSequence=54;
    public static final int T__63=63;
    public static final int STEP=13;
    public static final int FLOAT=29;
    public static final int T__61=61;
    public static final int HexDigit=60;
    public static final int PREDICATE=15;
    public static final int IF=20;
    public static final int STR=31;
    public static final int BOOLEAN=47;
    public static final int IDENTIFIER=42;
    public static final int EscapeCharacter=58;
    public static final int G_FLOAT=45;
    public static final int PROPERTY_CALL=36;
    public static final int UnicodeEscapeSequence=55;
    public static final int RANGE=35;
    public static final int StringLiteral=41;
    public static final int NEWLINE=39;
    public static final int BLOCK=22;
    public static final int NonEscapeCharacter=57;
    public static final int LONG=28;
    public static final int COND=21;
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


    public static class program_return extends TreeRuleReturnScope {
        public Iterable results;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:94:1: program returns [Iterable results] : ( statement ( NEWLINE )* )+ ;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:98:5: ( ( statement ( NEWLINE )* )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:98:9: ( statement ( NEWLINE )* )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:98:9: ( statement ( NEWLINE )* )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==VAR||LA2_0==FUNC||(LA2_0>=PATH && LA2_0<=GPATH)||(LA2_0>=FUNC_CALL && LA2_0<=IF)||(LA2_0>=FOREACH && LA2_0<=VARIABLE_CALL)||LA2_0==IDENTIFIER||(LA2_0>=66 && LA2_0<=67)||LA2_0==77||(LA2_0>=80 && LA2_0<=89)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:98:10: statement ( NEWLINE )*
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_program61);
            	    statement1=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement1.getTree());

            	                            Atom result = (statement1!=null?statement1.op:null).compute();

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

            	                       
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:119:22: ( NEWLINE )*
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==NEWLINE) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:119:22: NEWLINE
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    NEWLINE2=(CommonTree)match(input,NEWLINE,FOLLOW_NEWLINE_in_program65); 
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:125:1: statement returns [Operation op] : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | ^( VAR VARIABLE s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression );
    public final GremlinEvaluator.statement_return statement() throws RecognitionException {
        GremlinEvaluator.statement_return retval = new GremlinEvaluator.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree VAR11=null;
        CommonTree VARIABLE12=null;
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

        GremlinEvaluator.gpath_statement_return gpath_statement10 = null;

        GremlinEvaluator.expression_return expression15 = null;


        CommonTree VAR11_tree=null;
        CommonTree VARIABLE12_tree=null;
        CommonTree string_literal13_tree=null;
        CommonTree string_literal14_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:126:2: ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | ^( VAR VARIABLE s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression )
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
            case GPATH:
                {
                alt3=8;
                }
                break;
            case VAR:
                {
                alt3=9;
                }
                break;
            case 66:
                {
                alt3=10;
                }
                break;
            case 67:
                {
                alt3=11;
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
            case 77:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:126:4: if_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_if_statement_in_statement107);
                    if_statement3=if_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, if_statement3.getTree());
                     retval.op = (if_statement3!=null?if_statement3.op:null); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:127:4: foreach_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_statement_in_statement137);
                    foreach_statement4=foreach_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, foreach_statement4.getTree());
                     retval.op = (foreach_statement4!=null?foreach_statement4.op:null); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:128:7: while_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_while_statement_in_statement165);
                    while_statement5=while_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, while_statement5.getTree());
                     retval.op = (while_statement5!=null?while_statement5.op:null); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:129:4: repeat_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_repeat_statement_in_statement192);
                    repeat_statement6=repeat_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, repeat_statement6.getTree());
                     retval.op = (repeat_statement6!=null?repeat_statement6.op:null); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:130:4: path_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_definition_statement_in_statement218);
                    path_definition_statement7=path_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, path_definition_statement7.getTree());
                     retval.op = (path_definition_statement7!=null?path_definition_statement7.op:null); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:131:4: function_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_definition_statement_in_statement235);
                    function_definition_statement8=function_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, function_definition_statement8.getTree());
                     retval.op = (function_definition_statement8!=null?function_definition_statement8.op:null); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:132:4: include_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_include_statement_in_statement248);
                    include_statement9=include_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, include_statement9.getTree());
                     retval.op = new UnaryOperation((include_statement9!=null?include_statement9.result:null)); 

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:133:4: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_statement273);
                    gpath_statement10=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, gpath_statement10.getTree());
                     retval.op = (gpath_statement10!=null?gpath_statement10.op:null); 

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:134:4: ^( VAR VARIABLE s= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VAR11=(CommonTree)match(input,VAR,FOLLOW_VAR_in_statement301); 
                    VAR11_tree = (CommonTree)adaptor.dupNode(VAR11);

                    root_1 = (CommonTree)adaptor.becomeRoot(VAR11_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VARIABLE12=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_statement303); 
                    VARIABLE12_tree = (CommonTree)adaptor.dupNode(VARIABLE12);

                    adaptor.addChild(root_1, VARIABLE12_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement307);
                    s=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, s.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new DeclareVariable((VARIABLE12!=null?VARIABLE12.getText():null), (s!=null?s.op:null)); 

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:135:9: ^( 'and' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal13=(CommonTree)match(input,66,FOLLOW_66_in_statement329); 
                    string_literal13_tree = (CommonTree)adaptor.dupNode(string_literal13);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal13_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement333);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement337);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new And((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:136:9: ^( 'or' a= statement b= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal14=(CommonTree)match(input,67,FOLLOW_67_in_statement354); 
                    string_literal14_tree = (CommonTree)adaptor.dupNode(string_literal14);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal14_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement359);
                    a=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement363);
                    b=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Or((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:137:9: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement379);
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

    public static class include_statement_return extends TreeRuleReturnScope {
        public Atom result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "include_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:140:1: include_statement returns [Atom result] : ^( INCLUDE StringLiteral ) ;
    public final GremlinEvaluator.include_statement_return include_statement() throws RecognitionException {
        GremlinEvaluator.include_statement_return retval = new GremlinEvaluator.include_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INCLUDE16=null;
        CommonTree StringLiteral17=null;

        CommonTree INCLUDE16_tree=null;
        CommonTree StringLiteral17_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:141:2: ( ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:141:4: ^( INCLUDE StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            INCLUDE16=(CommonTree)match(input,INCLUDE,FOLLOW_INCLUDE_in_include_statement422); 
            INCLUDE16_tree = (CommonTree)adaptor.dupNode(INCLUDE16);

            root_1 = (CommonTree)adaptor.becomeRoot(INCLUDE16_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            StringLiteral17=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement424); 
            StringLiteral17_tree = (CommonTree)adaptor.dupNode(StringLiteral17);

            adaptor.addChild(root_1, StringLiteral17_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.result = new Atom(true);

                        String filename = (StringLiteral17!=null?StringLiteral17.getText():null);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:155:1: path_definition_statement returns [Operation op] : ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) ;
    public final GremlinEvaluator.path_definition_statement_return path_definition_statement() throws RecognitionException {
        GremlinEvaluator.path_definition_statement_return retval = new GremlinEvaluator.path_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree path_name=null;
        CommonTree pr=null;
        CommonTree PATH18=null;
        CommonTree PROPERTY_CALL19=null;
        GremlinEvaluator.gpath_statement_return gpath = null;


        CommonTree path_name_tree=null;
        CommonTree pr_tree=null;
        CommonTree PATH18_tree=null;
        CommonTree PROPERTY_CALL19_tree=null;


                List<Pipe> pipes = new ArrayList<Pipe>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:159:2: ( ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:159:4: ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PATH18=(CommonTree)match(input,PATH,FOLLOW_PATH_in_path_definition_statement461); 
            PATH18_tree = (CommonTree)adaptor.dupNode(PATH18);

            root_1 = (CommonTree)adaptor.becomeRoot(PATH18_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            path_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_path_definition_statement465); 
            path_name_tree = (CommonTree)adaptor.dupNode(path_name);

            adaptor.addChild(root_1, path_name_tree);

            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:159:32: (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:159:33: gpath= gpath_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_path_definition_statement470);
                    gpath=gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_1, gpath.getTree());
                     pipes.addAll(((GPathOperation)(gpath!=null?gpath.op:null)).getPipes()); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:159:115: ^( PROPERTY_CALL pr= PROPERTY )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    PROPERTY_CALL19=(CommonTree)match(input,PROPERTY_CALL,FOLLOW_PROPERTY_CALL_in_path_definition_statement477); 
                    PROPERTY_CALL19_tree = (CommonTree)adaptor.dupNode(PROPERTY_CALL19);

                    root_2 = (CommonTree)adaptor.becomeRoot(PROPERTY_CALL19_tree, root_2);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pr=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_path_definition_statement481); 
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:167:1: gpath_statement returns [Operation op] : ^( GPATH ( step )+ ) ;
    public final GremlinEvaluator.gpath_statement_return gpath_statement() throws RecognitionException {
        gpath_statement_stack.push(new gpath_statement_scope());
        GremlinEvaluator.gpath_statement_return retval = new GremlinEvaluator.gpath_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GPATH20=null;
        GremlinEvaluator.step_return step21 = null;


        CommonTree GPATH20_tree=null;


                isGPath = true;
                
                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeCount = 0;
                ((gpath_statement_scope)gpath_statement_stack.peek()).startPoint = null;
                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList = new ArrayList<Pipe>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:184:2: ( ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:184:4: ^( GPATH ( step )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            GPATH20=(CommonTree)match(input,GPATH,FOLLOW_GPATH_in_gpath_statement540); 
            GPATH20_tree = (CommonTree)adaptor.dupNode(GPATH20);

            root_1 = (CommonTree)adaptor.becomeRoot(GPATH20_tree, root_1);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:184:12: ( step )+
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:184:13: step
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_step_in_gpath_statement543);
            	    step21=step();

            	    state._fsp--;

            	    adaptor.addChild(root_1, step21.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:194:1: step : ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) ;
    public final GremlinEvaluator.step_return step() throws RecognitionException {
        GremlinEvaluator.step_return retval = new GremlinEvaluator.step_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STEP22=null;
        CommonTree TOKEN23=null;
        CommonTree PREDICATES25=null;
        CommonTree PREDICATE26=null;
        GremlinEvaluator.token_return token24 = null;

        GremlinEvaluator.statement_return statement27 = null;


        CommonTree STEP22_tree=null;
        CommonTree TOKEN23_tree=null;
        CommonTree PREDICATES25_tree=null;
        CommonTree PREDICATE26_tree=null;


                List<Operation> predicates = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:198:5: ( ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:198:7: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            STEP22=(CommonTree)match(input,STEP,FOLLOW_STEP_in_step581); 
            STEP22_tree = (CommonTree)adaptor.dupNode(STEP22);

            root_1 = (CommonTree)adaptor.becomeRoot(STEP22_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            TOKEN23=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_step584); 
            TOKEN23_tree = (CommonTree)adaptor.dupNode(TOKEN23);

            root_2 = (CommonTree)adaptor.becomeRoot(TOKEN23_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_token_in_step586);
            token24=token();

            state._fsp--;

            adaptor.addChild(root_2, token24.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PREDICATES25=(CommonTree)match(input,PREDICATES,FOLLOW_PREDICATES_in_step590); 
            PREDICATES25_tree = (CommonTree)adaptor.dupNode(PREDICATES25);

            root_2 = (CommonTree)adaptor.becomeRoot(PREDICATES25_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:198:42: ( ^( PREDICATE statement ) )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==PREDICATE) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:198:44: ^( PREDICATE statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    PREDICATE26=(CommonTree)match(input,PREDICATE,FOLLOW_PREDICATE_in_step595); 
                	    PREDICATE26_tree = (CommonTree)adaptor.dupNode(PREDICATE26);

                	    root_3 = (CommonTree)adaptor.becomeRoot(PREDICATE26_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_step597);
                	    statement27=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_3, statement27.getTree());
                	     predicates.add((statement27!=null?statement27.op:null)); 

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


                        Atom tokenAtom = (token24!=null?token24.atom:null);
                        
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
                                ((gpath_statement_scope)gpath_statement_stack.peek()).pipeList.addAll(GremlinPipesHelper.pipesForStep((token24!=null?token24.atom:null), predicates));
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:221:1: token returns [Atom atom] : ( expression | '..' );
    public final GremlinEvaluator.token_return token() throws RecognitionException {
        GremlinEvaluator.token_return retval = new GremlinEvaluator.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal29=null;
        GremlinEvaluator.expression_return expression28 = null;


        CommonTree string_literal29_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:222:5: ( expression | '..' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==FUNC_CALL||(LA7_0>=INT && LA7_0<=VARIABLE_CALL)||LA7_0==IDENTIFIER||LA7_0==77||(LA7_0>=80 && LA7_0<=89)) ) {
                alt7=1;
            }
            else if ( (LA7_0==64) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:222:8: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_token639);
                    expression28=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression28.getTree());
                     retval.atom = (expression28!=null?expression28.expr:null).compute(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:223:9: '..'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal29=(CommonTree)match(input,64,FOLLOW_64_in_token651); 
                    string_literal29_tree = (CommonTree)adaptor.dupNode(string_literal29);

                    adaptor.addChild(root_0, string_literal29_tree);



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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:257:1: if_statement returns [Operation op] : ^( IF ^( COND cond= statement ) block ) ;
    public final GremlinEvaluator.if_statement_return if_statement() throws RecognitionException {
        GremlinEvaluator.if_statement_return retval = new GremlinEvaluator.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IF30=null;
        CommonTree COND31=null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return block32 = null;


        CommonTree IF30_tree=null;
        CommonTree COND31_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:258:2: ( ^( IF ^( COND cond= statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:258:4: ^( IF ^( COND cond= statement ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            IF30=(CommonTree)match(input,IF,FOLLOW_IF_in_if_statement676); 
            IF30_tree = (CommonTree)adaptor.dupNode(IF30);

            root_1 = (CommonTree)adaptor.becomeRoot(IF30_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND31=(CommonTree)match(input,COND,FOLLOW_COND_in_if_statement679); 
            COND31_tree = (CommonTree)adaptor.dupNode(COND31);

            root_2 = (CommonTree)adaptor.becomeRoot(COND31_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_if_statement683);
            cond=statement();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_if_statement686);
            block32=block();

            state._fsp--;

            adaptor.addChild(root_1, block32.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new If((cond!=null?cond.op:null), (block32!=null?block32.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:264:1: while_statement returns [Operation op] : ^( WHILE ^( COND cond= statement ) block ) ;
    public final GremlinEvaluator.while_statement_return while_statement() throws RecognitionException {
        GremlinEvaluator.while_statement_return retval = new GremlinEvaluator.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree WHILE33=null;
        CommonTree COND34=null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return block35 = null;


        CommonTree WHILE33_tree=null;
        CommonTree COND34_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:265:2: ( ^( WHILE ^( COND cond= statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:265:4: ^( WHILE ^( COND cond= statement ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            WHILE33=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_while_statement714); 
            WHILE33_tree = (CommonTree)adaptor.dupNode(WHILE33);

            root_1 = (CommonTree)adaptor.becomeRoot(WHILE33_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            COND34=(CommonTree)match(input,COND,FOLLOW_COND_in_while_statement717); 
            COND34_tree = (CommonTree)adaptor.dupNode(COND34);

            root_2 = (CommonTree)adaptor.becomeRoot(COND34_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_while_statement721);
            cond=statement();

            state._fsp--;

            adaptor.addChild(root_2, cond.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_while_statement724);
            block35=block();

            state._fsp--;

            adaptor.addChild(root_1, block35.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new While((cond!=null?cond.op:null), (block35!=null?block35.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:271:1: foreach_statement returns [Operation op] : ^( FOREACH VARIABLE arr= statement block ) ;
    public final GremlinEvaluator.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinEvaluator.foreach_statement_return retval = new GremlinEvaluator.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH36=null;
        CommonTree VARIABLE37=null;
        GremlinEvaluator.statement_return arr = null;

        GremlinEvaluator.block_return block38 = null;


        CommonTree FOREACH36_tree=null;
        CommonTree VARIABLE37_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:272:2: ( ^( FOREACH VARIABLE arr= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:272:4: ^( FOREACH VARIABLE arr= statement block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FOREACH36=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_statement751); 
            FOREACH36_tree = (CommonTree)adaptor.dupNode(FOREACH36);

            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH36_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            VARIABLE37=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement753); 
            VARIABLE37_tree = (CommonTree)adaptor.dupNode(VARIABLE37);

            adaptor.addChild(root_1, VARIABLE37_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_foreach_statement757);
            arr=statement();

            state._fsp--;

            adaptor.addChild(root_1, arr.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_foreach_statement759);
            block38=block();

            state._fsp--;

            adaptor.addChild(root_1, block38.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Foreach((VARIABLE37!=null?VARIABLE37.getText():null), (arr!=null?arr.op:null), (block38!=null?block38.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:278:1: repeat_statement returns [Operation op] : ^( REPEAT timer= statement block ) ;
    public final GremlinEvaluator.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinEvaluator.repeat_statement_return retval = new GremlinEvaluator.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REPEAT39=null;
        GremlinEvaluator.statement_return timer = null;

        GremlinEvaluator.block_return block40 = null;


        CommonTree REPEAT39_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:279:2: ( ^( REPEAT timer= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:279:4: ^( REPEAT timer= statement block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            REPEAT39=(CommonTree)match(input,REPEAT,FOLLOW_REPEAT_in_repeat_statement787); 
            REPEAT39_tree = (CommonTree)adaptor.dupNode(REPEAT39);

            root_1 = (CommonTree)adaptor.becomeRoot(REPEAT39_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_repeat_statement791);
            timer=statement();

            state._fsp--;

            adaptor.addChild(root_1, timer.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_repeat_statement793);
            block40=block();

            state._fsp--;

            adaptor.addChild(root_1, block40.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        retval.op = new Repeat((timer!=null?timer.op:null), (block40!=null?block40.operations:null));
                    

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:285:1: block returns [List<Operation> operations] : ^( BLOCK ( statement )+ ) ;
    public final GremlinEvaluator.block_return block() throws RecognitionException {
        GremlinEvaluator.block_return retval = new GremlinEvaluator.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BLOCK41=null;
        GremlinEvaluator.statement_return statement42 = null;


        CommonTree BLOCK41_tree=null;


                List<Operation> operationList = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:289:5: ( ^( BLOCK ( statement )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:289:7: ^( BLOCK ( statement )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            BLOCK41=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_block832); 
            BLOCK41_tree = (CommonTree)adaptor.dupNode(BLOCK41);

            root_1 = (CommonTree)adaptor.becomeRoot(BLOCK41_tree, root_1);



            match(input, Token.DOWN, null); 
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:289:15: ( statement )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==VAR||LA8_0==FUNC||(LA8_0>=PATH && LA8_0<=GPATH)||(LA8_0>=FUNC_CALL && LA8_0<=IF)||(LA8_0>=FOREACH && LA8_0<=VARIABLE_CALL)||LA8_0==IDENTIFIER||(LA8_0>=66 && LA8_0<=67)||LA8_0==77||(LA8_0>=80 && LA8_0<=89)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:289:16: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_block835);
            	    statement42=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_1, statement42.getTree());
            	     operationList.add((statement42!=null?statement42.op:null)); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:292:1: expression returns [Operation expr] : ( ^( '=' a= operation b= operation ) | ^( '!=' a= operation b= operation ) | ^( '<' a= operation b= operation ) | ^( '>' a= operation b= operation ) | ^( '<=' a= operation b= operation ) | ^( '>=' a= operation b= operation ) | operation );
    public final GremlinEvaluator.expression_return expression() throws RecognitionException {
        GremlinEvaluator.expression_return retval = new GremlinEvaluator.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal43=null;
        CommonTree string_literal44=null;
        CommonTree char_literal45=null;
        CommonTree char_literal46=null;
        CommonTree string_literal47=null;
        CommonTree string_literal48=null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.operation_return operation49 = null;


        CommonTree char_literal43_tree=null;
        CommonTree string_literal44_tree=null;
        CommonTree char_literal45_tree=null;
        CommonTree char_literal46_tree=null;
        CommonTree string_literal47_tree=null;
        CommonTree string_literal48_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:293:5: ( ^( '=' a= operation b= operation ) | ^( '!=' a= operation b= operation ) | ^( '<' a= operation b= operation ) | ^( '>' a= operation b= operation ) | ^( '<=' a= operation b= operation ) | ^( '>=' a= operation b= operation ) | operation )
            int alt9=7;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt9=1;
                }
                break;
            case 81:
                {
                alt9=2;
                }
                break;
            case 82:
                {
                alt9=3;
                }
                break;
            case 84:
                {
                alt9=4;
                }
                break;
            case 83:
                {
                alt9=5;
                }
                break;
            case 85:
                {
                alt9=6;
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
            case 77:
            case 86:
            case 87:
            case 88:
            case 89:
                {
                alt9=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:293:9: ^( '=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal43=(CommonTree)match(input,80,FOLLOW_80_in_expression863); 
                    char_literal43_tree = (CommonTree)adaptor.dupNode(char_literal43);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal43_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression868);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression872);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new Equality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:294:9: ^( '!=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal44=(CommonTree)match(input,81,FOLLOW_81_in_expression886); 
                    string_literal44_tree = (CommonTree)adaptor.dupNode(string_literal44);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal44_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression890);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression894);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new UnEquality((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:295:9: ^( '<' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal45=(CommonTree)match(input,82,FOLLOW_82_in_expression908); 
                    char_literal45_tree = (CommonTree)adaptor.dupNode(char_literal45);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal45_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression913);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression917);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:296:9: ^( '>' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal46=(CommonTree)match(input,84,FOLLOW_84_in_expression931); 
                    char_literal46_tree = (CommonTree)adaptor.dupNode(char_literal46);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal46_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression936);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression940);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThan((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:297:9: ^( '<=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal47=(CommonTree)match(input,83,FOLLOW_83_in_expression954); 
                    string_literal47_tree = (CommonTree)adaptor.dupNode(string_literal47);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal47_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression958);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression962);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new LessThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:298:9: ^( '>=' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal48=(CommonTree)match(input,85,FOLLOW_85_in_expression976); 
                    string_literal48_tree = (CommonTree)adaptor.dupNode(string_literal48);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal48_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression980);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression984);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.expr = new GreaterThanOrEqual((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:299:9: operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression997);
                    operation49=operation();

                    state._fsp--;

                    adaptor.addChild(root_0, operation49.getTree());
                     retval.expr = (operation49!=null?operation49.op:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:302:1: operation returns [Operation op] : ( ^( '+' a= operation b= operation ) | ^( '-' a= operation b= operation ) | binary_operation );
    public final GremlinEvaluator.operation_return operation() throws RecognitionException {
        GremlinEvaluator.operation_return retval = new GremlinEvaluator.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal50=null;
        CommonTree char_literal51=null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.binary_operation_return binary_operation52 = null;


        CommonTree char_literal50_tree=null;
        CommonTree char_literal51_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:303:5: ( ^( '+' a= operation b= operation ) | ^( '-' a= operation b= operation ) | binary_operation )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 86:
                {
                alt10=1;
                }
                break;
            case 87:
                {
                alt10=2;
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
            case 77:
            case 88:
            case 89:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:303:9: ^( '+' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal50=(CommonTree)match(input,86,FOLLOW_86_in_operation1042); 
                    char_literal50_tree = (CommonTree)adaptor.dupNode(char_literal50);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal50_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1046);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1050);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Addition((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:304:9: ^( '-' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal51=(CommonTree)match(input,87,FOLLOW_87_in_operation1064); 
                    char_literal51_tree = (CommonTree)adaptor.dupNode(char_literal51);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal51_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1068);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_operation1072);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.op = new Subtraction((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:305:9: binary_operation
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_binary_operation_in_operation1085);
                    binary_operation52=binary_operation();

                    state._fsp--;

                    adaptor.addChild(root_0, binary_operation52.getTree());
                     retval.op = (binary_operation52!=null?binary_operation52.operation:null); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:308:1: binary_operation returns [Operation operation] : ( ^( '*' a= operation b= operation ) | ^( 'div' a= operation b= operation ) | atom );
    public final GremlinEvaluator.binary_operation_return binary_operation() throws RecognitionException {
        GremlinEvaluator.binary_operation_return retval = new GremlinEvaluator.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal53=null;
        CommonTree string_literal54=null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.atom_return atom55 = null;


        CommonTree char_literal53_tree=null;
        CommonTree string_literal54_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:309:5: ( ^( '*' a= operation b= operation ) | ^( 'div' a= operation b= operation ) | atom )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt11=1;
                }
                break;
            case 89:
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
            case 77:
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:309:9: ^( '*' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal53=(CommonTree)match(input,88,FOLLOW_88_in_binary_operation1122); 
                    char_literal53_tree = (CommonTree)adaptor.dupNode(char_literal53);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal53_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1126);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1130);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Multiplication((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:310:9: ^( 'div' a= operation b= operation )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal54=(CommonTree)match(input,89,FOLLOW_89_in_binary_operation1149); 
                    string_literal54_tree = (CommonTree)adaptor.dupNode(string_literal54);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal54_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1153);
                    a=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, a.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_operation_in_binary_operation1157);
                    b=operation();

                    state._fsp--;

                    adaptor.addChild(root_1, b.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.operation = new Division((a!=null?a.op:null), (b!=null?b.op:null)); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:311:9: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_atom_in_binary_operation1173);
                    atom55=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom55.getTree());
                     retval.operation = new UnaryOperation((atom55!=null?atom55.value:null)); 

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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:314:1: function_definition_statement returns [Operation op] : ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) ;
    public final GremlinEvaluator.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinEvaluator.function_definition_statement_return retval = new GremlinEvaluator.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC56=null;
        CommonTree FUNC_NAME57=null;
        CommonTree NS58=null;
        CommonTree NAME59=null;
        CommonTree ARGS60=null;
        CommonTree ARG61=null;
        CommonTree VARIABLE62=null;
        GremlinEvaluator.block_return block63 = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC56_tree=null;
        CommonTree FUNC_NAME57_tree=null;
        CommonTree NS58_tree=null;
        CommonTree NAME59_tree=null;
        CommonTree ARGS60_tree=null;
        CommonTree ARG61_tree=null;
        CommonTree VARIABLE62_tree=null;


                List<String> params = new ArrayList<String>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:318:2: ( ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:318:4: ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC56=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_function_definition_statement1231); 
            FUNC56_tree = (CommonTree)adaptor.dupNode(FUNC56);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC56_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME57=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_definition_statement1234); 
            FUNC_NAME57_tree = (CommonTree)adaptor.dupNode(FUNC_NAME57);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME57_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS58=(CommonTree)match(input,NS,FOLLOW_NS_in_function_definition_statement1237); 
            NS58_tree = (CommonTree)adaptor.dupNode(NS58);

            root_3 = (CommonTree)adaptor.becomeRoot(NS58_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1241); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME59=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_definition_statement1245); 
            NAME59_tree = (CommonTree)adaptor.dupNode(NAME59);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME59_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition_statement1249); 
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
            ARGS60=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_definition_statement1254); 
            ARGS60_tree = (CommonTree)adaptor.dupNode(ARGS60);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS60_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:318:78: ( ^( ARG VARIABLE ) )*
                loop12:
                do {
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==ARG) ) {
                        alt12=1;
                    }


                    switch (alt12) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:318:80: ^( ARG VARIABLE )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG61=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_definition_statement1259); 
                	    ARG61_tree = (CommonTree)adaptor.dupNode(ARG61);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG61_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    VARIABLE62=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_function_definition_statement1261); 
                	    VARIABLE62_tree = (CommonTree)adaptor.dupNode(VARIABLE62);

                	    adaptor.addChild(root_3, VARIABLE62_tree);

                	     params.add((VARIABLE62!=null?VARIABLE62.getText():null)); 

                	    match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
                	    }


                	    }
                	    break;

                	default :
                	    break loop12;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_block_in_function_definition_statement1270);
            block63=block();

            state._fsp--;

            adaptor.addChild(root_1, block63.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


                        NativeFunction fn = new NativeFunction((fn_name!=null?fn_name.getText():null), params, (block63!=null?block63.operations:null));
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
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:327:1: function_call returns [Atom value] : ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) ;
    public final GremlinEvaluator.function_call_return function_call() throws RecognitionException {
        GremlinEvaluator.function_call_return retval = new GremlinEvaluator.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns=null;
        CommonTree fn_name=null;
        CommonTree FUNC_CALL64=null;
        CommonTree FUNC_NAME65=null;
        CommonTree NS66=null;
        CommonTree NAME67=null;
        CommonTree ARGS68=null;
        CommonTree ARG69=null;
        GremlinEvaluator.statement_return st = null;


        CommonTree ns_tree=null;
        CommonTree fn_name_tree=null;
        CommonTree FUNC_CALL64_tree=null;
        CommonTree FUNC_NAME65_tree=null;
        CommonTree NS66_tree=null;
        CommonTree NAME67_tree=null;
        CommonTree ARGS68_tree=null;
        CommonTree ARG69_tree=null;


                List<Operation> params = new ArrayList<Operation>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:331:2: ( ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:331:4: ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_CALL64=(CommonTree)match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_function_call1307); 
            FUNC_CALL64_tree = (CommonTree)adaptor.dupNode(FUNC_CALL64);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_CALL64_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNC_NAME65=(CommonTree)match(input,FUNC_NAME,FOLLOW_FUNC_NAME_in_function_call1310); 
            FUNC_NAME65_tree = (CommonTree)adaptor.dupNode(FUNC_NAME65);

            root_2 = (CommonTree)adaptor.becomeRoot(FUNC_NAME65_tree, root_2);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NS66=(CommonTree)match(input,NS,FOLLOW_NS_in_function_call1313); 
            NS66_tree = (CommonTree)adaptor.dupNode(NS66);

            root_3 = (CommonTree)adaptor.becomeRoot(NS66_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ns=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1317); 
            ns_tree = (CommonTree)adaptor.dupNode(ns);

            adaptor.addChild(root_3, ns_tree);


            match(input, Token.UP, null); adaptor.addChild(root_2, root_3);_last = _save_last_3;
            }

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            NAME67=(CommonTree)match(input,NAME,FOLLOW_NAME_in_function_call1321); 
            NAME67_tree = (CommonTree)adaptor.dupNode(NAME67);

            root_3 = (CommonTree)adaptor.becomeRoot(NAME67_tree, root_3);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            fn_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_call1325); 
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
            ARGS68=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_function_call1330); 
            ARGS68_tree = (CommonTree)adaptor.dupNode(ARGS68);

            root_2 = (CommonTree)adaptor.becomeRoot(ARGS68_tree, root_2);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:331:83: ( ^( ARG st= statement ) )*
                loop13:
                do {
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==ARG) ) {
                        alt13=1;
                    }


                    switch (alt13) {
                	case 1 :
                	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:331:85: ^( ARG st= statement )
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    {
                	    CommonTree _save_last_3 = _last;
                	    CommonTree _first_3 = null;
                	    CommonTree root_3 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                	    ARG69=(CommonTree)match(input,ARG,FOLLOW_ARG_in_function_call1335); 
                	    ARG69_tree = (CommonTree)adaptor.dupNode(ARG69);

                	    root_3 = (CommonTree)adaptor.becomeRoot(ARG69_tree, root_3);



                	    match(input, Token.DOWN, null); 
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_function_call1339);
                	    st=statement();

                	    state._fsp--;

                	    adaptor.addChild(root_3, st.getTree());
                	     params.add((st!=null?st.op:null)); 

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

    public static class atom_return extends TreeRuleReturnScope {
        public Atom value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:341:1: atom returns [Atom value] : ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | ^( RANGE min= G_INT max= G_INT ) | ^( STR StringLiteral ) | ^( BOOL b= BOOLEAN ) | NULL | ^( ARR ( NUMBER )+ ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | function_call | '(' statement ')' );
    public final GremlinEvaluator.atom_return atom() throws RecognitionException {
        GremlinEvaluator.atom_return retval = new GremlinEvaluator.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree min=null;
        CommonTree max=null;
        CommonTree b=null;
        CommonTree INT70=null;
        CommonTree G_INT71=null;
        CommonTree LONG72=null;
        CommonTree G_LONG73=null;
        CommonTree FLOAT74=null;
        CommonTree G_FLOAT75=null;
        CommonTree DOUBLE76=null;
        CommonTree G_DOUBLE77=null;
        CommonTree RANGE78=null;
        CommonTree STR79=null;
        CommonTree StringLiteral80=null;
        CommonTree BOOL81=null;
        CommonTree NULL82=null;
        CommonTree ARR83=null;
        CommonTree NUMBER84=null;
        CommonTree VARIABLE_CALL85=null;
        CommonTree VARIABLE86=null;
        CommonTree PROPERTY_CALL87=null;
        CommonTree PROPERTY88=null;
        CommonTree IDENTIFIER89=null;
        CommonTree char_literal91=null;
        CommonTree char_literal93=null;
        GremlinEvaluator.function_call_return function_call90 = null;

        GremlinEvaluator.statement_return statement92 = null;


        CommonTree min_tree=null;
        CommonTree max_tree=null;
        CommonTree b_tree=null;
        CommonTree INT70_tree=null;
        CommonTree G_INT71_tree=null;
        CommonTree LONG72_tree=null;
        CommonTree G_LONG73_tree=null;
        CommonTree FLOAT74_tree=null;
        CommonTree G_FLOAT75_tree=null;
        CommonTree DOUBLE76_tree=null;
        CommonTree G_DOUBLE77_tree=null;
        CommonTree RANGE78_tree=null;
        CommonTree STR79_tree=null;
        CommonTree StringLiteral80_tree=null;
        CommonTree BOOL81_tree=null;
        CommonTree NULL82_tree=null;
        CommonTree ARR83_tree=null;
        CommonTree NUMBER84_tree=null;
        CommonTree VARIABLE_CALL85_tree=null;
        CommonTree VARIABLE86_tree=null;
        CommonTree PROPERTY_CALL87_tree=null;
        CommonTree PROPERTY88_tree=null;
        CommonTree IDENTIFIER89_tree=null;
        CommonTree char_literal91_tree=null;
        CommonTree char_literal93_tree=null;


                List<Double> array = new ArrayList<Double>();
            
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:345:2: ( ^( INT G_INT ) | ^( LONG G_LONG ) | ^( FLOAT G_FLOAT ) | ^( DOUBLE G_DOUBLE ) | ^( RANGE min= G_INT max= G_INT ) | ^( STR StringLiteral ) | ^( BOOL b= BOOLEAN ) | NULL | ^( ARR ( NUMBER )+ ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | function_call | '(' statement ')' )
            int alt15=14;
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
            case RANGE:
                {
                alt15=5;
                }
                break;
            case STR:
                {
                alt15=6;
                }
                break;
            case BOOL:
                {
                alt15=7;
                }
                break;
            case NULL:
                {
                alt15=8;
                }
                break;
            case ARR:
                {
                alt15=9;
                }
                break;
            case VARIABLE_CALL:
                {
                alt15=10;
                }
                break;
            case PROPERTY_CALL:
                {
                alt15=11;
                }
                break;
            case IDENTIFIER:
                {
                alt15=12;
                }
                break;
            case FUNC_CALL:
                {
                alt15=13;
                }
                break;
            case 77:
                {
                alt15=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:345:6: ^( INT G_INT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    INT70=(CommonTree)match(input,INT,FOLLOW_INT_in_atom1385); 
                    INT70_tree = (CommonTree)adaptor.dupNode(INT70);

                    root_1 = (CommonTree)adaptor.becomeRoot(INT70_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_INT71=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1387); 
                    G_INT71_tree = (CommonTree)adaptor.dupNode(G_INT71);

                    adaptor.addChild(root_1, G_INT71_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Integer>(new Integer((G_INT71!=null?G_INT71.getText():null))); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:346:6: ^( LONG G_LONG )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    LONG72=(CommonTree)match(input,LONG,FOLLOW_LONG_in_atom1445); 
                    LONG72_tree = (CommonTree)adaptor.dupNode(LONG72);

                    root_1 = (CommonTree)adaptor.becomeRoot(LONG72_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_LONG73=(CommonTree)match(input,G_LONG,FOLLOW_G_LONG_in_atom1447); 
                    G_LONG73_tree = (CommonTree)adaptor.dupNode(G_LONG73);

                    adaptor.addChild(root_1, G_LONG73_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String longStr = (G_LONG73!=null?G_LONG73.getText():null);
                    	                                                                    retval.value = new Atom<Long>(new Long(longStr.substring(0, longStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:350:6: ^( FLOAT G_FLOAT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    FLOAT74=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_atom1503); 
                    FLOAT74_tree = (CommonTree)adaptor.dupNode(FLOAT74);

                    root_1 = (CommonTree)adaptor.becomeRoot(FLOAT74_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_FLOAT75=(CommonTree)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_atom1505); 
                    G_FLOAT75_tree = (CommonTree)adaptor.dupNode(G_FLOAT75);

                    adaptor.addChild(root_1, G_FLOAT75_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom<Float>(new Float((G_FLOAT75!=null?G_FLOAT75.getText():null))); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:351:6: ^( DOUBLE G_DOUBLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    DOUBLE76=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_atom1559); 
                    DOUBLE76_tree = (CommonTree)adaptor.dupNode(DOUBLE76);

                    root_1 = (CommonTree)adaptor.becomeRoot(DOUBLE76_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    G_DOUBLE77=(CommonTree)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_atom1561); 
                    G_DOUBLE77_tree = (CommonTree)adaptor.dupNode(G_DOUBLE77);

                    adaptor.addChild(root_1, G_DOUBLE77_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    	                                                                    String doubleStr = (G_DOUBLE77!=null?G_DOUBLE77.getText():null);
                    	                                                                    retval.value = new Atom<Double>(new Double(doubleStr.substring(0, doubleStr.length() - 1)));
                    	                                                                

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:355:6: ^( RANGE min= G_INT max= G_INT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    RANGE78=(CommonTree)match(input,RANGE,FOLLOW_RANGE_in_atom1613); 
                    RANGE78_tree = (CommonTree)adaptor.dupNode(RANGE78);

                    root_1 = (CommonTree)adaptor.becomeRoot(RANGE78_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    min=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1617); 
                    min_tree = (CommonTree)adaptor.dupNode(min);

                    adaptor.addChild(root_1, min_tree);

                    _last = (CommonTree)input.LT(1);
                    max=(CommonTree)match(input,G_INT,FOLLOW_G_INT_in_atom1621); 
                    max_tree = (CommonTree)adaptor.dupNode(max);

                    adaptor.addChild(root_1, max_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom(new Range((min!=null?min.getText():null), (max!=null?max.getText():null))); 

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:356:4: ^( STR StringLiteral )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    STR79=(CommonTree)match(input,STR,FOLLOW_STR_in_atom1661); 
                    STR79_tree = (CommonTree)adaptor.dupNode(STR79);

                    root_1 = (CommonTree)adaptor.becomeRoot(STR79_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    StringLiteral80=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_atom1663); 
                    StringLiteral80_tree = (CommonTree)adaptor.dupNode(StringLiteral80);

                    adaptor.addChild(root_1, StringLiteral80_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom((StringLiteral80!=null?StringLiteral80.getText():null)); 

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:357:9: ^( BOOL b= BOOLEAN )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    BOOL81=(CommonTree)match(input,BOOL,FOLLOW_BOOL_in_atom1716); 
                    BOOL81_tree = (CommonTree)adaptor.dupNode(BOOL81);

                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL81_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    b=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_atom1720); 
                    b_tree = (CommonTree)adaptor.dupNode(b);

                    adaptor.addChild(root_1, b_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom(new Boolean((b!=null?b.getText():null))); 

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:358:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    NULL82=(CommonTree)match(input,NULL,FOLLOW_NULL_in_atom1775); 
                    NULL82_tree = (CommonTree)adaptor.dupNode(NULL82);

                    adaptor.addChild(root_0, NULL82_tree);

                     retval.value = new Atom(null); 

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:359:9: ^( ARR ( NUMBER )+ )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    ARR83=(CommonTree)match(input,ARR,FOLLOW_ARR_in_atom1843); 
                    ARR83_tree = (CommonTree)adaptor.dupNode(ARR83);

                    root_1 = (CommonTree)adaptor.becomeRoot(ARR83_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:359:15: ( NUMBER )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==NUMBER) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:359:16: NUMBER
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    NUMBER84=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_atom1846); 
                    	    NUMBER84_tree = (CommonTree)adaptor.dupNode(NUMBER84);

                    	    adaptor.addChild(root_1, NUMBER84_tree);

                    	     array.add(new Double((NUMBER84!=null?NUMBER84.getText():null))); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.value = new Atom(array); 

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:360:4: ^( VARIABLE_CALL VARIABLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VARIABLE_CALL85=(CommonTree)match(input,VARIABLE_CALL,FOLLOW_VARIABLE_CALL_in_atom1861); 
                    VARIABLE_CALL85_tree = (CommonTree)adaptor.dupNode(VARIABLE_CALL85);

                    root_1 = (CommonTree)adaptor.becomeRoot(VARIABLE_CALL85_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VARIABLE86=(CommonTree)match(input,VARIABLE,FOLLOW_VARIABLE_in_atom1863); 
                    VARIABLE86_tree = (CommonTree)adaptor.dupNode(VARIABLE86);

                    adaptor.addChild(root_1, VARIABLE86_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     
                                                                                          retval.value = getVariable((VARIABLE86!=null?VARIABLE86.getText():null)); 
                                                                                        

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:363:4: ^( PROPERTY_CALL PROPERTY )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    PROPERTY_CALL87=(CommonTree)match(input,PROPERTY_CALL,FOLLOW_PROPERTY_CALL_in_atom1906); 
                    PROPERTY_CALL87_tree = (CommonTree)adaptor.dupNode(PROPERTY_CALL87);

                    root_1 = (CommonTree)adaptor.becomeRoot(PROPERTY_CALL87_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    PROPERTY88=(CommonTree)match(input,PROPERTY,FOLLOW_PROPERTY_in_atom1908); 
                    PROPERTY88_tree = (CommonTree)adaptor.dupNode(PROPERTY88);

                    adaptor.addChild(root_1, PROPERTY88_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     
                                                                                            Atom propertyAtom = new Atom((PROPERTY88!=null?PROPERTY88.getText():null).substring(1));
                                                                                            propertyAtom.setProperty(true);
                                                                                            retval.value = propertyAtom;
                                                                                        

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:368:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER89=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atom1950); 
                    IDENTIFIER89_tree = (CommonTree)adaptor.dupNode(IDENTIFIER89);

                    adaptor.addChild(root_0, IDENTIFIER89_tree);


                    	                                                                    String idText = (IDENTIFIER89!=null?IDENTIFIER89.getText():null);
                                                                                            
                    	                                                                    if (idText.equals(".") && !isGPath) {
                    	                                                                        retval.value = getVariable(Tokens.ROOT_VARIABLE);
                    	                                                                    } else if (idText.matches("^[\\d]+..[\\d]+")) {
                                                                                                Matcher range = rangePattern.matcher(idText);
                                                                                                if (range.matches())
                                                                                                    retval.value = new Atom(new Range(range.group(1), range.group(2)));
                                                                                                else
                                                                                                    retval.value = new Atom(null);
                    	                                                                    } else {
                                                                                                Atom idAtom = new Atom((IDENTIFIER89!=null?IDENTIFIER89.getText():null));
                                                                                                idAtom.setIdentifier(true);
                                                                                                retval.value = idAtom;
                                                                                            }
                                                                                        

                    }
                    break;
                case 13 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:385:4: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_call_in_atom2006);
                    function_call90=function_call();

                    state._fsp--;

                    adaptor.addChild(root_0, function_call90.getTree());
                     retval.value = (function_call90!=null?function_call90.value:null); 

                    }
                    break;
                case 14 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:386:4: '(' statement ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal91=(CommonTree)match(input,77,FOLLOW_77_in_atom2059); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_atom2062);
                    statement92=statement();

                    state._fsp--;

                    adaptor.addChild(root_0, statement92.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal93=(CommonTree)match(input,78,FOLLOW_78_in_atom2064); 

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


 

    public static final BitSet FOLLOW_statement_in_program61 = new BitSet(new long[]{0x000004BFFF981892L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_NEWLINE_in_program65 = new BitSet(new long[]{0x000004BFFF981892L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_if_statement_in_statement107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_definition_statement_in_statement218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_statement273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_statement301 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_statement303 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_statement_in_statement307 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_66_in_statement329 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement333 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_statement_in_statement337 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_statement354 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement359 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_statement_in_statement363 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_statement379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_include_statement422 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement424 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PATH_in_path_definition_statement461 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_path_definition_statement465 = new BitSet(new long[]{0x0000001000001000L});
    public static final BitSet FOLLOW_gpath_statement_in_path_definition_statement470 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_path_definition_statement477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_path_definition_statement481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GPATH_in_gpath_statement540 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_step_in_gpath_statement543 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_STEP_in_step581 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_in_step584 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_step586 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREDICATES_in_step590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PREDICATE_in_step595 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_step597 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_token639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_token651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_statement676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_if_statement679 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_if_statement683 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_if_statement686 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_while_statement714 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_while_statement717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_while_statement721 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_while_statement724 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_statement751 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement753 = new BitSet(new long[]{0x000004BFFFD81890L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_statement_in_foreach_statement757 = new BitSet(new long[]{0x000004BFFFD81890L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_block_in_foreach_statement759 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_repeat_statement787 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_repeat_statement791 = new BitSet(new long[]{0x000004BFFFD81890L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_block_in_repeat_statement793 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_block832 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block835 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_80_in_expression863 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression868 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_operation_in_expression872 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_81_in_expression886 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression890 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_operation_in_expression894 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_82_in_expression908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression913 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_operation_in_expression917 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_84_in_expression931 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression936 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_operation_in_expression940 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_83_in_expression954 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression958 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_operation_in_expression962 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_85_in_expression976 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression980 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_operation_in_expression984 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_operation_in_expression997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_operation1042 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_operation1046 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_operation_in_operation1050 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_87_in_operation1064 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_operation1068 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_operation_in_operation1072 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binary_operation_in_operation1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_binary_operation1122 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_binary_operation1126 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_operation_in_binary_operation1130 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_89_in_binary_operation1149 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_binary_operation1153 = new BitSet(new long[]{0x000004BFFF981898L,0x0000000003FF200CL});
    public static final BitSet FOLLOW_operation_in_binary_operation1157 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_binary_operation1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_in_function_definition_statement1231 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_definition_statement1234 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_definition_statement1237 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1241 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_definition_statement1245 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1249 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_definition_statement1254 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_definition_statement1259 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_function_definition_statement1261 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_function_definition_statement1270 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_function_call1307 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_call1310 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_call1313 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1317 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_call1321 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1325 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_call1330 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_call1335 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_function_call1339 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_atom1385 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_INT_in_atom1387 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONG_in_atom1445 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_LONG_in_atom1447 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FLOAT_in_atom1503 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_FLOAT_in_atom1505 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLE_in_atom1559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_DOUBLE_in_atom1561 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_atom1613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_G_INT_in_atom1617 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_G_INT_in_atom1621 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STR_in_atom1661 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_atom1663 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOOL_in_atom1716 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOLEAN_in_atom1720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_atom1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARR_in_atom1843 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NUMBER_in_atom1846 = new BitSet(new long[]{0x0000000000000008L,0x0000000008000000L});
    public static final BitSet FOLLOW_VARIABLE_CALL_in_atom1861 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_atom1863 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_atom1906 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_atom1908 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_atom2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_atom2059 = new BitSet(new long[]{0x000004BFFF981890L,0x0000000003FF600CL});
    public static final BitSet FOLLOW_statement_in_atom2062 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_atom2064 = new BitSet(new long[]{0x0000000000000002L});

}
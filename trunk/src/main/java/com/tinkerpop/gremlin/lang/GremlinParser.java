// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g 2009-11-12 16:22:54
 package com.tinkerpop.gremlin.lang; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class GremlinParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WHITESPACE", "NEWLINE", "SINGLE_COMMENT", "VARIABLE", "ASSIGN", "DIGIT", "INTEGER", "REAL", "STRING", "PATH"
    };
    public static final int INTEGER=10;
    public static final int SINGLE_COMMENT=6;
    public static final int EOF=-1;
    public static final int VARIABLE=7;
    public static final int ASSIGN=8;
    public static final int STRING=12;
    public static final int DIGIT=9;
    public static final int REAL=11;
    public static final int WHITESPACE=4;
    public static final int NEWLINE=5;
    public static final int PATH=13;

    // delegates
    // delegators


        public GremlinParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public GremlinParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return GremlinParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g"; }


    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:10:1: program : ( statement )+ ;
    public final GremlinParser.program_return program() throws RecognitionException {
        GremlinParser.program_return retval = new GremlinParser.program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.statement_return statement1 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:10:9: ( ( statement )+ )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:10:11: ( statement )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:10:11: ( statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==VARIABLE||(LA1_0>=INTEGER && LA1_0<=PATH)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:10:11: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program36);
            	    statement1=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class integer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "integer"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:12:1: integer : INTEGER ;
    public final GremlinParser.integer_return integer() throws RecognitionException {
        GremlinParser.integer_return retval = new GremlinParser.integer_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INTEGER2=null;

        Object INTEGER2_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:12:9: ( INTEGER )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:12:11: INTEGER
            {
            root_0 = (Object)adaptor.nil();

            INTEGER2=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_integer45); 
            INTEGER2_tree = (Object)adaptor.create(INTEGER2);
            adaptor.addChild(root_0, INTEGER2_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "integer"

    public static class real_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "real"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:13:1: real : REAL ;
    public final GremlinParser.real_return real() throws RecognitionException {
        GremlinParser.real_return retval = new GremlinParser.real_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token REAL3=null;

        Object REAL3_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:13:7: ( REAL )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:13:9: REAL
            {
            root_0 = (Object)adaptor.nil();

            REAL3=(Token)match(input,REAL,FOLLOW_REAL_in_real53); 
            REAL3_tree = (Object)adaptor.create(REAL3);
            adaptor.addChild(root_0, REAL3_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "real"

    public static class string_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "string"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:14:1: string : STRING ;
    public final GremlinParser.string_return string() throws RecognitionException {
        GremlinParser.string_return retval = new GremlinParser.string_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STRING4=null;

        Object STRING4_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:14:9: ( STRING )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:14:11: STRING
            {
            root_0 = (Object)adaptor.nil();

            STRING4=(Token)match(input,STRING,FOLLOW_STRING_in_string61); 
            STRING4_tree = (Object)adaptor.create(STRING4);
            adaptor.addChild(root_0, STRING4_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "string"

    public static class path_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "path"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:15:1: path : PATH ;
    public final GremlinParser.path_return path() throws RecognitionException {
        GremlinParser.path_return retval = new GremlinParser.path_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PATH5=null;

        Object PATH5_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:15:6: ( PATH )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:15:8: PATH
            {
            root_0 = (Object)adaptor.nil();

            PATH5=(Token)match(input,PATH,FOLLOW_PATH_in_path68); 
            PATH5_tree = (Object)adaptor.create(PATH5);
            adaptor.addChild(root_0, PATH5_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "path"

    public static class value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:17:1: value : ( integer | real | string | path );
    public final GremlinParser.value_return value() throws RecognitionException {
        GremlinParser.value_return retval = new GremlinParser.value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.integer_return integer6 = null;

        GremlinParser.real_return real7 = null;

        GremlinParser.string_return string8 = null;

        GremlinParser.path_return path9 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:17:7: ( integer | real | string | path )
            int alt2=4;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt2=1;
                }
                break;
            case REAL:
                {
                alt2=2;
                }
                break;
            case STRING:
                {
                alt2=3;
                }
                break;
            case PATH:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:17:9: integer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_integer_in_value76);
                    integer6=integer();

                    state._fsp--;

                    adaptor.addChild(root_0, integer6.getTree());

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:17:19: real
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_real_in_value80);
                    real7=real();

                    state._fsp--;

                    adaptor.addChild(root_0, real7.getTree());

                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:17:26: string
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_string_in_value84);
                    string8=string();

                    state._fsp--;

                    adaptor.addChild(root_0, string8.getTree());

                    }
                    break;
                case 4 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:17:35: path
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_path_in_value88);
                    path9=path();

                    state._fsp--;

                    adaptor.addChild(root_0, path9.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "value"

    public static class variable_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:18:1: variable : VARIABLE ;
    public final GremlinParser.variable_return variable() throws RecognitionException {
        GremlinParser.variable_return retval = new GremlinParser.variable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VARIABLE10=null;

        Object VARIABLE10_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:18:10: ( VARIABLE )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:18:12: VARIABLE
            {
            root_0 = (Object)adaptor.nil();

            VARIABLE10=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_variable95); 
            VARIABLE10_tree = (Object)adaptor.create(VARIABLE10);
            adaptor.addChild(root_0, VARIABLE10_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variable"

    public static class terminator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "terminator"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:19:1: terminator : ( NEWLINE | EOF );
    public final GremlinParser.terminator_return terminator() throws RecognitionException {
        GremlinParser.terminator_return retval = new GremlinParser.terminator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set11=null;

        Object set11_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:19:12: ( NEWLINE | EOF )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:
            {
            root_0 = (Object)adaptor.nil();

            set11=(Token)input.LT(1);
            if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set11));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "terminator"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:22:1: statement : ( variable ASSIGN value terminator -> ^( ASSIGN variable value ) | value terminator -> ^( value ) );
    public final GremlinParser.statement_return statement() throws RecognitionException {
        GremlinParser.statement_return retval = new GremlinParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASSIGN13=null;
        GremlinParser.variable_return variable12 = null;

        GremlinParser.value_return value14 = null;

        GremlinParser.terminator_return terminator15 = null;

        GremlinParser.value_return value16 = null;

        GremlinParser.terminator_return terminator17 = null;


        Object ASSIGN13_tree=null;
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_terminator=new RewriteRuleSubtreeStream(adaptor,"rule terminator");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_variable=new RewriteRuleSubtreeStream(adaptor,"rule variable");
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:22:11: ( variable ASSIGN value terminator -> ^( ASSIGN variable value ) | value terminator -> ^( value ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==VARIABLE) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=INTEGER && LA3_0<=PATH)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:22:13: variable ASSIGN value terminator
                    {
                    pushFollow(FOLLOW_variable_in_statement121);
                    variable12=variable();

                    state._fsp--;

                    stream_variable.add(variable12.getTree());
                    ASSIGN13=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_statement123);  
                    stream_ASSIGN.add(ASSIGN13);

                    pushFollow(FOLLOW_value_in_statement125);
                    value14=value();

                    state._fsp--;

                    stream_value.add(value14.getTree());
                    pushFollow(FOLLOW_terminator_in_statement127);
                    terminator15=terminator();

                    state._fsp--;

                    stream_terminator.add(terminator15.getTree());


                    // AST REWRITE
                    // elements: value, variable, ASSIGN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 22:46: -> ^( ASSIGN variable value )
                    {
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:22:49: ^( ASSIGN variable value )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_variable.nextTree());
                        adaptor.addChild(root_1, stream_value.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:22:76: value terminator
                    {
                    pushFollow(FOLLOW_value_in_statement141);
                    value16=value();

                    state._fsp--;

                    stream_value.add(value16.getTree());
                    pushFollow(FOLLOW_terminator_in_statement143);
                    terminator17=terminator();

                    state._fsp--;

                    stream_terminator.add(terminator17.getTree());


                    // AST REWRITE
                    // elements: value
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 22:93: -> ^( value )
                    {
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:22:96: ^( value )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_value.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_in_program36 = new BitSet(new long[]{0x0000000000003C82L});
    public static final BitSet FOLLOW_INTEGER_in_integer45 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_real53 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_string61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PATH_in_path68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_in_value76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_real_in_value80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_value84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_in_value88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_variable95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_terminator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_statement121 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ASSIGN_in_statement123 = new BitSet(new long[]{0x0000000000003CA0L});
    public static final BitSet FOLLOW_value_in_statement125 = new BitSet(new long[]{0x0000000000003CA0L});
    public static final BitSet FOLLOW_terminator_in_statement127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_statement141 = new BitSet(new long[]{0x0000000000003CA0L});
    public static final BitSet FOLLOW_terminator_in_statement143 = new BitSet(new long[]{0x0000000000000002L});

}
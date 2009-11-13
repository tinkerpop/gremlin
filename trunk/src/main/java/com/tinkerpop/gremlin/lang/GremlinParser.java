// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g 2009-11-13 11:24:47
 package com.tinkerpop.gremlin.lang; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class GremlinParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WHITESPACE", "NEWLINE", "SINGLE_COMMENT", "VARIABLE", "ASSIGN", "DIGIT", "NATURAL", "REAL", "STRING", "PATH"
    };
    public static final int SINGLE_COMMENT=6;
    public static final int EOF=-1;
    public static final int VARIABLE=7;
    public static final int STRING=12;
    public static final int ASSIGN=8;
    public static final int NATURAL=10;
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
    public String getGrammarFileName() { return "/Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g"; }


    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:10:1: program : ( statement )+ ;
    public final GremlinParser.program_return program() throws RecognitionException {
        GremlinParser.program_return retval = new GremlinParser.program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.statement_return statement1 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:10:9: ( ( statement )+ )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:10:11: ( statement )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:10:11: ( statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==VARIABLE||(LA1_0>=NATURAL && LA1_0<=PATH)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:10:11: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program38);
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

    public static class terminator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "terminator"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:12:1: terminator : ( NEWLINE | EOF );
    public final GremlinParser.terminator_return terminator() throws RecognitionException {
        GremlinParser.terminator_return retval = new GremlinParser.terminator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set2=null;

        Object set2_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:12:12: ( NEWLINE | EOF )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:
            {
            root_0 = (Object)adaptor.nil();

            set2=(Token)input.LT(1);
            if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set2));
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

    public static class natural_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "natural"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:14:1: natural : NATURAL ;
    public final GremlinParser.natural_return natural() throws RecognitionException {
        GremlinParser.natural_return retval = new GremlinParser.natural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NATURAL3=null;

        Object NATURAL3_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:14:9: ( NATURAL )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:14:11: NATURAL
            {
            root_0 = (Object)adaptor.nil();

            NATURAL3=(Token)match(input,NATURAL,FOLLOW_NATURAL_in_natural59); 
            NATURAL3_tree = (Object)adaptor.create(NATURAL3);
            adaptor.addChild(root_0, NATURAL3_tree);


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
    // $ANTLR end "natural"

    public static class real_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "real"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:15:1: real : REAL ;
    public final GremlinParser.real_return real() throws RecognitionException {
        GremlinParser.real_return retval = new GremlinParser.real_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token REAL4=null;

        Object REAL4_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:15:7: ( REAL )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:15:9: REAL
            {
            root_0 = (Object)adaptor.nil();

            REAL4=(Token)match(input,REAL,FOLLOW_REAL_in_real67); 
            REAL4_tree = (Object)adaptor.create(REAL4);
            adaptor.addChild(root_0, REAL4_tree);


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
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:16:1: string : STRING ;
    public final GremlinParser.string_return string() throws RecognitionException {
        GremlinParser.string_return retval = new GremlinParser.string_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STRING5=null;

        Object STRING5_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:16:9: ( STRING )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:16:11: STRING
            {
            root_0 = (Object)adaptor.nil();

            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_string75); 
            STRING5_tree = (Object)adaptor.create(STRING5);
            adaptor.addChild(root_0, STRING5_tree);


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
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:17:1: path : PATH ;
    public final GremlinParser.path_return path() throws RecognitionException {
        GremlinParser.path_return retval = new GremlinParser.path_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PATH6=null;

        Object PATH6_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:17:6: ( PATH )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:17:8: PATH
            {
            root_0 = (Object)adaptor.nil();

            PATH6=(Token)match(input,PATH,FOLLOW_PATH_in_path82); 
            PATH6_tree = (Object)adaptor.create(PATH6);
            adaptor.addChild(root_0, PATH6_tree);


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

    public static class variable_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:18:1: variable : VARIABLE ;
    public final GremlinParser.variable_return variable() throws RecognitionException {
        GremlinParser.variable_return retval = new GremlinParser.variable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VARIABLE7=null;

        Object VARIABLE7_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:18:10: ( VARIABLE )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:18:12: VARIABLE
            {
            root_0 = (Object)adaptor.nil();

            VARIABLE7=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_variable89); 
            VARIABLE7_tree = (Object)adaptor.create(VARIABLE7);
            adaptor.addChild(root_0, VARIABLE7_tree);


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

    public static class value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:20:1: value : ( natural | real | string | path | variable );
    public final GremlinParser.value_return value() throws RecognitionException {
        GremlinParser.value_return retval = new GremlinParser.value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.natural_return natural8 = null;

        GremlinParser.real_return real9 = null;

        GremlinParser.string_return string10 = null;

        GremlinParser.path_return path11 = null;

        GremlinParser.variable_return variable12 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:20:7: ( natural | real | string | path | variable )
            int alt2=5;
            switch ( input.LA(1) ) {
            case NATURAL:
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
            case VARIABLE:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:20:9: natural
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_natural_in_value97);
                    natural8=natural();

                    state._fsp--;

                    adaptor.addChild(root_0, natural8.getTree());

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:20:19: real
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_real_in_value101);
                    real9=real();

                    state._fsp--;

                    adaptor.addChild(root_0, real9.getTree());

                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:20:26: string
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_string_in_value105);
                    string10=string();

                    state._fsp--;

                    adaptor.addChild(root_0, string10.getTree());

                    }
                    break;
                case 4 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:20:35: path
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_path_in_value109);
                    path11=path();

                    state._fsp--;

                    adaptor.addChild(root_0, path11.getTree());

                    }
                    break;
                case 5 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:20:42: variable
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_value113);
                    variable12=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable12.getTree());

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

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:22:1: statement : ( variable ASSIGN value terminator -> ^( ASSIGN variable value ) | value terminator -> ^( value ) );
    public final GremlinParser.statement_return statement() throws RecognitionException {
        GremlinParser.statement_return retval = new GremlinParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASSIGN14=null;
        GremlinParser.variable_return variable13 = null;

        GremlinParser.value_return value15 = null;

        GremlinParser.terminator_return terminator16 = null;

        GremlinParser.value_return value17 = null;

        GremlinParser.terminator_return terminator18 = null;


        Object ASSIGN14_tree=null;
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_terminator=new RewriteRuleSubtreeStream(adaptor,"rule terminator");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_variable=new RewriteRuleSubtreeStream(adaptor,"rule variable");
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:22:11: ( variable ASSIGN value terminator -> ^( ASSIGN variable value ) | value terminator -> ^( value ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==VARIABLE) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==ASSIGN) ) {
                    alt3=1;
                }
                else if ( (LA3_1==EOF||LA3_1==NEWLINE) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA3_0>=NATURAL && LA3_0<=PATH)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:22:13: variable ASSIGN value terminator
                    {
                    pushFollow(FOLLOW_variable_in_statement127);
                    variable13=variable();

                    state._fsp--;

                    stream_variable.add(variable13.getTree());
                    ASSIGN14=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_statement129);  
                    stream_ASSIGN.add(ASSIGN14);

                    pushFollow(FOLLOW_value_in_statement131);
                    value15=value();

                    state._fsp--;

                    stream_value.add(value15.getTree());
                    pushFollow(FOLLOW_terminator_in_statement133);
                    terminator16=terminator();

                    state._fsp--;

                    stream_terminator.add(terminator16.getTree());


                    // AST REWRITE
                    // elements: value, ASSIGN, variable
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
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:22:49: ^( ASSIGN variable value )
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
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:22:76: value terminator
                    {
                    pushFollow(FOLLOW_value_in_statement147);
                    value17=value();

                    state._fsp--;

                    stream_value.add(value17.getTree());
                    pushFollow(FOLLOW_terminator_in_statement149);
                    terminator18=terminator();

                    state._fsp--;

                    stream_terminator.add(terminator18.getTree());


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
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinParser.g:22:96: ^( value )
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


 

    public static final BitSet FOLLOW_statement_in_program38 = new BitSet(new long[]{0x0000000000003C82L});
    public static final BitSet FOLLOW_set_in_terminator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NATURAL_in_natural59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_real67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_string75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PATH_in_path82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_variable89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_natural_in_value97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_real_in_value101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_value105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_in_value109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_value113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_statement127 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ASSIGN_in_statement129 = new BitSet(new long[]{0x0000000000003CA0L});
    public static final BitSet FOLLOW_value_in_statement131 = new BitSet(new long[]{0x0000000000003CA0L});
    public static final BitSet FOLLOW_terminator_in_statement133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_statement147 = new BitSet(new long[]{0x0000000000003CA0L});
    public static final BitSet FOLLOW_terminator_in_statement149 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g 2009-11-12 16:23:31

package com.tinkerpop.gremlin.lang;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GremlinWalker extends TreeParser {
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


        public GremlinWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public GremlinWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return GremlinWalker.tokenNames; }
    public String getGrammarFileName() { return "/Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g"; }



    // $ANTLR start "program"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:12:1: program : ( statement )+ ;
    public final void program() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:12:9: ( ( statement )+ )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:12:11: ( statement )+
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:12:11: ( statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ASSIGN||(LA1_0>=INTEGER && LA1_0<=PATH)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:12:11: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program37);
            	    statement();

            	    state._fsp--;


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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "program"


    // $ANTLR start "integer"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:14:1: integer : INTEGER ;
    public final void integer() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:14:9: ( INTEGER )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:14:11: INTEGER
            {
            match(input,INTEGER,FOLLOW_INTEGER_in_integer46); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "integer"


    // $ANTLR start "real"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:15:1: real : REAL ;
    public final void real() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:15:7: ( REAL )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:15:9: REAL
            {
            match(input,REAL,FOLLOW_REAL_in_real54); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "real"


    // $ANTLR start "string"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:16:1: string : STRING ;
    public final void string() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:16:9: ( STRING )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:16:11: STRING
            {
            match(input,STRING,FOLLOW_STRING_in_string62); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "string"


    // $ANTLR start "path"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:17:1: path : PATH ;
    public final void path() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:17:6: ( PATH )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:17:8: PATH
            {
            match(input,PATH,FOLLOW_PATH_in_path69); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "path"

    public static class value_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "value"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:19:1: value : ( integer | real | string | path );
    public final GremlinWalker.value_return value() throws RecognitionException {
        GremlinWalker.value_return retval = new GremlinWalker.value_return();
        retval.start = input.LT(1);

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:19:7: ( integer | real | string | path )
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
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:19:9: integer
                    {
                    pushFollow(FOLLOW_integer_in_value77);
                    integer();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:19:19: real
                    {
                    pushFollow(FOLLOW_real_in_value81);
                    real();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:19:26: string
                    {
                    pushFollow(FOLLOW_string_in_value85);
                    string();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:19:35: path
                    {
                    pushFollow(FOLLOW_path_in_value89);
                    path();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "value"

    public static class variable_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "variable"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:20:1: variable : VARIABLE ;
    public final GremlinWalker.variable_return variable() throws RecognitionException {
        GremlinWalker.variable_return retval = new GremlinWalker.variable_return();
        retval.start = input.LT(1);

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:20:10: ( VARIABLE )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:20:12: VARIABLE
            {
            match(input,VARIABLE,FOLLOW_VARIABLE_in_variable97); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variable"


    // $ANTLR start "terminator"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:21:1: terminator : ( NEWLINE | EOF );
    public final void terminator() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:21:12: ( NEWLINE | EOF )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:
            {
            if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "terminator"


    // $ANTLR start "statement"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:24:1: statement : ( ^( ASSIGN variable value ) | value );
    public final void statement() throws RecognitionException {
        GremlinWalker.variable_return variable1 = null;

        GremlinWalker.value_return value2 = null;

        GremlinWalker.value_return value3 = null;


        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:24:11: ( ^( ASSIGN variable value ) | value )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ASSIGN) ) {
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
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:24:13: ^( ASSIGN variable value )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_statement124); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_variable_in_statement126);
                    variable1=variable();

                    state._fsp--;

                    pushFollow(FOLLOW_value_in_statement128);
                    value2=value();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    System.out.println((variable1!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(variable1.start),
                      input.getTreeAdaptor().getTokenStopIndex(variable1.start))):null) + " here dude " + (value2!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(value2.start),
                      input.getTreeAdaptor().getTokenStopIndex(value2.start))):null));

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinWalker.g:25:6: value
                    {
                    pushFollow(FOLLOW_value_in_statement138);
                    value3=value();

                    state._fsp--;

                    System.out.println("marko: " + (value3!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(value3.start),
                      input.getTreeAdaptor().getTokenStopIndex(value3.start))):null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "statement"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_in_program37 = new BitSet(new long[]{0x0000000000003D02L});
    public static final BitSet FOLLOW_INTEGER_in_integer46 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_real54 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_string62 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PATH_in_path69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_in_value77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_real_in_value81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_value85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_in_value89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_variable97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_terminator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_statement124 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_variable_in_statement126 = new BitSet(new long[]{0x0000000000003D08L});
    public static final BitSet FOLLOW_value_in_statement128 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_value_in_statement138 = new BitSet(new long[]{0x0000000000000002L});

}
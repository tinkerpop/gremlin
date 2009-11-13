// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g 2009-11-13 11:27:23

  package com.tinkerpop.gremlin.lang;
  
  import com.tinkerpop.gremlin.Evaluator;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Gremlin extends TreeParser {
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
    public static final int PATH=13;
    public static final int NEWLINE=5;

    // delegates
    // delegators


        public Gremlin(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public Gremlin(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return Gremlin.tokenNames; }
    public String getGrammarFileName() { return "/Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g"; }


       private Evaluator evaluator;
      
       public Gremlin(TreeNodeStream input, Evaluator evaluator) {
            this(input, new RecognizerSharedState());
            this.evaluator = evaluator;
       }




    // $ANTLR start "program"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:25:1: program : ( statement )+ ;
    public final void program() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:25:9: ( ( statement )+ )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:25:11: ( statement )+
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:25:11: ( statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=VARIABLE && LA1_0<=ASSIGN)||(LA1_0>=NATURAL && LA1_0<=PATH)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:25:11: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program50);
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


    // $ANTLR start "natural"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:27:1: natural : NATURAL ;
    public final void natural() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:27:9: ( NATURAL )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:27:11: NATURAL
            {
            match(input,NATURAL,FOLLOW_NATURAL_in_natural59); 

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
    // $ANTLR end "natural"


    // $ANTLR start "real"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:28:1: real : REAL ;
    public final void real() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:28:7: ( REAL )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:28:9: REAL
            {
            match(input,REAL,FOLLOW_REAL_in_real67); 

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
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:29:1: string : STRING ;
    public final void string() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:29:9: ( STRING )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:29:11: STRING
            {
            match(input,STRING,FOLLOW_STRING_in_string75); 

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
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:30:1: path : PATH ;
    public final void path() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:30:6: ( PATH )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:30:8: PATH
            {
            match(input,PATH,FOLLOW_PATH_in_path82); 

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
        public String t;
    };

    // $ANTLR start "value"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:32:1: value returns [String t] : ( natural | real | string | path | variable );
    public final Gremlin.value_return value() throws RecognitionException {
        Gremlin.value_return retval = new Gremlin.value_return();
        retval.start = input.LT(1);

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:32:25: ( natural | real | string | path | variable )
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
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:32:27: natural
                    {
                    pushFollow(FOLLOW_natural_in_value93);
                    natural();

                    state._fsp--;

                    retval.t ="NATURAL";

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:32:52: real
                    {
                    pushFollow(FOLLOW_real_in_value98);
                    real();

                    state._fsp--;

                    retval.t ="REAL";

                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:32:72: string
                    {
                    pushFollow(FOLLOW_string_in_value104);
                    string();

                    state._fsp--;

                    retval.t ="STRING";

                    }
                    break;
                case 4 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:32:96: path
                    {
                    pushFollow(FOLLOW_path_in_value110);
                    path();

                    state._fsp--;

                    retval.t ="PATH";

                    }
                    break;
                case 5 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:32:116: variable
                    {
                    pushFollow(FOLLOW_variable_in_value116);
                    variable();

                    state._fsp--;

                    retval.t ="VARIABLE";

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
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:33:1: variable : VARIABLE ;
    public final Gremlin.variable_return variable() throws RecognitionException {
        Gremlin.variable_return retval = new Gremlin.variable_return();
        retval.start = input.LT(1);

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:33:10: ( VARIABLE )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:33:12: VARIABLE
            {
            match(input,VARIABLE,FOLLOW_VARIABLE_in_variable125); 

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
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:34:1: terminator : ( NEWLINE | EOF );
    public final void terminator() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:34:12: ( NEWLINE | EOF )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:
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
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:37:1: statement : ( ^( ASSIGN variable value ) | value );
    public final void statement() throws RecognitionException {
        Gremlin.variable_return variable1 = null;

        Gremlin.value_return value2 = null;

        Gremlin.value_return value3 = null;


        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:37:11: ( ^( ASSIGN variable value ) | value )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ASSIGN) ) {
                alt3=1;
            }
            else if ( (LA3_0==VARIABLE||(LA3_0>=NATURAL && LA3_0<=PATH)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:37:13: ^( ASSIGN variable value )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_statement152); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_variable_in_statement154);
                    variable1=variable();

                    state._fsp--;

                    pushFollow(FOLLOW_value_in_statement156);
                    value2=value();

                    state._fsp--;


                    match(input, Token.UP, null); 


                      evaluator.setVariable((variable1!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(variable1.start),
                      input.getTreeAdaptor().getTokenStopIndex(variable1.start))):null), (value2!=null?value2.t:null), (value2!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(value2.start),
                      input.getTreeAdaptor().getTokenStopIndex(value2.start))):null));


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/Gremlin.g:41:6: value
                    {
                    pushFollow(FOLLOW_value_in_statement166);
                    value3=value();

                    state._fsp--;


                    	  
                      evaluator.evaluate(null, (value3!=null?(input.getTokenStream().toString(
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


 

    public static final BitSet FOLLOW_statement_in_program50 = new BitSet(new long[]{0x0000000000003D82L});
    public static final BitSet FOLLOW_NATURAL_in_natural59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_real67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_string75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PATH_in_path82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_natural_in_value93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_real_in_value98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_value104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_in_value110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_value116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_variable125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_terminator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_statement152 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_variable_in_statement154 = new BitSet(new long[]{0x0000000000003D88L});
    public static final BitSet FOLLOW_value_in_statement156 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_value_in_statement166 = new BitSet(new long[]{0x0000000000000002L});

}
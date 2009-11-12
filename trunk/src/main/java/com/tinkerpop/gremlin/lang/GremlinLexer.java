// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g 2009-11-12 16:22:51
 package com.tinkerpop.gremlin.lang; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GremlinLexer extends Lexer {
    public static final int INTEGER=10;
    public static final int SINGLE_COMMENT=6;
    public static final int EOF=-1;
    public static final int VARIABLE=7;
    public static final int STRING=12;
    public static final int ASSIGN=8;
    public static final int DIGIT=9;
    public static final int REAL=11;
    public static final int WHITESPACE=4;
    public static final int PATH=13;
    public static final int NEWLINE=5;

    // delegates
    // delegators

    public GremlinLexer() {;} 
    public GremlinLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public GremlinLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g"; }

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:5:11: ( ( ' ' | '\\t' )+ )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:5:13: ( ' ' | '\\t' )+
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:5:13: ( ' ' | '\\t' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\t'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:7:9: ( ( ( '\\r' )? '\\n' )+ )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:7:11: ( ( '\\r' )? '\\n' )+
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:7:11: ( ( '\\r' )? '\\n' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\n'||LA3_0=='\r') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:7:12: ( '\\r' )? '\\n'
            	    {
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:7:12: ( '\\r' )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0=='\r') ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:7:12: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "SINGLE_COMMENT"
    public final void mSINGLE_COMMENT() throws RecognitionException {
        try {
            int _type = SINGLE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:9:15: ( '//' (~ ( '\\r' | '\\n' ) )* NEWLINE )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:9:17: '//' (~ ( '\\r' | '\\n' ) )* NEWLINE
            {
            match("//"); 

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:9:22: (~ ( '\\r' | '\\n' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:9:22: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            mNEWLINE(); 
             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINGLE_COMMENT"

    // $ANTLR start "VARIABLE"
    public final void mVARIABLE() throws RecognitionException {
        try {
            int _type = VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:10: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) )* )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:12: '$' ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) )*
            {
            match('$'); 
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:40: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) )*
            loop5:
            do {
                int alt5=4;
                switch ( input.LA(1) ) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt5=1;
                    }
                    break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    {
                    alt5=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt5=3;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:41: ( 'a' .. 'z' )
            	    {
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:41: ( 'a' .. 'z' )
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:42: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:54: ( 'A' .. 'Z' )
            	    {
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:54: ( 'A' .. 'Z' )
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:55: 'A' .. 'Z'
            	    {
            	    matchRange('A','Z'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:69: ( '0' .. '9' )
            	    {
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:69: ( '0' .. '9' )
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:11:70: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARIABLE"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:13:8: ( ':=' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:13:10: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:15:16: ( ( '0' .. '9' ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:15:18: ( '0' .. '9' )
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:15:18: ( '0' .. '9' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:15:19: '0' .. '9'
            {
            matchRange('0','9'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:16:9: ( ( '1' .. '9' ) ( DIGIT )* )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:16:11: ( '1' .. '9' ) ( DIGIT )*
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:16:11: ( '1' .. '9' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:16:12: '1' .. '9'
            {
            matchRange('1','9'); 

            }

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:16:22: ( DIGIT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:16:22: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:17:6: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:17:8: ( '0' .. '9' )+ '.' ( '0' .. '9' )*
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:17:8: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:17:9: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            match('.'); 
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:17:24: ( '0' .. '9' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:17:24: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:18:8: ( '\"' (~ ( '\"' ) )* '\"' | '\\'' (~ ( '\\'' ) )* '\\'' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\"') ) {
                alt11=1;
            }
            else if ( (LA11_0=='\'') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:18:10: '\"' (~ ( '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:18:14: (~ ( '\"' ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='\uFFFF')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:18:14: ~ ( '\"' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:18:28: '\\'' (~ ( '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:18:33: (~ ( '\\'' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='\u0000' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='\uFFFF')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:18:33: ~ ( '\\'' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "PATH"
    public final void mPATH() throws RecognitionException {
        try {
            int _type = PATH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:19:6: ( '~' STRING )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:19:8: '~' STRING
            {
            match('~'); 
            mSTRING(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PATH"

    public void mTokens() throws RecognitionException {
        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:1:8: ( WHITESPACE | NEWLINE | SINGLE_COMMENT | VARIABLE | ASSIGN | INTEGER | REAL | STRING | PATH )
        int alt12=9;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:1:10: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 2 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:1:21: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 3 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:1:29: SINGLE_COMMENT
                {
                mSINGLE_COMMENT(); 

                }
                break;
            case 4 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:1:44: VARIABLE
                {
                mVARIABLE(); 

                }
                break;
            case 5 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:1:53: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 6 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:1:60: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 7 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:1:68: REAL
                {
                mREAL(); 

                }
                break;
            case 8 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:1:73: STRING
                {
                mSTRING(); 

                }
                break;
            case 9 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/lang/GremlinLexer.g:1:80: PATH
                {
                mPATH(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\6\uffff\1\13\3\uffff\1\13\1\uffff";
    static final String DFA12_eofS =
        "\14\uffff";
    static final String DFA12_minS =
        "\1\11\5\uffff\1\56\3\uffff\1\56\1\uffff";
    static final String DFA12_maxS =
        "\1\176\5\uffff\1\71\3\uffff\1\71\1\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\1\11\1\uffff\1\6";
    static final String DFA12_specialS =
        "\14\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1\1\2\2\uffff\1\2\22\uffff\1\1\1\uffff\1\10\1\uffff\1\4\2"+
            "\uffff\1\10\7\uffff\1\3\1\7\11\6\1\5\103\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "\1\7\1\uffff\12\12",
            "",
            "",
            "",
            "\1\7\1\uffff\12\12",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( WHITESPACE | NEWLINE | SINGLE_COMMENT | VARIABLE | ASSIGN | INTEGER | REAL | STRING | PATH );";
        }
    }
 

}
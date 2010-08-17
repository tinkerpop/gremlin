// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g 2010-08-15 20:12:13
package com.tinkerpop.gremlin.compiler;

import org.antlr.runtime.*;

public class GremlinLexer extends Lexer {
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
    public static final int G_INT=47;
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
    public static final int VARIABLE=45;
    public static final int T__70=70;
    public static final int G_DOUBLE=50;
    public static final int PROPERTY=44;
    public static final int FUNC=7;
    public static final int G_LONG=48;
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
    public static final int IDENTIFIER=46;
    public static final int EscapeCharacter=61;
    public static final int COLLECTION_CALL=40;
    public static final int G_FLOAT=49;
    public static final int PROPERTY_CALL=38;
    public static final int UnicodeEscapeSequence=58;
    public static final int RANGE=37;
    public static final int StringLiteral=43;
    public static final int NEWLINE=42;
    public static final int BLOCK=23;
    public static final int NonEscapeCharacter=60;
    public static final int LONG=30;
    public static final int COND=22;
    public static final int SELF=17;
    public static final int VARIABLE_CALL=39;

    // delegates
    // delegators

    public GremlinLexer() {;} 
    public GremlinLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public GremlinLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g"; }

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:5:7: ( '/' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:5:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:6:7: ( '[' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:6:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:7:7: ( ']' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:7:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:8:7: ( '..' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:8:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:9:7: ( ':=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:9:9: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:10:7: ( 'and' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:10:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:11:7: ( 'or' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:11:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:12:7: ( 'include' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:12:9: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:13:7: ( 'script' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:13:9: 'script'
            {
            match("script"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:14:7: ( 'if' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:14:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:15:7: ( 'else' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:15:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:16:7: ( 'end' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:16:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:17:7: ( 'foreach' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:17:9: 'foreach'
            {
            match("foreach"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:18:7: ( 'in' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:18:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:19:7: ( 'while' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:19:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:20:7: ( 'repeat' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:20:9: 'repeat'
            {
            match("repeat"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:21:7: ( 'path' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:21:9: 'path'
            {
            match("path"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:22:7: ( 'func' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:22:9: 'func'
            {
            match("func"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:23:7: ( '(' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:23:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:24:7: ( ')' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:24:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:25:7: ( ',' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:25:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:26:7: ( '=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:26:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:27:7: ( '!=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:27:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:28:7: ( '<' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:28:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:29:7: ( '<=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:29:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:30:7: ( '>' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:30:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:31:7: ( '>=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:31:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:32:7: ( '+' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:32:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:33:7: ( '-' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:33:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:34:7: ( '*' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:34:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:35:7: ( 'div' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:35:9: 'div'
            {
            match("div"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:36:7: ( 'mod' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:36:9: 'mod'
            {
            match("mod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:37:7: ( ':' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:37:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:72:5: ( '#' ( . )* NEWLINE )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:72:7: '#' ( . )* NEWLINE
            {
            match('#'); 
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:72:11: ( . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\n'||LA1_0=='\r'||(LA1_0>='\u2028' && LA1_0<='\u2029')) ) {
                    alt1=2;
                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\u2027')||(LA1_0>='\u202A' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:72:11: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "COMMENT"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:206:2: ( '\"' ( DoubleStringCharacter )* '\"' | '\\'' ( SingleStringCharacter )* '\\'' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\"') ) {
                alt4=1;
            }
            else if ( (LA4_0=='\'') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:206:4: '\"' ( DoubleStringCharacter )* '\"'
                    {
                    match('\"'); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:206:8: ( DoubleStringCharacter )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='\u2027')||(LA2_0>='\u202A' && LA2_0<='\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:206:8: DoubleStringCharacter
                    	    {
                    	    mDoubleStringCharacter(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:4: '\\'' ( SingleStringCharacter )* '\\''
                    {
                    match('\''); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:9: ( SingleStringCharacter )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='\u2027')||(LA3_0>='\u202A' && LA3_0<='\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:9: SingleStringCharacter
                    	    {
                    	    mSingleStringCharacter(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
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
    // $ANTLR end "StringLiteral"

    // $ANTLR start "G_INT"
    public final void mG_INT() throws RecognitionException {
        try {
            int _type = G_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:212:5: ( ( '-' )? ( '0' .. '9' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:212:7: ( '-' )? ( '0' .. '9' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:212:7: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:212:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:212:12: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:212:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "G_INT"

    // $ANTLR start "G_LONG"
    public final void mG_LONG() throws RecognitionException {
        try {
            int _type = G_LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:216:5: ( ( '-' )? ( '0' .. '9' )+ 'l' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:216:7: ( '-' )? ( '0' .. '9' )+ 'l'
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:216:7: ( '-' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='-') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:216:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:216:12: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:216:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

            match('l'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "G_LONG"

    // $ANTLR start "G_FLOAT"
    public final void mG_FLOAT() throws RecognitionException {
        try {
            int _type = G_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:220:5: ( G_INT '.' G_INT )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:220:7: G_INT '.' G_INT
            {
            mG_INT(); 
            match('.'); 
            mG_INT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "G_FLOAT"

    // $ANTLR start "G_DOUBLE"
    public final void mG_DOUBLE() throws RecognitionException {
        try {
            int _type = G_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:224:5: ( G_FLOAT 'd' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:224:7: G_FLOAT 'd'
            {
            mG_FLOAT(); 
            match('d'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "G_DOUBLE"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:228:5: ( 'true' | 'false' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='t') ) {
                alt9=1;
            }
            else if ( (LA9_0=='f') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:228:7: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:229:7: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:233:5: ( 'null' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:233:7: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "VARIABLE"
    public final void mVARIABLE() throws RecognitionException {
        try {
            int _type = VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:241:5: ( '$' IDENTIFIER )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:241:9: '$' IDENTIFIER
            {
            match('$'); 
            mIDENTIFIER(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARIABLE"

    // $ANTLR start "PROPERTY"
    public final void mPROPERTY() throws RecognitionException {
        try {
            int _type = PROPERTY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:245:2: ( '@' IDENTIFIER )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:245:4: '@' IDENTIFIER
            {
            match('@'); 
            mIDENTIFIER(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROPERTY"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:249:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:249:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:249:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='-' && LA10_0<='.')||(LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:253:2: ( '\\n' | '\\r' | '\\u2028' | '\\u2029' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r'||(input.LA(1)>='\u2028' && input.LA(1)<='\u2029') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:260:5: ( ( ' ' | '\\t' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:260:7: ( ' ' | '\\t' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:260:7: ( ' ' | '\\t' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\t'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "DoubleStringCharacter"
    public final void mDoubleStringCharacter() throws RecognitionException {
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:264:2: (~ ( '\"' | '\\\\' | NEWLINE ) | '\\\\' EscapeSequence )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\u2027')||(LA12_0>='\u202A' && LA12_0<='\uFFFF')) ) {
                alt12=1;
            }
            else if ( (LA12_0=='\\') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:264:4: ~ ( '\"' | '\\\\' | NEWLINE )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\u2027')||(input.LA(1)>='\u202A' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:265:4: '\\\\' EscapeSequence
                    {
                    match('\\'); 
                    mEscapeSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "DoubleStringCharacter"

    // $ANTLR start "SingleStringCharacter"
    public final void mSingleStringCharacter() throws RecognitionException {
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:269:2: (~ ( '\\'' | '\\\\' | NEWLINE ) | '\\\\' EscapeSequence )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\u2027')||(LA13_0>='\u202A' && LA13_0<='\uFFFF')) ) {
                alt13=1;
            }
            else if ( (LA13_0=='\\') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:269:4: ~ ( '\\'' | '\\\\' | NEWLINE )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\u2027')||(input.LA(1)>='\u202A' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:270:4: '\\\\' EscapeSequence
                    {
                    match('\\'); 
                    mEscapeSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "SingleStringCharacter"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:274:2: ( CharacterEscapeSequence | '0' | HexEscapeSequence | UnicodeEscapeSequence )
            int alt14=4;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='/')||(LA14_0>=':' && LA14_0<='t')||(LA14_0>='v' && LA14_0<='w')||(LA14_0>='y' && LA14_0<='\u2027')||(LA14_0>='\u202A' && LA14_0<='\uFFFF')) ) {
                alt14=1;
            }
            else if ( (LA14_0=='0') ) {
                alt14=2;
            }
            else if ( (LA14_0=='x') ) {
                alt14=3;
            }
            else if ( (LA14_0=='u') ) {
                alt14=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:274:4: CharacterEscapeSequence
                    {
                    mCharacterEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:275:4: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:276:4: HexEscapeSequence
                    {
                    mHexEscapeSequence(); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:277:4: UnicodeEscapeSequence
                    {
                    mUnicodeEscapeSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "CharacterEscapeSequence"
    public final void mCharacterEscapeSequence() throws RecognitionException {
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:281:2: ( SingleEscapeCharacter | NonEscapeCharacter )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\"'||LA15_0=='\''||LA15_0=='\\'||LA15_0=='b'||LA15_0=='f'||LA15_0=='n'||LA15_0=='r'||LA15_0=='t'||LA15_0=='v') ) {
                alt15=1;
            }
            else if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='!')||(LA15_0>='#' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='/')||(LA15_0>=':' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='a')||(LA15_0>='c' && LA15_0<='e')||(LA15_0>='g' && LA15_0<='m')||(LA15_0>='o' && LA15_0<='q')||LA15_0=='s'||LA15_0=='w'||(LA15_0>='y' && LA15_0<='\u2027')||(LA15_0>='\u202A' && LA15_0<='\uFFFF')) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:281:4: SingleEscapeCharacter
                    {
                    mSingleEscapeCharacter(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:282:4: NonEscapeCharacter
                    {
                    mNonEscapeCharacter(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "CharacterEscapeSequence"

    // $ANTLR start "NonEscapeCharacter"
    public final void mNonEscapeCharacter() throws RecognitionException {
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:286:2: (~ ( EscapeCharacter | NEWLINE ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:286:4: ~ ( EscapeCharacter | NEWLINE )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='/')||(input.LA(1)>=':' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='a')||(input.LA(1)>='c' && input.LA(1)<='e')||(input.LA(1)>='g' && input.LA(1)<='m')||(input.LA(1)>='o' && input.LA(1)<='q')||input.LA(1)=='s'||input.LA(1)=='w'||(input.LA(1)>='y' && input.LA(1)<='\u2027')||(input.LA(1)>='\u202A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "NonEscapeCharacter"

    // $ANTLR start "SingleEscapeCharacter"
    public final void mSingleEscapeCharacter() throws RecognitionException {
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:290:2: ( '\\'' | '\"' | '\\\\' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:
            {
            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SingleEscapeCharacter"

    // $ANTLR start "EscapeCharacter"
    public final void mEscapeCharacter() throws RecognitionException {
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:294:2: ( SingleEscapeCharacter | DecimalDigit | 'x' | 'u' )
            int alt16=4;
            switch ( input.LA(1) ) {
            case '\"':
            case '\'':
            case '\\':
            case 'b':
            case 'f':
            case 'n':
            case 'r':
            case 't':
            case 'v':
                {
                alt16=1;
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
                alt16=2;
                }
                break;
            case 'x':
                {
                alt16=3;
                }
                break;
            case 'u':
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:294:4: SingleEscapeCharacter
                    {
                    mSingleEscapeCharacter(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:295:4: DecimalDigit
                    {
                    mDecimalDigit(); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:296:4: 'x'
                    {
                    match('x'); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:297:4: 'u'
                    {
                    match('u'); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "EscapeCharacter"

    // $ANTLR start "HexEscapeSequence"
    public final void mHexEscapeSequence() throws RecognitionException {
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:301:2: ( 'x' HexDigit HexDigit )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:301:4: 'x' HexDigit HexDigit
            {
            match('x'); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "HexEscapeSequence"

    // $ANTLR start "UnicodeEscapeSequence"
    public final void mUnicodeEscapeSequence() throws RecognitionException {
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:305:2: ( 'u' HexDigit HexDigit HexDigit HexDigit )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:305:4: 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('u'); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UnicodeEscapeSequence"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:309:2: ( DecimalDigit | ( 'a' .. 'f' ) | ( 'A' .. 'F' ) )
            int alt17=3;
            switch ( input.LA(1) ) {
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
                alt17=1;
                }
                break;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
                {
                alt17=2;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:309:4: DecimalDigit
                    {
                    mDecimalDigit(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:309:19: ( 'a' .. 'f' )
                    {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:309:19: ( 'a' .. 'f' )
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:309:20: 'a' .. 'f'
                    {
                    matchRange('a','f'); 

                    }


                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:309:32: ( 'A' .. 'F' )
                    {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:309:32: ( 'A' .. 'F' )
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:309:33: 'A' .. 'F'
                    {
                    matchRange('A','F'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "DecimalDigit"
    public final void mDecimalDigit() throws RecognitionException {
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:313:2: ( ( '0' .. '9' ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:313:4: ( '0' .. '9' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "DecimalDigit"

    public void mTokens() throws RecognitionException {
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:8: ( T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | COMMENT | StringLiteral | G_INT | G_LONG | G_FLOAT | G_DOUBLE | BOOLEAN | NULL | VARIABLE | PROPERTY | IDENTIFIER | NEWLINE | WS )
        int alt18=46;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:10: T__64
                {
                mT__64(); 

                }
                break;
            case 2 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:16: T__65
                {
                mT__65(); 

                }
                break;
            case 3 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:22: T__66
                {
                mT__66(); 

                }
                break;
            case 4 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:28: T__67
                {
                mT__67(); 

                }
                break;
            case 5 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:34: T__68
                {
                mT__68(); 

                }
                break;
            case 6 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:40: T__69
                {
                mT__69(); 

                }
                break;
            case 7 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:46: T__70
                {
                mT__70(); 

                }
                break;
            case 8 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:52: T__71
                {
                mT__71(); 

                }
                break;
            case 9 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:58: T__72
                {
                mT__72(); 

                }
                break;
            case 10 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:64: T__73
                {
                mT__73(); 

                }
                break;
            case 11 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:70: T__74
                {
                mT__74(); 

                }
                break;
            case 12 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:76: T__75
                {
                mT__75(); 

                }
                break;
            case 13 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:82: T__76
                {
                mT__76(); 

                }
                break;
            case 14 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:88: T__77
                {
                mT__77(); 

                }
                break;
            case 15 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:94: T__78
                {
                mT__78(); 

                }
                break;
            case 16 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:100: T__79
                {
                mT__79(); 

                }
                break;
            case 17 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:106: T__80
                {
                mT__80(); 

                }
                break;
            case 18 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:112: T__81
                {
                mT__81(); 

                }
                break;
            case 19 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:118: T__82
                {
                mT__82(); 

                }
                break;
            case 20 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:124: T__83
                {
                mT__83(); 

                }
                break;
            case 21 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:130: T__84
                {
                mT__84(); 

                }
                break;
            case 22 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:136: T__85
                {
                mT__85(); 

                }
                break;
            case 23 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:142: T__86
                {
                mT__86(); 

                }
                break;
            case 24 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:148: T__87
                {
                mT__87(); 

                }
                break;
            case 25 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:154: T__88
                {
                mT__88(); 

                }
                break;
            case 26 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:160: T__89
                {
                mT__89(); 

                }
                break;
            case 27 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:166: T__90
                {
                mT__90(); 

                }
                break;
            case 28 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:172: T__91
                {
                mT__91(); 

                }
                break;
            case 29 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:178: T__92
                {
                mT__92(); 

                }
                break;
            case 30 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:184: T__93
                {
                mT__93(); 

                }
                break;
            case 31 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:190: T__94
                {
                mT__94(); 

                }
                break;
            case 32 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:196: T__95
                {
                mT__95(); 

                }
                break;
            case 33 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:202: T__96
                {
                mT__96(); 

                }
                break;
            case 34 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:208: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 35 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:216: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 36 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:230: G_INT
                {
                mG_INT(); 

                }
                break;
            case 37 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:236: G_LONG
                {
                mG_LONG(); 

                }
                break;
            case 38 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:243: G_FLOAT
                {
                mG_FLOAT(); 

                }
                break;
            case 39 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:251: G_DOUBLE
                {
                mG_DOUBLE(); 

                }
                break;
            case 40 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:260: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 41 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:268: NULL
                {
                mNULL(); 

                }
                break;
            case 42 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:273: VARIABLE
                {
                mVARIABLE(); 

                }
                break;
            case 43 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:282: PROPERTY
                {
                mPROPERTY(); 

                }
                break;
            case 44 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:291: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 45 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:302: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 46 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:310: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\4\uffff\1\42\1\47\11\42\5\uffff\1\66\1\70\1\uffff\1\71\1\uffff"+
        "\2\42\2\uffff\1\74\2\42\5\uffff\1\101\2\uffff\1\42\1\103\1\105\1"+
        "\106\11\42\5\uffff\2\42\1\uffff\1\42\1\124\2\42\1\uffff\1\127\1"+
        "\uffff\1\42\2\uffff\2\42\1\133\6\42\1\142\1\143\1\42\1\144\1\uffff"+
        "\2\42\1\uffff\2\42\1\152\1\uffff\1\42\1\154\3\42\1\160\3\uffff\1"+
        "\161\1\162\1\163\2\42\1\uffff\1\42\1\uffff\1\162\1\167\1\42\4\uffff"+
        "\1\42\1\172\1\42\1\uffff\1\174\1\175\1\uffff\1\176\3\uffff";
    static final String DFA18_eofS =
        "\177\uffff";
    static final String DFA18_minS =
        "\1\11\3\uffff\1\56\1\75\1\156\1\162\1\146\1\143\1\154\1\141\1\150"+
        "\1\145\1\141\5\uffff\2\75\1\uffff\1\55\1\uffff\1\151\1\157\2\uffff"+
        "\1\55\1\162\1\165\5\uffff\1\55\2\uffff\1\144\3\55\1\162\1\163\1"+
        "\144\1\162\1\156\1\154\1\151\1\160\1\164\5\uffff\1\166\1\144\1\uffff"+
        "\2\55\1\165\1\154\1\uffff\1\55\1\uffff\1\154\2\uffff\1\151\1\145"+
        "\1\55\1\145\1\143\1\163\1\154\1\145\1\150\2\55\1\60\1\55\1\uffff"+
        "\1\145\1\154\1\uffff\1\165\1\160\1\55\1\uffff\1\141\1\55\2\145\1"+
        "\141\1\55\3\uffff\3\55\1\144\1\164\1\uffff\1\143\1\uffff\2\55\1"+
        "\164\4\uffff\1\145\1\55\1\150\1\uffff\2\55\1\uffff\1\55\3\uffff";
    static final String DFA18_maxS =
        "\1\u2029\3\uffff\1\56\1\75\1\156\1\162\1\156\1\143\1\156\1\165\1"+
        "\150\1\145\1\141\5\uffff\2\75\1\uffff\1\172\1\uffff\1\151\1\157"+
        "\2\uffff\1\172\1\162\1\165\5\uffff\1\172\2\uffff\1\144\3\172\1\162"+
        "\1\163\1\144\1\162\1\156\1\154\1\151\1\160\1\164\5\uffff\1\166\1"+
        "\144\1\uffff\1\71\1\172\1\165\1\154\1\uffff\1\172\1\uffff\1\154"+
        "\2\uffff\1\151\1\145\1\172\1\145\1\143\1\163\1\154\1\145\1\150\2"+
        "\172\1\71\1\172\1\uffff\1\145\1\154\1\uffff\1\165\1\160\1\172\1"+
        "\uffff\1\141\1\172\2\145\1\141\1\172\3\uffff\3\172\1\144\1\164\1"+
        "\uffff\1\143\1\uffff\2\172\1\164\4\uffff\1\145\1\172\1\150\1\uffff"+
        "\2\172\1\uffff\1\172\3\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\1\3\13\uffff\1\23\1\24\1\25\1\26\1\27\2\uffff\1"+
        "\34\1\uffff\1\36\2\uffff\1\42\1\43\3\uffff\1\52\1\53\1\54\1\55\1"+
        "\56\1\uffff\1\5\1\41\15\uffff\1\31\1\30\1\33\1\32\1\35\2\uffff\1"+
        "\44\4\uffff\1\4\1\uffff\1\7\1\uffff\1\16\1\12\15\uffff\1\45\2\uffff"+
        "\1\6\3\uffff\1\14\6\uffff\1\37\1\40\1\46\5\uffff\1\13\1\uffff\1"+
        "\22\3\uffff\1\21\1\47\1\50\1\51\3\uffff\1\17\2\uffff\1\11\1\uffff"+
        "\1\20\1\10\1\15";
    static final String DFA18_specialS =
        "\177\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\44\1\43\2\uffff\1\43\22\uffff\1\44\1\23\1\34\1\33\1\40\2"+
            "\uffff\1\34\1\17\1\20\1\30\1\26\1\21\1\27\1\4\1\1\12\35\1\5"+
            "\1\uffff\1\24\1\22\1\25\1\uffff\1\41\32\42\1\2\1\uffff\1\3\1"+
            "\uffff\1\42\1\uffff\1\6\2\42\1\31\1\12\1\13\2\42\1\10\3\42\1"+
            "\32\1\37\1\7\1\16\1\42\1\15\1\11\1\36\2\42\1\14\3\42\u1fad\uffff"+
            "\2\43",
            "",
            "",
            "",
            "\1\45",
            "\1\46",
            "\1\50",
            "\1\51",
            "\1\53\7\uffff\1\52",
            "\1\54",
            "\1\55\1\uffff\1\56",
            "\1\61\15\uffff\1\57\5\uffff\1\60",
            "\1\62",
            "\1\63",
            "\1\64",
            "",
            "",
            "",
            "",
            "",
            "\1\65",
            "\1\67",
            "",
            "\2\42\1\uffff\12\35\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\72",
            "\1\73",
            "",
            "",
            "\1\42\1\75\1\uffff\12\35\7\uffff\32\42\4\uffff\1\42\1\uffff"+
            "\13\42\1\76\16\42",
            "\1\77",
            "\1\100",
            "",
            "",
            "",
            "",
            "",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "\1\102",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\2\42"+
            "\1\104\27\42",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "",
            "",
            "",
            "",
            "",
            "\1\120",
            "\1\121",
            "",
            "\1\122\2\uffff\12\123",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\125",
            "\1\126",
            "",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\130",
            "",
            "",
            "\1\131",
            "\1\132",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\123",
            "\2\42\1\uffff\12\123\7\uffff\32\42\4\uffff\1\42\1\uffff\3\42"+
            "\1\145\26\42",
            "",
            "\1\146",
            "\1\147",
            "",
            "\1\150",
            "\1\151",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\153",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\155",
            "\1\156",
            "\1\157",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\164",
            "\1\165",
            "",
            "\1\166",
            "",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\170",
            "",
            "",
            "",
            "",
            "\1\171",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\173",
            "",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\2\42\1\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | COMMENT | StringLiteral | G_INT | G_LONG | G_FLOAT | G_DOUBLE | BOOLEAN | NULL | VARIABLE | PROPERTY | IDENTIFIER | NEWLINE | WS );";
        }
    }
 

}
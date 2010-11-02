// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g 2010-11-02 18:33:58

            package com.tinkerpop.gremlin.compiler;

            import com.tinkerpop.gremlin.compiler.exceptions.SyntaxErrorException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GremlinLexer extends Lexer {
    public static final int WHILE=27;
    public static final int DecimalDigit=64;
    public static final int EOF=-1;
    public static final int FUNC_CALL=19;
    public static final int SingleStringCharacter=55;
    public static final int TOKEN=14;
    public static final int T__93=93;
    public static final int HISTORY=18;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int NAME=9;
    public static final int T__90=90;
    public static final int ARG=5;
    public static final int G_INT=45;
    public static final int SingleEscapeCharacter=61;
    public static final int INCLUDE=29;
    public static final int RETURN=20;
    public static final int DOUBLE=34;
    public static final int ARGS=6;
    public static final int VAR=4;
    public static final int GPATH=11;
    public static final int COMMENT=43;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int SCRIPT=30;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int NS=8;
    public static final int NULL=38;
    public static final int ELSE=22;
    public static final int BOOL=37;
    public static final int NATIVE=25;
    public static final int INT=31;
    public static final int DoubleStringCharacter=54;
    public static final int ARR=36;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int WS=56;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int PREDICATES=16;
    public static final int VARIABLE=51;
    public static final int T__70=70;
    public static final int G_DOUBLE=48;
    public static final int PROPERTY=50;
    public static final int FUNC=7;
    public static final int G_LONG=46;
    public static final int FOREACH=26;
    public static final int REPEAT=28;
    public static final int CharacterEscapeSequence=58;
    public static final int FUNC_NAME=10;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int EscapeSequence=57;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int HexEscapeSequence=59;
    public static final int STEP=13;
    public static final int FLOAT=33;
    public static final int HexDigit=65;
    public static final int PREDICATE=15;
    public static final int IF=21;
    public static final int STR=35;
    public static final int BOOLEAN=53;
    public static final int IDENTIFIER=52;
    public static final int EscapeCharacter=63;
    public static final int NATIVE_STEP=12;
    public static final int COLLECTION_CALL=42;
    public static final int G_FLOAT=47;
    public static final int PROPERTY_CALL=40;
    public static final int UnicodeEscapeSequence=60;
    public static final int RANGE=39;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int StringLiteral=49;
    public static final int NEWLINE=44;
    public static final int BLOCK=24;
    public static final int NonEscapeCharacter=62;
    public static final int LONG=32;
    public static final int COND=23;
    public static final int SELF=17;
    public static final int VARIABLE_CALL=41;

                public void reportError(RecognitionException e) {
                    throw new SyntaxErrorException("Syntax error at " + e.line + "-" + e.charPositionInLine + ": " + this.getErrorMessage(e, this.getTokenNames()));
                }
            

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

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:14:7: ( '/' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:14:9: '/'
            {
            match('/'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:15:7: ( '[' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:15:9: '['
            {
            match('['); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:16:7: ( ']' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:16:9: ']'
            {
            match(']'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:17:7: ( '..' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:17:9: '..'
            {
            match(".."); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:18:7: ( '(' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:18:9: '('
            {
            match('('); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:19:7: ( ')' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:19:9: ')'
            {
            match(')'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:20:7: ( '{' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:20:9: '{'
            {
            match('{'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:21:7: ( ';' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:21:9: ';'
            {
            match(';'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:22:7: ( '}' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:22:9: '}'
            {
            match('}'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:23:7: ( ':=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:23:9: ':='
            {
            match(":="); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:24:7: ( 'and' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:24:9: 'and'
            {
            match("and"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:25:7: ( 'or' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:25:9: 'or'
            {
            match("or"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:26:7: ( 'include' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:26:9: 'include'
            {
            match("include"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:27:7: ( 'script' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:27:9: 'script'
            {
            match("script"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:28:7: ( 'if' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:28:9: 'if'
            {
            match("if"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:29:7: ( 'else' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:29:9: 'else'
            {
            match("else"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:30:7: ( 'end' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:30:9: 'end'
            {
            match("end"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:31:7: ( 'foreach' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:31:9: 'foreach'
            {
            match("foreach"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:32:7: ( 'in' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:32:9: 'in'
            {
            match("in"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:33:7: ( 'while' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:33:9: 'while'
            {
            match("while"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:34:7: ( 'repeat' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:34:9: 'repeat'
            {
            match("repeat"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:35:7: ( 'step' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:35:9: 'step'
            {
            match("step"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:36:7: ( 'func' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:36:9: 'func'
            {
            match("func"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:37:7: ( ',' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:37:9: ','
            {
            match(','); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:38:7: ( 'return' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:38:9: 'return'
            {
            match("return"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:39:7: ( '=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:39:9: '='
            {
            match('='); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:40:7: ( '!=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:40:9: '!='
            {
            match("!="); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:41:7: ( '<' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:41:9: '<'
            {
            match('<'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:42:7: ( '<=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:42:9: '<='
            {
            match("<="); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:43:7: ( '>' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:43:9: '>'
            {
            match('>'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:44:7: ( '>=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:44:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:45:7: ( '+' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:45:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:46:7: ( '-' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:46:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:47:7: ( '*' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:47:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:48:8: ( 'div' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:48:10: 'div'
            {
            match("div"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:49:8: ( 'mod' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:49:10: 'mod'
            {
            match("mod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:50:8: ( ':' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:50:10: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:98:5: ( '#' ( . )* NEWLINE )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:98:7: '#' ( . )* NEWLINE
            {
            match('#'); 
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:98:11: ( . )*
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:98:11: .
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:251:2: ( '\"' ( DoubleStringCharacter )* '\"' | '\\'' ( SingleStringCharacter )* '\\'' )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:251:4: '\"' ( DoubleStringCharacter )* '\"'
                    {
                    match('\"'); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:251:8: ( DoubleStringCharacter )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='\u2027')||(LA2_0>='\u202A' && LA2_0<='\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:251:8: DoubleStringCharacter
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:252:4: '\\'' ( SingleStringCharacter )* '\\''
                    {
                    match('\''); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:252:9: ( SingleStringCharacter )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='\u2027')||(LA3_0>='\u202A' && LA3_0<='\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:252:9: SingleStringCharacter
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:257:5: ( ( '-' )? ( '0' .. '9' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:257:7: ( '-' )? ( '0' .. '9' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:257:7: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:257:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:257:12: ( '0' .. '9' )+
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:257:13: '0' .. '9'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:261:5: ( ( '-' )? ( '0' .. '9' )+ 'l' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:261:7: ( '-' )? ( '0' .. '9' )+ 'l'
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:261:7: ( '-' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='-') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:261:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:261:12: ( '0' .. '9' )+
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:261:13: '0' .. '9'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:265:5: ( G_INT '.' G_INT )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:265:7: G_INT '.' G_INT
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:269:5: ( G_FLOAT 'd' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:269:7: G_FLOAT 'd'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:273:5: ( 'true' | 'false' )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:273:7: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:274:7: 'false'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:278:5: ( 'null' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:278:7: 'null'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:282:5: ( '$' IDENTIFIER )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:282:9: '$' IDENTIFIER
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:286:2: ( '@' ( IDENTIFIER | StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:286:4: '@' ( IDENTIFIER | StringLiteral )
            {
            match('@'); 
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:286:8: ( IDENTIFIER | StringLiteral )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>='-' && LA10_0<='.')||(LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                alt10=1;
            }
            else if ( (LA10_0=='\"'||LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:286:10: IDENTIFIER
                    {
                    mIDENTIFIER(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:286:23: StringLiteral
                    {
                    mStringLiteral(); 

                    }
                    break;

            }


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:290:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:290:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:290:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='-' && LA11_0<='.')||(LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }


                switch (alt11) {
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:294:2: ( '\\n' | '\\r' | '\\u2028' | '\\u2029' )
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:301:5: ( ( ' ' | '\\t' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:301:7: ( ' ' | '\\t' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:301:7: ( ' ' | '\\t' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\t'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
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
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:305:2: (~ ( '\"' | '\\\\' | NEWLINE ) | '\\\\' EscapeSequence )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\u2027')||(LA13_0>='\u202A' && LA13_0<='\uFFFF')) ) {
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:305:4: ~ ( '\"' | '\\\\' | NEWLINE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:306:4: '\\\\' EscapeSequence
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:310:2: (~ ( '\\'' | '\\\\' | NEWLINE ) | '\\\\' EscapeSequence )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='&')||(LA14_0>='(' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\u2027')||(LA14_0>='\u202A' && LA14_0<='\uFFFF')) ) {
                alt14=1;
            }
            else if ( (LA14_0=='\\') ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:310:4: ~ ( '\\'' | '\\\\' | NEWLINE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:311:4: '\\\\' EscapeSequence
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:315:2: ( CharacterEscapeSequence | '0' | HexEscapeSequence | UnicodeEscapeSequence )
            int alt15=4;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='/')||(LA15_0>=':' && LA15_0<='t')||(LA15_0>='v' && LA15_0<='w')||(LA15_0>='y' && LA15_0<='\u2027')||(LA15_0>='\u202A' && LA15_0<='\uFFFF')) ) {
                alt15=1;
            }
            else if ( (LA15_0=='0') ) {
                alt15=2;
            }
            else if ( (LA15_0=='x') ) {
                alt15=3;
            }
            else if ( (LA15_0=='u') ) {
                alt15=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:315:4: CharacterEscapeSequence
                    {
                    mCharacterEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:316:4: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:317:4: HexEscapeSequence
                    {
                    mHexEscapeSequence(); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:318:4: UnicodeEscapeSequence
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:322:2: ( SingleEscapeCharacter | NonEscapeCharacter )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\"'||LA16_0=='\''||LA16_0=='\\'||LA16_0=='b'||LA16_0=='f'||LA16_0=='n'||LA16_0=='r'||LA16_0=='t'||LA16_0=='v') ) {
                alt16=1;
            }
            else if ( ((LA16_0>='\u0000' && LA16_0<='\t')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='!')||(LA16_0>='#' && LA16_0<='&')||(LA16_0>='(' && LA16_0<='/')||(LA16_0>=':' && LA16_0<='[')||(LA16_0>=']' && LA16_0<='a')||(LA16_0>='c' && LA16_0<='e')||(LA16_0>='g' && LA16_0<='m')||(LA16_0>='o' && LA16_0<='q')||LA16_0=='s'||LA16_0=='w'||(LA16_0>='y' && LA16_0<='\u2027')||(LA16_0>='\u202A' && LA16_0<='\uFFFF')) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:322:4: SingleEscapeCharacter
                    {
                    mSingleEscapeCharacter(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:323:4: NonEscapeCharacter
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:327:2: (~ ( EscapeCharacter | NEWLINE ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:327:4: ~ ( EscapeCharacter | NEWLINE )
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:331:2: ( '\\'' | '\"' | '\\\\' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' )
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:335:2: ( SingleEscapeCharacter | DecimalDigit | 'x' | 'u' )
            int alt17=4;
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
                alt17=1;
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
                alt17=2;
                }
                break;
            case 'x':
                {
                alt17=3;
                }
                break;
            case 'u':
                {
                alt17=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:335:4: SingleEscapeCharacter
                    {
                    mSingleEscapeCharacter(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:336:4: DecimalDigit
                    {
                    mDecimalDigit(); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:337:4: 'x'
                    {
                    match('x'); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:338:4: 'u'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:342:2: ( 'x' HexDigit HexDigit )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:342:4: 'x' HexDigit HexDigit
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:346:2: ( 'u' HexDigit HexDigit HexDigit HexDigit )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:346:4: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:350:2: ( DecimalDigit | ( 'a' .. 'f' ) | ( 'A' .. 'F' ) )
            int alt18=3;
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
                alt18=1;
                }
                break;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
                {
                alt18=2;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:350:4: DecimalDigit
                    {
                    mDecimalDigit(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:350:19: ( 'a' .. 'f' )
                    {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:350:19: ( 'a' .. 'f' )
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:350:20: 'a' .. 'f'
                    {
                    matchRange('a','f'); 

                    }


                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:350:32: ( 'A' .. 'F' )
                    {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:350:32: ( 'A' .. 'F' )
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:350:33: 'A' .. 'F'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:354:2: ( ( '0' .. '9' ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:354:4: ( '0' .. '9' )
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
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:8: ( T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | COMMENT | StringLiteral | G_INT | G_LONG | G_FLOAT | G_DOUBLE | BOOLEAN | NULL | VARIABLE | PROPERTY | IDENTIFIER | NEWLINE | WS )
        int alt19=50;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:10: T__66
                {
                mT__66(); 

                }
                break;
            case 2 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:16: T__67
                {
                mT__67(); 

                }
                break;
            case 3 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:22: T__68
                {
                mT__68(); 

                }
                break;
            case 4 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:28: T__69
                {
                mT__69(); 

                }
                break;
            case 5 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:34: T__70
                {
                mT__70(); 

                }
                break;
            case 6 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:40: T__71
                {
                mT__71(); 

                }
                break;
            case 7 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:46: T__72
                {
                mT__72(); 

                }
                break;
            case 8 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:52: T__73
                {
                mT__73(); 

                }
                break;
            case 9 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:58: T__74
                {
                mT__74(); 

                }
                break;
            case 10 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:64: T__75
                {
                mT__75(); 

                }
                break;
            case 11 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:70: T__76
                {
                mT__76(); 

                }
                break;
            case 12 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:76: T__77
                {
                mT__77(); 

                }
                break;
            case 13 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:82: T__78
                {
                mT__78(); 

                }
                break;
            case 14 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:88: T__79
                {
                mT__79(); 

                }
                break;
            case 15 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:94: T__80
                {
                mT__80(); 

                }
                break;
            case 16 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:100: T__81
                {
                mT__81(); 

                }
                break;
            case 17 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:106: T__82
                {
                mT__82(); 

                }
                break;
            case 18 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:112: T__83
                {
                mT__83(); 

                }
                break;
            case 19 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:118: T__84
                {
                mT__84(); 

                }
                break;
            case 20 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:124: T__85
                {
                mT__85(); 

                }
                break;
            case 21 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:130: T__86
                {
                mT__86(); 

                }
                break;
            case 22 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:136: T__87
                {
                mT__87(); 

                }
                break;
            case 23 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:142: T__88
                {
                mT__88(); 

                }
                break;
            case 24 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:148: T__89
                {
                mT__89(); 

                }
                break;
            case 25 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:154: T__90
                {
                mT__90(); 

                }
                break;
            case 26 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:160: T__91
                {
                mT__91(); 

                }
                break;
            case 27 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:166: T__92
                {
                mT__92(); 

                }
                break;
            case 28 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:172: T__93
                {
                mT__93(); 

                }
                break;
            case 29 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:178: T__94
                {
                mT__94(); 

                }
                break;
            case 30 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:184: T__95
                {
                mT__95(); 

                }
                break;
            case 31 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:190: T__96
                {
                mT__96(); 

                }
                break;
            case 32 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:196: T__97
                {
                mT__97(); 

                }
                break;
            case 33 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:202: T__98
                {
                mT__98(); 

                }
                break;
            case 34 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:208: T__99
                {
                mT__99(); 

                }
                break;
            case 35 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:214: T__100
                {
                mT__100(); 

                }
                break;
            case 36 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:221: T__101
                {
                mT__101(); 

                }
                break;
            case 37 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:228: T__102
                {
                mT__102(); 

                }
                break;
            case 38 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:235: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 39 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:243: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 40 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:257: G_INT
                {
                mG_INT(); 

                }
                break;
            case 41 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:263: G_LONG
                {
                mG_LONG(); 

                }
                break;
            case 42 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:270: G_FLOAT
                {
                mG_FLOAT(); 

                }
                break;
            case 43 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:278: G_DOUBLE
                {
                mG_DOUBLE(); 

                }
                break;
            case 44 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:287: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 45 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:295: NULL
                {
                mNULL(); 

                }
                break;
            case 46 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:300: VARIABLE
                {
                mVARIABLE(); 

                }
                break;
            case 47 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:309: PROPERTY
                {
                mPROPERTY(); 

                }
                break;
            case 48 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:318: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 49 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:329: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 50 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:337: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\4\uffff\1\44\5\uffff\1\51\10\44\3\uffff\1\70\1\72\1\uffff\1\73"+
        "\1\uffff\2\44\2\uffff\1\76\2\44\5\uffff\1\103\2\uffff\1\44\1\105"+
        "\1\107\1\110\11\44\5\uffff\2\44\1\uffff\1\44\1\127\2\44\1\uffff"+
        "\1\132\1\uffff\1\44\2\uffff\3\44\1\137\6\44\1\146\1\147\1\44\1\150"+
        "\1\uffff\2\44\1\uffff\2\44\1\156\1\157\1\uffff\1\44\1\161\4\44\3"+
        "\uffff\1\166\1\167\1\170\2\44\2\uffff\1\44\1\uffff\1\167\1\174\2"+
        "\44\3\uffff\1\44\1\u0080\1\44\1\uffff\1\u0082\1\u0083\1\u0084\1"+
        "\uffff\1\u0085\4\uffff";
    static final String DFA19_eofS =
        "\u0086\uffff";
    static final String DFA19_minS =
        "\1\11\3\uffff\1\56\5\uffff\1\75\1\156\1\162\1\146\1\143\1\154\1"+
        "\141\1\150\1\145\3\uffff\2\75\1\uffff\1\55\1\uffff\1\151\1\157\2"+
        "\uffff\1\55\1\162\1\165\5\uffff\1\55\2\uffff\1\144\3\55\1\162\1"+
        "\145\1\163\1\144\1\162\1\156\1\154\1\151\1\160\5\uffff\1\166\1\144"+
        "\1\uffff\2\55\1\165\1\154\1\uffff\1\55\1\uffff\1\154\2\uffff\1\151"+
        "\1\160\1\145\1\55\1\145\1\143\1\163\1\154\1\145\1\165\2\55\1\60"+
        "\1\55\1\uffff\1\145\1\154\1\uffff\1\165\1\160\2\55\1\uffff\1\141"+
        "\1\55\2\145\1\141\1\162\3\uffff\3\55\1\144\1\164\2\uffff\1\143\1"+
        "\uffff\2\55\1\164\1\156\3\uffff\1\145\1\55\1\150\1\uffff\3\55\1"+
        "\uffff\1\55\4\uffff";
    static final String DFA19_maxS =
        "\1\u2029\3\uffff\1\56\5\uffff\1\75\1\156\1\162\1\156\1\164\1\156"+
        "\1\165\1\150\1\145\3\uffff\2\75\1\uffff\1\172\1\uffff\1\151\1\157"+
        "\2\uffff\1\172\1\162\1\165\5\uffff\1\172\2\uffff\1\144\3\172\1\162"+
        "\1\145\1\163\1\144\1\162\1\156\1\154\1\151\1\164\5\uffff\1\166\1"+
        "\144\1\uffff\1\71\1\172\1\165\1\154\1\uffff\1\172\1\uffff\1\154"+
        "\2\uffff\1\151\1\160\1\145\1\172\1\145\1\143\1\163\1\154\1\145\1"+
        "\165\2\172\1\71\1\172\1\uffff\1\145\1\154\1\uffff\1\165\1\160\2"+
        "\172\1\uffff\1\141\1\172\2\145\1\141\1\162\3\uffff\3\172\1\144\1"+
        "\164\2\uffff\1\143\1\uffff\2\172\1\164\1\156\3\uffff\1\145\1\172"+
        "\1\150\1\uffff\3\172\1\uffff\1\172\4\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\6\1\7\1\10\1\11\11\uffff\1\30"+
        "\1\32\1\33\2\uffff\1\40\1\uffff\1\42\2\uffff\1\46\1\47\3\uffff\1"+
        "\56\1\57\1\60\1\61\1\62\1\uffff\1\12\1\45\15\uffff\1\35\1\34\1\37"+
        "\1\36\1\41\2\uffff\1\50\4\uffff\1\4\1\uffff\1\14\1\uffff\1\23\1"+
        "\17\16\uffff\1\51\2\uffff\1\13\4\uffff\1\21\6\uffff\1\43\1\44\1"+
        "\52\5\uffff\1\26\1\20\1\uffff\1\27\4\uffff\1\53\1\54\1\55\3\uffff"+
        "\1\24\3\uffff\1\16\1\uffff\1\25\1\31\1\15\1\22";
    static final String DFA19_specialS =
        "\u0086\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\46\1\45\2\uffff\1\45\22\uffff\1\46\1\25\1\36\1\35\1\42\2"+
            "\uffff\1\36\1\5\1\6\1\32\1\30\1\23\1\31\1\4\1\1\12\37\1\12\1"+
            "\10\1\26\1\24\1\27\1\uffff\1\43\32\44\1\2\1\uffff\1\3\1\uffff"+
            "\1\44\1\uffff\1\13\2\44\1\33\1\17\1\20\2\44\1\15\3\44\1\34\1"+
            "\41\1\14\2\44\1\22\1\16\1\40\2\44\1\21\3\44\1\7\1\uffff\1\11"+
            "\u1faa\uffff\2\45",
            "",
            "",
            "",
            "\1\47",
            "",
            "",
            "",
            "",
            "",
            "\1\50",
            "\1\52",
            "\1\53",
            "\1\55\7\uffff\1\54",
            "\1\56\20\uffff\1\57",
            "\1\60\1\uffff\1\61",
            "\1\64\15\uffff\1\62\5\uffff\1\63",
            "\1\65",
            "\1\66",
            "",
            "",
            "",
            "\1\67",
            "\1\71",
            "",
            "\2\44\1\uffff\12\37\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\74",
            "\1\75",
            "",
            "",
            "\1\44\1\77\1\uffff\12\37\7\uffff\32\44\4\uffff\1\44\1\uffff"+
            "\13\44\1\100\16\44",
            "\1\101",
            "\1\102",
            "",
            "",
            "",
            "",
            "",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "\1\104",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\2\44"+
            "\1\106\27\44",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121\3\uffff\1\122",
            "",
            "",
            "",
            "",
            "",
            "\1\123",
            "\1\124",
            "",
            "\1\125\2\uffff\12\126",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\130",
            "\1\131",
            "",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\133",
            "",
            "",
            "\1\134",
            "\1\135",
            "\1\136",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\126",
            "\2\44\1\uffff\12\126\7\uffff\32\44\4\uffff\1\44\1\uffff\3\44"+
            "\1\151\26\44",
            "",
            "\1\152",
            "\1\153",
            "",
            "\1\154",
            "\1\155",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\160",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "",
            "",
            "",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\171",
            "\1\172",
            "",
            "",
            "\1\173",
            "",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\175",
            "\1\176",
            "",
            "",
            "",
            "\1\177",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0081",
            "",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\2\44\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | COMMENT | StringLiteral | G_INT | G_LONG | G_FLOAT | G_DOUBLE | BOOLEAN | NULL | VARIABLE | PROPERTY | IDENTIFIER | NEWLINE | WS );";
        }
    }
 

}
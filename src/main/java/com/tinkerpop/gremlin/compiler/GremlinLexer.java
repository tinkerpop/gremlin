// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g 2010-10-05 14:26:29

            package com.tinkerpop.gremlin.compiler;

            import com.tinkerpop.gremlin.compiler.exceptions.SyntaxErrorException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GremlinLexer extends Lexer {
    public static final int WHILE=26;
    public static final int DecimalDigit=63;
    public static final int EOF=-1;
    public static final int FUNC_CALL=20;
    public static final int TOKEN=14;
    public static final int SingleStringCharacter=54;
    public static final int T__93=93;
    public static final int HISTORY=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int NAME=9;
    public static final int T__90=90;
    public static final int ARG=5;
    public static final int G_INT=44;
    public static final int SingleEscapeCharacter=60;
    public static final int INCLUDE=28;
    public static final int DOUBLE=33;
    public static final int ARGS=6;
    public static final int VAR=4;
    public static final int GPATH=11;
    public static final int COMMENT=42;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int SCRIPT=29;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int NS=8;
    public static final int NULL=37;
    public static final int ELSE=22;
    public static final int BOOL=36;
    public static final int INT=30;
    public static final int DoubleStringCharacter=53;
    public static final int ARR=35;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int T__71=71;
    public static final int WS=55;
    public static final int T__72=72;
    public static final int PREDICATES=16;
    public static final int VARIABLE=50;
    public static final int T__70=70;
    public static final int G_DOUBLE=47;
    public static final int PROPERTY=49;
    public static final int FUNC=7;
    public static final int G_LONG=45;
    public static final int FOREACH=25;
    public static final int REPEAT=27;
    public static final int CharacterEscapeSequence=57;
    public static final int FUNC_NAME=10;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int EscapeSequence=56;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__65=65;
    public static final int HexEscapeSequence=58;
    public static final int STEP=13;
    public static final int FLOAT=32;
    public static final int HexDigit=64;
    public static final int PREDICATE=15;
    public static final int IF=21;
    public static final int STR=34;
    public static final int BOOLEAN=52;
    public static final int IDENTIFIER=51;
    public static final int EscapeCharacter=62;
    public static final int NATIVE_STEP=12;
    public static final int COLLECTION_CALL=41;
    public static final int G_FLOAT=46;
    public static final int LOOPS=17;
    public static final int PROPERTY_CALL=39;
    public static final int UnicodeEscapeSequence=59;
    public static final int RANGE=38;
    public static final int T__100=100;
    public static final int StringLiteral=48;
    public static final int NEWLINE=43;
    public static final int BLOCK=24;
    public static final int NonEscapeCharacter=61;
    public static final int LONG=31;
    public static final int COND=23;
    public static final int SELF=18;
    public static final int VARIABLE_CALL=40;

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

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
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
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
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
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
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
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
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
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
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
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
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
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
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
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:21:7: ( '=>' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:21:9: '=>'
            {
            match("=>"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:22:7: ( 'while' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:22:9: 'while'
            {
            match("while"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:23:7: ( 'foreach' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:23:9: 'foreach'
            {
            match("foreach"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:24:7: ( 'in' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:24:9: 'in'
            {
            match("in"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:25:7: ( '{' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:25:9: '{'
            {
            match('{'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:26:7: ( '}' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:26:9: '}'
            {
            match('}'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:27:7: ( ':=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:27:9: ':='
            {
            match(":="); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:28:7: ( 'and' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:28:9: 'and'
            {
            match("and"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:29:7: ( 'or' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:29:9: 'or'
            {
            match("or"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:30:7: ( 'include' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:30:9: 'include'
            {
            match("include"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:31:7: ( 'script' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:31:9: 'script'
            {
            match("script"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:32:7: ( 'if' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:32:9: 'if'
            {
            match("if"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:33:7: ( 'else' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:33:9: 'else'
            {
            match("else"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:34:7: ( 'end' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:34:9: 'end'
            {
            match("end"); 


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
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
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
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
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
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:38:7: ( '=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:38:9: '='
            {
            match('='); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:39:7: ( '!=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:39:9: '!='
            {
            match("!="); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:40:7: ( '<' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:40:9: '<'
            {
            match('<'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:41:7: ( '<=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:41:9: '<='
            {
            match("<="); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:42:7: ( '>' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:42:9: '>'
            {
            match('>'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:43:7: ( '>=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:43:9: '>='
            {
            match(">="); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:44:7: ( '+' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:44:9: '+'
            {
            match('+'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:45:7: ( '-' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:45:9: '-'
            {
            match('-'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:46:7: ( '*' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:46:9: '*'
            {
            match('*'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:47:7: ( 'div' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:47:9: 'div'
            {
            match("div"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:48:7: ( 'mod' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:48:9: 'mod'
            {
            match("mod"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:49:8: ( ':' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:49:10: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:244:2: ( '\"' ( DoubleStringCharacter )* '\"' | '\\'' ( SingleStringCharacter )* '\\'' )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:244:4: '\"' ( DoubleStringCharacter )* '\"'
                    {
                    match('\"'); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:244:8: ( DoubleStringCharacter )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='\u2027')||(LA2_0>='\u202A' && LA2_0<='\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:244:8: DoubleStringCharacter
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:245:4: '\\'' ( SingleStringCharacter )* '\\''
                    {
                    match('\''); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:245:9: ( SingleStringCharacter )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='\u2027')||(LA3_0>='\u202A' && LA3_0<='\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:245:9: SingleStringCharacter
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:250:5: ( ( '-' )? ( '0' .. '9' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:250:7: ( '-' )? ( '0' .. '9' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:250:7: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:250:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:250:12: ( '0' .. '9' )+
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:250:13: '0' .. '9'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:254:5: ( ( '-' )? ( '0' .. '9' )+ 'l' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:254:7: ( '-' )? ( '0' .. '9' )+ 'l'
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:254:7: ( '-' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='-') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:254:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:254:12: ( '0' .. '9' )+
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:254:13: '0' .. '9'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:258:5: ( G_INT '.' G_INT )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:258:7: G_INT '.' G_INT
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:262:5: ( G_FLOAT 'd' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:262:7: G_FLOAT 'd'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:266:5: ( 'true' | 'false' )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:266:7: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:267:7: 'false'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:271:5: ( 'null' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:271:7: 'null'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:275:5: ( '$' IDENTIFIER )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:275:9: '$' IDENTIFIER
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:279:2: ( '@' ( IDENTIFIER | StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:279:4: '@' ( IDENTIFIER | StringLiteral )
            {
            match('@'); 
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:279:8: ( IDENTIFIER | StringLiteral )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:279:10: IDENTIFIER
                    {
                    mIDENTIFIER(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:279:23: StringLiteral
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:283:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:283:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:283:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:287:2: ( '\\n' | '\\r' | '\\u2028' | '\\u2029' )
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:294:5: ( ( ' ' | '\\t' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:294:7: ( ' ' | '\\t' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:294:7: ( ' ' | '\\t' )+
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:298:2: (~ ( '\"' | '\\\\' | NEWLINE ) | '\\\\' EscapeSequence )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:298:4: ~ ( '\"' | '\\\\' | NEWLINE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:299:4: '\\\\' EscapeSequence
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:303:2: (~ ( '\\'' | '\\\\' | NEWLINE ) | '\\\\' EscapeSequence )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:303:4: ~ ( '\\'' | '\\\\' | NEWLINE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:304:4: '\\\\' EscapeSequence
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:308:2: ( CharacterEscapeSequence | '0' | HexEscapeSequence | UnicodeEscapeSequence )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:308:4: CharacterEscapeSequence
                    {
                    mCharacterEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:309:4: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:310:4: HexEscapeSequence
                    {
                    mHexEscapeSequence(); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:311:4: UnicodeEscapeSequence
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:315:2: ( SingleEscapeCharacter | NonEscapeCharacter )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:315:4: SingleEscapeCharacter
                    {
                    mSingleEscapeCharacter(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:316:4: NonEscapeCharacter
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:320:2: (~ ( EscapeCharacter | NEWLINE ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:320:4: ~ ( EscapeCharacter | NEWLINE )
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:324:2: ( '\\'' | '\"' | '\\\\' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' )
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:328:2: ( SingleEscapeCharacter | DecimalDigit | 'x' | 'u' )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:328:4: SingleEscapeCharacter
                    {
                    mSingleEscapeCharacter(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:329:4: DecimalDigit
                    {
                    mDecimalDigit(); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:330:4: 'x'
                    {
                    match('x'); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:331:4: 'u'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:335:2: ( 'x' HexDigit HexDigit )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:335:4: 'x' HexDigit HexDigit
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:339:2: ( 'u' HexDigit HexDigit HexDigit HexDigit )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:339:4: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:343:2: ( DecimalDigit | ( 'a' .. 'f' ) | ( 'A' .. 'F' ) )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:343:4: DecimalDigit
                    {
                    mDecimalDigit(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:343:19: ( 'a' .. 'f' )
                    {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:343:19: ( 'a' .. 'f' )
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:343:20: 'a' .. 'f'
                    {
                    matchRange('a','f'); 

                    }


                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:343:32: ( 'A' .. 'F' )
                    {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:343:32: ( 'A' .. 'F' )
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:343:33: 'A' .. 'F'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:347:2: ( ( '0' .. '9' ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:347:4: ( '0' .. '9' )
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
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:8: ( T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | COMMENT | StringLiteral | G_INT | G_LONG | G_FLOAT | G_DOUBLE | BOOLEAN | NULL | VARIABLE | PROPERTY | IDENTIFIER | NEWLINE | WS )
        int alt19=49;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:10: T__65
                {
                mT__65(); 

                }
                break;
            case 2 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:16: T__66
                {
                mT__66(); 

                }
                break;
            case 3 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:22: T__67
                {
                mT__67(); 

                }
                break;
            case 4 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:28: T__68
                {
                mT__68(); 

                }
                break;
            case 5 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:34: T__69
                {
                mT__69(); 

                }
                break;
            case 6 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:40: T__70
                {
                mT__70(); 

                }
                break;
            case 7 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:46: T__71
                {
                mT__71(); 

                }
                break;
            case 8 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:52: T__72
                {
                mT__72(); 

                }
                break;
            case 9 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:58: T__73
                {
                mT__73(); 

                }
                break;
            case 10 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:64: T__74
                {
                mT__74(); 

                }
                break;
            case 11 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:70: T__75
                {
                mT__75(); 

                }
                break;
            case 12 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:76: T__76
                {
                mT__76(); 

                }
                break;
            case 13 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:82: T__77
                {
                mT__77(); 

                }
                break;
            case 14 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:88: T__78
                {
                mT__78(); 

                }
                break;
            case 15 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:94: T__79
                {
                mT__79(); 

                }
                break;
            case 16 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:100: T__80
                {
                mT__80(); 

                }
                break;
            case 17 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:106: T__81
                {
                mT__81(); 

                }
                break;
            case 18 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:112: T__82
                {
                mT__82(); 

                }
                break;
            case 19 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:118: T__83
                {
                mT__83(); 

                }
                break;
            case 20 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:124: T__84
                {
                mT__84(); 

                }
                break;
            case 21 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:130: T__85
                {
                mT__85(); 

                }
                break;
            case 22 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:136: T__86
                {
                mT__86(); 

                }
                break;
            case 23 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:142: T__87
                {
                mT__87(); 

                }
                break;
            case 24 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:148: T__88
                {
                mT__88(); 

                }
                break;
            case 25 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:154: T__89
                {
                mT__89(); 

                }
                break;
            case 26 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:160: T__90
                {
                mT__90(); 

                }
                break;
            case 27 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:166: T__91
                {
                mT__91(); 

                }
                break;
            case 28 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:172: T__92
                {
                mT__92(); 

                }
                break;
            case 29 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:178: T__93
                {
                mT__93(); 

                }
                break;
            case 30 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:184: T__94
                {
                mT__94(); 

                }
                break;
            case 31 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:190: T__95
                {
                mT__95(); 

                }
                break;
            case 32 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:196: T__96
                {
                mT__96(); 

                }
                break;
            case 33 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:202: T__97
                {
                mT__97(); 

                }
                break;
            case 34 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:208: T__98
                {
                mT__98(); 

                }
                break;
            case 35 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:214: T__99
                {
                mT__99(); 

                }
                break;
            case 36 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:220: T__100
                {
                mT__100(); 

                }
                break;
            case 37 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:227: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 38 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:235: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 39 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:249: G_INT
                {
                mG_INT(); 

                }
                break;
            case 40 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:255: G_LONG
                {
                mG_LONG(); 

                }
                break;
            case 41 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:262: G_FLOAT
                {
                mG_FLOAT(); 

                }
                break;
            case 42 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:270: G_DOUBLE
                {
                mG_DOUBLE(); 

                }
                break;
            case 43 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:279: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 44 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:287: NULL
                {
                mNULL(); 

                }
                break;
            case 45 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:292: VARIABLE
                {
                mVARIABLE(); 

                }
                break;
            case 46 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:301: PROPERTY
                {
                mPROPERTY(); 

                }
                break;
            case 47 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:310: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 48 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:321: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 49 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:329: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\4\uffff\1\43\2\uffff\1\43\1\51\3\43\2\uffff\1\61\4\43\2\uffff\1"+
        "\71\1\73\1\uffff\1\74\1\uffff\2\43\2\uffff\1\77\2\43\5\uffff\1\104"+
        "\1\43\2\uffff\4\43\1\113\1\114\2\uffff\1\43\1\116\4\43\5\uffff\2"+
        "\43\1\uffff\1\125\3\43\1\uffff\6\43\2\uffff\1\140\1\uffff\3\43\1"+
        "\144\1\145\1\146\1\uffff\1\43\1\147\5\43\1\156\2\43\1\uffff\1\43"+
        "\1\162\1\163\4\uffff\1\164\1\165\1\166\1\43\1\170\1\43\1\uffff\1"+
        "\165\2\43\5\uffff\1\174\1\uffff\2\43\1\177\1\uffff\1\u0080\1\u0081"+
        "\3\uffff";
    static final String DFA19_eofS =
        "\u0082\uffff";
    static final String DFA19_minS =
        "\1\11\3\uffff\1\56\2\uffff\1\145\1\76\1\150\1\141\1\146\2\uffff"+
        "\1\75\1\156\1\162\1\143\1\154\2\uffff\2\75\1\uffff\1\55\1\uffff"+
        "\1\151\1\157\2\uffff\1\55\1\162\1\165\5\uffff\1\55\1\160\2\uffff"+
        "\1\151\1\162\1\156\1\154\2\55\2\uffff\1\144\1\55\1\162\1\145\1\163"+
        "\1\144\5\uffff\1\166\1\144\1\uffff\2\55\1\165\1\154\1\uffff\1\145"+
        "\1\154\1\145\1\143\1\163\1\154\2\uffff\1\55\1\uffff\1\151\1\160"+
        "\1\145\3\55\1\uffff\1\60\1\55\1\145\1\154\1\141\1\145\1\141\1\55"+
        "\1\145\1\165\1\uffff\1\160\2\55\4\uffff\3\55\1\164\1\55\1\143\1"+
        "\uffff\1\55\1\144\1\164\5\uffff\1\55\1\uffff\1\150\1\145\1\55\1"+
        "\uffff\2\55\3\uffff";
    static final String DFA19_maxS =
        "\1\u2029\3\uffff\1\56\2\uffff\1\145\1\76\1\150\1\165\1\156\2\uffff"+
        "\1\75\1\156\1\162\1\164\1\156\2\uffff\2\75\1\uffff\1\172\1\uffff"+
        "\1\151\1\157\2\uffff\1\172\1\162\1\165\5\uffff\1\172\1\160\2\uffff"+
        "\1\151\1\162\1\156\1\154\2\172\2\uffff\1\144\1\172\1\162\1\145\1"+
        "\163\1\144\5\uffff\1\166\1\144\1\uffff\1\172\1\71\1\165\1\154\1"+
        "\uffff\1\145\1\154\1\145\1\143\1\163\1\154\2\uffff\1\172\1\uffff"+
        "\1\151\1\160\1\145\3\172\1\uffff\1\71\1\172\1\145\1\154\1\141\1"+
        "\145\1\141\1\172\1\145\1\165\1\uffff\1\160\2\172\4\uffff\3\172\1"+
        "\164\1\172\1\143\1\uffff\1\172\1\144\1\164\5\uffff\1\172\1\uffff"+
        "\1\150\1\145\1\172\1\uffff\2\172\3\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\6\5\uffff\1\14\1\15\5\uffff\1"+
        "\30\1\32\2\uffff\1\37\1\uffff\1\41\2\uffff\1\45\1\46\3\uffff\1\55"+
        "\1\56\1\57\1\60\1\61\2\uffff\1\10\1\31\6\uffff\1\16\1\44\6\uffff"+
        "\1\34\1\33\1\36\1\35\1\40\2\uffff\1\47\4\uffff\1\4\6\uffff\1\13"+
        "\1\23\1\uffff\1\20\6\uffff\1\50\12\uffff\1\17\3\uffff\1\25\1\42"+
        "\1\43\1\51\6\uffff\1\27\3\uffff\1\26\1\24\1\52\1\53\1\54\1\uffff"+
        "\1\11\3\uffff\1\7\2\uffff\1\22\1\12\1\21";
    static final String DFA19_specialS =
        "\u0082\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\45\1\44\2\uffff\1\44\22\uffff\1\45\1\24\1\35\1\34\1\41\2"+
            "\uffff\1\35\1\5\1\6\1\31\1\27\1\23\1\30\1\4\1\1\12\36\1\16\1"+
            "\uffff\1\25\1\10\1\26\1\uffff\1\42\32\43\1\2\1\uffff\1\3\1\uffff"+
            "\1\43\1\uffff\1\17\2\43\1\32\1\22\1\12\2\43\1\13\3\43\1\33\1"+
            "\40\1\20\2\43\1\7\1\21\1\37\2\43\1\11\3\43\1\14\1\uffff\1\15"+
            "\u1faa\uffff\2\44",
            "",
            "",
            "",
            "\1\46",
            "",
            "",
            "\1\47",
            "\1\50",
            "\1\52",
            "\1\55\15\uffff\1\53\5\uffff\1\54",
            "\1\57\7\uffff\1\56",
            "",
            "",
            "\1\60",
            "\1\62",
            "\1\63",
            "\1\64\20\uffff\1\65",
            "\1\66\1\uffff\1\67",
            "",
            "",
            "\1\70",
            "\1\72",
            "",
            "\2\43\1\uffff\12\36\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\75",
            "\1\76",
            "",
            "",
            "\1\43\1\101\1\uffff\12\36\7\uffff\32\43\4\uffff\1\43\1\uffff"+
            "\13\43\1\100\16\43",
            "\1\102",
            "\1\103",
            "",
            "",
            "",
            "",
            "",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\105",
            "",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\2\43"+
            "\1\112\27\43",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "\1\115",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "",
            "",
            "",
            "",
            "\1\123",
            "\1\124",
            "",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\126\2\uffff\12\127",
            "\1\130",
            "\1\131",
            "",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\12\127",
            "\2\43\1\uffff\12\127\7\uffff\32\43\4\uffff\1\43\1\uffff\3\43"+
            "\1\150\26\43",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\157",
            "\1\160",
            "",
            "\1\161",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "",
            "",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\167",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\171",
            "",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\172",
            "\1\173",
            "",
            "",
            "",
            "",
            "",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\175",
            "\1\176",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\2\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
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
            return "1:1: Tokens : ( T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | COMMENT | StringLiteral | G_INT | G_LONG | G_FLOAT | G_DOUBLE | BOOLEAN | NULL | VARIABLE | PROPERTY | IDENTIFIER | NEWLINE | WS );";
        }
    }
 

}
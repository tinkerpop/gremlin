// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g 2010-07-13 09:09:16
package com.tinkerpop.gremlin.compiler;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GremlinLexer extends Lexer {
    public static final int WHILE=24;
    public static final int DecimalDigit=60;
    public static final int EOF=-1;
    public static final int FUNC_CALL=19;
    public static final int TOKEN=14;
    public static final int SingleStringCharacter=51;
    public static final int HISTORY=18;
    public static final int T__91=91;
    public static final int NAME=9;
    public static final int T__90=90;
    public static final int ARG=5;
    public static final int PATH=11;
    public static final int G_INT=44;
    public static final int INCLUDE=26;
    public static final int SingleEscapeCharacter=57;
    public static final int ARGS=6;
    public static final int DOUBLE=30;
    public static final int VAR=4;
    public static final int GPATH=12;
    public static final int COMMENT=39;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int NS=8;
    public static final int NULL=34;
    public static final int BOOL=33;
    public static final int INT=27;
    public static final int DoubleStringCharacter=50;
    public static final int ARR=32;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int WS=52;
    public static final int T__71=71;
    public static final int PREDICATES=16;
    public static final int T__72=72;
    public static final int VARIABLE=40;
    public static final int T__70=70;
    public static final int G_DOUBLE=47;
    public static final int PROPERTY=49;
    public static final int FUNC=7;
    public static final int G_LONG=45;
    public static final int FOREACH=23;
    public static final int REPEAT=25;
    public static final int FUNC_NAME=10;
    public static final int CharacterEscapeSequence=54;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int EscapeSequence=53;
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
    public static final int T__63=63;
    public static final int HexEscapeSequence=55;
    public static final int STEP=13;
    public static final int FLOAT=29;
    public static final int HexDigit=61;
    public static final int PREDICATE=15;
    public static final int IF=20;
    public static final int STR=31;
    public static final int BOOLEAN=48;
    public static final int IDENTIFIER=43;
    public static final int EscapeCharacter=59;
    public static final int COLLECTION_CALL=38;
    public static final int G_FLOAT=46;
    public static final int PROPERTY_CALL=36;
    public static final int UnicodeEscapeSequence=56;
    public static final int RANGE=35;
    public static final int StringLiteral=42;
    public static final int NEWLINE=41;
    public static final int BLOCK=22;
    public static final int NonEscapeCharacter=58;
    public static final int COND=21;
    public static final int LONG=28;
    public static final int SELF=17;
    public static final int VARIABLE_CALL=37;

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

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:3:7: ( ':=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:3:9: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:4:7: ( '/' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:4:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:5:7: ( '[' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:5:9: '['
            {
            match('['); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:6:7: ( ']' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:6:9: ']'
            {
            match(']'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:7:7: ( '..' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:7:9: '..'
            {
            match(".."); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:8:7: ( 'and' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:8:9: 'and'
            {
            match("and"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:9:7: ( 'or' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:9:9: 'or'
            {
            match("or"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:10:7: ( 'include' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:10:9: 'include'
            {
            match("include"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:11:7: ( 'if' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:11:9: 'if'
            {
            match("if"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:12:7: ( 'end' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:12:9: 'end'
            {
            match("end"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:13:7: ( 'foreach' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:13:9: 'foreach'
            {
            match("foreach"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:14:7: ( 'in' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:14:9: 'in'
            {
            match("in"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:15:7: ( 'while' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:15:9: 'while'
            {
            match("while"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:16:7: ( 'repeat' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:16:9: 'repeat'
            {
            match("repeat"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:17:7: ( 'path' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:17:9: 'path'
            {
            match("path"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:18:7: ( 'func' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:18:9: 'func'
            {
            match("func"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:19:7: ( '(' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:19:9: '('
            {
            match('('); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:20:7: ( ')' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:20:9: ')'
            {
            match(')'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:21:7: ( ',' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:21:9: ','
            {
            match(','); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:22:7: ( '=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:22:9: '='
            {
            match('='); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:23:7: ( '!=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:23:9: '!='
            {
            match("!="); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:24:7: ( '<' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:24:9: '<'
            {
            match('<'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:25:7: ( '<=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:25:9: '<='
            {
            match("<="); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:26:7: ( '>' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:26:9: '>'
            {
            match('>'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:27:7: ( '>=' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:27:9: '>='
            {
            match(">="); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:28:7: ( '+' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:28:9: '+'
            {
            match('+'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:29:7: ( '-' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:29:9: '-'
            {
            match('-'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:30:7: ( '*' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:30:9: '*'
            {
            match('*'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:31:7: ( 'div' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:31:9: 'div'
            {
            match("div"); 


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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:32:7: ( ':' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:32:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:68:5: ( '#' ( . )* NEWLINE )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:68:7: '#' ( . )* NEWLINE
            {
            match('#'); 
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:68:11: ( . )*
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:68:11: .
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:2: ( '\"' ( DoubleStringCharacter )* '\"' | '\\'' ( SingleStringCharacter )* '\\'' )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:4: '\"' ( DoubleStringCharacter )* '\"'
                    {
                    match('\"'); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:8: ( DoubleStringCharacter )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='\u2027')||(LA2_0>='\u202A' && LA2_0<='\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:8: DoubleStringCharacter
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:200:4: '\\'' ( SingleStringCharacter )* '\\''
                    {
                    match('\''); 
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:200:9: ( SingleStringCharacter )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='\u2027')||(LA3_0>='\u202A' && LA3_0<='\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:200:9: SingleStringCharacter
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:205:5: ( ( '0' .. '9' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:205:7: ( '0' .. '9' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:205:7: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:205:8: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:209:5: ( ( '0' .. '9' )+ 'l' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:209:7: ( '0' .. '9' )+ 'l'
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:209:7: ( '0' .. '9' )+
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
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:209:8: '0' .. '9'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:213:5: ( G_INT '.' G_INT )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:213:7: G_INT '.' G_INT
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:217:5: ( G_FLOAT 'd' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:217:7: G_FLOAT 'd'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:221:5: ( 'true' | 'false' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='t') ) {
                alt7=1;
            }
            else if ( (LA7_0=='f') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:221:7: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:222:7: 'false'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:226:5: ( 'null' )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:226:7: 'null'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:240:5: ( '$' IDENTIFIER )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:240:9: '$' IDENTIFIER
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:248:2: ( '@' IDENTIFIER )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:248:4: '@' IDENTIFIER
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:252:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:252:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:252:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='-' && LA8_0<='.')||(LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
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
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:256:2: ( '\\n' | '\\r' | '\\u2028' | '\\u2029' )
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:263:5: ( ( ' ' | '\\t' )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:263:7: ( ' ' | '\\t' )+
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:263:7: ( ' ' | '\\t' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\t'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:267:2: (~ ( '\"' | '\\\\' | NEWLINE ) | '\\\\' EscapeSequence )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='!')||(LA10_0>='#' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\u2027')||(LA10_0>='\u202A' && LA10_0<='\uFFFF')) ) {
                alt10=1;
            }
            else if ( (LA10_0=='\\') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:267:4: ~ ( '\"' | '\\\\' | NEWLINE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:268:4: '\\\\' EscapeSequence
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:272:2: (~ ( '\\'' | '\\\\' | NEWLINE ) | '\\\\' EscapeSequence )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='&')||(LA11_0>='(' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\u2027')||(LA11_0>='\u202A' && LA11_0<='\uFFFF')) ) {
                alt11=1;
            }
            else if ( (LA11_0=='\\') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:272:4: ~ ( '\\'' | '\\\\' | NEWLINE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:273:4: '\\\\' EscapeSequence
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:277:2: ( CharacterEscapeSequence | '0' | HexEscapeSequence | UnicodeEscapeSequence )
            int alt12=4;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='/')||(LA12_0>=':' && LA12_0<='t')||(LA12_0>='v' && LA12_0<='w')||(LA12_0>='y' && LA12_0<='\u2027')||(LA12_0>='\u202A' && LA12_0<='\uFFFF')) ) {
                alt12=1;
            }
            else if ( (LA12_0=='0') ) {
                alt12=2;
            }
            else if ( (LA12_0=='x') ) {
                alt12=3;
            }
            else if ( (LA12_0=='u') ) {
                alt12=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:277:4: CharacterEscapeSequence
                    {
                    mCharacterEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:278:4: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:279:4: HexEscapeSequence
                    {
                    mHexEscapeSequence(); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:280:4: UnicodeEscapeSequence
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:284:2: ( SingleEscapeCharacter | NonEscapeCharacter )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\"'||LA13_0=='\''||LA13_0=='\\'||LA13_0=='b'||LA13_0=='f'||LA13_0=='n'||LA13_0=='r'||LA13_0=='t'||LA13_0=='v') ) {
                alt13=1;
            }
            else if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='/')||(LA13_0>=':' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='a')||(LA13_0>='c' && LA13_0<='e')||(LA13_0>='g' && LA13_0<='m')||(LA13_0>='o' && LA13_0<='q')||LA13_0=='s'||LA13_0=='w'||(LA13_0>='y' && LA13_0<='\u2027')||(LA13_0>='\u202A' && LA13_0<='\uFFFF')) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:284:4: SingleEscapeCharacter
                    {
                    mSingleEscapeCharacter(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:285:4: NonEscapeCharacter
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:289:2: (~ ( EscapeCharacter | NEWLINE ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:289:4: ~ ( EscapeCharacter | NEWLINE )
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:293:2: ( '\\'' | '\"' | '\\\\' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' )
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:297:2: ( SingleEscapeCharacter | DecimalDigit | 'x' | 'u' )
            int alt14=4;
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
                alt14=1;
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
                alt14=2;
                }
                break;
            case 'x':
                {
                alt14=3;
                }
                break;
            case 'u':
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:297:4: SingleEscapeCharacter
                    {
                    mSingleEscapeCharacter(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:298:4: DecimalDigit
                    {
                    mDecimalDigit(); 

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:299:4: 'x'
                    {
                    match('x'); 

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:300:4: 'u'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:304:2: ( 'x' HexDigit HexDigit )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:304:4: 'x' HexDigit HexDigit
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:308:2: ( 'u' HexDigit HexDigit HexDigit HexDigit )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:308:4: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:312:2: ( DecimalDigit | ( 'a' .. 'f' ) | ( 'A' .. 'F' ) )
            int alt15=3;
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
                alt15=1;
                }
                break;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
                {
                alt15=2;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:312:4: DecimalDigit
                    {
                    mDecimalDigit(); 

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:312:19: ( 'a' .. 'f' )
                    {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:312:19: ( 'a' .. 'f' )
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:312:20: 'a' .. 'f'
                    {
                    matchRange('a','f'); 

                    }


                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:312:32: ( 'A' .. 'F' )
                    {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:312:32: ( 'A' .. 'F' )
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:312:33: 'A' .. 'F'
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:316:2: ( ( '0' .. '9' ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:316:4: ( '0' .. '9' )
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
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:8: ( T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | COMMENT | StringLiteral | G_INT | G_LONG | G_FLOAT | G_DOUBLE | BOOLEAN | NULL | VARIABLE | PROPERTY | IDENTIFIER | NEWLINE | WS )
        int alt16=43;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:10: T__62
                {
                mT__62(); 

                }
                break;
            case 2 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:16: T__63
                {
                mT__63(); 

                }
                break;
            case 3 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:22: T__64
                {
                mT__64(); 

                }
                break;
            case 4 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:28: T__65
                {
                mT__65(); 

                }
                break;
            case 5 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:34: T__66
                {
                mT__66(); 

                }
                break;
            case 6 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:40: T__67
                {
                mT__67(); 

                }
                break;
            case 7 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:46: T__68
                {
                mT__68(); 

                }
                break;
            case 8 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:52: T__69
                {
                mT__69(); 

                }
                break;
            case 9 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:58: T__70
                {
                mT__70(); 

                }
                break;
            case 10 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:64: T__71
                {
                mT__71(); 

                }
                break;
            case 11 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:70: T__72
                {
                mT__72(); 

                }
                break;
            case 12 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:76: T__73
                {
                mT__73(); 

                }
                break;
            case 13 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:82: T__74
                {
                mT__74(); 

                }
                break;
            case 14 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:88: T__75
                {
                mT__75(); 

                }
                break;
            case 15 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:94: T__76
                {
                mT__76(); 

                }
                break;
            case 16 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:100: T__77
                {
                mT__77(); 

                }
                break;
            case 17 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:106: T__78
                {
                mT__78(); 

                }
                break;
            case 18 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:112: T__79
                {
                mT__79(); 

                }
                break;
            case 19 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:118: T__80
                {
                mT__80(); 

                }
                break;
            case 20 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:124: T__81
                {
                mT__81(); 

                }
                break;
            case 21 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:130: T__82
                {
                mT__82(); 

                }
                break;
            case 22 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:136: T__83
                {
                mT__83(); 

                }
                break;
            case 23 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:142: T__84
                {
                mT__84(); 

                }
                break;
            case 24 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:148: T__85
                {
                mT__85(); 

                }
                break;
            case 25 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:154: T__86
                {
                mT__86(); 

                }
                break;
            case 26 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:160: T__87
                {
                mT__87(); 

                }
                break;
            case 27 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:166: T__88
                {
                mT__88(); 

                }
                break;
            case 28 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:172: T__89
                {
                mT__89(); 

                }
                break;
            case 29 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:178: T__90
                {
                mT__90(); 

                }
                break;
            case 30 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:184: T__91
                {
                mT__91(); 

                }
                break;
            case 31 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:190: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 32 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:198: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 33 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:212: G_INT
                {
                mG_INT(); 

                }
                break;
            case 34 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:218: G_LONG
                {
                mG_LONG(); 

                }
                break;
            case 35 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:225: G_FLOAT
                {
                mG_FLOAT(); 

                }
                break;
            case 36 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:233: G_DOUBLE
                {
                mG_DOUBLE(); 

                }
                break;
            case 37 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:242: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 38 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:250: NULL
                {
                mNULL(); 

                }
                break;
            case 39 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:255: VARIABLE
                {
                mVARIABLE(); 

                }
                break;
            case 40 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:264: PROPERTY
                {
                mPROPERTY(); 

                }
                break;
            case 41 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:273: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 42 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:284: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 43 :
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:1:292: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\1\44\3\uffff\11\40\5\uffff\1\62\1\64\1\uffff\1\65\1\uffff"+
        "\1\40\2\uffff\1\70\2\40\7\uffff\1\74\1\40\1\76\1\100\1\101\7\40"+
        "\5\uffff\1\40\1\112\1\uffff\3\40\1\uffff\1\116\1\uffff\1\40\2\uffff"+
        "\1\120\6\40\1\127\1\uffff\1\130\2\40\1\uffff\1\40\1\uffff\1\40\1"+
        "\136\3\40\1\142\2\uffff\1\143\1\144\1\145\2\40\1\uffff\1\144\1\150"+
        "\1\40\4\uffff\2\40\1\uffff\1\154\1\155\1\156\3\uffff";
    static final String DFA16_eofS =
        "\157\uffff";
    static final String DFA16_minS =
        "\1\11\1\75\3\uffff\1\56\1\156\1\162\1\146\1\156\1\141\1\150\1\145"+
        "\1\141\5\uffff\2\75\1\uffff\1\55\1\uffff\1\151\2\uffff\1\55\1\162"+
        "\1\165\7\uffff\1\55\1\144\3\55\1\144\1\162\1\156\1\154\1\151\1\160"+
        "\1\164\5\uffff\1\166\1\55\1\uffff\1\60\1\165\1\154\1\uffff\1\55"+
        "\1\uffff\1\154\2\uffff\1\55\1\145\1\143\1\163\1\154\1\145\1\150"+
        "\1\55\1\uffff\1\55\1\145\1\154\1\uffff\1\165\1\uffff\1\141\1\55"+
        "\2\145\1\141\1\55\2\uffff\3\55\1\144\1\143\1\uffff\2\55\1\164\4"+
        "\uffff\1\145\1\150\1\uffff\3\55\3\uffff";
    static final String DFA16_maxS =
        "\1\u2029\1\75\3\uffff\1\56\1\156\1\162\2\156\1\165\1\150\1\145\1"+
        "\141\5\uffff\2\75\1\uffff\1\172\1\uffff\1\151\2\uffff\1\172\1\162"+
        "\1\165\7\uffff\1\172\1\144\3\172\1\144\1\162\1\156\1\154\1\151\1"+
        "\160\1\164\5\uffff\1\166\1\172\1\uffff\1\71\1\165\1\154\1\uffff"+
        "\1\172\1\uffff\1\154\2\uffff\1\172\1\145\1\143\1\163\1\154\1\145"+
        "\1\150\1\172\1\uffff\1\172\1\145\1\154\1\uffff\1\165\1\uffff\1\141"+
        "\1\172\2\145\1\141\1\172\2\uffff\3\172\1\144\1\143\1\uffff\2\172"+
        "\1\164\4\uffff\1\145\1\150\1\uffff\3\172\3\uffff";
    static final String DFA16_acceptS =
        "\2\uffff\1\2\1\3\1\4\11\uffff\1\21\1\22\1\23\1\24\1\25\2\uffff\1"+
        "\32\1\uffff\1\34\1\uffff\1\37\1\40\3\uffff\1\47\1\50\1\51\1\52\1"+
        "\53\1\1\1\36\14\uffff\1\27\1\26\1\31\1\30\1\33\2\uffff\1\41\3\uffff"+
        "\1\5\1\uffff\1\7\1\uffff\1\14\1\11\10\uffff\1\42\3\uffff\1\6\1\uffff"+
        "\1\12\6\uffff\1\35\1\43\5\uffff\1\20\3\uffff\1\17\1\44\1\45\1\46"+
        "\2\uffff\1\15\3\uffff\1\16\1\10\1\13";
    static final String DFA16_specialS =
        "\157\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\42\1\41\2\uffff\1\41\22\uffff\1\42\1\22\1\32\1\31\1\36\2"+
            "\uffff\1\32\1\16\1\17\1\27\1\25\1\20\1\26\1\5\1\2\12\33\1\1"+
            "\1\uffff\1\23\1\21\1\24\1\uffff\1\37\32\40\1\3\1\uffff\1\4\1"+
            "\uffff\1\40\1\uffff\1\6\2\40\1\30\1\11\1\12\2\40\1\10\4\40\1"+
            "\35\1\7\1\15\1\40\1\14\1\40\1\34\2\40\1\13\3\40\u1fad\uffff"+
            "\2\41",
            "\1\43",
            "",
            "",
            "",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\51\7\uffff\1\50",
            "\1\52",
            "\1\55\15\uffff\1\53\5\uffff\1\54",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "",
            "",
            "",
            "",
            "\1\61",
            "\1\63",
            "",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\1\66",
            "",
            "",
            "\1\40\1\71\1\uffff\12\33\7\uffff\32\40\4\uffff\1\40\1\uffff"+
            "\13\40\1\67\16\40",
            "\1\72",
            "\1\73",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\75",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\2\40"+
            "\1\77\27\40",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "",
            "",
            "",
            "",
            "",
            "\1\111",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\12\113",
            "\1\114",
            "\1\115",
            "",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\1\117",
            "",
            "",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\2\40\1\uffff\12\113\7\uffff\32\40\4\uffff\1\40\1\uffff\3\40"+
            "\1\131\26\40",
            "\1\132",
            "\1\133",
            "",
            "\1\134",
            "",
            "\1\135",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\137",
            "\1\140",
            "\1\141",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\146",
            "\1\147",
            "",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\151",
            "",
            "",
            "",
            "",
            "\1\152",
            "\1\153",
            "",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\2\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | COMMENT | StringLiteral | G_INT | G_LONG | G_FLOAT | G_DOUBLE | BOOLEAN | NULL | VARIABLE | PROPERTY | IDENTIFIER | NEWLINE | WS );";
        }
    }
 

}
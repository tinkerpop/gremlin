// $ANTLR 3.2 Sep 23, 2009 12:02:23 com/tinkerpop/gremlin/compiler/Gremlin.g 2010-07-05 13:02:37

package com.tinkerpop.gremlin.compiler;

import org.antlr.runtime.*;

public class GremlinLexer extends Lexer {
    public static final int T__68 = 68;
    public static final int T__69 = 69;
    public static final int T__66 = 66;
    public static final int T__67 = 67;
    public static final int T__64 = 64;
    public static final int T__65 = 65;
    public static final int T__62 = 62;
    public static final int T__63 = 63;
    public static final int WHILE = 24;
    public static final int HexEscapeSequence = 48;
    public static final int STEP = 13;
    public static final int T__61 = 61;
    public static final int DecimalDigit = 53;
    public static final int T__60 = 60;
    public static final int EOF = -1;
    public static final int HexDigit = 54;
    public static final int PREDICATE = 15;
    public static final int IF = 20;
    public static final int FUNC_CALL = 19;
    public static final int SingleStringCharacter = 44;
    public static final int TOKEN = 14;
    public static final int HISTORY = 18;
    public static final int T__55 = 55;
    public static final int STR = 28;
    public static final int T__56 = 56;
    public static final int T__57 = 57;
    public static final int T__58 = 58;
    public static final int NAME = 9;
    public static final int BOOLEAN = 41;
    public static final int ARG = 5;
    public static final int PATH = 11;
    public static final int IDENTIFIER = 39;
    public static final int T__59 = 59;
    public static final int SingleEscapeCharacter = 50;
    public static final int INCLUDE = 26;
    public static final int ARGS = 6;
    public static final int EscapeCharacter = 52;
    public static final int VAR = 4;
    public static final int GPATH = 12;
    public static final int COMMENT = 35;
    public static final int T__80 = 80;
    public static final int PROPERTY_CALL = 33;
    public static final int T__81 = 81;
    public static final int T__82 = 82;
    public static final int T__83 = 83;
    public static final int NS = 8;
    public static final int UnicodeEscapeSequence = 49;
    public static final int NULL = 31;
    public static final int BOOL = 30;
    public static final int NUMBER = 40;
    public static final int ARR = 29;
    public static final int DoubleStringCharacter = 43;
    public static final int ARR_IDX = 32;
    public static final int NUM = 27;
    public static final int StringLiteral = 38;
    public static final int T__71 = 71;
    public static final int WS = 45;
    public static final int T__72 = 72;
    public static final int PREDICATES = 16;
    public static final int NEWLINE = 36;
    public static final int VARIABLE = 37;
    public static final int T__70 = 70;
    public static final int PROPERTY = 42;
    public static final int FUNC = 7;
    public static final int BLOCK = 22;
    public static final int NonEscapeCharacter = 51;
    public static final int FOREACH = 23;
    public static final int REPEAT = 25;
    public static final int FUNC_NAME = 10;
    public static final int CharacterEscapeSequence = 47;
    public static final int T__76 = 76;
    public static final int T__75 = 75;
    public static final int COND = 21;
    public static final int T__74 = 74;
    public static final int SELF = 17;
    public static final int T__73 = 73;
    public static final int EscapeSequence = 46;
    public static final int T__79 = 79;
    public static final int T__78 = 78;
    public static final int VARIABLE_CALL = 34;
    public static final int T__77 = 77;

    // delegates
    // delegators

    public GremlinLexer() {
        ;
    }

    public GremlinLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }

    public GremlinLexer(CharStream input, RecognizerSharedState state) {
        super(input, state);

    }

    public String getGrammarFileName() {
        return "com/tinkerpop/gremlin/compiler/Gremlin.g";
    }

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:3:7: ( '/' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:3:9: '/'
            {
                match('/');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:4:7: ( '[' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:4:9: '['
            {
                match('[');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:5:7: ( ']' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:5:9: ']'
            {
                match(']');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:6:7: ( ':=' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:6:9: ':='
            {
                match(":=");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:7:7: ( 'and' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:7:9: 'and'
            {
                match("and");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:8:7: ( 'or' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:8:9: 'or'
            {
                match("or");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:9:7: ( 'include' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:9:9: 'include'
            {
                match("include");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:10:7: ( 'if' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:10:9: 'if'
            {
                match("if");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:11:7: ( 'end' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:11:9: 'end'
            {
                match("end");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:12:7: ( 'foreach' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:12:9: 'foreach'
            {
                match("foreach");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:13:7: ( 'in' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:13:9: 'in'
            {
                match("in");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:14:7: ( 'while' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:14:9: 'while'
            {
                match("while");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:15:7: ( 'repeat' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:15:9: 'repeat'
            {
                match("repeat");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:16:7: ( 'path' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:16:9: 'path'
            {
                match("path");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:17:7: ( 'func' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:17:9: 'func'
            {
                match("func");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:18:7: ( '(' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:18:9: '('
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:19:7: ( ')' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:19:9: ')'
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:20:7: ( ',' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:20:9: ','
            {
                match(',');

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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:21:7: ( '=' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:21:9: '='
            {
                match('=');

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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:22:7: ( '!=' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:22:9: '!='
            {
                match("!=");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:23:7: ( '<' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:23:9: '<'
            {
                match('<');

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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:24:7: ( '<=' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:24:9: '<='
            {
                match("<=");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:25:7: ( '>' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:25:9: '>'
            {
                match('>');

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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:26:7: ( '>=' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:26:9: '>='
            {
                match(">=");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:27:7: ( '+' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:27:9: '+'
            {
                match('+');

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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:28:7: ( '-' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:28:9: '-'
            {
                match('-');

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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:29:7: ( '*' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:29:9: '*'
            {
                match('*');

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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:30:7: ( 'div' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:30:9: 'div'
            {
                match("div");


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:31:7: ( ':' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:31:9: ':'
            {
                match(':');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:61:5: ( '#' ( . )* NEWLINE )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:61:7: '#' ( . )* NEWLINE
            {
                match('#');
                // com/tinkerpop/gremlin/compiler/Gremlin.g:61:11: ( . )*
                loop1:
                do {
                    int alt1 = 2;
                    int LA1_0 = input.LA(1);

                    if ((LA1_0 == '\n' || LA1_0 == '\r' || (LA1_0 >= '\u2028' && LA1_0 <= '\u2029'))) {
                        alt1 = 2;
                    } else if (((LA1_0 >= '\u0000' && LA1_0 <= '\t') || (LA1_0 >= '\u000B' && LA1_0 <= '\f') || (LA1_0 >= '\u000E' && LA1_0 <= '\u2027') || (LA1_0 >= '\u202A' && LA1_0 <= '\uFFFF'))) {
                        alt1 = 1;
                    }


                    switch (alt1) {
                        case 1:
                            // com/tinkerpop/gremlin/compiler/Gremlin.g:61:11: .
                        {
                            matchAny();

                        }
                        break;

                        default:
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:174:2: ( '\"' ( DoubleStringCharacter )* '\"' | '\\'' ( SingleStringCharacter )* '\\'' )
            int alt4 = 2;
            int LA4_0 = input.LA(1);

            if ((LA4_0 == '\"')) {
                alt4 = 1;
            } else if ((LA4_0 == '\'')) {
                alt4 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:174:4: '\"' ( DoubleStringCharacter )* '\"'
                {
                    match('\"');
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:174:8: ( DoubleStringCharacter )*
                    loop2:
                    do {
                        int alt2 = 2;
                        int LA2_0 = input.LA(1);

                        if (((LA2_0 >= '\u0000' && LA2_0 <= '\t') || (LA2_0 >= '\u000B' && LA2_0 <= '\f') || (LA2_0 >= '\u000E' && LA2_0 <= '!') || (LA2_0 >= '#' && LA2_0 <= '\u2027') || (LA2_0 >= '\u202A' && LA2_0 <= '\uFFFF'))) {
                            alt2 = 1;
                        }


                        switch (alt2) {
                            case 1:
                                // com/tinkerpop/gremlin/compiler/Gremlin.g:174:8: DoubleStringCharacter
                            {
                                mDoubleStringCharacter();

                            }
                            break;

                            default:
                                break loop2;
                        }
                    } while (true);

                    match('\"');

                }
                break;
                case 2:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:175:4: '\\'' ( SingleStringCharacter )* '\\''
                {
                    match('\'');
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:175:9: ( SingleStringCharacter )*
                    loop3:
                    do {
                        int alt3 = 2;
                        int LA3_0 = input.LA(1);

                        if (((LA3_0 >= '\u0000' && LA3_0 <= '\t') || (LA3_0 >= '\u000B' && LA3_0 <= '\f') || (LA3_0 >= '\u000E' && LA3_0 <= '&') || (LA3_0 >= '(' && LA3_0 <= '\u2027') || (LA3_0 >= '\u202A' && LA3_0 <= '\uFFFF'))) {
                            alt3 = 1;
                        }


                        switch (alt3) {
                            case 1:
                                // com/tinkerpop/gremlin/compiler/Gremlin.g:175:9: SingleStringCharacter
                            {
                                mSingleStringCharacter();

                            }
                            break;

                            default:
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

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:179:5: ( 'true' | 'false' )
            int alt5 = 2;
            int LA5_0 = input.LA(1);

            if ((LA5_0 == 't')) {
                alt5 = 1;
            } else if ((LA5_0 == 'f')) {
                alt5 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:179:7: 'true'
                {
                    match("true");


                }
                break;
                case 2:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:180:7: 'false'
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:184:5: ( 'null' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:184:7: 'null'
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

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:193:5: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:193:8: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:193:8: ( '0' .. '9' )+
                int cnt6 = 0;
                loop6:
                do {
                    int alt6 = 2;
                    int LA6_0 = input.LA(1);

                    if (((LA6_0 >= '0' && LA6_0 <= '9'))) {
                        alt6 = 1;
                    }


                    switch (alt6) {
                        case 1:
                            // com/tinkerpop/gremlin/compiler/Gremlin.g:193:9: '0' .. '9'
                        {
                            matchRange('0', '9');

                        }
                        break;

                        default:
                            if (cnt6 >= 1) break loop6;
                            EarlyExitException eee =
                                    new EarlyExitException(6, input);
                            throw eee;
                    }
                    cnt6++;
                } while (true);

                // com/tinkerpop/gremlin/compiler/Gremlin.g:193:20: ( '.' ( '0' .. '9' )+ )?
                int alt8 = 2;
                int LA8_0 = input.LA(1);

                if ((LA8_0 == '.')) {
                    alt8 = 1;
                }
                switch (alt8) {
                    case 1:
                        // com/tinkerpop/gremlin/compiler/Gremlin.g:193:21: '.' ( '0' .. '9' )+
                    {
                        match('.');
                        // com/tinkerpop/gremlin/compiler/Gremlin.g:193:25: ( '0' .. '9' )+
                        int cnt7 = 0;
                        loop7:
                        do {
                            int alt7 = 2;
                            int LA7_0 = input.LA(1);

                            if (((LA7_0 >= '0' && LA7_0 <= '9'))) {
                                alt7 = 1;
                            }


                            switch (alt7) {
                                case 1:
                                    // com/tinkerpop/gremlin/compiler/Gremlin.g:193:26: '0' .. '9'
                                {
                                    matchRange('0', '9');

                                }
                                break;

                                default:
                                    if (cnt7 >= 1) break loop7;
                                    EarlyExitException eee =
                                            new EarlyExitException(7, input);
                                    throw eee;
                            }
                            cnt7++;
                        } while (true);


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
    // $ANTLR end "NUMBER"

    // $ANTLR start "VARIABLE"
    public final void mVARIABLE() throws RecognitionException {
        try {
            int _type = VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/tinkerpop/gremlin/compiler/Gremlin.g:197:2: ( '$' IDENTIFIER )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:197:4: '$' IDENTIFIER
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:201:2: ( '@' IDENTIFIER )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:201:4: '@' IDENTIFIER
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:205:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+ )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:205:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:205:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '.' | '0' .. '9' )+
                int cnt9 = 0;
                loop9:
                do {
                    int alt9 = 2;
                    int LA9_0 = input.LA(1);

                    if (((LA9_0 >= '-' && LA9_0 <= '.') || (LA9_0 >= '0' && LA9_0 <= '9') || (LA9_0 >= 'A' && LA9_0 <= 'Z') || LA9_0 == '_' || (LA9_0 >= 'a' && LA9_0 <= 'z'))) {
                        alt9 = 1;
                    }


                    switch (alt9) {
                        case 1:
                            // com/tinkerpop/gremlin/compiler/Gremlin.g:
                        {
                            if ((input.LA(1) >= '-' && input.LA(1) <= '.') || (input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                                input.consume();

                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }


                        }
                        break;

                        default:
                            if (cnt9 >= 1) break loop9;
                            EarlyExitException eee =
                                    new EarlyExitException(9, input);
                            throw eee;
                    }
                    cnt9++;
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:209:2: ( '\\n' | '\\r' | '\\u2028' | '\\u2029' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:
            {
                if (input.LA(1) == '\n' || input.LA(1) == '\r' || (input.LA(1) >= '\u2028' && input.LA(1) <= '\u2029')) {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }


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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:216:5: ( ( ' ' | '\\t' )+ )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:216:7: ( ' ' | '\\t' )+
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:216:7: ( ' ' | '\\t' )+
                int cnt10 = 0;
                loop10:
                do {
                    int alt10 = 2;
                    int LA10_0 = input.LA(1);

                    if ((LA10_0 == '\t' || LA10_0 == ' ')) {
                        alt10 = 1;
                    }


                    switch (alt10) {
                        case 1:
                            // com/tinkerpop/gremlin/compiler/Gremlin.g:
                        {
                            if (input.LA(1) == '\t' || input.LA(1) == ' ') {
                                input.consume();

                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }


                        }
                        break;

                        default:
                            if (cnt10 >= 1) break loop10;
                            EarlyExitException eee =
                                    new EarlyExitException(10, input);
                            throw eee;
                    }
                    cnt10++;
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:220:2: (~ ( '\"' | '\\\\' | NEWLINE ) | '\\\\' EscapeSequence )
            int alt11 = 2;
            int LA11_0 = input.LA(1);

            if (((LA11_0 >= '\u0000' && LA11_0 <= '\t') || (LA11_0 >= '\u000B' && LA11_0 <= '\f') || (LA11_0 >= '\u000E' && LA11_0 <= '!') || (LA11_0 >= '#' && LA11_0 <= '[') || (LA11_0 >= ']' && LA11_0 <= '\u2027') || (LA11_0 >= '\u202A' && LA11_0 <= '\uFFFF'))) {
                alt11 = 1;
            } else if ((LA11_0 == '\\')) {
                alt11 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:220:4: ~ ( '\"' | '\\\\' | NEWLINE )
                {
                    if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f') || (input.LA(1) >= '\u000E' && input.LA(1) <= '!') || (input.LA(1) >= '#' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= '\u2027') || (input.LA(1) >= '\u202A' && input.LA(1) <= '\uFFFF')) {
                        input.consume();

                    } else {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }


                }
                break;
                case 2:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:221:4: '\\\\' EscapeSequence
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:225:2: (~ ( '\\'' | '\\\\' | NEWLINE ) | '\\\\' EscapeSequence )
            int alt12 = 2;
            int LA12_0 = input.LA(1);

            if (((LA12_0 >= '\u0000' && LA12_0 <= '\t') || (LA12_0 >= '\u000B' && LA12_0 <= '\f') || (LA12_0 >= '\u000E' && LA12_0 <= '&') || (LA12_0 >= '(' && LA12_0 <= '[') || (LA12_0 >= ']' && LA12_0 <= '\u2027') || (LA12_0 >= '\u202A' && LA12_0 <= '\uFFFF'))) {
                alt12 = 1;
            } else if ((LA12_0 == '\\')) {
                alt12 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:225:4: ~ ( '\\'' | '\\\\' | NEWLINE )
                {
                    if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f') || (input.LA(1) >= '\u000E' && input.LA(1) <= '&') || (input.LA(1) >= '(' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= '\u2027') || (input.LA(1) >= '\u202A' && input.LA(1) <= '\uFFFF')) {
                        input.consume();

                    } else {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }


                }
                break;
                case 2:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:226:4: '\\\\' EscapeSequence
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:230:2: ( CharacterEscapeSequence | '0' | HexEscapeSequence | UnicodeEscapeSequence )
            int alt13 = 4;
            int LA13_0 = input.LA(1);

            if (((LA13_0 >= '\u0000' && LA13_0 <= '\t') || (LA13_0 >= '\u000B' && LA13_0 <= '\f') || (LA13_0 >= '\u000E' && LA13_0 <= '/') || (LA13_0 >= ':' && LA13_0 <= 't') || (LA13_0 >= 'v' && LA13_0 <= 'w') || (LA13_0 >= 'y' && LA13_0 <= '\u2027') || (LA13_0 >= '\u202A' && LA13_0 <= '\uFFFF'))) {
                alt13 = 1;
            } else if ((LA13_0 == '0')) {
                alt13 = 2;
            } else if ((LA13_0 == 'x')) {
                alt13 = 3;
            } else if ((LA13_0 == 'u')) {
                alt13 = 4;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:230:4: CharacterEscapeSequence
                {
                    mCharacterEscapeSequence();

                }
                break;
                case 2:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:231:4: '0'
                {
                    match('0');

                }
                break;
                case 3:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:232:4: HexEscapeSequence
                {
                    mHexEscapeSequence();

                }
                break;
                case 4:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:233:4: UnicodeEscapeSequence
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:237:2: ( SingleEscapeCharacter | NonEscapeCharacter )
            int alt14 = 2;
            int LA14_0 = input.LA(1);

            if ((LA14_0 == '\"' || LA14_0 == '\'' || LA14_0 == '\\' || LA14_0 == 'b' || LA14_0 == 'f' || LA14_0 == 'n' || LA14_0 == 'r' || LA14_0 == 't' || LA14_0 == 'v')) {
                alt14 = 1;
            } else if (((LA14_0 >= '\u0000' && LA14_0 <= '\t') || (LA14_0 >= '\u000B' && LA14_0 <= '\f') || (LA14_0 >= '\u000E' && LA14_0 <= '!') || (LA14_0 >= '#' && LA14_0 <= '&') || (LA14_0 >= '(' && LA14_0 <= '/') || (LA14_0 >= ':' && LA14_0 <= '[') || (LA14_0 >= ']' && LA14_0 <= 'a') || (LA14_0 >= 'c' && LA14_0 <= 'e') || (LA14_0 >= 'g' && LA14_0 <= 'm') || (LA14_0 >= 'o' && LA14_0 <= 'q') || LA14_0 == 's' || LA14_0 == 'w' || (LA14_0 >= 'y' && LA14_0 <= '\u2027') || (LA14_0 >= '\u202A' && LA14_0 <= '\uFFFF'))) {
                alt14 = 2;
            } else {
                NoViableAltException nvae =
                        new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:237:4: SingleEscapeCharacter
                {
                    mSingleEscapeCharacter();

                }
                break;
                case 2:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:238:4: NonEscapeCharacter
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:242:2: (~ ( EscapeCharacter | NEWLINE ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:242:4: ~ ( EscapeCharacter | NEWLINE )
            {
                if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f') || (input.LA(1) >= '\u000E' && input.LA(1) <= '!') || (input.LA(1) >= '#' && input.LA(1) <= '&') || (input.LA(1) >= '(' && input.LA(1) <= '/') || (input.LA(1) >= ':' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= 'a') || (input.LA(1) >= 'c' && input.LA(1) <= 'e') || (input.LA(1) >= 'g' && input.LA(1) <= 'm') || (input.LA(1) >= 'o' && input.LA(1) <= 'q') || input.LA(1) == 's' || input.LA(1) == 'w' || (input.LA(1) >= 'y' && input.LA(1) <= '\u2027') || (input.LA(1) >= '\u202A' && input.LA(1) <= '\uFFFF')) {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }


            }

        }
        finally {
        }
    }
    // $ANTLR end "NonEscapeCharacter"

    // $ANTLR start "SingleEscapeCharacter"
    public final void mSingleEscapeCharacter() throws RecognitionException {
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:246:2: ( '\\'' | '\"' | '\\\\' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:
            {
                if (input.LA(1) == '\"' || input.LA(1) == '\'' || input.LA(1) == '\\' || input.LA(1) == 'b' || input.LA(1) == 'f' || input.LA(1) == 'n' || input.LA(1) == 'r' || input.LA(1) == 't' || input.LA(1) == 'v') {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }


            }

        }
        finally {
        }
    }
    // $ANTLR end "SingleEscapeCharacter"

    // $ANTLR start "EscapeCharacter"
    public final void mEscapeCharacter() throws RecognitionException {
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:250:2: ( SingleEscapeCharacter | DecimalDigit | 'x' | 'u' )
            int alt15 = 4;
            switch (input.LA(1)) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                case 'v': {
                    alt15 = 1;
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
                case '9': {
                    alt15 = 2;
                }
                break;
                case 'x': {
                    alt15 = 3;
                }
                break;
                case 'u': {
                    alt15 = 4;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                    throw nvae;
            }

            switch (alt15) {
                case 1:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:250:4: SingleEscapeCharacter
                {
                    mSingleEscapeCharacter();

                }
                break;
                case 2:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:251:4: DecimalDigit
                {
                    mDecimalDigit();

                }
                break;
                case 3:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:252:4: 'x'
                {
                    match('x');

                }
                break;
                case 4:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:253:4: 'u'
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:257:2: ( 'x' HexDigit HexDigit )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:257:4: 'x' HexDigit HexDigit
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:261:2: ( 'u' HexDigit HexDigit HexDigit HexDigit )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:261:4: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:265:2: ( DecimalDigit | ( 'a' .. 'f' ) | ( 'A' .. 'F' ) )
            int alt16 = 3;
            switch (input.LA(1)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': {
                    alt16 = 1;
                }
                break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f': {
                    alt16 = 2;
                }
                break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F': {
                    alt16 = 3;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                    throw nvae;
            }

            switch (alt16) {
                case 1:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:265:4: DecimalDigit
                {
                    mDecimalDigit();

                }
                break;
                case 2:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:265:19: ( 'a' .. 'f' )
                {
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:265:19: ( 'a' .. 'f' )
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:265:20: 'a' .. 'f'
                    {
                        matchRange('a', 'f');

                    }


                }
                break;
                case 3:
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:265:32: ( 'A' .. 'F' )
                {
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:265:32: ( 'A' .. 'F' )
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:265:33: 'A' .. 'F'
                    {
                        matchRange('A', 'F');

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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:269:2: ( ( '0' .. '9' ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:269:4: ( '0' .. '9' )
            {
                if ((input.LA(1) >= '0' && input.LA(1) <= '9')) {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }


            }

        }
        finally {
        }
    }
    // $ANTLR end "DecimalDigit"

    public void mTokens() throws RecognitionException {
        // com/tinkerpop/gremlin/compiler/Gremlin.g:1:8: ( T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | COMMENT | StringLiteral | BOOLEAN | NULL | NUMBER | VARIABLE | PROPERTY | IDENTIFIER | NEWLINE | WS )
        int alt17 = 39;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:10: T__55
            {
                mT__55();

            }
            break;
            case 2:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:16: T__56
            {
                mT__56();

            }
            break;
            case 3:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:22: T__57
            {
                mT__57();

            }
            break;
            case 4:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:28: T__58
            {
                mT__58();

            }
            break;
            case 5:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:34: T__59
            {
                mT__59();

            }
            break;
            case 6:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:40: T__60
            {
                mT__60();

            }
            break;
            case 7:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:46: T__61
            {
                mT__61();

            }
            break;
            case 8:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:52: T__62
            {
                mT__62();

            }
            break;
            case 9:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:58: T__63
            {
                mT__63();

            }
            break;
            case 10:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:64: T__64
            {
                mT__64();

            }
            break;
            case 11:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:70: T__65
            {
                mT__65();

            }
            break;
            case 12:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:76: T__66
            {
                mT__66();

            }
            break;
            case 13:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:82: T__67
            {
                mT__67();

            }
            break;
            case 14:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:88: T__68
            {
                mT__68();

            }
            break;
            case 15:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:94: T__69
            {
                mT__69();

            }
            break;
            case 16:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:100: T__70
            {
                mT__70();

            }
            break;
            case 17:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:106: T__71
            {
                mT__71();

            }
            break;
            case 18:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:112: T__72
            {
                mT__72();

            }
            break;
            case 19:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:118: T__73
            {
                mT__73();

            }
            break;
            case 20:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:124: T__74
            {
                mT__74();

            }
            break;
            case 21:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:130: T__75
            {
                mT__75();

            }
            break;
            case 22:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:136: T__76
            {
                mT__76();

            }
            break;
            case 23:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:142: T__77
            {
                mT__77();

            }
            break;
            case 24:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:148: T__78
            {
                mT__78();

            }
            break;
            case 25:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:154: T__79
            {
                mT__79();

            }
            break;
            case 26:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:160: T__80
            {
                mT__80();

            }
            break;
            case 27:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:166: T__81
            {
                mT__81();

            }
            break;
            case 28:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:172: T__82
            {
                mT__82();

            }
            break;
            case 29:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:178: T__83
            {
                mT__83();

            }
            break;
            case 30:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:184: COMMENT
            {
                mCOMMENT();

            }
            break;
            case 31:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:192: StringLiteral
            {
                mStringLiteral();

            }
            break;
            case 32:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:206: BOOLEAN
            {
                mBOOLEAN();

            }
            break;
            case 33:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:214: NULL
            {
                mNULL();

            }
            break;
            case 34:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:219: NUMBER
            {
                mNUMBER();

            }
            break;
            case 35:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:226: VARIABLE
            {
                mVARIABLE();

            }
            break;
            case 36:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:235: PROPERTY
            {
                mPROPERTY();

            }
            break;
            case 37:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:244: IDENTIFIER
            {
                mIDENTIFIER();

            }
            break;
            case 38:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:255: NEWLINE
            {
                mNEWLINE();

            }
            break;
            case 39:
                // com/tinkerpop/gremlin/compiler/Gremlin.g:1:263: WS
            {
                mWS();

            }
            break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
            "\4\uffff\1\43\10\37\5\uffff\1\60\1\62\1\uffff\1\63\1\uffff\1\37" +
                    "\2\uffff\2\37\1\67\7\uffff\1\37\1\72\1\74\1\75\7\37\5\uffff\3\37" +
                    "\1\uffff\1\37\1\111\1\uffff\1\37\2\uffff\1\113\6\37\1\122\2\37\1" +
                    "\67\1\uffff\1\37\1\uffff\1\37\1\127\3\37\1\133\1\uffff\1\134\1\135" +
                    "\2\37\1\uffff\1\134\1\140\1\37\3\uffff\2\37\1\uffff\1\144\1\145" +
                    "\1\146\3\uffff";
    static final String DFA17_eofS =
            "\147\uffff";
    static final String DFA17_minS =
            "\1\11\3\uffff\1\75\1\156\1\162\1\146\1\156\1\141\1\150\1\145\1\141" +
                    "\5\uffff\2\75\1\uffff\1\55\1\uffff\1\151\2\uffff\1\162\1\165\1\55" +
                    "\7\uffff\1\144\3\55\1\144\1\162\1\156\1\154\1\151\1\160\1\164\5" +
                    "\uffff\1\166\1\165\1\154\1\uffff\1\60\1\55\1\uffff\1\154\2\uffff" +
                    "\1\55\1\145\1\143\1\163\1\154\1\145\1\150\1\55\1\145\1\154\1\55" +
                    "\1\uffff\1\165\1\uffff\1\141\1\55\2\145\1\141\1\55\1\uffff\2\55" +
                    "\1\144\1\143\1\uffff\2\55\1\164\3\uffff\1\145\1\150\1\uffff\3\55" +
                    "\3\uffff";
    static final String DFA17_maxS =
            "\1\u2029\3\uffff\1\75\1\156\1\162\2\156\1\165\1\150\1\145\1\141" +
                    "\5\uffff\2\75\1\uffff\1\172\1\uffff\1\151\2\uffff\1\162\1\165\1" +
                    "\172\7\uffff\1\144\3\172\1\144\1\162\1\156\1\154\1\151\1\160\1\164" +
                    "\5\uffff\1\166\1\165\1\154\1\uffff\1\71\1\172\1\uffff\1\154\2\uffff" +
                    "\1\172\1\145\1\143\1\163\1\154\1\145\1\150\1\172\1\145\1\154\1\172" +
                    "\1\uffff\1\165\1\uffff\1\141\1\172\2\145\1\141\1\172\1\uffff\2\172" +
                    "\1\144\1\143\1\uffff\2\172\1\164\3\uffff\1\145\1\150\1\uffff\3\172" +
                    "\3\uffff";
    static final String DFA17_acceptS =
            "\1\uffff\1\1\1\2\1\3\11\uffff\1\20\1\21\1\22\1\23\1\24\2\uffff\1" +
                    "\31\1\uffff\1\33\1\uffff\1\36\1\37\3\uffff\1\43\1\44\1\45\1\46\1" +
                    "\47\1\4\1\35\13\uffff\1\26\1\25\1\30\1\27\1\32\3\uffff\1\42\2\uffff" +
                    "\1\6\1\uffff\1\13\1\10\13\uffff\1\5\1\uffff\1\11\6\uffff\1\34\4" +
                    "\uffff\1\17\3\uffff\1\16\1\40\1\41\2\uffff\1\14\3\uffff\1\15\1\7" +
                    "\1\12";
    static final String DFA17_specialS =
            "\147\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\41\1\40\2\uffff\1\40\22\uffff\1\41\1\21\1\31\1\30\1\35\2" +
                    "\uffff\1\31\1\15\1\16\1\26\1\24\1\17\1\25\1\37\1\1\12\34\1\4" +
                    "\1\uffff\1\22\1\20\1\23\1\uffff\1\36\32\37\1\2\1\uffff\1\3\1" +
                    "\uffff\1\37\1\uffff\1\5\2\37\1\27\1\10\1\11\2\37\1\7\4\37\1" +
                    "\33\1\6\1\14\1\37\1\13\1\37\1\32\2\37\1\12\3\37\u1fad\uffff" +
                    "\2\40",
            "",
            "",
            "",
            "\1\42",
            "\1\44",
            "\1\45",
            "\1\47\7\uffff\1\46",
            "\1\50",
            "\1\53\15\uffff\1\51\5\uffff\1\52",
            "\1\54",
            "\1\55",
            "\1\56",
            "",
            "",
            "",
            "",
            "",
            "\1\57",
            "\1\61",
            "",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\1\64",
            "",
            "",
            "\1\65",
            "\1\66",
            "\1\37\1\70\1\uffff\12\34\7\uffff\32\37\4\uffff\1\37\1\uffff" +
                    "\32\37",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\71",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\2\37" +
                    "\1\73\27\37",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "",
            "",
            "",
            "",
            "",
            "\1\105",
            "\1\106",
            "\1\107",
            "",
            "\12\110",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\1\112",
            "",
            "",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\123",
            "\1\124",
            "\2\37\1\uffff\12\110\7\uffff\32\37\4\uffff\1\37\1\uffff\32" +
                    "\37",
            "",
            "\1\125",
            "",
            "\1\126",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\130",
            "\1\131",
            "\1\132",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\136",
            "\1\137",
            "",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\141",
            "",
            "",
            "",
            "\1\142",
            "\1\143",
            "",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\2\37\1\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }

        public String getDescription() {
            return "1:1: Tokens : ( T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | COMMENT | StringLiteral | BOOLEAN | NULL | NUMBER | VARIABLE | PROPERTY | IDENTIFIER | NEWLINE | WS );";
        }
    }


}
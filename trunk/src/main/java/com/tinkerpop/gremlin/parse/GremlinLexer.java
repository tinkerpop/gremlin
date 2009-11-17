// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g 2009-11-17 12:39:26

package com.tinkerpop.gremlin.parse;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GremlinLexer extends Lexer {
    public static final int AxisName=33;
    public static final int AxisNameSeparator=34;
    public static final int SingleAxisStep=30;
    public static final int Foreach=27;
    public static final int NUMBER=6;
    public static final int ABBREVIATED_AXIS_STEP=16;
    public static final int And=48;
    public static final int FORSET=24;
    public static final int VARREF=7;
    public static final int PREDICATE=12;
    public static final int Letter=55;
    public static final int ANY_NAMESPACED_NODE=21;
    public static final int Comma=46;
    public static final int EqualtyOp=49;
    public static final int ANDEXPR=9;
    public static final int OREXPR=8;
    public static final int DoubleLiteral=53;
    public static final int RightSquareBracket=45;
    public static final int FUNCALL=13;
    public static final int NodeType=36;
    public static final int EXPRLIST=19;
    public static final int RecursiveAxisStep=31;
    public static final int NAMED_AXIS_STEP=14;
    public static final int LeftParenthesis=37;
    public static final int Colon=43;
    public static final int QNAME=4;
    public static final int Or=47;
    public static final int SIMPLE_AXIS_STEP=15;
    public static final int AbbreviatedStep=32;
    public static final int EQUEXPRESSION=11;
    public static final int NAME_AXIS=17;
    public static final int Star=41;
    public static final int WS=56;
    public static final int UNIONEXPR=10;
    public static final int IntegerLiteral=51;
    public static final int STRING=5;
    public static final int ATTRIBUTE_AXIS=18;
    public static final int RightParenthesis=38;
    public static final int StringLiteral=40;
    public static final int In=29;
    public static final int LOOPBODY=25;
    public static final int Pipe=50;
    public static final int GPATH=22;
    public static final int LeftSquareBracket=44;
    public static final int Newline=26;
    public static final int EOF=-1;
    public static final int DecimalLiteral=52;
    public static final int AbbreviatedAxisSpecifier=35;
    public static final int VariableReference=28;
    public static final int ProcessingInstruction=39;
    public static final int NCName=42;
    public static final int ANY_NODE=20;
    public static final int For=54;
    public static final int FOREACH=23;

    // delegates
    // delegators

    public GremlinLexer() {;} 
    public GremlinLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public GremlinLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g"; }

    // $ANTLR start "SingleAxisStep"
    public final void mSingleAxisStep() throws RecognitionException {
        try {
            int _type = SingleAxisStep;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:141:15: ( '/' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:141:17: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SingleAxisStep"

    // $ANTLR start "RecursiveAxisStep"
    public final void mRecursiveAxisStep() throws RecognitionException {
        try {
            int _type = RecursiveAxisStep;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:142:18: ( '//' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:142:20: '//'
            {
            match("//"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RecursiveAxisStep"

    // $ANTLR start "AxisNameSeparator"
    public final void mAxisNameSeparator() throws RecognitionException {
        try {
            int _type = AxisNameSeparator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:144:18: ( '::' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:144:20: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AxisNameSeparator"

    // $ANTLR start "AbbreviatedAxisSpecifier"
    public final void mAbbreviatedAxisSpecifier() throws RecognitionException {
        try {
            int _type = AbbreviatedAxisSpecifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:145:25: ( '@' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:145:27: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AbbreviatedAxisSpecifier"

    // $ANTLR start "Star"
    public final void mStar() throws RecognitionException {
        try {
            int _type = Star;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:147:5: ( '*' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:147:12: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Star"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:148:6: ( ':' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:148:12: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:149:6: ( ',' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:149:12: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "Pipe"
    public final void mPipe() throws RecognitionException {
        try {
            int _type = Pipe;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:150:5: ( '|' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:150:12: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Pipe"

    // $ANTLR start "AbbreviatedStep"
    public final void mAbbreviatedStep() throws RecognitionException {
        try {
            int _type = AbbreviatedStep;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:152:17: ( '.' | '..' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='.') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='.') ) {
                    alt1=2;
                }
                else {
                    alt1=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:152:19: '.'
                    {
                    match('.'); 

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:152:25: '..'
                    {
                    match(".."); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AbbreviatedStep"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:154:16: ( '(' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:154:18: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:155:17: ( ')' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:155:19: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:157:18: ( '[' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:157:20: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:158:19: ( ']' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:158:21: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "And"
    public final void mAnd() throws RecognitionException {
        try {
            int _type = And;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:160:5: ( 'and' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:160:7: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "And"

    // $ANTLR start "Or"
    public final void mOr() throws RecognitionException {
        try {
            int _type = Or;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:161:4: ( 'or' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:161:6: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Or"

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:163:6: ( 'for' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:163:8: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "For"

    // $ANTLR start "Foreach"
    public final void mForeach() throws RecognitionException {
        try {
            int _type = Foreach;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:164:9: ( 'foreach' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:164:11: 'foreach'
            {
            match("foreach"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Foreach"

    // $ANTLR start "In"
    public final void mIn() throws RecognitionException {
        try {
            int _type = In;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:165:5: ( 'in' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:165:7: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "In"

    // $ANTLR start "AxisName"
    public final void mAxisName() throws RecognitionException {
        try {
            int _type = AxisName;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:168:5: ( 'ancestor' | 'ancestor-or-self' | 'attribute' | 'child' | 'descendant' | 'descendant-or-self' | 'following' | 'following-sibling' | 'namespace' | 'parent' | 'preceding' | 'preceding-sibling' | 'self' )
            int alt2=13;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:168:8: 'ancestor'
                    {
                    match("ancestor"); 


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:168:22: 'ancestor-or-self'
                    {
                    match("ancestor-or-self"); 


                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:168:44: 'attribute'
                    {
                    match("attribute"); 


                    }
                    break;
                case 4 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:169:8: 'child'
                    {
                    match("child"); 


                    }
                    break;
                case 5 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:169:22: 'descendant'
                    {
                    match("descendant"); 


                    }
                    break;
                case 6 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:169:44: 'descendant-or-self'
                    {
                    match("descendant-or-self"); 


                    }
                    break;
                case 7 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:170:8: 'following'
                    {
                    match("following"); 


                    }
                    break;
                case 8 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:170:22: 'following-sibling'
                    {
                    match("following-sibling"); 


                    }
                    break;
                case 9 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:170:44: 'namespace'
                    {
                    match("namespace"); 


                    }
                    break;
                case 10 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:171:8: 'parent'
                    {
                    match("parent"); 


                    }
                    break;
                case 11 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:171:22: 'preceding'
                    {
                    match("preceding"); 


                    }
                    break;
                case 12 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:171:44: 'preceding-sibling'
                    {
                    match("preceding-sibling"); 


                    }
                    break;
                case 13 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:172:8: 'self'
                    {
                    match("self"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AxisName"

    // $ANTLR start "ProcessingInstruction"
    public final void mProcessingInstruction() throws RecognitionException {
        try {
            int _type = ProcessingInstruction;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:175:22: ( 'processing-instruction' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:175:25: 'processing-instruction'
            {
            match("processing-instruction"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ProcessingInstruction"

    // $ANTLR start "NodeType"
    public final void mNodeType() throws RecognitionException {
        try {
            int _type = NodeType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:178:2: ( 'comment' | 'text' | ProcessingInstruction | 'node' )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 'c':
                {
                alt3=1;
                }
                break;
            case 't':
                {
                alt3=2;
                }
                break;
            case 'p':
                {
                alt3=3;
                }
                break;
            case 'n':
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:178:5: 'comment'
                    {
                    match("comment"); 


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:178:17: 'text'
                    {
                    match("text"); 


                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:178:26: ProcessingInstruction
                    {
                    mProcessingInstruction(); 

                    }
                    break;
                case 4 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:178:50: 'node'
                    {
                    match("node"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NodeType"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            int _type = Letter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:181:5: ( '\\u0024' | '\\u005f' | '\\u0041' .. '\\u005a' | '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
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
    // $ANTLR end "Letter"

    // $ANTLR start "IntegerLiteral"
    public final void mIntegerLiteral() throws RecognitionException {
        try {
            int _type = IntegerLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:190:16: ( ( '0' .. '9' )+ )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:190:19: ( '0' .. '9' )+
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:190:19: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:190:20: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IntegerLiteral"

    // $ANTLR start "DecimalLiteral"
    public final void mDecimalLiteral() throws RecognitionException {
        try {
            int _type = DecimalLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:16: ( ( '.' ( '0' .. '9' )+ ) | ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='.') ) {
                alt8=1;
            }
            else if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:19: ( '.' ( '0' .. '9' )+ )
                    {
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:19: ( '.' ( '0' .. '9' )+ )
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:20: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:24: ( '0' .. '9' )+
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
                    	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:25: '0' .. '9'
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


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:40: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* )
                    {
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:40: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* )
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:41: ( '0' .. '9' )+ '.' ( '0' .. '9' )*
                    {
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:41: ( '0' .. '9' )+
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
                    	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:42: '0' .. '9'
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

                    match('.'); 
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:57: ( '0' .. '9' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:191:57: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DecimalLiteral"

    // $ANTLR start "DoubleLiteral"
    public final void mDoubleLiteral() throws RecognitionException {
        try {
            int _type = DoubleLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:16: ( ( ( '.' ( '0' .. '9' )+ ) | ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? ) ) ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:19: ( ( '.' ( '0' .. '9' )+ ) | ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? ) ) ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:19: ( ( '.' ( '0' .. '9' )+ ) | ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='.') ) {
                alt13=1;
            }
            else if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:20: ( '.' ( '0' .. '9' )+ )
                    {
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:20: ( '.' ( '0' .. '9' )+ )
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:21: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:25: ( '0' .. '9' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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


                    }


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:40: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? )
                    {
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:40: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? )
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:41: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )?
                    {
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:41: ( '0' .. '9' )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:42: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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

                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:53: ( '.' ( '0' .. '9' )* )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='.') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:54: '.' ( '0' .. '9' )*
                            {
                            match('.'); 
                            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:58: ( '0' .. '9' )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:58: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:84: ( '+' | '-' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='+'||LA14_0=='-') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:97: ( '0' .. '9' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:192:98: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DoubleLiteral"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:194:15: ( '\"' (~ ( '\"' ) )* '\"' | '\\'' (~ ( '\\'' ) )* '\\'' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\"') ) {
                alt18=1;
            }
            else if ( (LA18_0=='\'') ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:194:17: '\"' (~ ( '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:194:21: (~ ( '\"' ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='\u0000' && LA16_0<='!')||(LA16_0>='#' && LA16_0<='\uFFFF')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:194:21: ~ ( '\"' )
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
                    	    break loop16;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:194:35: '\\'' (~ ( '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:194:40: (~ ( '\\'' ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>='\u0000' && LA17_0<='&')||(LA17_0>='(' && LA17_0<='\uFFFF')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:194:40: ~ ( '\\'' )
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
                    	    break loop17;
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

    // $ANTLR start "EqualtyOp"
    public final void mEqualtyOp() throws RecognitionException {
        try {
            int _type = EqualtyOp;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:196:10: ( '=' | '!=' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='=') ) {
                alt19=1;
            }
            else if ( (LA19_0=='!') ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:196:12: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:196:18: '!='
                    {
                    match("!="); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualtyOp"

    // $ANTLR start "VariableReference"
    public final void mVariableReference() throws RecognitionException {
        try {
            int _type = VariableReference;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:198:18: ( '$' NCName )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:198:20: '$' NCName
            {
            match('$'); 
            mNCName(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VariableReference"

    // $ANTLR start "NCName"
    public final void mNCName() throws RecognitionException {
        try {
            int _type = NCName;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:200:8: ( Letter ( Letter | '0' .. '9' | '.' | '-' )* )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:200:10: Letter ( Letter | '0' .. '9' | '.' | '-' )*
            {
            mLetter(); 
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:200:17: ( Letter | '0' .. '9' | '.' | '-' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='$'||(LA20_0>='-' && LA20_0<='.')||(LA20_0>='0' && LA20_0<='9')||(LA20_0>='A' && LA20_0<='Z')||LA20_0=='_'||(LA20_0>='a' && LA20_0<='z')||(LA20_0>='\u00C0' && LA20_0<='\u00D6')||(LA20_0>='\u00D8' && LA20_0<='\u00F6')||(LA20_0>='\u00F8' && LA20_0<='\u1FFF')||(LA20_0>='\u3040' && LA20_0<='\u318F')||(LA20_0>='\u3300' && LA20_0<='\u337F')||(LA20_0>='\u3400' && LA20_0<='\u3D2D')||(LA20_0>='\u4E00' && LA20_0<='\u9FFF')||(LA20_0>='\uF900' && LA20_0<='\uFAFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NCName"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:202:3: ( ( ' ' | '\\t' | '\\u000C' ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:202:5: ( ' ' | '\\t' | '\\u000C' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "Newline"
    public final void mNewline() throws RecognitionException {
        try {
            int _type = Newline;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:204:9: ( ( ( '\\r' )? '\\n' ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:204:11: ( ( '\\r' )? '\\n' )
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:204:11: ( ( '\\r' )? '\\n' )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:204:12: ( '\\r' )? '\\n'
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:204:12: ( '\\r' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\r') ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:204:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Newline"

    public void mTokens() throws RecognitionException {
        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:8: ( SingleAxisStep | RecursiveAxisStep | AxisNameSeparator | AbbreviatedAxisSpecifier | Star | Colon | Comma | Pipe | AbbreviatedStep | LeftParenthesis | RightParenthesis | LeftSquareBracket | RightSquareBracket | And | Or | For | Foreach | In | AxisName | ProcessingInstruction | NodeType | Letter | IntegerLiteral | DecimalLiteral | DoubleLiteral | StringLiteral | EqualtyOp | VariableReference | NCName | WS | Newline )
        int alt22=31;
        alt22 = dfa22.predict(input);
        switch (alt22) {
            case 1 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:10: SingleAxisStep
                {
                mSingleAxisStep(); 

                }
                break;
            case 2 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:25: RecursiveAxisStep
                {
                mRecursiveAxisStep(); 

                }
                break;
            case 3 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:43: AxisNameSeparator
                {
                mAxisNameSeparator(); 

                }
                break;
            case 4 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:61: AbbreviatedAxisSpecifier
                {
                mAbbreviatedAxisSpecifier(); 

                }
                break;
            case 5 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:86: Star
                {
                mStar(); 

                }
                break;
            case 6 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:91: Colon
                {
                mColon(); 

                }
                break;
            case 7 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:97: Comma
                {
                mComma(); 

                }
                break;
            case 8 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:103: Pipe
                {
                mPipe(); 

                }
                break;
            case 9 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:108: AbbreviatedStep
                {
                mAbbreviatedStep(); 

                }
                break;
            case 10 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:124: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 11 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:140: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 12 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:157: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 13 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:175: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 14 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:194: And
                {
                mAnd(); 

                }
                break;
            case 15 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:198: Or
                {
                mOr(); 

                }
                break;
            case 16 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:201: For
                {
                mFor(); 

                }
                break;
            case 17 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:205: Foreach
                {
                mForeach(); 

                }
                break;
            case 18 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:213: In
                {
                mIn(); 

                }
                break;
            case 19 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:216: AxisName
                {
                mAxisName(); 

                }
                break;
            case 20 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:225: ProcessingInstruction
                {
                mProcessingInstruction(); 

                }
                break;
            case 21 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:247: NodeType
                {
                mNodeType(); 

                }
                break;
            case 22 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:256: Letter
                {
                mLetter(); 

                }
                break;
            case 23 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:263: IntegerLiteral
                {
                mIntegerLiteral(); 

                }
                break;
            case 24 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:278: DecimalLiteral
                {
                mDecimalLiteral(); 

                }
                break;
            case 25 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:293: DoubleLiteral
                {
                mDoubleLiteral(); 

                }
                break;
            case 26 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:307: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 27 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:321: EqualtyOp
                {
                mEqualtyOp(); 

                }
                break;
            case 28 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:331: VariableReference
                {
                mVariableReference(); 

                }
                break;
            case 29 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:349: NCName
                {
                mNCName(); 

                }
                break;
            case 30 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:356: WS
                {
                mWS(); 

                }
                break;
            case 31 :
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:1:359: Newline
                {
                mNewline(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA2_eotS =
        "\42\uffff\1\47\6\uffff\1\55\1\57\1\61\6\uffff";
    static final String DFA2_eofS =
        "\62\uffff";
    static final String DFA2_minS =
        "\1\141\1\156\1\uffff\1\145\1\157\1\uffff\1\141\1\uffff\1\143\1\uffff"+
        "\1\163\1\154\1\uffff\2\145\1\143\1\154\1\143\1\163\1\145\1\157\1"+
        "\145\1\164\1\156\1\167\1\144\1\157\1\144\2\151\1\162\1\141\2\156"+
        "\1\55\1\156\2\147\2\uffff\1\164\3\55\6\uffff";
    static final String DFA2_maxS =
        "\1\163\1\164\1\uffff\1\145\1\157\1\uffff\1\162\1\uffff\1\143\1\uffff"+
        "\1\163\1\154\1\uffff\2\145\1\143\1\154\1\143\1\163\1\145\1\157\1"+
        "\145\1\164\1\156\1\167\1\144\1\157\1\144\2\151\1\162\1\141\2\156"+
        "\1\55\1\156\2\147\2\uffff\1\164\3\55\6\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\4\2\uffff\1\11\1\uffff\1\15\1\uffff\1\3\2\uffff\1\12"+
        "\31\uffff\1\2\1\1\4\uffff\1\10\1\7\1\14\1\13\1\6\1\5";
    static final String DFA2_specialS =
        "\62\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\1\uffff\1\2\1\3\1\uffff\1\4\7\uffff\1\5\1\uffff\1\6\2\uffff"+
            "\1\7",
            "\1\10\5\uffff\1\11",
            "",
            "\1\12",
            "\1\13",
            "",
            "\1\14\20\uffff\1\15",
            "",
            "\1\16",
            "",
            "\1\17",
            "\1\20",
            "",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\50",
            "\1\51",
            "\1\52",
            "",
            "",
            "\1\53",
            "\1\54",
            "\1\56",
            "\1\60",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "167:1: AxisName : ( 'ancestor' | 'ancestor-or-self' | 'attribute' | 'child' | 'descendant' | 'descendant-or-self' | 'following' | 'following-sibling' | 'namespace' | 'parent' | 'preceding' | 'preceding-sibling' | 'self' );";
        }
    }
    static final String DFA22_eotS =
        "\1\uffff\1\36\1\40\4\uffff\1\41\4\uffff\13\45\1\66\2\uffff\1\45"+
        "\7\uffff\1\67\2\46\2\uffff\1\73\1\46\1\76\11\46\1\111\1\67\3\uffff"+
        "\1\114\2\46\1\uffff\1\120\1\46\1\uffff\12\46\1\uffff\1\111\1\67"+
        "\1\uffff\3\46\1\uffff\5\46\1\144\3\46\1\150\1\144\4\46\1\150\3\46"+
        "\1\uffff\3\46\1\uffff\7\46\1\150\4\46\1\176\1\46\1\144\4\46\1\150"+
        "\1\46\1\uffff\6\46\2\150\1\46\2\150\3\46\1\150\33\46\1\150\4\46"+
        "\1\150\1\46\1\150\1\46\1\150\4\46\1\u00b8\1\uffff";
    static final String DFA22_eofS =
        "\u00b9\uffff";
    static final String DFA22_minS =
        "\1\11\1\57\1\72\4\uffff\1\60\4\uffff\13\44\1\56\2\uffff\1\44\7\uffff"+
        "\1\60\1\143\1\164\2\uffff\1\44\1\154\1\44\1\151\1\155\1\163\1\155"+
        "\1\144\1\162\1\145\1\154\1\170\1\44\1\60\3\uffff\1\44\1\145\1\162"+
        "\1\uffff\1\44\1\154\1\uffff\1\154\1\155\1\143\3\145\2\143\1\146"+
        "\1\164\1\uffff\1\44\1\60\1\uffff\1\163\1\151\1\141\1\uffff\1\157"+
        "\1\144\2\145\1\163\1\44\1\156\2\145\2\44\1\164\1\142\1\143\1\167"+
        "\1\44\2\156\1\160\1\uffff\1\164\1\144\1\163\1\uffff\1\157\1\165"+
        "\1\150\1\151\1\164\1\144\1\141\1\44\1\151\1\163\1\162\1\164\1\44"+
        "\1\156\1\44\1\141\1\143\1\156\1\151\1\44\1\145\1\uffff\1\147\1\156"+
        "\1\145\1\147\1\156\1\157\2\44\1\164\2\44\1\147\1\162\1\163\1\44"+
        "\1\163\2\55\1\151\1\157\2\151\1\163\1\142\1\162\1\142\1\156\1\145"+
        "\1\154\1\55\1\154\1\163\1\154\1\151\1\163\1\151\1\164\1\146\1\156"+
        "\1\145\1\156\1\162\1\44\1\147\1\154\1\147\1\165\1\44\1\146\1\44"+
        "\1\143\1\44\1\164\1\151\1\157\1\156\1\44\1\uffff";
    static final String DFA22_maxS =
        "\1\ufaff\1\57\1\72\4\uffff\1\71\4\uffff\13\ufaff\1\145\2\uffff\1"+
        "\ufaff\7\uffff\1\145\1\144\1\164\2\uffff\1\ufaff\1\162\1\ufaff\1"+
        "\151\1\155\1\163\1\155\1\144\1\162\1\157\1\154\1\170\1\ufaff\1\145"+
        "\3\uffff\1\ufaff\1\145\1\162\1\uffff\1\ufaff\1\154\1\uffff\1\154"+
        "\1\155\1\143\3\145\2\143\1\146\1\164\1\uffff\1\ufaff\1\145\1\uffff"+
        "\1\163\1\151\1\141\1\uffff\1\157\1\144\2\145\1\163\1\ufaff\1\156"+
        "\2\145\2\ufaff\1\164\1\142\1\143\1\167\1\ufaff\2\156\1\160\1\uffff"+
        "\1\164\1\144\1\163\1\uffff\1\157\1\165\1\150\1\151\1\164\1\144\1"+
        "\141\1\ufaff\1\151\1\163\1\162\1\164\1\ufaff\1\156\1\ufaff\1\141"+
        "\1\143\1\156\1\151\1\ufaff\1\145\1\uffff\1\147\1\156\1\145\1\147"+
        "\1\156\1\157\2\ufaff\1\164\2\ufaff\1\147\1\162\1\163\1\ufaff\1\163"+
        "\2\55\1\151\1\157\2\151\1\163\1\142\1\162\1\142\1\156\1\145\1\154"+
        "\1\55\1\154\1\163\1\154\1\151\1\163\1\151\1\164\1\146\1\156\1\145"+
        "\1\156\1\162\1\ufaff\1\147\1\154\1\147\1\165\1\ufaff\1\146\1\ufaff"+
        "\1\143\1\ufaff\1\164\1\151\1\157\1\156\1\ufaff\1\uffff";
    static final String DFA22_acceptS =
        "\3\uffff\1\4\1\5\1\7\1\10\1\uffff\1\12\1\13\1\14\1\15\14\uffff\1"+
        "\32\1\33\1\uffff\1\36\1\37\1\2\1\1\1\3\1\6\1\11\3\uffff\1\26\1\35"+
        "\16\uffff\1\31\1\27\1\30\3\uffff\1\17\2\uffff\1\22\12\uffff\1\34"+
        "\2\uffff\1\16\3\uffff\1\20\23\uffff\1\25\3\uffff\1\23\25\uffff\1"+
        "\21\71\uffff\1\24";
    static final String DFA22_specialS =
        "\u00b9\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\33\1\34\1\uffff\1\33\1\34\22\uffff\1\33\1\31\1\30\1\uffff"+
            "\1\26\2\uffff\1\30\1\10\1\11\1\4\1\uffff\1\5\1\uffff\1\7\1\1"+
            "\12\27\1\2\2\uffff\1\31\2\uffff\1\3\32\32\1\12\1\uffff\1\13"+
            "\1\uffff\1\32\1\uffff\1\14\1\32\1\20\1\21\1\32\1\16\2\32\1\17"+
            "\4\32\1\22\1\15\1\23\2\32\1\24\1\25\6\32\1\uffff\1\6\103\uffff"+
            "\27\32\1\uffff\37\32\1\uffff\u1f08\32\u1040\uffff\u0150\32\u0170"+
            "\uffff\u0080\32\u0080\uffff\u092e\32\u10d2\uffff\u5200\32\u5900"+
            "\uffff\u0200\32",
            "\1\35",
            "\1\37",
            "",
            "",
            "",
            "",
            "\12\42",
            "",
            "",
            "",
            "",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\15\46\1\43\5\46\1\44\6\46\105\uffff\27\46\1\uffff\37"+
            "\46\1\uffff\u1f08\46\u1040\uffff\u0150\46\u0170\uffff\u0080"+
            "\46\u0080\uffff\u092e\46\u10d2\uffff\u5200\46\u5900\uffff\u0200"+
            "\46",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\21\46\1\47\10\46\105\uffff\27\46\1\uffff\37\46\1\uffff"+
            "\u1f08\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff"+
            "\u092e\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\16\46\1\50\13\46\105\uffff\27\46\1\uffff\37\46\1\uffff"+
            "\u1f08\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff"+
            "\u092e\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\15\46\1\51\14\46\105\uffff\27\46\1\uffff\37\46\1\uffff"+
            "\u1f08\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff"+
            "\u092e\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\7\46\1\52\6\46\1\53\13\46\105\uffff\27\46\1\uffff\37"+
            "\46\1\uffff\u1f08\46\u1040\uffff\u0150\46\u0170\uffff\u0080"+
            "\46\u0080\uffff\u092e\46\u10d2\uffff\u5200\46\u5900\uffff\u0200"+
            "\46",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\4\46\1\54\25\46\105\uffff\27\46\1\uffff\37\46\1\uffff"+
            "\u1f08\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff"+
            "\u092e\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\1\55\15\46\1\56\13\46\105\uffff\27\46\1\uffff\37\46"+
            "\1\uffff\u1f08\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46"+
            "\u0080\uffff\u092e\46\u10d2\uffff\u5200\46\u5900\uffff\u0200"+
            "\46",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\1\57\20\46\1\60\10\46\105\uffff\27\46\1\uffff\37\46"+
            "\1\uffff\u1f08\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46"+
            "\u0080\uffff\u092e\46\u10d2\uffff\u5200\46\u5900\uffff\u0200"+
            "\46",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\4\46\1\61\25\46\105\uffff\27\46\1\uffff\37\46\1\uffff"+
            "\u1f08\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff"+
            "\u092e\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\4\46\1\62\25\46\105\uffff\27\46\1\uffff\37\46\1\uffff"+
            "\u1f08\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff"+
            "\u092e\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\63\10\uffff\2\46\1\uffff\12\46\7\uffff\32\63\4\uffff\1\63"+
            "\1\uffff\32\63\105\uffff\27\63\1\uffff\37\63\1\uffff\u1f08\63"+
            "\u1040\uffff\u0150\63\u0170\uffff\u0080\63\u0080\uffff\u092e"+
            "\63\u10d2\uffff\u5200\63\u5900\uffff\u0200\63",
            "\1\64\1\uffff\12\27\13\uffff\1\65\37\uffff\1\65",
            "",
            "",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\42\13\uffff\1\65\37\uffff\1\65",
            "\1\71\1\70",
            "\1\72",
            "",
            "",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\75\5\uffff\1\74",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105\11\uffff\1\106",
            "\1\107",
            "\1\110",
            "\1\112\10\uffff\2\112\1\uffff\12\112\7\uffff\32\112\4\uffff"+
            "\1\112\1\uffff\32\112\105\uffff\27\112\1\uffff\37\112\1\uffff"+
            "\u1f08\112\u1040\uffff\u0150\112\u0170\uffff\u0080\112\u0080"+
            "\uffff\u092e\112\u10d2\uffff\u5200\112\u5900\uffff\u0200\112",
            "\12\113\13\uffff\1\65\37\uffff\1\65",
            "",
            "",
            "",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\115",
            "\1\116",
            "",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\4\46\1\117\25\46\105\uffff\27\46\1\uffff\37\46\1\uffff"+
            "\u1f08\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff"+
            "\u092e\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\121",
            "",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "",
            "\1\112\10\uffff\2\112\1\uffff\12\112\7\uffff\32\112\4\uffff"+
            "\1\112\1\uffff\32\112\105\uffff\27\112\1\uffff\37\112\1\uffff"+
            "\u1f08\112\u1040\uffff\u0150\112\u0170\uffff\u0080\112\u0080"+
            "\uffff\u092e\112\u10d2\uffff\u5200\112\u5900\uffff\u0200\112",
            "\12\113\13\uffff\1\65\37\uffff\1\65",
            "",
            "\1\134",
            "\1\135",
            "\1\136",
            "",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "\1\160",
            "\1\161",
            "\1\162",
            "",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\177",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\46\10\uffff\1\u0084\1\46\1\uffff\12\46\7\uffff\32\46\4\uffff"+
            "\1\46\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08"+
            "\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\u0085",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\46\10\uffff\1\u008c\1\46\1\uffff\12\46\7\uffff\32\46\4\uffff"+
            "\1\46\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08"+
            "\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\u008d",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\46\10\uffff\1\u008e\1\46\1\uffff\12\46\7\uffff\32\46\4\uffff"+
            "\1\46\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08"+
            "\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\46\10\uffff\1\u0092\1\46\1\uffff\12\46\7\uffff\32\46\4\uffff"+
            "\1\46\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08"+
            "\46\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\u00b2",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\u00b3",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\46\10\uffff\2\46\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46"+
            "\1\uffff\32\46\105\uffff\27\46\1\uffff\37\46\1\uffff\u1f08\46"+
            "\u1040\uffff\u0150\46\u0170\uffff\u0080\46\u0080\uffff\u092e"+
            "\46\u10d2\uffff\u5200\46\u5900\uffff\u0200\46",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( SingleAxisStep | RecursiveAxisStep | AxisNameSeparator | AbbreviatedAxisSpecifier | Star | Colon | Comma | Pipe | AbbreviatedStep | LeftParenthesis | RightParenthesis | LeftSquareBracket | RightSquareBracket | And | Or | For | Foreach | In | AxisName | ProcessingInstruction | NodeType | Letter | IntegerLiteral | DecimalLiteral | DoubleLiteral | StringLiteral | EqualtyOp | VariableReference | NCName | WS | Newline );";
        }
    }
 

}
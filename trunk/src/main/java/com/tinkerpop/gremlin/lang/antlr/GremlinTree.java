// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g 2009-11-17 16:13:27

package com.tinkerpop.gremlin.lang.antlr;

import com.tinkerpop.gremlin.Evaluator;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class GremlinTree extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QNAME", "STRING", "NUMBER", "VARREF", "OREXPR", "ANDEXPR", "UNIONEXPR", "EQUEXPRESSION", "PREDICATE", "FUNCALL", "NAMED_AXIS_STEP", "SIMPLE_AXIS_STEP", "ABBREVIATED_AXIS_STEP", "NAME_AXIS", "ATTRIBUTE_AXIS", "EXPRLIST", "ANY_NODE", "ANY_NAMESPACED_NODE", "GPATH", "FOREACH", "FORSET", "LOOPBODY", "Newline", "Foreach", "VariableReference", "In", "SingleAxisStep", "RecursiveAxisStep", "AbbreviatedStep", "AxisName", "AxisNameSeparator", "AbbreviatedAxisSpecifier", "NodeType", "LeftParenthesis", "RightParenthesis", "ProcessingInstruction", "StringLiteral", "Star", "NCName", "Colon", "LeftSquareBracket", "RightSquareBracket", "Comma", "Or", "And", "EqualtyOp", "Pipe", "IntegerLiteral", "DecimalLiteral", "DoubleLiteral", "For", "Letter", "WS"
    };
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


        public GremlinTree(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public GremlinTree(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return GremlinTree.tokenNames; }
    public String getGrammarFileName() { return "/Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g"; }


            
            protected Evaluator evaluator;
            
            public GremlinTree(TreeNodeStream input, Evaluator evaluator) {
                this(input, new RecognizerSharedState());
                this.evaluator = evaluator;
            }	



    // $ANTLR start "statement"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:25:1: statement : gpath ( Newline )? ;
    public final void statement() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:25:11: ( gpath ( Newline )? )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:25:13: gpath ( Newline )?
            {
            pushFollow(FOLLOW_gpath_in_statement48);
            gpath();

            state._fsp--;

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:25:19: ( Newline )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Newline) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:25:19: Newline
                    {
                    match(input,Newline,FOLLOW_Newline_in_statement50); 

                    }
                    break;

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
    // $ANTLR end "statement"


    // $ANTLR start "foreach"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:27:1: foreach : ^( FOREACH ^( VARREF VariableReference ) ^( FORSET set= gpath ) ^( LOOPBODY loop= gpath ) ) ;
    public final void foreach() throws RecognitionException {
        CommonTree FOREACH1=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:27:9: ( ^( FOREACH ^( VARREF VariableReference ) ^( FORSET set= gpath ) ^( LOOPBODY loop= gpath ) ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:27:11: ^( FOREACH ^( VARREF VariableReference ) ^( FORSET set= gpath ) ^( LOOPBODY loop= gpath ) )
            {
            FOREACH1=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach61); 

            match(input, Token.DOWN, null); 
            match(input,VARREF,FOLLOW_VARREF_in_foreach64); 

            match(input, Token.DOWN, null); 
            match(input,VariableReference,FOLLOW_VariableReference_in_foreach66); 

            match(input, Token.UP, null); 
            match(input,FORSET,FOLLOW_FORSET_in_foreach70); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_gpath_in_foreach74);
            gpath();

            state._fsp--;


            match(input, Token.UP, null); 
            match(input,LOOPBODY,FOLLOW_LOOPBODY_in_foreach78); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_gpath_in_foreach82);
            gpath();

            state._fsp--;


            match(input, Token.UP, null); 

            match(input, Token.UP, null); 

            	System.out.println("this is a foreach statement: " + (FOREACH1!=null?FOREACH1.getText():null));


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
    // $ANTLR end "foreach"


    // $ANTLR start "gpath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:32:1: gpath : ( ^( GPATH xpath ) | ^( GPATH functionCall ) | ^( GPATH literal ) );
    public final void gpath() throws RecognitionException {
        String literal2 = null;


        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:32:7: ( ^( GPATH xpath ) | ^( GPATH functionCall ) | ^( GPATH literal ) )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==GPATH) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case VariableReference:
                    case StringLiteral:
                    case IntegerLiteral:
                    case DecimalLiteral:
                    case DoubleLiteral:
                        {
                        alt2=3;
                        }
                        break;
                    case QNAME:
                    case SingleAxisStep:
                    case RecursiveAxisStep:
                    case AbbreviatedStep:
                    case AxisName:
                    case AbbreviatedAxisSpecifier:
                    case NodeType:
                    case ProcessingInstruction:
                    case Star:
                    case NCName:
                        {
                        alt2=1;
                        }
                        break;
                    case FUNCALL:
                        {
                        alt2=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:32:9: ^( GPATH xpath )
                    {
                    match(input,GPATH,FOLLOW_GPATH_in_gpath96); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_xpath_in_gpath98);
                    xpath();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     evaluator.evaluate("marko");

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:33:4: ^( GPATH functionCall )
                    {
                    match(input,GPATH,FOLLOW_GPATH_in_gpath106); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_functionCall_in_gpath108);
                    functionCall();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     evaluator.evaluate("paul");

                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:34:4: ^( GPATH literal )
                    {
                    match(input,GPATH,FOLLOW_GPATH_in_gpath116); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_literal_in_gpath118);
                    literal2=literal();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    evaluator.evaluate(literal2);

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
    // $ANTLR end "gpath"


    // $ANTLR start "xpath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:38:1: xpath : locationPath ;
    public final void xpath() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:38:6: ( locationPath )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:38:8: locationPath
            {
            pushFollow(FOLLOW_locationPath_in_xpath132);
            locationPath();

            state._fsp--;


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
    // $ANTLR end "xpath"


    // $ANTLR start "locationPath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:40:1: locationPath : ( relativeLocationPath | absoluteLocationPath );
    public final void locationPath() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:41:5: ( relativeLocationPath | absoluteLocationPath )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QNAME||(LA3_0>=AbbreviatedStep && LA3_0<=AxisName)||(LA3_0>=AbbreviatedAxisSpecifier && LA3_0<=NodeType)||LA3_0==ProcessingInstruction||(LA3_0>=Star && LA3_0<=NCName)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=SingleAxisStep && LA3_0<=RecursiveAxisStep)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:41:7: relativeLocationPath
                    {
                    pushFollow(FOLLOW_relativeLocationPath_in_locationPath145);
                    relativeLocationPath();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:42:7: absoluteLocationPath
                    {
                    pushFollow(FOLLOW_absoluteLocationPath_in_locationPath154);
                    absoluteLocationPath();

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
        return ;
    }
    // $ANTLR end "locationPath"


    // $ANTLR start "absoluteLocationPath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:45:1: absoluteLocationPath : ( SingleAxisStep ( relativeLocationPath )? | abbreviatedAbsoluteLocationPath );
    public final void absoluteLocationPath() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:46:5: ( SingleAxisStep ( relativeLocationPath )? | abbreviatedAbsoluteLocationPath )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==SingleAxisStep) ) {
                alt5=1;
            }
            else if ( (LA5_0==RecursiveAxisStep) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:46:7: SingleAxisStep ( relativeLocationPath )?
                    {
                    match(input,SingleAxisStep,FOLLOW_SingleAxisStep_in_absoluteLocationPath176); 
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:46:22: ( relativeLocationPath )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==QNAME||(LA4_0>=AbbreviatedStep && LA4_0<=AxisName)||(LA4_0>=AbbreviatedAxisSpecifier && LA4_0<=NodeType)||LA4_0==ProcessingInstruction||(LA4_0>=Star && LA4_0<=NCName)) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:46:22: relativeLocationPath
                            {
                            pushFollow(FOLLOW_relativeLocationPath_in_absoluteLocationPath178);
                            relativeLocationPath();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:47:7: abbreviatedAbsoluteLocationPath
                    {
                    pushFollow(FOLLOW_abbreviatedAbsoluteLocationPath_in_absoluteLocationPath187);
                    abbreviatedAbsoluteLocationPath();

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
        return ;
    }
    // $ANTLR end "absoluteLocationPath"


    // $ANTLR start "abbreviatedAbsoluteLocationPath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:50:1: abbreviatedAbsoluteLocationPath : RecursiveAxisStep relativeLocationPath ;
    public final void abbreviatedAbsoluteLocationPath() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:50:32: ( RecursiveAxisStep relativeLocationPath )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:50:34: RecursiveAxisStep relativeLocationPath
            {
            match(input,RecursiveAxisStep,FOLLOW_RecursiveAxisStep_in_abbreviatedAbsoluteLocationPath199); 
            pushFollow(FOLLOW_relativeLocationPath_in_abbreviatedAbsoluteLocationPath201);
            relativeLocationPath();

            state._fsp--;


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
    // $ANTLR end "abbreviatedAbsoluteLocationPath"


    // $ANTLR start "relativeLocationPath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:52:1: relativeLocationPath : step ( simpleAxisStep step )* ;
    public final void relativeLocationPath() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:53:5: ( step ( simpleAxisStep step )* )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:53:7: step ( simpleAxisStep step )*
            {
            pushFollow(FOLLOW_step_in_relativeLocationPath214);
            step();

            state._fsp--;

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:54:5: ( simpleAxisStep step )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=SingleAxisStep && LA6_0<=RecursiveAxisStep)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:54:7: simpleAxisStep step
            	    {
            	    pushFollow(FOLLOW_simpleAxisStep_in_relativeLocationPath223);
            	    simpleAxisStep();

            	    state._fsp--;

            	    pushFollow(FOLLOW_step_in_relativeLocationPath225);
            	    step();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
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
    // $ANTLR end "relativeLocationPath"


    // $ANTLR start "step"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:57:1: step : ( namedAxisStep | abbreviatedAxisStep ) ( predicate )* ;
    public final void step() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:58:5: ( ( namedAxisStep | abbreviatedAxisStep ) ( predicate )* )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:58:7: ( namedAxisStep | abbreviatedAxisStep ) ( predicate )*
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:58:7: ( namedAxisStep | abbreviatedAxisStep )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==QNAME||LA7_0==AxisName||(LA7_0>=AbbreviatedAxisSpecifier && LA7_0<=NodeType)||LA7_0==ProcessingInstruction||(LA7_0>=Star && LA7_0<=NCName)) ) {
                alt7=1;
            }
            else if ( (LA7_0==AbbreviatedStep) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:58:9: namedAxisStep
                    {
                    pushFollow(FOLLOW_namedAxisStep_in_step247);
                    namedAxisStep();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:58:25: abbreviatedAxisStep
                    {
                    pushFollow(FOLLOW_abbreviatedAxisStep_in_step251);
                    abbreviatedAxisStep();

                    state._fsp--;


                    }
                    break;

            }

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:58:47: ( predicate )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==LeftSquareBracket) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:58:47: predicate
            	    {
            	    pushFollow(FOLLOW_predicate_in_step255);
            	    predicate();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
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
    // $ANTLR end "step"


    // $ANTLR start "simpleAxisStep"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:61:1: simpleAxisStep : ( SingleAxisStep | RecursiveAxisStep ) ;
    public final void simpleAxisStep() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:62:5: ( ( SingleAxisStep | RecursiveAxisStep ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:62:7: ( SingleAxisStep | RecursiveAxisStep )
            {
            if ( (input.LA(1)>=SingleAxisStep && input.LA(1)<=RecursiveAxisStep) ) {
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
    // $ANTLR end "simpleAxisStep"


    // $ANTLR start "abbreviatedAxisStep"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:67:1: abbreviatedAxisStep : AbbreviatedStep ;
    public final void abbreviatedAxisStep() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:67:20: ( AbbreviatedStep )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:67:22: AbbreviatedStep
            {
            match(input,AbbreviatedStep,FOLLOW_AbbreviatedStep_in_abbreviatedAxisStep305); 

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
    // $ANTLR end "abbreviatedAxisStep"


    // $ANTLR start "namedAxisStep"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:69:1: namedAxisStep : ( ( axisSpecifier )? nodeTest ) ;
    public final void namedAxisStep() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:69:14: ( ( ( axisSpecifier )? nodeTest ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:69:16: ( ( axisSpecifier )? nodeTest )
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:69:16: ( ( axisSpecifier )? nodeTest )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:69:17: ( axisSpecifier )? nodeTest
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:69:17: ( axisSpecifier )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==AxisName||LA9_0==AbbreviatedAxisSpecifier) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:69:17: axisSpecifier
                    {
                    pushFollow(FOLLOW_axisSpecifier_in_namedAxisStep313);
                    axisSpecifier();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_nodeTest_in_namedAxisStep316);
            nodeTest();

            state._fsp--;


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
    // $ANTLR end "namedAxisStep"


    // $ANTLR start "axisSpecifier"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:71:1: axisSpecifier : ( AxisName AxisNameSeparator | AbbreviatedAxisSpecifier );
    public final void axisSpecifier() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:72:5: ( AxisName AxisNameSeparator | AbbreviatedAxisSpecifier )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==AxisName) ) {
                alt10=1;
            }
            else if ( (LA10_0==AbbreviatedAxisSpecifier) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:72:7: AxisName AxisNameSeparator
                    {
                    match(input,AxisName,FOLLOW_AxisName_in_axisSpecifier330); 
                    match(input,AxisNameSeparator,FOLLOW_AxisNameSeparator_in_axisSpecifier332); 

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:73:7: AbbreviatedAxisSpecifier
                    {
                    match(input,AbbreviatedAxisSpecifier,FOLLOW_AbbreviatedAxisSpecifier_in_axisSpecifier341); 

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
    // $ANTLR end "axisSpecifier"


    // $ANTLR start "nodeTest"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:76:1: nodeTest : ( nameTest | NodeType LeftParenthesis RightParenthesis | ProcessingInstruction LeftParenthesis StringLiteral RightParenthesis );
    public final void nodeTest() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:77:2: ( nameTest | NodeType LeftParenthesis RightParenthesis | ProcessingInstruction LeftParenthesis StringLiteral RightParenthesis )
            int alt11=3;
            switch ( input.LA(1) ) {
            case QNAME:
            case Star:
            case NCName:
                {
                alt11=1;
                }
                break;
            case NodeType:
                {
                alt11=2;
                }
                break;
            case ProcessingInstruction:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:77:4: nameTest
                    {
                    pushFollow(FOLLOW_nameTest_in_nodeTest356);
                    nameTest();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:78:4: NodeType LeftParenthesis RightParenthesis
                    {
                    match(input,NodeType,FOLLOW_NodeType_in_nodeTest362); 
                    match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_nodeTest364); 
                    match(input,RightParenthesis,FOLLOW_RightParenthesis_in_nodeTest366); 

                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:79:4: ProcessingInstruction LeftParenthesis StringLiteral RightParenthesis
                    {
                    match(input,ProcessingInstruction,FOLLOW_ProcessingInstruction_in_nodeTest372); 
                    match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_nodeTest374); 
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_nodeTest376); 
                    match(input,RightParenthesis,FOLLOW_RightParenthesis_in_nodeTest378); 

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
    // $ANTLR end "nodeTest"


    // $ANTLR start "nameTest"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:82:1: nameTest : ( Star | NCName Colon Star | qName );
    public final void nameTest() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:83:5: ( Star | NCName Colon Star | qName )
            int alt12=3;
            switch ( input.LA(1) ) {
            case Star:
                {
                alt12=1;
                }
                break;
            case NCName:
                {
                alt12=2;
                }
                break;
            case QNAME:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:83:7: Star
                    {
                    match(input,Star,FOLLOW_Star_in_nameTest394); 

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:84:7: NCName Colon Star
                    {
                    match(input,NCName,FOLLOW_NCName_in_nameTest403); 
                    match(input,Colon,FOLLOW_Colon_in_nameTest405); 
                    match(input,Star,FOLLOW_Star_in_nameTest407); 

                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:85:7: qName
                    {
                    pushFollow(FOLLOW_qName_in_nameTest416);
                    qName();

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
        return ;
    }
    // $ANTLR end "nameTest"


    // $ANTLR start "predicate"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:88:1: predicate : LeftSquareBracket predicateExpr RightSquareBracket ;
    public final void predicate() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:88:10: ( LeftSquareBracket predicateExpr RightSquareBracket )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:88:12: LeftSquareBracket predicateExpr RightSquareBracket
            {
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_predicate428); 
            pushFollow(FOLLOW_predicateExpr_in_predicate430);
            predicateExpr();

            state._fsp--;

            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_predicate432); 

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
    // $ANTLR end "predicate"


    // $ANTLR start "predicateExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:90:1: predicateExpr : expr ;
    public final void predicateExpr() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:90:15: ( expr )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:90:17: expr
            {
            pushFollow(FOLLOW_expr_in_predicateExpr440);
            expr();

            state._fsp--;


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
    // $ANTLR end "predicateExpr"


    // $ANTLR start "functionCall"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:92:1: functionCall : ^( FUNCALL qName ) ;
    public final void functionCall() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:92:13: ( ^( FUNCALL qName ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:92:15: ^( FUNCALL qName )
            {
            match(input,FUNCALL,FOLLOW_FUNCALL_in_functionCall452); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_qName_in_functionCall454);
            qName();

            state._fsp--;


            match(input, Token.UP, null); 

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
    // $ANTLR end "functionCall"


    // $ANTLR start "expressionList"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:95:1: expressionList : expr ( Comma expr )* ;
    public final void expressionList() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:95:16: ( expr ( Comma expr )* )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:95:18: expr ( Comma expr )*
            {
            pushFollow(FOLLOW_expr_in_expressionList466);
            expr();

            state._fsp--;

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:95:23: ( Comma expr )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==Comma) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:95:25: Comma expr
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_expressionList470); 
            	    pushFollow(FOLLOW_expr_in_expressionList472);
            	    expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
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
    // $ANTLR end "expressionList"


    // $ANTLR start "pathExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:97:1: pathExpr : ( locationPath | filterExpr ( simpleAxisStep relativeLocationPath )? );
    public final void pathExpr() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:98:5: ( locationPath | filterExpr ( simpleAxisStep relativeLocationPath )? )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==QNAME||(LA15_0>=SingleAxisStep && LA15_0<=AxisName)||(LA15_0>=AbbreviatedAxisSpecifier && LA15_0<=NodeType)||LA15_0==ProcessingInstruction||(LA15_0>=Star && LA15_0<=NCName)) ) {
                alt15=1;
            }
            else if ( (LA15_0==FUNCALL||LA15_0==VariableReference||LA15_0==LeftParenthesis||LA15_0==StringLiteral||(LA15_0>=IntegerLiteral && LA15_0<=DoubleLiteral)) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:98:7: locationPath
                    {
                    pushFollow(FOLLOW_locationPath_in_pathExpr487);
                    locationPath();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:99:7: filterExpr ( simpleAxisStep relativeLocationPath )?
                    {
                    pushFollow(FOLLOW_filterExpr_in_pathExpr495);
                    filterExpr();

                    state._fsp--;

                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:99:18: ( simpleAxisStep relativeLocationPath )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>=SingleAxisStep && LA14_0<=RecursiveAxisStep)) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:99:19: simpleAxisStep relativeLocationPath
                            {
                            pushFollow(FOLLOW_simpleAxisStep_in_pathExpr498);
                            simpleAxisStep();

                            state._fsp--;

                            pushFollow(FOLLOW_relativeLocationPath_in_pathExpr501);
                            relativeLocationPath();

                            state._fsp--;


                            }
                            break;

                    }


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
    // $ANTLR end "pathExpr"


    // $ANTLR start "filterExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:102:1: filterExpr : primaryExpr ( predicate )? ;
    public final void filterExpr() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:102:11: ( primaryExpr ( predicate )? )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:102:13: primaryExpr ( predicate )?
            {
            pushFollow(FOLLOW_primaryExpr_in_filterExpr515);
            primaryExpr();

            state._fsp--;

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:102:25: ( predicate )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LeftSquareBracket) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:102:25: predicate
                    {
                    pushFollow(FOLLOW_predicate_in_filterExpr517);
                    predicate();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "filterExpr"


    // $ANTLR start "primaryExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:104:1: primaryExpr : ( LeftParenthesis expr RightParenthesis | literal | functionCall );
    public final void primaryExpr() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:105:5: ( LeftParenthesis expr RightParenthesis | literal | functionCall )
            int alt17=3;
            switch ( input.LA(1) ) {
            case LeftParenthesis:
                {
                alt17=1;
                }
                break;
            case VariableReference:
            case StringLiteral:
            case IntegerLiteral:
            case DecimalLiteral:
            case DoubleLiteral:
                {
                alt17=2;
                }
                break;
            case FUNCALL:
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
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:105:7: LeftParenthesis expr RightParenthesis
                    {
                    match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_primaryExpr530); 
                    pushFollow(FOLLOW_expr_in_primaryExpr532);
                    expr();

                    state._fsp--;

                    match(input,RightParenthesis,FOLLOW_RightParenthesis_in_primaryExpr534); 

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:106:7: literal
                    {
                    pushFollow(FOLLOW_literal_in_primaryExpr542);
                    literal();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:107:7: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_primaryExpr550);
                    functionCall();

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
        return ;
    }
    // $ANTLR end "primaryExpr"


    // $ANTLR start "expr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:110:1: expr : orExpr ;
    public final void expr() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:110:5: ( orExpr )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:110:7: orExpr
            {
            pushFollow(FOLLOW_orExpr_in_expr562);
            orExpr();

            state._fsp--;


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
    // $ANTLR end "expr"


    // $ANTLR start "orExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:112:1: orExpr : andExpr ( Or andExpr )* ;
    public final void orExpr() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:112:7: ( andExpr ( Or andExpr )* )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:112:9: andExpr ( Or andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr569);
            andExpr();

            state._fsp--;

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:112:17: ( Or andExpr )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==Or) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:112:18: Or andExpr
            	    {
            	    match(input,Or,FOLLOW_Or_in_orExpr572); 
            	    pushFollow(FOLLOW_andExpr_in_orExpr574);
            	    andExpr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
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
    // $ANTLR end "orExpr"


    // $ANTLR start "andExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:114:1: andExpr : equalityExpr ( And equalityExpr )? ;
    public final void andExpr() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:114:8: ( equalityExpr ( And equalityExpr )? )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:114:10: equalityExpr ( And equalityExpr )?
            {
            pushFollow(FOLLOW_equalityExpr_in_andExpr583);
            equalityExpr();

            state._fsp--;

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:114:23: ( And equalityExpr )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==And) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:114:24: And equalityExpr
                    {
                    match(input,And,FOLLOW_And_in_andExpr586); 
                    pushFollow(FOLLOW_equalityExpr_in_andExpr588);
                    equalityExpr();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "andExpr"


    // $ANTLR start "equalityExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:116:1: equalityExpr : relationalExpr ( EqualtyOp relationalExpr )? ;
    public final void equalityExpr() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:116:13: ( relationalExpr ( EqualtyOp relationalExpr )? )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:116:15: relationalExpr ( EqualtyOp relationalExpr )?
            {
            pushFollow(FOLLOW_relationalExpr_in_equalityExpr597);
            relationalExpr();

            state._fsp--;

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:116:30: ( EqualtyOp relationalExpr )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==EqualtyOp) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:116:31: EqualtyOp relationalExpr
                    {
                    match(input,EqualtyOp,FOLLOW_EqualtyOp_in_equalityExpr600); 
                    pushFollow(FOLLOW_relationalExpr_in_equalityExpr602);
                    relationalExpr();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "equalityExpr"


    // $ANTLR start "relationalExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:118:1: relationalExpr : unionExpr ;
    public final void relationalExpr() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:118:15: ( unionExpr )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:118:17: unionExpr
            {
            pushFollow(FOLLOW_unionExpr_in_relationalExpr615);
            unionExpr();

            state._fsp--;


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
    // $ANTLR end "relationalExpr"


    // $ANTLR start "unionExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:120:1: unionExpr : pathExpr ( Pipe pathExpr )? ;
    public final void unionExpr() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:120:10: ( pathExpr ( Pipe pathExpr )? )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:120:12: pathExpr ( Pipe pathExpr )?
            {
            pushFollow(FOLLOW_pathExpr_in_unionExpr622);
            pathExpr();

            state._fsp--;

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:120:21: ( Pipe pathExpr )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Pipe) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:120:22: Pipe pathExpr
                    {
                    match(input,Pipe,FOLLOW_Pipe_in_unionExpr625); 
                    pushFollow(FOLLOW_pathExpr_in_unionExpr627);
                    pathExpr();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "unionExpr"


    // $ANTLR start "literal"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:122:1: literal returns [String value] : ( StringLiteral | IntegerLiteral | DecimalLiteral | DoubleLiteral | VariableReference );
    public final String literal() throws RecognitionException {
        String value = null;

        CommonTree StringLiteral3=null;
        CommonTree IntegerLiteral4=null;
        CommonTree DecimalLiteral5=null;
        CommonTree DoubleLiteral6=null;
        CommonTree VariableReference7=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:123:5: ( StringLiteral | IntegerLiteral | DecimalLiteral | DoubleLiteral | VariableReference )
            int alt22=5;
            switch ( input.LA(1) ) {
            case StringLiteral:
                {
                alt22=1;
                }
                break;
            case IntegerLiteral:
                {
                alt22=2;
                }
                break;
            case DecimalLiteral:
                {
                alt22=3;
                }
                break;
            case DoubleLiteral:
                {
                alt22=4;
                }
                break;
            case VariableReference:
                {
                alt22=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:123:7: StringLiteral
                    {
                    StringLiteral3=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_literal646); 
                    value = (StringLiteral3!=null?StringLiteral3.getText():null); 

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:124:7: IntegerLiteral
                    {
                    IntegerLiteral4=(CommonTree)match(input,IntegerLiteral,FOLLOW_IntegerLiteral_in_literal657); 
                    value = (IntegerLiteral4!=null?IntegerLiteral4.getText():null); 

                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:125:7: DecimalLiteral
                    {
                    DecimalLiteral5=(CommonTree)match(input,DecimalLiteral,FOLLOW_DecimalLiteral_in_literal667); 
                    value = (DecimalLiteral5!=null?DecimalLiteral5.getText():null); 

                    }
                    break;
                case 4 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:126:7: DoubleLiteral
                    {
                    DoubleLiteral6=(CommonTree)match(input,DoubleLiteral,FOLLOW_DoubleLiteral_in_literal677); 
                    value = (DoubleLiteral6!=null?DoubleLiteral6.getText():null); 

                    }
                    break;
                case 5 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:127:7: VariableReference
                    {
                    VariableReference7=(CommonTree)match(input,VariableReference,FOLLOW_VariableReference_in_literal687); 
                    value = (VariableReference7!=null?VariableReference7.getText():null); 

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
        return value;
    }
    // $ANTLR end "literal"


    // $ANTLR start "qName"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:131:1: qName : ^( QNAME ( NCName )+ ) ;
    public final void qName() throws RecognitionException {
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:131:6: ( ^( QNAME ( NCName )+ ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:131:8: ^( QNAME ( NCName )+ )
            {
            match(input,QNAME,FOLLOW_QNAME_in_qName707); 

            match(input, Token.DOWN, null); 
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:131:16: ( NCName )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==NCName) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/GremlinTree.g:131:16: NCName
            	    {
            	    match(input,NCName,FOLLOW_NCName_in_qName709); 

            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            match(input, Token.UP, null); 

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
    // $ANTLR end "qName"

    // Delegated rules


 

    public static final BitSet FOLLOW_gpath_in_statement48 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_Newline_in_statement50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_foreach61 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARREF_in_foreach64 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VariableReference_in_foreach66 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FORSET_in_foreach70 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_gpath_in_foreach74 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOOPBODY_in_foreach78 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_gpath_in_foreach82 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GPATH_in_gpath96 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_xpath_in_gpath98 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GPATH_in_gpath106 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_functionCall_in_gpath108 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GPATH_in_gpath116 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_gpath118 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_locationPath_in_xpath132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relativeLocationPath_in_locationPath145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_absoluteLocationPath_in_locationPath154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SingleAxisStep_in_absoluteLocationPath176 = new BitSet(new long[]{0x0000069B00000012L});
    public static final BitSet FOLLOW_relativeLocationPath_in_absoluteLocationPath178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abbreviatedAbsoluteLocationPath_in_absoluteLocationPath187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RecursiveAxisStep_in_abbreviatedAbsoluteLocationPath199 = new BitSet(new long[]{0x0000069B00000010L});
    public static final BitSet FOLLOW_relativeLocationPath_in_abbreviatedAbsoluteLocationPath201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_step_in_relativeLocationPath214 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_simpleAxisStep_in_relativeLocationPath223 = new BitSet(new long[]{0x0000069B00000010L});
    public static final BitSet FOLLOW_step_in_relativeLocationPath225 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_namedAxisStep_in_step247 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_abbreviatedAxisStep_in_step251 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_predicate_in_step255 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_set_in_simpleAxisStep273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AbbreviatedStep_in_abbreviatedAxisStep305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_axisSpecifier_in_namedAxisStep313 = new BitSet(new long[]{0x0000069A00000010L});
    public static final BitSet FOLLOW_nodeTest_in_namedAxisStep316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AxisName_in_axisSpecifier330 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_AxisNameSeparator_in_axisSpecifier332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AbbreviatedAxisSpecifier_in_axisSpecifier341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameTest_in_nodeTest356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeType_in_nodeTest362 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_nodeTest364 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_nodeTest366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ProcessingInstruction_in_nodeTest372 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_nodeTest374 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_nodeTest376 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_nodeTest378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_nameTest394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NCName_in_nameTest403 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_Colon_in_nameTest405 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_Star_in_nameTest407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qName_in_nameTest416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_predicate428 = new BitSet(new long[]{0x003807BBD0002010L});
    public static final BitSet FOLLOW_predicateExpr_in_predicate430 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_predicate432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_predicateExpr440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCALL_in_functionCall452 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_qName_in_functionCall454 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_expressionList466 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_Comma_in_expressionList470 = new BitSet(new long[]{0x003807BBD0002010L});
    public static final BitSet FOLLOW_expr_in_expressionList472 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_locationPath_in_pathExpr487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filterExpr_in_pathExpr495 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_simpleAxisStep_in_pathExpr498 = new BitSet(new long[]{0x0000069B00000010L});
    public static final BitSet FOLLOW_relativeLocationPath_in_pathExpr501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpr_in_filterExpr515 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_predicate_in_filterExpr517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_primaryExpr530 = new BitSet(new long[]{0x003807BBD0002010L});
    public static final BitSet FOLLOW_expr_in_primaryExpr532 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_primaryExpr534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primaryExpr542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_primaryExpr550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpr_in_expr562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr569 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_Or_in_orExpr572 = new BitSet(new long[]{0x003807BBD0002010L});
    public static final BitSet FOLLOW_andExpr_in_orExpr574 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr583 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_And_in_andExpr586 = new BitSet(new long[]{0x003807BBD0002010L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr597 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_EqualtyOp_in_equalityExpr600 = new BitSet(new long[]{0x003807BBD0002010L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unionExpr_in_relationalExpr615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_unionExpr622 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_Pipe_in_unionExpr625 = new BitSet(new long[]{0x003807BBD0002010L});
    public static final BitSet FOLLOW_pathExpr_in_unionExpr627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerLiteral_in_literal657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DecimalLiteral_in_literal667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DoubleLiteral_in_literal677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VariableReference_in_literal687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QNAME_in_qName707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NCName_in_qName709 = new BitSet(new long[]{0x0000040000000008L});

}
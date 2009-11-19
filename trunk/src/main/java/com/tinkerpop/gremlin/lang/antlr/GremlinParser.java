// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g 2009-11-17 16:21:35

package com.tinkerpop.gremlin.lang.antlr;


import org.antlr.runtime.*;


import org.antlr.runtime.tree.*;

public class GremlinParser extends Parser {
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
    public static final int Letter=55;
    public static final int PREDICATE=12;
    public static final int Comma=46;
    public static final int ANY_NAMESPACED_NODE=21;
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
    public static final int Pipe=50;
    public static final int LOOPBODY=25;
    public static final int GPATH=22;
    public static final int LeftSquareBracket=44;
    public static final int Newline=26;
    public static final int EOF=-1;
    public static final int DecimalLiteral=52;
    public static final int AbbreviatedAxisSpecifier=35;
    public static final int VariableReference=28;
    public static final int ProcessingInstruction=39;
    public static final int ANY_NODE=20;
    public static final int NCName=42;
    public static final int For=54;
    public static final int FOREACH=23;

    // delegates
    // delegators


        public GremlinParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public GremlinParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return GremlinParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g"; }


    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:25:1: program : ( statement )+ ;
    public final GremlinParser.program_return program() throws RecognitionException {
        GremlinParser.program_return retval = new GremlinParser.program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.statement_return statement1 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:25:9: ( ( statement )+ )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:25:11: ( statement )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:25:11: ( statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=Foreach && LA1_0<=VariableReference)||(LA1_0>=SingleAxisStep && LA1_0<=AxisName)||(LA1_0>=AbbreviatedAxisSpecifier && LA1_0<=NodeType)||(LA1_0>=ProcessingInstruction && LA1_0<=NCName)||(LA1_0>=IntegerLiteral && LA1_0<=DoubleLiteral)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:25:11: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program138);
            	    statement1=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement1.getTree());

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

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:27:1: statement : ( gpath | foreach ) ( Newline )? ;
    public final GremlinParser.statement_return statement() throws RecognitionException {
        GremlinParser.statement_return retval = new GremlinParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Newline4=null;
        GremlinParser.gpath_return gpath2 = null;

        GremlinParser.foreach_return foreach3 = null;


        Object Newline4_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:27:11: ( ( gpath | foreach ) ( Newline )? )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:27:13: ( gpath | foreach ) ( Newline )?
            {
            root_0 = (Object)adaptor.nil();

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:27:13: ( gpath | foreach )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==VariableReference||(LA2_0>=SingleAxisStep && LA2_0<=AxisName)||(LA2_0>=AbbreviatedAxisSpecifier && LA2_0<=NodeType)||(LA2_0>=ProcessingInstruction && LA2_0<=NCName)||(LA2_0>=IntegerLiteral && LA2_0<=DoubleLiteral)) ) {
                alt2=1;
            }
            else if ( (LA2_0==Foreach) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:27:14: gpath
                    {
                    pushFollow(FOLLOW_gpath_in_statement149);
                    gpath2=gpath();

                    state._fsp--;

                    adaptor.addChild(root_0, gpath2.getTree());

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:27:22: foreach
                    {
                    pushFollow(FOLLOW_foreach_in_statement153);
                    foreach3=foreach();

                    state._fsp--;

                    adaptor.addChild(root_0, foreach3.getTree());

                    }
                    break;

            }

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:27:31: ( Newline )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Newline) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:27:31: Newline
                    {
                    Newline4=(Token)match(input,Newline,FOLLOW_Newline_in_statement156); 
                    Newline4_tree = (Object)adaptor.create(Newline4);
                    adaptor.addChild(root_0, Newline4_tree);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class foreach_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "foreach"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:29:1: foreach : Foreach VariableReference In set= gpath loop= gpath -> ^( FOREACH ^( VARREF VariableReference ) ^( FORSET $set) ^( LOOPBODY $loop) ) ;
    public final GremlinParser.foreach_return foreach() throws RecognitionException {
        GremlinParser.foreach_return retval = new GremlinParser.foreach_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Foreach5=null;
        Token VariableReference6=null;
        Token In7=null;
        GremlinParser.gpath_return set = null;

        GremlinParser.gpath_return loop = null;


        Object Foreach5_tree=null;
        Object VariableReference6_tree=null;
        Object In7_tree=null;
        RewriteRuleTokenStream stream_VariableReference=new RewriteRuleTokenStream(adaptor,"token VariableReference");
        RewriteRuleTokenStream stream_Foreach=new RewriteRuleTokenStream(adaptor,"token Foreach");
        RewriteRuleTokenStream stream_In=new RewriteRuleTokenStream(adaptor,"token In");
        RewriteRuleSubtreeStream stream_gpath=new RewriteRuleSubtreeStream(adaptor,"rule gpath");
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:29:9: ( Foreach VariableReference In set= gpath loop= gpath -> ^( FOREACH ^( VARREF VariableReference ) ^( FORSET $set) ^( LOOPBODY $loop) ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:29:11: Foreach VariableReference In set= gpath loop= gpath
            {
            Foreach5=(Token)match(input,Foreach,FOLLOW_Foreach_in_foreach166);  
            stream_Foreach.add(Foreach5);

            VariableReference6=(Token)match(input,VariableReference,FOLLOW_VariableReference_in_foreach168);  
            stream_VariableReference.add(VariableReference6);

            In7=(Token)match(input,In,FOLLOW_In_in_foreach170);  
            stream_In.add(In7);

            pushFollow(FOLLOW_gpath_in_foreach174);
            set=gpath();

            state._fsp--;

            stream_gpath.add(set.getTree());
            pushFollow(FOLLOW_gpath_in_foreach178);
            loop=gpath();

            state._fsp--;

            stream_gpath.add(loop.getTree());


            // AST REWRITE
            // elements: VariableReference, loop, set
            // token labels: 
            // rule labels: set, retval, loop
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_set=new RewriteRuleSubtreeStream(adaptor,"rule set",set!=null?set.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_loop=new RewriteRuleSubtreeStream(adaptor,"rule loop",loop!=null?loop.tree:null);

            root_0 = (Object)adaptor.nil();
            // 29:61: -> ^( FOREACH ^( VARREF VariableReference ) ^( FORSET $set) ^( LOOPBODY $loop) )
            {
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:29:64: ^( FOREACH ^( VARREF VariableReference ) ^( FORSET $set) ^( LOOPBODY $loop) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH, "FOREACH"), root_1);

                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:29:74: ^( VARREF VariableReference )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARREF, "VARREF"), root_2);

                adaptor.addChild(root_2, stream_VariableReference.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:29:102: ^( FORSET $set)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORSET, "FORSET"), root_2);

                adaptor.addChild(root_2, stream_set.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:29:117: ^( LOOPBODY $loop)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(LOOPBODY, "LOOPBODY"), root_2);

                adaptor.addChild(root_2, stream_loop.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "foreach"

    public static class gpath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gpath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:31:1: gpath : ( xpath -> ^( GPATH xpath ) | functionCall -> ^( GPATH functionCall ) | literal -> ^( GPATH literal ) );
    public final GremlinParser.gpath_return gpath() throws RecognitionException {
        GremlinParser.gpath_return retval = new GremlinParser.gpath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.xpath_return xpath8 = null;

        GremlinParser.functionCall_return functionCall9 = null;

        GremlinParser.literal_return literal10 = null;


        RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");
        RewriteRuleSubtreeStream stream_xpath=new RewriteRuleSubtreeStream(adaptor,"rule xpath");
        RewriteRuleSubtreeStream stream_functionCall=new RewriteRuleSubtreeStream(adaptor,"rule functionCall");
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:31:7: ( xpath -> ^( GPATH xpath ) | functionCall -> ^( GPATH functionCall ) | literal -> ^( GPATH literal ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case SingleAxisStep:
            case RecursiveAxisStep:
            case AbbreviatedStep:
            case AxisName:
            case AbbreviatedAxisSpecifier:
            case NodeType:
            case ProcessingInstruction:
            case Star:
                {
                alt4=1;
                }
                break;
            case NCName:
                {
                switch ( input.LA(2) ) {
                case Colon:
                    {
                    int LA4_4 = input.LA(3);

                    if ( (LA4_4==Star) ) {
                        alt4=1;
                    }
                    else if ( (LA4_4==NCName) ) {
                        int LA4_6 = input.LA(4);

                        if ( (LA4_6==LeftParenthesis) ) {
                            alt4=2;
                        }
                        else if ( (LA4_6==EOF||(LA4_6>=Newline && LA4_6<=VariableReference)||(LA4_6>=SingleAxisStep && LA4_6<=AxisName)||(LA4_6>=AbbreviatedAxisSpecifier && LA4_6<=NodeType)||(LA4_6>=ProcessingInstruction && LA4_6<=NCName)||LA4_6==LeftSquareBracket||(LA4_6>=IntegerLiteral && LA4_6<=DoubleLiteral)) ) {
                            alt4=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case LeftParenthesis:
                    {
                    alt4=2;
                    }
                    break;
                case EOF:
                case Newline:
                case Foreach:
                case VariableReference:
                case SingleAxisStep:
                case RecursiveAxisStep:
                case AbbreviatedStep:
                case AxisName:
                case AbbreviatedAxisSpecifier:
                case NodeType:
                case ProcessingInstruction:
                case StringLiteral:
                case Star:
                case NCName:
                case LeftSquareBracket:
                case IntegerLiteral:
                case DecimalLiteral:
                case DoubleLiteral:
                    {
                    alt4=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }

                }
                break;
            case VariableReference:
            case StringLiteral:
            case IntegerLiteral:
            case DecimalLiteral:
            case DoubleLiteral:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:31:9: xpath
                    {
                    pushFollow(FOLLOW_xpath_in_gpath213);
                    xpath8=xpath();

                    state._fsp--;

                    stream_xpath.add(xpath8.getTree());


                    // AST REWRITE
                    // elements: xpath
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 31:16: -> ^( GPATH xpath )
                    {
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:31:19: ^( GPATH xpath )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GPATH, "GPATH"), root_1);

                        adaptor.addChild(root_1, stream_xpath.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:32:4: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_gpath227);
                    functionCall9=functionCall();

                    state._fsp--;

                    stream_functionCall.add(functionCall9.getTree());


                    // AST REWRITE
                    // elements: functionCall
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 32:18: -> ^( GPATH functionCall )
                    {
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:32:21: ^( GPATH functionCall )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GPATH, "GPATH"), root_1);

                        adaptor.addChild(root_1, stream_functionCall.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:33:4: literal
                    {
                    pushFollow(FOLLOW_literal_in_gpath241);
                    literal10=literal();

                    state._fsp--;

                    stream_literal.add(literal10.getTree());


                    // AST REWRITE
                    // elements: literal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 33:14: -> ^( GPATH literal )
                    {
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:33:17: ^( GPATH literal )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GPATH, "GPATH"), root_1);

                        adaptor.addChild(root_1, stream_literal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gpath"

    public static class xpath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xpath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:36:1: xpath : locationPath ;
    public final GremlinParser.xpath_return xpath() throws RecognitionException {
        GremlinParser.xpath_return retval = new GremlinParser.xpath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.locationPath_return locationPath11 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:36:6: ( locationPath )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:36:8: locationPath
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_locationPath_in_xpath260);
            locationPath11=locationPath();

            state._fsp--;

            adaptor.addChild(root_0, locationPath11.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "xpath"

    public static class locationPath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "locationPath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:38:1: locationPath : ( relativeLocationPath | absoluteLocationPath );
    public final GremlinParser.locationPath_return locationPath() throws RecognitionException {
        GremlinParser.locationPath_return retval = new GremlinParser.locationPath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.relativeLocationPath_return relativeLocationPath12 = null;

        GremlinParser.absoluteLocationPath_return absoluteLocationPath13 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:39:5: ( relativeLocationPath | absoluteLocationPath )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=AbbreviatedStep && LA5_0<=AxisName)||(LA5_0>=AbbreviatedAxisSpecifier && LA5_0<=NodeType)||LA5_0==ProcessingInstruction||(LA5_0>=Star && LA5_0<=NCName)) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=SingleAxisStep && LA5_0<=RecursiveAxisStep)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:39:7: relativeLocationPath
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_relativeLocationPath_in_locationPath273);
                    relativeLocationPath12=relativeLocationPath();

                    state._fsp--;

                    adaptor.addChild(root_0, relativeLocationPath12.getTree());

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:40:7: absoluteLocationPath
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_absoluteLocationPath_in_locationPath282);
                    absoluteLocationPath13=absoluteLocationPath();

                    state._fsp--;

                    adaptor.addChild(root_0, absoluteLocationPath13.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "locationPath"

    public static class absoluteLocationPath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "absoluteLocationPath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:43:1: absoluteLocationPath : ( SingleAxisStep ( relativeLocationPath )? | abbreviatedAbsoluteLocationPath );
    public final GremlinParser.absoluteLocationPath_return absoluteLocationPath() throws RecognitionException {
        GremlinParser.absoluteLocationPath_return retval = new GremlinParser.absoluteLocationPath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SingleAxisStep14=null;
        GremlinParser.relativeLocationPath_return relativeLocationPath15 = null;

        GremlinParser.abbreviatedAbsoluteLocationPath_return abbreviatedAbsoluteLocationPath16 = null;


        Object SingleAxisStep14_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:44:5: ( SingleAxisStep ( relativeLocationPath )? | abbreviatedAbsoluteLocationPath )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==SingleAxisStep) ) {
                alt7=1;
            }
            else if ( (LA7_0==RecursiveAxisStep) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:44:7: SingleAxisStep ( relativeLocationPath )?
                    {
                    root_0 = (Object)adaptor.nil();

                    SingleAxisStep14=(Token)match(input,SingleAxisStep,FOLLOW_SingleAxisStep_in_absoluteLocationPath304); 
                    SingleAxisStep14_tree = (Object)adaptor.create(SingleAxisStep14);
                    adaptor.addChild(root_0, SingleAxisStep14_tree);

                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:44:22: ( relativeLocationPath )?
                    int alt6=2;
                    alt6 = dfa6.predict(input);
                    switch (alt6) {
                        case 1 :
                            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:44:22: relativeLocationPath
                            {
                            pushFollow(FOLLOW_relativeLocationPath_in_absoluteLocationPath306);
                            relativeLocationPath15=relativeLocationPath();

                            state._fsp--;

                            adaptor.addChild(root_0, relativeLocationPath15.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:45:7: abbreviatedAbsoluteLocationPath
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_abbreviatedAbsoluteLocationPath_in_absoluteLocationPath315);
                    abbreviatedAbsoluteLocationPath16=abbreviatedAbsoluteLocationPath();

                    state._fsp--;

                    adaptor.addChild(root_0, abbreviatedAbsoluteLocationPath16.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "absoluteLocationPath"

    public static class abbreviatedAbsoluteLocationPath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "abbreviatedAbsoluteLocationPath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:48:1: abbreviatedAbsoluteLocationPath : RecursiveAxisStep relativeLocationPath ;
    public final GremlinParser.abbreviatedAbsoluteLocationPath_return abbreviatedAbsoluteLocationPath() throws RecognitionException {
        GremlinParser.abbreviatedAbsoluteLocationPath_return retval = new GremlinParser.abbreviatedAbsoluteLocationPath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RecursiveAxisStep17=null;
        GremlinParser.relativeLocationPath_return relativeLocationPath18 = null;


        Object RecursiveAxisStep17_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:48:32: ( RecursiveAxisStep relativeLocationPath )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:48:34: RecursiveAxisStep relativeLocationPath
            {
            root_0 = (Object)adaptor.nil();

            RecursiveAxisStep17=(Token)match(input,RecursiveAxisStep,FOLLOW_RecursiveAxisStep_in_abbreviatedAbsoluteLocationPath327); 
            RecursiveAxisStep17_tree = (Object)adaptor.create(RecursiveAxisStep17);
            adaptor.addChild(root_0, RecursiveAxisStep17_tree);

            pushFollow(FOLLOW_relativeLocationPath_in_abbreviatedAbsoluteLocationPath329);
            relativeLocationPath18=relativeLocationPath();

            state._fsp--;

            adaptor.addChild(root_0, relativeLocationPath18.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "abbreviatedAbsoluteLocationPath"

    public static class relativeLocationPath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relativeLocationPath"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:50:1: relativeLocationPath : step ( simpleAxisStep step )* ;
    public final GremlinParser.relativeLocationPath_return relativeLocationPath() throws RecognitionException {
        GremlinParser.relativeLocationPath_return retval = new GremlinParser.relativeLocationPath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.step_return step19 = null;

        GremlinParser.simpleAxisStep_return simpleAxisStep20 = null;

        GremlinParser.step_return step21 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:51:5: ( step ( simpleAxisStep step )* )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:51:7: step ( simpleAxisStep step )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_step_in_relativeLocationPath342);
            step19=step();

            state._fsp--;

            adaptor.addChild(root_0, step19.getTree());
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:52:5: ( simpleAxisStep step )*
            loop8:
            do {
                int alt8=2;
                alt8 = dfa8.predict(input);
                switch (alt8) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:52:7: simpleAxisStep step
            	    {
            	    pushFollow(FOLLOW_simpleAxisStep_in_relativeLocationPath351);
            	    simpleAxisStep20=simpleAxisStep();

            	    state._fsp--;

            	    adaptor.addChild(root_0, simpleAxisStep20.getTree());
            	    pushFollow(FOLLOW_step_in_relativeLocationPath353);
            	    step21=step();

            	    state._fsp--;

            	    adaptor.addChild(root_0, step21.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relativeLocationPath"

    public static class step_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "step"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:55:1: step : ( namedAxisStep | abbreviatedAxisStep ) ( predicate )* ;
    public final GremlinParser.step_return step() throws RecognitionException {
        GremlinParser.step_return retval = new GremlinParser.step_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.namedAxisStep_return namedAxisStep22 = null;

        GremlinParser.abbreviatedAxisStep_return abbreviatedAxisStep23 = null;

        GremlinParser.predicate_return predicate24 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:56:5: ( ( namedAxisStep | abbreviatedAxisStep ) ( predicate )* )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:56:7: ( namedAxisStep | abbreviatedAxisStep ) ( predicate )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:56:7: ( namedAxisStep | abbreviatedAxisStep )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==AxisName||(LA9_0>=AbbreviatedAxisSpecifier && LA9_0<=NodeType)||LA9_0==ProcessingInstruction||(LA9_0>=Star && LA9_0<=NCName)) ) {
                alt9=1;
            }
            else if ( (LA9_0==AbbreviatedStep) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:56:9: namedAxisStep
                    {
                    pushFollow(FOLLOW_namedAxisStep_in_step375);
                    namedAxisStep22=namedAxisStep();

                    state._fsp--;

                    adaptor.addChild(root_0, namedAxisStep22.getTree());

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:56:25: abbreviatedAxisStep
                    {
                    pushFollow(FOLLOW_abbreviatedAxisStep_in_step379);
                    abbreviatedAxisStep23=abbreviatedAxisStep();

                    state._fsp--;

                    adaptor.addChild(root_0, abbreviatedAxisStep23.getTree());

                    }
                    break;

            }

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:56:47: ( predicate )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==LeftSquareBracket) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:56:47: predicate
            	    {
            	    pushFollow(FOLLOW_predicate_in_step383);
            	    predicate24=predicate();

            	    state._fsp--;

            	    adaptor.addChild(root_0, predicate24.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "step"

    public static class simpleAxisStep_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simpleAxisStep"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:59:1: simpleAxisStep : ( SingleAxisStep | RecursiveAxisStep ) ;
    public final GremlinParser.simpleAxisStep_return simpleAxisStep() throws RecognitionException {
        GremlinParser.simpleAxisStep_return retval = new GremlinParser.simpleAxisStep_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set25=null;

        Object set25_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:60:5: ( ( SingleAxisStep | RecursiveAxisStep ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:60:7: ( SingleAxisStep | RecursiveAxisStep )
            {
            root_0 = (Object)adaptor.nil();

            set25=(Token)input.LT(1);
            if ( (input.LA(1)>=SingleAxisStep && input.LA(1)<=RecursiveAxisStep) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set25));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "simpleAxisStep"

    public static class abbreviatedAxisStep_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "abbreviatedAxisStep"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:65:1: abbreviatedAxisStep : AbbreviatedStep ;
    public final GremlinParser.abbreviatedAxisStep_return abbreviatedAxisStep() throws RecognitionException {
        GremlinParser.abbreviatedAxisStep_return retval = new GremlinParser.abbreviatedAxisStep_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AbbreviatedStep26=null;

        Object AbbreviatedStep26_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:66:5: ( AbbreviatedStep )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:66:7: AbbreviatedStep
            {
            root_0 = (Object)adaptor.nil();

            AbbreviatedStep26=(Token)match(input,AbbreviatedStep,FOLLOW_AbbreviatedStep_in_abbreviatedAxisStep443); 
            AbbreviatedStep26_tree = (Object)adaptor.create(AbbreviatedStep26);
            adaptor.addChild(root_0, AbbreviatedStep26_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "abbreviatedAxisStep"

    public static class namedAxisStep_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "namedAxisStep"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:68:1: namedAxisStep : ( ( axisSpecifier )? nodeTest ) ;
    public final GremlinParser.namedAxisStep_return namedAxisStep() throws RecognitionException {
        GremlinParser.namedAxisStep_return retval = new GremlinParser.namedAxisStep_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.axisSpecifier_return axisSpecifier27 = null;

        GremlinParser.nodeTest_return nodeTest28 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:69:5: ( ( ( axisSpecifier )? nodeTest ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:69:7: ( ( axisSpecifier )? nodeTest )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:69:7: ( ( axisSpecifier )? nodeTest )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:69:8: ( axisSpecifier )? nodeTest
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:69:8: ( axisSpecifier )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==AxisName||LA11_0==AbbreviatedAxisSpecifier) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:69:8: axisSpecifier
                    {
                    pushFollow(FOLLOW_axisSpecifier_in_namedAxisStep457);
                    axisSpecifier27=axisSpecifier();

                    state._fsp--;

                    adaptor.addChild(root_0, axisSpecifier27.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_nodeTest_in_namedAxisStep460);
            nodeTest28=nodeTest();

            state._fsp--;

            adaptor.addChild(root_0, nodeTest28.getTree());

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "namedAxisStep"

    public static class axisSpecifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "axisSpecifier"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:71:1: axisSpecifier : ( AxisName AxisNameSeparator | AbbreviatedAxisSpecifier );
    public final GremlinParser.axisSpecifier_return axisSpecifier() throws RecognitionException {
        GremlinParser.axisSpecifier_return retval = new GremlinParser.axisSpecifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AxisName29=null;
        Token AxisNameSeparator30=null;
        Token AbbreviatedAxisSpecifier31=null;

        Object AxisName29_tree=null;
        Object AxisNameSeparator30_tree=null;
        Object AbbreviatedAxisSpecifier31_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:72:5: ( AxisName AxisNameSeparator | AbbreviatedAxisSpecifier )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==AxisName) ) {
                alt12=1;
            }
            else if ( (LA12_0==AbbreviatedAxisSpecifier) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:72:7: AxisName AxisNameSeparator
                    {
                    root_0 = (Object)adaptor.nil();

                    AxisName29=(Token)match(input,AxisName,FOLLOW_AxisName_in_axisSpecifier474); 
                    AxisName29_tree = (Object)adaptor.create(AxisName29);
                    adaptor.addChild(root_0, AxisName29_tree);

                    AxisNameSeparator30=(Token)match(input,AxisNameSeparator,FOLLOW_AxisNameSeparator_in_axisSpecifier476); 
                    AxisNameSeparator30_tree = (Object)adaptor.create(AxisNameSeparator30);
                    adaptor.addChild(root_0, AxisNameSeparator30_tree);


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:73:7: AbbreviatedAxisSpecifier
                    {
                    root_0 = (Object)adaptor.nil();

                    AbbreviatedAxisSpecifier31=(Token)match(input,AbbreviatedAxisSpecifier,FOLLOW_AbbreviatedAxisSpecifier_in_axisSpecifier485); 
                    AbbreviatedAxisSpecifier31_tree = (Object)adaptor.create(AbbreviatedAxisSpecifier31);
                    adaptor.addChild(root_0, AbbreviatedAxisSpecifier31_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "axisSpecifier"

    public static class nodeTest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeTest"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:76:1: nodeTest : ( nameTest | NodeType LeftParenthesis RightParenthesis | ProcessingInstruction LeftParenthesis StringLiteral RightParenthesis );
    public final GremlinParser.nodeTest_return nodeTest() throws RecognitionException {
        GremlinParser.nodeTest_return retval = new GremlinParser.nodeTest_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeType33=null;
        Token LeftParenthesis34=null;
        Token RightParenthesis35=null;
        Token ProcessingInstruction36=null;
        Token LeftParenthesis37=null;
        Token StringLiteral38=null;
        Token RightParenthesis39=null;
        GremlinParser.nameTest_return nameTest32 = null;


        Object NodeType33_tree=null;
        Object LeftParenthesis34_tree=null;
        Object RightParenthesis35_tree=null;
        Object ProcessingInstruction36_tree=null;
        Object LeftParenthesis37_tree=null;
        Object StringLiteral38_tree=null;
        Object RightParenthesis39_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:77:2: ( nameTest | NodeType LeftParenthesis RightParenthesis | ProcessingInstruction LeftParenthesis StringLiteral RightParenthesis )
            int alt13=3;
            switch ( input.LA(1) ) {
            case Star:
            case NCName:
                {
                alt13=1;
                }
                break;
            case NodeType:
                {
                alt13=2;
                }
                break;
            case ProcessingInstruction:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:77:4: nameTest
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nameTest_in_nodeTest500);
                    nameTest32=nameTest();

                    state._fsp--;

                    adaptor.addChild(root_0, nameTest32.getTree());

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:78:4: NodeType LeftParenthesis RightParenthesis
                    {
                    root_0 = (Object)adaptor.nil();

                    NodeType33=(Token)match(input,NodeType,FOLLOW_NodeType_in_nodeTest506); 
                    NodeType33_tree = (Object)adaptor.create(NodeType33);
                    adaptor.addChild(root_0, NodeType33_tree);

                    LeftParenthesis34=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_nodeTest508); 
                    LeftParenthesis34_tree = (Object)adaptor.create(LeftParenthesis34);
                    adaptor.addChild(root_0, LeftParenthesis34_tree);

                    RightParenthesis35=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_nodeTest510); 
                    RightParenthesis35_tree = (Object)adaptor.create(RightParenthesis35);
                    adaptor.addChild(root_0, RightParenthesis35_tree);


                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:79:4: ProcessingInstruction LeftParenthesis StringLiteral RightParenthesis
                    {
                    root_0 = (Object)adaptor.nil();

                    ProcessingInstruction36=(Token)match(input,ProcessingInstruction,FOLLOW_ProcessingInstruction_in_nodeTest516); 
                    ProcessingInstruction36_tree = (Object)adaptor.create(ProcessingInstruction36);
                    adaptor.addChild(root_0, ProcessingInstruction36_tree);

                    LeftParenthesis37=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_nodeTest518); 
                    LeftParenthesis37_tree = (Object)adaptor.create(LeftParenthesis37);
                    adaptor.addChild(root_0, LeftParenthesis37_tree);

                    StringLiteral38=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_nodeTest520); 
                    StringLiteral38_tree = (Object)adaptor.create(StringLiteral38);
                    adaptor.addChild(root_0, StringLiteral38_tree);

                    RightParenthesis39=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_nodeTest522); 
                    RightParenthesis39_tree = (Object)adaptor.create(RightParenthesis39);
                    adaptor.addChild(root_0, RightParenthesis39_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nodeTest"

    public static class nameTest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nameTest"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:82:1: nameTest : ( Star -> ^( ANY_NODE ) | NCName Colon Star -> ^( ANY_NAMESPACED_NODE NCName ) | qName );
    public final GremlinParser.nameTest_return nameTest() throws RecognitionException {
        GremlinParser.nameTest_return retval = new GremlinParser.nameTest_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Star40=null;
        Token NCName41=null;
        Token Colon42=null;
        Token Star43=null;
        GremlinParser.qName_return qName44 = null;


        Object Star40_tree=null;
        Object NCName41_tree=null;
        Object Colon42_tree=null;
        Object Star43_tree=null;
        RewriteRuleTokenStream stream_NCName=new RewriteRuleTokenStream(adaptor,"token NCName");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:83:5: ( Star -> ^( ANY_NODE ) | NCName Colon Star -> ^( ANY_NAMESPACED_NODE NCName ) | qName )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Star) ) {
                alt14=1;
            }
            else if ( (LA14_0==NCName) ) {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==Colon) ) {
                    int LA14_3 = input.LA(3);

                    if ( (LA14_3==Star) ) {
                        alt14=2;
                    }
                    else if ( (LA14_3==NCName) ) {
                        alt14=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA14_2==EOF||(LA14_2>=Newline && LA14_2<=VariableReference)||(LA14_2>=SingleAxisStep && LA14_2<=AxisName)||(LA14_2>=AbbreviatedAxisSpecifier && LA14_2<=NodeType)||(LA14_2>=RightParenthesis && LA14_2<=NCName)||(LA14_2>=LeftSquareBracket && LA14_2<=DoubleLiteral)) ) {
                    alt14=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:83:7: Star
                    {
                    Star40=(Token)match(input,Star,FOLLOW_Star_in_nameTest538);  
                    stream_Star.add(Star40);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 83:12: -> ^( ANY_NODE )
                    {
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:83:15: ^( ANY_NODE )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ANY_NODE, "ANY_NODE"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:84:7: NCName Colon Star
                    {
                    NCName41=(Token)match(input,NCName,FOLLOW_NCName_in_nameTest552);  
                    stream_NCName.add(NCName41);

                    Colon42=(Token)match(input,Colon,FOLLOW_Colon_in_nameTest554);  
                    stream_Colon.add(Colon42);

                    Star43=(Token)match(input,Star,FOLLOW_Star_in_nameTest556);  
                    stream_Star.add(Star43);



                    // AST REWRITE
                    // elements: NCName
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 84:25: -> ^( ANY_NAMESPACED_NODE NCName )
                    {
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:84:28: ^( ANY_NAMESPACED_NODE NCName )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ANY_NAMESPACED_NODE, "ANY_NAMESPACED_NODE"), root_1);

                        adaptor.addChild(root_1, stream_NCName.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:85:7: qName
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_qName_in_nameTest572);
                    qName44=qName();

                    state._fsp--;

                    adaptor.addChild(root_0, qName44.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nameTest"

    public static class predicate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:88:1: predicate : LeftSquareBracket predicateExpr RightSquareBracket -> ^( PREDICATE predicateExpr ) ;
    public final GremlinParser.predicate_return predicate() throws RecognitionException {
        GremlinParser.predicate_return retval = new GremlinParser.predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LeftSquareBracket45=null;
        Token RightSquareBracket47=null;
        GremlinParser.predicateExpr_return predicateExpr46 = null;


        Object LeftSquareBracket45_tree=null;
        Object RightSquareBracket47_tree=null;
        RewriteRuleTokenStream stream_RightSquareBracket=new RewriteRuleTokenStream(adaptor,"token RightSquareBracket");
        RewriteRuleTokenStream stream_LeftSquareBracket=new RewriteRuleTokenStream(adaptor,"token LeftSquareBracket");
        RewriteRuleSubtreeStream stream_predicateExpr=new RewriteRuleSubtreeStream(adaptor,"rule predicateExpr");
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:89:5: ( LeftSquareBracket predicateExpr RightSquareBracket -> ^( PREDICATE predicateExpr ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:89:7: LeftSquareBracket predicateExpr RightSquareBracket
            {
            LeftSquareBracket45=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_predicate589);  
            stream_LeftSquareBracket.add(LeftSquareBracket45);

            pushFollow(FOLLOW_predicateExpr_in_predicate591);
            predicateExpr46=predicateExpr();

            state._fsp--;

            stream_predicateExpr.add(predicateExpr46.getTree());
            RightSquareBracket47=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_predicate593);  
            stream_RightSquareBracket.add(RightSquareBracket47);



            // AST REWRITE
            // elements: predicateExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 89:58: -> ^( PREDICATE predicateExpr )
            {
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:89:61: ^( PREDICATE predicateExpr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PREDICATE, "PREDICATE"), root_1);

                adaptor.addChild(root_1, stream_predicateExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicate"

    public static class predicateExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicateExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:92:1: predicateExpr : expr ;
    public final GremlinParser.predicateExpr_return predicateExpr() throws RecognitionException {
        GremlinParser.predicateExpr_return retval = new GremlinParser.predicateExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.expr_return expr48 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:92:15: ( expr )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:92:17: expr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expr_in_predicateExpr614);
            expr48=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr48.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicateExpr"

    public static class functionCall_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionCall"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:94:1: functionCall : qName LeftParenthesis ( expressionList )? RightParenthesis -> ^( FUNCALL qName ( expressionList )? ) ;
    public final GremlinParser.functionCall_return functionCall() throws RecognitionException {
        GremlinParser.functionCall_return retval = new GremlinParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LeftParenthesis50=null;
        Token RightParenthesis52=null;
        GremlinParser.qName_return qName49 = null;

        GremlinParser.expressionList_return expressionList51 = null;


        Object LeftParenthesis50_tree=null;
        Object RightParenthesis52_tree=null;
        RewriteRuleTokenStream stream_RightParenthesis=new RewriteRuleTokenStream(adaptor,"token RightParenthesis");
        RewriteRuleTokenStream stream_LeftParenthesis=new RewriteRuleTokenStream(adaptor,"token LeftParenthesis");
        RewriteRuleSubtreeStream stream_qName=new RewriteRuleSubtreeStream(adaptor,"rule qName");
        RewriteRuleSubtreeStream stream_expressionList=new RewriteRuleSubtreeStream(adaptor,"rule expressionList");
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:95:2: ( qName LeftParenthesis ( expressionList )? RightParenthesis -> ^( FUNCALL qName ( expressionList )? ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:95:4: qName LeftParenthesis ( expressionList )? RightParenthesis
            {
            pushFollow(FOLLOW_qName_in_functionCall627);
            qName49=qName();

            state._fsp--;

            stream_qName.add(qName49.getTree());
            LeftParenthesis50=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_functionCall629);  
            stream_LeftParenthesis.add(LeftParenthesis50);

            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:96:4: ( expressionList )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==VariableReference||(LA15_0>=SingleAxisStep && LA15_0<=AxisName)||(LA15_0>=AbbreviatedAxisSpecifier && LA15_0<=LeftParenthesis)||(LA15_0>=ProcessingInstruction && LA15_0<=NCName)||(LA15_0>=IntegerLiteral && LA15_0<=DoubleLiteral)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:96:4: expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_functionCall634);
                    expressionList51=expressionList();

                    state._fsp--;

                    stream_expressionList.add(expressionList51.getTree());

                    }
                    break;

            }

            RightParenthesis52=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_functionCall641);  
            stream_RightParenthesis.add(RightParenthesis52);



            // AST REWRITE
            // elements: qName, expressionList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 97:21: -> ^( FUNCALL qName ( expressionList )? )
            {
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:97:24: ^( FUNCALL qName ( expressionList )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCALL, "FUNCALL"), root_1);

                adaptor.addChild(root_1, stream_qName.nextTree());
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:97:40: ( expressionList )?
                if ( stream_expressionList.hasNext() ) {
                    adaptor.addChild(root_1, stream_expressionList.nextTree());

                }
                stream_expressionList.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionCall"

    public static class expressionList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expressionList"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:100:1: expressionList : expr ( Comma expr )* -> ^( EXPRLIST ( expr )+ ) ;
    public final GremlinParser.expressionList_return expressionList() throws RecognitionException {
        GremlinParser.expressionList_return retval = new GremlinParser.expressionList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma54=null;
        GremlinParser.expr_return expr53 = null;

        GremlinParser.expr_return expr55 = null;


        Object Comma54_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:101:5: ( expr ( Comma expr )* -> ^( EXPRLIST ( expr )+ ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:101:7: expr ( Comma expr )*
            {
            pushFollow(FOLLOW_expr_in_expressionList667);
            expr53=expr();

            state._fsp--;

            stream_expr.add(expr53.getTree());
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:101:12: ( Comma expr )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==Comma) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:101:14: Comma expr
            	    {
            	    Comma54=(Token)match(input,Comma,FOLLOW_Comma_in_expressionList671);  
            	    stream_Comma.add(Comma54);

            	    pushFollow(FOLLOW_expr_in_expressionList673);
            	    expr55=expr();

            	    state._fsp--;

            	    stream_expr.add(expr55.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 101:28: -> ^( EXPRLIST ( expr )+ )
            {
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:101:31: ^( EXPRLIST ( expr )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRLIST, "EXPRLIST"), root_1);

                if ( !(stream_expr.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_expr.hasNext() ) {
                    adaptor.addChild(root_1, stream_expr.nextTree());

                }
                stream_expr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expressionList"

    public static class pathExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pathExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:104:1: pathExpr : ( locationPath | filterExpr ( simpleAxisStep relativeLocationPath )? );
    public final GremlinParser.pathExpr_return pathExpr() throws RecognitionException {
        GremlinParser.pathExpr_return retval = new GremlinParser.pathExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.locationPath_return locationPath56 = null;

        GremlinParser.filterExpr_return filterExpr57 = null;

        GremlinParser.simpleAxisStep_return simpleAxisStep58 = null;

        GremlinParser.relativeLocationPath_return relativeLocationPath59 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:105:5: ( locationPath | filterExpr ( simpleAxisStep relativeLocationPath )? )
            int alt18=2;
            switch ( input.LA(1) ) {
            case SingleAxisStep:
            case RecursiveAxisStep:
            case AbbreviatedStep:
            case AxisName:
            case AbbreviatedAxisSpecifier:
            case NodeType:
            case ProcessingInstruction:
            case Star:
                {
                alt18=1;
                }
                break;
            case NCName:
                {
                switch ( input.LA(2) ) {
                case Colon:
                    {
                    int LA18_4 = input.LA(3);

                    if ( (LA18_4==Star) ) {
                        alt18=1;
                    }
                    else if ( (LA18_4==NCName) ) {
                        int LA18_5 = input.LA(4);

                        if ( (LA18_5==LeftParenthesis) ) {
                            alt18=2;
                        }
                        else if ( ((LA18_5>=SingleAxisStep && LA18_5<=RecursiveAxisStep)||LA18_5==RightParenthesis||(LA18_5>=LeftSquareBracket && LA18_5<=Pipe)) ) {
                            alt18=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case LeftParenthesis:
                    {
                    alt18=2;
                    }
                    break;
                case SingleAxisStep:
                case RecursiveAxisStep:
                case RightParenthesis:
                case LeftSquareBracket:
                case RightSquareBracket:
                case Comma:
                case Or:
                case And:
                case EqualtyOp:
                case Pipe:
                    {
                    alt18=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;
                }

                }
                break;
            case VariableReference:
            case LeftParenthesis:
            case StringLiteral:
            case IntegerLiteral:
            case DecimalLiteral:
            case DoubleLiteral:
                {
                alt18=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:105:7: locationPath
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_locationPath_in_pathExpr703);
                    locationPath56=locationPath();

                    state._fsp--;

                    adaptor.addChild(root_0, locationPath56.getTree());

                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:106:7: filterExpr ( simpleAxisStep relativeLocationPath )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_filterExpr_in_pathExpr711);
                    filterExpr57=filterExpr();

                    state._fsp--;

                    adaptor.addChild(root_0, filterExpr57.getTree());
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:106:18: ( simpleAxisStep relativeLocationPath )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( ((LA17_0>=SingleAxisStep && LA17_0<=RecursiveAxisStep)) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:106:19: simpleAxisStep relativeLocationPath
                            {
                            pushFollow(FOLLOW_simpleAxisStep_in_pathExpr714);
                            simpleAxisStep58=simpleAxisStep();

                            state._fsp--;

                            adaptor.addChild(root_0, simpleAxisStep58.getTree());
                            pushFollow(FOLLOW_relativeLocationPath_in_pathExpr717);
                            relativeLocationPath59=relativeLocationPath();

                            state._fsp--;

                            adaptor.addChild(root_0, relativeLocationPath59.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pathExpr"

    public static class filterExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "filterExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:109:1: filterExpr : primaryExpr ( predicate )? ;
    public final GremlinParser.filterExpr_return filterExpr() throws RecognitionException {
        GremlinParser.filterExpr_return retval = new GremlinParser.filterExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.primaryExpr_return primaryExpr60 = null;

        GremlinParser.predicate_return predicate61 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:109:11: ( primaryExpr ( predicate )? )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:109:13: primaryExpr ( predicate )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_primaryExpr_in_filterExpr731);
            primaryExpr60=primaryExpr();

            state._fsp--;

            adaptor.addChild(root_0, primaryExpr60.getTree());
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:109:25: ( predicate )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LeftSquareBracket) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:109:25: predicate
                    {
                    pushFollow(FOLLOW_predicate_in_filterExpr733);
                    predicate61=predicate();

                    state._fsp--;

                    adaptor.addChild(root_0, predicate61.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "filterExpr"

    public static class primaryExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primaryExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:111:1: primaryExpr : ( LeftParenthesis expr RightParenthesis | literal | functionCall );
    public final GremlinParser.primaryExpr_return primaryExpr() throws RecognitionException {
        GremlinParser.primaryExpr_return retval = new GremlinParser.primaryExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LeftParenthesis62=null;
        Token RightParenthesis64=null;
        GremlinParser.expr_return expr63 = null;

        GremlinParser.literal_return literal65 = null;

        GremlinParser.functionCall_return functionCall66 = null;


        Object LeftParenthesis62_tree=null;
        Object RightParenthesis64_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:112:5: ( LeftParenthesis expr RightParenthesis | literal | functionCall )
            int alt20=3;
            switch ( input.LA(1) ) {
            case LeftParenthesis:
                {
                alt20=1;
                }
                break;
            case VariableReference:
            case StringLiteral:
            case IntegerLiteral:
            case DecimalLiteral:
            case DoubleLiteral:
                {
                alt20=2;
                }
                break;
            case NCName:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:112:7: LeftParenthesis expr RightParenthesis
                    {
                    root_0 = (Object)adaptor.nil();

                    LeftParenthesis62=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_primaryExpr746); 
                    LeftParenthesis62_tree = (Object)adaptor.create(LeftParenthesis62);
                    adaptor.addChild(root_0, LeftParenthesis62_tree);

                    pushFollow(FOLLOW_expr_in_primaryExpr748);
                    expr63=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr63.getTree());
                    RightParenthesis64=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_primaryExpr750); 
                    RightParenthesis64_tree = (Object)adaptor.create(RightParenthesis64);
                    adaptor.addChild(root_0, RightParenthesis64_tree);


                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:113:7: literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primaryExpr758);
                    literal65=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, literal65.getTree());

                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:114:7: functionCall
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionCall_in_primaryExpr766);
                    functionCall66=functionCall();

                    state._fsp--;

                    adaptor.addChild(root_0, functionCall66.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "primaryExpr"

    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:117:1: expr : orExpr ;
    public final GremlinParser.expr_return expr() throws RecognitionException {
        GremlinParser.expr_return retval = new GremlinParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.orExpr_return orExpr67 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:117:5: ( orExpr )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:117:7: orExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_orExpr_in_expr778);
            orExpr67=orExpr();

            state._fsp--;

            adaptor.addChild(root_0, orExpr67.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class orExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:119:1: orExpr : andExpr ( Or andExpr )* ;
    public final GremlinParser.orExpr_return orExpr() throws RecognitionException {
        GremlinParser.orExpr_return retval = new GremlinParser.orExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Or69=null;
        GremlinParser.andExpr_return andExpr68 = null;

        GremlinParser.andExpr_return andExpr70 = null;


        Object Or69_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:119:7: ( andExpr ( Or andExpr )* )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:119:9: andExpr ( Or andExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_orExpr785);
            andExpr68=andExpr();

            state._fsp--;

            adaptor.addChild(root_0, andExpr68.getTree());
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:119:17: ( Or andExpr )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Or) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:119:18: Or andExpr
            	    {
            	    Or69=(Token)match(input,Or,FOLLOW_Or_in_orExpr788); 
            	    Or69_tree = (Object)adaptor.create(Or69);
            	    adaptor.addChild(root_0, Or69_tree);

            	    pushFollow(FOLLOW_andExpr_in_orExpr790);
            	    andExpr70=andExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, andExpr70.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "orExpr"

    public static class andExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:121:1: andExpr : equalityExpr ( And equalityExpr )? ;
    public final GremlinParser.andExpr_return andExpr() throws RecognitionException {
        GremlinParser.andExpr_return retval = new GremlinParser.andExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token And72=null;
        GremlinParser.equalityExpr_return equalityExpr71 = null;

        GremlinParser.equalityExpr_return equalityExpr73 = null;


        Object And72_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:121:8: ( equalityExpr ( And equalityExpr )? )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:121:10: equalityExpr ( And equalityExpr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equalityExpr_in_andExpr800);
            equalityExpr71=equalityExpr();

            state._fsp--;

            adaptor.addChild(root_0, equalityExpr71.getTree());
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:121:23: ( And equalityExpr )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==And) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:121:24: And equalityExpr
                    {
                    And72=(Token)match(input,And,FOLLOW_And_in_andExpr803); 
                    And72_tree = (Object)adaptor.create(And72);
                    adaptor.addChild(root_0, And72_tree);

                    pushFollow(FOLLOW_equalityExpr_in_andExpr805);
                    equalityExpr73=equalityExpr();

                    state._fsp--;

                    adaptor.addChild(root_0, equalityExpr73.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "andExpr"

    public static class equalityExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equalityExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:123:1: equalityExpr : relationalExpr ( EqualtyOp relationalExpr )? ;
    public final GremlinParser.equalityExpr_return equalityExpr() throws RecognitionException {
        GremlinParser.equalityExpr_return retval = new GremlinParser.equalityExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EqualtyOp75=null;
        GremlinParser.relationalExpr_return relationalExpr74 = null;

        GremlinParser.relationalExpr_return relationalExpr76 = null;


        Object EqualtyOp75_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:124:5: ( relationalExpr ( EqualtyOp relationalExpr )? )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:124:7: relationalExpr ( EqualtyOp relationalExpr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relationalExpr_in_equalityExpr820);
            relationalExpr74=relationalExpr();

            state._fsp--;

            adaptor.addChild(root_0, relationalExpr74.getTree());
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:124:22: ( EqualtyOp relationalExpr )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==EqualtyOp) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:124:23: EqualtyOp relationalExpr
                    {
                    EqualtyOp75=(Token)match(input,EqualtyOp,FOLLOW_EqualtyOp_in_equalityExpr823); 
                    EqualtyOp75_tree = (Object)adaptor.create(EqualtyOp75);
                    adaptor.addChild(root_0, EqualtyOp75_tree);

                    pushFollow(FOLLOW_relationalExpr_in_equalityExpr825);
                    relationalExpr76=relationalExpr();

                    state._fsp--;

                    adaptor.addChild(root_0, relationalExpr76.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equalityExpr"

    public static class relationalExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relationalExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:126:1: relationalExpr : unionExpr ;
    public final GremlinParser.relationalExpr_return relationalExpr() throws RecognitionException {
        GremlinParser.relationalExpr_return retval = new GremlinParser.relationalExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GremlinParser.unionExpr_return unionExpr77 = null;



        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:126:15: ( unionExpr )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:126:17: unionExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_unionExpr_in_relationalExpr839);
            unionExpr77=unionExpr();

            state._fsp--;

            adaptor.addChild(root_0, unionExpr77.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relationalExpr"

    public static class unionExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unionExpr"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:128:1: unionExpr : pathExpr ( Pipe pathExpr )? ;
    public final GremlinParser.unionExpr_return unionExpr() throws RecognitionException {
        GremlinParser.unionExpr_return retval = new GremlinParser.unionExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Pipe79=null;
        GremlinParser.pathExpr_return pathExpr78 = null;

        GremlinParser.pathExpr_return pathExpr80 = null;


        Object Pipe79_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:128:10: ( pathExpr ( Pipe pathExpr )? )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:128:12: pathExpr ( Pipe pathExpr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pathExpr_in_unionExpr846);
            pathExpr78=pathExpr();

            state._fsp--;

            adaptor.addChild(root_0, pathExpr78.getTree());
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:128:21: ( Pipe pathExpr )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Pipe) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:128:22: Pipe pathExpr
                    {
                    Pipe79=(Token)match(input,Pipe,FOLLOW_Pipe_in_unionExpr849); 
                    Pipe79_tree = (Object)adaptor.create(Pipe79);
                    adaptor.addChild(root_0, Pipe79_tree);

                    pushFollow(FOLLOW_pathExpr_in_unionExpr851);
                    pathExpr80=pathExpr();

                    state._fsp--;

                    adaptor.addChild(root_0, pathExpr80.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unionExpr"

    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:130:1: literal : ( StringLiteral -> ^( STRING StringLiteral ) | numericLiteral -> ^( NUMBER numericLiteral ) | VariableReference -> ^( VARREF VariableReference ) );
    public final GremlinParser.literal_return literal() throws RecognitionException {
        GremlinParser.literal_return retval = new GremlinParser.literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token StringLiteral81=null;
        Token VariableReference83=null;
        GremlinParser.numericLiteral_return numericLiteral82 = null;


        Object StringLiteral81_tree=null;
        Object VariableReference83_tree=null;
        RewriteRuleTokenStream stream_VariableReference=new RewriteRuleTokenStream(adaptor,"token VariableReference");
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleSubtreeStream stream_numericLiteral=new RewriteRuleSubtreeStream(adaptor,"rule numericLiteral");
        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:131:5: ( StringLiteral -> ^( STRING StringLiteral ) | numericLiteral -> ^( NUMBER numericLiteral ) | VariableReference -> ^( VARREF VariableReference ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case StringLiteral:
                {
                alt25=1;
                }
                break;
            case IntegerLiteral:
            case DecimalLiteral:
            case DoubleLiteral:
                {
                alt25=2;
                }
                break;
            case VariableReference:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:131:7: StringLiteral
                    {
                    StringLiteral81=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_literal867);  
                    stream_StringLiteral.add(StringLiteral81);



                    // AST REWRITE
                    // elements: StringLiteral
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 131:21: -> ^( STRING StringLiteral )
                    {
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:131:24: ^( STRING StringLiteral )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRING, "STRING"), root_1);

                        adaptor.addChild(root_1, stream_StringLiteral.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:132:7: numericLiteral
                    {
                    pushFollow(FOLLOW_numericLiteral_in_literal883);
                    numericLiteral82=numericLiteral();

                    state._fsp--;

                    stream_numericLiteral.add(numericLiteral82.getTree());


                    // AST REWRITE
                    // elements: numericLiteral
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 132:22: -> ^( NUMBER numericLiteral )
                    {
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:132:25: ^( NUMBER numericLiteral )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NUMBER, "NUMBER"), root_1);

                        adaptor.addChild(root_1, stream_numericLiteral.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:133:7: VariableReference
                    {
                    VariableReference83=(Token)match(input,VariableReference,FOLLOW_VariableReference_in_literal899);  
                    stream_VariableReference.add(VariableReference83);



                    // AST REWRITE
                    // elements: VariableReference
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 133:25: -> ^( VARREF VariableReference )
                    {
                        // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:133:28: ^( VARREF VariableReference )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARREF, "VARREF"), root_1);

                        adaptor.addChild(root_1, stream_VariableReference.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "literal"

    public static class numericLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "numericLiteral"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:136:1: numericLiteral : ( IntegerLiteral | DecimalLiteral | DoubleLiteral );
    public final GremlinParser.numericLiteral_return numericLiteral() throws RecognitionException {
        GremlinParser.numericLiteral_return retval = new GremlinParser.numericLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set84=null;

        Object set84_tree=null;

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:136:15: ( IntegerLiteral | DecimalLiteral | DoubleLiteral )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:
            {
            root_0 = (Object)adaptor.nil();

            set84=(Token)input.LT(1);
            if ( (input.LA(1)>=IntegerLiteral && input.LA(1)<=DoubleLiteral) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set84));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "numericLiteral"

    public static class qName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qName"
    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:138:1: qName : ( NCName Colon )? NCName -> ^( QNAME ( NCName )+ ) ;
    public final GremlinParser.qName_return qName() throws RecognitionException {
        GremlinParser.qName_return retval = new GremlinParser.qName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NCName85=null;
        Token Colon86=null;
        Token NCName87=null;

        Object NCName85_tree=null;
        Object Colon86_tree=null;
        Object NCName87_tree=null;
        RewriteRuleTokenStream stream_NCName=new RewriteRuleTokenStream(adaptor,"token NCName");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");

        try {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:138:6: ( ( NCName Colon )? NCName -> ^( QNAME ( NCName )+ ) )
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:138:8: ( NCName Colon )? NCName
            {
            // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:138:8: ( NCName Colon )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==NCName) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==Colon) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:138:9: NCName Colon
                    {
                    NCName85=(Token)match(input,NCName,FOLLOW_NCName_in_qName939);  
                    stream_NCName.add(NCName85);

                    Colon86=(Token)match(input,Colon,FOLLOW_Colon_in_qName941);  
                    stream_Colon.add(Colon86);


                    }
                    break;

            }

            NCName87=(Token)match(input,NCName,FOLLOW_NCName_in_qName945);  
            stream_NCName.add(NCName87);



            // AST REWRITE
            // elements: NCName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 138:31: -> ^( QNAME ( NCName )+ )
            {
                // /Users/marko/software/gremlin/trunk/src/main/java/com/tinkerpop/gremlin/parse/Gremlin.g:138:34: ^( QNAME ( NCName )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QNAME, "QNAME"), root_1);

                if ( !(stream_NCName.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_NCName.hasNext() ) {
                    adaptor.addChild(root_1, stream_NCName.nextNode());

                }
                stream_NCName.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "qName"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA6_eotS =
        "\20\uffff";
    static final String DFA6_eofS =
        "\1\10\17\uffff";
    static final String DFA6_minS =
        "\1\32\1\42\1\44\2\uffff\2\45\2\uffff\1\44\1\uffff\1\46\1\50\1\uffff"+
        "\1\46\1\uffff";
    static final String DFA6_maxS =
        "\1\65\1\42\1\52\2\uffff\2\45\2\uffff\1\52\1\uffff\1\46\1\50\1\uffff"+
        "\1\46\1\uffff";
    static final String DFA6_acceptS =
        "\3\uffff\2\1\2\uffff\1\1\1\2\1\uffff\1\1\2\uffff\1\1\1\uffff\1\1";
    static final String DFA6_specialS =
        "\20\uffff}>";
    static final String[] DFA6_transitionS = {
            "\3\10\1\uffff\2\10\1\7\1\1\1\uffff\1\2\1\5\1\uffff\1\10\1\6"+
            "\1\10\1\3\1\4\2\uffff\11\10",
            "\1\11",
            "\1\5\2\uffff\1\6\1\uffff\1\3\1\12",
            "",
            "",
            "\1\13",
            "\1\14",
            "",
            "",
            "\1\5\2\uffff\1\6\1\uffff\1\3\1\12",
            "",
            "\1\15",
            "\1\16",
            "",
            "\1\17",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "44:22: ( relativeLocationPath )?";
        }
    }
    static final String DFA8_eotS =
        "\37\uffff";
    static final String DFA8_eofS =
        "\1\1\1\uffff\1\1\34\uffff";
    static final String DFA8_minS =
        "\1\32\1\uffff\1\32\1\40\1\42\1\44\2\uffff\2\45\1\uffff\1\42\1\44"+
        "\2\uffff\2\45\1\uffff\1\44\1\uffff\1\46\1\50\1\44\1\46\1\50\1\uffff"+
        "\1\46\1\uffff\1\46\2\uffff";
    static final String DFA8_maxS =
        "\1\65\1\uffff\1\65\1\52\1\42\1\52\2\uffff\2\45\1\uffff\1\42\1\52"+
        "\2\uffff\2\45\1\uffff\1\52\1\uffff\1\46\1\50\1\52\1\46\1\50\1\uffff"+
        "\1\46\1\uffff\1\46\2\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\2\4\uffff\2\1\2\uffff\1\1\2\uffff\2\1\2\uffff\1\1\1\uffff"+
        "\1\1\5\uffff\1\1\1\uffff\1\1\1\uffff\2\1";
    static final String DFA8_specialS =
        "\37\uffff}>";
    static final String[] DFA8_transitionS = {
            "\3\1\1\uffff\1\2\1\3\2\1\1\uffff\2\1\1\uffff\5\1\2\uffff\11"+
            "\1",
            "",
            "\3\1\1\uffff\2\1\1\12\1\4\1\uffff\1\5\1\10\2\uffff\1\11\1\1"+
            "\1\6\1\7\10\uffff\3\1",
            "\1\21\1\13\1\uffff\1\14\1\17\2\uffff\1\20\1\uffff\1\15\1\16",
            "\1\22",
            "\1\10\2\uffff\1\11\1\uffff\1\6\1\23",
            "",
            "",
            "\1\24",
            "\1\25",
            "",
            "\1\26",
            "\1\17\2\uffff\1\20\1\uffff\1\15\1\16",
            "",
            "",
            "\1\27",
            "\1\30",
            "",
            "\1\10\2\uffff\1\11\1\uffff\1\6\1\23",
            "",
            "\1\31",
            "\1\32",
            "\1\17\2\uffff\1\20\1\uffff\1\15\1\16",
            "\1\33",
            "\1\34",
            "",
            "\1\35",
            "",
            "\1\36",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "()* loopback of 52:5: ( simpleAxisStep step )*";
        }
    }
 

    public static final BitSet FOLLOW_statement_in_program138 = new BitSet(new long[]{0x0038079BD8000002L});
    public static final BitSet FOLLOW_gpath_in_statement149 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_foreach_in_statement153 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_Newline_in_statement156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Foreach_in_foreach166 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_VariableReference_in_foreach168 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_In_in_foreach170 = new BitSet(new long[]{0x0038079BD0000000L});
    public static final BitSet FOLLOW_gpath_in_foreach174 = new BitSet(new long[]{0x0038079BD0000000L});
    public static final BitSet FOLLOW_gpath_in_foreach178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_in_gpath213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_gpath227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_gpath241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_locationPath_in_xpath260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relativeLocationPath_in_locationPath273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_absoluteLocationPath_in_locationPath282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SingleAxisStep_in_absoluteLocationPath304 = new BitSet(new long[]{0x0000069B00000002L});
    public static final BitSet FOLLOW_relativeLocationPath_in_absoluteLocationPath306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abbreviatedAbsoluteLocationPath_in_absoluteLocationPath315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RecursiveAxisStep_in_abbreviatedAbsoluteLocationPath327 = new BitSet(new long[]{0x0000069B00000000L});
    public static final BitSet FOLLOW_relativeLocationPath_in_abbreviatedAbsoluteLocationPath329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_step_in_relativeLocationPath342 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_simpleAxisStep_in_relativeLocationPath351 = new BitSet(new long[]{0x0000069B00000000L});
    public static final BitSet FOLLOW_step_in_relativeLocationPath353 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_namedAxisStep_in_step375 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_abbreviatedAxisStep_in_step379 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_predicate_in_step383 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_set_in_simpleAxisStep401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AbbreviatedStep_in_abbreviatedAxisStep443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_axisSpecifier_in_namedAxisStep457 = new BitSet(new long[]{0x0000069A00000000L});
    public static final BitSet FOLLOW_nodeTest_in_namedAxisStep460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AxisName_in_axisSpecifier474 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_AxisNameSeparator_in_axisSpecifier476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AbbreviatedAxisSpecifier_in_axisSpecifier485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameTest_in_nodeTest500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeType_in_nodeTest506 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_nodeTest508 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_nodeTest510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ProcessingInstruction_in_nodeTest516 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_nodeTest518 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_nodeTest520 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_nodeTest522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_nameTest538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NCName_in_nameTest552 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_Colon_in_nameTest554 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_Star_in_nameTest556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qName_in_nameTest572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_predicate589 = new BitSet(new long[]{0x003807BBD0000000L});
    public static final BitSet FOLLOW_predicateExpr_in_predicate591 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_predicate593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_predicateExpr614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qName_in_functionCall627 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_functionCall629 = new BitSet(new long[]{0x003807FBD0000000L});
    public static final BitSet FOLLOW_expressionList_in_functionCall634 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_functionCall641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_expressionList667 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_Comma_in_expressionList671 = new BitSet(new long[]{0x003807BBD0000000L});
    public static final BitSet FOLLOW_expr_in_expressionList673 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_locationPath_in_pathExpr703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filterExpr_in_pathExpr711 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_simpleAxisStep_in_pathExpr714 = new BitSet(new long[]{0x0000069B00000000L});
    public static final BitSet FOLLOW_relativeLocationPath_in_pathExpr717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpr_in_filterExpr731 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_predicate_in_filterExpr733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_primaryExpr746 = new BitSet(new long[]{0x003807BBD0000000L});
    public static final BitSet FOLLOW_expr_in_primaryExpr748 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_primaryExpr750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primaryExpr758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_primaryExpr766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpr_in_expr778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr785 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_Or_in_orExpr788 = new BitSet(new long[]{0x003807BBD0000000L});
    public static final BitSet FOLLOW_andExpr_in_orExpr790 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr800 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_And_in_andExpr803 = new BitSet(new long[]{0x003807BBD0000000L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr820 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_EqualtyOp_in_equalityExpr823 = new BitSet(new long[]{0x003807BBD0000000L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unionExpr_in_relationalExpr839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_unionExpr846 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_Pipe_in_unionExpr849 = new BitSet(new long[]{0x003807BBD0000000L});
    public static final BitSet FOLLOW_pathExpr_in_unionExpr851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_literal883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VariableReference_in_literal899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_numericLiteral0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NCName_in_qName939 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_Colon_in_qName941 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_NCName_in_qName945 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g 2010-10-05 14:26:28

            package com.tinkerpop.gremlin.compiler;
            
            import com.tinkerpop.gremlin.compiler.exceptions.SyntaxErrorException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class GremlinParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "GPATH", "NATIVE_STEP", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "LOOPS", "SELF", "HISTORY", "FUNC_CALL", "IF", "ELSE", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "SCRIPT", "INT", "LONG", "FLOAT", "DOUBLE", "STR", "ARR", "BOOL", "NULL", "RANGE", "PROPERTY_CALL", "VARIABLE_CALL", "COLLECTION_CALL", "COMMENT", "NEWLINE", "G_INT", "G_LONG", "G_FLOAT", "G_DOUBLE", "StringLiteral", "PROPERTY", "VARIABLE", "IDENTIFIER", "BOOLEAN", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "'/'", "'['", "']'", "'..'", "'('", "')'", "'repeat'", "'=>'", "'while'", "'foreach'", "'in'", "'{'", "'}'", "':='", "'and'", "'or'", "'include'", "'script'", "'if'", "'else'", "'end'", "'step'", "'func'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "'mod'", "':'"
    };
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
    public static final int ARGS=6;
    public static final int DOUBLE=33;
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
    public static final int ARR=35;
    public static final int DoubleStringCharacter=53;
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
    public static final int COND=23;
    public static final int LONG=31;
    public static final int SELF=18;
    public static final int VARIABLE_CALL=40;

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
    public String getGrammarFileName() { return "src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g"; }


                public void reportError(RecognitionException e) {
                    throw new SyntaxErrorException("Syntax error at " + e.line + "-" + e.charPositionInLine + ": " + this.getErrorMessage(e, this.getTokenNames()));
                }
            

    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:91:1: program : ( ( COMMENT )+ | ( ( statement )? NEWLINE )+ );
    public final GremlinParser.program_return program() throws RecognitionException {
        GremlinParser.program_return retval = new GremlinParser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMENT1=null;
        Token NEWLINE3=null;
        GremlinParser.statement_return statement2 = null;


        CommonTree COMMENT1_tree=null;
        CommonTree NEWLINE3_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:92:5: ( ( COMMENT )+ | ( ( statement )? NEWLINE )+ )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==COMMENT) ) {
                alt4=1;
            }
            else if ( (LA4_0==NULL||(LA4_0>=NEWLINE && LA4_0<=BOOLEAN)||(LA4_0>=68 && LA4_0<=69)||LA4_0==71||(LA4_0>=73 && LA4_0<=74)||(LA4_0>=81 && LA4_0<=83)||(LA4_0>=86 && LA4_0<=87)) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:92:7: ( COMMENT )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:92:7: ( COMMENT )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==COMMENT) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: COMMENT
                    	    {
                    	    COMMENT1=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_program315); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    COMMENT1_tree = (CommonTree)adaptor.create(COMMENT1);
                    	    adaptor.addChild(root_0, COMMENT1_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:93:9: ( ( statement )? NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:93:9: ( ( statement )? NEWLINE )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NULL||(LA3_0>=NEWLINE && LA3_0<=BOOLEAN)||(LA3_0>=68 && LA3_0<=69)||LA3_0==71||(LA3_0>=73 && LA3_0<=74)||(LA3_0>=81 && LA3_0<=83)||(LA3_0>=86 && LA3_0<=87)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:93:10: ( statement )? NEWLINE
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:93:10: ( statement )?
                    	    int alt2=2;
                    	    int LA2_0 = input.LA(1);

                    	    if ( (LA2_0==NULL||(LA2_0>=G_INT && LA2_0<=BOOLEAN)||(LA2_0>=68 && LA2_0<=69)||LA2_0==71||(LA2_0>=73 && LA2_0<=74)||(LA2_0>=81 && LA2_0<=83)||(LA2_0>=86 && LA2_0<=87)) ) {
                    	        alt2=1;
                    	    }
                    	    switch (alt2) {
                    	        case 1 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: statement
                    	            {
                    	            pushFollow(FOLLOW_statement_in_program327);
                    	            statement2=statement();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement2.getTree());

                    	            }
                    	            break;

                    	    }

                    	    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program330); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NEWLINE3_tree = (CommonTree)adaptor.create(NEWLINE3);
                    	    adaptor.addChild(root_0, NEWLINE3_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class gpath_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gpath_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:101:1: gpath_statement : step ( '/' step )* -> ^( GPATH ( step )+ ) ;
    public final GremlinParser.gpath_statement_return gpath_statement() throws RecognitionException {
        GremlinParser.gpath_statement_return retval = new GremlinParser.gpath_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal5=null;
        GremlinParser.step_return step4 = null;

        GremlinParser.step_return step6 = null;


        CommonTree char_literal5_tree=null;
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_step=new RewriteRuleSubtreeStream(adaptor,"rule step");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:102:5: ( step ( '/' step )* -> ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:102:7: step ( '/' step )*
            {
            pushFollow(FOLLOW_step_in_gpath_statement372);
            step4=step();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_step.add(step4.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:102:12: ( '/' step )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==65) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:102:13: '/' step
            	    {
            	    char_literal5=(Token)match(input,65,FOLLOW_65_in_gpath_statement375); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_65.add(char_literal5);

            	    pushFollow(FOLLOW_step_in_gpath_statement377);
            	    step6=step();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_step.add(step6.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);



            // AST REWRITE
            // elements: step
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 102:24: -> ^( GPATH ( step )+ )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:102:27: ^( GPATH ( step )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GPATH, "GPATH"), root_1);

                if ( !(stream_step.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_step.hasNext() ) {
                    adaptor.addChild(root_1, stream_step.nextTree());

                }
                stream_step.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gpath_statement"

    public static class step_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "step"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:105:1: step : token ( '[' statement ']' )* ( inline_loop_statement )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ^( LOOPS ( inline_loop_statement )* ) ) ;
    public final GremlinParser.step_return step() throws RecognitionException {
        GremlinParser.step_return retval = new GremlinParser.step_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal8=null;
        Token char_literal10=null;
        GremlinParser.token_return token7 = null;

        GremlinParser.statement_return statement9 = null;

        GremlinParser.inline_loop_statement_return inline_loop_statement11 = null;


        CommonTree char_literal8_tree=null;
        CommonTree char_literal10_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_token=new RewriteRuleSubtreeStream(adaptor,"rule token");
        RewriteRuleSubtreeStream stream_inline_loop_statement=new RewriteRuleSubtreeStream(adaptor,"rule inline_loop_statement");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:5: ( token ( '[' statement ']' )* ( inline_loop_statement )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ^( LOOPS ( inline_loop_statement )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:7: token ( '[' statement ']' )* ( inline_loop_statement )*
            {
            pushFollow(FOLLOW_token_in_step403);
            token7=token();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_token.add(token7.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:13: ( '[' statement ']' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==66) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:14: '[' statement ']'
            	    {
            	    char_literal8=(Token)match(input,66,FOLLOW_66_in_step406); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_66.add(char_literal8);

            	    pushFollow(FOLLOW_statement_in_step408);
            	    statement9=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement9.getTree());
            	    char_literal10=(Token)match(input,67,FOLLOW_67_in_step410); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_67.add(char_literal10);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:34: ( inline_loop_statement )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==76) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:36: inline_loop_statement
            	    {
            	    pushFollow(FOLLOW_inline_loop_statement_in_step416);
            	    inline_loop_statement11=inline_loop_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_inline_loop_statement.add(inline_loop_statement11.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);



            // AST REWRITE
            // elements: inline_loop_statement, token, statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 106:61: -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ^( LOOPS ( inline_loop_statement )* ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:64: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ^( LOOPS ( inline_loop_statement )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STEP, "STEP"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:71: ^( TOKEN token )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TOKEN, "TOKEN"), root_2);

                adaptor.addChild(root_2, stream_token.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:86: ^( PREDICATES ( ^( PREDICATE statement ) )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREDICATES, "PREDICATES"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:99: ( ^( PREDICATE statement ) )*
                while ( stream_statement.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:99: ^( PREDICATE statement )
                    {
                    CommonTree root_3 = (CommonTree)adaptor.nil();
                    root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREDICATE, "PREDICATE"), root_3);

                    adaptor.addChild(root_3, stream_statement.nextTree());

                    adaptor.addChild(root_2, root_3);
                    }

                }
                stream_statement.reset();

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:124: ^( LOOPS ( inline_loop_statement )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LOOPS, "LOOPS"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:132: ( inline_loop_statement )*
                while ( stream_inline_loop_statement.hasNext() ) {
                    adaptor.addChild(root_2, stream_inline_loop_statement.nextTree());

                }
                stream_inline_loop_statement.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "step"

    public static class token_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "token"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:109:1: token : ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | function_call | StringLiteral -> ^( STR StringLiteral ) | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | '..' | b= BOOLEAN -> ^( BOOL $b) | '(' statement ')' );
    public final GremlinParser.token_return token() throws RecognitionException {
        GremlinParser.token_return retval = new GremlinParser.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token b=null;
        Token G_INT12=null;
        Token G_LONG13=null;
        Token G_FLOAT14=null;
        Token G_DOUBLE15=null;
        Token StringLiteral17=null;
        Token PROPERTY18=null;
        Token VARIABLE19=null;
        Token IDENTIFIER20=null;
        Token string_literal21=null;
        Token char_literal22=null;
        Token char_literal24=null;
        GremlinParser.function_call_return function_call16 = null;

        GremlinParser.statement_return statement23 = null;


        CommonTree b_tree=null;
        CommonTree G_INT12_tree=null;
        CommonTree G_LONG13_tree=null;
        CommonTree G_FLOAT14_tree=null;
        CommonTree G_DOUBLE15_tree=null;
        CommonTree StringLiteral17_tree=null;
        CommonTree PROPERTY18_tree=null;
        CommonTree VARIABLE19_tree=null;
        CommonTree IDENTIFIER20_tree=null;
        CommonTree string_literal21_tree=null;
        CommonTree char_literal22_tree=null;
        CommonTree char_literal24_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_G_LONG=new RewriteRuleTokenStream(adaptor,"token G_LONG");
        RewriteRuleTokenStream stream_BOOLEAN=new RewriteRuleTokenStream(adaptor,"token BOOLEAN");
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_G_DOUBLE=new RewriteRuleTokenStream(adaptor,"token G_DOUBLE");
        RewriteRuleTokenStream stream_PROPERTY=new RewriteRuleTokenStream(adaptor,"token PROPERTY");
        RewriteRuleTokenStream stream_G_FLOAT=new RewriteRuleTokenStream(adaptor,"token G_FLOAT");
        RewriteRuleTokenStream stream_G_INT=new RewriteRuleTokenStream(adaptor,"token G_INT");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:110:2: ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | function_call | StringLiteral -> ^( STR StringLiteral ) | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | '..' | b= BOOLEAN -> ^( BOOL $b) | '(' statement ')' )
            int alt8=12;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:110:6: G_INT
                    {
                    G_INT12=(Token)match(input,G_INT,FOLLOW_G_INT_in_token470); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_INT.add(G_INT12);



                    // AST REWRITE
                    // elements: G_INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 110:22: -> ^( INT G_INT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:110:25: ^( INT G_INT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INT, "INT"), root_1);

                        adaptor.addChild(root_1, stream_G_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:111:6: G_LONG
                    {
                    G_LONG13=(Token)match(input,G_LONG,FOLLOW_G_LONG_in_token495); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_LONG.add(G_LONG13);



                    // AST REWRITE
                    // elements: G_LONG
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 111:22: -> ^( LONG G_LONG )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:111:25: ^( LONG G_LONG )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LONG, "LONG"), root_1);

                        adaptor.addChild(root_1, stream_G_LONG.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:112:6: G_FLOAT
                    {
                    G_FLOAT14=(Token)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_token519); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_FLOAT.add(G_FLOAT14);



                    // AST REWRITE
                    // elements: G_FLOAT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 112:22: -> ^( FLOAT G_FLOAT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:112:25: ^( FLOAT G_FLOAT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FLOAT, "FLOAT"), root_1);

                        adaptor.addChild(root_1, stream_G_FLOAT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:113:6: G_DOUBLE
                    {
                    G_DOUBLE15=(Token)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_token542); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_DOUBLE.add(G_DOUBLE15);



                    // AST REWRITE
                    // elements: G_DOUBLE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 113:22: -> ^( DOUBLE G_DOUBLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:113:25: ^( DOUBLE G_DOUBLE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DOUBLE, "DOUBLE"), root_1);

                        adaptor.addChild(root_1, stream_G_DOUBLE.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:114:9: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_call_in_token567);
                    function_call16=function_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_call16.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:115:9: StringLiteral
                    {
                    StringLiteral17=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_token577); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral17);



                    // AST REWRITE
                    // elements: StringLiteral
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 115:23: -> ^( STR StringLiteral )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:115:26: ^( STR StringLiteral )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STR, "STR"), root_1);

                        adaptor.addChild(root_1, stream_StringLiteral.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:116:4: PROPERTY
                    {
                    PROPERTY18=(Token)match(input,PROPERTY,FOLLOW_PROPERTY_in_token590); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROPERTY.add(PROPERTY18);



                    // AST REWRITE
                    // elements: PROPERTY
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 116:17: -> ^( PROPERTY_CALL PROPERTY )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:116:20: ^( PROPERTY_CALL PROPERTY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROPERTY_CALL, "PROPERTY_CALL"), root_1);

                        adaptor.addChild(root_1, stream_PROPERTY.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:117:4: VARIABLE
                    {
                    VARIABLE19=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_token607); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE19);



                    // AST REWRITE
                    // elements: VARIABLE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 117:20: -> ^( VARIABLE_CALL VARIABLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:117:23: ^( VARIABLE_CALL VARIABLE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VARIABLE_CALL, "VARIABLE_CALL"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:118:6: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IDENTIFIER20=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_token629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER20_tree = (CommonTree)adaptor.create(IDENTIFIER20);
                    adaptor.addChild(root_0, IDENTIFIER20_tree);
                    }

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:119:9: '..'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal21=(Token)match(input,68,FOLLOW_68_in_token639); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal21_tree = (CommonTree)adaptor.create(string_literal21);
                    adaptor.addChild(root_0, string_literal21_tree);
                    }

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:120:9: b= BOOLEAN
                    {
                    b=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_token651); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BOOLEAN.add(b);



                    // AST REWRITE
                    // elements: b
                    // token labels: b
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 120:25: -> ^( BOOL $b)
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:120:28: ^( BOOL $b)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BOOL, "BOOL"), root_1);

                        adaptor.addChild(root_1, stream_b.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:121:7: '(' statement ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal22=(Token)match(input,69,FOLLOW_69_in_token674); if (state.failed) return retval;
                    pushFollow(FOLLOW_statement_in_token677);
                    statement23=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement23.getTree());
                    char_literal24=(Token)match(input,70,FOLLOW_70_in_token679); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "token"

    public static class inline_loop_definition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inline_loop_definition"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:124:1: inline_loop_definition : ( 'repeat' times= statement '=>' block -> ^( REPEAT $times block ) | 'while' condition= statement '=>' block -> ^( WHILE ^( COND $condition) block ) | 'foreach' VARIABLE 'in' iterable= statement '=>' block -> ^( FOREACH VARIABLE $iterable block ) );
    public final GremlinParser.inline_loop_definition_return inline_loop_definition() throws RecognitionException {
        GremlinParser.inline_loop_definition_return retval = new GremlinParser.inline_loop_definition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal25=null;
        Token string_literal26=null;
        Token string_literal28=null;
        Token string_literal29=null;
        Token string_literal31=null;
        Token VARIABLE32=null;
        Token string_literal33=null;
        Token string_literal34=null;
        GremlinParser.statement_return times = null;

        GremlinParser.statement_return condition = null;

        GremlinParser.statement_return iterable = null;

        GremlinParser.block_return block27 = null;

        GremlinParser.block_return block30 = null;

        GremlinParser.block_return block35 = null;


        CommonTree string_literal25_tree=null;
        CommonTree string_literal26_tree=null;
        CommonTree string_literal28_tree=null;
        CommonTree string_literal29_tree=null;
        CommonTree string_literal31_tree=null;
        CommonTree VARIABLE32_tree=null;
        CommonTree string_literal33_tree=null;
        CommonTree string_literal34_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:125:5: ( 'repeat' times= statement '=>' block -> ^( REPEAT $times block ) | 'while' condition= statement '=>' block -> ^( WHILE ^( COND $condition) block ) | 'foreach' VARIABLE 'in' iterable= statement '=>' block -> ^( FOREACH VARIABLE $iterable block ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt9=1;
                }
                break;
            case 73:
                {
                alt9=2;
                }
                break;
            case 74:
                {
                alt9=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:125:7: 'repeat' times= statement '=>' block
                    {
                    string_literal25=(Token)match(input,71,FOLLOW_71_in_inline_loop_definition694); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_71.add(string_literal25);

                    pushFollow(FOLLOW_statement_in_inline_loop_definition699);
                    times=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(times.getTree());
                    string_literal26=(Token)match(input,72,FOLLOW_72_in_inline_loop_definition701); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(string_literal26);

                    pushFollow(FOLLOW_block_in_inline_loop_definition703);
                    block27=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block.add(block27.getTree());


                    // AST REWRITE
                    // elements: times, block
                    // token labels: 
                    // rule labels: retval, times
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_times=new RewriteRuleSubtreeStream(adaptor,"rule times",times!=null?times.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 125:44: -> ^( REPEAT $times block )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:125:47: ^( REPEAT $times block )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REPEAT, "REPEAT"), root_1);

                        adaptor.addChild(root_1, stream_times.nextTree());
                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:126:7: 'while' condition= statement '=>' block
                    {
                    string_literal28=(Token)match(input,73,FOLLOW_73_in_inline_loop_definition723); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_73.add(string_literal28);

                    pushFollow(FOLLOW_statement_in_inline_loop_definition729);
                    condition=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(condition.getTree());
                    string_literal29=(Token)match(input,72,FOLLOW_72_in_inline_loop_definition731); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(string_literal29);

                    pushFollow(FOLLOW_block_in_inline_loop_definition733);
                    block30=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block.add(block30.getTree());


                    // AST REWRITE
                    // elements: condition, block
                    // token labels: 
                    // rule labels: retval, condition
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition",condition!=null?condition.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 126:48: -> ^( WHILE ^( COND $condition) block )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:126:51: ^( WHILE ^( COND $condition) block )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);

                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:126:59: ^( COND $condition)
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COND, "COND"), root_2);

                        adaptor.addChild(root_2, stream_condition.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:127:7: 'foreach' VARIABLE 'in' iterable= statement '=>' block
                    {
                    string_literal31=(Token)match(input,74,FOLLOW_74_in_inline_loop_definition756); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_74.add(string_literal31);

                    VARIABLE32=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_inline_loop_definition758); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE32);

                    string_literal33=(Token)match(input,75,FOLLOW_75_in_inline_loop_definition760); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_75.add(string_literal33);

                    pushFollow(FOLLOW_statement_in_inline_loop_definition764);
                    iterable=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(iterable.getTree());
                    string_literal34=(Token)match(input,72,FOLLOW_72_in_inline_loop_definition766); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_72.add(string_literal34);

                    pushFollow(FOLLOW_block_in_inline_loop_definition768);
                    block35=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block.add(block35.getTree());


                    // AST REWRITE
                    // elements: block, iterable, VARIABLE
                    // token labels: 
                    // rule labels: retval, iterable
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_iterable=new RewriteRuleSubtreeStream(adaptor,"rule iterable",iterable!=null?iterable.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 127:61: -> ^( FOREACH VARIABLE $iterable block )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:127:64: ^( FOREACH VARIABLE $iterable block )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOREACH, "FOREACH"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE.nextNode());
                        adaptor.addChild(root_1, stream_iterable.nextTree());
                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inline_loop_definition"

    public static class inline_loop_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inline_loop_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:130:1: inline_loop_statement : '{' loop_def= inline_loop_definition '}' -> $loop_def;
    public final GremlinParser.inline_loop_statement_return inline_loop_statement() throws RecognitionException {
        GremlinParser.inline_loop_statement_return retval = new GremlinParser.inline_loop_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal36=null;
        Token char_literal37=null;
        GremlinParser.inline_loop_definition_return loop_def = null;


        CommonTree char_literal36_tree=null;
        CommonTree char_literal37_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_inline_loop_definition=new RewriteRuleSubtreeStream(adaptor,"rule inline_loop_definition");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:131:5: ( '{' loop_def= inline_loop_definition '}' -> $loop_def)
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:131:7: '{' loop_def= inline_loop_definition '}'
            {
            char_literal36=(Token)match(input,76,FOLLOW_76_in_inline_loop_statement799); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_76.add(char_literal36);

            pushFollow(FOLLOW_inline_loop_definition_in_inline_loop_statement803);
            loop_def=inline_loop_definition();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_inline_loop_definition.add(loop_def.getTree());
            char_literal37=(Token)match(input,77,FOLLOW_77_in_inline_loop_statement805); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal37);



            // AST REWRITE
            // elements: loop_def
            // token labels: 
            // rule labels: retval, loop_def
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_loop_def=new RewriteRuleSubtreeStream(adaptor,"rule loop_def",loop_def!=null?loop_def.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 131:47: -> $loop_def
            {
                adaptor.addChild(root_0, stream_loop_def.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inline_loop_statement"

    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:134:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | native_step_definition_statement | function_definition_statement | include_statement | script_statement | atom ':=' statement -> ^( VAR atom statement ) | expression ( ( 'and' | 'or' ) expression )* );
    public final GremlinParser.statement_return statement() throws RecognitionException {
        GremlinParser.statement_return retval = new GremlinParser.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal47=null;
        Token string_literal50=null;
        Token string_literal51=null;
        GremlinParser.if_statement_return if_statement38 = null;

        GremlinParser.foreach_statement_return foreach_statement39 = null;

        GremlinParser.while_statement_return while_statement40 = null;

        GremlinParser.repeat_statement_return repeat_statement41 = null;

        GremlinParser.native_step_definition_statement_return native_step_definition_statement42 = null;

        GremlinParser.function_definition_statement_return function_definition_statement43 = null;

        GremlinParser.include_statement_return include_statement44 = null;

        GremlinParser.script_statement_return script_statement45 = null;

        GremlinParser.atom_return atom46 = null;

        GremlinParser.statement_return statement48 = null;

        GremlinParser.expression_return expression49 = null;

        GremlinParser.expression_return expression52 = null;


        CommonTree string_literal47_tree=null;
        CommonTree string_literal50_tree=null;
        CommonTree string_literal51_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:135:5: ( if_statement | foreach_statement | while_statement | repeat_statement | native_step_definition_statement | function_definition_statement | include_statement | script_statement | atom ':=' statement -> ^( VAR atom statement ) | expression ( ( 'and' | 'or' ) expression )* )
            int alt12=10;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:135:9: if_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_if_statement_in_statement829);
                    if_statement38=if_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, if_statement38.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:136:4: foreach_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_foreach_statement_in_statement834);
                    foreach_statement39=foreach_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, foreach_statement39.getTree());

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:137:4: while_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_while_statement_in_statement839);
                    while_statement40=while_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, while_statement40.getTree());

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:138:4: repeat_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_repeat_statement_in_statement844);
                    repeat_statement41=repeat_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, repeat_statement41.getTree());

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:139:4: native_step_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_native_step_definition_statement_in_statement849);
                    native_step_definition_statement42=native_step_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, native_step_definition_statement42.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:4: function_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_definition_statement_in_statement854);
                    function_definition_statement43=function_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_definition_statement43.getTree());

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:141:4: include_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_include_statement_in_statement859);
                    include_statement44=include_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, include_statement44.getTree());

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:6: script_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_script_statement_in_statement866);
                    script_statement45=script_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, script_statement45.getTree());

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:143:9: atom ':=' statement
                    {
                    pushFollow(FOLLOW_atom_in_statement876);
                    atom46=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom46.getTree());
                    string_literal47=(Token)match(input,78,FOLLOW_78_in_statement878); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_78.add(string_literal47);

                    pushFollow(FOLLOW_statement_in_statement880);
                    statement48=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement48.getTree());


                    // AST REWRITE
                    // elements: atom, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 143:30: -> ^( VAR atom statement )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:143:33: ^( VAR atom statement )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:4: expression ( ( 'and' | 'or' ) expression )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement897);
                    expression49=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression49.getTree());
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:15: ( ( 'and' | 'or' ) expression )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>=79 && LA11_0<=80)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:16: ( 'and' | 'or' ) expression
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:16: ( 'and' | 'or' )
                    	    int alt10=2;
                    	    int LA10_0 = input.LA(1);

                    	    if ( (LA10_0==79) ) {
                    	        alt10=1;
                    	    }
                    	    else if ( (LA10_0==80) ) {
                    	        alt10=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 10, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt10) {
                    	        case 1 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:17: 'and'
                    	            {
                    	            string_literal50=(Token)match(input,79,FOLLOW_79_in_statement901); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal50_tree = (CommonTree)adaptor.create(string_literal50);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal50_tree, root_0);
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:24: 'or'
                    	            {
                    	            string_literal51=(Token)match(input,80,FOLLOW_80_in_statement904); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal51_tree = (CommonTree)adaptor.create(string_literal51);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal51_tree, root_0);
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    pushFollow(FOLLOW_expression_in_statement908);
                    	    expression52=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression52.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class include_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "include_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:147:1: include_statement : 'include' StringLiteral -> ^( INCLUDE StringLiteral ) ;
    public final GremlinParser.include_statement_return include_statement() throws RecognitionException {
        GremlinParser.include_statement_return retval = new GremlinParser.include_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal53=null;
        Token StringLiteral54=null;

        CommonTree string_literal53_tree=null;
        CommonTree StringLiteral54_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:2: ( 'include' StringLiteral -> ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:4: 'include' StringLiteral
            {
            string_literal53=(Token)match(input,81,FOLLOW_81_in_include_statement921); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_81.add(string_literal53);

            StringLiteral54=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement923); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral54);



            // AST REWRITE
            // elements: StringLiteral
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 148:28: -> ^( INCLUDE StringLiteral )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:31: ^( INCLUDE StringLiteral )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INCLUDE, "INCLUDE"), root_1);

                adaptor.addChild(root_1, stream_StringLiteral.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "include_statement"

    public static class script_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "script_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:151:1: script_statement : 'script' StringLiteral -> ^( SCRIPT StringLiteral ) ;
    public final GremlinParser.script_statement_return script_statement() throws RecognitionException {
        GremlinParser.script_statement_return retval = new GremlinParser.script_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal55=null;
        Token StringLiteral56=null;

        CommonTree string_literal55_tree=null;
        CommonTree StringLiteral56_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:5: ( 'script' StringLiteral -> ^( SCRIPT StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:9: 'script' StringLiteral
            {
            string_literal55=(Token)match(input,82,FOLLOW_82_in_script_statement947); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(string_literal55);

            StringLiteral56=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_script_statement949); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral56);



            // AST REWRITE
            // elements: StringLiteral
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 152:32: -> ^( SCRIPT StringLiteral )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:35: ^( SCRIPT StringLiteral )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SCRIPT, "SCRIPT"), root_1);

                adaptor.addChild(root_1, stream_StringLiteral.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "script_statement"

    public static class if_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "if_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:155:1: if_statement : 'if' statement NEWLINE if_block= block ( 'else' else_block= block )? 'end' -> ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? ) ;
    public final GremlinParser.if_statement_return if_statement() throws RecognitionException {
        GremlinParser.if_statement_return retval = new GremlinParser.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal57=null;
        Token NEWLINE59=null;
        Token string_literal60=null;
        Token string_literal61=null;
        GremlinParser.block_return if_block = null;

        GremlinParser.block_return else_block = null;

        GremlinParser.statement_return statement58 = null;


        CommonTree string_literal57_tree=null;
        CommonTree NEWLINE59_tree=null;
        CommonTree string_literal60_tree=null;
        CommonTree string_literal61_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:2: ( 'if' statement NEWLINE if_block= block ( 'else' else_block= block )? 'end' -> ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:4: 'if' statement NEWLINE if_block= block ( 'else' else_block= block )? 'end'
            {
            string_literal57=(Token)match(input,83,FOLLOW_83_in_if_statement973); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(string_literal57);

            pushFollow(FOLLOW_statement_in_if_statement975);
            statement58=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement58.getTree());
            NEWLINE59=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_if_statement977); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE59);

            pushFollow(FOLLOW_block_in_if_statement993);
            if_block=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(if_block.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:158:9: ( 'else' else_block= block )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==84) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:158:10: 'else' else_block= block
                    {
                    string_literal60=(Token)match(input,84,FOLLOW_84_in_if_statement1004); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_84.add(string_literal60);

                    pushFollow(FOLLOW_block_in_if_statement1019);
                    else_block=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block.add(else_block.getTree());

                    }
                    break;

            }

            string_literal61=(Token)match(input,85,FOLLOW_85_in_if_statement1031); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(string_literal61);



            // AST REWRITE
            // elements: if_block, statement, else_block
            // token labels: 
            // rule labels: if_block, retval, else_block
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_if_block=new RewriteRuleSubtreeStream(adaptor,"rule if_block",if_block!=null?if_block.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_else_block=new RewriteRuleSubtreeStream(adaptor,"rule else_block",else_block!=null?else_block.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 160:15: -> ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:18: ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:23: ^( COND statement )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COND, "COND"), root_2);

                adaptor.addChild(root_2, stream_statement.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_if_block.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:51: ( ^( ELSE $else_block) )?
                if ( stream_else_block.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:51: ^( ELSE $else_block)
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ELSE, "ELSE"), root_2);

                    adaptor.addChild(root_2, stream_else_block.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_else_block.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "if_statement"

    public static class foreach_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "foreach_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:163:1: foreach_statement : 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) ;
    public final GremlinParser.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinParser.foreach_statement_return retval = new GremlinParser.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal62=null;
        Token VARIABLE63=null;
        Token string_literal64=null;
        Token NEWLINE66=null;
        Token string_literal68=null;
        GremlinParser.statement_return statement65 = null;

        GremlinParser.block_return block67 = null;


        CommonTree string_literal62_tree=null;
        CommonTree VARIABLE63_tree=null;
        CommonTree string_literal64_tree=null;
        CommonTree NEWLINE66_tree=null;
        CommonTree string_literal68_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:164:2: ( 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:164:4: 'foreach' VARIABLE 'in' statement NEWLINE block 'end'
            {
            string_literal62=(Token)match(input,74,FOLLOW_74_in_foreach_statement1065); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(string_literal62);

            VARIABLE63=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement1067); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE63);

            string_literal64=(Token)match(input,75,FOLLOW_75_in_foreach_statement1069); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal64);

            pushFollow(FOLLOW_statement_in_foreach_statement1071);
            statement65=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement65.getTree());
            NEWLINE66=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_foreach_statement1073); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE66);

            pushFollow(FOLLOW_block_in_foreach_statement1084);
            block67=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block67.getTree());
            string_literal68=(Token)match(input,85,FOLLOW_85_in_foreach_statement1092); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(string_literal68);



            // AST REWRITE
            // elements: statement, VARIABLE, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 166:12: -> ^( FOREACH VARIABLE statement block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:166:15: ^( FOREACH VARIABLE statement block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOREACH, "FOREACH"), root_1);

                adaptor.addChild(root_1, stream_VARIABLE.nextNode());
                adaptor.addChild(root_1, stream_statement.nextTree());
                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "foreach_statement"

    public static class while_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "while_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:1: while_statement : 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) ;
    public final GremlinParser.while_statement_return while_statement() throws RecognitionException {
        GremlinParser.while_statement_return retval = new GremlinParser.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal69=null;
        Token NEWLINE71=null;
        Token string_literal73=null;
        GremlinParser.statement_return statement70 = null;

        GremlinParser.block_return block72 = null;


        CommonTree string_literal69_tree=null;
        CommonTree NEWLINE71_tree=null;
        CommonTree string_literal73_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:170:2: ( 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:170:4: 'while' statement NEWLINE block 'end'
            {
            string_literal69=(Token)match(input,73,FOLLOW_73_in_while_statement1116); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_73.add(string_literal69);

            pushFollow(FOLLOW_statement_in_while_statement1118);
            statement70=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement70.getTree());
            NEWLINE71=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_while_statement1120); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE71);

            pushFollow(FOLLOW_block_in_while_statement1131);
            block72=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block72.getTree());
            string_literal73=(Token)match(input,85,FOLLOW_85_in_while_statement1139); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(string_literal73);



            // AST REWRITE
            // elements: block, statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 172:12: -> ^( WHILE ^( COND statement ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:172:15: ^( WHILE ^( COND statement ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:172:23: ^( COND statement )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COND, "COND"), root_2);

                adaptor.addChild(root_2, stream_statement.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "while_statement"

    public static class repeat_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "repeat_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:175:1: repeat_statement : 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) ;
    public final GremlinParser.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinParser.repeat_statement_return retval = new GremlinParser.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal74=null;
        Token NEWLINE76=null;
        Token string_literal78=null;
        GremlinParser.statement_return statement75 = null;

        GremlinParser.block_return block77 = null;


        CommonTree string_literal74_tree=null;
        CommonTree NEWLINE76_tree=null;
        CommonTree string_literal78_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:176:2: ( 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:176:4: 'repeat' statement NEWLINE block 'end'
            {
            string_literal74=(Token)match(input,71,FOLLOW_71_in_repeat_statement1164); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal74);

            pushFollow(FOLLOW_statement_in_repeat_statement1166);
            statement75=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement75.getTree());
            NEWLINE76=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeat_statement1168); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE76);

            pushFollow(FOLLOW_block_in_repeat_statement1175);
            block77=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block77.getTree());
            string_literal78=(Token)match(input,85,FOLLOW_85_in_repeat_statement1179); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(string_literal78);



            // AST REWRITE
            // elements: statement, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 178:9: -> ^( REPEAT statement block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:178:12: ^( REPEAT statement block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REPEAT, "REPEAT"), root_1);

                adaptor.addChild(root_1, stream_statement.nextTree());
                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "repeat_statement"

    public static class native_step_definition_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "native_step_definition_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:181:1: native_step_definition_statement : 'step' IDENTIFIER NEWLINE block 'end' -> ^( NATIVE_STEP IDENTIFIER block ) ;
    public final GremlinParser.native_step_definition_statement_return native_step_definition_statement() throws RecognitionException {
        GremlinParser.native_step_definition_statement_return retval = new GremlinParser.native_step_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal79=null;
        Token IDENTIFIER80=null;
        Token NEWLINE81=null;
        Token string_literal83=null;
        GremlinParser.block_return block82 = null;


        CommonTree string_literal79_tree=null;
        CommonTree IDENTIFIER80_tree=null;
        CommonTree NEWLINE81_tree=null;
        CommonTree string_literal83_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:2: ( 'step' IDENTIFIER NEWLINE block 'end' -> ^( NATIVE_STEP IDENTIFIER block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:4: 'step' IDENTIFIER NEWLINE block 'end'
            {
            string_literal79=(Token)match(input,86,FOLLOW_86_in_native_step_definition_statement1201); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_86.add(string_literal79);

            IDENTIFIER80=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_native_step_definition_statement1203); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER80);

            NEWLINE81=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_native_step_definition_statement1205); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE81);

            pushFollow(FOLLOW_block_in_native_step_definition_statement1212);
            block82=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block82.getTree());
            string_literal83=(Token)match(input,85,FOLLOW_85_in_native_step_definition_statement1216); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(string_literal83);



            // AST REWRITE
            // elements: block, IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 184:9: -> ^( NATIVE_STEP IDENTIFIER block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:184:12: ^( NATIVE_STEP IDENTIFIER block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NATIVE_STEP, "NATIVE_STEP"), root_1);

                adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "native_step_definition_statement"

    public static class function_definition_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_definition_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:187:1: function_definition_statement : 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) ;
    public final GremlinParser.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinParser.function_definition_statement_return retval = new GremlinParser.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal84=null;
        Token char_literal86=null;
        Token char_literal88=null;
        Token NEWLINE89=null;
        Token string_literal91=null;
        GremlinParser.function_name_return function_name85 = null;

        GremlinParser.formal_arguments_return formal_arguments87 = null;

        GremlinParser.block_return block90 = null;


        CommonTree string_literal84_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree NEWLINE89_tree=null;
        CommonTree string_literal91_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_formal_arguments=new RewriteRuleSubtreeStream(adaptor,"rule formal_arguments");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:188:2: ( 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:188:4: 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end'
            {
            string_literal84=(Token)match(input,87,FOLLOW_87_in_function_definition_statement1238); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(string_literal84);

            pushFollow(FOLLOW_function_name_in_function_definition_statement1240);
            function_name85=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name85.getTree());
            char_literal86=(Token)match(input,69,FOLLOW_69_in_function_definition_statement1242); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(char_literal86);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:188:29: ( formal_arguments )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==VARIABLE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: formal_arguments
            	    {
            	    pushFollow(FOLLOW_formal_arguments_in_function_definition_statement1244);
            	    formal_arguments87=formal_arguments();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formal_arguments.add(formal_arguments87.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            char_literal88=(Token)match(input,70,FOLLOW_70_in_function_definition_statement1247); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(char_literal88);

            NEWLINE89=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function_definition_statement1249); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE89);

            pushFollow(FOLLOW_block_in_function_definition_statement1256);
            block90=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block90.getTree());
            string_literal91=(Token)match(input,85,FOLLOW_85_in_function_definition_statement1260); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(string_literal91);



            // AST REWRITE
            // elements: function_name, formal_arguments, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 190:9: -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:190:12: ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC, "FUNC"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:190:33: ^( ARGS ( formal_arguments )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:190:40: ( formal_arguments )*
                while ( stream_formal_arguments.hasNext() ) {
                    adaptor.addChild(root_2, stream_formal_arguments.nextTree());

                }
                stream_formal_arguments.reset();

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_definition_statement"

    public static class formal_arguments_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formal_arguments"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:193:1: formal_arguments : VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ ;
    public final GremlinParser.formal_arguments_return formal_arguments() throws RecognitionException {
        GremlinParser.formal_arguments_return retval = new GremlinParser.formal_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLE92=null;
        Token char_literal93=null;
        Token VARIABLE94=null;

        CommonTree VARIABLE92_tree=null;
        CommonTree char_literal93_tree=null;
        CommonTree VARIABLE94_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:194:2: ( VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:194:4: VARIABLE ( ',' VARIABLE )*
            {
            VARIABLE92=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments1290); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE92);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:194:13: ( ',' VARIABLE )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==88) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:194:14: ',' VARIABLE
            	    {
            	    char_literal93=(Token)match(input,88,FOLLOW_88_in_formal_arguments1293); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_88.add(char_literal93);

            	    VARIABLE94=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments1295); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE94);


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);



            // AST REWRITE
            // elements: VARIABLE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 194:29: -> ( ^( ARG VARIABLE ) )+
            {
                if ( !(stream_VARIABLE.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_VARIABLE.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:194:32: ^( ARG VARIABLE )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARG, "ARG"), root_1);

                    adaptor.addChild(root_1, stream_VARIABLE.nextNode());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_VARIABLE.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "formal_arguments"

    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:197:1: block : ( block_body | NEWLINE )* -> ^( BLOCK ( block_body )* ) ;
    public final GremlinParser.block_return block() throws RecognitionException {
        GremlinParser.block_return retval = new GremlinParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE96=null;
        GremlinParser.block_body_return block_body95 = null;


        CommonTree NEWLINE96_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_block_body=new RewriteRuleSubtreeStream(adaptor,"rule block_body");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:198:5: ( ( block_body | NEWLINE )* -> ^( BLOCK ( block_body )* ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:198:7: ( block_body | NEWLINE )*
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:198:7: ( block_body | NEWLINE )*
            loop16:
            do {
                int alt16=3;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==NULL||LA16_0==COMMENT||(LA16_0>=G_INT && LA16_0<=BOOLEAN)||(LA16_0>=68 && LA16_0<=69)||LA16_0==71||(LA16_0>=73 && LA16_0<=74)||(LA16_0>=81 && LA16_0<=83)||(LA16_0>=86 && LA16_0<=87)) ) {
                    alt16=1;
                }
                else if ( (LA16_0==NEWLINE) ) {
                    alt16=2;
                }


                switch (alt16) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:198:8: block_body
            	    {
            	    pushFollow(FOLLOW_block_body_in_block1322);
            	    block_body95=block_body();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_block_body.add(block_body95.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:198:21: NEWLINE
            	    {
            	    NEWLINE96=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block1326); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE96);


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);



            // AST REWRITE
            // elements: block_body
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 198:31: -> ^( BLOCK ( block_body )* )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:198:34: ^( BLOCK ( block_body )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:198:42: ( block_body )*
                while ( stream_block_body.hasNext() ) {
                    adaptor.addChild(root_1, stream_block_body.nextTree());

                }
                stream_block_body.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class block_body_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block_body"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:201:1: block_body : ( statement | COMMENT NEWLINE );
    public final GremlinParser.block_body_return block_body() throws RecognitionException {
        GremlinParser.block_body_return retval = new GremlinParser.block_body_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMENT98=null;
        Token NEWLINE99=null;
        GremlinParser.statement_return statement97 = null;


        CommonTree COMMENT98_tree=null;
        CommonTree NEWLINE99_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:202:5: ( statement | COMMENT NEWLINE )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==NULL||(LA17_0>=G_INT && LA17_0<=BOOLEAN)||(LA17_0>=68 && LA17_0<=69)||LA17_0==71||(LA17_0>=73 && LA17_0<=74)||(LA17_0>=81 && LA17_0<=83)||(LA17_0>=86 && LA17_0<=87)) ) {
                alt17=1;
            }
            else if ( (LA17_0==COMMENT) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:202:7: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_block_body1351);
                    statement97=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement97.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:7: COMMENT NEWLINE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    COMMENT98=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_block_body1359); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMENT98_tree = (CommonTree)adaptor.create(COMMENT98);
                    adaptor.addChild(root_0, COMMENT98_tree);
                    }
                    NEWLINE99=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block_body1361); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEWLINE99_tree = (CommonTree)adaptor.create(NEWLINE99);
                    adaptor.addChild(root_0, NEWLINE99_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block_body"

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:206:1: expression : operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* ;
    public final GremlinParser.expression_return expression() throws RecognitionException {
        GremlinParser.expression_return retval = new GremlinParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal101=null;
        Token string_literal102=null;
        Token char_literal103=null;
        Token string_literal104=null;
        Token char_literal105=null;
        Token string_literal106=null;
        GremlinParser.operation_return operation100 = null;

        GremlinParser.operation_return operation107 = null;


        CommonTree char_literal101_tree=null;
        CommonTree string_literal102_tree=null;
        CommonTree char_literal103_tree=null;
        CommonTree string_literal104_tree=null;
        CommonTree char_literal105_tree=null;
        CommonTree string_literal106_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:2: ( operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:4: operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_operation_in_expression1375);
            operation100=operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, operation100.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:14: ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=89 && LA19_0<=94)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' )
            	    int alt18=6;
            	    switch ( input.LA(1) ) {
            	    case 89:
            	        {
            	        alt18=1;
            	        }
            	        break;
            	    case 90:
            	        {
            	        alt18=2;
            	        }
            	        break;
            	    case 91:
            	        {
            	        alt18=3;
            	        }
            	        break;
            	    case 92:
            	        {
            	        alt18=4;
            	        }
            	        break;
            	    case 93:
            	        {
            	        alt18=5;
            	        }
            	        break;
            	    case 94:
            	        {
            	        alt18=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt18) {
            	        case 1 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:16: '='
            	            {
            	            char_literal101=(Token)match(input,89,FOLLOW_89_in_expression1379); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal101_tree = (CommonTree)adaptor.create(char_literal101);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal101_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:23: '!='
            	            {
            	            string_literal102=(Token)match(input,90,FOLLOW_90_in_expression1384); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal102_tree = (CommonTree)adaptor.create(string_literal102);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal102_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:31: '<'
            	            {
            	            char_literal103=(Token)match(input,91,FOLLOW_91_in_expression1389); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal103_tree = (CommonTree)adaptor.create(char_literal103);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal103_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:38: '<='
            	            {
            	            string_literal104=(Token)match(input,92,FOLLOW_92_in_expression1394); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal104_tree = (CommonTree)adaptor.create(string_literal104);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal104_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:46: '>'
            	            {
            	            char_literal105=(Token)match(input,93,FOLLOW_93_in_expression1399); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal105_tree = (CommonTree)adaptor.create(char_literal105);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal105_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:53: '>='
            	            {
            	            string_literal106=(Token)match(input,94,FOLLOW_94_in_expression1404); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal106_tree = (CommonTree)adaptor.create(string_literal106);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal106_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_operation_in_expression1408);
            	    operation107=operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, operation107.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class operation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operation"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:210:1: operation : binary_operation ( ( '+' | '-' ) binary_operation )* ;
    public final GremlinParser.operation_return operation() throws RecognitionException {
        GremlinParser.operation_return retval = new GremlinParser.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal109=null;
        Token char_literal110=null;
        GremlinParser.binary_operation_return binary_operation108 = null;

        GremlinParser.binary_operation_return binary_operation111 = null;


        CommonTree char_literal109_tree=null;
        CommonTree char_literal110_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:2: ( binary_operation ( ( '+' | '-' ) binary_operation )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:4: binary_operation ( ( '+' | '-' ) binary_operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_binary_operation_in_operation1421);
            binary_operation108=binary_operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation108.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:21: ( ( '+' | '-' ) binary_operation )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=95 && LA21_0<=96)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:22: ( '+' | '-' ) binary_operation
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:22: ( '+' | '-' )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==95) ) {
            	        alt20=1;
            	    }
            	    else if ( (LA20_0==96) ) {
            	        alt20=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:23: '+'
            	            {
            	            char_literal109=(Token)match(input,95,FOLLOW_95_in_operation1425); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal109_tree = (CommonTree)adaptor.create(char_literal109);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal109_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:28: '-'
            	            {
            	            char_literal110=(Token)match(input,96,FOLLOW_96_in_operation1428); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal110_tree = (CommonTree)adaptor.create(char_literal110);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal110_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_binary_operation_in_operation1432);
            	    binary_operation111=binary_operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation111.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operation"

    public static class binary_operation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "binary_operation"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:214:1: binary_operation : atom ( ( '*' | 'div' | 'mod' ) atom )* ;
    public final GremlinParser.binary_operation_return binary_operation() throws RecognitionException {
        GremlinParser.binary_operation_return retval = new GremlinParser.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal113=null;
        Token string_literal114=null;
        Token string_literal115=null;
        GremlinParser.atom_return atom112 = null;

        GremlinParser.atom_return atom116 = null;


        CommonTree char_literal113_tree=null;
        CommonTree string_literal114_tree=null;
        CommonTree string_literal115_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:2: ( atom ( ( '*' | 'div' | 'mod' ) atom )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:4: atom ( ( '*' | 'div' | 'mod' ) atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_binary_operation1446);
            atom112=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom112.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:9: ( ( '*' | 'div' | 'mod' ) atom )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=97 && LA23_0<=99)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:10: ( '*' | 'div' | 'mod' ) atom
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:10: ( '*' | 'div' | 'mod' )
            	    int alt22=3;
            	    switch ( input.LA(1) ) {
            	    case 97:
            	        {
            	        alt22=1;
            	        }
            	        break;
            	    case 98:
            	        {
            	        alt22=2;
            	        }
            	        break;
            	    case 99:
            	        {
            	        alt22=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt22) {
            	        case 1 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:11: '*'
            	            {
            	            char_literal113=(Token)match(input,97,FOLLOW_97_in_binary_operation1450); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal113_tree = (CommonTree)adaptor.create(char_literal113);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal113_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:16: 'div'
            	            {
            	            string_literal114=(Token)match(input,98,FOLLOW_98_in_binary_operation1453); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal114_tree = (CommonTree)adaptor.create(string_literal114);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal114_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:23: 'mod'
            	            {
            	            string_literal115=(Token)match(input,99,FOLLOW_99_in_binary_operation1456); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal115_tree = (CommonTree)adaptor.create(string_literal115);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal115_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_atom_in_binary_operation1460);
            	    atom116=atom();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom116.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "binary_operation"

    public static class function_call_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_call"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:218:1: function_call : function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) ;
    public final GremlinParser.function_call_return function_call() throws RecognitionException {
        GremlinParser.function_call_return retval = new GremlinParser.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal118=null;
        Token char_literal120=null;
        GremlinParser.function_name_return function_name117 = null;

        GremlinParser.function_call_params_return function_call_params119 = null;


        CommonTree char_literal118_tree=null;
        CommonTree char_literal120_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleSubtreeStream stream_function_call_params=new RewriteRuleSubtreeStream(adaptor,"rule function_call_params");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:219:2: ( function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:219:4: function_name '(' ( function_call_params )* ')'
            {
            pushFollow(FOLLOW_function_name_in_function_call1474);
            function_name117=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name117.getTree());
            char_literal118=(Token)match(input,69,FOLLOW_69_in_function_call1476); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(char_literal118);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:219:22: ( function_call_params )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==NULL||(LA24_0>=G_INT && LA24_0<=BOOLEAN)||(LA24_0>=68 && LA24_0<=69)||LA24_0==71||(LA24_0>=73 && LA24_0<=74)||(LA24_0>=81 && LA24_0<=83)||(LA24_0>=86 && LA24_0<=87)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: function_call_params
            	    {
            	    pushFollow(FOLLOW_function_call_params_in_function_call1478);
            	    function_call_params119=function_call_params();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function_call_params.add(function_call_params119.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            char_literal120=(Token)match(input,70,FOLLOW_70_in_function_call1481); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(char_literal120);



            // AST REWRITE
            // elements: function_name, function_call_params
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 219:48: -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:219:51: ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:219:77: ^( ARGS ( function_call_params )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:219:84: ( function_call_params )*
                while ( stream_function_call_params.hasNext() ) {
                    adaptor.addChild(root_2, stream_function_call_params.nextTree());

                }
                stream_function_call_params.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_call"

    public static class function_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_name"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:222:1: function_name : ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) ;
    public final GremlinParser.function_name_return function_name() throws RecognitionException {
        GremlinParser.function_name_return retval = new GremlinParser.function_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ns=null;
        Token ln=null;
        Token char_literal121=null;

        CommonTree ns_tree=null;
        CommonTree ln_tree=null;
        CommonTree char_literal121_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:223:2: (ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:223:4: ns= IDENTIFIER ':' ln= IDENTIFIER
            {
            ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name1510); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(ns);

            char_literal121=(Token)match(input,100,FOLLOW_100_in_function_name1512); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_100.add(char_literal121);

            ln=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name1516); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(ln);



            // AST REWRITE
            // elements: ln, ns
            // token labels: ln, ns
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_ln=new RewriteRuleTokenStream(adaptor,"token ln",ln);
            RewriteRuleTokenStream stream_ns=new RewriteRuleTokenStream(adaptor,"token ns",ns);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 223:36: -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:223:39: ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_NAME, "FUNC_NAME"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:223:51: ^( NS $ns)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NS, "NS"), root_2);

                adaptor.addChild(root_2, stream_ns.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:223:61: ^( NAME $ln)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAME, "NAME"), root_2);

                adaptor.addChild(root_2, stream_ln.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_name"

    public static class function_call_params_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_call_params"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:226:1: function_call_params : function_call_param ( ',' function_call_param )* -> ( ^( ARG function_call_param ) )+ ;
    public final GremlinParser.function_call_params_return function_call_params() throws RecognitionException {
        GremlinParser.function_call_params_return retval = new GremlinParser.function_call_params_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal123=null;
        GremlinParser.function_call_param_return function_call_param122 = null;

        GremlinParser.function_call_param_return function_call_param124 = null;


        CommonTree char_literal123_tree=null;
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleSubtreeStream stream_function_call_param=new RewriteRuleSubtreeStream(adaptor,"rule function_call_param");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:227:2: ( function_call_param ( ',' function_call_param )* -> ( ^( ARG function_call_param ) )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:227:4: function_call_param ( ',' function_call_param )*
            {
            pushFollow(FOLLOW_function_call_param_in_function_call_params1551);
            function_call_param122=function_call_param();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_call_param.add(function_call_param122.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:227:24: ( ',' function_call_param )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==88) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:227:25: ',' function_call_param
            	    {
            	    char_literal123=(Token)match(input,88,FOLLOW_88_in_function_call_params1554); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_88.add(char_literal123);

            	    pushFollow(FOLLOW_function_call_param_in_function_call_params1556);
            	    function_call_param124=function_call_param();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function_call_param.add(function_call_param124.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);



            // AST REWRITE
            // elements: function_call_param
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 227:51: -> ( ^( ARG function_call_param ) )+
            {
                if ( !(stream_function_call_param.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_function_call_param.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:227:54: ^( ARG function_call_param )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARG, "ARG"), root_1);

                    adaptor.addChild(root_1, stream_function_call_param.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_function_call_param.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_call_params"

    public static class function_call_param_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_call_param"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:230:1: function_call_param : statement ;
    public final GremlinParser.function_call_param_return function_call_param() throws RecognitionException {
        GremlinParser.function_call_param_return retval = new GremlinParser.function_call_param_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GremlinParser.statement_return statement125 = null;



        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:231:5: ( statement )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:231:7: statement
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_statement_in_function_call_param1581);
            statement125=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement125.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_call_param"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:234:1: atom : ( gpath_statement | G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | NULL );
    public final GremlinParser.atom_return atom() throws RecognitionException {
        GremlinParser.atom_return retval = new GremlinParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token G_INT127=null;
        Token G_LONG128=null;
        Token G_FLOAT129=null;
        Token G_DOUBLE130=null;
        Token NULL131=null;
        GremlinParser.gpath_statement_return gpath_statement126 = null;


        CommonTree G_INT127_tree=null;
        CommonTree G_LONG128_tree=null;
        CommonTree G_FLOAT129_tree=null;
        CommonTree G_DOUBLE130_tree=null;
        CommonTree NULL131_tree=null;
        RewriteRuleTokenStream stream_G_LONG=new RewriteRuleTokenStream(adaptor,"token G_LONG");
        RewriteRuleTokenStream stream_G_DOUBLE=new RewriteRuleTokenStream(adaptor,"token G_DOUBLE");
        RewriteRuleTokenStream stream_G_FLOAT=new RewriteRuleTokenStream(adaptor,"token G_FLOAT");
        RewriteRuleTokenStream stream_G_INT=new RewriteRuleTokenStream(adaptor,"token G_INT");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:235:2: ( gpath_statement | G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | NULL )
            int alt26=6;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:235:6: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_gpath_statement_in_atom1598);
                    gpath_statement126=gpath_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gpath_statement126.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:236:9: G_INT
                    {
                    G_INT127=(Token)match(input,G_INT,FOLLOW_G_INT_in_atom1608); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_INT.add(G_INT127);



                    // AST REWRITE
                    // elements: G_INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 236:25: -> ^( INT G_INT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:236:28: ^( INT G_INT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INT, "INT"), root_1);

                        adaptor.addChild(root_1, stream_G_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:237:6: G_LONG
                    {
                    G_LONG128=(Token)match(input,G_LONG,FOLLOW_G_LONG_in_atom1633); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_LONG.add(G_LONG128);



                    // AST REWRITE
                    // elements: G_LONG
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 237:22: -> ^( LONG G_LONG )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:237:25: ^( LONG G_LONG )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LONG, "LONG"), root_1);

                        adaptor.addChild(root_1, stream_G_LONG.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:238:6: G_FLOAT
                    {
                    G_FLOAT129=(Token)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_atom1657); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_FLOAT.add(G_FLOAT129);



                    // AST REWRITE
                    // elements: G_FLOAT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 238:22: -> ^( FLOAT G_FLOAT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:238:25: ^( FLOAT G_FLOAT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FLOAT, "FLOAT"), root_1);

                        adaptor.addChild(root_1, stream_G_FLOAT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:239:6: G_DOUBLE
                    {
                    G_DOUBLE130=(Token)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_atom1680); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_DOUBLE.add(G_DOUBLE130);



                    // AST REWRITE
                    // elements: G_DOUBLE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 239:22: -> ^( DOUBLE G_DOUBLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:239:25: ^( DOUBLE G_DOUBLE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DOUBLE, "DOUBLE"), root_1);

                        adaptor.addChild(root_1, stream_G_DOUBLE.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:240:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NULL131=(Token)match(input,NULL,FOLLOW_NULL_in_atom1705); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL131_tree = (CommonTree)adaptor.create(NULL131);
                    adaptor.addChild(root_0, NULL131_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    // $ANTLR start synpred29_Gremlin
    public final void synpred29_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:143:9: ( atom ':=' statement )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:143:9: atom ':=' statement
        {
        pushFollow(FOLLOW_atom_in_synpred29_Gremlin876);
        atom();

        state._fsp--;
        if (state.failed) return ;
        match(input,78,FOLLOW_78_in_synpred29_Gremlin878); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred29_Gremlin880);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_Gremlin

    // $ANTLR start synpred51_Gremlin
    public final void synpred51_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:235:6: ( gpath_statement )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:235:6: gpath_statement
        {
        pushFollow(FOLLOW_gpath_statement_in_synpred51_Gremlin1598);
        gpath_statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_Gremlin

    // $ANTLR start synpred52_Gremlin
    public final void synpred52_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:236:9: ( G_INT )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:236:9: G_INT
        {
        match(input,G_INT,FOLLOW_G_INT_in_synpred52_Gremlin1608); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_Gremlin

    // $ANTLR start synpred53_Gremlin
    public final void synpred53_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:237:6: ( G_LONG )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:237:6: G_LONG
        {
        match(input,G_LONG,FOLLOW_G_LONG_in_synpred53_Gremlin1633); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_Gremlin

    // $ANTLR start synpred54_Gremlin
    public final void synpred54_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:238:6: ( G_FLOAT )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:238:6: G_FLOAT
        {
        match(input,G_FLOAT,FOLLOW_G_FLOAT_in_synpred54_Gremlin1657); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_Gremlin

    // $ANTLR start synpred55_Gremlin
    public final void synpred55_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:239:6: ( G_DOUBLE )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:239:6: G_DOUBLE
        {
        match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_synpred55_Gremlin1680); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_Gremlin

    // Delegated rules

    public final boolean synpred29_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA8 dfa8 = new DFA8(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA8_eotS =
        "\16\uffff";
    static final String DFA8_eofS =
        "\5\uffff\1\15\10\uffff";
    static final String DFA8_minS =
        "\1\54\4\uffff\1\45\10\uffff";
    static final String DFA8_maxS =
        "\1\105\4\uffff\1\144\10\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\7\1\10\1\12\1\13\1\14\1\5"+
        "\1\11";
    static final String DFA8_specialS =
        "\16\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\1\2\1\3\1\4\1\6\1\7\1\10\1\5\1\12\17\uffff\1\11\1\13",
            "",
            "",
            "",
            "",
            "\1\15\4\uffff\13\15\14\uffff\12\15\1\uffff\30\15\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "109:1: token : ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | function_call | StringLiteral -> ^( STR StringLiteral ) | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | '..' | b= BOOLEAN -> ^( BOOL $b) | '(' statement ')' );";
        }
    }
    static final String DFA12_eotS =
        "\27\uffff";
    static final String DFA12_eofS =
        "\27\uffff";
    static final String DFA12_minS =
        "\1\45\10\uffff\14\0\2\uffff";
    static final String DFA12_maxS =
        "\1\127\10\uffff\14\0\2\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\14\uffff\1\11\1\12";
    static final String DFA12_specialS =
        "\11\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\2"+
        "\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\24\6\uffff\1\11\1\12\1\13\1\14\1\16\1\17\1\20\1\15\1\22\17"+
            "\uffff\1\21\1\23\1\uffff\1\4\1\uffff\1\3\1\2\6\uffff\1\7\1\10"+
            "\1\1\2\uffff\1\5\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
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
            return "134:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | native_step_definition_statement | function_definition_statement | include_statement | script_statement | atom ':=' statement -> ^( VAR atom statement ) | expression ( ( 'and' | 'or' ) expression )* );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_9 = input.LA(1);

                         
                        int index12_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_10 = input.LA(1);

                         
                        int index12_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_11 = input.LA(1);

                         
                        int index12_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_12 = input.LA(1);

                         
                        int index12_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_12);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA12_13 = input.LA(1);

                         
                        int index12_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_13);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA12_14 = input.LA(1);

                         
                        int index12_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_14);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA12_15 = input.LA(1);

                         
                        int index12_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_15);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA12_16 = input.LA(1);

                         
                        int index12_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_16);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA12_17 = input.LA(1);

                         
                        int index12_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_17);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA12_18 = input.LA(1);

                         
                        int index12_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_18);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA12_19 = input.LA(1);

                         
                        int index12_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_19);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA12_20 = input.LA(1);

                         
                        int index12_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index12_20);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA26_eotS =
        "\13\uffff";
    static final String DFA26_eofS =
        "\13\uffff";
    static final String DFA26_minS =
        "\1\45\4\0\6\uffff";
    static final String DFA26_maxS =
        "\1\105\4\0\6\uffff";
    static final String DFA26_acceptS =
        "\5\uffff\1\1\1\6\1\2\1\3\1\4\1\5";
    static final String DFA26_specialS =
        "\1\uffff\1\1\1\2\1\0\1\3\6\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\6\6\uffff\1\1\1\2\1\3\1\4\5\5\17\uffff\2\5",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "234:1: atom : ( gpath_statement | G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | NULL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_3 = input.LA(1);

                         
                        int index26_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_Gremlin()) ) {s = 5;}

                        else if ( (synpred54_Gremlin()) ) {s = 9;}

                         
                        input.seek(index26_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_1 = input.LA(1);

                         
                        int index26_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_Gremlin()) ) {s = 5;}

                        else if ( (synpred52_Gremlin()) ) {s = 7;}

                         
                        input.seek(index26_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA26_2 = input.LA(1);

                         
                        int index26_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_Gremlin()) ) {s = 5;}

                        else if ( (synpred53_Gremlin()) ) {s = 8;}

                         
                        input.seek(index26_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA26_4 = input.LA(1);

                         
                        int index26_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_Gremlin()) ) {s = 5;}

                        else if ( (synpred55_Gremlin()) ) {s = 10;}

                         
                        input.seek(index26_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_COMMENT_in_program315 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_statement_in_program327 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_program330 = new BitSet(new long[]{0x001FF82000000002L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_step_in_gpath_statement372 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_gpath_statement375 = new BitSet(new long[]{0x001FF00000000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_step_in_gpath_statement377 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_token_in_step403 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001004L});
    public static final BitSet FOLLOW_66_in_step406 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_step408 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_step410 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001004L});
    public static final BitSet FOLLOW_inline_loop_statement_in_step416 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_G_INT_in_token470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_LONG_in_token495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_FLOAT_in_token519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_DOUBLE_in_token542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_token567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_token577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROPERTY_in_token590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_token607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_token629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_token639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_token651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_token674 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_token677 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_token679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_inline_loop_definition694 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_inline_loop_definition699 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_inline_loop_definition701 = new BitSet(new long[]{0x001FFC2000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_block_in_inline_loop_definition703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_inline_loop_definition723 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_inline_loop_definition729 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_inline_loop_definition731 = new BitSet(new long[]{0x001FFC2000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_block_in_inline_loop_definition733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_inline_loop_definition756 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_inline_loop_definition758 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_inline_loop_definition760 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_inline_loop_definition764 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_inline_loop_definition766 = new BitSet(new long[]{0x001FFC2000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_block_in_inline_loop_definition768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_inline_loop_statement799 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000680L});
    public static final BitSet FOLLOW_inline_loop_definition_in_inline_loop_statement803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_inline_loop_statement805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_step_definition_statement_in_statement849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_script_statement_in_statement866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_statement876 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_statement878 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_statement880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement897 = new BitSet(new long[]{0x0000000000000002L,0x0000000000018000L});
    public static final BitSet FOLLOW_79_in_statement901 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_80_in_statement904 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_expression_in_statement908 = new BitSet(new long[]{0x0000000000000002L,0x0000000000018000L});
    public static final BitSet FOLLOW_81_in_include_statement921 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_script_statement947 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_script_statement949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_if_statement973 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_if_statement975 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_if_statement977 = new BitSet(new long[]{0x001FFC2000000000L,0x0000000000FE06B0L});
    public static final BitSet FOLLOW_block_in_if_statement993 = new BitSet(new long[]{0x0000000000000000L,0x0000000000300000L});
    public static final BitSet FOLLOW_84_in_if_statement1004 = new BitSet(new long[]{0x001FFC2000000000L,0x0000000000EE06B0L});
    public static final BitSet FOLLOW_block_in_if_statement1019 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_if_statement1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_foreach_statement1065 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement1067 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_foreach_statement1069 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_foreach_statement1071 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_foreach_statement1073 = new BitSet(new long[]{0x001FFC2000000000L,0x0000000000EE06B0L});
    public static final BitSet FOLLOW_block_in_foreach_statement1084 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_foreach_statement1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_while_statement1116 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_while_statement1118 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_while_statement1120 = new BitSet(new long[]{0x001FFC2000000000L,0x0000000000EE06B0L});
    public static final BitSet FOLLOW_block_in_while_statement1131 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_while_statement1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_repeat_statement1164 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_repeat_statement1166 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeat_statement1168 = new BitSet(new long[]{0x001FFC2000000000L,0x0000000000EE06B0L});
    public static final BitSet FOLLOW_block_in_repeat_statement1175 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_repeat_statement1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_native_step_definition_statement1201 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_native_step_definition_statement1203 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_native_step_definition_statement1205 = new BitSet(new long[]{0x001FFC2000000000L,0x0000000000EE06B0L});
    public static final BitSet FOLLOW_block_in_native_step_definition_statement1212 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_native_step_definition_statement1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_function_definition_statement1238 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_function_name_in_function_definition_statement1240 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_function_definition_statement1242 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formal_arguments_in_function_definition_statement1244 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_function_definition_statement1247 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_function_definition_statement1249 = new BitSet(new long[]{0x001FFC2000000000L,0x0000000000EE06B0L});
    public static final BitSet FOLLOW_block_in_function_definition_statement1256 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_function_definition_statement1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments1290 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_formal_arguments1293 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments1295 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_block_body_in_block1322 = new BitSet(new long[]{0x001FFC2000000002L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_NEWLINE_in_block1326 = new BitSet(new long[]{0x001FFC2000000002L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_block_body1351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_block_body1359 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_block_body1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operation_in_expression1375 = new BitSet(new long[]{0x0000000000000002L,0x000000007E000000L});
    public static final BitSet FOLLOW_89_in_expression1379 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_90_in_expression1384 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_91_in_expression1389 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_92_in_expression1394 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_93_in_expression1399 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_94_in_expression1404 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_operation_in_expression1408 = new BitSet(new long[]{0x0000000000000002L,0x000000007E000000L});
    public static final BitSet FOLLOW_binary_operation_in_operation1421 = new BitSet(new long[]{0x0000000000000002L,0x0000000180000000L});
    public static final BitSet FOLLOW_95_in_operation1425 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_96_in_operation1428 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_binary_operation_in_operation1432 = new BitSet(new long[]{0x0000000000000002L,0x0000000180000000L});
    public static final BitSet FOLLOW_atom_in_binary_operation1446 = new BitSet(new long[]{0x0000000000000002L,0x0000000E00000000L});
    public static final BitSet FOLLOW_97_in_binary_operation1450 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_98_in_binary_operation1453 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_99_in_binary_operation1456 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_atom_in_binary_operation1460 = new BitSet(new long[]{0x0000000000000002L,0x0000000E00000000L});
    public static final BitSet FOLLOW_function_name_in_function_call1474 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_function_call1476 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06F0L});
    public static final BitSet FOLLOW_function_call_params_in_function_call1478 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06F0L});
    public static final BitSet FOLLOW_70_in_function_call1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name1510 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_function_name1512 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_param_in_function_call_params1551 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_function_call_params1554 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_function_call_param_in_function_call_params1556 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_statement_in_function_call_param1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_atom1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_INT_in_atom1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_LONG_in_atom1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_FLOAT_in_atom1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_DOUBLE_in_atom1680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_atom1705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_synpred29_Gremlin876 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_synpred29_Gremlin878 = new BitSet(new long[]{0x001FF02000000000L,0x0000000000CE06B0L});
    public static final BitSet FOLLOW_statement_in_synpred29_Gremlin880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_synpred51_Gremlin1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_INT_in_synpred52_Gremlin1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_LONG_in_synpred53_Gremlin1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_FLOAT_in_synpred54_Gremlin1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_DOUBLE_in_synpred55_Gremlin1680 = new BitSet(new long[]{0x0000000000000002L});

}
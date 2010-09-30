// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g 2010-09-30 18:22:36

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "GPATH", "NATIVE_STEP", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "SELF", "HISTORY", "FUNC_CALL", "IF", "ELSE", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "SCRIPT", "INT", "LONG", "FLOAT", "DOUBLE", "STR", "ARR", "BOOL", "NULL", "RANGE", "PROPERTY_CALL", "VARIABLE_CALL", "COLLECTION_CALL", "COMMENT", "NEWLINE", "G_INT", "G_LONG", "G_FLOAT", "G_DOUBLE", "StringLiteral", "PROPERTY", "VARIABLE", "IDENTIFIER", "BOOLEAN", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "'/'", "'['", "']'", "'..'", "'('", "')'", "':='", "'and'", "'or'", "'include'", "'script'", "'if'", "'else'", "'end'", "'foreach'", "'in'", "'while'", "'repeat'", "'step'", "'func'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "'mod'", "':'"
    };
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
    public static final int G_INT=43;
    public static final int SingleEscapeCharacter=59;
    public static final int INCLUDE=27;
    public static final int ARGS=6;
    public static final int DOUBLE=32;
    public static final int VAR=4;
    public static final int GPATH=11;
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
    public static final int ARR=34;
    public static final int DoubleStringCharacter=52;
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
    public static final int VARIABLE=49;
    public static final int T__70=70;
    public static final int G_DOUBLE=46;
    public static final int PROPERTY=48;
    public static final int FUNC=7;
    public static final int G_LONG=44;
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
    public static final int IDENTIFIER=50;
    public static final int EscapeCharacter=61;
    public static final int NATIVE_STEP=12;
    public static final int COLLECTION_CALL=40;
    public static final int G_FLOAT=45;
    public static final int PROPERTY_CALL=38;
    public static final int UnicodeEscapeSequence=58;
    public static final int RANGE=37;
    public static final int StringLiteral=47;
    public static final int NEWLINE=42;
    public static final int BLOCK=23;
    public static final int NonEscapeCharacter=60;
    public static final int COND=22;
    public static final int LONG=30;
    public static final int SELF=17;
    public static final int VARIABLE_CALL=39;

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:89:1: program : ( ( COMMENT )+ | ( ( statement )? NEWLINE )+ );
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:5: ( ( COMMENT )+ | ( ( statement )? NEWLINE )+ )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==COMMENT) ) {
                alt4=1;
            }
            else if ( (LA4_0==NULL||(LA4_0>=NEWLINE && LA4_0<=BOOLEAN)||(LA4_0>=67 && LA4_0<=68)||(LA4_0>=73 && LA4_0<=75)||LA4_0==78||(LA4_0>=80 && LA4_0<=83)) ) {
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:7: ( COMMENT )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:7: ( COMMENT )+
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
                    	    COMMENT1=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_program307); if (state.failed) return retval;
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:91:9: ( ( statement )? NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:91:9: ( ( statement )? NEWLINE )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NULL||(LA3_0>=NEWLINE && LA3_0<=BOOLEAN)||(LA3_0>=67 && LA3_0<=68)||(LA3_0>=73 && LA3_0<=75)||LA3_0==78||(LA3_0>=80 && LA3_0<=83)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:91:10: ( statement )? NEWLINE
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:91:10: ( statement )?
                    	    int alt2=2;
                    	    int LA2_0 = input.LA(1);

                    	    if ( (LA2_0==NULL||(LA2_0>=G_INT && LA2_0<=BOOLEAN)||(LA2_0>=67 && LA2_0<=68)||(LA2_0>=73 && LA2_0<=75)||LA2_0==78||(LA2_0>=80 && LA2_0<=83)) ) {
                    	        alt2=1;
                    	    }
                    	    switch (alt2) {
                    	        case 1 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: statement
                    	            {
                    	            pushFollow(FOLLOW_statement_in_program319);
                    	            statement2=statement();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement2.getTree());

                    	            }
                    	            break;

                    	    }

                    	    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program322); if (state.failed) return retval;
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:99:1: gpath_statement : step ( '/' step )* -> ^( GPATH ( step )+ ) ;
    public final GremlinParser.gpath_statement_return gpath_statement() throws RecognitionException {
        GremlinParser.gpath_statement_return retval = new GremlinParser.gpath_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal5=null;
        GremlinParser.step_return step4 = null;

        GremlinParser.step_return step6 = null;


        CommonTree char_literal5_tree=null;
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleSubtreeStream stream_step=new RewriteRuleSubtreeStream(adaptor,"rule step");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:5: ( step ( '/' step )* -> ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:7: step ( '/' step )*
            {
            pushFollow(FOLLOW_step_in_gpath_statement364);
            step4=step();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_step.add(step4.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:12: ( '/' step )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==64) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:13: '/' step
            	    {
            	    char_literal5=(Token)match(input,64,FOLLOW_64_in_gpath_statement367); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_64.add(char_literal5);

            	    pushFollow(FOLLOW_step_in_gpath_statement369);
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
            // 100:24: -> ^( GPATH ( step )+ )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:27: ^( GPATH ( step )+ )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:103:1: step : token ( '[' statement ']' )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) ;
    public final GremlinParser.step_return step() throws RecognitionException {
        GremlinParser.step_return retval = new GremlinParser.step_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal8=null;
        Token char_literal10=null;
        GremlinParser.token_return token7 = null;

        GremlinParser.statement_return statement9 = null;


        CommonTree char_literal8_tree=null;
        CommonTree char_literal10_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_token=new RewriteRuleSubtreeStream(adaptor,"rule token");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:5: ( token ( '[' statement ']' )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:7: token ( '[' statement ']' )*
            {
            pushFollow(FOLLOW_token_in_step395);
            token7=token();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_token.add(token7.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:13: ( '[' statement ']' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==65) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:14: '[' statement ']'
            	    {
            	    char_literal8=(Token)match(input,65,FOLLOW_65_in_step398); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_65.add(char_literal8);

            	    pushFollow(FOLLOW_statement_in_step400);
            	    statement9=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement9.getTree());
            	    char_literal10=(Token)match(input,66,FOLLOW_66_in_step402); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_66.add(char_literal10);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);



            // AST REWRITE
            // elements: token, statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 104:34: -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:37: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STEP, "STEP"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:44: ^( TOKEN token )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TOKEN, "TOKEN"), root_2);

                adaptor.addChild(root_2, stream_token.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:59: ^( PREDICATES ( ^( PREDICATE statement ) )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREDICATES, "PREDICATES"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:72: ( ^( PREDICATE statement ) )*
                while ( stream_statement.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:72: ^( PREDICATE statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:107:1: token : ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | function_call | StringLiteral -> ^( STR StringLiteral ) | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | '..' | b= BOOLEAN -> ^( BOOL $b) | '(' statement ')' );
    public final GremlinParser.token_return token() throws RecognitionException {
        GremlinParser.token_return retval = new GremlinParser.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token b=null;
        Token G_INT11=null;
        Token G_LONG12=null;
        Token G_FLOAT13=null;
        Token G_DOUBLE14=null;
        Token StringLiteral16=null;
        Token PROPERTY17=null;
        Token VARIABLE18=null;
        Token IDENTIFIER19=null;
        Token string_literal20=null;
        Token char_literal21=null;
        Token char_literal23=null;
        GremlinParser.function_call_return function_call15 = null;

        GremlinParser.statement_return statement22 = null;


        CommonTree b_tree=null;
        CommonTree G_INT11_tree=null;
        CommonTree G_LONG12_tree=null;
        CommonTree G_FLOAT13_tree=null;
        CommonTree G_DOUBLE14_tree=null;
        CommonTree StringLiteral16_tree=null;
        CommonTree PROPERTY17_tree=null;
        CommonTree VARIABLE18_tree=null;
        CommonTree IDENTIFIER19_tree=null;
        CommonTree string_literal20_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree char_literal23_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_G_LONG=new RewriteRuleTokenStream(adaptor,"token G_LONG");
        RewriteRuleTokenStream stream_BOOLEAN=new RewriteRuleTokenStream(adaptor,"token BOOLEAN");
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_G_DOUBLE=new RewriteRuleTokenStream(adaptor,"token G_DOUBLE");
        RewriteRuleTokenStream stream_PROPERTY=new RewriteRuleTokenStream(adaptor,"token PROPERTY");
        RewriteRuleTokenStream stream_G_FLOAT=new RewriteRuleTokenStream(adaptor,"token G_FLOAT");
        RewriteRuleTokenStream stream_G_INT=new RewriteRuleTokenStream(adaptor,"token G_INT");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:108:2: ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | function_call | StringLiteral -> ^( STR StringLiteral ) | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | '..' | b= BOOLEAN -> ^( BOOL $b) | '(' statement ')' )
            int alt7=12;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:108:6: G_INT
                    {
                    G_INT11=(Token)match(input,G_INT,FOLLOW_G_INT_in_token443); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_INT.add(G_INT11);



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
                    // 108:22: -> ^( INT G_INT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:108:25: ^( INT G_INT )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:109:6: G_LONG
                    {
                    G_LONG12=(Token)match(input,G_LONG,FOLLOW_G_LONG_in_token468); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_LONG.add(G_LONG12);



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
                    // 109:22: -> ^( LONG G_LONG )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:109:25: ^( LONG G_LONG )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:110:6: G_FLOAT
                    {
                    G_FLOAT13=(Token)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_token492); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_FLOAT.add(G_FLOAT13);



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
                    // 110:22: -> ^( FLOAT G_FLOAT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:110:25: ^( FLOAT G_FLOAT )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:111:6: G_DOUBLE
                    {
                    G_DOUBLE14=(Token)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_token515); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_DOUBLE.add(G_DOUBLE14);



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
                    // 111:22: -> ^( DOUBLE G_DOUBLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:111:25: ^( DOUBLE G_DOUBLE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:112:9: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_call_in_token540);
                    function_call15=function_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_call15.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:113:9: StringLiteral
                    {
                    StringLiteral16=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_token550); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral16);



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
                    // 113:23: -> ^( STR StringLiteral )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:113:26: ^( STR StringLiteral )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:114:4: PROPERTY
                    {
                    PROPERTY17=(Token)match(input,PROPERTY,FOLLOW_PROPERTY_in_token563); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROPERTY.add(PROPERTY17);



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
                    // 114:17: -> ^( PROPERTY_CALL PROPERTY )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:114:20: ^( PROPERTY_CALL PROPERTY )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:115:4: VARIABLE
                    {
                    VARIABLE18=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_token580); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE18);



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
                    // 115:20: -> ^( VARIABLE_CALL VARIABLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:115:23: ^( VARIABLE_CALL VARIABLE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:116:6: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IDENTIFIER19=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_token602); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER19_tree = (CommonTree)adaptor.create(IDENTIFIER19);
                    adaptor.addChild(root_0, IDENTIFIER19_tree);
                    }

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:117:9: '..'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal20=(Token)match(input,67,FOLLOW_67_in_token612); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal20_tree = (CommonTree)adaptor.create(string_literal20);
                    adaptor.addChild(root_0, string_literal20_tree);
                    }

                    }
                    break;
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:118:9: b= BOOLEAN
                    {
                    b=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_token624); if (state.failed) return retval; 
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
                    // 118:25: -> ^( BOOL $b)
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:118:28: ^( BOOL $b)
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:119:7: '(' statement ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal21=(Token)match(input,68,FOLLOW_68_in_token647); if (state.failed) return retval;
                    pushFollow(FOLLOW_statement_in_token650);
                    statement22=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement22.getTree());
                    char_literal23=(Token)match(input,69,FOLLOW_69_in_token652); if (state.failed) return retval;

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

    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:122:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | native_step_definition_statement | function_definition_statement | include_statement | script_statement | atom ':=' statement -> ^( VAR atom statement ) | expression ( ( 'and' | 'or' ) expression )* );
    public final GremlinParser.statement_return statement() throws RecognitionException {
        GremlinParser.statement_return retval = new GremlinParser.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal33=null;
        Token string_literal36=null;
        Token string_literal37=null;
        GremlinParser.if_statement_return if_statement24 = null;

        GremlinParser.foreach_statement_return foreach_statement25 = null;

        GremlinParser.while_statement_return while_statement26 = null;

        GremlinParser.repeat_statement_return repeat_statement27 = null;

        GremlinParser.native_step_definition_statement_return native_step_definition_statement28 = null;

        GremlinParser.function_definition_statement_return function_definition_statement29 = null;

        GremlinParser.include_statement_return include_statement30 = null;

        GremlinParser.script_statement_return script_statement31 = null;

        GremlinParser.atom_return atom32 = null;

        GremlinParser.statement_return statement34 = null;

        GremlinParser.expression_return expression35 = null;

        GremlinParser.expression_return expression38 = null;


        CommonTree string_literal33_tree=null;
        CommonTree string_literal36_tree=null;
        CommonTree string_literal37_tree=null;
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:123:5: ( if_statement | foreach_statement | while_statement | repeat_statement | native_step_definition_statement | function_definition_statement | include_statement | script_statement | atom ':=' statement -> ^( VAR atom statement ) | expression ( ( 'and' | 'or' ) expression )* )
            int alt10=10;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:123:9: if_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_if_statement_in_statement669);
                    if_statement24=if_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, if_statement24.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:124:4: foreach_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_foreach_statement_in_statement674);
                    foreach_statement25=foreach_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, foreach_statement25.getTree());

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:125:4: while_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_while_statement_in_statement679);
                    while_statement26=while_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, while_statement26.getTree());

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:126:4: repeat_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_repeat_statement_in_statement684);
                    repeat_statement27=repeat_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, repeat_statement27.getTree());

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:127:4: native_step_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_native_step_definition_statement_in_statement689);
                    native_step_definition_statement28=native_step_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, native_step_definition_statement28.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:128:4: function_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_definition_statement_in_statement694);
                    function_definition_statement29=function_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_definition_statement29.getTree());

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:129:4: include_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_include_statement_in_statement699);
                    include_statement30=include_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, include_statement30.getTree());

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:130:6: script_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_script_statement_in_statement706);
                    script_statement31=script_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, script_statement31.getTree());

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:131:9: atom ':=' statement
                    {
                    pushFollow(FOLLOW_atom_in_statement716);
                    atom32=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom32.getTree());
                    string_literal33=(Token)match(input,70,FOLLOW_70_in_statement718); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_70.add(string_literal33);

                    pushFollow(FOLLOW_statement_in_statement720);
                    statement34=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement34.getTree());


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
                    // 131:30: -> ^( VAR atom statement )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:131:33: ^( VAR atom statement )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:132:4: expression ( ( 'and' | 'or' ) expression )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement737);
                    expression35=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression35.getTree());
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:132:15: ( ( 'and' | 'or' ) expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=71 && LA9_0<=72)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:132:16: ( 'and' | 'or' ) expression
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:132:16: ( 'and' | 'or' )
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0==71) ) {
                    	        alt8=1;
                    	    }
                    	    else if ( (LA8_0==72) ) {
                    	        alt8=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 8, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:132:17: 'and'
                    	            {
                    	            string_literal36=(Token)match(input,71,FOLLOW_71_in_statement741); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal36_tree = (CommonTree)adaptor.create(string_literal36);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal36_tree, root_0);
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:132:24: 'or'
                    	            {
                    	            string_literal37=(Token)match(input,72,FOLLOW_72_in_statement744); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal37_tree = (CommonTree)adaptor.create(string_literal37);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal37_tree, root_0);
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    pushFollow(FOLLOW_expression_in_statement748);
                    	    expression38=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression38.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:135:1: include_statement : 'include' StringLiteral -> ^( INCLUDE StringLiteral ) ;
    public final GremlinParser.include_statement_return include_statement() throws RecognitionException {
        GremlinParser.include_statement_return retval = new GremlinParser.include_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal39=null;
        Token StringLiteral40=null;

        CommonTree string_literal39_tree=null;
        CommonTree StringLiteral40_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:136:2: ( 'include' StringLiteral -> ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:136:4: 'include' StringLiteral
            {
            string_literal39=(Token)match(input,73,FOLLOW_73_in_include_statement761); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_73.add(string_literal39);

            StringLiteral40=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement763); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral40);



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
            // 136:28: -> ^( INCLUDE StringLiteral )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:136:31: ^( INCLUDE StringLiteral )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:139:1: script_statement : 'script' StringLiteral -> ^( SCRIPT StringLiteral ) ;
    public final GremlinParser.script_statement_return script_statement() throws RecognitionException {
        GremlinParser.script_statement_return retval = new GremlinParser.script_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal41=null;
        Token StringLiteral42=null;

        CommonTree string_literal41_tree=null;
        CommonTree StringLiteral42_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:5: ( 'script' StringLiteral -> ^( SCRIPT StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:9: 'script' StringLiteral
            {
            string_literal41=(Token)match(input,74,FOLLOW_74_in_script_statement787); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(string_literal41);

            StringLiteral42=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_script_statement789); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral42);



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
            // 140:32: -> ^( SCRIPT StringLiteral )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:35: ^( SCRIPT StringLiteral )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:143:1: if_statement : 'if' statement NEWLINE if_block= block ( 'else' else_block= block )? 'end' -> ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? ) ;
    public final GremlinParser.if_statement_return if_statement() throws RecognitionException {
        GremlinParser.if_statement_return retval = new GremlinParser.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal43=null;
        Token NEWLINE45=null;
        Token string_literal46=null;
        Token string_literal47=null;
        GremlinParser.block_return if_block = null;

        GremlinParser.block_return else_block = null;

        GremlinParser.statement_return statement44 = null;


        CommonTree string_literal43_tree=null;
        CommonTree NEWLINE45_tree=null;
        CommonTree string_literal46_tree=null;
        CommonTree string_literal47_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:2: ( 'if' statement NEWLINE if_block= block ( 'else' else_block= block )? 'end' -> ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:4: 'if' statement NEWLINE if_block= block ( 'else' else_block= block )? 'end'
            {
            string_literal43=(Token)match(input,75,FOLLOW_75_in_if_statement813); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal43);

            pushFollow(FOLLOW_statement_in_if_statement815);
            statement44=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement44.getTree());
            NEWLINE45=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_if_statement817); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE45);

            pushFollow(FOLLOW_block_in_if_statement833);
            if_block=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(if_block.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:9: ( 'else' else_block= block )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==76) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:10: 'else' else_block= block
                    {
                    string_literal46=(Token)match(input,76,FOLLOW_76_in_if_statement844); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_76.add(string_literal46);

                    pushFollow(FOLLOW_block_in_if_statement859);
                    else_block=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block.add(else_block.getTree());

                    }
                    break;

            }

            string_literal47=(Token)match(input,77,FOLLOW_77_in_if_statement871); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(string_literal47);



            // AST REWRITE
            // elements: else_block, if_block, statement
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
            // 148:15: -> ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:18: ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:23: ^( COND statement )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COND, "COND"), root_2);

                adaptor.addChild(root_2, stream_statement.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_if_block.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:51: ( ^( ELSE $else_block) )?
                if ( stream_else_block.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:51: ^( ELSE $else_block)
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:151:1: foreach_statement : 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) ;
    public final GremlinParser.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinParser.foreach_statement_return retval = new GremlinParser.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal48=null;
        Token VARIABLE49=null;
        Token string_literal50=null;
        Token NEWLINE52=null;
        Token string_literal54=null;
        GremlinParser.statement_return statement51 = null;

        GremlinParser.block_return block53 = null;


        CommonTree string_literal48_tree=null;
        CommonTree VARIABLE49_tree=null;
        CommonTree string_literal50_tree=null;
        CommonTree NEWLINE52_tree=null;
        CommonTree string_literal54_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:2: ( 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:4: 'foreach' VARIABLE 'in' statement NEWLINE block 'end'
            {
            string_literal48=(Token)match(input,78,FOLLOW_78_in_foreach_statement905); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(string_literal48);

            VARIABLE49=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement907); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE49);

            string_literal50=(Token)match(input,79,FOLLOW_79_in_foreach_statement909); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(string_literal50);

            pushFollow(FOLLOW_statement_in_foreach_statement911);
            statement51=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement51.getTree());
            NEWLINE52=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_foreach_statement913); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE52);

            pushFollow(FOLLOW_block_in_foreach_statement924);
            block53=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block53.getTree());
            string_literal54=(Token)match(input,77,FOLLOW_77_in_foreach_statement932); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(string_literal54);



            // AST REWRITE
            // elements: VARIABLE, block, statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 154:12: -> ^( FOREACH VARIABLE statement block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:154:15: ^( FOREACH VARIABLE statement block )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:157:1: while_statement : 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) ;
    public final GremlinParser.while_statement_return while_statement() throws RecognitionException {
        GremlinParser.while_statement_return retval = new GremlinParser.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal55=null;
        Token NEWLINE57=null;
        Token string_literal59=null;
        GremlinParser.statement_return statement56 = null;

        GremlinParser.block_return block58 = null;


        CommonTree string_literal55_tree=null;
        CommonTree NEWLINE57_tree=null;
        CommonTree string_literal59_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:158:2: ( 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:158:4: 'while' statement NEWLINE block 'end'
            {
            string_literal55=(Token)match(input,80,FOLLOW_80_in_while_statement956); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_80.add(string_literal55);

            pushFollow(FOLLOW_statement_in_while_statement958);
            statement56=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement56.getTree());
            NEWLINE57=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_while_statement960); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE57);

            pushFollow(FOLLOW_block_in_while_statement971);
            block58=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block58.getTree());
            string_literal59=(Token)match(input,77,FOLLOW_77_in_while_statement979); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(string_literal59);



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
            // 160:12: -> ^( WHILE ^( COND statement ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:15: ^( WHILE ^( COND statement ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:23: ^( COND statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:163:1: repeat_statement : 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) ;
    public final GremlinParser.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinParser.repeat_statement_return retval = new GremlinParser.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal60=null;
        Token NEWLINE62=null;
        Token string_literal64=null;
        GremlinParser.statement_return statement61 = null;

        GremlinParser.block_return block63 = null;


        CommonTree string_literal60_tree=null;
        CommonTree NEWLINE62_tree=null;
        CommonTree string_literal64_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:164:2: ( 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:164:4: 'repeat' statement NEWLINE block 'end'
            {
            string_literal60=(Token)match(input,81,FOLLOW_81_in_repeat_statement1004); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_81.add(string_literal60);

            pushFollow(FOLLOW_statement_in_repeat_statement1006);
            statement61=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement61.getTree());
            NEWLINE62=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeat_statement1008); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE62);

            pushFollow(FOLLOW_block_in_repeat_statement1015);
            block63=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block63.getTree());
            string_literal64=(Token)match(input,77,FOLLOW_77_in_repeat_statement1019); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(string_literal64);



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
            // 166:9: -> ^( REPEAT statement block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:166:12: ^( REPEAT statement block )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:1: native_step_definition_statement : 'step' IDENTIFIER NEWLINE block 'end' -> ^( NATIVE_STEP IDENTIFIER block ) ;
    public final GremlinParser.native_step_definition_statement_return native_step_definition_statement() throws RecognitionException {
        GremlinParser.native_step_definition_statement_return retval = new GremlinParser.native_step_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal65=null;
        Token IDENTIFIER66=null;
        Token NEWLINE67=null;
        Token string_literal69=null;
        GremlinParser.block_return block68 = null;


        CommonTree string_literal65_tree=null;
        CommonTree IDENTIFIER66_tree=null;
        CommonTree NEWLINE67_tree=null;
        CommonTree string_literal69_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:170:2: ( 'step' IDENTIFIER NEWLINE block 'end' -> ^( NATIVE_STEP IDENTIFIER block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:170:4: 'step' IDENTIFIER NEWLINE block 'end'
            {
            string_literal65=(Token)match(input,82,FOLLOW_82_in_native_step_definition_statement1041); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(string_literal65);

            IDENTIFIER66=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_native_step_definition_statement1043); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER66);

            NEWLINE67=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_native_step_definition_statement1045); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE67);

            pushFollow(FOLLOW_block_in_native_step_definition_statement1052);
            block68=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block68.getTree());
            string_literal69=(Token)match(input,77,FOLLOW_77_in_native_step_definition_statement1056); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(string_literal69);



            // AST REWRITE
            // elements: IDENTIFIER, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 172:9: -> ^( NATIVE_STEP IDENTIFIER block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:172:12: ^( NATIVE_STEP IDENTIFIER block )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:175:1: function_definition_statement : 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) ;
    public final GremlinParser.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinParser.function_definition_statement_return retval = new GremlinParser.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal70=null;
        Token char_literal72=null;
        Token char_literal74=null;
        Token NEWLINE75=null;
        Token string_literal77=null;
        GremlinParser.function_name_return function_name71 = null;

        GremlinParser.formal_arguments_return formal_arguments73 = null;

        GremlinParser.block_return block76 = null;


        CommonTree string_literal70_tree=null;
        CommonTree char_literal72_tree=null;
        CommonTree char_literal74_tree=null;
        CommonTree NEWLINE75_tree=null;
        CommonTree string_literal77_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleSubtreeStream stream_formal_arguments=new RewriteRuleSubtreeStream(adaptor,"rule formal_arguments");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:176:2: ( 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:176:4: 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end'
            {
            string_literal70=(Token)match(input,83,FOLLOW_83_in_function_definition_statement1078); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(string_literal70);

            pushFollow(FOLLOW_function_name_in_function_definition_statement1080);
            function_name71=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name71.getTree());
            char_literal72=(Token)match(input,68,FOLLOW_68_in_function_definition_statement1082); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_68.add(char_literal72);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:176:29: ( formal_arguments )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==VARIABLE) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: formal_arguments
            	    {
            	    pushFollow(FOLLOW_formal_arguments_in_function_definition_statement1084);
            	    formal_arguments73=formal_arguments();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formal_arguments.add(formal_arguments73.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            char_literal74=(Token)match(input,69,FOLLOW_69_in_function_definition_statement1087); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(char_literal74);

            NEWLINE75=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function_definition_statement1089); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE75);

            pushFollow(FOLLOW_block_in_function_definition_statement1096);
            block76=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block76.getTree());
            string_literal77=(Token)match(input,77,FOLLOW_77_in_function_definition_statement1100); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(string_literal77);



            // AST REWRITE
            // elements: function_name, block, formal_arguments
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 178:9: -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:178:12: ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC, "FUNC"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:178:33: ^( ARGS ( formal_arguments )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:178:40: ( formal_arguments )*
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:181:1: formal_arguments : VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ ;
    public final GremlinParser.formal_arguments_return formal_arguments() throws RecognitionException {
        GremlinParser.formal_arguments_return retval = new GremlinParser.formal_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLE78=null;
        Token char_literal79=null;
        Token VARIABLE80=null;

        CommonTree VARIABLE78_tree=null;
        CommonTree char_literal79_tree=null;
        CommonTree VARIABLE80_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:2: ( VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:4: VARIABLE ( ',' VARIABLE )*
            {
            VARIABLE78=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments1130); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE78);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:13: ( ',' VARIABLE )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==84) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:14: ',' VARIABLE
            	    {
            	    char_literal79=(Token)match(input,84,FOLLOW_84_in_formal_arguments1133); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_84.add(char_literal79);

            	    VARIABLE80=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments1135); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE80);


            	    }
            	    break;

            	default :
            	    break loop13;
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
            // 182:29: -> ( ^( ARG VARIABLE ) )+
            {
                if ( !(stream_VARIABLE.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_VARIABLE.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:32: ^( ARG VARIABLE )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:185:1: block : ( block_body | NEWLINE )* -> ^( BLOCK ( block_body )* ) ;
    public final GremlinParser.block_return block() throws RecognitionException {
        GremlinParser.block_return retval = new GremlinParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE82=null;
        GremlinParser.block_body_return block_body81 = null;


        CommonTree NEWLINE82_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_block_body=new RewriteRuleSubtreeStream(adaptor,"rule block_body");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:186:5: ( ( block_body | NEWLINE )* -> ^( BLOCK ( block_body )* ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:186:7: ( block_body | NEWLINE )*
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:186:7: ( block_body | NEWLINE )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==NULL||LA14_0==COMMENT||(LA14_0>=G_INT && LA14_0<=BOOLEAN)||(LA14_0>=67 && LA14_0<=68)||(LA14_0>=73 && LA14_0<=75)||LA14_0==78||(LA14_0>=80 && LA14_0<=83)) ) {
                    alt14=1;
                }
                else if ( (LA14_0==NEWLINE) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:186:8: block_body
            	    {
            	    pushFollow(FOLLOW_block_body_in_block1162);
            	    block_body81=block_body();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_block_body.add(block_body81.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:186:21: NEWLINE
            	    {
            	    NEWLINE82=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block1166); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE82);


            	    }
            	    break;

            	default :
            	    break loop14;
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
            // 186:31: -> ^( BLOCK ( block_body )* )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:186:34: ^( BLOCK ( block_body )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:186:42: ( block_body )*
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:189:1: block_body : ( statement | COMMENT NEWLINE );
    public final GremlinParser.block_body_return block_body() throws RecognitionException {
        GremlinParser.block_body_return retval = new GremlinParser.block_body_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMENT84=null;
        Token NEWLINE85=null;
        GremlinParser.statement_return statement83 = null;


        CommonTree COMMENT84_tree=null;
        CommonTree NEWLINE85_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:190:5: ( statement | COMMENT NEWLINE )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NULL||(LA15_0>=G_INT && LA15_0<=BOOLEAN)||(LA15_0>=67 && LA15_0<=68)||(LA15_0>=73 && LA15_0<=75)||LA15_0==78||(LA15_0>=80 && LA15_0<=83)) ) {
                alt15=1;
            }
            else if ( (LA15_0==COMMENT) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:190:7: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_block_body1191);
                    statement83=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement83.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:191:7: COMMENT NEWLINE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    COMMENT84=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_block_body1199); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMENT84_tree = (CommonTree)adaptor.create(COMMENT84);
                    adaptor.addChild(root_0, COMMENT84_tree);
                    }
                    NEWLINE85=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block_body1201); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEWLINE85_tree = (CommonTree)adaptor.create(NEWLINE85);
                    adaptor.addChild(root_0, NEWLINE85_tree);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:194:1: expression : operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* ;
    public final GremlinParser.expression_return expression() throws RecognitionException {
        GremlinParser.expression_return retval = new GremlinParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal87=null;
        Token string_literal88=null;
        Token char_literal89=null;
        Token string_literal90=null;
        Token char_literal91=null;
        Token string_literal92=null;
        GremlinParser.operation_return operation86 = null;

        GremlinParser.operation_return operation93 = null;


        CommonTree char_literal87_tree=null;
        CommonTree string_literal88_tree=null;
        CommonTree char_literal89_tree=null;
        CommonTree string_literal90_tree=null;
        CommonTree char_literal91_tree=null;
        CommonTree string_literal92_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:2: ( operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:4: operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_operation_in_expression1215);
            operation86=operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, operation86.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:14: ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=85 && LA17_0<=90)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' )
            	    int alt16=6;
            	    switch ( input.LA(1) ) {
            	    case 85:
            	        {
            	        alt16=1;
            	        }
            	        break;
            	    case 86:
            	        {
            	        alt16=2;
            	        }
            	        break;
            	    case 87:
            	        {
            	        alt16=3;
            	        }
            	        break;
            	    case 88:
            	        {
            	        alt16=4;
            	        }
            	        break;
            	    case 89:
            	        {
            	        alt16=5;
            	        }
            	        break;
            	    case 90:
            	        {
            	        alt16=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt16) {
            	        case 1 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:16: '='
            	            {
            	            char_literal87=(Token)match(input,85,FOLLOW_85_in_expression1219); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal87_tree = (CommonTree)adaptor.create(char_literal87);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal87_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:23: '!='
            	            {
            	            string_literal88=(Token)match(input,86,FOLLOW_86_in_expression1224); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal88_tree = (CommonTree)adaptor.create(string_literal88);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal88_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:31: '<'
            	            {
            	            char_literal89=(Token)match(input,87,FOLLOW_87_in_expression1229); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal89_tree = (CommonTree)adaptor.create(char_literal89);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal89_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:38: '<='
            	            {
            	            string_literal90=(Token)match(input,88,FOLLOW_88_in_expression1234); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal90_tree = (CommonTree)adaptor.create(string_literal90);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal90_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:46: '>'
            	            {
            	            char_literal91=(Token)match(input,89,FOLLOW_89_in_expression1239); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal91_tree = (CommonTree)adaptor.create(char_literal91);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal91_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:53: '>='
            	            {
            	            string_literal92=(Token)match(input,90,FOLLOW_90_in_expression1244); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal92_tree = (CommonTree)adaptor.create(string_literal92);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal92_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_operation_in_expression1248);
            	    operation93=operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, operation93.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:198:1: operation : binary_operation ( ( '+' | '-' ) binary_operation )* ;
    public final GremlinParser.operation_return operation() throws RecognitionException {
        GremlinParser.operation_return retval = new GremlinParser.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal95=null;
        Token char_literal96=null;
        GremlinParser.binary_operation_return binary_operation94 = null;

        GremlinParser.binary_operation_return binary_operation97 = null;


        CommonTree char_literal95_tree=null;
        CommonTree char_literal96_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:2: ( binary_operation ( ( '+' | '-' ) binary_operation )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:4: binary_operation ( ( '+' | '-' ) binary_operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_binary_operation_in_operation1261);
            binary_operation94=binary_operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation94.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:21: ( ( '+' | '-' ) binary_operation )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=91 && LA19_0<=92)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:22: ( '+' | '-' ) binary_operation
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:22: ( '+' | '-' )
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==91) ) {
            	        alt18=1;
            	    }
            	    else if ( (LA18_0==92) ) {
            	        alt18=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:23: '+'
            	            {
            	            char_literal95=(Token)match(input,91,FOLLOW_91_in_operation1265); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal95_tree = (CommonTree)adaptor.create(char_literal95);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal95_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:28: '-'
            	            {
            	            char_literal96=(Token)match(input,92,FOLLOW_92_in_operation1268); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal96_tree = (CommonTree)adaptor.create(char_literal96);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal96_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_binary_operation_in_operation1272);
            	    binary_operation97=binary_operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation97.getTree());

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
    // $ANTLR end "operation"

    public static class binary_operation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "binary_operation"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:202:1: binary_operation : atom ( ( '*' | 'div' | 'mod' ) atom )* ;
    public final GremlinParser.binary_operation_return binary_operation() throws RecognitionException {
        GremlinParser.binary_operation_return retval = new GremlinParser.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal99=null;
        Token string_literal100=null;
        Token string_literal101=null;
        GremlinParser.atom_return atom98 = null;

        GremlinParser.atom_return atom102 = null;


        CommonTree char_literal99_tree=null;
        CommonTree string_literal100_tree=null;
        CommonTree string_literal101_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:2: ( atom ( ( '*' | 'div' | 'mod' ) atom )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:4: atom ( ( '*' | 'div' | 'mod' ) atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_binary_operation1286);
            atom98=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom98.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:9: ( ( '*' | 'div' | 'mod' ) atom )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=93 && LA21_0<=95)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:10: ( '*' | 'div' | 'mod' ) atom
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:10: ( '*' | 'div' | 'mod' )
            	    int alt20=3;
            	    switch ( input.LA(1) ) {
            	    case 93:
            	        {
            	        alt20=1;
            	        }
            	        break;
            	    case 94:
            	        {
            	        alt20=2;
            	        }
            	        break;
            	    case 95:
            	        {
            	        alt20=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt20) {
            	        case 1 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:11: '*'
            	            {
            	            char_literal99=(Token)match(input,93,FOLLOW_93_in_binary_operation1290); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal99_tree = (CommonTree)adaptor.create(char_literal99);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal99_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:16: 'div'
            	            {
            	            string_literal100=(Token)match(input,94,FOLLOW_94_in_binary_operation1293); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal100_tree = (CommonTree)adaptor.create(string_literal100);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal100_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:23: 'mod'
            	            {
            	            string_literal101=(Token)match(input,95,FOLLOW_95_in_binary_operation1296); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal101_tree = (CommonTree)adaptor.create(string_literal101);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal101_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_atom_in_binary_operation1300);
            	    atom102=atom();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom102.getTree());

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
    // $ANTLR end "binary_operation"

    public static class function_call_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_call"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:206:1: function_call : function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) ;
    public final GremlinParser.function_call_return function_call() throws RecognitionException {
        GremlinParser.function_call_return retval = new GremlinParser.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal104=null;
        Token char_literal106=null;
        GremlinParser.function_name_return function_name103 = null;

        GremlinParser.function_call_params_return function_call_params105 = null;


        CommonTree char_literal104_tree=null;
        CommonTree char_literal106_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleSubtreeStream stream_function_call_params=new RewriteRuleSubtreeStream(adaptor,"rule function_call_params");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:2: ( function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:4: function_name '(' ( function_call_params )* ')'
            {
            pushFollow(FOLLOW_function_name_in_function_call1314);
            function_name103=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name103.getTree());
            char_literal104=(Token)match(input,68,FOLLOW_68_in_function_call1316); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_68.add(char_literal104);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:22: ( function_call_params )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==NULL||(LA22_0>=G_INT && LA22_0<=BOOLEAN)||(LA22_0>=67 && LA22_0<=68)||(LA22_0>=73 && LA22_0<=75)||LA22_0==78||(LA22_0>=80 && LA22_0<=83)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: function_call_params
            	    {
            	    pushFollow(FOLLOW_function_call_params_in_function_call1318);
            	    function_call_params105=function_call_params();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function_call_params.add(function_call_params105.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            char_literal106=(Token)match(input,69,FOLLOW_69_in_function_call1321); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(char_literal106);



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
            // 207:48: -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:51: ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:77: ^( ARGS ( function_call_params )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:207:84: ( function_call_params )*
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:210:1: function_name : ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) ;
    public final GremlinParser.function_name_return function_name() throws RecognitionException {
        GremlinParser.function_name_return retval = new GremlinParser.function_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ns=null;
        Token ln=null;
        Token char_literal107=null;

        CommonTree ns_tree=null;
        CommonTree ln_tree=null;
        CommonTree char_literal107_tree=null;
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:2: (ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:4: ns= IDENTIFIER ':' ln= IDENTIFIER
            {
            ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name1350); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(ns);

            char_literal107=(Token)match(input,96,FOLLOW_96_in_function_name1352); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_96.add(char_literal107);

            ln=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name1356); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(ln);



            // AST REWRITE
            // elements: ns, ln
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
            // 211:36: -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:39: ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_NAME, "FUNC_NAME"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:51: ^( NS $ns)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NS, "NS"), root_2);

                adaptor.addChild(root_2, stream_ns.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:211:61: ^( NAME $ln)
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:214:1: function_call_params : function_call_param ( ',' function_call_param )* -> ( ^( ARG function_call_param ) )+ ;
    public final GremlinParser.function_call_params_return function_call_params() throws RecognitionException {
        GremlinParser.function_call_params_return retval = new GremlinParser.function_call_params_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal109=null;
        GremlinParser.function_call_param_return function_call_param108 = null;

        GremlinParser.function_call_param_return function_call_param110 = null;


        CommonTree char_literal109_tree=null;
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_function_call_param=new RewriteRuleSubtreeStream(adaptor,"rule function_call_param");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:2: ( function_call_param ( ',' function_call_param )* -> ( ^( ARG function_call_param ) )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:4: function_call_param ( ',' function_call_param )*
            {
            pushFollow(FOLLOW_function_call_param_in_function_call_params1391);
            function_call_param108=function_call_param();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_call_param.add(function_call_param108.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:24: ( ',' function_call_param )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==84) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:25: ',' function_call_param
            	    {
            	    char_literal109=(Token)match(input,84,FOLLOW_84_in_function_call_params1394); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_84.add(char_literal109);

            	    pushFollow(FOLLOW_function_call_param_in_function_call_params1396);
            	    function_call_param110=function_call_param();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function_call_param.add(function_call_param110.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
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
            // 215:51: -> ( ^( ARG function_call_param ) )+
            {
                if ( !(stream_function_call_param.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_function_call_param.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:215:54: ^( ARG function_call_param )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:218:1: function_call_param : statement ;
    public final GremlinParser.function_call_param_return function_call_param() throws RecognitionException {
        GremlinParser.function_call_param_return retval = new GremlinParser.function_call_param_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GremlinParser.statement_return statement111 = null;



        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:219:5: ( statement )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:219:7: statement
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_statement_in_function_call_param1421);
            statement111=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement111.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:222:1: atom : ( gpath_statement | G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | NULL );
    public final GremlinParser.atom_return atom() throws RecognitionException {
        GremlinParser.atom_return retval = new GremlinParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token G_INT113=null;
        Token G_LONG114=null;
        Token G_FLOAT115=null;
        Token G_DOUBLE116=null;
        Token NULL117=null;
        GremlinParser.gpath_statement_return gpath_statement112 = null;


        CommonTree G_INT113_tree=null;
        CommonTree G_LONG114_tree=null;
        CommonTree G_FLOAT115_tree=null;
        CommonTree G_DOUBLE116_tree=null;
        CommonTree NULL117_tree=null;
        RewriteRuleTokenStream stream_G_LONG=new RewriteRuleTokenStream(adaptor,"token G_LONG");
        RewriteRuleTokenStream stream_G_DOUBLE=new RewriteRuleTokenStream(adaptor,"token G_DOUBLE");
        RewriteRuleTokenStream stream_G_FLOAT=new RewriteRuleTokenStream(adaptor,"token G_FLOAT");
        RewriteRuleTokenStream stream_G_INT=new RewriteRuleTokenStream(adaptor,"token G_INT");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:223:2: ( gpath_statement | G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | NULL )
            int alt24=6;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:223:6: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_gpath_statement_in_atom1438);
                    gpath_statement112=gpath_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gpath_statement112.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:224:9: G_INT
                    {
                    G_INT113=(Token)match(input,G_INT,FOLLOW_G_INT_in_atom1448); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_INT.add(G_INT113);



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
                    // 224:25: -> ^( INT G_INT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:224:28: ^( INT G_INT )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:225:6: G_LONG
                    {
                    G_LONG114=(Token)match(input,G_LONG,FOLLOW_G_LONG_in_atom1473); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_LONG.add(G_LONG114);



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
                    // 225:22: -> ^( LONG G_LONG )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:225:25: ^( LONG G_LONG )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:226:6: G_FLOAT
                    {
                    G_FLOAT115=(Token)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_atom1497); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_FLOAT.add(G_FLOAT115);



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
                    // 226:22: -> ^( FLOAT G_FLOAT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:226:25: ^( FLOAT G_FLOAT )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:227:6: G_DOUBLE
                    {
                    G_DOUBLE116=(Token)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_atom1520); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_DOUBLE.add(G_DOUBLE116);



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
                    // 227:22: -> ^( DOUBLE G_DOUBLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:227:25: ^( DOUBLE G_DOUBLE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:228:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NULL117=(Token)match(input,NULL,FOLLOW_NULL_in_atom1545); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL117_tree = (CommonTree)adaptor.create(NULL117);
                    adaptor.addChild(root_0, NULL117_tree);
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

    // $ANTLR start synpred26_Gremlin
    public final void synpred26_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:131:9: ( atom ':=' statement )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:131:9: atom ':=' statement
        {
        pushFollow(FOLLOW_atom_in_synpred26_Gremlin716);
        atom();

        state._fsp--;
        if (state.failed) return ;
        match(input,70,FOLLOW_70_in_synpred26_Gremlin718); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred26_Gremlin720);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_Gremlin

    // $ANTLR start synpred48_Gremlin
    public final void synpred48_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:223:6: ( gpath_statement )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:223:6: gpath_statement
        {
        pushFollow(FOLLOW_gpath_statement_in_synpred48_Gremlin1438);
        gpath_statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_Gremlin

    // $ANTLR start synpred49_Gremlin
    public final void synpred49_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:224:9: ( G_INT )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:224:9: G_INT
        {
        match(input,G_INT,FOLLOW_G_INT_in_synpred49_Gremlin1448); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_Gremlin

    // $ANTLR start synpred50_Gremlin
    public final void synpred50_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:225:6: ( G_LONG )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:225:6: G_LONG
        {
        match(input,G_LONG,FOLLOW_G_LONG_in_synpred50_Gremlin1473); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_Gremlin

    // $ANTLR start synpred51_Gremlin
    public final void synpred51_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:226:6: ( G_FLOAT )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:226:6: G_FLOAT
        {
        match(input,G_FLOAT,FOLLOW_G_FLOAT_in_synpred51_Gremlin1497); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_Gremlin

    // $ANTLR start synpred52_Gremlin
    public final void synpred52_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:227:6: ( G_DOUBLE )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:227:6: G_DOUBLE
        {
        match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_synpred52_Gremlin1520); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_Gremlin

    // Delegated rules

    public final boolean synpred50_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_Gremlin_fragment(); // can never throw exception
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
    public final boolean synpred48_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_Gremlin_fragment(); // can never throw exception
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


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA7_eotS =
        "\16\uffff";
    static final String DFA7_eofS =
        "\5\uffff\1\15\10\uffff";
    static final String DFA7_minS =
        "\1\53\4\uffff\1\44\10\uffff";
    static final String DFA7_maxS =
        "\1\104\4\uffff\1\140\10\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\7\1\10\1\12\1\13\1\14\1\5"+
        "\1\11";
    static final String DFA7_specialS =
        "\16\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\1\2\1\3\1\4\1\6\1\7\1\10\1\5\1\12\17\uffff\1\11\1\13",
            "",
            "",
            "",
            "",
            "\1\15\4\uffff\13\15\14\uffff\17\15\1\uffff\20\15\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "107:1: token : ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | function_call | StringLiteral -> ^( STR StringLiteral ) | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | '..' | b= BOOLEAN -> ^( BOOL $b) | '(' statement ')' );";
        }
    }
    static final String DFA10_eotS =
        "\27\uffff";
    static final String DFA10_eofS =
        "\27\uffff";
    static final String DFA10_minS =
        "\1\44\10\uffff\14\0\2\uffff";
    static final String DFA10_maxS =
        "\1\123\10\uffff\14\0\2\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\14\uffff\1\11\1\12";
    static final String DFA10_specialS =
        "\11\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\2"+
        "\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\24\6\uffff\1\11\1\12\1\13\1\14\1\16\1\17\1\20\1\15\1\22\17"+
            "\uffff\1\21\1\23\4\uffff\1\7\1\10\1\1\2\uffff\1\2\1\uffff\1"+
            "\3\1\4\1\5\1\6",
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

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "122:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | native_step_definition_statement | function_definition_statement | include_statement | script_statement | atom ':=' statement -> ^( VAR atom statement ) | expression ( ( 'and' | 'or' ) expression )* );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_9 = input.LA(1);

                         
                        int index10_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_10 = input.LA(1);

                         
                        int index10_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_11 = input.LA(1);

                         
                        int index10_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA10_12 = input.LA(1);

                         
                        int index10_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_12);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA10_13 = input.LA(1);

                         
                        int index10_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_13);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA10_14 = input.LA(1);

                         
                        int index10_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_14);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA10_15 = input.LA(1);

                         
                        int index10_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_15);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA10_16 = input.LA(1);

                         
                        int index10_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_16);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA10_17 = input.LA(1);

                         
                        int index10_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_17);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA10_18 = input.LA(1);

                         
                        int index10_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_18);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA10_19 = input.LA(1);

                         
                        int index10_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_19);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA10_20 = input.LA(1);

                         
                        int index10_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index10_20);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA24_eotS =
        "\13\uffff";
    static final String DFA24_eofS =
        "\13\uffff";
    static final String DFA24_minS =
        "\1\44\4\0\6\uffff";
    static final String DFA24_maxS =
        "\1\104\4\0\6\uffff";
    static final String DFA24_acceptS =
        "\5\uffff\1\1\1\6\1\2\1\3\1\4\1\5";
    static final String DFA24_specialS =
        "\1\uffff\1\3\1\0\1\1\1\2\6\uffff}>";
    static final String[] DFA24_transitionS = {
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

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "222:1: atom : ( gpath_statement | G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | NULL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_2 = input.LA(1);

                         
                        int index24_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Gremlin()) ) {s = 5;}

                        else if ( (synpred50_Gremlin()) ) {s = 8;}

                         
                        input.seek(index24_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_3 = input.LA(1);

                         
                        int index24_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Gremlin()) ) {s = 5;}

                        else if ( (synpred51_Gremlin()) ) {s = 9;}

                         
                        input.seek(index24_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_4 = input.LA(1);

                         
                        int index24_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Gremlin()) ) {s = 5;}

                        else if ( (synpred52_Gremlin()) ) {s = 10;}

                         
                        input.seek(index24_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_1 = input.LA(1);

                         
                        int index24_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Gremlin()) ) {s = 5;}

                        else if ( (synpred49_Gremlin()) ) {s = 7;}

                         
                        input.seek(index24_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_COMMENT_in_program307 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_statement_in_program319 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_program322 = new BitSet(new long[]{0x000FFC1000000002L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_step_in_gpath_statement364 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_gpath_statement367 = new BitSet(new long[]{0x000FF80000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_step_in_gpath_statement369 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_token_in_step395 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_step398 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_statement_in_step400 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_step402 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_G_INT_in_token443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_LONG_in_token468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_FLOAT_in_token492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_DOUBLE_in_token515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_token540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_token550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROPERTY_in_token563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_token580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_token602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_token612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_token624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_token647 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_statement_in_token650 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_token652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_step_definition_statement_in_statement689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_script_statement_in_statement706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_statement716 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_statement718 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_statement_in_statement720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement737 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_71_in_statement741 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_72_in_statement744 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_expression_in_statement748 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_73_in_include_statement761 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_script_statement787 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_script_statement789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_if_statement813 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_statement_in_if_statement815 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_if_statement817 = new BitSet(new long[]{0x000FFE1000000000L,0x00000000000F7E18L});
    public static final BitSet FOLLOW_block_in_if_statement833 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_76_in_if_statement844 = new BitSet(new long[]{0x000FFE1000000000L,0x00000000000F6E18L});
    public static final BitSet FOLLOW_block_in_if_statement859 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_if_statement871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_foreach_statement905 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement907 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_foreach_statement909 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_statement_in_foreach_statement911 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_foreach_statement913 = new BitSet(new long[]{0x000FFE1000000000L,0x00000000000F6E18L});
    public static final BitSet FOLLOW_block_in_foreach_statement924 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_foreach_statement932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_while_statement956 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_statement_in_while_statement958 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_while_statement960 = new BitSet(new long[]{0x000FFE1000000000L,0x00000000000F6E18L});
    public static final BitSet FOLLOW_block_in_while_statement971 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_while_statement979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_repeat_statement1004 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_statement_in_repeat_statement1006 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeat_statement1008 = new BitSet(new long[]{0x000FFE1000000000L,0x00000000000F6E18L});
    public static final BitSet FOLLOW_block_in_repeat_statement1015 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_repeat_statement1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_native_step_definition_statement1041 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_native_step_definition_statement1043 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_native_step_definition_statement1045 = new BitSet(new long[]{0x000FFE1000000000L,0x00000000000F6E18L});
    public static final BitSet FOLLOW_block_in_native_step_definition_statement1052 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_native_step_definition_statement1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_function_definition_statement1078 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_function_name_in_function_definition_statement1080 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_function_definition_statement1082 = new BitSet(new long[]{0x0002000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_formal_arguments_in_function_definition_statement1084 = new BitSet(new long[]{0x0002000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_function_definition_statement1087 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_function_definition_statement1089 = new BitSet(new long[]{0x000FFE1000000000L,0x00000000000F6E18L});
    public static final BitSet FOLLOW_block_in_function_definition_statement1096 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_function_definition_statement1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments1130 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_formal_arguments1133 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments1135 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_block_body_in_block1162 = new BitSet(new long[]{0x000FFE1000000002L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_NEWLINE_in_block1166 = new BitSet(new long[]{0x000FFE1000000002L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_statement_in_block_body1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_block_body1199 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_block_body1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operation_in_expression1215 = new BitSet(new long[]{0x0000000000000002L,0x0000000007E00000L});
    public static final BitSet FOLLOW_85_in_expression1219 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_86_in_expression1224 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_87_in_expression1229 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_88_in_expression1234 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_89_in_expression1239 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_90_in_expression1244 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_operation_in_expression1248 = new BitSet(new long[]{0x0000000000000002L,0x0000000007E00000L});
    public static final BitSet FOLLOW_binary_operation_in_operation1261 = new BitSet(new long[]{0x0000000000000002L,0x0000000018000000L});
    public static final BitSet FOLLOW_91_in_operation1265 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_92_in_operation1268 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_binary_operation_in_operation1272 = new BitSet(new long[]{0x0000000000000002L,0x0000000018000000L});
    public static final BitSet FOLLOW_atom_in_binary_operation1286 = new BitSet(new long[]{0x0000000000000002L,0x00000000E0000000L});
    public static final BitSet FOLLOW_93_in_binary_operation1290 = new BitSet(new long[]{0x000FF81000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_94_in_binary_operation1293 = new BitSet(new long[]{0x000FF81000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_95_in_binary_operation1296 = new BitSet(new long[]{0x000FF81000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_atom_in_binary_operation1300 = new BitSet(new long[]{0x0000000000000002L,0x00000000E0000000L});
    public static final BitSet FOLLOW_function_name_in_function_call1314 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_function_call1316 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E38L});
    public static final BitSet FOLLOW_function_call_params_in_function_call1318 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E38L});
    public static final BitSet FOLLOW_69_in_function_call1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name1350 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_function_name1352 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_param_in_function_call_params1391 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_function_call_params1394 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_function_call_param_in_function_call_params1396 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_statement_in_function_call_param1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_atom1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_INT_in_atom1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_LONG_in_atom1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_FLOAT_in_atom1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_DOUBLE_in_atom1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_atom1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_synpred26_Gremlin716 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_synpred26_Gremlin718 = new BitSet(new long[]{0x000FF81000000000L,0x00000000000F4E18L});
    public static final BitSet FOLLOW_statement_in_synpred26_Gremlin720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_synpred48_Gremlin1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_INT_in_synpred49_Gremlin1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_LONG_in_synpred50_Gremlin1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_FLOAT_in_synpred51_Gremlin1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_DOUBLE_in_synpred52_Gremlin1520 = new BitSet(new long[]{0x0000000000000002L});

}
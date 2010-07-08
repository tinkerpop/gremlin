// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g 2010-07-08 20:10:43
package com.tinkerpop.gremlin.compiler;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class GremlinParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "PATH", "GPATH", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "SELF", "HISTORY", "FUNC_CALL", "IF", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "INT", "LONG", "FLOAT", "DOUBLE", "STR", "ARR", "BOOL", "NULL", "RANGE", "PROPERTY_CALL", "VARIABLE_CALL", "COLLECTION_CALL", "COMMENT", "NEWLINE", "VARIABLE", "StringLiteral", "IDENTIFIER", "G_INT", "G_LONG", "G_FLOAT", "G_DOUBLE", "BOOLEAN", "PROPERTY", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "'/'", "'['", "']'", "'..'", "':='", "'and'", "'or'", "'include'", "'if'", "'end'", "'foreach'", "'in'", "'while'", "'repeat'", "'path'", "'func'", "'('", "')'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "':'"
    };
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
    public static final int ARR=32;
    public static final int DoubleStringCharacter=50;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int T__71=71;
    public static final int WS=52;
    public static final int T__72=72;
    public static final int PREDICATES=16;
    public static final int VARIABLE=41;
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
    public static final int NEWLINE=40;
    public static final int BLOCK=22;
    public static final int NonEscapeCharacter=58;
    public static final int COND=21;
    public static final int LONG=28;
    public static final int SELF=17;
    public static final int VARIABLE_CALL=37;

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


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:60:1: program : ( ( COMMENT )+ | ( ( statement )? NEWLINE )+ | ( ( collection )? NEWLINE )+ );
    public final GremlinParser.program_return program() throws RecognitionException {
        GremlinParser.program_return retval = new GremlinParser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMENT1=null;
        Token NEWLINE3=null;
        Token NEWLINE5=null;
        GremlinParser.statement_return statement2 = null;

        GremlinParser.collection_return collection4 = null;


        CommonTree COMMENT1_tree=null;
        CommonTree NEWLINE3_tree=null;
        CommonTree NEWLINE5_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:61:5: ( ( COMMENT )+ | ( ( statement )? NEWLINE )+ | ( ( collection )? NEWLINE )+ )
            int alt6=3;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:61:7: ( COMMENT )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:61:7: ( COMMENT )+
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
                    	    COMMENT1=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_program244); if (state.failed) return retval;
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:62:9: ( ( statement )? NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:62:9: ( ( statement )? NEWLINE )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NULL||(LA3_0>=NEWLINE && LA3_0<=PROPERTY)||LA3_0==65||(LA3_0>=69 && LA3_0<=70)||LA3_0==72||(LA3_0>=74 && LA3_0<=78)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:62:10: ( statement )? NEWLINE
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:62:10: ( statement )?
                    	    int alt2=2;
                    	    int LA2_0 = input.LA(1);

                    	    if ( (LA2_0==NULL||(LA2_0>=VARIABLE && LA2_0<=PROPERTY)||LA2_0==65||(LA2_0>=69 && LA2_0<=70)||LA2_0==72||(LA2_0>=74 && LA2_0<=78)) ) {
                    	        alt2=1;
                    	    }
                    	    switch (alt2) {
                    	        case 1 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: statement
                    	            {
                    	            pushFollow(FOLLOW_statement_in_program256);
                    	            statement2=statement();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement2.getTree());

                    	            }
                    	            break;

                    	    }

                    	    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program259); if (state.failed) return retval;
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
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:63:9: ( ( collection )? NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:63:9: ( ( collection )? NEWLINE )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==NULL||(LA5_0>=NEWLINE && LA5_0<=PROPERTY)||LA5_0==65||LA5_0==78) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:63:10: ( collection )? NEWLINE
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:63:10: ( collection )?
                    	    int alt4=2;
                    	    int LA4_0 = input.LA(1);

                    	    if ( (LA4_0==NULL||(LA4_0>=VARIABLE && LA4_0<=PROPERTY)||LA4_0==65||LA4_0==78) ) {
                    	        alt4=1;
                    	    }
                    	    switch (alt4) {
                    	        case 1 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: collection
                    	            {
                    	            pushFollow(FOLLOW_collection_in_program272);
                    	            collection4=collection();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, collection4.getTree());

                    	            }
                    	            break;

                    	    }

                    	    NEWLINE5=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program275); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NEWLINE5_tree = (CommonTree)adaptor.create(NEWLINE5);
                    	    adaptor.addChild(root_0, NEWLINE5_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:70:1: gpath_statement : step '/' step ( '/' step )* -> ^( GPATH ( step )+ ) ;
    public final GremlinParser.gpath_statement_return gpath_statement() throws RecognitionException {
        GremlinParser.gpath_statement_return retval = new GremlinParser.gpath_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal7=null;
        Token char_literal9=null;
        GremlinParser.step_return step6 = null;

        GremlinParser.step_return step8 = null;

        GremlinParser.step_return step10 = null;


        CommonTree char_literal7_tree=null;
        CommonTree char_literal9_tree=null;
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_step=new RewriteRuleSubtreeStream(adaptor,"rule step");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:71:2: ( step '/' step ( '/' step )* -> ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:71:4: step '/' step ( '/' step )*
            {
            pushFollow(FOLLOW_step_in_gpath_statement312);
            step6=step();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_step.add(step6.getTree());
            char_literal7=(Token)match(input,62,FOLLOW_62_in_gpath_statement314); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal7);

            pushFollow(FOLLOW_step_in_gpath_statement316);
            step8=step();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_step.add(step8.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:71:18: ( '/' step )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==62) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:71:19: '/' step
            	    {
            	    char_literal9=(Token)match(input,62,FOLLOW_62_in_gpath_statement319); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_62.add(char_literal9);

            	    pushFollow(FOLLOW_step_in_gpath_statement321);
            	    step10=step();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_step.add(step10.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // 71:30: -> ^( GPATH ( step )+ )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:71:33: ^( GPATH ( step )+ )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:74:1: step : token ( '[' statement ']' )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) ;
    public final GremlinParser.step_return step() throws RecognitionException {
        GremlinParser.step_return retval = new GremlinParser.step_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal12=null;
        Token char_literal14=null;
        GremlinParser.token_return token11 = null;

        GremlinParser.statement_return statement13 = null;


        CommonTree char_literal12_tree=null;
        CommonTree char_literal14_tree=null;
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_token=new RewriteRuleSubtreeStream(adaptor,"rule token");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:75:5: ( token ( '[' statement ']' )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:75:7: token ( '[' statement ']' )*
            {
            pushFollow(FOLLOW_token_in_step347);
            token11=token();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_token.add(token11.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:75:13: ( '[' statement ']' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==63) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:75:14: '[' statement ']'
            	    {
            	    char_literal12=(Token)match(input,63,FOLLOW_63_in_step350); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_63.add(char_literal12);

            	    pushFollow(FOLLOW_statement_in_step352);
            	    statement13=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement13.getTree());
            	    char_literal14=(Token)match(input,64,FOLLOW_64_in_step354); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_64.add(char_literal14);


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);



            // AST REWRITE
            // elements: statement, token
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 75:34: -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:75:37: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STEP, "STEP"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:75:44: ^( TOKEN token )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TOKEN, "TOKEN"), root_2);

                adaptor.addChild(root_2, stream_token.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:75:59: ^( PREDICATES ( ^( PREDICATE statement ) )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREDICATES, "PREDICATES"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:75:72: ( ^( PREDICATE statement ) )*
                while ( stream_statement.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:75:72: ^( PREDICATE statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:78:1: token : ( expression | '..' ) ;
    public final GremlinParser.token_return token() throws RecognitionException {
        GremlinParser.token_return retval = new GremlinParser.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal16=null;
        GremlinParser.expression_return expression15 = null;


        CommonTree string_literal16_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:79:2: ( ( expression | '..' ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:79:5: ( expression | '..' )
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:79:5: ( expression | '..' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==NULL||(LA9_0>=VARIABLE && LA9_0<=PROPERTY)||LA9_0==78) ) {
                alt9=1;
            }
            else if ( (LA9_0==65) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:79:6: expression
                    {
                    pushFollow(FOLLOW_expression_in_token396);
                    expression15=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression15.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:79:19: '..'
                    {
                    string_literal16=(Token)match(input,65,FOLLOW_65_in_token400); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal16_tree = (CommonTree)adaptor.create(string_literal16);
                    adaptor.addChild(root_0, string_literal16_tree);
                    }

                    }
                    break;

            }


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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:82:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* );
    public final GremlinParser.statement_return statement() throws RecognitionException {
        GremlinParser.statement_return retval = new GremlinParser.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLE25=null;
        Token string_literal26=null;
        Token string_literal29=null;
        Token string_literal30=null;
        GremlinParser.if_statement_return if_statement17 = null;

        GremlinParser.foreach_statement_return foreach_statement18 = null;

        GremlinParser.while_statement_return while_statement19 = null;

        GremlinParser.repeat_statement_return repeat_statement20 = null;

        GremlinParser.path_definition_statement_return path_definition_statement21 = null;

        GremlinParser.function_definition_statement_return function_definition_statement22 = null;

        GremlinParser.include_statement_return include_statement23 = null;

        GremlinParser.gpath_statement_return gpath_statement24 = null;

        GremlinParser.statement_return statement27 = null;

        GremlinParser.expression_return expression28 = null;

        GremlinParser.expression_return expression31 = null;


        CommonTree VARIABLE25_tree=null;
        CommonTree string_literal26_tree=null;
        CommonTree string_literal29_tree=null;
        CommonTree string_literal30_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:83:5: ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* )
            int alt12=10;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:83:9: if_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_if_statement_in_statement417);
                    if_statement17=if_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, if_statement17.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:84:4: foreach_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_foreach_statement_in_statement422);
                    foreach_statement18=foreach_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, foreach_statement18.getTree());

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:85:4: while_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_while_statement_in_statement427);
                    while_statement19=while_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, while_statement19.getTree());

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:86:4: repeat_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_repeat_statement_in_statement432);
                    repeat_statement20=repeat_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, repeat_statement20.getTree());

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:87:4: path_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_path_definition_statement_in_statement437);
                    path_definition_statement21=path_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, path_definition_statement21.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:88:4: function_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_definition_statement_in_statement442);
                    function_definition_statement22=function_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_definition_statement22.getTree());

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:89:4: include_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_include_statement_in_statement447);
                    include_statement23=include_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, include_statement23.getTree());

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:4: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_gpath_statement_in_statement452);
                    gpath_statement24=gpath_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gpath_statement24.getTree());

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:91:4: VARIABLE ':=' statement
                    {
                    VARIABLE25=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_statement457); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE25);

                    string_literal26=(Token)match(input,66,FOLLOW_66_in_statement459); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_66.add(string_literal26);

                    pushFollow(FOLLOW_statement_in_statement461);
                    statement27=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement27.getTree());


                    // AST REWRITE
                    // elements: VARIABLE, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 91:28: -> ^( VAR VARIABLE statement )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:91:31: ^( VAR VARIABLE statement )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE.nextNode());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:92:4: expression ( ( 'and' | 'or' ) expression )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement476);
                    expression28=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression28.getTree());
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:92:15: ( ( 'and' | 'or' ) expression )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>=67 && LA11_0<=68)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:92:16: ( 'and' | 'or' ) expression
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:92:16: ( 'and' | 'or' )
                    	    int alt10=2;
                    	    int LA10_0 = input.LA(1);

                    	    if ( (LA10_0==67) ) {
                    	        alt10=1;
                    	    }
                    	    else if ( (LA10_0==68) ) {
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
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:92:17: 'and'
                    	            {
                    	            string_literal29=(Token)match(input,67,FOLLOW_67_in_statement480); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal29_tree = (CommonTree)adaptor.create(string_literal29);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal29_tree, root_0);
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:92:24: 'or'
                    	            {
                    	            string_literal30=(Token)match(input,68,FOLLOW_68_in_statement483); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal30_tree = (CommonTree)adaptor.create(string_literal30);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal30_tree, root_0);
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    pushFollow(FOLLOW_expression_in_statement487);
                    	    expression31=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression31.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:95:1: include_statement : 'include' StringLiteral -> ^( INCLUDE StringLiteral ) ;
    public final GremlinParser.include_statement_return include_statement() throws RecognitionException {
        GremlinParser.include_statement_return retval = new GremlinParser.include_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal32=null;
        Token StringLiteral33=null;

        CommonTree string_literal32_tree=null;
        CommonTree StringLiteral33_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:96:2: ( 'include' StringLiteral -> ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:96:4: 'include' StringLiteral
            {
            string_literal32=(Token)match(input,69,FOLLOW_69_in_include_statement500); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal32);

            StringLiteral33=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement502); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral33);



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
            // 96:28: -> ^( INCLUDE StringLiteral )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:96:31: ^( INCLUDE StringLiteral )
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

    public static class if_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "if_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:99:1: if_statement : 'if' statement NEWLINE block 'end' -> ^( IF ^( COND statement ) block ) ;
    public final GremlinParser.if_statement_return if_statement() throws RecognitionException {
        GremlinParser.if_statement_return retval = new GremlinParser.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal34=null;
        Token NEWLINE36=null;
        Token string_literal38=null;
        GremlinParser.statement_return statement35 = null;

        GremlinParser.block_return block37 = null;


        CommonTree string_literal34_tree=null;
        CommonTree NEWLINE36_tree=null;
        CommonTree string_literal38_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:2: ( 'if' statement NEWLINE block 'end' -> ^( IF ^( COND statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:4: 'if' statement NEWLINE block 'end'
            {
            string_literal34=(Token)match(input,70,FOLLOW_70_in_if_statement523); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal34);

            pushFollow(FOLLOW_statement_in_if_statement525);
            statement35=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement35.getTree());
            NEWLINE36=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_if_statement527); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE36);

            pushFollow(FOLLOW_block_in_if_statement541);
            block37=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block37.getTree());
            string_literal38=(Token)match(input,71,FOLLOW_71_in_if_statement552); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal38);



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
            // 102:15: -> ^( IF ^( COND statement ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:102:18: ^( IF ^( COND statement ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:102:23: ^( COND statement )
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
    // $ANTLR end "if_statement"

    public static class foreach_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "foreach_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:105:1: foreach_statement : 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) ;
    public final GremlinParser.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinParser.foreach_statement_return retval = new GremlinParser.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal39=null;
        Token VARIABLE40=null;
        Token string_literal41=null;
        Token NEWLINE43=null;
        Token string_literal45=null;
        GremlinParser.statement_return statement42 = null;

        GremlinParser.block_return block44 = null;


        CommonTree string_literal39_tree=null;
        CommonTree VARIABLE40_tree=null;
        CommonTree string_literal41_tree=null;
        CommonTree NEWLINE43_tree=null;
        CommonTree string_literal45_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:2: ( 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:4: 'foreach' VARIABLE 'in' statement NEWLINE block 'end'
            {
            string_literal39=(Token)match(input,72,FOLLOW_72_in_foreach_statement577); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(string_literal39);

            VARIABLE40=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement579); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE40);

            string_literal41=(Token)match(input,73,FOLLOW_73_in_foreach_statement581); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_73.add(string_literal41);

            pushFollow(FOLLOW_statement_in_foreach_statement583);
            statement42=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement42.getTree());
            NEWLINE43=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_foreach_statement585); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE43);

            pushFollow(FOLLOW_block_in_foreach_statement596);
            block44=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block44.getTree());
            string_literal45=(Token)match(input,71,FOLLOW_71_in_foreach_statement604); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal45);



            // AST REWRITE
            // elements: VARIABLE, statement, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 108:12: -> ^( FOREACH VARIABLE statement block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:108:15: ^( FOREACH VARIABLE statement block )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:111:1: while_statement : 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) ;
    public final GremlinParser.while_statement_return while_statement() throws RecognitionException {
        GremlinParser.while_statement_return retval = new GremlinParser.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal46=null;
        Token NEWLINE48=null;
        Token string_literal50=null;
        GremlinParser.statement_return statement47 = null;

        GremlinParser.block_return block49 = null;


        CommonTree string_literal46_tree=null;
        CommonTree NEWLINE48_tree=null;
        CommonTree string_literal50_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:112:2: ( 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:112:4: 'while' statement NEWLINE block 'end'
            {
            string_literal46=(Token)match(input,74,FOLLOW_74_in_while_statement628); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(string_literal46);

            pushFollow(FOLLOW_statement_in_while_statement630);
            statement47=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement47.getTree());
            NEWLINE48=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_while_statement632); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE48);

            pushFollow(FOLLOW_block_in_while_statement643);
            block49=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block49.getTree());
            string_literal50=(Token)match(input,71,FOLLOW_71_in_while_statement651); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal50);



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
            // 114:12: -> ^( WHILE ^( COND statement ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:114:15: ^( WHILE ^( COND statement ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:114:23: ^( COND statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:117:1: repeat_statement : 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) ;
    public final GremlinParser.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinParser.repeat_statement_return retval = new GremlinParser.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal51=null;
        Token NEWLINE53=null;
        Token string_literal55=null;
        GremlinParser.statement_return statement52 = null;

        GremlinParser.block_return block54 = null;


        CommonTree string_literal51_tree=null;
        CommonTree NEWLINE53_tree=null;
        CommonTree string_literal55_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:118:2: ( 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:118:4: 'repeat' statement NEWLINE block 'end'
            {
            string_literal51=(Token)match(input,75,FOLLOW_75_in_repeat_statement676); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal51);

            pushFollow(FOLLOW_statement_in_repeat_statement678);
            statement52=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement52.getTree());
            NEWLINE53=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeat_statement680); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE53);

            pushFollow(FOLLOW_block_in_repeat_statement687);
            block54=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block54.getTree());
            string_literal55=(Token)match(input,71,FOLLOW_71_in_repeat_statement691); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal55);



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
            // 120:9: -> ^( REPEAT statement block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:120:12: ^( REPEAT statement block )
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

    public static class path_definition_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "path_definition_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:123:1: path_definition_statement : 'path' IDENTIFIER NEWLINE statement NEWLINE 'end' -> ^( PATH IDENTIFIER statement ) ;
    public final GremlinParser.path_definition_statement_return path_definition_statement() throws RecognitionException {
        GremlinParser.path_definition_statement_return retval = new GremlinParser.path_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal56=null;
        Token IDENTIFIER57=null;
        Token NEWLINE58=null;
        Token NEWLINE60=null;
        Token string_literal61=null;
        GremlinParser.statement_return statement59 = null;


        CommonTree string_literal56_tree=null;
        CommonTree IDENTIFIER57_tree=null;
        CommonTree NEWLINE58_tree=null;
        CommonTree NEWLINE60_tree=null;
        CommonTree string_literal61_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:124:2: ( 'path' IDENTIFIER NEWLINE statement NEWLINE 'end' -> ^( PATH IDENTIFIER statement ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:124:4: 'path' IDENTIFIER NEWLINE statement NEWLINE 'end'
            {
            string_literal56=(Token)match(input,76,FOLLOW_76_in_path_definition_statement713); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_76.add(string_literal56);

            IDENTIFIER57=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_path_definition_statement715); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER57);

            NEWLINE58=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_path_definition_statement717); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE58);

            pushFollow(FOLLOW_statement_in_path_definition_statement724);
            statement59=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement59.getTree());
            NEWLINE60=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_path_definition_statement726); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE60);

            string_literal61=(Token)match(input,71,FOLLOW_71_in_path_definition_statement730); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal61);



            // AST REWRITE
            // elements: statement, IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 126:9: -> ^( PATH IDENTIFIER statement )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:126:12: ^( PATH IDENTIFIER statement )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PATH, "PATH"), root_1);

                adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                adaptor.addChild(root_1, stream_statement.nextTree());

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
    // $ANTLR end "path_definition_statement"

    public static class function_definition_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_definition_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:129:1: function_definition_statement : 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) ;
    public final GremlinParser.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinParser.function_definition_statement_return retval = new GremlinParser.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal62=null;
        Token char_literal64=null;
        Token char_literal66=null;
        Token NEWLINE67=null;
        Token string_literal69=null;
        GremlinParser.function_name_return function_name63 = null;

        GremlinParser.formal_arguments_return formal_arguments65 = null;

        GremlinParser.block_return block68 = null;


        CommonTree string_literal62_tree=null;
        CommonTree char_literal64_tree=null;
        CommonTree char_literal66_tree=null;
        CommonTree NEWLINE67_tree=null;
        CommonTree string_literal69_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleSubtreeStream stream_formal_arguments=new RewriteRuleSubtreeStream(adaptor,"rule formal_arguments");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:130:2: ( 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:130:4: 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end'
            {
            string_literal62=(Token)match(input,77,FOLLOW_77_in_function_definition_statement752); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(string_literal62);

            pushFollow(FOLLOW_function_name_in_function_definition_statement754);
            function_name63=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name63.getTree());
            char_literal64=(Token)match(input,78,FOLLOW_78_in_function_definition_statement756); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal64);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:130:29: ( formal_arguments )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==VARIABLE) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: formal_arguments
            	    {
            	    pushFollow(FOLLOW_formal_arguments_in_function_definition_statement758);
            	    formal_arguments65=formal_arguments();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formal_arguments.add(formal_arguments65.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            char_literal66=(Token)match(input,79,FOLLOW_79_in_function_definition_statement761); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(char_literal66);

            NEWLINE67=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function_definition_statement763); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE67);

            pushFollow(FOLLOW_block_in_function_definition_statement770);
            block68=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block68.getTree());
            string_literal69=(Token)match(input,71,FOLLOW_71_in_function_definition_statement774); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal69);



            // AST REWRITE
            // elements: block, function_name, formal_arguments
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 132:9: -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:132:12: ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC, "FUNC"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:132:33: ^( ARGS ( formal_arguments )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:132:40: ( formal_arguments )*
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:135:1: formal_arguments : VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ ;
    public final GremlinParser.formal_arguments_return formal_arguments() throws RecognitionException {
        GremlinParser.formal_arguments_return retval = new GremlinParser.formal_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLE70=null;
        Token char_literal71=null;
        Token VARIABLE72=null;

        CommonTree VARIABLE70_tree=null;
        CommonTree char_literal71_tree=null;
        CommonTree VARIABLE72_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:136:2: ( VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:136:4: VARIABLE ( ',' VARIABLE )*
            {
            VARIABLE70=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments804); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE70);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:136:13: ( ',' VARIABLE )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==80) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:136:14: ',' VARIABLE
            	    {
            	    char_literal71=(Token)match(input,80,FOLLOW_80_in_formal_arguments807); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_80.add(char_literal71);

            	    VARIABLE72=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments809); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE72);


            	    }
            	    break;

            	default :
            	    break loop14;
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
            // 136:29: -> ( ^( ARG VARIABLE ) )+
            {
                if ( !(stream_VARIABLE.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_VARIABLE.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:136:32: ^( ARG VARIABLE )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:139:1: block : ( statement | NEWLINE )* -> ^( BLOCK ( statement )* ) ;
    public final GremlinParser.block_return block() throws RecognitionException {
        GremlinParser.block_return retval = new GremlinParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE74=null;
        GremlinParser.statement_return statement73 = null;


        CommonTree NEWLINE74_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:5: ( ( statement | NEWLINE )* -> ^( BLOCK ( statement )* ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:7: ( statement | NEWLINE )*
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:7: ( statement | NEWLINE )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==NULL||(LA15_0>=VARIABLE && LA15_0<=PROPERTY)||LA15_0==65||(LA15_0>=69 && LA15_0<=70)||LA15_0==72||(LA15_0>=74 && LA15_0<=78)) ) {
                    alt15=1;
                }
                else if ( (LA15_0==NEWLINE) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:8: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block836);
            	    statement73=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement73.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:20: NEWLINE
            	    {
            	    NEWLINE74=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block840); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE74);


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 140:30: -> ^( BLOCK ( statement )* )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:33: ^( BLOCK ( statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:41: ( statement )*
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

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

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:143:1: expression : operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* ;
    public final GremlinParser.expression_return expression() throws RecognitionException {
        GremlinParser.expression_return retval = new GremlinParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal76=null;
        Token string_literal77=null;
        Token char_literal78=null;
        Token string_literal79=null;
        Token char_literal80=null;
        Token string_literal81=null;
        GremlinParser.operation_return operation75 = null;

        GremlinParser.operation_return operation82 = null;


        CommonTree char_literal76_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree char_literal78_tree=null;
        CommonTree string_literal79_tree=null;
        CommonTree char_literal80_tree=null;
        CommonTree string_literal81_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:2: ( operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:4: operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_operation_in_expression863);
            operation75=operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, operation75.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:14: ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=81 && LA17_0<=86)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' )
            	    int alt16=6;
            	    switch ( input.LA(1) ) {
            	    case 81:
            	        {
            	        alt16=1;
            	        }
            	        break;
            	    case 82:
            	        {
            	        alt16=2;
            	        }
            	        break;
            	    case 83:
            	        {
            	        alt16=3;
            	        }
            	        break;
            	    case 84:
            	        {
            	        alt16=4;
            	        }
            	        break;
            	    case 85:
            	        {
            	        alt16=5;
            	        }
            	        break;
            	    case 86:
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
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:16: '='
            	            {
            	            char_literal76=(Token)match(input,81,FOLLOW_81_in_expression867); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal76_tree = (CommonTree)adaptor.create(char_literal76);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal76_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:23: '!='
            	            {
            	            string_literal77=(Token)match(input,82,FOLLOW_82_in_expression872); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal77_tree = (CommonTree)adaptor.create(string_literal77);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal77_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:31: '<'
            	            {
            	            char_literal78=(Token)match(input,83,FOLLOW_83_in_expression877); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal78_tree = (CommonTree)adaptor.create(char_literal78);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal78_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:38: '<='
            	            {
            	            string_literal79=(Token)match(input,84,FOLLOW_84_in_expression882); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal79_tree = (CommonTree)adaptor.create(string_literal79);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal79_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:46: '>'
            	            {
            	            char_literal80=(Token)match(input,85,FOLLOW_85_in_expression887); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal80_tree = (CommonTree)adaptor.create(char_literal80);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal80_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:144:53: '>='
            	            {
            	            string_literal81=(Token)match(input,86,FOLLOW_86_in_expression892); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal81_tree = (CommonTree)adaptor.create(string_literal81);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal81_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_operation_in_expression896);
            	    operation82=operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, operation82.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:147:1: operation : binary_operation ( ( '+' | '-' ) binary_operation )* ;
    public final GremlinParser.operation_return operation() throws RecognitionException {
        GremlinParser.operation_return retval = new GremlinParser.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal84=null;
        Token char_literal85=null;
        GremlinParser.binary_operation_return binary_operation83 = null;

        GremlinParser.binary_operation_return binary_operation86 = null;


        CommonTree char_literal84_tree=null;
        CommonTree char_literal85_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:2: ( binary_operation ( ( '+' | '-' ) binary_operation )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:4: binary_operation ( ( '+' | '-' ) binary_operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_binary_operation_in_operation910);
            binary_operation83=binary_operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation83.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:21: ( ( '+' | '-' ) binary_operation )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=87 && LA19_0<=88)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:22: ( '+' | '-' ) binary_operation
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:22: ( '+' | '-' )
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==87) ) {
            	        alt18=1;
            	    }
            	    else if ( (LA18_0==88) ) {
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
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:23: '+'
            	            {
            	            char_literal84=(Token)match(input,87,FOLLOW_87_in_operation914); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal84_tree = (CommonTree)adaptor.create(char_literal84);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal84_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:148:28: '-'
            	            {
            	            char_literal85=(Token)match(input,88,FOLLOW_88_in_operation917); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal85_tree = (CommonTree)adaptor.create(char_literal85);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal85_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_binary_operation_in_operation921);
            	    binary_operation86=binary_operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation86.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:151:1: binary_operation : atom ( ( '*' | 'div' ) atom )* ;
    public final GremlinParser.binary_operation_return binary_operation() throws RecognitionException {
        GremlinParser.binary_operation_return retval = new GremlinParser.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal88=null;
        Token string_literal89=null;
        GremlinParser.atom_return atom87 = null;

        GremlinParser.atom_return atom90 = null;


        CommonTree char_literal88_tree=null;
        CommonTree string_literal89_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:2: ( atom ( ( '*' | 'div' ) atom )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:4: atom ( ( '*' | 'div' ) atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_binary_operation935);
            atom87=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom87.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:9: ( ( '*' | 'div' ) atom )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=89 && LA21_0<=90)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:10: ( '*' | 'div' ) atom
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:10: ( '*' | 'div' )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==89) ) {
            	        alt20=1;
            	    }
            	    else if ( (LA20_0==90) ) {
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
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:11: '*'
            	            {
            	            char_literal88=(Token)match(input,89,FOLLOW_89_in_binary_operation939); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal88_tree = (CommonTree)adaptor.create(char_literal88);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal88_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:152:16: 'div'
            	            {
            	            string_literal89=(Token)match(input,90,FOLLOW_90_in_binary_operation942); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal89_tree = (CommonTree)adaptor.create(string_literal89);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal89_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_atom_in_binary_operation946);
            	    atom90=atom();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom90.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:155:1: function_call : function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) ;
    public final GremlinParser.function_call_return function_call() throws RecognitionException {
        GremlinParser.function_call_return retval = new GremlinParser.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal92=null;
        Token char_literal94=null;
        GremlinParser.function_name_return function_name91 = null;

        GremlinParser.function_call_params_return function_call_params93 = null;


        CommonTree char_literal92_tree=null;
        CommonTree char_literal94_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleSubtreeStream stream_function_call_params=new RewriteRuleSubtreeStream(adaptor,"rule function_call_params");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:2: ( function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:4: function_name '(' ( function_call_params )* ')'
            {
            pushFollow(FOLLOW_function_name_in_function_call960);
            function_name91=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name91.getTree());
            char_literal92=(Token)match(input,78,FOLLOW_78_in_function_call962); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal92);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:22: ( function_call_params )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==NULL||(LA22_0>=VARIABLE && LA22_0<=PROPERTY)||LA22_0==65||(LA22_0>=69 && LA22_0<=70)||LA22_0==72||(LA22_0>=74 && LA22_0<=78)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: function_call_params
            	    {
            	    pushFollow(FOLLOW_function_call_params_in_function_call964);
            	    function_call_params93=function_call_params();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function_call_params.add(function_call_params93.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            char_literal94=(Token)match(input,79,FOLLOW_79_in_function_call967); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(char_literal94);



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
            // 156:48: -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:51: ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:77: ^( ARGS ( function_call_params )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:84: ( function_call_params )*
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:159:1: function_name : ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) ;
    public final GremlinParser.function_name_return function_name() throws RecognitionException {
        GremlinParser.function_name_return retval = new GremlinParser.function_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ns=null;
        Token ln=null;
        Token char_literal95=null;

        CommonTree ns_tree=null;
        CommonTree ln_tree=null;
        CommonTree char_literal95_tree=null;
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:2: (ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:4: ns= IDENTIFIER ':' ln= IDENTIFIER
            {
            ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name996); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(ns);

            char_literal95=(Token)match(input,91,FOLLOW_91_in_function_name998); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_91.add(char_literal95);

            ln=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name1002); if (state.failed) return retval; 
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
            // 160:36: -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:39: ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_NAME, "FUNC_NAME"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:51: ^( NS $ns)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NS, "NS"), root_2);

                adaptor.addChild(root_2, stream_ns.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:61: ^( NAME $ln)
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:163:1: function_call_params : statement ( ',' statement )* -> ( ^( ARG statement ) )+ ;
    public final GremlinParser.function_call_params_return function_call_params() throws RecognitionException {
        GremlinParser.function_call_params_return retval = new GremlinParser.function_call_params_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal97=null;
        GremlinParser.statement_return statement96 = null;

        GremlinParser.statement_return statement98 = null;


        CommonTree char_literal97_tree=null;
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:164:2: ( statement ( ',' statement )* -> ( ^( ARG statement ) )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:164:4: statement ( ',' statement )*
            {
            pushFollow(FOLLOW_statement_in_function_call_params1037);
            statement96=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement96.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:164:14: ( ',' statement )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==80) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:164:15: ',' statement
            	    {
            	    char_literal97=(Token)match(input,80,FOLLOW_80_in_function_call_params1040); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_80.add(char_literal97);

            	    pushFollow(FOLLOW_statement_in_function_call_params1042);
            	    statement98=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement98.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 164:31: -> ( ^( ARG statement ) )+
            {
                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:164:34: ^( ARG statement )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARG, "ARG"), root_1);

                    adaptor.addChild(root_1, stream_statement.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_statement.reset();

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

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:167:1: atom : ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | range | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | function_call | IDENTIFIER | '(' statement ')' | '(' collection ')' );
    public final GremlinParser.atom_return atom() throws RecognitionException {
        GremlinParser.atom_return retval = new GremlinParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token b=null;
        Token G_INT99=null;
        Token G_LONG100=null;
        Token G_FLOAT101=null;
        Token G_DOUBLE102=null;
        Token StringLiteral104=null;
        Token NULL105=null;
        Token PROPERTY106=null;
        Token VARIABLE107=null;
        Token IDENTIFIER109=null;
        Token char_literal110=null;
        Token char_literal112=null;
        Token char_literal113=null;
        Token char_literal115=null;
        GremlinParser.range_return range103 = null;

        GremlinParser.function_call_return function_call108 = null;

        GremlinParser.statement_return statement111 = null;

        GremlinParser.collection_return collection114 = null;


        CommonTree b_tree=null;
        CommonTree G_INT99_tree=null;
        CommonTree G_LONG100_tree=null;
        CommonTree G_FLOAT101_tree=null;
        CommonTree G_DOUBLE102_tree=null;
        CommonTree StringLiteral104_tree=null;
        CommonTree NULL105_tree=null;
        CommonTree PROPERTY106_tree=null;
        CommonTree VARIABLE107_tree=null;
        CommonTree IDENTIFIER109_tree=null;
        CommonTree char_literal110_tree=null;
        CommonTree char_literal112_tree=null;
        CommonTree char_literal113_tree=null;
        CommonTree char_literal115_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_G_LONG=new RewriteRuleTokenStream(adaptor,"token G_LONG");
        RewriteRuleTokenStream stream_BOOLEAN=new RewriteRuleTokenStream(adaptor,"token BOOLEAN");
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_G_DOUBLE=new RewriteRuleTokenStream(adaptor,"token G_DOUBLE");
        RewriteRuleTokenStream stream_PROPERTY=new RewriteRuleTokenStream(adaptor,"token PROPERTY");
        RewriteRuleTokenStream stream_G_FLOAT=new RewriteRuleTokenStream(adaptor,"token G_FLOAT");
        RewriteRuleTokenStream stream_G_INT=new RewriteRuleTokenStream(adaptor,"token G_INT");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:168:2: ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | range | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | function_call | IDENTIFIER | '(' statement ')' | '(' collection ')' )
            int alt24=14;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:168:6: G_INT
                    {
                    G_INT99=(Token)match(input,G_INT,FOLLOW_G_INT_in_atom1067); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_INT.add(G_INT99);



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
                    // 168:22: -> ^( INT G_INT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:168:25: ^( INT G_INT )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:6: G_LONG
                    {
                    G_LONG100=(Token)match(input,G_LONG,FOLLOW_G_LONG_in_atom1092); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_LONG.add(G_LONG100);



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
                    // 169:22: -> ^( LONG G_LONG )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:25: ^( LONG G_LONG )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:170:6: G_FLOAT
                    {
                    G_FLOAT101=(Token)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_atom1116); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_FLOAT.add(G_FLOAT101);



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
                    // 170:22: -> ^( FLOAT G_FLOAT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:170:25: ^( FLOAT G_FLOAT )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:171:6: G_DOUBLE
                    {
                    G_DOUBLE102=(Token)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_atom1139); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_DOUBLE.add(G_DOUBLE102);



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
                    // 171:22: -> ^( DOUBLE G_DOUBLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:171:25: ^( DOUBLE G_DOUBLE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:172:6: range
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_range_in_atom1161);
                    range103=range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, range103.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:173:4: StringLiteral
                    {
                    StringLiteral104=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_atom1166); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral104);



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
                    // 173:18: -> ^( STR StringLiteral )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:173:21: ^( STR StringLiteral )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:174:9: b= BOOLEAN
                    {
                    b=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_atom1186); if (state.failed) return retval; 
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
                    // 174:25: -> ^( BOOL $b)
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:174:28: ^( BOOL $b)
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
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:175:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NULL105=(Token)match(input,NULL,FOLLOW_NULL_in_atom1211); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL105_tree = (CommonTree)adaptor.create(NULL105);
                    adaptor.addChild(root_0, NULL105_tree);
                    }

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:176:4: PROPERTY
                    {
                    PROPERTY106=(Token)match(input,PROPERTY,FOLLOW_PROPERTY_in_atom1216); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROPERTY.add(PROPERTY106);



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
                    // 176:17: -> ^( PROPERTY_CALL PROPERTY )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:176:20: ^( PROPERTY_CALL PROPERTY )
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
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:177:4: VARIABLE
                    {
                    VARIABLE107=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_atom1233); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE107);



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
                    // 177:20: -> ^( VARIABLE_CALL VARIABLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:177:23: ^( VARIABLE_CALL VARIABLE )
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
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:178:4: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_call_in_atom1253);
                    function_call108=function_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_call108.getTree());

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:179:6: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IDENTIFIER109=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atom1260); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER109_tree = (CommonTree)adaptor.create(IDENTIFIER109);
                    adaptor.addChild(root_0, IDENTIFIER109_tree);
                    }

                    }
                    break;
                case 13 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:180:4: '(' statement ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal110=(Token)match(input,78,FOLLOW_78_in_atom1265); if (state.failed) return retval;
                    pushFollow(FOLLOW_statement_in_atom1268);
                    statement111=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement111.getTree());
                    char_literal112=(Token)match(input,79,FOLLOW_79_in_atom1270); if (state.failed) return retval;

                    }
                    break;
                case 14 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:181:6: '(' collection ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal113=(Token)match(input,78,FOLLOW_78_in_atom1278); if (state.failed) return retval;
                    pushFollow(FOLLOW_collection_in_atom1281);
                    collection114=collection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collection114.getTree());
                    char_literal115=(Token)match(input,79,FOLLOW_79_in_atom1283); if (state.failed) return retval;

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

    public static class range_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "range"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:221:1: range : min= G_INT '..' max= G_INT -> ^( RANGE $min $max) ;
    public final GremlinParser.range_return range() throws RecognitionException {
        GremlinParser.range_return retval = new GremlinParser.range_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token min=null;
        Token max=null;
        Token string_literal116=null;

        CommonTree min_tree=null;
        CommonTree max_tree=null;
        CommonTree string_literal116_tree=null;
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleTokenStream stream_G_INT=new RewriteRuleTokenStream(adaptor,"token G_INT");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:222:5: (min= G_INT '..' max= G_INT -> ^( RANGE $min $max) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:222:9: min= G_INT '..' max= G_INT
            {
            min=(Token)match(input,G_INT,FOLLOW_G_INT_in_range1466); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_G_INT.add(min);

            string_literal116=(Token)match(input,65,FOLLOW_65_in_range1468); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_65.add(string_literal116);

            max=(Token)match(input,G_INT,FOLLOW_G_INT_in_range1472); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_G_INT.add(max);



            // AST REWRITE
            // elements: max, min
            // token labels: min, max
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_min=new RewriteRuleTokenStream(adaptor,"token min",min);
            RewriteRuleTokenStream stream_max=new RewriteRuleTokenStream(adaptor,"token max",max);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 222:35: -> ^( RANGE $min $max)
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:222:38: ^( RANGE $min $max)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RANGE, "RANGE"), root_1);

                adaptor.addChild(root_1, stream_min.nextNode());
                adaptor.addChild(root_1, stream_max.nextNode());

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
    // $ANTLR end "range"

    public static class collection_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "collection"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:229:1: collection : token ( '[' statement ']' )+ -> ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) ) ;
    public final GremlinParser.collection_return collection() throws RecognitionException {
        GremlinParser.collection_return retval = new GremlinParser.collection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal118=null;
        Token char_literal120=null;
        GremlinParser.token_return token117 = null;

        GremlinParser.statement_return statement119 = null;


        CommonTree char_literal118_tree=null;
        CommonTree char_literal120_tree=null;
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_token=new RewriteRuleSubtreeStream(adaptor,"rule token");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:230:5: ( token ( '[' statement ']' )+ -> ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:230:7: token ( '[' statement ']' )+
            {
            pushFollow(FOLLOW_token_in_collection1523);
            token117=token();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_token.add(token117.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:230:13: ( '[' statement ']' )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==63) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:230:14: '[' statement ']'
            	    {
            	    char_literal118=(Token)match(input,63,FOLLOW_63_in_collection1526); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_63.add(char_literal118);

            	    pushFollow(FOLLOW_statement_in_collection1528);
            	    statement119=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement119.getTree());
            	    char_literal120=(Token)match(input,64,FOLLOW_64_in_collection1530); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_64.add(char_literal120);


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);



            // AST REWRITE
            // elements: statement, token
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 230:34: -> ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:230:37: ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COLLECTION_CALL, "COLLECTION_CALL"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:230:55: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STEP, "STEP"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:230:62: ^( TOKEN token )
                {
                CommonTree root_3 = (CommonTree)adaptor.nil();
                root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TOKEN, "TOKEN"), root_3);

                adaptor.addChild(root_3, stream_token.nextTree());

                adaptor.addChild(root_2, root_3);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:230:77: ^( PREDICATES ( ^( PREDICATE statement ) )+ )
                {
                CommonTree root_3 = (CommonTree)adaptor.nil();
                root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREDICATES, "PREDICATES"), root_3);

                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:230:90: ^( PREDICATE statement )
                    {
                    CommonTree root_4 = (CommonTree)adaptor.nil();
                    root_4 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREDICATE, "PREDICATE"), root_4);

                    adaptor.addChild(root_4, stream_statement.nextTree());

                    adaptor.addChild(root_3, root_4);
                    }

                }
                stream_statement.reset();

                adaptor.addChild(root_2, root_3);
                }

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
    // $ANTLR end "collection"

    // $ANTLR start synpred5_Gremlin
    public final void synpred5_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:62:9: ( ( ( statement )? NEWLINE )+ )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:62:9: ( ( statement )? NEWLINE )+
        {
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:62:9: ( ( statement )? NEWLINE )+
        int cnt29=0;
        loop29:
        do {
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==NULL||(LA29_0>=NEWLINE && LA29_0<=PROPERTY)||LA29_0==65||(LA29_0>=69 && LA29_0<=70)||LA29_0==72||(LA29_0>=74 && LA29_0<=78)) ) {
                alt29=1;
            }


            switch (alt29) {
        	case 1 :
        	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:62:10: ( statement )? NEWLINE
        	    {
        	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:62:10: ( statement )?
        	    int alt28=2;
        	    int LA28_0 = input.LA(1);

        	    if ( (LA28_0==NULL||(LA28_0>=VARIABLE && LA28_0<=PROPERTY)||LA28_0==65||(LA28_0>=69 && LA28_0<=70)||LA28_0==72||(LA28_0>=74 && LA28_0<=78)) ) {
        	        alt28=1;
        	    }
        	    switch (alt28) {
        	        case 1 :
        	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: statement
        	            {
        	            pushFollow(FOLLOW_statement_in_synpred5_Gremlin256);
        	            statement();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }
        	            break;

        	    }

        	    match(input,NEWLINE,FOLLOW_NEWLINE_in_synpred5_Gremlin259); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt29 >= 1 ) break loop29;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(29, input);
                    throw eee;
            }
            cnt29++;
        } while (true);


        }
    }
    // $ANTLR end synpred5_Gremlin

    // $ANTLR start synpred18_Gremlin
    public final void synpred18_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:4: ( gpath_statement )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:4: gpath_statement
        {
        pushFollow(FOLLOW_gpath_statement_in_synpred18_Gremlin452);
        gpath_statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_Gremlin

    // $ANTLR start synpred19_Gremlin
    public final void synpred19_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:91:4: ( VARIABLE ':=' statement )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:91:4: VARIABLE ':=' statement
        {
        match(input,VARIABLE,FOLLOW_VARIABLE_in_synpred19_Gremlin457); if (state.failed) return ;
        match(input,66,FOLLOW_66_in_synpred19_Gremlin459); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred19_Gremlin461);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_Gremlin

    // $ANTLR start synpred38_Gremlin
    public final void synpred38_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:168:6: ( G_INT )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:168:6: G_INT
        {
        match(input,G_INT,FOLLOW_G_INT_in_synpred38_Gremlin1067); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_Gremlin

    // $ANTLR start synpred42_Gremlin
    public final void synpred42_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:172:6: ( range )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:172:6: range
        {
        pushFollow(FOLLOW_range_in_synpred42_Gremlin1161);
        range();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_Gremlin

    // $ANTLR start synpred48_Gremlin
    public final void synpred48_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:178:4: ( function_call )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:178:4: function_call
        {
        pushFollow(FOLLOW_function_call_in_synpred48_Gremlin1253);
        function_call();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_Gremlin

    // $ANTLR start synpred49_Gremlin
    public final void synpred49_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:179:6: ( IDENTIFIER )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:179:6: IDENTIFIER
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred49_Gremlin1260); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_Gremlin

    // $ANTLR start synpred50_Gremlin
    public final void synpred50_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:180:4: ( '(' statement ')' )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:180:4: '(' statement ')'
        {
        match(input,78,FOLLOW_78_in_synpred50_Gremlin1265); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred50_Gremlin1268);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,79,FOLLOW_79_in_synpred50_Gremlin1270); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_Gremlin

    // Delegated rules

    public final boolean synpred19_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred42_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_Gremlin_fragment(); // can never throw exception
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
    public final boolean synpred38_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_Gremlin_fragment(); // can never throw exception
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
    public final boolean synpred18_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA6_eotS =
        "\27\uffff";
    static final String DFA6_eofS =
        "\27\uffff";
    static final String DFA6_minS =
        "\1\42\10\uffff\15\0\1\uffff";
    static final String DFA6_maxS =
        "\1\116\10\uffff\15\0\1\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\23\uffff\1\3";
    static final String DFA6_specialS =
        "\11\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\17\4\uffff\1\1\1\25\1\21\1\15\1\22\1\11\1\12\1\13\1\14\1"+
            "\16\1\20\17\uffff\1\24\3\uffff\2\2\1\uffff\1\2\1\uffff\4\2\1"+
            "\23",
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
            "\1\uffff",
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
            return "60:1: program : ( ( COMMENT )+ | ( ( statement )? NEWLINE )+ | ( ( collection )? NEWLINE )+ );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_9 = input.LA(1);

                         
                        int index6_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_10 = input.LA(1);

                         
                        int index6_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_11 = input.LA(1);

                         
                        int index6_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_12 = input.LA(1);

                         
                        int index6_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_12);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_13 = input.LA(1);

                         
                        int index6_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_13);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_14 = input.LA(1);

                         
                        int index6_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_14);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_15 = input.LA(1);

                         
                        int index6_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_15);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_16 = input.LA(1);

                         
                        int index6_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_16);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_17 = input.LA(1);

                         
                        int index6_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_17);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_18 = input.LA(1);

                         
                        int index6_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_18);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_19 = input.LA(1);

                         
                        int index6_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_19);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_20 = input.LA(1);

                         
                        int index6_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_20);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA6_21 = input.LA(1);

                         
                        int index6_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Gremlin()) ) {s = 2;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index6_21);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA12_eotS =
        "\26\uffff";
    static final String DFA12_eofS =
        "\26\uffff";
    static final String DFA12_minS =
        "\1\42\7\uffff\13\0\3\uffff";
    static final String DFA12_maxS =
        "\1\116\7\uffff\13\0\3\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\13\uffff\1\10\1\12\1\11";
    static final String DFA12_specialS =
        "\10\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\3\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\16\6\uffff\1\20\1\14\1\21\1\10\1\11\1\12\1\13\1\15\1\17\17"+
            "\uffff\1\23\3\uffff\1\7\1\1\1\uffff\1\2\1\uffff\1\3\1\4\1\5"+
            "\1\6\1\22",
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
            "",
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
            return "82:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_8 = input.LA(1);

                         
                        int index12_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index12_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_9 = input.LA(1);

                         
                        int index12_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index12_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_10 = input.LA(1);

                         
                        int index12_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index12_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_11 = input.LA(1);

                         
                        int index12_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index12_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA12_12 = input.LA(1);

                         
                        int index12_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index12_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA12_13 = input.LA(1);

                         
                        int index12_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index12_13);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA12_14 = input.LA(1);

                         
                        int index12_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index12_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA12_15 = input.LA(1);

                         
                        int index12_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index12_15);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA12_16 = input.LA(1);

                         
                        int index12_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Gremlin()) ) {s = 19;}

                        else if ( (synpred19_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index12_16);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA12_17 = input.LA(1);

                         
                        int index12_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index12_17);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA12_18 = input.LA(1);

                         
                        int index12_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index12_18);
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
    static final String DFA24_eotS =
        "\22\uffff";
    static final String DFA24_eofS =
        "\22\uffff";
    static final String DFA24_minS =
        "\1\42\1\0\10\uffff\2\0\6\uffff";
    static final String DFA24_maxS =
        "\1\116\1\0\10\uffff\2\0\6\uffff";
    static final String DFA24_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\6\1\7\1\10\1\11\1\12\2\uffff\1\1\1\5\1\13"+
        "\1\14\1\15\1\16";
    static final String DFA24_specialS =
        "\1\uffff\1\0\10\uffff\1\1\1\2\6\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\7\6\uffff\1\11\1\5\1\12\1\1\1\2\1\3\1\4\1\6\1\10\34\uffff"+
            "\1\13",
            "\1\uffff",
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
            return "167:1: atom : ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | range | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | function_call | IDENTIFIER | '(' statement ')' | '(' collection ')' );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_1 = input.LA(1);

                         
                        int index24_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_Gremlin()) ) {s = 12;}

                        else if ( (synpred42_Gremlin()) ) {s = 13;}

                         
                        input.seek(index24_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_10 = input.LA(1);

                         
                        int index24_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_Gremlin()) ) {s = 14;}

                        else if ( (synpred49_Gremlin()) ) {s = 15;}

                         
                        input.seek(index24_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_11 = input.LA(1);

                         
                        int index24_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_Gremlin()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index24_11);
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
 

    public static final BitSet FOLLOW_COMMENT_in_program244 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_statement_in_program256 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_program259 = new BitSet(new long[]{0x0003FF0400000002L,0x0000000000007D62L});
    public static final BitSet FOLLOW_collection_in_program272 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_program275 = new BitSet(new long[]{0x0003FF0400000002L,0x0000000000004002L});
    public static final BitSet FOLLOW_step_in_gpath_statement312 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_gpath_statement314 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004002L});
    public static final BitSet FOLLOW_step_in_gpath_statement316 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_gpath_statement319 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004002L});
    public static final BitSet FOLLOW_step_in_gpath_statement321 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_token_in_step347 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_step350 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_step352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_step354 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_expression_in_token396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_token400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_definition_statement_in_statement437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_statement452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_statement457 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_statement459 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_statement461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement476 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_67_in_statement480 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_68_in_statement483 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_expression_in_statement487 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_69_in_include_statement500 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_if_statement523 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_if_statement525 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_if_statement527 = new BitSet(new long[]{0x0003FF0400000000L,0x0000000000007DE2L});
    public static final BitSet FOLLOW_block_in_if_statement541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_if_statement552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_foreach_statement577 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement579 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_foreach_statement581 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_foreach_statement583 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_foreach_statement585 = new BitSet(new long[]{0x0003FF0400000000L,0x0000000000007DE2L});
    public static final BitSet FOLLOW_block_in_foreach_statement596 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_foreach_statement604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_while_statement628 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_while_statement630 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_while_statement632 = new BitSet(new long[]{0x0003FF0400000000L,0x0000000000007DE2L});
    public static final BitSet FOLLOW_block_in_while_statement643 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_while_statement651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_repeat_statement676 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_repeat_statement678 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeat_statement680 = new BitSet(new long[]{0x0003FF0400000000L,0x0000000000007DE2L});
    public static final BitSet FOLLOW_block_in_repeat_statement687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_repeat_statement691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_path_definition_statement713 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_path_definition_statement715 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_path_definition_statement717 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_path_definition_statement724 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_path_definition_statement726 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_path_definition_statement730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_function_definition_statement752 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_function_name_in_function_definition_statement754 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_function_definition_statement756 = new BitSet(new long[]{0x0000020000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_formal_arguments_in_function_definition_statement758 = new BitSet(new long[]{0x0000020000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_function_definition_statement761 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_function_definition_statement763 = new BitSet(new long[]{0x0003FF0400000000L,0x0000000000007DE2L});
    public static final BitSet FOLLOW_block_in_function_definition_statement770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_function_definition_statement774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments804 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_formal_arguments807 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments809 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_statement_in_block836 = new BitSet(new long[]{0x0003FF0400000002L,0x0000000000007D62L});
    public static final BitSet FOLLOW_NEWLINE_in_block840 = new BitSet(new long[]{0x0003FF0400000002L,0x0000000000007D62L});
    public static final BitSet FOLLOW_operation_in_expression863 = new BitSet(new long[]{0x0000000000000002L,0x00000000007E0000L});
    public static final BitSet FOLLOW_81_in_expression867 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_82_in_expression872 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_83_in_expression877 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_84_in_expression882 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_85_in_expression887 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_86_in_expression892 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_operation_in_expression896 = new BitSet(new long[]{0x0000000000000002L,0x00000000007E0000L});
    public static final BitSet FOLLOW_binary_operation_in_operation910 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
    public static final BitSet FOLLOW_87_in_operation914 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_88_in_operation917 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_binary_operation_in_operation921 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
    public static final BitSet FOLLOW_atom_in_binary_operation935 = new BitSet(new long[]{0x0000000000000002L,0x0000000006000000L});
    public static final BitSet FOLLOW_89_in_binary_operation939 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_90_in_binary_operation942 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_atom_in_binary_operation946 = new BitSet(new long[]{0x0000000000000002L,0x0000000006000000L});
    public static final BitSet FOLLOW_function_name_in_function_call960 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_function_call962 = new BitSet(new long[]{0x0003FE0400000000L,0x000000000000FD62L});
    public static final BitSet FOLLOW_function_call_params_in_function_call964 = new BitSet(new long[]{0x0003FE0400000000L,0x000000000000FD62L});
    public static final BitSet FOLLOW_79_in_function_call967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name996 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_function_name998 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_function_call_params1037 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_function_call_params1040 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_function_call_params1042 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_G_INT_in_atom1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_LONG_in_atom1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_FLOAT_in_atom1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_DOUBLE_in_atom1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_atom1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_atom1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_atom1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_atom1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROPERTY_in_atom1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_atom1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_atom1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_atom1265 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_atom1268 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_atom1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_atom1278 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000004002L});
    public static final BitSet FOLLOW_collection_in_atom1281 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_atom1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_INT_in_range1466 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_range1468 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_G_INT_in_range1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_token_in_collection1523 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_collection1526 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_collection1528 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_collection1530 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred5_Gremlin256 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_synpred5_Gremlin259 = new BitSet(new long[]{0x0003FF0400000002L,0x0000000000007D62L});
    public static final BitSet FOLLOW_gpath_statement_in_synpred18_Gremlin452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_synpred19_Gremlin457 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_synpred19_Gremlin459 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_synpred19_Gremlin461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_INT_in_synpred38_Gremlin1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_synpred42_Gremlin1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_synpred48_Gremlin1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred49_Gremlin1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_synpred50_Gremlin1265 = new BitSet(new long[]{0x0003FE0400000000L,0x0000000000007D62L});
    public static final BitSet FOLLOW_statement_in_synpred50_Gremlin1268 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_synpred50_Gremlin1270 = new BitSet(new long[]{0x0000000000000002L});

}
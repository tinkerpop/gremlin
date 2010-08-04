// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g 2010-08-05 00:49:28
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "PATH", "GPATH", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "SELF", "HISTORY", "FUNC_CALL", "IF", "ELSE", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "SCRIPT", "INT", "LONG", "FLOAT", "DOUBLE", "STR", "ARR", "BOOL", "NULL", "RANGE", "PROPERTY_CALL", "VARIABLE_CALL", "COLLECTION_CALL", "COMMENT", "VARIABLE", "NEWLINE", "StringLiteral", "IDENTIFIER", "G_INT", "G_LONG", "G_FLOAT", "G_DOUBLE", "BOOLEAN", "PROPERTY", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "':='", "'/'", "'['", "']'", "'..'", "'and'", "'or'", "'include'", "'script'", "'if'", "'else'", "'end'", "'foreach'", "'in'", "'while'", "'repeat'", "'path'", "'func'", "'('", "')'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "'mod'", "':'"
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
    public static final int PATH=11;
    public static final int G_INT=46;
    public static final int SingleEscapeCharacter=59;
    public static final int INCLUDE=27;
    public static final int ARGS=6;
    public static final int DOUBLE=32;
    public static final int VAR=4;
    public static final int GPATH=12;
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
    public static final int VARIABLE=42;
    public static final int T__70=70;
    public static final int G_DOUBLE=49;
    public static final int PROPERTY=51;
    public static final int FUNC=7;
    public static final int G_LONG=47;
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
    public static final int BOOLEAN=50;
    public static final int IDENTIFIER=45;
    public static final int EscapeCharacter=61;
    public static final int COLLECTION_CALL=40;
    public static final int G_FLOAT=48;
    public static final int PROPERTY_CALL=38;
    public static final int UnicodeEscapeSequence=58;
    public static final int RANGE=37;
    public static final int StringLiteral=44;
    public static final int NEWLINE=43;
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


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:62:1: program : ( ( COMMENT )+ | VARIABLE ':=' collection NEWLINE -> ^( VAR VARIABLE collection ) | ( ( statement )? NEWLINE )+ | ( ( collection )? NEWLINE )+ );
    public final GremlinParser.program_return program() throws RecognitionException {
        GremlinParser.program_return retval = new GremlinParser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMENT1=null;
        Token VARIABLE2=null;
        Token string_literal3=null;
        Token NEWLINE5=null;
        Token NEWLINE7=null;
        Token NEWLINE9=null;
        GremlinParser.collection_return collection4 = null;

        GremlinParser.statement_return statement6 = null;

        GremlinParser.collection_return collection8 = null;


        CommonTree COMMENT1_tree=null;
        CommonTree VARIABLE2_tree=null;
        CommonTree string_literal3_tree=null;
        CommonTree NEWLINE5_tree=null;
        CommonTree NEWLINE7_tree=null;
        CommonTree NEWLINE9_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleSubtreeStream stream_collection=new RewriteRuleSubtreeStream(adaptor,"rule collection");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:63:5: ( ( COMMENT )+ | VARIABLE ':=' collection NEWLINE -> ^( VAR VARIABLE collection ) | ( ( statement )? NEWLINE )+ | ( ( collection )? NEWLINE )+ )
            int alt6=4;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:63:7: ( COMMENT )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:63:7: ( COMMENT )+
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
                    	    COMMENT1=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_program252); if (state.failed) return retval;
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:64:9: VARIABLE ':=' collection NEWLINE
                    {
                    VARIABLE2=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_program263); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE2);

                    string_literal3=(Token)match(input,64,FOLLOW_64_in_program265); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_64.add(string_literal3);

                    pushFollow(FOLLOW_collection_in_program267);
                    collection4=collection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_collection.add(collection4.getTree());
                    NEWLINE5=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program269); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE5);



                    // AST REWRITE
                    // elements: collection, VARIABLE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 64:42: -> ^( VAR VARIABLE collection )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:64:45: ^( VAR VARIABLE collection )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE.nextNode());
                        adaptor.addChild(root_1, stream_collection.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:65:9: ( ( statement )? NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:65:9: ( ( statement )? NEWLINE )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NULL||(LA3_0>=VARIABLE && LA3_0<=PROPERTY)||LA3_0==68||(LA3_0>=71 && LA3_0<=73)||LA3_0==76||(LA3_0>=78 && LA3_0<=82)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:65:10: ( statement )? NEWLINE
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:65:10: ( statement )?
                    	    int alt2=2;
                    	    int LA2_0 = input.LA(1);

                    	    if ( (LA2_0==NULL||LA2_0==VARIABLE||(LA2_0>=StringLiteral && LA2_0<=PROPERTY)||LA2_0==68||(LA2_0>=71 && LA2_0<=73)||LA2_0==76||(LA2_0>=78 && LA2_0<=82)) ) {
                    	        alt2=1;
                    	    }
                    	    switch (alt2) {
                    	        case 1 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: statement
                    	            {
                    	            pushFollow(FOLLOW_statement_in_program290);
                    	            statement6=statement();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement6.getTree());

                    	            }
                    	            break;

                    	    }

                    	    NEWLINE7=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program293); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NEWLINE7_tree = (CommonTree)adaptor.create(NEWLINE7);
                    	    adaptor.addChild(root_0, NEWLINE7_tree);
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
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:66:9: ( ( collection )? NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:66:9: ( ( collection )? NEWLINE )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==NULL||(LA5_0>=VARIABLE && LA5_0<=PROPERTY)||LA5_0==68||LA5_0==82) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:66:10: ( collection )? NEWLINE
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:66:10: ( collection )?
                    	    int alt4=2;
                    	    int LA4_0 = input.LA(1);

                    	    if ( (LA4_0==NULL||LA4_0==VARIABLE||(LA4_0>=StringLiteral && LA4_0<=PROPERTY)||LA4_0==68||LA4_0==82) ) {
                    	        alt4=1;
                    	    }
                    	    switch (alt4) {
                    	        case 1 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: collection
                    	            {
                    	            pushFollow(FOLLOW_collection_in_program306);
                    	            collection8=collection();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, collection8.getTree());

                    	            }
                    	            break;

                    	    }

                    	    NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program309); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NEWLINE9_tree = (CommonTree)adaptor.create(NEWLINE9);
                    	    adaptor.addChild(root_0, NEWLINE9_tree);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:73:1: gpath_statement : step '/' step ( '/' step )* -> ^( GPATH ( step )+ ) ;
    public final GremlinParser.gpath_statement_return gpath_statement() throws RecognitionException {
        GremlinParser.gpath_statement_return retval = new GremlinParser.gpath_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal11=null;
        Token char_literal13=null;
        GremlinParser.step_return step10 = null;

        GremlinParser.step_return step12 = null;

        GremlinParser.step_return step14 = null;


        CommonTree char_literal11_tree=null;
        CommonTree char_literal13_tree=null;
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_step=new RewriteRuleSubtreeStream(adaptor,"rule step");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:74:2: ( step '/' step ( '/' step )* -> ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:74:4: step '/' step ( '/' step )*
            {
            pushFollow(FOLLOW_step_in_gpath_statement346);
            step10=step();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_step.add(step10.getTree());
            char_literal11=(Token)match(input,65,FOLLOW_65_in_gpath_statement348); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_65.add(char_literal11);

            pushFollow(FOLLOW_step_in_gpath_statement350);
            step12=step();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_step.add(step12.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:74:18: ( '/' step )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==65) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:74:19: '/' step
            	    {
            	    char_literal13=(Token)match(input,65,FOLLOW_65_in_gpath_statement353); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_65.add(char_literal13);

            	    pushFollow(FOLLOW_step_in_gpath_statement355);
            	    step14=step();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_step.add(step14.getTree());

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
            // 74:30: -> ^( GPATH ( step )+ )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:74:33: ^( GPATH ( step )+ )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:77:1: step : token ( '[' statement ']' )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) ;
    public final GremlinParser.step_return step() throws RecognitionException {
        GremlinParser.step_return retval = new GremlinParser.step_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal16=null;
        Token char_literal18=null;
        GremlinParser.token_return token15 = null;

        GremlinParser.statement_return statement17 = null;


        CommonTree char_literal16_tree=null;
        CommonTree char_literal18_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_token=new RewriteRuleSubtreeStream(adaptor,"rule token");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:78:5: ( token ( '[' statement ']' )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:78:7: token ( '[' statement ']' )*
            {
            pushFollow(FOLLOW_token_in_step381);
            token15=token();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_token.add(token15.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:78:13: ( '[' statement ']' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==66) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:78:14: '[' statement ']'
            	    {
            	    char_literal16=(Token)match(input,66,FOLLOW_66_in_step384); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_66.add(char_literal16);

            	    pushFollow(FOLLOW_statement_in_step386);
            	    statement17=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement17.getTree());
            	    char_literal18=(Token)match(input,67,FOLLOW_67_in_step388); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_67.add(char_literal18);


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
            // 78:34: -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:78:37: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STEP, "STEP"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:78:44: ^( TOKEN token )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TOKEN, "TOKEN"), root_2);

                adaptor.addChild(root_2, stream_token.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:78:59: ^( PREDICATES ( ^( PREDICATE statement ) )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREDICATES, "PREDICATES"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:78:72: ( ^( PREDICATE statement ) )*
                while ( stream_statement.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:78:72: ^( PREDICATE statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:81:1: token : ( expression | '..' ) ;
    public final GremlinParser.token_return token() throws RecognitionException {
        GremlinParser.token_return retval = new GremlinParser.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal20=null;
        GremlinParser.expression_return expression19 = null;


        CommonTree string_literal20_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:82:2: ( ( expression | '..' ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:82:5: ( expression | '..' )
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:82:5: ( expression | '..' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==NULL||LA9_0==VARIABLE||(LA9_0>=StringLiteral && LA9_0<=PROPERTY)||LA9_0==82) ) {
                alt9=1;
            }
            else if ( (LA9_0==68) ) {
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:82:6: expression
                    {
                    pushFollow(FOLLOW_expression_in_token430);
                    expression19=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression19.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:82:19: '..'
                    {
                    string_literal20=(Token)match(input,68,FOLLOW_68_in_token434); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal20_tree = (CommonTree)adaptor.create(string_literal20);
                    adaptor.addChild(root_0, string_literal20_tree);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:85:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | script_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* );
    public final GremlinParser.statement_return statement() throws RecognitionException {
        GremlinParser.statement_return retval = new GremlinParser.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLE30=null;
        Token string_literal31=null;
        Token string_literal34=null;
        Token string_literal35=null;
        GremlinParser.if_statement_return if_statement21 = null;

        GremlinParser.foreach_statement_return foreach_statement22 = null;

        GremlinParser.while_statement_return while_statement23 = null;

        GremlinParser.repeat_statement_return repeat_statement24 = null;

        GremlinParser.path_definition_statement_return path_definition_statement25 = null;

        GremlinParser.function_definition_statement_return function_definition_statement26 = null;

        GremlinParser.include_statement_return include_statement27 = null;

        GremlinParser.script_statement_return script_statement28 = null;

        GremlinParser.gpath_statement_return gpath_statement29 = null;

        GremlinParser.statement_return statement32 = null;

        GremlinParser.expression_return expression33 = null;

        GremlinParser.expression_return expression36 = null;


        CommonTree VARIABLE30_tree=null;
        CommonTree string_literal31_tree=null;
        CommonTree string_literal34_tree=null;
        CommonTree string_literal35_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:86:5: ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | script_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* )
            int alt12=11;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:86:9: if_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_if_statement_in_statement451);
                    if_statement21=if_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, if_statement21.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:87:4: foreach_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_foreach_statement_in_statement456);
                    foreach_statement22=foreach_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, foreach_statement22.getTree());

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:88:4: while_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_while_statement_in_statement461);
                    while_statement23=while_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, while_statement23.getTree());

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:89:4: repeat_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_repeat_statement_in_statement466);
                    repeat_statement24=repeat_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, repeat_statement24.getTree());

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:4: path_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_path_definition_statement_in_statement471);
                    path_definition_statement25=path_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, path_definition_statement25.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:91:4: function_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_definition_statement_in_statement476);
                    function_definition_statement26=function_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_definition_statement26.getTree());

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:92:4: include_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_include_statement_in_statement481);
                    include_statement27=include_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, include_statement27.getTree());

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:93:6: script_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_script_statement_in_statement488);
                    script_statement28=script_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, script_statement28.getTree());

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:94:4: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_gpath_statement_in_statement493);
                    gpath_statement29=gpath_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gpath_statement29.getTree());

                    }
                    break;
                case 10 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:95:9: VARIABLE ':=' statement
                    {
                    VARIABLE30=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_statement503); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE30);

                    string_literal31=(Token)match(input,64,FOLLOW_64_in_statement505); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_64.add(string_literal31);

                    pushFollow(FOLLOW_statement_in_statement507);
                    statement32=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement32.getTree());


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
                    // 95:34: -> ^( VAR VARIABLE statement )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:95:37: ^( VAR VARIABLE statement )
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
                case 11 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:96:4: expression ( ( 'and' | 'or' ) expression )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement524);
                    expression33=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression33.getTree());
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:96:15: ( ( 'and' | 'or' ) expression )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>=69 && LA11_0<=70)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:96:16: ( 'and' | 'or' ) expression
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:96:16: ( 'and' | 'or' )
                    	    int alt10=2;
                    	    int LA10_0 = input.LA(1);

                    	    if ( (LA10_0==69) ) {
                    	        alt10=1;
                    	    }
                    	    else if ( (LA10_0==70) ) {
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
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:96:17: 'and'
                    	            {
                    	            string_literal34=(Token)match(input,69,FOLLOW_69_in_statement528); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal34_tree = (CommonTree)adaptor.create(string_literal34);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal34_tree, root_0);
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:96:24: 'or'
                    	            {
                    	            string_literal35=(Token)match(input,70,FOLLOW_70_in_statement531); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal35_tree = (CommonTree)adaptor.create(string_literal35);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal35_tree, root_0);
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    pushFollow(FOLLOW_expression_in_statement535);
                    	    expression36=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression36.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:99:1: include_statement : 'include' StringLiteral -> ^( INCLUDE StringLiteral ) ;
    public final GremlinParser.include_statement_return include_statement() throws RecognitionException {
        GremlinParser.include_statement_return retval = new GremlinParser.include_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal37=null;
        Token StringLiteral38=null;

        CommonTree string_literal37_tree=null;
        CommonTree StringLiteral38_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:2: ( 'include' StringLiteral -> ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:4: 'include' StringLiteral
            {
            string_literal37=(Token)match(input,71,FOLLOW_71_in_include_statement548); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal37);

            StringLiteral38=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement550); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral38);



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
            // 100:28: -> ^( INCLUDE StringLiteral )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:31: ^( INCLUDE StringLiteral )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:103:1: script_statement : 'script' StringLiteral -> ^( SCRIPT StringLiteral ) ;
    public final GremlinParser.script_statement_return script_statement() throws RecognitionException {
        GremlinParser.script_statement_return retval = new GremlinParser.script_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal39=null;
        Token StringLiteral40=null;

        CommonTree string_literal39_tree=null;
        CommonTree StringLiteral40_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:5: ( 'script' StringLiteral -> ^( SCRIPT StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:9: 'script' StringLiteral
            {
            string_literal39=(Token)match(input,72,FOLLOW_72_in_script_statement574); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(string_literal39);

            StringLiteral40=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_script_statement576); if (state.failed) return retval; 
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
            // 104:32: -> ^( SCRIPT StringLiteral )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:35: ^( SCRIPT StringLiteral )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:107:1: if_statement : 'if' statement NEWLINE if_block= block ( 'else' else_block= block )? 'end' -> ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? ) ;
    public final GremlinParser.if_statement_return if_statement() throws RecognitionException {
        GremlinParser.if_statement_return retval = new GremlinParser.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal41=null;
        Token NEWLINE43=null;
        Token string_literal44=null;
        Token string_literal45=null;
        GremlinParser.block_return if_block = null;

        GremlinParser.block_return else_block = null;

        GremlinParser.statement_return statement42 = null;


        CommonTree string_literal41_tree=null;
        CommonTree NEWLINE43_tree=null;
        CommonTree string_literal44_tree=null;
        CommonTree string_literal45_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:108:2: ( 'if' statement NEWLINE if_block= block ( 'else' else_block= block )? 'end' -> ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:108:4: 'if' statement NEWLINE if_block= block ( 'else' else_block= block )? 'end'
            {
            string_literal41=(Token)match(input,73,FOLLOW_73_in_if_statement600); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_73.add(string_literal41);

            pushFollow(FOLLOW_statement_in_if_statement602);
            statement42=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement42.getTree());
            NEWLINE43=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_if_statement604); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE43);

            pushFollow(FOLLOW_block_in_if_statement620);
            if_block=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(if_block.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:110:9: ( 'else' else_block= block )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==74) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:110:10: 'else' else_block= block
                    {
                    string_literal44=(Token)match(input,74,FOLLOW_74_in_if_statement631); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_74.add(string_literal44);

                    pushFollow(FOLLOW_block_in_if_statement646);
                    else_block=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block.add(else_block.getTree());

                    }
                    break;

            }

            string_literal45=(Token)match(input,75,FOLLOW_75_in_if_statement658); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal45);



            // AST REWRITE
            // elements: statement, else_block, if_block
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
            // 112:15: -> ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:112:18: ^( IF ^( COND statement ) $if_block ( ^( ELSE $else_block) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:112:23: ^( COND statement )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COND, "COND"), root_2);

                adaptor.addChild(root_2, stream_statement.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_if_block.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:112:51: ( ^( ELSE $else_block) )?
                if ( stream_else_block.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:112:51: ^( ELSE $else_block)
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:115:1: foreach_statement : 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) ;
    public final GremlinParser.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinParser.foreach_statement_return retval = new GremlinParser.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal46=null;
        Token VARIABLE47=null;
        Token string_literal48=null;
        Token NEWLINE50=null;
        Token string_literal52=null;
        GremlinParser.statement_return statement49 = null;

        GremlinParser.block_return block51 = null;


        CommonTree string_literal46_tree=null;
        CommonTree VARIABLE47_tree=null;
        CommonTree string_literal48_tree=null;
        CommonTree NEWLINE50_tree=null;
        CommonTree string_literal52_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:116:2: ( 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:116:4: 'foreach' VARIABLE 'in' statement NEWLINE block 'end'
            {
            string_literal46=(Token)match(input,76,FOLLOW_76_in_foreach_statement692); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_76.add(string_literal46);

            VARIABLE47=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement694); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE47);

            string_literal48=(Token)match(input,77,FOLLOW_77_in_foreach_statement696); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(string_literal48);

            pushFollow(FOLLOW_statement_in_foreach_statement698);
            statement49=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement49.getTree());
            NEWLINE50=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_foreach_statement700); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE50);

            pushFollow(FOLLOW_block_in_foreach_statement711);
            block51=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block51.getTree());
            string_literal52=(Token)match(input,75,FOLLOW_75_in_foreach_statement719); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal52);



            // AST REWRITE
            // elements: block, statement, VARIABLE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 118:12: -> ^( FOREACH VARIABLE statement block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:118:15: ^( FOREACH VARIABLE statement block )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:121:1: while_statement : 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) ;
    public final GremlinParser.while_statement_return while_statement() throws RecognitionException {
        GremlinParser.while_statement_return retval = new GremlinParser.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal53=null;
        Token NEWLINE55=null;
        Token string_literal57=null;
        GremlinParser.statement_return statement54 = null;

        GremlinParser.block_return block56 = null;


        CommonTree string_literal53_tree=null;
        CommonTree NEWLINE55_tree=null;
        CommonTree string_literal57_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:122:2: ( 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:122:4: 'while' statement NEWLINE block 'end'
            {
            string_literal53=(Token)match(input,78,FOLLOW_78_in_while_statement743); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(string_literal53);

            pushFollow(FOLLOW_statement_in_while_statement745);
            statement54=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement54.getTree());
            NEWLINE55=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_while_statement747); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE55);

            pushFollow(FOLLOW_block_in_while_statement758);
            block56=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block56.getTree());
            string_literal57=(Token)match(input,75,FOLLOW_75_in_while_statement766); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal57);



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
            // 124:12: -> ^( WHILE ^( COND statement ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:124:15: ^( WHILE ^( COND statement ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:124:23: ^( COND statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:127:1: repeat_statement : 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) ;
    public final GremlinParser.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinParser.repeat_statement_return retval = new GremlinParser.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal58=null;
        Token NEWLINE60=null;
        Token string_literal62=null;
        GremlinParser.statement_return statement59 = null;

        GremlinParser.block_return block61 = null;


        CommonTree string_literal58_tree=null;
        CommonTree NEWLINE60_tree=null;
        CommonTree string_literal62_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:128:2: ( 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:128:4: 'repeat' statement NEWLINE block 'end'
            {
            string_literal58=(Token)match(input,79,FOLLOW_79_in_repeat_statement791); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(string_literal58);

            pushFollow(FOLLOW_statement_in_repeat_statement793);
            statement59=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement59.getTree());
            NEWLINE60=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeat_statement795); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE60);

            pushFollow(FOLLOW_block_in_repeat_statement802);
            block61=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block61.getTree());
            string_literal62=(Token)match(input,75,FOLLOW_75_in_repeat_statement806); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal62);



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
            // 130:9: -> ^( REPEAT statement block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:130:12: ^( REPEAT statement block )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:133:1: path_definition_statement : 'path' IDENTIFIER NEWLINE statement NEWLINE 'end' -> ^( PATH IDENTIFIER statement ) ;
    public final GremlinParser.path_definition_statement_return path_definition_statement() throws RecognitionException {
        GremlinParser.path_definition_statement_return retval = new GremlinParser.path_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal63=null;
        Token IDENTIFIER64=null;
        Token NEWLINE65=null;
        Token NEWLINE67=null;
        Token string_literal68=null;
        GremlinParser.statement_return statement66 = null;


        CommonTree string_literal63_tree=null;
        CommonTree IDENTIFIER64_tree=null;
        CommonTree NEWLINE65_tree=null;
        CommonTree NEWLINE67_tree=null;
        CommonTree string_literal68_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:134:2: ( 'path' IDENTIFIER NEWLINE statement NEWLINE 'end' -> ^( PATH IDENTIFIER statement ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:134:4: 'path' IDENTIFIER NEWLINE statement NEWLINE 'end'
            {
            string_literal63=(Token)match(input,80,FOLLOW_80_in_path_definition_statement828); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_80.add(string_literal63);

            IDENTIFIER64=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_path_definition_statement830); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER64);

            NEWLINE65=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_path_definition_statement832); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE65);

            pushFollow(FOLLOW_statement_in_path_definition_statement839);
            statement66=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement66.getTree());
            NEWLINE67=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_path_definition_statement841); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE67);

            string_literal68=(Token)match(input,75,FOLLOW_75_in_path_definition_statement845); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal68);



            // AST REWRITE
            // elements: IDENTIFIER, statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 136:9: -> ^( PATH IDENTIFIER statement )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:136:12: ^( PATH IDENTIFIER statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:139:1: function_definition_statement : 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) ;
    public final GremlinParser.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinParser.function_definition_statement_return retval = new GremlinParser.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal69=null;
        Token char_literal71=null;
        Token char_literal73=null;
        Token NEWLINE74=null;
        Token string_literal76=null;
        GremlinParser.function_name_return function_name70 = null;

        GremlinParser.formal_arguments_return formal_arguments72 = null;

        GremlinParser.block_return block75 = null;


        CommonTree string_literal69_tree=null;
        CommonTree char_literal71_tree=null;
        CommonTree char_literal73_tree=null;
        CommonTree NEWLINE74_tree=null;
        CommonTree string_literal76_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_formal_arguments=new RewriteRuleSubtreeStream(adaptor,"rule formal_arguments");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:2: ( 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:4: 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end'
            {
            string_literal69=(Token)match(input,81,FOLLOW_81_in_function_definition_statement867); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_81.add(string_literal69);

            pushFollow(FOLLOW_function_name_in_function_definition_statement869);
            function_name70=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name70.getTree());
            char_literal71=(Token)match(input,82,FOLLOW_82_in_function_definition_statement871); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal71);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:140:29: ( formal_arguments )*
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
            	    pushFollow(FOLLOW_formal_arguments_in_function_definition_statement873);
            	    formal_arguments72=formal_arguments();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formal_arguments.add(formal_arguments72.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            char_literal73=(Token)match(input,83,FOLLOW_83_in_function_definition_statement876); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(char_literal73);

            NEWLINE74=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function_definition_statement878); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE74);

            pushFollow(FOLLOW_block_in_function_definition_statement885);
            block75=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block75.getTree());
            string_literal76=(Token)match(input,75,FOLLOW_75_in_function_definition_statement889); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal76);



            // AST REWRITE
            // elements: formal_arguments, function_name, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 142:9: -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:12: ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC, "FUNC"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:33: ^( ARGS ( formal_arguments )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:40: ( formal_arguments )*
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:145:1: formal_arguments : VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ ;
    public final GremlinParser.formal_arguments_return formal_arguments() throws RecognitionException {
        GremlinParser.formal_arguments_return retval = new GremlinParser.formal_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLE77=null;
        Token char_literal78=null;
        Token VARIABLE79=null;

        CommonTree VARIABLE77_tree=null;
        CommonTree char_literal78_tree=null;
        CommonTree VARIABLE79_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:2: ( VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:4: VARIABLE ( ',' VARIABLE )*
            {
            VARIABLE77=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments919); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE77);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:13: ( ',' VARIABLE )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==84) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:14: ',' VARIABLE
            	    {
            	    char_literal78=(Token)match(input,84,FOLLOW_84_in_formal_arguments922); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_84.add(char_literal78);

            	    VARIABLE79=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments924); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE79);


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
            // 146:29: -> ( ^( ARG VARIABLE ) )+
            {
                if ( !(stream_VARIABLE.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_VARIABLE.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:32: ^( ARG VARIABLE )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:149:1: block : ( block_body | NEWLINE )* -> ^( BLOCK ( block_body )* ) ;
    public final GremlinParser.block_return block() throws RecognitionException {
        GremlinParser.block_return retval = new GremlinParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE81=null;
        GremlinParser.block_body_return block_body80 = null;


        CommonTree NEWLINE81_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_block_body=new RewriteRuleSubtreeStream(adaptor,"rule block_body");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:5: ( ( block_body | NEWLINE )* -> ^( BLOCK ( block_body )* ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:7: ( block_body | NEWLINE )*
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:7: ( block_body | NEWLINE )*
            loop16:
            do {
                int alt16=3;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==NULL||(LA16_0>=COMMENT && LA16_0<=VARIABLE)||(LA16_0>=StringLiteral && LA16_0<=PROPERTY)||LA16_0==68||(LA16_0>=71 && LA16_0<=73)||LA16_0==76||(LA16_0>=78 && LA16_0<=82)) ) {
                    alt16=1;
                }
                else if ( (LA16_0==NEWLINE) ) {
                    alt16=2;
                }


                switch (alt16) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:8: block_body
            	    {
            	    pushFollow(FOLLOW_block_body_in_block951);
            	    block_body80=block_body();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_block_body.add(block_body80.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:21: NEWLINE
            	    {
            	    NEWLINE81=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block955); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE81);


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
            // 150:31: -> ^( BLOCK ( block_body )* )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:34: ^( BLOCK ( block_body )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:42: ( block_body )*
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:153:1: block_body : ( collection NEWLINE | statement | VARIABLE ':=' collection NEWLINE -> ^( VAR VARIABLE collection ) | COMMENT NEWLINE );
    public final GremlinParser.block_body_return block_body() throws RecognitionException {
        GremlinParser.block_body_return retval = new GremlinParser.block_body_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE83=null;
        Token VARIABLE85=null;
        Token string_literal86=null;
        Token NEWLINE88=null;
        Token COMMENT89=null;
        Token NEWLINE90=null;
        GremlinParser.collection_return collection82 = null;

        GremlinParser.statement_return statement84 = null;

        GremlinParser.collection_return collection87 = null;


        CommonTree NEWLINE83_tree=null;
        CommonTree VARIABLE85_tree=null;
        CommonTree string_literal86_tree=null;
        CommonTree NEWLINE88_tree=null;
        CommonTree COMMENT89_tree=null;
        CommonTree NEWLINE90_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleSubtreeStream stream_collection=new RewriteRuleSubtreeStream(adaptor,"rule collection");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:154:5: ( collection NEWLINE | statement | VARIABLE ':=' collection NEWLINE -> ^( VAR VARIABLE collection ) | COMMENT NEWLINE )
            int alt17=4;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:154:7: collection NEWLINE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collection_in_block_body980);
                    collection82=collection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collection82.getTree());
                    NEWLINE83=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block_body982); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEWLINE83_tree = (CommonTree)adaptor.create(NEWLINE83);
                    adaptor.addChild(root_0, NEWLINE83_tree);
                    }

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:155:7: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_block_body990);
                    statement84=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement84.getTree());

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:7: VARIABLE ':=' collection NEWLINE
                    {
                    VARIABLE85=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_block_body998); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE85);

                    string_literal86=(Token)match(input,64,FOLLOW_64_in_block_body1000); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_64.add(string_literal86);

                    pushFollow(FOLLOW_collection_in_block_body1002);
                    collection87=collection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_collection.add(collection87.getTree());
                    NEWLINE88=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block_body1004); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE88);



                    // AST REWRITE
                    // elements: VARIABLE, collection
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 156:40: -> ^( VAR VARIABLE collection )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:43: ^( VAR VARIABLE collection )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                        adaptor.addChild(root_1, stream_VARIABLE.nextNode());
                        adaptor.addChild(root_1, stream_collection.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:157:7: COMMENT NEWLINE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    COMMENT89=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_block_body1022); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMENT89_tree = (CommonTree)adaptor.create(COMMENT89);
                    adaptor.addChild(root_0, COMMENT89_tree);
                    }
                    NEWLINE90=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block_body1024); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEWLINE90_tree = (CommonTree)adaptor.create(NEWLINE90);
                    adaptor.addChild(root_0, NEWLINE90_tree);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:160:1: expression : operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* ;
    public final GremlinParser.expression_return expression() throws RecognitionException {
        GremlinParser.expression_return retval = new GremlinParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal92=null;
        Token string_literal93=null;
        Token char_literal94=null;
        Token string_literal95=null;
        Token char_literal96=null;
        Token string_literal97=null;
        GremlinParser.operation_return operation91 = null;

        GremlinParser.operation_return operation98 = null;


        CommonTree char_literal92_tree=null;
        CommonTree string_literal93_tree=null;
        CommonTree char_literal94_tree=null;
        CommonTree string_literal95_tree=null;
        CommonTree char_literal96_tree=null;
        CommonTree string_literal97_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:2: ( operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:4: operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_operation_in_expression1038);
            operation91=operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, operation91.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:14: ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=85 && LA19_0<=90)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' )
            	    int alt18=6;
            	    switch ( input.LA(1) ) {
            	    case 85:
            	        {
            	        alt18=1;
            	        }
            	        break;
            	    case 86:
            	        {
            	        alt18=2;
            	        }
            	        break;
            	    case 87:
            	        {
            	        alt18=3;
            	        }
            	        break;
            	    case 88:
            	        {
            	        alt18=4;
            	        }
            	        break;
            	    case 89:
            	        {
            	        alt18=5;
            	        }
            	        break;
            	    case 90:
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
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:16: '='
            	            {
            	            char_literal92=(Token)match(input,85,FOLLOW_85_in_expression1042); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal92_tree = (CommonTree)adaptor.create(char_literal92);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal92_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:23: '!='
            	            {
            	            string_literal93=(Token)match(input,86,FOLLOW_86_in_expression1047); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal93_tree = (CommonTree)adaptor.create(string_literal93);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal93_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:31: '<'
            	            {
            	            char_literal94=(Token)match(input,87,FOLLOW_87_in_expression1052); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal94_tree = (CommonTree)adaptor.create(char_literal94);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal94_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:38: '<='
            	            {
            	            string_literal95=(Token)match(input,88,FOLLOW_88_in_expression1057); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal95_tree = (CommonTree)adaptor.create(string_literal95);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal95_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:46: '>'
            	            {
            	            char_literal96=(Token)match(input,89,FOLLOW_89_in_expression1062); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal96_tree = (CommonTree)adaptor.create(char_literal96);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal96_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:53: '>='
            	            {
            	            string_literal97=(Token)match(input,90,FOLLOW_90_in_expression1067); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal97_tree = (CommonTree)adaptor.create(string_literal97);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal97_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_operation_in_expression1071);
            	    operation98=operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, operation98.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:164:1: operation : binary_operation ( ( '+' | '-' ) binary_operation )* ;
    public final GremlinParser.operation_return operation() throws RecognitionException {
        GremlinParser.operation_return retval = new GremlinParser.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal100=null;
        Token char_literal101=null;
        GremlinParser.binary_operation_return binary_operation99 = null;

        GremlinParser.binary_operation_return binary_operation102 = null;


        CommonTree char_literal100_tree=null;
        CommonTree char_literal101_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:165:2: ( binary_operation ( ( '+' | '-' ) binary_operation )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:165:4: binary_operation ( ( '+' | '-' ) binary_operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_binary_operation_in_operation1084);
            binary_operation99=binary_operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation99.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:165:21: ( ( '+' | '-' ) binary_operation )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=91 && LA21_0<=92)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:165:22: ( '+' | '-' ) binary_operation
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:165:22: ( '+' | '-' )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==91) ) {
            	        alt20=1;
            	    }
            	    else if ( (LA20_0==92) ) {
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
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:165:23: '+'
            	            {
            	            char_literal100=(Token)match(input,91,FOLLOW_91_in_operation1088); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal100_tree = (CommonTree)adaptor.create(char_literal100);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal100_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:165:28: '-'
            	            {
            	            char_literal101=(Token)match(input,92,FOLLOW_92_in_operation1091); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal101_tree = (CommonTree)adaptor.create(char_literal101);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal101_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_binary_operation_in_operation1095);
            	    binary_operation102=binary_operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation102.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:168:1: binary_operation : atom ( ( '*' | 'div' | 'mod' ) atom )* ;
    public final GremlinParser.binary_operation_return binary_operation() throws RecognitionException {
        GremlinParser.binary_operation_return retval = new GremlinParser.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal104=null;
        Token string_literal105=null;
        Token string_literal106=null;
        GremlinParser.atom_return atom103 = null;

        GremlinParser.atom_return atom107 = null;


        CommonTree char_literal104_tree=null;
        CommonTree string_literal105_tree=null;
        CommonTree string_literal106_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:2: ( atom ( ( '*' | 'div' | 'mod' ) atom )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:4: atom ( ( '*' | 'div' | 'mod' ) atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_binary_operation1109);
            atom103=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom103.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:9: ( ( '*' | 'div' | 'mod' ) atom )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=93 && LA23_0<=95)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:10: ( '*' | 'div' | 'mod' ) atom
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:10: ( '*' | 'div' | 'mod' )
            	    int alt22=3;
            	    switch ( input.LA(1) ) {
            	    case 93:
            	        {
            	        alt22=1;
            	        }
            	        break;
            	    case 94:
            	        {
            	        alt22=2;
            	        }
            	        break;
            	    case 95:
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
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:11: '*'
            	            {
            	            char_literal104=(Token)match(input,93,FOLLOW_93_in_binary_operation1113); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal104_tree = (CommonTree)adaptor.create(char_literal104);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal104_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:16: 'div'
            	            {
            	            string_literal105=(Token)match(input,94,FOLLOW_94_in_binary_operation1116); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal105_tree = (CommonTree)adaptor.create(string_literal105);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal105_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:23: 'mod'
            	            {
            	            string_literal106=(Token)match(input,95,FOLLOW_95_in_binary_operation1119); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal106_tree = (CommonTree)adaptor.create(string_literal106);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal106_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_atom_in_binary_operation1123);
            	    atom107=atom();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom107.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:172:1: function_call : function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) ;
    public final GremlinParser.function_call_return function_call() throws RecognitionException {
        GremlinParser.function_call_return retval = new GremlinParser.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal109=null;
        Token char_literal111=null;
        GremlinParser.function_name_return function_name108 = null;

        GremlinParser.function_call_params_return function_call_params110 = null;


        CommonTree char_literal109_tree=null;
        CommonTree char_literal111_tree=null;
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleSubtreeStream stream_function_call_params=new RewriteRuleSubtreeStream(adaptor,"rule function_call_params");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:173:2: ( function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:173:4: function_name '(' ( function_call_params )* ')'
            {
            pushFollow(FOLLOW_function_name_in_function_call1137);
            function_name108=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name108.getTree());
            char_literal109=(Token)match(input,82,FOLLOW_82_in_function_call1139); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(char_literal109);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:173:22: ( function_call_params )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==NULL||LA24_0==VARIABLE||(LA24_0>=StringLiteral && LA24_0<=PROPERTY)||LA24_0==68||(LA24_0>=71 && LA24_0<=73)||LA24_0==76||(LA24_0>=78 && LA24_0<=82)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: function_call_params
            	    {
            	    pushFollow(FOLLOW_function_call_params_in_function_call1141);
            	    function_call_params110=function_call_params();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function_call_params.add(function_call_params110.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            char_literal111=(Token)match(input,83,FOLLOW_83_in_function_call1144); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(char_literal111);



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
            // 173:48: -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:173:51: ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:173:77: ^( ARGS ( function_call_params )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:173:84: ( function_call_params )*
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:176:1: function_name : ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) ;
    public final GremlinParser.function_name_return function_name() throws RecognitionException {
        GremlinParser.function_name_return retval = new GremlinParser.function_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ns=null;
        Token ln=null;
        Token char_literal112=null;

        CommonTree ns_tree=null;
        CommonTree ln_tree=null;
        CommonTree char_literal112_tree=null;
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:177:2: (ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:177:4: ns= IDENTIFIER ':' ln= IDENTIFIER
            {
            ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name1173); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(ns);

            char_literal112=(Token)match(input,96,FOLLOW_96_in_function_name1175); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_96.add(char_literal112);

            ln=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name1179); if (state.failed) return retval; 
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
            // 177:36: -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:177:39: ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_NAME, "FUNC_NAME"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:177:51: ^( NS $ns)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NS, "NS"), root_2);

                adaptor.addChild(root_2, stream_ns.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:177:61: ^( NAME $ln)
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:180:1: function_call_params : function_call_param ( ',' function_call_param )* -> ( ^( ARG function_call_param ) )+ ;
    public final GremlinParser.function_call_params_return function_call_params() throws RecognitionException {
        GremlinParser.function_call_params_return retval = new GremlinParser.function_call_params_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal114=null;
        GremlinParser.function_call_param_return function_call_param113 = null;

        GremlinParser.function_call_param_return function_call_param115 = null;


        CommonTree char_literal114_tree=null;
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_function_call_param=new RewriteRuleSubtreeStream(adaptor,"rule function_call_param");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:2: ( function_call_param ( ',' function_call_param )* -> ( ^( ARG function_call_param ) )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:4: function_call_param ( ',' function_call_param )*
            {
            pushFollow(FOLLOW_function_call_param_in_function_call_params1216);
            function_call_param113=function_call_param();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_call_param.add(function_call_param113.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:24: ( ',' function_call_param )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==84) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:25: ',' function_call_param
            	    {
            	    char_literal114=(Token)match(input,84,FOLLOW_84_in_function_call_params1219); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_84.add(char_literal114);

            	    pushFollow(FOLLOW_function_call_param_in_function_call_params1221);
            	    function_call_param115=function_call_param();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function_call_param.add(function_call_param115.getTree());

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
            // 182:51: -> ( ^( ARG function_call_param ) )+
            {
                if ( !(stream_function_call_param.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_function_call_param.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:182:54: ^( ARG function_call_param )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:185:1: function_call_param : ( collection | statement );
    public final GremlinParser.function_call_param_return function_call_param() throws RecognitionException {
        GremlinParser.function_call_param_return retval = new GremlinParser.function_call_param_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GremlinParser.collection_return collection116 = null;

        GremlinParser.statement_return statement117 = null;



        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:186:5: ( collection | statement )
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:186:7: collection
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_collection_in_function_call_param1246);
                    collection116=collection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collection116.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:187:7: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_function_call_param1254);
                    statement117=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement117.getTree());

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
    // $ANTLR end "function_call_param"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:190:1: atom : ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | range | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | function_call | IDENTIFIER | '(' statement ')' | '(' collection ')' );
    public final GremlinParser.atom_return atom() throws RecognitionException {
        GremlinParser.atom_return retval = new GremlinParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token b=null;
        Token G_INT118=null;
        Token G_LONG119=null;
        Token G_FLOAT120=null;
        Token G_DOUBLE121=null;
        Token StringLiteral123=null;
        Token NULL124=null;
        Token PROPERTY125=null;
        Token VARIABLE126=null;
        Token IDENTIFIER128=null;
        Token char_literal129=null;
        Token char_literal131=null;
        Token char_literal132=null;
        Token char_literal134=null;
        GremlinParser.range_return range122 = null;

        GremlinParser.function_call_return function_call127 = null;

        GremlinParser.statement_return statement130 = null;

        GremlinParser.collection_return collection133 = null;


        CommonTree b_tree=null;
        CommonTree G_INT118_tree=null;
        CommonTree G_LONG119_tree=null;
        CommonTree G_FLOAT120_tree=null;
        CommonTree G_DOUBLE121_tree=null;
        CommonTree StringLiteral123_tree=null;
        CommonTree NULL124_tree=null;
        CommonTree PROPERTY125_tree=null;
        CommonTree VARIABLE126_tree=null;
        CommonTree IDENTIFIER128_tree=null;
        CommonTree char_literal129_tree=null;
        CommonTree char_literal131_tree=null;
        CommonTree char_literal132_tree=null;
        CommonTree char_literal134_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_G_LONG=new RewriteRuleTokenStream(adaptor,"token G_LONG");
        RewriteRuleTokenStream stream_BOOLEAN=new RewriteRuleTokenStream(adaptor,"token BOOLEAN");
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_G_DOUBLE=new RewriteRuleTokenStream(adaptor,"token G_DOUBLE");
        RewriteRuleTokenStream stream_PROPERTY=new RewriteRuleTokenStream(adaptor,"token PROPERTY");
        RewriteRuleTokenStream stream_G_FLOAT=new RewriteRuleTokenStream(adaptor,"token G_FLOAT");
        RewriteRuleTokenStream stream_G_INT=new RewriteRuleTokenStream(adaptor,"token G_INT");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:191:2: ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | range | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | function_call | IDENTIFIER | '(' statement ')' | '(' collection ')' )
            int alt27=14;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:191:6: G_INT
                    {
                    G_INT118=(Token)match(input,G_INT,FOLLOW_G_INT_in_atom1271); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_INT.add(G_INT118);



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
                    // 191:22: -> ^( INT G_INT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:191:25: ^( INT G_INT )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:192:6: G_LONG
                    {
                    G_LONG119=(Token)match(input,G_LONG,FOLLOW_G_LONG_in_atom1296); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_LONG.add(G_LONG119);



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
                    // 192:22: -> ^( LONG G_LONG )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:192:25: ^( LONG G_LONG )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:193:6: G_FLOAT
                    {
                    G_FLOAT120=(Token)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_atom1320); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_FLOAT.add(G_FLOAT120);



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
                    // 193:22: -> ^( FLOAT G_FLOAT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:193:25: ^( FLOAT G_FLOAT )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:194:6: G_DOUBLE
                    {
                    G_DOUBLE121=(Token)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_atom1343); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_DOUBLE.add(G_DOUBLE121);



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
                    // 194:22: -> ^( DOUBLE G_DOUBLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:194:25: ^( DOUBLE G_DOUBLE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:6: range
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_range_in_atom1365);
                    range122=range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, range122.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:196:4: StringLiteral
                    {
                    StringLiteral123=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_atom1370); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral123);



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
                    // 196:18: -> ^( STR StringLiteral )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:196:21: ^( STR StringLiteral )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:197:9: b= BOOLEAN
                    {
                    b=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_atom1390); if (state.failed) return retval; 
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
                    // 197:25: -> ^( BOOL $b)
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:197:28: ^( BOOL $b)
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:198:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NULL124=(Token)match(input,NULL,FOLLOW_NULL_in_atom1415); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL124_tree = (CommonTree)adaptor.create(NULL124);
                    adaptor.addChild(root_0, NULL124_tree);
                    }

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:4: PROPERTY
                    {
                    PROPERTY125=(Token)match(input,PROPERTY,FOLLOW_PROPERTY_in_atom1420); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROPERTY.add(PROPERTY125);



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
                    // 199:17: -> ^( PROPERTY_CALL PROPERTY )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:199:20: ^( PROPERTY_CALL PROPERTY )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:200:4: VARIABLE
                    {
                    VARIABLE126=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_atom1437); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE126);



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
                    // 200:20: -> ^( VARIABLE_CALL VARIABLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:200:23: ^( VARIABLE_CALL VARIABLE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:201:4: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_call_in_atom1457);
                    function_call127=function_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_call127.getTree());

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:202:6: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IDENTIFIER128=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atom1464); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER128_tree = (CommonTree)adaptor.create(IDENTIFIER128);
                    adaptor.addChild(root_0, IDENTIFIER128_tree);
                    }

                    }
                    break;
                case 13 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:4: '(' statement ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal129=(Token)match(input,82,FOLLOW_82_in_atom1469); if (state.failed) return retval;
                    pushFollow(FOLLOW_statement_in_atom1472);
                    statement130=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement130.getTree());
                    char_literal131=(Token)match(input,83,FOLLOW_83_in_atom1474); if (state.failed) return retval;

                    }
                    break;
                case 14 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:204:6: '(' collection ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal132=(Token)match(input,82,FOLLOW_82_in_atom1482); if (state.failed) return retval;
                    pushFollow(FOLLOW_collection_in_atom1485);
                    collection133=collection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, collection133.getTree());
                    char_literal134=(Token)match(input,83,FOLLOW_83_in_atom1487); if (state.failed) return retval;

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:244:1: range : min= G_INT '..' max= G_INT -> ^( RANGE $min $max) ;
    public final GremlinParser.range_return range() throws RecognitionException {
        GremlinParser.range_return retval = new GremlinParser.range_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token min=null;
        Token max=null;
        Token string_literal135=null;

        CommonTree min_tree=null;
        CommonTree max_tree=null;
        CommonTree string_literal135_tree=null;
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_G_INT=new RewriteRuleTokenStream(adaptor,"token G_INT");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:245:5: (min= G_INT '..' max= G_INT -> ^( RANGE $min $max) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:245:9: min= G_INT '..' max= G_INT
            {
            min=(Token)match(input,G_INT,FOLLOW_G_INT_in_range1670); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_G_INT.add(min);

            string_literal135=(Token)match(input,68,FOLLOW_68_in_range1672); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_68.add(string_literal135);

            max=(Token)match(input,G_INT,FOLLOW_G_INT_in_range1676); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_G_INT.add(max);



            // AST REWRITE
            // elements: min, max
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
            // 245:35: -> ^( RANGE $min $max)
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:245:38: ^( RANGE $min $max)
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:252:1: collection : token ( '[' statement ']' )+ -> ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) ) ;
    public final GremlinParser.collection_return collection() throws RecognitionException {
        GremlinParser.collection_return retval = new GremlinParser.collection_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal137=null;
        Token char_literal139=null;
        GremlinParser.token_return token136 = null;

        GremlinParser.statement_return statement138 = null;


        CommonTree char_literal137_tree=null;
        CommonTree char_literal139_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_token=new RewriteRuleSubtreeStream(adaptor,"rule token");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:253:5: ( token ( '[' statement ']' )+ -> ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:253:7: token ( '[' statement ']' )+
            {
            pushFollow(FOLLOW_token_in_collection1727);
            token136=token();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_token.add(token136.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:253:13: ( '[' statement ']' )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==66) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:253:14: '[' statement ']'
            	    {
            	    char_literal137=(Token)match(input,66,FOLLOW_66_in_collection1730); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_66.add(char_literal137);

            	    pushFollow(FOLLOW_statement_in_collection1732);
            	    statement138=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement138.getTree());
            	    char_literal139=(Token)match(input,67,FOLLOW_67_in_collection1734); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_67.add(char_literal139);


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
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
            // 253:34: -> ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:253:37: ^( COLLECTION_CALL ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COLLECTION_CALL, "COLLECTION_CALL"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:253:55: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )+ ) )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STEP, "STEP"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:253:62: ^( TOKEN token )
                {
                CommonTree root_3 = (CommonTree)adaptor.nil();
                root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TOKEN, "TOKEN"), root_3);

                adaptor.addChild(root_3, stream_token.nextTree());

                adaptor.addChild(root_2, root_3);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:253:77: ^( PREDICATES ( ^( PREDICATE statement ) )+ )
                {
                CommonTree root_3 = (CommonTree)adaptor.nil();
                root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREDICATES, "PREDICATES"), root_3);

                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:253:90: ^( PREDICATE statement )
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

    // $ANTLR start synpred3_Gremlin
    public final void synpred3_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:64:9: ( VARIABLE ':=' collection NEWLINE )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:64:9: VARIABLE ':=' collection NEWLINE
        {
        match(input,VARIABLE,FOLLOW_VARIABLE_in_synpred3_Gremlin263); if (state.failed) return ;
        match(input,64,FOLLOW_64_in_synpred3_Gremlin265); if (state.failed) return ;
        pushFollow(FOLLOW_collection_in_synpred3_Gremlin267);
        collection();

        state._fsp--;
        if (state.failed) return ;
        match(input,NEWLINE,FOLLOW_NEWLINE_in_synpred3_Gremlin269); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Gremlin

    // $ANTLR start synpred6_Gremlin
    public final void synpred6_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:65:9: ( ( ( statement )? NEWLINE )+ )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:65:9: ( ( statement )? NEWLINE )+
        {
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:65:9: ( ( statement )? NEWLINE )+
        int cnt32=0;
        loop32:
        do {
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==NULL||(LA32_0>=VARIABLE && LA32_0<=PROPERTY)||LA32_0==68||(LA32_0>=71 && LA32_0<=73)||LA32_0==76||(LA32_0>=78 && LA32_0<=82)) ) {
                alt32=1;
            }


            switch (alt32) {
        	case 1 :
        	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:65:10: ( statement )? NEWLINE
        	    {
        	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:65:10: ( statement )?
        	    int alt31=2;
        	    int LA31_0 = input.LA(1);

        	    if ( (LA31_0==NULL||LA31_0==VARIABLE||(LA31_0>=StringLiteral && LA31_0<=PROPERTY)||LA31_0==68||(LA31_0>=71 && LA31_0<=73)||LA31_0==76||(LA31_0>=78 && LA31_0<=82)) ) {
        	        alt31=1;
        	    }
        	    switch (alt31) {
        	        case 1 :
        	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: statement
        	            {
        	            pushFollow(FOLLOW_statement_in_synpred6_Gremlin290);
        	            statement();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }
        	            break;

        	    }

        	    match(input,NEWLINE,FOLLOW_NEWLINE_in_synpred6_Gremlin293); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt32 >= 1 ) break loop32;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(32, input);
                    throw eee;
            }
            cnt32++;
        } while (true);


        }
    }
    // $ANTLR end synpred6_Gremlin

    // $ANTLR start synpred20_Gremlin
    public final void synpred20_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:94:4: ( gpath_statement )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:94:4: gpath_statement
        {
        pushFollow(FOLLOW_gpath_statement_in_synpred20_Gremlin493);
        gpath_statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_Gremlin

    // $ANTLR start synpred21_Gremlin
    public final void synpred21_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:95:9: ( VARIABLE ':=' statement )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:95:9: VARIABLE ':=' statement
        {
        match(input,VARIABLE,FOLLOW_VARIABLE_in_synpred21_Gremlin503); if (state.failed) return ;
        match(input,64,FOLLOW_64_in_synpred21_Gremlin505); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred21_Gremlin507);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_Gremlin

    // $ANTLR start synpred29_Gremlin
    public final void synpred29_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:154:7: ( collection NEWLINE )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:154:7: collection NEWLINE
        {
        pushFollow(FOLLOW_collection_in_synpred29_Gremlin980);
        collection();

        state._fsp--;
        if (state.failed) return ;
        match(input,NEWLINE,FOLLOW_NEWLINE_in_synpred29_Gremlin982); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_Gremlin

    // $ANTLR start synpred30_Gremlin
    public final void synpred30_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:155:7: ( statement )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:155:7: statement
        {
        pushFollow(FOLLOW_statement_in_synpred30_Gremlin990);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_Gremlin

    // $ANTLR start synpred31_Gremlin
    public final void synpred31_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:7: ( VARIABLE ':=' collection NEWLINE )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:156:7: VARIABLE ':=' collection NEWLINE
        {
        match(input,VARIABLE,FOLLOW_VARIABLE_in_synpred31_Gremlin998); if (state.failed) return ;
        match(input,64,FOLLOW_64_in_synpred31_Gremlin1000); if (state.failed) return ;
        pushFollow(FOLLOW_collection_in_synpred31_Gremlin1002);
        collection();

        state._fsp--;
        if (state.failed) return ;
        match(input,NEWLINE,FOLLOW_NEWLINE_in_synpred31_Gremlin1004); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_Gremlin

    // $ANTLR start synpred45_Gremlin
    public final void synpred45_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:186:7: ( collection )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:186:7: collection
        {
        pushFollow(FOLLOW_collection_in_synpred45_Gremlin1246);
        collection();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_Gremlin

    // $ANTLR start synpred46_Gremlin
    public final void synpred46_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:191:6: ( G_INT )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:191:6: G_INT
        {
        match(input,G_INT,FOLLOW_G_INT_in_synpred46_Gremlin1271); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_Gremlin

    // $ANTLR start synpred50_Gremlin
    public final void synpred50_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:6: ( range )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:195:6: range
        {
        pushFollow(FOLLOW_range_in_synpred50_Gremlin1365);
        range();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_Gremlin

    // $ANTLR start synpred56_Gremlin
    public final void synpred56_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:201:4: ( function_call )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:201:4: function_call
        {
        pushFollow(FOLLOW_function_call_in_synpred56_Gremlin1457);
        function_call();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_Gremlin

    // $ANTLR start synpred57_Gremlin
    public final void synpred57_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:202:6: ( IDENTIFIER )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:202:6: IDENTIFIER
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred57_Gremlin1464); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_Gremlin

    // $ANTLR start synpred58_Gremlin
    public final void synpred58_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:4: ( '(' statement ')' )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:203:4: '(' statement ')'
        {
        match(input,82,FOLLOW_82_in_synpred58_Gremlin1469); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred58_Gremlin1472);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,83,FOLLOW_83_in_synpred58_Gremlin1474); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_Gremlin

    // Delegated rules

    public final boolean synpred56_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred57_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_Gremlin_fragment(); // can never throw exception
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
    public final boolean synpred3_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_Gremlin_fragment(); // can never throw exception
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
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA6_eotS =
        "\31\uffff";
    static final String DFA6_eofS =
        "\31\uffff";
    static final String DFA6_minS =
        "\1\44\1\uffff\1\0\10\uffff\14\0\2\uffff";
    static final String DFA6_maxS =
        "\1\122\1\uffff\1\0\10\uffff\14\0\2\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\23\uffff\1\2\1\4";
    static final String DFA6_specialS =
        "\2\uffff\1\0\10\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\1\14\2\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\21\4\uffff\1\1\1\2\1\26\1\17\1\23\1\13\1\14\1\15\1\16\1\20"+
            "\1\22\20\uffff\1\25\2\uffff\3\3\2\uffff\1\3\1\uffff\4\3\1\24",
            "",
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
            return "62:1: program : ( ( COMMENT )+ | VARIABLE ':=' collection NEWLINE -> ^( VAR VARIABLE collection ) | ( ( statement )? NEWLINE )+ | ( ( collection )? NEWLINE )+ );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_2 = input.LA(1);

                         
                        int index6_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Gremlin()) ) {s = 23;}

                        else if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_11 = input.LA(1);

                         
                        int index6_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_11);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_12 = input.LA(1);

                         
                        int index6_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_12);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_13 = input.LA(1);

                         
                        int index6_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_13);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_14 = input.LA(1);

                         
                        int index6_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_14);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_15 = input.LA(1);

                         
                        int index6_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_15);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_16 = input.LA(1);

                         
                        int index6_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_16);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_17 = input.LA(1);

                         
                        int index6_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_17);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_18 = input.LA(1);

                         
                        int index6_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_18);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_19 = input.LA(1);

                         
                        int index6_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_19);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_20 = input.LA(1);

                         
                        int index6_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_20);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_21 = input.LA(1);

                         
                        int index6_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_21);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA6_22 = input.LA(1);

                         
                        int index6_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_Gremlin()) ) {s = 3;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index6_22);
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
        "\27\uffff";
    static final String DFA12_eofS =
        "\27\uffff";
    static final String DFA12_minS =
        "\1\44\10\uffff\13\0\3\uffff";
    static final String DFA12_maxS =
        "\1\122\10\uffff\13\0\3\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\13\uffff\1\11\1\13\1\12";
    static final String DFA12_specialS =
        "\11\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\3\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\17\5\uffff\1\21\1\uffff\1\15\1\22\1\11\1\12\1\13\1\14\1\16"+
            "\1\20\20\uffff\1\24\2\uffff\1\7\1\10\1\1\2\uffff\1\2\1\uffff"+
            "\1\3\1\4\1\5\1\6\1\23",
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
            return "85:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | script_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* );";
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
                        if ( (synpred20_Gremlin()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index12_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_10 = input.LA(1);

                         
                        int index12_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_Gremlin()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index12_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_11 = input.LA(1);

                         
                        int index12_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_Gremlin()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index12_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_12 = input.LA(1);

                         
                        int index12_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_Gremlin()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index12_12);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA12_13 = input.LA(1);

                         
                        int index12_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_Gremlin()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index12_13);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA12_14 = input.LA(1);

                         
                        int index12_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_Gremlin()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index12_14);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA12_15 = input.LA(1);

                         
                        int index12_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_Gremlin()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index12_15);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA12_16 = input.LA(1);

                         
                        int index12_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_Gremlin()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index12_16);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA12_17 = input.LA(1);

                         
                        int index12_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_Gremlin()) ) {s = 20;}

                        else if ( (synpred21_Gremlin()) ) {s = 22;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index12_17);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA12_18 = input.LA(1);

                         
                        int index12_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_Gremlin()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index12_18);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA12_19 = input.LA(1);

                         
                        int index12_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_Gremlin()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index12_19);
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
    static final String DFA17_eotS =
        "\30\uffff";
    static final String DFA17_eofS =
        "\30\uffff";
    static final String DFA17_minS =
        "\1\44\14\0\13\uffff";
    static final String DFA17_maxS =
        "\1\122\14\0\13\uffff";
    static final String DFA17_acceptS =
        "\15\uffff\1\2\7\uffff\1\4\1\1\1\3";
    static final String DFA17_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\13"+
        "\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\7\4\uffff\1\25\1\11\1\uffff\1\5\1\12\1\1\1\2\1\3\1\4\1\6"+
            "\1\10\20\uffff\1\14\2\uffff\3\15\2\uffff\1\15\1\uffff\4\15\1"+
            "\13",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
        for (int i=0; i<numStates; i++) {
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
            return "153:1: block_body : ( collection NEWLINE | statement | VARIABLE ':=' collection NEWLINE -> ^( VAR VARIABLE collection ) | COMMENT NEWLINE );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_1 = input.LA(1);

                         
                        int index17_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                         
                        input.seek(index17_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_2 = input.LA(1);

                         
                        int index17_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                         
                        input.seek(index17_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_3 = input.LA(1);

                         
                        int index17_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                         
                        input.seek(index17_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_4 = input.LA(1);

                         
                        int index17_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                         
                        input.seek(index17_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_5 = input.LA(1);

                         
                        int index17_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                         
                        input.seek(index17_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_6 = input.LA(1);

                         
                        int index17_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                         
                        input.seek(index17_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_7 = input.LA(1);

                         
                        int index17_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                         
                        input.seek(index17_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_8 = input.LA(1);

                         
                        int index17_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                         
                        input.seek(index17_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_9 = input.LA(1);

                         
                        int index17_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                        else if ( (synpred31_Gremlin()) ) {s = 23;}

                         
                        input.seek(index17_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_10 = input.LA(1);

                         
                        int index17_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                         
                        input.seek(index17_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_11 = input.LA(1);

                         
                        int index17_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                         
                        input.seek(index17_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_12 = input.LA(1);

                         
                        int index17_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Gremlin()) ) {s = 22;}

                        else if ( (synpred30_Gremlin()) ) {s = 13;}

                         
                        input.seek(index17_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA26_eotS =
        "\26\uffff";
    static final String DFA26_eofS =
        "\26\uffff";
    static final String DFA26_minS =
        "\1\44\14\0\11\uffff";
    static final String DFA26_maxS =
        "\1\122\14\0\11\uffff";
    static final String DFA26_acceptS =
        "\15\uffff\1\2\7\uffff\1\1";
    static final String DFA26_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\11"+
        "\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\7\5\uffff\1\11\1\uffff\1\5\1\12\1\1\1\2\1\3\1\4\1\6\1\10"+
            "\20\uffff\1\14\2\uffff\3\15\2\uffff\1\15\1\uffff\4\15\1\13",
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
            "",
            "",
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
            return "185:1: function_call_param : ( collection | statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_1 = input.LA(1);

                         
                        int index26_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_2 = input.LA(1);

                         
                        int index26_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA26_3 = input.LA(1);

                         
                        int index26_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA26_4 = input.LA(1);

                         
                        int index26_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA26_5 = input.LA(1);

                         
                        int index26_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA26_6 = input.LA(1);

                         
                        int index26_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA26_7 = input.LA(1);

                         
                        int index26_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA26_8 = input.LA(1);

                         
                        int index26_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA26_9 = input.LA(1);

                         
                        int index26_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA26_10 = input.LA(1);

                         
                        int index26_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA26_11 = input.LA(1);

                         
                        int index26_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA26_12 = input.LA(1);

                         
                        int index26_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index26_12);
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
    static final String DFA27_eotS =
        "\22\uffff";
    static final String DFA27_eofS =
        "\22\uffff";
    static final String DFA27_minS =
        "\1\44\1\0\10\uffff\2\0\6\uffff";
    static final String DFA27_maxS =
        "\1\122\1\0\10\uffff\2\0\6\uffff";
    static final String DFA27_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\6\1\7\1\10\1\11\1\12\2\uffff\1\1\1\5\1\13"+
        "\1\14\1\15\1\16";
    static final String DFA27_specialS =
        "\1\uffff\1\0\10\uffff\1\1\1\2\6\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\7\5\uffff\1\11\1\uffff\1\5\1\12\1\1\1\2\1\3\1\4\1\6\1\10"+
            "\36\uffff\1\13",
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

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "190:1: atom : ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | range | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | function_call | IDENTIFIER | '(' statement ')' | '(' collection ')' );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_Gremlin()) ) {s = 12;}

                        else if ( (synpred50_Gremlin()) ) {s = 13;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_10 = input.LA(1);

                         
                        int index27_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_Gremlin()) ) {s = 14;}

                        else if ( (synpred57_Gremlin()) ) {s = 15;}

                         
                        input.seek(index27_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_11 = input.LA(1);

                         
                        int index27_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred58_Gremlin()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index27_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_COMMENT_in_program252 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_program263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_program265 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040010L});
    public static final BitSet FOLLOW_collection_in_program267 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_program269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_program290 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_program293 = new BitSet(new long[]{0x000FFC1000000002L,0x000000000007D390L});
    public static final BitSet FOLLOW_collection_in_program306 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_program309 = new BitSet(new long[]{0x000FFC1000000002L,0x0000000000040010L});
    public static final BitSet FOLLOW_step_in_gpath_statement346 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_gpath_statement348 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040010L});
    public static final BitSet FOLLOW_step_in_gpath_statement350 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_gpath_statement353 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040010L});
    public static final BitSet FOLLOW_step_in_gpath_statement355 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_token_in_step381 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_step384 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_statement_in_step386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_step388 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_token430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_token434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_definition_statement_in_statement471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_script_statement_in_statement488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_statement493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_statement503 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_statement505 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_statement_in_statement507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement524 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_69_in_statement528 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_70_in_statement531 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_expression_in_statement535 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_71_in_include_statement548 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_script_statement574 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_script_statement576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_if_statement600 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_statement_in_if_statement602 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_if_statement604 = new BitSet(new long[]{0x000FFE1000000000L,0x000000000007DF90L});
    public static final BitSet FOLLOW_block_in_if_statement620 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_74_in_if_statement631 = new BitSet(new long[]{0x000FFE1000000000L,0x000000000007DB90L});
    public static final BitSet FOLLOW_block_in_if_statement646 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_if_statement658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_foreach_statement692 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement694 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_foreach_statement696 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_statement_in_foreach_statement698 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_foreach_statement700 = new BitSet(new long[]{0x000FFE1000000000L,0x000000000007DB90L});
    public static final BitSet FOLLOW_block_in_foreach_statement711 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_foreach_statement719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_while_statement743 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_statement_in_while_statement745 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_while_statement747 = new BitSet(new long[]{0x000FFE1000000000L,0x000000000007DB90L});
    public static final BitSet FOLLOW_block_in_while_statement758 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_while_statement766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_repeat_statement791 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_statement_in_repeat_statement793 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeat_statement795 = new BitSet(new long[]{0x000FFE1000000000L,0x000000000007DB90L});
    public static final BitSet FOLLOW_block_in_repeat_statement802 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_repeat_statement806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_path_definition_statement828 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_path_definition_statement830 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_path_definition_statement832 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_statement_in_path_definition_statement839 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_path_definition_statement841 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_path_definition_statement845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_function_definition_statement867 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_function_name_in_function_definition_statement869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_function_definition_statement871 = new BitSet(new long[]{0x0000040000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_formal_arguments_in_function_definition_statement873 = new BitSet(new long[]{0x0000040000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_function_definition_statement876 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_function_definition_statement878 = new BitSet(new long[]{0x000FFE1000000000L,0x000000000007DB90L});
    public static final BitSet FOLLOW_block_in_function_definition_statement885 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_function_definition_statement889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments919 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_formal_arguments922 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments924 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_block_body_in_block951 = new BitSet(new long[]{0x000FFE1000000002L,0x000000000007D390L});
    public static final BitSet FOLLOW_NEWLINE_in_block955 = new BitSet(new long[]{0x000FFE1000000002L,0x000000000007D390L});
    public static final BitSet FOLLOW_collection_in_block_body980 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_block_body982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block_body990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_block_body998 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_block_body1000 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040010L});
    public static final BitSet FOLLOW_collection_in_block_body1002 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_block_body1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_block_body1022 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_block_body1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operation_in_expression1038 = new BitSet(new long[]{0x0000000000000002L,0x0000000007E00000L});
    public static final BitSet FOLLOW_85_in_expression1042 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_86_in_expression1047 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_87_in_expression1052 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_88_in_expression1057 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_89_in_expression1062 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_90_in_expression1067 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_operation_in_expression1071 = new BitSet(new long[]{0x0000000000000002L,0x0000000007E00000L});
    public static final BitSet FOLLOW_binary_operation_in_operation1084 = new BitSet(new long[]{0x0000000000000002L,0x0000000018000000L});
    public static final BitSet FOLLOW_91_in_operation1088 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_92_in_operation1091 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_binary_operation_in_operation1095 = new BitSet(new long[]{0x0000000000000002L,0x0000000018000000L});
    public static final BitSet FOLLOW_atom_in_binary_operation1109 = new BitSet(new long[]{0x0000000000000002L,0x00000000E0000000L});
    public static final BitSet FOLLOW_93_in_binary_operation1113 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_94_in_binary_operation1116 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_95_in_binary_operation1119 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_atom_in_binary_operation1123 = new BitSet(new long[]{0x0000000000000002L,0x00000000E0000000L});
    public static final BitSet FOLLOW_function_name_in_function_call1137 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_function_call1139 = new BitSet(new long[]{0x000FF41000000000L,0x00000000000FD390L});
    public static final BitSet FOLLOW_function_call_params_in_function_call1141 = new BitSet(new long[]{0x000FF41000000000L,0x00000000000FD390L});
    public static final BitSet FOLLOW_83_in_function_call1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name1173 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_function_name1175 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_param_in_function_call_params1216 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_function_call_params1219 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_function_call_param_in_function_call_params1221 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_collection_in_function_call_param1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_function_call_param1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_INT_in_atom1271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_LONG_in_atom1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_FLOAT_in_atom1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_DOUBLE_in_atom1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_atom1365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_atom1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_atom1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_atom1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROPERTY_in_atom1420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_atom1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_atom1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_atom1469 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_statement_in_atom1472 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_atom1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_atom1482 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040010L});
    public static final BitSet FOLLOW_collection_in_atom1485 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_atom1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_INT_in_range1670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_range1672 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_G_INT_in_range1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_token_in_collection1727 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_collection1730 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_statement_in_collection1732 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_collection1734 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_synpred3_Gremlin263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_synpred3_Gremlin265 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040010L});
    public static final BitSet FOLLOW_collection_in_synpred3_Gremlin267 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_synpred3_Gremlin269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred6_Gremlin290 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_synpred6_Gremlin293 = new BitSet(new long[]{0x000FFC1000000002L,0x000000000007D390L});
    public static final BitSet FOLLOW_gpath_statement_in_synpred20_Gremlin493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_synpred21_Gremlin503 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_synpred21_Gremlin505 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_statement_in_synpred21_Gremlin507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_in_synpred29_Gremlin980 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_synpred29_Gremlin982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred30_Gremlin990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_synpred31_Gremlin998 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_synpred31_Gremlin1000 = new BitSet(new long[]{0x000FF41000000000L,0x0000000000040010L});
    public static final BitSet FOLLOW_collection_in_synpred31_Gremlin1002 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_synpred31_Gremlin1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_in_synpred45_Gremlin1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_INT_in_synpred46_Gremlin1271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_synpred50_Gremlin1365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_synpred56_Gremlin1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred57_Gremlin1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_synpred58_Gremlin1469 = new BitSet(new long[]{0x000FF41000000000L,0x000000000007D390L});
    public static final BitSet FOLLOW_statement_in_synpred58_Gremlin1472 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_synpred58_Gremlin1474 = new BitSet(new long[]{0x0000000000000002L});

}
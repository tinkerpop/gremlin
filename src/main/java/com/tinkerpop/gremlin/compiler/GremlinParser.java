// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g 2010-07-08 00:08:03
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "PATH", "GPATH", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "SELF", "HISTORY", "FUNC_CALL", "IF", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "INT", "LONG", "FLOAT", "DOUBLE", "STR", "ARR", "BOOL", "NULL", "RANGE", "PROPERTY_CALL", "VARIABLE_CALL", "COMMENT", "NEWLINE", "VARIABLE", "StringLiteral", "IDENTIFIER", "G_INT", "G_LONG", "G_FLOAT", "G_DOUBLE", "BOOLEAN", "PROPERTY", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "'/'", "'['", "']'", "'..'", "':='", "'and'", "'or'", "'include'", "'if'", "'end'", "'foreach'", "'in'", "'while'", "'repeat'", "'path'", "'func'", "'('", "')'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "':'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int HexEscapeSequence=54;
    public static final int WHILE=24;
    public static final int T__63=63;
    public static final int STEP=13;
    public static final int FLOAT=29;
    public static final int DecimalDigit=59;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int HexDigit=60;
    public static final int PREDICATE=15;
    public static final int IF=20;
    public static final int FUNC_CALL=19;
    public static final int SingleStringCharacter=50;
    public static final int TOKEN=14;
    public static final int HISTORY=18;
    public static final int STR=31;
    public static final int NAME=9;
    public static final int BOOLEAN=47;
    public static final int T__90=90;
    public static final int ARG=5;
    public static final int PATH=11;
    public static final int G_INT=43;
    public static final int IDENTIFIER=42;
    public static final int SingleEscapeCharacter=56;
    public static final int INCLUDE=26;
    public static final int DOUBLE=30;
    public static final int ARGS=6;
    public static final int EscapeCharacter=58;
    public static final int VAR=4;
    public static final int GPATH=12;
    public static final int COMMENT=38;
    public static final int G_FLOAT=45;
    public static final int PROPERTY_CALL=36;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int NS=8;
    public static final int UnicodeEscapeSequence=55;
    public static final int NULL=34;
    public static final int BOOL=33;
    public static final int RANGE=35;
    public static final int INT=27;
    public static final int DoubleStringCharacter=49;
    public static final int ARR=32;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int StringLiteral=41;
    public static final int WS=51;
    public static final int T__71=71;
    public static final int PREDICATES=16;
    public static final int T__72=72;
    public static final int VARIABLE=40;
    public static final int NEWLINE=39;
    public static final int G_DOUBLE=46;
    public static final int T__70=70;
    public static final int PROPERTY=48;
    public static final int FUNC=7;
    public static final int BLOCK=22;
    public static final int NonEscapeCharacter=57;
    public static final int G_LONG=44;
    public static final int REPEAT=25;
    public static final int FOREACH=23;
    public static final int CharacterEscapeSequence=53;
    public static final int FUNC_NAME=10;
    public static final int T__76=76;
    public static final int LONG=28;
    public static final int COND=21;
    public static final int T__75=75;
    public static final int SELF=17;
    public static final int T__74=74;
    public static final int EscapeSequence=52;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int VARIABLE_CALL=37;
    public static final int T__78=78;
    public static final int T__77=77;

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:59:1: program : ( ( COMMENT )+ | ( ( statement )? NEWLINE )+ );
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
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:60:5: ( ( COMMENT )+ | ( ( statement )? NEWLINE )+ )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==COMMENT) ) {
                alt4=1;
            }
            else if ( (LA4_0==NULL||(LA4_0>=NEWLINE && LA4_0<=PROPERTY)||LA4_0==64||(LA4_0>=68 && LA4_0<=69)||LA4_0==71||(LA4_0>=73 && LA4_0<=77)) ) {
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:60:7: ( COMMENT )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:60:7: ( COMMENT )+
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
                    	    COMMENT1=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_program240); if (state.failed) return retval;
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:61:9: ( ( statement )? NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:61:9: ( ( statement )? NEWLINE )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NULL||(LA3_0>=NEWLINE && LA3_0<=PROPERTY)||LA3_0==64||(LA3_0>=68 && LA3_0<=69)||LA3_0==71||(LA3_0>=73 && LA3_0<=77)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:61:10: ( statement )? NEWLINE
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:61:10: ( statement )?
                    	    int alt2=2;
                    	    int LA2_0 = input.LA(1);

                    	    if ( (LA2_0==NULL||(LA2_0>=VARIABLE && LA2_0<=PROPERTY)||LA2_0==64||(LA2_0>=68 && LA2_0<=69)||LA2_0==71||(LA2_0>=73 && LA2_0<=77)) ) {
                    	        alt2=1;
                    	    }
                    	    switch (alt2) {
                    	        case 1 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: statement
                    	            {
                    	            pushFollow(FOLLOW_statement_in_program252);
                    	            statement2=statement();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement2.getTree());

                    	            }
                    	            break;

                    	    }

                    	    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program255); if (state.failed) return retval;
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:68:1: gpath_statement : step '/' step ( '/' step )* -> ^( GPATH ( step )+ ) ;
    public final GremlinParser.gpath_statement_return gpath_statement() throws RecognitionException {
        GremlinParser.gpath_statement_return retval = new GremlinParser.gpath_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal5=null;
        Token char_literal7=null;
        GremlinParser.step_return step4 = null;

        GremlinParser.step_return step6 = null;

        GremlinParser.step_return step8 = null;


        CommonTree char_literal5_tree=null;
        CommonTree char_literal7_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleSubtreeStream stream_step=new RewriteRuleSubtreeStream(adaptor,"rule step");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:69:2: ( step '/' step ( '/' step )* -> ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:69:4: step '/' step ( '/' step )*
            {
            pushFollow(FOLLOW_step_in_gpath_statement292);
            step4=step();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_step.add(step4.getTree());
            char_literal5=(Token)match(input,61,FOLLOW_61_in_gpath_statement294); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal5);

            pushFollow(FOLLOW_step_in_gpath_statement296);
            step6=step();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_step.add(step6.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:69:18: ( '/' step )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==61) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:69:19: '/' step
            	    {
            	    char_literal7=(Token)match(input,61,FOLLOW_61_in_gpath_statement299); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_61.add(char_literal7);

            	    pushFollow(FOLLOW_step_in_gpath_statement301);
            	    step8=step();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_step.add(step8.getTree());

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
            // 69:30: -> ^( GPATH ( step )+ )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:69:33: ^( GPATH ( step )+ )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:72:1: step : token ( '[' statement ']' )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) ;
    public final GremlinParser.step_return step() throws RecognitionException {
        GremlinParser.step_return retval = new GremlinParser.step_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal10=null;
        Token char_literal12=null;
        GremlinParser.token_return token9 = null;

        GremlinParser.statement_return statement11 = null;


        CommonTree char_literal10_tree=null;
        CommonTree char_literal12_tree=null;
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_token=new RewriteRuleSubtreeStream(adaptor,"rule token");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:73:5: ( token ( '[' statement ']' )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:73:7: token ( '[' statement ']' )*
            {
            pushFollow(FOLLOW_token_in_step327);
            token9=token();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_token.add(token9.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:73:13: ( '[' statement ']' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==62) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:73:14: '[' statement ']'
            	    {
            	    char_literal10=(Token)match(input,62,FOLLOW_62_in_step330); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_62.add(char_literal10);

            	    pushFollow(FOLLOW_statement_in_step332);
            	    statement11=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement11.getTree());
            	    char_literal12=(Token)match(input,63,FOLLOW_63_in_step334); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_63.add(char_literal12);


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
            // 73:34: -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:73:37: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STEP, "STEP"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:73:44: ^( TOKEN token )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TOKEN, "TOKEN"), root_2);

                adaptor.addChild(root_2, stream_token.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:73:59: ^( PREDICATES ( ^( PREDICATE statement ) )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREDICATES, "PREDICATES"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:73:72: ( ^( PREDICATE statement ) )*
                while ( stream_statement.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:73:72: ^( PREDICATE statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:76:1: token : ( expression | '..' ) ;
    public final GremlinParser.token_return token() throws RecognitionException {
        GremlinParser.token_return retval = new GremlinParser.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal14=null;
        GremlinParser.expression_return expression13 = null;


        CommonTree string_literal14_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:77:2: ( ( expression | '..' ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:77:5: ( expression | '..' )
            {
            root_0 = (CommonTree)adaptor.nil();

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:77:5: ( expression | '..' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==NULL||(LA7_0>=VARIABLE && LA7_0<=PROPERTY)||LA7_0==77) ) {
                alt7=1;
            }
            else if ( (LA7_0==64) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:77:6: expression
                    {
                    pushFollow(FOLLOW_expression_in_token376);
                    expression13=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression13.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:77:19: '..'
                    {
                    string_literal14=(Token)match(input,64,FOLLOW_64_in_token380); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal14_tree = (CommonTree)adaptor.create(string_literal14);
                    adaptor.addChild(root_0, string_literal14_tree);
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:80:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* );
    public final GremlinParser.statement_return statement() throws RecognitionException {
        GremlinParser.statement_return retval = new GremlinParser.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLE23=null;
        Token string_literal24=null;
        Token string_literal27=null;
        Token string_literal28=null;
        GremlinParser.if_statement_return if_statement15 = null;

        GremlinParser.foreach_statement_return foreach_statement16 = null;

        GremlinParser.while_statement_return while_statement17 = null;

        GremlinParser.repeat_statement_return repeat_statement18 = null;

        GremlinParser.path_definition_statement_return path_definition_statement19 = null;

        GremlinParser.function_definition_statement_return function_definition_statement20 = null;

        GremlinParser.include_statement_return include_statement21 = null;

        GremlinParser.gpath_statement_return gpath_statement22 = null;

        GremlinParser.statement_return statement25 = null;

        GremlinParser.expression_return expression26 = null;

        GremlinParser.expression_return expression29 = null;


        CommonTree VARIABLE23_tree=null;
        CommonTree string_literal24_tree=null;
        CommonTree string_literal27_tree=null;
        CommonTree string_literal28_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:81:5: ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* )
            int alt10=10;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:81:9: if_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_if_statement_in_statement397);
                    if_statement15=if_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, if_statement15.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:82:4: foreach_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_foreach_statement_in_statement402);
                    foreach_statement16=foreach_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, foreach_statement16.getTree());

                    }
                    break;
                case 3 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:83:4: while_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_while_statement_in_statement407);
                    while_statement17=while_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, while_statement17.getTree());

                    }
                    break;
                case 4 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:84:4: repeat_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_repeat_statement_in_statement412);
                    repeat_statement18=repeat_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, repeat_statement18.getTree());

                    }
                    break;
                case 5 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:85:4: path_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_path_definition_statement_in_statement417);
                    path_definition_statement19=path_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, path_definition_statement19.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:86:4: function_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_definition_statement_in_statement422);
                    function_definition_statement20=function_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_definition_statement20.getTree());

                    }
                    break;
                case 7 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:87:4: include_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_include_statement_in_statement427);
                    include_statement21=include_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, include_statement21.getTree());

                    }
                    break;
                case 8 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:88:4: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_gpath_statement_in_statement432);
                    gpath_statement22=gpath_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gpath_statement22.getTree());

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:89:4: VARIABLE ':=' statement
                    {
                    VARIABLE23=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_statement437); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE23);

                    string_literal24=(Token)match(input,65,FOLLOW_65_in_statement439); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_65.add(string_literal24);

                    pushFollow(FOLLOW_statement_in_statement441);
                    statement25=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement25.getTree());


                    // AST REWRITE
                    // elements: statement, VARIABLE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 89:28: -> ^( VAR VARIABLE statement )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:89:31: ^( VAR VARIABLE statement )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:4: expression ( ( 'and' | 'or' ) expression )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement456);
                    expression26=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression26.getTree());
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:15: ( ( 'and' | 'or' ) expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=66 && LA9_0<=67)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:16: ( 'and' | 'or' ) expression
                    	    {
                    	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:16: ( 'and' | 'or' )
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0==66) ) {
                    	        alt8=1;
                    	    }
                    	    else if ( (LA8_0==67) ) {
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
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:17: 'and'
                    	            {
                    	            string_literal27=(Token)match(input,66,FOLLOW_66_in_statement460); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal27_tree = (CommonTree)adaptor.create(string_literal27);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal27_tree, root_0);
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:90:24: 'or'
                    	            {
                    	            string_literal28=(Token)match(input,67,FOLLOW_67_in_statement463); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal28_tree = (CommonTree)adaptor.create(string_literal28);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal28_tree, root_0);
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    pushFollow(FOLLOW_expression_in_statement467);
                    	    expression29=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression29.getTree());

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:93:1: include_statement : 'include' StringLiteral -> ^( INCLUDE StringLiteral ) ;
    public final GremlinParser.include_statement_return include_statement() throws RecognitionException {
        GremlinParser.include_statement_return retval = new GremlinParser.include_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal30=null;
        Token StringLiteral31=null;

        CommonTree string_literal30_tree=null;
        CommonTree StringLiteral31_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:94:2: ( 'include' StringLiteral -> ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:94:4: 'include' StringLiteral
            {
            string_literal30=(Token)match(input,68,FOLLOW_68_in_include_statement480); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_68.add(string_literal30);

            StringLiteral31=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement482); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral31);



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
            // 94:28: -> ^( INCLUDE StringLiteral )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:94:31: ^( INCLUDE StringLiteral )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:97:1: if_statement : 'if' statement NEWLINE block 'end' -> ^( IF ^( COND statement ) block ) ;
    public final GremlinParser.if_statement_return if_statement() throws RecognitionException {
        GremlinParser.if_statement_return retval = new GremlinParser.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal32=null;
        Token NEWLINE34=null;
        Token string_literal36=null;
        GremlinParser.statement_return statement33 = null;

        GremlinParser.block_return block35 = null;


        CommonTree string_literal32_tree=null;
        CommonTree NEWLINE34_tree=null;
        CommonTree string_literal36_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:98:2: ( 'if' statement NEWLINE block 'end' -> ^( IF ^( COND statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:98:4: 'if' statement NEWLINE block 'end'
            {
            string_literal32=(Token)match(input,69,FOLLOW_69_in_if_statement503); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal32);

            pushFollow(FOLLOW_statement_in_if_statement505);
            statement33=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement33.getTree());
            NEWLINE34=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_if_statement507); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE34);

            pushFollow(FOLLOW_block_in_if_statement521);
            block35=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block35.getTree());
            string_literal36=(Token)match(input,70,FOLLOW_70_in_if_statement532); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal36);



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
            // 100:15: -> ^( IF ^( COND statement ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:18: ^( IF ^( COND statement ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:100:23: ^( COND statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:103:1: foreach_statement : 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) ;
    public final GremlinParser.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinParser.foreach_statement_return retval = new GremlinParser.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal37=null;
        Token VARIABLE38=null;
        Token string_literal39=null;
        Token NEWLINE41=null;
        Token string_literal43=null;
        GremlinParser.statement_return statement40 = null;

        GremlinParser.block_return block42 = null;


        CommonTree string_literal37_tree=null;
        CommonTree VARIABLE38_tree=null;
        CommonTree string_literal39_tree=null;
        CommonTree NEWLINE41_tree=null;
        CommonTree string_literal43_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:2: ( 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:104:4: 'foreach' VARIABLE 'in' statement NEWLINE block 'end'
            {
            string_literal37=(Token)match(input,71,FOLLOW_71_in_foreach_statement557); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal37);

            VARIABLE38=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement559); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE38);

            string_literal39=(Token)match(input,72,FOLLOW_72_in_foreach_statement561); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(string_literal39);

            pushFollow(FOLLOW_statement_in_foreach_statement563);
            statement40=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement40.getTree());
            NEWLINE41=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_foreach_statement565); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE41);

            pushFollow(FOLLOW_block_in_foreach_statement576);
            block42=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block42.getTree());
            string_literal43=(Token)match(input,70,FOLLOW_70_in_foreach_statement584); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal43);



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
            // 106:12: -> ^( FOREACH VARIABLE statement block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:106:15: ^( FOREACH VARIABLE statement block )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:109:1: while_statement : 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) ;
    public final GremlinParser.while_statement_return while_statement() throws RecognitionException {
        GremlinParser.while_statement_return retval = new GremlinParser.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal44=null;
        Token NEWLINE46=null;
        Token string_literal48=null;
        GremlinParser.statement_return statement45 = null;

        GremlinParser.block_return block47 = null;


        CommonTree string_literal44_tree=null;
        CommonTree NEWLINE46_tree=null;
        CommonTree string_literal48_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:110:2: ( 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:110:4: 'while' statement NEWLINE block 'end'
            {
            string_literal44=(Token)match(input,73,FOLLOW_73_in_while_statement608); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_73.add(string_literal44);

            pushFollow(FOLLOW_statement_in_while_statement610);
            statement45=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement45.getTree());
            NEWLINE46=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_while_statement612); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE46);

            pushFollow(FOLLOW_block_in_while_statement623);
            block47=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block47.getTree());
            string_literal48=(Token)match(input,70,FOLLOW_70_in_while_statement631); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal48);



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
            // 112:12: -> ^( WHILE ^( COND statement ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:112:15: ^( WHILE ^( COND statement ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:112:23: ^( COND statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:115:1: repeat_statement : 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) ;
    public final GremlinParser.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinParser.repeat_statement_return retval = new GremlinParser.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal49=null;
        Token NEWLINE51=null;
        Token string_literal53=null;
        GremlinParser.statement_return statement50 = null;

        GremlinParser.block_return block52 = null;


        CommonTree string_literal49_tree=null;
        CommonTree NEWLINE51_tree=null;
        CommonTree string_literal53_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:116:2: ( 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:116:4: 'repeat' statement NEWLINE block 'end'
            {
            string_literal49=(Token)match(input,74,FOLLOW_74_in_repeat_statement656); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(string_literal49);

            pushFollow(FOLLOW_statement_in_repeat_statement658);
            statement50=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement50.getTree());
            NEWLINE51=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeat_statement660); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE51);

            pushFollow(FOLLOW_block_in_repeat_statement667);
            block52=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block52.getTree());
            string_literal53=(Token)match(input,70,FOLLOW_70_in_repeat_statement671); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal53);



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
            // 118:9: -> ^( REPEAT statement block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:118:12: ^( REPEAT statement block )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:121:1: path_definition_statement : 'path' IDENTIFIER NEWLINE statement NEWLINE 'end' -> ^( PATH IDENTIFIER statement ) ;
    public final GremlinParser.path_definition_statement_return path_definition_statement() throws RecognitionException {
        GremlinParser.path_definition_statement_return retval = new GremlinParser.path_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal54=null;
        Token IDENTIFIER55=null;
        Token NEWLINE56=null;
        Token NEWLINE58=null;
        Token string_literal59=null;
        GremlinParser.statement_return statement57 = null;


        CommonTree string_literal54_tree=null;
        CommonTree IDENTIFIER55_tree=null;
        CommonTree NEWLINE56_tree=null;
        CommonTree NEWLINE58_tree=null;
        CommonTree string_literal59_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:122:2: ( 'path' IDENTIFIER NEWLINE statement NEWLINE 'end' -> ^( PATH IDENTIFIER statement ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:122:4: 'path' IDENTIFIER NEWLINE statement NEWLINE 'end'
            {
            string_literal54=(Token)match(input,75,FOLLOW_75_in_path_definition_statement693); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal54);

            IDENTIFIER55=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_path_definition_statement695); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER55);

            NEWLINE56=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_path_definition_statement697); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE56);

            pushFollow(FOLLOW_statement_in_path_definition_statement704);
            statement57=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement57.getTree());
            NEWLINE58=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_path_definition_statement706); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE58);

            string_literal59=(Token)match(input,70,FOLLOW_70_in_path_definition_statement710); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal59);



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
            // 124:9: -> ^( PATH IDENTIFIER statement )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:124:12: ^( PATH IDENTIFIER statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:127:1: function_definition_statement : 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) ;
    public final GremlinParser.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinParser.function_definition_statement_return retval = new GremlinParser.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal60=null;
        Token char_literal62=null;
        Token char_literal64=null;
        Token NEWLINE65=null;
        Token string_literal67=null;
        GremlinParser.function_name_return function_name61 = null;

        GremlinParser.formal_arguments_return formal_arguments63 = null;

        GremlinParser.block_return block66 = null;


        CommonTree string_literal60_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree char_literal64_tree=null;
        CommonTree NEWLINE65_tree=null;
        CommonTree string_literal67_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_formal_arguments=new RewriteRuleSubtreeStream(adaptor,"rule formal_arguments");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:128:2: ( 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:128:4: 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end'
            {
            string_literal60=(Token)match(input,76,FOLLOW_76_in_function_definition_statement732); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_76.add(string_literal60);

            pushFollow(FOLLOW_function_name_in_function_definition_statement734);
            function_name61=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name61.getTree());
            char_literal62=(Token)match(input,77,FOLLOW_77_in_function_definition_statement736); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal62);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:128:29: ( formal_arguments )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==VARIABLE) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: formal_arguments
            	    {
            	    pushFollow(FOLLOW_formal_arguments_in_function_definition_statement738);
            	    formal_arguments63=formal_arguments();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formal_arguments.add(formal_arguments63.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            char_literal64=(Token)match(input,78,FOLLOW_78_in_function_definition_statement741); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal64);

            NEWLINE65=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function_definition_statement743); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE65);

            pushFollow(FOLLOW_block_in_function_definition_statement750);
            block66=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block66.getTree());
            string_literal67=(Token)match(input,70,FOLLOW_70_in_function_definition_statement754); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal67);



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
            // 130:9: -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:130:12: ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC, "FUNC"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:130:33: ^( ARGS ( formal_arguments )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:130:40: ( formal_arguments )*
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:133:1: formal_arguments : VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ ;
    public final GremlinParser.formal_arguments_return formal_arguments() throws RecognitionException {
        GremlinParser.formal_arguments_return retval = new GremlinParser.formal_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLE68=null;
        Token char_literal69=null;
        Token VARIABLE70=null;

        CommonTree VARIABLE68_tree=null;
        CommonTree char_literal69_tree=null;
        CommonTree VARIABLE70_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:134:2: ( VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:134:4: VARIABLE ( ',' VARIABLE )*
            {
            VARIABLE68=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments784); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE68);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:134:13: ( ',' VARIABLE )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==79) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:134:14: ',' VARIABLE
            	    {
            	    char_literal69=(Token)match(input,79,FOLLOW_79_in_formal_arguments787); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_79.add(char_literal69);

            	    VARIABLE70=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments789); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE70);


            	    }
            	    break;

            	default :
            	    break loop12;
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
            // 134:29: -> ( ^( ARG VARIABLE ) )+
            {
                if ( !(stream_VARIABLE.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_VARIABLE.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:134:32: ^( ARG VARIABLE )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:137:1: block : ( statement | NEWLINE )* -> ^( BLOCK ( statement )* ) ;
    public final GremlinParser.block_return block() throws RecognitionException {
        GremlinParser.block_return retval = new GremlinParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE72=null;
        GremlinParser.statement_return statement71 = null;


        CommonTree NEWLINE72_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:138:5: ( ( statement | NEWLINE )* -> ^( BLOCK ( statement )* ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:138:7: ( statement | NEWLINE )*
            {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:138:7: ( statement | NEWLINE )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==NULL||(LA13_0>=VARIABLE && LA13_0<=PROPERTY)||LA13_0==64||(LA13_0>=68 && LA13_0<=69)||LA13_0==71||(LA13_0>=73 && LA13_0<=77)) ) {
                    alt13=1;
                }
                else if ( (LA13_0==NEWLINE) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:138:8: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block816);
            	    statement71=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement71.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:138:20: NEWLINE
            	    {
            	    NEWLINE72=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block820); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE72);


            	    }
            	    break;

            	default :
            	    break loop13;
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
            // 138:30: -> ^( BLOCK ( statement )* )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:138:33: ^( BLOCK ( statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:138:41: ( statement )*
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:141:1: expression : operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* ;
    public final GremlinParser.expression_return expression() throws RecognitionException {
        GremlinParser.expression_return retval = new GremlinParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal74=null;
        Token string_literal75=null;
        Token char_literal76=null;
        Token string_literal77=null;
        Token char_literal78=null;
        Token string_literal79=null;
        GremlinParser.operation_return operation73 = null;

        GremlinParser.operation_return operation80 = null;


        CommonTree char_literal74_tree=null;
        CommonTree string_literal75_tree=null;
        CommonTree char_literal76_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree char_literal78_tree=null;
        CommonTree string_literal79_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:2: ( operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:4: operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_operation_in_expression843);
            operation73=operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, operation73.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:14: ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=80 && LA15_0<=85)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' )
            	    int alt14=6;
            	    switch ( input.LA(1) ) {
            	    case 80:
            	        {
            	        alt14=1;
            	        }
            	        break;
            	    case 81:
            	        {
            	        alt14=2;
            	        }
            	        break;
            	    case 82:
            	        {
            	        alt14=3;
            	        }
            	        break;
            	    case 83:
            	        {
            	        alt14=4;
            	        }
            	        break;
            	    case 84:
            	        {
            	        alt14=5;
            	        }
            	        break;
            	    case 85:
            	        {
            	        alt14=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt14) {
            	        case 1 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:16: '='
            	            {
            	            char_literal74=(Token)match(input,80,FOLLOW_80_in_expression847); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal74_tree = (CommonTree)adaptor.create(char_literal74);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal74_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:23: '!='
            	            {
            	            string_literal75=(Token)match(input,81,FOLLOW_81_in_expression852); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal75_tree = (CommonTree)adaptor.create(string_literal75);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal75_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:31: '<'
            	            {
            	            char_literal76=(Token)match(input,82,FOLLOW_82_in_expression857); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal76_tree = (CommonTree)adaptor.create(char_literal76);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal76_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:38: '<='
            	            {
            	            string_literal77=(Token)match(input,83,FOLLOW_83_in_expression862); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal77_tree = (CommonTree)adaptor.create(string_literal77);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal77_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:46: '>'
            	            {
            	            char_literal78=(Token)match(input,84,FOLLOW_84_in_expression867); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal78_tree = (CommonTree)adaptor.create(char_literal78);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal78_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:142:53: '>='
            	            {
            	            string_literal79=(Token)match(input,85,FOLLOW_85_in_expression872); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal79_tree = (CommonTree)adaptor.create(string_literal79);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal79_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_operation_in_expression876);
            	    operation80=operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, operation80.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:145:1: operation : binary_operation ( ( '+' | '-' ) binary_operation )* ;
    public final GremlinParser.operation_return operation() throws RecognitionException {
        GremlinParser.operation_return retval = new GremlinParser.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal82=null;
        Token char_literal83=null;
        GremlinParser.binary_operation_return binary_operation81 = null;

        GremlinParser.binary_operation_return binary_operation84 = null;


        CommonTree char_literal82_tree=null;
        CommonTree char_literal83_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:2: ( binary_operation ( ( '+' | '-' ) binary_operation )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:4: binary_operation ( ( '+' | '-' ) binary_operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_binary_operation_in_operation890);
            binary_operation81=binary_operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation81.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:21: ( ( '+' | '-' ) binary_operation )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=86 && LA17_0<=87)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:22: ( '+' | '-' ) binary_operation
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:22: ( '+' | '-' )
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( (LA16_0==86) ) {
            	        alt16=1;
            	    }
            	    else if ( (LA16_0==87) ) {
            	        alt16=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:23: '+'
            	            {
            	            char_literal82=(Token)match(input,86,FOLLOW_86_in_operation894); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal82_tree = (CommonTree)adaptor.create(char_literal82);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal82_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:146:28: '-'
            	            {
            	            char_literal83=(Token)match(input,87,FOLLOW_87_in_operation897); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal83_tree = (CommonTree)adaptor.create(char_literal83);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal83_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_binary_operation_in_operation901);
            	    binary_operation84=binary_operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation84.getTree());

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
    // $ANTLR end "operation"

    public static class binary_operation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "binary_operation"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:149:1: binary_operation : atom ( ( '*' | 'div' ) atom )* ;
    public final GremlinParser.binary_operation_return binary_operation() throws RecognitionException {
        GremlinParser.binary_operation_return retval = new GremlinParser.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal86=null;
        Token string_literal87=null;
        GremlinParser.atom_return atom85 = null;

        GremlinParser.atom_return atom88 = null;


        CommonTree char_literal86_tree=null;
        CommonTree string_literal87_tree=null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:2: ( atom ( ( '*' | 'div' ) atom )* )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:4: atom ( ( '*' | 'div' ) atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_binary_operation915);
            atom85=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom85.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:9: ( ( '*' | 'div' ) atom )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=88 && LA19_0<=89)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:10: ( '*' | 'div' ) atom
            	    {
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:10: ( '*' | 'div' )
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==88) ) {
            	        alt18=1;
            	    }
            	    else if ( (LA18_0==89) ) {
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
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:11: '*'
            	            {
            	            char_literal86=(Token)match(input,88,FOLLOW_88_in_binary_operation919); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal86_tree = (CommonTree)adaptor.create(char_literal86);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal86_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:150:16: 'div'
            	            {
            	            string_literal87=(Token)match(input,89,FOLLOW_89_in_binary_operation922); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal87_tree = (CommonTree)adaptor.create(string_literal87);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal87_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_atom_in_binary_operation926);
            	    atom88=atom();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom88.getTree());

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
    // $ANTLR end "binary_operation"

    public static class function_call_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_call"
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:153:1: function_call : function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) ;
    public final GremlinParser.function_call_return function_call() throws RecognitionException {
        GremlinParser.function_call_return retval = new GremlinParser.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal90=null;
        Token char_literal92=null;
        GremlinParser.function_name_return function_name89 = null;

        GremlinParser.function_call_params_return function_call_params91 = null;


        CommonTree char_literal90_tree=null;
        CommonTree char_literal92_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleSubtreeStream stream_function_call_params=new RewriteRuleSubtreeStream(adaptor,"rule function_call_params");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:154:2: ( function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:154:4: function_name '(' ( function_call_params )* ')'
            {
            pushFollow(FOLLOW_function_name_in_function_call940);
            function_name89=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name89.getTree());
            char_literal90=(Token)match(input,77,FOLLOW_77_in_function_call942); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(char_literal90);

            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:154:22: ( function_call_params )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==NULL||(LA20_0>=VARIABLE && LA20_0<=PROPERTY)||LA20_0==64||(LA20_0>=68 && LA20_0<=69)||LA20_0==71||(LA20_0>=73 && LA20_0<=77)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: function_call_params
            	    {
            	    pushFollow(FOLLOW_function_call_params_in_function_call944);
            	    function_call_params91=function_call_params();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function_call_params.add(function_call_params91.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            char_literal92=(Token)match(input,78,FOLLOW_78_in_function_call947); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(char_literal92);



            // AST REWRITE
            // elements: function_call_params, function_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 154:48: -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:154:51: ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:154:77: ^( ARGS ( function_call_params )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:154:84: ( function_call_params )*
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:157:1: function_name : ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) ;
    public final GremlinParser.function_name_return function_name() throws RecognitionException {
        GremlinParser.function_name_return retval = new GremlinParser.function_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ns=null;
        Token ln=null;
        Token char_literal93=null;

        CommonTree ns_tree=null;
        CommonTree ln_tree=null;
        CommonTree char_literal93_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:158:2: (ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:158:4: ns= IDENTIFIER ':' ln= IDENTIFIER
            {
            ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name976); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(ns);

            char_literal93=(Token)match(input,90,FOLLOW_90_in_function_name978); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_90.add(char_literal93);

            ln=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name982); if (state.failed) return retval; 
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
            // 158:36: -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:158:39: ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_NAME, "FUNC_NAME"), root_1);

                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:158:51: ^( NS $ns)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NS, "NS"), root_2);

                adaptor.addChild(root_2, stream_ns.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:158:61: ^( NAME $ln)
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:161:1: function_call_params : statement ( ',' statement )* -> ( ^( ARG statement ) )+ ;
    public final GremlinParser.function_call_params_return function_call_params() throws RecognitionException {
        GremlinParser.function_call_params_return retval = new GremlinParser.function_call_params_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal95=null;
        GremlinParser.statement_return statement94 = null;

        GremlinParser.statement_return statement96 = null;


        CommonTree char_literal95_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:162:2: ( statement ( ',' statement )* -> ( ^( ARG statement ) )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:162:4: statement ( ',' statement )*
            {
            pushFollow(FOLLOW_statement_in_function_call_params1017);
            statement94=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement94.getTree());
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:162:14: ( ',' statement )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==79) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:162:15: ',' statement
            	    {
            	    char_literal95=(Token)match(input,79,FOLLOW_79_in_function_call_params1020); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_79.add(char_literal95);

            	    pushFollow(FOLLOW_statement_in_function_call_params1022);
            	    statement96=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement96.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
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
            // 162:31: -> ( ^( ARG statement ) )+
            {
                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:162:34: ^( ARG statement )
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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:165:1: atom : ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | range | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | function_call | '(' statement ')' );
    public final GremlinParser.atom_return atom() throws RecognitionException {
        GremlinParser.atom_return retval = new GremlinParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token b=null;
        Token G_INT97=null;
        Token G_LONG98=null;
        Token G_FLOAT99=null;
        Token G_DOUBLE100=null;
        Token StringLiteral102=null;
        Token NULL103=null;
        Token PROPERTY104=null;
        Token VARIABLE105=null;
        Token IDENTIFIER106=null;
        Token char_literal108=null;
        Token char_literal110=null;
        GremlinParser.range_return range101 = null;

        GremlinParser.function_call_return function_call107 = null;

        GremlinParser.statement_return statement109 = null;


        CommonTree b_tree=null;
        CommonTree G_INT97_tree=null;
        CommonTree G_LONG98_tree=null;
        CommonTree G_FLOAT99_tree=null;
        CommonTree G_DOUBLE100_tree=null;
        CommonTree StringLiteral102_tree=null;
        CommonTree NULL103_tree=null;
        CommonTree PROPERTY104_tree=null;
        CommonTree VARIABLE105_tree=null;
        CommonTree IDENTIFIER106_tree=null;
        CommonTree char_literal108_tree=null;
        CommonTree char_literal110_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_G_LONG=new RewriteRuleTokenStream(adaptor,"token G_LONG");
        RewriteRuleTokenStream stream_BOOLEAN=new RewriteRuleTokenStream(adaptor,"token BOOLEAN");
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_G_DOUBLE=new RewriteRuleTokenStream(adaptor,"token G_DOUBLE");
        RewriteRuleTokenStream stream_PROPERTY=new RewriteRuleTokenStream(adaptor,"token PROPERTY");
        RewriteRuleTokenStream stream_G_FLOAT=new RewriteRuleTokenStream(adaptor,"token G_FLOAT");
        RewriteRuleTokenStream stream_G_INT=new RewriteRuleTokenStream(adaptor,"token G_INT");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:166:2: ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | range | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | function_call | '(' statement ')' )
            int alt22=13;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:166:6: G_INT
                    {
                    G_INT97=(Token)match(input,G_INT,FOLLOW_G_INT_in_atom1047); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_INT.add(G_INT97);



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
                    // 166:22: -> ^( INT G_INT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:166:25: ^( INT G_INT )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:167:6: G_LONG
                    {
                    G_LONG98=(Token)match(input,G_LONG,FOLLOW_G_LONG_in_atom1072); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_LONG.add(G_LONG98);



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
                    // 167:22: -> ^( LONG G_LONG )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:167:25: ^( LONG G_LONG )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:168:6: G_FLOAT
                    {
                    G_FLOAT99=(Token)match(input,G_FLOAT,FOLLOW_G_FLOAT_in_atom1096); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_FLOAT.add(G_FLOAT99);



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
                    // 168:22: -> ^( FLOAT G_FLOAT )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:168:25: ^( FLOAT G_FLOAT )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:6: G_DOUBLE
                    {
                    G_DOUBLE100=(Token)match(input,G_DOUBLE,FOLLOW_G_DOUBLE_in_atom1119); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_G_DOUBLE.add(G_DOUBLE100);



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
                    // 169:22: -> ^( DOUBLE G_DOUBLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:169:25: ^( DOUBLE G_DOUBLE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:170:6: range
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_range_in_atom1141);
                    range101=range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, range101.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:171:4: StringLiteral
                    {
                    StringLiteral102=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_atom1146); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral102);



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
                    // 171:18: -> ^( STR StringLiteral )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:171:21: ^( STR StringLiteral )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:172:9: b= BOOLEAN
                    {
                    b=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_atom1166); if (state.failed) return retval; 
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
                    // 172:25: -> ^( BOOL $b)
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:172:28: ^( BOOL $b)
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:173:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NULL103=(Token)match(input,NULL,FOLLOW_NULL_in_atom1191); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL103_tree = (CommonTree)adaptor.create(NULL103);
                    adaptor.addChild(root_0, NULL103_tree);
                    }

                    }
                    break;
                case 9 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:174:4: PROPERTY
                    {
                    PROPERTY104=(Token)match(input,PROPERTY,FOLLOW_PROPERTY_in_atom1196); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROPERTY.add(PROPERTY104);



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
                    // 174:17: -> ^( PROPERTY_CALL PROPERTY )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:174:20: ^( PROPERTY_CALL PROPERTY )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:175:4: VARIABLE
                    {
                    VARIABLE105=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_atom1213); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE105);



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
                    // 175:20: -> ^( VARIABLE_CALL VARIABLE )
                    {
                        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:175:23: ^( VARIABLE_CALL VARIABLE )
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
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:176:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IDENTIFIER106=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atom1233); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER106_tree = (CommonTree)adaptor.create(IDENTIFIER106);
                    adaptor.addChild(root_0, IDENTIFIER106_tree);
                    }

                    }
                    break;
                case 12 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:177:4: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_call_in_atom1238);
                    function_call107=function_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_call107.getTree());

                    }
                    break;
                case 13 :
                    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:178:4: '(' statement ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal108=(Token)match(input,77,FOLLOW_77_in_atom1243); if (state.failed) return retval;
                    pushFollow(FOLLOW_statement_in_atom1246);
                    statement109=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement109.getTree());
                    char_literal110=(Token)match(input,78,FOLLOW_78_in_atom1248); if (state.failed) return retval;

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
    // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:218:1: range : min= G_INT '..' max= G_INT -> ^( RANGE $min $max) ;
    public final GremlinParser.range_return range() throws RecognitionException {
        GremlinParser.range_return retval = new GremlinParser.range_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token min=null;
        Token max=null;
        Token string_literal111=null;

        CommonTree min_tree=null;
        CommonTree max_tree=null;
        CommonTree string_literal111_tree=null;
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_G_INT=new RewriteRuleTokenStream(adaptor,"token G_INT");

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:219:5: (min= G_INT '..' max= G_INT -> ^( RANGE $min $max) )
            // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:219:9: min= G_INT '..' max= G_INT
            {
            min=(Token)match(input,G_INT,FOLLOW_G_INT_in_range1431); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_G_INT.add(min);

            string_literal111=(Token)match(input,64,FOLLOW_64_in_range1433); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_64.add(string_literal111);

            max=(Token)match(input,G_INT,FOLLOW_G_INT_in_range1437); if (state.failed) return retval; 
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
            // 219:35: -> ^( RANGE $min $max)
            {
                // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:219:38: ^( RANGE $min $max)
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

    // $ANTLR start synpred15_Gremlin
    public final void synpred15_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:88:4: ( gpath_statement )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:88:4: gpath_statement
        {
        pushFollow(FOLLOW_gpath_statement_in_synpred15_Gremlin432);
        gpath_statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_Gremlin

    // $ANTLR start synpred16_Gremlin
    public final void synpred16_Gremlin_fragment() throws RecognitionException {   
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:89:4: ( VARIABLE ':=' statement )
        // src/main/java/com/tinkerpop/gremlin/compiler/Gremlin.g:89:4: VARIABLE ':=' statement
        {
        match(input,VARIABLE,FOLLOW_VARIABLE_in_synpred16_Gremlin437); if (state.failed) return ;
        match(input,65,FOLLOW_65_in_synpred16_Gremlin439); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred16_Gremlin441);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_Gremlin

    // Delegated rules

    public final boolean synpred15_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA10_eotS =
        "\26\uffff";
    static final String DFA10_eofS =
        "\26\uffff";
    static final String DFA10_minS =
        "\1\42\7\uffff\13\0\3\uffff";
    static final String DFA10_maxS =
        "\1\115\7\uffff\13\0\3\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\13\uffff\1\10\1\12\1\11";
    static final String DFA10_specialS =
        "\10\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\3\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\16\5\uffff\1\20\1\14\1\21\1\10\1\11\1\12\1\13\1\15\1\17\17"+
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
            return "80:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_8 = input.LA(1);

                         
                        int index10_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index10_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_9 = input.LA(1);

                         
                        int index10_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index10_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_10 = input.LA(1);

                         
                        int index10_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index10_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA10_11 = input.LA(1);

                         
                        int index10_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index10_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA10_12 = input.LA(1);

                         
                        int index10_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index10_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA10_13 = input.LA(1);

                         
                        int index10_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index10_13);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA10_14 = input.LA(1);

                         
                        int index10_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index10_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA10_15 = input.LA(1);

                         
                        int index10_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index10_15);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA10_16 = input.LA(1);

                         
                        int index10_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Gremlin()) ) {s = 19;}

                        else if ( (synpred16_Gremlin()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index10_16);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA10_17 = input.LA(1);

                         
                        int index10_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index10_17);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA10_18 = input.LA(1);

                         
                        int index10_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Gremlin()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index10_18);
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
    static final String DFA22_eotS =
        "\21\uffff";
    static final String DFA22_eofS =
        "\1\uffff\1\15\10\uffff\1\17\6\uffff";
    static final String DFA22_minS =
        "\2\42\10\uffff\1\42\1\uffff\1\53\4\uffff";
    static final String DFA22_maxS =
        "\1\115\1\131\10\uffff\1\132\1\uffff\1\76\4\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\6\1\7\1\10\1\11\1\12\1\uffff\1\15\1\uffff"+
        "\1\1\1\14\1\13\1\5";
    static final String DFA22_specialS =
        "\21\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\7\5\uffff\1\11\1\5\1\12\1\1\1\2\1\3\1\4\1\6\1\10\34\uffff"+
            "\1\13",
            "\1\15\4\uffff\12\15\14\uffff\3\15\1\14\1\uffff\6\15\1\uffff"+
            "\21\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17\4\uffff\12\17\14\uffff\4\17\1\uffff\6\17\1\uffff\21\17"+
            "\1\16",
            "",
            "\1\20\21\uffff\2\15",
            "",
            "",
            "",
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
            return "165:1: atom : ( G_INT -> ^( INT G_INT ) | G_LONG -> ^( LONG G_LONG ) | G_FLOAT -> ^( FLOAT G_FLOAT ) | G_DOUBLE -> ^( DOUBLE G_DOUBLE ) | range | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | function_call | '(' statement ')' );";
        }
    }
 

    public static final BitSet FOLLOW_COMMENT_in_program240 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_statement_in_program252 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_program255 = new BitSet(new long[]{0x0001FF8400000002L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_step_in_gpath_statement292 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_gpath_statement294 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002001L});
    public static final BitSet FOLLOW_step_in_gpath_statement296 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_gpath_statement299 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002001L});
    public static final BitSet FOLLOW_step_in_gpath_statement301 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_token_in_step327 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_step330 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_statement_in_step332 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_step334 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_expression_in_token376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_token380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_definition_statement_in_statement417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_statement432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_statement437 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_statement439 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_statement_in_statement441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement456 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_66_in_statement460 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_67_in_statement463 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_expression_in_statement467 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_68_in_include_statement480 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_if_statement503 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_statement_in_if_statement505 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_if_statement507 = new BitSet(new long[]{0x0001FF8400000000L,0x0000000000003EF1L});
    public static final BitSet FOLLOW_block_in_if_statement521 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_if_statement532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_foreach_statement557 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement559 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_foreach_statement561 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_statement_in_foreach_statement563 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_foreach_statement565 = new BitSet(new long[]{0x0001FF8400000000L,0x0000000000003EF1L});
    public static final BitSet FOLLOW_block_in_foreach_statement576 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_foreach_statement584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_while_statement608 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_statement_in_while_statement610 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_while_statement612 = new BitSet(new long[]{0x0001FF8400000000L,0x0000000000003EF1L});
    public static final BitSet FOLLOW_block_in_while_statement623 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_while_statement631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_repeat_statement656 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_statement_in_repeat_statement658 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeat_statement660 = new BitSet(new long[]{0x0001FF8400000000L,0x0000000000003EF1L});
    public static final BitSet FOLLOW_block_in_repeat_statement667 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_repeat_statement671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_path_definition_statement693 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_path_definition_statement695 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_path_definition_statement697 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_statement_in_path_definition_statement704 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_path_definition_statement706 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_path_definition_statement710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_function_definition_statement732 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_function_name_in_function_definition_statement734 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_function_definition_statement736 = new BitSet(new long[]{0x0000010000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_formal_arguments_in_function_definition_statement738 = new BitSet(new long[]{0x0000010000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_function_definition_statement741 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_function_definition_statement743 = new BitSet(new long[]{0x0001FF8400000000L,0x0000000000003EF1L});
    public static final BitSet FOLLOW_block_in_function_definition_statement750 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_function_definition_statement754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments784 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_formal_arguments787 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments789 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_statement_in_block816 = new BitSet(new long[]{0x0001FF8400000002L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_NEWLINE_in_block820 = new BitSet(new long[]{0x0001FF8400000002L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_operation_in_expression843 = new BitSet(new long[]{0x0000000000000002L,0x00000000003F0000L});
    public static final BitSet FOLLOW_80_in_expression847 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_81_in_expression852 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_82_in_expression857 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_83_in_expression862 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_84_in_expression867 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_85_in_expression872 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_operation_in_expression876 = new BitSet(new long[]{0x0000000000000002L,0x00000000003F0000L});
    public static final BitSet FOLLOW_binary_operation_in_operation890 = new BitSet(new long[]{0x0000000000000002L,0x0000000000C00000L});
    public static final BitSet FOLLOW_86_in_operation894 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_87_in_operation897 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_binary_operation_in_operation901 = new BitSet(new long[]{0x0000000000000002L,0x0000000000C00000L});
    public static final BitSet FOLLOW_atom_in_binary_operation915 = new BitSet(new long[]{0x0000000000000002L,0x0000000003000000L});
    public static final BitSet FOLLOW_88_in_binary_operation919 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_89_in_binary_operation922 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_atom_in_binary_operation926 = new BitSet(new long[]{0x0000000000000002L,0x0000000003000000L});
    public static final BitSet FOLLOW_function_name_in_function_call940 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_function_call942 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000007EB1L});
    public static final BitSet FOLLOW_function_call_params_in_function_call944 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000007EB1L});
    public static final BitSet FOLLOW_78_in_function_call947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name976 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_function_name978 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_function_call_params1017 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_function_call_params1020 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_statement_in_function_call_params1022 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_G_INT_in_atom1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_LONG_in_atom1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_FLOAT_in_atom1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_DOUBLE_in_atom1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_atom1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_atom1146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_atom1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_atom1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROPERTY_in_atom1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_atom1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_atom1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_atom1243 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_statement_in_atom1246 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_atom1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_G_INT_in_range1431 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_range1433 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_G_INT_in_range1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_synpred15_Gremlin432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_synpred16_Gremlin437 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_synpred16_Gremlin439 = new BitSet(new long[]{0x0001FF0400000000L,0x0000000000003EB1L});
    public static final BitSet FOLLOW_statement_in_synpred16_Gremlin441 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.2 Sep 23, 2009 12:02:23 com/tinkerpop/gremlin/compiler/Gremlin.g 2010-07-05 13:02:36

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "PATH", "GPATH", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "SELF", "HISTORY", "FUNC_CALL", "IF", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "NUM", "STR", "ARR", "BOOL", "NULL", "ARR_IDX", "PROPERTY_CALL", "VARIABLE_CALL", "COMMENT", "NEWLINE", "VARIABLE", "StringLiteral", "IDENTIFIER", "NUMBER", "BOOLEAN", "PROPERTY", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "'/'", "'['", "']'", "':='", "'and'", "'or'", "'include'", "'if'", "'end'", "'foreach'", "'in'", "'while'", "'repeat'", "'path'", "'func'", "'('", "')'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "':'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int HexEscapeSequence=48;
    public static final int WHILE=24;
    public static final int T__63=63;
    public static final int STEP=13;
    public static final int DecimalDigit=53;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int HexDigit=54;
    public static final int PREDICATE=15;
    public static final int IF=20;
    public static final int FUNC_CALL=19;
    public static final int SingleStringCharacter=44;
    public static final int TOKEN=14;
    public static final int HISTORY=18;
    public static final int T__55=55;
    public static final int STR=28;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int NAME=9;
    public static final int BOOLEAN=41;
    public static final int ARG=5;
    public static final int PATH=11;
    public static final int IDENTIFIER=39;
    public static final int T__59=59;
    public static final int SingleEscapeCharacter=50;
    public static final int INCLUDE=26;
    public static final int ARGS=6;
    public static final int EscapeCharacter=52;
    public static final int VAR=4;
    public static final int GPATH=12;
    public static final int COMMENT=35;
    public static final int PROPERTY_CALL=33;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int NS=8;
    public static final int UnicodeEscapeSequence=49;
    public static final int NULL=31;
    public static final int NUMBER=40;
    public static final int BOOL=30;
    public static final int DoubleStringCharacter=43;
    public static final int ARR=29;
    public static final int ARR_IDX=32;
    public static final int NUM=27;
    public static final int StringLiteral=38;
    public static final int WS=45;
    public static final int T__71=71;
    public static final int PREDICATES=16;
    public static final int T__72=72;
    public static final int VARIABLE=37;
    public static final int NEWLINE=36;
    public static final int T__70=70;
    public static final int PROPERTY=42;
    public static final int FUNC=7;
    public static final int BLOCK=22;
    public static final int NonEscapeCharacter=51;
    public static final int REPEAT=25;
    public static final int FOREACH=23;
    public static final int CharacterEscapeSequence=47;
    public static final int FUNC_NAME=10;
    public static final int T__76=76;
    public static final int COND=21;
    public static final int T__75=75;
    public static final int SELF=17;
    public static final int T__74=74;
    public static final int EscapeSequence=46;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int VARIABLE_CALL=34;
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
    public String getGrammarFileName() { return "com/tinkerpop/gremlin/compiler/Gremlin.g"; }


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // com/tinkerpop/gremlin/compiler/Gremlin.g:55:1: program : ( ( COMMENT )+ | ( ( statement )? NEWLINE )+ );
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
            // com/tinkerpop/gremlin/compiler/Gremlin.g:56:5: ( ( COMMENT )+ | ( ( statement )? NEWLINE )+ )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==COMMENT) ) {
                alt4=1;
            }
            else if ( (LA4_0==NULL||(LA4_0>=NEWLINE && LA4_0<=PROPERTY)||(LA4_0>=61 && LA4_0<=62)||LA4_0==64||(LA4_0>=66 && LA4_0<=70)) ) {
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
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:56:7: ( COMMENT )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // com/tinkerpop/gremlin/compiler/Gremlin.g:56:7: ( COMMENT )+
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
                    	    // com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: COMMENT
                    	    {
                    	    COMMENT1=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_program214); if (state.failed) return retval;
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
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:57:9: ( ( statement )? NEWLINE )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // com/tinkerpop/gremlin/compiler/Gremlin.g:57:9: ( ( statement )? NEWLINE )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NULL||(LA3_0>=NEWLINE && LA3_0<=PROPERTY)||(LA3_0>=61 && LA3_0<=62)||LA3_0==64||(LA3_0>=66 && LA3_0<=70)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // com/tinkerpop/gremlin/compiler/Gremlin.g:57:10: ( statement )? NEWLINE
                    	    {
                    	    // com/tinkerpop/gremlin/compiler/Gremlin.g:57:10: ( statement )?
                    	    int alt2=2;
                    	    int LA2_0 = input.LA(1);

                    	    if ( (LA2_0==NULL||(LA2_0>=VARIABLE && LA2_0<=PROPERTY)||(LA2_0>=61 && LA2_0<=62)||LA2_0==64||(LA2_0>=66 && LA2_0<=70)) ) {
                    	        alt2=1;
                    	    }
                    	    switch (alt2) {
                    	        case 1 :
                    	            // com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: statement
                    	            {
                    	            pushFollow(FOLLOW_statement_in_program226);
                    	            statement2=statement();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement2.getTree());

                    	            }
                    	            break;

                    	    }

                    	    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_program229); if (state.failed) return retval;
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:64:1: gpath_statement : step '/' step ( '/' step )* -> ^( GPATH ( step )+ ) ;
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
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleSubtreeStream stream_step=new RewriteRuleSubtreeStream(adaptor,"rule step");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:65:2: ( step '/' step ( '/' step )* -> ^( GPATH ( step )+ ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:65:4: step '/' step ( '/' step )*
            {
            pushFollow(FOLLOW_step_in_gpath_statement266);
            step4=step();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_step.add(step4.getTree());
            char_literal5=(Token)match(input,55,FOLLOW_55_in_gpath_statement268); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_55.add(char_literal5);

            pushFollow(FOLLOW_step_in_gpath_statement270);
            step6=step();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_step.add(step6.getTree());
            // com/tinkerpop/gremlin/compiler/Gremlin.g:65:18: ( '/' step )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==55) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:65:19: '/' step
            	    {
            	    char_literal7=(Token)match(input,55,FOLLOW_55_in_gpath_statement273); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_55.add(char_literal7);

            	    pushFollow(FOLLOW_step_in_gpath_statement275);
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
            // 65:30: -> ^( GPATH ( step )+ )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:65:33: ^( GPATH ( step )+ )
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:68:1: step : token ( '[' statement ']' )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) ;
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
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_token=new RewriteRuleSubtreeStream(adaptor,"rule token");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:69:5: ( token ( '[' statement ']' )* -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:69:7: token ( '[' statement ']' )*
            {
            pushFollow(FOLLOW_token_in_step301);
            token9=token();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_token.add(token9.getTree());
            // com/tinkerpop/gremlin/compiler/Gremlin.g:69:13: ( '[' statement ']' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==56) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:69:14: '[' statement ']'
            	    {
            	    char_literal10=(Token)match(input,56,FOLLOW_56_in_step304); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_56.add(char_literal10);

            	    pushFollow(FOLLOW_statement_in_step306);
            	    statement11=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement11.getTree());
            	    char_literal12=(Token)match(input,57,FOLLOW_57_in_step308); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_57.add(char_literal12);


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
            // 69:34: -> ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:69:37: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STEP, "STEP"), root_1);

                // com/tinkerpop/gremlin/compiler/Gremlin.g:69:44: ^( TOKEN token )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TOKEN, "TOKEN"), root_2);

                adaptor.addChild(root_2, stream_token.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // com/tinkerpop/gremlin/compiler/Gremlin.g:69:59: ^( PREDICATES ( ^( PREDICATE statement ) )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREDICATES, "PREDICATES"), root_2);

                // com/tinkerpop/gremlin/compiler/Gremlin.g:69:72: ( ^( PREDICATE statement ) )*
                while ( stream_statement.hasNext() ) {
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:69:72: ^( PREDICATE statement )
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:72:1: token : expression ;
    public final GremlinParser.token_return token() throws RecognitionException {
        GremlinParser.token_return retval = new GremlinParser.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        GremlinParser.expression_return expression13 = null;



        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:73:2: ( expression )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:73:5: expression
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_expression_in_token349);
            expression13=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression13.getTree());

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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:76:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* );
    public final GremlinParser.statement_return statement() throws RecognitionException {
        GremlinParser.statement_return retval = new GremlinParser.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLE22=null;
        Token string_literal23=null;
        Token string_literal26=null;
        Token string_literal27=null;
        GremlinParser.if_statement_return if_statement14 = null;

        GremlinParser.foreach_statement_return foreach_statement15 = null;

        GremlinParser.while_statement_return while_statement16 = null;

        GremlinParser.repeat_statement_return repeat_statement17 = null;

        GremlinParser.path_definition_statement_return path_definition_statement18 = null;

        GremlinParser.function_definition_statement_return function_definition_statement19 = null;

        GremlinParser.include_statement_return include_statement20 = null;

        GremlinParser.gpath_statement_return gpath_statement21 = null;

        GremlinParser.statement_return statement24 = null;

        GremlinParser.expression_return expression25 = null;

        GremlinParser.expression_return expression28 = null;


        CommonTree VARIABLE22_tree=null;
        CommonTree string_literal23_tree=null;
        CommonTree string_literal26_tree=null;
        CommonTree string_literal27_tree=null;
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:77:5: ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* )
            int alt9=10;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:77:9: if_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_if_statement_in_statement365);
                    if_statement14=if_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, if_statement14.getTree());

                    }
                    break;
                case 2 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:78:4: foreach_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_foreach_statement_in_statement370);
                    foreach_statement15=foreach_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, foreach_statement15.getTree());

                    }
                    break;
                case 3 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:79:4: while_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_while_statement_in_statement375);
                    while_statement16=while_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, while_statement16.getTree());

                    }
                    break;
                case 4 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:80:4: repeat_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_repeat_statement_in_statement380);
                    repeat_statement17=repeat_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, repeat_statement17.getTree());

                    }
                    break;
                case 5 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:81:4: path_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_path_definition_statement_in_statement385);
                    path_definition_statement18=path_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, path_definition_statement18.getTree());

                    }
                    break;
                case 6 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:82:4: function_definition_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_definition_statement_in_statement390);
                    function_definition_statement19=function_definition_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_definition_statement19.getTree());

                    }
                    break;
                case 7 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:83:4: include_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_include_statement_in_statement395);
                    include_statement20=include_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, include_statement20.getTree());

                    }
                    break;
                case 8 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:84:4: gpath_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_gpath_statement_in_statement400);
                    gpath_statement21=gpath_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gpath_statement21.getTree());

                    }
                    break;
                case 9 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:85:4: VARIABLE ':=' statement
                    {
                    VARIABLE22=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_statement405); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE22);

                    string_literal23=(Token)match(input,58,FOLLOW_58_in_statement407); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_58.add(string_literal23);

                    pushFollow(FOLLOW_statement_in_statement409);
                    statement24=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement24.getTree());


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
                    // 85:28: -> ^( VAR VARIABLE statement )
                    {
                        // com/tinkerpop/gremlin/compiler/Gremlin.g:85:31: ^( VAR VARIABLE statement )
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
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:86:4: expression ( ( 'and' | 'or' ) expression )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement424);
                    expression25=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression25.getTree());
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:86:15: ( ( 'and' | 'or' ) expression )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=59 && LA8_0<=60)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // com/tinkerpop/gremlin/compiler/Gremlin.g:86:16: ( 'and' | 'or' ) expression
                    	    {
                    	    // com/tinkerpop/gremlin/compiler/Gremlin.g:86:16: ( 'and' | 'or' )
                    	    int alt7=2;
                    	    int LA7_0 = input.LA(1);

                    	    if ( (LA7_0==59) ) {
                    	        alt7=1;
                    	    }
                    	    else if ( (LA7_0==60) ) {
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
                    	            // com/tinkerpop/gremlin/compiler/Gremlin.g:86:17: 'and'
                    	            {
                    	            string_literal26=(Token)match(input,59,FOLLOW_59_in_statement428); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal26_tree = (CommonTree)adaptor.create(string_literal26);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal26_tree, root_0);
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // com/tinkerpop/gremlin/compiler/Gremlin.g:86:24: 'or'
                    	            {
                    	            string_literal27=(Token)match(input,60,FOLLOW_60_in_statement431); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal27_tree = (CommonTree)adaptor.create(string_literal27);
                    	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal27_tree, root_0);
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    pushFollow(FOLLOW_expression_in_statement435);
                    	    expression28=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression28.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:89:1: include_statement : 'include' StringLiteral -> ^( INCLUDE StringLiteral ) ;
    public final GremlinParser.include_statement_return include_statement() throws RecognitionException {
        GremlinParser.include_statement_return retval = new GremlinParser.include_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal29=null;
        Token StringLiteral30=null;

        CommonTree string_literal29_tree=null;
        CommonTree StringLiteral30_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");

        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:90:2: ( 'include' StringLiteral -> ^( INCLUDE StringLiteral ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:90:4: 'include' StringLiteral
            {
            string_literal29=(Token)match(input,61,FOLLOW_61_in_include_statement448); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(string_literal29);

            StringLiteral30=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_include_statement450); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral30);



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
            // 90:28: -> ^( INCLUDE StringLiteral )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:90:31: ^( INCLUDE StringLiteral )
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:93:1: if_statement : 'if' statement NEWLINE block 'end' -> ^( IF ^( COND statement ) block ) ;
    public final GremlinParser.if_statement_return if_statement() throws RecognitionException {
        GremlinParser.if_statement_return retval = new GremlinParser.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal31=null;
        Token NEWLINE33=null;
        Token string_literal35=null;
        GremlinParser.statement_return statement32 = null;

        GremlinParser.block_return block34 = null;


        CommonTree string_literal31_tree=null;
        CommonTree NEWLINE33_tree=null;
        CommonTree string_literal35_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:94:2: ( 'if' statement NEWLINE block 'end' -> ^( IF ^( COND statement ) block ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:94:4: 'if' statement NEWLINE block 'end'
            {
            string_literal31=(Token)match(input,62,FOLLOW_62_in_if_statement471); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(string_literal31);

            pushFollow(FOLLOW_statement_in_if_statement473);
            statement32=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement32.getTree());
            NEWLINE33=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_if_statement475); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE33);

            pushFollow(FOLLOW_block_in_if_statement489);
            block34=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block34.getTree());
            string_literal35=(Token)match(input,63,FOLLOW_63_in_if_statement500); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(string_literal35);



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
            // 96:15: -> ^( IF ^( COND statement ) block )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:96:18: ^( IF ^( COND statement ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                // com/tinkerpop/gremlin/compiler/Gremlin.g:96:23: ^( COND statement )
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:99:1: foreach_statement : 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) ;
    public final GremlinParser.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinParser.foreach_statement_return retval = new GremlinParser.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal36=null;
        Token VARIABLE37=null;
        Token string_literal38=null;
        Token NEWLINE40=null;
        Token string_literal42=null;
        GremlinParser.statement_return statement39 = null;

        GremlinParser.block_return block41 = null;


        CommonTree string_literal36_tree=null;
        CommonTree VARIABLE37_tree=null;
        CommonTree string_literal38_tree=null;
        CommonTree NEWLINE40_tree=null;
        CommonTree string_literal42_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:100:2: ( 'foreach' VARIABLE 'in' statement NEWLINE block 'end' -> ^( FOREACH VARIABLE statement block ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:100:4: 'foreach' VARIABLE 'in' statement NEWLINE block 'end'
            {
            string_literal36=(Token)match(input,64,FOLLOW_64_in_foreach_statement525); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_64.add(string_literal36);

            VARIABLE37=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_foreach_statement527); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE37);

            string_literal38=(Token)match(input,65,FOLLOW_65_in_foreach_statement529); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_65.add(string_literal38);

            pushFollow(FOLLOW_statement_in_foreach_statement531);
            statement39=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement39.getTree());
            NEWLINE40=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_foreach_statement533); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE40);

            pushFollow(FOLLOW_block_in_foreach_statement544);
            block41=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block41.getTree());
            string_literal42=(Token)match(input,63,FOLLOW_63_in_foreach_statement552); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(string_literal42);



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
            // 102:12: -> ^( FOREACH VARIABLE statement block )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:102:15: ^( FOREACH VARIABLE statement block )
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:105:1: while_statement : 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) ;
    public final GremlinParser.while_statement_return while_statement() throws RecognitionException {
        GremlinParser.while_statement_return retval = new GremlinParser.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal43=null;
        Token NEWLINE45=null;
        Token string_literal47=null;
        GremlinParser.statement_return statement44 = null;

        GremlinParser.block_return block46 = null;


        CommonTree string_literal43_tree=null;
        CommonTree NEWLINE45_tree=null;
        CommonTree string_literal47_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:106:2: ( 'while' statement NEWLINE block 'end' -> ^( WHILE ^( COND statement ) block ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:106:4: 'while' statement NEWLINE block 'end'
            {
            string_literal43=(Token)match(input,66,FOLLOW_66_in_while_statement576); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_66.add(string_literal43);

            pushFollow(FOLLOW_statement_in_while_statement578);
            statement44=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement44.getTree());
            NEWLINE45=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_while_statement580); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE45);

            pushFollow(FOLLOW_block_in_while_statement591);
            block46=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block46.getTree());
            string_literal47=(Token)match(input,63,FOLLOW_63_in_while_statement599); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(string_literal47);



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
            // 108:12: -> ^( WHILE ^( COND statement ) block )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:108:15: ^( WHILE ^( COND statement ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);

                // com/tinkerpop/gremlin/compiler/Gremlin.g:108:23: ^( COND statement )
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:111:1: repeat_statement : 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) ;
    public final GremlinParser.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinParser.repeat_statement_return retval = new GremlinParser.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal48=null;
        Token NEWLINE50=null;
        Token string_literal52=null;
        GremlinParser.statement_return statement49 = null;

        GremlinParser.block_return block51 = null;


        CommonTree string_literal48_tree=null;
        CommonTree NEWLINE50_tree=null;
        CommonTree string_literal52_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:112:2: ( 'repeat' statement NEWLINE block 'end' -> ^( REPEAT statement block ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:112:4: 'repeat' statement NEWLINE block 'end'
            {
            string_literal48=(Token)match(input,67,FOLLOW_67_in_repeat_statement624); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(string_literal48);

            pushFollow(FOLLOW_statement_in_repeat_statement626);
            statement49=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement49.getTree());
            NEWLINE50=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_repeat_statement628); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE50);

            pushFollow(FOLLOW_block_in_repeat_statement635);
            block51=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block51.getTree());
            string_literal52=(Token)match(input,63,FOLLOW_63_in_repeat_statement639); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(string_literal52);



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
            // 114:9: -> ^( REPEAT statement block )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:114:12: ^( REPEAT statement block )
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:117:1: path_definition_statement : 'path' IDENTIFIER NEWLINE statement NEWLINE 'end' -> ^( PATH IDENTIFIER statement ) ;
    public final GremlinParser.path_definition_statement_return path_definition_statement() throws RecognitionException {
        GremlinParser.path_definition_statement_return retval = new GremlinParser.path_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal53=null;
        Token IDENTIFIER54=null;
        Token NEWLINE55=null;
        Token NEWLINE57=null;
        Token string_literal58=null;
        GremlinParser.statement_return statement56 = null;


        CommonTree string_literal53_tree=null;
        CommonTree IDENTIFIER54_tree=null;
        CommonTree NEWLINE55_tree=null;
        CommonTree NEWLINE57_tree=null;
        CommonTree string_literal58_tree=null;
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:118:2: ( 'path' IDENTIFIER NEWLINE statement NEWLINE 'end' -> ^( PATH IDENTIFIER statement ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:118:4: 'path' IDENTIFIER NEWLINE statement NEWLINE 'end'
            {
            string_literal53=(Token)match(input,68,FOLLOW_68_in_path_definition_statement661); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_68.add(string_literal53);

            IDENTIFIER54=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_path_definition_statement663); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER54);

            NEWLINE55=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_path_definition_statement665); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE55);

            pushFollow(FOLLOW_statement_in_path_definition_statement672);
            statement56=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement56.getTree());
            NEWLINE57=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_path_definition_statement674); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE57);

            string_literal58=(Token)match(input,63,FOLLOW_63_in_path_definition_statement678); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(string_literal58);



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
            // 120:9: -> ^( PATH IDENTIFIER statement )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:120:12: ^( PATH IDENTIFIER statement )
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:123:1: function_definition_statement : 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) ;
    public final GremlinParser.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinParser.function_definition_statement_return retval = new GremlinParser.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal59=null;
        Token char_literal61=null;
        Token char_literal63=null;
        Token NEWLINE64=null;
        Token string_literal66=null;
        GremlinParser.function_name_return function_name60 = null;

        GremlinParser.formal_arguments_return formal_arguments62 = null;

        GremlinParser.block_return block65 = null;


        CommonTree string_literal59_tree=null;
        CommonTree char_literal61_tree=null;
        CommonTree char_literal63_tree=null;
        CommonTree NEWLINE64_tree=null;
        CommonTree string_literal66_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_formal_arguments=new RewriteRuleSubtreeStream(adaptor,"rule formal_arguments");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:124:2: ( 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end' -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:124:4: 'func' function_name '(' ( formal_arguments )* ')' NEWLINE block 'end'
            {
            string_literal59=(Token)match(input,69,FOLLOW_69_in_function_definition_statement700); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal59);

            pushFollow(FOLLOW_function_name_in_function_definition_statement702);
            function_name60=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name60.getTree());
            char_literal61=(Token)match(input,70,FOLLOW_70_in_function_definition_statement704); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(char_literal61);

            // com/tinkerpop/gremlin/compiler/Gremlin.g:124:29: ( formal_arguments )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==VARIABLE) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: formal_arguments
            	    {
            	    pushFollow(FOLLOW_formal_arguments_in_function_definition_statement706);
            	    formal_arguments62=formal_arguments();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_formal_arguments.add(formal_arguments62.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            char_literal63=(Token)match(input,71,FOLLOW_71_in_function_definition_statement709); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(char_literal63);

            NEWLINE64=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_function_definition_statement711); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE64);

            pushFollow(FOLLOW_block_in_function_definition_statement718);
            block65=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block65.getTree());
            string_literal66=(Token)match(input,63,FOLLOW_63_in_function_definition_statement722); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(string_literal66);



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
            // 126:9: -> ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:126:12: ^( FUNC function_name ^( ARGS ( formal_arguments )* ) block )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC, "FUNC"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // com/tinkerpop/gremlin/compiler/Gremlin.g:126:33: ^( ARGS ( formal_arguments )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // com/tinkerpop/gremlin/compiler/Gremlin.g:126:40: ( formal_arguments )*
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:129:1: formal_arguments : VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ ;
    public final GremlinParser.formal_arguments_return formal_arguments() throws RecognitionException {
        GremlinParser.formal_arguments_return retval = new GremlinParser.formal_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLE67=null;
        Token char_literal68=null;
        Token VARIABLE69=null;

        CommonTree VARIABLE67_tree=null;
        CommonTree char_literal68_tree=null;
        CommonTree VARIABLE69_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");

        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:130:2: ( VARIABLE ( ',' VARIABLE )* -> ( ^( ARG VARIABLE ) )+ )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:130:4: VARIABLE ( ',' VARIABLE )*
            {
            VARIABLE67=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments752); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE67);

            // com/tinkerpop/gremlin/compiler/Gremlin.g:130:13: ( ',' VARIABLE )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==72) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:130:14: ',' VARIABLE
            	    {
            	    char_literal68=(Token)match(input,72,FOLLOW_72_in_formal_arguments755); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_72.add(char_literal68);

            	    VARIABLE69=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_formal_arguments757); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE69);


            	    }
            	    break;

            	default :
            	    break loop11;
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
            // 130:29: -> ( ^( ARG VARIABLE ) )+
            {
                if ( !(stream_VARIABLE.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_VARIABLE.hasNext() ) {
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:130:32: ^( ARG VARIABLE )
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:133:1: block : ( statement | NEWLINE )* -> ^( BLOCK ( statement )* ) ;
    public final GremlinParser.block_return block() throws RecognitionException {
        GremlinParser.block_return retval = new GremlinParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE71=null;
        GremlinParser.statement_return statement70 = null;


        CommonTree NEWLINE71_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:134:5: ( ( statement | NEWLINE )* -> ^( BLOCK ( statement )* ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:134:7: ( statement | NEWLINE )*
            {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:134:7: ( statement | NEWLINE )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==NULL||(LA12_0>=VARIABLE && LA12_0<=PROPERTY)||(LA12_0>=61 && LA12_0<=62)||LA12_0==64||(LA12_0>=66 && LA12_0<=70)) ) {
                    alt12=1;
                }
                else if ( (LA12_0==NEWLINE) ) {
                    alt12=2;
                }


                switch (alt12) {
            	case 1 :
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:134:8: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block784);
            	    statement70=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement70.getTree());

            	    }
            	    break;
            	case 2 :
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:134:20: NEWLINE
            	    {
            	    NEWLINE71=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_block788); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NEWLINE.add(NEWLINE71);


            	    }
            	    break;

            	default :
            	    break loop12;
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
            // 134:30: -> ^( BLOCK ( statement )* )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:134:33: ^( BLOCK ( statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                // com/tinkerpop/gremlin/compiler/Gremlin.g:134:41: ( statement )*
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:137:1: expression : operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* ;
    public final GremlinParser.expression_return expression() throws RecognitionException {
        GremlinParser.expression_return retval = new GremlinParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal73=null;
        Token string_literal74=null;
        Token char_literal75=null;
        Token string_literal76=null;
        Token char_literal77=null;
        Token string_literal78=null;
        GremlinParser.operation_return operation72 = null;

        GremlinParser.operation_return operation79 = null;


        CommonTree char_literal73_tree=null;
        CommonTree string_literal74_tree=null;
        CommonTree char_literal75_tree=null;
        CommonTree string_literal76_tree=null;
        CommonTree char_literal77_tree=null;
        CommonTree string_literal78_tree=null;

        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:138:2: ( operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )* )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:138:4: operation ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_operation_in_expression811);
            operation72=operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, operation72.getTree());
            // com/tinkerpop/gremlin/compiler/Gremlin.g:138:14: ( ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=73 && LA14_0<=78)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:138:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' ) operation
            	    {
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:138:15: ( '=' | '!=' | '<' | '<=' | '>' | '>=' )
            	    int alt13=6;
            	    switch ( input.LA(1) ) {
            	    case 73:
            	        {
            	        alt13=1;
            	        }
            	        break;
            	    case 74:
            	        {
            	        alt13=2;
            	        }
            	        break;
            	    case 75:
            	        {
            	        alt13=3;
            	        }
            	        break;
            	    case 76:
            	        {
            	        alt13=4;
            	        }
            	        break;
            	    case 77:
            	        {
            	        alt13=5;
            	        }
            	        break;
            	    case 78:
            	        {
            	        alt13=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt13) {
            	        case 1 :
            	            // com/tinkerpop/gremlin/compiler/Gremlin.g:138:16: '='
            	            {
            	            char_literal73=(Token)match(input,73,FOLLOW_73_in_expression815); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal73_tree = (CommonTree)adaptor.create(char_literal73);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal73_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com/tinkerpop/gremlin/compiler/Gremlin.g:138:23: '!='
            	            {
            	            string_literal74=(Token)match(input,74,FOLLOW_74_in_expression820); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal74_tree = (CommonTree)adaptor.create(string_literal74);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal74_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // com/tinkerpop/gremlin/compiler/Gremlin.g:138:31: '<'
            	            {
            	            char_literal75=(Token)match(input,75,FOLLOW_75_in_expression825); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal75_tree = (CommonTree)adaptor.create(char_literal75);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal75_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // com/tinkerpop/gremlin/compiler/Gremlin.g:138:38: '<='
            	            {
            	            string_literal76=(Token)match(input,76,FOLLOW_76_in_expression830); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal76_tree = (CommonTree)adaptor.create(string_literal76);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal76_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // com/tinkerpop/gremlin/compiler/Gremlin.g:138:46: '>'
            	            {
            	            char_literal77=(Token)match(input,77,FOLLOW_77_in_expression835); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal77_tree = (CommonTree)adaptor.create(char_literal77);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal77_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // com/tinkerpop/gremlin/compiler/Gremlin.g:138:53: '>='
            	            {
            	            string_literal78=(Token)match(input,78,FOLLOW_78_in_expression840); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal78_tree = (CommonTree)adaptor.create(string_literal78);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal78_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_operation_in_expression844);
            	    operation79=operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, operation79.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:141:1: operation : binary_operation ( ( '+' | '-' ) binary_operation )* ;
    public final GremlinParser.operation_return operation() throws RecognitionException {
        GremlinParser.operation_return retval = new GremlinParser.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal81=null;
        Token char_literal82=null;
        GremlinParser.binary_operation_return binary_operation80 = null;

        GremlinParser.binary_operation_return binary_operation83 = null;


        CommonTree char_literal81_tree=null;
        CommonTree char_literal82_tree=null;

        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:142:2: ( binary_operation ( ( '+' | '-' ) binary_operation )* )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:142:4: binary_operation ( ( '+' | '-' ) binary_operation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_binary_operation_in_operation858);
            binary_operation80=binary_operation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation80.getTree());
            // com/tinkerpop/gremlin/compiler/Gremlin.g:142:21: ( ( '+' | '-' ) binary_operation )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=79 && LA16_0<=80)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:142:22: ( '+' | '-' ) binary_operation
            	    {
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:142:22: ( '+' | '-' )
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==79) ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0==80) ) {
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
            	            // com/tinkerpop/gremlin/compiler/Gremlin.g:142:23: '+'
            	            {
            	            char_literal81=(Token)match(input,79,FOLLOW_79_in_operation862); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal81_tree = (CommonTree)adaptor.create(char_literal81);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal81_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com/tinkerpop/gremlin/compiler/Gremlin.g:142:28: '-'
            	            {
            	            char_literal82=(Token)match(input,80,FOLLOW_80_in_operation865); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal82_tree = (CommonTree)adaptor.create(char_literal82);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal82_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_binary_operation_in_operation869);
            	    binary_operation83=binary_operation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, binary_operation83.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:145:1: binary_operation : atom ( ( '*' | 'div' ) atom )* ;
    public final GremlinParser.binary_operation_return binary_operation() throws RecognitionException {
        GremlinParser.binary_operation_return retval = new GremlinParser.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal85=null;
        Token string_literal86=null;
        GremlinParser.atom_return atom84 = null;

        GremlinParser.atom_return atom87 = null;


        CommonTree char_literal85_tree=null;
        CommonTree string_literal86_tree=null;

        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:146:2: ( atom ( ( '*' | 'div' ) atom )* )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:146:4: atom ( ( '*' | 'div' ) atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_binary_operation883);
            atom84=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom84.getTree());
            // com/tinkerpop/gremlin/compiler/Gremlin.g:146:9: ( ( '*' | 'div' ) atom )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=81 && LA18_0<=82)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:146:10: ( '*' | 'div' ) atom
            	    {
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:146:10: ( '*' | 'div' )
            	    int alt17=2;
            	    int LA17_0 = input.LA(1);

            	    if ( (LA17_0==81) ) {
            	        alt17=1;
            	    }
            	    else if ( (LA17_0==82) ) {
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
            	            // com/tinkerpop/gremlin/compiler/Gremlin.g:146:11: '*'
            	            {
            	            char_literal85=(Token)match(input,81,FOLLOW_81_in_binary_operation887); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal85_tree = (CommonTree)adaptor.create(char_literal85);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal85_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com/tinkerpop/gremlin/compiler/Gremlin.g:146:16: 'div'
            	            {
            	            string_literal86=(Token)match(input,82,FOLLOW_82_in_binary_operation890); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal86_tree = (CommonTree)adaptor.create(string_literal86);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal86_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_atom_in_binary_operation894);
            	    atom87=atom();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom87.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:149:1: function_call : function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) ;
    public final GremlinParser.function_call_return function_call() throws RecognitionException {
        GremlinParser.function_call_return retval = new GremlinParser.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal89=null;
        Token char_literal91=null;
        GremlinParser.function_name_return function_name88 = null;

        GremlinParser.function_call_params_return function_call_params90 = null;


        CommonTree char_literal89_tree=null;
        CommonTree char_literal91_tree=null;
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleSubtreeStream stream_function_call_params=new RewriteRuleSubtreeStream(adaptor,"rule function_call_params");
        RewriteRuleSubtreeStream stream_function_name=new RewriteRuleSubtreeStream(adaptor,"rule function_name");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:150:2: ( function_name '(' ( function_call_params )* ')' -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:150:4: function_name '(' ( function_call_params )* ')'
            {
            pushFollow(FOLLOW_function_name_in_function_call908);
            function_name88=function_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function_name.add(function_name88.getTree());
            char_literal89=(Token)match(input,70,FOLLOW_70_in_function_call910); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(char_literal89);

            // com/tinkerpop/gremlin/compiler/Gremlin.g:150:22: ( function_call_params )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==NULL||(LA19_0>=VARIABLE && LA19_0<=PROPERTY)||(LA19_0>=61 && LA19_0<=62)||LA19_0==64||(LA19_0>=66 && LA19_0<=70)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:0:0: function_call_params
            	    {
            	    pushFollow(FOLLOW_function_call_params_in_function_call912);
            	    function_call_params90=function_call_params();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function_call_params.add(function_call_params90.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            char_literal91=(Token)match(input,71,FOLLOW_71_in_function_call915); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(char_literal91);



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
            // 150:48: -> ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:150:51: ^( FUNC_CALL function_name ^( ARGS ( function_call_params )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                adaptor.addChild(root_1, stream_function_name.nextTree());
                // com/tinkerpop/gremlin/compiler/Gremlin.g:150:77: ^( ARGS ( function_call_params )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                // com/tinkerpop/gremlin/compiler/Gremlin.g:150:84: ( function_call_params )*
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:153:1: function_name : ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) ;
    public final GremlinParser.function_name_return function_name() throws RecognitionException {
        GremlinParser.function_name_return retval = new GremlinParser.function_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ns=null;
        Token ln=null;
        Token char_literal92=null;

        CommonTree ns_tree=null;
        CommonTree ln_tree=null;
        CommonTree char_literal92_tree=null;
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:154:2: (ns= IDENTIFIER ':' ln= IDENTIFIER -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) ) )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:154:4: ns= IDENTIFIER ':' ln= IDENTIFIER
            {
            ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name944); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(ns);

            char_literal92=(Token)match(input,83,FOLLOW_83_in_function_name946); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(char_literal92);

            ln=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_name950); if (state.failed) return retval; 
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
            // 154:36: -> ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
            {
                // com/tinkerpop/gremlin/compiler/Gremlin.g:154:39: ^( FUNC_NAME ^( NS $ns) ^( NAME $ln) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_NAME, "FUNC_NAME"), root_1);

                // com/tinkerpop/gremlin/compiler/Gremlin.g:154:51: ^( NS $ns)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NS, "NS"), root_2);

                adaptor.addChild(root_2, stream_ns.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // com/tinkerpop/gremlin/compiler/Gremlin.g:154:61: ^( NAME $ln)
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:157:1: function_call_params : statement ( ',' statement )* -> ( ^( ARG statement ) )+ ;
    public final GremlinParser.function_call_params_return function_call_params() throws RecognitionException {
        GremlinParser.function_call_params_return retval = new GremlinParser.function_call_params_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal94=null;
        GremlinParser.statement_return statement93 = null;

        GremlinParser.statement_return statement95 = null;


        CommonTree char_literal94_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:158:2: ( statement ( ',' statement )* -> ( ^( ARG statement ) )+ )
            // com/tinkerpop/gremlin/compiler/Gremlin.g:158:4: statement ( ',' statement )*
            {
            pushFollow(FOLLOW_statement_in_function_call_params985);
            statement93=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement93.getTree());
            // com/tinkerpop/gremlin/compiler/Gremlin.g:158:14: ( ',' statement )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==72) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // com/tinkerpop/gremlin/compiler/Gremlin.g:158:15: ',' statement
            	    {
            	    char_literal94=(Token)match(input,72,FOLLOW_72_in_function_call_params988); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_72.add(char_literal94);

            	    pushFollow(FOLLOW_statement_in_function_call_params990);
            	    statement95=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement95.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
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
            // 158:31: -> ( ^( ARG statement ) )+
            {
                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:158:34: ^( ARG statement )
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
    // com/tinkerpop/gremlin/compiler/Gremlin.g:161:1: atom : ( NUMBER -> ^( NUM NUMBER ) | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | function_call | '(' statement ')' );
    public final GremlinParser.atom_return atom() throws RecognitionException {
        GremlinParser.atom_return retval = new GremlinParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token b=null;
        Token NUMBER96=null;
        Token StringLiteral97=null;
        Token NULL98=null;
        Token PROPERTY99=null;
        Token VARIABLE100=null;
        Token IDENTIFIER101=null;
        Token char_literal103=null;
        Token char_literal105=null;
        GremlinParser.function_call_return function_call102 = null;

        GremlinParser.statement_return statement104 = null;


        CommonTree b_tree=null;
        CommonTree NUMBER96_tree=null;
        CommonTree StringLiteral97_tree=null;
        CommonTree NULL98_tree=null;
        CommonTree PROPERTY99_tree=null;
        CommonTree VARIABLE100_tree=null;
        CommonTree IDENTIFIER101_tree=null;
        CommonTree char_literal103_tree=null;
        CommonTree char_literal105_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_BOOLEAN=new RewriteRuleTokenStream(adaptor,"token BOOLEAN");
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_PROPERTY=new RewriteRuleTokenStream(adaptor,"token PROPERTY");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com/tinkerpop/gremlin/compiler/Gremlin.g:162:2: ( NUMBER -> ^( NUM NUMBER ) | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | function_call | '(' statement ')' )
            int alt21=9;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:162:4: NUMBER
                    {
                    NUMBER96=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_atom1013); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER96);



                    // AST REWRITE
                    // elements: NUMBER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 162:16: -> ^( NUM NUMBER )
                    {
                        // com/tinkerpop/gremlin/compiler/Gremlin.g:162:19: ^( NUM NUMBER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUM, "NUM"), root_1);

                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:163:4: StringLiteral
                    {
                    StringLiteral97=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_atom1031); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral97);



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
                    // 163:18: -> ^( STR StringLiteral )
                    {
                        // com/tinkerpop/gremlin/compiler/Gremlin.g:163:21: ^( STR StringLiteral )
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
                case 3 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:164:9: b= BOOLEAN
                    {
                    b=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_atom1051); if (state.failed) return retval; 
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
                    // 164:25: -> ^( BOOL $b)
                    {
                        // com/tinkerpop/gremlin/compiler/Gremlin.g:164:28: ^( BOOL $b)
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
                case 4 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:165:9: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NULL98=(Token)match(input,NULL,FOLLOW_NULL_in_atom1076); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL98_tree = (CommonTree)adaptor.create(NULL98);
                    adaptor.addChild(root_0, NULL98_tree);
                    }

                    }
                    break;
                case 5 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:166:4: PROPERTY
                    {
                    PROPERTY99=(Token)match(input,PROPERTY,FOLLOW_PROPERTY_in_atom1081); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROPERTY.add(PROPERTY99);



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
                    // 166:17: -> ^( PROPERTY_CALL PROPERTY )
                    {
                        // com/tinkerpop/gremlin/compiler/Gremlin.g:166:20: ^( PROPERTY_CALL PROPERTY )
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
                case 6 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:167:4: VARIABLE
                    {
                    VARIABLE100=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_atom1098); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE100);



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
                    // 167:20: -> ^( VARIABLE_CALL VARIABLE )
                    {
                        // com/tinkerpop/gremlin/compiler/Gremlin.g:167:23: ^( VARIABLE_CALL VARIABLE )
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
                case 7 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:168:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IDENTIFIER101=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atom1118); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER101_tree = (CommonTree)adaptor.create(IDENTIFIER101);
                    adaptor.addChild(root_0, IDENTIFIER101_tree);
                    }

                    }
                    break;
                case 8 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:169:4: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_call_in_atom1123);
                    function_call102=function_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_call102.getTree());

                    }
                    break;
                case 9 :
                    // com/tinkerpop/gremlin/compiler/Gremlin.g:170:4: '(' statement ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal103=(Token)match(input,70,FOLLOW_70_in_atom1128); if (state.failed) return retval;
                    pushFollow(FOLLOW_statement_in_atom1131);
                    statement104=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement104.getTree());
                    char_literal105=(Token)match(input,71,FOLLOW_71_in_atom1133); if (state.failed) return retval;

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

    // $ANTLR start synpred14_Gremlin
    public final void synpred14_Gremlin_fragment() throws RecognitionException {   
        // com/tinkerpop/gremlin/compiler/Gremlin.g:84:4: ( gpath_statement )
        // com/tinkerpop/gremlin/compiler/Gremlin.g:84:4: gpath_statement
        {
        pushFollow(FOLLOW_gpath_statement_in_synpred14_Gremlin400);
        gpath_statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_Gremlin

    // $ANTLR start synpred15_Gremlin
    public final void synpred15_Gremlin_fragment() throws RecognitionException {   
        // com/tinkerpop/gremlin/compiler/Gremlin.g:85:4: ( VARIABLE ':=' statement )
        // com/tinkerpop/gremlin/compiler/Gremlin.g:85:4: VARIABLE ':=' statement
        {
        match(input,VARIABLE,FOLLOW_VARIABLE_in_synpred15_Gremlin405); if (state.failed) return ;
        match(input,58,FOLLOW_58_in_synpred15_Gremlin407); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred15_Gremlin409);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_Gremlin

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
    public final boolean synpred14_Gremlin() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_Gremlin_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA9_eotS =
        "\23\uffff";
    static final String DFA9_eofS =
        "\23\uffff";
    static final String DFA9_minS =
        "\1\37\7\uffff\10\0\3\uffff";
    static final String DFA9_maxS =
        "\1\106\7\uffff\10\0\3\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\10\uffff\1\10\1\12\1\11";
    static final String DFA9_specialS =
        "\10\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\3\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\13\5\uffff\1\15\1\11\1\16\1\10\1\12\1\14\22\uffff\1\7\1\1"+
            "\1\uffff\1\2\1\uffff\1\3\1\4\1\5\1\6\1\17",
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
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "76:1: statement : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | VARIABLE ':=' statement -> ^( VAR VARIABLE statement ) | expression ( ( 'and' | 'or' ) expression )* );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_8 = input.LA(1);

                         
                        int index9_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_Gremlin()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index9_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_9 = input.LA(1);

                         
                        int index9_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_Gremlin()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index9_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_10 = input.LA(1);

                         
                        int index9_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_Gremlin()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index9_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_11 = input.LA(1);

                         
                        int index9_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_Gremlin()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index9_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_12 = input.LA(1);

                         
                        int index9_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_Gremlin()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index9_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA9_13 = input.LA(1);

                         
                        int index9_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_Gremlin()) ) {s = 16;}

                        else if ( (synpred15_Gremlin()) ) {s = 18;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index9_13);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA9_14 = input.LA(1);

                         
                        int index9_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_Gremlin()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index9_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA9_15 = input.LA(1);

                         
                        int index9_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_Gremlin()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index9_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA21_eotS =
        "\13\uffff";
    static final String DFA21_eofS =
        "\7\uffff\1\12\3\uffff";
    static final String DFA21_minS =
        "\1\37\6\uffff\1\37\3\uffff";
    static final String DFA21_maxS =
        "\1\106\6\uffff\1\123\3\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\11\1\10\1\7";
    static final String DFA21_specialS =
        "\13\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\4\5\uffff\1\6\1\2\1\7\1\1\1\3\1\5\33\uffff\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\4\uffff\7\12\14\uffff\3\12\1\uffff\6\12\1\uffff\21\12"+
            "\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "161:1: atom : ( NUMBER -> ^( NUM NUMBER ) | StringLiteral -> ^( STR StringLiteral ) | b= BOOLEAN -> ^( BOOL $b) | NULL | PROPERTY -> ^( PROPERTY_CALL PROPERTY ) | VARIABLE -> ^( VARIABLE_CALL VARIABLE ) | IDENTIFIER | function_call | '(' statement ')' );";
        }
    }
 

    public static final BitSet FOLLOW_COMMENT_in_program214 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_statement_in_program226 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_program229 = new BitSet(new long[]{0x600007F080000002L,0x000000000000007DL});
    public static final BitSet FOLLOW_step_in_gpath_statement266 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_gpath_statement268 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_step_in_gpath_statement270 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_gpath_statement273 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_step_in_gpath_statement275 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_token_in_step301 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_56_in_step304 = new BitSet(new long[]{0x600007E080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_statement_in_step306 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_step308 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_expression_in_token349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_definition_statement_in_statement385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_statement400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_statement405 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_statement407 = new BitSet(new long[]{0x600007E080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_statement_in_statement409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement424 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_59_in_statement428 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_60_in_statement431 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_expression_in_statement435 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_61_in_include_statement448 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_if_statement471 = new BitSet(new long[]{0x600007E080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_statement_in_if_statement473 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_if_statement475 = new BitSet(new long[]{0xE00007F080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_block_in_if_statement489 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_if_statement500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_foreach_statement525 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement527 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_foreach_statement529 = new BitSet(new long[]{0x600007E080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_statement_in_foreach_statement531 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_foreach_statement533 = new BitSet(new long[]{0xE00007F080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_block_in_foreach_statement544 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_foreach_statement552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_while_statement576 = new BitSet(new long[]{0x600007E080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_statement_in_while_statement578 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_while_statement580 = new BitSet(new long[]{0xE00007F080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_block_in_while_statement591 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_while_statement599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_repeat_statement624 = new BitSet(new long[]{0x600007E080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_statement_in_repeat_statement626 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_repeat_statement628 = new BitSet(new long[]{0xE00007F080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_block_in_repeat_statement635 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_repeat_statement639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_path_definition_statement661 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_path_definition_statement663 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_path_definition_statement665 = new BitSet(new long[]{0x600007E080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_statement_in_path_definition_statement672 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_path_definition_statement674 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_path_definition_statement678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_function_definition_statement700 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_function_name_in_function_definition_statement702 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_function_definition_statement704 = new BitSet(new long[]{0x0000002000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_formal_arguments_in_function_definition_statement706 = new BitSet(new long[]{0x0000002000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_function_definition_statement709 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NEWLINE_in_function_definition_statement711 = new BitSet(new long[]{0xE00007F080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_block_in_function_definition_statement718 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_function_definition_statement722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments752 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_formal_arguments755 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_VARIABLE_in_formal_arguments757 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_statement_in_block784 = new BitSet(new long[]{0x600007F080000002L,0x000000000000007DL});
    public static final BitSet FOLLOW_NEWLINE_in_block788 = new BitSet(new long[]{0x600007F080000002L,0x000000000000007DL});
    public static final BitSet FOLLOW_operation_in_expression811 = new BitSet(new long[]{0x0000000000000002L,0x0000000000007E00L});
    public static final BitSet FOLLOW_73_in_expression815 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_74_in_expression820 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_75_in_expression825 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_76_in_expression830 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_77_in_expression835 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_78_in_expression840 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_operation_in_expression844 = new BitSet(new long[]{0x0000000000000002L,0x0000000000007E00L});
    public static final BitSet FOLLOW_binary_operation_in_operation858 = new BitSet(new long[]{0x0000000000000002L,0x0000000000018000L});
    public static final BitSet FOLLOW_79_in_operation862 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_80_in_operation865 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_binary_operation_in_operation869 = new BitSet(new long[]{0x0000000000000002L,0x0000000000018000L});
    public static final BitSet FOLLOW_atom_in_binary_operation883 = new BitSet(new long[]{0x0000000000000002L,0x0000000000060000L});
    public static final BitSet FOLLOW_81_in_binary_operation887 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_82_in_binary_operation890 = new BitSet(new long[]{0x000007E080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_atom_in_binary_operation894 = new BitSet(new long[]{0x0000000000000002L,0x0000000000060000L});
    public static final BitSet FOLLOW_function_name_in_function_call908 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_function_call910 = new BitSet(new long[]{0x600007E080000000L,0x00000000000000FDL});
    public static final BitSet FOLLOW_function_call_params_in_function_call912 = new BitSet(new long[]{0x600007E080000000L,0x00000000000000FDL});
    public static final BitSet FOLLOW_71_in_function_call915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_function_name946 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_name950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_function_call_params985 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_function_call_params988 = new BitSet(new long[]{0x600007E080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_statement_in_function_call_params990 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_atom1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_atom1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_atom1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_atom1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROPERTY_in_atom1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_atom1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_atom1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_atom1128 = new BitSet(new long[]{0x600007E080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_statement_in_atom1131 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_atom1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_synpred14_Gremlin400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_synpred15_Gremlin405 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_synpred15_Gremlin407 = new BitSet(new long[]{0x600007E080000000L,0x000000000000007DL});
    public static final BitSet FOLLOW_statement_in_synpred15_Gremlin409 = new BitSet(new long[]{0x0000000000000002L});

}
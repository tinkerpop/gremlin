// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g 2010-07-05 19:31:58

package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.gremlin.Gremlin;
import com.tinkerpop.gremlin.compiler.functions.NativeFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import com.tinkerpop.gremlin.compiler.operations.logic.*;
import com.tinkerpop.gremlin.compiler.operations.math.Addition;
import com.tinkerpop.gremlin.compiler.operations.math.Division;
import com.tinkerpop.gremlin.compiler.operations.math.Multiplication;
import com.tinkerpop.gremlin.compiler.operations.math.Subtraction;
import com.tinkerpop.gremlin.compiler.operations.util.DeclareVariable;
import com.tinkerpop.gremlin.compiler.operations.util.GPathOperation;
import com.tinkerpop.gremlin.compiler.pipes.GremlinPipesHelper;
import com.tinkerpop.gremlin.compiler.statements.Foreach;
import com.tinkerpop.gremlin.compiler.statements.If;
import com.tinkerpop.gremlin.compiler.statements.Repeat;
import com.tinkerpop.gremlin.compiler.statements.While;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.pgm.PropertyPipe;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class GremlinEvaluator extends TreeParser {
    public static final String[] tokenNames = new String[]{
            "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VAR", "ARG", "ARGS", "FUNC", "NS", "NAME", "FUNC_NAME", "PATH", "GPATH", "STEP", "TOKEN", "PREDICATE", "PREDICATES", "SELF", "HISTORY", "FUNC_CALL", "IF", "COND", "BLOCK", "FOREACH", "WHILE", "REPEAT", "INCLUDE", "NUM", "STR", "ARR", "BOOL", "NULL", "ARR_IDX", "PROPERTY_CALL", "VARIABLE_CALL", "COMMENT", "NEWLINE", "VARIABLE", "StringLiteral", "IDENTIFIER", "NUMBER", "BOOLEAN", "PROPERTY", "DoubleStringCharacter", "SingleStringCharacter", "WS", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "'/'", "'['", "']'", "':='", "'and'", "'or'", "'include'", "'if'", "'end'", "'foreach'", "'in'", "'while'", "'repeat'", "'path'", "'func'", "'('", "')'", "','", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'div'", "':'"
    };
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


    public GremlinEvaluator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }

    public GremlinEvaluator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);

    }

    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }

    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() {
        return GremlinEvaluator.tokenNames;
    }

    public String getGrammarFileName() {
        return "src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g";
    }


    public static boolean DEBUG = false;

    private static VariableLibrary variables = new VariableLibrary();
    public static FunctionLibrary functions = new FunctionLibrary();
    public static PathLibrary paths = new PathLibrary();

    public static void declareVariable(String name, Atom value) {
        variables.declare(name, value);
    }

    public static Atom getVariable(String name) {
        return variables.get(name);
    }

    public static void freeVariable(String name) {
        variables.free(name);
    }

    public static VariableLibrary getVariableLibrary() {
        return variables;
    }

    public static void setVariableLibrary(VariableLibrary lib) {
        variables = lib;
    }


    public static class program_return extends TreeRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "program"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:72:1: program : ( statement ( NEWLINE )* )+ ;
    public final GremlinEvaluator.program_return program() throws RecognitionException {
        GremlinEvaluator.program_return retval = new GremlinEvaluator.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NEWLINE2 = null;
        GremlinEvaluator.statement_return statement1 = null;


        CommonTree NEWLINE2_tree = null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:73:5: ( ( statement ( NEWLINE )* )+ )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:73:9: ( statement ( NEWLINE )* )+
            {
                root_0 = (CommonTree) adaptor.nil();

                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:73:9: ( statement ( NEWLINE )* )+
                int cnt2 = 0;
                loop2:
                do {
                    int alt2 = 2;
                    int LA2_0 = input.LA(1);

                    if ((LA2_0 == VAR || LA2_0 == FUNC || (LA2_0 >= PATH && LA2_0 <= GPATH) || (LA2_0 >= FUNC_CALL && LA2_0 <= IF) || (LA2_0 >= FOREACH && LA2_0 <= NULL) || (LA2_0 >= PROPERTY_CALL && LA2_0 <= VARIABLE_CALL) || LA2_0 == IDENTIFIER || (LA2_0 >= 59 && LA2_0 <= 60) || LA2_0 == 70 || (LA2_0 >= 73 && LA2_0 <= 82))) {
                        alt2 = 1;
                    }


                    switch (alt2) {
                        case 1:
                            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:73:10: statement ( NEWLINE )*
                        {
                            _last = (CommonTree) input.LT(1);
                            pushFollow(FOLLOW_statement_in_program48);
                            statement1 = statement();

                            state._fsp--;

                            adaptor.addChild(root_0, statement1.getTree());

                            Atom result = (statement1 != null ? statement1.op : null).compute();

                            if (!result.isNull() && DEBUG) {
                                if (result.isList()) {
                                    for (Object o : (ArrayList) result.getValue()) {
                                        System.out.println(Tokens.RESULT_PROMPT + o);
                                    }
                                } else {
                                    System.out.println(Tokens.RESULT_PROMPT + result);
                                }
                            }


                            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:86:22: ( NEWLINE )*
                            loop1:
                            do {
                                int alt1 = 2;
                                int LA1_0 = input.LA(1);

                                if ((LA1_0 == NEWLINE)) {
                                    alt1 = 1;
                                }


                                switch (alt1) {
                                    case 1:
                                        // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:86:22: NEWLINE
                                    {
                                        _last = (CommonTree) input.LT(1);
                                        NEWLINE2 = (CommonTree) match(input, NEWLINE, FOLLOW_NEWLINE_in_program52);
                                        NEWLINE2_tree = (CommonTree) adaptor.dupNode(NEWLINE2);

                                        adaptor.addChild(root_0, NEWLINE2_tree);


                                    }
                                    break;

                                    default:
                                        break loop1;
                                }
                            } while (true);


                        }
                        break;

                        default:
                            if (cnt2 >= 1) break loop2;
                            EarlyExitException eee =
                                    new EarlyExitException(2, input);
                            throw eee;
                    }
                    cnt2++;
                } while (true);


            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:89:1: statement returns [Operation op] : ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | ^( VAR VARIABLE s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression );
    public final GremlinEvaluator.statement_return statement() throws RecognitionException {
        GremlinEvaluator.statement_return retval = new GremlinEvaluator.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree VAR11 = null;
        CommonTree VARIABLE12 = null;
        CommonTree string_literal13 = null;
        CommonTree string_literal14 = null;
        GremlinEvaluator.statement_return s = null;

        GremlinEvaluator.statement_return a = null;

        GremlinEvaluator.statement_return b = null;

        GremlinEvaluator.if_statement_return if_statement3 = null;

        GremlinEvaluator.foreach_statement_return foreach_statement4 = null;

        GremlinEvaluator.while_statement_return while_statement5 = null;

        GremlinEvaluator.repeat_statement_return repeat_statement6 = null;

        GremlinEvaluator.path_definition_statement_return path_definition_statement7 = null;

        GremlinEvaluator.function_definition_statement_return function_definition_statement8 = null;

        GremlinEvaluator.include_statement_return include_statement9 = null;

        GremlinEvaluator.gpath_statement_return gpath_statement10 = null;

        GremlinEvaluator.expression_return expression15 = null;


        CommonTree VAR11_tree = null;
        CommonTree VARIABLE12_tree = null;
        CommonTree string_literal13_tree = null;
        CommonTree string_literal14_tree = null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:90:2: ( if_statement | foreach_statement | while_statement | repeat_statement | path_definition_statement | function_definition_statement | include_statement | gpath_statement | ^( VAR VARIABLE s= statement ) | ^( 'and' a= statement b= statement ) | ^( 'or' a= statement b= statement ) | expression )
            int alt3 = 12;
            switch (input.LA(1)) {
                case IF: {
                    alt3 = 1;
                }
                break;
                case FOREACH: {
                    alt3 = 2;
                }
                break;
                case WHILE: {
                    alt3 = 3;
                }
                break;
                case REPEAT: {
                    alt3 = 4;
                }
                break;
                case PATH: {
                    alt3 = 5;
                }
                break;
                case FUNC: {
                    alt3 = 6;
                }
                break;
                case INCLUDE: {
                    alt3 = 7;
                }
                break;
                case GPATH: {
                    alt3 = 8;
                }
                break;
                case VAR: {
                    alt3 = 9;
                }
                break;
                case 59: {
                    alt3 = 10;
                }
                break;
                case 60: {
                    alt3 = 11;
                }
                break;
                case FUNC_CALL:
                case NUM:
                case STR:
                case ARR:
                case BOOL:
                case NULL:
                case PROPERTY_CALL:
                case VARIABLE_CALL:
                case IDENTIFIER:
                case 70:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82: {
                    alt3 = 12;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                    throw nvae;
            }

            switch (alt3) {
                case 1:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:90:4: if_statement
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_if_statement_in_statement73);
                    if_statement3 = if_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, if_statement3.getTree());
                    retval.op = (if_statement3 != null ? if_statement3.op : null);

                }
                break;
                case 2:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:91:4: foreach_statement
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_foreach_statement_in_statement103);
                    foreach_statement4 = foreach_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, foreach_statement4.getTree());
                    retval.op = (foreach_statement4 != null ? foreach_statement4.op : null);

                }
                break;
                case 3:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:92:7: while_statement
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_while_statement_in_statement131);
                    while_statement5 = while_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, while_statement5.getTree());
                    retval.op = (while_statement5 != null ? while_statement5.op : null);

                }
                break;
                case 4:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:93:4: repeat_statement
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_repeat_statement_in_statement158);
                    repeat_statement6 = repeat_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, repeat_statement6.getTree());
                    retval.op = (repeat_statement6 != null ? repeat_statement6.op : null);

                }
                break;
                case 5:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:94:4: path_definition_statement
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_path_definition_statement_in_statement184);
                    path_definition_statement7 = path_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, path_definition_statement7.getTree());
                    retval.op = (path_definition_statement7 != null ? path_definition_statement7.op : null);

                }
                break;
                case 6:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:95:4: function_definition_statement
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_function_definition_statement_in_statement201);
                    function_definition_statement8 = function_definition_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, function_definition_statement8.getTree());
                    retval.op = (function_definition_statement8 != null ? function_definition_statement8.op : null);

                }
                break;
                case 7:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:96:4: include_statement
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_include_statement_in_statement214);
                    include_statement9 = include_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, include_statement9.getTree());
                    retval.op = new UnaryOperation((include_statement9 != null ? include_statement9.result : null));

                }
                break;
                case 8:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:97:4: gpath_statement
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_gpath_statement_in_statement239);
                    gpath_statement10 = gpath_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, gpath_statement10.getTree());
                    retval.op = (gpath_statement10 != null ? gpath_statement10.op : null);

                }
                break;
                case 9:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:98:4: ^( VAR VARIABLE s= statement )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        VAR11 = (CommonTree) match(input, VAR, FOLLOW_VAR_in_statement267);
                        VAR11_tree = (CommonTree) adaptor.dupNode(VAR11);

                        root_1 = (CommonTree) adaptor.becomeRoot(VAR11_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        VARIABLE12 = (CommonTree) match(input, VARIABLE, FOLLOW_VARIABLE_in_statement269);
                        VARIABLE12_tree = (CommonTree) adaptor.dupNode(VARIABLE12);

                        adaptor.addChild(root_1, VARIABLE12_tree);

                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_statement_in_statement273);
                        s = statement();

                        state._fsp--;

                        adaptor.addChild(root_1, s.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.op = new DeclareVariable((VARIABLE12 != null ? VARIABLE12.getText() : null), (s != null ? s.op : null));

                }
                break;
                case 10:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:99:9: ^( 'and' a= statement b= statement )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        string_literal13 = (CommonTree) match(input, 59, FOLLOW_59_in_statement295);
                        string_literal13_tree = (CommonTree) adaptor.dupNode(string_literal13);

                        root_1 = (CommonTree) adaptor.becomeRoot(string_literal13_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_statement_in_statement299);
                        a = statement();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_statement_in_statement303);
                        b = statement();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.op = new And((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 11:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:100:9: ^( 'or' a= statement b= statement )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        string_literal14 = (CommonTree) match(input, 60, FOLLOW_60_in_statement320);
                        string_literal14_tree = (CommonTree) adaptor.dupNode(string_literal14);

                        root_1 = (CommonTree) adaptor.becomeRoot(string_literal14_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_statement_in_statement325);
                        a = statement();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_statement_in_statement329);
                        b = statement();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.op = new Or((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 12:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:101:9: expression
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement345);
                    expression15 = expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression15.getTree());
                    retval.op = (expression15 != null ? expression15.expr : null);

                }
                break;

            }
            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class include_statement_return extends TreeRuleReturnScope {
        public Atom result;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "include_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:104:1: include_statement returns [Atom result] : ^( INCLUDE StringLiteral ) ;
    public final GremlinEvaluator.include_statement_return include_statement() throws RecognitionException {
        GremlinEvaluator.include_statement_return retval = new GremlinEvaluator.include_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INCLUDE16 = null;
        CommonTree StringLiteral17 = null;

        CommonTree INCLUDE16_tree = null;
        CommonTree StringLiteral17_tree = null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:105:2: ( ^( INCLUDE StringLiteral ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:105:4: ^( INCLUDE StringLiteral )
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree) adaptor.nil();
                    _last = (CommonTree) input.LT(1);
                    INCLUDE16 = (CommonTree) match(input, INCLUDE, FOLLOW_INCLUDE_in_include_statement388);
                    INCLUDE16_tree = (CommonTree) adaptor.dupNode(INCLUDE16);

                    root_1 = (CommonTree) adaptor.becomeRoot(INCLUDE16_tree, root_1);


                    match(input, Token.DOWN, null);
                    _last = (CommonTree) input.LT(1);
                    StringLiteral17 = (CommonTree) match(input, StringLiteral, FOLLOW_StringLiteral_in_include_statement390);
                    StringLiteral17_tree = (CommonTree) adaptor.dupNode(StringLiteral17);

                    adaptor.addChild(root_1, StringLiteral17_tree);


                    match(input, Token.UP, null);
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }


                retval.result = new Atom(true);

                String filename = (StringLiteral17 != null ? StringLiteral17.getText() : null);
                try {
                    ANTLRFileStream file = new ANTLRFileStream(filename.substring(1, filename.length() - 1));
                    Gremlin.evaluate(file);
                } catch (Exception e) {
                    retval.result = new Atom(false);
                }


            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "include_statement"

    public static class path_definition_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "path_definition_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:119:1: path_definition_statement returns [Operation op] : ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) ;
    public final GremlinEvaluator.path_definition_statement_return path_definition_statement() throws RecognitionException {
        GremlinEvaluator.path_definition_statement_return retval = new GremlinEvaluator.path_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree path_name = null;
        CommonTree pr = null;
        CommonTree PATH18 = null;
        CommonTree PROPERTY_CALL19 = null;
        GremlinEvaluator.gpath_statement_return gpath = null;


        CommonTree path_name_tree = null;
        CommonTree pr_tree = null;
        CommonTree PATH18_tree = null;
        CommonTree PROPERTY_CALL19_tree = null;


        List<Pipe> pipes = new ArrayList<Pipe>();

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:2: ( ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:4: ^( PATH path_name= IDENTIFIER (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) ) )
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree) adaptor.nil();
                    _last = (CommonTree) input.LT(1);
                    PATH18 = (CommonTree) match(input, PATH, FOLLOW_PATH_in_path_definition_statement427);
                    PATH18_tree = (CommonTree) adaptor.dupNode(PATH18);

                    root_1 = (CommonTree) adaptor.becomeRoot(PATH18_tree, root_1);


                    match(input, Token.DOWN, null);
                    _last = (CommonTree) input.LT(1);
                    path_name = (CommonTree) match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_path_definition_statement431);
                    path_name_tree = (CommonTree) adaptor.dupNode(path_name);

                    adaptor.addChild(root_1, path_name_tree);

                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:32: (gpath= gpath_statement | ^( PROPERTY_CALL pr= PROPERTY ) )
                    int alt4 = 2;
                    int LA4_0 = input.LA(1);

                    if ((LA4_0 == GPATH)) {
                        alt4 = 1;
                    } else if ((LA4_0 == PROPERTY_CALL)) {
                        alt4 = 2;
                    } else {
                        NoViableAltException nvae =
                                new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1:
                            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:33: gpath= gpath_statement
                        {
                            _last = (CommonTree) input.LT(1);
                            pushFollow(FOLLOW_gpath_statement_in_path_definition_statement436);
                            gpath = gpath_statement();

                            state._fsp--;

                            adaptor.addChild(root_1, gpath.getTree());
                            pipes.addAll(((GPathOperation) (gpath != null ? gpath.op : null)).getPipes());

                        }
                        break;
                        case 2:
                            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:123:115: ^( PROPERTY_CALL pr= PROPERTY )
                        {
                            _last = (CommonTree) input.LT(1);
                            {
                                CommonTree _save_last_2 = _last;
                                CommonTree _first_2 = null;
                                CommonTree root_2 = (CommonTree) adaptor.nil();
                                _last = (CommonTree) input.LT(1);
                                PROPERTY_CALL19 = (CommonTree) match(input, PROPERTY_CALL, FOLLOW_PROPERTY_CALL_in_path_definition_statement443);
                                PROPERTY_CALL19_tree = (CommonTree) adaptor.dupNode(PROPERTY_CALL19);

                                root_2 = (CommonTree) adaptor.becomeRoot(PROPERTY_CALL19_tree, root_2);


                                match(input, Token.DOWN, null);
                                _last = (CommonTree) input.LT(1);
                                pr = (CommonTree) match(input, PROPERTY, FOLLOW_PROPERTY_in_path_definition_statement447);
                                pr_tree = (CommonTree) adaptor.dupNode(pr);

                                adaptor.addChild(root_2, pr_tree);


                                match(input, Token.UP, null);
                                adaptor.addChild(root_1, root_2);
                                _last = _save_last_2;
                            }

                            pipes.add(new PropertyPipe((pr != null ? pr.getText() : null).substring(1)));

                        }
                        break;

                    }


                    match(input, Token.UP, null);
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }


                paths.registerPath((path_name != null ? path_name.getText() : null), pipes);
                retval.op = new UnaryOperation(new Atom(null));


            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "path_definition_statement"

    protected static class gpath_statement_scope {
        int pipeCount;
        Object startPoint;
        List<Pipe> pipeList;
    }

    protected Stack gpath_statement_stack = new Stack();

    public static class gpath_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "gpath_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:131:1: gpath_statement returns [Operation op] : ^( GPATH ( step )+ ) ;
    public final GremlinEvaluator.gpath_statement_return gpath_statement() throws RecognitionException {
        gpath_statement_stack.push(new gpath_statement_scope());
        GremlinEvaluator.gpath_statement_return retval = new GremlinEvaluator.gpath_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GPATH20 = null;
        GremlinEvaluator.step_return step21 = null;


        CommonTree GPATH20_tree = null;


        ((gpath_statement_scope) gpath_statement_stack.peek()).pipeCount = 0;
        ((gpath_statement_scope) gpath_statement_stack.peek()).startPoint = null;
        ((gpath_statement_scope) gpath_statement_stack.peek()).pipeList = new ArrayList<Pipe>();

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:143:2: ( ^( GPATH ( step )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:143:4: ^( GPATH ( step )+ )
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree) adaptor.nil();
                    _last = (CommonTree) input.LT(1);
                    GPATH20 = (CommonTree) match(input, GPATH, FOLLOW_GPATH_in_gpath_statement497);
                    GPATH20_tree = (CommonTree) adaptor.dupNode(GPATH20);

                    root_1 = (CommonTree) adaptor.becomeRoot(GPATH20_tree, root_1);


                    match(input, Token.DOWN, null);
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:143:12: ( step )+
                    int cnt5 = 0;
                    loop5:
                    do {
                        int alt5 = 2;
                        int LA5_0 = input.LA(1);

                        if ((LA5_0 == STEP)) {
                            alt5 = 1;
                        }


                        switch (alt5) {
                            case 1:
                                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:143:13: step
                            {
                                _last = (CommonTree) input.LT(1);
                                pushFollow(FOLLOW_step_in_gpath_statement500);
                                step21 = step();

                                state._fsp--;

                                adaptor.addChild(root_1, step21.getTree());

                            }
                            break;

                            default:
                                if (cnt5 >= 1) break loop5;
                                EarlyExitException eee =
                                        new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    match(input, Token.UP, null);
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }


                retval.op = new GPathOperation(((gpath_statement_scope) gpath_statement_stack.peek()).pipeList, ((gpath_statement_scope) gpath_statement_stack.peek()).startPoint);


            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
            gpath_statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "gpath_statement"

    public static class step_return extends TreeRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "step"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:149:1: step : ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) ;
    public final GremlinEvaluator.step_return step() throws RecognitionException {
        GremlinEvaluator.step_return retval = new GremlinEvaluator.step_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STEP22 = null;
        CommonTree TOKEN23 = null;
        CommonTree PREDICATES25 = null;
        CommonTree PREDICATE26 = null;
        GremlinEvaluator.token_return token24 = null;

        GremlinEvaluator.statement_return statement27 = null;


        CommonTree STEP22_tree = null;
        CommonTree TOKEN23_tree = null;
        CommonTree PREDICATES25_tree = null;
        CommonTree PREDICATE26_tree = null;


        List<Operation> predicates = new ArrayList<Operation>();

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:153:5: ( ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:153:7: ^( STEP ^( TOKEN token ) ^( PREDICATES ( ^( PREDICATE statement ) )* ) )
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree) adaptor.nil();
                    _last = (CommonTree) input.LT(1);
                    STEP22 = (CommonTree) match(input, STEP, FOLLOW_STEP_in_step538);
                    STEP22_tree = (CommonTree) adaptor.dupNode(STEP22);

                    root_1 = (CommonTree) adaptor.becomeRoot(STEP22_tree, root_1);


                    match(input, Token.DOWN, null);
                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_2 = _last;
                        CommonTree _first_2 = null;
                        CommonTree root_2 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        TOKEN23 = (CommonTree) match(input, TOKEN, FOLLOW_TOKEN_in_step541);
                        TOKEN23_tree = (CommonTree) adaptor.dupNode(TOKEN23);

                        root_2 = (CommonTree) adaptor.becomeRoot(TOKEN23_tree, root_2);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_token_in_step543);
                        token24 = token();

                        state._fsp--;

                        adaptor.addChild(root_2, token24.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_1, root_2);
                        _last = _save_last_2;
                    }

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_2 = _last;
                        CommonTree _first_2 = null;
                        CommonTree root_2 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        PREDICATES25 = (CommonTree) match(input, PREDICATES, FOLLOW_PREDICATES_in_step547);
                        PREDICATES25_tree = (CommonTree) adaptor.dupNode(PREDICATES25);

                        root_2 = (CommonTree) adaptor.becomeRoot(PREDICATES25_tree, root_2);


                        if (input.LA(1) == Token.DOWN) {
                            match(input, Token.DOWN, null);
                            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:153:42: ( ^( PREDICATE statement ) )*
                            loop6:
                            do {
                                int alt6 = 2;
                                int LA6_0 = input.LA(1);

                                if ((LA6_0 == PREDICATE)) {
                                    alt6 = 1;
                                }


                                switch (alt6) {
                                    case 1:
                                        // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:153:44: ^( PREDICATE statement )
                                    {
                                        _last = (CommonTree) input.LT(1);
                                        {
                                            CommonTree _save_last_3 = _last;
                                            CommonTree _first_3 = null;
                                            CommonTree root_3 = (CommonTree) adaptor.nil();
                                            _last = (CommonTree) input.LT(1);
                                            PREDICATE26 = (CommonTree) match(input, PREDICATE, FOLLOW_PREDICATE_in_step552);
                                            PREDICATE26_tree = (CommonTree) adaptor.dupNode(PREDICATE26);

                                            root_3 = (CommonTree) adaptor.becomeRoot(PREDICATE26_tree, root_3);


                                            match(input, Token.DOWN, null);
                                            _last = (CommonTree) input.LT(1);
                                            pushFollow(FOLLOW_statement_in_step554);
                                            statement27 = statement();

                                            state._fsp--;

                                            adaptor.addChild(root_3, statement27.getTree());
                                            predicates.add((statement27 != null ? statement27.op : null));

                                            match(input, Token.UP, null);
                                            adaptor.addChild(root_2, root_3);
                                            _last = _save_last_3;
                                        }


                                    }
                                    break;

                                    default:
                                        break loop6;
                                }
                            } while (true);


                            match(input, Token.UP, null);
                        }
                        adaptor.addChild(root_1, root_2);
                        _last = _save_last_2;
                    }


                    match(input, Token.UP, null);
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }


                Atom tokenAtom = (token24 != null ? token24.atom : null);

                if (((gpath_statement_scope) gpath_statement_stack.peek()).pipeCount == 0) {
                    if (tokenAtom.isIdentifier() && ((String) tokenAtom.getValue()).equals(".")) {
                        ((gpath_statement_scope) gpath_statement_stack.peek()).startPoint = GremlinEvaluator.getVariable(Tokens.ROOT).getValue();
                    } else if (paths.isPath(tokenAtom.getValue().toString())) {
                        ((gpath_statement_scope) gpath_statement_stack.peek()).pipeList.addAll(paths.getPath((String) tokenAtom.getValue()));
                        ((gpath_statement_scope) gpath_statement_stack.peek()).startPoint = GremlinEvaluator.getVariable(Tokens.ROOT).getValue();
                    } else {
                        ((gpath_statement_scope) gpath_statement_stack.peek()).startPoint = tokenAtom.getValue();
                    }
                } else {
                    ((gpath_statement_scope) gpath_statement_stack.peek()).pipeList.addAll(GremlinPipesHelper.pipesForStep((token24 != null ? token24.atom : null), predicates));
                }

                ((gpath_statement_scope) gpath_statement_stack.peek()).pipeCount++;


            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "step"

    public static class token_return extends TreeRuleReturnScope {
        public Atom atom;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "token"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:174:1: token returns [Atom atom] : expression ;
    public final GremlinEvaluator.token_return token() throws RecognitionException {
        GremlinEvaluator.token_return retval = new GremlinEvaluator.token_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        GremlinEvaluator.expression_return expression28 = null;


        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:175:5: ( expression )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:175:8: expression
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                pushFollow(FOLLOW_expression_in_token596);
                expression28 = expression();

                state._fsp--;

                adaptor.addChild(root_0, expression28.getTree());
                retval.atom = (expression28 != null ? expression28.expr : null).compute();

            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "token"

    public static class if_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "if_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:179:1: if_statement returns [Operation op] : ^( IF ^( COND cond= statement ) block ) ;
    public final GremlinEvaluator.if_statement_return if_statement() throws RecognitionException {
        GremlinEvaluator.if_statement_return retval = new GremlinEvaluator.if_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IF29 = null;
        CommonTree COND30 = null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return block31 = null;


        CommonTree IF29_tree = null;
        CommonTree COND30_tree = null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:180:2: ( ^( IF ^( COND cond= statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:180:4: ^( IF ^( COND cond= statement ) block )
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree) adaptor.nil();
                    _last = (CommonTree) input.LT(1);
                    IF29 = (CommonTree) match(input, IF, FOLLOW_IF_in_if_statement615);
                    IF29_tree = (CommonTree) adaptor.dupNode(IF29);

                    root_1 = (CommonTree) adaptor.becomeRoot(IF29_tree, root_1);


                    match(input, Token.DOWN, null);
                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_2 = _last;
                        CommonTree _first_2 = null;
                        CommonTree root_2 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        COND30 = (CommonTree) match(input, COND, FOLLOW_COND_in_if_statement618);
                        COND30_tree = (CommonTree) adaptor.dupNode(COND30);

                        root_2 = (CommonTree) adaptor.becomeRoot(COND30_tree, root_2);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_statement_in_if_statement622);
                        cond = statement();

                        state._fsp--;

                        adaptor.addChild(root_2, cond.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_1, root_2);
                        _last = _save_last_2;
                    }

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_block_in_if_statement625);
                    block31 = block();

                    state._fsp--;

                    adaptor.addChild(root_1, block31.getTree());

                    match(input, Token.UP, null);
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }


                retval.op = new If((cond != null ? cond.op : null), (block31 != null ? block31.operations : null));


            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "if_statement"

    public static class while_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "while_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:186:1: while_statement returns [Operation op] : ^( WHILE ^( COND cond= statement ) block ) ;
    public final GremlinEvaluator.while_statement_return while_statement() throws RecognitionException {
        GremlinEvaluator.while_statement_return retval = new GremlinEvaluator.while_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree WHILE32 = null;
        CommonTree COND33 = null;
        GremlinEvaluator.statement_return cond = null;

        GremlinEvaluator.block_return block34 = null;


        CommonTree WHILE32_tree = null;
        CommonTree COND33_tree = null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:187:2: ( ^( WHILE ^( COND cond= statement ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:187:4: ^( WHILE ^( COND cond= statement ) block )
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree) adaptor.nil();
                    _last = (CommonTree) input.LT(1);
                    WHILE32 = (CommonTree) match(input, WHILE, FOLLOW_WHILE_in_while_statement653);
                    WHILE32_tree = (CommonTree) adaptor.dupNode(WHILE32);

                    root_1 = (CommonTree) adaptor.becomeRoot(WHILE32_tree, root_1);


                    match(input, Token.DOWN, null);
                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_2 = _last;
                        CommonTree _first_2 = null;
                        CommonTree root_2 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        COND33 = (CommonTree) match(input, COND, FOLLOW_COND_in_while_statement656);
                        COND33_tree = (CommonTree) adaptor.dupNode(COND33);

                        root_2 = (CommonTree) adaptor.becomeRoot(COND33_tree, root_2);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_statement_in_while_statement660);
                        cond = statement();

                        state._fsp--;

                        adaptor.addChild(root_2, cond.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_1, root_2);
                        _last = _save_last_2;
                    }

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_block_in_while_statement663);
                    block34 = block();

                    state._fsp--;

                    adaptor.addChild(root_1, block34.getTree());

                    match(input, Token.UP, null);
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }


                retval.op = new While((cond != null ? cond.op : null), (block34 != null ? block34.operations : null));


            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "while_statement"

    public static class foreach_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "foreach_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:193:1: foreach_statement returns [Operation op] : ^( FOREACH VARIABLE arr= statement block ) ;
    public final GremlinEvaluator.foreach_statement_return foreach_statement() throws RecognitionException {
        GremlinEvaluator.foreach_statement_return retval = new GremlinEvaluator.foreach_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH35 = null;
        CommonTree VARIABLE36 = null;
        GremlinEvaluator.statement_return arr = null;

        GremlinEvaluator.block_return block37 = null;


        CommonTree FOREACH35_tree = null;
        CommonTree VARIABLE36_tree = null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:194:2: ( ^( FOREACH VARIABLE arr= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:194:4: ^( FOREACH VARIABLE arr= statement block )
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree) adaptor.nil();
                    _last = (CommonTree) input.LT(1);
                    FOREACH35 = (CommonTree) match(input, FOREACH, FOLLOW_FOREACH_in_foreach_statement690);
                    FOREACH35_tree = (CommonTree) adaptor.dupNode(FOREACH35);

                    root_1 = (CommonTree) adaptor.becomeRoot(FOREACH35_tree, root_1);


                    match(input, Token.DOWN, null);
                    _last = (CommonTree) input.LT(1);
                    VARIABLE36 = (CommonTree) match(input, VARIABLE, FOLLOW_VARIABLE_in_foreach_statement692);
                    VARIABLE36_tree = (CommonTree) adaptor.dupNode(VARIABLE36);

                    adaptor.addChild(root_1, VARIABLE36_tree);

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_statement_in_foreach_statement696);
                    arr = statement();

                    state._fsp--;

                    adaptor.addChild(root_1, arr.getTree());
                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_block_in_foreach_statement698);
                    block37 = block();

                    state._fsp--;

                    adaptor.addChild(root_1, block37.getTree());

                    match(input, Token.UP, null);
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }


                retval.op = new Foreach((VARIABLE36 != null ? VARIABLE36.getText() : null), (arr != null ? arr.op : null), (block37 != null ? block37.operations : null));


            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "foreach_statement"

    public static class repeat_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "repeat_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:200:1: repeat_statement returns [Operation op] : ^( REPEAT timer= statement block ) ;
    public final GremlinEvaluator.repeat_statement_return repeat_statement() throws RecognitionException {
        GremlinEvaluator.repeat_statement_return retval = new GremlinEvaluator.repeat_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REPEAT38 = null;
        GremlinEvaluator.statement_return timer = null;

        GremlinEvaluator.block_return block39 = null;


        CommonTree REPEAT38_tree = null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:201:2: ( ^( REPEAT timer= statement block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:201:4: ^( REPEAT timer= statement block )
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree) adaptor.nil();
                    _last = (CommonTree) input.LT(1);
                    REPEAT38 = (CommonTree) match(input, REPEAT, FOLLOW_REPEAT_in_repeat_statement726);
                    REPEAT38_tree = (CommonTree) adaptor.dupNode(REPEAT38);

                    root_1 = (CommonTree) adaptor.becomeRoot(REPEAT38_tree, root_1);


                    match(input, Token.DOWN, null);
                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_statement_in_repeat_statement730);
                    timer = statement();

                    state._fsp--;

                    adaptor.addChild(root_1, timer.getTree());
                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_block_in_repeat_statement732);
                    block39 = block();

                    state._fsp--;

                    adaptor.addChild(root_1, block39.getTree());

                    match(input, Token.UP, null);
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }


                retval.op = new Repeat((timer != null ? timer.op : null), (block39 != null ? block39.operations : null));


            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "repeat_statement"

    public static class block_return extends TreeRuleReturnScope {
        public List<Operation> operations;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "block"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:207:1: block returns [List<Operation> operations] : ^( BLOCK ( statement )+ ) ;
    public final GremlinEvaluator.block_return block() throws RecognitionException {
        GremlinEvaluator.block_return retval = new GremlinEvaluator.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BLOCK40 = null;
        GremlinEvaluator.statement_return statement41 = null;


        CommonTree BLOCK40_tree = null;


        List<Operation> operationList = new ArrayList<Operation>();

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:211:5: ( ^( BLOCK ( statement )+ ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:211:7: ^( BLOCK ( statement )+ )
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree) adaptor.nil();
                    _last = (CommonTree) input.LT(1);
                    BLOCK40 = (CommonTree) match(input, BLOCK, FOLLOW_BLOCK_in_block771);
                    BLOCK40_tree = (CommonTree) adaptor.dupNode(BLOCK40);

                    root_1 = (CommonTree) adaptor.becomeRoot(BLOCK40_tree, root_1);


                    match(input, Token.DOWN, null);
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:211:15: ( statement )+
                    int cnt7 = 0;
                    loop7:
                    do {
                        int alt7 = 2;
                        int LA7_0 = input.LA(1);

                        if ((LA7_0 == VAR || LA7_0 == FUNC || (LA7_0 >= PATH && LA7_0 <= GPATH) || (LA7_0 >= FUNC_CALL && LA7_0 <= IF) || (LA7_0 >= FOREACH && LA7_0 <= NULL) || (LA7_0 >= PROPERTY_CALL && LA7_0 <= VARIABLE_CALL) || LA7_0 == IDENTIFIER || (LA7_0 >= 59 && LA7_0 <= 60) || LA7_0 == 70 || (LA7_0 >= 73 && LA7_0 <= 82))) {
                            alt7 = 1;
                        }


                        switch (alt7) {
                            case 1:
                                // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:211:16: statement
                            {
                                _last = (CommonTree) input.LT(1);
                                pushFollow(FOLLOW_statement_in_block774);
                                statement41 = statement();

                                state._fsp--;

                                adaptor.addChild(root_1, statement41.getTree());
                                operationList.add((statement41 != null ? statement41.op : null));

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


                    match(input, Token.UP, null);
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }

                retval.operations = operationList;

            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class expression_return extends TreeRuleReturnScope {
        public Operation expr;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "expression"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:214:1: expression returns [Operation expr] : ( ^( '=' a= operation b= operation ) | ^( '!=' a= operation b= operation ) | ^( '<' a= operation b= operation ) | ^( '>' a= operation b= operation ) | ^( '<=' a= operation b= operation ) | ^( '>=' a= operation b= operation ) | operation );
    public final GremlinEvaluator.expression_return expression() throws RecognitionException {
        GremlinEvaluator.expression_return retval = new GremlinEvaluator.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal42 = null;
        CommonTree string_literal43 = null;
        CommonTree char_literal44 = null;
        CommonTree char_literal45 = null;
        CommonTree string_literal46 = null;
        CommonTree string_literal47 = null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.operation_return operation48 = null;


        CommonTree char_literal42_tree = null;
        CommonTree string_literal43_tree = null;
        CommonTree char_literal44_tree = null;
        CommonTree char_literal45_tree = null;
        CommonTree string_literal46_tree = null;
        CommonTree string_literal47_tree = null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:215:5: ( ^( '=' a= operation b= operation ) | ^( '!=' a= operation b= operation ) | ^( '<' a= operation b= operation ) | ^( '>' a= operation b= operation ) | ^( '<=' a= operation b= operation ) | ^( '>=' a= operation b= operation ) | operation )
            int alt8 = 7;
            switch (input.LA(1)) {
                case 73: {
                    alt8 = 1;
                }
                break;
                case 74: {
                    alt8 = 2;
                }
                break;
                case 75: {
                    alt8 = 3;
                }
                break;
                case 77: {
                    alt8 = 4;
                }
                break;
                case 76: {
                    alt8 = 5;
                }
                break;
                case 78: {
                    alt8 = 6;
                }
                break;
                case FUNC_CALL:
                case NUM:
                case STR:
                case ARR:
                case BOOL:
                case NULL:
                case PROPERTY_CALL:
                case VARIABLE_CALL:
                case IDENTIFIER:
                case 70:
                case 79:
                case 80:
                case 81:
                case 82: {
                    alt8 = 7;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                    throw nvae;
            }

            switch (alt8) {
                case 1:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:215:9: ^( '=' a= operation b= operation )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        char_literal42 = (CommonTree) match(input, 73, FOLLOW_73_in_expression802);
                        char_literal42_tree = (CommonTree) adaptor.dupNode(char_literal42);

                        root_1 = (CommonTree) adaptor.becomeRoot(char_literal42_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression807);
                        a = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression811);
                        b = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.expr = new Equality((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 2:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:216:9: ^( '!=' a= operation b= operation )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        string_literal43 = (CommonTree) match(input, 74, FOLLOW_74_in_expression825);
                        string_literal43_tree = (CommonTree) adaptor.dupNode(string_literal43);

                        root_1 = (CommonTree) adaptor.becomeRoot(string_literal43_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression829);
                        a = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression833);
                        b = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.expr = new UnEquality((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 3:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:217:9: ^( '<' a= operation b= operation )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        char_literal44 = (CommonTree) match(input, 75, FOLLOW_75_in_expression847);
                        char_literal44_tree = (CommonTree) adaptor.dupNode(char_literal44);

                        root_1 = (CommonTree) adaptor.becomeRoot(char_literal44_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression852);
                        a = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression856);
                        b = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.expr = new LessThan((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 4:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:218:9: ^( '>' a= operation b= operation )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        char_literal45 = (CommonTree) match(input, 77, FOLLOW_77_in_expression870);
                        char_literal45_tree = (CommonTree) adaptor.dupNode(char_literal45);

                        root_1 = (CommonTree) adaptor.becomeRoot(char_literal45_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression875);
                        a = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression879);
                        b = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.expr = new GreaterThan((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 5:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:219:9: ^( '<=' a= operation b= operation )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        string_literal46 = (CommonTree) match(input, 76, FOLLOW_76_in_expression893);
                        string_literal46_tree = (CommonTree) adaptor.dupNode(string_literal46);

                        root_1 = (CommonTree) adaptor.becomeRoot(string_literal46_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression897);
                        a = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression901);
                        b = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.expr = new LessThanOrEqual((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 6:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:220:9: ^( '>=' a= operation b= operation )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        string_literal47 = (CommonTree) match(input, 78, FOLLOW_78_in_expression915);
                        string_literal47_tree = (CommonTree) adaptor.dupNode(string_literal47);

                        root_1 = (CommonTree) adaptor.becomeRoot(string_literal47_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression919);
                        a = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_expression923);
                        b = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.expr = new GreaterThanOrEqual((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 7:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:221:9: operation
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_operation_in_expression936);
                    operation48 = operation();

                    state._fsp--;

                    adaptor.addChild(root_0, operation48.getTree());
                    retval.expr = (operation48 != null ? operation48.op : null);

                }
                break;

            }
            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class operation_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "operation"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:224:1: operation returns [Operation op] : ( ^( '+' a= operation b= operation ) | ^( '-' a= operation b= operation ) | binary_operation );
    public final GremlinEvaluator.operation_return operation() throws RecognitionException {
        GremlinEvaluator.operation_return retval = new GremlinEvaluator.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal49 = null;
        CommonTree char_literal50 = null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.binary_operation_return binary_operation51 = null;


        CommonTree char_literal49_tree = null;
        CommonTree char_literal50_tree = null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:225:5: ( ^( '+' a= operation b= operation ) | ^( '-' a= operation b= operation ) | binary_operation )
            int alt9 = 3;
            switch (input.LA(1)) {
                case 79: {
                    alt9 = 1;
                }
                break;
                case 80: {
                    alt9 = 2;
                }
                break;
                case FUNC_CALL:
                case NUM:
                case STR:
                case ARR:
                case BOOL:
                case NULL:
                case PROPERTY_CALL:
                case VARIABLE_CALL:
                case IDENTIFIER:
                case 70:
                case 81:
                case 82: {
                    alt9 = 3;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                    throw nvae;
            }

            switch (alt9) {
                case 1:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:225:9: ^( '+' a= operation b= operation )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        char_literal49 = (CommonTree) match(input, 79, FOLLOW_79_in_operation981);
                        char_literal49_tree = (CommonTree) adaptor.dupNode(char_literal49);

                        root_1 = (CommonTree) adaptor.becomeRoot(char_literal49_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_operation985);
                        a = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_operation989);
                        b = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.op = new Addition((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 2:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:226:9: ^( '-' a= operation b= operation )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        char_literal50 = (CommonTree) match(input, 80, FOLLOW_80_in_operation1003);
                        char_literal50_tree = (CommonTree) adaptor.dupNode(char_literal50);

                        root_1 = (CommonTree) adaptor.becomeRoot(char_literal50_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_operation1007);
                        a = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_operation1011);
                        b = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.op = new Subtraction((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 3:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:227:9: binary_operation
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_binary_operation_in_operation1024);
                    binary_operation51 = binary_operation();

                    state._fsp--;

                    adaptor.addChild(root_0, binary_operation51.getTree());
                    retval.op = (binary_operation51 != null ? binary_operation51.operation : null);

                }
                break;

            }
            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operation"

    public static class binary_operation_return extends TreeRuleReturnScope {
        public Operation operation;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "binary_operation"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:230:1: binary_operation returns [Operation operation] : ( ^( '*' a= operation b= operation ) | ^( 'div' a= operation b= operation ) | atom );
    public final GremlinEvaluator.binary_operation_return binary_operation() throws RecognitionException {
        GremlinEvaluator.binary_operation_return retval = new GremlinEvaluator.binary_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal52 = null;
        CommonTree string_literal53 = null;
        GremlinEvaluator.operation_return a = null;

        GremlinEvaluator.operation_return b = null;

        GremlinEvaluator.atom_return atom54 = null;


        CommonTree char_literal52_tree = null;
        CommonTree string_literal53_tree = null;

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:231:5: ( ^( '*' a= operation b= operation ) | ^( 'div' a= operation b= operation ) | atom )
            int alt10 = 3;
            switch (input.LA(1)) {
                case 81: {
                    alt10 = 1;
                }
                break;
                case 82: {
                    alt10 = 2;
                }
                break;
                case FUNC_CALL:
                case NUM:
                case STR:
                case ARR:
                case BOOL:
                case NULL:
                case PROPERTY_CALL:
                case VARIABLE_CALL:
                case IDENTIFIER:
                case 70: {
                    alt10 = 3;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                    throw nvae;
            }

            switch (alt10) {
                case 1:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:231:9: ^( '*' a= operation b= operation )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        char_literal52 = (CommonTree) match(input, 81, FOLLOW_81_in_binary_operation1061);
                        char_literal52_tree = (CommonTree) adaptor.dupNode(char_literal52);

                        root_1 = (CommonTree) adaptor.becomeRoot(char_literal52_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_binary_operation1065);
                        a = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_binary_operation1069);
                        b = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.operation = new Multiplication((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 2:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:232:9: ^( 'div' a= operation b= operation )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        string_literal53 = (CommonTree) match(input, 82, FOLLOW_82_in_binary_operation1088);
                        string_literal53_tree = (CommonTree) adaptor.dupNode(string_literal53);

                        root_1 = (CommonTree) adaptor.becomeRoot(string_literal53_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_binary_operation1092);
                        a = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, a.getTree());
                        _last = (CommonTree) input.LT(1);
                        pushFollow(FOLLOW_operation_in_binary_operation1096);
                        b = operation();

                        state._fsp--;

                        adaptor.addChild(root_1, b.getTree());

                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.operation = new Division((a != null ? a.op : null), (b != null ? b.op : null));

                }
                break;
                case 3:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:233:9: atom
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_atom_in_binary_operation1112);
                    atom54 = atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom54.getTree());
                    retval.operation = new UnaryOperation((atom54 != null ? atom54.value : null));

                }
                break;

            }
            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "binary_operation"

    public static class function_definition_statement_return extends TreeRuleReturnScope {
        public Operation op;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "function_definition_statement"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:236:1: function_definition_statement returns [Operation op] : ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) ;
    public final GremlinEvaluator.function_definition_statement_return function_definition_statement() throws RecognitionException {
        GremlinEvaluator.function_definition_statement_return retval = new GremlinEvaluator.function_definition_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns = null;
        CommonTree fn_name = null;
        CommonTree FUNC55 = null;
        CommonTree FUNC_NAME56 = null;
        CommonTree NS57 = null;
        CommonTree NAME58 = null;
        CommonTree ARGS59 = null;
        CommonTree ARG60 = null;
        CommonTree VARIABLE61 = null;
        GremlinEvaluator.block_return block62 = null;


        CommonTree ns_tree = null;
        CommonTree fn_name_tree = null;
        CommonTree FUNC55_tree = null;
        CommonTree FUNC_NAME56_tree = null;
        CommonTree NS57_tree = null;
        CommonTree NAME58_tree = null;
        CommonTree ARGS59_tree = null;
        CommonTree ARG60_tree = null;
        CommonTree VARIABLE61_tree = null;


        List<String> params = new ArrayList<String>();

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:240:2: ( ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:240:4: ^( FUNC ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG VARIABLE ) )* ) block )
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree) adaptor.nil();
                    _last = (CommonTree) input.LT(1);
                    FUNC55 = (CommonTree) match(input, FUNC, FOLLOW_FUNC_in_function_definition_statement1170);
                    FUNC55_tree = (CommonTree) adaptor.dupNode(FUNC55);

                    root_1 = (CommonTree) adaptor.becomeRoot(FUNC55_tree, root_1);


                    match(input, Token.DOWN, null);
                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_2 = _last;
                        CommonTree _first_2 = null;
                        CommonTree root_2 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        FUNC_NAME56 = (CommonTree) match(input, FUNC_NAME, FOLLOW_FUNC_NAME_in_function_definition_statement1173);
                        FUNC_NAME56_tree = (CommonTree) adaptor.dupNode(FUNC_NAME56);

                        root_2 = (CommonTree) adaptor.becomeRoot(FUNC_NAME56_tree, root_2);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        {
                            CommonTree _save_last_3 = _last;
                            CommonTree _first_3 = null;
                            CommonTree root_3 = (CommonTree) adaptor.nil();
                            _last = (CommonTree) input.LT(1);
                            NS57 = (CommonTree) match(input, NS, FOLLOW_NS_in_function_definition_statement1176);
                            NS57_tree = (CommonTree) adaptor.dupNode(NS57);

                            root_3 = (CommonTree) adaptor.becomeRoot(NS57_tree, root_3);


                            match(input, Token.DOWN, null);
                            _last = (CommonTree) input.LT(1);
                            ns = (CommonTree) match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_function_definition_statement1180);
                            ns_tree = (CommonTree) adaptor.dupNode(ns);

                            adaptor.addChild(root_3, ns_tree);


                            match(input, Token.UP, null);
                            adaptor.addChild(root_2, root_3);
                            _last = _save_last_3;
                        }

                        _last = (CommonTree) input.LT(1);
                        {
                            CommonTree _save_last_3 = _last;
                            CommonTree _first_3 = null;
                            CommonTree root_3 = (CommonTree) adaptor.nil();
                            _last = (CommonTree) input.LT(1);
                            NAME58 = (CommonTree) match(input, NAME, FOLLOW_NAME_in_function_definition_statement1184);
                            NAME58_tree = (CommonTree) adaptor.dupNode(NAME58);

                            root_3 = (CommonTree) adaptor.becomeRoot(NAME58_tree, root_3);


                            match(input, Token.DOWN, null);
                            _last = (CommonTree) input.LT(1);
                            fn_name = (CommonTree) match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_function_definition_statement1188);
                            fn_name_tree = (CommonTree) adaptor.dupNode(fn_name);

                            adaptor.addChild(root_3, fn_name_tree);


                            match(input, Token.UP, null);
                            adaptor.addChild(root_2, root_3);
                            _last = _save_last_3;
                        }


                        match(input, Token.UP, null);
                        adaptor.addChild(root_1, root_2);
                        _last = _save_last_2;
                    }

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_2 = _last;
                        CommonTree _first_2 = null;
                        CommonTree root_2 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        ARGS59 = (CommonTree) match(input, ARGS, FOLLOW_ARGS_in_function_definition_statement1193);
                        ARGS59_tree = (CommonTree) adaptor.dupNode(ARGS59);

                        root_2 = (CommonTree) adaptor.becomeRoot(ARGS59_tree, root_2);


                        if (input.LA(1) == Token.DOWN) {
                            match(input, Token.DOWN, null);
                            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:240:78: ( ^( ARG VARIABLE ) )*
                            loop11:
                            do {
                                int alt11 = 2;
                                int LA11_0 = input.LA(1);

                                if ((LA11_0 == ARG)) {
                                    alt11 = 1;
                                }


                                switch (alt11) {
                                    case 1:
                                        // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:240:80: ^( ARG VARIABLE )
                                    {
                                        _last = (CommonTree) input.LT(1);
                                        {
                                            CommonTree _save_last_3 = _last;
                                            CommonTree _first_3 = null;
                                            CommonTree root_3 = (CommonTree) adaptor.nil();
                                            _last = (CommonTree) input.LT(1);
                                            ARG60 = (CommonTree) match(input, ARG, FOLLOW_ARG_in_function_definition_statement1198);
                                            ARG60_tree = (CommonTree) adaptor.dupNode(ARG60);

                                            root_3 = (CommonTree) adaptor.becomeRoot(ARG60_tree, root_3);


                                            match(input, Token.DOWN, null);
                                            _last = (CommonTree) input.LT(1);
                                            VARIABLE61 = (CommonTree) match(input, VARIABLE, FOLLOW_VARIABLE_in_function_definition_statement1200);
                                            VARIABLE61_tree = (CommonTree) adaptor.dupNode(VARIABLE61);

                                            adaptor.addChild(root_3, VARIABLE61_tree);

                                            params.add((VARIABLE61 != null ? VARIABLE61.getText() : null));

                                            match(input, Token.UP, null);
                                            adaptor.addChild(root_2, root_3);
                                            _last = _save_last_3;
                                        }


                                    }
                                    break;

                                    default:
                                        break loop11;
                                }
                            } while (true);


                            match(input, Token.UP, null);
                        }
                        adaptor.addChild(root_1, root_2);
                        _last = _save_last_2;
                    }

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_block_in_function_definition_statement1209);
                    block62 = block();

                    state._fsp--;

                    adaptor.addChild(root_1, block62.getTree());

                    match(input, Token.UP, null);
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }


                NativeFunction fn = new NativeFunction((fn_name != null ? fn_name.getText() : null), params, (block62 != null ? block62.operations : null));
                functions.registerFunction((ns != null ? ns.getText() : null), fn);

                retval.op = new UnaryOperation(new Atom(null));


            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_definition_statement"

    public static class function_call_return extends TreeRuleReturnScope {
        public Atom value;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "function_call"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:249:1: function_call returns [Atom value] : ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) ;
    public final GremlinEvaluator.function_call_return function_call() throws RecognitionException {
        GremlinEvaluator.function_call_return retval = new GremlinEvaluator.function_call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ns = null;
        CommonTree fn_name = null;
        CommonTree FUNC_CALL63 = null;
        CommonTree FUNC_NAME64 = null;
        CommonTree NS65 = null;
        CommonTree NAME66 = null;
        CommonTree ARGS67 = null;
        CommonTree ARG68 = null;
        GremlinEvaluator.statement_return st = null;


        CommonTree ns_tree = null;
        CommonTree fn_name_tree = null;
        CommonTree FUNC_CALL63_tree = null;
        CommonTree FUNC_NAME64_tree = null;
        CommonTree NS65_tree = null;
        CommonTree NAME66_tree = null;
        CommonTree ARGS67_tree = null;
        CommonTree ARG68_tree = null;


        List<Operation> params = new ArrayList<Operation>();

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:253:2: ( ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) ) )
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:253:4: ^( FUNC_CALL ^( FUNC_NAME ^( NS ns= IDENTIFIER ) ^( NAME fn_name= IDENTIFIER ) ) ^( ARGS ( ^( ARG st= statement ) )* ) )
            {
                root_0 = (CommonTree) adaptor.nil();

                _last = (CommonTree) input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree) adaptor.nil();
                    _last = (CommonTree) input.LT(1);
                    FUNC_CALL63 = (CommonTree) match(input, FUNC_CALL, FOLLOW_FUNC_CALL_in_function_call1246);
                    FUNC_CALL63_tree = (CommonTree) adaptor.dupNode(FUNC_CALL63);

                    root_1 = (CommonTree) adaptor.becomeRoot(FUNC_CALL63_tree, root_1);


                    match(input, Token.DOWN, null);
                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_2 = _last;
                        CommonTree _first_2 = null;
                        CommonTree root_2 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        FUNC_NAME64 = (CommonTree) match(input, FUNC_NAME, FOLLOW_FUNC_NAME_in_function_call1249);
                        FUNC_NAME64_tree = (CommonTree) adaptor.dupNode(FUNC_NAME64);

                        root_2 = (CommonTree) adaptor.becomeRoot(FUNC_NAME64_tree, root_2);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        {
                            CommonTree _save_last_3 = _last;
                            CommonTree _first_3 = null;
                            CommonTree root_3 = (CommonTree) adaptor.nil();
                            _last = (CommonTree) input.LT(1);
                            NS65 = (CommonTree) match(input, NS, FOLLOW_NS_in_function_call1252);
                            NS65_tree = (CommonTree) adaptor.dupNode(NS65);

                            root_3 = (CommonTree) adaptor.becomeRoot(NS65_tree, root_3);


                            match(input, Token.DOWN, null);
                            _last = (CommonTree) input.LT(1);
                            ns = (CommonTree) match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_function_call1256);
                            ns_tree = (CommonTree) adaptor.dupNode(ns);

                            adaptor.addChild(root_3, ns_tree);


                            match(input, Token.UP, null);
                            adaptor.addChild(root_2, root_3);
                            _last = _save_last_3;
                        }

                        _last = (CommonTree) input.LT(1);
                        {
                            CommonTree _save_last_3 = _last;
                            CommonTree _first_3 = null;
                            CommonTree root_3 = (CommonTree) adaptor.nil();
                            _last = (CommonTree) input.LT(1);
                            NAME66 = (CommonTree) match(input, NAME, FOLLOW_NAME_in_function_call1260);
                            NAME66_tree = (CommonTree) adaptor.dupNode(NAME66);

                            root_3 = (CommonTree) adaptor.becomeRoot(NAME66_tree, root_3);


                            match(input, Token.DOWN, null);
                            _last = (CommonTree) input.LT(1);
                            fn_name = (CommonTree) match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_function_call1264);
                            fn_name_tree = (CommonTree) adaptor.dupNode(fn_name);

                            adaptor.addChild(root_3, fn_name_tree);


                            match(input, Token.UP, null);
                            adaptor.addChild(root_2, root_3);
                            _last = _save_last_3;
                        }


                        match(input, Token.UP, null);
                        adaptor.addChild(root_1, root_2);
                        _last = _save_last_2;
                    }

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_2 = _last;
                        CommonTree _first_2 = null;
                        CommonTree root_2 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        ARGS67 = (CommonTree) match(input, ARGS, FOLLOW_ARGS_in_function_call1269);
                        ARGS67_tree = (CommonTree) adaptor.dupNode(ARGS67);

                        root_2 = (CommonTree) adaptor.becomeRoot(ARGS67_tree, root_2);


                        if (input.LA(1) == Token.DOWN) {
                            match(input, Token.DOWN, null);
                            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:253:83: ( ^( ARG st= statement ) )*
                            loop12:
                            do {
                                int alt12 = 2;
                                int LA12_0 = input.LA(1);

                                if ((LA12_0 == ARG)) {
                                    alt12 = 1;
                                }


                                switch (alt12) {
                                    case 1:
                                        // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:253:85: ^( ARG st= statement )
                                    {
                                        _last = (CommonTree) input.LT(1);
                                        {
                                            CommonTree _save_last_3 = _last;
                                            CommonTree _first_3 = null;
                                            CommonTree root_3 = (CommonTree) adaptor.nil();
                                            _last = (CommonTree) input.LT(1);
                                            ARG68 = (CommonTree) match(input, ARG, FOLLOW_ARG_in_function_call1274);
                                            ARG68_tree = (CommonTree) adaptor.dupNode(ARG68);

                                            root_3 = (CommonTree) adaptor.becomeRoot(ARG68_tree, root_3);


                                            match(input, Token.DOWN, null);
                                            _last = (CommonTree) input.LT(1);
                                            pushFollow(FOLLOW_statement_in_function_call1278);
                                            st = statement();

                                            state._fsp--;

                                            adaptor.addChild(root_3, st.getTree());
                                            params.add((st != null ? st.op : null));

                                            match(input, Token.UP, null);
                                            adaptor.addChild(root_2, root_3);
                                            _last = _save_last_3;
                                        }


                                    }
                                    break;

                                    default:
                                        break loop12;
                                }
                            } while (true);


                            match(input, Token.UP, null);
                        }
                        adaptor.addChild(root_1, root_2);
                        _last = _save_last_2;
                    }


                    match(input, Token.UP, null);
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }


                try {
                    retval.value = functions.runFunction((ns != null ? ns.getText() : null), (fn_name != null ? fn_name.getText() : null), params);
                } catch (Exception e) {
                    System.err.println(e);
                }


            }

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_call"

    public static class atom_return extends TreeRuleReturnScope {
        public Atom value;
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    }

    ;

    // $ANTLR start "atom"
    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:263:1: atom returns [Atom value] : ( ^( NUM NUMBER ) | ^( STR StringLiteral ) | ^( BOOL b= BOOLEAN ) | NULL | ^( ARR ( NUMBER )+ ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | function_call | '(' statement ')' );
    public final GremlinEvaluator.atom_return atom() throws RecognitionException {
        GremlinEvaluator.atom_return retval = new GremlinEvaluator.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree b = null;
        CommonTree NUM69 = null;
        CommonTree NUMBER70 = null;
        CommonTree STR71 = null;
        CommonTree StringLiteral72 = null;
        CommonTree BOOL73 = null;
        CommonTree NULL74 = null;
        CommonTree ARR75 = null;
        CommonTree NUMBER76 = null;
        CommonTree VARIABLE_CALL77 = null;
        CommonTree VARIABLE78 = null;
        CommonTree PROPERTY_CALL79 = null;
        CommonTree PROPERTY80 = null;
        CommonTree IDENTIFIER81 = null;
        CommonTree char_literal83 = null;
        CommonTree char_literal85 = null;
        GremlinEvaluator.function_call_return function_call82 = null;

        GremlinEvaluator.statement_return statement84 = null;


        CommonTree b_tree = null;
        CommonTree NUM69_tree = null;
        CommonTree NUMBER70_tree = null;
        CommonTree STR71_tree = null;
        CommonTree StringLiteral72_tree = null;
        CommonTree BOOL73_tree = null;
        CommonTree NULL74_tree = null;
        CommonTree ARR75_tree = null;
        CommonTree NUMBER76_tree = null;
        CommonTree VARIABLE_CALL77_tree = null;
        CommonTree VARIABLE78_tree = null;
        CommonTree PROPERTY_CALL79_tree = null;
        CommonTree PROPERTY80_tree = null;
        CommonTree IDENTIFIER81_tree = null;
        CommonTree char_literal83_tree = null;
        CommonTree char_literal85_tree = null;


        List<Double> array = new ArrayList<Double>();

        try {
            // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:267:2: ( ^( NUM NUMBER ) | ^( STR StringLiteral ) | ^( BOOL b= BOOLEAN ) | NULL | ^( ARR ( NUMBER )+ ) | ^( VARIABLE_CALL VARIABLE ) | ^( PROPERTY_CALL PROPERTY ) | IDENTIFIER | function_call | '(' statement ')' )
            int alt14 = 10;
            switch (input.LA(1)) {
                case NUM: {
                    alt14 = 1;
                }
                break;
                case STR: {
                    alt14 = 2;
                }
                break;
                case BOOL: {
                    alt14 = 3;
                }
                break;
                case NULL: {
                    alt14 = 4;
                }
                break;
                case ARR: {
                    alt14 = 5;
                }
                break;
                case VARIABLE_CALL: {
                    alt14 = 6;
                }
                break;
                case PROPERTY_CALL: {
                    alt14 = 7;
                }
                break;
                case IDENTIFIER: {
                    alt14 = 8;
                }
                break;
                case FUNC_CALL: {
                    alt14 = 9;
                }
                break;
                case 70: {
                    alt14 = 10;
                }
                break;
                default:
                    NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                    throw nvae;
            }

            switch (alt14) {
                case 1:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:267:4: ^( NUM NUMBER )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        NUM69 = (CommonTree) match(input, NUM, FOLLOW_NUM_in_atom1322);
                        NUM69_tree = (CommonTree) adaptor.dupNode(NUM69);

                        root_1 = (CommonTree) adaptor.becomeRoot(NUM69_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        NUMBER70 = (CommonTree) match(input, NUMBER, FOLLOW_NUMBER_in_atom1324);
                        NUMBER70_tree = (CommonTree) adaptor.dupNode(NUMBER70);

                        adaptor.addChild(root_1, NUMBER70_tree);


                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.value = new Atom(new Double((NUMBER70 != null ? NUMBER70.getText() : null)));

                }
                break;
                case 2:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:268:4: ^( STR StringLiteral )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        STR71 = (CommonTree) match(input, STR, FOLLOW_STR_in_atom1379);
                        STR71_tree = (CommonTree) adaptor.dupNode(STR71);

                        root_1 = (CommonTree) adaptor.becomeRoot(STR71_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        StringLiteral72 = (CommonTree) match(input, StringLiteral, FOLLOW_StringLiteral_in_atom1381);
                        StringLiteral72_tree = (CommonTree) adaptor.dupNode(StringLiteral72);

                        adaptor.addChild(root_1, StringLiteral72_tree);


                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.value = new Atom((StringLiteral72 != null ? StringLiteral72.getText() : null));

                }
                break;
                case 3:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:269:9: ^( BOOL b= BOOLEAN )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        BOOL73 = (CommonTree) match(input, BOOL, FOLLOW_BOOL_in_atom1434);
                        BOOL73_tree = (CommonTree) adaptor.dupNode(BOOL73);

                        root_1 = (CommonTree) adaptor.becomeRoot(BOOL73_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        b = (CommonTree) match(input, BOOLEAN, FOLLOW_BOOLEAN_in_atom1438);
                        b_tree = (CommonTree) adaptor.dupNode(b);

                        adaptor.addChild(root_1, b_tree);


                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.value = new Atom(new Boolean((b != null ? b.getText() : null)));

                }
                break;
                case 4:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:270:9: NULL
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    NULL74 = (CommonTree) match(input, NULL, FOLLOW_NULL_in_atom1493);
                    NULL74_tree = (CommonTree) adaptor.dupNode(NULL74);

                    adaptor.addChild(root_0, NULL74_tree);

                    retval.value = new Atom(null);

                }
                break;
                case 5:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:271:9: ^( ARR ( NUMBER )+ )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        ARR75 = (CommonTree) match(input, ARR, FOLLOW_ARR_in_atom1561);
                        ARR75_tree = (CommonTree) adaptor.dupNode(ARR75);

                        root_1 = (CommonTree) adaptor.becomeRoot(ARR75_tree, root_1);


                        match(input, Token.DOWN, null);
                        // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:271:15: ( NUMBER )+
                        int cnt13 = 0;
                        loop13:
                        do {
                            int alt13 = 2;
                            int LA13_0 = input.LA(1);

                            if ((LA13_0 == NUMBER)) {
                                alt13 = 1;
                            }


                            switch (alt13) {
                                case 1:
                                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:271:16: NUMBER
                                {
                                    _last = (CommonTree) input.LT(1);
                                    NUMBER76 = (CommonTree) match(input, NUMBER, FOLLOW_NUMBER_in_atom1564);
                                    NUMBER76_tree = (CommonTree) adaptor.dupNode(NUMBER76);

                                    adaptor.addChild(root_1, NUMBER76_tree);

                                    array.add(new Double((NUMBER76 != null ? NUMBER76.getText() : null)));

                                }
                                break;

                                default:
                                    if (cnt13 >= 1) break loop13;
                                    EarlyExitException eee =
                                            new EarlyExitException(13, input);
                                    throw eee;
                            }
                            cnt13++;
                        } while (true);


                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }

                    retval.value = new Atom(array);

                }
                break;
                case 6:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:272:4: ^( VARIABLE_CALL VARIABLE )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        VARIABLE_CALL77 = (CommonTree) match(input, VARIABLE_CALL, FOLLOW_VARIABLE_CALL_in_atom1579);
                        VARIABLE_CALL77_tree = (CommonTree) adaptor.dupNode(VARIABLE_CALL77);

                        root_1 = (CommonTree) adaptor.becomeRoot(VARIABLE_CALL77_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        VARIABLE78 = (CommonTree) match(input, VARIABLE, FOLLOW_VARIABLE_in_atom1581);
                        VARIABLE78_tree = (CommonTree) adaptor.dupNode(VARIABLE78);

                        adaptor.addChild(root_1, VARIABLE78_tree);


                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }


                    retval.value = getVariable((VARIABLE78 != null ? VARIABLE78.getText() : null));


                }
                break;
                case 7:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:275:4: ^( PROPERTY_CALL PROPERTY )
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    {
                        CommonTree _save_last_1 = _last;
                        CommonTree _first_1 = null;
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        _last = (CommonTree) input.LT(1);
                        PROPERTY_CALL79 = (CommonTree) match(input, PROPERTY_CALL, FOLLOW_PROPERTY_CALL_in_atom1624);
                        PROPERTY_CALL79_tree = (CommonTree) adaptor.dupNode(PROPERTY_CALL79);

                        root_1 = (CommonTree) adaptor.becomeRoot(PROPERTY_CALL79_tree, root_1);


                        match(input, Token.DOWN, null);
                        _last = (CommonTree) input.LT(1);
                        PROPERTY80 = (CommonTree) match(input, PROPERTY, FOLLOW_PROPERTY_in_atom1626);
                        PROPERTY80_tree = (CommonTree) adaptor.dupNode(PROPERTY80);

                        adaptor.addChild(root_1, PROPERTY80_tree);


                        match(input, Token.UP, null);
                        adaptor.addChild(root_0, root_1);
                        _last = _save_last_1;
                    }


                    Atom propertyAtom = new Atom((PROPERTY80 != null ? PROPERTY80.getText() : null).substring(1));
                    propertyAtom.setProperty(true);
                    retval.value = propertyAtom;


                }
                break;
                case 8:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:280:4: IDENTIFIER
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    IDENTIFIER81 = (CommonTree) match(input, IDENTIFIER, FOLLOW_IDENTIFIER_in_atom1668);
                    IDENTIFIER81_tree = (CommonTree) adaptor.dupNode(IDENTIFIER81);

                    adaptor.addChild(root_0, IDENTIFIER81_tree);


                    Atom idAtom = new Atom((IDENTIFIER81 != null ? IDENTIFIER81.getText() : null));
                    idAtom.setIdentifier(true);
                    retval.value = idAtom;


                }
                break;
                case 9:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:285:4: function_call
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_function_call_in_atom1724);
                    function_call82 = function_call();

                    state._fsp--;

                    adaptor.addChild(root_0, function_call82.getTree());
                    retval.value = (function_call82 != null ? function_call82.value : null);

                }
                break;
                case 10:
                    // src/main/java/com/tinkerpop/gremlin/compiler/GremlinEvaluator.g:286:4: '(' statement ')'
                {
                    root_0 = (CommonTree) adaptor.nil();

                    _last = (CommonTree) input.LT(1);
                    char_literal83 = (CommonTree) match(input, 70, FOLLOW_70_in_atom1777);
                    _last = (CommonTree) input.LT(1);
                    pushFollow(FOLLOW_statement_in_atom1780);
                    statement84 = statement();

                    state._fsp--;

                    adaptor.addChild(root_0, statement84.getTree());
                    _last = (CommonTree) input.LT(1);
                    char_literal85 = (CommonTree) match(input, 71, FOLLOW_71_in_atom1782);

                }
                break;

            }
            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    // Delegated rules


    public static final BitSet FOLLOW_statement_in_program48 = new BitSet(new long[]{0x18000096FF981892L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_NEWLINE_in_program52 = new BitSet(new long[]{0x18000096FF981892L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_if_statement_in_statement73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_statement_in_statement103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_statement_in_statement158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_definition_statement_in_statement184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_statement_in_statement201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_statement214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gpath_statement_in_statement239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_statement267 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_statement269 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_statement_in_statement273 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_59_in_statement295 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement299 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_statement_in_statement303 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_60_in_statement320 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement325 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_statement_in_statement329 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_statement345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_include_statement388 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_include_statement390 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PATH_in_path_definition_statement427 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_path_definition_statement431 = new BitSet(new long[]{0x0000000200001000L});
    public static final BitSet FOLLOW_gpath_statement_in_path_definition_statement436 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_path_definition_statement443 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_path_definition_statement447 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GPATH_in_gpath_statement497 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_step_in_gpath_statement500 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_STEP_in_step538 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_in_step541 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_step543 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREDICATES_in_step547 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PREDICATE_in_step552 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_step554 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_token596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_statement615 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_if_statement618 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_if_statement622 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_if_statement625 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_while_statement653 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COND_in_while_statement656 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_while_statement660 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_while_statement663 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_statement690 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_foreach_statement692 = new BitSet(new long[]{0x18000096FFD81890L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_statement_in_foreach_statement696 = new BitSet(new long[]{0x18000096FFD81890L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_block_in_foreach_statement698 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REPEAT_in_repeat_statement726 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_repeat_statement730 = new BitSet(new long[]{0x18000096FFD81890L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_block_in_repeat_statement732 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_block771 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block774 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_73_in_expression802 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression807 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_operation_in_expression811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_74_in_expression825 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression829 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_operation_in_expression833 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_75_in_expression847 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression852 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_operation_in_expression856 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_77_in_expression870 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression875 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_operation_in_expression879 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_76_in_expression893 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression897 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_operation_in_expression901 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_78_in_expression915 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_expression919 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_operation_in_expression923 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_operation_in_expression936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_operation981 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_operation985 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_operation_in_operation989 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_80_in_operation1003 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_operation1007 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_operation_in_operation1011 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binary_operation_in_operation1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_binary_operation1061 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_binary_operation1065 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_operation_in_binary_operation1069 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_82_in_binary_operation1088 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_binary_operation1092 = new BitSet(new long[]{0x18000096FF981898L, 0x000000000007FE40L});
    public static final BitSet FOLLOW_operation_in_binary_operation1096 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_binary_operation1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_in_function_definition_statement1170 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_definition_statement1173 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_definition_statement1176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1180 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_definition_statement1184 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition_statement1188 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_definition_statement1193 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_definition_statement1198 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_function_definition_statement1200 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_function_definition_statement1209 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_function_call1246 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNC_NAME_in_function_call1249 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NS_in_function_call1252 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1256 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_function_call1260 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_call1264 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_function_call1269 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_function_call1274 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_function_call1278 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NUM_in_atom1322 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NUMBER_in_atom1324 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STR_in_atom1379 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_atom1381 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOOL_in_atom1434 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOLEAN_in_atom1438 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_atom1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARR_in_atom1561 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NUMBER_in_atom1564 = new BitSet(new long[]{0x0000010000000008L});
    public static final BitSet FOLLOW_VARIABLE_CALL_in_atom1579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VARIABLE_in_atom1581 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_CALL_in_atom1624 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PROPERTY_in_atom1626 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atom1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_atom1724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_atom1777 = new BitSet(new long[]{0x18000096FF981890L, 0x000000000007FEC0L});
    public static final BitSet FOLLOW_statement_in_atom1780 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_atom1782 = new BitSet(new long[]{0x0000000000000002L});

}
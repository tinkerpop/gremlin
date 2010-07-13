package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.GremlinLexer;
import com.tinkerpop.gremlin.compiler.GremlinParser;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

/**
 * @author Pavel A. Yaskevich
 */
public class Gremlin {

    public static Iterable evaluate(final String code) throws RecognitionException {
        GremlinEvaluator.EMBEDDED = true;

        ANTLRStringStream input = new ANTLRStringStream(code + "\n");
        return evaluate(input);
    }

    public static Iterable evaluate(final CharStream input) throws RecognitionException {
        final GremlinLexer lexer = new GremlinLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        final GremlinParser parser = new GremlinParser(tokens);
        final GremlinParser.program_return r = parser.program();

        final CommonTree t = (CommonTree) r.getTree();

        //System.out.println(t.toStringTree());

        final CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
        final GremlinEvaluator walker = new GremlinEvaluator(nodes);

        return walker.program().results;
    }

}

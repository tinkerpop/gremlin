package com.tinkerpop.gremlin.lang;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import junit.framework.TestCase;
import com.tinkerpop.gremlin.Evaluator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinLanguageTest extends TestCase {

    public static void main(String args[]) throws Exception {
        //GremlinLexer lex = new GremlinLexer(new ANTLRFileStream("/Users/marko/software/gremlin/trunk/src/test/resources/com/tinkerpop/gremlin/lang/gremlin-examples.txt"));
        GremlinLexer lex = new GremlinLexer(new ANTLRStringStream("$i := 2"));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        GremlinParser g = new GremlinParser(tokens);

        try {
            GremlinParser.program_return ret = g.program();
            CommonTree tree = (CommonTree) ret.getTree();
            System.out.println("TREE: " + tree.toStringTree());
            CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            nodes.setTokenStream(tokens);
            Gremlin walker = new Gremlin(nodes, new Evaluator());
            walker.program();

        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}

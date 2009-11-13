package com.tinkerpop.gremlin;

import jline.ConsoleReader;

import java.io.PrintWriter;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import com.tinkerpop.gremlin.lang.GremlinParser;
import com.tinkerpop.gremlin.lang.GremlinLexer;
import com.tinkerpop.gremlin.lang.Gremlin;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Console {

    public static void main(String[] args) throws Exception {

        Console console = new Console();
        ConsoleReader reader = new ConsoleReader();
        reader.setBellEnabled(false);
        reader.setUseHistory(true);

        String line;
        Evaluator evaluator = new Evaluator(System.out);
        while ((line = reader.readLine("gremlin> ")) != null) {

            if (line.equalsIgnoreCase("quit"))
                break;
            else {
                console.evaluate(line, evaluator);
            }

        }

    }

    public void evaluate(String line, Evaluator evaluator) {
        GremlinLexer lex = new GremlinLexer(new ANTLRStringStream(line));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        GremlinParser g = new GremlinParser(tokens);

        try {
            GremlinParser.program_return ret = g.program();
            CommonTree tree = (CommonTree) ret.getTree();
            CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            nodes.setTokenStream(tokens);
            Gremlin walker = new Gremlin(nodes, evaluator);
            walker.program();

        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }

}

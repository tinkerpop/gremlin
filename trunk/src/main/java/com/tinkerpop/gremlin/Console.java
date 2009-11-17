package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.db.tg.TinkerVertex;
import jline.ConsoleReader;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;

import java.io.IOException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Console {

    public static void main(String[] args) throws IOException {

        ConsoleReader reader = new ConsoleReader();
        reader.setBellEnabled(false);
        reader.setUseHistory(true);
        TinkerGraph graph = TinkerGraphFactory.createTinkerGraph();
        TinkerVertex marko = graph.getVertex("1");
        String line;
        Evaluator evaluator = new Evaluator(marko);
        while ((line = reader.readLine("gremlin> ")) != null) {
            if (line.equalsIgnoreCase("quit"))
                break;
            else if (line.length() > 0) {
                try {
                    evaluator.evaluate(line);
                } catch (JXPathInvalidSyntaxException e) {
                    System.out.println(e.getMessage().replace("Invalid XPath:", "Invalid expression:"));
                }
            }

        }

    }
}

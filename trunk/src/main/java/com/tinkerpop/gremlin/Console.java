package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.lang.SyntaxErrorException;
import jline.ArgumentCompletor;
import jline.ConsoleReader;
import jline.SimpleCompletor;
import org.apache.commons.jxpath.JXPathException;

import java.io.IOException;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Console {

    private static final String PRINT_SPACING = "  ";

    public static void main(String[] args) throws IOException {

        ConsoleReader reader = new ConsoleReader();
        reader.setBellEnabled(false);
        reader.setUseHistory(true);
        reader.addCompletor(new ArgumentCompletor(
                new SimpleCompletor(new String[]{"outEdges", "inEdges", "bothEdges",
                        "outVertex", "inVertex", "bothVertex"})));

        String line;
        GremlinEvaluator gremlinEvaluator = new GremlinEvaluator();
        while ((line = reader.readLine("gremlin> ")) != null) {
            if (line.equalsIgnoreCase("quit"))
                break;
            else if (line.length() > 0) {
                try {
                    List results = gremlinEvaluator.evaluate(line);
                    if (null != results) {
                        for (Object o : results) {
                            System.out.println(PRINT_SPACING + o);
                        }
                    }
                } catch (JXPathException e) {
                    System.out.println(e.getMessage().replace("Invalid XPath:", "Invalid statement:"));
                } catch (SyntaxErrorException e) {
                    System.out.println(e.getMessage());
                }
            }

        }

    }
}

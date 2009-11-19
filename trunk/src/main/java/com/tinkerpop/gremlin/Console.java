package com.tinkerpop.gremlin;

import jline.ArgumentCompletor;
import jline.ConsoleReader;
import jline.SimpleCompletor;
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;

import java.io.IOException;
import java.util.List;

import com.tinkerpop.gremlin.lang.SyntaxErrorException;

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
                    for (Object o : results) {
                        System.out.println(PRINT_SPACING + o);
                    }
                } catch (JXPathInvalidSyntaxException e) {
                    System.out.println(e.getMessage().replace("Invalid XPath:", "Invalid expression:"));
                } catch (JXPathInvalidAccessException e) {
                    System.out.println(e.getMessage());
                } catch (JXPathFunctionNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch(SyntaxErrorException e) {
                    System.out.println(e.getMessage());
                }
            }

        }

    }
}

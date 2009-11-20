package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.lang.EvaluationErrorException;
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

    private static final String MIDSTATEMENT_SPACING = "           ";
    private static final String PRINT_RETURN = "==>";
    private static final String PRINT_SPACING = "   ";
    private static final String NULL = "null";
    private static final String EMPTY = "[]";

    public static void main(String[] args) throws IOException {

        ConsoleReader reader = new ConsoleReader();
        reader.setBellEnabled(false);
        reader.setUseHistory(true);
        reader.addCompletor(new ArgumentCompletor(
                new SimpleCompletor(new String[]{"outEdges", "inEdges", "bothEdges",
                        "outVertex", "inVertex", "bothVertex"})));

        GremlinEvaluator gremlinEvaluator = new GremlinEvaluator();
        String line = "";
        System.out.println();
        System.out.println("         \\,,,/");
        System.out.println("         (o o)");
        System.out.println("-----oOOo-(_)-oOOo-----");
        while (line != null) {
            if (gremlinEvaluator.inStatement())
                line = reader.readLine(MIDSTATEMENT_SPACING);
            else {
                line = reader.readLine("gremlin> ");
                if (line.equalsIgnoreCase("quit"))
                    break;
                else if(line.equals("?")) {
                    System.out.println(PRINT_SPACING + "Gremlin 0.1");
                    System.out.println(PRINT_SPACING + "'quit': exit gremlin");
                    line = "";
                }
            }

            if (line.length() > 0) {
                try {
                    List results = gremlinEvaluator.evaluate(line);
                    if (null != results) {
                        if (results.size() > 0) {
                            for (Object o : results) {
                                System.out.println(PRINT_RETURN + o);
                            }
                        } else {
                            System.out.println(PRINT_RETURN + EMPTY);
                        }
                    }
                } catch (JXPathException e) {
                    System.out.println(e.getMessage());
                } catch (SyntaxErrorException e) {
                    System.out.println(e.getMessage());
                } catch (EvaluationErrorException e) {
                    System.out.println(e.getMessage());
                }
            }

        }

    }
}

package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.pipes.SingleIterator;
import jline.ConsoleReader;
import jline.History;
import org.codehaus.groovy.tools.shell.Groovysh;
import org.codehaus.groovy.tools.shell.IO;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Console {

    private static final String PROMPT = "gremlin> ";
    private static final String EMPTY = "";
    private static final String QUIT = "quit";
    private static final String RETURN = "==>";
    private static final String HISTORY_FILE = ".gremlin_history";
    private static final String HISTORY_ERROR = "Error: Can't set history file to " + HISTORY_FILE;


    public static void main(String[] args) throws Exception {
        final PrintStream output = System.out;

        final ConsoleReader reader = new ConsoleReader();
        reader.setBellEnabled(false);
        reader.setUseHistory(true);

        try {
            History history = new History();
            history.setHistoryFile(new File(HISTORY_FILE));
            reader.setHistory(history);
        } catch (IOException e) {
            System.err.println(HISTORY_ERROR);
        }

        output.println();
        output.println("         \\,,,/");
        output.println("         (o o)");
        output.println("-----oOOo-(_)-oOOo-----");


        Groovysh groovy = new Groovysh(new IO(System.in, new NullOutputStream(), System.err));
        groovy.execute("import com.tinkerpop.blueprints.pgm.*");
        groovy.execute("import com.tinkerpop.blueprints.pgm.impls.tg.*");
        //groovy.execute("new GroovyGremlin()");

        new GroovyGremlin();
        String line = "";
        while (line != null) {
            try {
                line = reader.readLine(PROMPT).trim();
                if (line.equals(QUIT))
                    return;
                Object result = groovy.execute(line);
                if (result == null) {
                    while (result == null) {
                        result = groovy.execute(reader.readLine(EMPTY).trim());
                    }
                }

                Iterator itty;
                if (result instanceof Iterator) {
                    itty = (Iterator) result;
                } else if (result instanceof Iterable) {
                    itty = ((Iterable) result).iterator();
                } else if (result instanceof Map) {
                    itty = ((Map) result).entrySet().iterator();
                } else {
                    itty = new SingleIterator<Object>(result);
                }

                while (itty.hasNext()) {
                    output.println(RETURN + itty.next());
                }
            } catch (Exception e) {
                output.println(e.getMessage().replace("startup failed:", "").replace("groovysh_parse:","").trim());
            }

        }
    }

    private static class NullOutputStream extends OutputStream {
        public void write(int value) {

        }
    }

}
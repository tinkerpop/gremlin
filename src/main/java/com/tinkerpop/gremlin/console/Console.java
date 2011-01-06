package com.tinkerpop.gremlin.console;

import com.tinkerpop.gremlin.Gremlin;
import jline.History;
import org.codehaus.groovy.tools.shell.Groovysh;
import org.codehaus.groovy.tools.shell.IO;
import org.codehaus.groovy.tools.shell.InteractiveShellRunner;

import java.io.File;
import java.io.IOException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Console {

    private static final String HISTORY_FILE = ".gremlin_history";

    public static void main(final String[] args) {
        IO io = new IO(System.in, System.out, System.err);
        io.out.println();
        io.out.println("         \\,,,/");
        io.out.println("         (o o)");
        io.out.println("-----oOOo-(_)-oOOo-----");

        final Groovysh groovy = new Groovysh();
        groovy.setResultHook(new NullResultHookClosure(groovy));
        for (String imps : Imports.getImports()) {
            groovy.execute("import " + imps);
        }
        groovy.setResultHook(new ResultHookClosure(groovy, io));
        groovy.setHistory(new History());

        final InteractiveShellRunner runner = new InteractiveShellRunner(groovy, new PromptClosure(groovy));
        runner.setErrorHandler(new ErrorHookClosure(runner, io));
        try {
            runner.setHistory(new History(new File(HISTORY_FILE)));
        } catch (IOException e) {
            io.err.println("Unable to create history file: " + HISTORY_FILE);
        }

        new Gremlin();
        try {
            runner.run();
        } catch (Error e) {
            System.err.println(e.getMessage());
        }
    }
}
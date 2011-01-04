package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.pipes.SingleIterator;
import groovy.lang.Closure;
import jline.History;
import org.codehaus.groovy.control.MultipleCompilationErrorsException;
import org.codehaus.groovy.tools.shell.Groovysh;
import org.codehaus.groovy.tools.shell.IO;
import org.codehaus.groovy.tools.shell.InteractiveShellRunner;

import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Console {

    private static final String PROMPT = "gremlin> ";
    private static final String RETURN = "==>";
    private static final String HISTORY_FILE = ".gremlin_history";
    private static final String HISTORY_ERROR = "Error: Can't set history file to " + HISTORY_FILE;


    public static void main(String[] args) throws Exception {
        final PrintStream output = System.out;


        output.println();
        output.println("         \\,,,/");
        output.println("         (o o)");
        output.println("-----oOOo-(_)-oOOo-----");


        Groovysh groovy = new Groovysh(new IO(System.in, System.out, System.err));
        groovy.setResultHook(new NullResultHookClosure(groovy));
        groovy.execute("import com.tinkerpop.gremlin.groovy.*");
        groovy.execute("import com.tinkerpop.gremlin.groovy.Tokens.T");
        groovy.execute("import com.tinkerpop.blueprints.pgm.*");
        groovy.execute("import com.tinkerpop.blueprints.pgm.impls.tg.*");
        groovy.setResultHook(new ResultHookClosure(groovy));
        groovy.setHistory(new History());
        groovy.getHistory().setHistoryFile(new File(HISTORY_FILE));

        InteractiveShellRunner runner = new InteractiveShellRunner(groovy, new PromptClosure(groovy));
        runner.setErrorHandler(new ErrorHookClosure(runner));
        //groovy.setRunner(runner);

        new GroovyGremlin();
        try {
            runner.run();
        } catch (Error e) {
            System.exit(0);
        }
    }

    private static class ArrayIterator implements Iterator {

        private Object[] array;
        private int count = 0;

        public ArrayIterator(final Object[] array) {
            this.array = array;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Object next() {
            if (count > array.length)
                throw new NoSuchElementException();

            return array[count++];
        }

        public boolean hasNext() {
            return count < array.length;
        }
    }

    private static class ErrorHookClosure extends Closure {
        public ErrorHookClosure(Object owner) {
            super(owner);
        }

        public Object call(Object[] args) {
            MultipleCompilationErrorsException e = (MultipleCompilationErrorsException) args[0];
            String message = e.getMessage();
            message = message.replace("startup failed:", "");
            System.out.println(message.trim());
            return null;
        }
    }

    private static class ResultHookClosure extends Closure {
        public ResultHookClosure(Object owner) {
            super(owner);
        }

        public Object call(Object[] args) {
            Object result = args[0];
            Iterator itty;
            if (result instanceof Iterator) {
                itty = (Iterator) result;
            } else if (result instanceof Iterable) {
                itty = ((Iterable) result).iterator();
            } else if (result instanceof Object[]) {
                itty = new ArrayIterator((Object[]) result);
            } else if (result instanceof Map) {
                itty = ((Map) result).entrySet().iterator();
            } else {
                itty = new SingleIterator<Object>(result);
            }

            while (itty.hasNext()) {
                System.out.println(RETURN + itty.next());
            }

            return null;
        }
    }

    private static class NullResultHookClosure extends Closure {
        public NullResultHookClosure(Object owner) {
            super(owner);
        }

        public Object call(Object[] args) {
            return null;
        }
    }

    private static class PromptClosure extends Closure {
        public PromptClosure(Object owner) {
            super(owner);
        }

        public Object call() {
            return PROMPT;
        }
    }


}
package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import junit.framework.TestCase;
import org.antlr.runtime.RecognitionException;

import java.io.File;
import java.net.URL;
import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class BaseTest extends TestCase {

    double timer = -1.0d;

    public List<String> generateUUIDs(int count) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            list.add(UUID.randomUUID().toString());
        }
        return list;
    }

    public static void printIterator(final Iterator itty) {
        while (itty.hasNext()) {
            System.out.println(itty.next());
        }
    }

    public static int count(final Iterator iterator) {
        int counter = 0;
        while (iterator.hasNext()) {
            iterator.next();
            counter++;
        }
        return counter;
    }

    public static int count(final Iterable iterable) {
        return count(iterable.iterator());
    }

    public static List asList(final Iterable iterable) {
        return asList(iterable.iterator());
    }

    public static List asList(final Iterator iterator) {
        List list = new ArrayList();
        while (iterator.hasNext()) {

            list.add(iterator.next());
        }
        return list;
    }

    public List evaluateGremlinScriptIterable(final String script, final GremlinScriptContext context, boolean printStatistics) throws RecognitionException {

        final GremlinScriptEngine engine = new GremlinScriptEngine();
        Iterable itty = null;

        this.stopWatch();
        try {
            itty = (Iterable) ((Iterable) engine.eval(script, context)).iterator().next();
        } catch (Exception e) {
        }

        if (printStatistics)
            printPerformance(script, 1, "pipe constructed", this.stopWatch());
        else
            this.stopWatch();

        this.stopWatch();
        // todo: make a "illegal pipe constructed error"
        if (null == itty) {
            this.stopWatch();
            return null;
        }
        List results = asList(itty);
        if (printStatistics)
            printPerformance(script, 1, "pipe listed", this.stopWatch());
        else
            this.stopWatch();
        return results;
    }

    public Object evaluateGremlinScriptPrimitive(final String script, final GremlinScriptContext context, boolean printStatistics) throws RecognitionException {
        this.stopWatch();
        final GremlinScriptEngine engine = new GremlinScriptEngine();

        Object object = ((Iterable) engine.eval(script, context)).iterator().next();
        if (printStatistics)
            printPerformance(script, 1, "pipe evaluated", this.stopWatch());
        else
            this.stopWatch();
        return object;
    }

    public List evaluateGremlinScriptIterable(final String script, boolean printStatistics) throws RecognitionException {
        return this.evaluateGremlinScriptIterable(script, new GremlinScriptContext(), printStatistics);
    }

    public Object evaluateGremlinScriptPrimitive(final String script, boolean printStatistics) throws RecognitionException {
        return this.evaluateGremlinScriptPrimitive(script, new GremlinScriptContext(), printStatistics);
    }


    public double stopWatch() {
        if (this.timer == -1.0d) {
            this.timer = System.nanoTime() / 1000000.0d;
            return -1.0d;
        } else {
            double temp = (System.nanoTime() / 1000000.0d) - this.timer;
            this.timer = -1.0d;
            return temp;
        }
    }

    public static void printPerformance(String name, Integer events, String eventName, double timeInMilliseconds) {
        if (null != events)
            System.out.println("\t" + name + ": " + events + " " + eventName + " in " + timeInMilliseconds + "ms");
        else
            System.out.println("\t" + name + ": " + eventName + " in " + timeInMilliseconds + "ms");
    }

    public static <T> UnaryOperation createUnary(T object) {
        final Atom<T> argument = (object instanceof Atom) ? (Atom<T>) object : new Atom<T>(object);
        return new UnaryOperation(argument);
    }

    public static List<Operation> createUnaryArgs(Object... objects) {
        List<Operation> args = new ArrayList<Operation>();
        if (null != objects) {
            for (Object object : objects) {
                args.add(createUnary(object));
            }
        }
        return args;
    }

    public static Operation[] createUnaryArgsArray(Object... objects) {
        Operation[] args = new Operation[objects.length];
        if (null != objects) {
            for (int i = 0; i < objects.length; i++) {
                args[i] = createUnary(objects[i]);
            }
        }
        return args;
    }

    public static Class[] getClasses(final String packageName) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }

    public static List<Class> findClasses(final File directory, final String packageName) throws Exception {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}

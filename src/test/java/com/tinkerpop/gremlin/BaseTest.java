package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BaseTest extends TestCase {

    double timer = -1.0d;

    public void testTrue() {
        assertTrue(true);
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
        List list = new ArrayList();
        for (Object object : iterable) {
            list.add(object);
        }
        return list;
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

    public static UnaryOperation createUnary(Object object) {
        return new UnaryOperation(new Atom(object));
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
}

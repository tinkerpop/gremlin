package com.tinkerpop.gremlin;

import junit.framework.TestCase;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BaseTest extends TestCase {

    double timer = -1.0d;

    public void testTrue() {
        assertTrue(true);
    }

    public static List<String> generateUUIDs(int number) {
        List<String> uuids = new ArrayList<String>();
        for (int i = 0; i < number; i++) {
            uuids.add(UUID.randomUUID().toString());
        }
        return uuids;
    }

    public static List<String> generateUUIDs(String prefix, int number) {
        List<String> uuids = new ArrayList<String>();
        for (int i = 0; i < number; i++) {
            uuids.add(prefix + UUID.randomUUID().toString());
        }
        return uuids;
    }

    public static void printCollection(final Collection collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
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

    public static List asList(final Object x, final int times) {
        List list = new ArrayList();
        for (int i = 0; i < times; i++) {
            list.add(x);
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
}

package com.tinkerpop.gremlin;

import junit.framework.TestCase;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class BaseTest extends TestCase {

    long timer = -1l;

    public static void printList(List list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void printIterator(Iterator itty) {
        while (itty.hasNext()) {
            System.out.println(itty.next());
        }
    }

    public static int countIterator(Iterator itty) {
        int counter = 0;
        while (itty.hasNext()) {
            itty.next();
            counter++;
        }
        return counter;
    }

    public static List asList(Object x, int times) {
        List list = new ArrayList();
        for(int i=0; i<times; i++) {
            list.add(x);
        }
        return list;
    }

    public void testUnmodifiableListChecker() {
        assertTrue(FunctionHelper.isUnmodifiable(Collections.EMPTY_LIST));
        assertFalse(FunctionHelper.isUnmodifiable(new ArrayList()));
    }

    public double stopWatch() {
        if(this.timer == -1l) {
            this.timer = System.currentTimeMillis();
            return -1.0d;
        } else {

            double temp = ((double) System.currentTimeMillis() - (double)this.timer) /  1000.0d;
            this.timer = -1l;
            return temp;
        }


    }

}

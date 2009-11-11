package com.tinkerpop.gremlin;

import java.util.Random;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TestFunctions {

    protected static final Random random = new Random();

    public static boolean test() {
        System.out.println("here");
        return true;
    }

    public static Object random(Integer value) {
        return random.nextInt(value);
    }


}

package com.tinkerpop.gremlin.core;

import com.tinkerpop.gremlin.Pair;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AddFunctionTest extends TestCase {

    public void testAddFunction() {
        Float a = 1.1f;
        Float b = 1.2f;
        Integer c = 1;
        Integer d = 2;

        assertEquals(1.1f + 1.2f, new AddFunction().evaluate(new Pair(a, b)));
        assertEquals(1.1f + 2, new AddFunction().evaluate(new Pair(a, d)));
        assertEquals(1 + 2, new AddFunction().evaluate(new Pair(c,d)));
    }
}

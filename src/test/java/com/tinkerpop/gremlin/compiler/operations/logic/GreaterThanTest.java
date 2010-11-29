package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GreaterThanTest extends BaseTest {

    public void testDifferentNumberGreaterThan() {
        GreaterThan gt = new GreaterThan(createUnaryArgsArray(2.0, 1l));
        assertTrue(gt.compute().getValue());

        gt = new GreaterThan(createUnaryArgsArray(2.0, 2));
        assertFalse(gt.compute().getValue());

        gt = new GreaterThan(createUnaryArgsArray(2.0, 1.0));
        assertTrue(gt.compute().getValue());
    }

}

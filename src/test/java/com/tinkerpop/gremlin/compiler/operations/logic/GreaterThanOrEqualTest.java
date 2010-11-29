package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GreaterThanOrEqualTest extends BaseTest {

    public void testDifferentNumberGreaterThanOrEqual() {
        GreaterThanOrEqual gt = new GreaterThanOrEqual(createUnaryArgsArray(2.0, 1l));
        assertTrue(gt.compute().getValue());

        gt = new GreaterThanOrEqual(createUnaryArgsArray(2.0, 2));
        assertTrue(gt.compute().getValue());

        gt = new GreaterThanOrEqual(createUnaryArgsArray(2.0, 1.0));
        assertTrue(gt.compute().getValue());
    }
}
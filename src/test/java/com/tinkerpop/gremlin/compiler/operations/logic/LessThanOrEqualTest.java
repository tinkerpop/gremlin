package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LessThanOrEqualTest extends BaseTest {

    public void testDifferentNumberGreaterThanOrEqual() {
        LessThanOrEqual lt = new LessThanOrEqual(createUnaryArgsArray(2.0, 1l));
        assertFalse(lt.compute().getValue());

        lt = new LessThanOrEqual(createUnaryArgsArray(2.0, 2));
        assertTrue(lt.compute().getValue());

        lt = new LessThanOrEqual(createUnaryArgsArray(1.0, 2.0));
        assertTrue(lt.compute().getValue());
    }
}
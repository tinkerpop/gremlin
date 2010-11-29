package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LessThanTest extends BaseTest {

    public void testDifferentNumberGreaterThan() {
        LessThan lt = new LessThan(createUnaryArgsArray(2.0, 1l));
        assertFalse(lt.compute().getValue());

        lt = new LessThan(createUnaryArgsArray(2.0, 2));
        assertFalse(lt.compute().getValue());

        lt = new LessThan(createUnaryArgsArray(1.0, 2.0));
        assertTrue(lt.compute().getValue());
    }

}

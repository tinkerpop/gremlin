package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OrTest extends BaseTest {

    public void testOrBoolean() {
        Or or = new Or(createUnaryArgsArray(true, false));
        assertTrue(or.compute().getValue());

        or = new Or(createUnaryArgsArray(true, true));
        assertTrue(or.compute().getValue());

        or = new Or(createUnaryArgsArray(false, true));
        assertTrue(or.compute().getValue());

        or = new Or(createUnaryArgsArray(false, false));
        assertFalse(or.compute().getValue());
    }

}
package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AndTest extends BaseTest {

    public void testAndBoolean() {
        And and = new And(createUnaryArgsArray(true, false));
        assertFalse(and.compute().getValue());

        and = new And(createUnaryArgsArray(true, true));
        assertTrue(and.compute().getValue());

        and = new And(createUnaryArgsArray(false, true));
        assertFalse(and.compute().getValue());

        and = new And(createUnaryArgsArray(false, false));
        assertFalse(and.compute().getValue());
    }

}
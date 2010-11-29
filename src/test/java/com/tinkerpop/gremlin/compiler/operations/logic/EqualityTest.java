package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EqualityTest extends BaseTest {

    public void testSameObjectEquality() {
        Object object = new Object();
        Equality equals = new Equality(createUnaryArgsArray(object, object));
        assertTrue(equals.compute().getValue());
    }

    public void testNumberEquality() {
        Equality equals = new Equality(createUnaryArgsArray(1.0, 1.0));
        assertTrue(equals.compute().getValue());

        equals = new Equality(createUnaryArgsArray(1.0, 1));
        assertTrue(equals.compute().getValue());

        equals = new Equality(createUnaryArgsArray(1.0d, 1l));
        assertTrue(equals.compute().getValue());

        equals = new Equality(createUnaryArgsArray(2.0, 1l));
        assertFalse(equals.compute().getValue());

        equals = new Equality(createUnaryArgsArray(2.451234, 2.451234d));
        assertTrue(equals.compute().getValue());

        equals = new Equality(createUnaryArgsArray(2, 5));
        assertFalse(equals.compute().getValue());
    }
}

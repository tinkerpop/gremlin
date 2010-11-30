package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnEqualityTest extends BaseTest {

    public void testSameObjectEquality() {
        Object a = new Object();
        Object b = new Object();
        UnEquality equals = new UnEquality(createUnaryArgsArray(a, b));
        assertTrue(equals.compute().getValue());
    }

    public void testNumberEquality() {
        UnEquality equals = new UnEquality(createUnaryArgsArray(1.0, 1.0));
        assertFalse(equals.compute().getValue());

        equals = new UnEquality(createUnaryArgsArray(1.0, 1));
        assertFalse(equals.compute().getValue());

        equals = new UnEquality(createUnaryArgsArray(1.0d, 1l));
        assertFalse(equals.compute().getValue());

        equals = new UnEquality(createUnaryArgsArray(2.0, 1l));
        assertTrue(equals.compute().getValue());

        equals = new UnEquality(createUnaryArgsArray(2.451234, 2.451234d));
        assertFalse(equals.compute().getValue());

        equals = new UnEquality(createUnaryArgsArray(2, 5));
        assertTrue(equals.compute().getValue());
    }

}
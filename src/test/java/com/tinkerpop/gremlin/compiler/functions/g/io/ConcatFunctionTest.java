package com.tinkerpop.gremlin.compiler.functions.g.io;

import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ConcatFunctionTest extends TestCase {

    public void testOneStringConcat() {
        Function function = new ConcatFunction();
        Atom atom = function.compute(TestHelper.createUnaryArgs("marko"));
        assertEquals(atom.getValue(), "marko");
    }

    public void testTwoStringConcat() {
        Function function = new ConcatFunction();
        Atom atom = function.compute(TestHelper.createUnaryArgs("marko", "rodriguez"));
        assertEquals(atom.getValue(), "markorodriguez");
    }

    public void testThreeObjectConcat() {
        Function function = new ConcatFunction();
        Atom atom = function.compute(TestHelper.createUnaryArgs("marko", 1, "rodriguez", 7.0d));
        assertEquals(atom.getValue(), "marko1rodriguez7.0");
    }
}

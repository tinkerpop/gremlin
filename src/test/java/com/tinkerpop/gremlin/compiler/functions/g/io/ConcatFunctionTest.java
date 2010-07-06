package com.tinkerpop.gremlin.compiler.functions.g.io;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ConcatFunctionTest extends BaseTest {

    public void testOneStringConcat() {
        Function function = new ConcatFunction();
        this.stopWatch();
        Atom atom = function.compute(TestHelper.createUnaryArgs("marko"));
        printPerformance(function.getFunctionName() + " function", 1, "argument concat", this.stopWatch());
        assertEquals(atom.getValue(), "marko");
    }

    public void testTwoStringConcat() {
        Function function = new ConcatFunction();
        this.stopWatch();
        Atom atom = function.compute(TestHelper.createUnaryArgs("marko", "rodriguez"));
        printPerformance(function.getFunctionName() + " function", 2, "argument concat", this.stopWatch());
        assertEquals(atom.getValue(), "markorodriguez");
    }

    public void testThreeObjectConcat() {
        Function function = new ConcatFunction();
        this.stopWatch();
        Atom atom = function.compute(TestHelper.createUnaryArgs("marko", 1, "rodriguez", 7.0d));
        printPerformance(function.getFunctionName() + " function", 4, "argument concat", this.stopWatch());
        assertEquals(atom.getValue(), "marko1rodriguez7.0");
    }
}

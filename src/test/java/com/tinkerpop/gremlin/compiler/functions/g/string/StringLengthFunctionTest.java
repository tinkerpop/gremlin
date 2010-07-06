package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StringLengthFunctionTest extends BaseTest {

    public void testStringLength() {
        Function<Double> function = new StringLengthFunction();
        this.stopWatch();
        Atom<Double> atom = function.compute(createUnaryArgs("marko"));
        printPerformance(function.getFunctionName() + " function", 1, "string length of 5", this.stopWatch());
        assertEquals(atom.getValue(), 5.0);
        this.stopWatch();
        atom = function.compute(createUnaryArgs(""));
        printPerformance(function.getFunctionName() + " function", 1, "string length of 0", this.stopWatch());
        assertEquals(atom.getValue(), 0.0);
    }

    public void testIllegalArguments() {
        try {
            Function<Double> function = new StringLengthFunction();
            function.compute(createUnaryArgs());
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}

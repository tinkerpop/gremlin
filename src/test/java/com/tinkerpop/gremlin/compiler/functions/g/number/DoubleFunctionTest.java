package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DoubleFunctionTest extends BaseTest {

    public void testDouble() {
        Function<Double> function = new DoubleFunction();
        this.stopWatch();
        Atom<Double> atom = function.compute(createUnaryArgs("1.0"));
        printPerformance(function.getFunctionName() + " function", 1, "double parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.0d);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1.0f));
        printPerformance(function.getFunctionName() + " function", 1, "double parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.0d);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1l));
        printPerformance(function.getFunctionName() + " function", 1, "double parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.0d);
    }
}
package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RoundFunctionTest extends BaseTest {

    public void testRound() {
        Function<Double> function = new RoundFunction();
        this.stopWatch();
        Atom<Double> atom = function.compute(TestHelper.createUnaryArgs(1.4));
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        Double real = atom.getValue();
        assertEquals(real, 1.0);

        this.stopWatch();
        atom = function.compute(TestHelper.createUnaryArgs(1.5));
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        real = atom.getValue();
        assertEquals(real, 2.0);

    }
}


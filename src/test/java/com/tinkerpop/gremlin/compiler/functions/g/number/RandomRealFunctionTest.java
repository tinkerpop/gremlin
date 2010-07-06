package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RandomRealFunctionTest extends BaseTest {

    public void testRangeOfReal() {
        Function<Double> function = new RandomRealFunction();
        this.stopWatch();
        Atom<Double> atom = function.compute(new ArrayList<Operation>());
        printPerformance(function.getFunctionName() + " function", 1, "random generation", this.stopWatch());
        assertTrue(atom.isNumber());
        Double real = atom.getValue();
        assertTrue(real < 1.000001d);
        assertTrue(real > -0.000001d);
    }
}

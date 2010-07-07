package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LongFunctionTest extends BaseTest {

    public void testLong() {
        Function<Long> function = new LongFunction();
        this.stopWatch();
        Atom<Long> atom = function.compute(createUnaryArgs("1.02"));
        printPerformance(function.getFunctionName() + " function", 1, "long parse", this.stopWatch());
        assertEquals(atom.getValue(), new Long(1));

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1.0f));
        printPerformance(function.getFunctionName() + " function", 1, "long parse", this.stopWatch());
        assertEquals(atom.getValue(), new Long(1));

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1l));
        printPerformance(function.getFunctionName() + " function", 1, "long parse", this.stopWatch());
        assertEquals(atom.getValue(), new Long(1));
    }
}
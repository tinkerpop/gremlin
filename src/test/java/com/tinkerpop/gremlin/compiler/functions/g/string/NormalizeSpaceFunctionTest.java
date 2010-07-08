package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NormalizeSpaceFunctionTest extends BaseTest {

    public void testNormalizeSpace() {
        Function<String> function = new NormalizeSpaceFunction();
        this.stopWatch();
        Atom<String> atom = function.compute(createUnaryArgs("   marko  "));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "marko");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("\t  \tma r ko\n"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "ma r ko");
    }

    public void testIllegalArguments() {
        try {
            Function<String> function = new NormalizeSpaceFunction();
            function.compute(createUnaryArgs("marko", 2));
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}

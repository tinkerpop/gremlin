package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SubstringAfterFunctionTest extends BaseTest {

    public void testSubstringAfter() {
        Function<String> function = new SubstringAfterFunction();
        this.stopWatch();
        Atom<String> atom = function.compute(createUnaryArgs("marko", "ar"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "ko");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "ma"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "rko");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "o"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "x"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "marko");
    }

    public void testIllegalArguments() {
        try {
            Function<String> function = new SubstringAfterFunction();
            function.compute(createUnaryArgs("marko"));
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}

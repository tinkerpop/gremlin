package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SubstringBeforeFunctionTest extends BaseTest {

    public void testSubstringBefore() {
        Function<String> function = new SubstringBeforeFunction();
        this.stopWatch();
        Atom<String> atom = function.compute(createUnaryArgs("marko", "ar"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "m");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "ma"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "o"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "mark");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "x"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "marko");
    }

    public void testIllegalArguments() {
        try {
            Function<String> function = new SubstringBeforeFunction();
            function.compute(createUnaryArgs("marko"));
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}
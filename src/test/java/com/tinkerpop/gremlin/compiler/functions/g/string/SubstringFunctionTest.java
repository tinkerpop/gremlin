package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SubstringFunctionTest extends BaseTest {

    public void testSubstring() {
        Function<String> function = new SubstringFunction();
        this.stopWatch();
        Atom<String> atom = function.compute(createUnaryArgs("marko",0,3));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "mar");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko",4));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "o");
    }

    public void testIllegalArguments() {
        try {
            Function<String> function = new SubstringFunction();
            function.compute(createUnaryArgs("marko"));
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}

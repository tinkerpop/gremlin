package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TranslateFunctionTest extends BaseTest {

    public void testTranslate() {
        Function<String> function = new TranslateFunction();
        this.stopWatch();
        Atom<String> atom = function.compute(createUnaryArgs("marko","ar","ie"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "mieko");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko","x","z"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "marko");
    }

    public void testIllegalArguments() {
        try {
            Function<String> function = new TranslateFunction();
            function.compute(createUnaryArgs("marko"));
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}

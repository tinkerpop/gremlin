package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TranslateFunctionTest extends BaseTest {

    public void testTranslate() {
        Function<String> function = new TranslateFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        Atom<String> atom = function.compute(createUnaryArgs("marko","ar","ie"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "mieko");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko","x","z"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "marko");
    }

    public void testIllegalArguments() {
        try {
            Function<String> function = new TranslateFunction();
            GremlinScriptContext context = new GremlinScriptContext();
            function.compute(createUnaryArgs("marko"), context);
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}

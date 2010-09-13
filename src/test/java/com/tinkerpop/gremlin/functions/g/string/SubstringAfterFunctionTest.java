package com.tinkerpop.gremlin.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SubstringAfterFunctionTest extends BaseTest {

    public void testSubstringAfter() {
        Function<String> function = new SubstringAfterFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        Atom<String> atom = function.compute(createUnaryArgs("marko", "ar"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "ko");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "ma"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "rko");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "o"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "x"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "marko");
    }

    public void testIllegalArguments() {
        try {
            Function<String> function = new SubstringAfterFunction();
            GremlinScriptContext context = new GremlinScriptContext();
            function.compute(createUnaryArgs("marko"), context);
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}

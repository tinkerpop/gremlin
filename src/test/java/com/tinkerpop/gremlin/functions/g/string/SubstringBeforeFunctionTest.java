package com.tinkerpop.gremlin.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SubstringBeforeFunctionTest extends BaseTest {

    public void testSubstringBefore() {
        Function<String> function = new SubstringBeforeFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        Atom<String> atom = function.compute(createUnaryArgs("marko", "ar"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "m");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "ma"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "o"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "mark");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "x"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "marko");
    }

    public void testIllegalArguments() {
        try {
            Function<String> function = new SubstringBeforeFunction();
            GremlinScriptContext context = new GremlinScriptContext();
            function.compute(createUnaryArgs("marko"), context);
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}
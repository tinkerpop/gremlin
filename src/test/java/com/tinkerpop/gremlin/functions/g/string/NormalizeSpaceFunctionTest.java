package com.tinkerpop.gremlin.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NormalizeSpaceFunctionTest extends BaseTest {

    public void testNormalizeSpace() {
        Function<String> function = new NormalizeSpaceFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        Atom<String> atom = function.compute(createUnaryArgs("   marko  "), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "marko");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("\t  \tma r ko\n"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "ma r ko");
    }

    public void testIllegalArguments() {
        try {
            Function<String> function = new NormalizeSpaceFunction();
            GremlinScriptContext context = new GremlinScriptContext();
            function.compute(createUnaryArgs("marko", 2), context);
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}

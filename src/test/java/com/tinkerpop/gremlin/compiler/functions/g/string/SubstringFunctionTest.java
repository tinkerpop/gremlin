package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SubstringFunctionTest extends BaseTest {

    public void testSubstring() {
        Function<String> function = new SubstringFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        Atom<String> atom = function.compute(createUnaryArgs("marko",0,3), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "mar");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko",4), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "o");
    }

    public void testIllegalArguments() {
        try {
            Function<String> function = new SubstringFunction();
            GremlinScriptContext context = new GremlinScriptContext();
            function.compute(createUnaryArgs("marko"), context);
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}

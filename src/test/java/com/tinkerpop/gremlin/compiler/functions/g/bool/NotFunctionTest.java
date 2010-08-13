package com.tinkerpop.gremlin.compiler.functions.g.bool;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NotFunctionTest extends BaseTest {

    public void testNot() {
        Function<Boolean> function = new NotFunction();
        this.stopWatch();
        Atom<Boolean> atom = function.compute(createUnaryArgs(true), new GremlinScriptContext());
        printPerformance(function.getFunctionName() + " function", 1, "boolean flip", this.stopWatch());
        assertFalse(atom.getValue());
        this.stopWatch();
        atom = function.compute(createUnaryArgs(false), new GremlinScriptContext());
        printPerformance(function.getFunctionName() + " function", 1, "boolean flip", this.stopWatch());
        assertTrue(atom.getValue());
    }

    public void testNotInline() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        List results = evaluateGremlinScriptIterable("g:list(1,2)[g:not(g:not(g:not(true)) and false)]", context, true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
    }

    public void testIllegalArguments() {
        try {
            Function<Boolean> function = new NotFunction();
            function.compute(createUnaryArgs(true, false, true), new GremlinScriptContext());
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}
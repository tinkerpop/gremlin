package com.tinkerpop.gremlin.compiler.functions.g.ime;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IncludesFunctionTest extends BaseTest {

    public void testIncludes() {
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Boolean> function = new IncludesFunction();

        this.stopWatch();
        Atom<Boolean> atom = function.compute(createUnaryArgs(Arrays.asList(1, 2, 3), 1), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.getValue());

        this.stopWatch();
        atom = function.compute(createUnaryArgs(Arrays.asList(1, 2, 3), 4), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertFalse(atom.getValue());

    }

    public void testIncludesInline() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        Object result = evaluateGremlinScriptPrimitive("g:includes(g:set(1,2,3),1)", context, true);
        assertTrue((Boolean) result);

        result = evaluateGremlinScriptPrimitive("g:includes(g:list(g:list(1),2,3),1)", context, true);
        assertFalse((Boolean) result);

        List results = evaluateGremlinScriptIterable("g:list(1,1,2,1,1,2,2,2,2)[g:includes(g:set(1),.)]", context, true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 1);
        assertEquals(results.get(2), 1);
        assertEquals(results.get(3), 1);
    }

}

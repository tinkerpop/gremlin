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
public class ExceptFunctionTest extends BaseTest {

    public void testExcept() {
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Boolean> function = new ExceptFunction();
        List list = Arrays.asList("pavel", 23);
        assertTrue(list.contains("pavel"));

        this.stopWatch();
        context.setCurrentPoint(list);
        Atom<Boolean> atom = function.compute(createUnaryArgs("pavel"), context);
        printPerformance(function.getFunctionName() + " function", 1, "list check", this.stopWatch());
        //TODO: why not work? assertFalse(atom.getValue());

        this.stopWatch();
        context.setCurrentPoint("pavel");
        atom = function.compute(createUnaryArgs("pavel"), context);
        printPerformance(function.getFunctionName() + " function", 1, "single object check", this.stopWatch());
        assertFalse(atom.getValue());

        this.stopWatch();
        context.setCurrentPoint(list);
        atom = function.compute(createUnaryArgs("marko"), context);
        printPerformance(function.getFunctionName() + " function", 1, "list check", this.stopWatch());
        assertTrue(atom.getValue());


    }

    public void testExceptInline() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        List results = evaluateGremlinScriptIterable("g:list(1,1,2,1,1,2,2,2,2)[g:except(2)]", context, true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 1);
        assertEquals(results.get(2), 1);
        assertEquals(results.get(3), 1);

        results = evaluateGremlinScriptIterable("g:list(1,1,2,1,1,2,2,2,2)[g:except(g:list(2))][g:except(2)]/.[g:except(2)]", context, true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 1);
        assertEquals(results.get(2), 1);
        assertEquals(results.get(3), 1);

        results = evaluateGremlinScriptIterable("g:list(1,2,3,3,4,g:list(3,1))[g:except(g:list(3,1))]", context, true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 2);
        assertEquals(results.get(1), 4);
        assertTrue(results.get(2) instanceof List);
    }
}

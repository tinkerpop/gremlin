package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RetainFunctionTest extends BaseTest {

    public void testRetain() {
        GremlinScriptContext context = new GremlinScriptContext();
        
        Function<Boolean> function = new RetainFunction();
        List list = Arrays.asList("pavel", 23);
        assertTrue(list.contains("pavel"));

        this.stopWatch();
        context.setCurrentPoint(list);
        Atom<Boolean> atom = function.compute(createUnaryArgs("pavel"), context);
        printPerformance(function.getFunctionName() + " function", 1, "list check", this.stopWatch());
        // TODO: why not work? assertTrue(atom.getValue()); 

        this.stopWatch();
        context.setCurrentPoint("pavel");
        atom = function.compute(createUnaryArgs("pavel"), context);
        printPerformance(function.getFunctionName() + " function", 1, "single object check", this.stopWatch());
        assertTrue(atom.getValue());

        this.stopWatch();
        context.setCurrentPoint(list);
        atom = function.compute(createUnaryArgs("marko"), context);
        printPerformance(function.getFunctionName() + " function", 1, "list check", this.stopWatch());
        assertFalse(atom.getValue());


    }

     public void testInline() throws Exception {
        List results = evaluateGremlinScriptIterable("g:list(1,1,2,1,1,2,2,2,2)[g:retain(1)]", true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 1);
        assertEquals(results.get(2), 1);
        assertEquals(results.get(3), 1);

        results = evaluateGremlinScriptIterable("g:list(1,1,2,1,1,2,2,2,2)[g:retain(g:list(1))][g:retain(1)]/.[g:retain(1)]", true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 1);
        assertEquals(results.get(2), 1);
        assertEquals(results.get(3), 1);

        results = evaluateGremlinScriptIterable("g:list(1,2,3,3,4,g:list(3,1))[g:retain(g:list(2,4))]", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), 2);
        assertEquals(results.get(1), 4);
    }
}

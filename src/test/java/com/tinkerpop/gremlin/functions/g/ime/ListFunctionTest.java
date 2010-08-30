package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ListFunctionTest extends BaseTest {

    public void testEmptyList() {
        GremlinScriptContext context = new GremlinScriptContext();
        Function<List> function = new ListFunction();
        this.stopWatch();
        Atom<List> atom = function.compute(new ArrayList<Operation>(), context);
        printPerformance(function.getFunctionName() + " function", 0, "arguments", this.stopWatch());
        assertEquals(count(atom.getValue()), 0);
    }


    public void testListInline() throws Exception {
        List<Integer> results = evaluateGremlinScriptIterable("g:list(1,2,3)[. > 1]", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(2));
        assertEquals(results.get(1), new Integer(3));

        results = evaluateGremlinScriptIterable("g:list(1,2,3)[. >= 2]", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(2));
        assertEquals(results.get(1), new Integer(3));

        results = evaluateGremlinScriptIterable("g:list(1,2,3)[. >= 1]", true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(3));

        results = evaluateGremlinScriptIterable("g:list(1,2,3)[. < 3]", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));

        results = evaluateGremlinScriptIterable("g:list(1,2,3)[. = 1 or . = 2]", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));

        results = evaluateGremlinScriptIterable("g:list(1,2,3,4,5,6)[. < 4 and . >= 2]", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(2));
        assertEquals(results.get(1), new Integer(3));

        results = evaluateGremlinScriptIterable("g:list(1,2,3,4,5,6)[. < 3 or (. > 5 and . <= 7)]", true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(6));

        results = evaluateGremlinScriptIterable("g:list(1,2,3,4,5,6,7,8)[. < 3 or (. > 5 and . <= 7 and . != 7) or . = 8]", true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(6));
        assertEquals(results.get(3), new Integer(8));

        assertEquals(evaluateGremlinScriptPrimitive("g:list(1,2,3,4,5,6,7,8)[0]", true), new Integer(1));

        GremlinScriptContext context = new GremlinScriptContext();
        evaluateGremlinScriptIterable("g:list(1,2,3)[g:p(g:assign($x,.))]", context, true);
        assertEquals(context.getVariableByName("$x").getValue(), 3);
        results = evaluateGremlinScriptIterable("g:g(g:list(1,2,3))[g:p($x := .)]", context, true);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(3));
        assertEquals(context.getVariableByName("$x").getValue().getClass(), ArrayList.class);
        assertEquals(((List) context.getVariableByName("$x").getValue()).get(0), 1);
        assertEquals(((List) context.getVariableByName("$x").getValue()).get(1), 2);
        assertEquals(((List) context.getVariableByName("$x").getValue()).get(2), 3);


    }
}

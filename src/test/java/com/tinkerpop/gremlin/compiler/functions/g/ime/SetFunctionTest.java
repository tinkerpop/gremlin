package com.tinkerpop.gremlin.compiler.functions.g.ime;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SetFunctionTest extends BaseTest {

    public void testEmptySet() {
        GremlinScriptContext context = new GremlinScriptContext();
        Function<Set> function = new SetFunction();
        this.stopWatch();
        Atom<Set> atom = function.compute(new ArrayList<Operation>(), context);
        printPerformance(function.getFunctionName() + " function", 0, "arguments", this.stopWatch());
        assertEquals(count(atom.getValue()), 0);
    }

     public void testSetInline() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();

        List<Integer> results = evaluateGremlinScriptIterable("g:set(1,2,3)[. > 1]", context, true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(2));
        assertEquals(results.get(1), new Integer(3));

        results = evaluateGremlinScriptIterable("g:set(1,2,2,2,2,3)[. >= 2]", context, true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(2));
        assertEquals(results.get(1), new Integer(3));

        results = evaluateGremlinScriptIterable("g:set(1,1,1,1,2,3)[. >= 1]", context, true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(3));

        results = evaluateGremlinScriptIterable("g:set(1,2,2,2,3,3,3)[. < 3]", context, true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));

        results = evaluateGremlinScriptIterable("g:set(1,2,3,3,3,2,1,1,1)[. = 1 or . = 2]", context, true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));

        results = evaluateGremlinScriptIterable("g:set(1,2,3,4,5,6)[. < 4 and . >= 2]", context, true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(2));
        assertEquals(results.get(1), new Integer(3));

        results = evaluateGremlinScriptIterable("g:set(1,2,3,4,5,6)[. < 3 or (. > 5 and . <= 7)]", context, true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(6));

        results = evaluateGremlinScriptIterable("g:set(1,2,3,4,5,6,7,8)[. < 3 or (. > 5 and . <= 7 and . != 7) or . = 8]", context, true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(6));
        assertEquals(results.get(3), new Integer(8));

        assertEquals(evaluateGremlinScriptPrimitive("g:set(1,2,3,4,5,6,7,8)[0]", context, true), new Integer(1));


    }
}
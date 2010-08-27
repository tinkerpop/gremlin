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

    public void testSet() {
        GremlinScriptContext context = new GremlinScriptContext();
        Function<Set> function = new SetFunction();
        this.stopWatch();
        Atom<Set> atom = function.compute(new ArrayList<Operation>(), context);
        printPerformance(function.getFunctionName() + " function", 0, "arguments", this.stopWatch());
        assertEquals(count(atom.getValue()), 0);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1,1,2,2,2,3,3,3,3,4,4,4,4,4), context);
        printPerformance(function.getFunctionName() + " function", 0, "arguments", this.stopWatch());
        assertEquals(count(atom.getValue()), 4);
        assertTrue(atom.getValue().contains(1));
        assertTrue(atom.getValue().contains(2));
        assertTrue(atom.getValue().contains(3));
        assertTrue(atom.getValue().contains(4));
    }

     public void testSetInline() throws Exception {

        List<Integer> results = evaluateGremlinScriptIterable("g:set(1,2,3)[. > 1]", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(2));
        assertEquals(results.get(1), new Integer(3));

        results = evaluateGremlinScriptIterable("g:set(1,2,2,2,2,3)[. >= 2]", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(2));
        assertEquals(results.get(1), new Integer(3));

        results = evaluateGremlinScriptIterable("g:set(1,1,1,1,2,3)[. >= 1]", true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(3));

        results = evaluateGremlinScriptIterable("g:set(1,2,2,2,3,3,3)[. < 3]", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));

        results = evaluateGremlinScriptIterable("g:set(1,2,3,3,3,2,1,1,1)[. = 1 or . = 2]", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));

        results = evaluateGremlinScriptIterable("g:set(1,2,3,4,5,6)[. < 4 and . >= 2]", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), new Integer(2));
        assertEquals(results.get(1), new Integer(3));

        results = evaluateGremlinScriptIterable("g:set(1,2,3,4,5,6)[. < 3 or (. > 5 and . <= 7)]", true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(6));

        results = evaluateGremlinScriptIterable("g:set(1,2,3,4,5,6,7,8)[. < 3 or (. > 5 and . <= 7 and . != 7) or . = 8]", true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(6));
        assertEquals(results.get(3), new Integer(8));

        assertEquals(evaluateGremlinScriptPrimitive("g:set(1,2,3,4,5,6,7,8)[0]", true), new Integer(1));


    }
}
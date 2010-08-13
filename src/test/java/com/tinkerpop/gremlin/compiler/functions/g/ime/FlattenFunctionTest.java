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
public class FlattenFunctionTest extends BaseTest {

    public void testFlatten() {
        GremlinScriptContext context = new GremlinScriptContext();

        Function<List> function = new FlattenFunction();

        this.stopWatch();
        Atom<List> atom = function.compute(createUnaryArgs(1,2,3), context);
        printPerformance(function.getFunctionName() + " function", 1, "flat list flatten", this.stopWatch());
        assertEquals(atom.getValue().get(0), 1);
        assertEquals(atom.getValue().get(1), 2);
        assertEquals(atom.getValue().get(2), 3);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1,2, Arrays.asList(3,4,5)), context);
        printPerformance(function.getFunctionName() + " function", 1, "single embedded list flatten", this.stopWatch());
        assertEquals(atom.getValue().get(0), 1);
        assertEquals(atom.getValue().get(1), 2);
        assertEquals(atom.getValue().get(2), 3);
        assertEquals(atom.getValue().get(3), 4);
        assertEquals(atom.getValue().get(4), 5);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1,2, Arrays.asList(3,4,Arrays.asList(5,6,7),8,Arrays.asList(9),Arrays.asList(),10)), context);
        printPerformance(function.getFunctionName() + " function", 1, "double embedded list flatten", this.stopWatch());
        assertEquals(atom.getValue().get(0), 1);
        assertEquals(atom.getValue().get(1), 2);
        assertEquals(atom.getValue().get(2), 3);
        assertEquals(atom.getValue().get(3), 4);
        assertEquals(atom.getValue().get(4), 5);
        assertEquals(atom.getValue().get(5), 6);
        assertEquals(atom.getValue().get(6), 7);
        assertEquals(atom.getValue().get(7), 8);
        assertEquals(atom.getValue().get(8), 9);
        assertEquals(atom.getValue().get(9), 10);

    }

    public void testFlattenInline() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        List results = evaluateGremlinScriptIterable("g:flatten(g:list(1,2,3,4))", context, true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);
        assertEquals(results.get(3), 4);

        results = evaluateGremlinScriptIterable("g:flatten(g:list(g:flatten(g:list(1,2,3)),4))", context, true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);
        assertEquals(results.get(3), 4);

        results = evaluateGremlinScriptIterable("g:flatten(g:list(g:list(g:list(1,g:list(g:list(g:list(2)),g:list(3)))),g:list(g:list(g:list(4)))))", context, true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);
        assertEquals(results.get(3), 4);

    }
}

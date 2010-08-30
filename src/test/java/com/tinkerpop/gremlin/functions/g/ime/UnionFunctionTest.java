package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnionFunctionTest extends BaseTest {

    public void testUnionList() {
        GremlinScriptContext context = new GremlinScriptContext();
        Function<Set> function = new UnionFunction();
        this.stopWatch();
        Atom<Set> atom = function.compute(createUnaryArgs(1.0d, 2.0d, 3.0d, 4.0d), context);
        printPerformance(function.getFunctionName() + " function", 4, "primitive arguments", this.stopWatch());
        List list = asList(atom.getValue());
        assertEquals(list.size(), 4);

        assertTrue(list.contains(1.0d));
        assertTrue(list.contains(2.0d));
        assertTrue(list.contains(3.0d));
        assertTrue(list.contains(4.0d));

        function = new UnionFunction();
        this.stopWatch();
        atom = function.compute(createUnaryArgs(Arrays.asList(1.0, 2.0), Arrays.asList(2.0, 2.0)), context);
        printPerformance(function.getFunctionName() + " function", 3, "list arguments", this.stopWatch());
        list = asList(atom.getValue());
        assertEquals(list.size(), 2);
        assertTrue(list.contains(1.0d));
        assertTrue(list.contains(2.0d));
    }

    public void testUnionInline() throws Exception {
        List results = evaluateGremlinScriptIterable("g:union(g:list(1,2),g:list(2,3))", true);
        assertEquals(results.size(), 3);
        assertTrue(results.contains(1));
        assertTrue(results.contains(2));
        assertTrue(results.contains(3));


        results = evaluateGremlinScriptIterable("g:union(g:list(1,2,2,3),g:list(2,2,2,2,3))", true);
        assertEquals(results.size(), 3);
        assertTrue(results.contains(1));
        assertTrue(results.contains(2));
        assertTrue(results.contains(3));

        results = evaluateGremlinScriptIterable("g:union(g:list(1,2,2),2)", true);
        assertEquals(results.size(), 2);
        assertTrue(results.contains(1));
        assertTrue(results.contains(2));
    }
}

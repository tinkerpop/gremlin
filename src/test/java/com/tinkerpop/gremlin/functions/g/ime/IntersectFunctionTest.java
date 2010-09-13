package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.Function;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IntersectFunctionTest extends BaseTest {
    public void testIntersect() {
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Set> function = new IntersectFunction();
        List list1 = Arrays.asList("marko", "pavel", "peter", "josh");
        List list2 = Arrays.asList("marko", "pavel");
        List list3 = Arrays.asList("marko");

        this.stopWatch();
        Atom<Set> atom = function.compute(createUnaryArgs("marko", "marko", "marko"), context);
        printPerformance(function.getFunctionName() + " function", 3, "singleton intersect", this.stopWatch());
        assertEquals(count(atom.getValue()), 1);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list2), context);
        printPerformance(function.getFunctionName() + " function", 2, "list intersect", this.stopWatch());
        assertEquals(count(atom.getValue()), 2);
        for (Object object : atom.getValue()) {
            assertTrue(object.equals("marko") || object.equals("pavel"));
        }

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list3), context);
        printPerformance(function.getFunctionName() + " function", 2, "list intersect", this.stopWatch());
        assertEquals(count(atom.getValue()), 1);
        for (Object object : atom.getValue()) {
            assertTrue(object.equals("marko"));
        }

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list1), context);
        printPerformance(function.getFunctionName() + " function", 2, "list intersect", this.stopWatch());
        assertEquals(count(atom.getValue()), 4);
        for (Object object : atom.getValue()) {
            assertTrue(object.equals("marko") || object.equals("pavel") ||
                    object.equals("peter") || object.equals("josh"));
        }

        try {
            function.compute(createUnaryArgs(list1), context);
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

        try {
            function.compute(createUnaryArgs(), context);
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testIntersectInline() throws Exception {
        List results = evaluateGremlinScriptIterable("g:intersect(g:list(1,2),g:list(2,3))", true);
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), 2);

        results = evaluateGremlinScriptIterable("g:intersect(g:list(1,2,2,3),g:list(2,2,2,2,3))", true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), 2);
        assertEquals(results.get(1), 3);

        results = evaluateGremlinScriptIterable("g:intersect(g:list(1,2,2),2)", true);
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), 2);
    }


}

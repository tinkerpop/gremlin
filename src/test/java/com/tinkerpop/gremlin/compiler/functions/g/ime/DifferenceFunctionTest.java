package com.tinkerpop.gremlin.compiler.functions.g.ime;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DifferenceFunctionTest extends BaseTest {

    public void testDifference() {
        GremlinScriptContext context = new GremlinScriptContext();
        
        Function<Set> function = new DifferenceFunction();
        List list1 = Arrays.asList("marko", "pavel", "peter", "josh");
        List list2 = Arrays.asList("marko", "pavel");
        List list3 = Arrays.asList("marko");

        this.stopWatch();
        Atom<Set> atom = function.compute(createUnaryArgs("marko", "marko", "marko"), context);
        printPerformance(function.getFunctionName() + " function", 3, "singleton difference", this.stopWatch());
        assertEquals(count(atom.getValue()), 0);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list2), context);
        printPerformance(function.getFunctionName() + " function", 2, "list difference", this.stopWatch());
        assertEquals(count(atom.getValue()), 2);
        for (Object object : atom.getValue()) {
            assertTrue(object.equals("peter") || object.equals("josh"));
        }

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list3), context);
        printPerformance(function.getFunctionName() + " function", 2, "list difference", this.stopWatch());
        assertEquals(count(atom.getValue()), 3);
        for (Object object : atom.getValue()) {
            assertTrue(object.equals("pavel") || object.equals("peter") || object.equals("josh"));
        }

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list1), context);
        printPerformance(function.getFunctionName() + " function", 2, "list difference", this.stopWatch());
        assertEquals(count(atom.getValue()), 0);

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

    public void testDifferenceInline() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        List results = evaluateGremlinScriptIterable("g:diff(g:list(1,1,2),g:list(1))", context, true);
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), 2);

        results = evaluateGremlinScriptIterable("g:diff(g:list(1,1,2),g:diff(g:list(1,2,3),g:list(2,3)))", context, true);
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), 2);
    }

}

package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DifferenceFunctionTest extends BaseTest {

    public void testDifference() {
        GremlinScriptContext context = new GremlinScriptContext();
        
        Function<Iterable> function = new DifferenceFunction();
        List list1 = Arrays.asList("marko", "pavel", "peter", "josh");
        List list2 = Arrays.asList("marko", "pavel");
        List list3 = Arrays.asList("marko");

        this.stopWatch();
        Atom<Iterable> atom = function.compute(createUnaryArgs("marko", "marko", "marko"), context);
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

}

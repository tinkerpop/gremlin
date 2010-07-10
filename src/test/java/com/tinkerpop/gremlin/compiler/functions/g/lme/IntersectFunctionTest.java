package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IntersectFunctionTest extends BaseTest {
    public void testIntersect() {
        Function<Iterable> function = new IntersectFunction();
        List list1 = Arrays.asList("marko","pavel", "peter", "josh");
        List list2 = Arrays.asList("marko", "pavel");
        List list3 = Arrays.asList("marko");

        this.stopWatch();
        Atom<Iterable> atom = function.compute(createUnaryArgs("marko", "marko", "marko"));
        printPerformance(function.getFunctionName() + " function", 3, "singleton intersect", this.stopWatch());
        assertEquals(count(atom.getValue()), 1);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list2));
        printPerformance(function.getFunctionName() + " function", 2, "list intersect", this.stopWatch());
        assertEquals(count(atom.getValue()), 2);
        for (Object object : atom.getValue()) {
            assertTrue(object.equals("marko") || object.equals("pavel"));
        }

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list3));
        printPerformance(function.getFunctionName() + " function", 2, "list intersect", this.stopWatch());
        assertEquals(count(atom.getValue()), 1);
        for (Object object : atom.getValue()) {
            assertTrue(object.equals("marko"));
        }

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list1));
        printPerformance(function.getFunctionName() + " function", 2, "list intersect", this.stopWatch());
        assertEquals(count(atom.getValue()), 4);
        for (Object object : atom.getValue()) {
            assertTrue(object.equals("marko") || object.equals("pavel") ||
                    object.equals("peter") || object.equals("josh"));
        }

        try {
            function.compute(createUnaryArgs(list1));
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

        try {
            function.compute(createUnaryArgs());
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}

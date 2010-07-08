package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DifferenceFunctionTest extends BaseTest {

    public void testDifference() {
        Function<Iterable<Atom>> function = new DifferenceFunction();
        List<Atom> list1 = Arrays.asList(new Atom("marko"), new Atom("pavel"), new Atom("peter"), new Atom("josh"));
        List<Atom> list2 = Arrays.asList(new Atom("marko"), new Atom("pavel"));
        List<Atom> list3 = Arrays.asList(new Atom("marko"));

        this.stopWatch();
        Atom<Iterable<Atom>> atom = function.compute(createUnaryArgs("marko", "marko", "marko"));
        printPerformance(function.getFunctionName() + " function", 3, "singleton difference", this.stopWatch());
        assertEquals(count(atom.getValue()), 0);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list2));
        printPerformance(function.getFunctionName() + " function", 2, "list difference", this.stopWatch());
        assertEquals(count(atom.getValue()), 2);
        for (Atom object : atom.getValue()) {
            assertTrue(object.getValue().equals("peter") || object.getValue().equals("josh"));
        }

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list3));
        printPerformance(function.getFunctionName() + " function", 2, "list difference", this.stopWatch());
        assertEquals(count(atom.getValue()), 3);
        for (Atom object : atom.getValue()) {
            assertTrue(object.getValue().equals("pavel") || object.getValue().equals("peter") || object.getValue().equals("josh"));
        }

        this.stopWatch();
        atom = function.compute(createUnaryArgs(list1, list1));
        printPerformance(function.getFunctionName() + " function", 2, "list difference", this.stopWatch());
        assertEquals(count(atom.getValue()), 0);

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

package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnionFunctionTest extends BaseTest {

    public void testUnionList() {
        Function<Iterable<Atom>> function = new UnionFunction();
        this.stopWatch();
        Atom<Iterable<Atom>> atom = function.compute(TestHelper.createUnaryArgs(1.0d, 2.0d, 3.0d, 4.0d));
        printPerformance(function.getFunctionName() + " function", 4, "primitive arguments", this.stopWatch());
        List<Atom> list = asList(atom.getValue());
        assertEquals(list.size(), 4);

        assertTrue(list.contains(new Atom<Double>(1.0d)));
        assertTrue(list.contains(new Atom<Double>(2.0d)));
        assertTrue(list.contains(new Atom<Double>(3.0d)));
        assertTrue(list.contains(new Atom<Double>(4.0d)));

        function = new UnionFunction();
        this.stopWatch();
        atom = function.compute(TestHelper.createUnaryArgs(Arrays.asList(1.0, 2.0), Arrays.asList(2.0, 2.0)));
        printPerformance(function.getFunctionName() + " function", 3, "list arguments", this.stopWatch());
        list = asList(atom.getValue());
        assertEquals(list.size(), 2);
        assertTrue(list.contains(new Atom<Double>(1.0d)));
        assertTrue(list.contains(new Atom<Double>(2.0d)));

    }
}

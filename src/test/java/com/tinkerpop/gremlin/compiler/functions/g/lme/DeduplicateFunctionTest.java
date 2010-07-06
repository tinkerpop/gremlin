package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DeduplicateFunctionTest extends TestCase {

    public void testDeduplicateList() {
        Function function = new DeduplicateFunction();
        Atom atom = function.compute(TestHelper.createUnaryArgs(Arrays.asList(1.0d, 2.0d, 3.0d, 4.0d)));
        assertEquals(((Collection) atom.getValue()).size(), 4);
        assertTrue(((Collection) atom.getValue()).contains(new Atom(1.0d)));
        assertTrue(((Collection) atom.getValue()).contains(new Atom(2.0d)));
        assertTrue(((Collection) atom.getValue()).contains(new Atom(3.0d)));
        assertTrue(((Collection) atom.getValue()).contains(new Atom(4.0d)));

        function = new DeduplicateFunction();
        atom = function.compute(TestHelper.createUnaryArgs(Arrays.asList(1.0, 2.0, 2.0, 2.0)));
        assertEquals(((Collection) atom.getValue()).size(), 2);
        assertTrue(((Collection) atom.getValue()).contains(new Atom(1.0d)));
        assertTrue(((Collection) atom.getValue()).contains(new Atom(2.0d)));

    }
}

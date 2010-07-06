package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class KeyFunctionTest extends TestCase {

    public void testKey() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Function function = new KeyFunction();
        assertEquals(function.getFunctionName(), "key");
        Atom atom = function.compute(TestHelper.createUnaryArgs(graph, "name", "marko"));
        assertTrue(atom.isIterable());
        assertEquals(TestHelper.countIterable((Iterable)atom.getValue()), 1);

    }
}

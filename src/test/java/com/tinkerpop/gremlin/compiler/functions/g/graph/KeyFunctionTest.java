package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class KeyFunctionTest extends BaseTest {

    public void testKey() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Function function = new KeyFunction();
        assertEquals(function.getFunctionName(), "key");
        this.stopWatch();
        Atom atom = function.compute(TestHelper.createUnaryArgs(graph, "name", "marko"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isIterable());
        assertEquals(TestHelper.countIterable((Iterable)atom.getValue()), 1);

    }
}

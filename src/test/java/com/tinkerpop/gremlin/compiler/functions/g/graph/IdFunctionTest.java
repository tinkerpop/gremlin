package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IdFunctionTest extends BaseTest {

    public void testId() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Function<Vertex> function = new IdFunction();
        assertEquals(function.getFunctionName(), "id");
        this.stopWatch();
        Atom<Vertex> atom = function.compute(TestHelper.createUnaryArgs(graph, "1"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isVertex());
        assertEquals(atom.getValue().getProperty("name"), "marko");

    }
}

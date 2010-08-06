package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IdEdgeFunctionTest extends BaseTest {

    public void testIdEdge() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Edge> function = new IdEdgeFunction();
        assertEquals(function.getFunctionName(), "id-e");
        this.stopWatch();
        Atom<Edge> atom = function.compute(createUnaryArgs(graph, "8"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isEdge());
        assertEquals(atom.getValue().getProperty("weight"), 1.0f);
        assertEquals(atom.getValue().getLabel(), "knows");
        assertNull(atom.getValue().getProperty("blah"));
    }
}

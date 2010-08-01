package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RemoveVertexEdgeFunctionTest extends BaseTest {

    public void testAddVertex() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        
        Function<Boolean> function = new RemoveVertexEdgeFunction();
        assertEquals(function.getFunctionName(), "remove-ve");
        assertEquals(count(graph.getVertex("3").getInEdges()), 3);
        this.stopWatch();
        Atom<Boolean> atom = function.compute(createUnaryArgs(graph, graph.getVertex("6")), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.getValue());
        assertEquals(count(graph.getVertex("3").getInEdges()), 2);

        function = new RemoveVertexEdgeFunction();
        assertEquals(function.getFunctionName(), "remove-ve");
        assertEquals(count(graph.getVertex("5").getInEdges()), 1);
        this.stopWatch();
        atom = function.compute(createUnaryArgs(graph.getVertex("4").getOutEdges().iterator().next()), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.getValue());
        assertEquals(count(graph.getVertex("5").getInEdges()), 0);
    }
}

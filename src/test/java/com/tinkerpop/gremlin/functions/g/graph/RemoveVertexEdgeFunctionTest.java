package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import javax.script.ScriptContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RemoveVertexEdgeFunctionTest extends BaseTest {

    public void testAddVertex() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        
        Function<Object> function = new RemoveVertexEdgeFunction();
        assertEquals(function.getFunctionName(), "remove-ve");
        assertEquals(count(graph.getVertex("3").getInEdges()), 3);
        this.stopWatch();
        Atom<Object> atom = function.compute(createUnaryArgs(graph, graph.getVertex("6")), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertNull(atom.getValue());
        assertEquals(count(graph.getVertex("3").getInEdges()), 2);

        function = new RemoveVertexEdgeFunction();
        assertEquals(function.getFunctionName(), "remove-ve");
        assertEquals(count(graph.getVertex("5").getInEdges()), 1);
        this.stopWatch();
        atom = function.compute(createUnaryArgs(graph.getVertex("4").getOutEdges().iterator().next()), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertNull(atom.getValue());
        assertEquals(count(graph.getVertex("5").getInEdges()), 0);
    }
}

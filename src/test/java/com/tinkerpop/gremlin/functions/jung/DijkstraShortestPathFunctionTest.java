package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import javax.script.ScriptContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DijkstraShortestPathFunctionTest extends JungTest {

    public void testNoParameters() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        Function<List<Edge>> function = new DijkstraShortestPathFunction();
        this.stopWatch();
        Atom<List<Edge>> atom = function.compute(this.createUnaryArgs(graph.getVertex(1), graph.getVertex(5)), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue().size(), 2);
        for (Object result : atom.getValue()) {
            assertTrue(result instanceof Edge);
            Edge edge = (Edge) result;
            assertTrue(edge.getId().equals("8") || edge.getId().equals("10"));
        }
    }

    public void testGraphParameter() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        Function<List<Edge>> function = new DijkstraShortestPathFunction();
        this.stopWatch();
        Atom<List<Edge>> atom = function.compute(this.createUnaryArgs(graph, graph.getVertex(1), graph.getVertex(5)), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue().size(), 2);
        for (Object result : atom.getValue()) {
            assertTrue(result instanceof Edge);
            Edge edge = (Edge) result;
            assertTrue(edge.getId().equals("8") || edge.getId().equals("10"));
        }
    }

    public void testEdgeWeight() {
        Graph graph = new TinkerGraph();
        Vertex v1 = graph.addVertex("1");
        Vertex v2 = graph.addVertex("2");
        Vertex v3 = graph.addVertex("3");
        Vertex v4 = graph.addVertex("4");
        Vertex v5 = graph.addVertex("5");
        graph.addEdge("a", v1, v2, "knows");
        graph.addEdge("b", v1, v3, "knows");
        graph.addEdge("c", v2, v4, "knows");
        graph.addEdge("d", v3, v4, "hates");
        graph.addEdge("e", v3, v5, "knows");
        graph.addEdge("f", v5, v4, "knows");
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        Function<List<Edge>> function = new DijkstraShortestPathFunction();
        this.stopWatch();
        Atom<List<Edge>> atom = function.compute(this.createUnaryArgs(graph, v3, v4), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue().size(), 1);
        assertEquals(atom.getValue().get(0).getId(), "d");

        Map parameters = new HashMap();
        parameters.put("labels", Arrays.asList("hates"));
        parameters.put("filter", true);
        function = new DijkstraShortestPathFunction();
        this.stopWatch();
        atom = function.compute(this.createUnaryArgs(v3, v4, parameters), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());

        assertEquals(atom.getValue().size(), 2);
        for (Object result : atom.getValue()) {
            assertTrue(result instanceof Edge);
            Edge edge = (Edge) result;
            assertTrue(edge.getId().equals("e") || edge.getId().equals("f"));
        }

    }
}


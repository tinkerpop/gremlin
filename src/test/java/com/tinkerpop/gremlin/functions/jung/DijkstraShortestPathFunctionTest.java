package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.Tokens;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DijkstraShortestPathFunctionTest extends JungTest {

    public void testNoParameters() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        xe.getVariables().declareVariable("$a", graph.getVertex('1'));
        xe.getVariables().declareVariable("$b", graph.getVertex('5'));
        List results = xe.evaluateList("jung:dijkstra($a,$b)");
        assertEquals(results.size(), 2);
        for (Object result : results) {
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
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        xe.getVariables().declareVariable("$a", v3);
        xe.getVariables().declareVariable("$b", v4);

        List results = xe.evaluateList("jung:dijkstra($a,$b)");
        assertEquals(results.size(), 1);
        assertEquals(((Edge) results.get(0)).getId(), "d");

        results = xe.evaluateList("jung:dijkstra($a,$b,g:map('labels',g:list('hates'),'filter',true()))");
        assertEquals(results.size(), 2);
        for (Object result : results) {
            assertTrue(result instanceof Edge);
            Edge edge = (Edge) result;
            assertTrue(edge.getId().equals("e") || edge.getId().equals("f"));
        }

    }
}

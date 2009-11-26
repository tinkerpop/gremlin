package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.Graph;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraphTest extends BaseTest {

    public void testAddVertex() {
        Graph graph = new TinkerGraph();
        graph.addVertex("marko");
        graph.addVertex("jen");
        assertEquals(((TinkerGraph)graph).vertices.size(), 2);
        graph.addVertex("marko");
        assertEquals(((TinkerGraph)graph).vertices.size(), 2);
        graph.addVertex("marco");
        assertEquals(((TinkerGraph)graph).vertices.size(), 3);
    }

    public void testRemoveVertex() {
        Graph graph = new TinkerGraph();
        Vertex marko = graph.addVertex("marko");
        assertEquals(((TinkerGraph)graph).vertices.size(), 1);
        graph.removeVertex(marko);
        assertEquals(((TinkerGraph)graph).vertices.size(), 0);
    }

    public void testRemoveVertexEdges() {
        Graph graph = new TinkerGraph();
        Vertex marko = graph.addVertex("marko");
        Vertex jen = graph.addVertex("jen");
        Vertex chewy = graph.addVertex("chewy");
        graph.addEdge(null, marko, jen, "knows");
        graph.addEdge(null, jen, chewy, "pets");
        graph.addEdge(null, jen, chewy, "pets");
        assertEquals(marko.getOutEdges().size(), 1);
        assertEquals(jen.getOutEdges().size(), 2);
        assertEquals(chewy.getInEdges().size(), 2);
        assertEquals(jen.getInEdges().size(), 1);

        assertEquals(((TinkerGraph)graph).vertices.size(), 3);
        graph.removeVertex(marko);
        assertEquals(((TinkerGraph)graph).vertices.size(), 2);
        assertEquals(marko.getOutEdges().size(), 0);
        assertEquals(jen.getOutEdges().size(), 2);
        assertEquals(chewy.getInEdges().size(), 2);
        assertEquals(jen.getInEdges().size(), 0);
    }
}

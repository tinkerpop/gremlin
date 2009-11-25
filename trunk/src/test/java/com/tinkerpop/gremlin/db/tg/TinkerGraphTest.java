package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.model.Element;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraphTest extends BaseTest {

    public void testAddVertex() {
        TinkerGraph graph = new TinkerGraph();
        TinkerVertex marko = new TinkerVertex("marko");
        TinkerVertex jen = new TinkerVertex("jen");
        graph.addVertex(marko);
        graph.addVertex(jen);
        assertEquals(graph.vertices.size(),2);
        marko = new TinkerVertex("marko");
        graph.addVertex(marko);
        assertEquals(graph.vertices.size(),2);
        marko = new TinkerVertex("marco");
        graph.addVertex(marko);
        assertEquals(graph.vertices.size(), 3);
    }

    public void testRemoveVertex() {
        TinkerGraph graph = new TinkerGraph();
        TinkerVertex marko = new TinkerVertex("marko");
        graph.addVertex(marko);
        assertEquals(graph.vertices.size(), 1);
        graph.removeVertex("marko");
        assertEquals(graph.vertices.size(), 0);
    }

    public void testRemoveVertexEdges() {
        TinkerGraph graph = new TinkerGraph();
        TinkerVertex marko = new TinkerVertex("marko");
        TinkerVertex jen = new TinkerVertex("jen");
        TinkerVertex chewy = new TinkerVertex("chewy");
        marko.createOutEdge(null, jen, "knows");
        marko.createOutEdge(null, chewy, "pets");
        jen.createOutEdge(null, chewy, "pets");
        assertEquals(marko.getOutEdges().size(), 2);
        assertEquals(jen.getOutEdges().size(), 1);
        assertEquals(chewy.getInEdges().size(), 2);
        assertEquals(jen.getInEdges().size(), 1);
        graph.addVertex(marko);
        graph.addVertex(jen);
        graph.addVertex(chewy);
        assertEquals(graph.vertices.size(), 3);
        graph.removeVertex("marko");
        assertEquals(graph.vertices.size(), 2);
        assertEquals(marko.getOutEdges().size(), 0);
        assertEquals(jen.getOutEdges().size(), 1);
        assertEquals(chewy.getInEdges().size(), 1);
        assertEquals(jen.getInEdges().size(), 0);
    }
}

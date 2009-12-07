package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraphTest extends BaseTest {

    public void testAddVertex() {
        Graph graph = new TinkerGraph();
        graph.addVertex("marko");
        graph.addVertex("jen");
        assertEquals(((TinkerGraph) graph).vertices.size(), 2);
        graph.addVertex("marko");
        assertEquals(((TinkerGraph) graph).vertices.size(), 2);
        graph.addVertex("marco");
        assertEquals(((TinkerGraph) graph).vertices.size(), 3);
    }

    public void testRemoveVertex() {
        Graph graph = new TinkerGraph();
        Vertex marko = graph.addVertex("marko");
        assertEquals(((TinkerGraph) graph).vertices.size(), 1);
        graph.removeVertex(marko);
        assertEquals(((TinkerGraph) graph).vertices.size(), 0);
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

        assertEquals(((TinkerGraph) graph).vertices.size(), 3);
        graph.removeVertex(marko);
        assertEquals(((TinkerGraph) graph).vertices.size(), 2);
        assertEquals(marko.getOutEdges().size(), 0);
        assertEquals(jen.getOutEdges().size(), 2);
        assertEquals(chewy.getInEdges().size(), 2);
        assertEquals(jen.getInEdges().size(), 0);
    }

    public void testVertexIterator() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Iterator<Vertex> vertices = graph.getVertices();
        Set<String> vertexNames = new HashSet<String>();
        int count = 0;
        while (vertices.hasNext()) {
            count++;
            Vertex v = vertices.next();
            vertexNames.add((String) v.getProperty("name"));
            //System.out.println(v);
        }
        assertEquals(count, 6);
        assertEquals(vertexNames.size(), 6);
        assertTrue(vertexNames.contains("marko"));
        assertTrue(vertexNames.contains("josh"));
        assertTrue(vertexNames.contains("peter"));
        assertTrue(vertexNames.contains("vadas"));
        assertTrue(vertexNames.contains("ripple"));
        assertTrue(vertexNames.contains("lop"));
    }

    public void testEdgeIterator() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Iterator<Edge> edges = graph.getEdges();
        Set<String> edgeIds = new HashSet<String>();
        int count = 0;
        while (edges.hasNext()) {
            count++;
            Edge e = edges.next();
            edgeIds.add((String) e.getId());
            //System.out.println(e);
        }
        assertEquals(count, 6);
        assertEquals(edgeIds.size(), 6);
        assertTrue(edgeIds.contains("7"));
        assertTrue(edgeIds.contains("8"));
        assertTrue(edgeIds.contains("9"));
        assertTrue(edgeIds.contains("10"));
        assertTrue(edgeIds.contains("11"));
        assertTrue(edgeIds.contains("12"));
    }

    public void testEdgeIterator2() {
        Graph graph = new TinkerGraph();
        Vertex a = graph.addVertex("a");
        Vertex b = graph.addVertex("b");
        graph.addEdge("1", a, a, "test");
        graph.addEdge("2", a, a, "test");
        graph.addEdge("3", a, a, "test");
        graph.addEdge("4", a, a, "test");

        Iterator<Edge> edges = graph.getEdges();
        Set<String> edgeIds = new HashSet<String>();
        int count = 0;
        while (edges.hasNext()) {
            count++;
            Edge e = edges.next();
            edgeIds.add((String) e.getId());
            //System.out.println(e);
        }
        assertEquals(count, 4);
        assertEquals(edgeIds.size(), 4);
        assertTrue(edgeIds.contains("1"));
        assertTrue(edgeIds.contains("2"));
        assertTrue(edgeIds.contains("3"));
        assertTrue(edgeIds.contains("4"));

        graph.addEdge("5", b, b, "test");
        graph.addEdge("6", b, a, "test");
        graph.addEdge("7", a, b, "test");
        graph.addEdge("8", a, a, "test");

        edges = graph.getEdges();
        edgeIds = new HashSet<String>();
        count = 0;
        while (edges.hasNext()) {
            count++;
            Edge e = edges.next();
            edgeIds.add((String) e.getId());
            //System.out.println(e);
        }
        assertEquals(count, 8);
        assertEquals(edgeIds.size(), 8);
        assertTrue(edgeIds.contains("1"));
        assertTrue(edgeIds.contains("2"));
        assertTrue(edgeIds.contains("3"));
        assertTrue(edgeIds.contains("4"));
        assertTrue(edgeIds.contains("5"));
        assertTrue(edgeIds.contains("6"));
        assertTrue(edgeIds.contains("7"));
        assertTrue(edgeIds.contains("8"));


    }
}

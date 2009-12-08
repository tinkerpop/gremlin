package com.tinkerpop.gremlin.db;

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
public class BaseGraphTest extends BaseTest {


    public static void testAddVertexStringId(Graph graph) {
        graph.addVertex("marko");
        graph.addVertex("jen");
        assertEquals(countIterator(graph.getVertices()), 2);
        graph.addVertex("marko");
        assertEquals(countIterator(graph.getVertices()), 2);
        graph.addVertex("marco");
        assertEquals(countIterator(graph.getVertices()), 3);
    }

    public static void testAddVertexNumberId(Graph graph) {
        graph.addVertex("1");
        graph.addVertex("2");
        assertEquals(countIterator(graph.getVertices()), 2);
        graph.addVertex("1");
        assertEquals(countIterator(graph.getVertices()), 2);
        graph.addVertex("3");
        assertEquals(countIterator(graph.getVertices()), 3);
    }

    public static void testRemoveVertexNullId(Graph graph) {
        Vertex v = graph.addVertex(null);
        assertEquals(countIterator(graph.getVertices()), 1);
        graph.removeVertex(v);
        assertEquals(countIterator(graph.getVertices()), 0);

    }

    public static void testRemoveVertexStringId(Graph graph) {
        Vertex marko = graph.addVertex("marko");
        assertEquals(countIterator(graph.getVertices()), 1);
        graph.removeVertex(marko);
        assertEquals(countIterator(graph.getVertices()), 0);
    }

    public static void testRemoveVertexEdges(Graph graph) {
        Vertex marko = graph.addVertex("1");
        Vertex jen = graph.addVertex("2");
        Vertex chewy = graph.addVertex("3");
        graph.addEdge(null, marko, jen, "knows");
        graph.addEdge(null, jen, chewy, "pets");
        graph.addEdge(null, jen, chewy, "pets");
        assertEquals(marko.getOutEdges().size(), 1);
        assertEquals(jen.getOutEdges().size(), 2);
        assertEquals(chewy.getInEdges().size(), 2);
        assertEquals(jen.getInEdges().size(), 1);

        assertEquals(countIterator(graph.getVertices()), 3);
        graph.removeVertex(marko);
        assertEquals(countIterator(graph.getVertices()), 2);
        //assertEquals(marko.getOutEdges().size(), 0);
        assertEquals(jen.getOutEdges().size(), 2);
        assertEquals(chewy.getInEdges().size(), 2);
        assertEquals(jen.getInEdges().size(), 0);
    }

    public void testVertexIterator(Graph graph) {
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

    public void testEdgeIterator(Graph graph) {
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

    public static void testEdgeIterator2SelfLoops(Graph graph) {
        Vertex a = graph.addVertex("1");
        Vertex b = graph.addVertex("2");
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
            edgeIds.add(e.getId().toString());
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
            edgeIds.add(e.getId().toString());
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

    public static void testEdgeIterator2NoSelfLoops(Graph graph) {
        Vertex a = graph.addVertex("1");
        Vertex b = graph.addVertex("2");

        Edge c = graph.addEdge(null, b, a, "test");
        Edge d = graph.addEdge(null, a, b, "test");

        Iterator<Edge> edges = graph.getEdges();
        Set<String> edgeIds = new HashSet<String>();
        int count = 0;
        while (edges.hasNext()) {
            count++;
            Edge e = edges.next();
            edgeIds.add(e.getId().toString());
            //System.out.println(e);
        }
        assertEquals(count, 2);
        assertEquals(edgeIds.size(), 2);
        assertTrue(edgeIds.contains(c.getId().toString()));
        assertTrue(edgeIds.contains(d.getId().toString()));
    }
}

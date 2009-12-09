package com.tinkerpop.gremlin.model;

import com.tinkerpop.gremlin.model.parser.GraphMLReader;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class VertexTestSuite extends ModelTestSuite {

    public static void testAddVertex(Graph graph) {
        Vertex v1 = graph.addVertex("1");
        Vertex v2 = graph.addVertex("2");
        assertEquals(countIterator(graph.getVertices()), 2);
        graph.addVertex(v1.getId());
        assertEquals(countIterator(graph.getVertices()), 2);
        Vertex v3 = graph.addVertex("3");
        assertEquals(countIterator(graph.getVertices()), 3);
        graph.addVertex(v2.getId());
        assertEquals(countIterator(graph.getVertices()), 3);
        graph.addVertex(v2.getId());
        assertEquals(countIterator(graph.getVertices()), 3);
        graph.addVertex(v3.getId());
        assertEquals(countIterator(graph.getVertices()), 3);
    }

    public static void testRemoveVertex(Graph graph) {
        Vertex v1 = graph.addVertex("1");
        assertEquals(countIterator(graph.getVertices()), 1);
        graph.removeVertex(v1);
        assertEquals(countIterator(graph.getVertices()), 0);

        Set<Vertex> vertices = new HashSet<Vertex>();
        for (int i = 0; i < 1000; i++) {
            vertices.add(graph.addVertex(null));
        }
        assertEquals(countIterator(graph.getVertices()), 1000);
        for (Vertex v : vertices) {
            graph.removeVertex(v);
        }
        assertEquals(countIterator(graph.getVertices()), 0);
    }

    public static void testRemoveVertexNullId(Graph graph) {
        Vertex v1 = graph.addVertex(null);
        assertEquals(countIterator(graph.getVertices()), 1);
        graph.removeVertex(v1);
        assertEquals(countIterator(graph.getVertices()), 0);

        Set<Vertex> vertices = new HashSet<Vertex>();
        for (int i = 0; i < 1000; i++) {
            vertices.add(graph.addVertex(null));
        }
        assertEquals(countIterator(graph.getVertices()), 1000);
        for (Vertex v : vertices) {
            graph.removeVertex(v);
        }
        assertEquals(countIterator(graph.getVertices()), 0);

    }

    public static void testVertexIterator(Graph graph) {
        for (int i = 0; i < 1000; i++) {
            graph.addVertex(null);
        }
        assertEquals(countIterator(graph.getVertices()), 1000);
    }

    public static void testAddVertexProperties(Graph graph) {
        Vertex v1 = graph.addVertex("1");
        Vertex v2 = graph.addVertex("2");
        v1.setProperty("key1", "value1");
        v1.setProperty("key2", 10);
        v2.setProperty("key2", 20);

        assertEquals(v1.getProperty("key1"), "value1");
        assertEquals(v1.getProperty("key2"), 10);
        assertEquals(v2.getProperty("key2"), 20);

    }

    public static void testRemoveVertexProperties(Graph graph) {
        Vertex v1 = graph.addVertex("1");
        Vertex v2 = graph.addVertex("2");
        v1.setProperty("key1", "value1");
        v1.setProperty("key2", 10);
        v2.setProperty("key2", 20);

        assertEquals(v1.removeProperty("key1"), "value1");
        assertEquals(v1.removeProperty("key2"), 10);
        assertEquals(v2.removeProperty("key2"), 20);

        assertNull(v1.removeProperty("key1"));
        assertNull(v1.removeProperty("key2"));
        assertNull(v2.removeProperty("key2"));

    }

    public static void testTinkerGraphVertices(Graph graph) throws Exception {
        GraphMLReader.inputGraph(graph, GraphMLReader.class.getResourceAsStream("graph-example-1.xml"));
        Iterator<Vertex> vertices = graph.getVertices();
        Set<String> vertexNames = new HashSet<String>();
        int count = 0;
        while (vertices.hasNext()) {
            count++;
            Vertex v = vertices.next();
            vertexNames.add(v.getProperty("name").toString());
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

    public static void testTinkerGraphSoftwareVertices(Graph graph) throws Exception {
        GraphMLReader.inputGraph(graph, GraphMLReader.class.getResourceAsStream("graph-example-1.xml"));
        Iterator<Vertex> vertices = graph.getVertices();
        Set<Vertex> softwareVertices = new HashSet<Vertex>();
        int count = 0;
        while (vertices.hasNext()) {
            count++;
            Vertex v = vertices.next();
            String name = v.getProperty("name").toString();
            if (name.equals("lop") || name.equals("ripple")) {
                softwareVertices.add(v);
            }
        }
        assertEquals(count, 6);
        assertEquals(softwareVertices.size(), 2);
        for (Vertex v : softwareVertices) {
            assertEquals(v.getProperty("lang"), "java");
        }
    }
}

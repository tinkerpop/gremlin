package com.tinkerpop.gremlin.model;

import com.tinkerpop.gremlin.model.parser.GraphMLReader;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class EdgeTestSuite extends ModelTestSuite {

    public void testAddEdges(Graph graph) throws Exception {
        Vertex v1 = graph.addVertex("1");
        Vertex v2 = graph.addVertex("2");
        Vertex v3 = graph.addVertex("3");
        graph.addEdge(null, v1, v2, "knows");
        graph.addEdge(null, v2, v3, "pets");
        graph.addEdge(null, v2, v3, "pets");
        assertEquals(v1.getOutEdges().size(), 1);
        assertEquals(v2.getOutEdges().size(), 2);
        assertEquals(v3.getOutEdges().size(), 0);
        assertEquals(v1.getInEdges().size(), 0);
        assertEquals(v2.getInEdges().size(), 1);
        assertEquals(v3.getInEdges().size(), 2);
    }

    public void testRemoveEdgesByRemovingVertex(Graph graph) {
        Vertex v1 = graph.addVertex("1");
        Vertex v2 = graph.addVertex("2");
        Vertex v3 = graph.addVertex("3");
        graph.addEdge(null, v1, v2, "knows");
        graph.addEdge(null, v2, v3, "pets");
        graph.addEdge(null, v2, v3, "pets");

        assertEquals(countIterator(graph.getVertices()), 3);
        graph.removeVertex(v1);
        assertEquals(countIterator(graph.getVertices()), 2);
        assertEquals(v2.getOutEdges().size(), 2);
        assertEquals(v3.getOutEdges().size(), 0);
        assertEquals(v2.getInEdges().size(), 0);
        assertEquals(v3.getInEdges().size(), 2);
    }

    public void testRemoveEdges(Graph graph) {
        Vertex v1 = graph.addVertex("1");
        Vertex v2 = graph.addVertex("2");
        Vertex v3 = graph.addVertex("3");
        Edge e1 = graph.addEdge(null, v1, v2, "knows");
        Edge e2 = graph.addEdge(null, v2, v3, "pets");
        Edge e3 = graph.addEdge(null, v2, v3, "pets");

        assertEquals(countIterator(graph.getVertices()), 3);
        graph.removeEdge(e1);
        assertEquals(v1.getOutEdges().size(), 0);
        assertEquals(v2.getOutEdges().size(), 2);
        assertEquals(v3.getOutEdges().size(), 0);
        assertEquals(v1.getInEdges().size(), 0);
        assertEquals(v2.getInEdges().size(), 0);
        assertEquals(v3.getInEdges().size(), 2);
        graph.removeEdge(e2);
        assertEquals(v1.getOutEdges().size(), 0);
        assertEquals(v2.getOutEdges().size(), 1);
        assertEquals(v3.getOutEdges().size(), 0);
        assertEquals(v1.getInEdges().size(), 0);
        assertEquals(v2.getInEdges().size(), 0);
        assertEquals(v3.getInEdges().size(), 1);
        graph.removeEdge(e3);
        assertEquals(v1.getOutEdges().size(), 0);
        assertEquals(v2.getOutEdges().size(), 0);
        assertEquals(v3.getOutEdges().size(), 0);
        assertEquals(v1.getInEdges().size(), 0);
        assertEquals(v2.getInEdges().size(), 0);
        assertEquals(v3.getInEdges().size(), 0);

    }

    public static void testEdgeIterator(Graph graph) {
        Vertex v1 = graph.addVertex("1");
        Vertex v2 = graph.addVertex("2");
        Vertex v3 = graph.addVertex("3");
        Edge e1 = graph.addEdge(null, v1, v2, "test");
        Edge e2 = graph.addEdge(null, v2, v3, "test");
        Edge e3 = graph.addEdge(null, v3, v1, "test");

        assertEquals(countIterator(graph.getVertices()), 3);
        assertEquals(countIterator(graph.getEdges()), 3);

        Iterator<Edge> edges = graph.getEdges();
        Set<String> edgeIds = new HashSet<String>();
        int count = 0;
        while (edges.hasNext()) {
            count++;
            Edge e = edges.next();
            edgeIds.add(e.getId().toString());
            assertEquals(e.getLabel(), "test");
            if (e.getId().toString().equals(e1.getId().toString())) {
                assertEquals(e.getOutVertex(), v1);
                assertEquals(e.getInVertex(), v2);
            } else if (e.getId().toString().equals(e2.getId().toString())) {
                assertEquals(e.getOutVertex(), v2);
                assertEquals(e.getInVertex(), v3);
            } else if (e.getId().toString().equals(e3.getId().toString())) {
                assertEquals(e.getOutVertex(), v3);
                assertEquals(e.getInVertex(), v1);
            } else {
                assertTrue(false);
            }
            //System.out.println(e);
        }
        assertEquals(count, 3);
        assertEquals(edgeIds.size(), 3);
        assertTrue(edgeIds.contains(e1.getId().toString()));
        assertTrue(edgeIds.contains(e2.getId().toString()));
        assertTrue(edgeIds.contains(e3.getId().toString()));
    }

    public void testTinkerGraphEdges(Graph graph) throws Exception {
        GraphMLReader.inputGraph(graph, GraphMLReader.class.getResourceAsStream("graph-example-1.xml"));
        Iterator<Edge> edges = graph.getEdges();
        Set<String> edgeIds = new HashSet<String>();
        Set<String> edgeKeys = new HashSet<String>();
        Set<String> edgeValues = new HashSet<String>();
        int count = 0;
        while (edges.hasNext()) {
            count++;
            Edge e = edges.next();
            edgeIds.add(e.getId().toString());
            for (String key : e.getPropertyKeys()) {
                edgeKeys.add(key);
                edgeValues.add(e.getProperty(key).toString());
            }
        }
        assertEquals(count, 6);
        assertEquals(edgeIds.size(), 6);
        assertEquals(edgeKeys.size(), 1);
        assertEquals(edgeValues.size(), 4);
    }
}

package com.tinkerpop.gremlin.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GraphTestSuite extends ModelTestSuite {

    public GraphTestSuite() {
    }

    public GraphTestSuite(SuiteConfiguration config) {
        super(config);
    }

    public void testAddingVerticesAndEdges(Graph graph) {
        Vertex a = graph.addVertex(null);
        Vertex b = graph.addVertex(null);
        Edge edge = graph.addEdge(null, a, b, convertId("knows"));
        if (config.supportsEdgeIteration) {
            assertEquals(countIterator(graph.getEdges()), 1);
        }
        if (config.supportsVertexIteration) {
            assertEquals(countIterator(graph.getVertices()), 2);
        }
        graph.removeVertex(a);
        if (config.supportsEdgeIteration) {
            assertEquals(countIterator(graph.getEdges()), 0);
        }
        if (config.supportsVertexIteration) {
            assertEquals(countIterator(graph.getVertices()), 1);
        }
        try {
            graph.removeEdge(edge);
            if (config.supportsEdgeIteration) {
                assertEquals(countIterator(graph.getEdges()), 0);
            }
            if (config.supportsVertexIteration) {
                assertEquals(countIterator(graph.getVertices()), 1);
            }
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testRemovingEdges(Graph graph) {
        List<Vertex> vertices = new ArrayList<Vertex>();
        List<Edge> edges = new ArrayList<Edge>();
        Random random = new Random();
        for (int i = 0; i < 500; i++) {
            vertices.add(graph.addVertex(null));
        }
        for (int i = 0; i < 1000; i++) {
            Vertex a = vertices.get(random.nextInt(vertices.size()));
            Vertex b = vertices.get(random.nextInt(vertices.size()));
            if (a != b) {
                edges.add(graph.addEdge(null, a, b, convertId("a" + UUID.randomUUID())));
            }
        }
        int counter = 0;
        for (Edge e : edges) {
            counter = counter + 1;
            graph.removeEdge(e);
            if (config.supportsEdgeIteration) {
                assertEquals(countIterator(graph.getEdges()), edges.size() - counter);
            }
            if (config.supportsVertexIteration) {
                assertEquals(countIterator(graph.getVertices()), vertices.size());
            }
        }


    }

    public void testRemovingVertices(Graph graph) {
        List<Vertex> vertices = new ArrayList<Vertex>();
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < 500; i++) {
            vertices.add(graph.addVertex(null));
        }
        for (int i = 0; i < 500; i = i + 2) {
            Vertex a = vertices.get(i);
            Vertex b = vertices.get(i + 1);
            edges.add(graph.addEdge(null, a, b, convertId("a" + UUID.randomUUID())));

        }
        int counter = 0;
        for (Vertex v : vertices) {
            counter = counter + 1;
            graph.removeVertex(v);
            if (counter + 1 % 2 == 0) {
                if (config.supportsEdgeIteration) {
                    assertEquals(countIterator(graph.getEdges()), edges.size() - counter);
                }
            }

            if (config.supportsVertexIteration) {
                assertEquals(countIterator(graph.getVertices()), vertices.size() - counter);
            }

        }


    }
}

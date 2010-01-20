package com.tinkerpop.gremlin.model;

import java.util.*;

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

    public void testClear(Graph graph) {
        if(config.supportsVertexIteration)
            assertEquals(countIterator(graph.getVertices()), 0);
        if(config.supportsEdgeIteration)
            assertEquals(countIterator(graph.getEdges()), 0);

        for(int i=0; i<25; i++) {
            Vertex a = graph.addVertex(null);
            Vertex b = graph.addVertex(null);
            graph.addEdge(null, a, b, convertId("knows"));
        }

        if(config.supportsVertexIteration)
            assertEquals(countIterator(graph.getVertices()), 50);
        if(config.supportsEdgeIteration)
            assertEquals(countIterator(graph.getEdges()), 25);

        graph.clear();

        if(config.supportsVertexIteration)
            assertEquals(countIterator(graph.getVertices()), 0);
        if(config.supportsEdgeIteration)
            assertEquals(countIterator(graph.getEdges()), 0);

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

    public void testConnectivityPatterns(Graph graph) {
        Vertex a = graph.addVertex(convertId("1"));
        Vertex b = graph.addVertex(convertId("2"));
        Vertex c = graph.addVertex(convertId("3"));
        Vertex d = graph.addVertex(convertId("4"));

        if (config.supportsVertexIteration)
            assertEquals(countIterator(graph.getVertices()), 4);

        Edge e = graph.addEdge(null, a, b, convertId("knows"));
        Edge f = graph.addEdge(null, b, c, convertId("knows"));
        Edge g = graph.addEdge(null, c, d, convertId("knows"));
        Edge h = graph.addEdge(null, d, a, convertId("knows"));

        if (config.supportsEdgeIteration)
            assertEquals(countIterator(graph.getEdges()), 4);

        if (config.supportsVertexIteration) {
            for (Vertex v : graph.getVertices()) {
                assertEquals(v.getOutEdges().size(), 1);
                assertEquals(v.getInEdges().size(), 1);
            }
        }

        if (config.supportsEdgeIteration) {
            for (Edge x : graph.getEdges()) {
                assertEquals(x.getLabel(), convertId("knows"));
            }
        }

        a = graph.getVertex(convertId("1"));
        b = graph.getVertex(convertId("2"));
        c = graph.getVertex(convertId("3"));
        d = graph.getVertex(convertId("4"));

        assertEquals(a.getBothEdges().size(), 2);
        assertEquals(b.getBothEdges().size(), 2);
        assertEquals(c.getBothEdges().size(), 2);
        assertEquals(d.getBothEdges().size(), 2);

        Edge i = graph.addEdge(null, a, b, convertId("hates"));

        assertEquals(a.getBothEdges().size(), 3);
        assertEquals(b.getBothEdges().size(), 3);
        assertEquals(c.getBothEdges().size(), 2);
        assertEquals(d.getBothEdges().size(), 2);

        assertEquals(a.getInEdges().size(), 1);
        assertEquals(a.getOutEdges().size(), 2);
        for (Edge x : a.getOutEdges()) {
            assertTrue(x.getLabel().equals(convertId("knows")) || x.getLabel().equals(convertId("hates")));
        }
        assertEquals(i.getLabel(), convertId("hates"));
        assertEquals(i.getInVertex().getId().toString(), convertId("2"));
        assertEquals(i.getOutVertex().getId().toString(), convertId("1"));

        Set<Object> vertexIds = new HashSet<Object>();
        vertexIds.add(a.getId());
        vertexIds.add(a.getId());
        vertexIds.add(b.getId());
        vertexIds.add(b.getId());
        vertexIds.add(c.getId());
        vertexIds.add(d.getId());
        vertexIds.add(d.getId());
        vertexIds.add(d.getId());
        assertEquals(vertexIds.size(), 4);

    }

    public void testConnectivityPatterns2(Graph graph) {
        Vertex a = graph.addVertex(convertId("1"));
        Vertex b = graph.addVertex(convertId("2"));
        Vertex c = graph.addVertex(convertId("3"));
        Vertex d = graph.addVertex(convertId("4"));

        if (config.supportsVertexIteration)
            assertEquals(countIterator(graph.getVertices()), 4);

        Edge e = graph.addEdge(null, a, b, convertId("knows"));
        Edge f = graph.addEdge(null, b, c, convertId("knows"));
        Edge g = graph.addEdge(null, b, d, convertId("knows"));
        Edge h = graph.addEdge(null, d, a, convertId("knows"));

        Set<Edge> aOut = a.getOutEdges();
        assertEquals(aOut.size(), 1);
        assertEquals(aOut.iterator().next().getInVertex(), b);
        Set<Edge> bOut = b.getOutEdges();
        assertEquals(bOut.size(), 2);

    }
}

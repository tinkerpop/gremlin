package com.tinkerpop.gremlin.models.ggm;

import com.tinkerpop.gremlin.models.ggm.Edge;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.models.ggm.Vertex;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GraphTestSuite extends ModelTestSuite {

    public GraphTestSuite() {
    }

    public GraphTestSuite(SuiteConfiguration config) {
        super(config);
    }

    public void testClear(Graph graph) {
        if (config.supportsVertexIteration)
            assertEquals(count(graph.getVertices()), 0);
        if (config.supportsEdgeIteration)
            assertEquals(count(graph.getEdges()), 0);

        for (int i = 0; i < 25; i++) {
            Vertex a = graph.addVertex(null);
            Vertex b = graph.addVertex(null);
            graph.addEdge(null, a, b, convertId("knows"));
        }

        if (config.supportsVertexIteration)
            assertEquals(count(graph.getVertices()), 50);
        if (config.supportsEdgeIteration)
            assertEquals(count(graph.getEdges()), 25);

        graph.clear();

        if (config.supportsVertexIteration)
            assertEquals(count(graph.getVertices()), 0);
        if (config.supportsEdgeIteration)
            assertEquals(count(graph.getEdges()), 0);

    }

    public void testAddingVerticesAndEdges(Graph graph) {
        Vertex a = graph.addVertex(null);
        Vertex b = graph.addVertex(null);
        Edge edge = graph.addEdge(null, a, b, convertId("knows"));
        if (config.supportsEdgeIteration) {
            assertEquals(count(graph.getEdges()), 1);
        }
        if (config.supportsVertexIteration) {
            assertEquals(count(graph.getVertices()), 2);
        }
        graph.removeVertex(a);
        if (config.supportsEdgeIteration) {
            assertEquals(count(graph.getEdges()), 0);
        }
        if (config.supportsVertexIteration) {
            assertEquals(count(graph.getVertices()), 1);
        }
        try {
            graph.removeEdge(edge);
            if (config.supportsEdgeIteration) {
                assertEquals(count(graph.getEdges()), 0);
            }
            if (config.supportsVertexIteration) {
                assertEquals(count(graph.getVertices()), 1);
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
                assertEquals(count(graph.getEdges()), edges.size() - counter);
            }
            if (config.supportsVertexIteration) {
                assertEquals(count(graph.getVertices()), vertices.size());
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
                    assertEquals(count(graph.getEdges()), edges.size() - counter);
                }
            }

            if (config.supportsVertexIteration) {
                assertEquals(count(graph.getVertices()), vertices.size() - counter);
            }
        }
    }

    public void testConnectivityPatterns(Graph graph) {
        Vertex a = graph.addVertex(convertId("1"));
        Vertex b = graph.addVertex(convertId("2"));
        Vertex c = graph.addVertex(convertId("3"));
        Vertex d = graph.addVertex(convertId("4"));

        if (config.supportsVertexIteration)
            assertEquals(count(graph.getVertices()), 4);

        Edge e = graph.addEdge(null, a, b, convertId("knows"));
        Edge f = graph.addEdge(null, b, c, convertId("knows"));
        Edge g = graph.addEdge(null, c, d, convertId("knows"));
        Edge h = graph.addEdge(null, d, a, convertId("knows"));

        if (config.supportsEdgeIteration)
            assertEquals(count(graph.getEdges()), 4);

        if (config.supportsVertexIteration) {
            for (Vertex v : graph.getVertices()) {
                assertEquals(count(v.getOutEdges()), 1);
                assertEquals(count(v.getInEdges()), 1);
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

        assertEquals(count(a.getInEdges()), 1);
        assertEquals(count(a.getOutEdges()), 1);
        assertEquals(count(b.getInEdges()), 1);
        assertEquals(count(b.getOutEdges()), 1);
        assertEquals(count(c.getInEdges()), 1);
        assertEquals(count(c.getOutEdges()), 1);
        assertEquals(count(d.getInEdges()), 1);
        assertEquals(count(d.getOutEdges()), 1);

        Edge i = graph.addEdge(null, a, b, convertId("hates"));

        assertEquals(count(a.getInEdges()), 1);
        assertEquals(count(a.getOutEdges()), 2);
        assertEquals(count(b.getInEdges()), 2);
        assertEquals(count(b.getOutEdges()), 1);
        assertEquals(count(c.getInEdges()), 1);
        assertEquals(count(c.getOutEdges()), 1);
        assertEquals(count(d.getInEdges()), 1);
        assertEquals(count(d.getOutEdges()), 1);

        assertEquals(count(a.getInEdges()), 1);
        assertEquals(count(a.getOutEdges()), 2);
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

    public void testTreeConnectivity(Graph graph) {
        int branchSize = 11;
        Vertex start = graph.addVertex(null);
        for (int i = 0; i < branchSize; i++) {
            Vertex a = graph.addVertex(null);
            graph.addEdge(null, start, a, convertId("test1"));
            for (int j = 0; j < branchSize; j++) {
                Vertex b = graph.addVertex(null);
                graph.addEdge(null, a, b, convertId("test2"));
                for (int k = 0; k < branchSize; k++) {
                    Vertex c = graph.addVertex(null);
                    graph.addEdge(null, b, c, convertId("test3"));
                }
            }
        }

        assertEquals(count(start.getInEdges()), 0);
        assertEquals(count(start.getOutEdges()), branchSize);
        for (Edge e : start.getOutEdges()) {
            assertEquals(e.getLabel(), convertId("test1"));
            assertEquals(count(e.getInVertex().getOutEdges()), branchSize);
            assertEquals(count(e.getInVertex().getInEdges()), 1);
            for (Edge f : e.getInVertex().getOutEdges()) {
                assertEquals(f.getLabel(), convertId("test2"));
                assertEquals(count(f.getInVertex().getOutEdges()), branchSize);
                assertEquals(count(f.getInVertex().getInEdges()), 1);
                for (Edge g : f.getInVertex().getOutEdges()) {
                    assertEquals(g.getLabel(), convertId("test3"));
                    assertEquals(count(g.getInVertex().getOutEdges()), 0);
                    assertEquals(count(g.getInVertex().getInEdges()), 1);
                }
            }
        }

        int totalVertices = 0;
        for (int i = 0; i < 4; i++) {
            totalVertices = totalVertices + (int) Math.pow(branchSize, i);
        }

        if (config.supportsVertexIteration) {
            Set<Vertex> vertices = new HashSet<Vertex>();
            for (Vertex v : graph.getVertices()) {
                vertices.add(v);
            }
            assertEquals(vertices.size(), totalVertices);
        }

        if (config.supportsEdgeIteration) {
            Set<Edge> edges = new HashSet<Edge>();
            for (Edge e : graph.getEdges()) {
                edges.add(e);
            }
            assertEquals(edges.size(), totalVertices - 1);
        }

    }
}

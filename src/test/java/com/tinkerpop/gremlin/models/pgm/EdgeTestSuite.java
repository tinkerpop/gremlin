package com.tinkerpop.gremlin.models.pgm;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EdgeTestSuite extends ModelTestSuite {

    public EdgeTestSuite() {
    }

    public EdgeTestSuite(SuiteConfiguration config) {
        super(config);
    }

    public void testEdgeEquality(Graph graph) {
        Vertex v = graph.addVertex(convertId("1"));
        Vertex u = graph.addVertex(convertId("2"));
        Edge e = graph.addEdge(null, v, u, convertId("test_label"));
        assertEquals(v.getOutEdges().iterator().next(), e);
        assertEquals(u.getInEdges().iterator().next(), e);
        assertEquals(v.getOutEdges().iterator().next(), u.getInEdges().iterator().next());
        Set<Edge> set = new HashSet<Edge>();
        set.add(e);
        set.add(e);
        set.add(v.getOutEdges().iterator().next());
        set.add(v.getOutEdges().iterator().next());
        set.add(u.getInEdges().iterator().next());
        set.add(u.getInEdges().iterator().next());
        if (config.supportsEdgeIteration)
            set.add(graph.getEdges().iterator().next());
        assertEquals(set.size(), 1);

    }

    public void testAddEdges(Graph graph) {
        Vertex v1 = graph.addVertex(convertId("1"));
        Vertex v2 = graph.addVertex(convertId("2"));
        Vertex v3 = graph.addVertex(convertId("3"));
        graph.addEdge(null, v1, v2, convertId("knows"));
        graph.addEdge(null, v2, v3, convertId("pets"));
        graph.addEdge(null, v2, v3, convertId("cares_for"));
        assertEquals(count(v1.getOutEdges()), 1);
        assertEquals(count(v2.getOutEdges()), 2);
        assertEquals(count(v3.getOutEdges()), 0);
        assertEquals(count(v1.getInEdges()), 0);
        assertEquals(count(v2.getInEdges()), 1);
        assertEquals(count(v3.getInEdges()), 2);
    }

    public void testAddManyEdges(Graph graph) {
        long counter = 0l;
        for (int i = 0; i < 1000; i++) {
            Vertex out = graph.addVertex(convertId("" + counter++));
            Vertex in = graph.addVertex(convertId("" + counter++));
            graph.addEdge(null, out, in, convertId(UUID.randomUUID().toString()));
        }
        if (config.supportsEdgeIteration)
            assertEquals(count(graph.getEdges()), 1000);
        if (config.supportsVertexIteration) {
            assertEquals(count(graph.getVertices()), 2000);
            for (Vertex vertex : graph.getVertices()) {
                if (count(vertex.getOutEdges()) > 0) {
                    assertEquals(count(vertex.getOutEdges()), 1);
                    assertFalse(count(vertex.getInEdges()) > 0);

                } else {
                    assertEquals(count(vertex.getInEdges()), 1);
                    assertFalse(count(vertex.getOutEdges()) > 0);
                }
            }
        }
    }

    public void testRemoveManyEdges(Graph graph) {
        long counter = 200000l;
        int numberOfEdges = 100;
        Set<Edge> edges = new HashSet<Edge>();
        for (int i = 0; i < numberOfEdges; i++) {
            Vertex out = graph.addVertex(convertId("" + counter++));
            Vertex in = graph.addVertex(convertId("" + counter++));
            edges.add(graph.addEdge(null, out, in, convertId("a" + UUID.randomUUID().toString())));
        }
        assertEquals(edges.size(), numberOfEdges);

        if (config.supportsVertexIteration)
            assertEquals(count(graph.getVertices()), numberOfEdges * 2);

        if (config.supportsEdgeIteration) {
            assertEquals(count(graph.getEdges()), numberOfEdges);

            int i = numberOfEdges;
            for (Edge edge : edges) {
                graph.removeEdge(edge);
                i--;
                assertEquals(count(graph.getEdges()), i);
                if (config.supportsVertexIteration) {
                    int x = 0;
                    for (Vertex vertex : graph.getVertices()) {
                        if (count(vertex.getOutEdges()) > 0) {
                            assertEquals(count(vertex.getOutEdges()), 1);
                            assertFalse(count(vertex.getInEdges()) > 0);
                        } else if (count(vertex.getInEdges()) > 0) {
                            assertEquals(count(vertex.getInEdges()), 1);
                            assertFalse(count(vertex.getOutEdges()) > 0);
                        } else {
                            x++;
                        }
                    }
                    assertEquals(x, (numberOfEdges - i) * 2);
                }
            }
        }
    }

    public void testAddingDuplicateEdges(Graph graph) {

        Vertex v1 = graph.addVertex(convertId("1"));
        Vertex v2 = graph.addVertex(convertId("2"));
        Vertex v3 = graph.addVertex(convertId("3"));
        graph.addEdge(null, v1, v2, convertId("knows"));
        graph.addEdge(null, v2, v3, convertId("pets"));
        graph.addEdge(null, v2, v3, convertId("pets"));
        graph.addEdge(null, v2, v3, convertId("pets"));
        graph.addEdge(null, v2, v3, convertId("pets"));

        if (config.allowsDuplicateEdges) {
            if (config.supportsVertexIteration)
                assertEquals(count(graph.getVertices()), 3);
            if (config.supportsEdgeIteration)
                assertEquals(count(graph.getEdges()), 5);

            assertEquals(count(v1.getInEdges()), 0);
            assertEquals(count(v1.getOutEdges()), 1);
            assertEquals(count(v2.getInEdges()), 1);
            assertEquals(count(v2.getOutEdges()), 4);
            assertEquals(count(v3.getInEdges()), 4);
            assertEquals(count(v3.getOutEdges()), 0);
        } else {
            if (config.supportsVertexIteration)
                assertEquals(count(graph.getVertices()), 3);
            if (config.supportsEdgeIteration)
                assertEquals(count(graph.getEdges()), 2);

            assertEquals(count(v1.getInEdges()), 0);
            assertEquals(count(v1.getOutEdges()), 1);
            assertEquals(count(v2.getInEdges()), 1);
            assertEquals(count(v2.getOutEdges()), 1);
            assertEquals(count(v3.getInEdges()), 1);
            assertEquals(count(v3.getOutEdges()), 0);
        }
    }

    public void testRemoveEdgesByRemovingVertex(Graph graph) {
        Vertex v1 = graph.addVertex(convertId("1"));
        Vertex v2 = graph.addVertex(convertId("2"));
        Vertex v3 = graph.addVertex(convertId("3"));
        graph.addEdge(null, v1, v2, convertId("knows"));
        graph.addEdge(null, v2, v3, convertId("pets"));
        graph.addEdge(null, v2, v3, convertId("pets"));

        assertEquals(count(v1.getInEdges()), 0);
        assertEquals(count(v1.getOutEdges()), 1);
        assertEquals(count(v2.getInEdges()), 1);
        assertEquals(count(v3.getOutEdges()), 0);

        v1 = graph.getVertex(convertId("1"));
        v2 = graph.getVertex(convertId("2"));
        v3 = graph.getVertex(convertId("3"));

        assertEquals(count(v1.getInEdges()), 0);
        assertEquals(count(v1.getOutEdges()), 1);
        assertEquals(count(v2.getInEdges()), 1);
        assertEquals(count(v3.getOutEdges()), 0);

        if (config.supportsVertexIteration)
            assertEquals(count(graph.getVertices()), 3);

        graph.removeVertex(v1);

        if (config.supportsVertexIteration)
            assertEquals(count(graph.getVertices()), 2);

        if (config.allowsDuplicateEdges)
            assertEquals(count(v2.getOutEdges()), 2);
        else
            assertEquals(count(v2.getOutEdges()), 1);

        assertEquals(count(v3.getOutEdges()), 0);
        assertEquals(count(v2.getInEdges()), 0);

        if (config.allowsDuplicateEdges)
            assertEquals(count(v3.getInEdges()), 2);
        else
            assertEquals(count(v3.getInEdges()), 1);

    }

    public void testRemoveEdges(Graph graph) {
        Vertex v1 = graph.addVertex(convertId("1"));
        Vertex v2 = graph.addVertex(convertId("2"));
        Vertex v3 = graph.addVertex(convertId("3"));
        Edge e1 = graph.addEdge(null, v1, v2, convertId("knows"));
        Edge e2 = graph.addEdge(null, v2, v3, convertId("pets"));
        Edge e3 = graph.addEdge(null, v2, v3, convertId("cares_for"));

        if (config.supportsVertexIteration)
            assertEquals(count(graph.getVertices()), 3);

        graph.removeEdge(e1);
        assertEquals(count(v1.getOutEdges()), 0);
        assertEquals(count(v2.getOutEdges()), 2);
        assertEquals(count(v3.getOutEdges()), 0);
        assertEquals(count(v1.getInEdges()), 0);
        assertEquals(count(v2.getInEdges()), 0);
        assertEquals(count(v3.getInEdges()), 2);
        v1 = graph.getVertex(convertId("1"));
        v2 = graph.getVertex(convertId("2"));
        v3 = graph.getVertex(convertId("3"));
        assertEquals(count(v1.getOutEdges()), 0);
        assertEquals(count(v2.getOutEdges()), 2);
        assertEquals(count(v3.getOutEdges()), 0);
        assertEquals(count(v1.getInEdges()), 0);
        assertEquals(count(v2.getInEdges()), 0);
        assertEquals(count(v3.getInEdges()), 2);

        graph.removeEdge(e2);
        assertEquals(count(v1.getOutEdges()), 0);
        assertEquals(count(v2.getOutEdges()), 1);
        assertEquals(count(v3.getOutEdges()), 0);
        assertEquals(count(v1.getInEdges()), 0);
        assertEquals(count(v2.getInEdges()), 0);
        assertEquals(count(v3.getInEdges()), 1);
        v1 = graph.getVertex(convertId("1"));
        v2 = graph.getVertex(convertId("2"));
        v3 = graph.getVertex(convertId("3"));
        assertEquals(count(v1.getOutEdges()), 0);
        assertEquals(count(v2.getOutEdges()), 1);
        assertEquals(count(v3.getOutEdges()), 0);
        assertEquals(count(v1.getInEdges()), 0);
        assertEquals(count(v2.getInEdges()), 0);
        assertEquals(count(v3.getInEdges()), 1);

        graph.removeEdge(e3);
        assertEquals(count(v1.getOutEdges()), 0);
        assertEquals(count(v2.getOutEdges()), 0);
        assertEquals(count(v3.getOutEdges()), 0);
        assertEquals(count(v1.getInEdges()), 0);
        assertEquals(count(v2.getInEdges()), 0);
        assertEquals(count(v3.getInEdges()), 0);
        v1 = graph.getVertex(convertId("1"));
        v2 = graph.getVertex(convertId("2"));
        v3 = graph.getVertex(convertId("3"));
        assertEquals(count(v1.getOutEdges()), 0);
        assertEquals(count(v2.getOutEdges()), 0);
        assertEquals(count(v3.getOutEdges()), 0);
        assertEquals(count(v1.getInEdges()), 0);
        assertEquals(count(v2.getInEdges()), 0);
        assertEquals(count(v3.getInEdges()), 0);

    }

    public void testAddingSelfLoops(Graph graph) {
        if (config.allowsSelfLoops) {
            Vertex v1 = graph.addVertex(convertId("1"));
            Vertex v2 = graph.addVertex(convertId("2"));
            Vertex v3 = graph.addVertex(convertId("3"));
            graph.addEdge(null, v1, v1, convertId("is_self"));
            graph.addEdge(null, v2, v2, convertId("is_self"));
            graph.addEdge(null, v3, v3, convertId("is_self"));

            if (config.supportsVertexIteration)
                assertEquals(count(graph.getVertices()), 3);
            if (config.supportsEdgeIteration) {
                assertEquals(count(graph.getEdges()), 3);
                int counter = 0;
                for (Edge edge : graph.getEdges()) {
                    counter++;
                    assertEquals(edge.getInVertex(), edge.getOutVertex());
                    assertEquals(edge.getInVertex().getId(), edge.getOutVertex().getId());
                }
                assertEquals(counter, 3);
            }

        }
    }

    public void testRemoveSelfLoops(Graph graph) {
        if (config.allowsSelfLoops) {
            Vertex v1 = graph.addVertex(convertId("1"));
            Vertex v2 = graph.addVertex(convertId("2"));
            Vertex v3 = graph.addVertex(convertId("3"));
            Edge e1 = graph.addEdge(null, v1, v1, convertId("is_self"));
            Edge e2 = graph.addEdge(null, v2, v2, convertId("is_self"));
            Edge e3 = graph.addEdge(null, v3, v3, convertId("is_self"));

            if (config.supportsVertexIteration)
                assertEquals(count(graph.getVertices()), 3);
            if (config.supportsEdgeIteration) {
                assertEquals(count(graph.getEdges()), 3);
                for (Edge edge : graph.getEdges()) {
                    assertEquals(edge.getInVertex(), edge.getOutVertex());
                    assertEquals(edge.getInVertex().getId(), edge.getOutVertex().getId());
                }
            }

            graph.removeVertex(v1);
            if (config.supportsEdgeIteration) {
                assertEquals(count(graph.getEdges()), 2);
                for (Edge edge : graph.getEdges()) {
                    assertEquals(edge.getInVertex(), edge.getOutVertex());
                    assertEquals(edge.getInVertex().getId(), edge.getOutVertex().getId());
                }
            }

            assertEquals(count(v2.getOutEdges()), 1);
            assertEquals(count(v2.getInEdges()), 1);
            graph.removeEdge(e2);
            assertEquals(count(v2.getOutEdges()), 0);
            assertEquals(count(v2.getInEdges()), 0);

            if (config.supportsEdgeIteration) {
                assertEquals(count(graph.getEdges()), 1);
                for (Edge edge : graph.getEdges()) {
                    assertEquals(edge.getInVertex(), edge.getOutVertex());
                    assertEquals(edge.getInVertex().getId(), edge.getOutVertex().getId());
                }
            }
        }
    }

    public void testEdgeIterator(Graph graph) {
        if (config.supportsEdgeIteration) {
            Vertex v1 = graph.addVertex(convertId("1"));
            Vertex v2 = graph.addVertex(convertId("2"));
            Vertex v3 = graph.addVertex(convertId("3"));
            Edge e1 = graph.addEdge(null, v1, v2, convertId("test"));
            Edge e2 = graph.addEdge(null, v2, v3, convertId("test"));
            Edge e3 = graph.addEdge(null, v3, v1, convertId("test"));

            if (config.supportsVertexIteration)
                assertEquals(count(graph.getVertices()), 3);
            if (config.supportsEdgeIteration)
                assertEquals(count(graph.getEdges()), 3);

            Set<String> edgeIds = new HashSet<String>();
            int count = 0;
            for (Edge e : graph.getEdges()) {
                count++;
                edgeIds.add(e.getId().toString());
                assertEquals(e.getLabel(), convertId("test"));
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
    }
}

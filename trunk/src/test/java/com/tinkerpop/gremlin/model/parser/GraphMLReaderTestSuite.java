package com.tinkerpop.gremlin.model.parser;

import com.tinkerpop.gremlin.model.*;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GraphMLReaderTestSuite extends ModelTestSuite {

    public GraphMLReaderTestSuite() {}

    public GraphMLReaderTestSuite(SuiteConfiguration config) {
        super(config);
    }

    public static void testReadingTinkerGraph(Graph graph) throws Exception {

        InputStream stream = GraphMLReader.class.getResourceAsStream("graph-example-1.xml");
        GraphMLReader.inputGraph(graph, stream);
        assertEquals(graph.getVertex("1").getOutEdges().size(), 3);
        assertEquals(graph.getVertex("1").getInEdges().size(), 0);
        Vertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");
        assertEquals(marko.getProperty("age"), 29);
        int counter = 0;
        for (Edge e : graph.getVertex("1").getOutEdges()) {
            if (e.getInVertex().getId().equals("2")) {
                //assertEquals(e.getProperty("weight"), 0.5);
                assertEquals(e.getLabel(), "knows");
                assertEquals(e.getId(), "7");
                counter++;
            } else if (e.getInVertex().getId().equals("3")) {
                //assertEquals(e.getProperty("weight"), 0.4);
                assertEquals(e.getLabel(), "created");
                assertEquals(e.getId(), "9");
                counter++;
            } else if (e.getInVertex().getId().equals("4")) {
                //assertEquals(e.getProperty("weight"), 1.0);
                assertEquals(e.getLabel(), "knows");
                assertEquals(e.getId(), "8");
                counter++;
            }
        }

        assertEquals(graph.getVertex("4").getOutEdges().size(), 2);
        assertEquals(graph.getVertex("4").getInEdges().size(), 1);
        Vertex josh = graph.getVertex("4");
        assertEquals(josh.getProperty("name"), "josh");
        assertEquals(josh.getProperty("age"), 32);
        for (Edge e : graph.getVertex("4").getOutEdges()) {
            if (e.getInVertex().getId().equals("3")) {
                //assertEquals(e.getProperty("weight"), 0.4);
                assertEquals(e.getLabel(), "created");
                assertEquals(e.getId(), "11");
                counter++;
            } else if (e.getInVertex().getId().equals("5")) {
                //assertEquals(e.getProperty("weight"), 1.0);
                assertEquals(e.getLabel(), "created");
                assertEquals(e.getId(), "10");
                counter++;
            }
        }

        assertEquals(counter, 5);

    }

    public void testTinkerGraphEdges(Graph graph) throws Exception {
        GraphMLReader.inputGraph(graph, GraphMLReader.class.getResourceAsStream("graph-example-1.xml"));
        Set<String> edgeIds = new HashSet<String>();
        Set<String> edgeKeys = new HashSet<String>();
        Set<String> edgeValues = new HashSet<String>();
        int count = 0;
        for (Edge e : graph.getEdges()) {
            count++;
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

    public static void testTinkerGraphVertices(Graph graph) throws Exception {
        GraphMLReader.inputGraph(graph, GraphMLReader.class.getResourceAsStream("graph-example-1.xml"));
        Set<String> vertexNames = new HashSet<String>();
        int count = 0;
        for(Vertex v : graph.getVertices()) {
            count++;
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
        Set<Vertex> softwareVertices = new HashSet<Vertex>();
        int count = 0;
        for(Vertex v : graph.getVertices()) {
            count++;
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

package com.tinkerpop.gremlin.model.parser;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.ModelTestSuite;
import junit.framework.TestCase;

import java.io.InputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GraphMLReaderTestSuite extends ModelTestSuite {

    public static void testReadingTinkerGraph(Graph graph) throws Exception {

        InputStream stream = GraphMLReader.class.getResourceAsStream("graph-example-1.xml");
        GraphMLReader.inputGraph(graph, stream);
        assertEquals(graph.getVertex("1").getOutEdges().size(), 3);
        assertEquals(graph.getVertex("1").getBothEdges().size(), 3);
        assertEquals(graph.getVertex("1").getInEdges().size(), 0);
        Vertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");
        assertEquals(marko.getProperty("age"), 29);
        int counter = 0;
        for (Edge e : graph.getVertex("1").getOutEdges()) {
            if (e.getInVertex().getId().equals("2")) {
                assertEquals(e.getProperty("weight"), new Float(0.5));
                assertEquals(e.getLabel(), "knows");
                assertEquals(e.getId(), "7");
                counter++;
            } else if (e.getInVertex().getId().equals("3")) {
                assertEquals(e.getProperty("weight"), new Float(0.4));
                assertEquals(e.getLabel(), "created");
                assertEquals(e.getId(), "9");
                counter++;
            } else if (e.getInVertex().getId().equals("4")) {
                assertEquals(e.getProperty("weight"), new Float(1.0));
                assertEquals(e.getLabel(), "knows");
                assertEquals(e.getId(), "8");
                counter++;
            }
        }

        assertEquals(graph.getVertex("4").getOutEdges().size(), 2);
        assertEquals(graph.getVertex("4").getBothEdges().size(), 3);
        assertEquals(graph.getVertex("4").getInEdges().size(), 1);
        Vertex josh = graph.getVertex("4");
        assertEquals(josh.getProperty("name"), "josh");
        assertEquals(josh.getProperty("age"), 32);
        for (Edge e : graph.getVertex("4").getOutEdges()) {
            if (e.getInVertex().getId().equals("3")) {
                assertEquals(e.getProperty("weight"), new Float(0.4));
                assertEquals(e.getLabel(), "created");
                assertEquals(e.getId(), "11");
                counter++;
            } else if (e.getInVertex().getId().equals("5")) {
                assertEquals(e.getProperty("weight"), new Float(1.0));
                assertEquals(e.getLabel(), "created");
                assertEquals(e.getId(), "10");
                counter++;
            }
        }

        assertEquals(counter, 5);

    }
}

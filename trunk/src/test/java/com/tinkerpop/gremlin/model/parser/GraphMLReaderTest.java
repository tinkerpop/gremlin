package com.tinkerpop.gremlin.model.parser;

import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.db.tg.TinkerVertex;
import com.tinkerpop.gremlin.model.parser.GraphMLReader;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.model.Edge;

import java.io.InputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GraphMLReaderTest extends BaseTest {

    public void testParsingForTinkerGraph() throws Exception {
        InputStream stream = TinkerGraph.class.getResourceAsStream("graph-example-1.xml");
        TinkerGraph g = new TinkerGraph();
        GraphMLReader.inputGraph(g, stream);
        assertEquals(g.getVertex("1").getOutEdges().size(), 3);
        assertEquals(g.getVertex("1").getBothEdges().size(), 3);
        assertEquals(g.getVertex("1").getInEdges().size(), 0);
        TinkerVertex marko = g.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");
        assertEquals(marko.getProperty("age"), 29);
        int counter = 0;
        for(Edge e : g.getVertex("1").getOutEdges()) {
            if(e.getInVertex().getId().equals("2")) {
                assertEquals(e.getProperty("weight"), new Float(0.5));
                assertEquals(e.getLabel(), "knows");
                assertEquals(e.getId(), "7");
                counter++;
            } else if(e.getInVertex().getId().equals("3")) {
                assertEquals(e.getProperty("weight"), new Float(0.4));
                assertEquals(e.getLabel(), "created");
                assertEquals(e.getId(), "9");
                counter++;
            } else if(e.getInVertex().getId().equals("4")) {
                assertEquals(e.getProperty("weight"), new Float(1.0));
                assertEquals(e.getLabel(), "knows");
                assertEquals(e.getId(), "8");
                counter++;
            }
        }

        assertEquals(g.getVertex("4").getOutEdges().size(), 2);
        assertEquals(g.getVertex("4").getBothEdges().size(), 3);
        assertEquals(g.getVertex("4").getInEdges().size(), 1);
        TinkerVertex josh = g.getVertex("4");
        assertEquals(josh.getProperty("name"), "josh");
        assertEquals(josh.getProperty("age"), 32);
        for(Edge e : g.getVertex("4").getOutEdges()) {
            if(e.getInVertex().getId().equals("3")) {
                assertEquals(e.getProperty("weight"), new Float(0.4));
                assertEquals(e.getLabel(), "created");
                assertEquals(e.getId(), "11");
                counter++;
            } else if(e.getInVertex().getId().equals("5")) {
                assertEquals(e.getProperty("weight"), new Float(1.0));
                assertEquals(e.getLabel(), "created");
                assertEquals(e.getId(), "10");
                counter++;
            }
        }

        assertEquals(counter, 5);

    }
}

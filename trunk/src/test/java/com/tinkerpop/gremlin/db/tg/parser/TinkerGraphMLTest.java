package com.tinkerpop.gremlin.db.tg.parser;

import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.db.tg.TinkerVertex;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.model.Edge;

import java.io.InputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraphMLTest extends BaseTest {

    public void testParsing() throws Exception {
        InputStream stream = TinkerGraph.class.getResourceAsStream("graph-example-1.xml");
        TinkerGraph g = TinkerGraphML.generateGraph(stream);
        assertEquals(g.getVertex("1").getEdges(Element.Direction.OUT).size(), 3);
        assertEquals(g.getVertex("1").getEdges(Element.Direction.BOTH).size(), 3);
        assertEquals(g.getVertex("1").getEdges(Element.Direction.IN).size(), 0);
        TinkerVertex marko = g.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");
        assertEquals(marko.getProperty("age"), 29);
        int counter = 0;
        for(Edge e : g.getVertex("1").getEdges(Element.Direction.OUT)) {
            if(e.getVertex(Element.Direction.IN).getId().equals("2")) {
                assertEquals(e.getProperty("weight"), new Float(0.5));
                assertEquals(e.getLabel(), "knows");
                counter++;
            } else if(e.getVertex(Element.Direction.IN).getId().equals("3")) {
                assertEquals(e.getProperty("weight"), new Float(0.4));
                assertEquals(e.getLabel(), "created");
                counter++;
            } else if(e.getVertex(Element.Direction.IN).getId().equals("4")) {
                assertEquals(e.getProperty("weight"), new Float(1.0));
                assertEquals(e.getLabel(), "knows");
                counter++;
            }
        }

        assertEquals(g.getVertex("4").getEdges(Element.Direction.OUT).size(), 2);
        assertEquals(g.getVertex("4").getEdges(Element.Direction.BOTH).size(), 3);
        assertEquals(g.getVertex("4").getEdges(Element.Direction.IN).size(), 1);
        TinkerVertex josh = g.getVertex("4");
        assertEquals(josh.getProperty("name"), "josh");
        assertEquals(josh.getProperty("age"), 32);
        for(Edge e : g.getVertex("4").getEdges(Element.Direction.OUT)) {
            if(e.getVertex(Element.Direction.IN).getId().equals("3")) {
                assertEquals(e.getProperty("weight"), new Float(0.4));
                assertEquals(e.getLabel(), "created");
                counter++;
            } else if(e.getVertex(Element.Direction.IN).getId().equals("5")) {
                assertEquals(e.getProperty("weight"), new Float(1.0));
                assertEquals(e.getLabel(), "created");
                counter++;
            }
        }

        assertEquals(counter, 5);

    }
}

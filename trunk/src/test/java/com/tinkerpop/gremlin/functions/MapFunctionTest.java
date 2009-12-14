package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.Map;

import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MapFunctionTest extends TestCase {

    public void testMapFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluate("g:map()").size(), 1);
        assertEquals(xe.evaluate("g:type(g:map())").get(0), "map");

        try {
            xe.evaluate("g:map(1)");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }


    }

    public void testMapFunctionElement() {
        XPathEvaluator xe = new XPathEvaluator();
        Vertex marko = TinkerGraphFactory.createTinkerGraph().getVertex("1");
        Edge edge = TinkerGraphFactory.createTinkerGraph().getVertex("1").getOutEdges().iterator().next();
        xe.setVariable("$v", marko);
        xe.setVariable("$e", edge);
        assertEquals(((Map)(xe.evaluate("g:map($v)")).get(0)).keySet().size(), 2);
        assertTrue(((Map)(xe.evaluate("g:map($v)")).get(0)).keySet().contains("age"));
        assertTrue(((Map)(xe.evaluate("g:map($v)")).get(0)).keySet().contains("name"));
        assertEquals(((Map)(xe.evaluate("g:map($e)")).get(0)).keySet().size(), 1);
        assertTrue(((Map)(xe.evaluate("g:map($e)")).get(0)).keySet().contains("weight"));
    }

}

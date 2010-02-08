package com.tinkerpop.gremlin.functions.g.lme;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.models.pgm.Edge;
import com.tinkerpop.gremlin.models.pgm.Vertex;
import com.tinkerpop.gremlin.models.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.statements.EvaluationException;
import junit.framework.TestCase;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MapFunctionTest extends TestCase {

    public void testMapFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:map()").size(), 1);
        assertEquals(xe.evaluateList("g:type(g:map())").get(0), "map");

        try {
            xe.evaluateList("g:map(1)");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }

    public void testMapFunctionElement() {
        XPathEvaluator xe = new XPathEvaluator();
        Vertex marko = TinkerGraphFactory.createTinkerGraph().getVertex("1");
        Edge edge = TinkerGraphFactory.createTinkerGraph().getVertex("1").getOutEdges().iterator().next();
        xe.getVariables().declareVariable("$v", marko);
        xe.getVariables().declareVariable("$e", edge);
        assertEquals(((Map) (xe.evaluateList("g:map($v)")).get(0)).keySet().size(), 2);
        assertTrue(((Map) (xe.evaluateList("g:map($v)")).get(0)).keySet().contains("age"));
        assertTrue(((Map) (xe.evaluateList("g:map($v)")).get(0)).keySet().contains("name"));
        assertEquals(((Map) (xe.evaluateList("g:map($e)")).get(0)).keySet().size(), 1);
        assertTrue(((Map) (xe.evaluateList("g:map($e)")).get(0)).keySet().contains("weight"));
    }

    public void testMapEmbeddingFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:map('key1',g:list(1,2,3))").size(), 1);
        assertEquals(xe.evaluateList("g:map('key1',g:list(1,2,3),'key2',g:map('key0','value0'))").size(), 1);
        assertEquals(xe.evaluateList("g:map('key1',g:list(1,2,3),'key2',g:map('key0','value0'),'key3',g:map('key00',g:list(1,2,3)))").size(), 1);
    }

}

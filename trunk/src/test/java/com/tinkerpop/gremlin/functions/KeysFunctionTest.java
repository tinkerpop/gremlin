package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class KeysFunctionTest extends TestCase {

    public void testKeysFunctionMap() {
        XPathEvaluator xe = new XPathEvaluator();
        Map map = new HashMap();
        map.put("marko", 1);
        map.put("josh", 2);
        map.put(3, "peter");
        xe.setVariable("$m", map);
        assertEquals(xe.evaluate("g:keys($m)").size(), 3);
        assertTrue(xe.evaluate("g:keys($m)").contains("marko"));
        assertTrue(xe.evaluate("g:keys($m)").contains("josh"));
        assertTrue(xe.evaluate("g:keys($m)").contains(3));
        assertFalse(xe.evaluate("g:keys($m)").contains("peter"));
    }

    public void testKeysFunctionElement() {
        XPathEvaluator xe = new XPathEvaluator();
        Vertex marko = TinkerGraphFactory.createTinkerGraph().getVertex("1");
        xe.setVariable("$v", marko);
        assertEquals(xe.evaluate("g:keys($v)").size(), 2);
        assertTrue(xe.evaluate("g:keys($v)").contains("age"));
        assertTrue(xe.evaluate("g:keys($v)").contains("name"));
        assertFalse(xe.evaluate("g:keys($v)").contains(3));
        assertFalse(xe.evaluate("g:keys($v)").contains("marko"));
    }


}

package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FromJsonFunctionTest extends TestCase {

    public void testFromMap() {
        String jsonString = "{\"key1\":[1,2,3], \"key2\":\"marko\"}";
        XPathEvaluator xe = new XPathEvaluator();
        Object list = xe.evaluateList("g:from-json('" + jsonString + "')");
        assertTrue(list instanceof List);
        assertTrue(((List) list).get(0) instanceof Map);
        Map map = (Map) ((List) list).get(0);
        List array = (List) map.get("key1");
        assertEquals(array.get(0), 1l);
        assertEquals(array.get(1), 2l);
        assertEquals(array.get(2), 3l);
        assertEquals(map.get("key2"), "marko");
    }


    public void testFromList() {
        String jsonString = "[1,2,3,4,\"marko\"]";
        XPathEvaluator xe = new XPathEvaluator();
        Object list = xe.evaluateList("g:from-json('" + jsonString + "')");
        assertTrue(list instanceof List);
        assertEquals(((List) list).get(0), 1l);
        assertEquals(((List) list).get(1), 2l);
        assertEquals(((List) list).get(2), 3l);
        assertEquals(((List) list).get(3), 4l);
        assertEquals(((List) list).get(4), "marko");

    }

    public void testFromPrimitive() {
        XPathEvaluator xe = new XPathEvaluator();

        String jsonString = "1";
        Object object = xe.evaluateList("g:from-json('" + jsonString + "')").get(0);
        assertTrue(object instanceof Number);
        assertEquals(object, 1l);

        jsonString = "\"marko\"";
        object = xe.evaluateList("g:from-json('" + jsonString + "')").get(0);
        assertTrue(object instanceof String);
        assertEquals(object, "marko");

        jsonString = "1.0468";
        object = xe.evaluateList("g:from-json('" + jsonString + "')").get(0);
        assertTrue(object instanceof Number);
        assertEquals(object, 1.0468d);

        jsonString = "true";
        object = xe.evaluateList("g:from-json('" + jsonString + "')").get(0);
        assertTrue(object instanceof Boolean);
        assertEquals(object, true);

        jsonString = "false";
        object = xe.evaluateList("g:from-json('" + jsonString + "')").get(0);
        assertTrue(object instanceof Boolean);
        assertEquals(object, false);

        jsonString = "null";
        assertEquals(xe.evaluateList("g:from-json('" + jsonString + "')").size(), 0);
    }
}

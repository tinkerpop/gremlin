package com.tinkerpop.gremlin.functions.util;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ToJsonFunctionTest extends TestCase {

    public void testToPrimitive() {
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable("$x", 1.0d);
        Object object = xe.evaluateList("g:to-json($x)").get(0);
        assertTrue(object instanceof String);
        assertEquals(object, "1.0");
        xe.getVariables().declareVariable("$x", 1.02d);
        object = xe.evaluateList("g:to-json($x)").get(0);
        assertTrue(object instanceof String);
        assertEquals(object, "1.02");
        xe.getVariables().declareVariable("$x", Boolean.TRUE);
        object = xe.evaluateList("g:to-json($x)").get(0);
        assertTrue(object instanceof String);
        assertEquals(object, "true");
        xe.getVariables().declareVariable("$x", Boolean.FALSE);
        object = xe.evaluateList("g:to-json($x)").get(0);
        assertTrue(object instanceof String);
        assertEquals(object, "false");
        xe.getVariables().declareVariable("$x", "marko");
        object = xe.evaluateList("g:to-json($x)").get(0);
        assertTrue(object instanceof String);
        assertEquals(object, "marko");
    }

    public void testToList() {
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable("$x", Arrays.asList(1, 2, 3, 4, "marko"));
        Object object = xe.evaluateList("g:to-json($x)").get(0);
        assertTrue(object instanceof String);
        assertEquals(object, "[1,2,3,4,\"marko\"]");
    }
}

package com.tinkerpop.gremlin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class XPathEvaluatorTest extends BaseTest {

    public void testSetVariables() {
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable("$i", 10);
        assertEquals(xe.getVariable("$i"), 10);
        xe.removeVariable("$i");
        assertNull(xe.getVariable("$i"));
    }

    public void testLastVariable() {
        XPathEvaluator xe = new XPathEvaluator();
        xe.evaluate("1+2");
        assertEquals(xe.getVariable("$_last"), 3.0);
        xe.evaluate("1+2");
        assertEquals(xe.evaluate("g:type($_last)").get(0), "number");
        xe.evaluate("g:append(1,2,3)");
        assertEquals(xe.evaluate("g:type($_last)").get(0), "list");


    }
}

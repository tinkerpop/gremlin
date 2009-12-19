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
        xe.evaluateList("1+2");
        assertEquals(xe.getVariable("$_last"), 3.0);
        xe.evaluateList("1+2");
        assertEquals(xe.evaluateList("g:type($_last)").get(0), "number");
        xe.evaluateList("g:append(1,2,3)");
        assertEquals(xe.evaluateList("g:type($_last)").get(0), "list");


    }
}

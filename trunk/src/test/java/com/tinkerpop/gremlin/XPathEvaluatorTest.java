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
}

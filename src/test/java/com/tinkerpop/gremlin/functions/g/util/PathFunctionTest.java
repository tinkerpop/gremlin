package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathFunctionTest extends TestCase {

    public void testPathFunction() {
        XPathEvaluator xe = new XPathEvaluator();

        assertEquals(xe.evaluateList("g:p(1+2)").size(), 1);
        assertTrue((Boolean) xe.evaluateList("g:p(1+2)").get(0));

        assertEquals(xe.evaluateList("g:p(false())").size(), 1);
        assertTrue((Boolean) xe.evaluateList("g:p(false())").get(0));

        assertEquals(xe.evaluateList("g:p(g:p())").size(), 1);
        assertTrue((Boolean) xe.evaluateList("g:p(g:p())").get(0));
    }
}

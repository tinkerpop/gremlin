package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class DeduplicateFunctionTest extends TestCase {

    public void testDuplicateFunctionTest() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:dedup(g:append(1,2,3,4))").size(), 4);
        assertTrue(xe.evaluateList("g:dedup(g:append(1,2,3,4))").contains(1.0));
        assertTrue(xe.evaluateList("g:dedup(g:append(1,2,3,4))").contains(2.0));
        assertTrue(xe.evaluateList("g:dedup(g:append(1,2,3,4))").contains(3.0));
        assertTrue(xe.evaluateList("g:dedup(g:append(1,2,3,4))").contains(4.0));

        assertEquals(xe.evaluateList("g:dedup(g:append(1,1,2,2,2,3,3,3,3,4,4,4,4,4))").size(), 4);
        assertTrue(xe.evaluateList("g:dedup(g:append(1,1,2,2,2,3,3,3,3,4,4,4,4,4))").contains(1.0));
        assertTrue(xe.evaluateList("g:dedup(g:append(1,1,2,2,2,3,3,3,3,4,4,4,4,4))").contains(2.0));
        assertTrue(xe.evaluateList("g:dedup(g:append(1,1,2,2,2,3,3,3,3,4,4,4,4,4))").contains(3.0));
        assertTrue(xe.evaluateList("g:dedup(g:append(1,1,2,2,2,3,3,3,3,4,4,4,4,4))").contains(4.0));
    }
}

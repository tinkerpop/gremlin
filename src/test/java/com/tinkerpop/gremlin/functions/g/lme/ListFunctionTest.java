package com.tinkerpop.gremlin.functions.g.lme;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ListFunctionTest extends TestCase {

    public void testAppendFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:list(1,2,3,4)").size(), 4);
        assertEquals(xe.evaluateList("g:list(1,2,3,4)").get(0), 1.0);
        assertEquals(xe.evaluateList("g:list(1,2,3,4)").get(1), 2.0);
        assertEquals(xe.evaluateList("g:list(1,2,3,4)").get(2), 3.0);
        assertEquals(xe.evaluateList("g:list(1,2,3,4)").get(3), 4.0);

        assertEquals(xe.evaluateList("g:list(g:list(1,2),3,4)").size(), 4);
        assertEquals(xe.evaluateList("g:list(g:list(1,2),3,4)").get(0), 1.0);
        assertEquals(xe.evaluateList("g:list(g:list(1,2),3,4)").get(1), 2.0);
        assertEquals(xe.evaluateList("g:list(g:list(1,2),3,4)").get(2), 3.0);
        assertEquals(xe.evaluateList("g:list(g:list(1,2),3,4)").get(3), 4.0);

        assertEquals(xe.evaluateList("g:list(g:list(1,2),g:list(3,4))").size(), 4);
        assertEquals(xe.evaluateList("g:list(g:list(1,2),g:list(3,4))").get(0), 1.0);
        assertEquals(xe.evaluateList("g:list(g:list(1,2),g:list(3,4))").get(1), 2.0);
        assertEquals(xe.evaluateList("g:list(g:list(1,2),g:list(3,4))").get(2), 3.0);
        assertEquals(xe.evaluateList("g:list(g:list(1,2),g:list(3,4))").get(3), 4.0);

    }
}

package com.tinkerpop.gremlin.functions.g.lme;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IntersectFunctionTest extends TestCase {

    public void testIntersectFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:intersect(g:list(1,2,3,4),3)").size(), 1);
        assertTrue(xe.evaluateList("g:intersect(g:list(1,2,3,4),3)").contains(3.0));
        assertEquals(xe.evaluateList("g:intersect(g:list(1,2,3,4),g:list(1,2))").size(), 2);
        assertTrue(xe.evaluateList("g:intersect(g:list(1,2,3,4),g:list(1,2))").contains(1.0));
        assertTrue(xe.evaluateList("g:intersect(g:list(1,2,3,4),g:list(1,2))").contains(2.0));
        assertEquals(xe.evaluateList("g:intersect(g:list(1,2,3,4),g:list(1,2,3),g:list(1,2))").size(), 2);
        assertTrue(xe.evaluateList("g:intersect(g:list(1,2,3,4),g:list(1,2,3),g:list(1,2))").contains(1.0));
        assertTrue(xe.evaluateList("g:intersect(g:list(1,2,3,4),g:list(1,2,3),g:list(1,2))").contains(2.0));

        assertEquals(xe.evaluateList("g:intersect(1,1)").size(), 1);
        assertEquals(xe.evaluateList("g:intersect(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)").size(), 1);
        assertEquals(xe.evaluateList("g:intersect(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0)").size(), 0);
        assertEquals(xe.evaluateList("g:intersect(1,2)").size(), 0);
        assertEquals(xe.evaluateList("g:intersect(1,2,3,4,5,6,7,8,9)").size(), 0);

        assertEquals(xe.evaluateList("g:intersect('marko','marko','marko')").size(), 1);
        assertEquals(xe.evaluateList("g:intersect('marko','marko','josh')").size(), 0);
        assertEquals(xe.evaluateList("g:intersect('marko','marko',42)").size(), 0);
    }
}

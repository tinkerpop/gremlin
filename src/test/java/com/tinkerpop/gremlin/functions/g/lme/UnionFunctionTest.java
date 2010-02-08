package com.tinkerpop.gremlin.functions.g.lme;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnionFunctionTest extends TestCase {

    public void testUnionFunction() {

        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:union(1,2,3,4)").size(), 4);
        assertTrue(xe.evaluateList("g:union(1,2,3,4)").contains(1.0));
        assertTrue(xe.evaluateList("g:union(1,2,3,4)").contains(2.0));
        assertTrue(xe.evaluateList("g:union(1,2,3,4)").contains(3.0));
        assertTrue(xe.evaluateList("g:union(1,2,3,4)").contains(4.0));

        assertEquals(xe.evaluateList("g:union(1,2,g:append(3,4))").size(), 4);
        assertTrue(xe.evaluateList("g:union(1,2,g:append(3,4))").contains(1.0));
        assertTrue(xe.evaluateList("g:union(1,2,g:append(3,4))").contains(2.0));
        assertTrue(xe.evaluateList("g:union(1,2,g:append(3,4))").contains(3.0));
        assertTrue(xe.evaluateList("g:union(1,2,g:append(3,4))").contains(4.0));

        assertEquals(xe.evaluateList("g:union(1,2,g:union(3,4))").size(), 4);
        assertTrue(xe.evaluateList("g:union(1,2,g:union(3,4))").contains(1.0));
        assertTrue(xe.evaluateList("g:union(1,2,g:union(3,4))").contains(2.0));
        assertTrue(xe.evaluateList("g:union(1,2,g:union(3,4))").contains(3.0));
        assertTrue(xe.evaluateList("g:union(1,2,g:union(3,4))").contains(4.0));

        assertEquals(xe.evaluateList("g:union(1,2,g:union(3,4,3,4),1,2,g:union(1,2),g:append(3,4,4,4))").size(), 4);
        assertTrue(xe.evaluateList("g:union(1,2,g:union(3,4,3,4),1,2,g:union(1,2),g:append(3,4,4,4))").contains(1.0));
        assertTrue(xe.evaluateList("g:union(1,2,g:union(3,4,3,4),1,2,g:union(1,2),g:append(3,4,4,4))").contains(2.0));
        assertTrue(xe.evaluateList("g:union(1,2,g:union(3,4,3,4),1,2,g:union(1,2),g:append(3,4,4,4))").contains(3.0));
        assertTrue(xe.evaluateList("g:union(1,2,g:union(3,4,3,4),1,2,g:union(1,2),g:append(3,4,4,4))").contains(4.0));

    }
}

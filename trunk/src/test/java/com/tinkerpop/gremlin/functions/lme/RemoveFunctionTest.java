package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RemoveFunctionTest extends TestCase {

    public void testRemoveFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:remove(g:append(1,2,3,4),3,4)").size(), 2);
        assertTrue(xe.evaluateList("g:remove(g:append(1,2,3,4),3,4)").contains(1.0));
        assertTrue(xe.evaluateList("g:remove(g:append(1,2,3,4),3,4)").contains(2.0));
        assertEquals(xe.evaluateList("g:remove(g:append(1,1,1,1,1,2,3,4),g:append(1,2))").size(), 2);
        assertTrue(xe.evaluateList("g:remove(g:append(1,2,2,2,2,3,4),g:append(1,2))").contains(3.0));
        assertTrue(xe.evaluateList("g:remove(g:append(1,2,3,3,3,3,4),g:append(1,2,3))").contains(4.0));
        assertEquals(xe.evaluateList("g:remove(g:append(1,1,1,1,4),4)").size(), 4);
        assertEquals(xe.evaluateList("g:remove(1,2)").size(), 1);
        assertEquals(xe.evaluateList("g:remove(1,1)").size(), 0);

        assertEquals(xe.evaluateList("g:remove('marko','marko')").size(), 0);
        assertEquals(xe.evaluateList("g:remove('marko',1)").size(), 1);
    }


}

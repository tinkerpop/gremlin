package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RemoveFunctionTest extends BaseTest {

    public void testRemoveFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluate("g:remove(g:append(1,2,3,4),3,4)").size(), 2);
        assertTrue(xe.evaluate("g:remove(g:append(1,2,3,4),3,4)").contains(1.0));
        assertTrue(xe.evaluate("g:remove(g:append(1,2,3,4),3,4)").contains(2.0));
        assertEquals(xe.evaluate("g:remove(g:append(1,1,1,1,1,2,3,4),g:append(1,2))").size(), 2);
        assertTrue(xe.evaluate("g:remove(g:append(1,2,2,2,2,3,4),g:append(1,2))").contains(3.0));
        assertTrue(xe.evaluate("g:remove(g:append(1,2,3,3,3,3,4),g:append(1,2,3))").contains(4.0));
        assertEquals(xe.evaluate("g:remove(g:append(1,1,1,1,4),4)").size(), 4);
        assertEquals(xe.evaluate("g:remove(1,2)").size(), 1);
        assertEquals(xe.evaluate("g:remove(1,1)").size(), 0);

        assertEquals(xe.evaluate("g:remove('marko','marko')").size(), 0);
        assertEquals(xe.evaluate("g:remove('marko',1)").size(), 1);
    }


}

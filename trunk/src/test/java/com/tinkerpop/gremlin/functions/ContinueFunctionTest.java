package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ContinueFunctionTest extends BaseTest {

    public void testContinueFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertTrue((Boolean)xe.evaluate("g:cont(true())").get(0));
        assertFalse((Boolean)xe.evaluate("g:cont(false())").get(0));

        assertEquals(xe.evaluate("(1+2)[g:cont(true())]").get(0), 3.0);
        assertEquals(xe.evaluate("(1+2)[g:cont(false())]").size(), 0);

    }
}

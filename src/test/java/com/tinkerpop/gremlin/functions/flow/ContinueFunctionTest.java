package com.tinkerpop.gremlin.functions.flow;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ContinueFunctionTest extends TestCase {

    public void testContinueFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertTrue((Boolean) xe.evaluateList("g:cont(true())").get(0));
        assertFalse((Boolean) xe.evaluateList("g:cont(false())").get(0));

        assertEquals(xe.evaluateList("(1+2)[g:cont(true())]").get(0), 3.0);
        assertEquals(xe.evaluateList("(1+2)[g:cont(false())]").size(), 0);

    }
}

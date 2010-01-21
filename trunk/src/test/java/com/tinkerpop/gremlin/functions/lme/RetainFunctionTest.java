package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RetainFunctionTest extends TestCase {

    public void testRetainFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:append(1,2,3,4)[g:retain(1,2)]").size(), 2);
        assertTrue(xe.evaluateList("g:append(1,2,3,4)[g:retain(1,2)]").contains(1.0));
        assertTrue(xe.evaluateList("g:append(1,2,3,4)[g:retain(1,2)]").contains(2.0));
        assertEquals(xe.evaluateList("g:append(1,2,3,4)[g:retain(1)]").size(), 1);
        assertTrue(xe.evaluateList("g:append(1,2,3,4)[g:retain(1)]").contains(1.0));
        assertEquals(xe.evaluateList("g:append(1,2,3,4)[g:retain(1, g:append(1,2,3))]").size(), 3);
        assertTrue(xe.evaluateList("g:append(1,2,3,4)[g:retain(1, g:append(1,2,3))]").contains(1.0));
        assertTrue(xe.evaluateList("g:append(1,2,3,4)[g:retain(1, g:append(1,2,3))]").contains(2.0));
        assertTrue(xe.evaluateList("g:append(1,2,3,4)[g:retain(1, g:append(1,2,3))]").contains(3.0));

    }
}

package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class HaltFunctionTest extends TestCase {

    public void testHaltFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertFalse((Boolean) xe.evaluateList("g:halt(true())").get(0));
        assertTrue((Boolean) xe.evaluateList("g:halt(false())").get(0));

        assertEquals(xe.evaluateList("(1+2)[g:halt(false())]").get(0), 3.0);
        assertEquals(xe.evaluateList("(1+2)[g:halt(true())]").size(), 0);

    }
}

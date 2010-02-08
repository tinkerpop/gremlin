package com.tinkerpop.gremlin.functions.g.flow;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
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

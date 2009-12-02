package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class HaltFunctionTest extends BaseTest {

        public void testHaltFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertFalse((Boolean)xe.evaluate("g:halt(true())").get(0));
        assertTrue((Boolean)xe.evaluate("g:halt(false())").get(0));

        assertEquals(xe.evaluate("(1+2)[g:halt(false())]").get(0), 3.0);
        assertEquals(xe.evaluate("(1+2)[g:halt(true())]").size(), 0);

    }
}

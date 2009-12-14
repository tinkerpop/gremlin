package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RandomRealFunctionTest extends TestCase {

    public void testRandomNaturalFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluate("g:rand-real()").size(), 1);
        assertEquals(xe.evaluate("g:type(g:rand-real())").get(0), "number");
        assertTrue(((Double)xe.evaluate("g:rand-real()").get(0)) < 1.00001d);
        try {
            xe.evaluate("g:rand-real('marko')");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
        try {
            xe.evaluate("g:rand-real(1000)");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }

    }

}

package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RandomRealFunctionTest extends TestCase {

    public void testRandomNaturalFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:rand-real()").size(), 1);
        assertEquals(xe.evaluateList("g:type(g:rand-real())").get(0), "number");
        assertTrue(((Double) xe.evaluateList("g:rand-real()").get(0)) < 1.00001d);
        try {
            xe.evaluateList("g:rand-real('marko')");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
        try {
            xe.evaluateList("g:rand-real(1000)");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }

    }

}

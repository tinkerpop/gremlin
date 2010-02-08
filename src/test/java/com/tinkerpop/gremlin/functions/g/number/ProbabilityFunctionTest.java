package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ProbabilityFunctionTest extends TestCase {

    public void testProbabilityFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        for (int i = 0; i < 100; i++) {
            assertEquals(xe.evaluateList("g:prob(g:append(1,2,3,4,5))").size(), 1);
            assertEquals(xe.evaluateList("g:prob(g:append(1,0,0,0,0))").get(0), 1);
            assertEquals(xe.evaluateList("g:prob(g:append(0,1,0,0,0))").get(0), 2);
            assertEquals(xe.evaluateList("g:prob(g:append(0,0,1,0,0))").get(0), 3);
            assertEquals(xe.evaluateList("g:prob(g:append(0,0,0,1,0))").get(0), 4);
            assertEquals(xe.evaluateList("g:prob(g:append(0,0,0,0,1))").get(0), 5);

            Object value = xe.evaluateList("g:prob(g:append(1,1,0,0,0,0))").get(0);
            assertTrue(value.equals(1) || value.equals(2));
        }
    }
}

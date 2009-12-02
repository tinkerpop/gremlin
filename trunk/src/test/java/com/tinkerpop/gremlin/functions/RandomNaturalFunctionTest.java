package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RandomNaturalFunctionTest extends BaseTest {

    public void testRandomNaturalFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluate("g:rand_nat()").size(), 1);
        assertEquals(xe.evaluate("g:type(g:rand_nat())").get(0), "number");
        assertEquals(xe.evaluate("g:type(g:rand_nat(1000))").get(0), "number");
        try {
            xe.evaluate("g:rand_nat('marko')");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }

    }

}

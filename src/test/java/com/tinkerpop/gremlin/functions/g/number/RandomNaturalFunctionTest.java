package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RandomNaturalFunctionTest extends TestCase {

    public void testRandomNaturalFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:list(1,2,3)[g:rand-nat()]").size(), 1);
        assertEquals(xe.evaluateList("g:type(1[g:rand-nat()])").get(0), "number");
        assertEquals(xe.evaluateList("g:type(g:rand-nat(1000))").get(0), "number");
        try {
            xe.evaluateList("g:rand-nat('marko')");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
        for (int i = 0; i < 1000; i++) {
            assertTrue((Double) (xe.evaluateList("g:list(1,2,3)[g:rand-nat()]").get(0)) > 0.0);
        }

    }

}

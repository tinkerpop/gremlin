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
        assertEquals(xe.evaluate("g:append(1,2,3)[g:rand-nat()]").size(), 1);
        assertEquals(xe.evaluate("g:type(1[g:rand-nat()])").get(0), "number");
        assertEquals(xe.evaluate("g:type(g:rand-nat(1000))").get(0), "number");
        try {
            xe.evaluate("g:rand-nat('marko')");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
        for(int i=0; i<1000; i++) {
            assertTrue((Double)(xe.evaluate("g:append(1,2,3)[g:rand-nat()]").get(0)) > 0.0);
        }

    }

}

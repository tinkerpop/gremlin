package com.tinkerpop.gremlin.functions;

import junit.framework.TestCase;
import com.tinkerpop.gremlin.XPathEvaluator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class CountContextFunctionTest extends TestCase {

    public void testCountContextFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:ctx-count()").get(0), 0.0);
        xe.evaluateList("g:append(1,2,3,4)[g:assign('$x', g:ctx-count())]");
        assertEquals(xe.getVariable("$x"), 4.0);

    }
}

package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ListFunctionTest extends TestCase {

    public void testListFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:list()").size(), 0);
        assertEquals(xe.evaluateList("g:list(1)").get(0), 1.0);
        assertEquals(xe.evaluateList("g:list(g:append(1,2,3,4))").get(1), 2.0);
        assertEquals(xe.evaluateList("g:list(g:append(1,2,3,4))").get(2), 3.0);
        assertEquals(xe.evaluateList("g:list(g:append(1,2,3,4))").get(3), 4.0);

        try {
            xe.evaluateList("g:list(g:append(1,2),3,4)");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }


    }

}

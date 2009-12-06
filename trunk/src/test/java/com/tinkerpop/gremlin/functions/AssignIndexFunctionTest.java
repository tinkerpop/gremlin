package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AssignIndexFunctionTest extends BaseTest {

    public void testAssignFunctionList() {
        XPathEvaluator xe = new XPathEvaluator();
        List list = new ArrayList();
        list.add(1.0);
        list.add(2.0);
        xe.setVariable("$i", list);
        assertEquals(xe.evaluate("(1+2)[g:assign-index($i,1)]").get(0), 3.0);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), 3.0);
        assertEquals(list.get(1), 2.0);
        try {
            xe.evaluate("(10+1)[g:assign-index($i,3)]");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
        try {
            xe.evaluate("g:map()[g:assign-index($i,2)]");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }
}

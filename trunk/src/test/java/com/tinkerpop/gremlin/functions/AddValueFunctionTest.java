package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AddValueFunctionTest extends TestCase {

    public void testIncrementValueFunctionMap() {
        XPathEvaluator xe = new XPathEvaluator();
        Map map = new HashMap();
        map.put("marko", 1.0);
        map.put("jen", 2.0);
        xe.setVariable("$i", map);
        assertEquals(xe.evaluateList("$i/@marko").get(0), 1.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("'marko'[g:add-value($i,10)]").get(0), "marko");
        assertEquals(xe.evaluateList("$i/@marko").get(0), 11.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("'peter'[g:add-value($i, 1000)]").get(0), "peter");
        assertEquals(xe.evaluateList("$i/@peter").get(0), 1000.0);
        try {
            xe.evaluateList("'marko'[g:add-value($i,'10')]").get(0);
            assertTrue(false);
        } catch(EvaluationException e) {
            assertTrue(true);
        }
    }

     public void testIncrementValueFunctionList() {
        XPathEvaluator xe = new XPathEvaluator();
        List list = new ArrayList();
        list.add(1.0);
        list.add(2.0);
        xe.setVariable("$i", list);
        assertEquals(xe.evaluateList("$i[1]").get(0), 1.0);
        assertEquals(xe.evaluateList("$i[2]").get(0), 2.0);
        assertEquals(xe.evaluateList("1[g:add-value($i,10)]").get(0), 1.0);
        assertEquals(xe.evaluateList("$i[1]").get(0), 11.0);
        assertEquals(xe.evaluateList("$i[2]").get(0), 2.0);
        xe.evaluateList("g:append(1,2)[g:add-value($i,1000)]");
        assertEquals(xe.evaluateList("$i[1]").get(0), 1011.0);
        assertEquals(xe.evaluateList("$i[2]").get(0), 1002.0);
        try {
            xe.evaluateList("'marko'[g:assign-value($i,1+2)]");
            assertFalse(true);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }


}

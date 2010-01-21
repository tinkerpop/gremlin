package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GetFunctionTest extends TestCase {

    public void testGetFunctionMap() {
        XPathEvaluator xe = new XPathEvaluator();
        Map map = new HashMap();
        map.put("marko", 1);
        map.put("josh", 2);
        map.put(3.0, "peter");
        xe.setVariable("$m", map);
        assertEquals(xe.evaluateList("g:get($m,'marko')").size(), 1);
        assertTrue(xe.evaluateList("g:get($m,'marko')").contains(1));
        assertTrue(xe.evaluateList("g:get($m, 3)").contains("peter"));
        assertTrue(xe.evaluateList("g:get($m, 3.0)").contains("peter"));
        assertTrue(xe.evaluateList("g:get($m, 3.00000000)").contains("peter"));
    }

    public void testGetFunctionList() {
        XPathEvaluator xe = new XPathEvaluator();
        List list = new ArrayList();
        list.add("marko");
        list.add("josh");
        list.add(3.0);
        xe.setVariable("$l", list);
        assertEquals(xe.evaluateList("g:get($l,1)").size(), 1);
        assertTrue(xe.evaluateList("g:get($l,1)").contains("marko"));
        assertTrue(xe.evaluateList("g:get($l,3)").contains(3.0));
        assertTrue(xe.evaluateList("g:get($l,3.0)").contains(3.0));
        assertTrue(xe.evaluateList("g:get($l,2)").contains("josh"));
        try {
            xe.evaluateList("g:get($l,4)");
            assertTrue(false);
        } catch(EvaluationException e) {
            assertTrue(true);
        }
         try {
            xe.evaluateList("g:get($l,0)");
            assertTrue(false);
        } catch(EvaluationException e) {
            assertTrue(true);
        }
    }
}

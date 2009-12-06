package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class UnassignFunctionTest extends BaseTest {

    public void testUnassignFunctionVariable() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluate("g:assign('$i',2)").get(0), 2.0);
        assertEquals(xe.getVariable("$i"), 2.0);
        assertEquals(xe.evaluate("g:unassign('$i')").get(0), 2.0);
        assertNull(xe.getVariable("$i"));
        assertEquals(xe.evaluate("g:unassign('$non-existant-variable')").size(), 0);
    }

    public void testUnassignFunctionMap() {
        XPathEvaluator xe = new XPathEvaluator();
        Map map = new HashMap();
        map.put("marko", 1.0);
        map.put("jen", 2.0);
        xe.setVariable("$i", map);
        assertEquals(xe.evaluate("$i/@marko").get(0), 1.0);
        assertEquals(xe.evaluate("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluate("'marko'[g:unassign($i)]").get(0), "marko");
        assertFalse(map.containsKey("marko"));
        assertTrue(map.size() == 1);
    }

    public void testUnassignFunctionList() {
        XPathEvaluator xe = new XPathEvaluator();
        List list = new ArrayList();
        list.add(1.0);
        list.add(2.0);
        xe.setVariable("$i", list);
        assertEquals(xe.evaluate("$i[1]").get(0), 1.0);
        assertEquals(xe.evaluate("$i[2]").get(0), 2.0);
        assertEquals(list.get(0), 1.0);
        assertEquals(xe.evaluate("1[g:unassign($i)]").get(0), 1.0);
        assertEquals(list.get(0), 2.0);
        assertEquals(xe.evaluate("1[g:unassign($i)]").get(0), 1.0);
        assertEquals(list.size(), 0);
        try {
            xe.evaluate("1[g:unassign($i)]");
            assertFalse(true);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }

}

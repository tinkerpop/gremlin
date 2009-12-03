package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AssignFunctionTest extends BaseTest {

    public void testAssignFunctionVariable() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluate("g:assign('$i',2)").size(), 1);
        assertEquals(xe.evaluate("g:assign('$i',2)").get(0), 2.0);
        assertEquals(xe.getVariable("i"), 2.0);
        assertEquals(xe.evaluate("g:assign('$i', g:append(1,2,3))").size(), 3);
        assertEquals(xe.getVariable("i").getClass(), ArrayList.class);

        assertEquals(xe.evaluate("(1+2)[g:assign('$i')]").size(), 1);
        assertEquals(xe.evaluate("(1+2)[g:assign('$i')]").get(0), 3.0);
        assertEquals(xe.evaluate("$i[g:assign('$j')]").get(0), 3.0);
        // TODO LIST OR OBJECT?
        //assertEquals(xe.getVariable("i"), 3.0);
        //assertEquals(xe.getVariable("j"), 3.0);
    }

    /*public void testAssignFunctionList() {
        XPathEvaluator xe = new XPathEvaluator();
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        xe.setVariable("$i", list);
        assertEquals(xe.evaluate("g:assign($i,1,1000.0)").get(0), 1000.0);
        assertEquals(xe.evaluate("g:assign($i,2,2000.0)").get(0), 2000.0);
        assertEquals(xe.evaluate("$i[1]").get(0), 1000.0);
        assertEquals(xe.evaluate("$i[2]").get(0), 2000.0);
        try {
            xe.evaluate("g:assign($i,3,3000.0)");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
        assertEquals(xe.evaluate("(1+2)[g:assign($i,1)]").get(0), 3.0);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), 3.0);
        assertEquals(list.get(1), 2000.0);
        try {
            xe.evaluate("g:assign($i,2,$i)");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }

    public void testAssignFunctionMap() {
        XPathEvaluator xe = new XPathEvaluator();
        Map map = new HashMap();
        map.put("marko", 1);
        map.put("jen", 2);
        xe.setVariable("$i", map);
        assertEquals(xe.evaluate("g:assign($i,'peter',3)").get(0), 3.0);
        assertEquals(xe.evaluate("g:assign($i,'marko','jen')").get(0), "jen");
        assertEquals(xe.evaluate("$i/@marko").get(0), "jen");
        assertEquals(xe.evaluate("$i/@peter").get(0), 3.0);
        assertEquals(xe.evaluate("(1+2)[g:assign($i,'marko')]").get(0), 3.0);
        assertEquals(xe.evaluate("$i/@marko").get(0), 3.0);
    }*/
}

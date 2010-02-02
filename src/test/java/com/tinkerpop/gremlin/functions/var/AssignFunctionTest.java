package com.tinkerpop.gremlin.functions.var;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AssignFunctionTest extends TestCase {

    public void testAssignFunctionVariable() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:assign('$i',2)").size(), 1);
        assertEquals(xe.evaluateList("g:assign('$i',2)").get(0), 2.0);
        assertEquals(xe.getVariables().getVariable("i"), 2.0);
        assertEquals(xe.evaluateList("g:assign('$i', g:append(1,2,3))").size(), 3);
        assertEquals(xe.getVariables().getVariable("i").getClass(), ArrayList.class);

        assertEquals(xe.evaluateList("(1+2)[g:assign('$i')]").size(), 1);
        assertEquals(xe.evaluateList("(1+2)[g:assign('$i')]").get(0), 3.0);
        assertEquals(xe.evaluateList("$i[g:assign('$j')]").get(0), 3.0);
        // TODO LIST OR OBJECT?
        //assertEquals(xe.getVariable("i"), 3.0);
        //assertEquals(xe.getVariable("j"), 3.0);
    }

    public void testAssignFunctionList() {
        XPathEvaluator xe = new XPathEvaluator();
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        xe.getVariables().declareVariable("$i", list);
        assertEquals(xe.evaluateList("g:assign($i,1,1000.0)").get(0), 1000.0);
        assertEquals(xe.evaluateList("g:assign($i,2,2000.0)").get(0), 2000.0);
        assertEquals(xe.evaluateList("$i[1]").get(0), 1000.0);
        assertEquals(xe.evaluateList("$i[2]").get(0), 2000.0);
        try {
            xe.evaluateList("g:assign($i,3,3000.0)");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
        try {
            xe.evaluateList("g:assign($i,2,$i)");
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
        xe.getVariables().declareVariable("$i", map);
        assertEquals(xe.evaluateList("g:assign($i,'peter',3)").get(0), 3.0);
        assertEquals(xe.evaluateList("g:assign($i,'marko','jen')").get(0), "jen");
        assertEquals(xe.evaluateList("$i/@marko").get(0), "jen");
        assertEquals(xe.evaluateList("$i/@peter").get(0), 3.0);
    }

    public void testAssignKeyFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        Map map = new HashMap();
        map.put("marko", 1.0);
        map.put("jen", 2.0);
        xe.getVariables().declareVariable("$i", map);
        assertEquals(xe.evaluateList("$i/@marko").get(0), 1.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("(1+2)[g:p(g:assign($i,'marko', .))]").get(0), 3.0);
        assertEquals(xe.evaluateList("$i/@marko").get(0), 3.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("(1000)[g:p(g:assign($i,'peter', .))]").get(0), 1000.0);
        assertEquals(xe.evaluateList("$i/@peter").get(0), 1000.0);
    }

    public void testAssignIndexFunctionList() {
        XPathEvaluator xe = new XPathEvaluator();
        List list = new ArrayList();
        list.add(1.0);
        list.add(2.0);
        xe.getVariables().declareVariable("$i", list);
        assertEquals(xe.evaluateList("(1+2)[g:p(g:assign($i,1,.))]").get(0), 3.0);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), 3.0);
        assertEquals(list.get(1), 2.0);
        try {
            xe.evaluateList("(10+1)[g:assign($i,3,.)]");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
        try {
            xe.evaluateList("g:map()[g:assign($i,2,.)]");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }

    public void testAssignValueFunctionMap() {
        XPathEvaluator xe = new XPathEvaluator();
        Map map = new HashMap();
        map.put("marko", 1.0);
        map.put("jen", 2.0);
        xe.getVariables().declareVariable("$i", map);
        assertEquals(xe.evaluateList("$i/@marko").get(0), 1.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("'marko'[g:p(g:assign($i, ., (1+2)))]").get(0), "marko");
        assertEquals(xe.evaluateList("$i/@marko").get(0), 3.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("'peter'[g:p(g:assign($i, ., 1000))]").get(0), "peter");
        assertEquals(xe.evaluateList("$i/@peter").get(0), 1000.0);

        xe.evaluateList("g:append('marko','jen','peter')[g:p(g:assign($i,.,2000))]");
        assertEquals(xe.evaluateList("$i/@marko").get(0), 2000.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2000.0);
        assertEquals(xe.evaluateList("$i/@peter").get(0), 2000.0);
        try {
            xe.evaluateList("g:map()[g:assign($i,.,3000)]");
            assertFalse(true);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }

    public void testAssignValueFunctionList() {
        XPathEvaluator xe = new XPathEvaluator();
        List list = new ArrayList();
        list.add(1.0);
        list.add(2.0);
        xe.getVariables().declareVariable("$i", list);
        assertEquals(xe.evaluateList("$i[1]").get(0), 1.0);
        assertEquals(xe.evaluateList("$i[2]").get(0), 2.0);
        assertEquals(xe.evaluateList("1[g:p(g:assign($i, .,(1+2)))]").get(0), 1.0);
        assertEquals(xe.evaluateList("$i[1]").get(0), 3.0);
        assertEquals(xe.evaluateList("$i[2]").get(0), 2.0);
        xe.evaluateList("g:append(1,2)[g:p(g:assign($i,.,1000))]");
        assertEquals(xe.evaluateList("$i[1]").get(0), 1000.0);
        assertEquals(xe.evaluateList("$i[2]").get(0), 1000.0);
        try {
            xe.evaluateList("g:map()[g:assign($i,.,1+2)]");
            assertFalse(true);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }
}

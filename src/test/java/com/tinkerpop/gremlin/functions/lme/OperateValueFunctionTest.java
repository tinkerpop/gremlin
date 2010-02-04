package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.models.ggm.Vertex;
import com.tinkerpop.gremlin.models.ggm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OperateValueFunctionTest extends TestCase {

    public void testOperateValueFunctionAddMap() {
        XPathEvaluator xe = new XPathEvaluator();
        Map map = new HashMap();
        map.put("marko", 1.0);
        map.put("jen", 2.0);
        xe.getVariables().declareVariable("$i", map);
        assertEquals(xe.evaluateList("$i/@marko").get(0), 1.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("'marko'[g:p(g:op-value('+',$i,.,10))]").get(0), "marko");
        assertEquals(xe.evaluateList("$i/@marko").get(0), 11.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("'peter'[g:p(g:op-value('+',$i, .,1000))]").get(0), "peter");
        assertEquals(xe.evaluateList("$i/@peter").get(0), 1000.0);
        try {
            xe.evaluateList("'marko'[g:add-value($i,'10')]").get(0);
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }

    public void testOperateValueFunctionAddList() {
        XPathEvaluator xe = new XPathEvaluator();
        List list = new ArrayList();
        list.add(1.0);
        list.add(2.0);
        xe.getVariables().declareVariable("$i", list);
        assertEquals(xe.evaluateList("$i[1]").get(0), 1.0);
        assertEquals(xe.evaluateList("$i[2]").get(0), 2.0);
        assertEquals(xe.evaluateList("1[g:p(g:op-value('+',$i,.,10))]").get(0), 1.0);
        assertEquals(xe.evaluateList("$i[1]").get(0), 11.0);
        assertEquals(xe.evaluateList("$i[2]").get(0), 2.0);
        xe.evaluateList("g:append(1,2)[g:p(g:op-value('+',$i,.,1000))]");
        assertEquals(xe.evaluateList("$i[1]").get(0), 1011.0);
        assertEquals(xe.evaluateList("$i[2]").get(0), 1002.0);
        try {
            xe.evaluateList("'marko'[g:assign($i,.,1+2)]");
            assertFalse(true);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }

    public void testOperateValueFunctionAddElement() {
        XPathEvaluator xe = new XPathEvaluator();
        Graph graph = new TinkerGraph();
        Vertex vertex = graph.addVertex("1");
        vertex.setProperty("marko", 1.0);
        vertex.setProperty("jen", 2.0);
        xe.getVariables().declareVariable("$i", vertex);
        assertEquals(xe.evaluateList("$i/@marko").get(0), 1.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("'marko'[g:p(g:op-value('+',$i,.,10))]").get(0), "marko");
        assertEquals(xe.evaluateList("$i/@marko").get(0), 11.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("'peter'[g:p(g:op-value('+',$i,.,1000))]").get(0), "peter");
        assertEquals(xe.evaluateList("$i/@peter").get(0), 1000.0);
        assertEquals(xe.evaluateList("$i[g:p(g:op-value('+',.,'test',1000))]").get(0), vertex);
        assertEquals(xe.evaluateList("$i/@test").get(0), 1000.0);
        try {
            xe.evaluateList("'marko'[g:op-value('+',$i,.,'10')]").get(0);
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }


}

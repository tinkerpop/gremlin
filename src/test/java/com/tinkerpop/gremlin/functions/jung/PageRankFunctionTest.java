package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.Tokens;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PageRankFunctionTest extends JungTest {

    public void testOnlyAlphaParameter() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        List results = xe.evaluateList("jung:pagerank()");
        assertEquals(results.size(), 1);
        assertTrue(results.get(0) instanceof Map);
        Map map = (Map) results.get(0);
        assertEquals(this.getHighestRankVertex(map).getId(), "3");
        assertTrue(this.getLowestRankVertex(map).getId().equals("6") || this.getLowestRankVertex(map).getId().equals("1"));

        results = xe.evaluateList("jung:pagerank(g:map('alpha',1.0))");
        assertEquals(results.size(), 1);
        assertTrue(results.get(0) instanceof Map);
        map = (Map) results.get(0);
        Set ranks = new HashSet();
        for (Vertex key : (Set<Vertex>) map.keySet()) {
            ranks.add(map.get(key));
        }
        assertEquals(ranks.size(), 1);
    }

    public void testOnlyLabelFilter() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        List results = xe.evaluateList("jung:pagerank(g:map('labels',g:list('knows')))");
        assertEquals(results.size(), 1);
        assertTrue(results.get(0) instanceof Map);
        Map map = (Map) results.get(0);
        assertTrue(this.getHighestRankVertex(map).getId().equals("2") || this.getHighestRankVertex(map).getId().equals("4"));
    }

    public void testOnlyLabelWeightFilter() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        List results = xe.evaluateList("jung:pagerank(g:map('weight-key','weight', 'normalize', true(),'labels',g:list('knows')))");
        assertEquals(results.size(), 1);
        assertTrue(results.get(0) instanceof Map);
        Map map = (Map) results.get(0);
        assertTrue(this.getHighestRankVertex(map).getId().equals("4"));
    }
}

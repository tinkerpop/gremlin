package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddEdgeFunctionTest extends BaseTest {

    public void testAddEdgeFunction() {
        Graph graph = new TinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        xe.getVariables().declareVariable("$v", graph.addVertex('1'));
        xe.getVariables().declareVariable("$u", graph.addVertex('2'));
        assertEquals(count(graph.getVertices()), 2);
        assertEquals(count(graph.getEdges()), 0);
        xe.evaluateList("g:add-e($v,'knows1',$u)");
        assertEquals(count(graph.getEdges()), 1);
        xe.evaluateList("g:add-e('42', $v,'knows2',$u)");
        assertEquals(count(graph.getEdges()), 2);
        xe.evaluateList("g:add-e($_g, $v,'knows3',$u)");
        assertEquals(count(graph.getEdges()), 3);
        xe.evaluateList("g:add-e($_g, '52', $v,'knows4',$u)");
        assertEquals(count(graph.getEdges()), 4);
        try {
            xe.evaluateList("g:add-e($_g, '52', $v,'knows4',$u,10)");
            assertTrue(false);

        } catch (EvaluationException e) {
            assertTrue(true);
        }

    }

    public void testAddEdgeFunctionWithMap() {
        Graph graph = new TinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        xe.getVariables().declareVariable("$v", graph.addVertex('1'));
        xe.getVariables().declareVariable("$u", graph.addVertex('2'));
        List result = xe.evaluateList("g:add-e(g:map('weight',1.0),$v,'knows1',$u)");
        assertEquals(result.size(), 1);
        assertTrue(result.get(0) instanceof Edge);
        Edge edge = (Edge) result.get(0);
        assertEquals(edge.getProperty("weight"), 1.0);
        assertEquals(edge.getLabel(), "knows1");
        assertEquals(edge.getPropertyKeys().size(), 1);

        result = xe.evaluateList("g:add-e($_g, g:map('weight',2.12),$v,'knows1',$u)");
        assertEquals(result.size(), 1);
        assertTrue(result.get(0) instanceof Edge);
        edge = (Edge) result.get(0);
        assertEquals(edge.getProperty("weight"), 2.12);
        assertEquals(edge.getLabel(), "knows1");
        assertEquals(edge.getPropertyKeys().size(), 1);
    }
}

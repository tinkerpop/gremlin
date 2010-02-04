package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.models.ggm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;

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
}

package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddEdgeFunctionTest extends BaseTest {

    public void testAddEdgeFunction() {
        Graph graph = new TinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable(Tokens.GRAPH_VARIABLE, graph);
        xe.setVariable("$v", graph.addVertex('1'));
        xe.setVariable("$u", graph.addVertex('2'));
        assertEquals(countIterator(graph.getVertices()), 2);
        assertEquals(countIterator(graph.getEdges()), 0);
        xe.evaluateList("g:add-e($v,'knows1',$u)");
        assertEquals(countIterator(graph.getEdges()), 1);
        xe.evaluateList("g:add-e('42', $v,'knows2',$u)");
        assertEquals(countIterator(graph.getEdges()), 2);
        xe.evaluateList("g:add-e($_g, $v,'knows3',$u)");
        assertEquals(countIterator(graph.getEdges()), 3);
        xe.evaluateList("g:add-e($_g, '52', $v,'knows4',$u)");
        assertEquals(countIterator(graph.getEdges()), 4);
        try {
            xe.evaluateList("g:add-e($_g, '52', $v,'knows4',$u,10)");
            assertTrue(false);

        } catch (EvaluationException e) {
            assertTrue(true);
        }

    }
}

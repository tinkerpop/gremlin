package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.Tokens;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RemoveVertexEdgeFunctionTest extends BaseTest {

    public void testRemoveVertexEdgeFunction() {
        Graph graph = new TinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable(Tokens.GRAPH_VARIABLE, graph);
        xe.setVariable("$v", graph.addVertex('1'));
        xe.setVariable("$u", graph.addVertex('2'));
        assertEquals(countIterator(graph.getVertices()), 2);
        assertEquals(countIterator(graph.getEdges()), 0);
        xe.setVariable("$e", graph.addEdge(null, graph.getVertex('1'), graph.getVertex('2'), "knows"));
        assertEquals(countIterator(graph.getVertices()), 2);
        assertEquals(countIterator(graph.getEdges()), 1);
        xe.evaluateList("g:remove-ve($e)");
        assertEquals(countIterator(graph.getVertices()), 2);
        assertEquals(countIterator(graph.getEdges()), 0);
        xe.evaluateList("g:remove-ve($_g, $v)");
        assertEquals(countIterator(graph.getVertices()), 1);
        assertEquals(countIterator(graph.getEdges()), 0);
        xe.evaluateList("g:remove-ve($u)");
        assertEquals(countIterator(graph.getVertices()), 0);
        assertEquals(countIterator(graph.getEdges()), 0);

    }


}

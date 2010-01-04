package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.Tokens;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AddVertexFunctionTest extends BaseTest {

    public void testAddVertexFunction() {
        Graph graph = new TinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable(Tokens.GRAPH_VARIABLE, graph);
        assertEquals(countIterator(graph.getVertices()), 0);
        xe.evaluateList("g:add-v()");
        assertEquals(countIterator(graph.getVertices()), 1);
        xe.evaluateList("g:add-v('11111')");
        assertEquals(countIterator(graph.getVertices()), 2);
        xe.evaluateList("g:add-v($_g)");
        assertEquals(countIterator(graph.getVertices()), 3);
        xe.evaluateList("g:add-v($_g, '22222')");
        assertEquals(countIterator(graph.getVertices()), 4);
    }
}

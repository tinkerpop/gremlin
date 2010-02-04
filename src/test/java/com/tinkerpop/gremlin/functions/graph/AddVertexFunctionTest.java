package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.models.ggm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.statements.Tokens;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddVertexFunctionTest extends BaseTest {

    public void testAddVertexFunction() {
        Graph graph = new TinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        assertEquals(count(graph.getVertices()), 0);
        xe.evaluateList("g:add-v()");
        assertEquals(count(graph.getVertices()), 1);
        xe.evaluateList("g:add-v('11111')");
        assertEquals(count(graph.getVertices()), 2);
        xe.evaluateList("g:add-v($_g)");
        assertEquals(count(graph.getVertices()), 3);
        xe.evaluateList("g:add-v($_g, '22222')");
        assertEquals(count(graph.getVertices()), 4);
    }
}

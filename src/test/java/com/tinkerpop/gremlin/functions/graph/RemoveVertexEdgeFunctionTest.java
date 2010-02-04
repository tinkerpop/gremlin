package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.models.ggm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.statements.Tokens;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RemoveVertexEdgeFunctionTest extends BaseTest {

    public void testRemoveVertexEdgeFunction() {
        Graph graph = new TinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        xe.getVariables().declareVariable("$v", graph.addVertex('1'));
        xe.getVariables().declareVariable("$u", graph.addVertex('2'));
        assertEquals(count(graph.getVertices()), 2);
        assertEquals(count(graph.getEdges()), 0);
        xe.getVariables().declareVariable("$e", graph.addEdge(null, graph.getVertex('1'), graph.getVertex('2'), "knows"));
        assertEquals(count(graph.getVertices()), 2);
        assertEquals(count(graph.getEdges()), 1);
        xe.evaluateList("g:remove-ve($e)");
        assertEquals(count(graph.getVertices()), 2);
        assertEquals(count(graph.getEdges()), 0);
        xe.evaluateList("g:remove-ve($_g, $v)");
        assertEquals(count(graph.getVertices()), 1);
        assertEquals(count(graph.getEdges()), 0);
        xe.evaluateList("g:remove-ve($u)");
        assertEquals(count(graph.getVertices()), 0);
        assertEquals(count(graph.getEdges()), 0);

    }


}

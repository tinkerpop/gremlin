package com.tinkerpop.gremlin.functions.graph;

import junit.framework.TestCase;
import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinEvaluator;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.Tokens;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ClearFunctionTest extends BaseTest {

    public void testClearFunction() {
        Graph graph = new TinkerGraph();
        graph.addVertex(null);
        graph.addVertex(null);
        graph.addVertex(null);
        assertEquals(countIterator(graph.getVertices()), 3);
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable(Tokens.GRAPH_VARIABLE, graph);
        xe.evaluateList("g:clear()");
        assertEquals(countIterator(graph.getVertices()), 0);
        graph.addVertex(null);
        graph.addVertex(null);
        graph.addVertex(null);
        assertEquals(countIterator(graph.getVertices()), 3);
        xe.evaluateList("g:clear($_g)");
        assertEquals(countIterator(graph.getVertices()), 0);

    }
}

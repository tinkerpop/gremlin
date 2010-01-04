package com.tinkerpop.gremlin.functions.graph;

import junit.framework.TestCase;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.Tokens;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ShutdownFunctionTest extends TestCase {

    public void testShutdownFunction() {
        Graph graph = new TinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable(Tokens.GRAPH_VARIABLE, graph);
        assertTrue((Boolean)xe.evaluateList("g:shutdown()").get(0));
        assertTrue((Boolean)xe.evaluateList("g:shutdown($_g)").get(0));
    }
}

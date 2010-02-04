package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.models.ggm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.statements.Tokens;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CloseFunctionTest extends TestCase {

    public void testShutdownFunction() {
        Graph graph = new TinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        assertTrue((Boolean) xe.evaluateList("g:close()").get(0));
        assertTrue((Boolean) xe.evaluateList("g:close($_g)").get(0));
    }
}

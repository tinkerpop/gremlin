package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;


/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoadFunctionTest extends BaseTest {

    public void testLoadFunction() {
        Graph graph = new TinkerGraph();
        assertEquals(count(graph.getVertices()), 0);
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable("$_g", graph);
        //TODO: where is this file in test cases ? xe.evaluateList("g:load('src/test/resources/com/tinkerpop/gremlin/model/parser/graph-example-1.xml')");
    }
}

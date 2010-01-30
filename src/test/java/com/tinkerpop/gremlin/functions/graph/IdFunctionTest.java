package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.Tokens;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IdFunctionTest extends TestCase {

    public void testIdFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        xe.setVariable("$g", graph);
        assertEquals(xe.evaluateList("g:id($g, '1')").size(), 1);
        assertEquals(xe.evaluateList("g:id($g, '1')").get(0), graph.getVertex("1"));
        assertEquals(xe.evaluateList("g:id($g, '2')").size(), 1);
        assertEquals(xe.evaluateList("g:id($g, '2')").get(0), graph.getVertex("2"));
        assertEquals(xe.evaluateList("g:id($g, '1000')").size(), 0);

    }

    public void testIdFunctionGraphVariable() {
        XPathEvaluator xe = new XPathEvaluator();
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        xe.setVariable(Tokens.GRAPH_VARIABLE, graph);
        assertEquals(xe.evaluateList("g:id('1')").size(), 1);
        assertEquals(xe.evaluateList("g:id('1')").get(0), graph.getVertex("1"));
        assertEquals(xe.evaluateList("g:id('2')").size(), 1);
        assertEquals(xe.evaluateList("g:id('2')").get(0), graph.getVertex("2"));
        assertEquals(xe.evaluateList("g:id('1000')").size(), 0);

    }
}

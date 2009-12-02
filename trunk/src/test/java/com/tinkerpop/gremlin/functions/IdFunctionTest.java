package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class IdFunctionTest extends BaseTest {

    public void testIdFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        Graph graph =  TinkerGraphFactory.createTinkerGraph();
        xe.setVariable("$g", graph);
        assertEquals(xe.evaluate("g:id($g, '1')").size(), 1);
        assertEquals(xe.evaluate("g:id($g, '1')").get(0), graph.getVertex("1"));
        assertEquals(xe.evaluate("g:id($g, '2')").size(), 1);
        assertEquals(xe.evaluate("g:id($g, '2')").get(0), graph.getVertex("2"));
        assertEquals(xe.evaluate("g:id($g, '1000')").size(), 0);

    }
}

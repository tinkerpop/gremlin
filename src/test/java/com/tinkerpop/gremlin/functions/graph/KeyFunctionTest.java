package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import junit.framework.TestCase;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class KeyFunctionTest extends TestCase {

    public void testKeyFunction() {

        XPathEvaluator xe = new XPathEvaluator();
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.addVertex("1");
        Vertex jen = graph.addVertex("2");
        marko.setProperty("name", "marko");
        jen.setProperty("name", "jen");
        marko.setProperty("location", "santa fe");
        jen.setProperty("location", "santa fe");
        marko.setProperty("zipcode", 87501);
        jen.setProperty("zipcode", "87501");

        xe.getVariables().declareVariable("$_g", graph);
        List results = xe.evaluateList("g:key('name','marko')");
        assertEquals(results.size(), 1);
        assertTrue(results.contains(marko));

        results = xe.evaluateList("g:key($_g, 'name','jen')");
        assertEquals(results.size(), 1);
        assertTrue(results.contains(jen));

        results = xe.evaluateList("g:key('location','los alamos')");
        assertEquals(results.size(), 0);

        results = xe.evaluateList("g:key($_g, 'location','santa fe')");
        assertEquals(results.size(), 2);
        assertTrue(results.contains(marko));
        assertTrue(results.contains(jen));

        results = xe.evaluateList("g:key('zipcode','87501')");
        assertEquals(results.size(), 1);
        assertTrue(results.contains(jen));

        /*TODO: number has decimal
        results = xe.evaluateList("g:key('zipcode', 87501)");
        assertEquals(results.size(), 1);
        assertTrue(results.contains(marko));
        */

        results = xe.evaluateList("g:key($_g, 'zipcode','8750112')");
        assertEquals(results.size(), 0);
    }
}

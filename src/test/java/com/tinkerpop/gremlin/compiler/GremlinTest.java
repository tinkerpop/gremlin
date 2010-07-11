package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinTest extends BaseTest {

    public void testBasicMathStatements() throws Exception {
        Object result = evaluateGremlinScriptPrimitive("1 + 2", true);
        assertEquals(result, 3);

        result = evaluateGremlinScriptPrimitive("1 div (2 * 2)", true);
        assertEquals(result.getClass(), Double.class);
        assertEquals(result, 0.25d);

        result = evaluateGremlinScriptPrimitive("(1l - 2) * 2.0d", true);
        assertEquals(result, -2.0d);

        result = evaluateGremlinScriptPrimitive("2 + (4l * 2.0d) - 7", true);
        assertEquals(result, 3.0d);
    }

    public void testBasicGraphStatements() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinEvaluator.declareVariable(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        GremlinEvaluator.declareVariable(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        List<Vertex> results = evaluateGremlinScriptIterable("./outE/inV", true);
        assertEquals(results.size(), 3);
        String name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(2).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));

        results = evaluateGremlinScriptIterable("./outE[@label='created' or @label='knows']/inV", true);
        assertEquals(results.size(), 3);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(2).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));

        results = evaluateGremlinScriptIterable("./outE[@label='created']/inV", true);
        assertEquals(results.size(), 1);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("lop"));

        results = evaluateGremlinScriptIterable("./outE[@label='knows']/inV", true);
        assertEquals(results.size(), 2);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("josh") || name.equals("vadas"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("josh") || name.equals("vadas"));

        results = evaluateGremlinScriptIterable("./inE", true);
        assertEquals(results.size(), 0);
    }

    public void testHistoryOnGraph() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinEvaluator.declareVariable(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        GremlinEvaluator.declareVariable(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        List<Vertex> results = evaluateGremlinScriptIterable("./outE/inV/../..", true);
        assertEquals(results.size(), 1);
        String name = (String) results.get(0).getProperty("name");
        assertEquals(name, "marko");

        results = evaluateGremlinScriptIterable("./outE/inV/../../..", true);
        assertNull(results);

        results = evaluateGremlinScriptIterable("./outE/inV/outE/inV/../..", true);
        assertEquals(results.size(), 1);
        name = (String) results.get(0).getProperty("name");
        assertEquals(name, "josh");

        results = evaluateGremlinScriptIterable("./outE/inV/outE/inV[@name='lop']/../..", true);
        assertEquals(results.size(), 1);
        name = (String) results.get(0).getProperty("name");
        assertEquals(name, "josh");

        results = evaluateGremlinScriptIterable("./outE/inV/outE/inV[@name='ripple']/../..", true);
        assertEquals(results.size(), 1);
        name = (String) results.get(0).getProperty("name");
        assertEquals(name, "josh");

        results = evaluateGremlinScriptIterable("./outE/inV/outE/inV[@name='ripple' or @name='lop' or @name='blah']/../../outE/inV", true);
        assertEquals(results.size(), 2);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("ripple") || name.equals("lop"));

    }

    public void testEmbeddedListMaps() throws Exception {
        Map results = (Map) evaluateGremlinScriptPrimitive("g:map(1,2,'k2',g:list(1,2,g:map('k1','v1','k2',g:list(1+2))))", true);
        assertEquals(results.get(1), 2);
        assertEquals(((List)(results.get("k2"))).get(0), 1);
        assertEquals(((List)(results.get("k2"))).get(1), 2);
        assertTrue(((List)(results.get("k2"))).get(2) instanceof Map);
        assertEquals(((Map)((List)(results.get("k2"))).get(2)).get("k1"), "v1");
        assertEquals(((List)((Map)((List)(results.get("k2"))).get(2)).get("k2")).get(0), 3);
        assertNull(((Map)((List)(results.get("k2"))).get(2)).get("k3"));

    }
}

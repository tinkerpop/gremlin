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

        String embedd = "g:map('k1','v1','k2',g:list(1,2,g:map('k11','v11','k22',g:list('a','b','c'))))";
        assertEquals(evaluateGremlinScriptIterable(embedd + "/@k1", true).get(0), "v1");
        assertEquals(((List)evaluateGremlinScriptIterable(embedd + "/@k2", true).get(0)).get(0), 1);
        assertEquals(((List)evaluateGremlinScriptIterable(embedd + "/@k2", true).get(0)).get(1), 2);
        assertEquals(evaluateGremlinScriptIterable(embedd + "/@k2[0][0]", true).get(0), 1);
        assertEquals(evaluateGremlinScriptIterable(embedd + "/@k2[0][1]", true).get(0), 2);
        assertEquals(((Map)evaluateGremlinScriptIterable(embedd + "/@k2[0][2]", true).get(0)).get("k11"), "v11");

        assertEquals(evaluateGremlinScriptIterable(embedd + "/@k2[0][2]/@k11", true).get(0), "v11");
        assertEquals(evaluateGremlinScriptIterable(embedd + "/@k2[0][2]/@k22[0][0]", true).get(0), "a");
        assertEquals(evaluateGremlinScriptIterable(embedd + "/@k2[0][2]/@k22[0][1]", true).get(0), "b");
        assertEquals(evaluateGremlinScriptIterable(embedd + "/@k2[0][2]/@k22[0][2]", true).get(0), "c");
    }

    public void testIdAndLabelProperties() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinEvaluator.declareVariable(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        GremlinEvaluator.declareVariable(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        List<Vertex> results = evaluateGremlinScriptIterable("./@id", true);
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), "1");

        results = evaluateGremlinScriptIterable("./outE/inV/@id", true);
        assertEquals(results.size(), 3);
        assertTrue(results.contains("2"));
        assertTrue(results.contains("3"));
        assertTrue(results.contains("4"));

        results = evaluateGremlinScriptIterable("./outE/@label", true);
        assertEquals(results.size(), 3);
        assertTrue(results.contains("created"));
        assertTrue(results.contains("knows"));
    }

    public void testVertexEdgeGraphProperties() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinEvaluator.declareVariable(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        GremlinEvaluator.declareVariable(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        List<Vertex> results = evaluateGremlinScriptIterable("$_g/V", true);
        assertEquals(results.size(), 6);
        assertTrue(results.contains(graph.getVertex("1")));
        assertTrue(results.contains(graph.getVertex("2")));
        assertTrue(results.contains(graph.getVertex("3")));
        assertTrue(results.contains(graph.getVertex("4")));
        assertTrue(results.contains(graph.getVertex("5")));
        assertTrue(results.contains(graph.getVertex("6")));


        results = evaluateGremlinScriptIterable("$_g/E/@id", true);
        assertEquals(results.size(), 6);
        assertTrue(results.contains("7"));
        assertTrue(results.contains("8"));
        assertTrue(results.contains("9"));
        assertTrue(results.contains("10"));
        assertTrue(results.contains("11"));
        assertTrue(results.contains("12"));


    }
}

package com.tinkerpop.gremlin;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptEngineTest extends BaseTest {

    public void testBasicMathStatements() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();

        Object result = evaluateGremlinScriptPrimitive("1 + 2", context, true);
        assertEquals(result, 3);

        result = evaluateGremlinScriptPrimitive("1 div (2 * 2)", context, true);
        assertEquals(result.getClass(), Double.class);
        assertEquals(result, 0.25d);

        result = evaluateGremlinScriptPrimitive("(1l - 2) * 2.0d", context, true);
        assertEquals(result, -2.0d);

        result = evaluateGremlinScriptPrimitive("2 + (4l * 2.0d) - 7", context, true);
        assertEquals(result, 3.0d);

        result = evaluateGremlinScriptPrimitive("-2 + 1", context, true);
        assertEquals(result, -1);

        // TODO: bad that substraction requires spacing.
        /*result = evaluateGremlinScriptPrimitive("1-2", context, true);
        assertEquals(result, -1);*/
    }

     public void testBasicTruthStatements() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();

        Object result = evaluateGremlinScriptPrimitive("true or false", context, true);
        assertTrue((Boolean) result);

        result = evaluateGremlinScriptPrimitive("true and false", context, true);
        assertFalse((Boolean) result);

        result = evaluateGremlinScriptPrimitive("true or (true and false)", context, true);
        assertTrue((Boolean) result);

        result = evaluateGremlinScriptPrimitive("true and (true or false)", context, true);
        assertTrue((Boolean) result);

        result = evaluateGremlinScriptPrimitive("false or (false and true) or (true and (false and true))", context, true);
        assertFalse((Boolean) result);
    }

    public void testGPathInExpression() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        assertEquals(evaluateGremlinScriptPrimitive("g:list(1,2,3)[1] + 10", context, true), 12);
        assertEquals(evaluateGremlinScriptPrimitive("g:map('marko',2)/@marko + 10", context, true), 12);
    }

    public void testBasicGraphStatements() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();

        GremlinScriptContext context = new GremlinScriptContext();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getVariableLibrary().declare(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        List<Vertex> results = evaluateGremlinScriptIterable("./outE/inV", context, true);
        assertEquals(results.size(), 3);
        String name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(2).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));

        results = evaluateGremlinScriptIterable("./outE[@label='created' or @label='knows']/inV", context, true);
        assertEquals(results.size(), 3);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(2).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));

        Vertex result = (Vertex) evaluateGremlinScriptPrimitive("./outE[@label='created']/inV", context, true);
        name = (String) result.getProperty("name");
        assertTrue(name.equals("lop"));

        results = evaluateGremlinScriptIterable("./outE[@label='knows']/inV", context, true);
        assertEquals(results.size(), 2);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("josh") || name.equals("vadas"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("josh") || name.equals("vadas"));

        results = evaluateGremlinScriptIterable("./outE[./@weight >= 0.5]/inV/././.", context, true);
        assertEquals(results.size(), 2);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh"));

        results = evaluateGremlinScriptIterable("./outE[./@weight >= $_/outE/@weight[0]]/inV", context, true);
        assertEquals(results.size(), 2);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh"));

        results = evaluateGremlinScriptIterable("./inE", context, true);
        assertNull(results);

        results = evaluateGremlinScriptIterable("./outE/inV[@blah != null]", context, true);
        assertNull(results);

        results = evaluateGremlinScriptIterable("./outE/inV[@blah = null]", context, true);
        assertEquals(results.size(), 3);
    }

    public void testHistoryOnGraph() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();

        GremlinScriptContext context = new GremlinScriptContext();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getVariableLibrary().declare(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        Vertex result = (Vertex) evaluateGremlinScriptPrimitive("./outE/inV/../..", context, true);
        String name = (String) result.getProperty("name");
        assertEquals(name, "marko");

        List<Vertex> results = evaluateGremlinScriptIterable("./outE/inV/../../..", context, true);
        assertNull(results);

        result = (Vertex) evaluateGremlinScriptPrimitive("./outE/inV/outE/inV/../..", context, true);
        name = (String) result.getProperty("name");
        assertEquals(name, "josh");

        result = (Vertex) evaluateGremlinScriptPrimitive("./outE/inV/outE/inV[@name='lop']/../..", context, true);
        name = (String) result.getProperty("name");
        assertEquals(name, "josh");

        result = (Vertex) evaluateGremlinScriptPrimitive("./outE/inV/outE/inV[@name='ripple']/../..", context, true);
        name = (String) result.getProperty("name");
        assertEquals(name, "josh");

        results = evaluateGremlinScriptIterable("./outE/inV/outE/inV[@name='ripple' or @name='lop' or @name='blah']/../../outE/inV", context, true);
        assertEquals(results.size(), 2);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("ripple") || name.equals("lop"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("ripple") || name.equals("lop"));
    }

    public void testEmbeddedFunctions() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        List<Integer> results = evaluateGremlinScriptIterable("g:list(1,2,3)[g:p(. > 1)]", context, true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(3));

    }

    public void testIdAndLabelProperties() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getVariableLibrary().declare(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        String result = (String) evaluateGremlinScriptPrimitive("./@id", context, true);
        assertEquals(result, "1");

        List<Vertex> results = evaluateGremlinScriptIterable("./outE/inV/@id", context, true);
        assertEquals(results.size(), 3);
        assertTrue(results.contains("2"));
        assertTrue(results.contains("3"));
        assertTrue(results.contains("4"));

        results = evaluateGremlinScriptIterable("./outE/@label", context, true);
        assertEquals(results.size(), 3);
        assertTrue(results.contains("created"));
        assertTrue(results.contains("knows"));
    }

    public void testVertexEdgeGraphProperties() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();

        GremlinScriptContext context = new GremlinScriptContext();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getVariableLibrary().declare(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        List<Element> results = evaluateGremlinScriptIterable("$_g/V", context, true);
        assertEquals(results.size(), 6);
        assertTrue(results.contains(graph.getVertex("1")));
        assertTrue(results.contains(graph.getVertex("2")));
        assertTrue(results.contains(graph.getVertex("3")));
        assertTrue(results.contains(graph.getVertex("4")));
        assertTrue(results.contains(graph.getVertex("5")));
        assertTrue(results.contains(graph.getVertex("6")));

        results = evaluateGremlinScriptIterable("$_g/V/@id", context, true);
        assertEquals(results.size(), 6);
        assertTrue(results.contains("1"));
        assertTrue(results.contains("2"));
        assertTrue(results.contains("3"));
        assertTrue(results.contains("4"));
        assertTrue(results.contains("5"));
        assertTrue(results.contains("6"));

        results = evaluateGremlinScriptIterable("$_g/E", context, true);
        assertEquals(results.size(), 6);
        assertTrue(results.contains(graph.getEdge("7")));
        assertTrue(results.contains(graph.getEdge("8")));
        assertTrue(results.contains(graph.getEdge("9")));
        assertTrue(results.contains(graph.getEdge("10")));
        assertTrue(results.contains(graph.getEdge("11")));
        assertTrue(results.contains(graph.getEdge("12")));


        results = evaluateGremlinScriptIterable("$_g/E/@id", context, true);
        assertEquals(results.size(), 6);
        assertTrue(results.contains("7"));
        assertTrue(results.contains("8"));
        assertTrue(results.contains("9"));
        assertTrue(results.contains("10"));
        assertTrue(results.contains("11"));
        assertTrue(results.contains("12"));

    }

    public void testGPathInExpressionGraph() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();

        GremlinScriptContext context = new GremlinScriptContext();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getVariableLibrary().declare(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));
        assertEquals(count(evaluateGremlinScriptIterable("./outE[./@label = 'knows']", context, true)), 2);
        assertEquals(evaluateGremlinScriptPrimitive("./outE[./inV/@name = 'vadas']/inV/@name", context, true), "vadas");
        assertEquals(evaluateGremlinScriptPrimitive("./outE[./inV[@name = 'vadas']/@name = 'vadas']/inV/@name", context, true), "vadas");
        assertEquals(evaluateGremlinScriptPrimitive(".[g:count(./outE/inV/@name) = 3l]/@name", context, true), "marko");
        assertEquals(evaluateGremlinScriptPrimitive(".[./outE/inV/@age >= 27]/@name", context, true), "marko");
    }
}

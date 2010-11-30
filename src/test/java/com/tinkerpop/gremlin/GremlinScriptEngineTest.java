package com.tinkerpop.gremlin;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;

import javax.script.*;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptEngineTest extends BaseTest {

    public void testScriptEngineManagerRegistry() {
        ScriptEngineManager manager = new ScriptEngineManager();
        assertNotNull(manager.getEngineByName("gremlin"));
        assertEquals(manager.getEngineByName("gremlin").getClass(), GremlinScriptEngine.class);
    }


    public void testBasicEmbeddedEngine() throws Exception {
        ScriptEngine engine = new GremlinScriptEngineFactory().getScriptEngine();
        assertEquals(((List) engine.eval("1+2")).get(0), 3);
        assertEquals(((List) engine.eval("$_g := tg:open()")).get(0).getClass(), TinkerGraph.class);
        engine.eval("$a := g:add-v(0)");
        engine.eval("$b := g:add-v(1)");
        engine.eval("$c := g:add-v(2)");
        engine.eval("g:add-e($a,'knows',$b)");
        engine.eval("g:add-e($a,'knows',$c)");
        engine.eval("$_ := $a");
        assertEquals(asList(((Iterable) ((List) engine.eval("./outE/inV/@id")).get(0))).get(0), "2");
        assertEquals(asList(((Iterable) ((List) engine.eval("./outE/inV/@id")).get(0))).get(1), "1");

    }

    public void testEmbeddedEngineBindings() throws Exception {
        ScriptEngine engine = new GremlinScriptEngineFactory().getScriptEngine();
        assertNull(engine.getBindings(ScriptContext.ENGINE_SCOPE).put("$name", "marko"));
        assertEquals(engine.getBindings(ScriptContext.ENGINE_SCOPE).put("$name", "pavel"), "marko");
        assertEquals(engine.getBindings(ScriptContext.ENGINE_SCOPE).get("$name"), "pavel");
        assertEquals(((List) engine.eval("$name")).get(0), "pavel");
        engine.put("$test1", "marko");
        assertEquals(engine.get("$test1"), engine.getBindings(ScriptContext.ENGINE_SCOPE).get("$test1"));
    }

    public void testEmbeddedEngineBindingsGraph() throws Exception {
        ScriptEngine engine = new GremlinScriptEngineFactory().getScriptEngine();
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        assertNull(engine.getBindings(ScriptContext.ENGINE_SCOPE).put("$_g", graph));
        assertNull(engine.getBindings(ScriptContext.ENGINE_SCOPE).put("$_", graph.getVertex(1)));
        assertNull(engine.getBindings(ScriptContext.ENGINE_SCOPE).put("$name", "josh"));
        assertEquals(engine.getBindings(ScriptContext.ENGINE_SCOPE).get("$name"), "josh");
        List results = (List) engine.eval("./outE/inV[@name=$name]");
        assertEquals(results.get(0), graph.getVertex(4));
        results = (List) engine.eval("./outE/inV[@id=g:string(4)]");
        assertEquals(results.get(0), graph.getVertex(4));
        results = (List) engine.eval("./outE[@label=g:string('knows') or @label=g:string(g:string('created'))]/inV[@id='4' and @name=$name]");
        assertEquals(results.get(0), graph.getVertex(4));
    }

    public void testGlobalAndEngineScoping() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        manager.registerEngineName("gremlin", new GremlinScriptEngineFactory());
        SimpleBindings globalBindings = new SimpleBindings();
        globalBindings.put("$name", "global");
        manager.setBindings(globalBindings);

        ScriptEngine engine = manager.getEngineByName("gremlin");
        engine.put("$name", "engine");
        assertEquals(engine.getBindings(ScriptContext.GLOBAL_SCOPE).get("$name"), "global");
        assertEquals(((List) (engine.eval("$name", manager.getBindings()))).get(0), "global");
        assertEquals(((List) (engine.eval("g:concat($name,'-test')", manager.getBindings()))).get(0), "global-test");
        assertEquals(((List) (engine.eval("$name"))).get(0), "engine");

        assertEquals(((List) engine.eval("$name := 'redefined global'", engine.getBindings(ScriptContext.GLOBAL_SCOPE))).get(0), "redefined global");
        assertEquals(manager.getBindings().get("$name"), "redefined global");
        assertEquals(((List) (engine.eval("g:concat($name,'-test')", manager.getBindings()))).get(0), "redefined global-test");
        assertEquals(((List) (engine.eval("$name"))).get(0), "engine");
        assertEquals(((List) (engine.eval("$name", engine.getContext()))).get(0), "engine");

    }

    public void testInvocable() throws Exception {
        Invocable engine = new GremlinScriptEngine();
        assertEquals(engine.invokeFunction("g:power", 2, 3), 8.0d);
        try {
            engine.invokeFunction("g:fake-method", 2, 3);
            assertFalse(true);
        } catch (NoSuchMethodException e) {
            assertTrue(true);
        }
    }


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

        result = evaluateGremlinScriptPrimitive("-2 + 1", true);
        assertEquals(result, -1);

        // TODO: bad that substraction requires spacing.
        /*result = evaluateGremlinScriptPrimitive("1-2", true);
        assertEquals(result, -1);*/
    }

    public void testBasicTruthStatements() throws Exception {

        Object result = evaluateGremlinScriptPrimitive("true or false", true);
        assertTrue((Boolean) result);

        result = evaluateGremlinScriptPrimitive("true and false", true);
        assertFalse((Boolean) result);

        result = evaluateGremlinScriptPrimitive("false or false", true);
        assertFalse((Boolean) result);

        result = evaluateGremlinScriptPrimitive("false and false", true);
        assertFalse((Boolean) result);

        result = evaluateGremlinScriptPrimitive("true or (true and false)", true);
        assertTrue((Boolean) result);

        result = evaluateGremlinScriptPrimitive("true and (true or false)", true);
        assertTrue((Boolean) result);

        result = evaluateGremlinScriptPrimitive("false or (false and true) or (true and (false and true))", true);
        assertFalse((Boolean) result);
    }

    public void testSideEffects() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();

        evaluateGremlinScriptIterable("g:list(1,2,3)[g:p(g:assign($x,.))]", context, true);
        assertEquals(context.getBindings(ScriptContext.ENGINE_SCOPE).get("$x"), 3);

        evaluateGremlinScriptIterable("g:list(1,2,3)[g:p(g:assign($y,.))][true]", context, true);
        assertEquals(context.getBindings(ScriptContext.ENGINE_SCOPE).get("$y"), 3);

        evaluateGremlinScriptIterable("g:list(1,2,3)[g:p(g:assign($z,.))][false]", context, true);
        assertEquals(context.getBindings(ScriptContext.ENGINE_SCOPE).get("$z"), 3);
    }

    public void testGPathInExpression() throws Exception {
        assertEquals(evaluateGremlinScriptPrimitive("g:list(1,2,3)[1] + 10", true), 12);
        assertEquals(evaluateGremlinScriptPrimitive("g:map('marko',2)/@marko + 10", true), 12);
    }

    public void testEmbeddedFunctions() throws Exception {
        List<Integer> results = evaluateGremlinScriptIterable("g:list(1,2,3)[g:p(. > 1)]", true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), new Integer(1));
        assertEquals(results.get(1), new Integer(2));
        assertEquals(results.get(2), new Integer(3));

    }

    public void testAssignmentOperation() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();

        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        assertEquals(evaluateGremlinScriptPrimitive("$x := 1", context, true), 1);
        assertEquals(evaluateGremlinScriptPrimitive("$x", context, true), 1);
        assertEquals(evaluateGremlinScriptPrimitive("$x := $x + 1", context, true), 2);
        assertEquals(evaluateGremlinScriptPrimitive("$x", context, true), 2);
        assertEquals(evaluateGremlinScriptPrimitive("./@name := 'name'", context, true), "name");
        assertEquals(evaluateGremlinScriptPrimitive("./@name", context, true), "name");
        assertEquals(evaluateGremlinScriptPrimitive("./outE/inV[0]/@name := 'vname'", context, true), "vname");
        assertEquals(evaluateGremlinScriptPrimitive("./outE/inV[0]/@name", context, true), "vname");
        assertEquals(evaluateGremlinScriptIterable("./outE/inV/@age := 20", context, true), Arrays.asList(20, null, 32));
        assertEquals(evaluateGremlinScriptIterable("./outE/inV/@age := g:list(21, 30, 31)", context, true), Arrays.asList(21, 30, 31));

        evaluateGremlinScriptPrimitive("$m := g:map()", context, false);
        assertEquals(evaluateGremlinScriptPrimitive("$m/@a := 5", context, true), 5);
        assertEquals(evaluateGremlinScriptPrimitive("$m/@a", context, true), 5);
        assertEquals(evaluateGremlinScriptPrimitive("$m/@b := (($m/@a + 6) - 4) div 2.67", context, true), 2.6217227715275007);
        assertEquals(evaluateGremlinScriptPrimitive("$m/@b", context, true), 2.6217227715275007);

        Map m = (Map) evaluateGremlinScriptPrimitive("$m", context, false);
        assertEquals(m.get("a"), 5);
        assertEquals(m.get("b"), 2.6217227715275007);

        evaluateGremlinScriptPrimitive("$m := g:map('marko',0,'pavel',1,'others',g:list('comm',g:map('peter',2,'josh',3)))", context, false);
        m = (Map) evaluateGremlinScriptPrimitive("$m", context, false);
        assertEquals(m.get("marko"), 0);
        assertEquals(evaluateGremlinScriptPrimitive("$m/@marko := 5", context, true), 5);
        assertEquals(m.get("marko"), 5);
        assertEquals(evaluateGremlinScriptPrimitive("$m/@others[1]/@peter", context, true), 2);
        assertEquals(((Map) ((List) (m.get("others"))).get(1)).get("peter"), 2);
        assertEquals(evaluateGremlinScriptPrimitive("$m/@others[1]/@peter := 10", context, true), 10);
        assertEquals(((Map) ((List) (m.get("others"))).get(1)).get("peter"), 10);
    }

    public void testEmbeddedAssignment() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        List results = evaluateGremlinScriptIterable("g:list(1,2,3)[g:p($x := g:list(.))]", context, true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);
        assertEquals(((List) context.getBindings(ScriptContext.ENGINE_SCOPE).get("$x")).get(0), 3);

        results = evaluateGremlinScriptIterable("g:list(1,2,3)[g:p($x := g:list(g:string(.)))]", context, true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);
        assertEquals(((List) context.getBindings(ScriptContext.ENGINE_SCOPE).get("$x")).get(0), "3");


        context.getBindings(ScriptContext.ENGINE_SCOPE).put("$m", new HashMap());
        results = evaluateGremlinScriptIterable("g:list(1,2,3)[g:p($m/@marko := g:list(g:string(g:double(.))))]", context, true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);
        assertEquals(((List) ((Map) context.getBindings(ScriptContext.ENGINE_SCOPE).get("$m")).get("marko")).get(0), "3.0");
    }

    public void testRanges() throws Exception {
        List results = evaluateGremlinScriptIterable("1..4", true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);

        assertEquals(evaluateGremlinScriptPrimitive("g:type(1..4)", true), "set");

        results = evaluateGremlinScriptIterable("g:union(1..3,4..6)", true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 4);
        assertEquals(results.get(3), 5);

        results = evaluateGremlinScriptIterable("g:list(1,2,3,4,5)/.[g:list(1,2,3,4,5)[1] = 2]/./.[true]", true);
        assertEquals(results.size(), 5);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);
        assertEquals(results.get(3), 4);
        assertEquals(results.get(4), 5);
    }

    public void testNumberFunctions() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        context.getFunctionLibrary().loadFunctions("com.tinkerpop.gremlin.functions.PlayFunctions");
        assertNotNull(context.getFunctionLibrary().getFunction("play", "play-number"));
        assertEquals(evaluateGremlinScriptPrimitive("g:list(1,2,3,4)[play:play-number(2)]", context, true), 3);

        // only one number should be returned
        assertNotNull(evaluateGremlinScriptPrimitive("g:list(1,2,3,4)[g:rand-nat(4)]", context, true));

        List results = evaluateGremlinScriptIterable("g:list(1,2,3,4,5,6)[g:set(0,3,4)]", context, true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 4);
        assertEquals(results.get(2), 5);

        results = evaluateGremlinScriptIterable("g:list(1,2,3,4,5,6)[g:flatten(0..3,4..6)]", context, true);
        assertEquals(results.size(), 5);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);
        assertEquals(results.get(3), 5);
        assertEquals(results.get(4), 6);

        results = evaluateGremlinScriptIterable("g:list(1,2,3,4,5,6)[g:union(0..3,4..1000)]", context, true);
        assertEquals(results.size(), 5);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);
        assertEquals(results.get(3), 5);
        assertEquals(results.get(4), 6);

        results = evaluateGremlinScriptIterable("g:list(1,2,3)[g:list(1,2)[0..2]]", context, true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), 2);
        assertEquals(results.get(1), 3);

        results = evaluateGremlinScriptIterable("g:list(1,2,3,4,5,6)[g:set(0,3,4)[0..2]]", context, true);
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 4);

    }

    // GRAPH RELATED TEST CASES

    public void testBasicGraphStatements() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();

        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

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
        assertEquals(results.size(), 0);

        results = evaluateGremlinScriptIterable("./outE/inV[@blah != null]", context, true);
        assertEquals(results.size(), 0);

        results = evaluateGremlinScriptIterable("./outE/inV[@blah = null]", context, true);
        assertEquals(results.size(), 3);
    }

    public void testHistoryOnGraph() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();

        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        assertEquals(((Vertex) evaluateGremlinScriptPrimitive("./outE/inV/../..", context, true)).getProperty("name"), "marko");
        assertNull(evaluateGremlinScriptIterable("./outE/inV/../../..", context, true));
        assertEquals(((Vertex) evaluateGremlinScriptPrimitive("./outE/inV/outE/inV/../..", context, true)).getProperty("name"), "josh");
        assertEquals(((Vertex) evaluateGremlinScriptPrimitive("./outE/inV/outE/inV[@name='lop']/../..", context, true)).getProperty("name"), "josh");
        assertEquals(((Vertex) evaluateGremlinScriptPrimitive("./outE/inV/outE/inV[@name='ripple']/../..", context, true)).getProperty("name"), "josh");
        assertEquals(((Edge) evaluateGremlinScriptPrimitive("./outE/inV[@name='lop']/..", context, true)).getId(), "9");

        List<Vertex> results = evaluateGremlinScriptIterable("./outE/inV/outE/inV[@name='ripple' or @name='lop' or @name='blah']/../../outE/inV", context, true);
        assertEquals(results.size(), 2);
        String name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("ripple") || name.equals("lop"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("ripple") || name.equals("lop"));
    }

    public void testIdAndLabelProperties() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

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
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

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
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        assertEquals(count(evaluateGremlinScriptIterable("./outE[./@label = 'knows']", context, true)), 2);
        assertEquals(evaluateGremlinScriptPrimitive("./outE[./inV/@name = 'vadas']/inV/@name", context, true), "vadas");
        assertEquals(evaluateGremlinScriptPrimitive("./outE[./inV[@name = 'vadas']/@name = 'vadas']/inV/@name", context, true), "vadas");
        assertEquals(evaluateGremlinScriptPrimitive(".[g:count(./outE/inV/@name) = 3l]/@name", context, true), "marko");
        assertEquals(evaluateGremlinScriptPrimitive(".[./outE/inV/@age >= 27]/@name", context, true), "marko");
    }

    public void testStepDeclarationInGraph() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();

        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        assertTrue((Boolean) evaluateGremlinScriptPrimitive("step simple\n./outE/inV\nend", context, true));
        assertEquals(evaluateGremlinScriptPrimitive("'simple'", context, true), "simple");
        assertEquals(count((Iterable) evaluateGremlinScriptPrimitive("'simple'[1]", context, true)), 0);

        List<Vertex> results = evaluateGremlinScriptIterable("./simple", context, true);
        assertEquals(results.size(), 3);
        String name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(2).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
    }

    public void testStepDeclaration() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        evaluateGremlinScriptPrimitive("step makelist\ng:list(1,2,3)\nend", context, true);
        List<Object> results = evaluateGremlinScriptIterable("./makelist", context, true);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);

        evaluateGremlinScriptPrimitive("step addone\n. + 1\nend", context, true);
        results = evaluateGremlinScriptIterable("./makelist/addone", context, true);
        assertEquals(results.get(0), 2);
        assertEquals(results.get(1), 3);
        assertEquals(results.get(2), 4);
    }

    public void testExpressionsInGPath() throws Exception {
        assertTrue((Boolean) evaluateGremlinScriptPrimitive("true[0]", true));
        assertFalse((Boolean) evaluateGremlinScriptPrimitive("false[0]", true));
        assertTrue((Boolean) evaluateGremlinScriptPrimitive("(true or false)[0]", true));
        assertFalse((Boolean) evaluateGremlinScriptPrimitive("(true and false)[0]", true));
        assertFalse((Boolean) evaluateGremlinScriptPrimitive("(true and (false and true))[0]", true));

        assertEquals(evaluateGremlinScriptPrimitive("(1 + 2)[0]", true), 3);
        assertEquals(evaluateGremlinScriptPrimitive("(1 + (2 - 3))[0]", true), 0);

        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Integer>(1));

        assertEquals(evaluateGremlinScriptPrimitive("(. + (2 - 3))[0]", context, true), 0);
        assertEquals(evaluateGremlinScriptPrimitive("((.) + (2 div 1))[0]", context, true), 3.0d);
        assertEquals(evaluateGremlinScriptPrimitive("((. + 2.5) div 0.5)[0]", context, true), 7.0d);
        assertEquals(evaluateGremlinScriptPrimitive("((. + 2.5) div 0.5)[. = 7.0d]", context, true), 7.0d);
        assertEquals(evaluateGremlinScriptPrimitive("((. + 2.5) div 0.5)[g:p($x := . + 1)]", context, true), 7.0d);
        assertEquals(evaluateGremlinScriptPrimitive("$x", context, true), 8.0d);
        assertEquals(evaluateGremlinScriptPrimitive("((. + 2.5) div 0.5)[. = (5.0d + (1 div 0.5)[0])[0]]", context, true), 7.0d);
    }

    public void testPropertyNamesWithSpaces() throws Exception {
        final GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put("$m", new Atom<Map>(new HashMap()));

        assertEquals(evaluateGremlinScriptPrimitive("$m/@'name w/ space' := 1", context, true), 1);
        assertEquals(evaluateGremlinScriptPrimitive("$m/@'name w/ space' + 3", context, true), 4);
        assertEquals(evaluateGremlinScriptPrimitive("$m/@'another name' := $m/@\"name w/ space\" + 3", context, true), 4);
        assertEquals(evaluateGremlinScriptPrimitive("$m/@\"another name\"", context, true), 4);

        Map mResults = (Map) evaluateGremlinScriptPrimitive("$m", context, true);
        assertEquals(mResults.size(), 2);
        assertEquals(mResults.get("name w/ space"), 1);
        assertEquals(mResults.get("another name"), 4);

        Graph graph = TinkerGraphFactory.createTinkerGraph();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        List<String> results = evaluateGremlinScriptIterable("./outE/inV/@'name'", context, true);
        assertEquals(results.size(), 3);
        String name = results.get(0);
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = results.get(1);
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = results.get(2);
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
    }

    public void testRecursiveFunctionDefinitionAndCall() throws Exception {
        final GremlinScriptContext context = new GremlinScriptContext();

        assertTrue((Boolean) evaluateGremlinScriptPrimitive("func ex:hello($x)\n" + "  if $x = 10 or $x > 10\n" + "    $x\n" + "  else\n" + "    ex:hello($x + 1)\n" + "  end\n" + "end", context, false));

        assertEquals(evaluateGremlinScriptPrimitive("ex:hello(12)", context, true), 12);
        assertEquals(evaluateGremlinScriptPrimitive("ex:hello(6)", context, true), 10);
        assertEquals(evaluateGremlinScriptPrimitive("ex:hello(20)", context, true), 20);
        assertEquals(evaluateGremlinScriptPrimitive("ex:hello(9)", context, true), 10);
    }

    public void testThatStepDoesNotOverrideGlobalVariables() throws Exception {
        final GremlinScriptContext context = new GremlinScriptContext();
        assertEquals(evaluateGremlinScriptPrimitive("$x := 2", context, true), 2);
        assertTrue((Boolean) evaluateGremlinScriptPrimitive("step test-global-x-step\n$x := 7\nend", context, true));
        assertEquals(evaluateGremlinScriptPrimitive("$x", context, true), 2);
        assertEquals(evaluateGremlinScriptPrimitive("test-global-x-step", context, true), 7);
        assertEquals(evaluateGremlinScriptPrimitive("$x", context, true), 2);
    }

    public void testScatterGatherSteps() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();

        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        List results = evaluateGremlinScriptIterable("./outE/inV", context, true);
        assertEquals(results.size(), 3);
        results = evaluateGremlinScriptIterable("./outE/inV/gather/gather", context, true);
        assertEquals(results.size(), 1);
        results = evaluateGremlinScriptIterable("./outE/inV/gather/scatter", context, true);
        assertEquals(results.size(), 3);
    }

    public void testNativeStepWithGPathInside() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        evaluateGremlinScriptPrimitive("$m := g:map()", context, false);
        assertTrue((Boolean) evaluateGremlinScriptPrimitive("step assign-m\ng:assign($m, ./inV/@name, ./@weight)\n.\nend", context, true));
        assertEquals(evaluateGremlinScriptPrimitive("g:count($m)", context, false), 1l);
        evaluateGremlinScriptIterable("./outE/assign-m", context, true);
        Map m = (Map) evaluateGremlinScriptPrimitive("$m", context, false);
        assertEquals(m.get("lop"), 0.4f);
        assertEquals(m.get("josh"), 1.0f);
        assertEquals(m.get("vadas"), 0.5f);
        assertEquals(evaluateGremlinScriptPrimitive(".", context, false), graph.getVertex(1));
    }

    public void testCommentedSpacedScript() throws Exception {
        String script = "# marko\n" + "\n" + "# marko\n" + "\n" + "1+2\n" + "\n" + "";
        GremlinScriptEngine engine = new GremlinScriptEngine();
        assertEquals(((Iterable) engine.eval(new StringReader(script))).iterator().next(), 3);
    }

    public void testFunctionReturn() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();

        /**
         * func test:f($x)
         *   if $x > 5
         *     return $x + 5
         *   end
         *
         *   return $x - 1
         * end
         */
        assertTrue((Boolean) evaluateGremlinScriptPrimitive("func test:f($x)\nif $x > 5\nreturn $x + 5\nend\nreturn $x - 1\nend", context, false));
        assertEquals(evaluateGremlinScriptPrimitive("test:f(3)", context, true), 2);
        assertEquals(evaluateGremlinScriptPrimitive("test:f(6)", context, true), 11);

/**
 * func test:f($x)
 *   if $x > 5
 *     return null
 *   end
 *
 *   return $x - 1
 * end
 */
        assertTrue((Boolean) evaluateGremlinScriptPrimitive("func test:f($x)\nif $x > 5\nreturn null\nend\nreturn $x - 1\nend", context, false));
        assertEquals(evaluateGremlinScriptPrimitive("test:f(5)", context, true), 4);
        assertNull(evaluateGremlinScriptPrimitive("test:f(6)", context, true));
    }

    public void testPathEquality() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        Object results = evaluateGremlinScriptPrimitive("./outE/inV = ./outE/inV", context, true);
        assertTrue((Boolean) results);
        results = evaluateGremlinScriptPrimitive("./inE = ./inE", context, true);
        assertTrue((Boolean) results);
        results = evaluateGremlinScriptPrimitive("./outE[true]/inV[0..100]/.[true] = ./outE/inV", context, true);
        assertTrue((Boolean) results);
    }
}

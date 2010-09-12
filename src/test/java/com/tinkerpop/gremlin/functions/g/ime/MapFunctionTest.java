package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MapFunctionTest extends BaseTest {

    public void testEmptyMap() {
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Map> function = new MapFunction();
        this.stopWatch();
        Atom<Map> atom = function.compute(new ArrayList<Operation>(), context);
        printPerformance(function.getFunctionName() + " function", 0, "arguments", this.stopWatch());
        assertTrue(atom.isMap());
        assertEquals(atom.getValue().size(), 0);
    }

    public void testArgumentSizeErrorMap() {
        GremlinScriptContext context = new GremlinScriptContext();

        Function function = new MapFunction();
        try {
            this.stopWatch();
            function.compute(createUnaryArgs("key1"), context);
            printPerformance(function.getFunctionName() + " function", 1, "bad argument", this.stopWatch());
            assertFalse(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testTwoEntryMap() {
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Map> function = new MapFunction();
        this.stopWatch();
        Atom<Map> atom = function.compute(createUnaryArgs("key1", "value1", "key2", 2), context);
        printPerformance(function.getFunctionName() + " function", 2, "key argument", this.stopWatch());
        assertTrue(atom.isMap());
        assertEquals(atom.getValue().size(), 2);
        assertEquals(atom.getValue().get("key1"), "value1");
        assertEquals(atom.getValue().get("key2"), 2);

    }

    public void testElementMap() {
        GremlinScriptContext context = new GremlinScriptContext();

        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Function<Map> function = new MapFunction();
        this.stopWatch();
        Atom<Map> atom = function.compute(createUnaryArgs(graph.getVertex("1")), context);
        printPerformance(function.getFunctionName() + " function", 1, "vertex argument", this.stopWatch());
        assertTrue(atom.isMap());
        Map<Atom, Atom> map = atom.getValue();
        assertEquals(map.get("name"), "marko");
        assertEquals(map.get("age"), 29);
    }

    public void testMapMap() {
        GremlinScriptContext context = new GremlinScriptContext();

        Map map = new HashMap();
        map.put("marko", 1);
        map.put("peter", 2);
        Function<Map> function = new MapFunction();
        this.stopWatch();
        Atom<Map> atom = function.compute(createUnaryArgs(map), context);
        printPerformance(function.getFunctionName() + " function", 1, "vertex argument", this.stopWatch());
        assertTrue(atom.isMap());
        Map<Atom, Atom> map2 = atom.getValue();
        assertEquals(map2.get("marko"), 1);
        assertEquals(map2.get("peter"), 2);
        assertEquals(map.size(), map2.size());
    }

    public void testListMap() {
        GremlinScriptContext context = new GremlinScriptContext();

        List list = Arrays.asList("marko", 1, "peter", 2);
        Function<Map> function = new MapFunction();
        this.stopWatch();
        Atom<Map> atom = function.compute(createUnaryArgs(list), context);
        printPerformance(function.getFunctionName() + " function", 1, "vertex argument", this.stopWatch());
        assertTrue(atom.isMap());
        Map<Atom, Atom> map = atom.getValue();
        assertEquals(map.get("marko"), 1);
        assertEquals(map.get("peter"), 2);
        assertEquals(map.size(), list.size() / 2);
    }

    public void testListSizeErrorMap() {
        GremlinScriptContext context = new GremlinScriptContext();

        List list = Arrays.asList("marko", 1, "peter", 2, "pavel");
        Function<Map> function = new MapFunction();
        this.stopWatch();
        try {
            function.compute(createUnaryArgs(list), context);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testMapInline() throws Exception {

        assertEquals(evaluateGremlinScriptPrimitive("g:map('k1','v1','k2','v2')/@k1", true), "v1");
        assertEquals(evaluateGremlinScriptPrimitive("g:map('k1','v1','k2','v2')/@k2", true), "v2");
        assertNull(evaluateGremlinScriptPrimitive("g:map('k1','v1','k2','v2')/@k3", true));

        Map results = (Map) evaluateGremlinScriptPrimitive("g:map(1,2,'k2',g:list(1,2,g:map('k1','v1','k2',g:list(1+2))))", true);

        assertEquals(results.get(1), 2);
        assertEquals(((List) (results.get("k2"))).get(0), 1);
        assertEquals(((List) (results.get("k2"))).get(1), 2);
        assertTrue(((List) (results.get("k2"))).get(2) instanceof Map);
        assertEquals(((Map) ((List) (results.get("k2"))).get(2)).get("k1"), "v1");
        assertEquals(((List) ((Map) ((List) (results.get("k2"))).get(2)).get("k2")).get(0), 3);
        assertNull(((Map) ((List) (results.get("k2"))).get(2)).get("k3"));

        String embedd = "g:map('k1','v1','k2',g:list(1,2,g:map('k11','v11','k22',g:list('a','b','c'))))";
        assertEquals(evaluateGremlinScriptPrimitive(embedd + "/@k1", true), "v1");
        assertEquals(evaluateGremlinScriptPrimitive(embedd + "/@k2[0]", true), 1);
        assertEquals(evaluateGremlinScriptPrimitive(embedd + "/@k2[1]", true), 2);
        assertEquals(((Map) evaluateGremlinScriptPrimitive(embedd + "/@k2[2]", true)).get("k11"), "v11");

        assertEquals(evaluateGremlinScriptPrimitive(embedd + "/@k2[2]/@k11", true), "v11");
        assertEquals(evaluateGremlinScriptPrimitive(embedd + "/@k2[2]/@k22[0]", true), "a");
        assertEquals(evaluateGremlinScriptPrimitive(embedd + "/@k2[2]/@k22[1]", true), "b");
        assertEquals(evaluateGremlinScriptPrimitive(embedd + "/@k2[2]/@k22[2]", true), "c");

    }
}

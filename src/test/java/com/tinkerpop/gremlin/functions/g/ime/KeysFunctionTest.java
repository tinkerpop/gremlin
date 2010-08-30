package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class KeysFunctionTest extends BaseTest {

    public void testMapKeys() {
        GremlinScriptContext context = new GremlinScriptContext();

        Map map = new HashMap();
        map.put("marko", 30.0d);
        map.put("jen", 26.0d);
        Function<Iterable> function = new KeysFunction();
        this.stopWatch();
        Atom<Iterable> atom = function.compute(createUnaryArgs(map), context);
        printPerformance(function.getFunctionName() + " function", 2, "key map", this.stopWatch());
        List<Atom> list = asList(atom.getValue());
        assertEquals(list.size(), 2);
        assertTrue(list.contains("marko"));
        assertTrue(list.contains("jen"));
    }

    public void testElementKeys() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Iterable> function = new KeysFunction();
        this.stopWatch();
        Atom<Iterable> atom = function.compute(createUnaryArgs(graph.getVertex("1")), context);
        printPerformance(function.getFunctionName() + " function", 2, "key vertex", this.stopWatch());
        List<Atom> list = asList(atom.getValue());
        assertEquals(list.size(), 2);
        assertTrue(list.contains("age"));
        assertTrue(list.contains("name"));
    }

    public void testKeysInline() throws Exception {
        List results = evaluateGremlinScriptIterable("g:keys(g:map('marko',1,\"pavel\",2,'peter',3))", true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), "marko");
        assertEquals(results.get(1), "peter");
        assertEquals(results.get(2), "pavel");

        assertEquals(evaluateGremlinScriptPrimitive("g:get(g:map('marko',1,\"pavel\",2,'peter',3), g:keys(g:map('marko',1,\"pavel\",2,'peter',3))[0])", true), 1);

    }

}

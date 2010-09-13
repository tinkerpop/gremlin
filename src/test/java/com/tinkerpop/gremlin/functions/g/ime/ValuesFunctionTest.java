package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.Function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ValuesFunctionTest extends BaseTest {

    public void testMapValues() {
        Map map = new HashMap();
        map.put("marko", 30.0d);
        map.put("jen", 26.0d);
        Function<Iterable> function = new ValuesFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        Atom<Iterable> atom = function.compute(createUnaryArgs(map), context);
        printPerformance(function.getFunctionName() + " function", 2, "value map", this.stopWatch());
        List list = asList(atom.getValue());
        assertEquals(list.size(), 2);
        assertTrue(list.contains(30.0d));
        assertTrue(list.contains(26.0d));
    }

    public void testElementValues() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Function<Iterable> function = new ValuesFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        Atom<Iterable> atom = function.compute(createUnaryArgs(graph.getVertex("1")), context);
        printPerformance(function.getFunctionName() + " function", 2, "value vertex", this.stopWatch());
        List<Atom> list = asList(atom.getValue());
        assertEquals(list.size(), 2);
        assertTrue(list.contains(29));
        assertTrue(list.contains("marko"));
    }

    public void testValuesInline() throws Exception {
        List results = evaluateGremlinScriptIterable("g:values(g:map('marko',1,\"pavel\",2,'peter',3))", true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 3);
        assertEquals(results.get(2), 2);


    }
}

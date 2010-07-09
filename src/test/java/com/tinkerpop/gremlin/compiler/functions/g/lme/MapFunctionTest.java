package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.Gremlin;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MapFunctionTest extends BaseTest {

    public void testEmptyMap() {
        Function<Map<Atom, Atom>> function = new MapFunction();
        this.stopWatch();
        Atom<Map<Atom, Atom>> atom = function.compute(new ArrayList<Operation>());
        printPerformance(function.getFunctionName() + " function", 0, "arguments", this.stopWatch());
        assertTrue(atom.isMap());
        assertEquals(atom.getValue().size(), 0);
    }

    public void testArgumentSizeErrorMap() {
        Function function = new MapFunction();
        try {
            this.stopWatch();
            function.compute(createUnaryArgs("key1"));
            printPerformance(function.getFunctionName() + " function", 1, "bad argument", this.stopWatch());
            assertFalse(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testTwoEntryMap() {
        Function<Map<Atom, Atom>> function = new MapFunction();
        this.stopWatch();
        Atom<Map<Atom, Atom>> atom = function.compute(createUnaryArgs("key1", "value1", "key2", 2));
        printPerformance(function.getFunctionName() + " function", 2, "key argument", this.stopWatch());
        assertTrue(atom.isMap());
        assertEquals(atom.getValue().size(), 2);
        assertEquals(atom.getValue().get(new Atom<String>("key1")).getValue(), "value1");
        assertEquals(atom.getValue().get(new Atom<String>("key2")).getValue(), 2);

    }

    public void testElementMap() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Function<Map<Atom, Atom>> function = new MapFunction();
        this.stopWatch();
        Atom<Map<Atom, Atom>> atom = function.compute(createUnaryArgs(graph.getVertex("1")));
        printPerformance(function.getFunctionName() + " function", 1, "vertex argument", this.stopWatch());
        assertTrue(atom.isMap());
        Map<Atom, Atom> map = atom.getValue();
        assertEquals(map.get(new Atom<String>("name")), new Atom<String>("marko"));
        assertEquals(map.get(new Atom<String>("age")), new Atom<Integer>(29));
    }

    public void testMapGremlin() throws Exception {

        this.stopWatch();
        String script = "g:map('k1','v1','k2','v2')/@k1";
        Iterable itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        List<Vertex> results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), new Atom<String>("v1"));

        this.stopWatch();
        script = "g:map('k1','v1','k2','v2')/@k2";
        itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), new Atom<String>("v2"));

        this.stopWatch();
        script = "g:map('k1','v1','k2','v2')/@k3";
        itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 1);
        assertNull(results.get(0));

    }
}

package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MapFunctionTest extends TestCase {

    public void testEmptyMap() {
        Function function = new MapFunction();
        Atom atom = function.compute(new ArrayList<Operation>());
        assertTrue(atom.isMap());
        assertEquals(((Map) atom.getValue()).size(), 0);
    }

    public void testArgumentSizeErrorMap() {
        Function function = new MapFunction();
        try {
            function.compute(TestHelper.createUnaryArgs("key1"));
            assertFalse(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testTwoEntryMap() {
        Function function = new MapFunction();
        Atom atom = function.compute(TestHelper.createUnaryArgs("key1", "value1", "key2", 2));
        assertTrue(atom.isMap());
        assertEquals(((Map) atom.getValue()).size(), 2);
        assertEquals(((Map<Atom, Atom>) atom.getValue()).get(new Atom("key1")).getValue(), "value1");
        assertEquals(((Map<Atom, Atom>) atom.getValue()).get(new Atom("key2")).getValue(), 2);

    }

    public void testElementMap() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Function function = new MapFunction();
        Atom atom = function.compute(TestHelper.createUnaryArgs(graph.getVertex("1")));
        assertTrue(atom.isMap());
        Map map = (Map) atom.getValue();
        assertEquals(map.get(new Atom("name")), new Atom("marko"));
        assertEquals(map.get(new Atom("age")), new Atom(29));
    }
}

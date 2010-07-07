package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class KeysFunctionTest extends BaseTest {

    public void testMapKeys() {
        Map<Atom, Atom> map = new HashMap<Atom, Atom>();
        map.put(new Atom<String>("marko"), new Atom<Double>(30.0d));
        map.put(new Atom<String>("jen"), new Atom<Double>(26.0d));
        Function<Iterable<Atom>> function = new KeysFunction();
        this.stopWatch();
        Atom<Iterable<Atom>> atom = function.compute(createUnaryArgs(map));
        printPerformance(function.getFunctionName() + " function", 2, "key map", this.stopWatch());
        List<Atom> list = asList(atom.getValue());
        assertEquals(list.size(), 2);
        assertTrue(list.contains(new Atom<String>("marko")));
        assertTrue(list.contains(new Atom<String>("jen")));
    }

    public void testElementKeys() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Function<Iterable<Atom>> function = new KeysFunction();
        this.stopWatch();
        Atom<Iterable<Atom>> atom = function.compute(createUnaryArgs(graph.getVertex("1")));
        printPerformance(function.getFunctionName() + " function", 2, "key vertex", this.stopWatch());
        List<Atom> list = asList(atom.getValue());
        assertEquals(list.size(), 2);
        assertTrue(list.contains(new Atom<String>("age")));
        assertTrue(list.contains(new Atom<String>("name")));
    }
}

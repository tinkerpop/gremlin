package com.tinkerpop.gremlin.steps

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GroupCountClosureStepTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.V.groupCount() instanceof Pipe)
        assertTrue(g.V.groupCount([:]) instanceof Pipe)
    }

    public void testReset() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def m = [:];
        Pipe pipe = g.v(1).outE.inV.groupCount(m);
        pipe >> -1;
        assertEquals(m.size(), 3);
        pipe.reset();
        assertEquals(m.size(), 3);
        pipe >> -1;
        assertEquals(m.size(), 3);
        assertEquals(pipe.getPipes()[3].getSideEffect().size(), 0);
        pipe.setStarts(g.v(1).iterator());
        pipe >> -1;
        assertEquals(m.size(), 3);
        assertEquals(pipe.getPipes()[3].getSideEffect().size(), 3);
    }

    public void testGroupCountClosure() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def m = [:].withDefault {0};
        g.v(1).outE.inV.groupCount(m) {it} {it + 1}.outE.inV.groupCount(m) {it} {it + 3} >> -1
        assertEquals(m.size(), 4)
        assertEquals(m.get(g.v(2)), 1);
        assertEquals(m.get(g.v(4)), 1);
        assertEquals(m.get(g.v(3)), 4);
        assertEquals(m.get(g.v(5)), 3);

        m = [:].withDefault {0};
        g.v(1).outE.inV.groupCount(m) {it} {it + 1}.outE.inV.groupCount(m) {it} {3.0d} >> -1
        assertEquals(m.size(), 4)
        assertEquals(m.get(g.v(2)), 1);
        assertEquals(m.get(g.v(4)), 1);
        assertEquals(m.get(g.v(3)), 3.0d);
        assertEquals(m.get(g.v(5)), 3.0d);
    }

    public void testGroupCountMixing() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def m = [:].withDefault {0};
        g.v(1).outE.inV.groupCount(m).outE.inV.groupCount(m) {it} {it + 3.0d} >> -1
        assertEquals(m.size(), 4)
        assertEquals(m.get(g.v(2)), 1);
        assertEquals(m.get(g.v(4)), 1);
        assertEquals(m.get(g.v(3)), 4.0d);
        assertEquals(m.get(g.v(5)), 3.0d);
    }

    public void testGroupCountKeyClosure() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def m = [:];
        g.v(1)._().groupCount(m) {it.age} {3.0f}.as('x').out.groupCount(m) {it.name}.loop('x') {it.loops < 3} >> -1
        assertEquals(m.size(), 5);
        assertTrue(m.keySet().contains("vadas"));
        assertTrue(m.keySet().contains("josh"));
        assertTrue(m.keySet().contains("lop"));
        assertTrue(m.keySet().contains("ripple"));
        assertTrue(m.keySet().contains(29));
        assertEquals(m["vadas"], 1);
        assertEquals(m["josh"], 1);
        assertEquals(m["lop"], 2);
        assertEquals(m["ripple"], 1);
        assertEquals(m[29], 3.0f);
    }

    public void testGroupCountNoCap() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def m = [:]
        assertEquals(g.v(1).outE.inV.groupCount(m), g.v(1).outE.inV);
        assertEquals(m.size(), 3);
        m.each {key, value -> assertEquals(value, 1); assertTrue(key instanceof Vertex)};
    }

    public void testGroupCountCap() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def m = g.E.bothV.groupCount.cap >> 1
        def n = m.clone()
        g.E.bothV.groupCount(n).cap >> -1

        m.each {key, value -> assertEquals(value / 1, n[key] / 2)};
    }
}

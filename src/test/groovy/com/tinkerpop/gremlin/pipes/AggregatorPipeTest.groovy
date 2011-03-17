package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class AggregatorPipeTest extends TestCase {

    public void testAggregateNoCap() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def x = [] as Set
        def results = []
        g.v(1).outE.inV.aggregate(x).outE.inV {!x.contains(it)} >> results
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), g.v(5));

        assertEquals(g.v(1).outE.inV.aggregate, g.v(1).outE.inV)
    }

    public void testAggregateCap() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def x = [] as Set
        assertEquals(g.v(1).outE.inV.aggregate(x).cap >> 1, x);
        x = []
        assertEquals(g.v(1).outE.inV.aggregate.cap >> 1, g.v(1).outE.inV >> x)
    }

    public void testAggregateWithClosureFilter() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def x = []
        def results = []
        g.v(1).outE.inV.aggregate(x) {it.name != 'lop'} >> results
        assertEquals(results.size(), 2)
        assertEquals(results.get(0).name, "vadas")
        assertEquals(results.get(1).name, "josh")
        assertEquals(x.size(), 3)

    }

    public void testEqualityToGather() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        assertEquals(g.E.bothV.aggregate.cap >> 1, g.E.bothV.gather >> 1)
    }
}

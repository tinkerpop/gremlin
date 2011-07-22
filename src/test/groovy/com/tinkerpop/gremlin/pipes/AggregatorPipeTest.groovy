package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class AggregatorPipeTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.V.aggregate() instanceof Pipe)
    }

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

    public void testEqualityToNonAggregation() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def x = [] as Set;
        assertEquals(g.V.out.in, g.V.out.aggregate(x).in);
        x.clear();
        assertEquals(g.v(1).out.aggregate(x).paths >> [], g.v(1).out.paths >> []);
        x.clear();
        assertEquals(g.v(1).out.aggregate(x).in.paths >> [], g.v(1).out.in.paths >> []);
    }

    public void testBreadthFirstAggregate() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def x = [];
        def results = [];

        g.v(1).as('x').out.aggregate(x).loop('x') {it.loops < 3} >> results;
        assertEquals(x, [g.v(2), g.v(3), g.v(4), g.v(5), g.v(3)])
        assertEquals(results.size(), 2);

        x = [];
        assertTrue(g.v(1).as('x').out.aggregate(x).loop('x') {it.loops < 3} == g.v(1).as('x').out.loop('x') {it.loops < 3});
        x = [];
        def resultsA = g.v(1).as('x').out.aggregate(x).loop('x') {it.loops < 3}.paths >> [];
        def resultsB = g.v(1).as('x').out.loop('x') {it.loops < 3}.paths >> [];
        assertEquals(resultsA, resultsB)

    }
}

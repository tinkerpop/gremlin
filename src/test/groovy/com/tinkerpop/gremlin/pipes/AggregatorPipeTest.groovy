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
    }

    /*public void testBreadthFirstAggregate() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def x = [];
        def results = [];
        def c = 0;

        g.v(1).as('x').out.aggregate(x).loop('x'){println(it.object.toString() + " " + it.loops); it.loops < 3} >> results;
        println results;
        println x;

        g.v(1).out.aggregate(x).paths.each{println it};
    }*/
}

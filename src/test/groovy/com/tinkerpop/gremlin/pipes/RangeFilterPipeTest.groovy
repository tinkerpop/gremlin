package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class RangeFilterPipeTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.V[0..10] instanceof Pipe)
        assertTrue(g.V.outE[0..<10] instanceof Pipe)
        assertTrue(g.V.outE.inV[1] instanceof Pipe)
    }

    public void testBasicRange() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def results = []
        g.v(1).outE[0..2] >> results
        assertEquals(results.size(), 3)
        assertEquals(results[0], g.v(1).outE[0] >> 1)
        assertEquals(results[1], g.v(1).outE[1] >> 1)
        assertEquals(results[2], g.v(1).outE[2] >> 1)
    }

    public void testGetAt() {
        Gremlin.load()
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertEquals(g.V[0].count(), 1);
        assertEquals(g.V.next(), (g.V[0] >> []).get(0));

        assertEquals(g.V[0..1].count(), 2);
        def itty = g.V;
        assertEquals([itty.next(), itty.next()], g.V[0..1].toList());

    }

}

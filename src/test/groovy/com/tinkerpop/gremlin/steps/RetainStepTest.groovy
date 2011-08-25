package com.tinkerpop.gremlin.steps

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class RetainStepTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.V.except([g.v(1)]) instanceof Pipe)
        assertTrue(g.V.retain([g.v(1)]) instanceof Pipe)
    }

    public void testRetainPattern() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def x = [] as Set
        def results = []
        g.v(1).outE.inV.aggregate(x).outE.inV.retain(x) >> results
        assertEquals(results.size(), 1)
        assertTrue(results.contains(g.v(3)))
    }

    public void testRetainWithClosureFilter() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def x = []
        def results = []
        g.v(1).outE.inV.aggregate(x).outE.inV.retain(x).filter{it.id == 3} >> results
        assertEquals(results.size(), 0)
    }

}


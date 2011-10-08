package com.tinkerpop.gremlin.groovy.steps

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GatherStepTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.V.gather instanceof Pipe)
        assertTrue(g.V.gather() instanceof Pipe)
    }

    public void testGatherNoClosure() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def results = [];
        assertEquals(g.v(1).outE.gather >> 1, g.v(1).outE >> results);
    }

    public void testGatherClosure() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertEquals(g.v(1).outE.gather { it.get(0) } >> 1, g.v(1).outE[0] >> 1);
    }
}

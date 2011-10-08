package com.tinkerpop.gremlin.groovy.steps

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class MemoizeStepTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.v(1).out.out.memoize(1).name instanceof Pipe)
    }

    public void testPipeEquality() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertEquals(g.v(1).out.out.memoize(1).name, g.v(1).out.out.name)
    }
}
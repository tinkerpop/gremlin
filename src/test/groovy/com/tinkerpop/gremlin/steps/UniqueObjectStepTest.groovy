package com.tinkerpop.gremlin.steps

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class UniqueObjectStepTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.V.uniqueObject instanceof Pipe)
        assertTrue(g.V.uniqueObject() instanceof Pipe)
    }

    public void testUniqueObject() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def results = []
        g.V.outE.bothV.uniqueObject >> results
        assertEquals(results.size(), 6);
    }
}

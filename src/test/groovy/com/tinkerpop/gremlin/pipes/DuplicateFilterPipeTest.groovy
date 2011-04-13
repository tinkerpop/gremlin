package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase
import com.tinkerpop.pipes.Pipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class DuplicateFilterPipeTest extends TestCase {

    public void testUniqueObject() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def results = []
        g.V.outE.bothV.uniqueObject >> results
        assertEquals(results.size(), 6);
        assertTrue(g.V.outE.bothV.uniqueObject instanceof Pipe)
        assertTrue(g.V.outE.bothV.uniqueObject() instanceof Pipe)

    }
}

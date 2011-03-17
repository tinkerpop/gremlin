package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class RangeFilterPipeTest extends TestCase {

    public void testBasicRange() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def results = []
        g.v(1).outE[0..2] >> results
        assertEquals(results.size(), 2)
        assertEquals(results[0], g.v(1).outE[0] >> 1)
        assertEquals(results[1], g.v(1).outE[1] >> 1)
    }
}

package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GatherPipeTest extends TestCase {

    public void testGatherNoClosure() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def results = [];
        assertEquals(g.v(1).outE.gather >> 1, g.v(1).outE >> results);
    }

    public void testGatherClosure() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertEquals(g.v(1).outE.gather { starts.next().get(0) } >> 1, g.v(1).outE[0] >> 1);
    }
}

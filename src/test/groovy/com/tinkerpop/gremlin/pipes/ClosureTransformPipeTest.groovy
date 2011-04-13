package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ClosureTransformPipeTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.V.transform {true} instanceof Pipe)
    }


    public void testTransformPipe() {
        Gremlin.load()
        def g = TinkerGraphFactory.createTinkerGraph()
        def results = []
        g.v(1).outE.inV.transform {it.name} >> results
        assertEquals(results.size(), 3)
        assertTrue(results.contains("josh"))
        assertTrue(results.contains("lop"))
        assertTrue(results.contains("vadas"))

        results = []
        g.v(1)._.transform {it.outE}.scatter.transform {it.inV}.scatter.transform {it.name} >> results
        assertEquals(results.size(), 3)
        assertTrue(results.contains("josh"))
        assertTrue(results.contains("lop"))
        assertTrue(results.contains("vadas"))
    }

}

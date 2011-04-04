package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ClosureTransformPipeTest extends TestCase {

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

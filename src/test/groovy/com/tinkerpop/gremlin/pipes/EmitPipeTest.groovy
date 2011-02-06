package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class EmitPipeTest extends TestCase {

  public void testEmitPipe() {
    Gremlin.load()
    def g = TinkerGraphFactory.createTinkerGraph()
    def results = []
    g.v(1).outE.inV.emit {it.name} >> results
    assertEquals(results.size(), 3)
    assertTrue(results.contains("josh"))
    assertTrue(results.contains("lop"))
    assertTrue(results.contains("vadas"))

    results = []
    g.v(1)._.emit {it.outE}.scatter.emit {it.inV}.scatter.emit {it.name} >> results
    assertEquals(results.size(), 3)
    assertTrue(results.contains("josh"))
    assertTrue(results.contains("lop"))
    assertTrue(results.contains("vadas"))
  }

}

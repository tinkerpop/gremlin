package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ForeachPipeTest extends TestCase {

  public void testForeachPipe() {

    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    def results = []
    def results2 = []
    g.v(1).outE.inV.foreach {results.add(it)}.name >> results2
    assertEquals(results.size(), 3)
    assertTrue(results.contains(g.v(2)))
    assertTrue(results.contains(g.v(4)))
    assertTrue(results.contains(g.v(3)))
    assertEquals(results.size(), 3)
    assertTrue(results2.contains('vadas'))
    assertTrue(results2.contains('josh'))
    assertTrue(results2.contains('lop'))
  }
}

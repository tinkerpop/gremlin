package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ClosureFilterPipeTest extends TestCase {

  public void testClosureFilter() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    def results = []
    g.v(1).outE.inV.filter {true} >> results
    assertEquals(results.size(), 3)
    assertTrue(results.contains(g.v(2)))
    assertTrue(results.contains(g.v(3)))
    assertTrue(results.contains(g.v(4)))

    results = []
    g.v(1).outE.inV.filter {false} >> results
    assertEquals(results.size(), 0)

    results = []
    g.v(1).outE.inV.filter {it == g.v(2)} >> results
    assertEquals(results.size(), 1)
    assertTrue(results.contains(g.v(2)))

  }
}

package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class CountPipeTest extends TestCase {

  public void testCountingObjects() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    assertEquals(g.v(1)._().objectCount.cap >> 1, 1);
    assertEquals(g.v(1).outE.inV.objectCount.cap >> 1, 3);
  }
}


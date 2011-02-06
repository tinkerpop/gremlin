package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class IfPipeTest extends TestCase {

  public void testIfPipe() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    assertEquals(29, g.v(1)._.ifelse {it.name == 'marko'} {it.age} {it.name} >> 1)
    assertEquals("marko", g.v(1)._.ifelse {it.name == 'josh'} {it.age} {it.name} >> 1)

    assertEquals("josh", g.v(1).outE[[label: 'knows']].ifelse {it.weight > 0.5} {it.inV.name >> 1} >> 1)
  }
}

package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GroupCountClosurePipeTest extends TestCase {

  public void testGroupCountClosure() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    def m = [:].withDefault {0};
    g.v(1).outE.inV.groupCount(m) {it + 1}.outE.inV.groupCount(m) {it + 3} >> -1
    assertEquals(m.size(), 4)
    assertEquals(m.get(g.v(2)), 1);
    assertEquals(m.get(g.v(4)), 1);
    assertEquals(m.get(g.v(3)), 4);
    assertEquals(m.get(g.v(5)), 3);

    m = [:].withDefault {0};
    g.v(1).outE.inV.groupCount(m) {it + 1}.outE.inV.groupCount(m) {3.0d} >> -1
    assertEquals(m.size(), 4)
    assertEquals(m.get(g.v(2)), 1);
    assertEquals(m.get(g.v(4)), 1);
    assertEquals(m.get(g.v(3)), 3.0d);
    assertEquals(m.get(g.v(5)), 3.0d);
  }
}

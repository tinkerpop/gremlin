package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens.T
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GroupCountPipeTest extends TestCase {

  public void testGroupCountNoCap() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    def m = [:]
    assertEquals(g.v(1).outE.inV.group_count(m), g.v(1).outE.inV);
    assertEquals(m.size(), 3);
    m.each {key, value -> assertEquals(value, 1); assertTrue(key instanceof Vertex)};
  }

  public void testGroupCountCap() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    def m = g.E.bothV.group_count.cap >> 1
    def n = m.clone()
    g.E.bothV.group_count(n)[T.side] >> -1

    m.each {key, value -> assertEquals(value / 1, n[key] / 2)};
  }
}

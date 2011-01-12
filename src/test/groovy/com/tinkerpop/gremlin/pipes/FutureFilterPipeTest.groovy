package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.PipeHelper
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class FutureFilterPipeTest extends TestCase {

  public void testFutureFilterOnGraph() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(g.v(1)._().futuref(_().outE.inV).name.next(), "marko");
    assertEquals(g.v(1).outE.inV.futuref(_().outE.inV[[name: 'lop']]).name.next(), "josh");
    assertEquals(g.v(1).outE.inV.futuref(_().outE.inV[[name: 'ripple']]).name.next(), "josh");
    assertEquals(g.v(1).outE.futuref(_().inV[[name: 'lop']]).id.next(), "9");

    def list = ["ripple", "lop", "blah"]
    assertEquals(PipeHelper.counter(g.v(1).outE.inV.futuref(_().outE.inV {list.contains(it.name)}).outE.inV), 2);
    assertTrue(["ripple", "lop"].contains(g.v(1).outE.inV.futuref(_().outE.inV {list.contains(it.name)}).outE.inV[0].name >> 1));
    assertTrue(["ripple", "lop"].contains(g.v(1).outE.inV.futuref(_().outE.inV {list.contains(it.name)}).outE.inV[1].name >> 1));
  }

  public void testFutureFilterOnGraphUsingBack() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(g.v(1).outE.inV.back(2).name.next(), "marko");
    assertEquals(g.v(1).outE.inV.outE.inV[[name: 'lop']].back(3).name.next(), "josh");
    assertEquals(g.v(1).outE.inV.outE.inV[[name: 'ripple']].back(3).name.next(), "josh");
    assertEquals(g.v(1).outE.inV[[name: 'lop']].back(2).id.next(), "9");

    def list = ["ripple", "lop", "blah"]
    assertEquals(PipeHelper.counter(g.v(1).outE.inV.outE.inV {list.contains(it.name)}.back(3).outE.inV), 2);
    assertTrue(["ripple", "lop"].contains(g.v(1).outE.inV.outE.inV {list.contains(it.name)}.back(3).outE.inV[0].name >> 1));
    assertTrue(["ripple", "lop"].contains(g.v(1).outE.inV.outE.inV {list.contains(it.name)}.back(3).outE.inV[1].name >> 1));
  }
}

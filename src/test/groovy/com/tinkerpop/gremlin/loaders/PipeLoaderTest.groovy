package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PipeLoaderTest extends TestCase {

  public void testRightShiftSetStarts() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    def list = []
    (g.v(1) >> _().outE.inV.name) >> list
    assertTrue(list.contains("lop"));
    assertTrue(list.contains("vadas"));
    assertTrue(list.contains("josh"));

    list = []
    g.v(1) >> _().outE.inV.name >> list
    assertTrue(list.contains("lop"));
    assertTrue(list.contains("vadas"));
    assertTrue(list.contains("josh"));
  }

}

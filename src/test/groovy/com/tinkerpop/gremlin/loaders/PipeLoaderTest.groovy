package com.tinkerpop.gremlin.loaders

import junit.framework.TestCase
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.blueprints.pgm.Graph

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PipeLoaderTest extends TestCase {

  public void testCount() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    assertEquals(g.V.count(), 6l);
    assertEquals(g.E.count(), 6l);
    assertEquals(g.v(1).outE().count(), 3l);
    assertEquals(g.v(1).outE[[label:'blah']].count(), 0l);
  }

}

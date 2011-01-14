package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class DuplicateFilterPipeTest extends TestCase {

  public void testUnique() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    def results = []
    g.V.outE.bothV.unique >> results
    assertEquals(results.size(), 6);

  }
}

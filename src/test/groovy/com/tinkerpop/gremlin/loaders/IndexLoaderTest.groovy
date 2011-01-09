package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens.T
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class IndexLoaderTest extends TestCase {
  public void testIndexShortcuts() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals((g.idx(T.v)[[name: 'marko']] as List)[0], g.v(1));
    assertEquals(g.idx(T.e)[[label: 'created']].size(), 4);
  }
}

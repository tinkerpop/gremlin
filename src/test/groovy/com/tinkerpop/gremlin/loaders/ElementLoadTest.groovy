package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ElementLoadTest extends TestCase {

  public void testKeysValuesMapOnElement() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    assertEquals(g.v(1).values.size(), 2);
    assertEquals(g.v(1).keys.size(), 2);
    assertEquals(g.v(1).map.keySet(), g.v(1).keys);
    assertTrue(g.v(1).values().contains("marko"));
    assertTrue(g.v(1).values().contains(29));
    assertTrue(g.v(1).keys().contains("name"));
    assertTrue(g.v(1).keys().contains("age"));
  }
}

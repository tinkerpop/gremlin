package com.tinkerpop.gremlin

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GremlinHelperTest extends TestCase {

  public void testMissingMethods() {
    Gremlin.load();
    Set tokens = GremlinHelper.getMissingMethods(TinkerGraph.class);
    assertTrue(tokens.contains("V"))
    assertTrue(tokens.contains("v"))
    assertTrue(tokens.contains("E"))
    assertTrue(tokens.contains("e"))
    assertTrue(tokens.contains("_"))
  }
}

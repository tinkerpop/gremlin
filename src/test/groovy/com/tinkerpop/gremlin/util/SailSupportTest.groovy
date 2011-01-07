package com.tinkerpop.gremlin.util

import com.tinkerpop.blueprints.pgm.impls.sail.impls.MemoryStoreSailGraph
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SailSupportTest extends TestCase {

  public void testNamespacePrefix() {
    SailSupport.load();

    def g = new MemoryStoreSailGraph();
    g.addNamespace('tg', 'http://tinkerpop.com#');
    assertEquals(g.uri('tg:1'), 'http://tinkerpop.com#1');
    assertEquals(g.qn('http://tinkerpop.com#1'), 'tg:1');
  }

}

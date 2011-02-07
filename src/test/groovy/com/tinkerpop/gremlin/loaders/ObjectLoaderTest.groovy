package com.tinkerpop.gremlin.loaders

import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ObjectLoaderTest extends TestCase {

  public void testMean() {
    Gremlin.load()
    def numbers = [1, 2, 3, 4, 5]
    assertEquals(numbers.mean(), 3.0d)
  }
}

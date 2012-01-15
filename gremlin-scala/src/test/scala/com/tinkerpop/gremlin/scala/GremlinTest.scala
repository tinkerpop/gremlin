package com.tinkerpop.gremlin.scala

import junit.framework.TestCase
import com.tinkerpop.gremlin.Tokens
import junit.framework.Assert._

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class GremlinTest extends TestCase {

  def testVersion() {
    assertEquals(Gremlin.version(), Tokens.VERSION);
  }

  def testLanguage() {
    assertEquals(Gremlin.language(), "gremlin-scala");
  }

}
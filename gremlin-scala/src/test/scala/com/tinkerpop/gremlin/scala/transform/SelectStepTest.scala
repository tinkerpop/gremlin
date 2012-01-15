package com.tinkerpop.gremlin.scala.transform

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.scala._

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class SelectStepTest extends com.tinkerpop.gremlin.test.transform.SelectStepTest {

  val g = TinkerGraphFactory.createTinkerGraph()

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_asXaX_outXknowsX_asXbX_select() {
    super.test_g_v1_asXaX_outXknowsX_asXbX_select(g.v(1).->.as("a").out("knows").as("b").select())
  }
}
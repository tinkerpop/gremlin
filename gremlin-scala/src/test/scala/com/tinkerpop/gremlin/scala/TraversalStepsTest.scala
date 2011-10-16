package com.tinkerpop.gremlin.scala.transform

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.UtilitiesTest
import com.tinkerpop.gremlin.scala._

class TraversalStepsTest extends com.tinkerpop.gremlin.test.transform.TraversalStepsTest {
  val g = TinkerGraphFactory.createTinkerGraph()
  
  override def testCompliance() {
    UtilitiesTest.testCompliance(this.getClass())
  }
  
  /*def test_g_V() {
    super.test_g_V(g.V)
  }*/
  
  def test_g_v1_out() {
    super.test_g_v1_out(g.v(1).head.out)
  }
}

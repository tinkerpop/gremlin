package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.blueprints.pgm.Vertex

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class UtilitiesTest extends com.tinkerpop.gremlin.test.UtilitiesTest {

  val g = TinkerGraphFactory.createTinkerGraph()

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_out_toList() {
    super.test_g_v1_out_toList(g.v(1).out.toList)
  }

  def test_g_v1_out_nextX1X() {
    super.test_g_v1_out_nextX1X(g.v(1).out.next(1))
  }

  def test_g_v1_out_fillXlistX() {
    super.test_g_v1_out_fillXlistX(g.v(1).out().fill(new java.util.ArrayList[Vertex]()));
  }

  def test_g_V_countXX() {
    super.test_g_V_countXX(g.V.count());
  }

}
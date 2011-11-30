package com.tinkerpop.gremlin.scala.transform

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.scala._

class TraversalStepsTest extends com.tinkerpop.gremlin.test.transform.TraversalStepsTest {
  val g = TinkerGraphFactory.createTinkerGraph()

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_V() {
    super.test_g_V(g.V)
  }

  def test_g_v1_out() {
    super.test_g_v1_out(g.v(1).out)
  }

  def test_g_v2_in() {
    super.test_g_v2_in(g.v(2).in)
  }

  def test_g_v4_both() {
    super.test_g_v4_both(g.v(4).both)
  }

  def test_g_E() {
    super.test_g_E(g.E)
  }

  def test_g_v1_outE() {
    super.test_g_v1_outE(g.v(1).outE)
  }

  def test_g_v2_inE() {
    super.test_g_v2_inE(g.v(2).inE)
  }

  def test_g_v4_bothE() {
    super.test_g_v4_bothE(g.v(4).bothE)
  }

  def test_g_v1_outE_inV() {
    super.test_g_v1_outE_inV(g.v(1).outE.inV)
  }

  def test_g_v2_inE_outV() {
    super.test_g_v2_inE_outV(g.v(2).inE.outV)
  }

  def test_g_v1_outXknowsX() {
    super.test_g_v1_outXknowsX(g.v(1).out("knows"))
  }

  def test_g_v1_outXknows_createdX() {
    super.test_g_v1_outXknows_createdX(g.v(1).out("knows", "created"))
  }

  def test_g_v1_outEXknowsX_inV() {
    super.test_g_v1_outEXknowsX_inV(g.v(1).outE("knows").inV)
  }

  def test_g_v1_outEXknows_createdX_inV() {
    super.test_g_v1_outEXknows_createdX_inV(g.v(1).outE("knows", "created").inV)
  }

  def test_g_V_out_out() {
    super.test_g_V_out_out(g.V.out.out)
  }

  def test_g_v1_out_out_out() {
    super.test_g_v1_out_out_out(g.v(1).out.out.out)
  }

  def test_g_v1_out_propertyXnameX() {
    super.test_g_v1_out_propertyXnameX(g.v(1).out.property("name"))
  }
}

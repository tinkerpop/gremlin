package com.tinkerpop.gremlin.scala.transform

import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory

class TransformStepTest extends com.tinkerpop.gremlin.test.transform.TransformStepTest {
  val g = TinkerGraphFactory.createTinkerGraph()

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_transformXnameX() {
    super.test_g_v1_transformXnameX(g.v(1).->.transform({v: Vertex => v.getProperty("name").toString}))
  }

  def test_g_v1_outE_label_transformXlengthX() {
    super.test_g_v1_outE_label_transformXlengthX(g.v(1).outE.label.transform({s: String => s.length(): java.lang.Integer})) //TODO eliminate the :java.lang.Integer
  }

  def test_g_v1_out_transformXnameX_transformXlengthX() {
    super.test_g_v1_out_transformXnameX_transformXlengthX(g.v(1).out.transform({v: Vertex => v.getProperty("name").toString}).transform({s: String => s.length(): java.lang.Integer})) //TODO eliminate the :java.lang.Integer
  }
}

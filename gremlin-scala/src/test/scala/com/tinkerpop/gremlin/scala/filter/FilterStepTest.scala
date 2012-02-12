package com.tinkerpop.gremlin.scala.filter

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.blueprints.pgm.Vertex
import java.lang.{Integer => JInteger}
import com.tinkerpop.gremlin.scala._

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class FilterStepTest extends com.tinkerpop.gremlin.test.filter.FilterStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_V_filterXfalseX() {
    super.test_g_V_filterXfalseX(g.V.filter {v: Vertex => false});
  }

  def test_g_V_filterXtrueX() {
    super.test_g_V_filterXtrueX(g.V.filter {v: Vertex => true});
  }

  def test_g_V_filterXlang_eq_javaX() {
    super.test_g_V_filterXlang_eq_javaX(g.V.filter {v: Vertex => v.as[String]("lang").exists(_.equals("java"))});
  }

  def test_g_v1_out_filterXage_gt_30X() {
    super.test_g_v1_out_filterXage_gt_30X(g.v(1).out.filter {v: Vertex => v.as[JInteger]("age").exists(_ > 30)});
  }

  def test_g_V_filterXname_startsWith_m_OR_name_startsWith_pX() {
    super.test_g_V_filterXname_startsWith_m_OR_name_startsWith_pX(g.V.filter {v: Vertex => v.as[String]("name").exists(n => n.startsWith("m") || n.startsWith("p"))});
  }
}
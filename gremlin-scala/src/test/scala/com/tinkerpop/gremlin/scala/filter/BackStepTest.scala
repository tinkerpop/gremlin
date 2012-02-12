package com.tinkerpop.gremlin.scala.filter

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.pipes.Pipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class BackStepTest extends com.tinkerpop.gremlin.test.filter.BackStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_out_backX1X() {
    super.test_g_v1_out_backX1X(g.v(1).out.back(1));
  }

  def test_g_v1_asXhereX_out_backXhereX() {
    super.test_g_v1_asXhereX_out_backXhereX(g.v(1).->.as("here").out.back("here").asInstanceOf[Pipe[Vertex, Vertex]]);
  }

  def test_g_v4_out_filterXlang_eq_javaX_backX1X() {
    super.test_g_v4_out_filterXlang_eq_javaX_backX1X(g.v(4).out.filter {v: Vertex => v.as[String]("lang").exists(_ == "java")}.back(1))
  }

  def test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX() {
    super.test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX(g.v(4).out.as("here").filter {v: Vertex => v.as[String]("lang").exists(_.equals("java"))}.back("here").asInstanceOf[Pipe[Vertex, Vertex]]);
  }

  def test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX_propertyXnameX() {
    super.test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX_propertyXnameX(g.v(4).out.as("here").filter {v: Vertex => v.as[String]("lang").exists(_.equals("java"))}.back("here").property("name").asInstanceOf[Pipe[Vertex, String]]);
  }
}

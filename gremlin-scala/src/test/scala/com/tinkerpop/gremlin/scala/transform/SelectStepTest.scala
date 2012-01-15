package com.tinkerpop.gremlin.scala.transform

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.blueprints.pgm.Vertex
import java.util.Arrays

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

  def test_g_v1_asXaX_outXknowsX_asXbX_selectXnameX() {
    super.test_g_v1_asXaX_outXknowsX_asXbX_selectXnameX(g.v(1).->.as("a").out("knows").as("b").select({v: Vertex => v("name")}))
  }

  def test_g_v1_asXaX_outXknowsX_asXbX_selectXaX() {
    super.test_g_v1_asXaX_outXknowsX_asXbX_selectXaX(g.v(1).->.as("a").out("knows").as("b").select(Arrays.asList("a")))
  }

  def test_g_v1_asXaX_outXknowsX_asXbX_selectXa_nameX() {
    super.test_g_v1_asXaX_outXknowsX_asXbX_selectXa_nameX(g.v(1).->.as("a").out("knows").as("b").select(Arrays.asList("a"), {v: Vertex => v("name")}))
  }
}
package com.tinkerpop.gremlin.scala.transform

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.blueprints.pgm.Vertex

class MapStepTest extends com.tinkerpop.gremlin.test.transform.MapStepTest {
  val g = TinkerGraphFactory.createTinkerGraph()

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_map() {
    super.test_g_v1_map(g.v(1).->.map.asInstanceOf[GremlinScalaPipeline[Vertex, java.util.Map[String, Object]]])
  }

  def test_g_v1_outXknowsX_map() {
    super.test_g_v1_outXknowsX_map(g.v(1).out("knows").map);
  }
}

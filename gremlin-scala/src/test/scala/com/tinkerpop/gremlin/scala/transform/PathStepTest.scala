package com.tinkerpop.gremlin.scala.transform

import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.pipes.branch.LoopPipe.LoopBundle

class PathStepTest extends com.tinkerpop.gremlin.test.transform.PathStepTest {
  val g = TinkerGraphFactory.createTinkerGraph()

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_propertyXnameX_path() {
    super.test_g_v1_propertyXnameX_path(g.v(1).->.property("name").path())
  }

  def test_g_v1_out_pathXage__nameX() {
    super.test_g_v1_out_pathXage__nameX(g.v(1).out.path({v: Vertex => v("age")}, {v: Vertex => v("name")}))
  }

  def test_g_V_out_loopX1__loops_lt_3X_pathXit__name__langX() {
    val p = g.V.out.loop(1, {lb: LoopBundle[Vertex] => lb.loops < 3}).path({v: Vertex => v}, {v: Vertex => v("name")}, {v: Vertex => v("lang")})
    super.test_g_V_out_loopX1__loops_lt_3X_pathXit__name__langX(p)
  }
}

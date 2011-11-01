package com.tinkerpop.gremlin.scala.transform

import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.UtilitiesTest
import com.tinkerpop.gremlin.scala._

class PathStepTest extends com.tinkerpop.gremlin.test.transform.PathStepTest {
  val g = TinkerGraphFactory.createTinkerGraph()

  /*override def testCompliance() {
    UtilitiesTest.testCompliance(this.getClass())
  }*/

  def test_g_v1_propertyXnameX_paths() {
    super.test_g_v1_propertyXnameX_paths(g.v(1).property("name").paths)
  }

  def test_g_v1_out_pathsXage__nameX() {
    super.test_g_v1_out_pathsXage__nameX(g.v(1).out.path({v: Vertex => v("age")}, {v: Vertex => v("name")}))
  }

  /* Waiting on https://github.com/tinkerpop/pipes/issues/53
  def test_g_V_out_loopX1__loops_lt_3X_pathsXit__name__langX() {
    def foo(lb: com.tinkerpop.pipes.branch.LoopPipe.LoopBundle[Vertex]) = lb.loops < 3
    super.test_g_V_out_loopX1__loops_lt_3X_pathsXit__name__langX(g.V.out.loop(1)(foo _).paths({it}{it.name}{it.lang}))
  }*/
}

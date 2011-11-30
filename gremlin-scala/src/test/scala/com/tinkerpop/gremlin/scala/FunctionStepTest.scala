package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import java.util.{Iterator => JIterator}

class FunctionStepTest extends com.tinkerpop.gremlin.test.FunctionStepTest {
  val g = TinkerGraphFactory.createTinkerGraph()

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_out_stepXnext_nameX() {
    //TODO can we use a scala Iterator here instead of JIterator?
    super.test_g_v1_out_stepXnext_nameX(g.v(1).out.step({it: JIterator[Vertex] => it.next()("name").toString}))
  }
}

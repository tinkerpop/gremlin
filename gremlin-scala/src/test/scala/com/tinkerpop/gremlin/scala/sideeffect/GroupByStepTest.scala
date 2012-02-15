package com.tinkerpop.gremlin.scala.sideeffect

import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.scala._

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class GroupByStepTest extends com.tinkerpop.gremlin.test.sideeffect.GroupByStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass);
  }

  def test_g_V_groupByXlang_nameX() {
    val m = new java.util.HashMap[String, java.util.List[String]]();
    super.test_g_V_groupByXlang_nameX(g.V.groupBy(m.asInstanceOf[java.util.HashMap[_, java.util.List[_]]], {v: Vertex => v("lang")}, {v: Vertex => v("name")}), m);
  }
}


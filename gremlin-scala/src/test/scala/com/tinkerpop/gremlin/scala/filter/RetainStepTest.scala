package com.tinkerpop.gremlin.scala.filter

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.blueprints.pgm.Vertex
import java.util.{HashSet, ArrayList}
import com.tinkerpop.gremlin.scala._

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class RetainStepTest extends com.tinkerpop.gremlin.test.filter.RetainStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_out_retainXg_v2X() {
    val x = new ArrayList[Vertex]();
    x.add(g.v(2));
    super.test_g_v1_out_retainXg_v2X(g.v(1).out.retain(x));
  }

  def test_g_v1_out_aggregateXxX_out_retainXxX() {
    val x = new HashSet[Vertex]();
    super.test_g_v1_out_aggregateXxX_out_retainXxX(g.v(1).out.aggregate(x).out.retain(x));
  }

}
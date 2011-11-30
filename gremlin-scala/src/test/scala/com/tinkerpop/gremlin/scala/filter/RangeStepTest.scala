package com.tinkerpop.gremlin.scala.filter

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class RangeStepTest extends com.tinkerpop.gremlin.test.filter.RangeStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass);
  }

  def test_g_v1_out_rangeX0_1X() {
    super.test_g_v1_out_rangeX0_1X(g.v(1).out.range(0, 1));
  }
}
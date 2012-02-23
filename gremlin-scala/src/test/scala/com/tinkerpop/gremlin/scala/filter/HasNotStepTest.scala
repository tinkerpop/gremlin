package com.tinkerpop.gremlin.scala.filter

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.gremlin.Tokens.T

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class HasNotStepTest extends com.tinkerpop.gremlin.test.filter.HasNotStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_V_hasNotXname_markoX() {
    super.test_g_V_hasNotXname_markoX(g.V.hasNot("name", "marko"));
  }

  def test_g_V_hasNotXname_blahX() {
    super.test_g_V_hasNotXname_blahX(g.V.hasNot("name", "blah"));
  }

  def test_g_V_hasNotXblah_nullX() {
    super.test_g_V_hasNotXblah_nullX(g.V.hasNot("blah", null));
  }

  def test_g_V_hasNotXage_gt_32X() {
    super.test_g_V_hasNotXage_gt_32X(g.V.hasNot("age", T.gt, 32));
  }
}
package com.tinkerpop.gremlin.scala.filter

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.blueprints.pgm.{Graph, Vertex}

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class DedupStepTest extends com.tinkerpop.gremlin.test.filter.DedupStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_V_both_dedup_name() {
    super.test_g_V_both_dedup_name(g.V.both().dedup.property("name").asInstanceOf[Pipe[Graph, String]]);
  }

  def test_g_V_both_dedupXlangX_name() {
    super.test_g_V_both_dedupXlangX_name(g.V.both().dedup {v: Vertex => v("lang")}.property("name").asInstanceOf[Pipe[Graph, String]])
  }
}
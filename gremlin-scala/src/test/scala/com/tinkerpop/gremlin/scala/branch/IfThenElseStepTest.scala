package com.tinkerpop.gremlin.scala.branch

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.pipes.Pipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class IfThenElseStepTest extends com.tinkerpop.gremlin.test.branch.IfThenElseStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_out_ifThenElseXlang_eq_java__it__outX_name() {
    super.test_g_v1_out_ifThenElseXlang_eq_java__it__outX_name(g.v(1).out.ifThenElse({v: Vertex => val lang = v.getProperty("lang"); lang != null && lang.equals("java")}, {v: Vertex => v}, {v: Vertex => v.out}).property("name").asInstanceOf[Pipe[Vertex, String]]);
  }

}
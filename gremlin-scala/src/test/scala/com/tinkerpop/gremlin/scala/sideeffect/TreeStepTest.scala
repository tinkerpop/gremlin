package com.tinkerpop.gremlin.scala.sideeffect

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.util.structures.Tree

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class TreeStepTest extends com.tinkerpop.gremlin.test.sideeffect.TreeStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass);
  }

  def test_g_v1_out_out_treeXnameX_cap() {
    super.test_g_v1_out_out_treeXnameX_cap(g.v(1).out.out.tree {v: Vertex => v("name")}.cap.asInstanceOf[Pipe[Vertex, Tree[_]]]);
  }
}

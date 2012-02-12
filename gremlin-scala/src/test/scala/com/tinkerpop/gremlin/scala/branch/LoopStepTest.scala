package com.tinkerpop.gremlin.scala.branch

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.pipes.branch.LoopPipe.LoopBundle
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.blueprints.pgm.{Graph, Vertex}

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class LoopStepTest extends com.tinkerpop.gremlin.test.branch.LoopStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_out_loopX1_loops_lt_3X_propertyXnameX() {
    super.test_g_v1_out_loopX1_loops_lt_3X_propertyXnameX(g.v(1).out.loop(1, {lb: LoopBundle[Vertex] => lb.loops < 3}).property("name").asInstanceOf[Pipe[Vertex, String]]);
  }

  def test_g_v1_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX() {
    super.test_g_v1_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX(g.v(1).->.as("here").out.loop("here", {lb: LoopBundle[Vertex] => lb.loops < 3}).property("name").asInstanceOf[Pipe[Vertex, String]]);
  }

  def test_g_V_out_loopX1_loops_lt_3X_propertyXnameX() {
    super.test_g_V_out_loopX1_loops_lt_3X_propertyXnameX(g.V.out.loop(1, {lb: LoopBundle[Vertex] => lb.loops < 3}).property("name").asInstanceOf[Pipe[Graph, String]]);
  }

  def test_g_V_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX() {
    super.test_g_V_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX(g.V.as("here").out().loop("here", {lb: LoopBundle[Vertex] => lb.loops < 3}).property("name").asInstanceOf[Pipe[Graph, String]]);
  }


}
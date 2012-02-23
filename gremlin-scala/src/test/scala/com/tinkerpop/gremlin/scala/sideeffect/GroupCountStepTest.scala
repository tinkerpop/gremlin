package com.tinkerpop.gremlin.scala.sideeffect

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.blueprints.pgm.{Graph, Vertex}
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.util.structures.{Pair => TPair}

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class GroupCountStepTest extends com.tinkerpop.gremlin.test.sideeffect.GroupCountStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass);
  }

  def test_g_V_outXcreatedX_groupCountXm__nameX() {
    val m = new java.util.HashMap[String, Number]();
    super.test_g_V_outXcreatedX_groupCountXm__nameX(g.V.out("created").groupCount(m, {v: Vertex => v("name")}).asInstanceOf[Pipe[Graph, Vertex]], m);
  }

  // TODO: Why is the implicit converstion of a => to a PipeFunction not being respected?
  def test_g_V_outXcreatedX_groupCountXm__name__plus_2X() {
    val m = new java.util.HashMap[String, Number]();

    //this works but has ugly function call instead of implicit
    //val pipeline = g.V.out("created").groupCount(m, {v: Vertex => v("name")}, com.tinkerpop.gremlin.scala.functionToPipeFunction({p: TPair[_, Number] => (p.getB.longValue() + 2l).asInstanceOf[Number]})).asInstanceOf[Pipe[Graph, Vertex]]

    //attempting to get implicit working
    val pipeline = g.V.out("created").groupCount(m, {v: Vertex => v("name")}, {p: TPair[_, Number] => (p.getB.longValue() + 2l).asInstanceOf[Number]}).asInstanceOf[Pipe[Graph, Vertex]]

    super.test_g_V_outXcreatedX_groupCountXm__name__plus_2X(pipeline, m);
  }

  def test_g_V_outXcreatedX_groupCountXnameX_cap() {
    super.test_g_V_outXcreatedX_groupCountXnameX_cap(g.V.out("created").groupCount {v: Vertex => v("name")}.cap.asInstanceOf[Pipe[Graph, java.util.Map[String, Number]]]);
  }
}


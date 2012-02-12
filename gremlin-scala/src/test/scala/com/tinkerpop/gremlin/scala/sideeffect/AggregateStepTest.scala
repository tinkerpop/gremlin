package com.tinkerpop.gremlin.scala.sideeffect

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.scala._
import java.util.ArrayList
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.blueprints.pgm.{Vertex, Graph}

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class AggregateStepTest extends com.tinkerpop.gremlin.test.sideeffect.AggregateStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();


  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass);
  }

  def test_g_v1_aggregateXxX_outXcreatedX_inXcreatedX_exceptXxX() {
    val x = new ArrayList[Vertex]();
    super.test_g_v1_aggregateXxX_outXcreatedX_inXcreatedX_exceptXxX(g.v(1).->.aggregate(x).out("created").in("created").except(x))
  }

  def test_g_V_propertyXnameX_aggregate_cap() {
    super.test_g_V_propertyXnameX_aggregate_cap(g.V.property("name").aggregate().cap.asInstanceOf[Pipe[Graph, java.util.List[String]]]);
  }

  def test_g_V_aggregateXnameX_cap() {
    super.test_g_V_aggregateXnameX_cap(g.V.aggregate {v: Vertex => v("name")}.cap.asInstanceOf[Pipe[Graph, java.util.List[String]]]);
  }
}
package com.tinkerpop.gremlin.scala.filter

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.blueprints.pgm.Vertex
import java.util.{ArrayList, HashSet}
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.pipes.Pipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class ExceptStepTest extends com.tinkerpop.gremlin.test.filter.ExceptStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_out_exceptXg_v2X() {
    val x = new ArrayList[Vertex]();
    x.add(g.v(2));
    super.test_g_v1_out_exceptXg_v2X(g.v(1).out.except(x));
  }

  def test_g_v1_out_aggregateXxX_out_exceptXxX() {
    val x = new HashSet[Vertex]();
    super.test_g_v1_out_aggregateXxX_out_exceptXxX(g.v(1).out.aggregate(x).out.except(x));
  }

  def test_g_v1_outXcreatedX_inXcreatedX_exceptXg_v1X_propertyXnameX() {
    import scala.collection.JavaConversions._
    super.test_g_v1_outXcreatedX_inXcreatedX_exceptXg_v1X_propertyXnameX(g.v(1).out("created").in("created").except(List(g.v(1))).property("name").asInstanceOf[Pipe[Vertex, String]])
  }

}
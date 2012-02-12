package com.tinkerpop.gremlin.scala.sideeffect

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.blueprints.pgm.{Graph, Vertex}

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class StoreStepTest extends com.tinkerpop.gremlin.test.sideeffect.StoreStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass);
  }

  def test_g_V_propertyXnameX_store_cap() {
    super.test_g_V_propertyXnameX_store_cap(g.V.property("name").store().cap.asInstanceOf[Pipe[Graph, java.util.List[String]]]);
  }

  def test_g_V_storeXnameX_cap() {
    super.test_g_V_storeXnameX_cap(g.V.store {v: Vertex => v("name")}.cap.asInstanceOf[Pipe[Graph, java.util.List[String]]]);
  }
}
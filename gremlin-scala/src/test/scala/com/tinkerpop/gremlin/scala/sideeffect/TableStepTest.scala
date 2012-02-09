package com.tinkerpop.gremlin.scala.sideeffect

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.pipes.util.structures.Table
import com.tinkerpop.pipes.Pipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class TableStepTest extends com.tinkerpop.gremlin.test.sideeffect.TableStepTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass);
  }

  def test_g_v1_asXaX_out_properyXnameX_asXbX_table_cap() {
    super.test_g_v1_asXaX_out_properyXnameX_asXbX_table_cap(g.v(1).->.as("a").out.property("name").as("b").table.cap.asInstanceOf[Pipe[Vertex, Table]]);
  }

  def test_g_v1_asXaX_out_asXbX_tableXnameX_cap() {
    super.test_g_v1_asXaX_out_asXbX_tableXnameX_cap(g.v(1).->.as("a").out.as("b").table {v: Vertex => v("name")}.cap.asInstanceOf[Pipe[Vertex, Table]]);
  }

  def test_g_v1_asXaX_out_propertyXnameX_asXbX_tableXname_lengthX_cap() {
    super.test_g_v1_asXaX_out_propertyXnameX_asXbX_tableXname_lengthX_cap(g.v(1).->.as("a").out.property("name").as("b").table({v: Vertex => v("name")}, {s: String => s.length()}).cap.asInstanceOf[Pipe[Vertex, Table]]);
  }
}

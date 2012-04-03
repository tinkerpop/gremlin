package com.tinkerpop.gremlin.scala.branch

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.scala._
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.pipes.Pipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

class SplitMergeStepsTest extends com.tinkerpop.gremlin.test.branch.SplitMergeStepsTest {

  val g = TinkerGraphFactory.createTinkerGraph();

  override def testCompliance() {
    ComplianceTest.testCompliance(this.getClass)
  }

  def test_g_v1_out_copySplitXpropertyXnameX__propertyXageXX_fairMerge() {
    super.test_g_v1_out_copySplitXpropertyXnameX__propertyXageXX_fairMerge(g.v(1).out.copySplit(->[Vertex].property("name"), ->[Vertex].property("age")).fairMerge.asInstanceOf[Pipe[Vertex, Object]])
  }

  def test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge() {
    super.test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge(g.v(1).out("knows").copySplit(->[Vertex].property("name"), ->[Vertex].property("age")).exhaustMerge.asInstanceOf[Pipe[Vertex, Object]]);
  }

  def test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge_path() {
    super.test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge_path(g.v(1).out("knows").copySplit(->[Vertex].property("name"), ->[Vertex].property("age")).exhaustMerge.path);
  }
}
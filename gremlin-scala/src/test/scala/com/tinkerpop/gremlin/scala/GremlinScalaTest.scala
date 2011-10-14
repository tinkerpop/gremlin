package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import _root_.scala.collection.JavaConversions
import junit.framework.TestCase
import com.tinkerpop.gremlin.pipes.GremlinPipeline

class GremlinScalaTest extends TestCase {
  def testGremlin() {
    val g = TinkerGraphFactory.createTinkerGraph();
    val pipe = new GremlinPipeline[Vertex, Vertex];
    JavaConversions.asScalaIterator[Vertex](pipe.start(g.getVertex(1)).out("knows").asInstanceOf[java.util.Iterator[Vertex]]);
  }
}

package com.tinkerpop.gremlin

import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import _root_.scala.collection.JavaConversions
import junit.framework.TestCase
import pipes.GremlinFluentPipeline

class GremlinScalaTest extends TestCase {
  def testGremlin() {
    val g = TinkerGraphFactory.createTinkerGraph();
    val pipe = new GremlinFluentPipeline[Vertex, Vertex];
    JavaConversions.asScalaIterator[Vertex](pipe.start(g.getVertex(1)).out("knows").asInstanceOf[java.util.Iterator[Vertex]]);
  }
}

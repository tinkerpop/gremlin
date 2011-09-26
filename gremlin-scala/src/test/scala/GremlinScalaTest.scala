package com.tinkerpop.gremlin

import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.pipes.util.FluentPipeline
import _root_.scala.collection.JavaConversions
import junit.framework.TestCase

class GremlinScalaTest extends TestCase {
  def testGremlin() {
    val g = TinkerGraphFactory.createTinkerGraph();
    val pipe = new FluentPipeline[Vertex, Vertex];
    JavaConversions.asScalaIterator[Vertex](pipe.start(g.getVertex(1)).out("knows").asInstanceOf[java.util.Iterator[Vertex]]);
  }
}

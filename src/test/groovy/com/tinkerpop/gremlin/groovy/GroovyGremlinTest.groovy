package com.tinkerpop.gremlin.groovy

import junit.framework.TestCase
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.blueprints.pgm.Graph

class GroovyGremlinTest extends TestCase {

  public void testGremlinGroovy() {
    new GroovyGremlin();
    Graph g = TinkerGraphFactory.createTinkerGraph();


    g.v(1).outE['weight'].each{println it}
  }
}
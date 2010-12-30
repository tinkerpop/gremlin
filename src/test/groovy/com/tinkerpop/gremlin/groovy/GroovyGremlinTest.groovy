package com.tinkerpop.gremlin.groovy

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import junit.framework.TestCase
import com.tinkerpop.gremlin.groovy.Filters.F

class GroovyGremlinTest extends TestCase {

  public void testGremlinGroovy() {
    new GroovyGremlin();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    //g.v(1).outE[[label:'knows',weight:[F.gte,0.5f]]].inV.each{println it.name}

    //g.v(1).outE.and(prop('label',F.eq,'knows'), prop('weight',F.gte,0.0f)).inV.each{println it};

    g.v(1).step{return starts.next()}.each{}

    //g.v(1).outE{it.label == 'knows' & it.weight >= 0.5f}.inV.each{println it.name}

    //g.v(1).outE[[weight:[F.lt, 0.5f],label:'created']].each{println "${it.label} -- ${it.weight}"};
    //g.v(1).outE.and(i().inV[[name:'josh']].i{println it; return true}).inV.each{println it}
    //g.v(1).split(outE{true}, new IdentityPipe().outE.inV).i.each{println it}
    // | is or
  }

  public void testEmbeddedEngineBindingsGraph() throws Exception {
    new GroovyGremlin();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    String name = "josh";
    Vertex josh = g.v(4);
    assertEquals(g.v(1).outE.inV[[name:name]][0], josh);
    assertEquals(g.v(1).outE.inV[[id:'4']][0], josh);

    assertEquals(g.v(1).outE {it.label == 'knows' | it.label == 'created'}.inV {it.id == '4' & it.name == name}[0], josh);
    assertEquals(g.v(1).outE.orf(i()[[label:'knows']], i()[[label:'created']]).inV.andf(i()[[id:'4']], i()[[name:name]])[0], josh);
    assertEquals(g.v(1).outE.orf(propf('label',F.eq,'knows'), propf('label',F.eq, 'created')).inV.andf(propf('id',F.eq,'4'), propf('name',F.eq, name))[0], josh);


  }
}
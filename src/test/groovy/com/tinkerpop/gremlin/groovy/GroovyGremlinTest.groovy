package com.tinkerpop.gremlin.groovy

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import junit.framework.TestCase
import com.tinkerpop.gremlin.groovy.Filters.F
import com.tinkerpop.blueprints.pgm.parser.GraphMLReader
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph
import com.tinkerpop.pipes.PipeHelper
import com.tinkerpop.pipes.Pipe

class GroovyGremlinTest extends TestCase {

  public void testGremlinGroovy() {
    new GroovyGremlin();

    /*Graph g = new TinkerGraph();
    GraphMLReader.inputGraph(g, new FileInputStream("/Users/marko/software/gremlin/data/graph-example-2.xml"));
    g.v(89).outE[[label:'followed_by']].inV.outE[[label:'followed_by']].inV.outE[[label:'followed_by']].inV.each{}
    g.v(89).outE[[label:'followed_by']].inV.outE[[label:'followed_by']].inV.outE[[label:'followed_by']].inV.each{}
    
    long t = System.currentTimeMillis();
    int counter = PipeHelper.counter(g.v(89).outE[[label:'followed_by']].inV.outE[[label:'followed_by']].inV.outE[[label:'followed_by']].inV);
    t = System.currentTimeMillis() - t
    System.out.println(t + ":" + counter);*/

    Graph g = TinkerGraphFactory.createTinkerGraph();
    //[g.v(1),g.v(2)]["name"].each{println it}
    //GroovyGremlin.getSteps(Object.class).each{println it.name};
    //g.v(1).step{return starts.next()}.each{}
    //g.v(1).outE[label:'followed_by',weight:0.5].each{println it}
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
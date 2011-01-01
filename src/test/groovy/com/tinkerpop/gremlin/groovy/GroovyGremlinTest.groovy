package com.tinkerpop.gremlin.groovy

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Filters.F
import com.tinkerpop.pipes.PipeHelper
import junit.framework.TestCase

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
    //g.v(1).outE._(i()[[label:'created']] & (i()[[label:'blah']] | i()[[label:'knows']])).each{println it}
    //[g.v(1),g.v(2)]["name"].each{println it}
    //GroovyGremlin.getSteps(Object.class).each{println it.name};
    //g.v(1).step{return starts.next()}.each{}
    //g.v(1).outE[label:'followed_by',weight:0.5].each{println it}
    //g.v(1).outE{it.label == 'knows' & it.weight >= 0.5f}.inV.each{println it.name}

    //g.v(1).outE[[weight:[F.lt, 0.5f],label:'created']].each{println "${it.label} -- ${it.weight}"};
    //g.v(1).outE.and(i().inV[[name:'josh']].i{println it; return true}).inV.each{println it}
    //g.v(1).split(outE{true}, new IdentityPipe().outE.inV).i.each{println it}
    // | is or
    def name = "jen";
    g.v(1).outE().inV.paths.step {name = starts.next()[2]}.each {println it}
    println name
    //x.enablePath();
    //x.each{println x.path}
  }

  public void testEmbeddedEngineBindingsGraph() throws Exception {
    new GroovyGremlin();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    String name = "josh";
    Vertex josh = g.v(4);
    assertEquals(g.v(1).outE.inV[[name: name]][0], josh);
    assertEquals(g.v(1).outE.inV[[id: '4']][0], josh);

    assertEquals(g.v(1).outE {it.label == 'knows' | it.label == 'created'}.inV {it.id == '4' & it.name == name}[0], josh);
    assertEquals(g.v(1).outE._(i()[[label: 'knows']] | i()[[label: 'created']]).inV._(i()[[id: '4']] & i()[[name: name]])[0], josh);
    assertEquals(g.v(1).outE._(propf('label', F.eq, 'knows') | propf('label', F.eq, 'created')).inV._(propf('id', F.eq, '4') & propf('name', F.eq, name))[0], josh);
  }

  public void testSideEffects() throws Exception {
    new GroovyGremlin();
    def x = 0;
    [1, 2, 3].step {x = starts.next()}.each {}
    assertEquals(x, 3);
  }

  public void testBasicGraphStatements() throws Exception {
    new GroovyGremlin();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(PipeHelper.counter(g.v(1).outE.inV), 3);
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[0].name));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[1].name));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[2].name));

    assertEquals(PipeHelper.counter(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV), 3);
    assertEquals(PipeHelper.counter(g.v(1).outE._(i()[[label: 'created']] | i()[[label: 'knows']]).inV), 3);
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[0].name));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[1].name));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[2].name));

    assertEquals(g.v(1).outE[[label: 'created']].inV['name'][0], "lop");
    assertEquals(PipeHelper.counter(g.v(1).outE[[label: 'knows']].inV), 2);
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[label: 'knows']].inV[0].name));
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[label: 'knows']].inV[1].name));

    assertEquals(PipeHelper.counter(g.v(1).outE[[weight: [F.gte, 0.5f]]].inV.i.i.i), 2);
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[weight: [F.gte, 0.5f]]].inV.i.i.i[0].name));
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[weight: [F.gte, 0.5f]]].inV.i.i.i[1].name));

    assertEquals(PipeHelper.counter(g.v(1).outE {it.weight >= g.v(1).outE['weight'][0]}.inV), 2);
    assertTrue(["vadas", "josh"].contains(g.v(1).outE {it.weight >= g.v(1).outE['weight'][0]}.inV[0].name));
    assertTrue(["vadas", "josh"].contains(g.v(1).outE {it.weight >= g.v(1).outE['weight'][0]}.inV[1].name));

    assertEquals(PipeHelper.counter(g.v(1).inE), 0);
    assertEquals(PipeHelper.counter(g.v(1).outE.inV[[blah: [F.neq, null]]]), 0)
    assertEquals(PipeHelper.counter(g.v(1).outE.inV[[blah: null]]), 3)

  }

  public void testFutureFilterOnGraph() throws Exception {
    new GroovyGremlin();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(g.v(1)._(~outE().inV).name.next(), "marko");
    assertEquals(g.v(1).outE.inV._(~outE().inV[[name: 'lop']]).name.next(), "josh");
    assertEquals(g.v(1).outE.inV._(~outE().inV[[name: 'ripple']]).name.next(), "josh");
    assertEquals(g.v(1).outE._(~inV()[[name: 'lop']]).id.next(), "9");

    def list = ["ripple", "lop", "blah"]
    assertEquals(PipeHelper.counter(g.v(1).outE.inV._(~outE().inV {list.contains(it.name)}).outE.inV), 2);
    assertTrue(["ripple", "lop"].contains(g.v(1).outE.inV._(~outE().inV {list.contains(it.name)}).outE.inV[0].name));
    assertTrue(["ripple", "lop"].contains(g.v(1).outE.inV._(~outE().inV {list.contains(it.name)}).outE.inV[1].name));
  }
}
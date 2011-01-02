package com.tinkerpop.gremlin.groovy

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Filters.F
import com.tinkerpop.pipes.Pipe
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
    def name = "jen";
    g.v(1).outE().inV.paths.step {name = starts.next()[2]}.each {println it}
    println name

    Pipe pipe = GroovyGremlin.compile("outE().inV.name.gather");
    pipe.setStarts(g.v(1).iterator());
    def list = [];
    pipe >> list;
    println list;
  }

  public void testPipelineVariations() throws Exception {
    new GroovyGremlin();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    String name = "josh";
    Vertex josh = g.v(4);
    assertEquals(g.v(1).outE.inV[[name: name]].next(), josh);
    assertEquals(g.v(1).outE.inV[[id: '4']].next(), josh);

    assertEquals(g.v(1).outE {it.label == 'knows' | it.label == 'created'}.inV {it.id == '4' & it.name == name}.next(), josh);
    assertEquals(g.v(1).outE._(i()[[label: 'knows']] | i()[[label: 'created']]).inV._(i()[[id: '4']] & i()[[name: name]]).next(), josh);
    assertEquals(g.v(1).outE._(propf('label', F.eq, 'knows') | propf('label', F.eq, 'created')).inV._(propf('id', F.eq, '4') & propf('name', F.eq, name)).next(), josh);
  }

  public void testSideEffects() throws Exception {
    new GroovyGremlin();
    def x = 0;
    [1, 2, 3].step {x = starts.next()}.each {}
    assertEquals(x, 3);
    [3, 2, 1].step {x = starts.next()}.each {}
    assertEquals(x, 1);
  }

  public void testBasicGraphStatements() throws Exception {
    new GroovyGremlin();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(PipeHelper.counter(g.v(1).outE.inV), 3);
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[0].name >> 1));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[1].name >> 1));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[2].name >> 1));

    assertEquals(PipeHelper.counter(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV), 3);
    assertEquals(PipeHelper.counter(g.v(1).outE._(i()[[label: 'created']] | i()[[label: 'knows']]).inV), 3);
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[0].name >> 1));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[1].name >> 1));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[2].name >> 1));

    assertEquals(g.v(1).outE[[label: 'created']].inV['name'][0].next(), "lop");
    assertEquals(PipeHelper.counter(g.v(1).outE[[label: 'knows']].inV), 2);
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[label: 'knows']].inV[0].name >> 1));
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[label: 'knows']].inV[1].name >> 1));

    assertEquals(PipeHelper.counter(g.v(1).outE[[weight: [F.gte, 0.5f]]].inV.i.i.i), 2);
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[weight: [F.gte, 0.5f]]].inV.i.i.i[0].name >> 1));
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[weight: [F.gte, 0.5f]]].inV.i.i.i[1].name >> 1));

    assertEquals(PipeHelper.counter(g.v(1).outE {it.weight >= g.v(1).outE['weight'][0] >> 1}.inV), 2);
    assertTrue(["vadas", "josh"].contains(g.v(1).outE {it.weight >= g.v(1).outE['weight'][0] >> 1}.inV[0].name >> 1));
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[weight: [F.gte, g.v(1).outE['weight'][0] >> 1]]].inV[1].name >> 1));

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
    assertTrue(["ripple", "lop"].contains(g.v(1).outE.inV._(~outE().inV {list.contains(it.name)}).outE.inV[0].name >> 1));
    assertTrue(["ripple", "lop"].contains(g.v(1).outE.inV._(~outE().inV {list.contains(it.name)}).outE.inV[1].name >> 1));
  }

  public void testIdAndLabelProperties() throws Exception {
    new GroovyGremlin();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(g.v(1).id, "1");
    assertEquals(g.v(1)['id'], "1");

    assertEquals(PipeHelper.counter(g.v(1).outE.inV.id), 3);
    assertTrue(["2", "3", "4"].contains(g.v(1).outE.inV.id[0] >> 1));
    assertTrue(["2", "3", "4"].contains(g.v(1).outE.inV.id[1] >> 1));
    assertTrue(["2", "3", "4"].contains(g.v(1).outE.inV.id[2] >> 1));

    assertEquals(PipeHelper.counter(g.v(1).outE.label), 3);
    assertTrue(["created", "knows"].contains(g.v(1).outE.label[0] >> 1));
    assertTrue(["created", "knows"].contains(g.v(1).outE.label[1] >> 1));
    assertTrue(["created", "knows"].contains(g.v(1).outE.label[2] >> 1));
  }

  public void testVertexEdgeGraphProperties() throws Exception {
    new GroovyGremlin();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(PipeHelper.counter(g.V), 6);
    assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V['id'][0] >> 1));
    assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V.id[1] >> 1));
    assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V['id'][2] >> 1));
    assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V.id[3] >> 1));
    assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V['id'][4] >> 1));
    assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V.id[5] >> 1));

    assertEquals(PipeHelper.counter(g.E), 6);
    assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E['id'][0] >> 1));
    assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E.id[1] >> 1));
    assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E['id'][2] >> 1));
    assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E.id[3] >> 1));
    assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E['id'][4] >> 1));
    assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E.id[5] >> 1));
  }

  public void testPathEquality() throws Exception {
    new GroovyGremlin();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(g.v(1).outE.inV, g.v(1).outE.inV);
    assertEquals(g.v(1).i.outE.i.i.inV[0..100], g.v(1).i.outE.inV.i.i);
    assertEquals(g.v(1).inE, g.v(1).inE);
  }
}
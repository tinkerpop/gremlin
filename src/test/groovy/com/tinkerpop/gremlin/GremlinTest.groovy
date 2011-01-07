package com.tinkerpop.gremlin

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.GremlinTokens.T
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.PipeHelper
import junit.framework.TestCase

class GremlinTest extends TestCase {

  public void testGremlinGroovy() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    println g.v(1).outE
    //[g.v(1), g.v(2)]._.outE.each {println it}
    //g.idx('vertices')[[name:'marko']].outE.inV.each{println it}
//    def m = g.v(1).outE.inV.outE.inV.group_count >> 1
    //  println m
  }

  public void testCompilation() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    // test imports
    Gremlin.compile("new IdentityPipe()");

    // test compilation
    Pipe pipe = Gremlin.compile("_.outE.inV.name");
    pipe.setStarts(g.v(1).iterator());
    (pipe >> 3).each {assertTrue(it.equals("josh") || it.equals("lop") || it.equals("vadas"))}
    assertFalse(pipe.hasNext());
  }

  public void testPipelineVariations() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    String name = "josh";
    Vertex josh = g.v(4);
    assertEquals(g.v(1).outE.inV[[name: name]].next(), josh);
    assertEquals(g.v(1).outE.inV[[id: '4']].next(), josh);

    assertEquals(g.v(1).outE {it.label == 'knows' | it.label == 'created'}.inV {it.id == '4' & it.name == name}.next(), josh);
    assertEquals(g.v(1).outE.orf(_()[[label: 'knows']], _()[[label: 'created']]).inV.andf(_()[[id: '4']], _()[[name: name]]) >> 1, josh);
    assertEquals(g.v(1).outE.orf(_().propf('label', T.eq, 'knows'), _().propf('label', T.eq, 'created')).inV.andf(_().propf('id', T.eq, '4'), _().propf('name', T.eq, name)).next(), josh);
  }

  public void testSideEffects() throws Exception {
    Gremlin.load();

    def x = 0;
    [1, 2, 3].step {x = starts.next()} >> -1
    assertEquals(x, 3);
    [3, 2, 1].step {x = starts.next()} >> -1
    assertEquals(x, 1);
  }

  public void testBasicGraphStatements() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(PipeHelper.counter(g.v(1).outE.inV), 3);
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[0].name >> 1));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[1].name >> 1));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[2].name >> 1));

    assertEquals(PipeHelper.counter(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV), 3);
    assertEquals(PipeHelper.counter(g.v(1).outE.orf(_()[[label: 'created']], _()[[label: 'knows']]).inV), 3);
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[0].name >> 1));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[1].name >> 1));
    assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[2].name >> 1));

    assertEquals(g.v(1).outE[[label: 'created']].inV['name'][0].next(), "lop");
    assertEquals(PipeHelper.counter(g.v(1).outE[[label: 'knows']].inV), 2);
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[label: 'knows']].inV[0].name >> 1));
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[label: 'knows']].inV[1].name >> 1));

    assertEquals(PipeHelper.counter(g.v(1).outE[[weight: [T.gte, 0.5f]]].inV), 2);
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[weight: [T.gte, 0.5f]]].inV[0].name >> 1));
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[weight: [T.gte, 0.5f]]].inV[1].name >> 1));

    assertEquals(PipeHelper.counter(g.v(1).outE {it.weight >= g.v(1).outE['weight'][0] >> 1}.inV), 2);
    assertTrue(["vadas", "josh"].contains(g.v(1).outE {it.weight >= g.v(1).outE['weight'][0] >> 1}.inV[0].name >> 1));
    assertTrue(["vadas", "josh"].contains(g.v(1).outE[[weight: [T.gte, g.v(1).outE['weight'][0] >> 1]]].inV[1].name >> 1));

    assertEquals(PipeHelper.counter(g.v(1).inE), 0);
    assertEquals(PipeHelper.counter(g.v(1).outE.inV[[blah: [T.neq, null]]]), 0)
    assertEquals(PipeHelper.counter(g.v(1).outE.inV[[blah: null]]), 3)

  }

  public void testFutureFilterOnGraph() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(g.v(1)._().futuref(_().outE.inV).name.next(), "marko");
    assertEquals(g.v(1).outE.inV.futuref(_().outE.inV[[name: 'lop']]).name.next(), "josh");
    assertEquals(g.v(1).outE.inV.futuref(_().outE.inV[[name: 'ripple']]).name.next(), "josh");
    assertEquals(g.v(1).outE.futuref(_().inV[[name: 'lop']]).id.next(), "9");

    def list = ["ripple", "lop", "blah"]
    assertEquals(PipeHelper.counter(g.v(1).outE.inV.futuref(_().outE.inV {list.contains(it.name)}).outE.inV), 2);
    assertTrue(["ripple", "lop"].contains(g.v(1).outE.inV.futuref(_().outE.inV {list.contains(it.name)}).outE.inV[0].name >> 1));
    assertTrue(["ripple", "lop"].contains(g.v(1).outE.inV.futuref(_().outE.inV {list.contains(it.name)}).outE.inV[1].name >> 1));
  }

  public void testIdAndLabelProperties() throws Exception {
    Gremlin.load();
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

  public void testVertexEdgeShortcuts() throws Exception {
    Gremlin.load();
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

  public void testIndexShortcuts() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals((g.idx(T.v)[[name: 'marko']] as List)[0], g.v(1));
    assertEquals(g.idx(T.e)[[label: 'created']].size(), 4);
  }

  public void testExceptPattern() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    def x = []
    def results = [];
    g.v(1).outE.inV {x << it}.outE.inV {!x.contains(it)} >> results
    assertEquals(results.size(), 1);
    assertEquals(results.get(0), g.v(5));
  }

  public void testPipelineEquality() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(g.v(1).outE.inV, g.v(1).outE.inV);
    assertEquals(g.v(1)._.outE._._.inV[0..100], g.v(1)._.outE.inV._._);
    assertEquals(g.v(1).inE, g.v(1).inE);
  }

  public void testStepCreation() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    def c = { _{def x = it}.outE[[label:'created']].inV.inE[[label:'created']].outV{ x != it} }
    [Iterable,Iterator,Vertex].each{it.metaClass.co_developer = { Gremlin.compose(delegate, c()) }}

    def list = []
    g.v(1).co_developer >> list
    assertTrue(list.contains(g.v(4)));
    assertTrue(list.contains(g.v(6)));

  }
}
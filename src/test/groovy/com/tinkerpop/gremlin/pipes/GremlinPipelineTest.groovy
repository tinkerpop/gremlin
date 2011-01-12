package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens.T
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GremlinPipelineTest extends TestCase {

  public void testPipelineEquality() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    assertEquals(g.v(1).outE.inV, g.v(1).outE.inV);
    assertEquals(g.v(1)._.outE._._.inV[0..100], g.v(1)._.outE.inV._._);
    assertEquals(g.v(1).inE, g.v(1).inE);
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

  public void testPipelineToString() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    println g.v(1).outE.inV.outE.inV
    println g.V.outE[[label: 'knows']].inV
  }
}

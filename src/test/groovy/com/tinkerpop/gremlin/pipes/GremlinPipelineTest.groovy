package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.BaseTest
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens.T

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GremlinPipelineTest extends BaseTest {

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


  public void testEmbeddedPipeTimings() throws Exception {
    Gremlin.load();
    Graph g = new TinkerGraph()
    (1..1000).each {
      def v = g.addVertex(null);
      g.addEdge(null, v, g.v(0), "knows");
    }
    g.V >> -1
    g.V >> -1

    this.stopWatch();
    g.V >> -1
    printPerformance("Non-embedded pipeline evaulation", 0, "steps", this.stopWatch())
    this.stopWatch();
    g.V.step {s()} >> -1
    printPerformance("Embedded pipeline evaulation", 0, "steps", this.stopWatch())
    println()

    this.stopWatch();
    g.V._ >> -1
    printPerformance("Non-embedded pipeline evaulation", 1, "steps", this.stopWatch())
    this.stopWatch();
    g.V.step {s()._ >> 1} >> -1
    printPerformance("Embedded pipeline evaulation", 1, "steps", this.stopWatch())
    println()

    this.stopWatch();
    g.V._._ >> -1
    printPerformance("Non-embedded pipeline evaulation", 2, "steps", this.stopWatch())
    this.stopWatch();
    g.V.step {s()._._ >> 1} >> -1
    printPerformance("Embedded pipeline evaulation", 2, "steps", this.stopWatch())
    println()

    this.stopWatch();
    g.V._._._ >> -1
    printPerformance("Non-embedded pipeline evaulation", 3, "steps", this.stopWatch())
    this.stopWatch();
    g.V.step {s()._._._ >> 1} >> -1
    printPerformance("Embedded pipeline evaulation", 3, "steps", this.stopWatch())
  }

}

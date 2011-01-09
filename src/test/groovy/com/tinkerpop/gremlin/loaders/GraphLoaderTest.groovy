package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens.T
import com.tinkerpop.pipes.PipeHelper
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GraphLoaderTest extends TestCase {
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

}

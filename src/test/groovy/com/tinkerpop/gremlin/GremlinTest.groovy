package com.tinkerpop.gremlin

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

class GremlinTest extends TestCase {

  public void testGremlinGroovy() {
    assertTrue(true);
    /*Gremlin.load();
    def g = new Neo4jGraph('/tmp/neo4jtest')
    g.idx(T.v)[[name: 'DARK STAR']].outE.each{println it}
    g.shutdown();*/
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

  public void testMidPipeVariableSetting() throws Exception {
    Gremlin.load();

    def x = 0;
    [1, 2, 3].step {x = starts.next()} >> -1
    assertEquals(x, 3);
    [3, 2, 1].step {x = starts.next()} >> -1
    assertEquals(x, 1);
  }


  public void testMissingMethods() {
    Gremlin.load();
    Set tokens = Gremlin.getMissingMethods(TinkerGraph.class);
    assertTrue(tokens.contains("V"))
    assertTrue(tokens.contains("v"))
    assertTrue(tokens.contains("E"))
    assertTrue(tokens.contains("e"))
    assertTrue(tokens.contains("_"))
  }
}
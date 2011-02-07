package com.tinkerpop.gremlin

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

class GremlinTest extends TestCase {

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


  public void testGetMissingMethods() {
    Gremlin.load();
    Set tokens = Gremlin.getExistingMethods(TinkerGraph.class);
    assertTrue(tokens.contains("V"))
    assertTrue(tokens.contains("v"))
    assertTrue(tokens.contains("E"))
    assertTrue(tokens.contains("e"))
    assertTrue(tokens.contains("_"))
  }

  public void testIsMissingMethod() {
    Gremlin.load();
    assertTrue(Gremlin.isExistingMethod(TinkerGraph.class, "V"))
    assertTrue(Gremlin.isExistingMethod(TinkerGraph.class, "v"))
    assertTrue(Gremlin.isExistingMethod(TinkerGraph.class, "E"))
    assertTrue(Gremlin.isExistingMethod(TinkerGraph.class, "e"))
    assertTrue(Gremlin.isExistingMethod(TinkerGraph.class, "_"))
  }

  public void testUserDefinedSteps() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    Gremlin.addStep("co_developer")
    [Iterable, Iterator, Vertex].each {
      def c = { def x; _ {x = it}.outE[[label: 'created']].inV.inE[[label: 'created']].outV {it != x} }
      it.metaClass.co_developer = { Gremlin.compose(delegate, c())}
    }
    def results = []
    g.v(1).co_developer >> results
    assertEquals(results.size(), 2);
    assertTrue(results.contains(g.v(4)));
    assertTrue(results.contains(g.v(6)));
  }

  public void testNothing() {
    Gremlin.load()
    Graph g = TinkerGraphFactory.createTinkerGraph()
    g.v(1)._.outE.each {println it}
  }
}
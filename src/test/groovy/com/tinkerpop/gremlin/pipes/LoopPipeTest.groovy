package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class LoopPipeTest extends TestCase {

  public void testSubPathLoop() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    def counter = 0;
    g.V[['name': 'marko']].back(1).outE.inV.loop(2, {it.object.name != 'ripple'}).each {counter++; assertEquals(it, g.v(5))}
    assertEquals(counter, 1);

    counter = 0;
    g.V[['name': 'marko']].back(1).outE.inV.loop(2) {it.object.name != 'ripple'}.each {counter++; assertEquals(it, g.v(5))}
    assertEquals(counter, 1);
  }

  public void testPathsInLoop() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    def results = []
    def loops = 0;
    g.v(1).outE.inV.loop(2) {assertTrue(it.loops >= loops); loops = it.loops; it.object != g.v(5)}.paths >> results
    results = results[0];
    assertEquals(results[0], g.v(1));
    assertEquals(results[1], g.e(8));
    assertEquals(results[2], g.v(4));
    assertEquals(results[3], g.e(10));
    assertEquals(results[4], g.v(5));
    //println results;
  }

  public void testLoopAndUnrolledEquality() {
    Gremlin.load();
    Graph g = new TinkerGraph();
    def a = g.addVertex(1)
    def b = g.addVertex(2)
    def c = g.addVertex(3)
    g.addEdge(null, a, b, 'knows1');
    g.addEdge(null, a, c, 'knows2');
    g.addEdge(null, c, a, 'knows3');
    g.addEdge(null, b, c, 'knows4');
    assertEquals(g.v(1).outE.inV.loop(2) {it.loops < 5}, g.v(1).outE.inV.outE.inV.outE.inV.outE.inV)


  }


}

package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class LoopPipeTest extends TestCase {

  /*public void testLoopPipe() {
    Pipe pipe = new LoopPipe(new IncrPipe(), { it < 10 });
    pipe.setStarts([1, 2, 3].iterator());
    int counter = 0;
    while (pipe.hasNext()) {
      counter++;
      assertEquals(pipe.next(), 10);
    }
    assertEquals(counter, 3);
  }*/

  public void testFullLoop() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    int counter = 0;
    g.v(1).outE.inV.loop {it.name != 'ripple'}.each {counter++; assertEquals(it, g.v(5))}
    assertEquals(counter, 1);
  }

  public void testSubPathLoop() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    def counter = 0;
    g.V[['name': 'marko']].back(1).outE.inV.loop(2, {it.name != 'ripple'}).each {counter++; assertEquals(it, g.v(5))}
    assertEquals(counter, 1);

    counter = 0;
    g.V[['name': 'marko']].back(1).outE.inV.loop(2) {it.name != 'ripple'}.each {counter++; assertEquals(it, g.v(5))}
    assertEquals(counter, 1);
  }

  public void testPathsInLoop() {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();
    def results = []
    def loops = 0;
    g.v(1).outE.inV.loop(2) {assertTrue(delegate.loops >= loops); loops = delegate.loops; it != g.v(5)}.paths >> results
    results = results[0];
    assertEquals(results[0], g.v(1));
    assertEquals(results[1], g.e(8));
    assertEquals(results[2], g.v(4));
    assertEquals(results[3], g.e(10));
    assertEquals(results[4], g.v(5));
    println results;
  }


}

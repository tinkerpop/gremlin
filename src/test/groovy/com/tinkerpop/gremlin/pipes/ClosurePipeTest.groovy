package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ClosurePipeTest extends TestCase {

  public void testStepCreation() throws Exception {
    Gremlin.load();
    Graph g = TinkerGraphFactory.createTinkerGraph();

    def c = { _ {def x = it}.outE[[label: 'created']].inV.inE[[label: 'created']].outV { x != it} }
    [Iterable, Iterator, Vertex].each {it.metaClass.co_developer = { Gremlin.compose(delegate, c()) }}

    def list = []
    g.v(1).co_developer >> list
    assertTrue(list.contains(g.v(4)));
    assertTrue(list.contains(g.v(6)));
  }
}

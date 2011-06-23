package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ClosurePipeTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.V.step {true} instanceof Pipe)
    }

    public void testStepCreation() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        Gremlin.addStep('co_developer')
        [Pipe, Vertex].each {
            def c = { _ {def x = it}.outE[[label: 'created']].inV.inE[[label: 'created']].outV { x != it} }
            it.metaClass.co_developer = { Gremlin.compose(delegate, c()) }
        }

        def list = []
        g.v(1).co_developer >> list
        assertTrue(list.contains(g.v(4)));
        assertTrue(list.contains(g.v(6)));
    }

    public void testSMethod() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def results = [];
        g.v(1).outE.inV.step {s().name} >> results
        assertTrue(results.contains("josh"))
        assertTrue(results.contains("lop"))
        assertTrue(results.contains("vadas"))
        assertEquals(results.size(), 3)
    }
}

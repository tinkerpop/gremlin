package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PathClosurePipeTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.v(1).outE.paths {it.name} {it.weight} instanceof Pipe)
    }

    public void testPathClosurePipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def results = [];
        g.v(1).outE.paths {it.name} {it.weight} >> results;
        assertEquals(results.size(), 3);
        assertEquals(results.get(0).get(0), "marko");
        assertEquals(results.get(1).get(0), "marko");
        assertEquals(results.get(2).get(0), "marko");

        results.clear();
        g.v(1).outE.paths {it.id} >> results;
        assertEquals(results.size(), 3);
        assertEquals(results.get(0).get(0), "1");
        assertEquals(results.get(1).get(0), "1");
        assertEquals(results.get(2).get(0), "1");
        assertTrue((results.get(0).get(1) as Integer) > 6);
        assertTrue((results.get(1).get(1) as Integer) > 6);
        assertTrue((results.get(2).get(1) as Integer) > 6);

    }

    public void testPathClosurePipeWithLooping() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def results = [];
        g.v(1).as('x').outE.inV.loop('x'){it.loops < 3}.paths{it.name}{it.weight} >> results;
        assertEquals(results.size(), 2);

        assertEquals(results.get(0).size(), 5);
        assertEquals(results.get(1).size(), 5);

        assertEquals(results.get(0).get(0), "marko");
        assertEquals(results.get(1).get(0), "marko");
        assertEquals(results.get(0).get(2), "josh");
        assertEquals(results.get(1).get(2), "josh");

    }
}

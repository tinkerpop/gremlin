package com.tinkerpop.gremlin.groovy.steps

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class AsStepTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.V.as('x') instanceof Pipe)
    }

    public void testAsPipeWithPaths() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def results = []
        g.v(1).as('1').out.as('2').paths >> results;
        assertEquals(results.get(0).get(0), g.v(1));
        assertEquals(results.get(0).get(1), g.v(2));
        assertEquals(results.get(1).get(0), g.v(1));
        assertEquals(results.get(1).get(1), g.v(3));

        g.v(1).out.as('2').paths >> results;
        assertEquals(results.get(0).get(0), g.v(1));
        assertEquals(results.get(0).get(1), g.v(2));
        assertEquals(results.get(1).get(0), g.v(1));
        assertEquals(results.get(1).get(1), g.v(3));


    }
}


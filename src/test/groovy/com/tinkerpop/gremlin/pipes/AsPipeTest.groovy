package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class AsPipeTest extends TestCase {

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


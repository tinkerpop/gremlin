package com.tinkerpop.gremlin.steps

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class IfThenElseStepTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.V.ifThenElse {} {} {} instanceof Pipe)
        assertTrue(g.V.ifThenElse {} {} instanceof Pipe)
    }

    public void testIfThenElsePipe() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        assertEquals(29, g.v(1)._.ifThenElse {it.name == 'marko'} {it.age} {it.name} >> 1)
        assertEquals("marko", g.v(1)._.ifThenElse {it.name == 'josh'} {it.age} {it.name} >> 1)
        assertEquals("josh", g.v(1).outE[[label: 'knows']].ifThenElse {it.weight > 0.5} {it.inV.name >> 1} >> 1)

        assertEquals(['vadas', 'josh'], g.v(1)._.ifThenElse {it.name == 'marko'} {it.out('knows')} {it.out('created')}.name >> [])
        assertEquals(['vadas', 'josh', 'lop', 'ripple', 'lop'], g.V._.ifThenElse {it.name == 'marko'} {it.out('knows')} {it.out('created')}.name >> [])
    }
}

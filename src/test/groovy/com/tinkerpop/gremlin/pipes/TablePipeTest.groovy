package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.pipes.util.Table
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class TablePipeTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        Table t = new Table();
        assertTrue((g.V.table(t, [1, 2, 3])) instanceof Pipe)
    }

    public void testBehavior() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        Table t = new Table();
        g.v(1).out.out.table(t, [0, 2]) >> -1;
        assertEquals(t.get(0, 0), g.v(1));
        assertEquals(t.get(0, 1), g.v(5));
        assertEquals(t.get(1, 0), g.v(1));
        assertEquals(t.get(1, 1), g.v(3));

        t = new Table();
        g.v(1).out.out.table(t, [0, 2], {it.name}, {it.name}) >> -1
        assertEquals(t.get(0, 0), "marko");
        assertEquals(t.get(0, 1), "ripple");
        assertEquals(t.get(1, 0), "marko");
        assertEquals(t.get(1, 1), "lop");

        t.clear()
        g.v(1).out.out.table(t, [0, 2]) {it.name} {it.name} >> -1
        assertEquals(t.get(0, 0), "marko");
        assertEquals(t.get(0, 1), "ripple");
        assertEquals(t.get(1, 0), "marko");
        assertEquals(t.get(1, 1), "lop");

        try {
            t.clear()
            g.v(1).out.out.table(t, [0, 3]) {it.name} >> -1
            assertTrue(false);
        } catch (RuntimeException e) {
            assertTrue(true);
        }

        t.clear()
        g.v(1).out.out.table(t) >> -1
        assertEquals(t.getColumnCount(), 3);
        assertEquals(t.getRowCount(), 2);
        assertTrue(t.get(0, 2) instanceof Vertex);

        t.clear()
        g.v(1).out.out.table(t) {it.name} {it.name} {it.name} >> -1
        assertEquals(t.getColumnCount(), 3);
        assertEquals(t.getRowCount(), 2);
        assertTrue(t.get(0, 2) instanceof String);


    }
}

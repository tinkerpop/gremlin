package com.tinkerpop.gremlin.pipes

import com.tinkerpop.blueprints.pgm.Graph
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
        assertTrue((g.V.table(t)) instanceof Pipe)
    }

    public void testTablePipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        Table t = new Table();
        g.v(1).as('1').out.as('2').out.as('3').table(t) >> -1;
        assertEquals(t.get(0, 0), g.v(1));
        assertEquals(t.get(0, 1), g.v(4));
        assertEquals(t.get(0, 2), g.v(5));
        assertEquals(t.get(1, 0), g.v(1));
        assertEquals(t.get(1, 1), g.v(4));
        assertEquals(t.get(1, 2), g.v(3));
        assertEquals(t.getColumnCount(), 3);
        assertEquals(t.getRowCount(), 2);

        t = new Table();
        g.v(1).as('1').out.out.as('2').table(t, {it.name}, {it.name}) >> -1
        assertEquals(t.get(0, '1'), "marko");
        assertEquals(t.get(0, '2'), "ripple");
        assertEquals(t.get(1, '1'), "marko");
        assertEquals(t.get(1, '2'), "lop");
        assertEquals(t.getColumnCount(), 2);
        assertEquals(t.getRowCount(), 2);

        t.clear()
        g.v(1).as('1').out.out.as('2').table(t) {it.name} {it.name} >> -1
        assertEquals(t.get(0, 0), "marko");
        assertEquals(t.get(0, 1), "ripple");
        assertEquals(t.get(1, 0), "marko");
        assertEquals(t.get(1, 1), "lop");
        assertEquals(t.getColumnCount(), 2);
        assertEquals(t.getRowCount(), 2);


    }

    public void testTablePipeWithMetaPipes() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        Table t = new Table();
        g.v(1).as('1').out.name.as('2').back(1).out.as('3').table(t) >> -1
        assertEquals(t.get(0, 0), g.v(1));
        assertEquals(t.get(0, 1), 'josh');
        assertEquals(t.get(0, 2), g.v(5));
        assertEquals(t.get(1, 0), g.v(1));
        assertEquals(t.get(1, 1), 'josh');
        assertEquals(t.get(1, 2), g.v(3));
        assertEquals(t.getColumnCount(), 3);
        assertEquals(t.getRowCount(), 2);

        t.clear();
        g.v(1).as('1').out.name.as('2').back(1).out.as('3').table(t) {it} {it.substring(0, 1)} {it.name} >> -1
        assertEquals(t.get(0, 0), g.v(1));
        assertEquals(t.get(0, 1), 'j');
        assertEquals(t.get(0, 2), 'ripple');
        assertEquals(t.get(1, 0), g.v(1));
        assertEquals(t.get(1, 1), 'j');
        assertEquals(t.get(1, 2), 'lop');
        assertEquals(t.getColumnCount(), 3);
        assertEquals(t.getRowCount(), 2);
    }

    public void testTablePipeWithLoop() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        Table t = new Table();
        g.v(1).as('1').out.loop(1) {it.loops < 3}.as('2').table(t) >> -1
        assertEquals(t.get(0, 0), g.v(1));
        assertEquals(t.get(0, 1), g.v(5));
        assertEquals(t.get(1, 0), g.v(1));
        assertEquals(t.get(1, 1), g.v(3));
        assertEquals(t.getColumnCount(), 2);
        assertEquals(t.getRowCount(), 2);

        t = new Table();
        g.v(1).as('1').out.loop(1) {it.loops < 3}._._._._.as('2').table(t) >> -1
        assertEquals(t.get(0, 0), g.v(1));
        assertEquals(t.get(0, 1), g.v(5));
        assertEquals(t.get(1, 0), g.v(1));
        assertEquals(t.get(1, 1), g.v(3));
        assertEquals(t.getColumnCount(), 2);
        assertEquals(t.getRowCount(), 2);

    }

    public void testTableClosures() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        Table t = new Table();
        g.v(1).as('1').out.as('2').table(t) >> -1;
        assertEquals(t.get(0, 0), g.v(1));
        assertEquals(t.get(0, 1), g.v(2));
        assertEquals(t.get(1, 0), g.v(1));
        assertEquals(t.get(1, 1), g.v(3));
        assertEquals(t.get(2, 0), g.v(1));
        assertEquals(t.get(2, 1), g.v(4));
        assertEquals(t.getColumnCount(), 2);
        assertEquals(t.getRowCount(), 3);

        t = t.apply {it.name} {it.name};
        assertEquals(t.get(0, 0), 'marko');
        assertEquals(t.get(0, 1), 'vadas');
        assertEquals(t.get(1, 0), 'marko');
        assertEquals(t.get(1, 1), 'lop');
        assertEquals(t.get(2, 0), 'marko');
        assertEquals(t.get(2, 1), 'josh');
        assertEquals(t.getColumnCount(), 2);
        assertEquals(t.getRowCount(), 3);


    }

    public void testTablePipeWithSubColumns() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        Table t = new Table();
        g.v(1).as('1').out.as('NO').out.as('2').table(t, ['1', '2']) {it.name} {it.name} >> -1
        assertEquals(t.get(0, '1'), "marko");
        assertEquals(t.get(0, '2'), "ripple");
        assertEquals(t.get(1, '1'), "marko");
        assertEquals(t.get(1, '2'), "lop");
        assertEquals(t.getColumnCount(), 2);
        assertEquals(t.getRowCount(), 2);

        t.clear();
        try {
            g.v(1).as('1').out.as('NO').out.as('2').table(t, ['1', '2']) {it.name} >> -1
            assertTrue(false);
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }
}

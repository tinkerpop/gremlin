package com.tinkerpop.gremlin

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.util.StartPipe
import junit.framework.TestCase

class GremlinTest extends TestCase {

    public void testVersion() throws Exception {
        Gremlin.load();
        assertEquals(Gremlin.version(), GremlinTokens.VERSION);
    }

    public void testCompilation() throws Exception {
        Graph g = TinkerGraphFactory.createTinkerGraph();

        // test imports
        Gremlin.compile("new IdentityPipe()");

        // test compilation
        Pipe pipe = Gremlin.compile("_().outE.inV.name");
        pipe.setStarts(g.v(1).iterator());
        (pipe >> 3).each {assertTrue(it.equals("josh") || it.equals("lop") || it.equals("vadas"))}
        assertFalse(pipe.hasNext());
    }

    public void testMidPipeVariableSetting() throws Exception {
        Gremlin.load();
        def x = 0;
        new StartPipe([1, 2, 3]).step {x = starts.next()} >> -1
        assertEquals(x, 3);
        new StartPipe([3, 2, 1]).step {x = starts.next()} >> -1
        assertEquals(x, 1);
    }

    public void testUserDefinedSteps() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        Gremlin.addStep("coDeveloper")
        [Pipe, Vertex].each {
            def c = { def x; _ {x = it}.outE('created').inV.inE('created').outV {it != x} }
            it.metaClass.coDeveloper = { Gremlin.compose(delegate, c())}
        }
        def results = []
        g.v(1).coDeveloper >> results
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.v(4)));
        assertTrue(results.contains(g.v(6)));

        Gremlin.defineStep("coCreator", [Pipe, Vertex], {
            def x; _ {x = it}.out('created').in('created') {it != x}
        });
        results = []
        g.v(1).coCreator >> results
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.v(4)));
        assertTrue(results.contains(g.v(6)));

        assertEquals(g.v(1).coCreator, g.v(1).coDeveloper);
    }



    public void testBasicTraversalPipes() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def results = [];
        g.v(1).out.name >> results;
        assertEquals(results.size(), 3);
        assertTrue(results.contains("josh") || results.contains("vadas") || results.contains("lop"));

        results = [];
        g.v(1).out('knows').name >> results;
        assertEquals(results.size(), 2);
        assertTrue(results.contains("josh") || results.contains("vadas"));

        ////////

        results = [];
        g.v(1).outE('knows') >> results;
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.e(7)) || g.e(8));

        results = [];
        g.v(1).outE >> results;
        assertEquals(results.size(), 3);
        assertTrue(results.contains(g.e(7)) || g.e(8) || g.e(9));

        ////////

        results = [];
        g.v(4).in >> results;
        assertTrue(results.contains(g.v(1)));
        assertEquals(results.size(), 1);

        results = [];
        g.v(4).in('knows') >> results;
        assertTrue(results.contains(g.v(1)));
        assertEquals(results.size(), 1);

        ////////

        results = [];
        g.v(4).inE >> results;
        assertTrue(results.contains(g.e(8)));
        assertEquals(results.size(), 1);

        results = [];
        g.v(4).inE('knows') >> results;
        assertTrue(results.contains(g.e(8)));
        assertEquals(results.size(), 1);

        ////////

        results = [];
        g.v(4).both >> results;
        assertTrue(results.contains(g.v(1)));
        assertTrue(results.contains(g.v(3)));
        assertTrue(results.contains(g.v(5)));
        assertEquals(results.size(), 3);

        results = [];
        g.v(4).both('created') >> results;
        assertTrue(results.contains(g.v(3)));
        assertTrue(results.contains(g.v(5)));
        assertEquals(results.size(), 2);

        ////////

        results = [];
        g.v(4).bothE >> results;
        assertEquals(results.size(), 3);
        assertTrue(results.contains(g.e(10)) || g.e(11) || g.e(8));

        results = [];
        g.v(4).bothE('created') >> results;
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.e(10)) || g.e(11));

        ////////

        assertEquals(g.e(10).outV >> 1, g.v(4));
        assertEquals(g.e(10).inV >> 1, g.v(5));
        assertTrue((g.e(10).bothV >> 2).contains(g.v(4)));
        assertTrue((g.e(10).bothV >> 2).contains(g.v(5)));

        ////////

        assertEquals(g.v(1).outE('knows', 'created').toList().size(), 3);
        assertEquals(g.v(2).inE('knows', 'created').toList().size(), 1);
        assertEquals(g.v(2).inE('knows', 'created').toList().get(0), g.v(1).outE('knows') >> 1);
        assertEquals(g.v(4).bothE('knows', 'created').toList().size(), 3);

        ////////

        assertEquals(g.v(1).out('knows', 'created').toList().size(), 3);
        assertEquals(g.v(2).in('knows', 'created').toList().size(), 1);
        assertEquals(g.v(2).in('knows', 'created').toList().get(0), g.v(1));
        assertEquals(g.v(4).both('knows', 'created').toList().size(), 3);

    }
}
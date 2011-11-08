package com.tinkerpop.gremlin.groovy

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.BaseTest
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.pipes.Pipe

class GremlinTest extends BaseTest {

    public void testVersion() throws Exception {
        Gremlin.load();
        assertEquals(Gremlin.version(), Tokens.VERSION);
    }

    public void testCompilation() throws Exception {
        Graph g = TinkerGraphFactory.createTinkerGraph();

        // test imports
        Gremlin.compile("new IdentityPipe()");

        // test compilation
        Pipe pipe = Gremlin.compile("_().outE.inV.name");
        pipe.setStarts(g.v(1).iterator());
        (pipe.next(3)).each {assertTrue(it.equals("josh") || it.equals("lop") || it.equals("vadas"))}
        assertFalse(pipe.hasNext());
    }

    public void testMidPipeVariableSetting() throws Exception {
        Gremlin.load();
        def x = 0;
        new GremlinGroovyPipeline().start([1, 2, 3]).step {x = it.next()}.iterate()
        assertEquals(x, 3);
        new GremlinGroovyPipeline().start([3, 2, 1]).step {x = it.next()}.iterate()
        assertEquals(x, 1);
    }

    public void testUserDefinedSteps() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        Gremlin.defineStep("coCreator", [Pipe, Vertex], {
            def x; _().sideEffect {x = it}.out('created').in('created').filter {it != x}
        });
        def results = []
        g.v(1).coCreator.fill(results)
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.v(4)));
        assertTrue(results.contains(g.v(6)));

        ///////////////////////

        Gremlin.defineStep("co", [Pipe, Vertex], { final String label ->
            def x; _().sideEffect {x = it}.out(label).in(label).filter {it != x}
        });
        results = []
        g.v(1).co('created').fill(results)
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.v(4)));
        assertTrue(results.contains(g.v(6)));

        assertEquals(g.v(1).co('created'), g.v(1).coCreator);

        ///////////////////////
        def x;
        Gremlin.defineStep("twoStep", [Pipe, Vertex], { final Object... params ->
            _().sideEffect {x = it}.out(params[0]).in(params[0]).filter(params[1])
        });
        //TODO: can this be possible?
        /*Gremlin.defineStep("twoStep", [Pipe, Vertex], { final String label, Closure function ->
            _ {x = it}.out(label).in(label).filter(function)
        });*/

        results = []
        g.v(1).twoStep('created') {it != x}.fill(results)
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.v(4)));
        assertTrue(results.contains(g.v(6)));
        assertEquals(g.v(1).co('created'), g.v(1).twoStep('created') {it != x});

        results = []
        g.v(1).twoStep('created') {it == x}.fill(results)
        assertEquals(results.size(), 1);
        assertTrue(results.contains(g.v(1)));


    }



    public void testBasicTraversalPipes() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def results = [];
        g.v(1).out.name.fill(results)
        assertEquals(results.size(), 3);
        assertTrue(results.contains("josh") && results.contains("vadas") && results.contains("lop"));

        results = [];
        g.v(1).out('knows').name.fill(results)
        assertEquals(results.size(), 2);
        assertTrue(results.contains("josh") && results.contains("vadas"));

        ////////

        results = [];
        g.v(1).outE('knows').fill(results)
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.e(7)) && g.e(8));

        results = [];
        g.v(1).outE.fill(results)
        assertEquals(results.size(), 3);
        assertTrue(results.contains(g.e(7)) && g.e(8) && g.e(9));

        ////////

        results = [];
        g.v(4).in.fill(results)
        assertTrue(results.contains(g.v(1)));
        assertEquals(results.size(), 1);

        results = [];
        g.v(4).in('knows').fill(results)
        assertTrue(results.contains(g.v(1)));
        assertEquals(results.size(), 1);

        ////////

        results = [];
        g.v(4).inE.fill(results)
        assertTrue(results.contains(g.e(8)));
        assertEquals(results.size(), 1);

        results = [];
        g.v(4).inE('knows').fill(results)
        assertTrue(results.contains(g.e(8)));
        assertEquals(results.size(), 1);

        ////////

        results = [];
        g.v(4).both.fill(results)
        assertTrue(results.contains(g.v(1)));
        assertTrue(results.contains(g.v(3)));
        assertTrue(results.contains(g.v(5)));
        assertEquals(results.size(), 3);

        results = [];
        g.v(4).both('created').fill(results)
        assertTrue(results.contains(g.v(3)));
        assertTrue(results.contains(g.v(5)));
        assertEquals(results.size(), 2);

        ////////

        results = [];
        g.v(4).bothE.fill(results)
        assertEquals(results.size(), 3);
        assertTrue(results.contains(g.e(10)) && g.e(11) && g.e(8));

        results = [];
        g.v(4).bothE('created').fill(results)
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.e(10)) && g.e(11));

        ////////

        assertEquals(g.e(10).outV.next(), g.v(4));
        assertEquals(g.e(10).inV.next(), g.v(5));
        assertTrue((g.e(10).bothV.next(2)).contains(g.v(4)));
        assertTrue((g.e(10).bothV.next(2)).contains(g.v(5)));

        ////////

        assertEquals(g.v(1).outE('knows', 'created').toList().size(), 3);
        assertEquals(g.v(2).inE('knows', 'created').toList().size(), 1);
        assertEquals(g.v(2).inE('knows', 'created').toList().get(0), g.v(1).outE('knows').next());
        assertEquals(g.v(4).bothE('knows', 'created').toList().size(), 3);

        ////////

        assertEquals(g.v(1).out('knows', 'created').toList().size(), 3);
        assertEquals(g.v(2).in('knows', 'created').toList().size(), 1);
        assertEquals(g.v(2).in('knows', 'created').toList().get(0), g.v(1));
        assertEquals(g.v(4).both('knows', 'created').toList().size(), 3);

    }

    public void testPipelineEquality() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        assertEquals(g.v(1).outE.inV, g.v(1).outE.inV);
        assertEquals(g.v(1)._.outE._._.inV[0..100], g.v(1)._.outE.inV._._);
        assertEquals(g.v(1).inE, g.v(1).inE);
    }

    public void testPipelineReset() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def results = [];
        Pipe pipe = g.v(1).outE.inV
        pipe.next();
        assertTrue(pipe.hasNext());
        pipe.reset();
        assertFalse(pipe.hasNext());
        pipe.setStarts(g.v(1).iterator());
        assertTrue(pipe.hasNext());
        pipe.fill(results)
        assertEquals(results.size(), 3);

    }

    public void testPipelineConstructionWithFunctionNotation() {
        Gremlin.load();
        Graph g = new TinkerGraph()
        def results1a = []
        def results1b = []
        def results2a = []
        def results2b = []
        def results3a = []
        def results3b = []

        for (int i = 0; i < 500; i++) {
            this.stopWatch();
            g.V.outE.inV
            results1a << this.stopWatch();
            this.stopWatch();
            g.V().outE().inV()
            results1b << this.stopWatch();

            this.stopWatch();
            g.V.outE.inV.outE.inV
            results2a << this.stopWatch();
            this.stopWatch()
            g.V().outE().inV().outE().inV()
            results2b << this.stopWatch();

            this.stopWatch();
            g.V.outE('knows').inV.outE('knows').inV
            results3a << this.stopWatch();

        }

        println "\tProperty notation <g.V.outE.inV>: " + results1a.mean();
        println "\tMethod notation <g.V().outE().inV()>: " + results1b.mean();
        println "\tProperty notation <g.V.outE.inV.outE.inV>: " + results2a.mean();
        println "\tMethod notation <g.V().outE().inV().outE().inV()>: " + results2b.mean();
        println "\tProperty notation <g.V.outE[[label: 'knows']].inV.outE[[label:'knows']].inV>: " + results3a.mean();
    }

}
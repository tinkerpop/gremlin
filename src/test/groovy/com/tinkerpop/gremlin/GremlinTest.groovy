package com.tinkerpop.gremlin

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.GremlinTokens.T
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.util.FluentPipeline

class GremlinTest extends BaseTest {

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
        new FluentPipeline().start([1, 2, 3]).step {x = it.next()} >> -1
        assertEquals(x, 3);
        new FluentPipeline().start([3, 2, 1]).step {x = it.next()} >> -1
        assertEquals(x, 1);
    }

    public void testUserDefinedSteps() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        Gremlin.defineStep("coCreator", [Pipe, Vertex], {
            def x; _().sideEffect {x = it}.out('created').in('created').filter {it != x}
        });
        def results = []
        g.v(1).coCreator >> results
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.v(4)));
        assertTrue(results.contains(g.v(6)));

        ///////////////////////

        Gremlin.defineStep("co", [Pipe, Vertex], { final String label ->
            def x; _().sideEffect {x = it}.out(label).in(label).filter {it != x}
        });
        results = []
        g.v(1).co('created') >> results
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
        g.v(1).twoStep('created') {it != x} >> results
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.v(4)));
        assertTrue(results.contains(g.v(6)));
        assertEquals(g.v(1).co('created'), g.v(1).twoStep('created') {it != x});

        results = []
        g.v(1).twoStep('created') {it == x} >> results
        assertEquals(results.size(), 1);
        assertTrue(results.contains(g.v(1)));


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
        pipe >> results;
        assertEquals(results.size(), 3);

    }

    public void testPipelineVariations() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        String name = "josh";
        Vertex josh = g.v(4);
        assertEquals(g.v(1).outE.inV[[name: name]].next(), josh);
        assertEquals(g.v(1).outE.inV[[id: '4']].next(), josh);

        assertEquals(g.v(1).outE.filter {it.label == 'knows' | it.label == 'created'}.inV.filter {it.id == '4' & it.name == name}.next(), josh);
        assertEquals(g.v(1).outE.orFilter(_()[[label: 'knows']], _()[[label: 'created']]).inV.andFilter(_()[[id: '4']], _()[[name: name]]) >> 1, josh);
        assertEquals(g.v(1).outE.orFilter(_().propertyFilter('label', T.eq, 'knows'), _().propertyFilter('label', T.eq, 'created')).inV.andFilter(_().propertyFilter('id', T.eq, '4'), _().propertyFilter('name', T.eq, name)).next(), josh);
    }

    public void testPipelineToString() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        println g.v(1).outE.inV.outE.inV
        println g.V.outE[[label: 'knows']].inV
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
            g.V.outE[[label: 'knows']].inV.outE[[label: 'knows']].inV
            results3a << this.stopWatch();
            this.stopWatch();
            g.V().outE()[[label: 'knows']].inV().outE()[[label: 'knows']].inV()
            results3b << this.stopWatch();

        }

        println "\tProperty notation <g.V.outE.inV>: " + results1a.mean();
        println "\tMethod notation <g.V().outE().inV()>: " + results1b.mean();
        println "\tProperty notation <g.V.outE.inV.outE.inV>: " + results2a.mean();
        println "\tMethod notation <g.V().outE().inV().outE().inV()>: " + results2b.mean();
        println "\tProperty notation <g.V.outE[[label: 'knows']].inV.outE[[label:'knows']].inV>: " + results3a.mean();
        println "\tMethod notation <g.V().outE()[[label: 'knows']].inV().outE()[[label:'knows']].inV()>: " + results3b.mean();

    }

}
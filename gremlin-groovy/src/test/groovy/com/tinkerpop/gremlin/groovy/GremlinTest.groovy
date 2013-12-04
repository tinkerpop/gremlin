package com.tinkerpop.gremlin.groovy

import com.tinkerpop.blueprints.Edge
import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.Vertex
import com.tinkerpop.blueprints.impls.tg.TinkerGraph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.BaseTest
import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.pipes.Pipe

class GremlinTest extends BaseTest {

    public void testVersion() throws Exception {
        Gremlin.load();
        assertEquals(Gremlin.version(), Tokens.VERSION);
    }

    public void testLanguage() throws Exception {
        Gremlin.load();
        assertEquals(Gremlin.language(), "gremlin-groovy");
    }

    public void testCompilation() throws Exception {
        Graph g = TinkerGraphFactory.createTinkerGraph();

        // test imports
        Gremlin.compile("new IdentityPipe()");

        // test compilation
        Pipe pipe = Gremlin.compile("_().outE.inV.name");
        pipe.setStarts(g.v(1).iterator());
        (pipe.next(3)).each { assertTrue(it.equals("josh") || it.equals("lop") || it.equals("vadas")) }
        assertFalse(pipe.hasNext());
    }

    public void testStartPipeWithIdentity() {
        Gremlin.load();
        Pipe pipe = _().out.name;
        pipe.setStarts([TinkerGraphFactory.createTinkerGraph().getVertex(1)]);
        int counter = 0;
        pipe.each {
            assertTrue(it.equals("josh") || it.equals("lop") || it.equals("vadas"))
            counter++;
        }
        assertEquals(counter, 3);
    }

    public void testMidPipeVariableSetting() throws Exception {
        Gremlin.load();
        def x = 0;
        new GremlinGroovyPipeline().start([1, 2, 3]).step { x = it.next() }.iterate()
        assertEquals(x, 3);
        new GremlinGroovyPipeline().start([3, 2, 1]).step { x = it.next() }.iterate()
        assertEquals(x, 1);
    }

    public void testUserDefinedSteps() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        Gremlin.defineStep("coCreator", [Pipe, Vertex], {
            def x; _().sideEffect { x = it }.out('created').in('created').filter { it != x }
        });
        def results = []
        g.v(1).coCreator.fill(results)
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.v(4)));
        assertTrue(results.contains(g.v(6)));

        ///////////////////////

        Gremlin.defineStep("co", [Pipe, Vertex], { final String label ->
            def x; _().sideEffect { x = it }.out(label).in(label).filter { it != x }
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
            _().sideEffect { x = it }.out(params[0]).in(params[0]).filter(params[1])
        });
        //TODO: can this be possible?
        /*Gremlin.defineStep("twoStep", [Pipe, Vertex], { final String label, Closure function ->
            _ {x = it}.out(label).in(label).filter(function)
        });*/

        results = []
        g.v(1).twoStep('created') { it != x }.fill(results)
        assertEquals(results.size(), 2);
        assertTrue(results.contains(g.v(4)));
        assertTrue(results.contains(g.v(6)));
        assertEquals(g.v(1).co('created'), g.v(1).twoStep('created') { it != x });

        results = []
        g.v(1).twoStep('created') { it == x }.fill(results)
        assertEquals(results.size(), 1);
        assertTrue(results.contains(g.v(1)));


    }

    public void testPipelineEquality() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        assertEquals(g.v(1).outE.inV, g.v(1).outE.inV);
        assertEquals(g.v(1)._.outE._._.inV[0..100], g.v(1)._.outE.inV._._);
        assertEquals(g.v(1).inE, g.v(1).inE);
        assertEquals(g.V.out[0..5], g.V.outE[0..5].inV);
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
        }

        println "\tProperty notation <g.V.outE.inV>: " + results1a.mean();
        println "\tMethod notation <g.V().outE().inV()>: " + results1b.mean();
        println "\tProperty notation <g.V.outE.inV.outE.inV>: " + results2a.mean();
        println "\tMethod notation <g.V().outE().inV().outE().inV()>: " + results2b.mean();
    }

    public void testCounting() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertEquals(g.V.count(), 6);
        assertEquals(g.E.count(), 6);
    }

    public void testSelfLoopsInPaths() {
        Gremlin.load();
        Graph g = new TinkerGraph();
        Vertex a = g.addVertex();
        g.addEdge(a, a, "self");
        assertEquals(a.out.out.out.path.next().size(), 4)
    }

    public void testVertexAddEdge() {
        Gremlin.load();
        Graph g = new TinkerGraph();
        Edge e = g.addVertex(1).addEdge("knows", g.addVertex(2), [weight: 0.2f]);
        assertEquals(e.outV.id.next(), "1");
        assertEquals(e.inV.id.next(), "2");
        assertEquals(e.weight, 0.2f)
        assertEquals(e.propertyKeys.size(), 1);
    }

    public void testPipeStarts() {
        Gremlin.load()
        Graph g = TinkerGraphFactory.createTinkerGraph();
        g.V.out.path.each {
            assertFalse(it[0] instanceof Graph);
            assertEquals(it.size(), 2);
        }
    }

    public void testIsSimple() {
        Gremlin.load();
        assertTrue([1, 2, 4].isSimple());
        assertFalse([1, 2, 2].isSimple());
    }

    public void testMethodPropertyNameConfusion() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        try {
            g.V.out.name.toList.iterate()
            assertTrue(false);
        } catch(Exception e) {
            assertTrue(true);
        }

        assertEquals(g.V.out.name.toList(), g.V.out.name.collect{it});

        try {
            g.V.out.name.toList.iterate()
            assertTrue(false);
        } catch(Exception e) {
            assertTrue(true);
        }
    }

    /*public void testPropertyClosureCachingSpeed() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        def times = 0l;
        (0..10000).each{
            def t = System.nanoTime();
            g.V.out.name;
            times += System.nanoTime() - t;
        }
        println times/10000;
    }*/
}
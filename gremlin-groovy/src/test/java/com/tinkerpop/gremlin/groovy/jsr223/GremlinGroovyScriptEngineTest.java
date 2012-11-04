package com.tinkerpop.gremlin.groovy.jsr223;

import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import junit.framework.TestCase;

import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinGroovyScriptEngineTest extends TestCase {

    public void testGremlinLoading() throws Exception {
        ScriptEngine engine = new GremlinGroovyScriptEngine();
        List list = new ArrayList();
        engine.put("g", TinkerGraphFactory.createTinkerGraph());
        engine.put("list", list);
        assertEquals(list.size(), 0);
        engine.eval("g.v(1).outE.inV._.fill(list)");
        assertEquals(list.size(), 3);
    }

    public void testImports() throws Exception {
        ScriptEngine engine = new GremlinGroovyScriptEngine();
        engine.eval("Vertex.class.getName()");
        engine.eval("new TinkerGraph()");
        engine.eval("TinkerGraphFactory.createTinkerGraph().V.hasNot('age',null).has('age',T.gt,25).count()");
        engine.eval("TinkerGraphFactory.createTinkerGraph().getVertex(1).getVertices(OUT)");
        engine.eval("TinkerGraphFactory.createTinkerGraph().getVertex(1).getEdges(BOTH)");
        engine.eval("TinkerGraphFactory.createTinkerGraph().getVertex(1).getEdges(IN)");
        engine.eval("Direction.OUT.toString(); Direction.IN.toString(); Direction.BOTH.toString()");
        engine.eval("SUCCESS.toString(); FAILURE.toString()");
        engine.eval("TransactionalGraph.Conclusion.SUCCESS.toString(); TransactionalGraph.Conclusion.FAILURE.toString()");
    }

    public void testBindings() throws Exception {
        ScriptEngine engine = new GremlinGroovyScriptEngine();
        assertTrue(engine.eval("g = TinkerGraphFactory.createTinkerGraph()") instanceof TinkerGraph);
        assertTrue(engine.get("g") instanceof TinkerGraph);
        assertEquals(engine.eval("g.v(1)"), TinkerGraphFactory.createTinkerGraph().getVertex(1));
    }

    public void testThreadSafetyOnEngine() throws Exception {
        final ScriptEngine engine = new GremlinGroovyScriptEngine();

        int runs = 100;
        final CountDownLatch latch = new CountDownLatch(runs);
        final List<String> names = Arrays.asList("marko", "peter", "josh", "vadas", "stephen", "pavel", "matthias");
        final Random random = new Random();

        for (int i = 0; i < runs; i++) {
            new Thread() {
                public void run() {
                    String name = names.get(random.nextInt(names.size() - 1));
                    try {
                        final Bindings bindings = engine.createBindings();
                        bindings.put("g", TinkerGraphFactory.createTinkerGraph());
                        bindings.put("name", name);
                        final Object result = engine.eval("pipe = g.V('name',name); if(pipe.hasNext()) { pipe.out.count() } else { null }", bindings);
                        if (name.equals("stephen") || name.equals("pavel") || name.equals("matthias"))
                            assertNull(result);
                        else
                            assertNotNull(result);
                    } catch (ScriptException e) {
                        //System.out.println(e);
                        assertFalse(true);
                    }
                    latch.countDown();
                }
            }.start();
        }
        latch.await();
    }

    public void testThreadSafetyOnCompiledScript() throws Exception {
        final GremlinGroovyScriptEngine engine = new GremlinGroovyScriptEngine();
        final CompiledScript script = engine.compile("pipe = g.V('name',name); if(pipe.hasNext()) { pipe.out.count() } else { null }");

        int runs = 100;
        final CountDownLatch latch = new CountDownLatch(runs);
        final List<String> names = Arrays.asList("marko", "peter", "josh", "vadas", "stephen", "pavel", "matthias");
        final Random random = new Random();

        for (int i = 0; i < runs; i++) {
            new Thread() {
                public void run() {
                    String name = names.get(random.nextInt(names.size() - 1));
                    try {
                        final Bindings bindings = engine.createBindings();
                        bindings.put("g", TinkerGraphFactory.createTinkerGraph());
                        bindings.put("name", name);
                        Object result = script.eval(bindings);
                        if (name.equals("stephen") || name.equals("pavel") || name.equals("matthias"))
                            assertNull(result);
                        else
                            assertNotNull(result);
                    } catch (ScriptException e) {
                        //System.out.println(e);
                        assertFalse(true);
                    }
                    latch.countDown();
                }
            }.start();
        }
        latch.await();
    }

    public void testEngineVsCompiledCosts() throws Exception {
        final GremlinGroovyScriptEngine engine = new GremlinGroovyScriptEngine();
        Bindings bindings = engine.createBindings();
        bindings.put("g", TinkerGraphFactory.createTinkerGraph());

        int runs = 1000;

        long totalTime = 0l;
        for (int i = 0; i < runs; i++) {
            long time = System.currentTimeMillis();
            CompiledScript script = engine.compile("g.v(1).out().count()");
            script.eval(bindings);
            totalTime += System.currentTimeMillis() - time;
        }
        System.out.println("Multi-compiled script runtime for " + runs + " runs: " + totalTime);

        totalTime = 0l;
        for (int i = 0; i < runs; i++) {
            long time = System.currentTimeMillis();
            engine.eval("g.v(1).out().count()", bindings);
            totalTime += System.currentTimeMillis() - time;
        }
        System.out.println("Evaluated script runtime for " + runs + " runs: " + totalTime);

        totalTime = 0l;
        CompiledScript script = engine.compile("g.v(1).out().count()");
        for (int i = 0; i < runs; i++) {
            long time = System.currentTimeMillis();
            script.eval(bindings);
            totalTime += System.currentTimeMillis() - time;
        }
        System.out.println("Compiled script runtime for " + runs + " runs: " + totalTime);
    }

}

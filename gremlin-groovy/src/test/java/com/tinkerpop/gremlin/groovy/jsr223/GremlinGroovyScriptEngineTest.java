package com.tinkerpop.gremlin.groovy.jsr223;

import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import junit.framework.TestCase;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
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
        engine.eval("g.v(1).outE.inV.fill(list)");
        assertEquals(list.size(), 3);
    }

    public void testImports() throws Exception {
        ScriptEngine engine = new GremlinGroovyScriptEngine();
        engine.eval("new TinkerGraph()");
    }

    public void testBindings() throws Exception {
        ScriptEngine engine = new GremlinGroovyScriptEngine();
        assertTrue(engine.eval("g = TinkerGraphFactory.createTinkerGraph()") instanceof TinkerGraph);
        assertTrue(engine.get("g") instanceof TinkerGraph);
        assertEquals(engine.eval("g.v(1)"), TinkerGraphFactory.createTinkerGraph().getVertex(1));
    }

    public void testThreadSafety() throws Exception {
        final ScriptEngine engine = new GremlinGroovyScriptEngine();
        engine.put("g", TinkerGraphFactory.createTinkerGraph());
        int runs = 100;
        final CountDownLatch latch = new CountDownLatch(runs);
        final List<String> names = Arrays.asList("marko", "peter", "josh", "vadas", "stephen", "pavel", "matthias");
        final Random random = new Random();

        for (int i = 0; i < runs; i++) {
            new Thread() {
                public void run() {
                    String name = names.get(random.nextInt(names.size() - 1));
                    try {
                        // final String var = "pipe" TODO: the variable is shared across threads
                        final String var = "a" + UUID.randomUUID().toString().replace("-","");
                        final Object result = engine.eval(var + " = g.V('name','" + name + "'); if("+var+".hasNext()) { "+var+".count() } else { null }");
                        //System.out.println(name);
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

}

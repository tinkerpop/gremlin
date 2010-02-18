package com.tinkerpop.gremlin;

import junit.framework.TestCase;

import javax.script.*;

import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptEngineTest extends TestCase {

    public void testVariableLibraryAsBindings() {
        ScriptEngineFactory factory = new GremlinScriptEngineFactory();
        ScriptEngine engine = factory.getScriptEngine();
        engine.put("$marko", 10);
        assertEquals(engine.get("$marko"), 10);
        assertEquals(engine.getBindings(0).get("$marko"), 10);
        assertEquals(engine.getBindings(0).put("$marko", 22), 10);
        for (int i = 0; i < 10; i++) {
            assertEquals(engine.getBindings(i).get("$marko"), 22);
        }
        Bindings bindings = engine.createBindings();
        bindings.put("$x", 10);
        bindings.put("$y", "marko");
        bindings.put("$z", true);
        engine.setBindings(bindings,0);
        assertEquals(engine.get("$x"), 10);
        assertEquals(engine.get("$y"), "marko");
        assertTrue((Boolean)engine.get("$z"));
        ///
        assertEquals(engine.get("$marko"), 22);
        assertEquals(engine.getBindings(0).get("$marko"), 22);
        try {
            engine.put("bad_variable", 1000.0);
            assertTrue(false);
        } catch(EvaluationException e) {
            assertTrue(true);
        }
    }

    public void testScriptEngineEvaluation() throws ScriptException {
        ScriptEngineFactory factory = new GremlinScriptEngineFactory();
        ScriptEngine engine = factory.getScriptEngine();
        assertEquals(((List)engine.eval("1+2")).get(0), 3.0);
        assertEquals(((List)engine.eval("1+2", new SimpleScriptContext())).get(0), 3.0);
        assertEquals(((List)engine.eval("$x := 'marko'")).get(0), "marko");
        assertEquals(engine.get("$x"), "marko");
        assertEquals(engine.getBindings(0).get("$x"), "marko");
        assertEquals(((List)engine.eval("$i := 0\nrepeat 10\n$i := $i + 1\nend\n")).get(0), 10.0);
    }
}

package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.EvaluationException;
import junit.framework.TestCase;

import javax.script.*;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptEngineTest extends TestCase {

    public void testVariableLibraryAsBindings() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("gremlin");
        engine.put("$marko", 10);
        assertEquals(engine.get("$marko"), 10);
        assertEquals(engine.getBindings(ScriptContext.ENGINE_SCOPE).get("$marko"), 10);
        assertEquals(engine.getBindings(ScriptContext.ENGINE_SCOPE).put("$marko", 22), 10);
        assertEquals(engine.getBindings(ScriptContext.ENGINE_SCOPE).get("$marko"), 22);
        
        Bindings bindings = engine.createBindings();
        bindings.put("$x", 10);
        bindings.put("$y", "marko");
        bindings.put("$z", true);
        engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
        assertEquals(engine.get("$x"), 10);
        assertEquals(engine.get("$y"), "marko");
        assertTrue((Boolean) engine.get("$z"));
        
        try {
            engine.put("bad_variable", 1000.0);
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }

    public void testScriptEngineEvaluation() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("gremlin");
        assertEquals(((List) engine.eval("1+2")).get(0), 3.0);
        assertEquals(((List) engine.eval("1+2", new SimpleScriptContext())).get(0), 3.0);
        assertEquals(((List) engine.eval("$x := 'marko'")).get(0), "marko");
        assertEquals(engine.get("$x"), "marko");
        assertEquals(engine.getBindings(ScriptContext.ENGINE_SCOPE).get("$x"), "marko");
        assertEquals(((List) engine.eval("$i := 0\nrepeat 10\n$i := $i + 1\nend\n")).get(0), 10.0);

        String script = "$i := 0\n" +
                "repeat 10\n" +
                "  $i := $i + 1\n" +
                "end\n";
        assertEquals(((List) engine.eval(script)).get(0), 10.0);
        InputStreamReader reader = new InputStreamReader(GremlinScriptEngine.class.getResourceAsStream("gremlinscriptengine-test.grm"));
        assertEquals(((List) engine.eval(reader)).get(0), 10.0);
    }

    public void testScriptEngineGlobalContext() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine1 = manager.getEngineByName("gremlin");
        ScriptEngine engine2 = manager.getEngineByName("gremlin");
        assertNull(engine1.getBindings(ScriptContext.GLOBAL_SCOPE).put("$name", "marko"));
        assertEquals(engine1.getBindings(ScriptContext.GLOBAL_SCOPE).get("$name"), "marko");
        assertEquals(engine2.getBindings(ScriptContext.GLOBAL_SCOPE).get("$name"), "marko");
        assertEquals(engine2.getBindings(ScriptContext.GLOBAL_SCOPE).put("$name", "jen"), "marko");
        assertEquals(engine1.getBindings(ScriptContext.GLOBAL_SCOPE).get("$name"), "jen");
        assertEquals(engine2.getBindings(ScriptContext.GLOBAL_SCOPE).get("$name"), "jen");
    }

}

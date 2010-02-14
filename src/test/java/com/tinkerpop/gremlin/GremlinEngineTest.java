package com.tinkerpop.gremlin;

import junit.framework.TestCase;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngine;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinEngineTest extends TestCase {

    public void testVariableLibrary() {
        ScriptEngineFactory factory = new GremlinEngineFactory();
        ScriptEngine engine = factory.getScriptEngine();
        engine.put("$marko", 10);
        assertEquals(engine.get("$marko"),10);
        assertEquals(engine.getBindings(0).get("$marko"), 10);
        assertEquals(engine.getBindings(0).put("$marko",22), 10);
    }
}

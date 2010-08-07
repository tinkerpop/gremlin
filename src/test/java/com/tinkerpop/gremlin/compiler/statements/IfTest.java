package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinScriptEngine;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IfTest extends BaseTest {

    public void testIf() throws Exception {
        final GremlinScriptEngine engine   = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$x := 0\nif true\n$x := 10\nend\n$x\n", context);
        printPerformance("if statement", 1, "boolean check", this.stopWatch());
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), 0);
        assertEquals(results.get(1), 10);
    }

    public void testIfElse() throws Exception {
        final GremlinScriptEngine engine   = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$x := 0\nif false\n$x := 10\nelse\n$x := 20\nend\n$x\n", context);
        printPerformance("if statement", 1, "boolean check", this.stopWatch());
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), 0);
        assertEquals(results.get(1), 20);
    }

    public void testEmbeddedIfElse() throws Exception {
        final GremlinScriptEngine engine   = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$x := 0\nif false\n$x := 10\nelse\nif true\n$x := 30\nelse\n$x := 20\nend\nend\n$x\n", context);
        printPerformance("if statement", 2, "embedded boolean checks", this.stopWatch());
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), 0);
        assertEquals(results.get(1), 30);
    }
}

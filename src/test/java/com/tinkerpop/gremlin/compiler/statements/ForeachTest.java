package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinScriptEngine;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ForeachTest extends BaseTest {

    public void testForeach() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$sum := 0\nforeach $x in g:list(1,2,3,4)\n$sum := $sum + $x\nend\n$sum\n", context);
        printPerformance("foreach statement", 4, "iterations w/ returns", this.stopWatch());
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), 0);
        assertEquals(results.get(1), 10);
    }

    public void testEmbeddedForeach() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$counter := 0\nforeach $x in g:list(1,2,3,4)\nforeach $y in g:list(5,6,7,8)\n$counter := $counter + 1\nend\nend\n$counter\n", context);
        printPerformance("foreach statement", 2, "embedded iterations w/ returns", this.stopWatch());
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), 0);
        assertEquals(results.get(1), 16);
    }

    public void testEmptyForeach() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("foreach $e in g:list(1, 2, 3)[g:p($x := .)]\nend\n$x", context);
        printPerformance("foreach statement", 3, "iterations w/ variable assignment", this.stopWatch());

        assertEquals(results.size(), 1);
        assertEquals(results.get(0), 3);
    }

    public void testSingleObjectForeach() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$x := 0\nforeach $e in 1\n$x := 1000\nend\n$x", context);
        printPerformance("foreach statement", 1, "iteration for testing single object foreach", this.stopWatch());

        assertEquals(results.size(), 2);
        assertEquals(results.get(1), 1000);
    }

    public void testNoEmbeddedBlockWithVariableAssignment() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$x := g:list()\nforeach $y in g:list(1,2,3)\ng:append($x,$y)\nend\n$x", context);
        printPerformance("foreach statement", 3, "iterations w/ variable assignment", this.stopWatch());

        assertEquals(results.size(), 2);
        assertEquals(((List)results.get(1)).size(), 3);
        assertEquals(((List)results.get(1)).get(0), 1);
        assertEquals(((List)results.get(1)).get(1), 2);
        assertEquals(((List)results.get(1)).get(2), 3);
    }

    public void testEmbeddedBlockWithFunctionCall() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$x := g:list()\nforeach $y in g:list(1,2,3)\nif true\ng:append($x,$y)\nend\nend\n$x", context);
        printPerformance("foreach statement", 3, "iterations w/ function call", this.stopWatch());

        assertEquals(results.size(), 2);
        System.out.println(results);
        assertEquals(((List)results.get(1)).size(), 3);
        assertEquals(((List)results.get(1)).get(0), 1);
        assertEquals(((List)results.get(1)).get(1), 2);
        assertEquals(((List)results.get(1)).get(2), 3);
    }

    public void testEmbeddedBlockWithVariableAssignment() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$x := 0\nforeach $y in g:list(1,2,3)\nif true\nif true\n$x := $x + $y\nend\nend\nend\n$x", context);
        printPerformance("foreach statement", 3, "iterations w/ variable assignment", this.stopWatch());

        assertEquals(results.size(), 2);
        assertEquals(results.get(1), 6);

    }

}

package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinScriptEngine;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;

import javax.script.ScriptContext;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RepeatTest extends BaseTest {

    public void testRepeat() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$x := 10\n$counter := 0\nrepeat 10\n$x := $x - 1\n$counter := $counter + 1\nend\n$x\n$counter\n", context);
        printPerformance("repeat statement", 10, "iterations", this.stopWatch());
        //System.out.println(results);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 10);
        assertEquals(results.get(1), 0);
        assertEquals(results.get(2), 0);
        assertEquals(results.get(3), 10);
    }

    public void testEmbeddedRepeat() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$counter := 0\nrepeat 10\nrepeat 10\n$counter := $counter + 1\nend\nend\n$counter\n", context);
        printPerformance("repeat statement", 2, "embedded iterations of 10", this.stopWatch());
        assertEquals(results.size(), 2);
        assertEquals(results.get(0), 0);
        assertEquals(results.get(1), 100);
    }

    public void testGraphRepeat() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        this.stopWatch();
        List results = (List) engine.eval("repeat 2\n$_ := ./outE/inV\nend", context);
        printPerformance("repeat statement", 2, "iterations over graph", this.stopWatch());
        assertEquals(results.size(), 0);

        assertTrue(asList((Iterable) context.getBindings(ScriptContext.ENGINE_SCOPE).get(Tokens.ROOT_VARIABLE)).contains(graph.getVertex(5)));
        assertTrue(asList((Iterable) context.getBindings(ScriptContext.ENGINE_SCOPE).get(Tokens.ROOT_VARIABLE)).contains(graph.getVertex(3)));

        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));
        this.stopWatch();
        results = (List) engine.eval("repeat 2\n$_ := ./outE\nif g:includes(g:flatten($_),g:id-e(10))\n$_ := g:diff($_,g:id-e(10))\nend\n$_ := ./inV\nend", context);
        printPerformance("repeat statement", 2, "iterations over graph with edge filtering using functions", this.stopWatch());
        assertEquals(results.size(), 0);
        assertEquals(context.getBindings(ScriptContext.ENGINE_SCOPE).get(Tokens.ROOT_VARIABLE), graph.getVertex(3));
    }

    public void testEmptyRepeat() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        engine.eval("repeat 5\nend", context);
        printPerformance("repeat statement", 5, "iterations (with empty block)", this.stopWatch());

    }

    public void testRepeatEmbeddedInFunctionWithReturn() {

        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("func ex:test()   \n" + "  repeat 10\n" + "    return 10\n" + "  end\n" + "end \n" + "ex:test()", context);
        printPerformance("repeat statement", 1, "return call in function in repeat body", this.stopWatch());
        System.out.println(results);
        assertTrue((Boolean) results.get(0));
        assertEquals(results.get(1), 10);

    }

}

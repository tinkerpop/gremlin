package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinScriptEngine;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class WhileTest extends BaseTest {

    public void testWhile() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$x := 10\n$counter := 0\nwhile $x > 0\n$x := $x - 1\n$counter := $counter + 1\nend\n$x\n$counter\n", context);
        printPerformance("while statement", 10, "iterations", this.stopWatch());
        //System.out.println(results);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 10);
        assertEquals(results.get(1), 0);
        assertEquals(results.get(2), 0);
        assertEquals(results.get(3), 10);
    }

    public void testEmbeddedWhile() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$x := 10\n$counter := 0\nwhile $x > 0\n$y := 10\n$x := $x - 1\nwhile $y > 0\n$y := $y - 1\n$counter := $counter + 1\nend\nend\n$counter\n", context);
        printPerformance("while statement", 10, "iterations", this.stopWatch());
        //System.out.println(results);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 10);
        assertEquals(results.get(1), 0);
        assertEquals(results.get(2), 100);
    }

    public void testGraphWhile() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getVariableLibrary().declare(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        this.stopWatch();
        List results = (List) engine.eval("$i := 0\nwhile $i < 2\n$_ := ./outE/inV\n$i := $i + 1\nend", context);
        printPerformance("repeat statement", 2, "iterations over graph", this.stopWatch());
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), 0);

        assertTrue(asList((Iterable) context.getVariableByName(Tokens.ROOT_VARIABLE).getValue()).contains(graph.getVertex(5)));
        assertTrue(asList((Iterable) context.getVariableByName(Tokens.ROOT_VARIABLE).getValue()).contains(graph.getVertex(3)));

        context.getVariableLibrary().declare(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));
        this.stopWatch();
        results = (List) engine.eval("$i := 0\nwhile $i < 2\n$_ := ./outE\nif g:includes(g:flatten($_),g:id-e(10))\n$_ := g:diff($_,g:id-e(10))\nend\n$_ := ./inV\n$i := $i + 1\nend", context);
        printPerformance("repeat statement", 2, "iterations over graph with edge filtering using functions", this.stopWatch());
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), 0);
        assertEquals(context.getVariableByName(Tokens.ROOT_VARIABLE).getValue(), graph.getVertex(3));

    }
}

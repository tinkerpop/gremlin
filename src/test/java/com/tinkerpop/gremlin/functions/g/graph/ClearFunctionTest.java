package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.functions.Function;

import javax.script.ScriptContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ClearFunctionTest extends BaseTest {

    public void testClear() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        assertEquals(count(graph.getVertices()), 6);
        assertEquals(count(graph.getEdges()), 6);
        Function<Object> function = new ClearFunction();
        assertEquals(function.getFunctionName(), "clear");
        this.stopWatch();
        Atom<Object> atom = function.compute(createUnaryArgs(graph), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isNull());
        assertEquals(count(graph.getVertices()), 0);
        assertEquals(count(graph.getEdges()), 0);


    }

    public void testClearNoArgument() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        assertEquals(count(graph.getVertices()), 6);
        assertEquals(count(graph.getEdges()), 6);
        Function<Object> function = new ClearFunction();
        assertEquals(function.getFunctionName(), "clear");
        this.stopWatch();
        Atom<Object> atom = function.compute(createUnaryArgs(), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertNull(atom.getValue());
        assertEquals(count(graph.getVertices()), 0);
        assertEquals(count(graph.getEdges()), 0);

    }
}
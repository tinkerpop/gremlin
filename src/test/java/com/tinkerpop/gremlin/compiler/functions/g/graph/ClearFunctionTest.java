package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ClearFunctionTest extends BaseTest {

    public void testClear() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        assertEquals(count(graph.getVertices()), 6);
        assertEquals(count(graph.getEdges()), 6);
        Function<Boolean> function = new ClearFunction();
        assertEquals(function.getFunctionName(), "clear");
        this.stopWatch();
        Atom<Boolean> atom = function.compute(createUnaryArgs(graph), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isBoolean());
        assertEquals(count(graph.getVertices()), 0);
        assertEquals(count(graph.getEdges()), 0);


    }

    public void testClearNoArgument() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        assertEquals(count(graph.getVertices()), 6);
        assertEquals(count(graph.getEdges()), 6);
        Function<Boolean> function = new ClearFunction();
        assertEquals(function.getFunctionName(), "clear");
        this.stopWatch();
        Atom<Boolean> atom = function.compute(createUnaryArgs(), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.getValue());
        assertEquals(count(graph.getVertices()), 0);
        assertEquals(count(graph.getEdges()), 0);

    }
}
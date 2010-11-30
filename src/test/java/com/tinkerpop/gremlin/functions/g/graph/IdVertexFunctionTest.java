package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
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
public class IdVertexFunctionTest extends BaseTest {

    public void testIdVertex() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Vertex> function = new IdVertexFunction();
        assertEquals(function.getFunctionName(), "id-v");
        this.stopWatch();
        Atom<Vertex> atom = function.compute(createUnaryArgs(graph, "1"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isVertex());
        assertEquals(atom.getValue().getProperty("name"), "marko");
    }

    public void testIdVertexInline() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        assertEquals(((Vertex) evaluateGremlinScriptPrimitive("g:id-v(1)", context, true)).getId(), "1");
        assertEquals(((Vertex) evaluateGremlinScriptPrimitive("g:id-v($_g, 1)", context, true)).getId(), "1");
    }
}

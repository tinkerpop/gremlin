package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
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
public class IdEdgeFunctionTest extends BaseTest {

    public void testIdEdge() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Edge> function = new IdEdgeFunction();
        assertEquals(function.getFunctionName(), "id-e");
        this.stopWatch();
        Atom<Edge> atom = function.compute(createUnaryArgs(graph, "8"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isEdge());
        assertEquals(atom.getValue().getProperty("weight"), 1.0f);
        assertEquals(atom.getValue().getLabel(), "knows");
        assertNull(atom.getValue().getProperty("blah"));
    }

    public void testIdEdgeInline() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        assertEquals(((Edge) evaluateGremlinScriptPrimitive("g:id-e(8)", context, true)).getId(), "8");
        assertEquals(((Edge) evaluateGremlinScriptPrimitive("g:id-e($_g, 8)", context, true)).getId(), "8");
    }
}

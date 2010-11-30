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
public class KeyVertexFunctionTest extends BaseTest {

    public void testKeyVertex() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Iterable<Vertex>> function = new KeyVertexFunction();
        assertEquals(function.getFunctionName(), "key-v");
        this.stopWatch();
        Atom<Iterable<Vertex>> atom = function.compute(createUnaryArgs(graph, "name", "marko"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isIterable());
        assertEquals(count(atom.getValue()), 1);

    }

    public void testKeyVertexInline() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        assertEquals(((Vertex) (evaluateGremlinScriptIterable("g:key-v('name','marko')", context, true)).get(0)).getId(), "1");
        assertEquals(((Vertex) (evaluateGremlinScriptIterable("g:key-v($_g,'name','marko')", context, true)).get(0)).getId(), "1");
    }
}

package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.GPath;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.pgm.EdgeVertexPipe;
import com.tinkerpop.pipes.pgm.VertexEdgePipe;

import javax.script.ScriptContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathFunctionTest extends BaseTest {

    public void testPath() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        Function<Iterable> function = new PathFunction();
        this.stopWatch();
        List<Pipe> pipes = new ArrayList<Pipe>();
        pipes.add(new VertexEdgePipe(VertexEdgePipe.Step.OUT_EDGES));
        pipes.add(new EdgeVertexPipe(EdgeVertexPipe.Step.IN_VERTEX));
        Atom<Iterable> atom = function.compute(createUnaryArgs(new GPath(new Atom<Vertex>(graph.getVertex(1)), pipes, context)), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        int counter = 0;
        for (List path : (Iterable<List>) atom.getValue()) {
            counter++;
            assertEquals(path.get(0), graph.getVertex(1));
            assertTrue(path.get(1) instanceof Edge);
            assertTrue(path.get(2) instanceof Vertex);
            assertEquals(path.size(), 3);
        }
        assertEquals(counter, 3);
    }

    public void testPathInline() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        evaluateGremlinScriptIterable("$x := g:path(./outE/inV)", context, true);
        Iterable<List> paths = (Iterable<List>) evaluateGremlinScriptIterable("$x", context, false);
        paths = (Iterable<List>) evaluateGremlinScriptIterable("$x", context, false);
        int counter = 0;
        for (List path : paths) {
            counter++;
            assertEquals(path.get(0), graph.getVertex(1));
            assertTrue(path.get(1) instanceof Edge);
            assertTrue(path.get(2) instanceof Vertex);
            assertEquals(path.size(), 3);
        }
        assertEquals(counter, 3);


    }
}

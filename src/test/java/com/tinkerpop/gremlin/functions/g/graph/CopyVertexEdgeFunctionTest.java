package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
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
public class CopyVertexEdgeFunctionTest extends BaseTest {

    public void testCopyVertexEdgeUsingId() {
        Graph fromGraph = TinkerGraphFactory.createTinkerGraph();
        Graph toGraph = new TinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(fromGraph));

        Vertex v1 = fromGraph.getVertex(1);
        Function<Element> function = new CopyVertexEdgeFunction();
        function.compute(createUnaryArgs(toGraph, v1), context);

        Vertex v2 = toGraph.getVertex(1);
        for (String key : v1.getPropertyKeys()) {
            assertEquals(v2.getProperty(key), v1.getProperty(key));
        }

        Edge e1 = fromGraph.getEdge(8);
        function.compute(createUnaryArgs(toGraph, e1), context);

        Edge e2 = toGraph.getEdge(8);
        for (String key : e1.getPropertyKeys()) {
            assertEquals(e2.getProperty(key), e1.getProperty(key));
        }

        assertEquals(count(toGraph.getVertices()), 2);
        assertEquals(count(toGraph.getEdges()), 1);

    }

    public void testCopyVertexEdgeUsingName() {
        Graph fromGraph = TinkerGraphFactory.createTinkerGraph();
        Graph toGraph = new TinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(fromGraph));

        Vertex v1 = fromGraph.getVertex(1);
        Function<Element> function = new CopyVertexEdgeFunction();
        function.compute(createUnaryArgs(toGraph, v1, "vertices", "name"), context);

        Vertex v2 = toGraph.getVertex(1);
        for (String key : v1.getPropertyKeys()) {
            assertEquals(v2.getProperty(key), v1.getProperty(key));
        }

        Edge e1 = fromGraph.getEdge(8);
        function.compute(createUnaryArgs(toGraph, e1, "vertices", "name"), context);

        Edge e2 = toGraph.getEdge(8);
        for (String key : e1.getPropertyKeys()) {
            assertEquals(e2.getProperty(key), e1.getProperty(key));
        }

        assertEquals(count(toGraph.getVertices()), 2);
        assertEquals(count(toGraph.getEdges()), 1);

    }

    public void testCopyVertexUsingDoublePropertiesToThrowException() {
        Graph fromGraph = TinkerGraphFactory.createTinkerGraph();
        Graph toGraph = new TinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(fromGraph));

        Vertex v1 = fromGraph.getVertex(3);
        Function<Element> function = new CopyVertexEdgeFunction();
        function.compute(createUnaryArgs(toGraph, v1, "vertices", "lang"), context);

        v1 = fromGraph.getVertex(5);
        function = new CopyVertexEdgeFunction();
        function.compute(createUnaryArgs(toGraph, v1, "vertices", "lang"), context);

        assertEquals(count(toGraph.getVertices()), 1); // ripple and lop merge to the same

    }
}
package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddEdgeFunction extends AbstractFunction<Edge> {

    private final static String FUNCTION_NAME = "add-e";

    public Atom<Edge> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size < 3 || size > 5)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Graph graph = FunctionHelper.getGraph(arguments, 0, context);
        List<Object> objects = generateObjects(arguments);

        if (size == 5) {
            return createEdge(graph, objects.get(1), (Vertex) objects.get(2), (String) objects.get(3), (Vertex) objects.get(4));
        } else if (size == 4) {
            if (objects.get(0) instanceof Graph) {
                return createEdge(graph, null, (Vertex) objects.get(1), (String) objects.get(2), (Vertex) objects.get(3));
            } else {
                return createEdge(graph, objects.get(0), (Vertex) objects.get(1), (String) objects.get(2), (Vertex) objects.get(3));
            }
        } else if (size == 3) {
            return createEdge(graph, null, (Vertex) objects.get(0), (String) objects.get(1), (Vertex) objects.get(2));
        }
        throw new RuntimeException(this.createUnsupportedArgumentMessage());

    }

    private static Atom<Edge> createEdge(final Graph graph, final Object object, final Vertex start, final String label, final Vertex end) {
        if (object instanceof Map) {
            final Map map = (Map) object;
            final Edge edge;
            if (map.containsKey(Tokens._ID)) {
                edge = graph.addEdge(map.get(Tokens._ID), start, end, label);
            } else {
                edge = graph.addEdge(null, start, end, label);
            }
            for (Object key : map.keySet()) {
                if (key instanceof String && !key.equals(Tokens._ID)) {
                    edge.setProperty((String) key, map.get(key));
                }
            }
            return new Atom<Edge>(edge);
        } else if (object instanceof Edge) {
            Edge v = (Edge) object;
            Edge u = graph.addEdge(v.getId(), start, end, label);
            for (String key : v.getPropertyKeys()) {
                u.setProperty(key, v.getProperty(key));
            }
            return new Atom<Edge>(u);
        } else {
            return new Atom<Edge>(graph.addEdge(object, start, end, label));
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

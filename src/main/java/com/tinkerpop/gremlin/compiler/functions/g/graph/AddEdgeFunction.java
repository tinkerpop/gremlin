package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddEdgeFunction extends AbstractFunction<Edge> {

    private final static String FUNCTION_NAME = "add-e";

    public Atom<Edge> compute(final List<Operation> parameters) throws RuntimeException {
        final int size = parameters.size();
        if (size < 3 || size > 5)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Graph graph = FunctionHelper.getGraph(parameters, 0);
        List<Object> objects = generateObjects(parameters);

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

    private static Atom<Edge> createEdge(Graph graph, Object object, Vertex start, String label, Vertex end) {
        if (object instanceof Map) {
            final Map<Atom, Atom> map = (Map<Atom, Atom>) object;
            final Edge edge;
            if (map.containsKey(new Atom<String>(Tokens.ID))) {
                edge = graph.addEdge(map.get(new Atom<String>(Tokens.ID)).getValue(), start, end, label);
            } else {
                edge = graph.addEdge(null, start, end, label);
            }
            for (Atom key : map.keySet()) {
                Object noAtomKey = key.getValue();
                if (noAtomKey instanceof String && !noAtomKey.equals(Tokens.ID)) {
                    edge.setProperty((String) noAtomKey, map.get(key).getValue());
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

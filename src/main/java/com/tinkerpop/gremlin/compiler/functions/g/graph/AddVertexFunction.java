package com.tinkerpop.gremlin.compiler.functions.g.graph;

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
public class AddVertexFunction extends AbstractFunction<Vertex> {

    private final static String FUNCTION_NAME = "add-v";

    public Atom<Vertex> compute(final List<Operation> parameters) throws RuntimeException {
        final int size = parameters.size();
        if (size > 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Graph graph = FunctionHelper.getGraph(parameters, 0);
        final Object identifier;

        if (size == 0)
            return new Atom<Vertex>(graph.addVertex(null));
        else if (size == 1 && !parameters.get(0).compute().isGraph())
            identifier = parameters.get(0).compute().getValue();
        else
            identifier = parameters.get(1).compute().getValue();

        if (identifier instanceof Map) {
            final Map<Atom, Atom> map = (Map<Atom, Atom>) identifier;
            final Vertex vertex;
            if (map.containsKey(new Atom<String>(Tokens.ID))) {
                vertex = graph.addVertex(map.get(new Atom<String>(Tokens.ID)).getValue());
            } else {
                vertex = graph.addVertex(null);
            }
            for (Atom key : map.keySet()) {
                Object noAtomKey = key.getValue();
                if (noAtomKey instanceof String && !noAtomKey.equals(Tokens.ID)) {
                    vertex.setProperty((String) noAtomKey, map.get(key).getValue());
                }
            }
            return new Atom<Vertex>(vertex);

        } else if (identifier instanceof Vertex) {
            Vertex v = (Vertex) identifier;
            Vertex u = graph.addVertex(v.getId());
            for (String key : v.getPropertyKeys()) {
                u.setProperty(key, v.getProperty(key));
            }
            return new Atom<Vertex>(u);

        } else {
            return new Atom<Vertex>(graph.addVertex(identifier));
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

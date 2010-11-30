package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddVertexFunction extends AbstractFunction<Vertex> {

    private final static String FUNCTION_NAME = "add-v";

    public Atom<Vertex> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size > 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Graph graph;
        List<Object> objects = FunctionHelper.generateObjects(arguments);
        if (size > 0 && objects.get(0) instanceof Graph)
            graph = (Graph) objects.get(0);
        else
            graph = FunctionHelper.getGlobalGraph(context);

        final Object identifier;

        if (size == 0)
            return new Atom<Vertex>(graph.addVertex(null));
        else if (size == 1 && !(objects.get(0) instanceof Graph))
            identifier = objects.get(0);
        else
            identifier = objects.get(1);

        if (identifier instanceof Map) {
            final Map map = (Map) identifier;
            final Vertex vertex;
            if (map.containsKey(Tokens._ID)) {
                vertex = graph.addVertex(map.get(Tokens._ID));
            } else {
                vertex = graph.addVertex(null);
            }
            for (Object key : map.keySet()) {
                if (key instanceof String && !key.equals(Tokens._ID)) {
                    vertex.setProperty((String) key, map.get(key));
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

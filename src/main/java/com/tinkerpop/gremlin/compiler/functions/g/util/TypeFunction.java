package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TypeFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "type";
    private static final String ITERABLE = "iterable";
    private static final String MAP = "map";
    private static final String GRAPH = "graph";
    private static final String VERTEX = "vertex";
    private static final String EDGE = "edge";

    public Atom<String> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {

        if (parameters.size() == 1) {
            final Object object = parameters.get(0).compute().getValue();
            if (object instanceof Iterable)
                return new Atom<String>(ITERABLE);
            else if (object instanceof Map)
                return new Atom<String>(MAP);
            else if (object instanceof Graph)
                return new Atom<String>(GRAPH);
            else if (object instanceof Vertex)
                return new Atom<String>(VERTEX);
            else if (object instanceof Edge)
                return new Atom<String>(EDGE);
            else
                return new Atom<String>(object.getClass().getSimpleName().toLowerCase());
        } else
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}
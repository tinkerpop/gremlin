package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class IdVertexFunction extends AbstractFunction<Vertex> {

    private final static String FUNCTION_NAME = "id-v";

    public Atom<Vertex> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size == 0 || size > 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Graph graph;
        List<Object> objects = FunctionHelper.generateObjects(arguments);
        if (size > 0 && objects.get(0) instanceof Graph)
            graph = (Graph) objects.get(0);
        else
            graph = FunctionHelper.getGlobalGraph(context);

        final Object identifer;

        if (size == 2) {
            identifer = objects.get(1);
        } else {
            identifer = objects.get(0);
        }

        return new Atom<Vertex>(graph.getVertex(identifer));
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

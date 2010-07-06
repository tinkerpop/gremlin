package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.helpers.GraphFunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class IdFunction extends AbstractFunction<Vertex> {

    private final static String FUNCTION_NAME = "id";

    public Atom<Vertex> compute(List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 0 || parameters.size() > 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        Graph graph = null;
        Object identifer = null;

        // graph variable as first parameters
        if (parameters.size() == 2) {
            graph = GraphFunctionHelper.getGraph(parameters.get(0));
            identifer = parameters.get(1).compute().getValue();
        } else {
            // only identifier in parameters
            graph = GraphFunctionHelper.getGraph(null);
            identifer = parameters.get(0).compute().getValue();
        }

        return new Atom<Vertex>(graph.getVertex(identifer));
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

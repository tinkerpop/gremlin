package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.helpers.GraphFunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class IdFunction extends AbstractFunction {

    private final static String FUNCTION_NAME = "id";


    public Atom compute(List<Operation> params) throws RuntimeException {
        if (params.size() == 0 || params.size() > 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        Graph graph = null;
        Object identifer = null;

        // graph variable as first param
        if (params.size() == 2) {
            graph = GraphFunctionHelper.getGraph(params.get(0));
            identifer = params.get(1).compute().getValue();
        } else {
            // only identifier in params
            graph = GraphFunctionHelper.getGraph(null);
            identifer = params.get(0).compute().getValue();
        }

        return new Atom(graph.getVertex(identifer));
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

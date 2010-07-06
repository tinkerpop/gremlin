package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.helpers.GraphFunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class KeyFunction extends AbstractFunction {

    private static final String FUNCTION_NAME = "key";


    public Atom compute(List<Operation> params) throws RuntimeException {
        if (params.size() != 2 && params.size() != 3)
            throwUnsupportedArguments();

        Graph graph = null;
        String key = null;
        Object value = null;

        // graph variable as first param
        if (params.size() == 3) {
            graph = GraphFunctionHelper.getGraph(params.get(0));
            key = (String) params.get(1).compute().getValue();
            value = params.get(2).compute().getValue();
        } else {
            // only identifier in params
            graph = GraphFunctionHelper.getGraph(null);
            key = (String) params.get(0).compute().getValue();
            value = params.get(1).compute().getValue();
        }

        return new Atom(graph.getIndex().get(key, value));
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}
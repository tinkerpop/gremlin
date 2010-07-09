package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RemoveIndexFunction extends AbstractFunction<Boolean> {

    private final static String FUNCTION_NAME = "remove-idx";

    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {
        final int size = parameters.size();
        if (size == 0 || size > 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Graph graph = FunctionHelper.getGraph(parameters, 0);
        final String index;

        if (size == 2) {
            index = (String) parameters.get(1).compute().getValue();
        } else {
            index = (String) parameters.get(0).compute().getValue();
        }

        graph.getIndex().removeIndexKey(index);
        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.GraphFunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CloseFunction extends AbstractFunction<Boolean> {

    private final static String FUNCTION_NAME = "close";

    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() > 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        if (parameters.size() == 1) {
            GraphFunctionHelper.getGraph(parameters.get(0)).shutdown();
        } else {
            GraphFunctionHelper.getGraph(null).shutdown();
        }

        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

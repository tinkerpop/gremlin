package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnassignFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "unassign";

    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() != 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        String variable = (String) parameters.get(0).compute().getValue();
        GremlinEvaluator.freeVariable(variable);
        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

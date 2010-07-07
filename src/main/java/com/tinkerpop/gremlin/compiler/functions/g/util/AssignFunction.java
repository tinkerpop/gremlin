package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AssignFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "assign";

    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() != 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        String variable = (String) parameters.get(0).compute().getValue();
        Atom atom = parameters.get(1).compute();
        GremlinEvaluator.declareVariable(variable, atom);
        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

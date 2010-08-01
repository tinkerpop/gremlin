package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AssignFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "assign";

    public Atom<Boolean> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {
        if (parameters.size() != 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final String variable = (String) parameters.get(0).compute().getValue();
        final Atom atom = parameters.get(1).compute();
        context.getVariableLibrary().declare(variable, atom);
        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

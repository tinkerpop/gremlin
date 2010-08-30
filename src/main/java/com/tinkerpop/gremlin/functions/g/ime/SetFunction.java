package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SetFunction extends AbstractFunction<Set> {

    private static final String FUNCTION_NAME = "set";

    public Atom<Set> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final Set set = new HashSet();
        for (Operation operation : arguments) {
            set.add(operation.compute().getValue());
        }

        return new Atom<Set>(set);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

package com.tinkerpop.gremlin.compiler.functions.g.ime;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DeduplicateFunction extends AbstractFunction<Set> {

    private static final String FUNCTION_NAME = "dedup";

    public Atom<Set> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() == 0) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            final Set set = new HashSet();
            for (Operation operation : arguments) {
                FlattenFunction.flatten(set, operation.compute().getValue());
            }
            return new Atom<Set>(set);
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
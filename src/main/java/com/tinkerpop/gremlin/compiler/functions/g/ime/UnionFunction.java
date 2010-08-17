package com.tinkerpop.gremlin.compiler.functions.g.ime;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.pipes.PipeHelper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnionFunction extends AbstractFunction<Set> {

    private static final String FUNCTION_NAME = "union";

    public Atom<Set> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() < 2) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            final Set set = new HashSet();
            for (Operation operation : arguments) {
                final Object object = operation.compute().getValue();
                if (object instanceof Iterable) {
                     PipeHelper.fillCollection(((Iterable) object).iterator(), set);
                } else {
                    set.add(object);
                }

            }
            return new Atom<Set>(set);
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
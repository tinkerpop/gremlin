package com.tinkerpop.gremlin.compiler.functions.g.ime;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.Collection;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RetainFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "retain";

    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() != 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Object check = arguments.get(0).compute().getValue();
        final Object point = context.getCurrentPoint();

        if (check instanceof Collection) {
            return new Atom<Boolean>(((Collection) check).contains(point));
        } else if (check instanceof Iterable) {
            for (Object check2 : (Iterable) check) {
                if (check2.equals(point))
                    return new Atom<Boolean>(true);
            }
            return new Atom<Boolean>(false);
        } else {
            return new Atom<Boolean>(check.equals(point));
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

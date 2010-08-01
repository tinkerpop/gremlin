package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.Collection;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RetainFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "retain";

    public Atom<Boolean> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {
        if (parameters.size() != 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Object object = parameters.get(0).compute().getValue();
        final Object check = parameters.get(1).compute().getValue();
        if (check instanceof Collection) {
            return new Atom<Boolean>(((Collection) check).contains(object));
        } else if (check instanceof Iterable) {
            for (Object check2 : (Iterable<Atom>) check) {
                if (check2.equals(object))
                    return new Atom<Boolean>(true);
            }
            return new Atom<Boolean>(false);
        } else {
            return new Atom<Boolean>(check.equals(object));
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

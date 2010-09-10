package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.Collection;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IncludesFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "includes";

    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() != 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        Object itty = arguments.get(0).compute().getValue();
        Object object = arguments.get(1).compute().getValue();


        if (itty instanceof Collection) {
            return new Atom<Boolean>(((Collection) itty).contains(object));
        } else if (itty instanceof Iterable) {
            for (Object o : (Iterable) itty) {
                if (object.equals(o))
                    return new Atom<Boolean>(true);
            }
            return new Atom<Boolean>(false);
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

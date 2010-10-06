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
public class AppendFunction extends AbstractFunction<Collection> {

    private static final String FUNCTION_NAME = "append";

    public Atom<Collection> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() > 1) {
            final Collection collection = (Collection) arguments.get(0).compute().getValue();
            for (int i = 1; i < arguments.size(); i++) {
                collection.add(arguments.get(i).compute().getValue());
            }
            return new Atom<Collection>(collection);

        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
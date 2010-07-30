package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class KeysFunction extends AbstractFunction<Iterable> {

    private static final String FUNCTION_NAME = "keys";

    public Atom<Iterable> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {

        if (parameters.size() != 1) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            final Object object = parameters.get(0).compute().getValue();
            if (object instanceof Map) {
                return new Atom<Iterable>(((Map) object).keySet());
            } else if (object instanceof Element) {
                return new Atom<Iterable>(((Element) object).getPropertyKeys());
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

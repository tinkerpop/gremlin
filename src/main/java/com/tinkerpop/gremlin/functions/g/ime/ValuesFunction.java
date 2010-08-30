package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ValuesFunction extends AbstractFunction<Iterable> {

    private static final String FUNCTION_NAME = "values";

    public Atom<Iterable> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() != 1) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            final Object object = arguments.get(0).compute().getValue();
            if (object instanceof Map) {
                return new Atom<Iterable>(((Map) object).values());
            } else if (object instanceof Element) {
                final List values = new ArrayList();
                final Element element = (Element) object;
                for (final String key : element.getPropertyKeys()) {
                    values.add(element.getProperty(key));
                }
                return new Atom<Iterable>(values);
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

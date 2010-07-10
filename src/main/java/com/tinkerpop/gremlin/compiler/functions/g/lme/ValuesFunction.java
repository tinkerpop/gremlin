package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ValuesFunction extends AbstractFunction<Iterable> {

    private static final String FUNCTION_NAME = "values";

    public Atom<Iterable> compute(final List<Operation> parameters) throws RuntimeException {

        if (parameters.size() != 1) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            final Object object = parameters.get(0).compute().getValue();
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

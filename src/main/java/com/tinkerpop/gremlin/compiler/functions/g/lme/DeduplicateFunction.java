package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DeduplicateFunction extends AbstractFunction<Iterable> {

    private static final String FUNCTION_NAME = "dedup";

    public Atom<Iterable> compute(final List<Operation> parameters) throws RuntimeException {

        if (parameters.size() == 0) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            final Set set = new HashSet();
            for (Operation operation : parameters) {
                final Object object = operation.compute().getValue();
                if (object instanceof Iterable) {
                    for (Object object2 : (Iterable) object) {
                        set.add(object2);
                    }
                } else {
                    set.add(object);
                }

            }
            return new Atom<Iterable>(set);
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
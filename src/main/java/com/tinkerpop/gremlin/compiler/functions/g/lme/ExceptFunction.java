package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.Collection;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ExceptFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "except";

    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() != 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        Atom object = parameters.get(0).compute();
        Atom check = parameters.get(1).compute();
        if (check.isCollection()) {
            return new Atom<Boolean>(!((Collection) check.getValue()).contains(object));
        } else if (check.isIterable()) {
            for (Atom check2 : (Iterable<Atom>) check.getValue()) {
                if (check2.equals(object))
                    return new Atom<Boolean>(false);
            }
            return new Atom<Boolean>(true);
        } else {
            return new Atom<Boolean>(!check.equals(object));
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

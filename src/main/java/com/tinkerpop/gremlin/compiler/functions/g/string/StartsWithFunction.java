package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StartsWithFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "starts-with";


    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 2) {
            final String base = (String) parameters.get(0).compute().getValue();
            final String check = (String) parameters.get(1).compute().getValue();
            return new Atom<Boolean>(base.startsWith(check));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}
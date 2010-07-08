package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NormalizeSpaceFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "normalize-space";


    public Atom<String> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 1) {
            final String string = (String) parameters.get(0).compute().getValue();
            return new Atom<String>(string.trim());
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
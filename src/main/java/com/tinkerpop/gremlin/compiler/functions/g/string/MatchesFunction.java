package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MatchesFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "normalize-space";


    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 2) {
            String string = (String) parameters.get(0).compute().getValue();
            String regex = (String) parameters.get(1).compute().getValue();
            return new Atom<Boolean>(string.matches(regex));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
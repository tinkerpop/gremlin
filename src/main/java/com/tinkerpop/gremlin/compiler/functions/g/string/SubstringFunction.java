package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SubstringFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "substring";


    public Atom<String> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 2) {
            String string = (String) parameters.get(0).compute().getValue();
            Number start = (Number) parameters.get(1).compute().getValue();
            return new Atom<String>(string.substring(start.intValue()));
        } else if (parameters.size() == 3) {
            String string = (String) parameters.get(0).compute().getValue();
            Number start = (Number) parameters.get(1).compute().getValue();
            Number end = (Number) parameters.get(2).compute().getValue();
            return new Atom<String>(string.substring(start.intValue(), end.intValue()));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
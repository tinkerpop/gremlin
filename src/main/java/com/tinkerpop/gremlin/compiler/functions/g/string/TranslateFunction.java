package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TranslateFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "translate";


    public Atom<String> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 3) {
            String base = (String) parameters.get(0).compute().getValue();
            String check = (String) parameters.get(1).compute().getValue();
            String replace = (String) parameters.get(2).compute().getValue();
            return new Atom<String>(base.replace(check, replace));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
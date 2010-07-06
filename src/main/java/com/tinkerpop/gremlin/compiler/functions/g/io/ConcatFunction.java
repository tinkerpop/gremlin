package com.tinkerpop.gremlin.compiler.functions.g.io;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class ConcatFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "concat";


    public Atom<String> compute(final List<Operation> parameters) throws RuntimeException {
        String resultString = "";

        for (Operation operation : parameters) {
            resultString = resultString.concat(operation.compute().toString());
        }

        return new Atom<String>(resultString);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}

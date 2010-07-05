package com.tinkerpop.gremlin.compiler.functions.g.io;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class ConcatFunction implements Function {

    private final String FUNCTION_NAME = "concat";

    public Atom compute(final List<Operation> params) throws RuntimeException {
        String resultString = "";

        for (Operation operation : params) {
            resultString = resultString.concat(operation.compute().toString());
        }

        return new Atom(resultString);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}

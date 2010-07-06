package com.tinkerpop.gremlin.compiler.functions.g.io;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class ConcatFunction extends AbstractFunction {

    private static final String FUNCTION_NAME = "concat";


    public Atom compute(final List<Operation> params) throws RuntimeException {
        String resultString = "";

        for (Operation operation : params) {
            resultString = resultString.concat(operation.compute().toString());
        }

        return new Atom(resultString);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}

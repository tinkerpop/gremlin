package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class TimeFunction implements Function {

    private final String FUNCTION_NAME = "time";
    private final double ONE_MILLION = 1000000d;

    public Atom compute(final List<Operation> params) throws RuntimeException {
        if (params.size() == 0) {
            return new Atom(new Double(System.nanoTime() / ONE_MILLION));
        } else if (params.size() == 1) {
            Object time = params.get(0).compute().getValue();
            if (time instanceof Number) {
                return new Atom((System.nanoTime() / ONE_MILLION) - (Double) time);
            }
        }

        throw new RuntimeException(Function.UNSUPPORTED_ARGUMENTS + this.FUNCTION_NAME);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}

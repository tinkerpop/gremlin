package com.tinkerpop.gremlin.compiler.operations.math;

import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class Division extends MathOperation {

    public Division(final Operation... operands) {
        super(operands);
    }

    protected Number doOperation(final Number a, final Number b) {
        return a.doubleValue() / b.doubleValue();
    }

}

package com.tinkerpop.gremlin.compiler.operations.math;

import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Modulo extends MathOperation {

    public Modulo(final Operation... operands) {
        super(operands);
    }

    protected Number doOperation(final Number a, final Number b) {
        if (a instanceof Double || b instanceof Double)
            return a.doubleValue() % b.doubleValue();

        if (a instanceof Float || b instanceof Float)
            return a.floatValue() % b.floatValue();

        if (a instanceof Long || b instanceof Long)
            return a.longValue() % b.longValue();

        if (a instanceof Integer || b instanceof Integer)
            return a.intValue() % b.intValue();

        return null;
    }

}

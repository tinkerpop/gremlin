package com.tinkerpop.gremlin.compiler.operations.math;

import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Pavel A. Yaskevich
 */
public class Addition extends MathOperation {

    public Addition(final Operation... operands) {
        super(operands);
    }

    public Atom compute() {
        Object a = this.operands[0].compute().getValue();
        Object b = this.operands[1].compute().getValue();

        if (a instanceof String || b instanceof String) {
            return new Atom<String>(a.toString() + b.toString());
        } else {
            return new Atom<Number>(doOperation((Number) a, (Number) b));
        }
    }

    protected Number doOperation(final Number a, final Number b) {
        if (a instanceof Double || b instanceof Double)
            return a.doubleValue() + b.doubleValue();

        if (a instanceof Float || b instanceof Float)
            return a.floatValue() + b.floatValue();

        if (a instanceof Long || b instanceof Long)
            return a.longValue() + b.longValue();

        if (a instanceof Integer || b instanceof Integer)
            return a.intValue() + b.intValue();

        return null;
    }

}

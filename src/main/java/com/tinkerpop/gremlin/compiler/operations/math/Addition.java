package com.tinkerpop.gremlin.compiler.operations.math;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class Addition extends BinaryOperation {

    public Addition(final Operation... operands) {
        super(operands);
    }

    public Atom compute() {
        Object a = this.operands[0].compute().getValue();
        Object b = this.operands[1].compute().getValue();
        
        if (a instanceof String || b instanceof String) {
            return new Atom<String>(a.toString() + b.toString());
        } else {
            return new Atom<Number>(add((Number) a, (Number) b));
        }
    }

    private Number add(Number a, Number b) {
        if (a instanceof Integer)
            return a.intValue() + b.intValue();

        if (a instanceof Long)
            return a.longValue() + b.longValue();

        if (a instanceof Float)
            return a.floatValue() + b.floatValue();

        if (a instanceof Double)
            return a.doubleValue() + b.doubleValue();

        return null;
    }

    public Type getType() {
        return Type.MATH;
    }

}

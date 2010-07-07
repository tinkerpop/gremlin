package com.tinkerpop.gremlin.compiler.operations.math;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class Multiplication extends BinaryOperation {

    public Multiplication(final Operation... operands) {
        super(operands);
    }

    public Atom<Number> compute() {
        Atom<Number> a = this.operands[0].compute();
        Atom<Number> b = this.operands[1].compute();

        return new Atom<Number>(multiply(a.getValue(), b.getValue()));
    }

    private Number multiply(Number a, Number b) {
        if (a instanceof Integer)
            return a.intValue() * b.intValue();

        if (a instanceof Long)
            return a.longValue() * b.longValue();

        if (a instanceof Float)
            return a.floatValue() * b.floatValue();

        if (a instanceof Double)
            return a.doubleValue() * b.doubleValue();

        return null;
    }

    public Type getType() {
        return Type.MATH;
    }

}

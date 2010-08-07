package com.tinkerpop.gremlin.compiler.operations.math;

import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Pavel A. Yaskevich
 */
public class Division extends BinaryOperation {

    public Division(final Operation... operands) {
        super(operands);
    }

    public Atom<Number> compute() {
        Atom<Number> a = this.operands[0].compute();
        Atom<Number> b = this.operands[1].compute();

        return new Atom<Number>(divide(a.getValue(), b.getValue()));
    }

    private Number divide(Number a, Number b) {
        return a.doubleValue() / b.doubleValue();
    }

    public Type getType() {
        return Type.MATH;
    }

}

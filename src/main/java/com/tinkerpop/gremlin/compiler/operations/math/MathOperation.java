package com.tinkerpop.gremlin.compiler.operations.math;

import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class MathOperation extends BinaryOperation {

    public MathOperation(final Operation... operands) {
        super(operands);
    }

    public Atom<Number> compute() {
        Atom<Number> a = this.operands[0].compute();
        Atom<Number> b = this.operands[1].compute();

        return new Atom<Number>(doOperation(a.getValue(), b.getValue()));
    }

    protected abstract Number doOperation(Number a, Number b);

    public Type getType() {
        return Type.MATH;
    }
}

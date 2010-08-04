package com.tinkerpop.gremlin.compiler.operations;

import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Pavel A. Yaskevich
 */
public class UnaryOperation implements Operation {

    private Atom operand;

    public UnaryOperation(Atom op) {
        this.operand = op;
    }

    public Atom compute() {
        return this.operand;
    }

    public Type getType() {
        if (this.operand.isNull()) {
            return Type.MATH;
        } else {
            return (this.operand.isNumber()) ? Type.MATH : Type.LOGIC;
        }
    }

    public static <T> Operation createUnaryOperation(T object) {
        return new UnaryOperation(new Atom<T>(object));
    }

}

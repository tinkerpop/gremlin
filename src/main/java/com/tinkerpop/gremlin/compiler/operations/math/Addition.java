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
            return new Atom(a.toString() + b.toString());
        } else {
            return new Atom((Double) a + (Double) b);
        }
    }

    public Type getType() {
        return Type.MATH;
    }

}

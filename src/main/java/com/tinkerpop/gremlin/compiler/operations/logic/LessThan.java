package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Pavel A. Yaskevich
 */
public class LessThan extends BinaryOperation {

    public LessThan(final Operation... operands) {
        super(operands);
    }

    public Atom<Boolean> compute() {
        Object a = this.operands[0].compute().getValue();
        Object b = this.operands[1].compute().getValue();
        if (a instanceof Comparable) {
            int comparison = ((Comparable) a).compareTo(b);
            return new Atom<Boolean>(comparison < 0);
        } else {
            throw new RuntimeException(a + " and " + b + " are incomparable objects");
        }

    }

    public Type getType() {
        return Type.LOGIC;
    }

}

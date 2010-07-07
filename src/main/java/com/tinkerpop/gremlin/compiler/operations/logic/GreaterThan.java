package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class GreaterThan extends BinaryOperation {

    public GreaterThan(final Operation... operands) {
        super(operands);
    }

    public Atom<Boolean> compute() {
        Number a = (Number) this.operands[0].compute().getValue();
        Number b = (Number) this.operands[1].compute().getValue();

        return new Atom<Boolean>((a.doubleValue() > b.doubleValue()));
    }

    public Type getType() {
        return Type.LOGIC;
    }

}

package com.tinkerpop.gremlin.compiler.operations;

import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Pavel A. Yaskevich
 */
public abstract class BinaryOperation implements Operation {

    protected Operation[] operands;

    public BinaryOperation(final Operation... operands) {
        this.operands = operands;
    }

    public Operation[] getOperands() {
        return this.operands;
    }

    protected boolean parseBoolean(Atom atom) {
        Object object = atom.getValue();

        if (object instanceof Number) {
            return ((Number) object).doubleValue() > 0;
        } else
            return Boolean.parseBoolean(object.toString());
    }
}

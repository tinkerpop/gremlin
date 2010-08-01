package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class Equality extends BinaryOperation {

    public Equality(final Operation... operands) {
        super(operands);
    }

    public Atom<Boolean> compute() {
        final Object a = this.operands[0].compute().getValue();
        final Object b = this.operands[1].compute().getValue();
        if (a == null && b == null)
            return new Atom<Boolean>(true);
        else if (a == null || b == null)
            return new Atom<Boolean>(false);
        else
            return new Atom<Boolean>(a.equals(b));
    }

    public Type getType() {
        return Type.LOGIC;
    }

}

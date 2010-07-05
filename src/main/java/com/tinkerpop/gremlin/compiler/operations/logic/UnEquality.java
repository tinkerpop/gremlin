package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class UnEquality extends BinaryOperation {

    public UnEquality(final Operation... operands) {
        super(operands);
    }

    public Atom compute() {
        Atom exprResultAtom = new Equality(this.operands[0], this.operands[1]).compute();
        return new Atom((Boolean) exprResultAtom.getValue() == false);
    }

    public Type getType() {
        return Type.LOGIC;
    }

}

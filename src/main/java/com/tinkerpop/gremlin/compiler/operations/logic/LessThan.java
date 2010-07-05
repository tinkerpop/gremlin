package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class LessThan extends BinaryOperation {

    public LessThan(final Operation... operands) {
        super(operands);
    }

    public Atom compute() {
        Double a = (Double) this.operands[0].compute().getValue();
        Double b = (Double) this.operands[1].compute().getValue();

        return new Atom((a < b) ? true : false);
    }

    public Type getType() {
        return Type.LOGIC;
    }

}

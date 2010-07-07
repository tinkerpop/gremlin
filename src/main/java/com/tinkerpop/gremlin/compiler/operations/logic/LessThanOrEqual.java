package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class LessThanOrEqual extends BinaryOperation {

    public LessThanOrEqual(final Operation... operands) {
        super(operands);
    }

    public Atom<Boolean> compute() {
        Atom aAtom = this.operands[0].compute();
        Atom bAtom = this.operands[1].compute();
        
        Double a = ((Number) aAtom.getValue()).doubleValue();
        Double b = ((Number) bAtom.getValue()).doubleValue();

        return new Atom<Boolean>(((a < b) || (a.compareTo(b) == 0)));
    }

    public Type getType() {
        return Type.LOGIC;
    }

}

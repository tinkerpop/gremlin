package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Pavel A. Yaskevich
 */
public class And extends LogicOperation {

    public And(final Operation... operands) {
        super(operands);
    }

    public Atom<Boolean> compute() {
        final Atom a = this.operands[0].compute();
        final Atom b = this.operands[1].compute();

        return new Atom<Boolean>((this.parseBoolean(a) && this.parseBoolean(b)));
    }
}

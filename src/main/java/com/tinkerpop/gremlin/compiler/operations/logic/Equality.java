package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez
 */
public class Equality extends LogicOperation {

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
        else {
            //if (a instanceof Number && b instanceof Number) {
            //    return new Atom<Boolean>(((Number) a).doubleValue() == ((Number) a).doubleValue());
            //} else {
                return new Atom<Boolean>(a.equals(b));
            //}
        }
    }

}

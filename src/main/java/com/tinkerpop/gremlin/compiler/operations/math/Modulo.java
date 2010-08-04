package com.tinkerpop.gremlin.compiler.operations.math;

import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Modulo extends BinaryOperation {

    public Modulo(final Operation... operands) {
        super(operands);
    }

    public Atom<Number> compute() {
        Atom<Number> a = this.operands[0].compute();
        Atom<Number> b = this.operands[1].compute();

        return new Atom<Number>(modulo(a.getValue(), b.getValue()));
    }

    private Number modulo(Number a, Number b) {
         if (a instanceof Double || b instanceof Double)
            return a.doubleValue() % b.doubleValue();

        if (a instanceof Float || b instanceof Float)
            return a.floatValue() % b.floatValue();

        if (a instanceof Long || b instanceof Long)
            return a.longValue() % b.longValue();

        if (a instanceof Integer || b instanceof Integer)
            return a.intValue() % b.intValue();

        return null;
    }

    public Type getType() {
        return Type.MATH;
    }

}

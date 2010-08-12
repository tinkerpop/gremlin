package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class LogicOperation extends BinaryOperation {

    public LogicOperation(final Operation... operands) {
        super(operands);
    }

    public abstract Atom<Boolean> compute();

    public Type getType() {
        return Type.LOGIC;
    }
}

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

    public Atom<Boolean> compute() {
           final Object a = this.operands[0].compute().getValue();
           final Object b = this.operands[1].compute().getValue();
           return new Atom<Boolean>(!a.equals(b));
       }


    public Type getType() {
        return Type.LOGIC;
    }

}

package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class Equality extends BinaryOperation {

    public Equality(final Operation... operands) {
        super(operands);
    }

    public Atom compute() {
        Atom a = this.operands[0].compute();
        Atom b = this.operands[1].compute();

        Boolean exprResult;

        if (!a.isNumber() && !b.isNumber()) {
            String aString = (String) a.getValue();
            String bString = (String) b.getValue();

            exprResult = (aString.equals(bString));
        } else {
            Double aDouble = ((Number) a.getValue()).doubleValue();
            Double bDouble = ((Number) b.getValue()).doubleValue();

            exprResult = (aDouble.compareTo(bDouble) == 0);
        }

        return new Atom<Boolean>(exprResult);
    }

    public Type getType() {
        return Type.LOGIC;
    }

}

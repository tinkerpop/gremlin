package com.tinkerpop.gremlin.compiler.operations.logic;

import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.Atom;

/**
 * @author Pavel A. Yaskevich
 */
public class And extends BinaryOperation {

	public And(final Operation... operands) {
		super(operands);
	}
	
    public Atom compute() {
        Type aType = this.operands[0].getType();
        Type bType = this.operands[1].getType();

        Atom resultA = this.operands[0].compute();                   
        Atom resultB = this.operands[1].compute();
        
        Boolean exprResult;
        
        if (aType == Type.LOGIC && bType == Type.LOGIC) {
        	exprResult = ((Boolean)resultA.getValue() && (Boolean)resultB.getValue()) ? true : false;
        } else if (aType == Type.MATH && bType == Type.LOGIC) {
        	exprResult = (resultA.isNull() == false && (Boolean)resultB.getValue()) ? true : false;
        } else if (aType == Type.LOGIC && bType == Type.MATH) {
            exprResult = ((Boolean)resultA.getValue() && resultB.isNull() == false) ? true : false;
        } else {
        	exprResult = (resultA.isNull() == false && resultB.isNull() == false) ? true : false;
        }
        
        return new Atom(exprResult);
    }

    public Type getType() {
        return Type.LOGIC;
    }

}

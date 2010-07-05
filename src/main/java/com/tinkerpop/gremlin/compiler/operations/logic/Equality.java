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
        
        if(!a.isNumber() && !b.isNumber()) {
        	String aString = (String)a.getValue();
        	String bString = (String)b.getValue();
        	
            exprResult = (aString.equals(bString)) ? true : false;
        } else {
        	Double aDouble = (Double)a.getValue();
        	Double bDouble = (Double)b.getValue();
        	
        	exprResult = (aDouble.compareTo(bDouble) == 0) ? true : false;
        }
        
        return new Atom(exprResult);
    }

    public Type getType() {
        return Type.LOGIC;
    }

}

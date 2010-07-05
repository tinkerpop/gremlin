package com.tinkerpop.gremlin.compiler.operations;

import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.Atom;

/**
 * @author Pavel A. Yaskevich
 */
public class UnaryOperation implements Operation {
    
    private Atom operand;

    public UnaryOperation(Atom op) {
        this.operand = op;
    }

    public Atom compute() {
    	return (this.operand.isPersistent()) ? this.operand : this.operand.recalculated();
    }

    public Type getType() {
    	if (this.operand.isNull()) {
    		return Type.MATH;
    	} else {
    		return (this.operand.isNumber()) ? Type.MATH : Type.LOGIC;
    	}
    }
}

package com.tinkerpop.gremlin.compiler.operations;

/**
 * @author Pavel A. Yaskevich
 */
public abstract class BinaryOperation implements Operation {

	protected Operation[] operands;
	
	public BinaryOperation(final Operation... operands) {
		this.operands = operands;
	}
	
	public Operation[] getOperands() {
		return this.operands;
	}
	
}

package com.tinkerpop.gremlin.compiler.statements;

import java.util.List;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class If implements Operation {

	private Operation condition;
	private List<Operation> statements;
	
	/*
	 * $x := 0 
	 * $y := 5
	 * $z := 7
	 * 
	 * if $x > 0 or ($y + 2) <= 5 or ($z - 1) >= 6
	 *    ...do something...
	 * end
	 */
	public If(Operation cond, List<Operation> block) {
		this.condition  = cond;
		this.statements = block;
	}
	
	public Atom compute() {
		Atom condResult  = this.condition.compute();
		
		if (condResult.isNull() == false) {
			if ((Boolean)condResult.getValue() == true) {
				for (int i = 0; i < this.statements.size(); i++) {
					this.statements.get(i).compute();
				}
			}
		}
		
		return new Atom(null);
	}

	public Type getType() {
		return Type.STATEMENT;
	}

}

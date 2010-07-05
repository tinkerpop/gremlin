package com.tinkerpop.gremlin.compiler.functions.g.io;

import java.util.List;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class PrintFunction implements Function {

	private final String FUNCTION_NAME = "print";
	
	public Atom compute(final List<Operation> params) throws RuntimeException {
		
		for(Operation o : params) {
			System.out.println(o.compute());
		}
		
		return new Atom(null);
	}
	
	public String getFunctionName() {
		return this.FUNCTION_NAME;
	}

}

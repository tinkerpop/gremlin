package com.tinkerpop.gremlin.compiler.functions.g.io;

import java.util.List;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class ConcatFunction implements Function {

	private final String FUNCTION_NAME = "concat";
	
	public Atom compute(final List<Operation> params) throws RuntimeException {
		String resultString = "";
		
		for(Operation o : params) {
			resultString = resultString.concat(o.compute().toString());
		}
		
		return new Atom(resultString);
	}
	
	public String getFunctionName() {
		return this.FUNCTION_NAME;
	}
}

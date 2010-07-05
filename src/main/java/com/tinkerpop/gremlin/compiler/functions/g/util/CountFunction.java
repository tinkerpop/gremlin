package com.tinkerpop.gremlin.compiler.functions.g.util;

import java.util.List;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class CountFunction implements Function {

	private final String FUNCTION_NAME = "count";
	
	@SuppressWarnings("unchecked")
	public Atom compute(final List<Operation> params) throws RuntimeException {
		if (params.size() != 1)
			throw new RuntimeException("Supports only one argument.");
		
		Atom result = params.get(0).compute();
		
		if (result.isArray()) {
			List<Object> arr = (List<Object>)result.getValue();
			return new Atom(arr.size());
		} else {
			return new Atom(1);
		}
	}

	public String getFunctionName() {
		return this.FUNCTION_NAME;
	}

}

package com.tinkerpop.gremlin.compiler.functions;

import java.util.List;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public interface Function {
	
	public Atom compute(final List<Operation> params) throws RuntimeException;

	public String getFunctionName();
	
}

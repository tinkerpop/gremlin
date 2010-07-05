package com.tinkerpop.gremlin.compiler.functions.tg;

import java.util.List;

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class OpenFunction implements Function {

	private final String FUNCTION_NAME = "open";
	
	public Atom compute(List<Operation> params) throws RuntimeException {
		
		if (params.size() == 0) {
            return new Atom(new TinkerGraph());
        }
		
		throw new RuntimeException("Unsupported arguments for tg:open().");
	}

	public String getFunctionName() {
		return this.FUNCTION_NAME;
	}
	
}

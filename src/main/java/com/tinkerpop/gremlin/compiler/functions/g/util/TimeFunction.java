package com.tinkerpop.gremlin.compiler.functions.g.util;

import java.util.List;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class TimeFunction implements Function {

	private final String FUNCTION_NAME = "time";
	
	public Atom compute(final List<Operation> params) throws RuntimeException {
		if (params.size() == 0) {
            return new Atom(new Long(System.currentTimeMillis()).doubleValue());
        } else if (params.size() == 1) {
        	Object time = params.get(0).compute().getValue();
        	
            if (time instanceof Number) {
            	return new Atom(System.currentTimeMillis() - (Double)time);
            }
        }
        	
		throw new RuntimeException("Unsupported arguments for g:time() function.");
	}

	public String getFunctionName() {
		return this.FUNCTION_NAME;
	}

}

package com.tinkerpop.gremlin.compiler.functions.g.lme;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class MapFunction implements Function {

	private final String FUNCTION_NAME = "map";
	
	public Atom compute(List<Operation> params) throws RuntimeException {
		Map<String, Atom> map = new HashMap<String, Atom>();
		
		if (params.size() % 2 != 0)
			throw new RuntimeException("Unsupported arguments for g:map().");
		
		for (int i = 0; i < params.size(); i+=2) {
			if (i == params.size()) 
				break;
			
			Atom key = params.get(i).compute();
			map.put((String)key.getValue(), params.get((i == 0) ? 1 : i - 1).compute());
		}
		
		return new Atom(map);
	}

	public String getFunctionName() {
		return this.FUNCTION_NAME;
	}

}

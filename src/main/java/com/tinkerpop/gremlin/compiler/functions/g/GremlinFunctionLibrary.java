package com.tinkerpop.gremlin.compiler.functions.g;

import java.util.ArrayList;
import java.util.List;

import com.tinkerpop.gremlin.compiler.functions.Function;

import com.tinkerpop.gremlin.compiler.functions.g.graph.*;
import com.tinkerpop.gremlin.compiler.functions.g.io.*;
import com.tinkerpop.gremlin.compiler.functions.g.lme.*;
import com.tinkerpop.gremlin.compiler.functions.g.util.*;

/**
 * @author Pavel A. Yaskevich
 */
public class GremlinFunctionLibrary {
	
	public static List<Function> library() {
		List<Function> functions = new ArrayList<Function>();
		
		// io
		functions.add(new PrintFunction());
		functions.add(new ConcatFunction());
		
		// graph
		functions.add(new LoadFunction());
		functions.add(new IdFunction());
		
		// util
		functions.add(new CountFunction());
		functions.add(new TimeFunction());
		
		// list
		functions.add(new ListFunction());
		
		// map
		functions.add(new MapFunction());
		
		return functions;
	}
}

package com.tinkerpop.gremlin.compiler.operations.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.Pipeline;
import com.tinkerpop.pipes.SingleIterator;

public class GPathOperation implements Operation {

	@SuppressWarnings("rawtypes")
	private Pipeline pipeline;
	private final Object startPoint;
	
	@SuppressWarnings({ "rawtypes" })
	private final List<Pipe> pipes;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GPathOperation(List<Pipe> pipes, Object start) {
		this.pipes = pipes;
		this.pipeline = new Pipeline(this.pipes);
		this.startPoint = start;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Atom compute() {
		List<Object> results = new ArrayList<Object>();
		
		if (this.startPoint instanceof Iterator) {
			this.pipeline.setStarts((Iterator)this.startPoint);
		} else {
			this.pipeline.setStarts(new SingleIterator(this.startPoint));
		}
		
		while(this.pipeline.hasNext())
			results.add(this.pipeline.next());
		
        return new Atom(results);
	}

	public Type getType() {
		return Type.STATEMENT;
	}

	@SuppressWarnings("rawtypes")
	public List<Pipe> getPipes() {
		return this.pipes;
	}
}

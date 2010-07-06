package com.tinkerpop.gremlin.compiler.operations.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.pipes.GremlinPipesHelper;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.Pipeline;
import com.tinkerpop.pipes.SingleIterator;

import java.util.Iterator;
import java.util.List;

public class GPathOperation implements Operation {

    private final Pipeline pipeline;
    private final Object startPoint;

    @SuppressWarnings({"rawtypes"})
    private final List<Pipe> pipes;

    @SuppressWarnings({"rawtypes", "unchecked"})
    public GPathOperation(List<Pipe> pipes, Object point) {
        this.pipes = pipes;
        this.pipeline = new Pipeline(this.pipes);
        this.startPoint = point;  
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public Atom compute() {
        this.pipeline.setStarts(GremlinPipesHelper.pipelineStartPoint(this.startPoint));
        
        Atom pipelineAtom = new Atom(this.pipeline);
        pipelineAtom.setStartPoint(this.startPoint);

        return pipelineAtom;
    }

    public Type getType() {
        return Type.STATEMENT;
    }
    
    @SuppressWarnings("rawtypes")
    public List<Pipe> getPipes() {
        return this.pipes;
    }
}

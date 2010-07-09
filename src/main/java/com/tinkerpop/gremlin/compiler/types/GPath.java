package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.pipes.GremlinPipesHelper;
import com.tinkerpop.gremlin.compiler.pipes.GremlinRangeFilterPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.Pipeline;

import java.util.Iterator;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class GPath implements Iterable {

    private final Object start;
    private final List<Pipe> pipes;

    public GPath(final Object startPoint, final List<Pipe> pipes) {
        this.pipes = pipes;
        this.start = startPoint;
    }
    
    public Iterator iterator() {
        for(Pipe p : this.pipes) {
            if (p instanceof GremlinRangeFilterPipe) {
                ((GremlinRangeFilterPipe) p).reset();
            }
        }
        Pipeline pipeline = new Pipeline(this.pipes);
        pipeline.setStarts(GremlinPipesHelper.pipelineStartPoint(this.start));
        return pipeline;
    }
}

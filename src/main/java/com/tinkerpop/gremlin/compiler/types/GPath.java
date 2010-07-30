package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
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

    private final List<Pipe> pipes;
    private final Atom<Object> root;
    private Object persistentRoot = null;

    public GPath(final Atom<Object> root, final List<Pipe> pipes, final GremlinScriptContext context) {
        this.root  = root;
        this.pipes = pipes;

        if (!(root instanceof DynamicEntity)) {
            if (root.toString().equals(".") && root.isIdentifier()) {
                this.persistentRoot = ((Atom) context.getVariableLibrary().get(Tokens.ROOT_VARIABLE)).getValue();
            }
        }
    }
    
    public Iterator iterator() {
        for(Pipe p : this.pipes) {
            if (p instanceof GremlinRangeFilterPipe) {
                ((GremlinRangeFilterPipe) p).reset();
            }
        }
        
        Pipeline pipeline = new Pipeline(this.pipes);
        pipeline.setStarts(GremlinPipesHelper.pipelineStartPoint(((persistentRoot == null) ? root.getValue() : persistentRoot)));
        return pipeline;
    }
    
}

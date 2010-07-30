package com.tinkerpop.gremlin.compiler.operations.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.GPath;
import com.tinkerpop.pipes.Pipe;

import java.util.List;

public class GPathOperation implements Operation {

    private final Atom<Object> root;
    private final List<Pipe> pipes;
    private final GremlinScriptContext context;
    
    public GPathOperation(List<Pipe> pipes, Atom<Object> root, final GremlinScriptContext context) {
        this.root = root;
        this.pipes = pipes;
        this.context = context;
    }

    public Atom compute() {
        return new Atom<GPath>(new GPath(this.root, this.pipes, this.context));
    }

    public Type getType() {
        return Type.STATEMENT;
    }

    public List<Pipe> getPipes() {
        return this.pipes;
    }
}

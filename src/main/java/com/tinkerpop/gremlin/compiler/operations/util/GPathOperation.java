package com.tinkerpop.gremlin.compiler.operations.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.GPath;
import com.tinkerpop.pipes.Pipe;

import java.util.List;

public class GPathOperation implements Operation {

    private final Atom<Object> root;
    private final List<Pipe> pipes;

    public GPathOperation(List<Pipe> pipes, Atom<Object> root) {
        this.root = root;
        this.pipes = pipes;
    }

    public Atom compute() {
        return new Atom<GPath>(new GPath(this.root, this.pipes));
    }

    public Type getType() {
        return Type.STATEMENT;
    }

    public List<Pipe> getPipes() {
        return this.pipes;
    }
}

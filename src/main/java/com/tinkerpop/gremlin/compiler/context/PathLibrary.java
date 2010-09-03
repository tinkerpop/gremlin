package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.pipes.Pipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathLibrary {

    private Map<String, List<Pipe>> paths;

    public PathLibrary() {
        this.paths = new HashMap<String, List<Pipe>>();
    }

    public void registerPath(final String id, final List<Pipe> pipes) {
        this.paths.put(id, pipes);
    }

    public List<Pipe> getPath(final String id) {
        return this.paths.get(id);
    }

    public boolean isPath(final String id) {
        return (this.paths.get(id) == null) ? false : true;
    }
}

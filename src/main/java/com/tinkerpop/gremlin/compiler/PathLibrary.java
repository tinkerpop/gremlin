package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.pipes.Pipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathLibrary {

    @SuppressWarnings("rawtypes")
    private Map<String, List<Pipe>> paths;

    @SuppressWarnings("rawtypes")
    public PathLibrary() {
        this.paths = new HashMap<String, List<Pipe>>();
    }

    @SuppressWarnings("rawtypes")
    public void registerPath(String id, List<Pipe> pipes) {
        this.paths.put(id, pipes);
    }

    @SuppressWarnings("rawtypes")
    public List<Pipe> getPath(String id) {
        return this.paths.get(id);
    }

    public boolean isPath(String id) {
        return (this.paths.get(id) == null) ? false : true;
    }
}

package com.tinkerpop.gremlin.compiler.lib;

import com.tinkerpop.pipes.Pipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathLibrary {

    private Map<String, List<Pipe>> paths;

    public PathLibrary() {
        this.paths = new HashMap<String, List<Pipe>>();
    }

    public void registerPath(String id, List<Pipe> pipes) {
        this.paths.put(id, pipes);
    }

    public List<Pipe> getPath(String id) {
        return this.paths.get(id);
    }

    public boolean isPath(String id) {
        return (this.paths.get(id) == null) ? false : true;
    }
}

package com.tinkerpop.gremlin.db.mini;

import java.util.Map;
import java.util.HashMap;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MiniGraph {

    protected Map<String, MiniVertex> vertices;

    public MiniGraph() {
        this.vertices = new HashMap<String, MiniVertex>();
    }

    public void addVertex(MiniVertex vertex) {
        this.vertices.put(vertex.getId(),vertex);
    }

    public MiniVertex getVertex(String id) {
        return this.vertices.get(id);
    }
}

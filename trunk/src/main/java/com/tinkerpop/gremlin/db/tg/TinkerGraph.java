package com.tinkerpop.gremlin.db.tg;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraph {

    protected Map<String, TinkerVertex> vertices;

    public TinkerGraph() {
        this.vertices = new HashMap<String, TinkerVertex>();
    }

    public void addVertex(TinkerVertex vertex) {
        this.vertices.put(vertex.getId(), vertex);
    }

    public TinkerVertex getVertex(String id) {
        return this.vertices.get(id);
    }
}

package com.tinkerpop.gremlin.model;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public interface Graph {

    public Vertex getVertex(Object indexKey);

    public void shutdown();
}

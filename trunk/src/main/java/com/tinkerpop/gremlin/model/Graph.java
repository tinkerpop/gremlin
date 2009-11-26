package com.tinkerpop.gremlin.model;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public interface Graph {

    public Vertex getVertex(Object id);

    public void removeVertex(Object id);
    // public void addVertex(Vertex vertex) TODO what is the best model?

    public void shutdown();
}

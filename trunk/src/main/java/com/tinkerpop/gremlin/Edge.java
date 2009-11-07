package com.tinkerpop.gremlin;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public interface Edge {
    public Vertex getOutVertex();
    public Vertex getInVertex();
    public String getEdgeLabel();
}

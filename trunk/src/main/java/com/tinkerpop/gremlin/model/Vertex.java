package com.tinkerpop.gremlin.model;

import java.util.Set;

/**
 * A vertex maintains pointers to both a set of incoming and outgoing edges.
 * The outgoing edges are those edges for which the vertex is the tail.
 * The incoming edges are those edges for which the vertex is the head.
 * Digramatically, ---inEdges---> vertex ---outEdges--->.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface Vertex extends Element {

    /**
     * The set of edges emanating from, or leaving, the vertex.
     *
     * @return the edges for which the vertex is the tail
     */
    public Set<Edge> getOutEdges();

    /**
     * The set of edges incoming to, or arriving at, the vertex.
     *
     * @return the edges for which the vertex is the head
     */
    public Set<Edge> getInEdges();


    /**
     * The set of all edges for which the vertex is the head or tail.
     * This method should return the union of both the inEdges and outEdges of the vertex.
     *
     * @return all the edges for which the vertex is the head or tail.
     */
    public Set<Edge> getBothEdges();

}

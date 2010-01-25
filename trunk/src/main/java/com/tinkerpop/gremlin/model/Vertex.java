package com.tinkerpop.gremlin.model;

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
     * The edges emanating from, or leaving, the vertex.
     *
     * @return the edges for which the vertex is the tail
     */
    public Iterable<Edge> getOutEdges();

    /**
     * The edges incoming to, or arriving at, the vertex.
     *
     * @return the edges for which the vertex is the head
     */
    public Iterable<Edge> getInEdges();

}

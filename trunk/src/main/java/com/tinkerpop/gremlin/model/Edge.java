package com.tinkerpop.gremlin.model;

import java.util.List;

/**
 * An edge links two vertices. Along with its key/value propertiees, an edge has both a directionality and a label.
 * The directionality determines which vertex is the tail vertex (out vertex) and which vertex is the head vertex (in vertex).
 * The edge label determines the type of relationship that exists between the two vertices.
 * Diagrammatically, outVertex ---label---> inVertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public interface Edge extends Element {

    /**
     * Return the vertex on the tail of the edge.
     *
     * @return the tail vertex
     */
    public Vertex getOutVertex();

    /**
     * Return the vertex on the head of the edge.
     *
     * @return the head vertex
     */
    public Vertex getInVertex();

    /**
     * Return an ordered list of length 2 containing the two vertices associated with the edge.
     * The tail vertex is the first in the list and the head vertex is the second in the list.
     *
     * @return an ordered list of the vertices associated with the edge
     */
    public List<Vertex> getBothVertices();

    /**
     * Return the label associated with the edge.
     *
     * @return the edge label
     */
    public String getLabel();

}

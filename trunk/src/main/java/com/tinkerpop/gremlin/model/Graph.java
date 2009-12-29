package com.tinkerpop.gremlin.model;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public interface Graph {

    public Vertex addVertex(Object id);

    public Vertex getVertex(Object id);

    public Iterable<Vertex> getVertices();

    public void removeVertex(Vertex vertex);

    public Edge addEdge(Object id, Vertex outVertex, Vertex inVertex, String label);

    public Iterable<Edge> getEdges();

    public void removeEdge(Edge edge);

    public Index getIndex();

    public void clear();

    public void shutdown();
}

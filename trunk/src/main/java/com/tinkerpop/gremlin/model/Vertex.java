package com.tinkerpop.gremlin.model;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public interface Vertex extends Element {

    public Set<Edge> getOutEdges();

    public Set<Edge> getInEdges();

    public Set<Edge> getBothEdges();

}

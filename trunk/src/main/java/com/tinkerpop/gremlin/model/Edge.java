package com.tinkerpop.gremlin.model;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public interface Edge extends Element {

    public Vertex getOutVertex();

    public Vertex getInVertex();

    public List<Vertex> getBothVertices();

    public String getLabel();

}

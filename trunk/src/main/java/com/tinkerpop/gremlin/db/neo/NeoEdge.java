package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.Edge;
import com.tinkerpop.gremlin.Vertex;
import org.neo4j.api.core.Relationship;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoEdge implements Edge {

    private Relationship relationship;

    public NeoEdge(Relationship relationship) {
        this.relationship = relationship;
    }

    public String getEdgeLabel() {
        return relationship.getType().name();
    }

    public Vertex getInVertex() {
        return new NeoVertex(relationship.getEndNode());
    }

    public Vertex getOutVertex() {
        return new NeoVertex(relationship.getStartNode());
    }

    public Relationship getEdgeObject() {
        return this.relationship;
    }
}

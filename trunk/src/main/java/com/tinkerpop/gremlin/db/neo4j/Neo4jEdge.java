package com.tinkerpop.gremlin.db.neo4j;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.db.StringFactory;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.graphdb.Relationship;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Neo4jEdge extends Neo4jElement implements Edge {

    public Neo4jEdge(Relationship relationship, Index index) {
        super(index);
        this.element = relationship;
    }

    public String getLabel() {
        return ((Relationship) this.element).getType().name();
    }

    public Vertex getOutVertex() {
        return new Neo4jVertex(((Relationship) this.element).getStartNode(), this.index);
    }

    public Vertex getInVertex() {
        return new Neo4jVertex(((Relationship) this.element).getEndNode(), this.index);
    }

    public List<Vertex> getBothVertices() {
        List<Vertex> bothVertices = new ArrayList<Vertex>();
        bothVertices.add(this.getOutVertex());
        bothVertices.add(this.getInVertex());
        return bothVertices;
    }

    public String toString() {
       return StringFactory.edgeString(this);
    }
}

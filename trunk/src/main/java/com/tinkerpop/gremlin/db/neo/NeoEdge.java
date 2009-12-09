package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.model.Vertex;
import org.neo4j.api.core.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoEdge extends NeoElement implements Edge {

    public NeoEdge(Relationship relationship, Index index) {
        super(index);
        this.element = relationship;
    }

    public String getLabel() {
        return ((Relationship) this.element).getType().name();
    }

    public Vertex getOutVertex() {
        return new NeoVertex(((Relationship) this.element).getStartNode(), this.index);
    }

    public Vertex getInVertex() {
        return new NeoVertex(((Relationship) this.element).getEndNode(), this.index);
    }

    public List<Vertex> getBothVertices() {
        List<Vertex> bothVertices = new ArrayList<Vertex>();
        bothVertices.add(this.getOutVertex());
        bothVertices.add(this.getInVertex());
        return bothVertices;
    }

    public String toString() {
        return "e[" + this.getId() + "][" + this.getOutVertex().getId() + "-" + this.getLabel() + "->" + this.getInVertex().getId() + "]";
    }
}

package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.db.StringFactory;
import org.neo4j.api.core.Node;
import org.neo4j.api.core.Relationship;
import org.neo4j.api.core.RelationshipType;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoVertex extends NeoElement implements Vertex {

    public NeoVertex(Node node, Index index) {
        super(index);
        this.element = node;
    }

    public Set<Edge> getOutEdges() {
        Set<Edge> outEdges = new HashSet<Edge>();
        for (Relationship r : ((Node) this.element).getRelationships(org.neo4j.api.core.Direction.OUTGOING)) {
            outEdges.add(new NeoEdge(r, this.index));
        }
        return outEdges;
    }

    public Set<Edge> getInEdges() {
        Set<Edge> inEdges = new HashSet<Edge>();
        for (Relationship r : ((Node) this.element).getRelationships(org.neo4j.api.core.Direction.INCOMING)) {
            inEdges.add(new NeoEdge(r, this.index));
        }
        return inEdges;
    }

    public Set<Edge> getBothEdges() {
        Set<Edge> bothEdges = new HashSet<Edge>();
        for (Relationship r : ((Node) this.element).getRelationships(org.neo4j.api.core.Direction.BOTH)) {
            bothEdges.add(new NeoEdge(r, this.index));
        }
        return bothEdges;
    }

    public String toString() {
       return StringFactory.vertexString(this);
    }

}

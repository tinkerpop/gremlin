package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.Index;
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
        Set<Edge> edges = new HashSet<Edge>();
        for (Relationship r : ((Node) this.element).getRelationships(org.neo4j.api.core.Direction.OUTGOING)) {
            edges.add(new NeoEdge(r, this.index));
        }
        return edges;
    }

    public Set<Edge> getInEdges() {
        Set<Edge> edges = new HashSet<Edge>();
        for (Relationship r : ((Node) this.element).getRelationships(org.neo4j.api.core.Direction.INCOMING)) {
            edges.add(new NeoEdge(r, this.index));
        }
        return edges;
    }

    public Set<Edge> getBothEdges() {
        Set<Edge> edges = new HashSet<Edge>();
        for (Relationship r : ((Node) this.element).getRelationships(org.neo4j.api.core.Direction.BOTH)) {
            edges.add(new NeoEdge(r, this.index));
        }
        return edges;
    }

}

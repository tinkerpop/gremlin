package com.tinkerpop.gremlin.db.neo4j;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.db.StringFactory;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Direction;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Neo4jVertex extends Neo4jElement implements Vertex {

    public Neo4jVertex(final Node node, final Index index, final Neo4jGraph graph) {
        super(index, graph);
        this.element = node;

    }

    public Set<Edge> getOutEdges() {
        Set<Edge> outEdges = new HashSet<Edge>();
        for (Relationship r : ((Node) this.element).getRelationships(Direction.OUTGOING)) {
            outEdges.add(new Neo4jEdge(r, this.index, this.graph));
        }
        return outEdges;
    }

    public Set<Edge> getInEdges() {
        Set<Edge> inEdges = new HashSet<Edge>();
        for (Relationship r : ((Node) this.element).getRelationships(Direction.INCOMING)) {
            inEdges.add(new Neo4jEdge(r, this.index, this.graph));
        }
        return inEdges;
    }

    public Set<Edge> getBothEdges() {
        Set<Edge> bothEdges = new HashSet<Edge>();
        for (Relationship r : ((Node) this.element).getRelationships(Direction.BOTH)) {
            bothEdges.add(new Neo4jEdge(r, this.index, this.graph));
        }
        return bothEdges;
    }

    public boolean equals(final Object object) {
        return object instanceof Neo4jVertex && ((Neo4jVertex)object).getId().equals(this.getId());
    }
    

    public String toString() {
       return StringFactory.vertexString(this);
    }

}

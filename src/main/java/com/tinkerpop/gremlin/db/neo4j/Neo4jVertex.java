package com.tinkerpop.gremlin.db.neo4j;

import com.tinkerpop.gremlin.db.StringFactory;
import com.tinkerpop.gremlin.db.neo4j.util.Neo4jEdgeIterable;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.model.Vertex;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jVertex extends Neo4jElement implements Vertex {

    public Neo4jVertex(final Node node, final Index index, final Neo4jGraph graph) {
        super(index, graph);
        this.element = node;

    }

    public Iterable<Edge> getOutEdges() {
        return new Neo4jEdgeIterable(((Node) this.element).getRelationships(Direction.OUTGOING), this.graph);
    }

    public Iterable<Edge> getInEdges() {
        return new Neo4jEdgeIterable(((Node) this.element).getRelationships(Direction.INCOMING), this.graph);
    }

    public boolean equals(final Object object) {
        return object instanceof Neo4jVertex && ((Neo4jVertex) object).getId().equals(this.getId());
    }

    public String toString() {
        return StringFactory.vertexString(this);
    }
}

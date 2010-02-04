package com.tinkerpop.gremlin.models.ggm.impls.neo4j;

import com.tinkerpop.gremlin.models.ggm.impls.StringFactory;
import com.tinkerpop.gremlin.models.ggm.Vertex;
import com.tinkerpop.gremlin.models.ggm.Edge;
import com.tinkerpop.gremlin.models.ggm.Index;
import org.neo4j.graphdb.Relationship;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jEdge extends Neo4jElement implements Edge {

    public Neo4jEdge(final Relationship relationship, final Index index, final Neo4jGraph graph) {
        super(index, graph);
        this.element = relationship;
    }

    public String getLabel() {
        return ((Relationship) this.element).getType().name();
    }

    public Vertex getOutVertex() {
        return new Neo4jVertex(((Relationship) this.element).getStartNode(), this.index, this.graph);
    }

    public Vertex getInVertex() {
        return new Neo4jVertex(((Relationship) this.element).getEndNode(), this.index, this.graph);
    }

    public boolean equals(final Object object) {
        return object instanceof Neo4jEdge && ((Neo4jEdge) object).getId().equals(this.getId());
    }

    public String toString() {
        return StringFactory.edgeString(this);
    }
}

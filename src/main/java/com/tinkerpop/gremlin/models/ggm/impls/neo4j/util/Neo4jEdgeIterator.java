package com.tinkerpop.gremlin.models.ggm.impls.neo4j.util;

import com.tinkerpop.gremlin.models.ggm.Edge;
import com.tinkerpop.gremlin.models.ggm.impls.neo4j.Neo4jEdge;
import com.tinkerpop.gremlin.models.ggm.impls.neo4j.Neo4jGraph;
import org.neo4j.graphdb.Relationship;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jEdgeIterator implements Iterator<Edge> {

    Iterator<Relationship> relationships;
    Neo4jGraph graph;

    public Neo4jEdgeIterator(final Iterable<Relationship> relationships, final Neo4jGraph graph) {
        this.graph = graph;
        this.relationships = relationships.iterator();
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public Edge next() {
        return new Neo4jEdge(this.relationships.next(), this.graph.getIndex(), this.graph);
    }

    public boolean hasNext() {
        return this.relationships.hasNext();
    }
}
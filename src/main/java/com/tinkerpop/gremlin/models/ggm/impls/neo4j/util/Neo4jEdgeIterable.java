package com.tinkerpop.gremlin.models.ggm.impls.neo4j.util;

import com.tinkerpop.gremlin.models.ggm.impls.neo4j.Neo4jGraph;
import com.tinkerpop.gremlin.models.ggm.Edge;
import org.neo4j.graphdb.Relationship;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jEdgeIterable implements Iterable<Edge> {

    Iterable<Relationship> relationships;
    Neo4jGraph graph;

    public Neo4jEdgeIterable(final Iterable<Relationship> relationships, final Neo4jGraph graph) {
        this.relationships = relationships;
        this.graph = graph;
    }

    public Iterator<Edge> iterator() {
        return new Neo4jEdgeIterator(this.relationships, this.graph);
    }
}
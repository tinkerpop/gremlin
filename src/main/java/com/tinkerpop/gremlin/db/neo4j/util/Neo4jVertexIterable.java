package com.tinkerpop.gremlin.db.neo4j.util;

import com.tinkerpop.gremlin.db.neo4j.Neo4jGraph;
import com.tinkerpop.gremlin.model.Vertex;
import org.neo4j.graphdb.Node;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jVertexIterable implements Iterable<Vertex> {

    Iterable<Node> nodes;
    Neo4jGraph graph;

    public Neo4jVertexIterable(final Iterable<Node> nodes, final Neo4jGraph graph) {
        this.nodes = nodes;
        this.graph = graph;
    }

    public Iterator<Vertex> iterator() {
        return new Neo4jVertexIterator(this.nodes, this.graph);
    }
}
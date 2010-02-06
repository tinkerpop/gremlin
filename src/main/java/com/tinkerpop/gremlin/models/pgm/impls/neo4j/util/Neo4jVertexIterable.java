package com.tinkerpop.gremlin.models.pgm.impls.neo4j.util;

import com.tinkerpop.gremlin.models.pgm.Vertex;
import com.tinkerpop.gremlin.models.pgm.impls.neo4j.Neo4jGraph;
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
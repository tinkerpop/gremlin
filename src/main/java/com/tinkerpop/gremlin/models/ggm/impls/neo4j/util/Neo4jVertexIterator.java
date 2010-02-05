package com.tinkerpop.gremlin.models.ggm.impls.neo4j.util;

import com.tinkerpop.gremlin.models.ggm.Vertex;
import com.tinkerpop.gremlin.models.ggm.impls.neo4j.Neo4jGraph;
import com.tinkerpop.gremlin.models.ggm.impls.neo4j.Neo4jVertex;
import org.neo4j.graphdb.Node;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jVertexIterator implements Iterator<Vertex> {

    Iterator<Node> nodes;
    Neo4jGraph graph;

    public Neo4jVertexIterator(final Iterable<Node> nodes, final Neo4jGraph graph) {
        this.graph = graph;
        this.nodes = nodes.iterator();
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public Vertex next() {
        return new Neo4jVertex(this.nodes.next(), this.graph);
    }

    public boolean hasNext() {
        return this.nodes.hasNext();
    }
}
package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import org.neo4j.api.core.*;
import org.neo4j.util.index.IndexService;
import org.neo4j.util.index.LuceneIndexService;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoGraph implements Graph {

    private NeoService neo;
    private IndexService index;
    private String indexKey;

    public NeoGraph(String directory, String indexKey) {
        this.neo = new EmbeddedNeo(directory);
        this.index = new LuceneIndexService(neo);
        this.indexKey = indexKey;
    }

    public Vertex addVertex(Object id) {
        return new NeoVertex(neo.createNode());
    }

    public Vertex getVertex(Object id) {
        Node node = this.index.getSingleNode(this.indexKey, id);
        if (null != node) {
            return new NeoVertex(node);
        } else {
            return null;
        }
    }

    public Iterator<Vertex> getVertices() {
        return new NeoVertexIterator(this.neo.getAllNodes().iterator());
    }

    public Iterator<Edge> getEdges() {
        return new NeoEdgeIterator(this.neo.getAllNodes().iterator());
    }

    public void removeVertex(Vertex vertex) {
        Long id = (Long) vertex.getId();
        Node node = neo.getNodeById(id);
        if (null != node) {
            this.index.removeIndex(node, this.indexKey, node.getProperty(this.indexKey));
            node.delete();
        }
    }

    public Edge addEdge(Object id, Vertex outVertex, Vertex inVertex, String label) {
        return null;
    }

    public void removeEdge(Edge edge) {
        ((Relationship) ((NeoEdge) edge).getRawElement()).delete();
    }

    public void shutdown() {
        this.neo.shutdown();
        this.index.shutdown();
    }

    private class NeoVertexIterator implements Iterator<Vertex> {

        Iterator<Node> nodes;

        public NeoVertexIterator(Iterator<Node> nodes) {
            this.nodes = nodes;
        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        public Vertex next() {
            return new NeoVertex(this.nodes.next());
        }

        public boolean hasNext() {
            return this.nodes.hasNext();
        }
    }

    private class NeoEdgeIterator implements Iterator<Edge> {

        Iterator<Node> nodes;
        Iterator<Relationship> relationshipIterator;


        public NeoEdgeIterator(Iterator<Node> nodes) {
            this.nodes = nodes;
        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        public Edge next() {
            if (null != relationshipIterator && relationshipIterator.hasNext())
                return new NeoEdge(relationshipIterator.next());
            else if(this.nodes.hasNext()) {
                Node node = nodes.next();
                relationshipIterator = node.getRelationships(Direction.OUTGOING).iterator();
                return next();
            } else {
                return null;
            }
        }

        public boolean hasNext() {
            if(!this.nodes.hasNext() && (null == this.relationshipIterator || !this.relationshipIterator.hasNext()))
                return false;
            else
                return true;
        }

    }
}

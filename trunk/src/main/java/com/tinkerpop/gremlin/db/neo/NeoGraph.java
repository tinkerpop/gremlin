package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.neo4j.api.core.*;
import org.neo4j.impl.core.NodeManager;
import org.neo4j.util.index.Isolation;
import org.neo4j.util.index.LuceneIndexService;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoGraph implements Graph {

    private NeoService neo;
    private String directory;
    private NeoIndex index;
    private Transaction tx;

    public NeoGraph(String directory) {
        this.directory = directory;
        this.neo = new EmbeddedNeo(this.directory);
        LuceneIndexService indexService = new LuceneIndexService(neo);
        indexService.setIsolation(Isolation.SAME_TX);
        this.index = new NeoIndex(indexService);
        this.tx = neo.beginTx();
    }

    public Index getIndex() {
        return this.index;
    }

    public Vertex addVertex(Object id) {
        Vertex vertex = new NeoVertex(neo.createNode(), this.index);
        this.stopStartTransaction();
        return vertex;
    }

    public Vertex getVertex(Object id) {
        if(null == id)
            return null;
        
        try {
            Long longId = Double.valueOf(id.toString()).longValue();
            Node node = this.neo.getNodeById(longId);
            return new NeoVertex(node, this.index);
        } catch (NotFoundException e) {
            return null;
        } catch (NumberFormatException e) {
            throw new EvaluationException("Neo vertex ids must be convertible to a long value.");
        }
    }

    public Iterable<Vertex> getVertices() {
        return new NeoVertexIterable(this.neo.getAllNodes());
    }

    public Iterable<Edge> getEdges() {
        return new NeoEdgeIterable(this.neo.getAllNodes());
    }

    public void removeVertex(Vertex vertex) {
        Long id = (Long) vertex.getId();
        Node node = neo.getNodeById(id);
        if (null != node) {
            for (String key : vertex.getPropertyKeys()) {
                this.index.remove(key, vertex.getProperty(key), vertex);
            }
            for (Edge edge : vertex.getBothEdges()) {
                this.removeEdge(edge);
            }
            node.delete();
            this.stopStartTransaction();
        }
    }

    public Edge addEdge(Object id, Vertex outVertex, Vertex inVertex, String label) {
        Node outNode = (Node) ((NeoVertex) outVertex).getRawElement();
        Node inNode = (Node) ((NeoVertex) inVertex).getRawElement();
        Relationship relationship = outNode.createRelationshipTo(inNode, DynamicRelationshipType.withName(label));
        this.stopStartTransaction();
        return new NeoEdge(relationship, this.index);
    }

    public void removeEdge(Edge edge) {
        ((Relationship) ((NeoEdge) edge).getRawElement()).delete();
        this.stopStartTransaction();
    }

    private void stopStartTransaction() {
        this.tx.success();
        this.tx.finish();
        this.tx = neo.beginTx();
    }

    public void shutdown() {
        this.tx.success();
        this.tx.finish();
        this.neo.shutdown();
        this.index.shutdown();

    }


    public String toString() {
        EmbeddedNeo embeddedNeo = (EmbeddedNeo) neo;
        NodeManager nodeManager = embeddedNeo.getConfig().getNeoModule().getNodeManager();
        return "neograph[db:" + this.directory + ", vertices:" + nodeManager.getNumberOfIdsInUse(Node.class) + ", edges:" + nodeManager.getNumberOfIdsInUse(Relationship.class) + "]";
    }

    private class NeoVertexIterable implements Iterable<Vertex> {

        Iterable<Node> nodes;

        public NeoVertexIterable(Iterable<Node> nodes) {
            this.nodes = nodes;
        }

        public Iterator<Vertex> iterator() {
            return new NeoVertexIterator(this.nodes);
        }
    }

    private class NeoVertexIterator implements Iterator<Vertex> {

        Iterator<Node> nodes;

        public NeoVertexIterator(Iterable<Node> nodes) {
            this.nodes = nodes.iterator();
        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        public Vertex next() {
            return new NeoVertex(this.nodes.next(), index);
        }

        public boolean hasNext() {
            return this.nodes.hasNext();
        }

    }

    private class NeoEdgeIterable implements Iterable<Edge> {

        Iterable<Node> nodes;

        public NeoEdgeIterable(Iterable<Node> nodes) {
            this.nodes = nodes;
        }

        public Iterator<Edge> iterator() {
            return new NeoEdgeIterator(this.nodes);
        }
    }

    private class NeoEdgeIterator implements Iterator<Edge> {

        private Iterator<Node> nodes;
        private Iterator<Relationship> currentRelationships;
        private boolean complete = false;

        public NeoEdgeIterator(Iterable<Node> nodes) {
            this.nodes = nodes.iterator();
            this.complete = this.goToNextEdge();

        }

        public Edge next() {
            Edge edge = new NeoEdge(currentRelationships.next(), index);
            this.complete = this.goToNextEdge();
            return edge;
        }

        public boolean hasNext() {
            return !complete;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private boolean goToNextEdge() {
            if (this.currentRelationships == null || !this.currentRelationships.hasNext()) {
                if (nodes.hasNext()) {
                    this.currentRelationships = nodes.next().getRelationships(Direction.OUTGOING).iterator();
                } else {
                    return true;
                }
            }

            if (this.currentRelationships.hasNext()) {
                return false;
            } else {
                return this.goToNextEdge();
            }
        }
    }
}

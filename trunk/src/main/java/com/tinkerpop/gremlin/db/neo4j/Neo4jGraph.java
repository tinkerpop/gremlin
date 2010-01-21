package com.tinkerpop.gremlin.db.neo4j;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.neo4j.graphdb.*;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.kernel.impl.core.NodeManager;
import org.neo4j.kernel.impl.transaction.TransactionFailureException;
import org.neo4j.index.lucene.LuceneIndexService;
import org.neo4j.index.Isolation;


import java.io.File;
import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jGraph implements Graph {

    private GraphDatabaseService neo;
    private String directory;
    private Neo4jIndex index;
    private Transaction tx;

    public Neo4jGraph(final String directory) {
        this.directory = directory;
        this.neo = new EmbeddedGraphDatabase(this.directory);
        LuceneIndexService indexService = new LuceneIndexService(neo);
        indexService.setIsolation(Isolation.SAME_TX);
        this.index = new Neo4jIndex(indexService, this);
        this.tx = neo.beginTx();
    }

    public Index getIndex() {
        return this.index;
    }

    public Vertex addVertex(final Object id) {
        Vertex vertex = new Neo4jVertex(neo.createNode(), this.index, this);
        this.stopStartTransaction();
        return vertex;
    }

    public Vertex getVertex(final Object id) {
        if (null == id)
            return null;

        try {
            Long longId = Double.valueOf(id.toString()).longValue();
            Node node = this.neo.getNodeById(longId);
            return new Neo4jVertex(node, this.index, this);
        } catch (NotFoundException e) {
            return null;
        } catch (NumberFormatException e) {
            throw new EvaluationException("Neo vertex ids must be convertible to a long value.");
        }
    }

    public Iterable<Vertex> getVertices() {
        return new NeoVertexIterable(this.neo.getAllNodes(), this);
    }

    public Iterable<Edge> getEdges() {
        return new NeoEdgeIterable(this.neo.getAllNodes(), this);
    }

    public void removeVertex(final Vertex vertex) {
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

    public Edge addEdge(final Object id, final Vertex outVertex, final Vertex inVertex, final String label) {
        Node outNode = (Node) ((Neo4jVertex) outVertex).getRawElement();
        Node inNode = (Node) ((Neo4jVertex) inVertex).getRawElement();
        Relationship relationship = outNode.createRelationshipTo(inNode, DynamicRelationshipType.withName(label));
        this.stopStartTransaction();
        return new Neo4jEdge(relationship, this.index, this);
    }

    public void removeEdge(Edge edge) {
        ((Relationship) ((Neo4jEdge) edge).getRawElement()).delete();
        this.stopStartTransaction();
    }

    protected void stopStartTransaction() {
        this.tx.success();
        this.tx.finish();
        this.tx = neo.beginTx();
    }

    public void shutdown() {
        try {
            this.tx.success();
            this.tx.finish();
        } catch (TransactionFailureException e) {
        }
        this.neo.shutdown();
        this.index.shutdown();

    }

    public void clear() {
        this.shutdown();
        deleteGraphDirectory(new File(this.directory));
        this.neo = new EmbeddedGraphDatabase(this.directory);
        LuceneIndexService indexService = new LuceneIndexService(neo);
        indexService.setIsolation(Isolation.SAME_TX);
        this.index = new Neo4jIndex(indexService, this);
        this.tx = neo.beginTx();
        this.removeVertex(this.getVertex(0));
        this.stopStartTransaction();
    }

    private static void deleteGraphDirectory(final File directory) {
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    deleteGraphDirectory(file);
                }
                file.delete();
            }
        }
    }


    public String toString() {
        EmbeddedGraphDatabase embeddedNeo = (EmbeddedGraphDatabase) neo;
        NodeManager nodeManager = embeddedNeo.getConfig().getNeoModule().getNodeManager();
        return "neograph[db:" + this.directory + ", vertices:" + nodeManager.getNumberOfIdsInUse(Node.class) + ", edges:" + nodeManager.getNumberOfIdsInUse(Relationship.class) + "]";
    }

    private class NeoVertexIterable implements Iterable<Vertex> {

        Iterable<Node> nodes;
        Neo4jGraph graph;

        public NeoVertexIterable(final Iterable<Node> nodes, final Neo4jGraph graph) {
            this.nodes = nodes;
            this.graph = graph;
        }

        public Iterator<Vertex> iterator() {
            return new NeoVertexIterator(this.nodes, this.graph);
        }
    }

    private class NeoVertexIterator implements Iterator<Vertex> {

        Iterator<Node> nodes;
        Neo4jGraph graph;

        public NeoVertexIterator(final Iterable<Node> nodes, final Neo4jGraph graph) {
            this.graph = graph;
            this.nodes = nodes.iterator();
        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        public Vertex next() {
            return new Neo4jVertex(this.nodes.next(), index, this.graph);
        }

        public boolean hasNext() {
            return this.nodes.hasNext();
        }

    }

    private class NeoEdgeIterable implements Iterable<Edge> {

        Iterable<Node> nodes;
        Neo4jGraph graph;

        public NeoEdgeIterable(final Iterable<Node> nodes, final Neo4jGraph graph) {
            this.nodes = nodes;
            this.graph = graph;
        }

        public Iterator<Edge> iterator() {
            return new NeoEdgeIterator(this.nodes, graph);
        }
    }

    private class NeoEdgeIterator implements Iterator<Edge> {

        private Neo4jGraph graph;
        private Iterator<Node> nodes;
        private Iterator<Relationship> currentRelationships;
        private boolean complete = false;

        public NeoEdgeIterator(final Iterable<Node> nodes, final Neo4jGraph graph) {
            this.graph = graph;
            this.nodes = nodes.iterator();
            this.complete = this.goToNextEdge();

        }

        public Edge next() {
            Edge edge = new Neo4jEdge(currentRelationships.next(), index, this.graph);
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

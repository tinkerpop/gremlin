package com.tinkerpop.gremlin.db.mongo;

import com.mongodb.*;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.Tokens;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MongoGraph implements Graph {

    private DB database;
    private MongoIndex index;

    public static final String VERTICES = "vertices";
    public static final String EDGES = "edges";
    public static final String VERTEX = "vertex";
    public static final String EDGE = "edge";
    public static final String ID = "_id";
    public static final String PROPERTIES = "properties";

    private DBCollection edgeCollection;
    private DBCollection vertexCollection;

    /*
        {
          _id: "1",
          properties: {
            name : "marko",
            age : 29
          },
          outE : ["7","8","9"]
        }


        {
          _id: "7",
          label: "knows",
          properties: {
            weight : 0.5
          },
          outV : "1",
          inV : "2"
        }
     */


    public MongoGraph(final String ipAddress, final int port, final String database) throws UnknownHostException {
        Mongo mongo = new Mongo(ipAddress, port);
        this.database = mongo.getDB(database);
        this.vertexCollection = this.database.getCollection(VERTICES);
        this.edgeCollection = this.database.getCollection(EDGES);
        this.vertexCollection.ensureIDIndex();
        this.edgeCollection.ensureIDIndex();
        this.index = new MongoIndex(this);
    }

    public void clear() {
        this.vertexCollection.drop();
        this.edgeCollection.drop();
    }

    protected DBCollection getVertexCollection() {
        return this.vertexCollection;
    }

    public DBCollection getEdgeCollection() {
        return this.edgeCollection;
    }

    public Vertex addVertex(Object id) {
        BasicDBObject vertexObject = new BasicDBObject();
        if (null == id)
            id = UUID.randomUUID().toString();
        vertexObject.put(MongoGraph.ID, id.toString());
        vertexObject.put(MongoGraph.PROPERTIES, new BasicDBObject());
        this.vertexCollection.insert(vertexObject);
        return new MongoVertex(vertexObject, this);
    }

    public Vertex getVertex(final Object id) {
        DBObject queryObject = new BasicDBObject();
        queryObject.put(MongoGraph.ID, id);
        DBObject vertexObject = this.vertexCollection.findOne(queryObject);
        if (null == vertexObject)
            return null;
        else
            return new MongoVertex(vertexObject, this);
    }

    public void removeVertex(final Vertex vertex) {
        Object vertexId = vertex.getId();
        Set<Edge> edges = new HashSet<Edge>();
        for (Edge edge : vertex.getInEdges()) {
            edges.add(edge);
        }
        for (Edge edge : vertex.getOutEdges()) {
            edges.add(edge);
        }
        for (Edge edge : edges) {
            Object inVertexId = edge.getInVertex().getId();
            Object outVertexId = edge.getOutVertex().getId();
            if (!inVertexId.equals(vertexId)) {
                ((MongoVertex) edge.getInVertex()).removeEdgeId(edge.getId(), Tokens.IN_EDGES);
            } else if (!outVertexId.equals(vertexId)) {
                ((MongoVertex) edge.getOutVertex()).removeEdgeId(edge.getId(), Tokens.OUT_EDGES);
            }
            this.edgeCollection.remove(((MongoEdge) edge).getRawObject());
        }
        this.vertexCollection.remove(((MongoVertex) vertex).getRawObject());

    }

    public Iterable<Vertex> getVertices() {
        return new MongoIterable<Vertex>(this.vertexCollection.find(), VERTEX, this);
    }


    public Edge addEdge(Object id, final Vertex outVertex, final Vertex inVertex, final String label) {
        BasicDBObject edgeObject = new BasicDBObject();
        if (null == id)
            id = UUID.randomUUID().toString();
        edgeObject.put(MongoGraph.ID, id.toString());
        edgeObject.put(Tokens.OUT_VERTEX, outVertex.getId());
        edgeObject.put(Tokens.IN_VERTEX, inVertex.getId());
        edgeObject.put(Tokens.LABEL, label);
        edgeObject.put(MongoGraph.PROPERTIES, new BasicDBObject());
        this.edgeCollection.insert(edgeObject);

        ((MongoVertex) outVertex).addEdgeId(id, Tokens.OUT_EDGES);
        ((MongoVertex) inVertex).addEdgeId(id, Tokens.IN_EDGES);

        return new MongoEdge(edgeObject, this);
    }

    public void removeEdge(final Edge edge) {
        ((MongoVertex) edge.getOutVertex()).removeEdgeId(edge.getId(), Tokens.OUT_EDGES);
        ((MongoVertex) edge.getInVertex()).removeEdgeId(edge.getId(), Tokens.IN_EDGES);
        this.edgeCollection.remove(((MongoEdge) edge).getRawObject());
    }

    protected Edge getEdge(final Object id) {
        DBObject queryObject = new BasicDBObject();
        queryObject.put(MongoGraph.ID, id);
        DBObject edgeObject = this.edgeCollection.findOne(queryObject);
        if (null == edgeObject)
            return null;
        else
            return new MongoEdge(edgeObject, this);
    }

    public Iterable<Edge> getEdges() {
        return new MongoIterable<Edge>(this.edgeCollection.find(), EDGE, this);
    }

    public Index getIndex() {
        return this.index;
    }

    public void shutdown() {
        // todo: is there a proper way to shutdown a mongodb connection?
    }


    public String toString() {
        return "mongograph[db:" + this.database.getName() + ", vertices:" + vertexCollection.getCount() + ", edges:" + edgeCollection.getCount() + "]";
    }

    private class MongoIterable<T> implements Iterable<T> {

        private DBCursor cursor;
        private String type;
        private MongoGraph graph;

        public MongoIterable(DBCursor cursor, String type, MongoGraph graph) {
            this.cursor = cursor;
            this.type = type;
            this.graph = graph;
        }

        public Iterator iterator() {
            if (type.equals(VERTEX)) {
                return new MongoIterator<Vertex>(cursor) {
                    public Vertex next() {
                        return new MongoVertex(cursor.next(), graph);
                    }
                };
            } else {
                return new MongoIterator<Edge>(cursor) {
                    public Edge next() {
                        return new MongoEdge(cursor.next(), graph);
                    }
                };
            }
        }
    }

    private abstract class MongoIterator<T> implements Iterator<T> {
        private DBCursor cursor;

        public MongoIterator(final DBCursor vertexCursor) {
            this.cursor = vertexCursor;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.cursor.hasNext();
        }


    }


}

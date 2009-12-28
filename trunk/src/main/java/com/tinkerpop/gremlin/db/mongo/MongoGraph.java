package com.tinkerpop.gremlin.db.mongo;

import com.mongodb.*;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.model.Vertex;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.UUID;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MongoGraph implements Graph {

    private DB database;
    public static final String VERTICES = "vertices";
    public static final String EDGES = "edges";
    public static final String VERTEX = "vertex";
    public static final String EDGE = "edge";
    public static final String ID = "_id";
    public static final String PROPERTIES = "properties";
    public static final String OUT_VERTEX = "outVertex";
    public static final String IN_VERTEX = "inVertex";
    public static final String OUT_EDGES = "outEdges";
    public static final String IN_EDGES = "inEdges";
    public static final String LABEL = "label";

    private DBCollection edgeCollection;
    private DBCollection vertexCollection;
    private long currentId = 0l;

    /*
{
  _id: "1",
  properties: {
    name : "marko",
    age : 29
  },
  outEdges : ["7","8","9"]
}
     */


    public MongoGraph(String ipAddress, int port, String database) throws UnknownHostException {
        Mongo mongo = new Mongo(ipAddress, port);
        this.database = mongo.getDB(database);
        this.vertexCollection = this.database.getCollection(VERTICES);
        this.edgeCollection = this.database.getCollection(EDGES);
    }

    protected void dropCollections() {
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

    public Vertex getVertex(Object id) {
        DBObject queryObject = new BasicDBObject();
        queryObject.put(MongoGraph.ID, id);
        DBObject vertexObject = this.vertexCollection.findOne(queryObject);
        if (null == vertexObject)
            return null;
        else
            return new MongoVertex(vertexObject, this);
    }

    public void removeVertex(Vertex vertex) {
        Object vertexId = vertex.getId();
        for (Edge edge : vertex.getBothEdges()) {
            Object inVertexId = edge.getInVertex().getId();
            Object outVertexId = edge.getOutVertex().getId();
            if(!inVertexId.equals(vertexId)) {
                ((MongoVertex)edge.getInVertex()).removeEdgeId(edge.getId(), IN_EDGES);
            } else if(!outVertexId.equals(vertexId)) {
                ((MongoVertex)edge.getOutVertex()).removeEdgeId(edge.getId(), OUT_EDGES);
            }
        }
        this.vertexCollection.remove(((MongoVertex)vertex).getRawObject());
    }

    public Iterable<Vertex> getVertices() {
        return new MongoIterable<Vertex>(this.vertexCollection.find(), VERTEX, this);
    }


    public Edge addEdge(Object id, Vertex outVertex, Vertex inVertex, String label) {
        BasicDBObject edgeObject = new BasicDBObject();
        if (null == id)
            id = UUID.randomUUID().toString();
        edgeObject.put(MongoGraph.ID, id.toString());
        edgeObject.put(MongoGraph.OUT_VERTEX, outVertex.getId());
        edgeObject.put(MongoGraph.IN_VERTEX, inVertex.getId());
        edgeObject.put(MongoGraph.LABEL, label);
        edgeObject.put(MongoGraph.PROPERTIES, new BasicDBObject());
        this.edgeCollection.insert(edgeObject);

        ((MongoVertex) outVertex).addEdgeId(id, MongoGraph.OUT_EDGES);
        ((MongoVertex) inVertex).addEdgeId(id, MongoGraph.IN_EDGES);

        return new MongoEdge(edgeObject, this);
    }

    public void removeEdge(Edge edge) {
        ((MongoVertex) edge.getOutVertex()).removeEdgeId(edge.getId(), MongoGraph.OUT_EDGES);
        ((MongoVertex) edge.getInVertex()).removeEdgeId(edge.getId(), MongoGraph.IN_EDGES);
        this.edgeCollection.remove(((MongoEdge)edge).getRawObject());
    }

    protected Edge getEdge(Object id) {
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
        return null;
    }

    public void shutdown() {
        // todo: is this really necessary?
        this.database.requestDone();
    }


    public String toString() {
        return "mongograph[db:" + this.database.getName() + "]";
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

        public MongoIterator(DBCursor vertexCursor) {
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

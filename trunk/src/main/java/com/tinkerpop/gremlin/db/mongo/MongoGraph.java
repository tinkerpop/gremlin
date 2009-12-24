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

    private Mongo mongo;
    private DB database;
    private static final String VERTICES = "vertices";
    private static final String EDGES = "edges";
    private static final String VERTEX = "vertex";
    private static final String EDGE = "edge";
    private DBCollection edgeCollection;
    private DBCollection vertexCollection;
    private long currentId = 0l;

    /*
{
  _id: "1",
  type: "vertex",
  properties: {
    name : "marko",
    age : 29
  },
  outEdges : ["7","8","9"]
}
     */


    public MongoGraph(String ipAddress, int port, String database) throws UnknownHostException {
        this.mongo = new Mongo(ipAddress, port);
        this.database = this.mongo.getDB(database);
        this.vertexCollection = this.database.getCollection(VERTICES);
        this.edgeCollection = this.database.getCollection(EDGES);

    }

    public void dropCollections() {
        this.vertexCollection.drop();
        this.edgeCollection.drop();
    }

    public Vertex addVertex(Object id) {
        BasicDBObject vertexObject = new BasicDBObject();
        if (null == id)
            id = UUID.randomUUID().toString();
        vertexObject.put("_id", id.toString());
        vertexObject.put("type", VERTEX);
        vertexObject.put("properties", new BasicDBObject());
        this.vertexCollection.insert(vertexObject);
        return new MongoVertex(vertexObject, this);
    }

    public Vertex getVertex(Object id) {
        DBObject queryObject = new BasicDBObject();
        queryObject.put("_id", id);
        DBObject vertexObject = this.vertexCollection.findOne(queryObject);
        return new MongoVertex(vertexObject, this);
    }

    public void removeVertex(Vertex vertex) {
        for(Edge edge : vertex.getBothEdges()) {
            this.removeEdge(edge);
        }

        DBObject queryObject = new BasicDBObject();
        queryObject.put("_id", vertex.getId());
        this.vertexCollection.remove(queryObject);
    }

    public Iterable<Vertex> getVertices() {
        return new MongoIterable<Vertex>(this.vertexCollection.find(), VERTEX, this);
    }


    public Edge addEdge(Object id, Vertex outVertex, Vertex inVertex, String label) {
        BasicDBObject edgeObject = new BasicDBObject();
        if (null == id)
            id = UUID.randomUUID().toString();
        edgeObject.put("_id", id.toString());
        edgeObject.put("type", EDGE);
        edgeObject.put("outVertex", outVertex.getId());
        edgeObject.put("inVertex", inVertex.getId());
        edgeObject.put("label", label);
        edgeObject.put("properties", new BasicDBObject());
        this.edgeCollection.insert(edgeObject);

        ((MongoVertex)outVertex).addEdge(id, "outEdges");
        ((MongoVertex)inVertex).addEdge(id, "inEdges");

       
        return new MongoEdge(edgeObject, this);
    }

    public void removeEdge(Edge edge) {
        DBObject queryObject = new BasicDBObject();
        queryObject.put("_id", edge.getId());

        ((MongoVertex)edge.getOutVertex()).removeEdge(edge.getId(), "outEdges");
        ((MongoVertex)edge.getInVertex()).removeEdge(edge.getId(), "inEdges");

        this.edgeCollection.remove(queryObject);
    }

    protected Edge getEdge(Object id) {
        DBObject queryObject = new BasicDBObject();
        queryObject.put("_id", id);
        DBObject edgeObject = this.edgeCollection.findOne(queryObject);
        return new MongoEdge(edgeObject, this);
    }

    public Iterable<Edge> getEdges() {
        return new MongoIterable<Edge>(this.edgeCollection.find(), EDGE, this);
    }

    public Index getIndex() {
        return null;
    }

    protected void saveDBObject(DBObject dbObject, String collection) {
        if(collection.equals(EDGES))
            edgeCollection.save(dbObject);
        else
            vertexCollection.save(dbObject);
    }


    public void shutdown() {
        // todo: how do you shutdown MongoDB?
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

package com.tinkerpop.gremlin.db.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.model.Index;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MongoIndex implements Index {

    MongoGraph graph;
    boolean indexAll = true;

    public MongoIndex(MongoGraph graph) {
        this.graph = graph;
    }

    public Set<Element> get(String key, Object value) {
        DBObject query = new BasicDBObject();
        DBObject properties = new BasicDBObject();
        properties.put(key, value);
        query.put(MongoGraph.PROPERTIES, properties);
        Set<Element> retElements = new HashSet<Element>();
        DBCursor cursor = this.graph.getVertexCollection().find(query);
        if (null != cursor) {
            while (cursor.hasNext()) {
                retElements.add(new MongoVertex(cursor.next(), this.graph));
            }
        }
        cursor = this.graph.getEdgeCollection().find(query);
        if (null != cursor) {
            while (cursor.hasNext()) {
                retElements.add(new MongoEdge(cursor.next(), this.graph));
            }
        }
        if (retElements.size() == 0)
            return null;
        else
            return retElements;
    }

    public void put(String key, Object value, Element element) {

    }

    public void remove(String key, Object value, Element element) {

    }

    public void addIndexKey(String key) {
        DBObject object = new BasicDBObject();
        DBObject properties = new BasicDBObject();
        properties.put(key, 1);
        object.put(MongoGraph.PROPERTIES, properties);
        this.graph.getVertexCollection().ensureIndex(object);
        this.graph.getEdgeCollection().ensureIndex(object);
    }

    public void removeIndexKey(String key) {
        this.graph.getVertexCollection().dropIndex(key + "_1");
        this.graph.getEdgeCollection().dropIndex(key + "_1");
    }

    public void indexAll(boolean indexAll) {
        this.indexAll = true;
    }
}

package com.tinkerpop.gremlin.db.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.tinkerpop.gremlin.model.Element;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MongoElement implements Element {

    DBObject dbObject;
    MongoGraph graph;

    public MongoElement(DBObject dbObject, MongoGraph graph) {
        this.dbObject = dbObject;
        this.graph = graph;
    }


    public void saveDbObject() {
        if (this instanceof MongoVertex)
            this.graph.getVertexCollection().save(this.dbObject);
        else
            this.graph.getEdgeCollection().save(this.dbObject);
    }

    public void refreshDbObject() {
        DBObject queryObject = new BasicDBObject();
        queryObject.put("_id", this.getId());
        if (this instanceof MongoVertex)
            this.dbObject = this.graph.getVertexCollection().findOne(queryObject);
        else
            this.dbObject = this.graph.getEdgeCollection().findOne(queryObject);
    }

    public Object getId() {
        return this.dbObject.get(MongoGraph.ID);
    }

    public Set<String> getPropertyKeys() {
        Set<String> keys = new HashSet<String>();
        DBObject properties = (DBObject) this.dbObject.get(MongoGraph.PROPERTIES);
        keys.addAll(properties.keySet());
        return keys;
    }

    public Object getProperty(String key) {
        return ((DBObject) this.dbObject.get(MongoGraph.PROPERTIES)).get(key);
    }

    public Object removeProperty(String key) {
        Object retObject = ((DBObject) this.dbObject.get(MongoGraph.PROPERTIES)).removeField(key);
        this.saveDbObject();
        return retObject;
    }

    public void setProperty(String key, Object value) {
        DBObject properties = (DBObject) this.dbObject.get(MongoGraph.PROPERTIES);
        properties.put(key, value);
        this.dbObject.put(MongoGraph.PROPERTIES, properties);
        this.saveDbObject();
    }

    public DBObject getRawObject() {
        return this.dbObject;
    }
}

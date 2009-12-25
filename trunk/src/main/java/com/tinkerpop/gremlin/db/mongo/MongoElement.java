package com.tinkerpop.gremlin.db.mongo;

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

    public Object getId() {
        return this.dbObject.get("_id");
    }


    public Set<String> getPropertyKeys() {
        Set<String> keys = new HashSet<String>();
        DBObject properties = (DBObject) this.dbObject.get("properties");
        keys.addAll(properties.keySet());
        return keys;
    }

    public Object getProperty(String key) {
        return ((DBObject) this.dbObject.get("properties")).get(key);
    }

    public Object removeProperty(String key) {
        Object retObject = ((DBObject) this.dbObject.get("properties")).removeField(key);
        if (this.dbObject.get("type").equals("vertex"))
            this.graph.saveDBObject(dbObject, "vertices");
        else
            this.graph.saveDBObject(dbObject, "edges");
        return retObject;
    }

    public void setProperty(String key, Object value) {
        DBObject properties = (DBObject) this.dbObject.get("properties");
        properties.put(key, value);
        this.dbObject.put("properties", properties);
        if (this.dbObject.get("type").equals("vertex"))
            this.graph.saveDBObject(dbObject, "vertices");
        else
            this.graph.saveDBObject(dbObject, "edges");
    }

    public DBObject getRawObject() {
        return this.dbObject;
    }
}

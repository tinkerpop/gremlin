package com.tinkerpop.gremlin.db.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.model.Index;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MongoIndex implements Index {

    MongoGraph graph;
    boolean indexAll = true;
    private static final String NAME = "name";
    private static final String PERIOD = ".";
    private static final String PROPERTIES_PERIOD = MongoGraph.PROPERTIES + PERIOD;
    private Set<String> indexNames = new HashSet<String>();


    public MongoIndex(final MongoGraph graph) {
        this.graph = graph;
        this.refreshIndexNames();
    }

    public Set<Element> get(final String key, final Object value) {
        if (this.indexNames.contains(key)) {
            DBObject query = new BasicDBObject();
            query.put(PROPERTIES_PERIOD + key, value);
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
        } else {
            return null;
        }
    }

    public void put(final String key, final Object value, final Element element) {
        if (this.indexAll && !this.indexNames.contains(key)) {
            this.addIndexKey(key);
        } else if (!this.indexNames.contains(key)) {
            this.addIndexKey(key);
        }
    }

    public void remove(final String key, final Object value, final Element element) {

    }

    private void refreshIndexNames() {
        this.indexNames.clear();
        List<DBObject> indexInfos = this.graph.getVertexCollection().getIndexInfo();
        for (DBObject indexInfo : indexInfos) {
            this.indexNames.add(indexInfo.get(NAME).toString());
        }
    }

    public void addIndexKey(final String key) {
        DBObject index = new BasicDBObject();
        index.put(PROPERTIES_PERIOD + key, 1);
        this.graph.getVertexCollection().ensureIndex(index, key);
        this.graph.getEdgeCollection().ensureIndex(index, key);
        this.refreshIndexNames();
    }

    public void removeIndexKey(final String key) {
        this.graph.getVertexCollection().dropIndex(key);
        this.graph.getEdgeCollection().dropIndex(key);
        this.refreshIndexNames();
    }

    public void indexAll(final boolean indexAll) {
        this.indexAll = true;
    }
}

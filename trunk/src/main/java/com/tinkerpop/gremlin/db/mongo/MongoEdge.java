package com.tinkerpop.gremlin.db.mongo;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MongoEdge extends MongoElement implements Edge {

    DBCollection vertexCollection;

    public MongoEdge(DBObject dbObject, MongoGraph graph) {
        super(dbObject, graph);
    }

    public String getLabel() {
        return this.dbObject.get("label").toString();
    }

    public Vertex getOutVertex() {
        Object id = this.dbObject.get("outVertex");
        return graph.getVertex(id);

    }

    public Vertex getInVertex() {
        Object id = this.dbObject.get("inVertex");
        return graph.getVertex(id);
    }

    public List<Vertex> getBothVertices() {
        List<Vertex> bothVertices = new ArrayList<Vertex>();
        bothVertices.add(this.getOutVertex());
        bothVertices.add(this.getInVertex());
        return bothVertices;
    }
}

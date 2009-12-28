package com.tinkerpop.gremlin.db.mongo;

import com.mongodb.DBObject;
import com.tinkerpop.gremlin.db.StringFactory;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MongoEdge extends MongoElement implements Edge {


    public MongoEdge(DBObject dbObject, MongoGraph graph) {
        super(dbObject, graph);
    }

    public String getLabel() {
        return this.dbObject.get(MongoGraph.LABEL).toString();
    }

    public Vertex getOutVertex() {
        Object id = this.dbObject.get(MongoGraph.OUT_VERTEX);
        return graph.getVertex(id);

    }

    public Vertex getInVertex() {
        Object id = this.dbObject.get(MongoGraph.IN_VERTEX);
        return graph.getVertex(id);
    }

    public List<Vertex> getBothVertices() {
        List<Vertex> bothVertices = new ArrayList<Vertex>();
        bothVertices.add(this.getOutVertex());
        bothVertices.add(this.getInVertex());
        return bothVertices;
    }

    public int hashCode() {
        return this.getId().hashCode();
    }

    public boolean equals(Object object) {
        return object instanceof MongoEdge && object.hashCode() == this.hashCode();
    }

    public String toString() {
        return StringFactory.edgeString(this);
    }
}

package com.tinkerpop.gremlin.db.mongo;

import com.mongodb.DBObject;
import com.tinkerpop.gremlin.db.StringFactory;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.Tokens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MongoEdge extends MongoElement implements Edge {


    public MongoEdge(final DBObject dbObject, final MongoGraph graph) {
        super(dbObject, graph);
    }

    public String getLabel() {
        return this.dbObject.get(Tokens.LABEL).toString();
    }

    public Vertex getOutVertex() {
        Object id = this.dbObject.get(Tokens.OUT_VERTEX);
        return graph.getVertex(id);

    }

    public Vertex getInVertex() {
        Object id = this.dbObject.get(Tokens.IN_VERTEX);
        return graph.getVertex(id);
    }

    public List<Vertex> getBothVertices() {
        List<Vertex> bothVertices = new ArrayList<Vertex>();
        bothVertices.add(this.getOutVertex());
        bothVertices.add(this.getInVertex());
        return bothVertices;
    }

    public boolean equals(final Object object) {
        return object instanceof MongoEdge && ((MongoEdge) object).getId().equals(this.getId());
    }

    public String toString() {
        return StringFactory.edgeString(this);
    }
}

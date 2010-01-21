package com.tinkerpop.gremlin.db.mongo;

import com.mongodb.DBObject;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.db.StringFactory;
import com.tinkerpop.gremlin.statements.Tokens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MongoVertex extends MongoElement implements Vertex {

    public MongoVertex(final DBObject vertexObject, final MongoGraph graph) {
        super(vertexObject, graph);
    }

    public Set<Edge> getInEdges() {
        this.refreshDbObject();
        List inEdgeIds = (List) this.dbObject.get(Tokens.IN_EDGES);
        Set<Edge> inEdges = new HashSet<Edge>();
        if (null != inEdgeIds && inEdgeIds.size() > 0) {
            for (Object id : inEdgeIds) {
                inEdges.add(this.graph.getEdge(id));
            }
        }
        return inEdges;
    }

    public Set<Edge> getOutEdges() {
        this.refreshDbObject();
        List outEdgeIds = (List) this.dbObject.get(Tokens.OUT_EDGES);
        Set<Edge> outEdges = new HashSet<Edge>();
        if (null != outEdgeIds && outEdgeIds.size() > 0) {
            for (Object id : outEdgeIds) {
                outEdges.add(this.graph.getEdge(id));
            }
        }
        return outEdges;
    }

    public Set<Edge> getBothEdges() {
        Set<Edge> bothEdges = new HashSet<Edge>();
        bothEdges.addAll(this.getInEdges());
        bothEdges.addAll(this.getOutEdges());
        return bothEdges;
    }

    protected void addEdgeId(final Object id, final String type) {
        List edgeIds = (List) this.dbObject.get(type);
        if (null == edgeIds) {
            edgeIds = new ArrayList();
        }
        edgeIds.add(id);
        this.dbObject.put(type, edgeIds);
        this.saveDbObject();
    }

    protected void removeEdgeId(final Object id, final String type) {
        List edgeIds = (List) this.dbObject.get(type);
        if (null != edgeIds) {
            edgeIds.remove(id);
            this.dbObject.put(type, edgeIds);
            this.saveDbObject();
        }
    }

    public String toString() {
        return StringFactory.vertexString(this);
    }

    public boolean equals(final Object object) {
        return object instanceof MongoVertex && ((MongoVertex)object).getId().equals(this.getId());
    }
}

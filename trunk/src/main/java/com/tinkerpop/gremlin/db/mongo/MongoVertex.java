package com.tinkerpop.gremlin.db.mongo;

import com.mongodb.DBObject;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MongoVertex extends MongoElement implements Vertex {

    public MongoVertex(DBObject vertexObject, MongoGraph graph) {
        super(vertexObject, graph);
    }

    public Set<Edge> getInEdges() {
        List inEdgeIds = (List) this.dbObject.get("inEdges");
        Set<Edge> inEdges = new HashSet<Edge>();
        if (null != inEdgeIds) {
            for (Object id : inEdgeIds) {
                inEdges.add(this.graph.getEdge(id));
            }
        }
        return inEdges;
    }

    public Set<Edge> getOutEdges() {
        List outEdgeIds = (List) this.dbObject.get("outEdges");
        Set<Edge> outEdges = new HashSet<Edge>();
        if (null != outEdgeIds) {
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

    protected void addEdge(Object id, String type) {
        DBObject vertexObject = this.getRawObject();
        List edgeIds = (List) vertexObject.get(type);
        if (null == edgeIds) {
            edgeIds = new ArrayList();
        }
        edgeIds.add(id);
        vertexObject.put(type, edgeIds);
        this.graph.saveDBObject(vertexObject, "vertices");
    }

    protected void removeEdge(Object id, String type) {
        DBObject vertexObject = this.getRawObject();
        List edgeIds = (List) vertexObject.get(type);

        if (null != edgeIds) {
            edgeIds.remove(id);
            vertexObject.put(type, edgeIds);
            this.graph.saveDBObject(vertexObject, "vertices");
        }

    }

    public String toString() {
        return "v[" + this.getId() + "]";
    }
}

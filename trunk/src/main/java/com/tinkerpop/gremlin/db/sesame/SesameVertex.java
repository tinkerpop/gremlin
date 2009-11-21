package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import info.aduna.iteration.CloseableIteration;
import org.openrdf.model.Literal;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.Value;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameVertex extends SesameElement implements Vertex {

    Resource resource;

    public SesameVertex(Resource resource, SailConnection sailConnection) {
        super(resource.stringValue(), sailConnection);
        this.resource = resource;
    }

    public void setProperty(String key, Object value) {
        System.out.println("setProperty() is not implemented yet.");
    }

    public Object getProperty(String key) {
        key = SesameGraph.prefixToNamespace(key, this.sailConnection);
        Set<String> values = new HashSet<String>();
        try {
            CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements(this.resource, new URIImpl(key), null, false);
            while (results.hasNext()) {
                Statement s = results.next();
                Value value = s.getObject();
                if (value instanceof Literal) {
                    values.add(value.stringValue());
                }
            }
            results.close();
        } catch (SailException e) {
            e.printStackTrace();
        }
        if (values.size() > 0)
            return values;
        else
            return null;

    }

    public Set<String> getPropertyKeys() {
        Set<String> keys = new HashSet<String>();
        try {
            CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements(this.resource, null, null, false);
            while (results.hasNext()) {
                Statement s = results.next();
                Value value = s.getObject();
                if (value instanceof Literal) {
                    keys.add(SesameGraph.namespaceToPrefix(s.getPredicate().stringValue(), this.sailConnection));
                }
            }
            results.close();
        } catch (SailException e) {
            e.printStackTrace();
        }
        return keys;
    }

    private Set<SesameEdge> getOutEdges() {
        Set<SesameEdge> edges = new HashSet<SesameEdge>();
        try {
            CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements(this.resource, null, null, false);
            while (results.hasNext()) {
                edges.add(new SesameEdge(results.next(), this.sailConnection));
            }
            results.close();

        } catch (SailException e) {
            e.printStackTrace();
        }
        return edges;
    }

    private Set<SesameEdge> getInEdges() {
        Set<SesameEdge> edges = new HashSet<SesameEdge>();
        try {
            CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements(null, null, this.resource, false);
            while (results.hasNext()) {
                edges.add(new SesameEdge(results.next(), this.sailConnection));
            }
            results.close();
        } catch (SailException e) {
            e.printStackTrace();
        }
        return edges;
    }

    public Set<Edge> getEdges(Direction direction) {
        Set<Edge> edges = new HashSet<Edge>();
        if (direction == Direction.OUT) {
            edges.addAll(this.getOutEdges());
        } else if (direction == Direction.IN) {
            edges.addAll(this.getInEdges());
        } else if (direction == Direction.BOTH) {
            edges.addAll(this.getOutEdges());
            edges.addAll(this.getInEdges());
        }
        return edges;
    }

    public String toString() {
        return this.resource.stringValue();
    }

    public int hashCode() {
        return this.resource.hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof SesameVertex)
            return object.hashCode() == this.hashCode();
        else
            return false;
    }
}

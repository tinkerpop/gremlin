package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import info.aduna.iteration.CloseableIteration;
import org.openrdf.model.Literal;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.Value;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameVertex extends SesameElement implements Vertex {

    Value value;

    public SesameVertex(Value value, SailConnection sailConnection) {
        super(sailConnection);
        this.value = value;
    }

    public Value getRawValue() {
        return this.value;
    }

    public void setProperty(String key, Object value) {
        System.out.println("setProperty() is not implemented yet.");
    }

    public Object removeProperty(String key) {
        System.out.println("removeProperty() is not implemented yet.");
        return null;
    }

    public Object getProperty(String key) {
        if (value instanceof Literal) {
            Literal literal = (Literal) value;
            if (key.equals("datatype")) {
                return literal.getDatatype();
            } else if (key.equals("language")) {
                return literal.getLanguage();
            }
        }
        return null;
    }

    public Set<String> getPropertyKeys() {
        if (value instanceof Literal) {
            Set<String> keys = new HashSet<String>();
            if (null != this.getProperty("datatype")) {
                keys.add("datatype");
            } else if (null != this.getProperty("language")) {
                keys.add("language");
            }
            if (keys.size() > 0)
                return keys;
        }
        return null;
    }

    public Set<Edge> getOutEdges() {
        if (this.value instanceof Resource) {
            Set<Edge> edges = new HashSet<Edge>();
            try {
                CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements((Resource) this.value, null, null, false);
                while (results.hasNext()) {
                    edges.add(new SesameEdge(results.next(), this.sailConnection));
                }
                results.close();

            } catch (SailException e) {
                throw new EvaluationException(e.getMessage());
            }
            return edges;
        } else {
            return null;
        }
    }

    public Set<Edge> getInEdges() {
        Set<Edge> edges = new HashSet<Edge>();
        try {
            CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements(null, null, this.value, false);
            while (results.hasNext()) {
                edges.add(new SesameEdge(results.next(), this.sailConnection));
            }
            results.close();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
        return edges;
    }

    public Set<Edge> getBothEdges() {
        Set<Edge> bothEdges = new HashSet<Edge>();
        bothEdges.addAll(this.getInEdges());
        if (!(this.value instanceof Resource)) {
            bothEdges.addAll(this.getOutEdges());
        }
        return bothEdges;
    }

    public String toString() {
        return this.value.stringValue();
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean equals(Object object) {
        return object instanceof SesameVertex && object.hashCode() == this.hashCode();
    }

    public Object getId() {
        return this.value;
    }
}

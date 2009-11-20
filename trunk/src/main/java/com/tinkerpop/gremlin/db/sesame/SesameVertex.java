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

    Value value;

    public SesameVertex(Value value, SailConnection sailConnection) {
        super(value.stringValue(), sailConnection);
        this.value = value;
    }

    public void setProperty(String key, Object value) {
        System.out.println("setProperty() is not implemented yet.");
    }

    public Object getProperty(String key) {
        if (value instanceof Resource) {
            key = SesameGraph.prefixToNamespace(key, this.sailConnection);
            Set<String> values = new HashSet<String>();
            try {
                CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements((Resource) this.value, new URIImpl(key), null, false);
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
        } else {
            return null;
        }
    }

    public Set<String> getPropertyKeys() {
        if (this.value instanceof Resource) {
            Set<String> keys = new HashSet<String>();
            try {
                CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements((Resource) this.value, null, null, false);
                while (results.hasNext()) {
                    Statement s = results.next();
                    Value value = s.getObject();
                    if (value instanceof Literal) {
                        keys.add(SesameGraph.namespaceToPrefix(s.getPredicate().toString(), this.sailConnection));
                    }
                }
                results.close();
            } catch (SailException e) {
                e.printStackTrace();
            }
            return keys;
        } else {
            return new HashSet<String>();
        }
    }

    public Set<Edge> getEdges(Direction direction) {
        Set<Edge> edges = new HashSet<Edge>();
        try {
            if (direction == Direction.OUT) {
                if (value instanceof Resource) {
                    CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements((Resource) this.value, null, null, false);
                    while (results.hasNext()) {
                        //Statement s = results.next();
                        //System.out.println("TESTES:::" + s);
                        edges.add(new SesameEdge(results.next(), this.sailConnection));
                    }
                    results.close();
                }
            } else if (direction == Direction.IN) {
                CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements(null, null, this.value, false);
                while (results.hasNext()) {
                    edges.add(new SesameEdge(results.next(), this.sailConnection));
                }
                results.close();
            } else {
                CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements(null, null, this.value, false);
                while (results.hasNext()) {
                    edges.add(new SesameEdge(results.next(), this.sailConnection));
                }
                results.close();
                if (value instanceof Resource) {
                    results = sailConnection.getStatements((Resource) this.value, null, null, false);
                    while (results.hasNext()) {
                        edges.add(new SesameEdge(results.next(), this.sailConnection));
                    }
                    results.close();
                }
            }
        } catch (SailException e) {
            e.printStackTrace();
        }

        return edges;

    }

    public String toString() {
        return this.value.stringValue();
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof SesameVertex)
            return object.hashCode() == this.hashCode();
        else
            return false;
    }
}

package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import info.aduna.iteration.CloseableIteration;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.Value;
import org.openrdf.model.Literal;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameVertex implements Vertex {

    Value value;
    SailConnection sailConnection;

    public SesameVertex(Value value, SailConnection sailConnection) {
        this.value = value;
        this.sailConnection = sailConnection;
    }

    public void setProperty(String key, Object value) {

    }

    public Object getProperty(String key) {
        Set<Value> values = new HashSet<Value>();
        try {
            CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements((Resource) this.value, new URIImpl(key), null, false);
            while (results.hasNext()) {
                Statement s = results.next();
                Value value = s.getObject();
                if(value instanceof Literal) {
                    values.add(value);
                }
            }
            results.close();
        } catch(SailException e) {
            e.printStackTrace();
        }
        if(values.size() > 0)
            return values;
        else
            return null;
    }

    public Set<String> getPropertyKeys() {
        Set<String> keys = new HashSet<String>();
        try {
            CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements((Resource) this.value, null, null, false);
            while (results.hasNext()) {
                Statement s = results.next();
                Value value = s.getObject();
                if(value instanceof Literal) {
                    keys.add(s.getPredicate().toString());
                }
            }
            results.close();
        } catch(SailException e) {
            e.printStackTrace();
        }
        return keys;
    }

    public Set<Edge> getEdges(Direction direction) {
        Set<Edge> edges = new HashSet<Edge>();
        try {
            if (direction == Direction.OUT) {
                if (value instanceof Resource) {
                    CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements((Resource) this.value, null, null, false);
                    while (results.hasNext()) {
                        edges.add(new SesameEdge(results.next(), this.sailConnection));
                    }
                    results.close();
                }
            } else {
                CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements(null, null, this.value, false);
                while (results.hasNext()) {
                    edges.add(new SesameEdge(results.next(), this.sailConnection));
                }
                results.close();
            }
        } catch (SailException e) {
            e.printStackTrace();
        }
        return edges;

    }

    public String toString() {
        return this.value.toString();
    }
}

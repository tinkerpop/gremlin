package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.Edge;
import com.tinkerpop.gremlin.Vertex;
import info.aduna.iteration.CloseableIteration;
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
        return null;
    }

    public Set<String> getPropertyKeys() {
        return new HashSet<String>();
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
}

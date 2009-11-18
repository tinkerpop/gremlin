package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.Graph;
import com.tinkerpop.gremlin.Vertex;
import org.openrdf.model.Value;
import org.openrdf.sail.Sail;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameGraph implements Graph {

    Sail sail;
    SailConnection sailConnection;

    public SesameGraph(Sail sail) throws SailException {
        this.sail = sail;
        this.sailConnection = sail.getConnection();
    }

    public Vertex getVertex(Object id) {
        if (id instanceof Value) {
            return new SesameVertex((Value) id, this.sailConnection);
        } else {
            return null;
        }
    }

    public void shutdown() throws SailException {
        this.sailConnection.close();
        this.sail.shutDown();
    }
}

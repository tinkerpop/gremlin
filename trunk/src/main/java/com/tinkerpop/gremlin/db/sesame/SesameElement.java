package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.model.Element;
import info.aduna.iteration.CloseableIteration;
import org.openrdf.model.Namespace;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public abstract class SesameElement implements Element {

    protected SailConnection sailConnection;

    public SesameElement(SailConnection sailConnection) {
        this.sailConnection = sailConnection;
    }
}

package com.tinkerpop.gremlin.db.io;

import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class FileElement implements Element {

    public Set<String> getPropertyKeys() {
        return null;
    }

    public Object removeProperty(String key) {
        return null;
    }

    public void setProperty(String key, Object value) {
        
    }

    public Object getProperty(String key) {
        return null;
    }

}

package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.model.Element;
import org.neo4j.api.core.PropertyContainer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoElement implements Element {

    protected PropertyContainer element;

    public void setProperty(String key, Object value) {
        this.element.setProperty(key, value);
    }

    public Object getProperty(String key) {
        return this.element.getProperty(key);
    }

    public Set<String> getPropertyKeys() {
        Set<String> keys = new HashSet<String>();
        for (String key : this.element.getPropertyKeys()) {
            keys.add(key);
        }
        return keys;
    }

    public int hashCode() {
        return this.element.hashCode();
    }

    public boolean equals(Object object) {
        if(object instanceof Element)
            return this.hashCode() == object.hashCode();
        else
            return false;
    }

    public String toString() {
        if (null == this.element)
            return null;
        else
            return this.element.toString();
    }
}

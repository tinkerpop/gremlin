package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.model.Index;
import org.neo4j.api.core.Node;
import org.neo4j.api.core.PropertyContainer;
import org.neo4j.api.core.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoElement implements Element {

    protected PropertyContainer element;
    protected final Index index;

    public NeoElement(Index index) {
        this.index = index;
    }

    public void setProperty(String key, Object value) {
        this.index.remove(key, this.getProperty(key), this);
        this.element.setProperty(key, value);
        this.index.put(key, value, this);
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

    public PropertyContainer getRawElement() {
        return this.element;
    }

    public boolean equals(Object object) {
        if (object instanceof Element)
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

    public Object getId() {
        if (this.element instanceof Node) {
            return ((Node) this.element).getId();
        } else { //if(this.element instanceof Relationship) {
            return ((Relationship) this.element).getId();
        }
    }
}

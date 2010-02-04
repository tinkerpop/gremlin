package com.tinkerpop.gremlin.models.ggm.impls.neo4j;

import com.tinkerpop.gremlin.models.ggm.Element;
import com.tinkerpop.gremlin.models.ggm.Index;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.NotFoundException;
import org.neo4j.graphdb.PropertyContainer;
import org.neo4j.graphdb.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class Neo4jElement implements Element {

    protected Neo4jGraph graph;
    protected PropertyContainer element;
    protected final Index index;

    public Neo4jElement(final Index index, final Neo4jGraph graph) {
        this.index = index;
        this.graph = graph;
    }

    public void setProperty(final String key, final Object value) {
        if (this instanceof Neo4jVertex) {
            Object value2 = this.getProperty(key);
            if (null != value2)
                this.index.remove(key, value2, this);
        }

        this.element.setProperty(key, value);
        if (this instanceof Neo4jVertex)
            this.index.put(key, value, this);

        this.graph.stopStartTransaction();
    }

    public Object getProperty(final String key) {
        if (this.element.hasProperty(key))
            return this.element.getProperty(key);
        else
            return null;
    }

    public Set<String> getPropertyKeys() {
        Set<String> keys = new HashSet<String>();
        for (String key : this.element.getPropertyKeys()) {
            keys.add(key);
        }
        return keys;
    }

    public Object removeProperty(final String key) {
        try {
            if (this instanceof Neo4jVertex) {
                Object value2 = this.getProperty(key);
                if (null != value2)
                    this.index.remove(key, value2, this);
            }
            Object value = this.element.removeProperty(key);
            this.graph.stopStartTransaction();
            return value;
        } catch (NotFoundException e) {
            return null;
        }
    }

    public int hashCode() {
        return this.getId().hashCode();
    }

    public PropertyContainer getRawElement() {
        return this.element;
    }

    public Object getId() {
        if (this.element instanceof Node) {
            return ((Node) this.element).getId();
        } else {
            return ((Relationship) this.element).getId();
        }
    }
}

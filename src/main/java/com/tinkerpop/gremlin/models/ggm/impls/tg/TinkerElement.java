package com.tinkerpop.gremlin.models.ggm.impls.tg;

import com.tinkerpop.gremlin.models.ggm.Element;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class TinkerElement implements Element {

    protected Map<String, Object> properties = new HashMap<String, Object>();
    protected final String id;
    protected final TinkerIndex index;

    protected TinkerElement(final String id, final TinkerIndex index) {
        this.index = index;
        this.id = id;
    }

    public Set<String> getPropertyKeys() {
        return this.properties.keySet();
    }

    public void setProperty(final String key, final Object value) {
        this.index.remove(key, this.getProperty(key), this);
        this.properties.put(key, value);
        this.index.put(key, value, this);
    }

    public Object getProperty(final String key) {
        return this.properties.get(key);
    }

    public Object removeProperty(final String key) {
        this.index.remove(key, this.getProperty(key), this);
        return this.properties.remove(key);
    }

    public int hashCode() {
        return this.getId().hashCode();
    }

    public String getId() {
        return this.id;
    }
}

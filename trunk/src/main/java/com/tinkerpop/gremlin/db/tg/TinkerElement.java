package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Element;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerElement implements Element {

    protected Map<String, Object> properties = new HashMap<String, Object>();
    protected final String id;
    protected final TinkerIndex index;

    protected TinkerElement(String id, TinkerIndex index) {
        if (null == id)
            this.id = UUID.randomUUID().toString();
        else
            this.id = id;

        this.index = index;
    }

    public Set<String> getPropertyKeys() {
        return this.properties.keySet();
    }

    public void setProperty(String key, Object value) {
        this.index.remove(key, this.getProperty(key), this);
        this.properties.put(key, value);
        this.index.put(key, value, this);
    }

    public Object getProperty(String key) {
        return this.properties.get(key);
    }

    public Object removeProperty(String key) {
        this.index.remove(key, this.getProperty(key), this);
        return this.properties.remove(key);
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

}

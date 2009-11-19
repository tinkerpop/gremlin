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
    protected String id;

    public TinkerElement() {
        this.id = UUID.randomUUID().toString();
    }

    public TinkerElement(String id) {
        this.id = id;
    }

    public Set<String> getPropertyKeys() {
        return this.properties.keySet();
    }

    public void setProperty(String key, Object value) {
        this.properties.put(key, value);
    }

    public Object getProperty(String key) {
        return this.properties.get(key);
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

}

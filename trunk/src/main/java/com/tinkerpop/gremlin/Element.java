package com.tinkerpop.gremlin;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public interface Element {

    public Object getProperty(String key);

    public Set<String> getPropertyKeys();

    public void setProperty(String key, Object value);
}

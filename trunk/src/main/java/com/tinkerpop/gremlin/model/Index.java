package com.tinkerpop.gremlin.model;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface Index {

    public void put(String key, Object value, Element element);

    public Iterable<Element> get(String key, Object value);

    public void remove(String key, Object value, Element element);

    public void indexAll(boolean indexAll);

    public void addIndexKey(String key);

    public void removeIndexKey(String key);
}

package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.model.Index;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TinkerIndex implements Index {

    private Map<String, Map<Object, Set<Element>>> indices = new HashMap<String, Map<Object, Set<Element>>>();
    private boolean indexAll = true;
    private Set<String> indexKeys = new HashSet<String>();

    public void put(final String key, final Object value, final Element element) {
        if (this.indexAll || indexKeys.contains(key)) {

            Map<Object, Set<Element>> keyMap = this.indices.get(key);
            if (keyMap == null) {
                keyMap = new HashMap<Object, Set<Element>>();
                this.indices.put(key, keyMap);
            }
            Set<Element> elements = keyMap.get(value);
            if (null == elements) {
                elements = new HashSet<Element>();
                keyMap.put(value, elements);
            }
            elements.add(element);
        }
    }

    public Iterable<Element> get(final String key, final Object value) {
        Map<Object, Set<Element>> keyMap = this.indices.get(key);
        if (null == keyMap) {
            return null;
        } else {
            return keyMap.get(value);
        }

    }

    public void remove(final String key, final Object value, final Element element) {
        Map<Object, Set<Element>> keyMap = this.indices.get(key);
        if (null != keyMap) {
            Set<Element> elements = keyMap.get(value);
            if (null != elements) {
                elements.remove(element);
                if (elements.size() == 0) {
                    keyMap.remove(value);
                }
            }
        }
    }

    public void indexAll(final boolean indexAll) {
        this.indexAll = indexAll;
    }

    public void addIndexKey(final String key) {
        indexKeys.add(key);
    }

    public void removeIndexKey(final String key) {
        indexKeys.remove(key);
    }

    public String toString() {
        return indices.toString();
    }

}

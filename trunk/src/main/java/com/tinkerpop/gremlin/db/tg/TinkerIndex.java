package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.model.Index;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerIndex implements Index {

    private Map<String, Map<Object, Set<Element>>> indices = new HashMap<String, Map<Object, Set<Element>>>();

    public void put(String key, Object value, Element element) {
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

    public Set<Element> get(String key, Object value) {
        Map<Object, Set<Element>> keyMap = this.indices.get(key);
        if (null == keyMap) {
            return null;
        } else {
            return keyMap.get(value);
        }

    }

    public void remove(String key, Object value, Element element) {
        Map<Object, Set<Element>> keyMap = this.indices.get(key);
        if (null != keyMap) {
            Set<Element> elements = keyMap.get(value);
            if (null != elements) {
                elements.remove(element);
                if(elements.size() == 0) {
                    keyMap.remove(value);
                }
            }
        }
    }

    /*public void remove(String key) {

    }

    public void remove(String key, Object value) {

    }*/

    public String toString() {
        return indices.toString();
    }

}

package com.tinkerpop.gremlin.paths.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MapPropertyHandler extends ObjectPropertyHandler {

    public String[] getPropertyNames(final Object mapObject) {
        Map map = (Map) mapObject;
        List<String> list = new ArrayList<String>();
        for (Object key : map.keySet()) {
            if (key instanceof String) {
                list.add((String) key);
            }
        }
        list.addAll(Arrays.asList(super.getPropertyNames(mapObject)));
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(final Object mapObject, final String key, final Object value) {
        Map map = (Map) mapObject;
        map.put(key, value);
    }

    public Object getProperty(final Object mapObject, final String key) {

        Map map = (Map) mapObject;
        if (super.containsProperty(key)) {
            return super.getProperty(mapObject, key);
        } else {
            return map.get(key);
        }
    }
}

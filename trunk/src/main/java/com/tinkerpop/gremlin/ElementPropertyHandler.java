package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class ElementPropertyHandler implements DynamicPropertyHandler {

    private static Map<String, DynamicPath> paths = new HashMap<String, DynamicPath>();

    public String[] getPropertyNames(final Object object) {
        return paths.keySet().toArray(new String[paths.size()]);
    }

    public Object getProperty(final Object object, final String key) {
        DynamicPath path = paths.get(key);
        return path.invoke(object);
    }

    public static void addDynamicPath(DynamicPath path) throws EvaluationException {
        paths.put(path.getPathName(), path);
    }

    public boolean containsProperty(String key) {
        return paths.containsKey(key);
    }
}

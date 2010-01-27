package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class ElementPropertyHandler implements DynamicPropertyHandler {

    private static Map<String, DynamicPath> paths = new HashMap<String, DynamicPath>();
    private static Set<String> properties = new HashSet<String>();


    public String[] getPropertyNames(final Object object) {
        return properties.toArray(new String[properties.size()]);
    }

    public Object getProperty(final Object object, final String key) {
        DynamicPath path = paths.get(key);
        return path.invoke(object);
    }

    public static void addDynamicPath(DynamicPath path) throws EvaluationException {
        String pathName = path.getPathName();
        if (pathName.equals(Tokens.VERTICES) || pathName.equals(Tokens.EDGES) || pathName.equals(Tokens.OUT_EDGES) ||
                pathName.equals(Tokens.IN_EDGES) || pathName.equals(Tokens.BOTH_EDGES) || pathName.equals(Tokens.OUT_VERTEX) ||
                pathName.equals(Tokens.IN_VERTEX) || pathName.equals(Tokens.BOTH_VERTICES) || pathName.equals(Tokens.LABEL) ||
                pathName.equals(Tokens.ID)) {
            throw new EvaluationException("Cannot override Gremlin path primitive: " + pathName);
        } else {
            paths.put(pathName, path);
            properties.add(pathName);
        }
    }
}

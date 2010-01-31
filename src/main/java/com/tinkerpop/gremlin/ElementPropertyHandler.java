package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.paths.Path;
import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class ElementPropertyHandler implements DynamicPropertyHandler {

    public String[] getPropertyNames(final Object object) {
        Set<String> pathNames = GremlinPathContext.getPathNames();
        return pathNames.toArray(new String[pathNames.size()]);
    }

    public Object getProperty(final Object object, final String key) {
        Path path = GremlinPathContext.getPath(key);
        return path.invoke(object);
    }

    public boolean containsProperty(String key) {
        return GremlinPathContext.getPath(key) != null;
    }
}

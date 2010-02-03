package com.tinkerpop.gremlin.paths.handlers;

import com.tinkerpop.gremlin.GremlinPathContext;
import com.tinkerpop.gremlin.paths.Path;
import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ObjectPropertyHandler implements DynamicPropertyHandler {

    public String[] getPropertyNames(final Object object) {
        Set<String> pathNames = GremlinPathContext.getPaths().getPathNames();
        return pathNames.toArray(new String[pathNames.size()]);
    }

    public Object getProperty(final Object object, final String key) {
        Path path = GremlinPathContext.getPaths().getPath(key);
        return path.invoke(object);
    }

    public boolean containsProperty(String key) {
        return GremlinPathContext.getPaths().getPath(key) != null;
    }

    public void setProperty(final Object object, final String key, final Object value) {

    }
}

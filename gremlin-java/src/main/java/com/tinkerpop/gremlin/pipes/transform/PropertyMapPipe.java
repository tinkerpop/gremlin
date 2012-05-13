package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Element;
import com.tinkerpop.pipes.AbstractPipe;

import java.util.HashMap;
import java.util.Map;

/**
 * PropertyMapPipe emits the property map of an element.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PropertyMapPipe<S extends Element> extends AbstractPipe<S, Map<String, Object>> {

    protected Map<String, Object> processNextStart() {
        final S element = this.starts.next();
        final Map<String, Object> map = new HashMap<String, Object>();
        for (final String key : element.getPropertyKeys()) {
            map.put(key, element.getProperty(key));
        }
        return map;
    }
}

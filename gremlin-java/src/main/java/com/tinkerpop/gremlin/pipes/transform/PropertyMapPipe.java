package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Element;
import com.tinkerpop.gremlin.Tokens;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.transform.TransformPipe;

import java.util.HashMap;
import java.util.Map;

/**
 * PropertyMapPipe emits the property map of an element.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PropertyMapPipe<S extends Element> extends AbstractPipe<S, Map<String, Object>> implements TransformPipe {

    private final String[] keys;

    public PropertyMapPipe(final String... keys) {
        this.keys = keys;
    }

    protected Map<String, Object> processNextStart() {
        final S element = this.starts.next();
        final Map<String, Object> map = new HashMap<String, Object>();
        if (this.keys.length == 0) {
            // TODO: add ID and LABEL as properties?
            for (final String key : element.getPropertyKeys()) {
                map.put(key, element.getProperty(key));
            }
        } else {
            for (final String key : this.keys) {
                if (key.equals(Tokens.ID))
                    map.put(Tokens.ID, element.getId());
                else if (element instanceof Edge && key.equals(Tokens.LABEL))
                    map.put(Tokens.LABEL, ((Edge) element).getLabel());
                else
                    map.put(key, element.getProperty(key));
            }
        }
        return map;
    }
}

package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.pipes.AbstractPipe;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinPropertyPipe extends AbstractPipe<Object, Object> {

    private final Object key;
    private static final String ILLEGAL_START = "Illegal start to this pipe (must be element or map)";
    private Iterator tempIterator = null;

    public GremlinPropertyPipe(final Object key) {
        this.key = key;
    }

    protected Object processNextStart() {
        if (null != this.tempIterator) {
            if (this.tempIterator.hasNext()) {
                return this.tempIterator.next();
            } else {
                this.tempIterator = null;
            }
        }

        Object start = this.starts.next();
        Object end = null;
        if (start instanceof Element) {
            end = ((Element) start).getProperty((String) this.key);
        } else if (start instanceof Map) {
            end = ((Map) start).get(this.key);
        } else {
            throw new RuntimeException(ILLEGAL_START);
        }

        if (end instanceof Iterable) {
            this.tempIterator = ((Iterable) end).iterator();
            return this.processNextStart();
        } else {
            return end;
        }
    }

    public Object getPropertyKey() {
        return this.key;
    }
}

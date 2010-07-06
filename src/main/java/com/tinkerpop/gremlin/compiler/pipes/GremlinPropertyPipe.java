package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.pipes.AbstractPipe;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinPropertyPipe<E> extends AbstractPipe<Object, E> {

    private final Object key;

    public GremlinPropertyPipe(final Object key) {
        this.key = key;
    }

    protected E processNextStart() {
        Object start = this.starts.next();
        if (start instanceof Element) {
            return (E) ((Element) start).getProperty((String) this.key);
        } else if (start instanceof Map) {
            return (E) ((Map) start).get(new Atom(this.key));
        } else {
            throw new RuntimeException("Illegal start to this pipe");
        }
    }
}

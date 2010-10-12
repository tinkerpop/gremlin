package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.pipes.AbstractPipe;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ScatterPipe extends AbstractPipe<Object, Object> {

    private Iterator<Object> tempIterator;

    public Object processNextStart() {
        while (true) {
            if (null != this.tempIterator && this.tempIterator.hasNext()) {
                return this.tempIterator.next();
            } else {
                Object object = this.starts.next();
                if (object instanceof Iterator)
                    this.tempIterator = (Iterator<Object>) object;
                else if (object instanceof Iterable)
                    this.tempIterator = ((Iterable<Object>) object).iterator();
                else
                    return object;
            }
        }
    }
}
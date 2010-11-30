package com.tinkerpop.gremlin.compiler.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EmptySequence implements Iterable, Iterator {

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public Iterator iterator() {
        return this;
    }

    public Object next() {
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return false;
    }

    public boolean equals(Object object) {
        Iterator itty;
        if (object instanceof Iterable)
            itty = ((Iterable) object).iterator();
        else if (object instanceof Iterator)
            itty = (Iterator) object;
        else
            return false;

        return (!itty.hasNext());
    }

    public String toString() {
        return "[]";
    }

}

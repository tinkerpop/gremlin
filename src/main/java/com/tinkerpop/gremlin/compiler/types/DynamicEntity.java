package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.Atom;

/**
 * @author Pavel A. Yaskevich
 */
public abstract class DynamicEntity extends Atom {

    /* Should be implemented by extending classes */
    protected abstract Object value();

    public Object getValue() {
        return value();
    }
    
    public boolean isNull() {
        return value() == null;
    }
    
    protected boolean isClassOf(final Class klass) {
        return (!isNull()) && (klass.isAssignableFrom(value().getClass()));
    }

    public String toString() {
        return value().toString();
    }
}

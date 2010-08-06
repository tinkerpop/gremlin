package com.tinkerpop.gremlin.compiler.types;

/**
 * @author Pavel A. Yaskevich
 */
public abstract class DynamicEntity extends Atom {

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

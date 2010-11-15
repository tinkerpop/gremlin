package com.tinkerpop.gremlin.compiler.types;

/**
 * @author Pavel A. Yaskevich
 */
public abstract class DynamicEntity extends Atom {

    protected boolean isClassOf(final Class klass) {
        return (!this.isNull()) && (klass.isAssignableFrom(this.getValue().getClass()));
    }

    public String toString() {
        return this.getValue().toString();
    }
}

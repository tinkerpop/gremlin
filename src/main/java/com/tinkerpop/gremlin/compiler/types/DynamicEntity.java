package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.util.Tokens;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class DynamicEntity extends Atom {

    protected boolean isClassOf(final Class klass) {
        return (!this.isNull()) && (klass.isAssignableFrom(this.getValue().getClass()));
    }

    public String toString() {
        if (null == this.getValue())
            return Tokens.NULL;
        else
            return this.getValue().toString();
    }
}

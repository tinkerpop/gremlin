package com.tinkerpop.gremlin.compiler.types;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Return<T> extends Atom<T> {

    public Return(T value) {
        super(value);
    }
}
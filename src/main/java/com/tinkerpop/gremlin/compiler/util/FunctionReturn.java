package com.tinkerpop.gremlin.compiler.util;

import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FunctionReturn<T> extends Atom<T> {

    public FunctionReturn(T value) {
        super(value);
    }
}
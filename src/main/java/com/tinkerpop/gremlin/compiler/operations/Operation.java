package com.tinkerpop.gremlin.compiler.operations;

import com.tinkerpop.gremlin.compiler.Atom;

/**
 * @author Pavel A. Yaskevich
 */
public interface Operation {
    public enum Type {
        MATH, LOGIC, STATEMENT
    }

    public Atom compute();

    public Type getType();

}

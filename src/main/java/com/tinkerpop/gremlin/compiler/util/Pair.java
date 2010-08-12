package com.tinkerpop.gremlin.compiler.util;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Pair<A, B> {

    private final A a;
    private final B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return this.a;
    }

    public B getB() {
        return this.b;
    }

}

package com.tinkerpop.gremlin;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Pair<A,B> {

    protected A a;
    protected B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getFirst() {
        return this.a;
    }

    public B getSecond() {
        return this.b;
    }

    public Class getFirstClass() {
        return a.getClass();
    }

    public Class getSecondClass() {
        return b.getClass();
    }

}

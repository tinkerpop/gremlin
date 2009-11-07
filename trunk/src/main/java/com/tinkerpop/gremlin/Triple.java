package com.tinkerpop.gremlin;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Triple<A,B,C> extends Pair<A,B> {

    protected C c;

    public Triple(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }

    public C getThird() {
        return this.c;
    }

}

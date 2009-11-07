package com.tinkerpop.gremlin;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Quadruple<A,B,C,D> extends Triple<A,B,C> {

    protected D d;

    public Quadruple(A a, B b, C c, D d) {
        super(a,b,c);
        this.d = d;
    }

    public D getForth() {
        return this.d;
    }
}

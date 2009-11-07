package com.tinkerpop.gremlin;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public interface Function<Domain,Codomain> {

    public Codomain evaluate(final Domain domain);
    public String getName();

}

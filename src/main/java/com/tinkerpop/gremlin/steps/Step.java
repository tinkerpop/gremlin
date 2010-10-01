package com.tinkerpop.gremlin.steps;

import com.tinkerpop.pipes.Pipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface Step<S,E> extends Pipe<S,E> {

    public String getStepName();

}

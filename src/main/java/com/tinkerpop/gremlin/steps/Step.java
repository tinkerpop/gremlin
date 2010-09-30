package com.tinkerpop.gremlin.steps;

import com.tinkerpop.pipes.Pipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface Step extends Pipe<Object, Object> {

    public String getStepName();

}

package com.tinkerpop.gremlin.pipes.util;

import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.PipeClosure;
import groovy.lang.Closure;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroovyPipeClosure implements PipeClosure {

    private final Closure closure;

    public GroovyPipeClosure(final Closure closure) {
        this.closure = closure;
    }

    public Object compute(final Object... parameters) {
        return this.closure.call(parameters);
    }

    public void setPipe(final Pipe pipe) {
        this.closure.setDelegate(pipe);
    }

    public static PipeClosure[] generate(final Closure... closures) {
        final PipeClosure[] pipeClosures = new PipeClosure[closures.length];
        for (int i = 0; i < closures.length; i++) {
            pipeClosures[i] = new GroovyPipeClosure(closures[i]);
        }
        return pipeClosures;
    }
}

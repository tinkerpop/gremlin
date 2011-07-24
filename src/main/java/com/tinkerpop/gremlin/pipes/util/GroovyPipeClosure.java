package com.tinkerpop.gremlin.pipes.util;

import com.tinkerpop.pipes.AbstractPipeClosure;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.PipeClosure;
import groovy.lang.Closure;

/**
 * GroovyPipeClosure wraps a Groovy Closure in a PipeClosure.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroovyPipeClosure extends AbstractPipeClosure {

    private final Closure closure;

    public GroovyPipeClosure(final Closure closure) {
        this.closure = closure;
    }

    public Object compute(final Object... parameters) {
        return this.closure.call(parameters);
    }

    public void setPipe(final Pipe hostPipe) {
        super.setPipe(hostPipe);
        this.closure.setDelegate(hostPipe);
    }

    public static PipeClosure[] generate(final Closure... closures) {
        final PipeClosure[] pipeClosures = new PipeClosure[closures.length];
        for (int i = 0; i < closures.length; i++) {
            pipeClosures[i] = new GroovyPipeClosure(closures[i]);
        }
        return pipeClosures;
    }
}

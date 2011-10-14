package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.pipes.PipeFunction;
import groovy.lang.Closure;

/**
 * GroovyPipeFunction wraps a Groovy Closure in a PipeFunction.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroovyPipeFunction<A, B> implements PipeFunction<A, B> {

    private final Closure closure;

    public GroovyPipeFunction(final Closure closure) {
        this.closure = closure;
    }

    public B compute(final A argument) {
        return (B) this.closure.call(argument);
    }

    public static PipeFunction[] generate(final Closure... closures) {
        final PipeFunction[] pipeFunctions = new PipeFunction[closures.length];
        for (int i = 0; i < closures.length; i++) {
            pipeFunctions[i] = new GroovyPipeFunction(closures[i]);
        }
        return pipeFunctions;
    }
}

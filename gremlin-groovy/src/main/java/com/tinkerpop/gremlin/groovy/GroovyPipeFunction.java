package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.util.PipesFunction;
import com.tinkerpop.pipes.util.structures.AsMap;
import groovy.lang.Closure;

/**
 * GroovyPipeFunction wraps a Groovy Closure in a PipeFunction.
 * If used within the context of a GremlinGroovyPipeline, the AsMap is the second argument of the function.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroovyPipeFunction<A, B> extends PipesFunction<A, B> {

    private final Closure closure;
    private final boolean doAsMap;

    public GroovyPipeFunction(final AsMap asMap, final Closure closure) {
        this.closure = closure;
        this.setAsMap(asMap);
        this.doAsMap = null != this.asMap && this.closure.getParameterTypes().length > 1;
    }

    public GroovyPipeFunction(final Closure closure) {
        this(null, closure);
    }

    public B compute(final A argument) {
        return this.doAsMap ? (B) this.closure.call(argument, this.asMap) : (B) this.closure.call(argument);
    }

    public static PipeFunction[] generate(final AsMap asMap, final Closure... closures) {
        final PipeFunction[] pipeFunctions = new PipeFunction[closures.length];
        for (int i = 0; i < closures.length; i++) {
            pipeFunctions[i] = new GroovyPipeFunction(asMap, closures[i]);
        }
        return pipeFunctions;
    }

    public static PipeFunction[] generate(final Closure... closures) {
        final PipeFunction[] pipeFunctions = new PipeFunction[closures.length];
        for (int i = 0; i < closures.length; i++) {
            pipeFunctions[i] = new GroovyPipeFunction(null, closures[i]);
        }
        return pipeFunctions;
    }
}

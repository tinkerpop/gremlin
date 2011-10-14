package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.gremlin.pipes.GremlinPipeline;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinGroovyPipeline<S, E> extends GremlinPipeline<S, E, GremlinGroovyPipeline> {

    public GremlinGroovyPipeline(final Object starts) {
        super(starts);
    }

    public GremlinGroovyPipeline() {
        super();
    }
}

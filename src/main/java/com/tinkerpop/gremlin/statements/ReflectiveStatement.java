package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.GremlinEvaluator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface ReflectiveStatement {

    public void setGremlinEvaluator(final GremlinEvaluator gremlinEvaluator);
}

package com.tinkerpop.gremlin.compiler.functions.jung;

import com.tinkerpop.gremlin.compiler.functions.AbstractFunctions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class JungFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "jung";

    public JungFunctions() {
        this.functions.add(new PageRankFunction());
        this.functions.add(new DijkstraShortestPathFunction());
    }

    public String getNamespace() {
        return NAMESPACE;
    }
}
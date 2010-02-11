package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.gremlin.functions.FunctionLibrary;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class JungFunctions extends FunctionLibrary {

    public static final String NAMESPACE_PREFIX = "jung";

    public JungFunctions() {
        this.addFunction(NAMESPACE_PREFIX, new PageRankFunction());
        this.addFunction(NAMESPACE_PREFIX, new DijkstraShortestPathFunction());

    }

}

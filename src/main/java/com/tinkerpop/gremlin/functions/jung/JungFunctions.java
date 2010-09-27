package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.gremlin.functions.AbstractFunctions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class JungFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "jung";

    public JungFunctions() {
        try
        {
            this.functions.add(new PageRankFunction());
            this.functions.add(new DijkstraShortestPathFunction());
        }
        catch (NoClassDefFoundError ignore)
        {
            // If jung.jar is not provided, proceed without adding functions.
        }
    }

    public String getNamespace() {
        return NAMESPACE;
    }
}
package com.tinkerpop.gremlin.functions.neo4j;

import com.tinkerpop.gremlin.functions.AbstractFunctions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "neo4j";

    public Neo4jFunctions() {
        this.functions.add(new OpenFunction());
    }

    public String getNamespace() {
        return NAMESPACE;
    }
}
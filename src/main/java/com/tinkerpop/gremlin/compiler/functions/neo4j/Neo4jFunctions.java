package com.tinkerpop.gremlin.compiler.functions.neo4j;

import com.tinkerpop.gremlin.compiler.functions.AbstractFunctions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "neo4j";

    public Neo4jFunctions() {
        this.functions.add(new AutoTransactionFunction());
        this.functions.add(new OpenFunction());
        this.functions.add(new StartTransactionFunction());
        this.functions.add(new StopTransactionFunction());
    }

    public String getNamespace() {
        return NAMESPACE;
    }
}
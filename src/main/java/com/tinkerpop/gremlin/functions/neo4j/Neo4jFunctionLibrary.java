package com.tinkerpop.gremlin.functions.neo4j;

import com.tinkerpop.gremlin.functions.FunctionLibrary;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jFunctionLibrary extends FunctionLibrary {

    public static final String NAMESPACE_PREFIX = "neo4j";

    public Neo4jFunctionLibrary() {
        this.addFunction(NAMESPACE_PREFIX, new OpenFunction());
        this.addFunction(NAMESPACE_PREFIX, new AutomaticTransactionsFunction());
        this.addFunction(NAMESPACE_PREFIX, new StartTransactionFunction());
        this.addFunction(NAMESPACE_PREFIX, new StopTransactionFunction());
    }
}

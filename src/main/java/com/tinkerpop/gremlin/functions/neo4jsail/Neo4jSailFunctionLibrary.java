package com.tinkerpop.gremlin.functions.neo4jsail;

import com.tinkerpop.gremlin.functions.FunctionLibrary;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jSailFunctionLibrary extends FunctionLibrary {

    public static final String NAMESPACE_PREFIX = "neo4jsail";

    public Neo4jSailFunctionLibrary() {
        this.addFunction(NAMESPACE_PREFIX, new OpenFunction());
    }
}
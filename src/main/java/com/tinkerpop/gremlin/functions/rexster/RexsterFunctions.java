package com.tinkerpop.gremlin.functions.rexster;

import com.tinkerpop.gremlin.functions.AbstractFunctions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RexsterFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "rexster";

    public RexsterFunctions() {
        this.functions.add(new OpenFunction());
    }

    public String getNamespace() {
        return NAMESPACE;
    }
}
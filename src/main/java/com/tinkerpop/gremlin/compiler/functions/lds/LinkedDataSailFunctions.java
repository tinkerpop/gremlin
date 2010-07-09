package com.tinkerpop.gremlin.compiler.functions.lds;

import com.tinkerpop.gremlin.compiler.functions.AbstractFunctions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LinkedDataSailFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "lds";

    public LinkedDataSailFunctions() {
        this.functions.add(new OpenFunction());

    }

    public String getNamespace() {
        return NAMESPACE;
    }
}
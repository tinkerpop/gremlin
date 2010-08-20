package com.tinkerpop.gremlin.compiler.functions.orientdb;

import com.tinkerpop.gremlin.compiler.functions.AbstractFunctions;

/**
 * @author Luca Garulli (http://www.orientechnologies.com)
 */
public class OrientDBFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "orientdb";

    public OrientDBFunctions() {
        this.functions.add(new OpenFunction());
    }

    public String getNamespace() {
        return NAMESPACE;
    }
}
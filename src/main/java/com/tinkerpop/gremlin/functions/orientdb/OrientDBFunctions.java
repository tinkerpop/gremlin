package com.tinkerpop.gremlin.functions.orientdb;

import com.tinkerpop.gremlin.functions.AbstractFunctions;

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
package com.tinkerpop.gremlin.functions.tg;

import com.tinkerpop.gremlin.functions.AbstractFunctions;

/**
 * @author Pavel A. Yaskevich
 */
public class TinkerGraphFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "tg";

    public TinkerGraphFunctions() {
        this.functions.add(new OpenFunction());

    }

    public String getNamespace() {
        return NAMESPACE;
    }
}

package com.tinkerpop.gremlin.compiler.functions.tg;

import com.tinkerpop.gremlin.compiler.functions.AbstractFunctions;

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

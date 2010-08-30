package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.gremlin.functions.AbstractFunctions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SailFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "sail";

    public SailFunctions() {
        this.functions.add(new AddNamespaceFunction());
        this.functions.add(new GetNamespacesFunction());
        this.functions.add(new LoadFunction());
        this.functions.add(new OpenFunction());
        this.functions.add(new PrefixFunction());
        this.functions.add(new NamespaceFunction());
        this.functions.add(new RemoveNamespaceFunction());
        this.functions.add(new SparqlFunction());
    }

    public String getNamespace() {
        return NAMESPACE;
    }
}

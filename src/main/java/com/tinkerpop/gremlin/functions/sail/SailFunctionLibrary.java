package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.gremlin.functions.FunctionLibrary;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SailFunctionLibrary extends FunctionLibrary {

    public static final String NAMESPACE_PREFIX = "sail";

    public SailFunctionLibrary() {
        this.addFunction(NAMESPACE_PREFIX, new OpenFunction());
        this.addFunction(NAMESPACE_PREFIX, new AddNamespaceFunction());
        this.addFunction(NAMESPACE_PREFIX, new RemoveNamespaceFunction());
        this.addFunction(NAMESPACE_PREFIX, new GetNamespacesFunction());
        this.addFunction(NAMESPACE_PREFIX, new LoadFunction());
        this.addFunction(NAMESPACE_PREFIX, new PrefixFunction());
        this.addFunction(NAMESPACE_PREFIX, new NamespaceFunction());
        this.addFunction(NAMESPACE_PREFIX, new SparqlFunction());
    }


}

package com.tinkerpop.gremlin.compiler.functions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NativeFunctions extends AbstractFunctions {

    private final String namespace;

    public NativeFunctions(String namespace) {
        this.namespace = namespace;
    }
    
    public String getNamespace() {
        return this.namespace;
    }
}

package com.tinkerpop.gremlin.functions.lds;

import com.tinkerpop.gremlin.functions.FunctionLibrary;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LinkedDataSailFunctionLibrary extends FunctionLibrary {

    public static final String NAMESPACE_PREFIX = "lds";

    public LinkedDataSailFunctionLibrary() {
        this.addFunction(NAMESPACE_PREFIX, new OpenFunction());
    }
}

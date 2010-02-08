package com.tinkerpop.gremlin.functions.fs;

import com.tinkerpop.gremlin.functions.FunctionLibrary;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FileSystemFunctions extends FunctionLibrary {

    public static final String NAMESPACE_PREFIX = "lds";

    public FileSystemFunctions() {
        this.addFunction(NAMESPACE_PREFIX, new OpenFunction());
    }
}

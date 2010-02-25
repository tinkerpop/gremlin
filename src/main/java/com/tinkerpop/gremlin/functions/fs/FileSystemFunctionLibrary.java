package com.tinkerpop.gremlin.functions.fs;

import com.tinkerpop.gremlin.functions.FunctionLibrary;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FileSystemFunctionLibrary extends FunctionLibrary {

    public static final String NAMESPACE_PREFIX = "fs";

    public FileSystemFunctionLibrary() {
        this.addFunction(NAMESPACE_PREFIX, new OpenFunction());
    }
}

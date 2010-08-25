package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class AbstractFunction<T> implements Function<T> {

    private static final String UNSUPPORTED_MESSAGE = "Unsupported arguments for ";

    protected String createUnsupportedArgumentMessage() {
        return UNSUPPORTED_MESSAGE + this.getFunctionName() + " function";
    }

    protected String createUnsupportedArgumentMessage(String extraInfo) {
        return UNSUPPORTED_MESSAGE + this.getFunctionName() + " function: " + extraInfo;
    }

}

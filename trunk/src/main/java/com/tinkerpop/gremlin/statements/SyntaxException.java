package com.tinkerpop.gremlin.statements;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SyntaxException extends RuntimeException {

    public SyntaxException(final String message) {
        super(message);
    }
}

package com.tinkerpop.gremlin.statements;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SyntaxException extends RuntimeException {

    private static final String MESSAGE_HEADER = "Syntax error: ";

    public SyntaxException(String message) {
        super(MESSAGE_HEADER + message);
    }
}

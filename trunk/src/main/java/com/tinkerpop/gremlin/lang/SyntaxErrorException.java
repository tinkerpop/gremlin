package com.tinkerpop.gremlin.lang;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SyntaxErrorException extends RuntimeException {

    public SyntaxErrorException(String message) {
        super(message);
    }
}

package com.tinkerpop.gremlin.compiler.exceptions;

/**
 * @author Pavel A. Yaskevich
 */
public class SyntaxErrorException extends RuntimeException {

    public SyntaxErrorException(final String message) {
        super(message);
    }

}

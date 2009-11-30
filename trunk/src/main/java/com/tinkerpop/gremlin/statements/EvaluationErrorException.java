package com.tinkerpop.gremlin.statements;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class EvaluationErrorException extends RuntimeException {

    private static final String MESSAGE_HEADER = "Evaluation error: ";

    public EvaluationErrorException(String message) {
        super(MESSAGE_HEADER + message);
    }
}

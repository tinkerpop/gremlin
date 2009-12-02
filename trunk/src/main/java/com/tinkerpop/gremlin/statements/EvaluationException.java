package com.tinkerpop.gremlin.statements;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class EvaluationException extends RuntimeException {

    public static final String MESSAGE_HEADER = "Evaluation error: ";
    private static final String EMBEDDED_COLLECTION_MESSAGE = "a collection or map can not be the element of a collection or map";
    private static final String UNSUPPORTED_PARAMETERS_MESSAGE = "does not support provided parameters";
    private static final String INDEX_BOUND_MESSAGE = "index out of bounds of collection";
    private static final String NO_FUNCTION_MESSAGE = "undefined function";

    public enum EvaluationErrorType {UNSUPPORTED_PARAMETERS, EMBEDDED_COLLECTIONS, INDEX_BOUNDS, NO_FUNCTION}


    public EvaluationException(String message) {
        super(message);
    }

    public static EvaluationException createException(String functionName, EvaluationErrorType type) {
        if(type == EvaluationErrorType.UNSUPPORTED_PARAMETERS)
            return new EvaluationException(MESSAGE_HEADER + functionName + " " + UNSUPPORTED_PARAMETERS_MESSAGE);
        else if(type == EvaluationErrorType.EMBEDDED_COLLECTIONS)
            return new EvaluationException(MESSAGE_HEADER + functionName + " " + EMBEDDED_COLLECTION_MESSAGE);
        else if(type == EvaluationErrorType.INDEX_BOUNDS)
            return new EvaluationException(MESSAGE_HEADER + functionName + " " + INDEX_BOUND_MESSAGE);
        else if(type == EvaluationErrorType.NO_FUNCTION)
            return new EvaluationException(MESSAGE_HEADER + NO_FUNCTION_MESSAGE + " " + functionName);
        else
            return new EvaluationException("Evaluation error.");

    }

    public static EvaluationException createException(EvaluationErrorType type) {
        if(type == EvaluationErrorType.UNSUPPORTED_PARAMETERS)
            return new EvaluationException(MESSAGE_HEADER + UNSUPPORTED_PARAMETERS_MESSAGE);
        else if(type == EvaluationErrorType.EMBEDDED_COLLECTIONS)
            return new EvaluationException(MESSAGE_HEADER + EMBEDDED_COLLECTION_MESSAGE);
        else if(type == EvaluationErrorType.INDEX_BOUNDS)
            return new EvaluationException(MESSAGE_HEADER + INDEX_BOUND_MESSAGE);
        else
            return new EvaluationException("Evaluation error.");
    }
}

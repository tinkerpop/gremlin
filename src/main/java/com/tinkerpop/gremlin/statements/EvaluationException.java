package com.tinkerpop.gremlin.statements;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EvaluationException extends RuntimeException {

    private static final String EMBEDDED_COLLECTION_MESSAGE = "a list can not be the element of a list";
    private static final String UNSUPPORTED_PARAMETERS_MESSAGE = "does not support provided parameters";
    private static final String INDEX_BOUND_MESSAGE = "index out of bounds of collection";
    private static final String NO_FUNCTION_MESSAGE = "undefined function";
    private static final String USE_OTHER_MESSAGE = "use the nearly equivalent function in the g namespace";
    private static final String UNSUPPORTED_OPERATION_MESSAGE = "This operation is not supported";

    public enum EvaluationErrorType {
        UNSUPPORTED_PARAMETERS, EMBEDDED_COLLECTIONS, INDEX_BOUNDS, NO_FUNCTION, USE_OTHER, UNSUPPORTED_OPERATION
    }


    public EvaluationException(String message) {
        super(message);
    }

    public static EvaluationException createException(final String functionName, final EvaluationErrorType type) {
        if (type == EvaluationErrorType.UNSUPPORTED_PARAMETERS)
            return new EvaluationException(functionName + " " + UNSUPPORTED_PARAMETERS_MESSAGE);
        else if (type == EvaluationErrorType.EMBEDDED_COLLECTIONS)
            return new EvaluationException(functionName + " " + EMBEDDED_COLLECTION_MESSAGE);
        else if (type == EvaluationErrorType.INDEX_BOUNDS)
            return new EvaluationException(functionName + " " + INDEX_BOUND_MESSAGE);
        else if (type == EvaluationErrorType.NO_FUNCTION)
            return new EvaluationException(NO_FUNCTION_MESSAGE + " " + functionName);
        else if (type == EvaluationErrorType.USE_OTHER)
            return new EvaluationException(USE_OTHER_MESSAGE);
        else
            return new EvaluationException("Evaluation error");

    }

    public static EvaluationException createException(final EvaluationErrorType type) {
        if (type == EvaluationErrorType.UNSUPPORTED_PARAMETERS)
            return new EvaluationException(UNSUPPORTED_PARAMETERS_MESSAGE);
        else if (type == EvaluationErrorType.EMBEDDED_COLLECTIONS)
            return new EvaluationException(EMBEDDED_COLLECTION_MESSAGE);
        else if (type == EvaluationErrorType.INDEX_BOUNDS)
            return new EvaluationException(INDEX_BOUND_MESSAGE);
        else if (type == EvaluationErrorType.UNSUPPORTED_OPERATION)
            return new EvaluationException(UNSUPPORTED_OPERATION_MESSAGE);
        else
            return new EvaluationException("Evaluation error");
    }
}

package com.tinkerpop.gremlin.db.fs.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.db.fs.FileSystemFunctions;
import com.tinkerpop.gremlin.db.fs.FileSystemGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OpenFunction implements Function {

    public static final String FUNCTION_NAME = "open";

    public Graph invoke(final ExpressionContext context, final Object[] parameters) {

        if (parameters == null) {
            return new FileSystemGraph();
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(FileSystemFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}

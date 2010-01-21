package com.tinkerpop.gremlin.db.mongo.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.db.mongo.MongoFunctions;
import com.tinkerpop.gremlin.db.mongo.MongoGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.net.UnknownHostException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OpenFunction implements Function {

    public static final String FUNCTION_NAME = "open";

    public Graph invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters && parameters.length == 3) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof String && objects[1] instanceof Number && objects[2] instanceof String) {
                try {
                    return new MongoGraph((String) objects[0], ((Number) objects[1]).intValue(), (String) objects[2]);
                } catch (UnknownHostException e) {
                    throw new EvaluationException(e.getMessage());
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(MongoFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}

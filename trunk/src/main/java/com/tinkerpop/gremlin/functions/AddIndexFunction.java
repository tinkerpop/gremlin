package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Collection;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AddIndexFunction implements Function {

    public static final String FUNCTION_NAME = "add-idx";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (parameters != null && parameters.length > 0) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof Graph) {
                Graph graph = ((Graph) objects[0]);
                Index index = graph.getIndex();
                if (objects.length == 1) {
                    index.indexAll(true);
                    return Boolean.TRUE;
                } else if (objects.length == 2 && objects[1] instanceof String) {
                    index.addIndexKey((String) objects[1]);
                    return Boolean.TRUE;
                }
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}

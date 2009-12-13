package com.tinkerpop.gremlin.db.sesame.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.db.sesame.SesameFunctions;
import com.tinkerpop.gremlin.db.sesame.SesameGraph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NamespaceFunction implements Function {

    public static final String FUNCTION_NAME = "expand";

    public String invoke(ExpressionContext context, Object[] parameters) {

        if (parameters.length == 2) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof SesameGraph && objects[1] instanceof String) {
                return ((SesameGraph) objects[0]).expandPrefix((String) objects[1]);
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SesameFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}

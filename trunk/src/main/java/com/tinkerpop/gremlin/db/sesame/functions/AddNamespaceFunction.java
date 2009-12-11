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
public class AddNamespaceFunction implements Function {

    public static final String FUNCTION_NAME = "add-ns";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters && parameters.length == 3) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof SesameGraph && objects[1] instanceof String && objects[2] instanceof String) {
                ((SesameGraph) objects[0]).addNamespace((String) objects[1], (String) objects[2]);
                return Boolean.TRUE;
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SesameFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }

}

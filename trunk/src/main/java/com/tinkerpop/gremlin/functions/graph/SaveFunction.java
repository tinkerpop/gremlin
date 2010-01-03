package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.parser.GraphMLWriter;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.io.FileOutputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SaveFunction implements Function {

    public static final String FUNCTION_NAME = "save";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (parameters != null) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 1 && objects[0] instanceof String) {
                  try {
                    GraphMLWriter.outputGraph(FunctionHelper.getGraph(context), new FileOutputStream((String) objects[0]));
                    return Boolean.TRUE;
                } catch (Exception e) {
                    throw new EvaluationException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " " + e.getMessage());
                }
            } else if (objects.length == 2 && objects[0] instanceof Graph && objects[1] instanceof String) {
                try {
                    GraphMLWriter.outputGraph((Graph) objects[0], new FileOutputStream((String) objects[1]));
                    return Boolean.TRUE;
                } catch (Exception e) {
                    throw new EvaluationException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " " + e.getMessage());
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}

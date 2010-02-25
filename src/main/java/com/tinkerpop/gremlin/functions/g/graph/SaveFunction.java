package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.parser.GraphMLWriter;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.g.GremlinFunctionLibrary;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

import java.io.FileOutputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SaveFunction implements Function {

    public static final String FUNCTION_NAME = "save";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {

        if (parameters != null) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 1 && objects[0] instanceof String) {
                try {
                    GraphMLWriter.outputGraph(FunctionHelper.getGraph(context), new FileOutputStream((String) objects[0]));
                    return Boolean.TRUE;
                } catch (Exception e) {
                    throw new EvaluationException(GremlinFunctionLibrary.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " " + e.getMessage());
                }
            } else if (objects.length == 2 && objects[0] instanceof Graph && objects[1] instanceof String) {
                try {
                    GraphMLWriter.outputGraph((Graph) objects[0], new FileOutputStream((String) objects[1]));
                    return Boolean.TRUE;
                } catch (Exception e) {
                    throw new EvaluationException(GremlinFunctionLibrary.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " " + e.getMessage());
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctionLibrary.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    public String getName() {
        return FUNCTION_NAME;
    }
}

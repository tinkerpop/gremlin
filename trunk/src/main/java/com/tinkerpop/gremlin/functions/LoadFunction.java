package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.parser.GraphMLReader;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.io.FileInputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class LoadFunction implements Function {

    public static final String FUNCTION_NAME = "load";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (parameters != null) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 1) {
                if(objects[0] instanceof String) {
                    String name = (String)objects[0];
                    if(name.equals("tinkerpop")) {
                        // TODO: is this worth it?
                    } else if(name.equals("gratefuldead")) {
                        // TODO: is this worth it?
                    }
                }
            } else if (objects.length == 2) {
                if (objects[0] instanceof Graph && objects[1] instanceof String) {
                    try {
                        GraphMLReader.inputGraph((Graph) objects[0], new FileInputStream((String) objects[1]));
                        return Boolean.TRUE;
                    } catch (Exception e) {
                        throw new EvaluationException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " " + e.getMessage());
                    }
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}

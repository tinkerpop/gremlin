package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.g.GremlinFunctions;
import com.tinkerpop.gremlin.models.pgm.Edge;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TypeFunction implements Function {
    public static final String FUNCTION_NAME = "type";

    private static final String LIST = "list";
    private static final String EDGE = "edge";
    private static final String VERTEX = "vertex";
    private static final String GRAPH = "graph";
    private static final String MAP = "map";
    private static final String NUMBER = "number";
    private static final String STRING = "string";
    private static final String BOOLEAN = "boolean";


    public String invoke(final ExpressionContext context, final Object[] parameters) {
        if (null != parameters && parameters.length == 1) {

            Object object = FunctionHelper.nodeSetConversion(parameters[0]);

            if (object instanceof List)
                return LIST;
            else if (object instanceof Edge)
                return EDGE;
            else if (object instanceof Vertex)
                return VERTEX;
            else if (object instanceof Graph)
                return GRAPH;
            else if (object instanceof Map)
                return MAP;
            else if (object instanceof Number)
                return NUMBER;
            else if (object instanceof String)
                return STRING;
            else if (object instanceof Boolean)
                return BOOLEAN;
            else
                return object.getClass().getSimpleName().toLowerCase(); // handles others (should not occur).
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

        public String getName() {
        return FUNCTION_NAME;
    }

}

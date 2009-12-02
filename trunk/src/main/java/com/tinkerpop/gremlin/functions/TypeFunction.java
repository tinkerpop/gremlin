package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TypeFunction implements Function {
    public static final String FUNCTION_NAME = "type";

    private static final String SET = "set";
    private static final String LIST = "list";
    private static final String EDGE = "edge";
    private static final String VERTEX = "vertex";
    private static final String GRAPH = "graph";
    private static final String MAP = "map";
    private static final String NUMBER = "number";
    private static final String STRING = "string";
    private static final String BOOLEAN = "boolean";


    public String invoke(ExpressionContext context, Object[] parameters) {
        if (null != parameters && parameters.length == 1) {

            Object object = FunctionHelper.nodeSetConversion(parameters[0]);

            if (object instanceof Set)
                return SET;
            else if (object instanceof List)
                return LIST;
            else if (object instanceof Edge)
                return EDGE;
            else if (object instanceof Vertex)
                return VERTEX;
            else if (object instanceof Graph)
                return GRAPH;
            else if (object instanceof Map)
                return MAP;
            else if (object instanceof Double || object instanceof Integer)
                return NUMBER;
            else if (object instanceof String)
                return STRING;
            else if (object instanceof Boolean)
                return BOOLEAN;
            else
                return object.getClass().getSimpleName().toLowerCase(); // handles others (should not occur).
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
        
    }

}

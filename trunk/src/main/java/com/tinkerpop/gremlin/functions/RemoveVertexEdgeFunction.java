package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RemoveVertexEdgeFunction implements Function {

    public static final String FUNCTION_NAME = "remove-ve";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (parameters != null) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 2 && objects[0] instanceof Graph && objects[1] instanceof Element) {
                Graph graph = (Graph) objects[0];
                if (objects[1] instanceof Vertex)
                    graph.removeVertex((Vertex) objects[1]);
                else
                    graph.removeEdge((Edge) objects[1]);
                return Boolean.TRUE;
            } else if(objects.length == 1 && objects[0] instanceof Element) {
                Graph graph = FunctionHelper.getGraph(context);
                if (objects[0] instanceof Vertex)
                    graph.removeVertex((Vertex) objects[0]);
                else
                    graph.removeEdge((Edge) objects[0]);
                return Boolean.TRUE;
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

}

package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class KeyFunction implements Function {

    public static final String FUNCTION_NAME = "key";

    public Object invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters) {
            Graph graph = GraphFunctionHelper.getGraph(context, parameters);
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{String.class, Object.class})) {
                Iterable results = graph.getIndex().get((String) objects[0], objects[1]);
                if (null != results) {
                    List resultList = new ArrayList();
                    for (Object o : results) {
                        resultList.add(o);
                    }
                    return resultList;
                } else
                    return null;
            } else if (objects.length == 3 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, String.class, Object.class})) {
                Iterable results = ((Graph) objects[0]).getIndex().get((String) objects[1], objects[2]);

                if (null != results) {
                    List resultList = new ArrayList();
                    for (Object o : results) {
                        resultList.add(o);
                    }
                    return resultList;
                } else
                    return null;
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}

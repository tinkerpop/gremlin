package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.parser.GraphMLReader;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoadFunction implements Function {

    public static final String FUNCTION_NAME = "load";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {

        if (parameters != null) {
            Graph graph = GraphFunctionHelper.getGraph(context, parameters);
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            String fileName = null;

            if (objects.length == 1 && objects[0] instanceof String) {
                fileName = (String) objects[0];
            } else if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, String.class})) {
                fileName = (String) objects[1];
            }

            if (null != fileName) {
                try {
                    InputStream stream;
                    try {
                        stream = new URL(fileName).openStream();
                    } catch (MalformedURLException urlEx) {
                        stream = new FileInputStream(fileName);
                    }
                    GraphMLReader.inputGraph(graph, stream);
                    return Boolean.TRUE;
                } catch (Exception e) {
                    throw new EvaluationException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " " + e.getMessage());
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}

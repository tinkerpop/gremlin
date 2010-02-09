package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import org.apache.commons.jxpath.ExpressionContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GraphFunctionHelper {

    public static Graph getGraph(final ExpressionContext context, final Object[] parameters) {
        if (null != parameters && parameters.length > 0) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof Graph) {
                return (Graph) object;
            }
        }
        return FunctionHelper.getGraph(context);
    }

}

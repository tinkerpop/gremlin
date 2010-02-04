package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.models.ggm.Graph;
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

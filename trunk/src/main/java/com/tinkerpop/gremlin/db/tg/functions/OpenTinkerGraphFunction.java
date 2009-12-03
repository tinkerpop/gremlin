package com.tinkerpop.gremlin.db.tg.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.db.tg.TinkerFunctions;
import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;
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
public class OpenTinkerGraphFunction implements Function {

    public static final String FUNCTION_NAME = "open-tg";

    public Graph invoke(ExpressionContext context, Object[] parameters) {

        if (null == parameters) {
            //this returns the hardcoded graph-example-1 graph until I can implement a tinker graph serialization
            return TinkerGraphFactory.createTinkerGraph();
        } else if (parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof String) {
                try {
                    TinkerGraph graph = new TinkerGraph();
                    GraphMLReader.inputGraph(graph, new FileInputStream((String) object));
                    return graph;
                } catch (Exception e) {
                    throw new EvaluationException(TinkerFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " " + e.getMessage());
                }
            }
        }
        throw new EvaluationException(TinkerFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " does not support provided parameters.");
    }
}

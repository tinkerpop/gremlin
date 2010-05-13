package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.jung.JungGraph;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.g.GremlinFunctionLibrary;
import com.tinkerpop.gremlin.functions.g.graph.GraphFunctionHelper;
import com.tinkerpop.gremlin.statements.EvaluationException;
import edu.uci.ics.jung.algorithms.scoring.PageRank;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PageRankFunction implements Function {

    public static final String FUNCTION_NAME = "pagerank";

    /*
        alpha = 0.15
        labels = g:list()
        allow = true()
        weight_key = 'weight'
        normalize = true()
     */


    public Map invoke(final ExpressionContext context, final Object[] parameters) {


        Graph graph = GraphFunctionHelper.getGraph(context, parameters);
        if (null != graph) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            Map parameterMap;
            if (null == objects) {
                parameterMap = new HashMap();
                parameterMap.put("alpha", 0.15);
            } else if (objects.length == 1 && FunctionHelper.assertTypes(objects, new Class[]{Map.class})) {
                parameterMap = (Map) objects[0];
            } else if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, Map.class})) {
                parameterMap = (Map) objects[1];
            } else {
                throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctionLibrary.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
            }


            Double alpha = null;
            List labels = null;
            Boolean filter = null;
            String weightKey = null;
            Boolean normalize = null;

            Object temp = parameterMap.get("alpha");
            if (null != temp && temp instanceof Number)
                alpha = ((Number) temp).doubleValue();
            temp = parameterMap.get("labels");
            if (null != temp && temp instanceof List)
                labels = (List) temp;
            temp = parameterMap.get("filter");
            if (null != temp && temp instanceof Boolean)
                filter = (Boolean) temp;
            temp = parameterMap.get("weight-key");
            if (null != temp && temp instanceof String)
                weightKey = (String) temp;
            temp = parameterMap.get("normalize");
            if (null != temp && temp instanceof Boolean)
                normalize = (Boolean) temp;
            if (null == alpha)
                alpha = 0.15d;


            PageRank<Vertex, Edge> pageRank;
            Transformer<Edge, Number> transformer = JungFunctionHelper.makeTransformer(JungFunctionHelper.makeSetList(labels), filter, 0.0d, true, weightKey, normalize, false);
            if (null == transformer) {
                pageRank = new PageRank<Vertex, Edge>(new JungGraph(graph), alpha);
            } else {
                pageRank = new PageRank<Vertex, Edge>(new JungGraph(graph), transformer, alpha);
            }
            pageRank.evaluate();
            Map<Vertex, Number> scores = new HashMap<Vertex, Number>();
            for (Vertex vertex : graph.getVertices()) {
                scores.put(vertex, pageRank.getVertexScore(vertex));
            }
            return scores;

        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctionLibrary.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    public String getName() {
        return FUNCTION_NAME;
    }
}

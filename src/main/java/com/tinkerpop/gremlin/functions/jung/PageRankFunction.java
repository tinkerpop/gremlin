package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.jung.JungGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import edu.uci.ics.jung.algorithms.scoring.PageRank;
import org.apache.commons.collections15.Transformer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PageRankFunction extends AbstractFunction<Map<Vertex, Double>> {

    /*
    alpha = 0.15
    labels = g:list()
    allow = true()
    weight_key = 'weight'
    normalize = true
    */

    private static final String FUNCTION_NAME = "pagerank";

    public Atom<Map<Vertex, Double>> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        Graph graph = FunctionHelper.getGraph(arguments, 0, context);
        if (null == graph)
            throw new RuntimeException(this.createUnsupportedArgumentMessage("No graph available"));

        List<Object> objects = FunctionHelper.generateObjects(arguments);
        Map parameterMap;
        if (objects.size() == 0) {
            parameterMap = new HashMap();
            parameterMap.put(JungFunctionHelper.ALPHA, 0.15);
        } else if (objects.size() == 1) {
            parameterMap = (Map) objects.get(0);
        } else if (objects.size() == 2) {
            parameterMap = (Map) objects.get(1);
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }


        Double alpha = null;
        List labels = null;
        Boolean filter = null;
        String weightKey = null;
        Boolean normalize = null;

        Object temp = parameterMap.get(JungFunctionHelper.ALPHA);
        if (null != temp && temp instanceof Number)
            alpha = ((Number) temp).doubleValue();
        temp = parameterMap.get(JungFunctionHelper.LABELS);
        if (null != temp && temp instanceof List)
            labels = (List) temp;
        temp = parameterMap.get(JungFunctionHelper.FILTER);
        if (null != temp && temp instanceof Boolean)
            filter = (Boolean) temp;
        temp = parameterMap.get(JungFunctionHelper.WEIGHT_KEY);
        if (null != temp && temp instanceof String)
            weightKey = (String) temp;
        temp = parameterMap.get(JungFunctionHelper.NORMALIZE);
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
        Map<Vertex, Double> scores = new HashMap<Vertex, Double>();
        for (Vertex vertex : graph.getVertices()) {
            scores.put(vertex, pageRank.getVertexScore(vertex));
        }
        return new Atom<Map<Vertex, Double>>(scores);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}

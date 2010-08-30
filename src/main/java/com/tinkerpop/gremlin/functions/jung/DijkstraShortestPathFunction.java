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
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import org.apache.commons.collections15.Transformer;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DijkstraShortestPathFunction extends AbstractFunction<List<Edge>> {

    private static final String FUNCTION_NAME = "dijkstra";

    /*
    labels = g:list()
    filter = true()
    weight_key = 'weight'
    invert = true
    */

    public Atom<List<Edge>> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        Graph graph = FunctionHelper.getGraph(arguments, 0, context);
        if (null == graph)
            throw new RuntimeException(this.createUnsupportedArgumentMessage("No graph available"));

        List<Object> objects = FunctionHelper.generateObjects(arguments);
        Vertex sourceVertex;
        Vertex targetVertex;
        Map parameterMap;
        if (objects.size() == 2) {
            sourceVertex = (Vertex) objects.get(0);
            targetVertex = (Vertex) objects.get(1);
            parameterMap = null;
        } else if (objects.size() == 3) {
            if (objects.get(0) instanceof Graph) {
                sourceVertex = (Vertex) objects.get(1);
                targetVertex = (Vertex) objects.get(2);
                parameterMap = null;
            } else {
                sourceVertex = (Vertex) objects.get(0);
                targetVertex = (Vertex) objects.get(1);
                parameterMap = (Map) objects.get(2);
            }
        } else if (objects.size() == 4) {
            sourceVertex = (Vertex) objects.get(1);
            targetVertex = (Vertex) objects.get(2);
            parameterMap = (Map) objects.get(3);
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

        List labels = null;
        Boolean filter = null;
        String weightKey = null;
        Boolean invert = null;

        if (parameterMap != null) {
            Object temp = parameterMap.get(JungFunctionHelper.LABELS);
            if (null != temp && temp instanceof List)
                labels = (List) temp;
            temp = parameterMap.get(JungFunctionHelper.FILTER);
            if (null != temp && temp instanceof Boolean)
                filter = (Boolean) temp;
            temp = parameterMap.get(JungFunctionHelper.WEIGHT_KEY);
            if (null != temp && temp instanceof String)
                weightKey = (String) temp;
            temp = parameterMap.get(JungFunctionHelper.INVERT);
            if (null != temp && temp instanceof Boolean)
                invert = (Boolean) temp;
        }


        DijkstraShortestPath<Vertex, Edge> dsp;
        Transformer<Edge, Number> transformer = JungFunctionHelper.makeTransformer(JungFunctionHelper.makeSetList(labels), filter, Double.MAX_VALUE, false, weightKey, null, invert);
        if (null == transformer) {
            dsp = new DijkstraShortestPath<Vertex, Edge>(new JungGraph(graph), true);
        } else {
            dsp = new DijkstraShortestPath<Vertex, Edge>(new JungGraph(graph), transformer, true);

        }
        return new Atom<List<Edge>>(dsp.getPath(sourceVertex, targetVertex));

    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}

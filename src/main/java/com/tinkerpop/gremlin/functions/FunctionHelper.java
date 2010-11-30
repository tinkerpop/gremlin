package com.tinkerpop.gremlin.functions;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.IndexableGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;

import javax.script.ScriptContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Pavel A. Yaskevich
 */
public class FunctionHelper {

    public static Graph getGlobalGraph(final GremlinScriptContext context) {
        return new Atom<Graph>((Graph) context.getBindings(ScriptContext.ENGINE_SCOPE).get(Tokens.GRAPH_VARIABLE)).getValue();
    }

    public static Graph getGraph(final List<Operation> parameters, int index, final GremlinScriptContext context) {
        if (parameters.size() > index) {
            final Operation parameter = parameters.get(index);
            final Atom atom = parameter.compute();
            if (atom.isGraph())
                return (Graph) atom.getValue();
        }

        Object object = context.getBindings(ScriptContext.ENGINE_SCOPE).get(Tokens.GRAPH_VARIABLE);
        if (object instanceof Graph)
            return (Graph) object;
        else
            throw new RuntimeException("No graph referenced by $_g");


    }

    public static IndexableGraph getIndexableGraph(final List<Operation> parameters, int index, final GremlinScriptContext context) {
        try {
            return (IndexableGraph) FunctionHelper.getGraph(parameters, index, context);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static void fillCollection(Iterable itty, Collection collection) {
        for (final Object object : itty) {
            collection.add(object);
        }
    }

    public static List<Edge> filterEdgeLabels(Iterable<Edge> edges, Set<String> labels, boolean filter) {
        List<Edge> returnEdges = new ArrayList<Edge>();
        for (Edge edge : edges) {
            if (labels.contains(edge.getLabel())) {
                if (!filter) {
                    returnEdges.add(edge);
                }
            } else {
                if (filter) {
                    returnEdges.add(edge);
                }
            }
        }
        return returnEdges;
    }

    public static Double totalWeight(Iterable<Edge> edges, String weightKey) {
        double total = 0.0d;
        for (Edge edge : edges) {
            Object weight = edge.getProperty(weightKey);
            if (null != weight && weight instanceof Number) {
                total = total + ((Number) weight).doubleValue();
            }
        }
        return total;
    }

    public static List<Object> generateObjects(List<Operation> operations) {
        final List<Object> list = new ArrayList<Object>();
        for (Operation operation : operations) {
            list.add(operation.compute().getValue());
        }
        return list;
    }

    public static void copyElementProperties(Element from, Element to) {
        for (String key : from.getPropertyKeys()) {
            to.setProperty(key, from.getProperty(key));
        }
    }
}

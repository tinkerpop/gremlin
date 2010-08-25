package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Pavel A. Yaskevich
 */
public class FunctionHelper {

    public static Graph getGraph(final Operation parameter, final GremlinScriptContext context) {
        final Atom<Graph> graphGlobalVariable = context.getVariableByName(Tokens.GRAPH_VARIABLE);
        if (parameter == null)
            return graphGlobalVariable.getValue();

        final Atom paramAtom = parameter.compute();
        return (paramAtom.isGraph()) ? (Graph) paramAtom.getValue() : graphGlobalVariable.getValue();
    }

    public static Graph getGraph(final List<Operation> parameters, int index, final GremlinScriptContext context) {
        if (parameters.size() > index) {
            final Operation parameter = parameters.get(index);
            final Atom atom = parameter.compute();
            if (atom.isGraph())
                return (Graph) atom.getValue();
        }

        Object object = context.getVariableByName(Tokens.GRAPH_VARIABLE).getValue();
        if (object instanceof Graph)
            return (Graph) object;
        else
            throw new RuntimeException("No graph referenced by $_g");


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
}

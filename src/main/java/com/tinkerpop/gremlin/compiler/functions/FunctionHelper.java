package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.Collection;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class FunctionHelper {

    public static Graph getGraph(final Operation parameter) {
        final Atom<Graph> graphGlobalVariable = GremlinEvaluator.getVariable(Tokens.GRAPH_VARIABLE);
        if (parameter == null)
            return graphGlobalVariable.getValue();

        final Atom paramAtom = parameter.compute();
        return (paramAtom.isGraph()) ? (Graph) paramAtom.getValue() : graphGlobalVariable.getValue();
    }

    public static Graph getGraph(final List<Operation> parameters, int index) {
        if (parameters.size() > index) {
            final Operation parameter = parameters.get(index);
            final Atom atom = parameter.compute();
            if (atom.isGraph())
                return (Graph) atom.getValue();
        }
        return (Graph) GremlinEvaluator.getVariable(Tokens.GRAPH_VARIABLE).getValue();
    }

    public static void fillCollection(Iterable itty, Collection collection) {
        for (final Object object : itty) {
            collection.add(object);
        }
    }
}

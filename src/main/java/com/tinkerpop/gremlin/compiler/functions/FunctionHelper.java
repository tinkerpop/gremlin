package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.Collection;
import java.util.List;

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
        return (Graph) context.getVariableByName(Tokens.GRAPH_VARIABLE).getValue();
    }

    public static void fillCollection(Iterable itty, Collection collection) {
        for (final Object object : itty) {
            collection.add(object);
        }
    }
}

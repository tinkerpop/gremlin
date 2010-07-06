package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class GraphFunctionHelper {

    public static Graph getGraph(final Operation parameter) {
        Atom graphGlobalVariable = GremlinEvaluator.getVariable(Tokens.GRAPH);
        if (parameter == null)
            return (Graph) graphGlobalVariable.getValue();

        Atom paramAtom = parameter.compute();
        return (paramAtom.isGraph()) ? (Graph) paramAtom.getValue() : (Graph) graphGlobalVariable.getValue();
    }

}

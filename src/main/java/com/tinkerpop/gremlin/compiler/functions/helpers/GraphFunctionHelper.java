package com.tinkerpop.gremlin.compiler.functions.helpers;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.operations.Operation;

/**
 * @author Pavel A. Yaskevich
 */
public class GraphFunctionHelper {

    public static Graph getGraph(final Operation param) {
        Atom graphGlobalVariable = GremlinEvaluator.getVariable(Tokens.GRAPH);

        if (param == null)
            return (Graph) graphGlobalVariable.getValue();

        Atom paramAtom = param.compute();
        return (paramAtom.isGraph()) ? (Graph) paramAtom.getValue() : (Graph) graphGlobalVariable.getValue();
    }

}

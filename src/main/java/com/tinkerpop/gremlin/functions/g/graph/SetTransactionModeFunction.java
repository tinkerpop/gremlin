package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.TransactionalGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SetTransactionModeFunction extends AbstractFunction<Object> {

    private final String FUNCTION_NAME = "set-tx-mode";

    public Atom<Object> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final Graph graph = FunctionHelper.getGraph(arguments, 0, context);
        if (graph instanceof TransactionalGraph) {
            if (arguments.size() == 1) {
                String modeString = (String) arguments.get(0).compute().getValue();
                if (modeString.equals("automatic"))
                    ((TransactionalGraph) graph).setTransactionMode(TransactionalGraph.Mode.AUTOMATIC);
                else if (modeString.equals("manual"))
                    ((TransactionalGraph) graph).setTransactionMode(TransactionalGraph.Mode.MANUAL);
                else
                    throw new RuntimeException(createUnsupportedArgumentMessage("Provide mode must be either automatic or manual"));


            } else if (arguments.size() == 2) {
                String modeString = (String) arguments.get(1).compute().getValue();
                if (modeString.equals("automatic"))
                    ((TransactionalGraph) graph).setTransactionMode(TransactionalGraph.Mode.AUTOMATIC);
                else if (modeString.equals("manual"))
                    ((TransactionalGraph) graph).setTransactionMode(TransactionalGraph.Mode.MANUAL);
                else
                    throw new RuntimeException(createUnsupportedArgumentMessage("Provide mode must be either automatic or manual"));
            } else {
                throw new RuntimeException(createUnsupportedArgumentMessage());
            }

        } else {
            throw new RuntimeException("Graph does not support transactions");
        }

        return new Atom<Object>(null);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}

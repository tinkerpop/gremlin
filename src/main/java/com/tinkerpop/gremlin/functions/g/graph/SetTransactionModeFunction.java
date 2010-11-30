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
    private static final String AUTOMATIC = "automatic";
    private static final String MANUAL = "manual";

    public Atom<Object> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final int size = arguments.size();

        final Graph graph;
        List<Object> objects = FunctionHelper.generateObjects(arguments);
        if (size > 0 && objects.get(0) instanceof Graph)
            graph = (Graph) objects.get(0);
        else
            graph = FunctionHelper.getGlobalGraph(context);

        if (graph instanceof TransactionalGraph) {
            if (size == 1) {
                String modeString = (String) objects.get(0);
                if (modeString.equals(AUTOMATIC))
                    ((TransactionalGraph) graph).setTransactionMode(TransactionalGraph.Mode.AUTOMATIC);
                else if (modeString.equals(MANUAL))
                    ((TransactionalGraph) graph).setTransactionMode(TransactionalGraph.Mode.MANUAL);
                else
                    throw new RuntimeException(createUnsupportedArgumentMessage("Provided mode must be either automatic or manual"));


            } else if (size == 2) {
                String modeString = (String) objects.get(1);
                if (modeString.equals(AUTOMATIC))
                    ((TransactionalGraph) graph).setTransactionMode(TransactionalGraph.Mode.AUTOMATIC);
                else if (modeString.equals(MANUAL))
                    ((TransactionalGraph) graph).setTransactionMode(TransactionalGraph.Mode.MANUAL);
                else
                    throw new RuntimeException(createUnsupportedArgumentMessage("Provided mode must be either automatic or manual"));
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

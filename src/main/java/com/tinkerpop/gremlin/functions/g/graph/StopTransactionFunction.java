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
public class StopTransactionFunction extends AbstractFunction<Boolean> {

    private final String FUNCTION_NAME = "stop-tx";

    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final Graph graph = FunctionHelper.getGraph(arguments, 0, context);
        if (graph instanceof TransactionalGraph) {
            if (arguments.size() == 1) {
                String conclusionString = (String) arguments.get(0).compute().getValue();
                if (conclusionString.equals("success"))
                    ((TransactionalGraph) graph).stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
                else if (conclusionString.equals("failure"))
                    ((TransactionalGraph) graph).stopTransaction(TransactionalGraph.Conclusion.FAILURE);
                else
                    throw new RuntimeException(createUnsupportedArgumentMessage("Conclusion must be either success or failure"));
            } else if (arguments.size() == 2) {
                String conclusionString = (String) arguments.get(1).compute().getValue();
                if (conclusionString.equals("success"))
                    ((TransactionalGraph) graph).stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
                else if (conclusionString.equals("failure"))
                    ((TransactionalGraph) graph).stopTransaction(TransactionalGraph.Conclusion.FAILURE);
                else
                    throw new RuntimeException(createUnsupportedArgumentMessage("Conclusion must be either success or failure"));

            } else {
                throw new RuntimeException(createUnsupportedArgumentMessage());
            }
        } else {
            throw new RuntimeException("Graph does not support transactions");
        }

        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}
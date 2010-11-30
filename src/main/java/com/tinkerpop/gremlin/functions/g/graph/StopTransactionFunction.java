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
public class StopTransactionFunction extends AbstractFunction<Object> {

    private final String FUNCTION_NAME = "stop-tx";
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    public Atom<Object> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final int size = arguments.size();

        final Graph graph;
        List<Object> objects = FunctionHelper.generateObjects(arguments);
        if (objects.get(0) instanceof Graph)
            graph = (Graph) objects.get(0);
        else
            graph = FunctionHelper.getGlobalGraph(context);

        if (graph instanceof TransactionalGraph) {
            if (size == 1) {
                String conclusionString = (String) objects.get(0);
                if (conclusionString.equals(SUCCESS))
                    ((TransactionalGraph) graph).stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
                else if (conclusionString.equals(FAILURE))
                    ((TransactionalGraph) graph).stopTransaction(TransactionalGraph.Conclusion.FAILURE);
                else
                    throw new RuntimeException(createUnsupportedArgumentMessage("Conclusion must be either success or failure"));
            } else if (size == 2) {
                String conclusionString = (String) objects.get(1);
                if (conclusionString.equals(SUCCESS))
                    ((TransactionalGraph) graph).stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
                else if (conclusionString.equals(FAILURE))
                    ((TransactionalGraph) graph).stopTransaction(TransactionalGraph.Conclusion.FAILURE);
                else
                    throw new RuntimeException(createUnsupportedArgumentMessage("Conclusion must be either success or failure"));

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
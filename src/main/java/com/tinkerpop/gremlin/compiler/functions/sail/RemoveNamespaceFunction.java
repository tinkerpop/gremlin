package com.tinkerpop.gremlin.compiler.functions.sail;

import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RemoveNamespaceFunction extends AbstractFunction<Boolean> {

    private final String FUNCTION_NAME = "remove-ns";

    public Atom<Boolean> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {

        final int size = parameters.size();
        final SailGraph graph = (SailGraph) FunctionHelper.getGraph(parameters, 0, context);

        final String namespace;

        if (size == 1) {
            namespace = (String) parameters.get(0).compute().getValue();
        } else if (size == 2) {
            namespace = (String) parameters.get(1).compute().getValue();
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
        graph.removeNamespace(namespace);
        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}
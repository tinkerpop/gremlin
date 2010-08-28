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
public class AddNamespaceFunction extends AbstractFunction<Object> {

    private final String FUNCTION_NAME = "add-ns";

    public Atom<Object> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final int size = arguments.size();
        final SailGraph graph = (SailGraph) FunctionHelper.getGraph(arguments, 0, context);

        final String prefix;
        final String namespace;

        if (size == 2) {
            prefix = (String) arguments.get(0).compute().getValue();
            namespace = (String) arguments.get(1).compute().getValue();
        } else if (size == 3) {
            prefix = (String) arguments.get(1).compute().getValue();
            namespace = (String) arguments.get(2).compute().getValue();
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
        graph.addNamespace(prefix, namespace);
        return new Atom<Object>(null);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}

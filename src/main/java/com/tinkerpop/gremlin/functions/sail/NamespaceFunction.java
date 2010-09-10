package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NamespaceFunction extends AbstractFunction<String> {

    private final String FUNCTION_NAME = "ns";

    public Atom<String> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final int size = arguments.size();
        final SailGraph graph = (SailGraph) FunctionHelper.getGraph(arguments, 0, context);

        final String prefixURI;

        if (size == 1) {
            prefixURI = (String) arguments.get(0).compute().getValue();
        } else if (size == 2) {
            prefixURI = (String) arguments.get(1).compute().getValue();
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

        return new Atom<String>(graph.expandPrefix(prefixURI));
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}

package com.tinkerpop.gremlin.compiler.functions.sail;

import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GetNamespacesFunction extends AbstractFunction<Map<String, String>> {

    private final String FUNCTION_NAME = "get-ns";

    public Atom<Map<String, String>> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {

        if (parameters.size() > 1) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

        return new Atom<Map<String, String>>(((SailGraph) FunctionHelper.getGraph(parameters, 0, context)).getNamespaces());
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}
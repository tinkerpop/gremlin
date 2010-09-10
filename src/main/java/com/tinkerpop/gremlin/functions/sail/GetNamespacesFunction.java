package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GetNamespacesFunction extends AbstractFunction<Map<String, String>> {

    private final String FUNCTION_NAME = "get-ns";

    public Atom<Map<String, String>> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() > 1) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

        return new Atom<Map<String, String>>(((SailGraph) FunctionHelper.getGraph(arguments, 0, context)).getNamespaces());
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}
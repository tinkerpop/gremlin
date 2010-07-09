package com.tinkerpop.gremlin.compiler.functions.sail;

import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GetNamespacesFunction extends AbstractFunction<Map<Atom<String>, Atom<String>>> {

    private final String FUNCTION_NAME = "get-ns";

    public Atom<Map<Atom<String>, Atom<String>>> compute(List<Operation> parameters) throws RuntimeException {

        if (parameters.size() > 1) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

        final SailGraph graph = (SailGraph) FunctionHelper.getGraph(parameters, 0);

        final Map<Atom<String>, Atom<String>> map = new HashMap<Atom<String>, Atom<String>>();
        for (Map.Entry<String, String> entry : graph.getNamespaces().entrySet()) {
            map.put(new Atom<String>(entry.getKey()), new Atom<String>(entry.getValue()));
        }
        return new Atom<Map<Atom<String>, Atom<String>>>(map);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}
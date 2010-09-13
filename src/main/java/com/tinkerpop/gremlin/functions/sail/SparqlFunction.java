package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.blueprints.pgm.Vertex;
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
public class SparqlFunction extends AbstractFunction<List<Map<String, Vertex>>> {

    private final String FUNCTION_NAME = "sparql";

    public Atom<List<Map<String, Vertex>>> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final int size = arguments.size();
        final SailGraph graph = (SailGraph) FunctionHelper.getGraph(arguments, 0, context);

        final String sparqlQuery;

        if (size == 1) {
            sparqlQuery = (String) arguments.get(0).compute().getValue();
        } else if (size == 2) {
            sparqlQuery = (String) arguments.get(1).compute().getValue();
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

        return new Atom<List<Map<String, Vertex>>>(graph.executeSparql(sparqlQuery));
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}

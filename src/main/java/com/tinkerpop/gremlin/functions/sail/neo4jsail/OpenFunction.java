package com.tinkerpop.gremlin.functions.sail.neo4jsail;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.sail.impls.Neo4jSailGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OpenFunction extends AbstractFunction<Graph> {

    private final String FUNCTION_NAME = "open";

    public Atom<Graph> compute(List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {
        try {
            final int size = parameters.size();
            final String directory;
            if (size == 1) {
                directory = (String) parameters.get(0).compute().getValue();
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }

            return new Atom<Graph>(new Neo4jSailGraph(directory));
        } catch (Error e) {
            throw new RuntimeException("Dependencies not available for this graph");
        }
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}

package com.tinkerpop.gremlin.functions.neo4j;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.neo4j.Neo4jGraph;
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

    public Atom<Graph> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        try {
            if (arguments.size() == 1) {
                return new Atom<Graph>(new Neo4jGraph((String) arguments.get(0).compute().getValue()));
            } else {
                throw new RuntimeException(createUnsupportedArgumentMessage());
            }
        } catch (Error e) {
            throw new RuntimeException("Dependencies not available for this graph");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}

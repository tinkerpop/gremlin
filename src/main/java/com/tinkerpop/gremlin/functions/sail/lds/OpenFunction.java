package com.tinkerpop.gremlin.functions.sail.lds;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.blueprints.pgm.impls.sail.impls.LinkedDataSailGraph;
import com.tinkerpop.blueprints.pgm.impls.sail.impls.MemoryStoreSailGraph;
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
            final int size = arguments.size();
            if (size == 0) {
                return new Atom<Graph>(new LinkedDataSailGraph(new MemoryStoreSailGraph()));
            } else if (size == 1) {
                return new Atom<Graph>(new LinkedDataSailGraph((SailGraph) arguments.get(0).compute().getValue()));
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
        } catch (Error e) {
            throw new RuntimeException("Dependencies not available for this graph");
        }
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}

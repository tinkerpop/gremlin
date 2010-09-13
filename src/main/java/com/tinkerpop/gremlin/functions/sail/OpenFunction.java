package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.sail.impls.MemoryStoreSailGraph;
import com.tinkerpop.blueprints.pgm.impls.sail.impls.NativeStoreSailGraph;
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
                return new Atom<Graph>(new MemoryStoreSailGraph());
            } else if (size == 1) {
                return new Atom<Graph>(new NativeStoreSailGraph((String) arguments.get(0).compute().getValue()));
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
        }
        catch (Error e) {
            throw new RuntimeException("Dependencies not available for this graph");
        }
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}

package com.tinkerpop.gremlin.compiler.functions.tg;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class OpenFunction extends AbstractFunction<Graph> {

    private final String FUNCTION_NAME = "open";

    public Atom<Graph> compute(final List<Operation> parameters) throws RuntimeException {

        if (parameters.size() == 0) {
            return new Atom<Graph>(new TinkerGraph());
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}

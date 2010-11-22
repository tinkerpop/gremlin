package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.pipes.PipeHelper;

import java.util.List;

/**
 * @author Marko A. Rodriguez
 */
public class CountFunction extends AbstractFunction<Long> {

    private static final String FUNCTION_NAME = "count";

    public Atom<Long> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() != 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage("A single countable argument required"));

        final Atom result = arguments.get(0).compute();
        if (result.isIterable()) {
            return new Atom<Long>(PipeHelper.counter(((Iterable) result.getValue()).iterator()));
        } else if (!result.isNull()) {
            return new Atom<Long>(1l);
        } else
            return new Atom<Long>(0l);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}

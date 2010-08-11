package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.pipes.PipeHelper;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class CountFunction extends AbstractFunction<Long> {

    private static final String FUNCTION_NAME = "count";

    public Atom<Long> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() != 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage("One countable argument required"));

        final Atom result = arguments.get(0).compute();
        if (result.isIterable()) {
            return new Atom<Long>(PipeHelper.counter(((Iterable<?>) result.getValue()).iterator()));
        } else
            return new Atom<Long>(1l);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}

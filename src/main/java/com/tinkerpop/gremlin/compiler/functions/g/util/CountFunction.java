package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.pipes.PipeHelper;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class CountFunction implements Function {

    private final String FUNCTION_NAME = "count";

    @SuppressWarnings("unchecked")
    public Atom compute(final List<Operation> params) throws RuntimeException {
        if (params.size() != 1)
            throw new RuntimeException(Function.UNSUPPORTED_ARGUMENTS + this.FUNCTION_NAME);

        Atom result = params.get(0).compute();
        if (result.isIterable()) {
            long count = PipeHelper.counter(((Iterable) result.getValue()).iterator());
            return new Atom(count);
        } else {
            return new Atom(1l);
        }
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}

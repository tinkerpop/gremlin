package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.pipes.PipeHelper;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class CountFunction extends AbstractFunction {


    private static final String FUNCTION_NAME = "count";


    @SuppressWarnings("unchecked")
    public Atom compute(final List<Operation> params) throws RuntimeException {
        if (params.size() != 1)
            throwUnsupportedArguments();

        Atom result = params.get(0).compute();
        if (result.isIterable()) {
            long count = PipeHelper.counter(((Iterable) result.getValue()).iterator());
            return new Atom(count);
        } else {
            return new Atom(1l);
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}

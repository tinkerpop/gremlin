package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.pipes.PipeHelper;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class CountFunction extends AbstractFunction<Double> {


    private static final String FUNCTION_NAME = "count";

    public Atom<Double> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() != 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Atom result = parameters.get(0).compute();
        if (result.isIterable()) {
            final double count = PipeHelper.counter(((Iterable) result.getValue()).iterator());
            return new Atom<Double>(count);
        } else {
            return new Atom<Double>(1.0d);
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}

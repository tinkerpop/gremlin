package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class TimeFunction extends AbstractFunction<Double> {

    private static final String FUNCTION_NAME = "time";

    private static final double ONE_MILLION = 1000000d;

    public Atom<Double> compute(final List<Operation> parameters) throws RuntimeException {
        final int size = parameters.size();
        if (size == 0) {
            return new Atom<Double>(System.nanoTime() / ONE_MILLION);
        } else if (size == 1) {
            final Number time = (Number) parameters.get(0).compute().getValue();
            return new Atom<Double>((System.nanoTime() / ONE_MILLION) - time.doubleValue());
        }

        throw new RuntimeException(this.createUnsupportedArgumentMessage());
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}
